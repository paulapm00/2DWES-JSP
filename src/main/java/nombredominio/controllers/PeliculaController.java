package nombredominio.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import nombredominio.modelsDAO.peliculaDAO;
import nombredominio.models.pelicula;


/**
 * Servlet implementation class PeliculaController
 */
public class PeliculaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String acceso; // Variable que distingue entre las vistas a las que tengo que redireccionar
    String action; // Variable que recibo por URL y que me enlaza con el metodo/vista
                   // correspondiente

    pelicula pelicula;
    peliculaDAO peliculaDAO = new peliculaDAO();

    String nombre, director, genero;

    String index = "pelicula/index.jsp";
    String create = "pelicula/create.jsp";
    String edit = "pelicula/edit.jsp";

    ArrayList<pelicula> peliculas;

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
                peliculas = peliculaDAO.all();
                request.setAttribute("peli", peliculas);
                System.out.println(peliculas);
                acceso = index;
                break;

            case "create":
                acceso = create;
                break;

            case "edit":
                // Recojo el ID por URL
                id = Integer.parseInt(request.getParameter("id"));
                System.out.println(id);
                // Envio ID recogido por URL
                request.setAttribute("peli", peliculaDAO.find(id));
                acceso = edit;
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                peliculaDAO.eliminar(id);

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

                pelicula = new pelicula();
                pelicula.setNombre(nombre);
                pelicula.setDirector(director);
                pelicula.setGenero(genero);

                peliculaDAO.save(pelicula);
                acceso = index;

                break;

            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                nombre = request.getParameter("nombre");
                director = request.getParameter("director");
                genero = request.getParameter("genero");

                pelicula = new pelicula();
                pelicula.setId(id);
                pelicula.setNombre(nombre);
                pelicula.setDirector(director);
                pelicula.setGenero(genero);

                peliculaDAO.update(pelicula);

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
