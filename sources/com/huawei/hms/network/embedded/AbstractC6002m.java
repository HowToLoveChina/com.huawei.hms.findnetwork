package com.huawei.hms.network.embedded;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.network.embedded.m */
/* loaded from: classes8.dex */
public abstract class AbstractC6002m {

    /* renamed from: a */
    public EnumC5989l f27453a;

    /* renamed from: b */
    public Map<String, Object> f27454b;

    public AbstractC6002m() {
        this(null);
    }

    /* renamed from: a */
    public Object m34728a(String str) {
        if (str == null) {
            return null;
        }
        return this.f27454b.get(str);
    }

    /* renamed from: b */
    public abstract EnumC6054q mo34733b();

    /* renamed from: c */
    public EnumC5989l m34734c() {
        return this.f27453a;
    }

    /* renamed from: d */
    public boolean m34735d() {
        return this.f27454b.isEmpty();
    }

    public AbstractC6002m(EnumC5989l enumC5989l) {
        this.f27453a = enumC5989l;
        this.f27454b = new ConcurrentHashMap();
    }

    /* renamed from: a */
    public Map<String, Object> m34729a() {
        return this.f27454b;
    }

    /* renamed from: a */
    public void m34730a(EnumC5989l enumC5989l) {
        this.f27453a = enumC5989l;
    }

    /* renamed from: a */
    public void m34731a(String str, Object obj) {
        if (str == null) {
            return;
        }
        this.f27454b.put(str.toLowerCase(Locale.ENGLISH), obj);
    }

    /* renamed from: a */
    public void m34732a(Map<String, Object> map) {
        this.f27454b.putAll(map);
    }
}
