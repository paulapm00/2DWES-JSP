package nombredominio.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

import nombredominio.modelsDAO.usuarioDAO;
import nombredominio.models.usuario;

/**
 * Servlet implementation class UsuariosControllers
 */
public class UsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	String acceso; // Variable que distingue entre las vistas a las que tengo que redireccionar
	String action; // Variable que recibo por URL y que me enlaza con el metodo/vista correspondiente
	
	usuario usuario;
	usuarioDAO usuarioDAO = new usuarioDAO();
	
	String nombre, email, password;
	
	String index = "usuarios/index.jsp";
	String create = "usuarios/create.jsp";
	String edit = "usuarios/edit.jsp";
	
	ArrayList<usuario> usuarios;
	
	int id;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		acceso = "";
		action =  request.getParameter("action"); // valor que recojo por url 
		
		switch (action) {
			case "index":
				usuarios = usuarioDAO.all();
				request.setAttribute("usu", usuarios);
				acceso = index;
				break;
				
			case "create":
				acceso = create;
				break;
				
			case "edit":
				// Recojo el ID por URL
				id = Integer.parseInt(request.getParameter("id"));
				
				// Envio ID recogido por URL
				request.setAttribute("usu", usuarioDAO.find(id));
				
				acceso = edit;
				break;
				
			case "delete":
				id = Integer.parseInt(request.getParameter("id"));
				usuarioDAO.eliminar(id);
				
				acceso = index;
				break;
				
			default:
				
				break;
		}
		
		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		acceso = "";
		action =  request.getParameter("action"); // valor que recojo por url 
		
		switch (action) {
			case "create":
				nombre = request.getParameter("nombre");
				email = request.getParameter("email");
				password = request.getParameter("password");
				
				usuario = new usuario();
				usuario.setNombre(nombre);
				usuario.setEmail(email);
				usuario.setPassword(getMD5(password));
				
				usuarioDAO.save(usuario);
				acceso = index;
				
				break;
			
			case "update":
				id = Integer.parseInt(request.getParameter("id"));
				nombre = request.getParameter("nombre");
				email = request.getParameter("email");
				password = request.getParameter("password");
				
				usuario = new usuario();
				usuario.setId(id);
				usuario.setNombre(nombre);
				usuario.setEmail(email);
				usuario.setPassword(getMD5(password));
				
				if(password != null && password != "") {
					usuario.setPassword(getMD5(password));
				}
				
				usuarioDAO.update(usuario);
				
				acceso = index;
				break;

	
			default:
				
				break;
		}
		
		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}
	public String getMD5 (String input) {

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte [] encBytes = md.digest(input.getBytes());

			BigInteger numero = new BigInteger(1,encBytes);

            String encString = numero.toString(16);

            while(encString.length() < 32) {

                encString = "0" + encString;

            }

            return encString;

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

}
