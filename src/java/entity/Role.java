
package entity;

public class Role {
    private int id;
    private String rName;

    public Role() {
    }

    public Role(int id, String rName) {
        this.id = id;
        this.rName = rName;
    }

    public int getId() { return id;}
    public void setId(int id) {this.id = id;}

    public String getrName() {return rName;}
    public void setrName(String rName) {this.rName = rName;}

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", rName=" + rName + '}';
    } 
}
