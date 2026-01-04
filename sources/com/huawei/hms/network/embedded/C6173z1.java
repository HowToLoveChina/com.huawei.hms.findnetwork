package com.huawei.hms.network.embedded;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;

/* renamed from: com.huawei.hms.network.embedded.z1 */
/* loaded from: classes8.dex */
public class C6173z1 extends ContextWrapper {

    /* renamed from: a */
    public PackageManager f29223a;

    public C6173z1(Context context) {
        super(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        PackageManager packageManager = this.f29223a;
        if (packageManager != null) {
            return packageManager;
        }
        C5845a2 c5845a2 = new C5845a2(getBaseContext());
        this.f29223a = c5845a2;
        return c5845a2;
    }
}
