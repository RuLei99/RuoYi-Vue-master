package com.ruoyi.web.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class HttpsExample {

    public static void main(String[] args) {
        try {
            // 禁用SSL证书验证
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }
                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // 创建Jsoup连接，并设置SSL上下文
            Document doc = Jsoup.connect("https://example.com").sslSocketFactory(sslContext.getSocketFactory()).get();

            // 输出网页内容
            System.out.println(doc.outerHtml());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
