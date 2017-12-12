package com.scoprion.mall.seller.service;

import com.scoprion.mall.domain.MallUser;
import com.scoprion.mall.domain.Seller;
import com.scoprion.result.BaseResult;
import com.scoprion.result.PageResult;

/**
 * @author by hmy
 * @created on 2017/12/7/007.
 */
public interface SellerService {

    /**
     * 商铺创建
     *
     * @param seller
     * @return
     * @throws Exception
     */
    BaseResult add(Seller seller) throws Exception;

    /**
     * 删除商铺
     *
     * @param id
     * @return
     */
    BaseResult delete(Long id);

    /**
     * 修改店铺信息
     *
     * @param seller
     * @return
     */
    BaseResult modify(Seller seller);

    /**
     * 微信商户登录
     * @param mallUser
     * @param ip
     * @return
     * @throws Exception
     */
    BaseResult login(MallUser mallUser, String ip) throws Exception;

    /**
     * 注册
     * @param mallUser
     * @param ip
     * @return
     * @throws Exception
     */
    BaseResult register(MallUser mallUser,String ip) throws Exception;

    /**
     * 修改商家个人信息
     * @param mallUser
     * @return
     */
    BaseResult alter(MallUser mallUser);


    /**
     * 退出登录
     * @param mobile
     * @param email
     * @return
     */
    BaseResult logout(String mobile,String email);


    /**
     * 查找商户的订单列表
     * @param pageNo
     * @param pageSize
     * @param sellerId
     * @return
     */
    PageResult findBySellerId(Integer pageNo, Integer pageSize, Long sellerId);
}