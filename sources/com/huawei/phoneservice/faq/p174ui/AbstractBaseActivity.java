package com.huawei.phoneservice.faq.p174ui;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.framework.common.Logger;
import com.huawei.phoneservice.faq.R$color;
import com.huawei.phoneservice.faq.R$style;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.network.SdkAppInfo;
import com.huawei.phoneservice.faq.base.tracker.HiAnalyticsUtils;
import com.huawei.phoneservice.faq.base.util.FaqBaseCallback;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqDeviceUtils;
import com.huawei.phoneservice.faq.base.util.FaqHwFrameworkUtil;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqMemoryLeakUtils;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqTahitiUtils;
import com.huawei.phoneservice.faq.base.util.FaqUiUtils;

/* loaded from: classes4.dex */
public abstract class AbstractBaseActivity extends FragmentActivity {

    /* renamed from: y */
    public boolean f38861y;

    /* renamed from: z */
    public boolean f38862z;

    /* renamed from: a */
    private void m52014a() {
        try {
            this.f38862z = FaqTahitiUtils.isTahiti(this);
            if (FaqTahitiUtils.isPadOrTahiti(this)) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        } catch (IllegalStateException e10) {
            Logger.m32136d("AbstractBaseActivity", "e: " + e10.getMessage());
        }
    }

    /* renamed from: e0 */
    public int[] m52016e0() {
        return new int[]{R.id.content};
    }

    /* renamed from: f */
    public abstract void mo51677f();

    /* renamed from: f0 */
    public abstract int mo51678f0();

    /* renamed from: g0 */
    public int[] mo52017g0() {
        return new int[]{0};
    }

    /* renamed from: h0 */
    public abstract void mo51671h0();

    /* renamed from: i0 */
    public abstract void mo51672i0();

    /* renamed from: j0 */
    public abstract int mo51645j0();

    /* renamed from: k0 */
    public void m52018k0() {
        FaqUiUtils.setPadPadding(this, m52016e0());
    }

    /* renamed from: l0 */
    public abstract int mo51646l0();

    public void onBackPressed(View view) {
        onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m52018k0();
        boolean zIsTahiti = FaqTahitiUtils.isTahiti(this);
        FaqLogger.m51837d("AbstractBaseActivity", "onConfigurationChanged newConfig.orientation:%s", Integer.valueOf(configuration.orientation));
        FaqTahitiUtils.setDefaultMargin(this, mo52017g0(), mo51646l0());
        if (zIsTahiti != this.f38862z) {
            this.f38862z = zIsTahiti;
            setRequestedOrientation((zIsTahiti || FaqCommonUtils.isPad()) ? -1 : 1);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        SdkAppInfo.initAppInfo(getApplication());
        int identifier = getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
        if (identifier == 0) {
            identifier = R$style.FaqTheme;
            this.f38861y = true;
        }
        super.setTheme(identifier);
        FaqHwFrameworkUtil.setDisplaySideMode(this, 1);
        FaqDeviceUtils.initForRing(this, new int[]{R.id.content}, mo51645j0());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        FaqUiUtils.setStatusBarColor(this, this.f38861y, getResources().getColor(R$color.faq_sdk_white_bg));
        m52014a();
        super.onCreate(bundle);
        try {
            setContentView(mo51678f0());
            FaqUiUtils.setRootViewDefaultFocusHighlight(this);
            mo51672i0();
            mo51671h0();
            mo51677f();
            if (FaqCommonUtils.isPad()) {
                m52018k0();
            }
        } catch (RuntimeException e10) {
            Log.e("AbstractBaseActivity", "RuntimeException:" + e10.getMessage());
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) throws Throwable {
        FaqBaseCallback callback = FaqSdk.getISdk().getCallback();
        if (callback != null) {
            FaqLogger.m51836d("AbstractBaseActivity", " baseCallback ");
            View viewOnCreateView = callback.onCreateView(getWindow(), str, context, attributeSet);
            if (viewOnCreateView != null) {
                FaqLogger.m51836d("AbstractBaseActivity", "return view");
                return viewOnCreateView;
            }
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        FaqMemoryLeakUtils.fixMemoryLeak(this);
        FaqSdk.getISdk().canceledSubmit(this);
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() throws Throwable {
        super.onStart();
        m52015a(TrackConstants$Opers.STARTED);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() throws Throwable {
        super.onStop();
        m52015a(TrackConstants$Opers.STOPPED);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i10) {
        super.setRequestedOrientation(i10);
    }

    @Override // android.app.Activity
    public void setTitle(int i10) {
        setTitle(getString(i10));
    }

    /* renamed from: a */
    public void m52015a(String str) throws Throwable {
        String simpleName = getClass().getSimpleName();
        CharSequence title = getTitle();
        HiAnalyticsUtils.trackEvent("activity", new HiAnalyticsUtils.Builder().setOperation(str).setTitle(title == null ? "" : title.toString()).setClassName(simpleName).setResultSucceed().build());
    }
}
