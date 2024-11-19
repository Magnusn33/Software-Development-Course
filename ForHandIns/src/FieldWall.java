/**
 * a feild to reprisent a impassable wall
 */
public class FieldWall extends BoardField {

    public FieldWall(){
        this.c = 'O';
    }

    @Override
    public boolean isObject() {
        return true;
    }

    @Override
    public boolean moveToDie() {
        return true;
    }

    @Override
    public void toggleVisibility(){
        isVisible = !isVisible;
    }
}
