package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 652343
 */
public class ShoppingListServlet extends HttpServlet
  {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
      {
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
      }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
      {
        HttpSession session = request.getSession();

        //determine which action
        String action = request.getParameter("action");

        //get name from textbox
        String name = request.getParameter("usernameInput");

        //ArrayList to store items
        ArrayList<String> list;

        if (action.equals("register"))
          {
            session.setAttribute("username", name);
            request.setAttribute("user", name);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
          } else if (action.equals(""))
          {
            session.removeAttribute("username");
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
          } else if (action.equals("add"))
          {
            list = (ArrayList<String>) session.getAttribute("list");
            if (list == null)
              {
                list = new ArrayList<>();

              }
            //get item from textbox
            String item = request.getParameter("itemInput");
            list.add(item);
            session.setAttribute("list", list);
            request.setAttribute("user", name);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

          } else if (action.equals("delete"))
          {
            try
              {
                String itemToDelete = request.getParameter("radiolist");
                list = (ArrayList<String>) session.getAttribute("list");
                list.remove(list.indexOf(itemToDelete));
                request.setAttribute("user", name);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
              } catch (IndexOutOfBoundsException e)
              {
                request.setAttribute("user", name);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
              }

          }

      }

  }
