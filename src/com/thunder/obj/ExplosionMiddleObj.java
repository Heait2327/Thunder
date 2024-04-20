package com.thunder.obj;

import com.thunder.GameWin;

import java.awt.*;

public class ExplosionMiddleObj extends GameObj{
    static Image[] explosionImg = new Image[9];
    //爆炸图片播放记录
    int explosionCount=0;
    //将爆炸图片放入静态数组中
    static {
        for (int i=0;i<explosionImg.length;i++){
            explosionImg[i]=Toolkit.getDefaultToolkit().getImage("res/images/explosionMiddle"+(i+1)+".png");
        }
    }
    @Override
    public void paintSelf(Graphics g) {
        if(GameWin.gameState==2) {
            if (explosionCount < 9) {
                super.img = explosionImg[explosionCount];
                super.paintSelf(g);
                explosionCount++;
            }
        }
    }

    public ExplosionMiddleObj(double x, double y) {
        super(x, y);
    }
}
