package toystopinventorymanagementsystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Fahad Satti
 */
public class ToyStopInventoryManagementSystem implements java.io.Serializable{
    ToyStopService tsService = new ToyStopService();
    public void init(){
        
        tsService.initEmployees();
        tsService.initStores();
        tsService.initToys();
        System.out.println("Init complete");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        
        ToyStopInventoryManagementSystem tsims = new ToyStopInventoryManagementSystem();
        
        try{
            tsims = tsims.loadData();
        } catch(Exception e){
            tsims.init();
            tsims.saveData(tsims);
        }

        Scanner scanner = new Scanner(System.in);
        tsims.showMenu();
        System.out.println("Enter a valid option below:");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                tsims.printAll();
                break;
            case 2:
                Store myStore = new Store();
                myStore.setUID(Util.getSaltNum(-1));
                myStore.addRandomEmployees(tsims.tsService.employees);
                tsims.tsService.stores.add(myStore);
                System.out.println("New store added");
                break;
            case 3:
                Employee myEmployee = new Employee();
                myEmployee.setUID(Util.getSaltNum(-1));
                myEmployee.setRandomName();
                tsims.tsService.employees.add(myEmployee);
                System.out.println("New employee added");
                break;
            case 4:
                Toy newToy = new Toy();
                newToy.setUID(Util.getSaltNum(-1));
                newToy.setMinAge(Util.getSaltNum(1));
                newToy.setMaxAge(Util.getSaltNum(18));
                newToy.setPrice(Util.getSaltNum(1000));
                newToy.setName(Util.getSaltAlphaString());
                newToy.setAddedOn(LocalDateTime.now());

                Random randStore = new Random();
                int index = randStore.nextInt(tsims.tsService.stores.size());
                Store selectedStore = (Store)tsims.tsService.stores.get(index);
                selectedStore.addToy(newToy);
                System.out.println("New toy added");
                break;
            case 0:
                tsims.saveData(tsims);
                break;
            case 5:
                System.out.println("1 to search for employee\n2 to search for toy\n3 to search for store");
                choice = scanner.nextInt();
                System.out.println("Enter uid:");
                int u = scanner.nextInt();
                switch(choice){
                    case 1:
                        tsims.searchemployee(u);
                        break;
                    case 2:
                        tsims.searchtoy(u);
                        break;
                    case 3:
                        tsims.searchstore(u);
                        break;
                }
                break;
        }
        
      
        System.out.println("Enter uid to search for employee: ");
        String u = scanner.next();
        
        
    }
    
    private void saveData(ToyStopInventoryManagementSystem s) throws FileNotFoundException, IOException{
        FileOutputStream ostream = new FileOutputStream("toy.ser");
        ObjectOutputStream p = new ObjectOutputStream(ostream);
        p.writeObject(s);
        p.flush();
        ostream.close();
        p.close();
    }
    private ToyStopInventoryManagementSystem loadData() throws IOException, ClassNotFoundException {
        FileInputStream istream = new FileInputStream("toy.ser");
        ObjectInputStream p = new ObjectInputStream(istream);
        ToyStopInventoryManagementSystem s = (ToyStopInventoryManagementSystem)p.readObject();
        return s;
    }

    private void showMenu() {
        System.out.println("Welcome to Toy Stop Inventory Management System");
        System.out.println("Enter 1 to show all data");
        System.out.println("Enter 2 to add a new Store");
        System.out.println("Enter 3 to add a new Employee");
        System.out.println("Enter 4 to add a new Toy");
        System.out.println("Enter 5 to search");
        System.out.println("Enter 0 to save state");
        
    }

    private void printAll() {
        System.out.println(this.tsService.stores);
    }
    private void searchstore(int uid){
        for(Store x: this.tsService.stores){
            if(uid ==  x.getUID()){
                System.out.println("Store found");
                System.out.println("Address: " + x.getAddress());
                System.out.println("Contact No: " + x.getContactNo());
                System.out.println("Email: " + x.getEmail());
                return;
            }
        } 
    }
    
    private void searchtoy(int uid){
        for(Store x: this.tsService.stores){
            for (Toy a : x.getToys()){
                if(uid == a.getUID()){
                    System.out.println("Toy found");
                    System.out.println("Name: " + a.getName());
                    System.out.println("Price: " + a.getPrice());
                    System.out.println("Min Age: " + a.getMinAge());
                    System.out.println("Max Age: " + a.getMaxAge());
                    System.out.println("Added On: " + a.getAddedOn());
                }
            }
        }
    }
    private void searchemployee(int uid){
        for(Employee x : this.tsService.employees){
            if(uid == x.getUID()){
                System.out.println("Employee found");
                System.out.println("Name: " + x.getName());
                System.out.println("Email: " + x.getEmail());
                System.out.println("Store ID: " + x.getStoreID());
                return;
            }
        }
    }
}
