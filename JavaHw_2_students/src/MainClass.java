/**
 * Main class
 */

/**
 * @author Java spring 2017
 */
public class MainClass {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		SysData sd = SysData.getInstance();
		Object o;
		o = sd.addCustomer("Eric Praline", "0551234567");
		printAdd(o);
		o = sd.addCustomer("John Cleese", "037654321");
		printAdd(o);
		o = sd.addCustomer("Michal Palin", "046546545");
		printAdd(o);
		o = sd.addCustomer("Graham Chapman", "0551234567");
		printAdd(o);
		o = sd.addAnimal("Parrot", "Bird");
		printAdd(o);
		o = sd.addAnimal("Parrot", "Bird");
		printAdd(o);
		o = sd.addAnimal("Pug", "Dog");
		printAdd(o);
		o = sd.addAnimal("Siberian Husky", "Dog");
		printAdd(o);
		o = sd.addAnimal("Halibut", "Fish");
		printAdd(o);
		o = sd.addAnimal("Tyrannosaurus-Rex", "Dinosaur");
		printAdd(o);
		o = sd.addPet("Polly", "Parrot", "Bird", 12, 10, 2005, "Beautiful plumage", 100.5);
		printAdd(o);
		o = sd.addPet("Barney", "Tyrannosaurus-Rex", "Dinosaur", 1, 1, 1999, "Big and scary", 15500);
		printAdd(o);
		o = sd.addPet("Eric", "Halibut", "Fish", 7, 2, 2010, "Not too flat", 123);
		printAdd(o);
		o = sd.addPet("Eric", "Halibut", "Fish", 5, 7, 2011, "Not too flat", 123);
		printAdd(o);
		o = sd.addPet("Stan", "Goldfish", "Fish", 10, 9, 2009, "Small", 13);
		printAdd(o);
		o = sd.addPet("Rusty", "Pug", "Dog", 16, 1, 2007, "Cute and cuddly", 1921);
		printAdd(o);
		boolean flag;
		flag = sd.addColorToPet("Polly", "Parrot", "Bird", 0, 0, 255);
		printBool(1, flag);
		flag = sd.addColorToPet("Rusty", "Pug", "Dog", 0, 0, 0);
		printBool(1, flag);
		flag = sd.addColorToPet("Rusty", "Pug", "Dog", 139, 69, 19);
		printBool(1, flag);
		flag = sd.addColorToPet("Stan", "Goldfish", "Fish", 255, 165, 0);
		printBool(1, flag);
		flag = sd.addColorToPet("Eric", "Halibut", "Fish", 145, 165, 30);
		printBool(1, flag);
		flag = sd.addColorToPet("Eric", "Halibut", "Fish", 145, 165, 30);
		printBool(1, flag);
		flag = sd.sellPet("Polly", "Parrot", "Bird", "0551234567");
		printBool(2, flag);
		flag = sd.sellPet("Eric", "Halibut", "Fish", "037654321");
		printBool(2, flag);
		flag = sd.sellPet("Polly", "Parrot", "Bird", "046546545");
		printBool(2, flag);
		flag = sd.returnPet("Polly", "Parrot", "Bird");
		printBool(3, flag);
		flag = sd.returnPet("Rusty", "Pug", "Dog");
		printBool(3, flag);
		System.out.println("Cash at the end: " + sd.getCash());
	}
	/**
	 * Prints the object that was added
	 * @param obj Object to print
	 */
	public static void printAdd(Object obj) {
		if (obj == null)
			System.out.println("Nothing was added");
		else
			System.out.println("Added " + obj.toString());
	}
	/**
	 * Prints results of boolean methods
	 * @param x type of print
	 * @param flag action success or fail
	 */
	public static void printBool(int x, boolean flag) {
		switch (x) {
		case 1:
			if (flag)
				System.out.println("Color added");
			else
				System.out.println("Color wasn't added");
			break;
		case 2:
			if (flag)
				System.out.println("Pet sold");
			else
				System.out.println("Pet wasn't sold");
			break;
		case 3:
			if (flag)
				System.out.println("Pet returned");
			else
				System.out.println("Pet wasn't returned");
			break;
		}
	}
}
