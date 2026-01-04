package com.huawei.phoneservice.feedback.p175ui;

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
import com.huawei.phoneservice.feedback.R$color;
import com.huawei.phoneservice.feedback.R$style;

/* loaded from: classes5.dex */
public abstract class FeedbackAbstractBaseActivity extends FragmentActivity {

    /* renamed from: y */
    public boolean f39784y;

    /* renamed from: z */
    public boolean f39785z;

    /* renamed from: f0 */
    private void m52964f0() {
        try {
            this.f39785z = FaqTahitiUtils.isTahiti(this);
            if (FaqTahitiUtils.isPadOrTahiti(this)) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        } catch (IllegalStateException e10) {
            Logger.m32136d("FeedbackAbstractActivity", "e: " + e10.getMessage());
        }
    }

    /* renamed from: o0 */
    private void m52965o0() {
        mo52898l0();
        mo52897k0();
        mo52896j0();
        if (FaqCommonUtils.isPad()) {
            m52968n0();
        }
    }

    /* renamed from: e0 */
    public void m52966e0(String str) throws Throwable {
        String simpleName = getClass().getSimpleName();
        CharSequence title = getTitle();
        HiAnalyticsUtils.trackEvent("activity", new HiAnalyticsUtils.Builder().setOperation(str).setTitle(title == null ? "" : title.toString()).setClassName(simpleName).setResultSucceed().build());
    }

    /* renamed from: g0 */
    public int[] m52967g0() {
        return new int[]{R.id.content};
    }

    /* renamed from: h0 */
    public abstract int mo52894h0();

    /* renamed from: i0 */
    public int[] mo52895i0() {
        return new int[]{0};
    }

    /* renamed from: j0 */
    public abstract void mo52896j0();

    /* renamed from: k0 */
    public abstract void mo52897k0();

    /* renamed from: l0 */
    public abstract void mo52898l0();

    /* renamed from: m0 */
    public abstract int mo52871m0();

    /* renamed from: n0 */
    public void m52968n0() {
        FaqUiUtils.setPadPadding(this, m52967g0());
    }

    public void onBackPressed(View view) {
        onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Throwable {
        super.onConfigurationChanged(configuration);
        m52968n0();
        boolean zIsTahiti = FaqTahitiUtils.isTahiti(this);
        FaqLogger.m51837d("FeedbackAbstractActivity", "onConfigurationChanged newConfig.orientation:%s", Integer.valueOf(configuration.orientation));
        FaqTahitiUtils.setDefaultMargin(this, mo52895i0(), mo52872p0());
        if (zIsTahiti != this.f39785z) {
            this.f39785z = zIsTahiti;
            setRequestedOrientation((zIsTahiti || FaqCommonUtils.isPad()) ? -1 : 1);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        SdkAppInfo.initAppInfo(getApplication());
        int identifier = getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
        if (identifier == 0) {
            identifier = R$style.FeedbackTheme;
            this.f39784y = true;
        }
        super.setTheme(identifier);
        FaqHwFrameworkUtil.setDisplaySideMode(this, 1);
        FaqDeviceUtils.initForRing(this, new int[]{R.id.content}, mo52871m0());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        FaqUiUtils.setStatusBarColor(this, this.f39784y, getResources().getColor(R$color.faq_emui_white_bg));
        m52964f0();
        super.onCreate(bundle);
        try {
            setContentView(mo52894h0());
            FaqUiUtils.setRootViewDefaultFocusHighlight(this);
            m52965o0();
        } catch (RuntimeException e10) {
            Log.e("FeedbackAbstractActivity", "RuntimeException:" + e10.getMessage());
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) throws Throwable {
        FaqBaseCallback callback = FaqSdk.getISdk().getCallback();
        if (callback != null) {
            FaqLogger.m51836d("FeedbackAbstractActivity", " baseCallback ");
            View viewOnCreateView = callback.onCreateView(getWindow(), str, context, attributeSet);
            if (viewOnCreateView != null) {
                FaqLogger.m51836d("FeedbackAbstractActivity", "return view");
                return viewOnCreateView;
            }
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws Throwable {
        FaqMemoryLeakUtils.fixMemoryLeak(this);
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
        m52966e0(TrackConstants$Opers.STARTED);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() throws Throwable {
        super.onStop();
        m52966e0(TrackConstants$Opers.STOPPED);
    }

    /* renamed from: p0 */
    public abstract int mo52872p0();

    @Override // android.app.Activity
    public void setRequestedOrientation(int i10) {
        super.setRequestedOrientation(i10);
    }

    @Override // android.app.Activity
    public void setTitle(int i10) {
        setTitle(getString(i10));
    }
}
