package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;

import java.awt.*;

public class BossBullet2Obj extends GameObj{
    double r=2;
    double xSpeed=0;
    double ySpeed=0;
    public BossBullet2Obj() {
        super();
    }

    public BossBullet2Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public BossBullet2Obj(Image img, int width, int height, double x, double y, int bulletNum, GameWin frame) {
        super(img, width, height, x, y, bulletNum, frame);
    }

    public BossBullet2Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    public BossBullet2Obj(double x, double y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==2) {
            if(bulletNum>=0 && bulletNum<=4){
                ySpeed=r*Math.cos((Math.PI/3)*(double)(bulletNum)/4);
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y+=ySpeed;
                x+=xSpeed;
            }else if(bulletNum>=5 && bulletNum<=7){
                ySpeed=r*Math.cos((Math.PI/3)*((double)(4-bulletNum%4)/4));
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y+=ySpeed;
                x+=xSpeed;
            }else if(bulletNum>=8 && bulletNum<=12){
                ySpeed=r*Math.cos((Math.PI/3)*((double)(bulletNum%8)/4));
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y+=ySpeed;
                x-=xSpeed;
            }
            else if(bulletNum>=13 && bulletNum<=16){
                ySpeed=r*Math.cos((Math.PI/3)*((double)(4-bulletNum%12)/4));
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y+=ySpeed;
                x-=xSpeed;
            }
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
