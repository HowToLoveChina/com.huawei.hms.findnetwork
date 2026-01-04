package com.huawei.location.nlp.network.response;

import android.text.TextUtils;
import com.huawei.location.C6769i;
import com.huawei.location.lite.common.http.response.BaseResponse;
import com.huawei.location.nlp.network.request.ResponseExtraInfo;

/* loaded from: classes8.dex */
public class OnlineLocationResponse extends BaseResponse {
    private static final String SUCCESS = "0";
    private ResponseExtraInfo extraInfo;
    private int indoor;
    private String locateType;
    private Location position;
    private String sessionId;
    private int status;

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public String getApiCode() {
        return this.code.isEmpty() ? "0" : this.code;
    }

    public ResponseExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public int getIndoor() {
        return this.indoor;
    }

    public String getLocateType() {
        return this.locateType;
    }

    public Location getPosition() {
        return this.position;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getStatus() {
        return this.status;
    }

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public boolean isSuccess() {
        return TextUtils.equals(this.code, "0") || TextUtils.isEmpty(this.code);
    }

    public void setExtraInfo(ResponseExtraInfo responseExtraInfo) {
        this.extraInfo = responseExtraInfo;
    }

    public void setIndoor(int i10) {
        this.indoor = i10;
    }

    public void setLocateType(String str) {
        this.locateType = str;
    }

    public void setPosition(Location location) {
        this.position = location;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("OnlineLocationResponse{code='");
        sb2.append(this.code);
        sb2.append("', msg='");
        sb2.append(this.msg);
        sb2.append("',locateType='");
        sb2.append(this.locateType);
        sb2.append("', indoor=");
        sb2.append(this.indoor);
        sb2.append(", position=");
        sb2.append(this.position);
        sb2.append(", extraInfo=");
        sb2.append(this.extraInfo);
        sb2.append(", status=");
        return C6769i.m38373a(sb2, this.status, '}');
    }
}
