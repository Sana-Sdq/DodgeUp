import processing.core.*;

public class Human implements Interface{
    float x;

    public static  PApplet a=Main.processing;

    @Override
    public void ShowObject() {
        x=a.mouseX;
        a.stroke(0,76,153);
        a.fill(255,215,0);
        a.ellipse(x, 590, 20, 20);
    }

}
