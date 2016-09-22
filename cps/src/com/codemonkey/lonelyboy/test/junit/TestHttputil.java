package com.codemonkey.lonelyboy.test.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.codemonkey.lonelyboy.cps.tools.HttpUtil;

public class TestHttputil {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("ttt");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Test
    public void test() {
        String context = HttpUtil.gethttpUriContext("http://blog.csdn.net/u010028869/article/details/49780515");
        System.out.println(context);
    }

}
