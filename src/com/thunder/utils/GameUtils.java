package com.thunder.utils;

import com.thunder.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    public static Image menu1Img = Toolkit.getDefaultToolkit().getImage("res/images/menu1.png");
    public static Image menu2Img = Toolkit.getDefaultToolkit().getImage("res/images/menu2.png");
    public static Image menu3Img = Toolkit.getDefaultToolkit().getImage("res/images/menu3.png");
    public static Image menu4Img = Toolkit.getDefaultToolkit().getImage("res/images/menu4.png");
    public static Image menu5Img = Toolkit.getDefaultToolkit().getImage("res/images/menu5.png");
    public static Image gameStopImg = Toolkit.getDefaultToolkit().getImage("res/images/stop.png");
    public static Image gameOverImg = Toolkit.getDefaultToolkit().getImage("res/images/gameOver.png");
    public static Image scoreListImg = Toolkit.getDefaultToolkit().getImage("res/images/scoreList.png");
    public static Image aboutImg = Toolkit.getDefaultToolkit().getImage("res/images/about.png");
    public static Image continueGame1Img = Toolkit.getDefaultToolkit().getImage("res/images/continueGame1.png");
    public static Image continueGame2Img = Toolkit.getDefaultToolkit().getImage("res/images/continueGame2.png");
    public static Image saveGame1Img = Toolkit.getDefaultToolkit().getImage("res/images/saveGame1.png");
    public static Image saveGame2Img = Toolkit.getDefaultToolkit().getImage("res/images/saveGame2.png");
    public static Image return1Img = Toolkit.getDefaultToolkit().getImage("res/images/return1.png");
    public static Image return2Img = Toolkit.getDefaultToolkit().getImage("res/images/return2.png");
    public static Image returnMenu1Img = Toolkit.getDefaultToolkit().getImage("res/images/returnMenu1.png");
    public static Image returnMenu2Img = Toolkit.getDefaultToolkit().getImage("res/images/returnMenu2.png");
    public static Image tryAgain1Img = Toolkit.getDefaultToolkit().getImage("res/images/tryAgain1.png");
    public static Image tryAgain2Img = Toolkit.getDefaultToolkit().getImage("res/images/tryAgain2.png");

    public static Image chosePlaneBackgroundImg = Toolkit.getDefaultToolkit().getImage("res/images/chosePlaneBackground.png");
    public static Image chosePlane1Img = Toolkit.getDefaultToolkit().getImage("res/images/chosePlane1.png");
    public static Image chosePlane2Img = Toolkit.getDefaultToolkit().getImage("res/images/chosePlane2.png");
    public static Image chosePlane3Img = Toolkit.getDefaultToolkit().getImage("res/images/chosePlane3.png");
    public static Image chosePlane4Img = Toolkit.getDefaultToolkit().getImage("res/images/chosePlane4.png");
    public static Image battle1Img = Toolkit.getDefaultToolkit().getImage("res/images/battle1.png");
    public static Image battle2Img = Toolkit.getDefaultToolkit().getImage("res/images/battle2.png");
    public static Image difficulty11Img = Toolkit.getDefaultToolkit().getImage("res/images/difficulty11.png");
    public static Image difficulty12Img = Toolkit.getDefaultToolkit().getImage("res/images/difficulty12.png");
    public static Image difficulty21Img = Toolkit.getDefaultToolkit().getImage("res/images/difficulty21.png");
    public static Image difficulty22Img = Toolkit.getDefaultToolkit().getImage("res/images/difficulty22.png");
    public static Image difficulty31Img = Toolkit.getDefaultToolkit().getImage("res/images/difficulty31.png");
    public static Image difficulty32Img = Toolkit.getDefaultToolkit().getImage("res/images/difficulty32.png");
    public static Image stateImg = Toolkit.getDefaultToolkit().getImage("res/images/state.png");
    public static Image plane1Img = Toolkit.getDefaultToolkit().getImage("res/images/plane1.png");
    public static Image plane2Img = Toolkit.getDefaultToolkit().getImage("res/images/plane2.png");
    public static Image plane3Img = Toolkit.getDefaultToolkit().getImage("res/images/plane3.png");
    public static Image plane4Img = Toolkit.getDefaultToolkit().getImage("res/images/plane4.png");
    public static Image playerBullet11Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet11.png");
    public static Image playerBullet12Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet12.png");
    public static Image playerBullet13Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet13.png");
    public static Image playerBullet21Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet21.png");
    public static Image playerBullet22Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet22.png");
    public static Image playerBullet23Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet23.png");
    public static Image playerBullet31Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet31.png");
    public static Image playerBullet32Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet32.png");
    public static Image playerBullet33Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet33.png");
    public static Image playerBullet41Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet41.png");
    public static Image playerBullet42Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet42.png");
    public static Image playerBullet43Img = Toolkit.getDefaultToolkit().getImage("res/images/playerBullet43.png");
    public static Image map1Img = Toolkit.getDefaultToolkit().getImage("res/images/map1.png");
    public static Image map2Img = Toolkit.getDefaultToolkit().getImage("res/images/map2.png");
    public static Image map3Img = Toolkit.getDefaultToolkit().getImage("res/images/map3.png");

    public static Image enemy1Img = Toolkit.getDefaultToolkit().getImage("res/images/enemy1.png");
    public static Image enemy2Img = Toolkit.getDefaultToolkit().getImage("res/images/enemy2.png");
    public static Image enemy3Img = Toolkit.getDefaultToolkit().getImage("res/images/enemy3.png");
    public static Image enemy4Img = Toolkit.getDefaultToolkit().getImage("res/images/enemy4.png");
    public static Image enemy5Img = Toolkit.getDefaultToolkit().getImage("res/images/enemy5.png");
    public static Image enemy3bulletImg = Toolkit.getDefaultToolkit().getImage("res/images/enemyBullet1.png");
    public static Image enemy4bulletImg = Toolkit.getDefaultToolkit().getImage("res/images/enemyBullet2.png");
    public static Image enemy5bulletImg = Toolkit.getDefaultToolkit().getImage("res/images/enemyBullet3.png");
    public static Image boss1Img = Toolkit.getDefaultToolkit().getImage("res/images/boss1.png");
    public static Image boss2Img = Toolkit.getDefaultToolkit().getImage("res/images/boss2.png");
    public static Image boss3Img = Toolkit.getDefaultToolkit().getImage("res/images/boss3.png");
    public static Image bossBulletImg = Toolkit.getDefaultToolkit().getImage("res/images/bossBullet.png");

    public static Image supply1DropImg = Toolkit.getDefaultToolkit().getImage("res/images/supply1Drop.png");
    public static Image supply2DropImg = Toolkit.getDefaultToolkit().getImage("res/images/supply2Drop.png");
    public static Image supply3DropImg = Toolkit.getDefaultToolkit().getImage("res/images/supply3Drop.png");
    public static Image supply4DropImg = Toolkit.getDefaultToolkit().getImage("res/images/supply4Drop.png");
    public static Image supply1Img = Toolkit.getDefaultToolkit().getImage("res/images/supply1.png");
    public static Image supply4Img = Toolkit.getDefaultToolkit().getImage("res/images/supply4.png");

    //创建我方飞机子弹的集合
    public static List<Plane1Bullet1Obj> plane1Bullet1ObjList = new ArrayList<>();
    public static List<Plane1Bullet2Obj> plane1Bullet2ObjList = new ArrayList<>();
    public static List<Plane1Bullet3Obj> plane1Bullet3ObjList = new ArrayList<>();
    public static List<Plane2Bullet1Obj> plane2Bullet1ObjList = new ArrayList<>();
    public static List<Plane2Bullet2Obj> plane2Bullet2ObjList = new ArrayList<>();
    public static List<Plane2Bullet3Obj> plane2Bullet3ObjList = new ArrayList<>();
    public static List<Plane3Bullet1Obj> plane3Bullet1ObjList = new ArrayList<>();
    public static List<Plane3Bullet2Obj> plane3Bullet2ObjList = new ArrayList<>();
    public static List<Plane3Bullet3Obj> plane3Bullet3ObjList = new ArrayList<>();
    public static List<Plane4Bullet1Obj> plane4Bullet1ObjList = new ArrayList<>();
    public static List<Plane4Bullet2Obj> plane4Bullet2ObjList = new ArrayList<>();
    public static List<Plane4Bullet3Obj> plane4Bullet3ObjList = new ArrayList<>();
    //创建敌机的集合
    public static List<Enemy1Obj> enemy1ObjList = new ArrayList<>();
    public static List<Enemy2Obj> enemy2ObjList = new ArrayList<>();
    public static List<Enemy3Obj> enemy3ObjList = new ArrayList<>();
    public static List<Enemy4Obj> enemy4ObjList = new ArrayList<>();
    public static List<Enemy5Obj> enemy5ObjList = new ArrayList<>();
    //创建敌机子弹集合
    public static List<Enemy3BulletObj> enemy3BulletObjList = new ArrayList<>();
    public static List<Enemy4BulletObj> enemy4BulletObjList = new ArrayList<>();
    public static List<Enemy5BulletObj> enemy5BulletObjList = new ArrayList<>();
    public static List<Boss1Obj> boss1ObjList = new ArrayList<>();
    public static List<Boss2Obj> boss2ObjList = new ArrayList<>();
    public static List<Boss3Obj> boss3ObjList = new ArrayList<>();
    public static List<BossBullet1Obj> bossBullet1ObjList = new ArrayList<>();
    public static List<BossBullet2Obj> bossBullet2ObjList = new ArrayList<>();
    public static List<BossBullet3Obj> bossBullet3ObjList = new ArrayList<>();
    
    public static List<Supply1DropObj> supply1DropObjList = new ArrayList<>();
    public static List<Supply2DropObj> supply2DropObjList = new ArrayList<>();
    public static List<Supply3DropObj> supply3DropObjList = new ArrayList<>();
    public static List<Supply4DropObj> supply4DropObjList = new ArrayList<>();
    public static List<Supply1Obj> supply1ObjList = new ArrayList<>();
    //所有元素的集合
    public static List<GameObj> gameObjList = new ArrayList<>();
    public static List<GameObj> removeObjList = new ArrayList<>();
    public static List<ExplosionSmallObj> explosionSmallObjList = new ArrayList<>();
    public static List<ExplosionMiddleObj> explosionMiddleObjList = new ArrayList<ExplosionMiddleObj>();
    public static List<ExplosionBigObj> explosionBigObjList = new ArrayList<>();
    //绘制文字的方法
    public static void drawWord(Graphics gImage, String str, Color color, int size, int x, int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋", Font.BOLD, size));
        gImage.drawString(str, x, y);
    }
}
