package com.huawei.openalliance.p169ad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.openalliance.ad.tx */
/* loaded from: classes8.dex */
public class CallableC7702tx implements Callable<Bitmap> {

    /* renamed from: a */
    private final C7650rz f35753a;

    public CallableC7702tx(C7650rz c7650rz) {
        this.f35753a = c7650rz;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Bitmap call() {
        return BitmapFactory.decodeFile(this.f35753a.m47158a().m47207a());
    }
}
