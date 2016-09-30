package com.codemonkey.lonelyboy.test;

import com.codemonkey.lonelyboy.cps.tools.ConfigUtil;

public class TestUtil {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String context = ConfigUtil.getProperty("khj.history.web"); //HttpUtil.gethttpUriContext("http://kjh.55128.cn/ssq-history-2013.htm");
        System.out.println(context);
        System.out.println(Integer.parseInt("09"));
    }

}
