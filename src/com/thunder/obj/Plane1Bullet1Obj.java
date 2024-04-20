package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;

import java.awt.*;

public class Plane1Bullet1Obj extends GameObj{
    double speed=3;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Plane1Bullet1Obj() {
        super();
    }

    public Plane1Bullet1Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Plane1Bullet1Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==1 || GameWin.gameState==2) {
            y-=speed;
        }
        if(y<-1000){
            GameUtils.removeObjList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
