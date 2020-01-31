package com.example.graduationproject.pojo;

import javax.persistence.*;

@Table(name = "t_received_info")
public class ReceivedInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "phone_number")
    private Long phoneNumber;

    private String address;

    /**
     * 1-为默认地址 0-普通地址
     */
    private Short mark;

    @Column(name = "user_id")
    private Integer userId;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取1-为默认地址 0-普通地址
     *
     * @return mark - 1-为默认地址 0-普通地址
     */
    public Short getMark() {
        return mark;
    }

    /**
     * 设置1-为默认地址 0-普通地址
     *
     * @param mark 1-为默认地址 0-普通地址
     */
    public void setMark(Short mark) {
        this.mark = mark;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}