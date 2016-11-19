
package toystopinventorymanagementsystem;

/**
 *
 * @author Fahad Satti
 */
class Email implements java.io.Serializable{
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Email{" + "emailAddress=" + emailAddress + '}';
    }

}
