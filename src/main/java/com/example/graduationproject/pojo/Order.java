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
     * 0:未付款 1:已付款未发货  2:已发货  3:已收货 4:待评价 5：已评价  6：取消订单

     */
    @Column(name = "order_state")
    private Short orderState;

    @Column(name = "total_price")
    private Double totalPrice;
    /**
     * 商品数量
     */
    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
1:true

     *
     * @return order_state - 0:未付款 1:已付款未发货  2:已发货  3:已收货
1:true

     */
    public Short getOrderState() {
        return orderState;
    }

    /**
     * 设置0:未付款 1:已付款未发货  2:已发货  3:已收货
1:true

     *
     * @param orderState 0:未付款 1:已付款未发货  2:已发货  3:已收货
1:true

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
     * @return order_number
     */
    public Integer getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber
     */
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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
}