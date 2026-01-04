package com.huawei.hicloud.report.p107bi;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.WindowManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0219i;
import p015ak.C0234s;
import p399jk.AbstractC10896a;
import p684un.C13227f;
import sk.C12806c;
import sk.C12808e;

/* loaded from: classes6.dex */
public class HiAnalyticsBaselActivity extends Activity {

    /* renamed from: a */
    public long f22771a;

    /* renamed from: a */
    public int m29938a() {
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f22771a) / 1000);
        if (iCurrentTimeMillis <= 0) {
            return 1;
        }
        return iCurrentTimeMillis;
    }

    /* renamed from: b */
    public final void m29939b(Activity activity) throws IllegalAccessException, IllegalArgumentException {
        if (activity == null) {
            AbstractC10896a.m65886e("HiAnalyticsBaselActivity", "setCutoutMode activity null");
            return;
        }
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        try {
            attributes.getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).setInt(attributes, 1);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsBaselActivity", "setCutoutMode exception:" + e10.toString());
        }
        activity.getWindow().setAttributes(attributes);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (C0219i.m1463a() >= 17 && C12806c.m76815f(this)) {
            m29939b(this);
        }
        C12808e.m76822a(this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "100", m29938a());
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f22771a = System.currentTimeMillis();
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "100");
    }
}
