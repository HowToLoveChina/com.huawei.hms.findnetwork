package com.huawei.phoneservice.faq.p174ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.FaqCommonWebActivity;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$menu;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.entity.ModuleConfigRequest;
import com.huawei.phoneservice.faq.base.entity.ModuleConfigResponse;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqDeviceUtils;
import com.huawei.phoneservice.faq.base.util.FaqLanguageUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqSharePrefUtil;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import com.huawei.phoneservice.faq.base.util.FaqWebActivityUtil;
import com.huawei.phoneservice.faq.business.C8326a;
import com.huawei.phoneservice.faq.business.InterfaceC8328c;
import com.huawei.phoneservice.faq.response.FaqIpccBean;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mu.C11526c;

/* loaded from: classes4.dex */
public class FaqOnlineActivity extends FaqCommonWebActivity {

    /* renamed from: Z */
    public C8371d f38939Z;

    /* renamed from: a0 */
    public C8372e f38940a0;

    /* renamed from: c0 */
    public String f38942c0;

    /* renamed from: f0 */
    public String f38945f0;

    /* renamed from: h0 */
    public MenuItem f38947h0;

    /* renamed from: X */
    public FaqIpccBean f38937X = new FaqIpccBean();

    /* renamed from: Y */
    public String f38938Y = null;

    /* renamed from: b0 */
    public String f38941b0 = "";

    /* renamed from: d0 */
    public String f38943d0 = null;

    /* renamed from: e0 */
    public String f38944e0 = null;

    /* renamed from: g0 */
    public boolean f38946g0 = false;

    /* renamed from: i0 */
    public final List<String> f38948i0 = new ArrayList();

    /* renamed from: j0 */
    public InterfaceC8328c f38949j0 = new C8368a();

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqOnlineActivity$a */
    public class C8368a implements InterfaceC8328c {
        public C8368a() {
        }

