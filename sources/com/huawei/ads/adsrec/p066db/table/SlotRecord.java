package com.huawei.ads.adsrec.p066db.table;

import com.huawei.ads.fund.anno.DataKeep;
import org.json.JSONObject;
import p357i4.AbstractC10440e;

@DataKeep
/* loaded from: classes.dex */
public class SlotRecord extends AbstractC10440e {
    private String ad30;
    private String pkgName;
    private String slotId;
    private long updateTime;

    public SlotRecord() {
        this.updateTime = System.currentTimeMillis();
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: f */
    public long mo12454f() {
        return 7776000000L;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: i */
    public String mo12455i() {
        return "updateTime<?";
    }

    /* renamed from: t */
    public String m12517t() {
        return this.ad30;
    }

    /* renamed from: u */
    public String m12518u() {
        return this.pkgName;
    }

    /* renamed from: v */
    public String m12519v() {
        return this.slotId;
    }

    public SlotRecord(String str, JSONObject jSONObject) {
        this.updateTime = System.currentTimeMillis();
        this.pkgName = str;
        if (jSONObject != null) {
            this.slotId = jSONObject.optString("slotid");
            this.ad30 = jSONObject.toString();
        }
        this.updateTime = System.currentTimeMillis();
    }
}
