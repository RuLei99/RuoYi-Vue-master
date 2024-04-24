package com.ruoyi.web.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateData {

    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\big_dataset1.arff"));

            // 写入ARFF文件头部信息
            writer.write("@relation temperature\n\n");
            writer.write("@attribute Date date \"yyyy-MM-dd\"\n");
            writer.write("@attribute Temperature numeric\n");
            writer.write("@data\n");

            // 生成100万条数据
            Random random = new Random();
            for (int i = 0; i < 1000000; i++) {
                double income = random.nextDouble() * 10000; // 随机生成收入
                int educationIndex = random.nextInt(3); // 随机生成教育程度索引
                String education = "";
                switch (educationIndex) {
                    case 0:
                        education = "low";
                        break;
                    case 1:
                        education = "medium";
                        break;
                    case 2:
                        education = "high";
                        break;
                }
                double medicalCoverage = random.nextDouble(); // 随机生成医疗覆盖率
                double disasterFrequency = random.nextDouble(); // 随机生成自然灾害频率
                int povertyLevelIndex = random.nextInt(3); // 随机生成贫困等级索引
                String povertyLevel = "";
                switch (povertyLevelIndex) {
                    case 0:
                        povertyLevel = "high";
                        break;
                    case 1:
                        povertyLevel = "medium";
                        break;
                    case 2:
                        povertyLevel = "low";
                        break;
                }
                writer.write(String.format("%.2f,%s,%.2f,%.2f,%s\n", income, education, medicalCoverage, disasterFrequency, povertyLevel));
            }

            writer.close();
            System.out.println("Generated big dataset successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
