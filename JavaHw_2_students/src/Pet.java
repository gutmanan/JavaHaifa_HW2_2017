import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * This class is used for creating specific pets
 */

/**
 * @author Java spring 2017
 */
public class Pet {
	//TODO Determine the access level of the class members.
	// Replace all **** with public, private or protected
	/**
	 * Pet name
	 */
	**** String name;
	/**
	 * Pet animal
	 * A pet cannot change it's animal type
	 */
	**** final Animal animal;
	/**
	 * The animal's date of birth
	 */
	**** final Calendar birthday;
	/**
	 * The pet's colors
	 */
	**** ArrayList<Color> colors;
	/**
	 * Pet description
	 */
	**** String description;
	/**
	 * Pet price
	 * Must have a positive value
	 */
	**** double price;
	/**
	 * The pet's owner
	 * Null owner means the animal is in the shop
	 */
	**** Customer owner;
	/**
	 * Full constructor
	 * @param name Pet name
	 * @param animal Pet animal
	 * @param birthday Pet birthday
	 * @param description Pet text description
	 * @param price Pet price
	 */
	**** Pet(String name, Animal animal, Calendar birthday, String description, double price) {
		//TODO Complete this method
	}
	/**
	 * Partial constructor
	 * @param name PEt name
	 * @param animal Pet animal
	 */
	**** Pet(String name, Animal animal) {
		//TODO Complete this method
	}
	/**
	 * @return Pet owner
	 */
	public Customer getOwner() {
		return owner;
	}
	/**
	 * Pet can only move from the shop to an owner or from an owner to the shop
	 * A pet cannot change from one owner to another.
	 * @param owner Customer to set as the owner
	 */
	**** void setOwner(Customer owner) {
		//TODO Complete this method
	}
	/**
	 * @return Pet price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price The pet's price
	 */
	public void setPrice(double price) {
		if (price > 0)
			this.price = price;
	}
	/**
	 * Age in years is always round down
	 * @return age in years
	 */
	**** int getAge() {
		//TODO Complete this method
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pet [name=" + name + ", animal=" + animal + ", age="
				+ getAge() + ", price=" + price + ", owner=" + owner + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pet) {
			if (name.equals(((Pet)obj).name) && animal.equals(((Pet)obj).animal)) {
				return true;				
			}
		}
		return false;
	}
}
