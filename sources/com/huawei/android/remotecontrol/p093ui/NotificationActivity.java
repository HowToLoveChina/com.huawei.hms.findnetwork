package com.huawei.android.remotecontrol.p093ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0234s;
import p809yg.C13981a;
import sk.C12808e;

/* loaded from: classes4.dex */
public class NotificationActivity extends Activity {
    /* renamed from: a */
    public final void m27049a() {
        try {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent("com.huawei.hwid.ACTION_MAIN_SETTINGS"));
            C0209d.m1302r2(hiCloudSafeIntent, "com.huawei.hwid");
            startActivity(hiCloudSafeIntent);
        } catch (Exception e10) {
            C13981a.m83988e("NotificationActivity", "start hwid error" + e10.toString());
        }
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
        C13981a.m83989i("NotificationActivity", "onCreate");
        m27049a();
        finish();
    }
}
