package com.huawei.android.remotecontrol.p093ui.webview;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.android.remotecontrol.p093ui.BaseActivity;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import mu.C11525b;
import ng.C11702i;
import ng.C11703j;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0224k0;
import p514o9.C11829c;
import p514o9.C11842p;
import p521og.C11868a;
import p809yg.C13981a;
import sk.C12809f;

/* loaded from: classes4.dex */
public class BaseWebViewActivity extends BaseActivity {

    /* renamed from: A */
    public AlertDialog f20772A;

    /* renamed from: B */
    public View f20773B;

    /* renamed from: C */
    public TextView f20774C;

    /* renamed from: D */
    public Handler f20775D;

    /* renamed from: E */
    public String f20776E;

    /* renamed from: F */
    public String f20777F;

    /* renamed from: G */
    public boolean f20778G;

    /* renamed from: H */
    public int f20779H = 0;

    /* renamed from: I */
    public NetworkBroadcastReceiver f20780I;

    /* renamed from: r */
    public View f20781r;

    /* renamed from: s */
    public SafeWebView f20782s;

    /* renamed from: t */
    public ProgressBar f20783t;

    /* renamed from: u */
    public TextView f20784u;

    /* renamed from: v */
    public HwButton f20785v;

    /* renamed from: w */
    public View f20786w;

    /* renamed from: x */
    public View f20787x;

    /* renamed from: y */
    public View f20788y;

    /* renamed from: z */
    public View f20789z;

    public static class NetworkBroadcastReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public WeakReference<BaseWebViewActivity> f20790a;

        /* renamed from: b */
        public boolean f20791b = false;

        public NetworkBroadcastReceiver(BaseWebViewActivity baseWebViewActivity) {
            this.f20790a = new WeakReference<>(baseWebViewActivity);
        }

        /* renamed from: a */
        public void m27704a(Context context) {
            if (this.f20791b) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.getApplicationContext().registerReceiver(this, intentFilter);
            this.f20791b = true;
        }

