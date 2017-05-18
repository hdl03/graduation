package com.san.graduation.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配 url 扫描 xml
 */
@Configuration
public class MatchUrlUtils {

    private Pattern pattern = null;
    private Matcher match = null;
    @Value("${graduation.login.checkUrl}")
    private String checkLoginUrls;
    /**
     * @param url
     * @param
     * @return 正则匹配url
     */
    public boolean checkUrls(String url) {
        return isMactchUrl(checkLoginUrls, url);
    }

    private boolean isMactchUrl(String urls, String url) {
        Logger.info(this, "check url");
        // 判断含有 url
        // 没有返回false
        if (null == urls) {
            return false;
        }
        // 以逗号分开
        List<String> urlsList = Arrays.asList(urls.split(","));
        Optional<String> optional = urlsList.stream().filter(pathUrl -> {
            if (pathUrl.contentEquals(url)) {
                return true;// 匹配成功
            }
            pattern = Pattern.compile(pathUrl);
            match = pattern.matcher(url);
            if (match.matches()) {
                return true; // 正在匹配成功
            }
            return false;
        }).findFirst();
        // 存在，说明匹配成
        if (optional.isPresent()) {
            return true;
        } else {
            return false;
        }

    }

}
