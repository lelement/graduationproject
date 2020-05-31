package com.example.graduationproject.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "received_info_id")
    private Integer receivedInfoId;

    /**
     * 0:未付款 1:已付款未发货  2:已发货  3:已收货


     */
    @Column(name = "order_state")
    private Short orderState;

    @Column(name = "total_price")
    private Double totalPrice;

    /**
     * 要买几本书
     */
    @Column(name = "book_mount")
    private Integer bookMount;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "book_id")
    private Integer bookId;

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

    /**
     * @return received_info_id
     */
    public Integer getReceivedInfoId() {
        return receivedInfoId;
    }

    /**
     * @param receivedInfoId
     */
    public void setReceivedInfoId(Integer receivedInfoId) {
        this.receivedInfoId = receivedInfoId;
    }

    /**
     * 获取0:未付款 1:已付款未发货  2:已发货  3:已收货


     *
     * @return order_state - 0:未付款 1:已付款未发货  2:已发货  3:已收货


     */
    public Short getOrderState() {
        return orderState;
    }

    /**
     * 设置0:未付款 1:已付款未发货  2:已发货  3:已收货


     *
     * @param orderState 0:未付款 1:已付款未发货  2:已发货  3:已收货


     */
    public void setOrderState(Short orderState) {
        this.orderState = orderState;
    }

    /**
     * @return total_price
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取要买几本书
     *
     * @return book_mount - 要买几本书
     */
    public Integer getBookMount() {
        return bookMount;
    }

    /**
     * 设置要买几本书
     *
     * @param bookMount 要买几本书
     */
    public void setBookMount(Integer bookMount) {
        this.bookMount = bookMount;
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
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return book_id
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * @param bookId
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}