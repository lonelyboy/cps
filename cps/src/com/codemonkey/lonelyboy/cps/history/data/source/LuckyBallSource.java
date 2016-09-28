package com.codemonkey.lonelyboy.cps.history.data.source;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;

import com.codemonkey.lonelyboy.cps.common.StringConts;
import com.codemonkey.lonelyboy.cps.history.data.bean.Ssq;
import com.codemonkey.lonelyboy.cps.tools.ConfigUtil;
import com.codemonkey.lonelyboy.cps.tools.HttpUtil;

public class LuckyBallSource {

    public static void main(String args[]) {
        getSsqYearData(2013);
    }

    /**
     * ssq开始时间
     */
    public static final int START_YEAR_SSQ = 2003;

    public static List<Ssq> getSsqHistory() {
        List<Ssq> listSsq = new ArrayList<Ssq>();
        //获取网站地址
        int yearOfNow = getYearOfNow();
        //循环解析每年的数据，单个解析能
        for (int year = START_YEAR_SSQ; year <= yearOfNow; year++) {
            getSsqYearData(year);
        }
        return listSsq;
    }

    private static int getYearOfNow() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    private static String getWebSite(int year, String pz) {
        String webSite = ConfigUtil.getProperty("khj.history.web");
        webSite = webSite.replaceAll("#pz#", pz);
        webSite = webSite.replaceAll("#year#", String.valueOf(year));
        return webSite;
    }

    public static List<Ssq> getSsqYearData(int year) {
        List<Ssq> dataList = new ArrayList<Ssq>();
        String webSite = getWebSite(year, StringConts.PZ_SSQ);
        String html = HttpUtil.gethttpUriContext(webSite);
        Parser htmlParser = Parser.createParser(html, "utf-8");
        HasAttributeFilter filter = new HasAttributeFilter("class", "ballbox");
        try {
            //获取到匹配开奖结果的ul列表
            NodeList nodes = htmlParser.extractAllNodesThatMatch(filter);
            SimpleNodeIterator iterator = nodes.elements();
            while (iterator.hasMoreNodes()) {
                //开奖结果的ul
                Node ulNode = iterator.nextNode();
                Node ssqKjjg = ulNode.getParent().getParent();
                //获取table中所有的子元素
                //获取table下面的ballbox元素
            }

        } catch (ParserException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    private static Ssq parseSsqNode(Node ssqTrNode) {
        Ssq ssq = new Ssq();
        NodeList tds = ssqTrNode.getChildren();
        //获取各种属性呗
        tds.elementAt(0);

        return ssq;
    }
}
