package com.huawei.openalliance.p169ad.beans.inner;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class UserIntent {
    private String domain;
    private float domainMean;
    private float domainScore;
    private float domainStd;
    private String intentId;
    private float intentMean;
    private String intentName;
    private float intentScore;
    private float intentStd;
    private String subDomain;
    private float subDomainMean;
    private float subDomainScore;
    private float subDomainStd;

    /* renamed from: a */
    public float m39417a() {
        return this.subDomainScore;
    }

    /* renamed from: b */
    public String m39418b() {
        return this.intentId;
    }
}
