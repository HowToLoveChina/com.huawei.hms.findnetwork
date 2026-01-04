package com.huawei.hicloud.request.cbs.bean;

import android.content.ContentValues;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class CallLogBean {
    private static final String TAG = "CallLogBean";
    private long date;
    private long duration;
    private Map<String, String> extParams;

    /* renamed from: id */
    private String f22811id;
    private String number;
    private int type;

    private JSONObject map2Json() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, String> map = this.extParams;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "map2Json Error " + e10.getMessage());
        }
        return jSONObject;
    }

    public JSONObject callLog2Json() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f22811id);
            jSONObject.put("number", this.number);
            jSONObject.put(CallLogCons.DATE, this.date);
            jSONObject.put("duration", this.duration);
            jSONObject.put("type", this.type);
            jSONObject.put("extParams", map2Json());
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "callLog2Json Error " + e10.getMessage());
        }
        return jSONObject;
    }

    public boolean equal(CallLogBean callLogBean) {
        return callLogBean != null && this.date == callLogBean.date && this.duration == callLogBean.duration && C0209d.m1291p(this.number, callLogBean.number);
    }

    public long getDate() {
        return this.date;
    }

    public long getDuration() {
        return this.duration;
    }

    public Map<String, String> getExtParams() {
        return this.extParams;
    }

    public String getId() {
        return this.f22811id;
    }

    public String getNumber() {
        return this.number;
    }

    public int getType() {
        return this.type;
    }

    public void setDate(long j10) {
        this.date = j10;
    }

    public void setDuration(long j10) {
        this.duration = j10;
    }

    public void setExtParams(Map<String, String> map) {
        this.extParams = map;
    }

    public void setId(String str) {
        this.f22811id = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", this.number);
        contentValues.put(CallLogCons.DATE, Long.valueOf(this.date));
        contentValues.put("duration", Long.valueOf(this.duration));
        contentValues.put("type", Integer.valueOf(this.type));
        return contentValues;
    }
}
