package com.san.graduation.dto;

import com.san.graduation.domain.GuideOrder;
import com.san.graduation.domain.GuideTask;

/**
 * Created by Administrator on 2017\5\29 0029.
 */
public class GuideOrderMapDto extends GuideOrder {
    private GuideTask guideTask;

    public GuideTask getGuideTask() {
        return guideTask;
    }

    public void setGuideTask(GuideTask guideTask) {
        this.guideTask = guideTask;
    }
}
