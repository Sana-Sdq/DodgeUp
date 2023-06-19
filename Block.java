import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import processing.core.*;

public class  Block implements Interface {
    private int BlockWidth = 20;
    private int BlockHeight = 50;
    private int Blockx;
    private int Blocky;
    private int blockR;
    private int blockG;
    private int blockB;
    public boolean Lost=false;
    private static int y0=-80;
    public static PApplet a = Main.processing;


    public Block(int blockx, int blocky, int blockR, int blockG, int blockB) {
        Blockx = blockx;
        Blocky = blocky;
        this.blockR = blockR;
        this.blockG = blockG;
        this.blockB = blockB;
    }

    public static void MakeBlocks() {
        for (int i=0;i<100;i++){
            Main.blocks.add(new Block(ThreadLocalRandom.current().nextInt(1,100),y0 , 255, 255, 255));
            y0-=80;
            Main.blocks.add(new Block(ThreadLocalRandom.current().nextInt(101,200), y0 , 255, 255, 255));
            y0+=40;
            Main.blocks.add(new Block(ThreadLocalRandom.current().nextInt(201,300), y0 , 255, 255, 255));
            y0-=30;
            Main.blocks.add(new Block(ThreadLocalRandom.current().nextInt(301,400), y0 , 255, 255, 255));
            y0-=80;
        }
    }

    @Override
    public void ShowObject() {
        a.fill(new Random().nextInt(1,250),new Random().nextInt(1,250),new Random().nextInt(1,250));
        a.noStroke();
        // a.rect(BlockWidth, BlockHeight, 40, 50);
        a.rect(Blockx, Blocky,BlockWidth, BlockHeight);

    }

    public int getBlockWidth() {
        return BlockWidth;
    }

    public void setBlockWidth(int blockWidth) {
        BlockWidth = blockWidth;
    }

    public int getBlockHeight() {
        return BlockHeight;
    }

    public void setBlockHeight(int blockHeight) {
        BlockHeight = blockHeight;
    }

    public int getBlockx() {
        return Blockx;
    }

    public void setBlockx(int blockx) {
        Blockx = blockx;
    }

    public int getblockR() {
        return blockR;
    }

    public void setblockR(int blockR) {
        this.blockR = blockR;
    }

    public int getblockG() {
        return blockG;
    }

    public void setblockG(int blockG) {
        this.blockG = blockG;
    }

    public int getblockB() {
        return blockB;
    }

    public void setblockB(int blockB) {
        this.blockB = blockB;
    }

    public int getBlocky() {
        return Blocky;
    }

    public void setBlocky(int blocky) {
        Blocky = blocky;
    }

    public static PApplet getA() {
        return a;
    }

    public static void setA(PApplet a) {
        Block.a = a;
    }

//    public void colors(int r1 , int r2 , int r3){
//        this.r1=r1;
//        this.r2=r2;
//        this.r3=r3;
//    }

}