package com.example.graduationproject.pojo;

import javax.persistence.*;

@Table(name = "t_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_id")
    private Integer bookId;

    private Integer mount;

    @Column(name = "item_total_price")
    private Double itemTotalPrice;

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

    /**
     * @return mount
     */
    public Integer getMount() {
        return mount;
    }

    /**
     * @param mount
     */
    public void setMount(Integer mount) {
        this.mount = mount;
    }

    /**
     * @return item_total_price
     */
    public Double getItemTotalPrice() {
        return itemTotalPrice;
    }

    /**
     * @param itemTotalPrice
     */
    public void setItemTotalPrice(Double itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }
}