/**
 * Animal Category
 * @author Java spring 2017
 */
public enum E_Category {
    Bird, Fish, Rodent, Lizard, Cat, Dog, Other;
    /**
     * Get the Enum from a string. Null if doesn't exists
     * @param category String of the category
     * @return Enum of the category. null if it doesn't exists
     */
    public static E_Category getCategory(String category) {
        try {
            return E_Category.valueOf(category);
        }
        catch (Exception e) {
            return null;
        }
    }
}
