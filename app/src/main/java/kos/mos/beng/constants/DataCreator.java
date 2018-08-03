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
        String NaClFly = "http://pic.qqtn.com/up/2018-8/20188214333653750.jpg";
        String flyTogether = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533323738470&di=5635f1d23edffa7c2bc27878d2782430&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D98b9bb7da164034f0fcdc20e9fc27980%2Fdd8bb81ab051f819555a76ead0b44aed2f73e7aa.jpg";
        String dentist = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533323996203&di=409bdcaf7f91c5954fd361bdb1762fec&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fb8e558500c6ee3946c306c0658ad063e2cc9dfc9.jpg";
        String Bronya = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3211019680,3970138183&fm=27&gp=0.jpg";
        String jizi = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533323894035&di=9bc48c889e92faffe2e00f888e9f31fc&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fe21ee3008961dba1f4215daa177a6e529f9817a7.jpg";
        String firefox = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/banner/banner_firefox.png";
        String kallen = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324007575&di=17dd9510081669843e289d0082cdfc39&imgtype=0&src=http%3A%2F%2Fattach10.92wy.com%2Fimages%2F2018%2F0511%2F1526014777a99283f5.jpg";
        String Theresa = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324222290&di=b5da45f6e5e3db1878ae0809a4680779&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fa33af8aeed817866cfaf2495c082d8aaa2222d6c.jpg";//德莉傻-阿波卡利斯
        String Dawei = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=644500532,484138190&fm=27&gp=0.jpg";
        String Auto = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324318010&di=08c5e76112d1fc7fe9bdaf54aae09665&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D1813743542%2C3042565469%26fm%3D214%26gp%3D0.jpg";//奥托
        String fuHua = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324381148&di=adde5fbf39e9ffa51a10d7649833b294&imgtype=0&src=http%3A%2F%2Fhiphotos.baidu.com%2Ffeed%2Fpic%2Fitem%2Fe1fe9925bc315c6070a2155981b1cb1349547754.jpg";
        String ai = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324451077&di=269536e2a31e373e5972fe4259b242ca&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Ff1530a6e092ccc97484acafb07ba12bcb1024766.jpg";
        String cptain = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324536616&di=d68e4c40fdb2f92c6e51dc57779a76b2&imgtype=0&src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2Fbfaa36e5e0c8a9e2090122991339226bf090f9f9.jpg";
    }

    public void creatPlayer() {
        PlayerHelper.getInstance()
            .insert(new PlayerBean(Code.Player.NaCl, -1, "女", "琪亚娜", Avatar.NaCl, "圣芙蕾雅学园", "小灵通", "饿不饿宅急送：1871234567", Banner.nacl, 17, false),
                new PlayerBean(Code.Player.NaClFly, -1, "女", "崩坏女王", Avatar.NaClFly, "天上", "意念传声", "签名", Banner.NaClFly, 17, false),
                new PlayerBean(Code.Player.FlyTogether, 1, "男", "齐格飞", Avatar.flyTogether, "去西伯利亚的路上", "反天命通讯", "我要干翻的，是这苍穹", Banner.flyTogether, 27, false),
                new PlayerBean(Code.Player.FlyDown, -1, "女", "塞西莉亚", Avatar.flyDown, "西伯利亚", "天命通讯", "", Banner.flyDown, 27, false),
                new PlayerBean(Code.Player.Dentist, -1, "女", "芽衣芽衣", Avatar.dentist, "圣芙蕾雅学园", "天命通讯", "街电租赁，60分钟只要一毛钱", Banner.dentist, 17, false),
                new PlayerBean(Code.Player.Bronya, -1, "女", "布洛丽亚", Avatar.Bronya, "圣芙蕾雅学园", "天命通讯", "吼姆大乱斗开发进度57%", Banner.Bronya, 16, false),
                new PlayerBean(Code.Player.Jizi, -1, "女", "姬子", Avatar.jizi, "休伯利安", "天命通讯", "今天的姬子有男朋友吗？", Banner.jizi, 18, false),
                new PlayerBean(Code.Player.LoverSakura, -1, "女", "嘤嘤嘤", Avatar.lover, "八重村", "绯玉丸", "舰长补给全保底，舰长副本零掉落", Banner.lover, 520, true),
                new PlayerBean(Code.Player.Kallen, -1, "女", "卡莲", Avatar.kallen, "八重村", "天命通讯", "樱，你真美！", Banner.kallen, 520, false),
                new PlayerBean(Code.Player.Firefox, -1, "女", "Firefox", Avatar.firefox, "八重村", "绯玉丸", "大姐，大姐，回来的时候给我带份油炸豆腐", Banner.firefox, 10000, false),
                new PlayerBean(Code.Player.Theresa, -1, "女", "德莉莎", Avatar.Theresa, "圣芙蕾雅学园", "天命通讯", "德莉莎世界第一可爱", Banner.Theresa, 40, false),
                new PlayerBean(Code.Player.Auto, 1, "男", "奥托", Avatar.Auto, "天命空港", "天命通讯", "苍茫的天涯是我的爱，绿油油的头顶花正开", Banner.Auto, 555, false),
                new PlayerBean(Code.Player.FuHua, -1, "女", "符华", Avatar.fuHua, "神舟", "喏基亚N95", "舞之道，永无止步！", Banner.fuHua, 5000, false),
                new PlayerBean(Code.Player.Dawei, 1, "男", "尼古拉斯·大伟", Avatar.Dawei, "", "", "我是MihuYo的总裁，现被建人所害，急需1000元律师费，等我坐回属于我的位置后，我任你为CTO，吱腐宝：WoZuiShuai@BanYa.com", Banner.Dawei, 35, false),
                new PlayerBean(Code.Player.Ai, -1, "女", "爱酱", Avatar.ai, "休伯利安", "天命通讯", "", Banner.ai, 0, false),
                new PlayerBean(Code.Player.Captain, 1, "男", "休伯利安唯一指定舰长", Avatar.cptain, "休伯利安", "大哥大", "你能体会那种养了一船老婆的鸭梨吗", Banner.cptain, 30, false));
    }
}
