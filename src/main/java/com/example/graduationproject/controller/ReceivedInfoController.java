package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.ReceivedInfo;
import com.example.graduationproject.request.AddReceivedInfoRequest;
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

    @PostMapping("add/res/by/userid")
    public SzpJsonResult<Integer> addReceivedInfo(@RequestBody AddReceivedInfoRequest addReceivedInfoRequest){
        return SzpJsonResult.ok(receivedInfoService.add(addReceivedInfoRequest));
    }

    @DeleteMapping("delete/res/by/id")
    public SzpJsonResult<Integer> deleteReceivedInfo(@RequestParam(value = "id") Integer id){
        return SzpJsonResult.ok(receivedInfoService.delete(id));
    }

    @PutMapping("update/res/by/id")
    public SzpJsonResult<Integer> updateReceivedInfo(@RequestBody ReceivedInfo receivedInfo){
        return SzpJsonResult.ok(receivedInfoService.update(receivedInfo));
    }

    @GetMapping(value = "select/by/userid")
    public SzpJsonResult<ReceivedInfo> selectByUserId(@RequestParam(value = "userid") Integer userId){
        return SzpJsonResult.ok(receivedInfoService.selectByUserId(userId));
    }
}
