package com.huawei.android.p069cg.request.threadpool;

import java.util.Objects;
import java.util.concurrent.FutureTask;

/* renamed from: com.huawei.android.cg.request.threadpool.o */
/* loaded from: classes2.dex */
public class C2334o<V> extends FutureTask<V> implements Comparable<C2334o<V>> {

    /* renamed from: a */
    public AbstractCallableC2320a f11149a;

    /* renamed from: b */
    public String f11150b;

    /* renamed from: c */
    public AbstractC2324e f11151c;

    /* renamed from: d */
    public int f11152d;

    public C2334o(AbstractCallableC2320a abstractCallableC2320a) {
        super(abstractCallableC2320a);
        this.f11149a = abstractCallableC2320a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C2334o c2334o) {
        return this.f11152d - c2334o.m14677f();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        this.f11149a.cancel();
        return super.cancel(z10);
    }

    /* renamed from: e */
    public AbstractC2324e m14676e() {
        return this.f11151c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2334o c2334o = (C2334o) obj;
        return this.f11152d == c2334o.f11152d && Objects.equals(this.f11149a, c2334o.f11149a);
    }

    /* renamed from: f */
    public int m14677f() {
        return this.f11152d;
    }

    /* renamed from: h */
    public String m14678h() {
        return this.f11150b;
    }

    public int hashCode() {
        return Objects.hash(this.f11149a, Integer.valueOf(this.f11152d));
    }

    /* renamed from: i */
    public void m14679i(Object obj) {
        AbstractC2324e abstractC2324e = this.f11151c;
        if (abstractC2324e != null) {
            abstractC2324e.handle(obj);
        }
    }

    /* renamed from: k */
    public void m14680k(AbstractC2324e abstractC2324e) {
        this.f11151c = abstractC2324e;
    }

    /* renamed from: p */
    public void m14681p(int i10) {
        this.f11152d = i10;
    }

    /* renamed from: q */
    public void m14682q(String str) {
        this.f11150b = str;
    }
}
