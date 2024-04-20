package com.thunder.utils;

import com.thunder.GameWin;

import java.awt.*;
import java.io.*;
import java.util.Map;
import java.util.regex.*;

public class ScoreList {
    static String filePath = "scoreList.txt";
    public static void loadScoreList() {
        Pattern pattern = Pattern.compile("^\\s*(.*?)\\s*(\\d+)\\s*$");
        int No=1;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if(matcher.matches()) {
                    String[] tokens = line.split(" ");
                    String name = tokens[0];
                    int score = Integer.parseInt(tokens[1]);
                    GameWin.scoreList.put(name,score);
                    No++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //GameWin.list=GameWin.scoreList;
    }
    public static void readScoreList(Graphics gImage) {
        Pattern pattern = Pattern.compile("^\\s*(.*?)\\s*(\\d+)\\s*$");
        int No=1;
        //Pattern pattern = Pattern.compile("^\\s*\"(.*?)\",\\s*(\\d+(?:\\.\\d+)?)\\s*$");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if(matcher.matches()) {
                    String[] tokens = line.split(" ");
                    String name = tokens[0];
                    int score = Integer.parseInt(tokens[1]);
                    GameUtils.drawWord(gImage,name,Color.white,30,150,146+64*No);
                    GameUtils.drawWord(gImage,""+score,Color.white,30,370,146+64*No);
                    No++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveScoreList() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // 写入数据到文件
            writer.write("@name @score\n");
            int count = 0;
            for (Map.Entry<String, Integer> entry : GameWin.list) {
                if (count < 10) {
                    writer.write(entry.getKey()+" "+entry.getValue()+"\n");
                    count++;
                } else {
                    break;
                }
            }
            // 关闭writer对象
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
