package com.thunder.obj;

import com.thunder.GameWin;

import java.awt.*;

public class Map3Obj extends GameObj{
    int speed=1;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Map3Obj() {
        super();
    }

    public Map3Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Map3Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    public Map3Obj(double x, double y) {
        super(x, y);
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
