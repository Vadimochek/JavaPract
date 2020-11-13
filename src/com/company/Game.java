package com.company;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import static com.company.INTERFACE.*;
import static org.lwjgl.opengl.GL11.*;

public class Game {
    private static int x=-1;
    private static int y=0;
    private static int direction=1;
    private static int length=3;
    private static boolean nowtoeat = true;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        INTERFACE.initial();
        newberry();
        while(true){
            vhod();
            play();
            INTERFACE.paint();
            INTERFACE.refresh(nowtoeat);
        }
    }
    private static void play(){
        nowtoeat=true;
        switch (direction){
            case 0:
                y++;
                break;
            case 1: x++; break;
            case 2: y--; break;
            case 3: x--; break;
            default: break;
        }
        if(x < 0 || x >= CELLX || y < 0 || y >= CELLY){
            System.out.println(length);
            System.exit(1);
        }
        int nextvalue=INTERFACE.getVAL(x,y);
        if(nextvalue>0){
            System.out.println(length);
            System.exit(1);
        } else if(nextvalue<0){
            length++;
            newberry();
            nowtoeat=false;
        }
        INTERFACE.setVAL(x,y,length);
    }

    private static void newberry() {
        int to4ka = new Random().nextInt(CELLX* CELLY-length);
        for(int i=0; i<CELLX; i++){
            for(int j=0; j<CELLY; j++){
                if(INTERFACE.getVAL(i,j) <= 0) {
                    if (to4ka == 0) {
                        INTERFACE.setVAL(i, j, -1);
                        return;
                    }else {
                        to4ka--;
                    }
                }
            }
        }
    }
    private static void vhod() {
        int newd = direction;
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                switch (Keyboard.getEventKey()) {
                    case Keyboard.KEY_UP:
                        if (direction != 2) newd = 0;
                        break;
                    case Keyboard.KEY_RIGHT:
                        if (direction != 3) newd = 1;
                        break;
                    case Keyboard.KEY_DOWN:
                        if (direction != 0) newd = 2;
                        break;
                    case Keyboard.KEY_LEFT:
                        if (direction != 1) newd = 3;
                        break;
                }
            }
        }
        direction=newd;
    }
}
class INTERFACE{
    public static final int SIZE = 35;
    public static final int CELLX = 25;
    public static final int CELLY = 25;
    public static final int SPAWN = 1;
    public static final int FPS = 8;
    public static final int WIDTH =CELLX*SIZE;
    public static final int HEIGHT = CELLY*SIZE;
    private static Cell[][] cells;
    public static void paint() {
        glClear(GL_COLOR_BUFFER_BIT);
        for (Cell[] line : cells)
            for (Cell cell : line)
                paintEl(cell);
    }
    private static void initializeOpenGL(){
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("SNAKE");
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0,WIDTH,0,HEIGHT,1,-1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glClearColor(1,1,1,1);
    }
    public static void initial(){
        initializeOpenGL();
        cells=new Cell[CELLX][CELLY];
        Random r= new Random();
        for(int i=0;i<CELLX;i++){
            for(int j=0;j<CELLY;j++){
                cells[i][j]=new Cell(i*SIZE,j*SIZE,( SPAWN > r.nextInt(100)?-1:0));
            }
        }
    }
    public static int getVAL(int x, int y){
        return cells[x][y].getValue();
    }

    public static void setVAL(int x, int y, int value){
        cells[x][y].setValue(value);
    }
    private static void paintEl(Cell obj){
        if(obj.graphic()==null) return;
        obj.graphic().getText().bind();

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2f(obj.getX(),obj.getY()+obj.getHeight());
        glTexCoord2f(1,0);
        glVertex2f(obj.getX()+obj.getWidth(),obj.getY()+obj.getHeight());
        glTexCoord2f(1,1);
        glVertex2f(obj.getX()+obj.getWidth(), obj.getY());
        glTexCoord2f(0,1);
        glVertex2f(obj.getX(), obj.getY());
        glEnd();
    }
    public static void refresh(boolean eat){
        updateGL();
        for (Cell[] line : cells)
            for (Cell cell : line)
                cell.Refresh(eat);
    }
    private static void updateGL() {
        Display.update();
        Display.sync(FPS);
    }

}
enum Sprite{
    BODY("YT"),money("money");
    private Texture text;
    Sprite (String texture){
        try{
        this.text= TextureLoader.getTexture("PNG",new FileInputStream(new File("C:\\Users\\vadim\\Downloads\\"+texture+".png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public Texture getText(){
        return this.text;
    }
}
class Cell{
    private int x;
    private int y;
    private int value;
    Cell(int x,int y,int value){
        this.x=x;
        this.y=y;
        this.value=value;
    }
    public void Refresh(boolean eating){
        if(eating && value>0){
            value--;
        }
    }
    public Sprite graphic() {
        if (value > 0) {
            return Sprite.BODY;
        } else if (value == 0) return null;
        else
            return Sprite.money;
    }

    public int getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public int getHeight(){
        return SIZE;
    }

    public int getWidth(){
        return SIZE;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}