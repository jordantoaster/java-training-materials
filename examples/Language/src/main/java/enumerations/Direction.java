package enumerations;

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public void print() {
        char arrow = '?';
        switch (this) {
            case WEST:
                arrow = 0x2190;
                break;
            case EAST:
                arrow = 0x2192;
                break;
            case NORTH:
                arrow = 0x2191;
                break;
            case SOUTH:
                arrow = 0x2193;
                break;
        }
        System.out.println(arrow);
    }
}
