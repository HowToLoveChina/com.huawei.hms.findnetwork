package com.huawei.hicloud.request.basic.bean;

import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class GetUserRegisterResp extends BasicBaseResp {
    public static final String ACTIVE = "A";
    public static final String IN_ACTIVE = "I";
    public static final String IN_CLEAR = "W";
    private HashMap<String, String> resultMap;

    public HashMap<String, String> getResultMap() {
        return this.resultMap;
    }

    public Boolean isActivated() {
        return this.resultMap != null ? Boolean.valueOf(!isInActive(r1.get("userStatus"))) : Boolean.FALSE;
    }

    public Boolean isInActive() {
        HashMap<String, String> map = this.resultMap;
        return map != null ? Boolean.valueOf(isInActive(map.getOrDefault("userStatus", "A"))) : Boolean.FALSE;
    }

    public void setResultMap(HashMap<String, String> map) {
        this.resultMap = map;
    }

    public static boolean isInActive(String str) {
        return StringUtil.equals("I", str);
    }
}
