package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;

import java.awt.*;

public class BossBullet1Obj extends GameObj{
    double xSpeed=Math.random()*2>1?-1:1;
    double ySpeed=2;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public BossBullet1Obj() {
        super();
    }

    public BossBullet1Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public BossBullet1Obj(Image img, int width, int height, double x, double y, int bulletNum, GameWin frame) {
        super(img, width, height, x, y, bulletNum, frame);
    }

    public BossBullet1Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    public BossBullet1Obj(double x, double y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        x+=xSpeed;
        y+=ySpeed;
        if(y>gameHeight){
            GameUtils.removeObjList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
