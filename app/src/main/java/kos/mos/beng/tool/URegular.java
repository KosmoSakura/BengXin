package kos.mos.beng.tool;

import android.text.InputFilter;
import android.text.Spanned;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 正则表达式
 * @Author: Kosmos
 * @Date: 2016年9月21日 17:01
 * @Email: KosmoSakura@foxmail.com
 */
public class URegular {

    private static InputFilter emojiFilter = new InputFilter() {
        Pattern emoji = Pattern.compile(
            "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                return "";
            }
            return null;
        }
    };
    /**
     * 禁止输入表情
     */
    public static InputFilter[] emojiFilters = {emojiFilter};

    /**
     * 使用正则表达式检查手机号码
     */
    public static boolean checkPhoneNum(String phone) {

        return phone.matches(RegularExp.REGULAR_EXPRESSION_MOBILE);
    }

    /**
     * 使用正则表达式检查标点
     */
    public static boolean checkSign(String phone) {

        return phone.matches(RegularExp.REGULAR_EXPRESSION_SIGN);
    }

    /**
     * 验证邮箱
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile(RegularExp.REGULAR_EXPRESSION_CONTACT_EMAIL);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 使用正则表达式检查密码
     */
    public static boolean checkPassWord(String pw) {

        return pw.matches(RegularExp.REGULAR_EXPRESSION_PASSWORD);
    }

    /**
     * 使用正则表达式检查用户名
     */
    public static boolean checkUsername(String name) {

        return name.matches(RegularExp.REGULAR_EXPRESSION_CONTACT);
    }

    /**
     * 银行卡号每隔四位增加一个空格
     *
     * @param input : 银行卡号,例如"6225880137706868"
     * @return
     */
    public static String formBankCard(String input) {
        String result = input.replaceAll("([\\d]{4})(?=\\d)", "$1 ");
        return result;
    }

    /**
     * 隐藏银行卡号前几位
     *
     * @param input
     * @return
     */
    public static String formBankCard2(String input) {
        String result = input.replaceAll("([\\d]{4})(?=\\d)", "**** ");
        return result;
    }

    /**
     * 隐藏银行卡号前几位
     *
     * @param input
     * @return
     */
    public static String formBankCard3(String input) {
        String result = input.replaceAll("([\\d]{4})(?=\\d)", "$1 ");
        return result;
    }

    /**
     * 格式化数字
     * 方式一:使用DecimalFormat
     */
    public static String formatDigitString(String string, int digitLength) {
//        DecimalFormat df1 = (DecimalFormat) DecimalFormat.getInstance();
        DecimalFormat df1 = new DecimalFormat("#,##0.00");
        df1.setGroupingSize(digitLength);
        String result = null;
        try {
//            string = new DecimalFormat("0.00").format(Float.parseFloat(string));
            result = df1.format(Float.parseFloat(string));
        } catch (Exception e) {
            e.printStackTrace();
            return string;
        }
        return result;
    }

    /**
     * 格式化数字
     * 方式一:使用DecimalFormat
     */
    public static void formatFileSize() {
        DecimalFormat df1 = (DecimalFormat) DecimalFormat.getInstance();
        df1.setGroupingSize(3);
        String result = df1.format(1234567.45);
        System.out.println(result);
    }

    /**
     * 格式化数字
     * 方式二:使用正则表达式
     */
    public static String digit(String input) {
//        String input = "1234567.45634";
        String regx = "(?<=\\d)(\\d{4})";
//        System.out.println(input.replaceAll(regx, " $1"));
        return input.replaceAll(regx, " $1");
    }

    /**
     * 现行 16 位银联卡现行卡号开头 6 位是 622126～622925 之间的，7 到 15 位是银行自定义的，
     可能是发卡分行，发卡网点，发卡序号，第 16 位是校验码。

     16 位卡号校验位采用 Luhm 校验方法计算：

     1，将未带校验位的 15 位卡号从右依次编号 1 到 15，位于奇数位号上的数字乘以 2
     2，将奇位乘积的个十位全部相加，再加上所有偶数位上的数字
     3，将加法和加上校验位能被 10 整除。

     比如卡号：

     Java code
     .  6  2  2  5   8  8  1  4   1  4  2  0   7  4  3
     *  2     2      2     2      2     2      2     2
     --------------------------------------------------
     .  12  2  4  5  16  8  2  4   2  4  4     14  4  6

     将上面的数字加和：1+2+2+4+5+1+6+8+2+4+2+4+4+1+4+4+6 = 60

     由于 60 加上 0 才能被 10 整除，所以校验位为 0

     因此该卡号为 6225 8814 1420 7430


     如果其中一位数字换掉的话，直接导致最后校验位错误。
     */

    /**
     * 校验银行卡卡号
     *
     * @param cardId
     * @return
     */
    public static boolean checkBankCard(String cardId) {
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     *
     * @param nonCheckCodeCardId
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
            || !nonCheckCodeCardId.matches("\\d+")) {
            throw new IllegalArgumentException("Bank card code must be number!");
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    public static void main(String[] args) {
        String card = "534534534534535";
        System.out.println("      card: " + card);
        System.out.println("check code: " + getBankCardCheckCode(card.substring(0, card.length() - 1)));
        System.out.println("   card id: " + card + getBankCardCheckCode(card));
        System.out.println(checkBankCard(card));
        System.out.println(formBankCard(card));
        System.out.println(formBankCard2(card));
        formatFileSize();
//        digit();
        System.out.println(formatDigitString("234545.4543", 3));
    }


    /**
     * 校验纯汉字
     *
     * @param name
     * @return
     */
    public static boolean checkChineseCharacters(String name) {
        String regular = "^[\\u4e00-\\u9fa5]+$";

        return name.matches(regular);
    }

    /**
     * 数字、字母、符号两者以上的组合
     *
     * @param password
     * @return
     */
    public static boolean checkPassword2(String password) {
        String characters = "!@#$%+-,\\.;'";
        String regular = "^((?=.*?\\d)(?=.*?[A-Za-z])|(?=.*?\\d)(?=.*?[符号])|(?=.*?[A-Za-z])(?=.*?[符号]))[\\dA-Za-z符号]+$";
        regular = regular.replace("符号", characters);

        return password.matches(regular);
    }

    /**
     * 数字、字母、符号三者的组合
     *
     * @param password
     * @return
     */
    public static boolean checkPassword(String password) {
        String characters = "!@#$%+-,\\.;'";
        String regular = "^((?=.*?\\d)(?=.*?[A-Za-z])(?=.*?[符号]))[\\dA-Za-z符号]+$";
        regular = regular.replace("符号", characters);

        return password.matches(regular);
    }

    private class RegularExp {
        private static final String REGULAR_EXPRESSION_MOBILE = "^1(3[0-9]\\d|47\\d|5[0-9]\\d|7[67]\\d|8[0-9]\\d|70[059])\\d{7}$";
        private static final String REGULAR_EXPRESSION_SIGN = "^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]+$";
        private static final String REGULAR_EXPRESSION_PASSWORD = "^[a-z0-9A-Z~\\-_`!\\/@#$%\\^\\+\\*&\\\\?\\|:\\.<>\\[\\]{}()';=\",]*$";
        private static final String REGULAR_EXPRESSION_ID_CARD = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$";
        private static final String REGULAR_EXPRESSION_REAL_NAME = "^[\\u4e00-\\u9fa5]+[·•●]{0,1}[\\u4e00-\\u9fa5]+$";
        private static final String REGULAR_EXPRESSION_CONTACT = "^[~\\-_`!\\/@#$%\\^\\+\\*&\\\\?\\|:\\.<>\\[\\]{}()';=\",]*$";
        private static final String REGULAR_EXPRESSION_CONTACT_EMAIL = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        private static final String REGUILAR_EXPERSSION_AMOUNT = "^(([1-9]\\d*)(\\.\\d{1,2})?)$|(0\\.0?([1-9]\\d?))$";
        private static final String REGULAR_EXPRESSION_TRADE_PASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]*$";
        private static final String REGULAR_EXPRESSION_ALL = ".+";
        private static final String REGULAR_Emoji_Not = "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";
    }
}
