package com.youlai.mall.ums.api.app;

import com.youlai.common.result.Result;
import com.youlai.mall.ums.pojo.domain.UmsMember;
import com.youlai.mall.ums.pojo.dto.AuthMemberDTO;
import com.youlai.mall.ums.pojo.dto.MemberDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "mall-ums")
public interface UmsMemberFeignService {

    @PostMapping("/api.app/v1/users")
    Result add(@RequestBody UmsMember user);

    /**
     * 获取会员信息
     */
    @GetMapping("/api.app/v1/members/{id}")
    Result<MemberDTO> getUserById(@PathVariable Long id);


    /**
     * 获取认证会员信息
     */
    @GetMapping("/api.app/v1/members/openid/{openid}")
    Result<AuthMemberDTO> getUserByOpenid(@PathVariable String openid);

    /**
     * 修改会员积分
     */
    @PutMapping("/api.admin/v1/members/{id}/points")
    Result updatePoint(@PathVariable Long id, @RequestParam Integer num);

    /**
     * 修改会员余额
     */
    @PutMapping("/api.app/v1/members/{id}/balances")
    Result updateBalance(@PathVariable Long id, @RequestParam Long balance);


    /**
     * 获取会员余额
     */
    @GetMapping("/api.app/v1/members/{id}/balances")
    Result<Long> getBalance(@PathVariable Long id);



}

