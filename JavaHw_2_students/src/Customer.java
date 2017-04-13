import java.util.ArrayList;
import java.util.Objects;
/**
 * Class for customers details 
 * @author Java spring 2017
 */
public class Customer {
    // TODO Determine the access level of the class members.
    // Replace all **** with public, private or protected
    /**
     * Customer name
     */
    public String name;
    /**
     * Customer phone number
     */
    private String phone;
    /**
     * The customers pets
     */
    private ArrayList<Pet> pets;
    /**
     * Full constructor
     * @param name Customer name
     * @param phone Customer phone
     */
    public Customer(String name, String phone) {
            this.name = name;
            setPhone(phone);
            this.pets = new ArrayList<Pet>();
    }
    /**
     * Partial constructor
     * @param phone Customer phone
     */
    public Customer(String phone) {
            setPhone(phone);
    }
    /**
     * @return the phone
     */
    public String getPhone() {
            return phone;
    }
    /**
     * @param phone The customer's phone number
     */
    public void setPhone(String phone) {
            this.phone = phone;
    }
    
    public ArrayList<Pet> getPets() {
    	return this.pets;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
            return "Customer [name=" + name + ", phone=" + phone + "]";
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }
}
