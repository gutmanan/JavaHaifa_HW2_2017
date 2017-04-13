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
	 * Singleton instance The only possible instance of this class
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
	 * Empty constructor to override default constructor This prevents the user
	 * from creating an instance of this class
	 */
	private SysData() {
		animals = new ArrayList<Animal>();
		customers = new ArrayList<Customer>();
		petsInventory = new ArrayList<Pet>();
		soldPets = new ArrayList<Pet>();
		cash = 0;
	}

	/**
	 * This method retrieves the singleton instance If the instance wasn't
	 * created yet, it will create it
	 * 
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
	 * Adding the customer only if the phone number is legal and the customer
	 * doesn't exists yet
	 * 
	 * @param name
	 *            Customer name
	 * @param phone
	 *            Customer phone
	 * @return The customer that was added, null if unsuccessful
	 */
	public Customer addCustomer(String name, String phone) {
		if (phone.length() > Constants.phoneNumberMaxLength)
			return null;
		if (phone.length() < Constants.phoneNumberMinLength)
			return null;
		Customer toAdd = new Customer(phone);
		if (customers.contains(toAdd))
			return null;
		toAdd = new Customer(name, phone);
		customers.add(toAdd);
		return toAdd;
	}

	/**
	 * Adding a new animal to the shop only if it isn't being sold yet.
	 * 
	 * @param species
	 *            Animal species
	 * @param category
	 *            Animal category
	 * @return The animal that was added, null if unsuccessful
	 */
	public Animal addAnimal(String species, String category) {
		if (E_Category.getCategory(category) == null)
			return null;
		if (getAnimal(species, category) != null)
			return null;
		Animal animalToAdd = new Animal(species, E_Category.getCategory(category));
		return animals.add(animalToAdd) ? animalToAdd : null;
	}

	/**
	 * Adding a new pet to the shop
	 * 
	 * @param name
	 *            Pet's name
	 * @param species
	 *            Pet's species
	 * @param category
	 *            Pet's category
	 * @param day
	 *            Day of birth
	 * @param month
	 *            Month of birth
	 * @param year
	 *            Year of birth
	 * @param description
	 *            Pet's text description
	 * @param price
	 *            Pet's price
	 * @return The pet that was created
	 */
	public Pet addPet(String name, String species, String category, int day, int month, int year, String description,
			double price) {
		Animal animal = getAnimal(species, category);
		Calendar birthday = Calendar.getInstance();
		birthday.set(year, month, day);
		Pet petToAdd = new Pet(name, animal, birthday, description, price);
		if (getPet(name, animal) != null)
			return null;
		return petsInventory.add(petToAdd) ? petToAdd : null;
	}

	/**
	 * Add color to pet, cannot add the same color twice
	 * 
	 * @param name
	 *            Pet name
	 * @param species
	 *            Pet species
	 * @param category
	 *            Pet category
	 * @param r
	 *            Red value
	 * @param g
	 *            Green value
	 * @param b
	 *            Blue value
	 * @return True if color was set successfully
	 */
	public boolean addColorToPet(String name, String species, String category, int r, int g, int b) {
		Color colorToAdd = new Color(r, g, b);

		if (getAnimal(species, category) == null) // Animal doesn't exists
			return false;

		Pet petC = getPet(name, getAnimal(species, category));

		if (petC == null)
			return false; // Pet doesn't exists

		for (Color c : petC.colors)
			if (c.equals(colorToAdd))
				return false; // the color is already exists

		return petC.colors.add(colorToAdd);
	}

	/**
	 * Selling a pet to a customer
	 * 
	 * @param name
	 *            Pet name
	 * @param species
	 *            Pet species
	 * @param category
	 *            Pet category
	 * @param phone
	 *            Customer phone
	 * @return True if sale was successful
	 */
	public boolean sellPet(String name, String species, String category, String phone) {
		if (getAnimal(species, category) == null) // Animal doesn't exists
			return false;
		Pet petC = getPet(name, getAnimal(species, category));
		if (petC == null) // Pet not in petsInventory
			return false;
		Customer cust = getCustomer(phone);
		if (cust == null) // Customer doesn't exists
			return false;

		petC.setOwner(cust);
		cust.getPets().add(petC);
		petsInventory.remove(petC);
		soldPets.add(petC);
		this.cash += petC.getPrice();
		return true;
	}

	/**
	 * Returning a pet to the shop
	 * 
	 * @param name
	 *            Pet name
	 * @param species
	 *            Pet species
	 * @param category
	 *            Pet category
	 * @return True if pet returned successfully
	 */
	public boolean returnPet(String name, String species, String category) {
		if (getAnimal(species, category) == null) // Animal doesn't exists
			return false;
		Pet pet = new Pet(name, getAnimal(species, category));
		boolean flag = true;
		for (Pet p : soldPets)
			if (p.equals(pet)) {
				pet = p;
				flag = false; // if this pet in soldPets list
			}
		if (flag) // if this pet doesn't in soldPets list
			return false;

		pet.getOwner().getPets().remove(pet);
		pet.setOwner(null);
		petsInventory.add(pet);
		soldPets.remove(pet);
		this.cash -= pet.getPrice();
		return true;
	}

	/**
	 * Gets the requested animal from the animals list
	 * 
	 * @param species
	 * @param category
	 * @return Animal from ArrayList, null if doesn't exists
	 */
	public Animal getAnimal(String species, String category) {
		if (E_Category.getCategory(category) == null)
			return null;
		Animal animal = new Animal(species, E_Category.getCategory(category));
		for (Animal an : animals)
			if (an.equals(animal))
				return an;
		return null;
	}

	/**
	 * Gets the requested pet
	 * 
	 * @param name
	 *            Pet name
	 * @param animal
	 *            PEt animal
	 * @return The pet from ArrayList, null if doesn't exists
	 */
	public Pet getPet(String name, Animal animal) {
		Pet pet = new Pet(name, animal);
		for (Pet p : petsInventory)
			if (p.equals(pet))
				return p;
		return null;
	}

	/**
	 * Gets the requested customer
	 * 
	 * @param phone
	 *            Customer's phone
	 * @return The customer from ArrayList, null if doesn't exists
	 */
	public Customer getCustomer(String phone) {
		Customer custToFind = new Customer(phone);
		for (Customer c : customers)
			if (c.equals(custToFind))
				return c;
		return null;
	}
}
