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
import javax.servlet.http.HttpSession;

@WebServlet(name = "LuuThanhToan", urlPatterns = {"/luuThanhToan"})
public class LuuThanhToan extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();//goi session
        Account a = (Account) session.getAttribute("acc");
        
        int id = a.getId();
        String dsIDItem = request.getParameter("danhSachIDItem");
        String dsSoLuongItem = request.getParameter("danhSachSoluongItem");
        
        String strDSItem[] = dsIDItem.split(",");
        String strDSSoLuongItem[] = dsSoLuongItem.split(",");
        
        int size = strDSItem.length;
        
        DAO dao = new DAO();
        String ngay = dao.traVeNgay();
        for (int i = 0; i < size; i++) {
            
            int idSP = Integer.parseInt(strDSItem[i]);
            int soLuong = Integer.parseInt(strDSSoLuongItem[i]);
            dao.insertNewItemGioHang(id, idSP, soLuong, ngay);           
        }
        
//        request.setAttribute("id", id);
//        request.setAttribute("dsIDItem", dsIDItem);
//        request.setAttribute("dsSoLuongItem", dsSoLuongItem);
//        
        request.getRequestDispatcher("inThongTinMuaHang.jsp").forward(request, response);
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
