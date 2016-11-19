
package toystopinventorymanagementsystem;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Fahad Satti
 */
public class Store implements java.io.Serializable{
    public int UID;
    public String address;
    public String contactNo;
    public Email email;
    public ArrayList<Toy> toys = new ArrayList();
    public ArrayList<Employee> employees = new ArrayList();

    

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public void setToys(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    public void addRandomEmployees(ArrayList<Employee> employeeList){
        Random randEmployee = new Random();
        int index = randEmployee.nextInt(employeeList.size());
        Employee selectedEmployee = (Employee)employeeList.get(index);
        selectedEmployee.setStoreID(this.getUID());
        this.employees.add(selectedEmployee);
        
        employeeList.remove(index);
    }

    @Override
    public String toString() {
        return "Store{" + "UID=" + UID + ", address=" + address + ", contactNo=" + contactNo + ", email=" + email + ", toys=" + toys + ", employees=" + employees + "}\n";
    }

    void addToy(Toy newToy) {
        if(newToy != null)
        this.toys.add(newToy);
    }
    
}
