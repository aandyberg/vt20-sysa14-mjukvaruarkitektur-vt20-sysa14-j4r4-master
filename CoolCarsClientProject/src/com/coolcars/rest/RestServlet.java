package com.coolcars.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coolcars.ejb.Person;
import com.coolcars.facade.FacadeLocal;

/**
 * Servlet implementation class RestServlet
 */
@WebServlet("/RestServlet/*")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	FacadeLocal facade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pathInfo = request.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			System.out.println("Alla");
			System.out.println(pathInfo);
			List<com.coolcars.ejb.Person> allPersons = facade.findAllPersons();
			sendAsJson(response, allPersons);
			return;
		}
		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			System.out.println("Alla2");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST); // statuscode 400 request by the server syntactically incorrect
			return;
		}
		String pId = splits[1];
		Person person = facade.findByPersonPId(pId);
		sendAsJson(response, person);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/")) {
			BufferedReader reader = request.getReader();
			Person p = parseJsonPerson(reader);
			
			try {
				p = facade.createPerson(p);
			} catch (Exception e) {
				System.out.println("duplicate primary key");
			}
			sendAsJson(response, p);
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String[] splits = pathInfo.split("/");
		System.out.println(splits);
		if(splits.length != 2) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		BufferedReader reader = request.getReader(); // För att kunna läsa Jsondata
		Person p = parseJsonPerson(reader);
		
		try {
			p = facade.updatePerson(p);
		} catch(Exception e) {
			System.out.println("facade update error");
		}
		sendAsJson(response, p);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String[] splits = pathInfo.split("/");
		if(splits.length != 2) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String pId = splits[1];
		Person person = facade.findByPersonPId(pId);
		if(person != null) {
			facade.deletePerson(pId);
		}
		sendAsJson(response, person);
	}
	
	private void sendAsJson(HttpServletResponse response, Person person) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		if(person != null) {
			JsonArrayBuilder array = Json.createArrayBuilder();
			JsonObjectBuilder o = Json.createObjectBuilder();
			JsonArrayBuilder carArray = Json.createArrayBuilder();
			o.add("name", person.getName());
			o.add("pid", person.getpId());
			o.add("email", person.getEmail());
			o.add("password", person.getPassword());
			if(person.getCars() != null) {
				for(com.coolcars.ejb.Car c : person.getCars()) {
					JsonObjectBuilder ob = Json.createObjectBuilder();
					ob.add("licenseNbr", c.getLicenseNbr());
					ob.add("brand", c.getBrand());
					ob.add("price", c.getPrice());
					carArray.add(ob.build());
				}
				o.add("cars", carArray.build());
			}
			array.add(o);
			JsonArray jsonArray = array.build();
			out.print(jsonArray);
		}
		out.flush();
	}
	
	private void sendAsJson(HttpServletResponse response, List<Person> persons) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		if(persons != null) {
			JsonArrayBuilder array = Json.createArrayBuilder();
			for(com.coolcars.ejb.Person p : persons) {
				JsonObjectBuilder o = Json.createObjectBuilder();
				JsonArrayBuilder carArray = Json.createArrayBuilder();
				o.add("name", p.getName());
				o.add("pid", p.getpId());
				o.add("email", p.getEmail());
				o.add("password", p.getPassword());
				//o.add("cars", p.getCars());
				if(p.getCars() != null) {
					for(com.coolcars.ejb.Car c : p.getCars()) {
						JsonObjectBuilder ob = Json.createObjectBuilder();
						ob.add("licenseNbr", c.getLicenseNbr());
						ob.add("brand", c.getBrand());
						ob.add("price", c.getPrice());
						carArray.add(ob.build());
					}
					o.add("cars", carArray.build());
				}
				array.add(o);
			}
			JsonArray jsonArray = array.build();
			out.print(jsonArray);
		}else {
			out.print("[]");
		}
		out.flush();
	}
	
	private Person parseJsonPerson(BufferedReader br) {
		JsonReader jsonReader = null;
		JsonObject jsonRoot = null;
		jsonReader = Json.createReader(br);
		jsonRoot = jsonReader.readObject();
		System.out.println("JsonRoot: " + jsonRoot);
		
		Person p = new Person();
		p.setpId(jsonRoot.getString("pid"));
		p.setName(jsonRoot.getString("name"));
		p.setEmail(jsonRoot.getString("email"));
		p.setPassword(jsonRoot.getString("password"));
		
		return p;
	}

}
