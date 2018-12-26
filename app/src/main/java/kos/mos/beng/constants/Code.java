package kos.mos.beng.constants;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 14:47
 * @Email: KosmoSakura@foxmail.com
 */
public interface Code {
    String code = "952bf2f7c4";
    String DB_NAME = "beng-db";
    boolean DebugState = true;

    interface State {
        long EventId = 1;
        String UUID = "WoShiUUID";
        String split = "-";//分割
        String MMM = "【";//分割
    }

    interface Uid {
        long Kosmos = 100000000;

        long NaCl = 100;//琪亚娜
        long NaClFly = 101;//空之律者
        long FlyTogether = 102;//齐格飞
        long FlyDown = 103;//塞西莉亚

        long Dentist = 200;//雷电芽衣 牙医
        long Bronya = 300;//布洛丽亚-扎伊切克 板鸭
        long Jizi = 400;//无量塔姬子
        long SakuraLover = 500;//八重樱 YaeSakura
        long Kallen = 501;//卡莲 Kaslana
        long Firefox = 502;//绯玉丸

        long Delisa = 600;//德莉傻-阿波卡利斯
        long Auto = 601;//奥托

        long FuHua = 700;//浮华
        long JiJi = 701;//浮华
        long Dawei = 800;//尼古拉斯-大伟
        long Ai = 900;//爱酱
        long Captain = 1000;//舰长
    }
}
