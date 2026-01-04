package com.huawei.hms.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hms.p148ui.SafeIntent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes8.dex */
public class BridgeActivity extends Activity {
    public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
    public static final String EXTRA_INTENT = "intent.extra.intent";
    public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
    public static final String EXTRA_RESULT = "intent.extra.RESULT";

    /* renamed from: b */
    private static final int f23051b = m30122a("ro.build.hw_emui_api_level", 0);

    /* renamed from: a */
    private IBridgeActivityDelegate f23052a;

    /* renamed from: com.huawei.hms.activity.BridgeActivity$a */
    public class ViewOnApplyWindowInsetsListenerC5048a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f23053a;

        public ViewOnApplyWindowInsetsListenerC5048a(ViewGroup viewGroup) {
            this.f23053a = viewGroup;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                Object objInvoke = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getMethod("getDisplaySideRegion", WindowInsets.class).invoke(null, windowInsets);
                if (objInvoke == null) {
                    HMSLog.m36988i("BridgeActivity", "sideRegion is null");
                } else {
                    Rect rect = (Rect) Class.forName("com.huawei.android.view.DisplaySideRegionEx").getMethod("getSafeInsets", new Class[0]).invoke(objInvoke, new Object[0]);
                    ViewGroup viewGroup = this.f23053a;
                    if (viewGroup != null) {
                        viewGroup.setPadding(rect.left, 0, rect.right, 0);
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                HMSLog.m36986e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e10.getMessage());
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    /* renamed from: a */
    private static void m30124a(Window window, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            window.getClass().getMethod("setHwFloating", Boolean.TYPE).invoke(window, Boolean.valueOf(z10));
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e10) {
            HMSLog.m36986e("BridgeActivity", "In setHwFloating, Failed to call Window.setHwFloating()." + e10.getMessage());
        }
    }

    /* renamed from: b */
    private void m30125b() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        View viewFindViewById = getWindow().findViewById(R.id.content);
        if (viewFindViewById == null || !(viewFindViewById instanceof ViewGroup)) {
            HMSLog.m36986e("BridgeActivity", "rootView is null or not ViewGroup");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) viewFindViewById;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
            cls.getMethod("setDisplaySideMode", Integer.TYPE).invoke(cls.getDeclaredConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 1);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            HMSLog.m36986e("BridgeActivity", "An exception occurred while reading: setDisplaySideMode" + e10.getMessage());
        }
        getWindow().getDecorView().setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC5048a(viewGroup));
    }

    /* renamed from: c */
    private boolean m30126c() {
        Intent intent = getIntent();
        if (intent == null) {
            HMSLog.m36986e("BridgeActivity", "In initialize, Must not pass in a null intent.");
            return false;
        }
        if (intent.getBooleanExtra("intent.extra.isfullscreen", false)) {
            getWindow().setFlags(1024, 1024);
        }
        try {
            try {
                String stringExtra = intent.getStringExtra(EXTRA_DELEGATE_CLASS_NAME);
                if (stringExtra == null) {
                    HMSLog.m36986e("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
                    return false;
                }
                IBridgeActivityDelegate iBridgeActivityDelegate = (IBridgeActivityDelegate) Class.forName(stringExtra).asSubclass(IBridgeActivityDelegate.class).newInstance();
                this.f23052a = iBridgeActivityDelegate;
                try {
                    iBridgeActivityDelegate.onBridgeActivityCreate(this);
                    return true;
                } catch (Throwable th2) {
                    HMSLog.m36986e("BridgeActivity", "onBridgeActivityCreate Exception." + th2.getMessage());
                    return false;
                }
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | InstantiationException e10) {
                HMSLog.m36986e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e10.getMessage());
                return false;
            }
        } catch (Throwable unused) {
            HMSLog.m36986e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance, throwable occur.");
            return false;
        }
    }

    /* renamed from: d */
    private void m30127d() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m30128e();
        Window window = getWindow();
        if (f23051b >= 9) {
            window.addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
            m30124a(window, true);
        }
        window.getDecorView().setSystemUiVisibility(0);
    }

    /* renamed from: e */
    private void m30128e() {
        try {
            if (getWindow() == null) {
                HMSLog.m36989w("BridgeActivity", "requestHideTitle, window is null.");
            } else {
                requestWindowFeature(1);
            }
        } catch (Throwable th2) {
            HMSLog.m36989w("BridgeActivity", "requestWindowFeature " + th2.getMessage());
        }
    }

    public static Intent getIntentStartBridgeActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(activity));
        return intent;
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(Window window) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    @Override // android.app.Activity
    public void finish() {
        HMSLog.m36988i("BridgeActivity", "Enter finish.");
        super.finish();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        Intent intentModifyIntentBehaviorsSafe = UIUtil.modifyIntentBehaviorsSafe(super.getIntent());
        if (intentModifyIntentBehaviorsSafe != null) {
            return new SafeIntent(intentModifyIntentBehaviorsSafe);
        }
        return null;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        super.onActivityResult(i10, i11, safeIntent);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f23052a;
        if (iBridgeActivityDelegate != null) {
            try {
                if (iBridgeActivityDelegate.onBridgeActivityResult(i10, i11, safeIntent)) {
                    return;
                }
            } catch (Throwable unused) {
                HMSLog.m36989w("BridgeActivity", "onBridgeActivityResult failed, throwable occur.");
            }
            if (isFinishing()) {
                return;
            }
            setResult(i11, UIUtil.modifyIntentBehaviorsSafe(safeIntent));
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f23052a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeConfigurationChanged();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m30128e();
        super.onCreate(bundle);
        HMSLog.m36988i("BridgeActivity", "BridgeActivity onCreate");
        if (getIntent() == null) {
            setResult(1, null);
            finish();
            return;
        }
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        m30127d();
        m30125b();
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(getApplicationContext());
        }
        setFullScreenWindowLayoutInDisplayCutout(getWindow());
        if (m30126c()) {
            return;
        }
        setResult(1, null);
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            ResolutionFlagUtil.getInstance().removeResolutionFlag(new SafeIntent(getIntent()).getStringExtra("transaction_id"));
        } catch (Throwable th2) {
            HMSLog.m36989w("BridgeActivity", "get transaction_id from intent fail: " + th2.getClass().getSimpleName());
        }
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f23052a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeActivityDestroy();
        }
        HMSLog.m36988i("BridgeActivity", "BridgeActivity onDestroy");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f23052a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onKeyUp(i10, keyEvent);
        }
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (Throwable th2) {
            HMSLog.m36987e("BridgeActivity", "super.onResume has an exception", th2);
            m30123a();
        }
    }

    /* renamed from: a */
    private void m30123a() {
        try {
            if (isFinishing() || isDestroyed()) {
                return;
            }
            setResult(1, null);
            finish();
        } catch (Throwable th2) {
            HMSLog.m36987e("BridgeActivity", "finishBridgeActivity has an exception", th2);
            throw new IllegalArgumentException("finishBridgeActivity has an exception ", th2);
        }
    }

    public static Intent getIntentStartBridgeActivity(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra("intent.extra.isfullscreen", false);
        return intent;
    }

    /* renamed from: a */
    private static int m30122a(String str, int i10) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(cls, str, Integer.valueOf(i10))).intValue();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.m36986e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
            return i10;
        }
    }
}
