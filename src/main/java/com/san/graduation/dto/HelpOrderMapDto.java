package com.san.graduation.dto;

import com.san.graduation.domain.GuideOrder;
import com.san.graduation.domain.HelpOrder;
import com.san.graduation.domain.HelpTask;

/**
 * Created by Administrator on 2017\5\29 0029.
 */
public class HelpOrderMapDto extends HelpOrder {

    private HelpTask helpTask;

    public HelpTask getHelpTask() {
        return helpTask;
    }

    public void setHelpTask(HelpTask helpTask) {
        this.helpTask = helpTask;
    }
}
