import java.util.ArrayList;
/**
 * Class for customers details 
 */

/**
 * @author Java spring 2017
 */
public class Customer {
	//TODO Determine the access level of the class members.
	// Replace all **** with public, private or protected
	/**
	 * Customer name
	 */
	**** String name;
	/**
	 * Customer phone number
	 */
	**** String phone;
	/**
	 * The customers pets
	 */
	**** ArrayList<Pet> pets;
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
	**** void setPhone(String phone) {
		//TODO Complete this method
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
	**** boolean equals(Object obj) {
		//TODO Complete this method
	}
}
