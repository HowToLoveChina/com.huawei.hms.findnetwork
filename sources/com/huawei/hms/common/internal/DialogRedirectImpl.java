package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes8.dex */
public class DialogRedirectImpl extends DialogRedirect {

    /* renamed from: a */
    private final Activity f23492a;

    /* renamed from: b */
    private final int f23493b;

    /* renamed from: c */
    private final Intent f23494c;

    public DialogRedirectImpl(Intent intent, Activity activity, int i10) {
        this.f23494c = intent;
        this.f23492a = activity;
        this.f23493b = i10;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Activity activity;
        Intent intent = this.f23494c;
        if (intent == null || (activity = this.f23492a) == null) {
            return;
        }
        activity.startActivityForResult(intent, this.f23493b);
    }
}
