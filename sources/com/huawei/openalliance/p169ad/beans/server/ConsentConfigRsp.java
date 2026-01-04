package com.huawei.openalliance.p169ad.beans.server;

import com.huawei.hms.ads.consent.bean.AdProvider;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.base.RspBean;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class ConsentConfigRsp extends RspBean {
    private List<AdProvider> companies;
    private int retcode = -1;
    private int isNeedConsent = 1;

    /* renamed from: a */
    public int m40945a() {
        return this.retcode;
    }

    /* renamed from: b */
    public int m40946b() {
        return this.isNeedConsent;
    }

    /* renamed from: c */
    public List<AdProvider> m40947c() {
        return this.companies;
    }
}
