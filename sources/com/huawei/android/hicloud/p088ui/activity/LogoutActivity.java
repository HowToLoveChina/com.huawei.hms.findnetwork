package com.huawei.android.hicloud.p088ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0234s;
import p742wj.C13612b;
import sk.C12808e;

/* loaded from: classes3.dex */
public class LogoutActivity extends Activity {
    /* renamed from: a */
    public final void m20944a() {
        C13612b.m81829B().m81879p0(true);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C12808e.m76822a(this);
        m20944a();
        SafeIntent safeIntent = new SafeIntent(new Intent());
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("isdeletephoto", false);
        bundle2.putBoolean("isdeletecontact", false);
        safeIntent.putExtra("com.huawei.android.ds.logoutinfo", bundle2);
        setResult(-1, safeIntent);
        finish();
    }
}
