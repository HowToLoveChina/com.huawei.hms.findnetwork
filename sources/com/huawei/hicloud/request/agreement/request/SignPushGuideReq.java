package com.huawei.hicloud.request.agreement.request;

import com.google.gson.Gson;
import java.util.List;

/* loaded from: classes6.dex */
public class SignPushGuideReq extends BaseReq {
    private String clientVersion;
    private List<ConsentInformation> signInfo;

    public SignPushGuideReq(String str, List<ConsentInformation> list) {
        this.clientVersion = str;
        this.signInfo = list;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public List<ConsentInformation> getConsentQueryInfoList() {
        return this.signInfo;
    }

    public void setClientVersion(String str) {
        this.clientVersion = str;
    }

    public void setConsentQueryInfoList(List<ConsentInformation> list) {
        this.signInfo = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
