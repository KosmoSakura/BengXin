package kos.mos.beng.dao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:32
 * @Email: KosmoSakura@foxmail.com
 * @Event:
 */
@Entity
public class EventBean {
    @Id(autoincrement = true)
    private Long id;//不能用int, autoincrement = true 主键自增
    private int type;//1:图文，2：链接
    private String name;//unique-属性唯一
    private String avatar;//头像
    private String describe;//描述
//    private List<String> images;
    private String address;//圣芙蕾雅学院
    private String time;//1分钟前
    private String sort;//分类：天命通讯
    private String point;//点赞
    private String commenter;//评论者
    private String comment;//评论内容
    private String linkTitle;
    private String linkImage;

    @Generated(hash = 1000402370)
    public EventBean(Long id, int type, String name, String avatar, String describe,
                     String address, String time, String sort, String point,
                     String commenter, String comment, String linkTitle, String linkImage) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.avatar = avatar;
        this.describe = describe;
        this.address = address;
        this.time = time;
        this.sort = sort;
        this.point = point;
        this.commenter = commenter;
        this.comment = comment;
        this.linkTitle = linkTitle;
        this.linkImage = linkImage;
    }

    @Generated(hash = 1783294599)
    public EventBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getDescribe() {
        return this.describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPoint() {
        return this.point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getCommenter() {
        return this.commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLinkTitle() {
        return this.linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLinkImage() {
        return this.linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }


}
