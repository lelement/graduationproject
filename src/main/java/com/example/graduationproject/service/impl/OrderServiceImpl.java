package com.example.graduationproject.service.impl;

import com.example.graduationproject.common.Constant;
import com.example.graduationproject.dao.*;
import com.example.graduationproject.dto.OrderDto;
import com.example.graduationproject.pojo.*;
import com.example.graduationproject.request.*;
import com.example.graduationproject.response.OrderResponse;
import com.example.graduationproject.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ReceivedInfoService receivedInfoService;
    @Autowired
    private ReceivedInfoDao receivedInfoDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addOrder(AddOrderRequest addOrderRequest) {
        Book book = bookDao.selBookById(addOrderRequest.getBookId());
        book.setMount(book.getMount() - addOrderRequest.getBookMount());
        book.setSaleMount(book.getSaleMount() + addOrderRequest.getBookMount());
        bookDao.updBook(book);
        Order order = new Order();
        BeanUtils.copyProperties(addOrderRequest, order);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        return orderDao.addOrder(order);
    }

    @Override
    public Integer deleteOrderById(Integer orderId) {
        return orderDao.deleteOrderById(orderId);
    }

    @Override
    public Integer updOrderItem(OrderDto orderDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        if (orderDto.getExpressNum()!=null) {
            stringRedisTemplate.opsForValue().set(order.getId().toString(), orderDto.getExpressNum(), 30, TimeUnit.DAYS);
        }
        return orderDao.updOrder(order);
    }

    /**
     * 读者根据userId查询不同支付状态下的所有订单
     *
     * @return
     */
    @Override
    public OrderResponseList selOrder(Integer userId, Short orderState, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        OrderResponseList orderResponseList = new OrderResponseList();
        List<OrderResponse> orderResponses = new ArrayList<>();
        List<Order> orderList = orderDao.getOrderByUserIdAndStatus(userId, orderState);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        for (Order order : pageInfo.getList()) {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setBook(bookDao.selBookById(order.getBookId()));
            orderResponse.setExpressNum(stringRedisTemplate.opsForValue().get(order.getId().toString()));
            ReceivedInfo receivedInfo = receivedInfoDao.selectById(order.getReceivedInfoId());
            orderResponse.setReceivedInfo(receivedInfo);
            orderResponse.setUser(userDao.getUserById(order.getUserId()));
            BeanUtils.copyProperties(order, orderResponse);
            orderResponses.add(orderResponse);
        }
        orderResponseList.setOrderResponseList(orderResponses);
        orderResponseList.setTotal(pageInfo.getTotal());
        return orderResponseList;
    }

    @Override
    public OrderResponseList selUserReceivedInfoByUserId(Integer userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        OrderResponseList orderResponseList = new OrderResponseList();
        List<OrderResponse> orderResponses = new ArrayList<>();
        List<Order> orderList = orderDao.selOrder(userId);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        for (Order order : pageInfo.getList()) {
            OrderResponse orderResponse = new OrderResponse();
            BeanUtils.copyProperties(order, orderResponse);
            orderResponse.setBook(bookDao.selBookById(order.getBookId()));
            orderResponse.setExpressNum(stringRedisTemplate.opsForValue().get(order.getId().toString()));
            ReceivedInfo receivedInfo = receivedInfoDao.selectById(order.getReceivedInfoId());
            orderResponse.setReceivedInfo(receivedInfo);
            orderResponses.add(orderResponse);
        }
        orderResponseList.setOrderResponseList(orderResponses);
        orderResponseList.setTotal(pageInfo.getTotal());
        return orderResponseList;
    }

    @Override
    public OrderResponseList selectAllOrders(Short orderState,Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        OrderResponseList orderResponseList = new OrderResponseList();
        List<OrderResponse> orderResponses = new ArrayList<>();
        List<Order> orderList = null;
        if (Constant.ALL_ORDER_STATUS.equals(orderState)) {
            orderList = orderDao.selectAllOrders();
        }else {
            orderList = orderDao.selectAll(orderState);
        }
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        for (Order order : pageInfo.getList()) {
            OrderResponse orderResponse = new OrderResponse();
            BeanUtils.copyProperties(order, orderResponse);
            orderResponse.setUser(userDao.getUserById(order.getUserId()));
            orderResponse.setBook(bookDao.selBookById(order.getBookId()));
            orderResponse.setExpressNum(stringRedisTemplate.opsForValue().get(order.getId().toString()));
            ReceivedInfo receivedInfo = receivedInfoDao.selectById(order.getReceivedInfoId());
            orderResponse.setReceivedInfo(receivedInfo);
            orderResponses.add(orderResponse);
        }
        orderResponseList.setOrderResponseList(orderResponses);
        orderResponseList.setTotal(pageInfo.getTotal());
        return orderResponseList;
    }

    @Override
    public OrderResponseList selectAll(Short orderState, Integer pageNumber, Integer pageSize) {
        List<Order> orderList = orderDao.selectAll(orderState);
        List<OrderResponse> orderResponses = new ArrayList<>();
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        for (Order order : pageInfo.getList()) {
            OrderResponse orderResponse = new OrderResponse();
            BeanUtils.copyProperties(order, orderResponse);
            orderResponse.setUser(userDao.getUserById(order.getUserId()));
            orderResponse.setBook(bookDao.selBookById(order.getBookId()));
            orderResponse.setExpressNum(stringRedisTemplate.opsForValue().get(order.getId().toString()));
            ReceivedInfo receivedInfo = receivedInfoDao.selectById(order.getReceivedInfoId());
            orderResponse.setReceivedInfo(receivedInfo);
            orderResponses.add(orderResponse);
        }
        OrderResponseList orderResponseList = new OrderResponseList();
        orderResponseList.setOrderResponseList(orderResponses);
        orderResponseList.setTotal(pageInfo.getTotal());
        return orderResponseList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer cancleOrder(CancleOrderReuquest cancleOrderReuquest) {
        Book book = bookDao.selBookById(cancleOrderReuquest.getBookId());
        book.setMount(book.getMount() + cancleOrderReuquest.getBookMount());
        book.setSaleMount(book.getSaleMount() - cancleOrderReuquest.getBookMount());
        bookDao.updBook(book);
        Order order = new Order();
        order.setId(cancleOrderReuquest.getId());
        order.setOrderState(Constant.CANCLE_ORDER);
        return orderDao.updOrder(order);
    }
}
