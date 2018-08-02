package kos.mos.beng.dao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

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
    @Property(nameInDb = "sex")
    private String sex;//Property-可以自定义字段名，注意外键不能使用该属性)
    @Unique
    private String name;//unique-属性唯一
    private String avatar;//头像
    private int age;

    @Generated(hash = 461461088)
    public PlayerBean(Long id, String sex, String name, String avatar, int age) {
        this.id = id;
        this.sex = sex;
        this.name = name;
        this.avatar = avatar;
        this.age = age;
    }

    @Generated(hash = 288301582)
    public PlayerBean() {
    }

    public PlayerBean(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
