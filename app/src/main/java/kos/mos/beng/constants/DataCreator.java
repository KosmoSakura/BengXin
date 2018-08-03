package kos.mos.beng.constants;

import kos.mos.beng.dao.PlayerHelper;
import kos.mos.beng.dao.bean.PlayerBean;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月03日 16:47
 * @Email: KosmoSakura@foxmail.com
 */
public class DataCreator {
    interface Avatar {
        String Base = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/";
        String NaCl = Base + "ic_nacl.png";//琪亚娜-卡斯兰娜
        String NaClFly = Base + "NaClFly.png";
        String flyTogether = Base + "fei.png";
        String flyDown = Base + "flyDown.png";
        String dentist = Base + "dentist.png";
        String Bronya = Base + "Bronya.png";
        String jizi = Base + "jizi.png";
        String lover = Base + "lover.png";
        String firefox = Base + "firefox.png";
        String kallen = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533298890267&di=d160f22d2728c7ebc02f18a585bbb5a4&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fbaike%2Fpic%2Fitem%2Fbd3eb13533fa828b94b3d645fd1f4134960a5a87.jpg";
        String Sakura = Base + "ic_sakuraura.png";//八重樱
        String Theresa = Base + "Theresa.png";//德莉傻-阿波卡利斯
        String Dawei = Base + "Dawei.png";//尼古拉斯-大伟
        String JianZhang = Base + "JianZhang.png";//舰长
        String Auto = Base + "Auto.png";//奥托
        String fuHua = Base + "fuHua.png";//奥托
        String ai = Base + "ai.png";
        String cptain = Base + "cptain.png";
    }

    interface Banner {
        //八重樱;
        String lover = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525863688390&di=ae5f8e6abbed204f9982abb54554e76b&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2Ff3a4c2da8426feb64c31de68bfb5983a16f264f4.jpg";
        //琪亚娜
        String nacl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525863597392&di=4fee1fbedf23c43c79c7e73b6dc04977&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2Fd751ba82e639b3c3482c451a8f81d8bb984733ab.jpg";
        //塞西莉亚
        String flyDown = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525863599488&di=e7b4c4322d77800312b9cbb12868c503&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2F268cf4a3edd342f7bc04b9445e2e9797758398e2.jpg";
        //百合
        String Baihe = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525863707712&di=301b3435a8370c19d1f251c65896e6a8&imgtype=0&src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2Ff8f7e8f2fd632f3653fc5d7186e6ad4b9fb2714c.jpg";

    }

    public void creatPlayer() {
        PlayerHelper.getInstance()
            .insert(new PlayerBean(Code.Player.NaCl, -1, "女", "琪亚娜", Avatar.NaCl, "圣芙蕾雅学园", "小灵通", "饿不饿宅急送：1871234567", 17, false),
                new PlayerBean(Code.Player.NaClFly, -1, "女", "崩坏女王", Avatar.NaClFly, "天上", "意念传声", "签名", 17, false),
                new PlayerBean(Code.Player.FlyTogether, 1, "男", "齐格飞", Avatar.flyTogether, "去西伯利亚的路上", "反天命通讯", "我要干翻的，是这苍穹", 27, false),
                new PlayerBean(Code.Player.FlyDown, -1, "女", "塞西莉亚", Avatar.flyDown, "西伯利亚", "天命通讯", "", 27, false),
                new PlayerBean(Code.Player.Dentist, -1, "女", "芽衣芽衣", Avatar.dentist, "圣芙蕾雅学园", "天命通讯", "街电租赁，60分钟只要一毛钱", 17, false),
                new PlayerBean(Code.Player.Bronya, -1, "女", "布洛丽亚", Avatar.Bronya, "圣芙蕾雅学园", "天命通讯", "吼姆大乱斗开发进度57%", 16, false),
                new PlayerBean(Code.Player.Jizi, -1, "女", "姬子", Avatar.jizi, "休伯利安", "天命通讯", "今天的姬子有男朋友吗？", 18, false),
                new PlayerBean(Code.Player.LoverSakura, -1, "女", "嘤嘤嘤", Avatar.lover, "八重村", "绯玉丸", "舰长补给全保底，舰长副本零掉落", 520, true),
                new PlayerBean(Code.Player.Kallen, -1, "女", "卡莲", Avatar.kallen, "八重村", "天命通讯", "樱，你真美！", 520, false),
                new PlayerBean(Code.Player.Firefox, -1, "女", "Firefox", Avatar.firefox, "八重村", "绯玉丸", "大姐，大姐，回来的时候给我带份油炸豆腐", 10000, false),
                new PlayerBean(Code.Player.Theresa, -1, "女", "德莉莎", Avatar.Theresa, "圣芙蕾雅学园", "天命通讯", "德莉莎世界第一可爱", 40, false),
                new PlayerBean(Code.Player.Auto, 1, "男", "奥托", Avatar.Auto, "天命空港", "天命通讯", "苍茫的天涯是我的爱，绿油油的头顶花正开", 555, false),
                new PlayerBean(Code.Player.FuHua, -1, "女", "符华", Avatar.fuHua, "神舟", "喏基亚N95", "舞之道，永无止步！", 5000, false),
                new PlayerBean(Code.Player.Dawei, 1, "男", "尼古拉斯·大伟", Avatar.Dawei, "", "", "我是MihuYo的总裁，现被建人所害，急需1000元律师费，等我坐回属于我的位置后，我任你为CTO，吱腐宝：WoZuiShuai@BanYa.com", 35, false),
                new PlayerBean(Code.Player.Ai, -1, "女", "爱酱", Avatar.ai, "休伯利安", "天命通讯", "", 0, false),
                new PlayerBean(Code.Player.Captain, 1, "男", "休伯利安唯一指定舰长", Avatar.cptain, "休伯利安", "大哥大", "你能体会那种养了一船老婆的鸭梨吗", 30, false));
    }
}
