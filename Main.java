import java.util.ArrayList;
import processing.core.*;
import processing.core.PImage;


public class Main extends PApplet {

    public static PApplet processing;
    Human human;
    Block block;
    PImage bg;



    static int Count;
    static boolean Win = false;
    static  boolean lose=false;

    boolean Alive = false;

    boolean countdown = true;

    int count=3;
    int timer=0;

     static float timer2;
    public static ArrayList<Block> blocks = new ArrayList<>();

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void setup() {
        timer2 = 0;
        processing = this;
        human = new Human();
        Block.MakeBlocks();
        //size(400,700);
        bg = loadImage("countdown3.jpg");


        size(400,700);
    }

    public void settings() {

        size(400, 700);
    }

    public void draw() {
       // image(bg, 0, 0);
        if(countdown){
            image(bg, 0, 0);
//        background(128,128,128);
            fill(225);
           textSize(100);
           text(count,170,350);
           if(millis()-timer>1000){
               count--;
               timer=millis();
           }
           if(count<=0){
               countdown=false;
               timer2=0;
               background(0,0,timer2);
               timer2 += 0.1;
               Alive=true;
//               background(0,0,timer2);
//               timer2 += 0.1;
           }

        }

        if (Alive) {
            background(0,0,timer2);
            timer2 += 0.1;
            stroke(150);
            line(0, 600, 400, 600);
            stroke(0);
            fill(255, 20, 147);
            for (Block block : blocks) {
                block.ShowObject();
            }
            checkCrash();
            human.ShowObject();
            FallBlocks();
            removeBlock();
        } else if (Win) {
                background(0);
                textSize(40);
                fill(0, 255, 0);
                text("You Won ;) "+"\n Good Job ", 30, 300);

        } else if (lose) {
            background(0);
            textSize(40);
            fill(255,0,0);
            text("You Lost :( "+"\n Please Try Again", 30, 300);
            textSize(30);
            fill(0,0,255);
            text("Play Again",30,600);
            if(mouseX>=30 && mouseX<=150 && mouseY>=580 && mouseY<=600){
                if(mousePressed){
                    background(0);
                    count=4;
                    countdown = true;
//                    setup();
//                    settings();
                    lose=false;


                }

            }

        }


    }


    public void FallBlocks() {
        for (Block block : blocks) {
            block.setBlocky(block.getBlocky() + 5);

        }

    }

    public void checkCrash() {
        for (Block block : blocks) {
            if (mouseX + 20 / 2 > block.getBlockx() && mouseX - 20 / 2 < block.getBlockx() + block.getBlockWidth()
                    && 590 + (20 / 2) > block.getBlocky()
                    && 590 - (20 / 2) < block.getBlocky() + block.getBlockHeight()) {

                Alive = false;
                lose=true;
            }
        }
    }

    public void removeBlock(){
        Count=0;
        for(int i=0;i<blocks.size();i++){
            if(blocks.get(i).getBlocky() >550){
                Count++;
                if (Count >= 400) {

                    Win = true;
                    Alive = false;
                }

            }
        }
    }


}