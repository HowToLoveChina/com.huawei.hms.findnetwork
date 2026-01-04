package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetDeviceIdResp extends BaseResp {
    private final int idType;
    private final String idValue;

    public static class IdType {
        public static final int IDTYPE_IMEI = 0;
        public static final int IDTYPE_UDID = 6;
        public static final int IDTYPE_VUDID = 11;
    }

    public GetDeviceIdResp(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.idType = jSONObject.getInt("idType");
        this.idValue = jSONObject.getString("idValue");
    }

    public int getIdType() {
        return this.idType;
    }

    public String getIdValue() {
        return this.idValue;
    }

    public String toString() {
        return "rtnCode: " + getRtnCode() + ", errorReason: " + getErrorReason() + ", idType: " + this.idType + ", idValue: " + this.idValue;
    }
}
