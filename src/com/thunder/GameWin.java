package com.thunder;

import com.thunder.obj.*;
import com.thunder.utils.SLTool;
import com.thunder.utils.ScoreList;
import com.thunder.utils.GameUtils;
import com.thunder.utils.MusicTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.util.*;
import java.util.List;

public class GameWin extends JFrame {
    public static int gameState=0;      //0开始菜单,1选择飞机,2游戏中,3暂停游戏,4游戏失败
    static int menuState=0;
    static int battlePressState=0;
    static int gameWidth=507, gameHeight=900;
    static int chosePlanePressState=0;
    static int noDifficulty=0;
    public static int difficulty=0;
    static int difficultyState=0;
    public static int chosePlane=1;
    public static int score=0, hitBossScore=0, bossIfLive=0, bossCome=0;
    public static int playerLevel=1;
    static int bossWidth=0;
    static int bossHeight=0;
    public static int playerAttack=2, playerBulletCd=1000, playerHp=0, ifCreatSupplyDrop=0, supplyDropNum=0;
    public static int plane1Hp=10, plane2Hp=5,plane3Hp=10,plane4Hp=5,plane4Bullet1Live=0, plane4Bullet2Live=0, plane4Bullet3Live=0;
    static int enemy3BulletNum[] = new int[100], bossBulletNum=0, ifCreatBossBullet=0;
    public static int invincibility[] = new int[2]; //0用来存是否无敌,1用来存闪烁
    public static int supply[] = new int[5], boom=0;
    public static double supplyDropX=0, supplyDropY=0, playerX=0, playerY=0;
    static int continueGameState=0, saveGameState=0, returnState=0, returnMenuState=0, tryAgainState=0;
    public static HashMap<String, Integer> scoreList = new HashMap<>();
    public static String playerName;
    //public static Iterable<? extends Map.Entry<String, Integer>> list;
    public static List<Map.Entry<String, Integer>> list = new ArrayList<>(scoreList.entrySet());
    static int overScore=0;  //是否已经统计分数

