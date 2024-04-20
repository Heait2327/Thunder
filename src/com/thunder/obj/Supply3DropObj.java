package com.thunder.obj;

import com.thunder.GameWin;

import java.awt.*;

public class Supply3DropObj extends GameObj{
    int xSpeed=Math.random()>0.5?1:-1;
    int ySpeed=Math.random()>0.5?1:-1;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Supply3DropObj() {
        super();
    }

    public Supply3DropObj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Supply3DropObj(Image img, double x, double y) {
        super(img, x, y);
    }

    public Supply3DropObj(double x, double y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==2) {
            x += xSpeed;
            y += ySpeed;
            if (x <= 0 || x >= gameWidth - width) {
                xSpeed *= -1;
            }
            if (y <= 0 || y >= gameHeight - height) {
                ySpeed *= -1;
            }
            if (y < 0) {
                y = 1;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
