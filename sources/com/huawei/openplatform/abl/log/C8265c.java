package com.huawei.openplatform.abl.log;

import android.content.Context;
import p405jt.AbstractC10919e;
import p434kt.AbstractC11153g;

/* renamed from: com.huawei.openplatform.abl.log.c */
/* loaded from: classes2.dex */
public class C8265c extends AbstractC10919e {
    public C8265c(Context context) {
        this.f51803a = context;
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: c */
    public void mo51629c(String str, String str2) {
        this.f51804b.m66022g(3, str, str2);
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: e */
    public boolean mo51630e() {
        return this.f51804b.m66021f(3);
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: f */
    public void mo51631f(String str, String str2) {
        this.f51804b.m66022g(6, str, str2);
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: g */
    public void mo51632g(String str, String str2, Object... objArr) {
        if (!m51637m() || str2 == null) {
            return;
        }
        mo51631f(str, AbstractC11153g.m67072b(str2, objArr));
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: i */
    public void mo51633i(String str, String str2) {
        this.f51804b.m66022g(4, str, str2);
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: j */
    public void mo51634j(String str, String str2, Object... objArr) {
        if (!m51638n() || str2 == null) {
            return;
        }
        mo51633i(str, AbstractC11153g.m67072b(str2, objArr));
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: k */
    public void mo51635k(String str, String str2) {
        this.f51804b.m66022g(5, str, str2);
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: l */
    public void mo51636l(String str, String str2, Object... objArr) {
        if (!m51639o() || str2 == null) {
            return;
        }
        mo51635k(str, AbstractC11153g.m67072b(str2, objArr));
    }

    /* renamed from: m */
    public boolean m51637m() {
        return this.f51804b.m66021f(6);
    }

    /* renamed from: n */
    public boolean m51638n() {
        return this.f51804b.m66021f(4);
    }

    /* renamed from: o */
    public boolean m51639o() {
        return this.f51804b.m66021f(5);
    }
}
