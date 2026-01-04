package com.huawei.hicloud.account.p102ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p399jk.AbstractC10896a;
import p664u0.C13108a;
import p681uj.C13195l;
import p742wj.C13612b;
import p742wj.C13613c;
import p846zj.C14306d;
import sk.C12808e;

/* loaded from: classes5.dex */
public class ValidateHwIdActivity extends Activity {

    /* renamed from: a */
    public Handler f22091a = new HandlerC4851a();

    /* renamed from: com.huawei.hicloud.account.ui.activity.ValidateHwIdActivity$a */
    public class HandlerC4851a extends Handler {
        public HandlerC4851a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (9003 == i10) {
                AbstractC10896a.m65887i("ValidateHwIdActivity", "processAccountInConsistent");
                ValidateHwIdActivity.this.m29100f();
                return;
            }
            if (9004 == i10) {
                AbstractC10896a.m65887i("ValidateHwIdActivity", "processAccountConsistent");
                ValidateHwIdActivity.this.m29099e();
            } else if (9005 == i10) {
                AbstractC10896a.m65887i("ValidateHwIdActivity", "processAccountLoginCanceled");
                ValidateHwIdActivity.this.m29102h();
            } else if (9006 == i10) {
                AbstractC10896a.m65887i("ValidateHwIdActivity", "processAccountAuthFailed");
                ValidateHwIdActivity.this.m29101g();
            }
        }
    }

    /* renamed from: e */
    public final void m29099e() {
        C13612b.m81829B().m81867h0(this);
        finish();
    }

    /* renamed from: f */
    public final void m29100f() {
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                Intent intent = new Intent();
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.setAction("com.huawei.hicloud.intent.action.ACCOUNT_INCONSISTENT_NOTICE");
                C13108a.m78878b(contextM1377a).m78881d(intent);
            }
            finish();
        } catch (Exception e10) {
            AbstractC10896a.m65887i("ValidateHwIdActivity", "notifyAccountInConsistent exception: " + e10.toString());
        }
    }

    /* renamed from: g */
    public final void m29101g() {
        finish();
    }

    /* renamed from: h */
    public final void m29102h() {
        finish();
    }

    /* renamed from: i */
    public final void m29103i() {
        C14306d.m85221v("com.huawei.hicloud.action.VALIDATE_HWID_REPORT");
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8910) {
            C13195l.m79272J().m79299O(this, new C13613c(this.f22091a), i10, i11, intent);
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
        AbstractC10896a.m65887i("ValidateHwIdActivity", "ValidateHwIdActivity reLogin");
        m29103i();
        C13612b.m81829B().m81882r(this, this.f22091a, 8910);
    }
}
