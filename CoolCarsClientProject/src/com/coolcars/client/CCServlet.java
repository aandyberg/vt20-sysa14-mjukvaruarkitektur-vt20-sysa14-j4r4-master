package com.coolcars.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.json.Json;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coolcars.ejb.Car;
import com.coolcars.ejb.Person;
import com.coolcars.facade.FacadeLocal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.json.*;

/**
 * Servlet implementation class CCServlet
 */
@WebServlet("/CCServlet")
public class CCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	FacadeLocal facade;
	HttpSession session;
    public CCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		boolean ajax = false;
		PrintWriter out = response.getWriter(); 
		
		String operation = request.getParameter("operation");
			
		
		if (operation.equals("ajax_cars")) {
			ajax = true;
			System.out.println("Kommer in i ajax_cars GET");
			try {
				System.out.println("kommer in i try satsen");
				List<Car> allCars = facade.findAll();
				List<Car> availableCars = new ArrayList<Car>();
				for(Car c : allCars) {
					if (c.getPersons().isEmpty()) {
						availableCars.add(c);
					}
				}
				JsonArrayBuilder array = Json.createArrayBuilder();
				for (Car c : availableCars) {
					JsonObjectBuilder o = Json.createObjectBuilder();
					o.add("brand", c.getBrand());
					o.add("licenseNbr", c.getLicenseNbr());
					o.add("price", c.getPrice());
					array.add(o);
				}
				JsonArray jsonArray = array.build();
				 response.setContentType("text/plain");
				out.print(jsonArray);

				
			} catch (Exception e) {
				
		}
		}

		if (operation.equals("logout")) {

	        session=request.getSession(false);
	        if(session != null) {
	        	session.invalidate(); 
	        	System.out.println("Session invalidated, logged out");
	        	url = "/Homepage.jsp";
	        }  
		}
		
		if (operation.equals("myprofile")) { 
			try {
				session=request.getSession(false);
		        Person user = (Person) session.getAttribute("user");
		        if(user!=null){    
		        url = "/MyProfile.jsp";
		        }  
		        else{  
		        	url = "/Login.jsp";
		        }  
			} catch (Exception e) {
				url = "/Login.jsp";
			}
	        
		}
			
			
		if(!ajax) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);		//Kolla upp exakt vad detta är 
		}	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		boolean ajax = false;
		String operation = request.getParameter("operation");
		
		if(operation.equals("registerperson")) {
			String pId = request.getParameter("textpid");
			String name = request.getParameter("textname");
			String email = request.getParameter("textemail");
			String password = request.getParameter("textpassword");
			
			Person p = new Person();
			p.setpId(pId);
			p.setName(name);
			p.setEmail(email);
			p.setPassword(password);
			
			try {
				if (facade.findByPersonPId(p.getpId()) == null) {
					facade.createPerson(p);
					url = "/RegistrationForm.jsp";
					request.setAttribute("errorMessage", "User registered");
					System.out.println("användare skapades");
				} else {
					request.setAttribute("errorMessage", "User already exists");
					url = "/RegistrationForm.jsp";
				}
				
			} catch (Exception e) {
				e.getMessage();
			}
		}

		if (operation.equals("login")) {
			String uName = request.getParameter("textusername").trim();
			String pWord = request.getParameter("textpassword");
			Person p = facade.findByPersonPId(uName);
			
			if(p != null) {
				if(p.getpId().equals(uName) && p.getPassword().equals(pWord)) {
					session=request.getSession();
					session.setAttribute("user", facade.findByPersonPId(uName));
					System.out.println("Inloggad som:" + session.getAttribute("user") + " , " + p.getName());
					url = "/MyProfile.jsp";
					
				}
				else {
					url = "/Login.jsp";
				}
			}else {
				url ="/Login.jsp";
			}
			
		}
	

		if (operation.equals("ajax_cars")) {
			try {
				List<Car> allCars = facade.findAll();
				request.setAttribute("allCars", allCars);
				url = "/Cars.jsp";
				for(Car c:allCars) {
					System.out.println(c.getBrand() + " nr: " + c.getLicenseNbr());
				}
			}
			catch (Exception e ) {
				e.getMessage();
			}
			
		}
		
		if(operation.equals("Rent")) {
			session = request.getSession(false);
			Person user = (Person) session.getAttribute("user");
			if(user!= null) {
				String licenseNbr = request.getParameter("licenseNbr");
				Car c = facade.findByLicenseNbr(licenseNbr);
				if(c.getPersons().isEmpty()) {
					Set<Car> userCars = user.getCars();
					userCars.add(c);
					user.setCars(userCars);
					session.setAttribute("user", facade.findByPersonPId(user.getpId()));
				}
				facade.updatePerson(user);
				session.setAttribute("user", facade.findByPersonPId(user.getpId()));
				session.setAttribute("errorMessage", "user_true");
				url = "/Cars.jsp";
			}else {
				System.out.println("no user");
				session.setAttribute("errorMessage", "user_false");
				url = "/Login.jsp";
			}
		}

		if(operation.equals("Cancel rent")) {
			session = request.getSession(false);
			Person user = (Person) session.getAttribute("user");
			if(user != null) {
				String licenseNbr = request.getParameter("licenseNbr");
				Car c = facade.findByLicenseNbr(licenseNbr);
				Iterator<Car> iter = user.getCars().iterator(); // Skapar en iterator, kör en while-loop och kollar ifall licenseNbr matchar 
				while (iter.hasNext()) {
				    Car car = iter.next();
				    if (car.getLicenseNbr().equals(c.getLicenseNbr())) {
				    	iter.remove();
				    	facade.updatePerson(user);
				    }
				}
				facade.updatePerson(user);
				session.setAttribute("user", facade.findByPersonPId(user.getpId()));
				System.out.println("was removed from user");
			} else {
				System.out.println("user finns inte");
			}
			url= "/MyProfile.jsp";
			
		}
		
		if(operation.equals("updateProfile")) {
			session = request.getSession(false);
			Person user = (Person) session.getAttribute("user");
			String name = request.getParameter("userName").trim();
			String email = request.getParameter("userEmail").trim();
			user.setName(name);
			user.setEmail(email);
			facade.updatePerson(user);
			session.setAttribute("user", facade.findByPersonPId(user.getpId()));
			url="/MyProfile.jsp";
		}
		
		if(!ajax) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}
