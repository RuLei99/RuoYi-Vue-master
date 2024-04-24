package com.ruoyi.web.controller;

import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.Instance;
import weka.core.converters.ConverterUtils.DataSource;

public class TemperaturePrediction {

    public static void main(String[] args) throws Exception {
        // 加载训练好的随机森林模型
        RandomForest randomForest = (RandomForest) weka.core.SerializationHelper.read("d:\\random_forest_model.model");

        // 加载待预测的数据集
        DataSource source = new DataSource("d:\\temperature.arff");
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1); // 设置类别索引

        // 遍历待预测的数据集，并进行预测
        for (int i = 0; i < data.numInstances(); i++) {
            Instance testInstance = data.instance(i);
            testInstance.setDataset(data);

            // 对待预测实例进行类别预测
            double predictedClass = randomForest.classifyInstance(testInstance);

            // 输出预测结果
            System.out.println("日期时间：" + testInstance.stringValue(0) + ", 预测的温度等级：" + data.attribute(data.classIndex()).value((int) predictedClass));
        }
    }
}
