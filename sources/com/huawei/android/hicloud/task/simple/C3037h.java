package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.content.Intent;
import p581qk.AbstractC12367d;
import p684un.C13223b;

/* renamed from: com.huawei.android.hicloud.task.simple.h */
/* loaded from: classes3.dex */
public class C3037h extends AbstractC12367d {

    /* renamed from: a */
    public Intent f13280a;

    /* renamed from: b */
    public Context f13281b;

    public C3037h(Context context, Intent intent) {
        this.f13281b = context;
        this.f13280a = intent;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Context context = this.f13281b;
        if (context != null) {
            C13223b.m79481i(context, this.f13280a);
        }
    }
}
