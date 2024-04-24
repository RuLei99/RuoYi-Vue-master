package com.ruoyi.system.service.impl;

import com.ruoyi.system.service.HdfsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HDFS相关配置
 *
 * @author adminstrator
 * @since 1.0.0
 */
@Configuration
public class HdfsConfig {
    @Value("${hdfs.url}")
    private  String defaultHdfsUri;

    @Bean
    public HdfsService getHbaseService(){
        System.setProperty("HADOOP_USER_NAME", "root");
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("fs.defaultFS",defaultHdfsUri);
        return new HdfsService(conf,defaultHdfsUri);
    }
//    public static void main(String args[]){
//        HdfsService hbaseService = HdfsConfig.getHbaseService();
//        boolean mkdir = hbaseService.mkdir("/opt/m2");
//        if(mkdir==true){
//            hbaseService.uploadFileToHdfs("/Users/apple/Downloads/Clash_1698318293.yaml","/opt/m2/a.yaml");
//        }
//    }

    public String getDefaultHdfsUri() {
        return defaultHdfsUri;
    }

    public void setDefaultHdfsUri(String defaultHdfsUri) {
        this.defaultHdfsUri = defaultHdfsUri;
    }
}
