package nombredominio.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


import nombredominio.modelsDAO.serieDAO;
import nombredominio.models.serie;


/**
 * Servlet implementation class SerieController
 */
public class SerieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String acceso; // Variable que distingue entre las vistas a las que tengo que redireccionar
    String action; // Variable que recibo por URL y que me enlaza con el metodo/vista
                   // correspondiente

    serie serie;
    serieDAO serieDAO = new serieDAO();
    
    String nombre, director, genero;

    String index = "serie/index.jsp";
    String create = "serie/create.jsp";
    String edit = "serie/edit.jsp";

    ArrayList<serie> series;

    int id;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        acceso = "";
        action = request.getParameter("action"); // valor que recojo por url

        switch (action) {
            case "index":
                series = serieDAO.all();
                request.setAttribute("seri", series);
                acceso = index;
                break;

            case "create":
                acceso = create;
                break;

            case "edit":
                // Recojo el ID por URL
                id = Integer.parseInt(request.getParameter("id"));

                // Envio ID recogido por URL
                request.setAttribute("seri", serieDAO.find(id));

                acceso = edit;
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                serieDAO.eliminar(id);

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        acceso = "";
        action = request.getParameter("action"); // valor que recojo por url

        switch (action) {
            case "create":
                nombre = request.getParameter("nombre");
                director = request.getParameter("director");
                genero = request.getParameter("genero");

                serie = new serie();
                serie.setNombre(nombre);
                serie.setDirector(director);
                serie.setGenero(genero);

                serieDAO.save(serie);
                acceso = index;

                break;

            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                nombre = request.getParameter("nombre");
                director = request.getParameter("director");
                genero = request.getParameter("genero");

                serie = new serie();
                serie.setId(id);
                serie.setNombre(nombre);
                serie.setDirector(director);
                serie.setGenero(genero);

                serieDAO.update(serie);

                acceso = index;
                break;

            default:

                break;
        }
     // Lanzar la vista en funcion del action recibido
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

    }
}
