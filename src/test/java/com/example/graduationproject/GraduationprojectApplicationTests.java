package com.example.graduationproject;

import com.example.graduationproject.dao.CommentDao;
/*import com.example.graduationproject.service.UserOrderCommentShipService;*/
import com.example.graduationproject.pojo.Comment;
import com.example.graduationproject.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class graduationprojectApplicationTests {

    @Autowired
    CommentDao commentDao;
    /*@Autowired
    UserOrderCommentShipService userOrderCommentShipService;
*/
    @Test
    void contextLoads() {

        /*UserOrderCommentShip userOrderCommentShip = new UserOrderCommentShip();

        //如果插入评论成功，插入用户订单评论表
        if(result==1){

            Integer result1 = userOrderCommentShipService.addUOCShip(userOrderCommentShip);
            System.out.println(result1 + "\n" + "--------------------------------" + "\n");
            System.out.println(userOrderCommentShip);
        }
*/
        /*SzpJsonResult<UserOrderCommentShip> szpJsonResult = new SzpJsonResult<UserOrderCommentShip>();
        szpJsonResult.ok(szpJsonResult);
        if(userOrderCommentShipService.addUOCShip(userOrderCommentShip)==1){
            return szpJsonResult;
        }else{
            return null;
        }*/
    }

}
