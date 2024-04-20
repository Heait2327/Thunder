package com.thunder.obj;

import com.thunder.GameWin;

import java.awt.*;

public class GameObj {
    public int gameWidth=507, gameHeight=900;
    Image img;
    int width;
    int height;
    double x;
    double y;
    int bulletNum;
    GameWin frame;

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public GameWin getFrame() {
        return frame;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }

    public GameObj() {

    }

    public GameObj(Image img, int width, int height, double x, double y, GameWin frame) {
        this.img = img;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.frame = frame;
    }

    public GameObj(Image img, int width, int height, double x, double y, int bulletNum, GameWin frame) {
        this.img = img;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.bulletNum = bulletNum;
        this.frame = frame;
    }

    public GameObj(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public GameObj(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void paintSelf(Graphics g){
        g.drawImage(img,(int)x,(int)y,null);
    }

    public Rectangle getRec(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
