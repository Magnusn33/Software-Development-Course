public enum DIRECTION {
    NORTH(0),
    SOUTH(1),
    WEST(2),
    EAST(3),
    NONE(-1);

    private int value;
    DIRECTION(int i){
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
