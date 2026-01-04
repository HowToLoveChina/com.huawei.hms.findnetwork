package p015ak;

import java.util.concurrent.CountDownLatch;

/* renamed from: ak.h */
/* loaded from: classes6.dex */
public class C0217h<T> extends CountDownLatch {

    /* renamed from: a */
    public volatile T f810a;

    public C0217h() {
        super(1);
        this.f810a = null;
    }

    /* renamed from: a */
    public void m1450a(T t10) {
        this.f810a = t10;
        super.countDown();
    }

    /* renamed from: b */
    public T m1451b() {
        return this.f810a;
    }

    @Override // java.util.concurrent.CountDownLatch
    @Deprecated
    public void countDown() {
        super.countDown();
    }
}
