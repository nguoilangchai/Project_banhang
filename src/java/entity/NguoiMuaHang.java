package entity;

public class NguoiMuaHang {
    private int idUser;
    private int idSanPham;
    private int soLuong;

    public NguoiMuaHang() {
    }

    public NguoiMuaHang(int idUser, int idSanPham, int soLuong) {
        this.idUser = idUser;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
    }

    public int getIdUser() {return idUser;}
    public void setIdUser(int idUser) {this.idUser = idUser;}

    public int getIdSanPham() {return idSanPham;}
    public void setIdSanPham(int idSanPham) {this.idSanPham = idSanPham;}

    public int getSoLuong() {return soLuong;}
    public void setSoLuong(int soLuong) {this.soLuong = soLuong;}

    @Override
    public String toString() {
        return "NguoiMuaHang{" + "idUser=" + idUser + ", idSanPham=" + idSanPham + ", soLuong=" + soLuong + '}';
    }  
}
