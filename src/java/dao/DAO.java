package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;
import entity.Role;
import entity.UserInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from products";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products WHERE cid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            //truyền cid vào dấu ?
            ps.setString(1, cid);
            rs = ps.executeQuery();//chạy câu lệnh query
            //lấy kết quả từ bảng rs đẩy vào object Product, 
            //sau đó đưa vào list
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }


    public Product getProductByID(String id) {
        String query = "SELECT * FROM Products WHERE id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from categories";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLast() {
        String query = "select top 1 * from products\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> getAllProductSearchByName(String tempName) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products WHERE name like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + tempName + "%");//truyền tempName vào dấu ? thứ 1
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Account getAccount(String user, String pass) 
    {
        String query = "SELECT * FROM Account WHERE userName = ? and pass = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                return new Account(rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getInt(4),
                                   rs.getInt(5)      
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Account checkAccountExist(String user) 
    {
        String query = "SELECT * FROM Account WHERE userName=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                return new Account(rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getInt(4),
                                   rs.getInt(5)      
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void insertNewAccount(String user, String pass)
    {
        String query = "INSERT INTO Account VALUES(?, ?, 0, 0)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public List<Product> getProductBySellID(String sellId) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products WHERE sell_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            //truyền sellId vào dấu ?
            ps.setString(1, sellId);
            rs = ps.executeQuery();//chạy câu lệnh query
            //lấy kết quả từ bảng rs đẩy vào object Product, 
            //sau đó đưa vào list
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    //Phương thức delete 1 sản phẩm
    public void deleteProduct(int pid)
    {
        String query = "DELETE FROM Products WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pid);

            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void addProduct(String name, String image, double price, String title, String description, int cid, int sellID)
    {
        String query = "INSERT INTO Products VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, cid);
            ps.setInt(7, sellID);
            
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void EditProduct(String name, String image, double price, String title, String description, int cid, int id)
    {
        String query = "UPDATE Products SET name=?,image=?,price=?,title=?,description=?,cid=? WHERE id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, cid);
            ps.setInt(7, id);
            
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM Account";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                /*
                int id, String user, String pass, int isSell, int isAdmin
                */
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    //Phương thức delete 1 Account
    public void deleteAccount(int pid)
    {
        String query = "DELETE FROM Account WHERE userID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pid);

            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public List<Role> getAllRoles() {
        List<Role> list = new ArrayList<>();
        String query = "SELECT * FROM Roles";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Role(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void insertAccount(String user, String pass, int aid)
    {
        String query = "";
        if(aid == 1)
            query = "INSERT INTO Account VALUES(?, ?, 1, 0)";
        if(aid == 2)
            query = "INSERT INTO Account VALUES(?, ?, 0, 1)";
        if(aid == 3)
            query = "INSERT INTO Account VALUES(?, ?, 1, 1)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public Account getAccountByID(String id) 
    {
        String query = "SELECT * FROM Account WHERE userID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                return new Account(rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getInt(4),
                                   rs.getInt(5)      
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void EditAccount(String user, String pass, int aid, int id)
    {
        String query = "";
        if(aid == 1)
            query = "UPDATE Account SET userName = ?, pass=?, isSell=1, isAdmin=0 WHERE userID = ?";
        if(aid == 2)
            query = "UPDATE Account SET userName = ?, pass=?, isSell=0, isAdmin=1 WHERE userID = ?";
        if(aid == 3)
            query = "UPDATE Account SET userName = ?, pass=?, isSell=1, isAdmin=1 WHERE userID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, id);
            
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void insertIdUser(int id)
    {
        String query = "INSERT INTO InfoUser(idUser) VALUES (?)";
           
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public int getIdByUserName(String user) 
    {
        String query = "SELECT userID FROM Account WHERE userName = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                return rs.getInt(1);     
            }
        } catch (Exception e) {
        }
        return -1;
    }
    
    public void updateInfoUser(int id, String fullName, String address, String mobile, String image)
    {
        String query = "UPDATE InfoUser SET fullName = ?, address = ?,\n" +
"mobile = ?,image = ? WHERE idUser = ?";
           
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, fullName);
            ps.setString(2, address);
            ps.setString(3, mobile);
            ps.setString(4, image);
            ps.setInt(5, id);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public UserInfo getUserInfoByID(int id) 
    {
        String query = "SELECT * FROM InfoUser WHERE idUser = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                
                return new UserInfo(rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getString(4),
                                   rs.getString(5)      
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        
//        Account a = dao.getAccount("nam", "nam1234");
//        if(a==null)
//            System.out.println("Không tồn tại");
//        else
//        System.out.println(a.toString());
        
//        List<Product> list = dao.getAllProductSearchByName("ip");
//          for (Product o : list) {
//            System.out.println(o);
//        }
 //       List<Product> list = dao.getAllProduct();
        //List<Category> listC = dao.getAllCategory();

//        for (Category o : listC) {
//            System.out.println(o);
//        }
        
//        for (Product o : list) {
//            System.out.println(o);
//        }

//        List<Product> list = dao.getProductBySellID("1");
//        for (Product o : list) {
//            System.out.println(o);
//        }
//          
//        dao.deleteProduct(7);
//        System.out.println("Sau khi xoá");
//        List<Product> list2 = dao.getProductBySellID("1");
//        for (Product o : list2) {
//            System.out.println(o);
//        }
          
//        List<Account> list = dao.getAllAccount();
//        for (Account o : list) {
//            System.out.println(o);
//        }
        
//          List<Role> list = dao.getAllRoles();
//          for (Role o : list) {
//              System.out.println(o);
//          }

//          dao.insertIdUser("12");

//            int x = dao.getIdByUserName("hai1");
//            System.out.println("x : " + x);

//            dao.updateInfoUser(13,"Nguyễn Văn Nam 2","Phú Yên","0372394603","link anh");

            String x = dao.getUserInfoByID(13).toString();
            System.out.println(x);
            
    }

}
