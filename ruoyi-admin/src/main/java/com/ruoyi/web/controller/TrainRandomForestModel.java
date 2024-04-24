package com.ruoyi.web.controller;

import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class TrainRandomForestModel {

    public static void main(String[] args) throws Exception {
        // 加载训练数据集
        DataSource source = new DataSource("d:\\training_data.arff");
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1); // 设置类别索引

        // 创建随机森林模型
        RandomForest randomForest = new RandomForest();
        randomForest.buildClassifier(data);

        // 将模型保存到文件中
        weka.core.SerializationHelper.write("d:\\random_forest_model.model", randomForest);
        
        System.out.println("随机森林模型已经训练并保存到 random_forest_model.model 文件中。");
    }
}
