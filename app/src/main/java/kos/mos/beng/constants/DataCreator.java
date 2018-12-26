package kos.mos.beng.constants;

import android.content.Context;

import kos.mos.beng.dao.DbEventHelper;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.bean.EventBean;
import kos.mos.beng.dao.bean.PlayerBean;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月03日 16:47
 * @Email: KosmoSakura@foxmail.com
 */
public class DataCreator {
    interface Avatar {
        String Base = "http://i2.bvimg.com/661842/";
        String NaClMoon = Base + "b82f8ce64a70a0a6.jpg";//琪亚娜-卡斯兰娜
        String NaClFly = Base + "614f3e30b618736e.png";
        String flyTogether = Base + "885006030ef989e8.png";
        String flyDown = Base + "43024edc54863b4c.png";
        String dentist = Base + "23753592b3d1361b.png";
        String Bronya = Base + "e255fe66d2df3792.png";
        String jizi = Base + "2fe924566e98482c.png";
        String lover = Base + "084b367fbee84ce5.png";
        String firefox = Base + "b8b3bfd97f5635b7.png";
        String kallen = Base + "e2e9aca0d887bd48.png";
        String Theresa = Base + "d2c8b647f7b83c43.png";//德莉傻-阿波卡利斯
        String Dawei = Base + "37857a21e3fbe64d.png";//尼古拉斯-大伟
        String Auto = Base + "3183edcf300201b3.png";//奥托
        String fuHua = Base + "e9b9702a0a9a3307.png";
        String ai = Base + "76164c50f4993226.png";
        String cptain = Base + "ddb30bc79d8dfcab.png";
        String JiJi = "http://i4.bvimg.com/661842/4a71e6cd23d86744.png";
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
        String NaClFly = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536827519420&di=c9356bf3ed9001ef0f33e9c2bc5e9d1c&imgtype=0&src=http%3A%2F%2Fvd3.bdstatic.com%2Fmda-ih99xvi42s9b9fgs%2Fmda-ih99xvi42s9b9fgs.jpg";
        String flyTogether = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533323738470&di=5635f1d23edffa7c2bc27878d2782430&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D98b9bb7da164034f0fcdc20e9fc27980%2Fdd8bb81ab051f819555a76ead0b44aed2f73e7aa.jpg";
        String dentist = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533323996203&di=409bdcaf7f91c5954fd361bdb1762fec&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fb8e558500c6ee3946c306c0658ad063e2cc9dfc9.jpg";
        String Bronya = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3211019680,3970138183&fm=27&gp=0.jpg";
        String jizi = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533323894035&di=9bc48c889e92faffe2e00f888e9f31fc&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fe21ee3008961dba1f4215daa177a6e529f9817a7.jpg";

        String kallen = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324007575&di=17dd9510081669843e289d0082cdfc39&imgtype=0&src=http%3A%2F%2Fattach10.92wy.com%2Fimages%2F2018%2F0511%2F1526014777a99283f5.jpg";
        String Theresa = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324222290&di=b5da45f6e5e3db1878ae0809a4680779&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fa33af8aeed817866cfaf2495c082d8aaa2222d6c.jpg";//德莉傻-阿波卡利斯
        String Dawei = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=644500532,484138190&fm=27&gp=0.jpg";
        String Auto = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324318010&di=08c5e76112d1fc7fe9bdaf54aae09665&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D1813743542%2C3042565469%26fm%3D214%26gp%3D0.jpg";//奥托
        String fuHua = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324381148&di=adde5fbf39e9ffa51a10d7649833b294&imgtype=0&src=http%3A%2F%2Fhiphotos.baidu.com%2Ffeed%2Fpic%2Fitem%2Fe1fe9925bc315c6070a2155981b1cb1349547754.jpg";
        String ai = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324451077&di=269536e2a31e373e5972fe4259b242ca&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Ff1530a6e092ccc97484acafb07ba12bcb1024766.jpg";
        //        String cptain = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324536616&di=d68e4c40fdb2f92c6e51dc57779a76b2&imgtype=0&src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2Fbfaa36e5e0c8a9e2090122991339226bf090f9f9.jpg";
        String cptain = "http://i2.bvimg.com/661842/c66d719bdba6cb44.png";
        String BASE = "http://i1.bvimg.com/661842/";
        String firefox = BASE + "3a4806836f731577.png";
        String SakuraSnow = BASE + "c035febf088c9e24.jpg";
    }