    Map1Obj map1Obj = new Map1Obj(GameUtils.map1Img,0,-900);
    Map1Obj map2Obj = new Map1Obj(GameUtils.map2Img,0,-900);
    Map1Obj map3Obj = new Map1Obj(GameUtils.map3Img,0,-900);
    Plane1Obj plane1Obj = new Plane1Obj(GameUtils.plane1Img,(int)(110*0.6),(int)(119*0.6),253.5-55,571,this);
    Plane2Obj plane2Obj = new Plane2Obj(GameUtils.plane2Img,(int)(110*0.6),(int)(115*0.6),253.5-55,571,this);
    Plane3Obj plane3Obj = new Plane3Obj(GameUtils.plane3Img,(int)(109*0.6),(int)(131*0.6),253.5-54.5,571,this);
    Plane4Obj plane4Obj = new Plane4Obj(GameUtils.plane4Img,(int)(81*0.6),(int)(106*0.6),253.5-40.5,571,this);
    Boss1Obj boss1Obj = new Boss1Obj(GameUtils.boss1Img,(int)(350*0.8),(int)(288*0.8),253.5-175,-288,this);
    Boss2Obj boss2Obj = new Boss2Obj(GameUtils.boss2Img,(int)(375*0.8),(int)(304*0.8),253.5-187.5,-304,this);
    Boss3Obj boss3Obj = new Boss3Obj(GameUtils.boss3Img,(int)(400*0.8),(int)(374*0.8),253.5-200,-374,this);
    Supply4Obj supply4Obj = new Supply4Obj(GameUtils.supply4Img,140,136,-1000,-1000,this);
    Image offScreenImage=null;
    static long[][] t0 = new long[10][200];     //计时器函数的数组
    long[][] t1 = new long[5][200];
    int init[][] = new int[5][1000];
    public void launch() throws MalformedURLException {
        this.setVisible(true);
        this.setSize(gameWidth, gameHeight);
        this.setLocationRelativeTo(null);
        this.setTitle("Thunder");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ScoreList.loadScoreList();
        GameUtils.gameObjList.add(plane1Obj);
        GameUtils.gameObjList.add(plane2Obj);
        GameUtils.gameObjList.add(plane3Obj);
        GameUtils.gameObjList.add(plane4Obj);
        GameUtils.gameObjList.add(supply4Obj);
        GameUtils.boss1ObjList.add(boss1Obj);
        GameUtils.boss2ObjList.add(boss2Obj);
        GameUtils.boss3ObjList.add(boss3Obj);
        //背景音乐
        MusicTool musicTool = new MusicTool();
        MusicTool.playMenuMusic();
        playerName = JOptionPane.showInputDialog("请输入你的昵称：");
        //鼠标移动事件
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if(gameState==0) {
                    if (e.getX() > 160 && e.getX() < 350 && e.getY() > 555 && e.getY() < 600) {       //开始游戏
                        menuState = 1;
                    } else if (e.getX() > 155 && e.getX() < 350 && e.getY() > 640 && e.getY() < 686) {    //继续游戏
                        menuState = 2;
                    } else if (e.getX() > 178 && e.getX() < 320 && e.getY() > 718 && e.getY() < 768) {        //排行榜
                        menuState = 3;
                    } else if (e.getX() > 204 && e.getX() < 298 && e.getY() > 807 && e.getY() < 845) {        //关于
                        menuState = 4;
                    } else {
                        menuState = 0;
                    }
                }
                if(gameState==1) {      //选择飞机
                    //出击按钮状态
                    if(e.getX() > 140 && e.getX() < 354 && e.getY() > 778 && e.getY() < 823) {
                        battlePressState=1;
                    }else{
                        battlePressState=0;
                    }
                    //飞机选择
                    if (e.getX() > 418 && e.getX() < 460 && e.getY() > 588 && e.getY() < 672) {
                        chosePlanePressState=1;
                    } else if (e.getX() > 36 && e.getX() < 78 && e.getY() > 588 && e.getY() < 672) {
                        chosePlanePressState=2;
                    } else{
                        chosePlanePressState=0;
                    }
                    //难度选择
                    if (e.getX() > 343 && e.getX() < 506 && e.getY() > 218 && e.getY() < 260) {
                        difficultyState=1;
                    } else if (e.getX() > 343 && e.getX() < 506 && e.getY() > 327 && e.getY() < 359) {
                        difficultyState=2;
                    } else if (e.getX() > 343 && e.getX() < 506 && e.getY() > 429 && e.getY() < 471) {
                        difficultyState=3;
                    }else{
                        difficultyState=0;
                    }
                }
                if(gameState==3) {
                    playerX=e.getX();
                    playerY=e.getY();
                }
                if(gameState==3){
                    if (e.getX() > 150 && e.getX() < 359 && e.getY() > 500 && e.getY() < 564) {
                        continueGameState=1;
                    } else if (e.getX() > 150 && e.getX() < 359 && e.getY() > 600 && e.getY() < 664) {
                        saveGameState=1;
                    } else if (e.getX() > 150 && e.getX() < 359 && e.getY() > 700 && e.getY() < 764) {
                        returnState=1;
                    }else{
                        continueGameState=saveGameState=returnState=0;
                    }
                }
                if(gameState==4){
                    if (e.getX() > 150 && e.getX() < 360 && e.getY() > 660 && e.getY() < 724) {
                        tryAgainState=1;
                    } else if (e.getX() > 150 && e.getX() < 360 && e.getY() > 760 && e.getY() < 824) {
                        returnMenuState=1;
                    } else{
                        tryAgainState=returnMenuState=0;
                    }
                }
            }
        });
        //鼠标点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gameState == 0 && e.getButton() == 1 && TimerZero(300, 0, 2)) {
                    MusicTool.playClickMusic();
                    if (menuState == 1) {        //开始游戏
                        difficulty = 0;
                        chosePlane = 1;
                        gameInit();
                        GameUtils.gameObjList.add(plane2Obj);
                        GameUtils.gameObjList.add(plane3Obj);
                        GameUtils.gameObjList.add(plane4Obj);
                        gameState = 1;
                    } else if (menuState == 2) {
                        SLTool.load();
                        gameInit();
                        gameState = 2;
                    } else if (menuState == 3) {
                        gameState = 5;
                    } else if (menuState == 4) {
                        gameState = 6;
                    }
                }
                if (gameState == 1 && e.getButton() == 1 && TimerZero(300, 0, 2)) {
                    MusicTool.playClickMusic();
                    //出击
                    if (battlePressState == 1) {
                        if (difficulty != 0) {
                            MusicTool.stopMenuMusic();
                            MusicTool.playBattleMusic();
                            MusicTool.playGoMusic();
                            gameInit();
                            battlePressState = 0;
                            gameState = 2;
                        } else {
                            noDifficulty = 1;
                        }
                    }
                    //选择难度
                    if (difficultyState == 1) {
                        difficulty = 1;
                    } else if (difficultyState == 2) {
                        difficulty = 2;
                    } else if (difficultyState == 3) {
                        difficulty = 3;
                    }
                    //选择飞机
                    if (chosePlanePressState == 1) {
                        chosePlane++;
                        plane4Bullet1Live = plane4Bullet2Live = plane4Bullet3Live = 0;
                        switch (chosePlane) {
                            case 1:
                                playerBulletCd = 1000;
                                playerAttack = 2;
                                break;
                            case 2:
                                playerBulletCd = 500;
                                playerAttack = 1;
                                break;
                            case 3:
                                playerBulletCd = 2000;
                                playerAttack = 4;
                                break;
                            case 4:
                                playerBulletCd = 800;
                                playerAttack = 1;
                                break;
                        }
                        if (playerLevel == 2) {
                            playerBulletCd /= 2;
                        } else if (playerLevel == 3) {
                            playerBulletCd /= 4;
                        }
                        if (chosePlane >= 5) {
                            chosePlane = 1;
                        }
                    } else if (chosePlanePressState == 2) {
                        chosePlane--;
                        plane4Bullet1Live = plane4Bullet2Live = plane4Bullet3Live = 0;
                        switch (chosePlane) {
                            case 1:
                                playerBulletCd = 1000;
                                playerAttack = 2;
                                break;
                            case 2:
                                playerBulletCd = 500;
                                playerAttack = 1;
                                break;
                            case 3:
                                playerBulletCd = 2000;
                                playerAttack = 4;
                                break;
                            case 4:
                                playerBulletCd = 800;
                                playerAttack = 1;
                                break;
                        }
                        if (playerLevel == 2) {
                            playerBulletCd /= 2;
                        } else if (playerLevel == 3) {
                            playerBulletCd /= 4;
                        }
                        if (chosePlane <= 0) {
                            chosePlane = 4;
                        }
                    }
                }
                if (gameState == 3 && e.getButton() == 1 && TimerZero(300, 0, 2)) {
                    MusicTool.playClickMusic();
                    if (continueGameState == 1) {
                        gameState = 2;
                    } else if (saveGameState == 1) {
                        SLTool.save();
                        gameState = 2;
                    } else if (returnState == 1) {
                        MusicTool.stopBattleMusic();
                        MusicTool.stopBossMusic();
                        MusicTool.playMenuMusic();
                        gameState = 0;
                    }
                }
                if (gameState == 4 && e.getButton() == 1 && TimerZero(300, 0, 2)) {
                    MusicTool.playClickMusic();
                    if (tryAgainState == 1) {
                        gameInit();
                        gameState = 2;
                    } else if (returnMenuState == 1) {
                        MusicTool.stopBattleMusic();
                        MusicTool.stopBossMusic();
                        MusicTool.playMenuMusic();
                        gameState = 0;
                    }
                }
                if (gameState == 5 && e.getButton() == 1 && TimerZero(300, 0, 2)) {
                    MusicTool.playClickMusic();
                    gameState = 0;
                }
                if (gameState == 6 && e.getButton() == 1 && TimerZero(300, 0, 2)) {
                    MusicTool.playClickMusic();
                    gameState = 0;
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(gameState==2) {
                    if (e.getKeyCode() == 27 && TimerZero(300, 0, 2)) {
                        MusicTool.playClickMusic();
                        gameState = 3;        //暂停游戏
                    }
                    if (e.getKeyCode() == 32 && supply[1] == 2) {
                        MusicTool.playClickMusic();
                        switch (chosePlane){
                            case 1:
                                GameUtils.supply1ObjList.get(GameUtils.supply1ObjList.size()-1).setX(plane1Obj.getX()+55-12);
                                GameUtils.supply1ObjList.get(GameUtils.supply1ObjList.size()-1).setY(plane1Obj.getY()-75);
                                break;
                            case 2:
                                GameUtils.supply1ObjList.get(GameUtils.supply1ObjList.size()-1).setX(plane2Obj.getX()+55-12);
                                GameUtils.supply1ObjList.get(GameUtils.supply1ObjList.size()-1).setY(plane2Obj.getY()-75);
                                break;
                            case 3:
                                GameUtils.supply1ObjList.get(GameUtils.supply1ObjList.size()-1).setX(plane3Obj.getX()+54.5-12);
                                GameUtils.supply1ObjList.get(GameUtils.supply1ObjList.size()-1).setY(plane3Obj.getY()-75);
                                break;
                            case 4:
                                GameUtils.supply1ObjList.get(GameUtils.supply1ObjList.size()-1).setX(plane4Obj.getX()+40.5-12);
                                GameUtils.supply1ObjList.get(GameUtils.supply1ObjList.size()-1).setY(plane4Obj.getY()-75);
                                break;
                        }
                        supply[1] = 3;        //发射炸弹
                    }
                }
                if(gameState==3) {
                    if (e.getKeyCode() == 27 && TimerZero(300, 0, 2)) {
                        MusicTool.playClickMusic();
                        gameState = 2;        //返回游戏
                    }
                }
                if(gameState==5) {
                    if(e.getKeyCode() != 0 && TimerZero(300, 0, 2)){
                        MusicTool.playClickMusic();
                        gameState=0;
                    }
                }
                if(gameState==6) {
                    if(e.getKeyCode() != 0 && TimerZero(300, 0, 2)){
                        MusicTool.playClickMusic();
                        gameState=0;
                    }
                }
            }
        });
        while(true){
            //选择飞机
            if(gameState==1){
                if(difficulty!=0){
                    noDifficulty=0;
                }
                switch (chosePlane){
                    case 1:
                        playerHp=plane1Obj.getHp();
                        break;
                    case 2:
                        playerHp=plane2Obj.getHp();
                        break;
                    case 3:
                        playerHp=plane3Obj.getHp();
                        break;
                    case 4:
                        playerHp=plane4Obj.getHp();
                        break;
                }
                //飞机子弹演示
                if(TimerOne(3000, 0, 2)){
                    score+=250;
                    if(score==750){
                        playerLevel=1;
                        playerAttack/=4;
                        playerBulletCd*=4;
                        score=0;
                    }
                }
            }
            //游戏中
            if(gameState==2){
                if (invincibility[0] == 1 && TimerZero(1000, 0, 0)) {
                    invincibility[0] = 0;		//不再闪烁
                    invincibility[1] = 0;
                }
                switch(chosePlane){
                    case 1:
                        playerHp=plane1Obj.getHp();
                        break;
                    case 2:
                        playerHp=plane2Obj.getHp();
                        break;
                    case 3:
                        playerHp=plane3Obj.getHp();
                        break;
                    case 4:
                        playerHp=plane4Obj.getHp();
                        break;
                }
/*                if(chosePlane==4){        //激光判断
                    if(TimerZero(playerBulletCd,0,3)){

                    }
                }*/
                if(boom==1){
                    if(TimerOne(1000,0,6)){
                        boom=0;
                        supply[1]=0;
                        init[0][6]=0;
                    }
                }
                if(supply[2]==1 || supply[2]==2){
                    if(supply[2]==1) {
                        playerBulletCd /= 2;
                        supply[2]=2;
                    }
                    if(TimerOne(10000,0,7)){
                        playerBulletCd*=2;
                        supply[2]=0;
                        init[0][7]=0;
                    }
                }
                if(supply[3]==1){
                    switch(chosePlane){
                        case 1:
                            plane1Obj.setHp(plane1Obj.getHp()+1);
                            break;
                        case 2:
                            plane2Obj.setHp(plane2Obj.getHp()+1);
                            break;
                        case 3:
                            plane3Obj.setHp(plane3Obj.getHp()+1);
                            break;
                        case 4:
                            plane4Obj.setHp(plane4Obj.getHp()+1);
                            break;
                    }
                    supply[3]=0;
                }
                if(supply[4]==1){
                    GameWin.invincibility[0]=2;
                    switch(chosePlane){
                        case 1:
                            supply4Obj.setX(plane1Obj.getX()+55-70);
                            supply4Obj.setY(plane1Obj.getY()+59.5-68);
                            break;
                        case 2:
                            supply4Obj.setX(plane2Obj.getX()+55-70);
                            supply4Obj.setY(plane2Obj.getY()+57.5-68);
                            break;
                        case 3:
                            supply4Obj.setX(plane3Obj.getX()+54.5-70);
                            supply4Obj.setY(plane3Obj.getY()+65.5-68);
                            break;
                        case 4:
                            supply4Obj.setX(plane4Obj.getX()+40.5-70);
                            supply4Obj.setY(plane4Obj.getY()+53-68);
                            break;
                    }
                    if(TimerOne(10000,0,8)){
                        GameWin.invincibility[0]=0;
                        supply[4]=0;
                        init[0][8]=0;
                    }
                }
            }
            //游戏暂停
            //游戏结束
            if(gameState==4) {
                if(overScore==0){
                    scoreList.put(playerName,score);
                    list.removeAll(list);
                    int mapI=0;
                    for(Map.Entry<String, Integer> entry : scoreList.entrySet()){
                        list.add(mapI++,entry);
                    }
                    list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));    // 按分数从大到小排序
                    ScoreList.saveScoreList();
                    overScore=1;
                }
            }
            //飞机升级
            if(score>=100 && playerLevel==1) {
                playerLevel=2;
                playerAttack*=2;
                playerBulletCd/=2;
            }
            if(score>=500 && playerLevel==2){
                playerLevel=3;
                playerAttack*=2;
                playerBulletCd/=2;
            }
            repaint();      //调用paint函数
            try {
                Thread.sleep(16);       //60Hz
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        //初始化
        if(offScreenImage==null){
            offScreenImage=createImage(gameWidth, gameHeight);
        }
        //获取双缓存图片对象画笔
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0,0,gameWidth, gameHeight);
        //开始菜单
        if(gameState==0) {
            gImage.drawImage(GameUtils.chosePlaneBackgroundImg, 0, 0, null);       //先画一遍,防止卡顿
            gImage.drawImage(GameUtils.scoreListImg, 0, 0, null);
            gImage.drawImage(GameUtils.aboutImg, 0, 0, null);
            gImage.drawImage(GameUtils.menu2Img, 0, 0, null);
            gImage.drawImage(GameUtils.menu3Img, 0, 0, null);
            gImage.drawImage(GameUtils.menu4Img, 0, 0, null);
            gImage.drawImage(GameUtils.menu5Img, 0, 0, null);
            gImage.drawImage(GameUtils.menu1Img, 0, 0, null);
            gImage.drawImage(GameUtils.chosePlane1Img, 0, 0, null);
            gImage.drawImage(GameUtils.chosePlane2Img, 0, 0, null);
            gImage.drawImage(GameUtils.chosePlane3Img, 0, 0, null);
            gImage.drawImage(GameUtils.chosePlane4Img, 0, 0, null);
            switch(menuState){
                case 1:
                    gImage.drawImage(GameUtils.menu2Img, 0, 0, null);
                    break;
                case 2:
                    gImage.drawImage(GameUtils.menu3Img, 0, 0, null);
                    break;
                case 3:
                    gImage.drawImage(GameUtils.menu4Img, 0, 0, null);
                    break;
                case 4:
                    gImage.drawImage(GameUtils.menu5Img, 0, 0, null);
                    break;
                default:
                    gImage.drawImage(GameUtils.menu1Img, 0, 0, null);
                    break;
            }
        }
        //选择飞机
        if(gameState==1){
            gImage.drawImage(GameUtils.chosePlaneBackgroundImg, 0, 0, null);
            if(battlePressState==1){
                gImage.drawImage(GameUtils.battle2Img, 137, 785, null);
            }else{
                gImage.drawImage(GameUtils.battle1Img, 137, 779, null);
            }
            if(chosePlane==1){
                gImage.drawImage(GameUtils.chosePlane1Img, 0, 0, null);
            }else if (chosePlane==2){
                gImage.drawImage(GameUtils.chosePlane2Img, 0, 0, null);
            }else if (chosePlane==3){
                gImage.drawImage(GameUtils.chosePlane3Img, 0, 0, null);
            }else if (chosePlane==4){
                gImage.drawImage(GameUtils.chosePlane4Img, 0, 0, null);
            }
            if(difficulty!=1) {
                gImage.drawImage(GameUtils.difficulty11Img, 343, 200, null);
            }
            if(difficulty!=2) {
                gImage.drawImage(GameUtils.difficulty21Img, 343, 306, null);
            }
            if(difficulty!=3) {
                gImage.drawImage(GameUtils.difficulty31Img, 343, 412, null);
            }
            if(difficultyState==1 || difficulty==1){
                gImage.drawImage(GameUtils.difficulty12Img, 343, 200, null);
            }
            if (difficultyState==2 || difficulty==2){
                gImage.drawImage(GameUtils.difficulty22Img, 343, 306, null);
            }
            if (difficultyState==3 || difficulty==3){
                gImage.drawImage(GameUtils.difficulty32Img, 343, 412, null);
            }
            creatPlayerObj();
            for(int i = 0; i < GameUtils.gameObjList.size(); i++){
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            if(noDifficulty==1){
                GameUtils.drawWord(gImage,"请先选择难度", Color.yellow,20,190,750);
            }
            //演示子弹的伤害存在问题,但不影响游戏,懒得修
        }
        //游戏中
        if(gameState==2){
            //爆炸集合
/*            for(int i = 0; i < GameUtils.explosionObjList.size()-1; i++){
                GameUtils.explosionObjList.get(i).paintSelf(gImage);
            }*/
            creatPlayerObj();
            creatEnemyObj();
            creatBossObj();
            creatSupply();
            if(supply[1]==1){       //0为获得炸弹,1时创建对象,2时可发射炸弹,3炸弹发射
                GameUtils.supply1ObjList.add(new Supply1Obj(GameUtils.supply1Img,24,75,0,52,this));
                supply[1]=2;
            }
            GameUtils.gameObjList.addAll(GameUtils.explosionSmallObjList);
            GameUtils.gameObjList.addAll(GameUtils.explosionMiddleObjList);
            GameUtils.gameObjList.addAll(GameUtils.explosionBigObjList);
            //除爆炸外的元素集合
            for(int i = 0; i < GameUtils.gameObjList.size(); i++){
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.plane4Bullet1ObjList.size(); i++){
                GameUtils.plane4Bullet1ObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.plane4Bullet2ObjList.size(); i++){
                GameUtils.plane4Bullet2ObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.plane4Bullet3ObjList.size(); i++){
                GameUtils.plane4Bullet3ObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.plane4Bullet3ObjList.size(); i++){
                GameUtils.plane4Bullet3ObjList.get(i).paintSelf(gImage);
            }
            //将要移除的元素删除
            GameUtils.gameObjList.removeAll(GameUtils.removeObjList);
            //绘制炸弹和护盾以及掉落物
            for(int i = 0; i < GameUtils.supply1ObjList.size(); i++){
                GameUtils.supply1ObjList.get(i).paintSelf(gImage);
            }
            if(supply[4]==1) {
                supply4Obj.paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.supply1DropObjList.size(); i++){
                GameUtils.supply1DropObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.supply2DropObjList.size(); i++){
                GameUtils.supply2DropObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.supply3DropObjList.size(); i++){
                GameUtils.supply3DropObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.supply4DropObjList.size(); i++){
                GameUtils.supply4DropObjList.get(i).paintSelf(gImage);
            }
            //绘制状态栏
            gImage.drawImage(GameUtils.stateImg, 0, 30, null);
            GameUtils.drawWord(gImage,""+score, Color.yellow,20,410,53);
        }
        if(gameState==3){       //暂停
            for(int i = 0; i < GameUtils.gameObjList.size()-1; i++){
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.supply1ObjList.size(); i++){
                GameUtils.supply1ObjList.get(i).paintSelf(gImage);
            }
            if(supply[4]==1) {
                supply4Obj.paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.supply1DropObjList.size(); i++){
                GameUtils.supply1DropObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.supply2DropObjList.size(); i++){
                GameUtils.supply2DropObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.supply3DropObjList.size(); i++){
                GameUtils.supply3DropObjList.get(i).paintSelf(gImage);
            }
            for(int i = 0; i < GameUtils.supply4DropObjList.size(); i++){
                GameUtils.supply4DropObjList.get(i).paintSelf(gImage);
            }
            //绘制状态栏
            gImage.drawImage(GameUtils.stateImg, 0, 30, null);
            GameUtils.drawWord(gImage,""+score, Color.yellow,20,410,53);
            if(continueGameState==1){
                gImage.drawImage(GameUtils.continueGame2Img,150,500,null);
            }else{
                gImage.drawImage(GameUtils.continueGame1Img,150,500,null);
            }
            if(saveGameState==1){
                gImage.drawImage(GameUtils.saveGame2Img,150,600,null);
            }else{
                gImage.drawImage(GameUtils.saveGame1Img,150,600,null);
            }
            if(returnState==1){
                gImage.drawImage(GameUtils.return2Img,150,700,null);
            }else{
                gImage.drawImage(GameUtils.return1Img,150,700,null);
            }
            gImage.drawImage(GameUtils.gameStopImg, 0, 0, null);
        }
        if(gameState==4){       //游戏结束
            gImage.drawImage(GameUtils.gameOverImg, 0, 0, null);
            GameUtils.drawWord(gImage,""+score, Color.yellow,60,139,270);
            if(tryAgainState==1){
                gImage.drawImage(GameUtils.tryAgain2Img,150,660,null);
            }else{
                gImage.drawImage(GameUtils.tryAgain1Img,150,660,null);
            }
            if(returnMenuState==1){
                gImage.drawImage(GameUtils.returnMenu2Img,150,760,null);
            }else{
                gImage.drawImage(GameUtils.returnMenu1Img,150,760,null);
            }
        }
        if(gameState==5){       //排行榜
            gImage.drawImage(GameUtils.scoreListImg, 0, 0, null);
            ScoreList.readScoreList(gImage);
        }
        if(gameState==6){       //关于
            gImage.drawImage(GameUtils.aboutImg, 0, 0, null);
        }
        //将双缓存图片绘制在游戏窗口
        g.drawImage(offScreenImage,0,0,null);
    }
    //批量创建物体的方法
    void creatPlayerObj(){
        //创建玩家子弹
        if(TimerOne(playerBulletCd, 0, 1)) {
            if(chosePlane==1) {
                if (playerLevel == 1) {
                    GameUtils.plane1Bullet1ObjList.add(new Plane1Bullet1Obj(GameUtils.playerBullet11Img, 13, 86, plane1Obj.getX() + 55 - 6.5, plane1Obj.getY() - 83, this));
                    GameUtils.gameObjList.add(GameUtils.plane1Bullet1ObjList.get(GameUtils.plane1Bullet1ObjList.size() - 1));//把新new出来的子弹对象添加到所有元素集合中
                }else if (playerLevel == 2) {
                    GameUtils.plane1Bullet2ObjList.add(new Plane1Bullet2Obj(GameUtils.playerBullet12Img, 47, 100, plane1Obj.getX() + 55 - 23.5, plane1Obj.getY() - 97, this));
                    GameUtils.gameObjList.add(GameUtils.plane1Bullet2ObjList.get(GameUtils.plane1Bullet2ObjList.size() - 1));
                }else if (playerLevel == 3) {
                    GameUtils.plane1Bullet3ObjList.add(new Plane1Bullet3Obj(GameUtils.playerBullet13Img, 80, 117, plane1Obj.getX() + 55 - 40, plane1Obj.getY() - 114, this));
                    GameUtils.gameObjList.add(GameUtils.plane1Bullet3ObjList.get(GameUtils.plane1Bullet3ObjList.size() - 1));
                }
            }else if(chosePlane==2){
                if (playerLevel == 1) {
                    GameUtils.plane2Bullet1ObjList.add(new Plane2Bullet1Obj(GameUtils.playerBullet21Img, 20, 92, plane2Obj.getX() + 55 - 10, plane2Obj.getY() - 89, this));
                    GameUtils.gameObjList.add(GameUtils.plane2Bullet1ObjList.get(GameUtils.plane2Bullet1ObjList.size() - 1));//把新new出来的子弹对象添加到所有元素集合中
                }else if (playerLevel == 2) {
                    GameUtils.plane2Bullet2ObjList.add(new Plane2Bullet2Obj(GameUtils.playerBullet22Img, 35, 93, plane2Obj.getX() + 55 - 17.5, plane2Obj.getY() - 90, this));
                    GameUtils.gameObjList.add(GameUtils.plane2Bullet2ObjList.get(GameUtils.plane2Bullet2ObjList.size() - 1));
                }else if (playerLevel == 3) {
                    GameUtils.plane2Bullet3ObjList.add(new Plane2Bullet3Obj(GameUtils.playerBullet23Img, 80, 118, plane2Obj.getX() + 55 - 40, plane2Obj.getY() - 115, this));
                    GameUtils.gameObjList.add(GameUtils.plane2Bullet3ObjList.get(GameUtils.plane2Bullet3ObjList.size() - 1));
                }
            }else if(chosePlane==3){
                if (playerLevel == 1) {
                    GameUtils.plane3Bullet1ObjList.add(new Plane3Bullet1Obj(GameUtils.playerBullet31Img, 17, 75, plane3Obj.getX() + 54.5 - 8.5, plane3Obj.getY() - 72, this));
                    GameUtils.gameObjList.add(GameUtils.plane3Bullet1ObjList.get(GameUtils.plane3Bullet1ObjList.size() - 1));//把新new出来的子弹对象添加到所有元素集合中
                }else if (playerLevel == 2) {
                    GameUtils.plane3Bullet2ObjList.add(new Plane3Bullet2Obj(GameUtils.playerBullet32Img, 44, 104, plane3Obj.getX() + 54.5 - 22, plane3Obj.getY() - 101, this));
                    GameUtils.gameObjList.add(GameUtils.plane3Bullet2ObjList.get(GameUtils.plane3Bullet2ObjList.size() - 1));
                }else if (playerLevel == 3) {
                    GameUtils.plane3Bullet3ObjList.add(new Plane3Bullet3Obj(GameUtils.playerBullet33Img, 80, 136, plane3Obj.getX() + 54.5 - 40, plane3Obj.getY() - 133, this));
                    GameUtils.gameObjList.add(GameUtils.plane3Bullet3ObjList.get(GameUtils.plane3Bullet3ObjList.size() - 1));
                }
            }else if(chosePlane==4){
                if (playerLevel == 1 && plane4Bullet1Live==0) {
                    if(plane4Bullet3Live==1) {
                        plane4Bullet3Live=0;
                    }
                    GameUtils.plane4Bullet1ObjList.add(new Plane4Bullet1Obj(GameUtils.playerBullet41Img, 31, 900, plane4Obj.getX() + 40.5 - 15.5, plane4Obj.getY() - 897, this));
                    GameUtils.gameObjList.add(GameUtils.plane4Bullet1ObjList.get(GameUtils.plane4Bullet1ObjList.size() - 1));//把新new出来的子弹对象添加到所有元素集合中
                    plane4Bullet1Live=1;
                }else if (playerLevel == 2 && plane4Bullet2Live==0) {
                    GameUtils.plane4Bullet2ObjList.add(new Plane4Bullet2Obj(GameUtils.playerBullet42Img, 36, 100, plane4Obj.getX() + 40.5 - 16.5, plane4Obj.getY() - 897, this));
                    GameUtils.gameObjList.add(GameUtils.plane4Bullet2ObjList.get(GameUtils.plane4Bullet2ObjList.size() - 1));
                    plane4Bullet1Live=0;
                    plane4Bullet2Live=1;
                }else if (playerLevel == 3 && plane4Bullet3Live==0) {
                    GameUtils.plane4Bullet3ObjList.add(new Plane4Bullet3Obj(GameUtils.playerBullet43Img, 46, 117, plane4Obj.getX() + 40.5 - 21.5, plane4Obj.getY() - 897, this));
                    GameUtils.gameObjList.add(GameUtils.plane4Bullet3ObjList.get(GameUtils.plane4Bullet3ObjList.size() - 1));
                    plane4Bullet2Live=0;
                    plane4Bullet3Live=1;
                }
            }
        }
    }
    void creatEnemyObj(){
        //生成敌机
        if(TimerOne(1000, 0, 0) && bossIfLive==0) {
            if(Math.random()*100>0 && Math.random()*100<10) {     //百分之十的概率产生敌机三
                GameUtils.enemy3ObjList.add(new Enemy3Obj(GameUtils.enemy3Img, 126, 116, (Math.random() * (gameWidth-126)), -116,  this));
                GameUtils.gameObjList.add(GameUtils.enemy3ObjList.get(GameUtils.enemy3ObjList.size() - 1));
            }
            else if(Math.random()*100>0 && Math.random()*100<20){     //百分之二十的概率产生敌机三
                GameUtils.enemy2ObjList.add(new Enemy2Obj(GameUtils.enemy2Img, 102, 100, (Math.random() * (gameWidth-102)), -100,  this));
                GameUtils.gameObjList.add(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size() - 1));
            }
            else {
                GameUtils.enemy1ObjList.add(new Enemy1Obj(GameUtils.enemy1Img, 65, 50, (Math.random() * (gameWidth-65)) , -50, this));
                GameUtils.gameObjList.add(GameUtils.enemy1ObjList.get(GameUtils.enemy1ObjList.size() - 1));
            }
            if (difficulty >= 2) {
                if (Math.random()*100>0 && Math.random()*100<=3 || (score%100==0 && score!=0 && Math.random()<=0.5)){		//类型三的飞机
                    GameUtils.enemy4ObjList.add(new Enemy4Obj(GameUtils.enemy4Img, 150, 110, (Math.random() * (gameWidth-150)), -110,  this));
                    GameUtils.gameObjList.add(GameUtils.enemy4ObjList.get(GameUtils.enemy4ObjList.size() - 1));
                }
                if (score > 1000) {			//到达一千分加大刷新高级敌机概率
                    if (Math.random()*100>=0 && Math.random()*100<=6 || (score%100==0 && score!=0 && Math.random()<=0.5)){		//类型三的飞机
                        GameUtils.enemy4ObjList.add(new Enemy4Obj(GameUtils.enemy4Img, 150, 110, (Math.random() * (gameWidth-150)), -110,  this));
                        GameUtils.gameObjList.add(GameUtils.enemy4ObjList.get(GameUtils.enemy4ObjList.size() - 1));
                    }
                }
                if (difficulty == 3) {
                    if (Math.random()*100>=0 && Math.random()*100<=2 || (score%200==0 && score!=0 && Math.random()<=0.5)){		//类型四的飞机
                        GameUtils.enemy5ObjList.add(new Enemy5Obj(GameUtils.enemy5Img, 150, 200, Math.random()>0.5?-150:gameWidth+150, 160,  this));
                        GameUtils.gameObjList.add(GameUtils.enemy5ObjList.get(GameUtils.enemy5ObjList.size() - 1));
                    }
                    if (score > 1000) {
                        if (Math.random()*100>=0 && Math.random()*100<=4 || (score%200==0 && score!=0 && Math.random()<=0.5)){		//类型四的飞机
                            GameUtils.enemy5ObjList.add(new Enemy5Obj(GameUtils.enemy5Img, 150, 200, Math.random()>0.5?-150:gameWidth+150, 160,  this));
                            GameUtils.gameObjList.add(GameUtils.enemy5ObjList.get(GameUtils.enemy5ObjList.size() - 1));
                        }
                    }
                }
            }
        }
        //生成敌机子弹
        for(Enemy3Obj enemy3Obj: GameUtils.enemy3ObjList){
            if(TimerOne(1000,1,GameUtils.enemy3ObjList.indexOf(enemy3Obj))){
                double x = (GameUtils.enemy3ObjList.get(GameUtils.enemy3ObjList.indexOf(enemy3Obj))).getX()+63-6.5;
                double y = (GameUtils.enemy3ObjList.get(GameUtils.enemy3ObjList.indexOf(enemy3Obj))).getY()+116;
                GameUtils.enemy3BulletObjList.add(new Enemy3BulletObj(GameUtils.enemy3bulletImg, 13, 30, x, y, this));
                GameUtils.gameObjList.add(GameUtils.enemy3BulletObjList.get(GameUtils.enemy3BulletObjList.size() - 1));//把新new出来的子弹对象添加到所有元素集合中
            }
        }
        for(Enemy4Obj enemy4Obj: GameUtils.enemy4ObjList){
            if(TimerOne(2000,2,GameUtils.enemy4ObjList.indexOf(enemy4Obj))){
                double x = (GameUtils.enemy4ObjList.get(GameUtils.enemy4ObjList.indexOf(enemy4Obj))).getX()+Math.random()*(150-13);
                double y = (GameUtils.enemy4ObjList.get(GameUtils.enemy4ObjList.indexOf(enemy4Obj))).getY()+110;
                GameUtils.enemy4BulletObjList.add(new Enemy4BulletObj(GameUtils.enemy4bulletImg, 20, 40, x, y, this));
                GameUtils.gameObjList.add(GameUtils.enemy4BulletObjList.get(GameUtils.enemy4BulletObjList.size() - 1));
            }
        }
        for(Enemy5Obj enemy5Obj: GameUtils.enemy5ObjList){
            if(TimerOne(100,3,GameUtils.enemy5ObjList.indexOf(enemy5Obj)) && ((      //并且站稳了才发射子弹
                    (GameUtils.enemy5ObjList.get(GameUtils.enemy5ObjList.indexOf(enemy5Obj))).getX() >= 0.2 * 150 ) &&
                    (GameUtils.enemy5ObjList.get(GameUtils.enemy5ObjList.indexOf(enemy5Obj))).getX() <= gameWidth - 1.2 * 150)){
                enemy3BulletNum[GameUtils.enemy5ObjList.indexOf(enemy5Obj)]++;      //该敌机子弹数量自增
                enemy3BulletNum[GameUtils.enemy5ObjList.indexOf(enemy5Obj)]%=12;
                double x = (GameUtils.enemy5ObjList.get(GameUtils.enemy5ObjList.indexOf(enemy5Obj))).getX()+75-10;
                double y = (GameUtils.enemy5ObjList.get(GameUtils.enemy5ObjList.indexOf(enemy5Obj))).getY()+200;
                GameUtils.enemy5BulletObjList.add(new Enemy5BulletObj(GameUtils.enemy5bulletImg, 20, 22, x, y, enemy3BulletNum[GameUtils.enemy5ObjList.indexOf(enemy5Obj)], this));
                GameUtils.gameObjList.add(GameUtils.enemy5BulletObjList.get(GameUtils.enemy5BulletObjList.size() - 1));
            }
        }
    }
    void creatBossObj(){
        if((score-hitBossScore)%1000>=950 && (score-hitBossScore)%1000<=1000 && score!=0 && bossIfLive==0){
            MusicTool.stopBattleMusic();
            MusicTool.playWarningMusic();
            MusicTool.playBossMusic();
            if(difficulty==1){
                bossCome=1;
                bossWidth=350;
                bossHeight=288;
                GameUtils.gameObjList.add(boss1Obj);
            }else if(difficulty==2){
                bossCome=2;
                bossWidth=375;
                bossHeight=304;
                GameUtils.gameObjList.add(boss2Obj);
            }else if(difficulty==3){
                bossCome=3;
                bossWidth=400;
                bossHeight=374;
                GameUtils.gameObjList.add(boss3Obj);
            }
            bossIfLive=1;
        }
        //创建BOSS子弹
        if(TimerOne(10000, 0, 4))
        {
            if(difficulty == 1 && boss1Obj.getY()>=0){
                ifCreatBossBullet=1;
            }else if(difficulty == 2 && boss2Obj.getY()>=0){
                if(Math.random()*100 >= 0 && Math.random()*100 <= 50) {
                    ifCreatBossBullet=1;
                }
                else{
                    ifCreatBossBullet=2;
                }
            }else if(difficulty == 3 && boss3Obj.getY()>=0){
                if(Math.random()*100 >= 0 && Math.random()*100 <= 30){
                    ifCreatBossBullet=1;
                }else if(Math.random()*100 >= 0 && Math.random()*100 <= 50) {
                    ifCreatBossBullet=2;
                }
                else{
                    ifCreatBossBullet=3;
                }
            }
        }
        if(ifCreatBossBullet==1 && TimerOne(800,0,5)) {
            bossBulletNum++;      //该BOSS子弹数量自增
            if(bossBulletNum>=3){
                bossBulletNum=0;
                ifCreatBossBullet=0;
            }
            for(int i=0;i<(int)(Math.random()*7)+3;i++){      //每次发射三到十发子弹
                double x = Math.random() * (bossWidth - 40) + (gameWidth - bossWidth) / 2;
                double y = bossHeight*0.8;
                GameUtils.bossBullet1ObjList.add(new BossBullet1Obj(GameUtils.bossBulletImg, 40, 39, x, y, this));
                GameUtils.gameObjList.add(GameUtils.bossBullet1ObjList.get(GameUtils.bossBullet1ObjList.size() - 1));
            }
        }
        if(ifCreatBossBullet==2 && TimerOne(100,0,5)) {
            bossBulletNum++;      //该BOSS子弹数量自增
            if(bossBulletNum>=16){
                bossBulletNum=0;
                ifCreatBossBullet=0;
            }
            double x = gameWidth/2 - 20;      //减去子弹宽度的一半
            double y = bossHeight;       //修正位置
            GameUtils.bossBullet2ObjList.add(new BossBullet2Obj(GameUtils.bossBulletImg, 40, 39, x, y, bossBulletNum, this));
            GameUtils.gameObjList.add(GameUtils.bossBullet2ObjList.get(GameUtils.bossBullet2ObjList.size() - 1));
        }
        if(ifCreatBossBullet==3 && TimerOne(100,0,5)) {
            bossBulletNum++;      //该BOSS子弹数量自增
            if(bossBulletNum>=48){
                bossBulletNum=0;
                ifCreatBossBullet=0;
            }
            double x = gameWidth/2 - 25;      //修正位置
            double y = bossHeight-6;
            GameUtils.bossBullet3ObjList.add(new BossBullet3Obj(GameUtils.bossBulletImg, 40, 39, x, y, bossBulletNum%24, this));
            GameUtils.gameObjList.add(GameUtils.bossBullet3ObjList.get(GameUtils.bossBullet3ObjList.size() - 1));
        }
    }
    void creatSupply(){
        if(ifCreatSupplyDrop==1) {
            switch (supplyDropNum) {
                case 1:
                    GameUtils.supply1DropObjList.add(new Supply1DropObj(GameUtils.supply1DropImg, 60, 65, supplyDropX, supplyDropY, this));
                    break;
                case 2:
                    GameUtils.supply2DropObjList.add(new Supply2DropObj(GameUtils.supply2DropImg, 60, 65, supplyDropX, supplyDropY, this));
                    break;
                case 3:
                    GameUtils.supply3DropObjList.add(new Supply3DropObj(GameUtils.supply3DropImg, 60, 65, supplyDropX, supplyDropY, this));
                    break;
                case 4:
                    GameUtils.supply4DropObjList.add(new Supply4DropObj(GameUtils.supply4DropImg, 60, 65, supplyDropX, supplyDropY, this));
                    break;
            }
            ifCreatSupplyDrop=0;
        }
    }
    void gameInit(){
        GameUtils.gameObjList.removeAll(GameUtils.gameObjList);
        GameUtils.removeObjList.removeAll(GameUtils.removeObjList);
        GameUtils.plane1Bullet1ObjList.removeAll(GameUtils.plane1Bullet1ObjList);
        GameUtils.plane1Bullet2ObjList.removeAll(GameUtils.plane1Bullet2ObjList);
        GameUtils.plane1Bullet3ObjList.removeAll(GameUtils.plane1Bullet3ObjList);
        GameUtils.plane2Bullet1ObjList.removeAll(GameUtils.plane2Bullet1ObjList);
        GameUtils.plane2Bullet2ObjList.removeAll(GameUtils.plane2Bullet2ObjList);
        GameUtils.plane2Bullet3ObjList.removeAll(GameUtils.plane2Bullet3ObjList);
        GameUtils.plane3Bullet1ObjList.removeAll(GameUtils.plane3Bullet1ObjList);
        GameUtils.plane3Bullet2ObjList.removeAll(GameUtils.plane3Bullet2ObjList);
        GameUtils.plane3Bullet3ObjList.removeAll(GameUtils.plane3Bullet3ObjList);
        GameUtils.plane4Bullet1ObjList.removeAll(GameUtils.plane4Bullet1ObjList);
        GameUtils.plane4Bullet2ObjList.removeAll(GameUtils.plane4Bullet2ObjList);
        GameUtils.plane4Bullet3ObjList.removeAll(GameUtils.plane4Bullet3ObjList);
        GameUtils.enemy1ObjList.removeAll(GameUtils.enemy1ObjList);
        GameUtils.enemy2ObjList.removeAll(GameUtils.enemy2ObjList);
        GameUtils.enemy3ObjList.removeAll(GameUtils.enemy3ObjList);
        GameUtils.enemy4ObjList.removeAll(GameUtils.enemy4ObjList);
        GameUtils.enemy5ObjList.removeAll(GameUtils.enemy5ObjList);
        GameUtils.enemy3BulletObjList.removeAll(GameUtils.enemy3BulletObjList);
        GameUtils.enemy4BulletObjList.removeAll(GameUtils.enemy4BulletObjList);
        GameUtils.enemy5BulletObjList.removeAll(GameUtils.enemy5BulletObjList);
        GameUtils.boss1ObjList.removeAll(GameUtils.boss1ObjList);
        GameUtils.boss2ObjList.removeAll(GameUtils.boss2ObjList);
        GameUtils.boss3ObjList.removeAll(GameUtils.boss3ObjList);
        GameUtils.bossBullet1ObjList.removeAll(GameUtils.bossBullet1ObjList);
        GameUtils.bossBullet2ObjList.removeAll(GameUtils.bossBullet2ObjList);
        GameUtils.bossBullet3ObjList.removeAll(GameUtils.bossBullet3ObjList);
        GameUtils.supply1DropObjList.removeAll(GameUtils.supply1DropObjList);
        GameUtils.supply2DropObjList.removeAll(GameUtils.supply2DropObjList);
        GameUtils.supply3DropObjList.removeAll(GameUtils.supply3DropObjList);
        GameUtils.supply4DropObjList.removeAll(GameUtils.supply4DropObjList);
        GameUtils.supply1ObjList.removeAll(GameUtils.supply1ObjList);
        GameUtils.gameObjList.add(supply4Obj);
        score = 0;
        overScore = 0;
        playerLevel = 1;
        plane4Bullet1Live=0;
        plane4Bullet2Live=0;
        plane4Bullet3Live=0;
        switch (difficulty) {
            case 1:
                GameUtils.boss1ObjList.add(boss1Obj);
                GameUtils.gameObjList.add(map1Obj);
                break;
            case 2:
                GameUtils.boss2ObjList.add(boss2Obj);
                GameUtils.gameObjList.add(map2Obj);
                break;
            case 3:
                GameUtils.boss3ObjList.add(boss3Obj);
                GameUtils.gameObjList.add(map3Obj);
                break;
            default:
                break;
        }
        switch (chosePlane) {
            case 1:
                GameUtils.gameObjList.add(plane1Obj);
                plane1Obj.setHp(plane1Hp);
                playerBulletCd = 900;
                playerAttack = 2;
                break;
            case 2:
                GameUtils.gameObjList.add(plane2Obj);
                plane2Obj.setHp(plane2Hp);
                playerBulletCd = 500;
                playerAttack = 1;
                break;
            case 3:
                GameUtils.gameObjList.add(plane3Obj);
                plane3Obj.setHp(plane3Hp);
                playerBulletCd = 1600;
                playerAttack = 4;
                break;
            case 4:
                GameUtils.gameObjList.add(plane4Obj);
                plane4Obj.setHp(plane4Hp);
                playerBulletCd = 600;
                playerAttack = 1;
                break;
            default:
                break;
        }
    }
    //计时器函数
    public static boolean TimerZero(int ms, int i, int id){//定时器，i=0为总，id=0和1为玩家短暂无敌,2为防止鼠标连点,3为激光子弹判断
        if(System.currentTimeMillis()-t0[i][id] > ms){
            t0[i][id]=System.currentTimeMillis();
            return true;
        }
        return false;
    }
    boolean TimerOne(int ms, int i, int id){//i=0为总,1为敌机三子弹，2为敌机四子弹,3为敌机四子弹;id=0为创建敌机,1为玩家子弹发射,2为演示子弹发射，4和5为BOSS子弹发射,6为炸弹爆炸,7为狂暴持续时间,8为护盾持续时间,9为保存游戏
        if(init[i][id]==0){
            t1[i][id]=System.currentTimeMillis();
            init[i][id]=1;
        }
        if(System.currentTimeMillis()-t1[i][id] > ms){
            t1[i][id]=System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws MalformedURLException {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
//激光战机
//可以改进的地方
//代码换成函数    运算直接用结果,公式写到注释上     排行榜内容居中对齐
//存在暂停时计时器不暂停的bug
//激光战机备选方案：1、采用一定时间只能打固定量伤害  2、