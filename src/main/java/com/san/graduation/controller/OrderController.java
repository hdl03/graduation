package com.san.graduation.controller;

import com.github.pagehelper.PageInfo;
import com.san.graduation.common.BaseResponse;
import com.san.graduation.common.util.Logger;
import com.san.graduation.controller.param.PageParam;
import com.san.graduation.controller.result.QueryResponseWithPageResult;
import com.san.graduation.dto.PageDto;
import com.san.graduation.service.impl.GuideOrderService;
import com.san.graduation.service.impl.HelpOrderService;
import org.apache.commons.lang3.StringUtils;
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
    @Autowired
    private HelpOrderService helpOrderService;


    /**
     * 学霸获取我的订单
     *
     * @return
     */
    @PostMapping("myGuideOrder")
    public BaseResponse gainMyGuideOrder(@RequestBody PageParam pageParam) {
        Logger.info(this, "gainMyGuideOrder :" + pageParam);

        PageInfo pageInfo = null;
        if (StringUtils.isNoneBlank(pageParam.getKeyWord()) && pageParam.getKeyWord().contentEquals("recevierNo")) {
            pageInfo = guideOrderService.gainMyGuideOrder(pageParam.getStartPage(), pageParam.getPageSize(), true);
        } else {
            pageInfo = guideOrderService.gainMyGuideOrder(pageParam.getStartPage(), pageParam.getPageSize(), false);
        }
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(pageInfo, pageDto);
        return QueryResponseWithPageResult.success(pageInfo.getList(), pageDto);

    }

    /**
     * 学渣获取我的订单
     */

    @PostMapping("myHelpOrder")
    public BaseResponse gainMyHelpOrder(@RequestBody PageParam pageParam) {

        Logger.info(this, "gainMyGuideOrder :" + pageParam);

        PageInfo pageInfo = null;
        if (StringUtils.isNoneBlank(pageParam.getKeyWord()) && pageParam.getKeyWord().contentEquals("recevierNo")) {
            pageInfo = helpOrderService.gainMyHelpOrder(pageParam.getStartPage(), pageParam.getPageSize(), true);
        } else {
            pageInfo = helpOrderService.gainMyHelpOrder(pageParam.getStartPage(), pageParam.getPageSize(), false);
        }
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(pageInfo, pageDto);
        return QueryResponseWithPageResult.success(pageInfo.getList(), pageDto);

    }


    /**
     * 订单状态修改
     */

    @PostMapping("updateHelpOrder")
    public BaseResponse updateMyHelpOrder(@RequestBody PageParam pageParam) {

        PageInfo pageInfo = guideOrderService.gainMyGuideOrder(pageParam.getStartPage(), pageParam.getPageSize(), true);
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(pageInfo, pageDto);
        return QueryResponseWithPageResult.success(pageInfo.getList(), pageDto);

    }

    /**
     * 订单状态修改
     */

    @PostMapping("updateGuideOrder")
    public BaseResponse updateMyGuideOrder(@RequestBody PageParam pageParam) {

        PageInfo pageInfo = guideOrderService.gainMyGuideOrder(pageParam.getStartPage(), pageParam.getPageSize(), true);
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(pageInfo, pageDto);
        return QueryResponseWithPageResult.success(pageInfo.getList(), pageDto);

    }


}
