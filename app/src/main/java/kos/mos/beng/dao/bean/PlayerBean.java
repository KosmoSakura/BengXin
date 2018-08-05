package kos.mos.beng.dao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:16
 * @Email: KosmoSakura@foxmail.com
 */
@Entity(generateConstructors = false)
public class PlayerBean {
    @Id
    private Long id;//autoincrement = true
    private int sex;//男-1，女--1， ？？-0
    private String uid;
    private String sexStr;
    private String name;//unique-属性唯一
    private String avatar;//头像
    private String address;//圣芙蕾雅学院
    private String phoneModel;//手机型号：天命通讯
    private String describe;//签名
    private String banner;//朋友圈展示图
    private int age;//年龄
    private String hobby;//爱好
    private boolean me;

    public PlayerBean(Long id, String uid, int sex, String sexStr, String name, String avatar,
                      String address, String phoneModel, String describe, String banner,
                      int age, String hobby, boolean me) {
        this.uid = uid;
        this.id = id;
        this.sex = sex;
        this.sexStr = sexStr;
        this.name = name;
        this.avatar = avatar;
        this.address = address;
        this.phoneModel = phoneModel;
        this.describe = describe;
        this.banner = banner;
        this.age = age;
        this.hobby = hobby;
        this.me = me;
    }

    public PlayerBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSexStr() {
        return this.sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneModel() {
        return this.phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getDescribe() {
        return this.describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getBanner() {
        return this.banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return this.hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public boolean getMe() {
        return this.me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
