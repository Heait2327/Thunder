package com.thunder.obj;

import com.thunder.GameWin;

import java.awt.*;

public class Map1Obj extends GameObj{
    double speed=1;
    public Map1Obj() {
        super();
    }

    public Map1Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Map1Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==2) {
            y += speed;
            if (y >= 0) {
                y = -900;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