    interface Zone {
        String NaclHotSprings = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533455226383&di=3b399f0095042ef1ad465d43a4c14016&imgtype=0&src=http%3A%2F%2Fwww.xz7.com%2Fup%2F2017-9%2F201792193913.jpg";
        String kallen = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533298890267&di=d160f22d2728c7ebc02f18a585bbb5a4&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fbaike%2Fpic%2Fitem%2Fbd3eb13533fa828b94b3d645fd1f4134960a5a87.jpg";
        String BASE = "http://i4.bvimg.com/661842/";
        String BengBengBeng = BASE + "fbf9c6f6a4b0b9b8.gif";
        String KaBed = BASE + "3a5218953dc29760.png";
        String YaYi = "http://i1.bvimg.com/661842/0a1660e607c9f34a.png";
        String KaSmail = BASE + "8f56b2946baefa7d.png";
        String Man80 = BASE + "e4ccf3149282d410.png";
        String NaclMoonRun = "http://i1.bvimg.com/661842/435e47a6b3f42a83.jpg";
        String SakuraKun = BASE + "27846bd3d4a96826.png";
        String YueLunGet = BASE + "f7cd0c56135eef85.png";
        String ZheNiMa = BASE + "eacdfe7827e3e16b.png";
        String xiongShort = "http://i1.bvimg.com/661842/58755151e55b6a6d.png";
        String ss_ed_1 = "http://i1.bvimg.com/661842/33ee1861f3d875d3.png";
        String ss_ed_2 = "http://i1.bvimg.com/661842/374bfe67c7be41b7.png";
        String ss_ed_3 = "http://i1.bvimg.com/661842/20cdaf9ac33ed7be.png";
        String ss_ed_4 = "http://i4.bvimg.com/661842/772666748ed7bc12.png";
        String ss_fuhua_1 = "http://i1.bvimg.com/661842/eeba608c2daa420d.png";
        String ss_fuhua_2 = "http://i1.bvimg.com/661842/077e39e8f215cce9.png";
        String ss_fuhua_3 = "http://i1.bvimg.com/661842/16494d4144cf475a.png";
        String ss_egg = "http://i1.bvimg.com/661842/d52042754a884a55.png";
        String ss_feiji = "http://i1.bvimg.com/661842/284557f435d39d8d.png";
        String ss_key_1 = "http://i1.bvimg.com/661842/8bdb7bcc7e9f8908.png";
        String ss_key_2 = "http://i1.bvimg.com/661842/8e2e0ff2520186ce.png";
        String ss_key_3 = "http://i4.bvimg.com/661842/d522dd4cbf58d5b0.jpg";
        String ss_nvwang = "http://i1.bvimg.com/661842/ff31c974fcfe3bb3.jpg";
        String ss_fuhhua_chouka = "http://i1.bvimg.com/661842/f0d65783b84b56f4.png";
    }

    interface Name {
        String Kiana = "月光少女✧娜娜";
        String NvWang = "女王大人";
        String QiGeFei = "七哥灰";
        String SeXiLiYa = "塞西莉亚";
        String YaYi = "芽衣不是牙医";
        String Bronya = "铁板·烤鸭";
        String JiZi = "现充姬子";
        String Sakura = "樱花·散";
        String KaLian = "莲花·开";
        String Firefox = "火狐狸·绯玉丸";
        String Delisa = "神恩·送锅";
        String Auto = "全自动奥托";
        String Fuhua = "专业看场子的符神";
        String JiJi = "专业砸场子的火鸡";
        String Dawei = "尼古拉斯·棒棒糖";
        String Aii = "农学博士·包菜";
        String Captain = "萌新舰长No:996";
    }

