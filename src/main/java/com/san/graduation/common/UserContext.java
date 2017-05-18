package com.san.graduation.common;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * Created by ShanLin on 2017/4/6.
 */
public final class UserContext {
    private UserContext() {

    }
    private static UserContext userContext = new UserContext();
    private ThreadLocal<String> userNoLocal = new ThreadLocal<String>();
    private ThreadLocal<String> mobileNo = new ThreadLocal<String>();

    public static void init(String userNo, String mobileNo) {
        if (StringUtils.isNoneEmpty(userContext.userNoLocal.get()) || StringUtils.isNoneEmpty(userContext.mobileNo.get())) {
            // can't reset the userNo&MobileNo
            // 有数据，需要清理数据
            clean();
        }
        userContext.userNoLocal.set(userNo);
        userContext.mobileNo.set(mobileNo);
    }

    public static Optional<String> getCurrentMobileNo() {
        if (null != userContext.mobileNo.get()) {
            return Optional.of(userContext.mobileNo.get());
        }
        return Optional.empty();
    }

    public static Optional<String> getCurrentUserNo() {
        if (null != userContext.userNoLocal.get()) {
            return Optional.of(userContext.userNoLocal.get());
        }
        return Optional.empty();
    }

    //  must be invoke in last filter
    public static void clean() {
        userContext.mobileNo.remove();
        userContext.userNoLocal.remove();
    }
}
