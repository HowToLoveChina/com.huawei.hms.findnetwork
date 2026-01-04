package com.huawei.hms.network.embedded;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.huawei.hms.network.embedded.h4 */
/* loaded from: classes8.dex */
public class C5942h4 {

    /* renamed from: a */
    public final Lock f26924a;

    /* renamed from: b */
    public final Condition f26925b;

    /* renamed from: c */
    public final Condition f26926c;

    /* renamed from: d */
    public final Object[] f26927d;

    /* renamed from: e */
    public int f26928e;

    /* renamed from: f */
    public int f26929f;

    /* renamed from: g */
    public int f26930g;

    public C5942h4() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f26924a = reentrantLock;
        this.f26925b = reentrantLock.newCondition();
        this.f26926c = reentrantLock.newCondition();
        this.f26927d = new Object[1];
    }

    public void put(Object obj) throws InterruptedException {
        int i10;
        Object[] objArr;
        this.f26924a.lock();
        while (true) {
            try {
                i10 = this.f26930g;
                objArr = this.f26927d;
                if (i10 != objArr.length) {
                    break;
                } else {
                    this.f26925b.await();
                }
            } catch (Throwable th2) {
                this.f26924a.unlock();
                throw th2;
            }
        }
        int i11 = this.f26928e;
        objArr[i11] = obj;
        int i12 = i11 + 1;
        this.f26928e = i12;
        if (i12 == objArr.length) {
            this.f26928e = 0;
        }
        this.f26930g = i10 + 1;
        this.f26926c.signal();
        this.f26924a.unlock();
    }

    public Object take() throws InterruptedException {
        int i10;
        this.f26924a.lock();
        while (true) {
            try {
                i10 = this.f26930g;
                if (i10 != 0) {
                    break;
                }
                this.f26926c.await();
            } catch (Throwable th2) {
                this.f26924a.unlock();
                throw th2;
            }
        }
        Object[] objArr = this.f26927d;
        int i11 = this.f26929f;
        Object obj = objArr[i11];
        int i12 = i11 + 1;
        this.f26929f = i12;
        if (i12 == objArr.length) {
            this.f26929f = 0;
        }
        this.f26930g = i10 - 1;
        this.f26925b.signal();
        this.f26924a.unlock();
        return obj;
    }
}
