package com.huawei.hms.drive;

/* renamed from: com.huawei.hms.drive.bm */
/* loaded from: classes8.dex */
public abstract class AbstractRunnableC5208bm implements Runnable {

    /* renamed from: c */
    protected final String f23984c;

    public AbstractRunnableC5208bm(String str, Object... objArr) {
        this.f23984c = C5210bo.m31181a(str, objArr);
    }

    /* renamed from: f */
    public abstract void mo31106f();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f23984c);
        try {
            mo31106f();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
