package com.example.graduationproject.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name")
    private String bookName;

    private Double price;

    @Column(name = "writer_name")
    private String writerName;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 书库中剩余数量
     */
    private Integer mount;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "book_kind_id")
    private Integer bookKindId;

    private String production;

    /**
     * 销售数量
     */
    @Column(name = "sale_mount")
    private Integer saleMount;

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
     * @return book_name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName
     */
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    /**
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return writer_name
     */
    public String getWriterName() {
        return writerName;
    }

    /**
     * @param writerName
     */
    public void setWriterName(String writerName) {
        this.writerName = writerName == null ? null : writerName.trim();
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
     * 获取书库中剩余数量
     *
     * @return mount - 书库中剩余数量
     */
    public Integer getMount() {
        return mount;
    }

    /**
     * 设置书库中剩余数量
     *
     * @param mount 书库中剩余数量
     */
    public void setMount(Integer mount) {
        this.mount = mount;
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
     * @return book_kind_id
     */
    public Integer getBookKindId() {
        return bookKindId;
    }

    /**
     * @param bookKindId
     */
    public void setBookKindId(Integer bookKindId) {
        this.bookKindId = bookKindId;
    }

    /**
     * @return production
     */
    public String getProduction() {
        return production;
    }

    /**
     * @param production
     */
    public void setProduction(String production) {
        this.production = production == null ? null : production.trim();
    }


    public Integer getSaleMount() {
        return saleMount;
    }

    public void setSaleMount(Integer saleMount) {
        this.saleMount = saleMount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", writerName='" + writerName + '\'' +
                ", createTime=" + createTime +
                ", mount=" + mount +
                ", imgUrl='" + imgUrl + '\'' +
                ", bookKindId=" + bookKindId +
                ", production='" + production + '\'' +
                ", saleMount=" + saleMount +
                '}';
    }
}