        /* renamed from: b */
        public void m27705b(Context context) {
            if (this.f20791b) {
                context.getApplicationContext().unregisterReceiver(this);
                this.f20791b = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BaseWebViewActivity baseWebViewActivity = this.f20790a.get();
            if (baseWebViewActivity == null) {
                return;
            }
            baseWebViewActivity.m27693d2();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.webview.BaseWebViewActivity$a */
    public class HandlerC4529a extends Handler {
        public HandlerC4529a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BaseWebViewActivity baseWebViewActivity = BaseWebViewActivity.this;
            if (baseWebViewActivity.f20773B == null || baseWebViewActivity.isFinishing()) {
                return;
            }
            BaseWebViewActivity.this.f20773B.setVisibility(8);
        }
    }

    /* renamed from: h2 */
    public static boolean m27680h2(ActionBar actionBar, Drawable drawable) {
        if (17 <= C0219i.m1463a()) {
            return m27681i2(actionBar, drawable);
        }
        actionBar.setBackgroundDrawable(drawable);
        return true;
    }

    /* renamed from: i2 */
    public static boolean m27681i2(ActionBar actionBar, Drawable drawable) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("com.huawei.android.app.ActionBarEx");
            cls.getDeclaredMethod("setAppbarBackground", ActionBar.class, Drawable.class).invoke(cls, actionBar, drawable);
            return true;
        } catch (ClassNotFoundException e10) {
            C13981a.m83988e("WebViewActivity", "ClassNotFoundException" + e10.getMessage());
            return false;
        } catch (IllegalAccessException e11) {
            C13981a.m83988e("WebViewActivity", "IllegalAccessException" + e11.getMessage());
            return false;
        } catch (NoSuchMethodException e12) {
            C13981a.m83988e("WebViewActivity", "NoSuchMethodException" + e12.getMessage());
            return false;
        } catch (InvocationTargetException e13) {
            C13981a.m83988e("WebViewActivity", "InvocationTargetException" + e13.getMessage());
            return false;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: D1 */
    public void mo20612D1() {
    }

    /* renamed from: S1 */
    public void m27682S1() {
        if (C0209d.m1333z1(this) || !C11703j.m69817m(this)) {
            return;
        }
        C13981a.m83988e("WebViewActivity", "net is not connected");
        m27699l2();
    }

    /* renamed from: T1 */
    public boolean m27683T1(String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("WebViewActivity", "url is empty");
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        if ("https".equalsIgnoreCase(scheme) || "http".equalsIgnoreCase(scheme)) {
            return true;
        }
        C13981a.m83988e("WebViewActivity", "check url illegal scheme:" + scheme);
        return false;
    }

    /* renamed from: U1 */
    public boolean m27684U1(String... strArr) {
        for (String str : strArr) {
            if (checkSelfPermission(str) != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: V1 */
    public void mo27685V1() {
        m27702o2();
        this.f20787x.setVisibility(8);
        SafeWebView safeWebView = this.f20782s;
        if (safeWebView != null) {
            safeWebView.loadUrl(this.f20776E);
        }
    }

    /* renamed from: W1 */
    public void m27686W1(WebSettings webSettings) {
        try {
            if (21 >= C0219i.m1463a()) {
                C13981a.m83989i("WebViewActivity", "dark mode is not support");
                return;
            }
            PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
            if (currentWebViewPackage == null) {
                C13981a.m83989i("WebViewActivity", "packageInfo is null");
                return;
            }
            if ("com.google.android.webview".equals(currentWebViewPackage.packageName)) {
                webSettings.setForceDark(0);
                C13981a.m83989i("WebViewActivity", "set webview dark mode off");
                this.f20779H = 0;
                C13981a.m83989i("WebViewActivity", "forbid g webview dark mode");
                return;
            }
            if (this.f20779H == 1 && C11842p.m70732H0(this)) {
                C13981a.m83989i("WebViewActivity", "setForceDark");
                webSettings.setForceDark(2);
            } else {
                webSettings.setForceDark(0);
                C13981a.m83989i("WebViewActivity", "set dark mode off");
            }
        } catch (Exception e10) {
            C13981a.m83988e("WebViewActivity", "initDarkMode exception:" + e10.getMessage());
        }
    }

    /* renamed from: X1 */
    public void mo27687X1() {
        this.f20775D = new HandlerC4529a();
    }

    /* renamed from: Y1 */
    public void mo27688Y1() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f20776E = safeIntent.getStringExtra("url");
        this.f20777F = safeIntent.getStringExtra("title");
        this.f20778G = safeIntent.getBooleanExtra("isEnableJs", false);
        this.f20779H = C0224k0.a.m1575d("persist.sys.hw.forcedark_policy", 0);
        C13981a.m83989i("WebViewActivity", "forceDark=" + this.f20779H);
    }

    /* renamed from: Z1 */
    public void mo27689Z1() {
        setContentView(R$layout.pf_activity_wap_find_phone);
        this.f20781r = C12809f.m76829b(this, R$id.rl_cutout_layout);
        this.f20782s = (SafeWebView) C12809f.m76829b(this, R$id.external_webview);
        this.f20783t = (ProgressBar) C12809f.m76829b(this, R$id.external_webview_progress);
        this.f20786w = C12809f.m76829b(this, R$id.ll_webview);
        this.f20787x = C12809f.m76829b(this, R$id.net_error_contain);
        this.f20788y = C12809f.m76829b(this, R$id.load_error_page);
        this.f20789z = C12809f.m76829b(this, R$id.loading_view);
        this.f20784u = (TextView) C12809f.m76829b(this, R$id.net_error_text);
        this.f20785v = (HwButton) C12809f.m76829b(this, R$id.set_net);
        this.f20773B = C12809f.m76829b(this, R$id.tip_layout);
        this.f20774C = (TextView) C12809f.m76829b(this, R$id.tip_text_view);
        if (this.f20782s == null) {
            C13981a.m83988e("WebViewActivity", "can not find webview");
            finish();
        }
        View view = this.f20787x;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: a2 */
    public final /* synthetic */ void m27690a2(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("WebViewActivity", "dialog positive");
        m27694e2();
    }

    /* renamed from: b2 */
    public final /* synthetic */ void m27691b2(boolean z10, DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("WebViewActivity", "dialog cancel");
        setResult(0);
        if (z10) {
            C11702i.m69785a();
            finish();
        }
    }

    /* renamed from: c2 */
    public final /* synthetic */ void m27692c2(DialogInterface dialogInterface) {
        C13981a.m83989i("WebViewActivity", "dialog dismiss");
        setResult(0);
    }

    /* renamed from: d2 */
    public void m27693d2() {
        C13981a.m83989i("WebViewActivity", "onNetStateChange");
        if (C0209d.m1333z1(this)) {
            C13981a.m83989i("WebViewActivity", "network connected");
            mo27685V1();
        }
    }

    /* renamed from: e2 */
    public void m27694e2() {
        C13981a.m83989i("WebViewActivity", "open manager permission UI");
        Intent data = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", getPackageName(), null));
        data.addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
        try {
            startActivityForResult(data, 1);
        } catch (Exception unused) {
            C13981a.m83988e("WebViewActivity", "start permission activity error");
        }
    }

    /* renamed from: f2 */
    public void m27695f2() {
        if (this.f20780I == null) {
            this.f20780I = new NetworkBroadcastReceiver(this);
        }
        this.f20780I.m27704a(this);
    }

    /* renamed from: g2 */
    public void m27696g2(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C13981a.m83988e("WebViewActivity", "set title error for actionbar is null");
            return;
        }
        String strFilterInvisibleStr = StringUtil.filterInvisibleStr(str);
        if (TextUtils.isEmpty(strFilterInvisibleStr)) {
            actionBar.hide();
            C13981a.m83987d("WebViewActivity", "actionBar hide");
            return;
        }
        actionBar.setTitle(strFilterInvisibleStr);
        actionBar.setDisplayHomeAsUpEnabled(true);
        m27680h2(actionBar, ContextCompat.getDrawable(this, R$color.emui_color_bg));
        C13981a.m83987d("WebViewActivity", "setActionBarTitle title: " + strFilterInvisibleStr);
        actionBar.show();
    }

    /* renamed from: j2 */
    public void mo27697j2(boolean z10) {
        C11525b.m68802f(this.f20782s);
        WebSettings settings = this.f20782s.getSettings();
        String[] strArrM70529L = C11829c.m70529L();
        if (strArrM70529L.length != 0) {
            this.f20782s.setWhitelist(strArrM70529L);
        } else {
            this.f20782s.setWhitelistWithPath(new String[]{this.f20776E});
        }
        if (settings == null) {
            C13981a.m83988e("WebViewActivity", "setJavaScriptEnabled fail,WebSettings is null. Enable:" + z10);
            return;
        }
        settings.setJavaScriptEnabled(z10);
        settings.setDomStorageEnabled(true);
        settings.setTextZoom(100);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        m27686W1(settings);
    }

    /* renamed from: k2 */
    public void m27698k2() {
        this.f20787x.setVisibility(0);
        this.f20785v.setVisibility(8);
        this.f20784u.setText(getString(R$string.invalid_url_text));
    }

    /* renamed from: l2 */
    public void m27699l2() {
        C13981a.m83989i("WebViewActivity", "showNetErrorView");
        this.f20787x.setVisibility(0);
        this.f20785v.setVisibility(0);
        this.f20784u.setText(getString(R$string.net_err_tip_no_net));
        this.f20789z.setVisibility(8);
        m27695f2();
    }

    /* renamed from: m2 */
    public void m27700m2(int i10, int i11, final boolean z10) {
        C13981a.m83989i("WebViewActivity", "show permission dialog");
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.pf_layout_permission_dialog, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.permission_title);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.permission_message);
        if (textView == null || textView2 == null) {
            C13981a.m83988e("WebViewActivity", "showPermissionDialog titleView or messageView is null");
            return;
        }
        textView.setText(getString(i10));
        textView2.setText(getString(i11));
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setView(viewInflate).setPositiveButton(R$string.permission_btn_go_setting, new DialogInterface.OnClickListener() { // from class: jg.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                this.f51617a.m27690a2(dialogInterface, i12);
            }
        }).setNegativeButton(R$string.permission_btn_cancel, new DialogInterface.OnClickListener() { // from class: jg.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                this.f51620a.m27691b2(z10, dialogInterface, i12);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: jg.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f51626a.m27692c2(dialogInterface);
            }
        }).create();
        this.f20772A = alertDialogCreate;
        try {
            alertDialogCreate.show();
        } catch (Exception unused) {
            C13981a.m83988e("WebViewActivity", "showPermissionDialog exception");
            if (z10) {
                C11702i.m69785a();
                finish();
            }
        }
    }

    /* renamed from: n2 */
    public void m27701n2(String str, int i10) {
        if (TextUtils.isEmpty(str) || this.f20773B == null) {
            return;
        }
        TextView textView = this.f20774C;
        if (textView != null) {
            textView.setText(str);
        }
        this.f20773B.setVisibility(0);
        this.f20775D.sendEmptyMessageDelayed(0, i10 == 1 ? 3500 : 2000);
    }

    /* renamed from: o2 */
    public void m27702o2() {
        NetworkBroadcastReceiver networkBroadcastReceiver = this.f20780I;
        if (networkBroadcastReceiver == null) {
            return;
        }
        networkBroadcastReceiver.m27705b(this);
        this.f20780I = null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        SafeWebView safeWebView = this.f20782s;
        if (safeWebView == null || !safeWebView.canGoBack()) {
            super.onBackPressed();
        } else {
            C13981a.m83989i("WebViewActivity", "goBack");
            this.f20782s.goBack();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C11842p.m70768T0(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (C11842p.m70768T0(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        C11868a.m71128d().m71129a(this);
        C13981a.m83989i("WebViewActivity", "onCreate");
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C13981a.m83989i("WebViewActivity", "destroy activity");
        m27702o2();
        SafeWebView safeWebView = this.f20782s;
        if (safeWebView != null) {
            ViewGroup viewGroup = (ViewGroup) safeWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f20782s);
            }
            this.f20782s.destroy();
        }
        AlertDialog alertDialog = this.f20772A;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f20772A.dismiss();
            this.f20772A = null;
        }
        super.onDestroy();
        C11868a.m71128d().m71132e(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* renamed from: p2 */
    public void m27703p2(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C13981a.m83987d("WebViewActivity", "set title error for actionbar is null");
            return;
        }
        String strFilterInvisibleStr = StringUtil.filterInvisibleStr(str);
        if (TextUtils.isEmpty(strFilterInvisibleStr)) {
            C13981a.m83987d("WebViewActivity", "title empty");
            return;
        }
        actionBar.setTitle(strFilterInvisibleStr);
        actionBar.setDisplayHomeAsUpEnabled(true);
        m27680h2(actionBar, ContextCompat.getDrawable(this, R$color.emui_color_bg));
        C13981a.m83987d("WebViewActivity", "updateActionBarTitle title: " + strFilterInvisibleStr);
        actionBar.show();
    }
}
