package com.huawei.hicloud.request.cbs.bean;

import android.content.ContentValues;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.network.p129ai.C5799g0;
import java.util.Map;
import mk.C11476b;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;

/* loaded from: classes6.dex */
public class SmsBean {
    private String address;
    private String body;
    private long date;
    private Map<String, String> extParams = null;

    /* renamed from: id */
    private String f22813id;
    private int read;
    private String threadId;
    private int type;

    public boolean equal(SmsBean smsBean) {
        return smsBean != null && this.date == smsBean.date && C0209d.m1291p(this.body, smsBean.body) && C0209d.m1291p(this.address, smsBean.address) && this.type == smsBean.type;
    }

    public String getAddress() {
        return this.address;
    }

    public String getBody() {
        return this.body;
    }

    public long getDate() {
        return this.date;
    }

    public Map<String, String> getExtParams() {
        return this.extParams;
    }

    public String getId() {
        return this.f22813id;
    }

    public int getRead() {
        return this.read;
    }

    public String getSmsStr() {
        return C11476b.m68626h(this.f22813id + "|" + this.address + "|" + this.type + "|" + this.date + "|" + this.body);
    }

    public String getThreadId() {
        return this.threadId;
    }

    public int getType() {
        return this.type;
    }

    public JSONObject map2JSONString(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map2 = this.extParams;
        if (map2 != null) {
            jSONObject.put("seen", map2.get("seen"));
            jSONObject.put("status", this.extParams.get("status"));
            jSONObject.put("protocol", this.extParams.get("protocol"));
            jSONObject.put("locked", this.extParams.get("locked"));
            jSONObject.put("error_code", this.extParams.get("error_code"));
            jSONObject.put("date_sent", this.extParams.get("date_sent"));
            jSONObject.put(CallLogCons.SUBID, this.extParams.get(CallLogCons.SUBID));
            jSONObject.put("network_type", this.extParams.get("network_type"));
        }
        return jSONObject;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setDate(long j10) {
        this.date = j10;
    }

    public void setExtParams(Map<String, String> map) {
        this.extParams = map;
    }

    public void setId(String str) {
        this.f22813id = str;
    }

    public void setRead(int i10) {
        this.read = i10;
    }

    public void setThreadId(String str) {
        this.threadId = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public JSONObject smsJsontoString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f22813id);
        jSONObject.put(CrashHianalyticsData.THREAD_ID, this.threadId);
        jSONObject.put(C5799g0.f25867g, this.address);
        jSONObject.put(CallLogCons.DATE, this.date);
        jSONObject.put("read", this.read);
        jSONObject.put("type", this.type);
        jSONObject.put("body", this.body);
        jSONObject.put("extParams", map2JSONString(this.extParams));
        return jSONObject;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C5799g0.f25867g, this.address);
        contentValues.put(CallLogCons.DATE, Long.valueOf(this.date));
        contentValues.put("read", (Integer) 1);
        contentValues.put("type", Integer.valueOf(this.type));
        contentValues.put("body", this.body);
        return contentValues;
    }

    public String toString() {
        return "SmsBean [_id=" + this.f22813id + ", thread_id=" + this.threadId + ", address=" + this.address + ", date=" + this.date + ", read=" + this.read + " ,type = " + this.type + ", body=" + this.body + ", extParams=" + this.extParams + "]";
    }
}
