package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;
import com.thunder.utils.MusicTool;

import java.awt.*;

public class Enemy1Obj extends GameObj{
    int hp=1;
    double speed=2.5;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Enemy1Obj() {
        super();
    }

    @Override
    public void setImg(Image img) {
        super.setImg(img);
    }

    public Enemy1Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Enemy1Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==2) {
            y += speed;
            if(y>gameHeight){
                GameUtils.removeObjList.add(this);
            }
            if (this.hp<=0 || GameWin.boom==1) {
                MusicTool.playExplodeMusic();
                ExplosionSmallObj explosionSmallObj = new ExplosionSmallObj(x, y);
                GameUtils.explosionSmallObjList.add(explosionSmallObj);
                GameUtils.removeObjList.add(explosionSmallObj);
                if(Math.random()<0.05){     //百分之五的概率掉落道具
                    GameWin.ifCreatSupplyDrop=1;
                    GameWin.supplyDropX=x;
                    if(y>=0) {
                        GameWin.supplyDropY = y;
                    }else{
                        GameWin.supplyDropY = 1;
                    }
                    GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                }
                this.setX(-1000);
                this.setY(-1000);
                GameUtils.removeObjList.add(this);
                GameWin.score+=1;
            }
            //敌机被击中
            if(GameWin.chosePlane==1) {
                for (Plane1Bullet1Obj plane1Bullet1Obj : GameUtils.plane1Bullet1ObjList) {
                    if (this.getRec().intersects(plane1Bullet1Obj.getRec())) {
                        plane1Bullet1Obj.setX(-1000);
                        plane1Bullet1Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane1Bullet1Obj);
                        hp -= GameWin.playerAttack;         //若一级子弹未消失,则存在一级子弹打出二级子弹伤害的bug
                    }
                }
                for (Plane1Bullet2Obj plane1Bullet2Obj : GameUtils.plane1Bullet2ObjList) {
                    if (this.getRec().intersects(plane1Bullet2Obj.getRec())) {
                        plane1Bullet2Obj.setX(-1000);
                        plane1Bullet2Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane1Bullet2Obj);
                        hp -= GameWin.playerAttack;
                    }
                }
                for (Plane1Bullet3Obj plane1Bullet3Obj : GameUtils.plane1Bullet3ObjList) {
                    if (this.getRec().intersects(plane1Bullet3Obj.getRec())) {
                        plane1Bullet3Obj.setX(-1000);
                        plane1Bullet3Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane1Bullet3Obj);
                        hp -= GameWin.playerAttack;
                    }
                }
            }else if(GameWin.chosePlane==2) {
                for (Plane2Bullet1Obj plane2Bullet1Obj : GameUtils.plane2Bullet1ObjList) {
                    if (this.getRec().intersects(plane2Bullet1Obj.getRec())) {
                        plane2Bullet1Obj.setX(-1000);
                        plane2Bullet1Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane2Bullet1Obj);
                        hp -= GameWin.playerAttack;         //若一级子弹未消失,则存在一级子弹打出二级子弹伤害的bug
                    }
                }
                for (Plane2Bullet2Obj plane2Bullet2Obj : GameUtils.plane2Bullet2ObjList) {
                    if (this.getRec().intersects(plane2Bullet2Obj.getRec())) {
                        plane2Bullet2Obj.setX(-1000);
                        plane2Bullet2Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane2Bullet2Obj);
                        hp -= GameWin.playerAttack;
                    }
                }
                for (Plane2Bullet3Obj plane2Bullet3Obj : GameUtils.plane2Bullet3ObjList) {
                    if (this.getRec().intersects(plane2Bullet3Obj.getRec())) {
                        plane2Bullet3Obj.setX(-1000);
                        plane2Bullet3Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane2Bullet3Obj);
                        hp -= GameWin.playerAttack;
                    }
                }
            }else if(GameWin.chosePlane==3) {
                for (Plane3Bullet1Obj plane3Bullet1Obj : GameUtils.plane3Bullet1ObjList) {
                    if (this.getRec().intersects(plane3Bullet1Obj.getRec())) {
                        plane3Bullet1Obj.setX(-1000);
                        plane3Bullet1Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane3Bullet1Obj);
                        hp -= GameWin.playerAttack;         //若一级子弹未消失,则存在一级子弹打出二级子弹伤害的bug
                    }
                }
                for (Plane3Bullet2Obj plane3Bullet2Obj : GameUtils.plane3Bullet2ObjList) {
                    if (this.getRec().intersects(plane3Bullet2Obj.getRec())) {
                        plane3Bullet2Obj.setX(-1000);
                        plane3Bullet2Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane3Bullet2Obj);
                        hp -= GameWin.playerAttack;
                    }
                }
                for (Plane3Bullet3Obj plane3Bullet3Obj : GameUtils.plane3Bullet3ObjList) {
                    if (this.getRec().intersects(plane3Bullet3Obj.getRec())) {
                        plane3Bullet3Obj.setX(-1000);
                        plane3Bullet3Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane3Bullet3Obj);
                        hp -= GameWin.playerAttack;
                    }
                }
            }else if(GameWin.chosePlane==4) {
                for (Plane4Bullet1Obj plane4Bullet1Obj : GameUtils.plane4Bullet1ObjList) {
                    if (this.getRec().intersects(plane4Bullet1Obj.getRec())) {
                        hp -= GameWin.playerAttack;         //若一级子弹未消失,则存在一级子弹打出二级子弹伤害的bug
                    }
                }
                for (Plane4Bullet2Obj plane4Bullet2Obj : GameUtils.plane4Bullet2ObjList) {
                    if (this.getRec().intersects(plane4Bullet2Obj.getRec())) {
                        hp -= GameWin.playerAttack;
                    }
                }
                for (Plane4Bullet3Obj plane4Bullet3Obj : GameUtils.plane4Bullet3ObjList) {
                    if (this.getRec().intersects(plane4Bullet3Obj.getRec())) {
                        hp -= GameWin.playerAttack;
                    }
                }
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