    public void creatPlayer(Context context) {
        DbPlayerHelper.insert(context,
            new PlayerBean(Code.Uid.NaCl, "NaCl", -1, "女", Name.Kiana,
                Avatar.NaClMoon, "圣芙蕾雅学园", "娜娜的小灵通",
                "饿不饿宅急送：1871234567\n新款鲜榨饮品《芽衣的妹汁》已到货", Banner.nacl, 17, "芽衣的妹汁", false),

            new PlayerBean(Code.Uid.NaClFly, "NaClFly", -1, "女",
                Name.NvWang, Avatar.NaClFly, "天上", "意念传声β",
                "恕我直言，在座的各位都是垃圾", Banner.NaClFly, 17, "毁灭人类", false),

            new PlayerBean(Code.Uid.FlyTogether, "FlyTogether", 1, "男",
                Name.QiGeFei, Avatar.flyTogether, "去西伯利亚的路上", "反天命通讯",
                "狗天命，还我老婆", Banner.flyTogether, 27, "塞西莉亚", false),

            new PlayerBean(Code.Uid.FlyDown, "FlyAnywhere", -1, "女", Name.SeXiLiYa,
                Avatar.flyDown, "西伯利亚", "天命通讯", "希望我的琪亚娜早点长大", Banner.flyDown,
                27, "琪亚娜", false),

            new PlayerBean(Code.Uid.Dentist, "dentist", -1, "女", Name.YaYi,
                Avatar.dentist, "圣芙蕾雅学园", "圣芙蕾雅电磁波", "街电租赁，陪逛街免费充电٩(๑❛ᴗ❛๑)۶",
                Banner.dentist, 17, "琪亚娜", false),

            new PlayerBean(Code.Uid.Bronya, "duck", -1, "女", Name.Bronya,
                Avatar.Bronya, "圣芙蕾雅学园", "天命通讯", "吼姆大乱斗开发进度57%",
                Banner.Bronya, 16, "吼姆", false),

            new PlayerBean(Code.Uid.Jizi, "18forever", -1, "女", Name.JiZi, Avatar.jizi,
                "休伯利安", "天命通讯", "今天的姬子有男朋友吗？",
                Banner.jizi, 18, "男", false),

            new PlayerBean(Code.Uid.SakuraLover, "Sakura", -1, "女", Name.Sakura,
                Avatar.lover, "八重村", "绯玉丸", "舰长补给全保底，舰长副本零掉落",
                Banner.SakuraSnow, 520, "卡莲卡莲", false),

            new PlayerBean(Code.Uid.Kallen, "00001", -1, "女", Name.KaLian,
                Avatar.kallen, "八重村", "天命通讯", "樱，你真美！",
                Banner.SakuraSnow, 520, "嘤嘤嘤", false),

            new PlayerBean(Code.Uid.Firefox, "Firefox", -1, "女", Name.Firefox,
                Avatar.firefox, "八重村", "绯玉丸",
                "火狐但不是浏览器，也不能上网,更不能打电话", Banner.firefox, 10000,
                "油炸豆腐", false),

            new PlayerBean(Code.Uid.Delisa, "A-310", -1, "女", Name.Delisa,
                Avatar.Theresa, "圣芙蕾雅学园", "犹大索敌模式",
                "德莉莎世界第一可爱", Banner.Theresa, 40, "苦瓜汁", false),

            new PlayerBean(Code.Uid.Auto, "00000", 1, "男", Name.Auto,
                Avatar.Auto, "天命空港", "天命通讯(主教限定)",
                "苍茫的天涯是我的爱，绿油油的头顶花正开", Zone.KaSmail, 555, "卡莲", false),

            new PlayerBean(Code.Uid.JiJi, "chicken", 1, "雄性", Name.JiJi,
                Avatar.JiJi, "神舟", "天命打鸣②型", "符华专用格斗鸡，站在食物链顶端抓虫子",
                Banner.fuHua, 10000, "怼符华", false),

            new PlayerBean(Code.Uid.FuHua, "FireBird", -1, "女", Name.Fuhua,
                Avatar.fuHua, "神舟", "喏基亚N95", "舞之道，永无止步！",
                Banner.fuHua, 10000, "崩崩崩", false),

            new PlayerBean(Code.Uid.Dawei, "DV", 1, "男", Name.Dawei,
                Avatar.Dawei, "MiHuYo大楼", "IPhone9",
                "我是HuYoNi总裁，现被某鸭所害，急需1000元律师费，等我坐回原来的位置任你为CTO，吱腐宝：huyoni@BanYa.com",
                Banner.Dawei, 35, "Money", false),

            new PlayerBean(Code.Uid.Ai, "89757", -1, "女", Name.Aii,
                Avatar.ai, "包菜种植基地", "天命通讯", "这个人很懒，只留下了一颗发了芽的包菜",
                Banner.ai, 0, "偷电", false),
//            new PlayerBean(Code.Uid.Kosmos, "KosmoSakura", 1, "男", "赤夜千樱",
//                Me.Normal, "三次元", "HWP9", "被赤色夜空染色的一千株樱花在零时凋落的声音",
//                Me.Banner, 0, "Vocaloid，Code，八重樱老婆", false)
            new PlayerBean(Code.Uid.Captain, "11872324", 1, "男",
                Name.Captain, Avatar.cptain, "休伯利安",
                "红米Note", "新来的清洁工，请多指教",
                Banner.cptain, 30, "开飞机和休伯利安", false)
        );
    }

    private String int2Str(int res) {
        return String.valueOf(res);
    }

