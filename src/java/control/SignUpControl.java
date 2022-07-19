package control;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUpControl", urlPatterns = {"/signup"})
public class SignUpControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String tempUser = request.getParameter("user");
        String tempPass = request.getParameter("pass");
        String tempRepass = request.getParameter("repass");
        
        if(!tempPass.equals(tempRepass))
        {
            request.setAttribute("mess", "Sign up Faild!!! Password and Repeat Password are not match");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        else
        {
            DAO dao = new DAO();
            Account a = dao.checkAccountExist(tempUser);
            if(a==null)
            {
                dao.insertNewAccount(tempUser, tempPass);                
                int x = dao.getIdByUserName(tempUser);
                if(x > 0)
                    dao.insertIdUser(x);
                
                request.setAttribute("mess", "Sign up successful ");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            else{
                request.setAttribute("mess", "Sign up Faild!!! User already exists ");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
