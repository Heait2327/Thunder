package com.thunder.obj;

import com.thunder.GameWin;

import java.awt.*;

public class Supply4Obj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Supply4Obj() {
        super();
    }

    public Supply4Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Supply4Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    public Supply4Obj(double x, double y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        if(GameWin.gameState==2) {
            super.paintSelf(g);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
