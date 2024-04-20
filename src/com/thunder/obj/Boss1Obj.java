package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;
import com.thunder.utils.MusicTool;

import java.awt.*;

public class Boss1Obj extends GameObj{
    int speed=1;
    int hp=500;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Boss1Obj() {
        super();
    }

    public Boss1Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
    }

    public Boss1Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    public Boss1Obj(double x, double y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==2) {
            if(GameWin.bossIfLive==1 && GameWin.bossCome==1){
                hp = 500;
                x = 253.5-175;
                y = -288;
                GameWin.bossCome=0;
            }
            if(GameWin.bossIfLive==1){
                //血条
/*               g.setColor(Color.white);
                g.fillRect(gameWidth/2-100,50,200,10);*/
                g.setColor(Color.red);
                g.fillRect(gameWidth/2-100,50,hp*200/500,10);
            }
            if(y<=0) {
                y += speed;
            }
            if (this.hp <= 0) {
                MusicTool.playExplodeMusic();
                ExplosionBigObj explosionBigObj = new ExplosionBigObj(x, y);
                GameUtils.explosionBigObjList.add(explosionBigObj);
                GameUtils.removeObjList.add(explosionBigObj);
                this.setX(-1000);
                this.setY(-1000);
                this.hp=500;
                GameWin.bossIfLive=0;
                GameWin.score+=100;
                MusicTool.playBattleMusic();
            }
            //敌机被击中
            if(GameWin.chosePlane==1) {
                for (Plane1Bullet1Obj plane1Bullet1Obj : GameUtils.plane1Bullet1ObjList) {
                    if (this.getRec().intersects(plane1Bullet1Obj.getRec())) {
                        plane1Bullet1Obj.setX(-1000);
                        plane1Bullet1Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane1Bullet1Obj);
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;         //若一级子弹未消失,则存在一级子弹打出二级子弹伤害的bug
                        if(Math.random()<0.01){     //百分之一的概率掉落道具
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
                for (Plane1Bullet2Obj plane1Bullet2Obj : GameUtils.plane1Bullet2ObjList) {
                    if (this.getRec().intersects(plane1Bullet2Obj.getRec())) {
                        plane1Bullet2Obj.setX(-1000);
                        plane1Bullet2Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane1Bullet2Obj);
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
                for (Plane1Bullet3Obj plane1Bullet3Obj : GameUtils.plane1Bullet3ObjList) {
                    if (this.getRec().intersects(plane1Bullet3Obj.getRec())) {
                        plane1Bullet3Obj.setX(-1000);
                        plane1Bullet3Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane1Bullet3Obj);
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
            }else if(GameWin.chosePlane==2) {
                for (Plane2Bullet1Obj plane2Bullet1Obj : GameUtils.plane2Bullet1ObjList) {
                    if (this.getRec().intersects(plane2Bullet1Obj.getRec())) {
                        plane2Bullet1Obj.setX(-1000);
                        plane2Bullet1Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane2Bullet1Obj);
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
                for (Plane2Bullet2Obj plane2Bullet2Obj : GameUtils.plane2Bullet2ObjList) {
                    if (this.getRec().intersects(plane2Bullet2Obj.getRec())) {
                        plane2Bullet2Obj.setX(-1000);
                        plane2Bullet2Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane2Bullet2Obj);
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
                for (Plane2Bullet3Obj plane2Bullet3Obj : GameUtils.plane2Bullet3ObjList) {
                    if (this.getRec().intersects(plane2Bullet3Obj.getRec())) {
                        plane2Bullet3Obj.setX(-1000);
                        plane2Bullet3Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane2Bullet3Obj);
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
            }else if(GameWin.chosePlane==3) {
                for (Plane3Bullet1Obj plane3Bullet1Obj : GameUtils.plane3Bullet1ObjList) {
                    if (this.getRec().intersects(plane3Bullet1Obj.getRec())) {
                        plane3Bullet1Obj.setX(-1000);
                        plane3Bullet1Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane3Bullet1Obj);
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
                for (Plane3Bullet2Obj plane3Bullet2Obj : GameUtils.plane3Bullet2ObjList) {
                    if (this.getRec().intersects(plane3Bullet2Obj.getRec())) {
                        plane3Bullet2Obj.setX(-1000);
                        plane3Bullet2Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane3Bullet2Obj);
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
                for (Plane3Bullet3Obj plane3Bullet3Obj : GameUtils.plane3Bullet3ObjList) {
                    if (this.getRec().intersects(plane3Bullet3Obj.getRec())) {
                        plane3Bullet3Obj.setX(-1000);
                        plane3Bullet3Obj.setY(-1000);
                        GameUtils.removeObjList.add(plane3Bullet3Obj);
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
            }else if(GameWin.chosePlane==4) {
                for (Plane4Bullet1Obj plane4Bullet1Obj : GameUtils.plane4Bullet1ObjList) {
                    if (this.getRec().intersects(plane4Bullet1Obj.getRec())) {
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
                for (Plane4Bullet2Obj plane4Bullet2Obj : GameUtils.plane4Bullet2ObjList) {
                    if (this.getRec().intersects(plane4Bullet2Obj.getRec())) {
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
                    }
                }
                for (Plane4Bullet3Obj plane4Bullet3Obj : GameUtils.plane4Bullet3ObjList) {
                    if (this.getRec().intersects(plane4Bullet3Obj.getRec())) {
                        GameWin.score+=GameWin.playerAttack;
                        GameWin.hitBossScore+=GameWin.playerAttack;
                        hp -= GameWin.playerAttack;
                        if(Math.random()<0.01){
                            GameWin.ifCreatSupplyDrop=1;
                            GameWin.supplyDropX=253.5-30;
                            if(y>=0) {
                                GameWin.supplyDropY = height;
                            }else{
                                GameWin.supplyDropY = 1;
                            }
                            GameWin.supplyDropNum=(int)((Math.random()+0.25)*4);
                        }
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
