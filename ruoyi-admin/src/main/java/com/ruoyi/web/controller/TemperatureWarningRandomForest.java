package com.ruoyi.web.controller;

import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class TemperatureWarningRandomForest {

    public static void main(String[] args) throws Exception {
        // 加载数据集
        DataSource source = new DataSource("d:\\temperature.arff");
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1); // 设置类别索引

        // 创建随机森林模型
        RandomForest randomForest = new RandomForest();
        randomForest.buildClassifier(data);

        System.out.println(randomForest);
        // 模拟获取当前温度数据点
        double[] instanceValues = new double[data.numAttributes()];
        // 设置日期时间属性值（假设在数据集中为第一个属性）
        // 设置其他属性值（如果有的话）

        // 创建待预测的实例
        Instances testInstance = new Instances(data, 1);
        testInstance.add(data.instance(0)); // 添加一个空实例
        testInstance.instance(0).setDataset(data);
        testInstance.instance(0).setClassMissing(); // 设置类别值为缺失

        // 对待预测实例进行类别预测
        double predictedClass = randomForest.classifyInstance(testInstance.instance(0));

        // 输出预测结果
        System.out.println("预测的温度等级：" + data.attribute(data.classIndex()).value((int) predictedClass));
    }
}
