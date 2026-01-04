package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import p252e9.C9435l;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.task.simple.k2 */
/* loaded from: classes3.dex */
public class C3052k2 extends AbstractC12367d {

    /* renamed from: a */
    public Context f13321a;

    /* renamed from: b */
    public int f13322b;

    public C3052k2(Context context, int i10) {
        this.f13321a = context;
        this.f13322b = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C9435l c9435l = new C9435l();
        int i10 = this.f13322b;
        if (i10 == 1) {
            c9435l.m59172d(this.f13321a);
            return;
        }
        if (i10 == 2) {
            c9435l.m59171c(this.f13321a);
        } else if (i10 == 3) {
            c9435l.m59170b(this.f13321a);
        } else {
            if (i10 != 4) {
                return;
            }
            c9435l.m59173e(this.f13321a);
        }
    }
}
