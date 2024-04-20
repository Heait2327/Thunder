package com.thunder.obj;

import com.thunder.GameWin;

import java.awt.*;

public class Plane4Bullet2Obj extends GameObj{
    double speed=2;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Plane4Bullet2Obj() {
        super();
    }

    public Plane4Bullet2Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Plane4Bullet2Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.plane4Bullet2Live==1) {
            if (GameWin.gameState == 1){

            } else if(GameWin.gameState == 2) {
                x = GameWin.playerX - 16.5;
                y = GameWin.playerY - 900 - 40;
            }
        }else{
            x = -1000;
            y = -1000;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
