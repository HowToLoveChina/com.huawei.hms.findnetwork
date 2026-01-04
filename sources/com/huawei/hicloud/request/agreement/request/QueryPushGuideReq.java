package com.huawei.hicloud.request.agreement.request;

import com.google.gson.Gson;
import java.util.List;

/* loaded from: classes6.dex */
public class QueryPushGuideReq {
    private String clientVersion;
    private List<ConsentQueryInformation> consentQueryInfoList;

    public QueryPushGuideReq(String str, List<ConsentQueryInformation> list) {
        this.clientVersion = str;
        this.consentQueryInfoList = list;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public List<ConsentQueryInformation> getConsentQueryInfoList() {
        return this.consentQueryInfoList;
    }

    public void setClientVersion(String str) {
        this.clientVersion = str;
    }

    public void setConsentQueryInfoList(List<ConsentQueryInformation> list) {
        this.consentQueryInfoList = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
