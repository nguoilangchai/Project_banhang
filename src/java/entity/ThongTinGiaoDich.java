package entity;

public class ThongTinGiaoDich {
    private String ngay;
    private int userID;
    private String fullName;
    private int idSanPham;
    private String nameProduct;
    private int soLuong;
    private double price;
    private double money;

    public ThongTinGiaoDich(String ngay, int userID, String fullName, int idSanPham, String nameProduct, int soLuong, double price, double money) {
        this.ngay = ngay;
        this.userID = userID;
        this.fullName = fullName;
        this.idSanPham = idSanPham;
        this.nameProduct = nameProduct;
        this.soLuong = soLuong;
        this.price = price;
        this.money = money;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "ThongTinGiaoDich{" + "ngay=" + ngay + ", userID=" + userID + ", fullName=" + fullName + ", idSanPham=" + idSanPham + ", nameProduct=" + nameProduct + ", soLuong=" + soLuong + ", price=" + price + ", money=" + money + '}';
    }
    
    

    

        
}
