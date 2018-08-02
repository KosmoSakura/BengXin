package kos.mos.beng.constants;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 14:47
 * @Email: KosmoSakura@foxmail.com
 * @Event: vector
 */
public interface Code {
    String code = "952bf2f7c4";

    interface Player {
        long Kiana = 100;//琪亚娜-卡斯兰娜
        long RaidenMei = 200;//雷电芽衣
        long Bronya = 300;//布洛丽亚-扎伊切克 Zaychik
        long Jizi = 400;//无量塔姬子
        long Sakura = 500;//八重樱 YaeSakura
        long Theresa = 600;//德莉傻-阿波卡利斯
        long FuHua = 700;//浮华
        long KallenKaslana = 800;//卡莲-卡斯兰娜
        long Dawei = 900;//尼古拉斯-大伟
        long JianZhang = 1000;//舰长
        long Auto = 101;//奥托
    }

    interface Avatar {
        String Base = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/";
        String Kiana = Base + "Kiana.png";//琪亚娜-卡斯兰娜
        String Bronya = Base + "Bronya.png";//布洛丽亚-扎伊切克 Zaychik
        String Sakura = Base + "Sakura.png";//八重樱 YaeSakura
        String Theresa = Base + "Theresa.png";//德莉傻-阿波卡利斯
        String Dawei = Base + "Dawei.png";//尼古拉斯-大伟
        String JianZhang = Base + "JianZhang.png";//舰长
        String Auto = Base + "Auto.png";//奥托
    }

    public class Config {
        public static String Cache = "";
    }
}
