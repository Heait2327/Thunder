package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;

import java.awt.*;

public class Enemy5BulletObj extends GameObj{
    double r=2;
    double xSpeed=0;
    double ySpeed=0;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Enemy5BulletObj() {
        super();
    }

    public Enemy5BulletObj(Image img, int width, int height, double x, double y, int bulletNum, GameWin frame) {
        super(img, width, height, x, y, bulletNum, frame);
    }

    public Enemy5BulletObj(Image img, double x, double y) {
        super(img, x, y);
    }

    public Enemy5BulletObj(double x, double y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==2) {
            if(bulletNum>=0 && bulletNum<=3){
                ySpeed=r*Math.cos((Math.PI/3)*(double)(bulletNum)/3);
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y+=ySpeed;
                x+=xSpeed;
            }else if(bulletNum>=4 && bulletNum<=5){
                ySpeed=r*Math.cos((Math.PI/3)*((double)(3-bulletNum%3)/3));
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y+=ySpeed;
                x+=xSpeed;
            }else if(bulletNum>=6 && bulletNum<=9){
                ySpeed=r*Math.cos((Math.PI/3)*((double)(bulletNum%6)/3));
                xSpeed=Math.sqrt(r*r-ySpeed*ySpeed);
                y+=ySpeed;
                x-=xSpeed;
            }
            else if(bulletNum>=10 && bulletNum<=12){
                ySpeed=r*Math.cos((Math.PI/3)*((double)(3-bulletNum%9))/3);
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
