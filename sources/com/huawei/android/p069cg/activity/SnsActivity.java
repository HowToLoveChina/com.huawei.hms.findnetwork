package com.huawei.android.p069cg.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.android.p069cg.logic.app.HmsSnsApp;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0234s;
import p031b7.C1120a;
import sk.C12808e;

/* loaded from: classes2.dex */
public class SnsActivity extends Activity {
    /* renamed from: a */
    public final void m13990a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            int i10 = bundle.getInt("groupUiType", 0);
            if (i10 == 1) {
                HmsSnsApp.m14419h().m14429o(this);
            } else if (i10 == 2) {
                HmsSnsApp.m14419h().m14430p(this, bundle.getLong("groupId", 0L));
            }
        } catch (Exception e10) {
            C1120a.m6676e("SnsActivity", "handleUI Exception: " + e10.toString());
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
        C1120a.m6677i("SnsActivity", "onCreate");
        Intent intent = getIntent();
        m13990a(intent != null ? new HiCloudSafeIntent(intent).getExtras() : null);
        try {
            finish();
        } catch (Exception e10) {
            C1120a.m6676e("SnsActivity", "finish Exception: " + e10.toString());
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
    }
}
