package com.huawei.openalliance.p169ad.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.IRemoteViewDelegate;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7084e;
import com.huawei.openalliance.p169ad.C7582pp;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class TemplateStubActivity extends AbstractActivityC6906f {

    /* renamed from: b */
    private static AdContentData f31781b;

    /* renamed from: a */
    private IRemoteViewDelegate f31782a;

    /* renamed from: c */
    private View f31783c;

    /* renamed from: d */
    private boolean f31784d = false;

    /* renamed from: com.huawei.openalliance.ad.activity.TemplateStubActivity$a */
    public static class BinderC6900a extends IPPSUiEngineCallback.AbstractBinderC5102a {

        /* renamed from: a */
        private WeakReference<TemplateStubActivity> f31786a;

        public BinderC6900a(TemplateStubActivity templateStubActivity) {
            this.f31786a = new WeakReference<>(templateStubActivity);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
        public void onCallResult(String str, Bundle bundle) {
            AbstractC7185ho.m43821b("TemplateStubActivity", "onCallResult method: %s", str);
            TemplateStubActivity templateStubActivity = this.f31786a.get();
            if (templateStubActivity == null) {
                return;
            }
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -872396787:
                    if (str.equals(ParamConstants.CallbackMethod.ON_EASTER_EGG_CLICK)) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -599445191:
                    if (str.equals("complete")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 3135262:
                    if (str.equals("fail")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 3529469:
                    if (str.equals(ParamConstants.CallbackMethod.ON_SHOW)) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 94756344:
                    if (str.equals("close")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 1671672458:
                    if (str.equals(ParamConstants.CallbackMethod.ON_DISMISS)) {
                        c10 = 6;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    if (!C7582pp.m46808a(templateStubActivity.getApplicationContext()).m46822b(templateStubActivity, bundle, templateStubActivity.getClass().getSimpleName(), TemplateStubActivity.f31781b != null ? TemplateStubActivity.f31781b.m39295f() : null)) {
                        return;
                    }
                    break;
                case 1:
                    templateStubActivity.m38765b();
                    C7582pp.m46808a(templateStubActivity.getApplicationContext()).m46812a(templateStubActivity, bundle, TemplateStubActivity.f31781b != null ? TemplateStubActivity.f31781b.m39295f() : null);
                    return;
                case 2:
                    templateStubActivity.m38765b();
                    C7582pp.m46808a(templateStubActivity.getApplicationContext()).m46813a(templateStubActivity, TemplateStubActivity.f31781b != null ? TemplateStubActivity.f31781b.m39295f() : null, bundle);
                    return;
                case 3:
                    C7582pp.m46808a(templateStubActivity.getApplicationContext()).m46818a(templateStubActivity.getClass().getSimpleName(), TemplateStubActivity.f31781b != null ? TemplateStubActivity.f31781b.m39295f() : null);
                    return;
                case 4:
                    if (!C7582pp.m46808a(templateStubActivity.getApplicationContext()).m46819a(templateStubActivity, bundle, templateStubActivity.getClass().getSimpleName(), TemplateStubActivity.f31781b != null ? TemplateStubActivity.f31781b.m39295f() : null)) {
                        return;
                    }
                    break;
                case 5:
                    templateStubActivity.m38765b();
                    C7582pp.m46808a(templateStubActivity.getApplicationContext()).m46814a(bundle, TemplateStubActivity.f31781b != null ? TemplateStubActivity.f31781b.m39295f() : null);
                    return;
                case 6:
                    templateStubActivity.m38765b();
                    C7582pp.m46808a(templateStubActivity.getApplicationContext()).m46821b(TemplateStubActivity.f31781b != null ? TemplateStubActivity.f31781b.m39295f() : null);
                    return;
                default:
                    return;
            }
            templateStubActivity.m38765b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m38765b() {
        finish();
        overridePendingTransition(0, C6849R.anim.hiad_anim_stub_fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m38769d() {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.f31782a;
            if (iRemoteViewDelegate != null) {
                View view = (View) ObjectWrapper.unwrap(iRemoteViewDelegate.getView());
                this.f31783c = view;
                setContentView(view);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("TemplateStubActivity", "plugRemoteView " + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: e */
    private void m38770e() {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.f31782a;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onDestroy();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("TemplateStubActivity", "onDestroy failed: " + th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, C6849R.anim.hiad_anim_stub_fade_out);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AbstractC7185ho.m43820b("TemplateStubActivity", "onCreate");
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra("content");
        m38764a((AdContentData) AbstractC7758be.m47739b(stringExtra, AdContentData.class, new Class[0]));
        if (!C7582pp.m46808a(getApplicationContext()).m46820a(f31781b)) {
            AbstractC7185ho.m43820b("TemplateStubActivity", "content is null");
            C7582pp.m46808a(getApplicationContext()).m46816a((String) null, 3);
            finish();
        }
        if (AbstractC7811dd.m48310b(getApplicationContext())) {
            AbstractC7185ho.m43820b("TemplateStubActivity", "screen locked");
            if (Constants.MAGEZINE_PKG_NAME.equalsIgnoreCase(getApplicationContext().getPackageName())) {
                setShowWhenLocked(true);
            } else {
                C7582pp c7582ppM46808a = C7582pp.m46808a(getApplicationContext());
                AdContentData adContentData = f31781b;
                c7582ppM46808a.m46816a(adContentData != null ? adContentData.m39295f() : null, 1);
                finish();
            }
        }
        IRemoteCreator iRemoteCreatorM42835a = C7084e.m42835a(getApplicationContext());
        if (iRemoteCreatorM42835a == null) {
            AbstractC7185ho.m43820b("TemplateStubActivity", "remoteCreator is null");
            C7582pp c7582ppM46808a2 = C7582pp.m46808a(getApplicationContext());
            AdContentData adContentData2 = f31781b;
            c7582ppM46808a2.m46816a(adContentData2 != null ? adContentData2.m39295f() : null, 2);
            finish();
            return;
        }
        m38768c();
        m38762a(safeIntent);
        Bundle bundle2 = new Bundle();
        bundle2.putString("filePath", safeIntent.getStringExtra("filePath"));
        bundle2.putString("content", stringExtra);
        try {
            IRemoteViewDelegate iRemoteViewDelegateNewRemoteViewDelegate = iRemoteCreatorM42835a.newRemoteViewDelegate(ObjectWrapper.wrap(this), safeIntent.getStringExtra(ParamConstants.Param.VIEW_TYPE), null);
            this.f31782a = iRemoteViewDelegateNewRemoteViewDelegate;
            iRemoteViewDelegateNewRemoteViewDelegate.onCreate(bundle2);
            this.f31782a.setCallback(new BinderC6900a(this));
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.TemplateStubActivity.1
                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    TemplateStubActivity.this.m38769d();
                    TemplateStubActivity.this.m38760a("start", null);
                    AbstractC7811dd.m48295a(TemplateStubActivity.this.f31783c, TemplateStubActivity.this);
                    TemplateStubActivity.this.f31783c.startAnimation(AnimationUtils.loadAnimation(TemplateStubActivity.this.getApplicationContext(), C6849R.anim.hiad_anim_stub_fade_in));
                }
            });
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("TemplateStubActivity", "create remoteViewDelegate err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AbstractC7185ho.m43820b("TemplateStubActivity", "onDestroy");
        m38770e();
        C7582pp c7582ppM46808a = C7582pp.m46808a(getApplicationContext());
        AdContentData adContentData = f31781b;
        c7582ppM46808a.m46821b(adContentData != null ? adContentData.m39295f() : null);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onPause() {
        super.onPause();
        AbstractC7185ho.m43820b("TemplateStubActivity", "onPause");
        this.f31784d = true;
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.f31782a;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onPause();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("TemplateStubActivity", "onPause " + th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onRestart() {
        super.onRestart();
        AbstractC7185ho.m43821b("TemplateStubActivity", "onRestart, hasPause= %s", Boolean.valueOf(this.f31784d));
        if (this.f31784d) {
            finish();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onResume() {
        super.onResume();
        AbstractC7185ho.m43821b("TemplateStubActivity", "onResume, hasPause= %s", Boolean.valueOf(this.f31784d));
        if (this.f31784d) {
            finish();
        }
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.f31782a;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onResume();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("TemplateStubActivity", "onResume " + th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.f31782a;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onStart();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("TemplateStubActivity", "onStart " + th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onStop() {
        super.onStop();
        AbstractC7185ho.m43820b("TemplateStubActivity", "onStop");
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.f31782a;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onStop();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("TemplateStubActivity", "onStop " + th2.getClass().getSimpleName());
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Bundle m38760a(String str, Bundle bundle) {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.f31782a;
            if (iRemoteViewDelegate != null) {
                return iRemoteViewDelegate.sendCommand(str, bundle);
            }
            return null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("TemplateStubActivity", "%s failed: %s ", str, th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: c */
    private void m38768c() {
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        try {
            if (1 == getResources().getConfiguration().orientation) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Throwable th2) {
            Log.w("TemplateStubActivity", "set CutoutMode error:" + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m38762a(Intent intent) {
        try {
            if (!intent.getBooleanExtra(ParamConstants.Param.NEED_RESET, false)) {
                AbstractC7185ho.m43823c("TemplateStubActivity", "not need reset");
                return;
            }
            Window window = getWindow();
            if (window == null) {
                AbstractC7185ho.m43823c("TemplateStubActivity", "window is null");
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags = intent.getIntExtra(ParamConstants.Param.FLAGS, window.getAttributes().flags);
            if (!WhiteListPkgList.isHwBrowserPkgName(getPackageName())) {
                attributes.flags |= HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK;
            }
            attributes.layoutInDisplayCutoutMode = intent.getIntExtra(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE, window.getAttributes().layoutInDisplayCutoutMode);
            window.setAttributes(attributes);
            window.setNavigationBarColor(intent.getIntExtra(ParamConstants.Param.NAVIGATION_BAR_COLOR, window.getNavigationBarColor()));
            View decorView = window.getDecorView();
            if (decorView == null) {
                AbstractC7185ho.m43823c("TemplateStubActivity", "decorView is null");
            } else {
                decorView.setSystemUiVisibility(intent.getIntExtra(ParamConstants.Param.SYSTEM_UI_VISIBILITY, decorView.getSystemUiVisibility()));
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("TemplateStubActivity", "inherit err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private static void m38764a(AdContentData adContentData) {
        f31781b = adContentData;
    }
}
