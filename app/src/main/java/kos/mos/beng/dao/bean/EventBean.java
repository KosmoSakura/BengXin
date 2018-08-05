package kos.mos.beng.dao.bean;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import kos.mos.beng.dao.gen.DaoSession;
import kos.mos.beng.dao.gen.EventBeanDao;
import kos.mos.beng.dao.gen.PlayerBeanDao;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:32
 * @Email: KosmoSakura@foxmail.com
 */
@Entity(generateConstructors = false)
public class EventBean {
    @Id(autoincrement = true)
    private Long id;
    private int type;//1:图文，2：链接
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
    @ToOne
    private PlayerBean bean;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 519173234)
    private transient EventBeanDao myDao;
    @Generated(hash = 781616881)
    private transient boolean bean__refreshed;

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
        this.bean = bean;
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

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 326759599)
    public PlayerBean getBean() {
        if (bean != null || !bean__refreshed) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlayerBeanDao targetDao = daoSession.getPlayerBeanDao();
            targetDao.refresh(bean);
            bean__refreshed = true;
        }
        return bean;
    }

    /**
     * To-one relationship, returned entity is not refreshed and may carry only the PK property.
     */
    @Generated(hash = 81766737)
    public PlayerBean peakBean() {
        return bean;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1258350067)
    public void setBean(PlayerBean bean) {
        synchronized (this) {
            this.bean = bean;
            bean__refreshed = true;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1741896799)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEventBeanDao() : null;
    }

    public String getEventAddress() {
        return this.eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }


}
