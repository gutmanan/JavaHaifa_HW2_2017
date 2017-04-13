/**
 * Animal type: Parrot, Dog, Cat etc...
 */

/**
 * @author Java spring 2017
	public class Animal {
	//TODO Determine the access level of the class members.
	// Replace all **** with public, private or protected
	/**
	 * The animal's species
	 */
	public String species;
	/**
	 * The animal's category
	 * @see E_Category
	 */
	**** E_Category category;
	/**
	 * Constructor
	 * @param species Animal species
	 * @param category Animal Category
	 */
	**** Animal(String species, E_Category category) {
		//TODO Complete this method
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
		//TODO Complete this method
	}
}
