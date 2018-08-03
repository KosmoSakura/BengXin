package kos.mos.beng.dao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:16
 * @Email: KosmoSakura@foxmail.com
 * @Event:
 */
@Entity //告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作
public class PlayerBean {
    @Id
    private Long id;//不能用int, autoincrement = true 主键自增）
    private int sex;//男-1，女--1， ？？-0
    private String sexStr;
    @Unique
    private String name;//unique-属性唯一
    private String avatar;//头像
    private String address;//圣芙蕾雅学院
    private String phoneModel;//手机型号：天命通讯
    private String describe;//签名
    private int age;//年龄
    private boolean me;

    @Generated(hash = 1605734744)
    public PlayerBean(Long id, int sex, String sexStr, String name, String avatar,
                      String address, String phoneModel, String describe, int age,
                      boolean me) {
        this.id = id;
        this.sex = sex;
        this.sexStr = sexStr;
        this.name = name;
        this.avatar = avatar;
        this.address = address;
        this.phoneModel = phoneModel;
        this.describe = describe;
        this.age = age;
        this.me = me;
    }

    @Generated(hash = 288301582)
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getMe() {
        return this.me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }


}
