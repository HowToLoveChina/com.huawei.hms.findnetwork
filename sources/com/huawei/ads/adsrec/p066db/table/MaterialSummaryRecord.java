package com.huawei.ads.adsrec.p066db.table;

import com.huawei.ads.fund.anno.DataKeep;
import org.json.JSONObject;
import p216d4.C9001b0;
import p216d4.C9010g;
import p216d4.C9014i;
import p357i4.AbstractC10440e;

@DataKeep
/* loaded from: classes.dex */
public class MaterialSummaryRecord extends AbstractC10440e {
    private String adType;
    private String contentId;
    private int height;
    private String pkgName;
    private String slotId;
    private long updateTime;
    private String urls;
    private int width;

    public MaterialSummaryRecord() {
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: f */
    public long mo12454f() {
        return 2592000000L;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: i */
    public String mo12455i() {
        return "updateTime<?";
    }

    /* renamed from: t */
    public String m12510t() {
        return this.adType;
    }

    /* renamed from: u */
    public String m12511u() {
        return this.contentId;
    }

    /* renamed from: v */
    public int m12512v() {
        return this.height;
    }

    /* renamed from: w */
    public String m12513w() {
        return this.pkgName;
    }

    /* renamed from: x */
    public String m12514x() {
        return this.slotId;
    }

    /* renamed from: y */
    public String m12515y() {
        return this.urls;
    }

    /* renamed from: z */
    public int m12516z() {
        return this.width;
    }

    public MaterialSummaryRecord(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        this.pkgName = str;
        this.adType = str2;
        this.slotId = str3;
        this.contentId = str4;
        C9001b0 c9001b0M56921c = jSONObject != null ? "3".equals(jSONObject.optString("apiVer")) ? C9014i.m56921c(jSONObject) : C9010g.m56887b(jSONObject) : null;
        if (c9001b0M56921c != null) {
            this.width = c9001b0M56921c.m56869f();
            this.height = c9001b0M56921c.m56864a();
            this.urls = c9001b0M56921c.m56867d();
        }
        this.updateTime = System.currentTimeMillis();
    }
}
