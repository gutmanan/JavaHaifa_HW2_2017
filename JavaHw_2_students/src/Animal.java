
import java.util.Objects;

/**
 * Animal type: Parrot, Dog, Cat etc...
 * @author Java spring 2017
 */

public class Animal {
    // TODO Determine the access level of the class members.
    // Replace all **** with public, private or protected
    /**
     * The animal's species
     */
    private String species;
    /**
     * The animal's category
     * @see E_Category
     */
    private E_Category category;
    /**
     * Constructor
     * @param species Animal species
     * @param category Animal Category
     */
    public Animal(String species, E_Category category) {
            this.species = species;
            this.category = category;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
            return "Animal [species=" + species + ", category=" + category + "]";
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
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.species, other.species)) {
            return false;
        }
        if (this.category != other.category) {
            return false;
        }
        return true;
    }
    
}