    //ಠ  ω (ಥ﹏ಥ)(´థ౪థ)σ ✧ ❥ ✿ ☆ ヾ(◍°∇°◍)ﾉﾞ (｡◕ˇ∀ˇ◕)
    //㊣☆☺☹®©☊☋℡
    private void creatEventNest(Context context) {
        DbEventHelper.insert(context,
            new EventBean(Code.State.EventId + 24, getPlayer(context, Code.Uid.Delisa), 1,
                Zone.ss_ed_1 + Code.State.MMM +
                    Zone.ss_ed_2 + Code.State.MMM +
                    Zone.ss_ed_3 + Code.State.MMM +
                    Zone.ss_ed_4, "刚刚", "休伯利安档案室",
                Name.Kiana,
                UStr.parseComments(Name.Kiana, "??????") + Code.State.split +
                    UStr.parseComments(Name.JiZi, "。。。。") + Code.State.split +
                    UStr.parseComments(Name.Delisa, "阿符，阿符") + UStr.parseAt(Name.Fuhua),
                null, null,
                "。。。" + UStr.parseAt(Name.Captain)),

            new EventBean(Code.State.EventId + 23, getPlayer(context, Code.Uid.Jizi), 1,
                "", "刚刚", "休伯利安舰桥",
                Name.Captain,
                UStr.parseComments(Name.Dawei, "大家别紧张，被阿符拆过的废龙一条") + Code.State.split +
                    UStr.parseComments(Name.Fuhua, "。。。") + Code.State.split +
                    UStr.parseComments(Name.NvWang, "友军，友军，是我在遛龙") + Code.State.split +
                    UStr.parseComments("贝纳勒斯", "我...只是路过...") + Code.State.split +
                    UStr.parseComments(Name.JiZi, "。。。"),
                null, null,
                "<font color= '#732b90'>通知：" +
                    "<br/>崩坏动力炉气压过载，" +
                    "<br/>泄露的崩坏能引来了一坨贝纳勒斯，" +
                    "<br/>舰长的事先放一放，" +
                    "<br/>全体女武神一级战斗准备。</font>"),

            new EventBean(Code.State.EventId + 22, getPlayer(context, Code.Uid.Captain), 1,
                Zone.ss_fuhua_1 + Code.State.MMM +
                    Zone.ss_fuhua_2 + Code.State.MMM +
                    Zone.ss_fuhua_3, "刚刚", "休伯利安档案室",
                Name.Sakura + "," + Name.KaLian + "," + Name.Auto,
                UStr.parseComments(Name.Fuhua, "黑我!还敢@我!") + Code.State.split +
                    UStr.parseComments(Name.Fuhua, "舰长，你是直接跳下去，还是走流程？") + Code.State.split +
                    UStr.parseComments(Name.Delisa, "大伟,上次发布的舰长招聘信息还没撤回吧？") + UStr.parseAt("尼古拉斯·大伟") + Code.State.split +
                    UStr.parseComments(Name.Dawei, Name.Delisa, "呃。。。舰长难道是消耗品？") + Code.State.split +
                    UStr.parseComments(Name.Captain, "娜娜不是说萌新可以进档案室么？") + Code.State.split +
                    UStr.parseComments(Name.Auto, Name.Captain, "草履虫的话你也信，念你是初犯，但是符华上仙我也惹不起"),
                null, null,
                "阿符原来长得这么抽象呀" + UStr.parseAt("黑丝·阿符")),

            new EventBean(Code.State.EventId + 21, getPlayer(context, Code.Uid.NaCl), 1,
                Zone.ss_egg + Code.State.MMM, "1天前", "休伯利安档案室",
                Name.Aii + "," + Name.Sakura + "," + Name.KaLian,
                UStr.parseComments(Name.Fuhua, "嗯，这张照片，有些年头了。。") + Code.State.split +
                    UStr.parseComments(Name.YaYi, "班长萌萌哒") + Code.State.split +
                    UStr.parseComments(Name.Captain, "琪亚娜随便进档案室，大丈夫？？") + Code.State.split +
                    UStr.parseComments(Name.Delisa, Name.Captain, "单细胞生物，没关系啦~") + Code.State.split +
                    UStr.parseComments(Name.Kiana, Name.Delisa, "萌新舰长的细胞明明比我还少！") + Code.State.split +
                    UStr.parseComments(Name.Captain, "原来如此，我懂了"),
                null, null,
                "班长小时候好可爱呀~" + UStr.parseAt("老班长")),

            new EventBean(Code.State.EventId + 20, getPlayer(context, Code.Uid.NaCl), 1,
                Zone.ss_feiji + Code.State.MMM, "1天前", "天命花园空港",
                Name.Kiana + "," + Name.Fuhua,
                UStr.parseComments(Name.YaYi, "以后常来~") + Code.State.split +
                    UStr.parseComments(Name.JiJi, "15号神之键的广告牌真大") + Code.State.split +
                    UStr.parseComments(Name.Fuhua, "大吉大利"),
                null, null,
                "开开飞机，唱唱歌，喝口妹汁，唠唠嗑~"),

            new EventBean(Code.State.EventId + 19, getPlayer(context, Code.Uid.JiJi), 1,
                Zone.ss_key_1 + Code.State.MMM +
                    Zone.ss_key_2 + Code.State.MMM +
                    Zone.ss_key_3 + Code.State.MMM, "2天前", "天命广告位",
                Name.JiJi + "," + Name.Fuhua,
                UStr.parseComments(Name.NvWang, "555555") + Code.State.split +
                    UStr.parseComments(Name.JiJi, "大家都有份") + UStr.parseAt("神之键15号:芽衣") + "还有" + UStr.parseAt("神之键16号:绿托") + Code.State.split +
                    UStr.parseComments(Name.Fuhua, "大吉大利"),
                null, null,
                "最近的神之键计划，各位了解下"),

            new EventBean(Code.State.EventId + 18, getPlayer(context, Code.Uid.NaClFly), 1,
                Zone.ss_nvwang + Code.State.MMM, "4天前", "圣芙蕾雅大门",
                Name.JiJi + "," + Name.Captain,
                UStr.parseComments(Name.Captain, "养不起") + Code.State.split +
                    UStr.parseComments(Name.YaYi, "太咸了") + Code.State.split +
                    UStr.parseComments(Name.JiJi, "来我这里吧，我需要你❤") + Code.State.split +
                    UStr.parseComments(Name.Fuhua, "大吉大利"),
                null, null,
                "5~55~~555~~~"),

            new EventBean(Code.State.EventId + 17, getPlayer(context, Code.Uid.FuHua), 1,
                Zone.ss_fuhhua_chouka + Code.State.MMM, "5天前", "圣芙蕾雅厕所",
                Name.Kiana + "," + Name.Captain,
                UStr.parseComments(Name.Kiana, "班长变回曾经的班长了。") + Code.State.split +
                    UStr.parseComments(Name.Auto, "神农爱你哟╭❤～") + Code.State.split +
                    UStr.parseComments("休伯利安领头人", "羡慕符仔的月轮") + Code.State.split +
                    UStr.parseComments(Name.Delisa, "休伯利安领头人", "舰长把名字改回去。") + Code.State.split +
                    UStr.parseComments(Name.Auto, "休伯利安领头人", "名片转正后才能改哦。") + Code.State.split +
                    UStr.parseComments(Name.Captain, "好哒，木问题~") + Code.State.split +
                    UStr.parseComments(Name.QiGeFei, "舰长，看好你~"),
                null, null,
                "啊啊啊啊，我这是欧气用完了吗？"),

            new EventBean(Code.State.EventId + 16, getPlayer(context, Code.Uid.Captain), 1,
                Code.State.MMM, "7天前", "休伯利安舰桥",
                Name.Auto + "," + Name.Dawei + "," + Name.Fuhua,
                UStr.parseComments(Name.Fuhua, "再叫上仙，我让你拥抱蓝天。") + Code.State.split +
                    UStr.parseComments(Name.Auto, "舰长轻松点，来天命工作了，那大家都是一家人，以后叫她符仔就好。") + Code.State.split +
                    UStr.parseComments(Name.Dawei, "舰长把这里当做自己家就好，别太拘束 ") + UStr.parseAt("阿符") + Code.State.split +
                    UStr.parseComments(Name.Fuhua, "嗯，舰长，您毕竟是舰长，之前是我失礼了") + Code.State.split +
                    UStr.parseComments(Name.Captain, "嗯嗯…符…符仔… :)"),
                null, null,
                "今晚的星空真美啊，符华上仙好，各位领导，女武神们好。这里萌新舰长No:996给大家请安了。"),

            new EventBean(Code.State.EventId + 15, getPlayer(context, Code.Uid.Captain), 1,
                Code.State.MMM, "7天前", "休伯利安员工食堂",
                Name.Delisa + "," + Name.NvWang + "," + Name.YaYi,
                UStr.parseComments(Name.Delisa, "扫厕所去") + Code.State.split +
                    UStr.parseComments(Name.Dawei, "把桶子去掉，我们还是朋友。") + Code.State.split +
                    UStr.parseComments(Name.JiZi, "先把阿符上次抽卡弄坏的厕所门修下") + Code.State.split +
                    UStr.parseComments(Name.Delisa, "哦对，还有档案室的排气口也给修下") + Code.State.split +
                    UStr.parseComments(Name.Fuhua, "月轮啊，那可是影骑士·月轮啊") + Code.State.split +
                    UStr.parseComments(Name.JiZi, Name.Fuhua, "这就是你拆门的理由？") + Code.State.split +
                    UStr.parseComments(Name.Captain, "符...符华上仙早上，中午，晚上好，符华上仙 万岁万万岁！") + Code.State.split +
                    UStr.parseComments(Name.Fuhua, Name.Captain, "万岁？咒我!?") + Code.State.split +
                    UStr.parseComments(Name.Auto, Name.Captain, "捡到手机的就是你吧，别紧张，阿符就像个") + UStr.parseHigh("老", "好人一样，和蔼，温柔。"),
                null, null,
                "各位领导桶子<br/>女武神们大家晚上好<br/>我是休伯利安本分老实的萌新舰长No:996<br/>求混个脸熟。"),

            new EventBean(Code.State.EventId + 14, getPlayer(context, Code.Uid.Captain), 1,
                Code.State.MMM, "7天前", "休伯利安甲板",
                Name.Aii + "," + Name.Dawei + "," + Name.JiZi,
                UStr.parseComments(Name.Delisa, "擦窗子去"),
                null, null,
                "各位领导桶子<br/>女武神们大家中午好<br/>我是休伯利安萌新舰长No:996<br/>求脸熟。"),

            new EventBean(Code.State.EventId + 13, getPlayer(context, Code.Uid.Captain), 1,
                Code.State.MMM, "7天前", "休伯利安舰桥",
                Name.Aii + "," + Name.QiGeFei + "," + Name.YaYi,
                UStr.parseComments(Name.Delisa, "扫甲板去"), null, null,
                "各位领导桶子<br/>女武神们大家早上好<br/>我是休伯利安萌新舰长No:996<br/>请多指教。")
        );


    }

