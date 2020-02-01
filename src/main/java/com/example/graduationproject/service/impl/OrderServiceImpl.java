package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.*;
import com.example.graduationproject.pojo.*;
import com.example.graduationproject.request.OrderRequest;
import com.example.graduationproject.response.OrderItemResponse;
import com.example.graduationproject.response.OrderResponse;
import com.example.graduationproject.response.ReceivedInfoResponse;
import com.example.graduationproject.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lemon on 2020-01-30 20:08.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private OrderShipDao orderShipDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ReceivedInfoDao receivedInfoDao;

    @Override
    public List<OrderResponse> selectAll(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<OrderResponse> orderResponseList = new ArrayList<>();
        List<Order> orderList = orderDao.selectAll();
        for (int i = 0; i < orderList.size(); i++) {
            OrderResponse orderResponse = new OrderResponse();
            Integer orderId = orderList.get(i).getId();
            BeanUtils.copyProperties(orderList.get(i), orderResponse);
            User user = userDao.selectUserById(orderList.get(i).getUserId());
            ReceivedInfo receivedInfo = receivedInfoDao.selectById(orderList.get(i).getReceivedInfoId());
            ReceivedInfoResponse receivedInfoResponse = new ReceivedInfoResponse();
            if (receivedInfo != null)
                BeanUtils.copyProperties(receivedInfo, receivedInfoResponse);
            else
                break;
            List<OrderShip> orderShipList = orderShipDao.selectOrderItemIdByOrderId(orderId);
            List<OrderItemResponse> orderItemResponseList = new ArrayList<>();
            for (OrderShip orderShip : orderShipList) {
                Integer orderItemId = orderShip.getOrderItemId();
                List<OrderItem> orderItemList = orderItemDao.selectOrderItemByOrderItemId(orderItemId);
                OrderItemResponse orderItemResponse = new OrderItemResponse();
                for (OrderItem orderItem : orderItemList) {
                    BeanUtils.copyProperties(orderItem, orderItemResponse);
                    Book book = bookDao.selBookById(orderItem.getBookId());
                    orderItemResponse.setId(orderShip.getOrderItemId());
                    orderItemResponse.setBook(book);
                    orderItemResponse.setMount(orderItem.getMount());
                    orderItemResponse.setItemTotalPrice(orderItem.getItemTotalPrice());
                    orderItemResponseList.add(orderItemResponse);
                    orderResponse.add(orderItemResponse);
                }
            }
            orderResponse.setList(orderItemResponseList);
            orderResponse.setUser(user);
            orderResponse.setReceivedInfo(receivedInfoResponse);
            orderResponseList.add(orderResponse);
        }
        PageInfo<OrderResponse> pageInfo = new PageInfo<>(orderResponseList);
        return pageInfo.getList();
    }

    @Override
    public Integer updateOrder(OrderRequest orderRequest) {
        Order order = new Order();
        BeanUtils.copyProperties(orderRequest, order);
        order.setCreateTime(new Date());
        order.setReceivedInfoId(orderRequest.getReceivedInfoId());
        return orderDao.updateOrder(order);
    }

    @Transactional
    @Override
    public Integer deleteOrderById(Integer orderId) {
        List<OrderShip> orderShipList = orderShipDao.selectOrderItemIdByOrderId(orderId);
        List<Integer> orderShipIds = new ArrayList<>();
        List<Integer> orderItemIds = new ArrayList<>();
        Integer res = null;
        for (OrderShip orderShip : orderShipList) {
            orderShipIds.add(orderShip.getId());
            orderItemIds.add(orderShip.getOrderItemId());
        }
        res = orderShipDao.deleteOrderShipByIds(orderShipIds);
        res = orderItemDao.deleteOrderItemByIds(orderItemIds);
        res = orderDao.deleteOrderById(orderId);
        return res;
    }

    @Override
    public OrderResponse selectByOrderId(Integer orderId) {
        OrderResponse orderResponse = new OrderResponse();
        Order order =  orderDao.selectById(orderId);
        BeanUtils.copyProperties(order,orderResponse);
        User user = userDao.selectUserById(order.getUserId());
        orderResponse.setUser(user);
        ReceivedInfoResponse receivedInfoResponse = new ReceivedInfoResponse();
        ReceivedInfo receivedInfo = receivedInfoDao.selectById(order.getReceivedInfoId());
        if (receivedInfo != null)
            BeanUtils.copyProperties(receivedInfo, receivedInfoResponse);
        orderResponse.setReceivedInfo(receivedInfoResponse);
        List<OrderShip> orderShipList = orderShipDao.selectOrderItemIdByOrderId(orderId);
        List<OrderItemResponse> itemResponseList = new ArrayList<>();
        for (OrderShip orderShip:orderShipList){
            Integer orderItemId = orderShip.getOrderItemId();
            List<OrderItem> orderItemList = orderItemDao.selectOrderItemByOrderItemId(orderItemId);
            for (OrderItem orderItem:orderItemList){
                OrderItemResponse orderItemResponse = new OrderItemResponse();
                BeanUtils.copyProperties(orderItem,orderItemResponse);
                Integer bookId = orderItem.getBookId();
                Book book = bookDao.selBookById(bookId);
                orderItemResponse.setBook(book);
                itemResponseList.add(orderItemResponse);
            }

        }
        orderResponse.setList(itemResponseList);
        return orderResponse;
    }
}
