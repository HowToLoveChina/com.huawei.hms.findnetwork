package com.huawei.ads.adsrec.p066db.table;

import com.huawei.ads.fund.anno.DataKeep;
import org.json.JSONObject;
import p357i4.AbstractC10440e;

@DataKeep
/* loaded from: classes.dex */
public class AdContentRspRecord extends AbstractC10440e {
    private String adContentRsp;
    private String pkgName;
    private long updateTime = System.currentTimeMillis();

    public AdContentRspRecord() {
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: f */
    public long mo12454f() {
        return 1296000000L;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: i */
    public String mo12455i() {
        return "updateTime<?";
    }

    /* renamed from: t */
    public String m12456t() {
        return this.adContentRsp;
    }

    public String toString() {
        return "AdContentRspRecord{pkgName='" + this.pkgName + "', rsp=" + this.adContentRsp + '}';
    }

    /* renamed from: u */
    public String m12457u() {
        return this.pkgName;
    }

    public AdContentRspRecord(String str, JSONObject jSONObject) {
        this.pkgName = str;
        if (jSONObject != null) {
            this.adContentRsp = jSONObject.toString();
        }
    }
}
