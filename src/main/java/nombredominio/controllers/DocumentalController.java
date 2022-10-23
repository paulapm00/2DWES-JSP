package nombredominio.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import nombredominio.modelsDAO.documentalDAO;
import nombredominio.models.documental;


/**
 * Servlet implementation class documentalController
 */
public class DocumentalController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String acceso; // Variable que distingue entre las vistas a las que tengo que redireccionar
    String action; // Variable que recibo por URL y que me enlaza con el metodo/vista
                   // correspondiente

    documental documental;
    documentalDAO documentalDAO = new documentalDAO();

    String nombre, director, genero;

    String index = "documental/index.jsp";
    String create = "documental/create.jsp";
    String edit = "documental/edit.jsp";

    ArrayList<documental> documentales;

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
                documentales = documentalDAO.all();
                request.setAttribute("docu", documentales);
                System.out.println(documentales);
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
                request.setAttribute("docu", documentalDAO.find(id));
                acceso = edit;
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                documentalDAO.eliminar(id);
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

                documental = new documental();
                documental.setNombre(nombre);
                documental.setDirector(director);
                documental.setGenero(genero);

                documentalDAO.save(documental);
                acceso = index;

                break;

            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                nombre = request.getParameter("nombre");
                director = request.getParameter("director");
                genero = request.getParameter("genero");

                documental = new documental();
                documental.setId(id);
                documental.setNombre(nombre);
                documental.setDirector(director);
                documental.setGenero(genero);

                documentalDAO.update(documental);

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
