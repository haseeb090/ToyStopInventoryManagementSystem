package toystopinventorymanagementsystem;

import java.time.LocalDateTime;

/**
 *
 * @author Fahad Satti
 */
public class Toy implements java.io.Serializable{
    private int UID;
    private String name;
    private transient int price;
    private int minAge;
    private int maxAge;
    private LocalDateTime addedOn;

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    @Override
    public String toString() {
        return "Toy{" + "UID=" + UID + ", name=" + name + ", price=" + price + ", minAge=" + minAge + ", maxAge=" + maxAge + ", addedOn=" + addedOn + '}';
    }
    
    
}
