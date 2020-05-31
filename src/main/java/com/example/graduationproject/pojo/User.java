package com.example.graduationproject.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone_number")
    private Long phoneNumber;

    private String password;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "create_time")
    private Date createTime;

    private Integer age;
    /**
     * 男--0      女-1
     */
    private Short sex;

    /**
     * 非会员-0 会员-1

     */
    private Short vip;

    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 用户-0    管理员-1
     */
    private Short mark;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return phone_number
     */
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取男--0      女-1
     *
     * @return sex - 男--0      女-1
     */
    public Short getSex() {
        return sex;
    }

    /**
     * 设置男--0      女-1
     *
     * @param sex 男--0      女-1
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * 获取非会员-0 会员-1

     *
     * @return vip - 非会员-0 会员-1

     */
    public Short getVip() {
        return vip;
    }

    /**
     * 设置非会员-0 会员-1

     *
     * @param vip 非会员-0 会员-1

     */
    public void setVip(Short vip) {
        this.vip = vip;
    }

    /**
     * @return img_url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取用户-0    管理员-1
     *
     * @return mark - 用户-0    管理员-1
     */
    public Short getMark() {
        return mark;
    }

    /**
     * 设置用户-0    管理员-1
     *
     * @param mark 用户-0    管理员-1
     */
    public void setMark(Short mark) {
        this.mark = mark;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}