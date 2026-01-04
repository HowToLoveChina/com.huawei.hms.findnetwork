package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.base.RspBean;

@DataKeep
/* loaded from: classes8.dex */
public class AdEventResult extends RspBean {
    private int retcode;
    private String seq;

    /* renamed from: a */
    public String m39498a() {
        return this.seq;
    }

    /* renamed from: b */
    public int m39499b() {
        return this.retcode;
    }
}
