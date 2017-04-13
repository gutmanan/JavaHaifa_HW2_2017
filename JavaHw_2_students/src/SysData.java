import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * This class contains all the store's database
 */
/**
 * @author Java spring 2017
 */
public class SysData {
	/**
	 * Singleton instance
	 * The only possible instance of this class
	 */
	private static SysData instance = null;
	/**
	 * List of animals sold by the shop
	 */
	private ArrayList<Animal> animals;
	/**
	 * List of customers
	 */
	private ArrayList<Customer> customers;
	/**
	 * List of pets currently in the shop
	 */
	private ArrayList<Pet> petsInventory;
	/**
	 * List of sold pets
	 */
	private ArrayList<Pet> soldPets;
	/**
	 * Current cash
	 */
	private double cash;
	/**
	 * Empty constructor to override default constructor
	 * This prevents the user from creating an instance of this class
	 */
	private SysData() {
		animals = new ArrayList<Animal>();
		customers = new ArrayList<Customer>();
		petsInventory = new ArrayList<Pet>();
		soldPets = new ArrayList<Pet>();
		cash = 0;
	}
	/**
	 * This method retrieves the singleton instance
	 * If the instance wasn't created yet, it will create it
	 * @return Singleton instance
	 */
	public static SysData getInstance() {
		if (instance == null)
			instance = new SysData();
		return instance;
	}
	
	/**
	 * @return Current cash
	 */
	public double getCash() {
		return cash;
	}
	/**
	 * Adding the customer only if the phone number is legal and the customer doesn't exists yet
	 * @param name Customer name
	 * @param phone Customer phone
	 * @return The customer that was added, null if unsuccessful
	 */
	public Customer addCustomer(String name, String phone) {
		if (phone.length() > Constants.phoneNumberMaxLength) return null;
		if (phone.length() < Constants.phoneNumberMinLength) return null;
		Customer toAdd = new Customer(phone);
		if (customers.contains(toAdd)) return null;
		toAdd = new Customer(name, phone);
		customers.add(toAdd);
		return toAdd;
	}
	/**
	 * Adding a new animal to the shop only if it isn't being sold yet.
	 * @param species Animal species
	 * @param category Animal category
	 * @return The animal that was added, null if unsuccessful
	 */
	public Animal addAnimal(String species, String category) {
		//TODO Complete this method
	}
	/**
	 * Adding a new pet to the shop
	 * @param name Pet's name
	 * @param species Pet's species
	 * @param category Pet's category
	 * @param day Day of birth
	 * @param month Month of birth
	 * @param year Year of birth
	 * @param description Pet's text description
	 * @param price Pet's price
	 * @return The pet that was created
	 */
	public Pet addPet(String name, String species, String category, int day, int month, int year, String description, double price) {
		//TODO Complete this method
	}
	/**
	 * Add color to pet, cannot add the same color twice
	 * @param name Pet name
	 * @param species Pet species
	 * @param category Pet category
	 * @param r Red value
	 * @param g Green value
	 * @param b Blue value
	 * @return True if color was set successfully
	 */
	public boolean addColorToPet(String name, String species, String category, int r, int g, int b) {
		//TODO Complete this method
	}
	/**
	 * Selling a pet to a customer
	 * @param name Pet name
	 * @param species Pet species
	 * @param category Pet category
	 * @param phone Customer phone
	 * @return True if sale was successful
	 */
	public boolean sellPet(String name, String species, String category, String phone) {
		//TODO Complete this method
	}
	/**
	 * Returning a pet to the shop
	 * @param name Pet name
	 * @param species Pet species
	 * @param category Pet category
	 * @return True if pet returned successfully
	 */
	public boolean returnPet(String name, String species, String category) {
		//TODO Complete this method
	}
	/**
	 * Gets the requested animal from the animals list
	 * @param species
	 * @param category
	 * @return Animal from ArrayList, null if doesn't exists
	 */
	public Animal getAnimal(String species, String category) {
		//TODO Complete this method
	}
	/**
	 * Gets the requested pet
	 * @param name Pet name
	 * @param animal PEt animal
	 * @return The pet from ArrayList, null if doesn't exists
	 */
	public Pet getPet(String name, Animal animal) {
		//TODO Complete this method
	}
	/**
	 * Gets the requested customer
	 * @param phone Customer's phone
	 * @return The customer from ArrayList, null if doesn't exists
	 */
	public Customer getCustomer(String phone) {
		//TODO Complete this method
	}
}