    public void creatEvent(Context context) {
        DbEventHelper.insert(context,
            new EventBean(Code.State.EventId + 1, getPlayer(context, Code.Uid.Auto), 1,
                Zone.kallen + Code.State.MMM, "200年前", "主教王座",
                "逆神巫女",
                UStr.parseComments("赤鸢·精卫", "奥托你醒醒，卡莲已经不在了。还有，别忘记我们的约定！") + Code.State.split +
                    UStr.parseComments("A420", "奥托大人，请节哀。") + Code.State.split +
                    UStr.parseComments("A520", "奥托大人，别放弃，卡莲的灵魂一定会从我们中间转世的！") + Code.State.split +
                    UStr.parseComments("德莉莎·阿波卡利斯", "对不起，爷爷，是我让您失望了...") + Code.State.split +
                    UStr.parseComments("A120", "奥托大人，请用我们的身体召唤卡莲吧！") + Code.State.split +
                    UStr.parseComments("A240", "A120", "我们并没有召唤卡莲的资格") + Code.State.split +
                    UStr.parseComments("德莉莎·阿波卡利斯", "爷爷,对不起...") + Code.State.split +
                    UStr.parseComments("赤鸢·精卫", "抱歉，奥托，我刚刚说的话。") + Code.State.split +
                    UStr.parseComments("赤鸢·精卫", "我能理解你的心情，我也经常梦到伏羲、轩辕他们") + Code.State.split +
                    UStr.parseComments("赤鸢·精卫", "但是，人死不能复生，我们身上还背负着使命。") + Code.State.split +
                    UStr.parseComments("逆神巫女", "嘿嘿嘿,绿托 你放错图了") + Code.State.split +
                    UStr.parseComments("奥托·卡斯兰娜", "逆神巫女", "嘿你妹啊，话说，你从哪里冒出来的啊？！？！你不是已经死了吗？？") + Code.State.split +
                    UStr.parseComments("绯玉丸", "奥托·卡斯兰娜", "地藏御魂的力量，了解一下。"), null, null,
                "卡莲，你在哪里，想你了。我现在已经是主教了，你快回来。。。"),

//            new EventBean(Code.State.EventId + 1, getPlayer(context, Code.Uid.Kosmos), 1,
//                Me.Banner + Code.State.MMM, "时间不详", "三次元",
//                "八重樱，布狼牙，闪光少女✧Kiana，世界第一可爱", "", null, null,
//                parseAt("观众老爷") +
//                    "<br/>就折腾这么多吧，" +
//                    "<br/>大家关于这个App有什么意见或建议的话，" +
//                    "<br/>欢迎私信、留言、加群（854392248）讨论，" +
//                    "<br/>App的源码和安装包整理好了会丢在Github上，" +
//                    "<br/>下载地址可能会出没在视频简介或者评论的某一层" +
//                    "<br/>谢谢观看，千樱在此给大家鞠个躬( • ̀ω•́ )✧"),

            new EventBean(Code.State.EventId + 2, getPlayer(context, Code.Uid.Kallen), 1,
                Zone.SakuraKun + Code.State.MMM, "6天前", "天守阁",
                "闪光少女✧Kiana,布狼牙，世界第一可爱",
                UStr.parseComments("布狼牙", "哇哦~") + Code.State.split +
                    UStr.parseComments("闪光少女✧Kiana", "哇哦~") + Code.State.split +
                    UStr.parseComments("布狼牙", "闪光少女✧Kiana", "笨蛋娜，不要学我") + Code.State.split +
                    UStr.parseComments("嘤嘤嘤", "。。。。") + Code.State.split +
                    UStr.parseComments("世界第一可爱", "学到了，可是要对谁用呢？") + Code.State.split +
                    UStr.parseComments("舰长长", "世界第一可爱", "对我~对我~") + Code.State.split +
                    UStr.parseComments("世界第一可爱", "舰长长", "你想被犹大砸扁吗")
                , null, null,
                "你知道犹大的另一种用法吗" + UStr.parseAt("世界第一可爱")),

            new EventBean(Code.State.EventId + 3, getPlayer(context, Code.Uid.Captain), 1,
                Zone.NaclHotSprings + Code.State.MMM, "5天前", "休伯利安员工宿舍",
                "姬子今年18，小绿帽",
                UStr.parseComments("闪光少女✧Kiana", "这不是我，真不是我！！！") + Code.State.split +
                    UStr.parseComments("芽衣芽衣", "舰长，你果然也对琪亚娜做这样的事") + Code.State.split +
                    UStr.parseComments("闪光少女✧Kiana", "芽衣芽衣", "欸！！！！！！") + Code.State.split +
                    UStr.parseComments("姬子今年18", "嚯哟哟~") + Code.State.split +
                    UStr.parseComments("小绿帽", "贵圈真乱"), null, null,
                "还记得那年的温泉吗" + UStr.parseAt("琪亚娜")),

            new EventBean(Code.State.EventId + 4, getPlayer(context, Code.Uid.NaCl), 1,
                Zone.YaYi + Code.State.MMM, "1天前", "圣芙蕾雅宿舍",
                "闪光少女✧Kiana,芽衣芽衣",
                UStr.parseComments("芽衣芽衣", "(⁄ ⁄•⁄ω⁄•⁄ ⁄)") + Code.State.split +
                    UStr.parseComments("七哥飞", "女儿长大了，可我为什么想哭") + Code.State.split +
                    UStr.parseComments("龙马", "七哥飞", "亲家，借个火")
                , null, null,
                "才不需要治疗，我要喝芽衣的妹汁"),

            new EventBean(Code.State.EventId + 5, getPlayer(context, Code.Uid.Bronya), 1,
                Zone.BengBengBeng + Code.State.MMM, "1天前", "MiHuYo总部",
                "火鸟✧符华，闪光少女✧Kiana，芽衣芽衣",
                UStr.parseComments("火鸟✧符华", "吼吼吼，新的修行之路要开始了吗") + Code.State.split +
                    UStr.parseComments("真·舰长", "板鸭你蹦跶不累吗？") + Code.State.split +
                    UStr.parseComments("机械少女·布狼牙", "真·舰长", "重装小兔，Fire！") + Code.State.split +
                    UStr.parseComments("芽衣芽衣", "布洛尼亚辛苦了~") + Code.State.split +
                    UStr.parseComments("机械少女·布狼牙", "芽衣芽衣", "谢谢芽衣姐姐"), null, null,
                "吼姆大乱斗开发进度90%" + UStr.parseAt("火鸟✧符华")),

            new EventBean(Code.State.EventId + 6, getPlayer(context, Code.Uid.NaCl), 1,
                Zone.NaclMoonRun + Code.State.MMM, "1小时前", "雪狼训练营",
                "闪光少女✧Kiana",
                UStr.parseComments("芽衣芽衣", "琪亚娜你这什么备注啊(⁄ ⁄•⁄ω⁄•⁄ ⁄)"), null, null,
                "芽衣看我在西伯利亚飞驰的身影" + UStr.parseAt("芽衣的妹汁")),

            new EventBean(Code.State.EventId + 7, getPlayer(context, Code.Uid.FuHua), 1,
                Zone.Man80 + Code.State.MMM, "40分钟前", "圣芙蕾雅宿舍厕所",
                "闪光少女✧Kiana，奥托绿者",
                UStr.parseComments("闪光少女✧Kiana", "大佬真乃神人也") + Code.State.split +
                    UStr.parseComments("奥托绿者", "闪光少女✧Kiana", "还真是。"), null, null,
                "是尽头，也是新的开始！！！小小号终于也满80了"),

            new EventBean(Code.State.EventId + 8, getPlayer(context, Code.Uid.FuHua), 1,
                Zone.YueLunGet + Code.State.MMM, "10分钟前", "休伯利安厕所",
                "火鸟✧符华,火鸟✧符华,火鸟✧符华,火鸟✧符华,火鸟✧符华",
                UStr.parseComments("奥托托", "工作时间，不要玩手机，嘛 这么难得，还是恭喜下") + Code.State.split +
                    UStr.parseComments("火鸟✧符华", "奥托托", "奥托大人，天命能换一个logo吗？") + Code.State.split +
                    UStr.parseComments("闪光少女✧Kiana", "莫奈三件套凑齐了？") + Code.State.split +
                    UStr.parseComments("真·休伯利安舰长", "断光出货了？") + Code.State.split +
                    UStr.parseNotice("闪光少女✧Kiana", "爱酱：闪光少女✧Kiana通过【标配补给】获得了", "炽翎角色卡") + Code.State.split +
                    UStr.parseNotice("闪光少女✧Kiana", "爱酱：闪光少女✧Kiana通过【扩充补给】获得了", "空之律者角色卡") + Code.State.split +
                    UStr.parseComments("真·休伯利安舰长", "许愿律化娜，欧皇琪亚娜赐予我魔法") + Code.State.split +
                    UStr.parseComments("芽衣芽衣", "班长为什么总是在厕所肝崩崩崩呢？") + Code.State.split +
                    UStr.parseComments("火鸟✧符华", "全部", "引起不适，已举报"), null, null,
                "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊，我偷渡到欧洲了!!!!"),

            new EventBean(Code.State.EventId + 9, getPlayer(context, Code.Uid.NaCl), 1,
                Zone.ZheNiMa + Code.State.MMM, "8分钟前", "天守阁",
                "闪光少女✧Kiana",
                UStr.parseComments("舰长舰长", "哈哈哈哈哈哈嗝") + Code.State.split +
                    UStr.parseComments("机械少女·布狼牙", "那K423为什么还要给自己点赞"),
                null, null,
                "这尼玛尴尬了"),

            new EventBean(Code.State.EventId + 10, getPlayer(context, Code.Uid.Captain), 1,
                Zone.KaBed + Code.State.MMM, "刚刚", "圣芙蕾雅宿舍",
                "怪盗卡莲,闪光少女✧Kiana,御雷机甲,姬子永远18岁",
                UStr.parseComments("怪盗卡莲", "删除！立刻！马上！") + Code.State.split +
                    UStr.parseComments("舰长大人", "怪盗卡莲", "(ಥ﹏ಥ)你刚刚不是还点赞来着？") + Code.State.split +
                    UStr.parseComments("奥托绿者", "舰长麻烦来总部一趟") + Code.State.split +
                    UStr.parseComments("闪光少女✧Kiana", "hhh,舰长摊事了") + Code.State.split +
                    UStr.parseComments("姬子永远18岁", "哎呀呀~") + Code.State.split +
                    UStr.parseComments("御雷机甲", "Zzzzzz"),
                null, null,
                "哈哈哈哈哈哈，真卡卡卡卡卡莲"),

            new EventBean(Code.State.EventId + 11, getPlayer(context, Code.Uid.Captain), 1,
                Zone.xiongShort + Code.State.MMM, "刚刚", "休伯利安档案室",
                "齐格小灰灰,嗷~脱,姬子永远18岁",
                UStr.parseComments("姬子永远18岁", "你叫谁阿姨？") + Code.State.split +
                    UStr.parseComments("卡卡卡莲", "舰长真是日常作死呢。") + Code.State.split +
                    UStr.parseComments("芽衣", "(⁄ ⁄•⁄ω⁄•⁄ ⁄)舰长根据什么乱排名啊？") + Code.State.split +
                    UStr.parseComments("闪光少女✧Kiana", "芽衣", "我也没看懂，论战力的话，班长不是应该第一吗？") + Code.State.split +
                    UStr.parseComments("嗷~脱", "我觉得太大了也不好，第六的大小最合适~") + Code.State.split +
                    UStr.parseComments("齐格小灰灰", "舰长深的我的真传，我之前还做过一期《休伯利安女武神翘度》的排名") + Code.State.split +
                    UStr.parseComments("嘤嘤嘤", "舰长，粗来！") + Code.State.split +
                    UStr.parseComments("德莉傻", "舰长，粗来！") + Code.State.split +
                    UStr.parseComments("律化娜", "虫豸，粗来！") + Code.State.split +
                    UStr.parseComments("神鸟·阿符", "出来，是不可能出来了。刚刚从休伯利安号排气口掉下去的那个就是") + Code.State.split +
                    UStr.parseComments("德莉傻", "神鸟·阿符", "阿符干得好，大伟去安排下一任舰长竞选") + UStr.parseAt("尼古拉斯·大伟"),
                null, null,
                "在下给休伯利安号的女武神做了一个排名：" +
                    "<br/>" + UStr.parseOrder("第一名", "姬子阿姨&emsp") + UStr.parseOrder("第二名", "芽衣") +
                    "<br/>" + UStr.parseOrder("第三名", "律化娜&emsp&emsp") + UStr.parseOrder("第四名", "八重樱") +
                    "<br/>" + UStr.parseOrder("第五名", "琪亚娜&emsp&emsp") + UStr.parseOrder("第六名", "卡莲") +
                    "<br/>剩下的难以辨认大家自行掂量"),

            new EventBean(Code.State.EventId + 12, DbPlayerHelper.Search(context, Code.Uid.Dawei), 1,
                "", "刚刚", "天命空港",
                "奥托主教，德莉莎·阿波卡利斯，幽兰戴尔，可可利亚",
                UStr.parseComments("奥托主教", "天命已出动神机巴德尔部队，由幽兰戴尔指挥") + Code.State.split +
                    UStr.parseComments("德莉莎·阿波卡利斯", "极东支部休伯利安号正在搜寻原舰长信号来源") + Code.State.split +
                    UStr.parseComments("可可利亚", "逆熵机甲已进入隐形搜寻模式"),
                null, null,
                "<font color= '#732b90'>紧急通知！！！" +
                    "<br/>已殉职休伯利安号舰长的通讯设备现已遗失。" +
                    "<br/>现很可能已经落入外人手中" +
                    "<br/>全体成员立即出动。" +
                    "<br/>务必在机密泄露之前抓回此人。" +
                    "<br/>不论生死。</font>")

        );
        creatEventNest(context);
    }

    private PlayerBean getPlayer(Context context, long key) {
        return DbPlayerHelper.Search(context, key);
    }


}
