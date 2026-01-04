package com.huawei.hicloud.request.basic.bean;

import com.huawei.hicloud.bean.BasicBaseResp;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class GetUserPublicInfoResp extends BasicBaseResp {
    private HashMap<String, String> resultMap;

    public HashMap<String, String> getResultMap() {
        return this.resultMap;
    }

    public void setResultMap(HashMap<String, String> map) {
        this.resultMap = map;
    }
}
