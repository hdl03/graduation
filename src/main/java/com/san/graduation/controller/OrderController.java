package com.san.graduation.controller;

import com.github.pagehelper.PageInfo;
import com.san.graduation.common.BaseResponse;
import com.san.graduation.controller.param.PageParam;
import com.san.graduation.controller.result.QueryResponseWithPageResult;
import com.san.graduation.dto.PageDto;
import com.san.graduation.service.impl.GuideOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017\5\29 0029.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private GuideOrderService guideOrderService;


    /**
     * 学霸获取我的订单
     *
     * @return
     */
    @PostMapping("myGuideOrder")
    public BaseResponse gainMyGuideOrder(@RequestBody PageParam pageParam) {

        PageInfo pageInfo = guideOrderService.gainMyGuideOrder(pageParam.getStartPage(), pageParam.getPageSize());
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(pageInfo, pageDto);
        return QueryResponseWithPageResult.success(pageInfo.getList(), pageDto);

    }

    /**
     * 获取学渣帖
     *
     */

    @PostMapping("myHelpOrder")
    public BaseResponse gainMyHelpOrder(@RequestBody PageParam pageParam) {

        PageInfo pageInfo = guideOrderService.gainMyGuideOrder(pageParam.getStartPage(), pageParam.getPageSize());
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(pageInfo, pageDto);
        return QueryResponseWithPageResult.success(pageInfo.getList(), pageDto);

    }


    /**
     *  订单状态修改
     */

    @PostMapping("updateHelpOrder")
    public BaseResponse updateMyHelpOrder(@RequestBody PageParam pageParam) {

        PageInfo pageInfo = guideOrderService.gainMyGuideOrder(pageParam.getStartPage(), pageParam.getPageSize());
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(pageInfo, pageDto);
        return QueryResponseWithPageResult.success(pageInfo.getList(), pageDto);

    }

    /**
     *  订单状态修改
     */

    @PostMapping("updateGuideOrder")
    public BaseResponse updateMyGuideOrder(@RequestBody PageParam pageParam) {

        PageInfo pageInfo = guideOrderService.gainMyGuideOrder(pageParam.getStartPage(), pageParam.getPageSize());
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(pageInfo, pageDto);
        return QueryResponseWithPageResult.success(pageInfo.getList(), pageDto);

    }


}
