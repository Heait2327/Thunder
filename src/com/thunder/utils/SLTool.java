package com.thunder.utils;

import com.thunder.GameWin;

import java.awt.*;
import java.io.*;
import java.util.regex.*;

public class SLTool {
    static String filePath = "data.txt";
    public static void save() {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // 写入数据到文件
            writer.write("@player\n");
            writer.write("x = "+GameWin.playerX+"\n");
            writer.write("y = "+GameWin.playerY+"\n");
            writer.write("hp = "+GameWin.playerHp+"\n");
            writer.write("playerLevel = "+GameWin.playerLevel+"\n");
            writer.write("playerAttack = "+GameWin.playerAttack+"\n");
            writer.write("playerBulletCd = "+GameWin.playerBulletCd+"\n");
            writer.write("@otherData\n");
            writer.write("chosePlane = "+GameWin.chosePlane+"\n");
            writer.write("difficulty = "+GameWin.difficulty+"\n");
            writer.write("score = "+GameWin.score+"\n");
            writer.write("hitBossScore = "+GameWin.hitBossScore+"\n");
            writer.write("BossIfLive = "+GameWin.bossIfLive+"\n");
            writer.write("bossCome = "+GameWin.bossCome+"\n");
            writer.write("plane4Bullet1Live = "+GameWin.plane4Bullet1Live+"\n");
            writer.write("plane4Bullet2Live = "+GameWin.plane4Bullet2Live+"\n");
            writer.write("plane4Bullet3Live = "+GameWin.plane4Bullet3Live+"\n");
            // 关闭writer对象
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void load() {
        //Pattern pattern = Pattern.compile("^\\s*(.*?)\\s*(-?\\d+(\\.\\d+)?)\\s*$");
        //Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        //Pattern pattern = Pattern.compile("^\\s*\"(.*?)\",\\s*(\\d+(?:\\.\\d+)?)\\s*$");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int intData;
            double doubleData;
            String line;
            Matcher matcher;
            String dataStr;

            reader.readLine();       //吃掉@player

            line = reader.readLine();
            String[] tokens = line.split(" ");
            doubleData = Double.parseDouble(tokens[2]);
            GameWin.playerX = doubleData;
            line = reader.readLine();
            tokens = line.split(" ");
            doubleData = Double.parseDouble(tokens[2]);
            GameWin.playerY = doubleData;
            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.playerHp = intData;
            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.playerLevel = intData;
            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.playerAttack = intData;
            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.playerBulletCd = intData;

            reader.readLine();       //吃掉@otherData

            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.chosePlane = intData;            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.difficulty = intData;            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.score = intData;            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.hitBossScore = intData;            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.bossIfLive = intData;            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.bossCome = intData;            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.plane4Bullet1Live = intData;            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.plane4Bullet2Live = intData;            line = reader.readLine();
            tokens = line.split(" ");
            intData = Integer.parseInt(tokens[2]);
            GameWin.plane4Bullet3Live = intData;
            } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
