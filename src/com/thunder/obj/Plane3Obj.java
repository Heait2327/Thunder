package com.thunder.obj;

import com.thunder.GameWin;
import com.thunder.utils.GameUtils;
import com.thunder.utils.MusicTool;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Plane3Obj extends GameObj{
    int hp=GameWin.plane3Hp;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Plane3Obj() {
        super();
    }

    public Plane3Obj(Image img, int width, int height, double x, double y, GameWin frame) {
        super(img, width, height, x, y, frame);
        //鼠标移动事件
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                GameWin.playerX=e.getX();
                GameWin.playerY=e.getY();
            }
        });
    }

    public Plane3Obj(Image img, double x, double y) {
        super(img, x, y);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(GameWin.gameState==1){
            if(GameWin.chosePlane==3){
                this.x=253.5-54.5;
                this.y=571;
            }else{
                this.x=-2000;
                this.y=-2000;
            }
        }
        if(GameWin.gameState==2 && GameWin.chosePlane==3) {
            if (GameWin.invincibility[0]==0 || GameWin.invincibility[0]==2) {        //如果不闪烁
                this.x = GameWin.playerX - 55;
                this.y = GameWin.playerY - 60;
            }else{
                if(GameWin.invincibility[1] == 0){		//开始闪烁
                    this.x = GameWin.playerX - 54.5;
                    this.y = GameWin.playerY - 65.5;
                    if (GameWin.TimerZero(100, 0, 1)) {
                        GameWin.invincibility[1] = 1;
                        this.x = -2000;
                        this.y = -2000;
                    }
                }else if(GameWin.TimerZero(100, 0, 1)){
                    GameWin.invincibility[1] = 0;
                }
            }
            if(GameWin.invincibility[0]==0 && GameWin.TimerZero(1000, 0, 0)) {
                //玩家碰撞敌机
                for (Enemy1Obj enemy1Obj : GameUtils.enemy1ObjList) {
                    if (this.getRec().intersects(enemy1Obj.getRec())) {
                        GameWin.invincibility[0] = 1;		//玩家飞机闪烁
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                    }
                }
                for (Enemy2Obj enemy2Obj : GameUtils.enemy2ObjList) {
                    if (this.getRec().intersects(enemy2Obj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                    }
                }
                for (Enemy3Obj enemy3Obj : GameUtils.enemy3ObjList) {
                    if (this.getRec().intersects(enemy3Obj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                    }
                }
                for (Enemy4Obj enemy4Obj : GameUtils.enemy4ObjList) {
                    if (this.getRec().intersects(enemy4Obj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                    }
                }
                for (Enemy5Obj enemy5Obj : GameUtils.enemy5ObjList) {
                    if (this.getRec().intersects(enemy5Obj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                    }
                }
                //玩家碰撞BOSS
                for (Boss1Obj boss1Obj : GameUtils.boss1ObjList) {
                    if (this.getRec().intersects(boss1Obj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                    }
                }
                for (Boss2Obj boss2Obj : GameUtils.boss2ObjList) {
                    if (this.getRec().intersects(boss2Obj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                    }
                }
                for (Boss3Obj boss3Obj : GameUtils.boss3ObjList) {
                    if (this.getRec().intersects(boss3Obj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                    }
                }
                //玩家被击中
                for (Enemy3BulletObj enemy3BulletObj : GameUtils.enemy3BulletObjList) {
                    if (this.getRec().intersects(enemy3BulletObj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                        enemy3BulletObj.setX(-1000);
                        enemy3BulletObj.setY(-1000);
                        GameUtils.removeObjList.add(enemy3BulletObj);
                    }
                }
                for (Enemy4BulletObj enemy4BulletObj : GameUtils.enemy4BulletObjList) {
                    if (this.getRec().intersects(enemy4BulletObj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                        enemy4BulletObj.setX(-1000);
                        enemy4BulletObj.setY(-1000);
                        GameUtils.removeObjList.add(enemy4BulletObj);
                    }
                }
                for (Enemy5BulletObj enemy5BulletObj : GameUtils.enemy5BulletObjList) {
                    if (this.getRec().intersects(enemy5BulletObj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                        enemy5BulletObj.setX(-1000);
                        enemy5BulletObj.setY(-1000);
                        GameUtils.removeObjList.add(enemy5BulletObj);
                    }
                }
                for (BossBullet1Obj bossBullet1Obj : GameUtils.bossBullet1ObjList) {
                    if (this.getRec().intersects(bossBullet1Obj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                        bossBullet1Obj.setX(-1000);
                        bossBullet1Obj.setY(-1000);
                        GameUtils.removeObjList.add(bossBullet1Obj);
                    }
                }
                for (BossBullet2Obj bossBullet2Obj : GameUtils.bossBullet2ObjList) {
                    if (this.getRec().intersects(bossBullet2Obj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                        bossBullet2Obj.setX(-1000);
                        bossBullet2Obj.setY(-1000);
                        GameUtils.removeObjList.add(bossBullet2Obj);
                    }
                }
                for (BossBullet3Obj bossBullet3Obj : GameUtils.bossBullet3ObjList) {
                    if (this.getRec().intersects(bossBullet3Obj.getRec())) {
                        GameWin.invincibility[0] = 1;
                        GameWin.invincibility[1] = 1;
                        this.hp--;
                        bossBullet3Obj.setX(-1000);
                        bossBullet3Obj.setY(-1000);
                        GameUtils.removeObjList.add(bossBullet3Obj);
                    }
                }
            }
            if (this.hp <= 0) {
                this.x = -2000;
                this.y = -2000;
                GameUtils.removeObjList.add(this);
                GameWin.gameState = 4;
            }
            //和补给碰撞
            for (Supply1DropObj supply1DropObj : GameUtils.supply1DropObjList) {
                if (this.getRec().intersects(supply1DropObj.getRec())) {
                    supply1DropObj.setX(-1000);
                    supply1DropObj.setY(-1000);
                    GameUtils.removeObjList.add(supply1DropObj);
                    GameWin.supply[1]=1;
                }
            }
            for (Supply2DropObj supply2DropObj : GameUtils.supply2DropObjList) {
                if (this.getRec().intersects(supply2DropObj.getRec())) {
                    supply2DropObj.setX(-1000);
                    supply2DropObj.setY(-1000);
                    GameUtils.removeObjList.add(supply2DropObj);
                    if(GameWin.supply[2]!=2) {  //狂暴状态不可叠加
                        GameWin.supply[2] = 1;
                        MusicTool.playRageMusic();
                    }
                }
            }
            for (Supply3DropObj supply3DropObj : GameUtils.supply3DropObjList) {
                if (this.getRec().intersects(supply3DropObj.getRec())) {
                    supply3DropObj.setX(-1000);
                    supply3DropObj.setY(-1000);
                    GameUtils.removeObjList.add(supply3DropObj);
                    GameWin.supply[3]=1;
                    MusicTool.playRestoreMusic();
                }
            }
            for (Supply4DropObj supply4DropObj : GameUtils.supply4DropObjList) {
                if (this.getRec().intersects(supply4DropObj.getRec())) {
                    supply4DropObj.setX(-1000);
                    supply4DropObj.setY(-1000);
                    GameUtils.removeObjList.add(supply4DropObj);
                    GameWin.supply[4]=1;
                    MusicTool.playShieldMusic();
                }
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}