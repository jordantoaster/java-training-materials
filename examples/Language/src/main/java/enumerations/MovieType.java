package enumerations;

public enum MovieType {
    SCIFI {
        public String description() {
            return "A movie set in the future";
        }
    },
    COMEDY {
        public String description() {
            return "A movie that makes you laugh";
        }
    },
    HEIST {
        public String description() {
            return "A movie based around a crime";
        }
    };

    public abstract String description();

}
