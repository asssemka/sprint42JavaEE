package narxoz.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import narxoz.db.DBConnection;
import narxoz.db.Items;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/home.html")
public class HomeServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");
    ArrayList<Items> items =DBConnection.getItems();

    request.setAttribute("items",items);
    request.getRequestDispatcher("/index.jsp").forward(request,response);




  }
}
