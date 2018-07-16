package spring.user.bean;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private String passWord;

    private Date createTime;

    //省略getset和toString方法

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserBean{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", passWord='").append(passWord).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}