package com.codemonkey.lonelyboy.cps.tools;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

    public static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static String gethttpUriContext(String uri) {
        URL url = null;
        InputStream in = null;
        try {
            url = new URL(uri);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5 * 1000);
            // 假装自己是浏览器
            urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            in = urlConnection.getInputStream();
            return IOUtils.toString(in);
        } catch (MalformedURLException e) {
            logger.error("创建url：", e);
        } catch (IOException e) {
            logger.error("创建连接失败：", e);
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
        return null;
    }

}
