package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class EncryptDataRequ extends BaseRequ {
    private static final String TAG = "EncryptDataRequ";

    @Packed
    private String algorithm;

    @Packed
    private String data;

    @Packed
    private String info;

    /* renamed from: iv */
    @Packed
    private String f29802iv;

    @Packed
    private int okmLen;

    @Packed
    private String seed;

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getData() {
        return this.data;
    }

    public String getInfo() {
        return this.info;
    }

    public String getIv() {
        return this.f29802iv;
    }

    public int getOkmLen() {
        return this.okmLen;
    }

    public String getSeed() {
        return this.seed;
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setIv(String str) {
        this.f29802iv = str;
    }

    public void setOkmLen(int i10) {
        this.okmLen = i10;
    }

    public void setSeed(String str) {
        this.seed = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("algorithm", this.algorithm);
            jSONObject.put("okmLen", this.okmLen);
            jSONObject.put("seed", this.seed);
            jSONObject.put("info", this.info);
            jSONObject.put("iv", this.f29802iv);
            jSONObject.put("data", this.data);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "toJson failed");
        }
        return jSONObject.toString();
    }
}
