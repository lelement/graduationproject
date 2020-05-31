package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.request.AddReceivedInfoRequest;
import com.example.graduationproject.request.DeleteReceivedInfoRequest;
import com.example.graduationproject.request.SelectReceivedInfoRequest;
import com.example.graduationproject.request.UpdateReceivedInfoRequest;
import com.example.graduationproject.response.ReceivedInfoResponseList;
import com.example.graduationproject.service.ReceivedInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lemon on 2020-01-31 0:55.
 */
@RestController
public class ReceivedInfoController {
    @Autowired
    private ReceivedInfoService receivedInfoService;

    @PostMapping("add/res")
    public SzpJsonResult<Integer> addReceivedInfo(@RequestBody AddReceivedInfoRequest addReceivedInfoRequest){
        return SzpJsonResult.ok(receivedInfoService.add(addReceivedInfoRequest));
    }

    @DeleteMapping("delete/receivedInfo")
    public SzpJsonResult<Integer> deleteReceivedInfo(@RequestBody DeleteReceivedInfoRequest deleteReceivedInfoRequest){
        return SzpJsonResult.ok(receivedInfoService.delete(deleteReceivedInfoRequest));
    }

    @PutMapping("update/receivedInfo")
    public SzpJsonResult<Integer> updateReceivedInfo(@RequestBody UpdateReceivedInfoRequest updateReceivedInfoRequest){
        return SzpJsonResult.ok(receivedInfoService.update(updateReceivedInfoRequest));
    }

    @GetMapping(value = "select")
    public SzpJsonResult<ReceivedInfoResponseList> selectByUserId(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "pageNumber") Integer pageNumber,@RequestParam(value = "size") Integer size){
        return SzpJsonResult.ok(receivedInfoService.selectByUserId(userId,pageNumber,size));
    }
}
