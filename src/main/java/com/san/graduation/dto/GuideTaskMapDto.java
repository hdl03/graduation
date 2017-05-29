package com.san.graduation.dto;

import com.san.graduation.domain.GuideOrder;
import com.san.graduation.domain.GuideTask;

import java.util.List;

/**
 * Created by Administrator on 2017\5\29 0029.
 */
public class GuideTaskMapDto extends GuideTask{
    private List<GuideOrder> guideOrders;

    public List<GuideOrder> getGuideOrders() {
        return guideOrders;
    }

    public void setGuideOrders(List<GuideOrder> guideOrders) {
        this.guideOrders = guideOrders;
    }
}
