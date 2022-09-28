
public enum Words {
        STRING_ONE("Oksana"),
        STRING_TWO("Beer"),
        STRING_Three("Lvivarnya");



        private final String text;

        /**
         * @param text
         */
        Words(final String text) {
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