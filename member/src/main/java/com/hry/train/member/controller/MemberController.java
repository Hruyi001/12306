package com.hry.train.member.controller;

import com.hry.train.common.resp.CommonResp;
import com.hry.train.member.req.MemberLoginReq;
import com.hry.train.member.req.MemberRegisterReq;
import com.hry.train.member.req.MemberSendCodeReq;
import com.hry.train.member.resp.MemberLoginResp;
import com.hry.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;
    @GetMapping("/count")
    public CommonResp count() {
        int count = memberService.count();
        CommonResp<Integer> comResp = new CommonResp<>();
        comResp.setContent(count);
        return comResp;
    }

    @PostMapping("/register")
    public CommonResp register(@Valid MemberRegisterReq memberRegisterReq) {
        long register = memberService.register(memberRegisterReq);
        return new CommonResp(register);
    }
    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req) {
        MemberLoginResp login = memberService.login(req);
        return new CommonResp<>(login);
    }

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid @RequestBody MemberSendCodeReq req) {
        memberService.sendCode(req);
        return new CommonResp<>();
    }
}
