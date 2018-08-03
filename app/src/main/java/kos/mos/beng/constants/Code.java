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
    boolean DebugState = true;

    interface Player {
        long NaCl = 100;//琪亚娜
        long NaClFly = 101;//空之律者
        long FlyTogether = 102;//齐格飞
        long FlyDown = 103;//塞西莉亚

        long Dentist = 200;//雷电芽衣 牙医
        long Bronya = 300;//布洛丽亚-扎伊切克 板鸭
        long Jizi = 400;//无量塔姬子
        long LoverSakura = 500;//八重樱 YaeSakura
        long Kallen = 501;//卡莲 Kaslana
        long Firefox = 502;//绯玉丸

        long Theresa = 600;//德莉傻-阿波卡利斯
        long Auto = 601;//奥托

        long FuHua = 700;//浮华
        long Dawei = 800;//尼古拉斯-大伟
        long Ai = 900;//爱酱
        long Captain = 1000;//舰长
    }

    interface Avatar {
        String Base = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/";
        String Kiana = Base + "ic_nacl.png";//琪亚娜-卡斯兰娜
        String Bronya = Base + "Bronya.png";//布洛丽亚-扎伊切克
        String Sakura = Base + "ic_sakuraura.png";//八重樱
        String Theresa = Base + "Theresa.png";//德莉傻-阿波卡利斯
        String Dawei = Base + "Dawei.png";//尼古拉斯-大伟
        String JianZhang = Base + "JianZhang.png";//舰长
        String Auto = Base + "Auto.png";//奥托
    }

    interface State {
        String UUID = "WoShiUUID";
    }


}
