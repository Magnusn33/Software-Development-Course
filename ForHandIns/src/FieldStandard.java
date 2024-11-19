/**
 * a standard field to show the basics and hold a player
 */
public class FieldStandard extends BoardField {

    FieldStandard(){ }

    public boolean isObject(){
        return false;
    }

    public boolean moveToDie(){
        return false;
    }

    @Override
    public void toggleVisibility(){
        isVisible = !isVisible;
    }
}
