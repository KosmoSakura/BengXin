package kos.mos.beng.constants;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月24日 21:06
 * @Email: KosmoSakura@foxmail.com
 */
public class UStr {
    public static String parseComments(String nameA, String nameB, String comments) {
        return "<font color= '#5501b5c6'>" + nameA + "</font> 回复" +
            "<font color= '#5501b5c6'>" + nameB + "</font> ：" +
            " <font color= '#21211d'>" + comments + "</font>";
    }

    public static String parseComments(String name, String comments) {
        return "<font color= '#5501b5c6'>" + name + "</font> ：<font color= '#21211d'>" + comments + "</font>";
    }

    public static String parseOrder(String name, String comments) {
        return "<font color= '#5501b5c6'>" + name + "：</font><font color= '#732b90'>" + comments + "</font>";
    }

    public static String parseNotice(String name, String str1, String str2) {
        return "<font color= '#5501b5c6'>" + name + "</font> ：" +
            "<font color= '#ef5a3d'>" + str1 + "</font> ：<font color= '#732b90'>" + str2 + "</font>";
    }

    public static String parseAtNoAt(String str) {
        return "<font color= '#c6017a'>" + str + "</font>";
    }
    public static String parseAt(String str) {
        return "<font color= '#c6017a'>@" + str + "</font>";
    }

    public static String parseHigh(String str, String strN) {
        return "<font color= '#d4000b'>" + str + "</font><font color= '#21211d'>" + strN + "</font>";
    }
}
