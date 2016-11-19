
package toystopinventorymanagementsystem;

/**
 *
 * @author Fahad Satti
 */
public class Employee implements java.io.Serializable{
    private String name;
    private int UID;
    private Email email;
    private int storeID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRandomName() {
        this.name = Util.getSaltAlphaString();
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    
    public void setEmail(String email) {
        this.email = new Email();
        this.email.setEmailAddress(email);
    }
    
    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", UID=" + UID + ", email=" + email + ", storeID=" + storeID + "}";
    }
    
    
}
