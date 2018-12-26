package kos.mos.beng.dao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:32
 * @Email: KosmoSakura@foxmail.com
 */
@Entity(generateConstructors = false)
public class EventBean {
    @Id
    private Long id;
    private int type;//1:图文，2：链接,3:数字图片
    private String describe;//描述
    /**
     * sb.append(link);
     * sb.append(",");
     * List<String> list = Arrays.asList(databaseValue.split(","));
     */
    private String images;
    private String time;//1分钟前
    private String point;//点赞
    private String comments;//评论者+评论内容
    private String linkTitle;
    private String linkImage;
    private String eventAddress;
    private String name;
    private String avatar;//头像
    private String phoneModel;//手机型号：天命通讯

    public EventBean(Long id, PlayerBean bean, int type,
                     String images, String time, String eventAddress, String point, String comments,
                     String linkTitle, String linkImage, String describe) {
        this.id = id;
        this.type = type;
        this.describe = describe;
        this.images = images;
        this.time = time;
        this.point = point;
        this.eventAddress = eventAddress;
        this.comments = comments;
        this.linkTitle = linkTitle;
        this.linkImage = linkImage;
        if (bean != null) {
            this.name = bean.getName();
            this.avatar = bean.getAvatar();
            this.phoneModel = bean.getPhoneModel();
        }
    }

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

    public String getDescribe() {
        return this.describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImages() {
        return this.images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPoint() {
        return this.point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getEventAddress() {
        return this.eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
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

    public String getPhoneModel() {
        return this.phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

}
