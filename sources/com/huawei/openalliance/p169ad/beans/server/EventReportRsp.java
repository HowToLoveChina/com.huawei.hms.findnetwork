package com.huawei.openalliance.p169ad.beans.server;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.base.RspBean;
import com.huawei.openalliance.p169ad.beans.metadata.AdEventResult;
import com.huawei.openalliance.p169ad.beans.metadata.AdEventResultV2;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class EventReportRsp extends RspBean {

    /* renamed from: e */
    private List<AdEventResultV2> f32015e;

    /* renamed from: r */
    private Integer f32016r;
    private List<AdEventResult> result;

    /* renamed from: a */
    public List<AdEventResult> m40951a() {
        return this.result;
    }

    /* renamed from: b */
    public Integer m40953b() {
        return this.f32016r;
    }

    /* renamed from: c */
    public List<AdEventResultV2> m40955c() {
        return this.f32015e;
    }

    /* renamed from: a */
    public void m40952a(List<AdEventResult> list) {
        this.result = list;
    }

    /* renamed from: b */
    public void m40954b(List<AdEventResultV2> list) {
        this.f32015e = list;
    }
}
