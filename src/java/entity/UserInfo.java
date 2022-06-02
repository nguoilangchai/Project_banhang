package entity;

public class UserInfo {
    private int idUser;
    private String fullName;
    private String address;
    private String mobile;
    private String image;

    public UserInfo() {
    }

    public UserInfo(int idUser, String fullName, String address, String mobile, String image) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.address = address;
        this.mobile = mobile;
        this.image = image;
    }

    public int getIdUser() {return idUser;}
    public void setIdUser(int idUser) {this.idUser = idUser;}

    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getMobile() {return mobile;}
    public void setMobile(String mobile) {this.mobile = mobile;}

    public String getImage() { return image;}  
    public void setImage(String image) {this.image = image;}

    @Override
    public String toString() {
        return "UserInfo{" + "idUser=" + idUser + ", fullName=" + fullName + ", address=" + address + ", mobile=" + mobile + ", image=" + image + '}';
    }   
}
