package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;

import java.awt.*;

public class Supply1Obj extends GameObj{
    int route=0;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Supply1Obj() {
        super();
    }

    public Supply1Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Supply1Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    public Supply1Obj(double x, double y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==2) {
            if (GameWin.supply[1] == 3) {
                if (route <= 150 && y >= 0) {
                    y -= 3;
                    route += 3;
                } else {
                    GameWin.boom = 1;
                    GameWin.supply[1] = 0;
                    x = -1000;
                    y = -1000;
                    GameUtils.removeObjList.add(this);
                }
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
