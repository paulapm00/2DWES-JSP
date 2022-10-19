package nombredominio.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nombredominio.models.usuario;
import nombredominio.modelsDAO.usuarioDAO;
import java.util.ArrayList;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Servlet implementation class AuthController
 */
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String action, acceso;

	usuario usuario;
	usuarioDAO usuarioDAO = new usuarioDAO();

	String email, password;

	String login = "login.jsp";
	String home = "home.jsp";
	//String edit = "usuarios/edit.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		action = request.getParameter("action");
		
		switch (action) {
		case "login":
			acceso = login;
			
			break;
			
		case "home":
			acceso = home;
			
			break;
			
		case "logout":
			request.getSession().removeAttribute("usuario");
			acceso = login;
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

		action = request.getParameter("action");

		switch (action) {
		case "login":
			/*
			 * Realizo el login de mi aplicacion
			 * */

			email = request.getParameter("email");
			password = request.getParameter("password");

			if(usuarioDAO.validate(email, getMD5(password))) {
				// Correcto, usuario existe con email y password correctos
				request.getSession().setAttribute("usuario", usuarioDAO.getusuario(email, getMD5(password)));
				ArrayList<usuario> usuarios = usuarioDAO.all();
				request.getSession().setAttribute("usuarios", usuarios);
				acceso = home;
			}else {
				acceso = login;
				// Al ser un error, puedo enviar un mensaje con setAttribute
			}
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