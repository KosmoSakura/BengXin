package kos.mos.beng.tool;

import android.graphics.Paint;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @Description: 该类写所有的URL以及相关字符串拼接
 * @Author: Kosmos
 * @Date: 2016年8月29日 11:32
 * @Email: KosmoSakura@foxmail.com
 * @Events: UTxt
 * ------>1.新增字符串处理函数
 * ------>2.原有字符串工具增强
 */
public class UTxt {
    //------------------------------------------------------------------------------------------------
    public static boolean isEmpty(TextView tv) {
        return tv == null || isEmpty(tv.getText().toString());
    }

    public static String isNull(TextView tv) {
        String str = tv.getText().toString();
        if (isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }


    /**
     * 移除list中为null的元素
     */
    public static void clearNullOfList(List list) {
        if (list.contains(null)) {
            list.remove(null);
            if (list.contains(null)) {
                clearNullOfList(list);
            }
        }
    }

    /**
     * String为空返回""
     */
    public static String isNull(String str) {
        if (isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }

    /**
     * String为空返回指定字符
     */
    public static String isNull(String str, String defaul) {
        if (isEmpty(str)) {
            return defaul;
        } else {
            return str;
        }
    }

    public static String isNull(Editable str, String defaul) {
        if (isEmpty(str)) {
            return isNull(defaul);
        } else {
            return str.toString();
        }
    }

    public static String isNull(CharSequence str, String defaul) {
        if (isEmpty(str)) {
            return isNull(defaul);
        } else {
            return str.toString();
        }
    }

    /**
     * 任意对象，如果是不为空的String则返回，
     * 否则返回""
     */
    public static String isNull(Object str) {
        if (str == null) {
            return "";
        } else {
            if (str instanceof String) {
                return isNull(str);
            } else {
                return "";
            }
        }
    }

    /**
     * 任意对象，如果是不为空的String则返回，
     * 否则返回指定字符
     */
    public static String isNull(Object str, String defaul) {
        if (str == null) {
            return defaul;
        } else {
            if (str instanceof String) {
                return isNull(str);
            } else {
                return defaul;
            }
        }
    }

    /**
     * Long为空返回-1
     */
    public static long isNull(Long l) {
        if (l == null) {
            return -1;
        } else {
            return l;
        }
    }

    /**
     * Long为空返回为空返回指定值
     */
    public static long isNull(Long l, long defasult) {
        if (l == null) {
            return defasult;
        } else {
            return l;
        }
    }

    /**
     * Long为空返回-1
     */
    public static float isNull(Float l) {
        if (l == null) {
            return -1;
        } else {
            return l;
        }
    }

    /**
     * Long为空返回为空返回指定值
     */
    public static float isNull(Float l, float defasult) {
        if (l == null) {
            return defasult;
        } else {
            return l;
        }
    }

    /**
     * Integer为空返回-1
     */
    public static int isNull(Integer integer) {
        if (integer == null) {
            return -1;
        } else
            return integer;
    }

    /**
     * Integer为空返回指定值
     */
    public static int isNull(Integer integer, int defasult) {
        if (integer == null) {
            return defasult;
        } else
            return integer;
    }

    /**
     * Boolean为空返回false
     */
    public static boolean isBoolean(Boolean b) {
        if (b == null) {
            return false;
        } else return b;
    }

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(List list) {
        if (list == null) {
            return true;
        } else return list.size() == 0;
    }

    /**
     * 判断数组是否为空
     */
    public static <Z> boolean isEmpty(Z[] arr) {
        if (arr == null) {
            return true;
        } else return arr.length == 0;
    }

    /**
     * 判断字符串是否为null或长度为0
     *
     * @return {@code true}: 空<br> {@code false}: 不为空
     */
    public static boolean isEmpty(String str) {
        return str == null || TextUtils.isEmpty(str.trim()) || str.equalsIgnoreCase("null");
    }

    public static boolean isEmpty(CharSequence str) {
        return isEmpty(str.toString());
    }

    //------------------------------------------------------------------------------------------------

    /**
     * 返回str长度，为空返回0
     */
    public static int getLength(String str) {
        if (isEmpty(str)) {
            return 0;
        } else {
            return str.length();
        }
    }

    /**
     * 返回str长度，为空返回指定值
     */
    public static int getLength(String str, int defaultVelua) {
        if (isEmpty(str)) {
            return defaultVelua;
        } else {
            return str.length();
        }
    }

    public static int getLength(TextView tv) {
        String str = tv.getText().toString();
        if (isEmpty(str)) {
            return 0;
        } else {
            return str.length();
        }
    }

    /**
     * 判断字符串是否为null或全为空格
     *
     * @return {@code true}: null或全空格<br> {@code false}: 不为null且不全空格
     */
    public static boolean isSpace(String s) {
        return (isEmpty(s) || s.trim().length() == 0);
    }


    /**
     * 返回：首字母大写字符串
     */
    public static String upperFirstLetter(String s) {
        if (isEmpty(s) || !Character.isLowerCase(s.charAt(0))) return s;
        return String.valueOf((char) (s.charAt(0) - 32)) + s.substring(1);
    }

    /**
     * 返回：首字母小写字符串
     */
    public static String lowerFirstLetter(String s) {
        if (isEmpty(s) || !Character.isUpperCase(s.charAt(0))) return s;
        return String.valueOf((char) (s.charAt(0) + 32)) + s.substring(1);
    }

    //------------------------------------------------------------------------------------------------

    /**
     * 判断两字符串是否相等
     *
     * @return {@code true}: 相等<br>{@code false}: 不相等
     */
    public static boolean equals(CharSequence a, CharSequence b) {
        if (a == b) return true;
        int length;
        if (a != null && b != null && (length = a.length()) == b.length()) {
            if (a instanceof String && b instanceof String) {
                return a.equals(b);
            } else {
                for (int i = 0; i < length; i++) {
                    if (a.charAt(i) != b.charAt(i)) return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 价格后两位缩小
     */
    public static void setSpannableSize(BigDecimal big, TextView tv) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String str = "¥\b" + df.format(big);
        int lengh = str.length();
        if (lengh - 2 < 0) {
            return;
        }
        int size = (int) tv.getTextSize() - 8;
        SpannableString styledText = new SpannableString(str);
        styledText.setSpan(new TextAppearanceSpan(null, 0, size, tv.getTextColors(), null), lengh - 2, lengh, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(styledText);
    }

    /**
     * 下划线
     */
    public static void getTextUnderLine(TextView t) {
        t.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        t.getPaint().setAntiAlias(true);//抗锯齿
    }

    /**
     * 下划线
     */
    public static Spanned getTextUnderLine(String str) {
        return Html.fromHtml("<u>" + str + "</u>");
    }

    /**
     * 文本加粗
     */
    public static Spanned getTextBold(String str) {
        return Html.fromHtml("<b>" + str + "</b>");
    }

    /**
     * 文本斜体
     */
    public static Spanned getTextItalic(String str) {
        return Html.fromHtml("<i>" + str + "</i>");
    }

    /**
     * 动态设置字符串的颜色和大小
     *
     * @param t             TextView
     * @param color         将要单色设置的颜色
     * @param startLocation 使用该颜色的起始位置
     * @param endLocation   使用该颜色的终止位置
     * @param large         使用该颜色的字体与该字符串其他字体大小的倍数
     */
    public static void getSpannableString(TextView t, int color, int startLocation, int endLocation, float large) {
        String str = t.getText().toString();
        SpannableString styledText = new SpannableString(str);
        styledText.setSpan(new ForegroundColorSpan(color), startLocation, endLocation, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledText.setSpan(new RelativeSizeSpan(large), startLocation, endLocation, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(styledText);
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String path) {
        int separatorIndex = path.lastIndexOf("/");
        return (separatorIndex < 0) ? System.currentTimeMillis() + "" : path.substring(separatorIndex + 1, path.length());
    }

    /**
     * 获取后缀名
     */
    public static String getFileSuffix(String path) {
        int separatorIndex = path.lastIndexOf(".");
        return (separatorIndex < 0) ? ".jpg" : path.substring(separatorIndex, path.length());
    }
}
