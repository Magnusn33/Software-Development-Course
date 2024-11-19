import java.util.Random; /**
 * Board is a class to handle main initialization of the grid, and handling if it.
 * The struktur is ment to prepare for a game, with a player.
 */
public class Board {
    /** the width of the grid */
    int width = 9;
    /** the heigth of the grid */
    int heigth = 9;
    /** the first feild
     * NOTE: that the grid is a top down coordinat system,
     * Meaning that the positive numbering of feilds are going up as the grid goes down.
     */
    BoardField start;

    /**
     * default constructor
     */
    public Board() {
        init();
    }

    /**
     * a construtor that adds a dynamic element to the grid
     * @param width the width of the grid
     * @param heigth the heigth of the grid
     */
    public Board(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        init();
    }

    /**
     * a class internal function to initialize the grid 
     */
    private void init() {
        /* we need a stating point of the grid */
        start = new FieldStandard();
        /* x y coords to handle random, and for loop initialization for feilds.. why wast memory */
        int x = 0, y = 0;

        /* We create a multi dimentional array to gaing a better random of positions, for wall fields */
        //
        //Test array
        // boolean[][] specialPos = {
        //     { false, false, false, false, true, false, false, false, false },
        //     { false, false, false, false, true, false, false, false, false },
        //     { false, false, false, false, false, false, false, false, false },
        //     { false, false, false, false, false, false, false, false, false },
        //     { false, false, true, false, false/*Mid*/, false, false, true, false },
        //     { false, false, false, false, false, false, false, false, false },
        //     { false, false, false, false, false, false, false, false, false },
        //     { false, false, false, false, true, false, false, false, false },
        //     { false, false, false, false, false, false, false, false, false }
        //   };

        boolean[][] specialPos = {
                { false, false, false, false, false, false, false, false, false },
                { false, false, false, false, false, false, false, false, false },
                { false, false, false, false, false, false, false, false, false },
                { false, false, false, false, false, false, false, false, false },
                { false, false, false, false, false/*Mid*/, false, false, false, false },
                { false, false, false, false, false, false, false, false, false },
                { false, false, false, false, false, false, false, false, false },
                { false, false, false, false, false, false, false, false, false },
                { false, false, false, false, false, false, false, false, false }
        };

        /* we know why */
        Random rand = new Random();

        /* we create the random positions (Could be made dynamic to, by replacing 10) */
        for (int i = 0; i < 10; i++) {
            while (true) {//keep generating x y coords if the coord is allready true, so that we always get 10
                x = rand.nextInt(1, width);
                y = rand.nextInt(1, heigth);

                if (!specialPos[x][y]) {
                    specialPos[x][y] = true;
                    break;
                }
            }
        }


        start.toggleVisibility();//in this case we want the field to be visible, in the game we only those who are en the line of sigth - TODO: remove in the game
        BoardField lastField = start;//last feild is to hold the previuos, so that the new field can be associated with it.
        BoardField firstInRow = start;//when we are done with a row we need to add the next start row to the south of it
        BoardField newField;//a place holder for the new field, so that we dont keep creating a new variable in memory

        for (y = 0; y < heigth; y++) {//stating with the rows is easyer to think the process, sins we start from the top
            for (x = 1; x < width; x++) {//for each heigth we create the appropriate amount of fields in the row, from west to east
                if (specialPos[y][x]) {//checks if we need to create a special field(wall field)
                    newField = new FieldWall();
                } else {
                    newField = new FieldStandard();
                }
                lastField.setEast(newField);//the last field needs to know the its eastern feild
                if(lastField.north != null && lastField.north.east != null){//if the row is below annother we also need to let the top row know of who is placed south of it.
                    lastField.north.east.setSouth(newField);
                }
                lastField = newField;//set the new field to the next last field
                newField.toggleVisibility();//same as last toogle - TODO: remove in the game
            }
            if(y + 1 < heigth){//when the row is done, and there is more rows to be create, we need to add the first field in the next row.
                if (specialPos[y + 1][0]) {
                    newField = new FieldWall();
                } else {
                    newField = new FieldStandard();
                }
                firstInRow.setSouth(newField);//the first field in the above row needs to know of the first in the next row.
                firstInRow = newField;
                lastField = newField;
                newField.toggleVisibility();//same as last toogle - TODO: remove in the game
            }
        }
    }

    /** Starts the printing process of the fields */
    public void printBoard() {
        this.start.printFields();
    }

    /** the run function of the game, will run in a eternaty loop */
    public void run() {
        printBoard();//Starts with printing the board

        BoardField mid = start.findFieldByCount(width % 2 == 1 ? (width / 2) + 1 : width / 2, heigth % 2 == 1 ? (heigth / 2) + 1 : heigth / 2);//find the middle or closet representativ

        System.out.println("North of Middle: " + mid.countNearestObject(DIRECTION.NORTH));//print out closes wall to the north of middle -1 if none
        System.out.println("SOUTH of Middle: " + mid.countNearestObject(DIRECTION.SOUTH));//print out closes wall to the south of middle -1 if none
        System.out.println("EAST of Middle: " + mid.countNearestObject(DIRECTION.EAST));//print out closes wall to the east of middle -1 if none
        System.out.println("WEST of Middle: " + mid.countNearestObject(DIRECTION.WEST));//print out closes wall to the west of middle -1 if none
    }
}
