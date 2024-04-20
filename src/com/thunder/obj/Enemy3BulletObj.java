package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;

import java.awt.*;

public class Enemy3BulletObj extends GameObj{
    double speed=3;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Enemy3BulletObj() {
        super();
    }

    public Enemy3BulletObj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Enemy3BulletObj(Image img, double x, double y) {
        super(img, x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==2) {
            y += speed;
        }
        if(y>gameHeight){
            GameUtils.removeObjList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
