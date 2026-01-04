package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class SingleResponse extends C11707b {
    private static final String TAG = "SingleResponse";

    @InterfaceC4648p
    private Map<String, Object> httpBody;

    @InterfaceC4648p
    private String httpCode;

    @InterfaceC4648p
    private C4609l httpHeader;

    public Map<String, Object> getHttpBody() {
        return this.httpBody;
    }

    public String getHttpCode() {
        return this.httpCode;
    }

    public C4609l getHttpHeader() {
        return this.httpHeader;
    }

    public void setHttpBody(Map<String, Object> map) {
        this.httpBody = map;
    }

    public void setHttpCode(String str) {
        this.httpCode = str;
    }

    public void setHttpHeader(C4609l c4609l) {
        this.httpHeader = c4609l;
    }
}
