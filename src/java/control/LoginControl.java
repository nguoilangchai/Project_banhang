
package control;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userName = request.getParameter("user");
        String passWord = request.getParameter("pass");
        String r = request.getParameter("rem");
        DAO dao = new DAO();
        Account a = dao.getAccount(userName, passWord);
        if(a==null)
        {
            request.setAttribute("mess", "wrong username or password");  
            request.setAttribute("tempUser", userName);
            request.setAttribute("tempPass", passWord);
            
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        //a != null        
        else
        {
            HttpSession session = request.getSession();//gọi session
            session.setAttribute("acc", a);
            session.setMaxInactiveInterval(5000);
            
//            Cookie cu = new Cookie("user", userName);
//            Cookie cp = new Cookie("pass", passWord);
//            Cookie cr = new Cookie("rem", r);
//            
//            //tao thoi gian song
//            if(r==null){
//                cu.setMaxAge(0);
//                cp.setMaxAge(0);
//                cr.setMaxAge(0);
//            }else{
//                cu.setMaxAge(24*60*60);
//                cp.setMaxAge(24*60*60);
//                cr.setMaxAge(24*60*60);
//            }
//            response.addCookie(cu);
//            response.addCookie(cp);
//            response.addCookie(cr);
            
            request.getRequestDispatcher("home").forward(request, response);
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
