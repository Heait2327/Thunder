package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;

import java.awt.*;

public class Plane3Bullet3Obj extends GameObj{
    double speed=2;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Plane3Bullet3Obj() {
        super();
    }

    public Plane3Bullet3Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Plane3Bullet3Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    public Plane3Bullet3Obj(double x, double y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==1 || GameWin.gameState==2) {
            y -= speed;
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
