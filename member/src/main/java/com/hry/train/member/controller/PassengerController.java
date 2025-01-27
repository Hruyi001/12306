package com.hry.train.member.controller;

import com.hry.train.common.context.LoginMemberContext;
import com.hry.train.common.resp.CommonResp;
import com.hry.train.common.resp.PageResp;
import com.hry.train.member.req.PassengerQueryReq;
import com.hry.train.member.req.PassengerSaveReq;
import com.hry.train.member.resp.PassengerQueryResp;
import com.hry.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Resource
    private PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req) {
        passengerService.save(req);
        return new CommonResp<>();
    }
    @GetMapping("/query-list")
    public CommonResp<PageResp<PassengerQueryResp>> queryList(@Valid PassengerQueryReq req) {
        req.setMemberId(LoginMemberContext.getId());
        PageResp<PassengerQueryResp> list = passengerService.queryList(req);
        return new CommonResp<>(list);
    }
}
