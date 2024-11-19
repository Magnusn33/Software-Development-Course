/**
 * The board field class is made to holde information of all the surrounding fields, and to make the basis of other types of fields easy to create.
 * it is abstract so the child fields is forced to implement abstract funktions
 */
public abstract class BoardField {
    /**
     * in novisible mode this is printed
     */
    protected static final char hiddenC = '.';
    /**
     * the standart char to be printed when the field is shown
     */
    protected char c = '*';
    /**
     * set to true if the field (c) is shown
     */
    protected boolean isVisible = false;

    //TODO: add a user variable, that is null as standard

    protected BoardField west = null;//the field to the west or right of the current field
    protected BoardField east = null;//the field to the east or left of the current field
    protected BoardField north = null;//the field to the north or top of the current field
    protected BoardField south = null;//the field to the south or bottom of the current field

    /** sets the west/right field, NOTE that east is not set on the incomming feild, this is mainly used to set a incomming field to the feild being set
     * @param field the incomming field
     */
    public void setWest(BoardField field) {
        west = field;
    }

    /** sets the east field, and the west feild of the incomming field
     * * @param field the incomming field
     */
    public void setEast(BoardField field) {
        east = field;
        east.setWest(this);
    }

    /** sets the north/top field, NOTE that east is not set on the incomming feild, this is mainly used to set a incomming field to the feild being set
     * * @param field the incomming field
     */
    public void setNorth(BoardField field) {
        north = field;
    }

    /** sets the south field, and the north field of the incomming field
     * * @param field the incomming field
     */
    public void setSouth(BoardField field) {
        south = field;
        south.setNorth(this);
    }

    /**a funtion to tell if the object is a object for special handling */
    public abstract boolean isObject();

    /**a game function to tell if a move to this field is to subtract a life */
    public abstract boolean moveToDie();

    /** the funktion toogles visibility on or of NOTE: if the object is not to be visible at all no toggeling*/
    public abstract void toggleVisibility();

    /** prints the field to the console */
    private void printField() {
        if (isVisible) {
            System.out.print(c);
        } else {
            System.out.print(hiddenC);
        }

    }
    /**
     * start printing all fields from current field, from west to east, and north to south
     */
    public void printFields() {
        printField();
        if (east != null) {//while there is an east wee need to tell the objects to keep printing, or we wont print all, and change line
            east.printFields(DIRECTION.EAST);
        }
        System.out.println();//change line
        if (south != null) {
            south.printFields();//calls this function on the next object, a objectiv reqursive function... :-P
        }
    }

    /**
     * used to print all objets in one direction
     * @param dir the direction to print the objects
     */
    private void printFields(DIRECTION dir) {
        printField();
        switch (dir) {
            case NORTH:
                if (north != null) {
                    north.printFields(dir);
                }
                break;
            case SOUTH:
                if (south != null) {
                    south.printFields(dir);
                }
                break;
            case EAST:
                if (east != null) {
                    east.printFields(dir);
                }
                break;
            case WEST:
                if (west != null) {
                    west.printFields(dir);
                }
                break;
        }
    }

    /**
     * By way of classical coords find the object on the position, from north to south, west to east
     * @param x the horizontal possition
     * @param y the vertical possition
     * @return the feild on that pos if exists else a null object
     */
    public BoardField findFieldByCount(int x, int y) {
        if (x == 1 && y == 1) {
            return this;
        }

        if (x > 1 && this.south != null) {
            return this.south.findFieldByCount(x - 1, y);
        }

        if (y > 1 && this.east != null) {
            return this.east.findFieldByCount(x, y - 1);
        }

        return null;
    }

    /**
     * count the feilds in between the nearest object, from the current field, in a given direction
     * @param dir the direction to count
     * @return the amount of feilds, to the object or -1 of none
     */
    public int countNearestObject(DIRECTION dir) {
        if (this.isObject()) {
            return 0;//if this is a object is we return 0 as the amount, sins no other fields can be counted
        }
        switch (dir) {
            case NORTH:
                if (north != null && !north.isObject()) {//if the northern exits and is not an object, we call it's counter in the direction
                    return north.countNearestObject(dir, 1);
                }
                break;
            case SOUTH:
                if (south != null && !south.isObject()) {//if the southern exits and is not an object, we call it's counter in the direction
                    return south.countNearestObject(dir, 1);
                }
                break;
            case EAST:
                if (east != null && !east.isObject()) {//if the eastern exits and is not an object, we call it's counter in the direction
                    return east.countNearestObject(dir, 1);
                }
                break;
            case WEST:
                if (west != null && !west.isObject()) {//if the western exits and is not an object, we call it's counter in the direction
                    return west.countNearestObject(dir, 1);
                }
                break;
            case NONE://error in case that the programmer calls a none direktion 
                return -1;
        }
        return 0;//if this is not a object and the next is a object, we return 0 as the amount, sins no other fields can be counted
    }

    /**
     * used internaly count and to keep tract of counts of feilds
     * @param dir the direction to count
     * @param current the number of feilds before an object, until now.
     * @return the counted numbers (current + this one, if no more fields)
     */
    protected int countNearestObject(DIRECTION dir, int current) {
        switch (dir) {
            case NORTH:
                if (north != null) {
                    if (!north.isObject()) {
                        return north.countNearestObject(dir, current + 1);
                    }
                } else {
                    return -1;
                }
                break;
            case SOUTH:
                if (south != null) {
                    if (!south.isObject()) {
                        return south.countNearestObject(dir, current + 1);
                    }
                } else {
                    return -1;
                }
                break;
            case EAST:
                if (east != null) {
                    if (!east.isObject()) {
                        return east.countNearestObject(dir, current + 1);
                    }
                } else {
                    return -1;
                }
                break;
            case WEST:
                if (west != null) {
                    if (!west.isObject()) {
                        return west.countNearestObject(dir, current + 1);
                    }
                } else {
                    return -1;
                }
                break;
            case NONE:
                return -1;
        }

        return current + 1;
    }
}
