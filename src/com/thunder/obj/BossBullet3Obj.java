package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;

import java.awt.*;

public class BossBullet3Obj extends GameObj{
    double r=2;
    double xSpeed=0;
    double ySpeed=0;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public BossBullet3Obj() {
        super();
    }

    public BossBullet3Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public BossBullet3Obj(Image img, int width, int height, double x, double y, int bulletNum, GameWin frame) {
        super(img, width, height, x, y, bulletNum, frame);
    }

    public BossBullet3Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    public BossBullet3Obj(double x, double y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==2) {
            if(bulletNum>=0 && bulletNum<=5){
                ySpeed=r*Math.cos((Math.PI/2)*((double)(bulletNum)/6));
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y+=ySpeed;
                x-=xSpeed;
            }else if(bulletNum>=6 && bulletNum<=11){
                ySpeed=r*Math.sin((Math.PI/2)*((double)(bulletNum%6)/6));
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y-=ySpeed;
                x-=xSpeed;
            }else if(bulletNum>=12 && bulletNum<=17){
                ySpeed=r*Math.cos((Math.PI/2)*((double)(bulletNum%12)/6));
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y-=ySpeed;
                x+=xSpeed;
            }
            else if(bulletNum>=18 && bulletNum<=24){
                ySpeed=r*Math.sin((Math.PI/2)*((double)(bulletNum%18)/6));
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y+=ySpeed;
                x+=xSpeed;
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
