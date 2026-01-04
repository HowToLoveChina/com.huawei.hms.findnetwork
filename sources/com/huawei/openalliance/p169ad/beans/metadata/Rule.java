package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.base.RspBean;

@DataKeep
/* loaded from: classes8.dex */
public class Rule extends RspBean {
    private static final String TAG = "Rule";
    private long noShowTime;
    private int skippedAdMaxTimes;
    private int skippedAdMinTimes;
    private int timeScope;

    /* renamed from: a */
    public int m40438a() {
        return this.timeScope;
    }

    /* renamed from: b */
    public int m40439b() {
        return this.skippedAdMinTimes;
    }

    /* renamed from: c */
    public int m40440c() {
        return this.skippedAdMaxTimes;
    }

    /* renamed from: d */
    public long m40441d() {
        return this.noShowTime;
    }
}