        @Override // com.huawei.phoneservice.faq.business.InterfaceC8328c
        /* renamed from: a */
        public void mo51900a(int i10) throws Throwable {
            FaqLogger.m51836d("FaqOnlineActivity", "onSystemStatusChanged status: " + i10);
            FaqSdk.getSdk().saveSdk(FaqConstants.FAQ_CALLFLAG, "N");
            if (i10 == 0) {
                FaqIpccBean faqIpccBean = new FaqIpccBean();
                faqIpccBean.m51953l(FaqSdk.getSdk().getSdk("countryCode"));
                faqIpccBean.m51962v(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_OSVERSION));
                faqIpccBean.m51956o(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION));
                faqIpccBean.m51961t(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL));
                faqIpccBean.m51937I(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION));
                faqIpccBean.m51939L(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN));
                faqIpccBean.m51938K(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN));
                faqIpccBean.m51947e(FaqSdk.getSdk().getSdk("appVersion"));
                faqIpccBean.m51949g(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CHANNEL));
                faqIpccBean.m51951i(FaqSdk.getSdk().getSdk("country"));
                faqIpccBean.m51955n(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LEVEL));
                faqIpccBean.m51957p(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE));
                faqIpccBean.m51945c(FaqSdk.getSdk().getSdk("accessToken"));
                faqIpccBean.m51940M("auto");
                FaqOnlineActivity faqOnlineActivity = FaqOnlineActivity.this;
                faqOnlineActivity.m52108N0(faqOnlineActivity.f38944e0, faqIpccBean);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqOnlineActivity$b */
    public class C8369b extends FaqCallback<ModuleConfigResponse> {
        public C8369b(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, ModuleConfigResponse moduleConfigResponse) throws Throwable {
            FaqOnlineActivity.this.m52109O0(th2, moduleConfigResponse);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqOnlineActivity$c */
    public final class C8370c {
        public C8370c() {
        }

        @JavascriptInterface
        public void changeTitle(String str) {
            FaqOnlineActivity.this.setTitle(str);
        }

        @JavascriptInterface
        public void closeActivity() {
            FaqOnlineActivity.this.finish();
        }

        @JavascriptInterface
        public void loadURL(String str) {
            Intent intent = new Intent(FaqOnlineActivity.this, (Class<?>) IpccDetailActivity.class);
            intent.putExtra("ipcc_url_extra", str);
            FaqOnlineActivity.this.startActivity(intent);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqOnlineActivity$d */
    public final class C8371d {

        /* renamed from: a */
        public WeakReference<Activity> f38953a;

        public C8371d(Activity activity) {
            this.f38953a = new WeakReference<>(activity);
        }

        @JavascriptInterface
        public void onLogin() throws Throwable {
            FaqLogger.m51846i("FaqBaseWebActivity", "onLogin");
            WeakReference<Activity> weakReference = this.f38953a;
            if ((weakReference == null ? null : weakReference.get()) != null) {
                FaqOnlineActivity faqOnlineActivity = FaqOnlineActivity.this;
                C8406a.m52326b(faqOnlineActivity, faqOnlineActivity.f38938Y);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqOnlineActivity$e */
    public static final class C8372e {

        /* renamed from: a */
        public WeakReference<Activity> f38955a;

        /* renamed from: b */
        public WebView f38956b;

        /* renamed from: c */
        public List<String> f38957c;

        /* renamed from: d */
        public String f38958d;

        /* renamed from: com.huawei.phoneservice.faq.ui.FaqOnlineActivity$e$a */
        public class a extends BaseSdkUpdateRequest<Object> {

            /* renamed from: com.huawei.phoneservice.faq.ui.FaqOnlineActivity$e$a$a, reason: collision with other inner class name */
            public class RunnableC14485a implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ String f38960a;

                public RunnableC14485a(String str) {
                    this.f38960a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C8372e.this.f38956b.loadUrl("javascript:setAccessToken(' " + this.f38960a + " ');");
                }
            }

            public a(Object obj) {
                super(obj);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            public void onCallback(String str, String str2, String str3, Object obj) throws Throwable {
                if ("accessToken".equals(str)) {
                    FaqLogger.print("FaqOnlineActivity", "refreshAccessToken faq_access");
                    if (C8372e.this.f38956b != null) {
                        FaqLogger.print("FaqOnlineActivity", "refreshAccessToken webView");
                        String sdk = FaqSdk.getSdk().getSdk("accessToken");
                        Activity activity = (Activity) C8372e.this.f38955a.get();
                        if (activity != null) {
                            activity.runOnUiThread(new RunnableC14485a(sdk));
                        }
                    }
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                }
            }
        }

        public C8372e(Activity activity, WebView webView) {
            this.f38955a = new WeakReference<>(activity);
            this.f38956b = webView;
        }

        /* renamed from: b */
        public void m52113b(String str) {
            this.f38958d = str;
        }

        /* renamed from: c */
        public void m52114c(List<String> list) {
            this.f38957c = list;
        }

        /* renamed from: d */
        public final boolean m52115d() {
            List<String> list = this.f38957c;
            if (list == null || list.isEmpty() || TextUtils.isEmpty(this.f38958d)) {
                return true;
            }
            return !C11526c.m68808e(this.f38958d, (String[]) this.f38957c.toArray(new String[0]));
        }

        @JavascriptInterface
        public void refreshAccessToken() throws Throwable {
            if (m52115d()) {
                return;
            }
            FaqLogger.print("FaqOnlineActivity", "refreshAccessToken");
            FaqSdk.getISdk().registerUpdateListener(new a(null));
            FaqSdk.getISdk().onSdkErr("accessToken", SdkFaqManager.getSdk().getSdk("accessToken"));
        }

        @JavascriptInterface
        public String venusCustomerService() {
            if (m52115d()) {
                return null;
            }
            WeakReference<Activity> weakReference = this.f38955a;
            if ((weakReference == null ? null : weakReference.get()) != null) {
                return FaqSdk.getSdk().getMap();
            }
            return null;
        }
    }

    /* renamed from: Q0 */
    private void m52106Q0() {
        if (this.f38946g0) {
            this.f38947h0.setVisible(true);
        }
    }

    /* renamed from: a */
    private void m52107a(List<ModuleConfigResponse.ModuleListBean> list) throws Throwable {
        for (ModuleConfigResponse.ModuleListBean moduleListBean : list) {
            if ("2".equals(moduleListBean.getModuleCode())) {
                this.f38944e0 = moduleListBean.getLinkAddress();
                this.f38945f0 = moduleListBean.getOpenType();
                FaqSharePrefUtil.save(this, FaqSharePrefUtil.FAQ_IPCC_FILENAME, FaqSharePrefUtil.FAQ_IPCC_KEY, this.f38944e0);
                FaqSharePrefUtil.save(this, FaqSharePrefUtil.FAQ_IPCC_FILENAME, FaqSharePrefUtil.FAQ_IPCC_TYPE, this.f38945f0);
                this.f38946g0 = true;
                this.f38512F.setVisibility(4);
                m52108N0(this.f38944e0, this.f38937X);
                return;
            }
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: E0 */
    public void mo51663E0() {
        super.mo51663E0();
        this.f38939Z = new C8371d(this);
        this.f38940a0 = new C8372e(this, this.f38511E);
        this.f38511E.addJavascriptInterface(this.f38939Z, "ipccJSInterface");
        this.f38507A = false;
        this.f38511E.addJavascriptInterface(new C8370c(), "AndroidAPP");
        this.f38511E.addJavascriptInterface(this.f38940a0, "venusJSInterface");
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity
    /* renamed from: J0 */
    public void mo51676J0(String str) {
        C8372e c8372e = this.f38940a0;
        if (c8372e != null) {
            c8372e.m52113b(str);
        }
    }

    /* renamed from: N0 */
    public final void m52108N0(String str, FaqIpccBean faqIpccBean) throws Throwable {
        List<String> list;
        if (FaqConstants.OPEN_TYPE_APK.equals(this.f38945f0)) {
            if (this.f38511E == null) {
                return;
            }
            try {
                if (!FaqStringUtil.isEmpty(faqIpccBean.m51944a())) {
                    faqIpccBean.m51945c(URLEncoder.encode(faqIpccBean.m51944a(), Constants.UTF_8));
                }
                this.f38511E.postUrl(str, new Gson().toJson(faqIpccBean).getBytes("utf-8"));
                this.f38946g0 = true;
                return;
            } catch (UnsupportedEncodingException unused) {
                this.f38512F.m52468g(FaqConstants.FaqErrorCode.LOAD_DATA_ERROR);
                FaqLogger.print("FaqOnlineActivity", "UnsupportedEncodingException");
                return;
            }
        }
        if (FaqConstants.OPEN_TYPE_OUT.equals(this.f38945f0)) {
            m51661B0(this.f38944e0);
            return;
        }
        if (FaqConstants.OPEN_TYPE_IN.equals(this.f38945f0)) {
            if (!TextUtils.isEmpty(this.f38944e0) && (list = this.f38948i0) != null) {
                list.add(this.f38944e0);
            }
            C8372e c8372e = this.f38940a0;
            if (c8372e != null) {
                c8372e.m52114c(this.f38948i0);
            }
            m51662D0(this.f38944e0);
        }
    }

    /* renamed from: O0 */
    public final void m52109O0(Throwable th2, ModuleConfigResponse moduleConfigResponse) throws Throwable {
        if (th2 == null && moduleConfigResponse != null) {
            List<ModuleConfigResponse.ModuleListBean> moduleList = moduleConfigResponse.getModuleList();
            if (!FaqCommonUtils.isEmpty(moduleList)) {
                m52107a(moduleList);
                return;
            }
        } else if (th2 != null) {
            this.f38946g0 = false;
            this.f38512F.m52471k(th2);
            return;
        }
        this.f38946g0 = false;
        this.f38512F.m52468g(FaqConstants.FaqErrorCode.LOAD_DATA_ERROR);
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: V */
    public void mo51668V() throws Throwable {
        Bundle extras;
        super.mo51668V();
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey(FaqConstants.ON_IPCC_PARMS)) {
            FaqIpccBean faqIpccBean = (FaqIpccBean) extras.getParcelable(FaqConstants.ON_IPCC_PARMS);
            this.f38937X = faqIpccBean;
            if (faqIpccBean != null) {
                this.f38941b0 = faqIpccBean.m51950h();
                this.f38942c0 = this.f38937X.m51948f();
                this.f38937X.m51940M("");
            }
            try {
                this.f38938Y = extras.getString(FaqConstants.FAQ_CALLFUNCTION);
            } catch (ClassCastException e10) {
                FaqLogger.m51840e("FaqOnlineActivity", e10.getMessage());
            }
        }
        setTitle(getResources().getString(R$string.faq_sdk_menu_online_service));
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() throws Throwable {
        if (this.f38511E == null || this.f38512F == null) {
            return;
        }
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            this.f38512F.m52468g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            return;
        }
        this.f38511E.setVisibility(4);
        this.f38944e0 = FaqSharePrefUtil.getString(this, FaqSharePrefUtil.FAQ_IPCC_FILENAME, FaqSharePrefUtil.FAQ_IPCC_KEY, "");
        this.f38945f0 = FaqSharePrefUtil.getString(this, FaqSharePrefUtil.FAQ_IPCC_FILENAME, FaqSharePrefUtil.FAQ_IPCC_TYPE, "");
        if (TextUtils.isEmpty(this.f38944e0)) {
            this.f38512F.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
            FaqSdk.getISdk().queryModuleList(this, new ModuleConfigRequest(this.f38937X.m51950h(), this.f38937X.m51952j(), FaqUtil.getBrand(), this.f38942c0, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_SHASN), FaqDeviceUtils.getSpecialEmuiVersion(), this.f38937X.m51946d(), this.f38937X.m51954m(), FaqDeviceUtils.getMachineType()), new C8369b(ModuleConfigResponse.class, this));
        } else {
            if (TextUtils.isEmpty(this.f38508B) || this.f38508B.startsWith(this.f38944e0)) {
                this.f38512F.setVisibility(4);
                m52108N0(this.f38944e0, this.f38937X);
                return;
            }
            this.f38512F.setVisibility(4);
            if (FaqWebActivityUtil.isInWhiteList(this.f38508B, this)) {
                this.f38511E.loadUrl(this.f38508B);
            } else {
                FaqWebActivityUtil.goToBrowserWebUrl(this, this.f38508B, true);
            }
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != getResources().getConfiguration().orientation) {
            FaqLanguageUtils.changeAppLanguage(this, this.f38937X.m51952j(), this.f38937X.m51950h(), configuration);
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity, com.huawei.phoneservice.faq.FaqBaseActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C8326a.m51895b().mo51899b(this.f38949j0);
        List<String> whiteList = SdkFaqManager.getManager().getWhiteList();
        if (this.f38948i0 != null && whiteList != null && !whiteList.isEmpty()) {
            this.f38948i0.addAll(whiteList);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.faq_sdk_online_menu, menu);
        MenuItem menuItemFindItem = menu.findItem(R$id.faq_sdk_cancel);
        this.f38947h0 = menuItemFindItem;
        menuItemFindItem.setVisible(false);
        m52106Q0();
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C8326a.m51895b().mo51898a(this.f38949j0);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R$id.faq_sdk_cancel) {
            if (this.f38946g0) {
                this.f38511E.loadUrl("javascript:pageConsole.endPage()");
            } else {
                finish();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.phoneservice.faq.FaqCommonWebActivity, com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: z0 */
    public boolean mo51675z0(String str) throws Throwable {
        StringBuilder sb2;
        String str2;
        if (FaqWebActivityUtil.isUrl(str)) {
            mo51676J0(str);
            if (FaqWebActivityUtil.isInWhiteList(str, this)) {
                return false;
            }
            FaqWebActivityUtil.goToBrowserWebUrl(this, str, false);
            return true;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "ActivityNotFoundException:";
            sb2.append(str2);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("FaqOnlineActivity", sb2.toString());
            return true;
        } catch (IllegalArgumentException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "IllegalArgumentException:";
            sb2.append(str2);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("FaqOnlineActivity", sb2.toString());
            return true;
        }
        return true;
    }
}
