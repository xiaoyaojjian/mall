package com.scoprion.mall.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.scoprion.mall.domain.Goods;
import com.scoprion.mall.wx.service.activity.WxActivityService;
import com.scoprion.result.BaseResult;
import com.scoprion.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fk on 2017/11/12.
 */
@RestController
@RequestMapping("wx/activity")
public class WxActivityController {

    @Autowired
    private WxActivityService wxActivityService;

    /**
     * 抢购拼团
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public PageResult group(int pageNo, int pageSize) {
        return wxActivityService.group(pageNo, pageSize);
    }
}