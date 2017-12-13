package com.scoprion.mall.seller.controller;


import com.scoprion.annotation.Access;
import com.scoprion.mall.domain.MallUser;
import com.scoprion.mall.domain.Seller;
import com.scoprion.mall.seller.service.SellerService;
import com.scoprion.result.BaseResult;
import com.scoprion.result.PageResult;
import com.scoprion.utils.IPUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author by kunlun
 * @created on 2017/12/7.
 */
@RequestMapping("/seller")
@RestController
public class SellerController {


    @Autowired
    private SellerService sellerService;

    /**
     * 商户店铺建立
     *
     * @param seller
     * @return
     */
    @Access
    @ApiOperation("商户创建商铺")
    @PostMapping("/add")
    public BaseResult add(@RequestBody Seller seller) {
        return sellerService.add(seller);
    }


    /**
     * 删除店铺
     *
     * @param id
     * @return
     */
    @Access
    @ApiOperation("删除店铺")
    @GetMapping("/delete")
    public BaseResult deleteById(Long id) {
        return sellerService.delete(id);
    }


    /**
     * 修改店铺信息
     *
     * @param seller
     * @return
     */
    @Access
    @ApiOperation("修改店铺信息")
    @PostMapping("/modify")
    public BaseResult modify(@RequestBody Seller seller) {
        return sellerService.modify(seller);
    }

    /**
     * 商户注册
     *
     * @param mallUser
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    @ApiOperation("商户注册")
    @PostMapping("/registry")
    public BaseResult registry(@RequestBody MallUser mallUser, HttpServletRequest httpServletRequest) throws Exception {
        String ip = IPUtil.getIPAddress(httpServletRequest);
        return sellerService.register(mallUser, ip);
    }


    /**
     * 微信商户登录
     *
     * @param mallUser
     * @param httpServletRequest
     * @return
     */
    @ApiOperation("商户登录")
    @PostMapping("/login")
    public BaseResult login(@RequestBody MallUser mallUser, HttpServletRequest httpServletRequest) throws Exception {
        String ip = IPUtil.getIPAddress(httpServletRequest);
        return sellerService.login(mallUser, ip);
    }


    /**
     * 修改个人信息
     *
     * @param mallUser
     * @return
     */
    @Access
    @ApiOperation("修改个人信息")
    @PostMapping("/alter")
    public BaseResult alter(@RequestBody MallUser mallUser) {
        return sellerService.alter(mallUser);
    }


    /**
     * 商户退出登录
     *
     * @param mobile
     * @param email
     * @return
     */
    @Access
    @ApiOperation("商户退出登录")
    @GetMapping("/logout")
    public BaseResult logout(String mobile, String email) {
        return sellerService.logout(mobile, email);
    }


    /**
     * 查询店铺详情
     *
     * @param userId
     * @return
     */
    @Access
    @ApiOperation("查询店铺详情")
    @GetMapping("/findByUserId/{userId}")
    public BaseResult findByUserId(@PathVariable("userId") Long userId) {
        return sellerService.findByUserId(userId);
    }
}

