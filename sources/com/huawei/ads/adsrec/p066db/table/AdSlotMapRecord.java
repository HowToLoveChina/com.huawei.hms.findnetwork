package com.huawei.ads.adsrec.p066db.table;

import com.huawei.ads.fund.anno.DataKeep;
import com.huawei.hms.network.p129ai.C5820t;
import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import org.json.JSONObject;
import p357i4.AbstractC10440e;

@DataKeep
/* loaded from: classes.dex */
public class AdSlotMapRecord extends AbstractC10440e {
    private int adClicked;
    private int adShown;
    private String content;
    private String contentId;
    private long endTime;
    private String pkgName;
    private String slotId;
    private long startTime;

    public AdSlotMapRecord() {
    }

    /* renamed from: v */
    private void m12491v(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.contentId = jSONObject.optString("contentid");
            this.content = jSONObject.toString();
            this.startTime = jSONObject.optLong(C5820t.f26067o);
            this.endTime = jSONObject.optLong("endtime");
        }
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: f */
    public long mo12454f() {
        return AiCoreSdkConstant.CHECK_SUPPORT_INTERVAL;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: i */
    public String mo12455i() {
        return "endTime<?";
    }

    /* renamed from: t */
    public String m12492t() {
        return this.content;
    }

    /* renamed from: u */
    public void m12493u(int i10) {
        this.adClicked = i10;
    }

    /* renamed from: w */
    public String m12494w() {
        return this.contentId;
    }

    /* renamed from: x */
    public void m12495x(int i10) {
        this.adShown = i10;
    }

    /* renamed from: y */
    public String m12496y() {
        return this.pkgName;
    }

    /* renamed from: z */
    public String m12497z() {
        return this.slotId;
    }

    public AdSlotMapRecord(String str, String str2, JSONObject jSONObject) {
        this.pkgName = str;
        this.slotId = str2;
        m12491v(jSONObject);
    }
}
