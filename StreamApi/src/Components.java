
public enum Components {
    TOMATO("Tomato"),
    CHEESE("Cheese"),
    OLIVES("Olives"),

    ONIONS("Onions"),
    CHICKEN("Chicken"),
    PINEAPPLE("Pineapple"),
    PEPPER("Pepper"),
    SAUSAGES("Sausages"),
    PROSCIUTTO("Prosciutto");
    private final String text;

    /**
     * @param text
     */
    Components(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
