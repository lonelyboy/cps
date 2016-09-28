package com.codemonkey.lonelyboy.cps.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
    public static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 获取文件的内容
     * @param filePath
     * @return
     */
    public static String getFileContext(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            return IOUtils.toString(in);
        } catch (FileNotFoundException e) {
            logger.error("文件未找到", e);
        } catch (IOException e) {
            logger.error("文件无法获取内容", e);
        }
        return null;
    }
}
