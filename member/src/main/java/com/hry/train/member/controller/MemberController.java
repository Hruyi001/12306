package com.hry.train.member.controller;

import com.hry.train.common.resp.CommonResp;
import com.hry.train.member.req.MemberRegisterReq;
import com.hry.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
