package com.codemonkey.lonelyboy.cps.history.data.source;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.codemonkey.lonelyboy.cps.common.StringConts;
import com.codemonkey.lonelyboy.cps.history.data.bean.Ssq;
import com.codemonkey.lonelyboy.cps.tools.ConfigUtil;
import com.codemonkey.lonelyboy.cps.tools.HttpUtil;

public class LuckyBallSource {
    public static Logger logger = LoggerFactory.getLogger(LuckyBallSource.class);

    public static void main(String args[]) {
        getSsqHistory();
    }

    /**
     * ssq开始时间
     */
    public static final int START_YEAR_SSQ = 2003;

    public static final String DEFAULT_KJSJ = "1900.01.01";

    public static List<Ssq> getSsqHistory() {
        List<Ssq> listSsq = new ArrayList<Ssq>();
        //获取网站地址
        int yearOfNow = getYearOfNow();
        //循环解析每年的数据，单个解析能
        for (int year = START_YEAR_SSQ; year <= yearOfNow; year++) {
            listSsq.addAll(getSsqYearData(year));
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
        if(StringUtils.isEmpty(html)){
        	return dataList;
        }
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
                dataList.add(parseSsqNode(ssqKjjg, ulNode));
            }

        } catch (ParserException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    private static Ssq parseSsqNode(Node ssqTrNode, Node ulNode) {
        SimpleDateFormat simp = new SimpleDateFormat("yyyy.MM.dd");

        Ssq ssq = new Ssq();
        NodeList tds = ssqTrNode.getChildren();
        TagNameFilter tagFilter = new TagNameFilter("td");
        NodeList allTds = tds.extractAllNodesThatMatch(tagFilter);
        //获取各种属性呗

        //设置期号
        Node qh = allTds.elementAt(0);
        ssq.setC_qh(qh.toPlainTextString());
        //设置开奖时间
        Node kjsj = allTds.elementAt(1);
        try {
            ssq.setD_kjsj(simp.parse(kjsj.toPlainTextString()));
        } catch (ParseException e) {
            ssq.setD_kjsj(getDefaultKjsj(simp));
            logger.error("日期转换异常", e);
        }
        //设置几个球号
        writeBallNumber(ulNode, ssq);
        //要解析详情页面获取到开奖的各种奖多少注

        //设置奖金池
        //        Node jjc = allTds.elementAt(6);
        //        ssq.setDl_jc(Double.parseDouble(jjc.toPlainTextString()));
        return ssq;
    }

    private static void writeBallNumber(Node ulNode, Ssq ssq) {
        NodeList numbersList = ulNode.getChildren();
        TagNameFilter liTagFilter = new TagNameFilter("li");
        NodeList litags = numbersList.extractAllNodesThatMatch(liTagFilter);
        Node redBall1 = litags.elementAt(0);
        ssq.setN_h1(Integer.parseInt(redBall1.toPlainTextString()));
        Node redBall2 = litags.elementAt(1);
        ssq.setN_h2(Integer.parseInt(redBall2.toPlainTextString()));
        Node redBall3 = litags.elementAt(2);
        ssq.setN_h3(Integer.parseInt(redBall3.toPlainTextString()));
        Node redBall4 = litags.elementAt(3);
        ssq.setN_h4(Integer.parseInt(redBall4.toPlainTextString()));
        Node redBall5 = litags.elementAt(4);
        ssq.setN_h5(Integer.parseInt(redBall5.toPlainTextString()));
        Node redBall6 = litags.elementAt(5);
        ssq.setN_h6(Integer.parseInt(redBall6.toPlainTextString()));
        Node blueBall = litags.elementAt(6);
        ssq.setN_b1(Integer.parseInt(blueBall.toPlainTextString()));
    }

    private static Date getDefaultKjsj(SimpleDateFormat simp) {
        try {
            return simp.parse(DEFAULT_KJSJ);
        } catch (ParseException e) {
            return null;
        }
    }
}
