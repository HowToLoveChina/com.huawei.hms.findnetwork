package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hianalytics.framework.d */
/* loaded from: classes5.dex */
public class C4757d {

    /* renamed from: e */
    public static final C4757d f21744e = new C4757d();

    /* renamed from: a */
    public IMandatoryParameters f21745a;

    /* renamed from: b */
    public final Map<String, ICollectorConfig> f21746b = new ConcurrentHashMap();

    /* renamed from: c */
    public final Map<String, C4758e> f21747c = new ConcurrentHashMap();

    /* renamed from: d */
    public final Map<String, IStoragePolicy> f21748d = new ConcurrentHashMap();

    /* renamed from: a */
    public ICollectorConfig m28847a(String str) {
        return this.f21746b.get(str);
    }

    /* renamed from: b */
    public IMandatoryParameters m28848b() {
        return this.f21745a;
    }

    /* renamed from: a */
    public static C4757d m28846a() {
        return f21744e;
    }
}
