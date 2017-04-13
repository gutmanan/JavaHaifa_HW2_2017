import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * This class is used for creating specific pets
 * @author Java spring 2017
 */
public class Pet {
    // TODO Determine the access level of the class members.
    // Replace all **** with public, private or protected
    /**
     * Pet name
     */
    public String name;
    /**
     * Pet animal
     * A pet cannot change it's animal type
     */
    public final Animal animal;
    /**
     * The animal's date of birth
     */
    public final Calendar birthday;
    /**
     * The pet's colors
     */
    public ArrayList<Color> colors;
    /**
     * Pet description
     */
    public String description;
    /**
     * Pet price
     * Must have a positive value
     */
    private double price;
    /**
     * The pet's owner
     * Null owner means the animal is in the shop
     */
    public Customer owner;
    /**
     * Full constructor
     * @param name Pet name
     * @param animal Pet animal
     * @param birthday Pet birthday
     * @param description Pet text description
     * @param price Pet price
     */
    public Pet(String name, Animal animal, Calendar birthday, String description, double price) {
        this.name = name;
        this.animal = animal;
        this.birthday = birthday;
        this.description = description;
        this.price = price;
    }
    /**
     * Partial constructor
     * @param name PEt name
     * @param animal Pet animal
     */
    public Pet(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
        this.birthday = null;
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
    public void setOwner(Customer owner) {
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
    public int getAge() {
       long age = TimeUnit.MILLISECONDS.convert(Calendar.getInstance().getTimeInMillis() - birthday.getTimeInMillis(), TimeUnit.DAYS);
       return (int) age/365;
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
