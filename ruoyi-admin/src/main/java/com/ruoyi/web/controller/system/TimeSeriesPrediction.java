package com.ruoyi.web.controller.system;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class TimeSeriesPrediction {

    public static void main(String[] args) throws Exception {
        // 加载数据集
        DataSource source = new DataSource("d:\\temp.arff");
        Instances data = source.getDataSet();

        // 设置类别索引（假设气温数据在最后一列）
        data.setClassIndex(data.numAttributes() - 1);

        // 创建LinearRegression对象
        LinearRegression model = new LinearRegression();
        model.buildClassifier(data);

        // 假设要预测未来5个时间步的气温
        for (int i = 0; i < 5; i++) {
            // 创建一个新的实例
            Instance newInstance = (Instance) data.lastInstance().copy();

            // 设置时间戳
            newInstance.setValue(data.attribute("Date"), data.lastInstance().value(data.attribute("Date")) + 1);

            // 使用模型进行预测
            double predictedTemperature = model.classifyInstance(newInstance);

            // 输出预测结果
            System.out.println("Time Step " + (i + 1) + " Predicted Temperature: " + predictedTemperature);
        }
    }
}
