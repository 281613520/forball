package com.xw.utils;

import org.springframework.util.StringUtils;

/**
 * Created by Ankh on 2017/6/4.
 */
public class ValidUtil {

    private ValidUtil() {
    }

    public static boolean validIdParam(final String id) {
        if(StringUtils.isEmpty(id)){
            return false;
        }
        //防止 sql 攻击
        if(id.contains("\"") || id.contains("\'")){
            return false;
        }
        return true;
    }

    /**
     * 分页查询的时候,验证 Page 和 Size 是否合理
     * 1. page,size 都是大于0 的数.
     */
    public static boolean validPageAndSize(final int page,final int size) {
        if(page <= 0 || size <= 0){
            return false;
        }
        return true;
    }
}
