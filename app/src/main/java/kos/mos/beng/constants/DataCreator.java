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
        String Base = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/";
        String NaCl = Base + "ic_nacl.png";//琪亚娜-卡斯兰娜
        String NaClMoon = Base + "NaClMoon.jpeg";//琪亚娜-卡斯兰娜
        String NaClFly = Base + "NaClFly.png";
        String flyTogether = Base + "fei.png";
        String flyDown = Base + "flyDown.png";
        String dentist = Base + "dentist.png";
        String Bronya = Base + "BronyaBeng.png";
        String jizi = Base + "jizi.png";
        String lover = Base + "lover.png";
        String firefox = Base + "firefox.png";
        String kallen = Base + "kallen.png";
        String Sakura = Base + "ic_sakuraura.png";//八重樱
        String Theresa = Base + "Theresa.png";//德莉傻-阿波卡利斯
        String Dawei = Base + "Dawei.png";//尼古拉斯-大伟
        String Auto = Base + "Auto.png";//奥托
        String fuHua = Base + "fuHua.png";//奥托
        String ai = Base + "ai.png";
        String cptain = Base + "JianZhang.png";
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

        String kallen = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324007575&di=17dd9510081669843e289d0082cdfc39&imgtype=0&src=http%3A%2F%2Fattach10.92wy.com%2Fimages%2F2018%2F0511%2F1526014777a99283f5.jpg";
        String Theresa = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324222290&di=b5da45f6e5e3db1878ae0809a4680779&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fa33af8aeed817866cfaf2495c082d8aaa2222d6c.jpg";//德莉傻-阿波卡利斯
        String Dawei = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=644500532,484138190&fm=27&gp=0.jpg";
        String Auto = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324318010&di=08c5e76112d1fc7fe9bdaf54aae09665&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D1813743542%2C3042565469%26fm%3D214%26gp%3D0.jpg";//奥托
        String fuHua = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324381148&di=adde5fbf39e9ffa51a10d7649833b294&imgtype=0&src=http%3A%2F%2Fhiphotos.baidu.com%2Ffeed%2Fpic%2Fitem%2Fe1fe9925bc315c6070a2155981b1cb1349547754.jpg";
        String ai = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324451077&di=269536e2a31e373e5972fe4259b242ca&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Ff1530a6e092ccc97484acafb07ba12bcb1024766.jpg";
        String cptain = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533324536616&di=d68e4c40fdb2f92c6e51dc57779a76b2&imgtype=0&src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2Fbfaa36e5e0c8a9e2090122991339226bf090f9f9.jpg";

        String BASE = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/banner/";
        String firefox = BASE + "banner_firefox.png";
        String SakuraSnow = BASE + "sakura_sonw.png";
    }

    interface Me {
        String Banner = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/kosmos/banner.jpg";
        String Circle = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/kosmos/circle.png";
        String Normal = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/kosmos/normal.png";
    }

    public void creatPlayer(Context context) {
        DbPlayerHelper.insert(context,
            new PlayerBean(Code.Uid.NaCl, "NaCl", -1, "女", "闪光少女✧Kiana",
                Avatar.NaClMoon, "圣芙蕾雅学园", "娜娜的小灵通",
                "饿不饿宅急送：1871234567\n新款鲜榨饮品《芽衣的妹汁》已到货", Banner.nacl, 17, "芽衣的妹汁", false),

            new PlayerBean(Code.Uid.NaClFly, "NaClFly", -1, "女",
                "崩坏女王", Avatar.NaClFly, "天上", "意念传声",
                "恕我直言，在座的各位都是垃圾", Banner.NaClFly, 17, "毁灭人类", false),

            new PlayerBean(Code.Uid.FlyTogether, "FlyTogether", 1, "男",
                "齐格飞", Avatar.flyTogether, "去西伯利亚的路上", "反天命通讯",
                "狗天命，还我老婆", Banner.flyTogether, 27, "塞西莉亚", false),

            new PlayerBean(Code.Uid.FlyDown, "FlyAnywhere", -1, "女", "塞西莉亚",
                Avatar.flyDown, "西伯利亚", "天命通讯", "希望我的琪亚娜早点长大", Banner.flyDown,
                27, "琪亚娜", false),

            new PlayerBean(Code.Uid.Dentist, "dentist", -1, "女", "芽衣芽衣",
                Avatar.dentist, "圣芙蕾雅学园", "圣芙蕾雅电磁波", "街电租赁，陪逛街免费充电٩(๑❛ᴗ❛๑)۶",
                Banner.dentist, 17, "琪亚娜", false),

            new PlayerBean(Code.Uid.Bronya, "duck", -1, "女", "机械少女·布狼牙",
                Avatar.Bronya, "圣芙蕾雅学园", "天命通讯", "吼姆大乱斗开发进度57%",
                Banner.Bronya, 16, "吼姆", false),

            new PlayerBean(Code.Uid.Jizi, "18forever", -1, "女", "姬子❤姐姐", Avatar.jizi,
                "休伯利安", "天命通讯", "今天的姬子有男朋友吗？",
                Banner.jizi, 18, "男", false),

            new PlayerBean(Code.Uid.SakuraLover, "Sakura", -1, "女", "八重嘤✿",
                Avatar.lover, "八重村", "绯玉丸", "舰长补给全保底，舰长副本零掉落",
                Banner.SakuraSnow, 520, "卡莲卡莲", false),

            new PlayerBean(Code.Uid.Kallen, "00001", -1, "女", "怪盗·卡莲",
                Avatar.kallen, "八重村", "天命通讯", "樱，你真美！",
                Banner.kallen, 520, "嘤嘤嘤", false),

            new PlayerBean(Code.Uid.Firefox, "Firefox", -1, "女", "火狐狸·绯玉丸",
                Avatar.firefox, "八重村", "绯玉丸",
                "大姐，大姐，我要油炸豆腐", Banner.firefox, 10000,
                "油炸豆腐", false),

            new PlayerBean(Code.Uid.Theresa, "A-310", -1, "女", "德莉莎",
                Avatar.Theresa, "圣芙蕾雅学园", "犹大索敌模式",
                "德莉莎世界第一可爱", Banner.Theresa, 40, "苦瓜汁", false),

            new PlayerBean(Code.Uid.Auto, "00000", 1, "男", "奥托·阿波卡利斯",
                Avatar.Auto, "天命空港", "天命通讯(主教限定)",
                "苍茫的天涯是我的爱，绿油油的头顶花正开", Zone.KaSmail, 555, "卡莲", false),

            new PlayerBean(Code.Uid.FuHua, "FireBird", -1, "女", "火鸟✧符华",
                Avatar.fuHua, "神舟", "喏基亚N95", "舞之道，永无止步！",
                Banner.fuHua, 5000, "崩崩崩", false),

            new PlayerBean(Code.Uid.Dawei, "DV", 1, "男", "尼古拉斯·大伟",
                Avatar.Dawei, "MiHuYo大楼", "IPhone9",
                "我是HuYoNi总裁，现被某鸭所害，急需1000元律师费，等我坐回原来的位置任你为CTO，吱腐宝：huyoni@BanYa.com",
                Banner.Dawei, 35, "Money", false),

            new PlayerBean(Code.Uid.Ai, "89757", -1, "女", "包菜头·爱酱",
                Avatar.ai, "包菜种植基地", "天命通讯", "这个人很懒，只留下了一颗发了芽的包菜",
                Banner.ai, 0, "偷电", false),
            new PlayerBean(Code.Uid.Captain, "11872324", 1, "男",
                "休伯利安唯一指定舰长", Avatar.cptain, "休伯利安",
                "红米Note", "你能体会那种养了一船老婆的鸭梨吗",
                Banner.cptain, 30, "开飞机和休伯利安", false),

            new PlayerBean(Code.Uid.Kosmos, "KosmoSakura", 1, "男", "赤夜千樱",
                Me.Normal, "三次元", "HWP9", "被赤色夜空染色的一千株樱花在零时凋落的声音",
                Me.Banner, 0, "Vocaloid，Code，八重樱老婆", false));
    }

    interface Zone {
        String BASE = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/event/";
        String NaclCry = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533455105524&di=358d869f17ad9302a6452ac1a279bb23&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Fface%2F218d70030c312b4dee8df7e53b02a4cfc8a8e3d9.jpg";
        String NaclHotSprings = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533455226383&di=3b399f0095042ef1ad465d43a4c14016&imgtype=0&src=http%3A%2F%2Fwww.xz7.com%2Fup%2F2017-9%2F201792193913.jpg";
        //红月卡莲
        String kallen = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533298890267&di=d160f22d2728c7ebc02f18a585bbb5a4&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fbaike%2Fpic%2Fitem%2Fbd3eb13533fa828b94b3d645fd1f4134960a5a87.jpg";
        String BengBengBeng = BASE + "bengbengbeng.gif";
        String KaBed = BASE + "kakakakalian.png";
        String YaYi = BASE + "yayiyayiya.png";
        String KaSmail = BASE + "kaliansmail.png";
        String Man80 = BASE + "man80.png";
        String NaclMoonRun = BASE + "nacl_moon.jpg";
        String SakuraKun = BASE + "sakura_kunbang.png";
        String YueLunGet = BASE + "yuelunget.png";
        String ZheNiMa = BASE + "zhenima.png";
        String xiongLong = BASE + "xiong_long.png";
        String xiongShort = BASE + "xiong_short.png";
    }

    //ಠ  ω (ಥ﹏ಥ)(´థ౪థ)σ ✧ ❥ ✿ ☆ ヾ(◍°∇°◍)ﾉﾞ (｡◕ˇ∀ˇ◕)
    //㊣☆☺☹®©☊☋℡
    public void creatEvent(Context context) {
        DbEventHelper.insert(context,
            new EventBean(Code.State.EventId - 1, getPlayer(context, Code.Uid.Captain), 1,
                Zone.xiongShort + Code.State.MMM, "刚刚", "休伯利安档案室",
                "齐格小灰灰,嗷~脱,姬子永远18岁",
                parseComments("姬子永远18岁", "你叫谁阿姨？") + Code.State.split +
                    parseComments("卡卡卡莲", "舰长真是日常作死呢。") + Code.State.split +
                    parseComments("芽衣", "(⁄ ⁄•⁄ω⁄•⁄ ⁄)舰长根据什么乱排名啊？") + Code.State.split +
                    parseCommentsBack("闪光少女✧Kiana", "芽衣", "我也没看懂，论战力的话，班长不是应该第一吗？") + Code.State.split +
                    parseComments("嗷~脱", "我觉得太大了也不好，第六的大小最合适~") + Code.State.split +
                    parseComments("齐格小灰灰", "舰长深的我的真传，我之前还做过一期《休伯利安女武神翘度》的排名") + Code.State.split +
                    parseComments("嘤嘤嘤", "舰长，粗来！") + Code.State.split +
                    parseComments("德莉傻", "舰长，粗来！") + Code.State.split +
                    parseComments("律化娜", "虫豸，粗来！") + Code.State.split +
                    parseComments("神鸟·阿符", "出来，是不可能出来了。刚刚从休伯利安号排气口掉下去的那个就是") + Code.State.split +
                    parseCommentsBack("德莉傻", "神鸟·阿符", "阿符干得好，大伟去安排下一任舰长竞选") + parseAt("尼古拉斯·大伟"),
                null, null,
                "在下给休伯利安号的女武神做了一个排名：" +
                    "<br/>" + parseOrder("第一名", "姬子阿姨&emsp") + parseOrder("第二名", "芽衣") +
                    "<br/>" + parseOrder("第三名", "律化娜&emsp&emsp") + parseOrder("第四名", "八重樱") +
                    "<br/>" + parseOrder("第五名", "琪亚娜&emsp&emsp") + parseOrder("第六名", "卡莲") +
                    "<br/>剩下的难以辨认大家自行掂量"),

            new EventBean(Code.State.EventId + 9, getPlayer(context, Code.Uid.Kosmos), 1,
                Me.Banner + Code.State.MMM, "时间不详", "三次元",
                "八重樱，布狼牙，闪光少女✧Kiana，世界第一可爱", "", null, null,
                parseAt("观众老爷") +
                    "<br/>就折腾这么多吧，" +
                    "<br/>大家关于这个App有什么意见或建议的话，" +
                    "<br/>欢迎私信、留言、加群（854392248）讨论，" +
                    "<br/>App的源码和安装包整理好了会丢在Github上，" +
                    "<br/>下载地址可能会出没在视频简介或者评论的某一层" +
                    "<br/>谢谢观看，千樱在此给大家鞠个躬( • ̀ω•́ )✧"),

            new EventBean(Code.State.EventId, getPlayer(context, Code.Uid.Captain), 1,
                Zone.KaBed + Code.State.MMM, "刚刚", "圣芙蕾雅宿舍",
                "怪盗卡莲,闪光少女✧Kiana,御雷机甲,姬子永远18岁",
                parseComments("怪盗卡莲", "删除！立刻！马上！") + Code.State.split +
                    parseCommentsBack("舰长大人", "怪盗卡莲", "(ಥ﹏ಥ)你刚刚不是还点赞来着？") + Code.State.split +
                    parseComments("奥托绿者", "舰长麻烦来总部一趟") + Code.State.split +
                    parseComments("闪光少女✧Kiana", "hhh,舰长摊事了") + Code.State.split +
                    parseComments("姬子永远18岁", "哎呀呀~") + Code.State.split +
                    parseComments("御雷机甲", "Zzzzzz"),
                null, null,
                "哈哈哈哈哈哈，真卡卡卡卡卡莲"),

            new EventBean(Code.State.EventId + 1, getPlayer(context, Code.Uid.NaCl), 1,
                Zone.ZheNiMa + Code.State.MMM, "8分钟前", "天守阁",
                "闪光少女✧Kiana",
                parseComments("舰长舰长", "哈哈哈哈哈哈嗝") + Code.State.split +
                    parseComments("机械少女·布狼牙", "那K423为什么还要给自己点赞"),
                null, null,
                "这尼玛尴尬了"),


            new EventBean(Code.State.EventId + 2, getPlayer(context, Code.Uid.FuHua), 1,
                Zone.YueLunGet + Code.State.MMM, "10分钟前", "休伯利安厕所",
                "火鸟✧符华,火鸟✧符华,火鸟✧符华,火鸟✧符华,火鸟✧符华",
                parseComments("奥托托", "工作时间，不要玩手机，嘛 这么难得，还是恭喜下") + Code.State.split +
                    parseCommentsBack("火鸟✧符华", "奥托托", "奥托大人，天命能换一个logo吗？") + Code.State.split +
                    parseComments("闪光少女✧Kiana", "莫奈三件套凑齐了？") + Code.State.split +
                    parseComments("真·休伯利安舰长", "断光出货了？") + Code.State.split +
                    parseNotice("闪光少女✧Kiana", "爱酱：闪光少女✧Kiana通过【标配补给】获得了", "炽翎角色卡") + Code.State.split +
                    parseNotice("闪光少女✧Kiana", "爱酱：闪光少女✧Kiana通过【扩充补给】获得了", "空之律者角色卡") + Code.State.split +
                    parseComments("真·休伯利安舰长", "许愿律化娜，欧皇琪亚娜赐予我魔法") + Code.State.split +
                    parseComments("芽衣芽衣", "班长为什么总是在厕所肝崩崩崩呢？") + Code.State.split +
                    parseCommentsBack("火鸟✧符华", "全部", "引起不适，已举报"), null, null,
                "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊，我偷渡到欧洲了!!!!"),

            new EventBean(Code.State.EventId + 3, getPlayer(context, Code.Uid.FuHua), 1,
                Zone.Man80 + Code.State.MMM, "40分钟前", "圣芙蕾雅宿舍厕所",
                "闪光少女✧Kiana，奥托绿者",
                parseComments("闪光少女✧Kiana", "大佬真乃神人也") + Code.State.split +
                    parseCommentsBack("奥托绿者", "闪光少女✧Kiana", "还真是。"), null, null,
                "是尽头，也是新的开始！！！小小号终于也满80了"),

            new EventBean(Code.State.EventId + 4, getPlayer(context, Code.Uid.NaCl), 1,
                Zone.NaclMoonRun + Code.State.MMM, "1小时前", "雪狼训练营",
                "闪光少女✧Kiana",
                parseComments("芽衣芽衣", "琪亚娜你这什么备注啊(⁄ ⁄•⁄ω⁄•⁄ ⁄)"), null, null,
                "芽衣看我在西伯利亚飞驰的身影" + parseAt("芽衣的妹汁")),

            new EventBean(Code.State.EventId + 5, getPlayer(context, Code.Uid.Bronya), 1,
                Zone.BengBengBeng + Code.State.MMM, "1天前", "MiHuYo总部",
                "火鸟✧符华，闪光少女✧Kiana，芽衣芽衣",
                parseComments("火鸟✧符华", "吼吼吼，新的修行之路要开始了吗") + Code.State.split +
                    parseComments("真·舰长", "板鸭你蹦跶不累吗？") + Code.State.split +
                    parseCommentsBack("机械少女·布狼牙", "真·舰长", "重装小兔，Fire！") + Code.State.split +
                    parseComments("芽衣芽衣", "布洛尼亚辛苦了~") + Code.State.split +
                    parseCommentsBack("机械少女·布狼牙", "芽衣芽衣", "谢谢芽衣姐姐"), null, null,
                "吼姆大乱斗开发进度90%" + parseAt("火鸟✧符华")),

            new EventBean(Code.State.EventId + 6, getPlayer(context, Code.Uid.NaCl), 1,
                Zone.YaYi + Code.State.MMM, "1天前", "圣芙蕾雅宿舍",
                "闪光少女✧Kiana,芽衣芽衣",
                parseComments("芽衣芽衣", "(⁄ ⁄•⁄ω⁄•⁄ ⁄)") + Code.State.split +
                    parseComments("七哥飞", "女儿长大了，可我为什么想哭") + Code.State.split +
                    parseCommentsBack("龙马", "七哥飞", "亲家，借个火")
                , null, null,
                "才不需要治疗，我要喝芽衣的妹汁"),

            new EventBean(Code.State.EventId + 7, getPlayer(context, Code.Uid.Captain), 1,
                Zone.NaclHotSprings + Code.State.MMM, "5天前", "休伯利安员工宿舍",
                "姬子今年18，小绿帽",
                parseComments("闪光少女✧Kiana", "这不是我，真不是我！！！") + Code.State.split +
                    parseComments("芽衣芽衣", "舰长，你果然也对琪亚娜做这样的事") + Code.State.split +
                    parseCommentsBack("闪光少女✧Kiana", "芽衣芽衣", "欸！！！！！！") + Code.State.split +
                    parseComments("姬子今年18", "嚯哟哟~") + Code.State.split +
                    parseComments("小绿帽", "贵圈真乱"), null, null,
                "还记得那年的温泉吗" + parseAt("琪亚娜")),

            new EventBean(Code.State.EventId + 8, getPlayer(context, Code.Uid.Kallen), 1,
                Zone.SakuraKun + Code.State.MMM, "6天前", "天守阁",
                "闪光少女✧Kiana,布狼牙，世界第一可爱",
                parseComments("布狼牙", "哇哦~") + Code.State.split +
                    parseComments("闪光少女✧Kiana", "哇哦~") + Code.State.split +
                    parseCommentsBack("布狼牙", "闪光少女✧Kiana", "笨蛋娜，不要学我") + Code.State.split +
                    parseComments("嘤嘤嘤", "。。。。") + Code.State.split +
                    parseComments("世界第一可爱", "学到了，可是要对谁用呢？") + Code.State.split +
                    parseCommentsBack("舰长长", "世界第一可爱", "对我~对我~") + Code.State.split +
                    parseCommentsBack("世界第一可爱", "舰长长", "你想被犹大砸扁吗")
                , null, null,
                "你知道犹大的另一种用法吗" + parseAt("世界第一可爱")),

            new EventBean(Code.State.EventId + 10, getPlayer(context, Code.Uid.Auto), 1,
                Zone.kallen + Code.State.MMM, "200年前", "主教王座",
                "逆神巫女",
                parseComments("赤鸢·精卫", "奥托你醒醒，卡莲已经不在了。还有，别忘记我们的约定！") + Code.State.split +
                    parseComments("A420", "奥托大人，请节哀。") + Code.State.split +
                    parseComments("A520", "奥托大人，别放弃，卡莲的灵魂一定会从我们中间转世的！") + Code.State.split +
                    parseComments("德莉莎·阿波卡利斯", "对不起，爷爷，是我让您失望了...") + Code.State.split +
                    parseComments("A120", "奥托大人，请用我们的身体召唤卡莲吧！") + Code.State.split +
                    parseCommentsBack("A240", "A120", "我们并没有召唤卡莲的资格") + Code.State.split +
                    parseComments("德莉莎·阿波卡利斯", "爷爷,对不起...") + Code.State.split +
                    parseComments("赤鸢·精卫", "抱歉，奥托，我刚刚说的话。") + Code.State.split +
                    parseComments("赤鸢·精卫", "我能理解你的心情，我也经常梦到伏羲、轩辕他们") + Code.State.split +
                    parseComments("赤鸢·精卫", "但是，人死不能复生，我们身上还背负着使命。") + Code.State.split +
                    parseComments("逆神巫女", "嘿嘿嘿,绿托 你放错图了") + Code.State.split +
                    parseCommentsBack("奥托·卡斯兰娜", "逆神巫女", "嘿你妹啊，话说，你从哪里冒出来的啊？！？！你不是已经死了吗？？") + Code.State.split +
                    parseCommentsBack("绯玉丸", "奥托·卡斯兰娜", "地藏御魂的力量，了解一下。"), null, null,
                "卡莲，你在哪里，想你了。我现在已经是主教了，你快回来。。。")
        );

    }

    /**
     * 评论: Spanned spanned = Html.fromHtml(name);
     */
    private String parseCommentsBack(String nameA, String nameB, String comments) {
        return "<font color= '#5501b5c6'>" + nameA + "</font> 回复" +
            "<font color= '#5501b5c6'>" + nameB + "</font> ：" +
            " <font color= '#21211d'>" + comments + "</font>";
    }

    private String parseComments(String name, String comments) {
        return "<font color= '#5501b5c6'>" + name + "</font> ：<font color= '#21211d'>" + comments + "</font>";
    }

    private String parseOrder(String name, String comments) {
        return "<font color= '#5501b5c6'>" + name + "：</font><font color= '#732b90'>" + comments + "</font>";
    }

    private String parseNotice(String name, String str1, String str2) {
        return "<font color= '#5501b5c6'>" + name + "</font> ：" +
            "<font color= '#ef5a3d'>" + str1 + "</font> ：<font color= '#732b90'>" + str2 + "</font>";
    }

    private String parseAt(String str) {
        return "<font color= '#5501b5c6'>@" + str + "</font>";
    }

    private PlayerBean getPlayer(Context context, long key) {
        return DbPlayerHelper.Search(context, key);
    }

    public void creatEvent(Context context, PlayerBean bean) {

    }


}
