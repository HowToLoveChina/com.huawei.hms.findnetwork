package com.huawei.phoneservice.faq.p174ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.FaqBaseActivity;
import com.huawei.phoneservice.faq.FaqBaseWebActivity;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.R$menu;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.adapter.C8287a;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.AttackCharFilter;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqDeviceUtils;
import com.huawei.phoneservice.faq.base.util.FaqLanguageUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.FaqWebActivityUtil;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.response.C8341a;
import com.huawei.phoneservice.faq.response.C8344d;
import com.huawei.phoneservice.faq.response.C8348h;
import com.huawei.phoneservice.faq.response.FaqFastServicesResponse;
import com.huawei.phoneservice.faq.response.FaqIpccBean;
import com.huawei.phoneservice.faq.response.FaqRecommendResponse;
import com.huawei.phoneservice.faq.utils.C8414d;
import com.huawei.phoneservice.faq.utils.C8417g;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;
import com.huawei.phoneservice.faqcommon.utils.SdkFaqCommonManager;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqRecommendKnowledgeRequest;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p043c1.C1377b;
import p043c1.C1378c;

/* loaded from: classes4.dex */
public class FaqQuestionDetailActivity extends FaqBaseActivity implements View.OnClickListener {

    /* renamed from: A */
    public ScrollView f38963A;

    /* renamed from: A0 */
    public String f38964A0;

    /* renamed from: B */
    public WebView f38965B;

    /* renamed from: B0 */
    public String f38966B0;

    /* renamed from: C */
    public LinearLayout f38967C;

    /* renamed from: D */
    public RelativeLayout f38969D;

    /* renamed from: E */
    public LinearLayout f38971E;

    /* renamed from: E0 */
    public volatile boolean f38972E0;

    /* renamed from: F */
    public LinearLayout f38973F;

    /* renamed from: G */
    public View f38974G;

    /* renamed from: H */
    public Button f38975H;

    /* renamed from: I */
    public Button f38976I;

    /* renamed from: J */
    public TextView f38977J;

    /* renamed from: K */
    public ListView f38978K;

    /* renamed from: L */
    public EditText f38979L;

    /* renamed from: M */
    public TextView f38980M;

    /* renamed from: N */
    public Button f38981N;

    /* renamed from: O */
    public LinearLayout f38982O;

    /* renamed from: P */
    public Button f38983P;

    /* renamed from: Q */
    public ProgressBar f38984Q;

    /* renamed from: R */
    public FaqNoticeView f38985R;

    /* renamed from: S */
    public String f38986S;

    /* renamed from: W */
    public FaqBaseWebActivity.FullscreenHolder f38990W;

    /* renamed from: X */
    public int f38991X;

    /* renamed from: Y */
    public String f38992Y;

    /* renamed from: Z */
    public List<FaqRecommendResponse.RecommendResponse> f38993Z;

    /* renamed from: a0 */
    public boolean f38994a0;

    /* renamed from: g0 */
    public String f39000g0;

    /* renamed from: h0 */
    public String f39001h0;

    /* renamed from: l0 */
    public String f39005l0;

    /* renamed from: m0 */
    public String f39006m0;

    /* renamed from: n0 */
    public String f39007n0;

    /* renamed from: o0 */
    public String f39008o0;

    /* renamed from: p0 */
    public String f39009p0;

    /* renamed from: q0 */
    public String f39010q0;

    /* renamed from: r0 */
    public String f39011r0;

    /* renamed from: s0 */
    public String f39012s0;

    /* renamed from: t0 */
    public String f39013t0;

    /* renamed from: u0 */
    public String f39014u0;

    /* renamed from: v0 */
    public String f39015v0;

    /* renamed from: w0 */
    public String f39016w0;

    /* renamed from: x0 */
    public String f39017x0;

    /* renamed from: y0 */
    public String f39018y0;

    /* renamed from: z0 */
    public String f39019z0;

    /* renamed from: T */
    public List<View> f38987T = new ArrayList(4);

    /* renamed from: U */
    public String f38988U = null;

    /* renamed from: V */
    public String f38989V = null;

    /* renamed from: b0 */
    public Map<String, String> f38995b0 = new HashMap();

    /* renamed from: c0 */
    public List<C8344d.a> f38996c0 = new ArrayList();

    /* renamed from: d0 */
    public int f38997d0 = 0;

    /* renamed from: e0 */
    public int f38998e0 = 0;

    /* renamed from: f0 */
    public boolean f38999f0 = false;

    /* renamed from: i0 */
    public String f39002i0 = "CN";

    /* renamed from: j0 */
    public String f39003j0 = "4";

    /* renamed from: k0 */
    public String f39004k0 = "hicare";

    /* renamed from: C0 */
    public FaqNoticeView.InterfaceC8428b f38968C0 = new C8375b();

    /* renamed from: D0 */
    public Runnable f38970D0 = new RunnableC8376c();

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$11 */
    public class C837311 extends WebChromeClient {
        WebChromeClient.CustomViewCallback customViewCallback;

        public C837311() {
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            return new TextView(FaqQuestionDetailActivity.this);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (FaqQuestionDetailActivity.this.f38990W != null) {
                WebChromeClient.CustomViewCallback customViewCallback = this.customViewCallback;
                if (customViewCallback != null) {
                    customViewCallback.onCustomViewHidden();
                }
                FrameLayout frameLayout = (FrameLayout) FaqQuestionDetailActivity.this.getWindow().getDecorView();
                FaqQuestionDetailActivity.this.f38990W.removeAllViews();
                frameLayout.removeView(FaqQuestionDetailActivity.this.f38990W);
                FaqQuestionDetailActivity.this.f38990W = null;
                if (FaqCommonUtils.isPad()) {
                    FaqQuestionDetailActivity.this.setRequestedOrientation(2);
                } else {
                    FaqQuestionDetailActivity.this.setRequestedOrientation(1);
                }
                FaqQuestionDetailActivity.this.m52143a(true);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (FaqQuestionDetailActivity.this.f38990W != null) {
                WebChromeClient.CustomViewCallback customViewCallback2 = this.customViewCallback;
                if (customViewCallback2 != null) {
                    customViewCallback2.onCustomViewHidden();
                    return;
                }
                return;
            }
            FaqQuestionDetailActivity.this.f38985R.setVisibility(8);
            this.customViewCallback = customViewCallback;
            FaqQuestionDetailActivity.this.setRequestedOrientation(6);
            FaqQuestionDetailActivity.this.m52143a(false);
            FrameLayout frameLayout = (FrameLayout) FaqQuestionDetailActivity.this.getWindow().getDecorView();
            FaqQuestionDetailActivity.this.f38990W = new FaqBaseWebActivity.FullscreenHolder(FaqQuestionDetailActivity.this);
            FaqBaseWebActivity.FullscreenHolder fullscreenHolder = FaqQuestionDetailActivity.this.f38990W;
            FrameLayout.LayoutParams layoutParams = FaqBaseWebActivity.f38506W;
            fullscreenHolder.addView(view, layoutParams);
            frameLayout.addView(FaqQuestionDetailActivity.this.f38990W, layoutParams);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$a */
    public class RunnableC8374a implements Runnable {
        public RunnableC8374a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[2];
            FaqQuestionDetailActivity.this.f38981N.getLocationOnScreen(iArr);
            int measuredHeight = (iArr[1] - FaqQuestionDetailActivity.this.f38963A.getMeasuredHeight()) - 50;
            if (measuredHeight < 0) {
                measuredHeight = 0;
            }
            FaqQuestionDetailActivity.this.f38963A.smoothScrollBy(0, measuredHeight);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$b */
    public class C8375b implements FaqNoticeView.InterfaceC8428b {
        public C8375b() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqNoticeView.InterfaceC8428b
        /* renamed from: a */
        public void mo52087a() throws Throwable {
            FaqQuestionDetailActivity.this.m52160q0();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$c */
    public class RunnableC8376c implements Runnable {
        public RunnableC8376c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FaqQuestionDetailActivity.this.f38997d0 = 3;
            FaqQuestionDetailActivity.this.f38999f0 = true;
            FaqQuestionDetailActivity.this.f38965B.stopLoading();
            if (FaqQuestionDetailActivity.this.f38972E0) {
                return;
            }
            FaqQuestionDetailActivity.this.m52164u0();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$d */
    public class ViewOnTouchListenerC8377d implements View.OnTouchListener {
        public ViewOnTouchListenerC8377d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FaqQuestionDetailActivity.this.m52161r0();
            if (FaqQuestionDetailActivity.this.f38979L.hasFocus()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                if ((motionEvent.getAction() & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) == 8) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$e */
    public class C8378e implements TextWatcher {
        public C8378e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FaqQuestionDetailActivity.this.f38980M.setText(String.format(FaqQuestionDetailActivity.this.getResources().getString(R$string.faq_sdk_input_text_count), Integer.valueOf(editable.length()), 500));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$f */
    public class C8379f extends WebViewClient {
        public C8379f() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            FaqQuestionDetailActivity.this.f38985R.removeCallbacks(FaqQuestionDetailActivity.this.f38970D0);
            FaqQuestionDetailActivity.this.f38985R.setEnabled(true);
            FaqQuestionDetailActivity.this.f38965B.getSettings().setBlockNetworkImage(false);
            if (!FaqQuestionDetailActivity.this.f38999f0) {
                FaqQuestionDetailActivity.this.f38997d0 = 2;
            }
            if (FaqQuestionDetailActivity.this.f38972E0) {
                return;
            }
            FaqQuestionDetailActivity.this.m52164u0();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            FaqQuestionDetailActivity.this.f38999f0 = false;
            FaqQuestionDetailActivity.this.f38997d0 = 1;
            FaqQuestionDetailActivity.this.f38985R.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
            FaqQuestionDetailActivity.this.f38985R.setEnabled(false);
            FaqQuestionDetailActivity.this.f38985R.postDelayed(FaqQuestionDetailActivity.this.f38970D0, 20000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) throws Throwable {
            super.onReceivedError(webView, i10, str, str2);
            FaqLogger.m51840e("FaqQuestionDetail", i10 + "");
            FaqQuestionDetailActivity.this.f38997d0 = 3;
            FaqQuestionDetailActivity.this.f38999f0 = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            FaqWebActivityUtil.onReceivedSslError(sslErrorHandler);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return FaqWebActivityUtil.overrideUrlLoading(str, FaqQuestionDetailActivity.this);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$g */
    public class C8380g extends FaqCallback<FaqRecommendResponse> {
        public C8380g(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, FaqRecommendResponse faqRecommendResponse) {
            if (th2 == null && faqRecommendResponse != null) {
                FaqQuestionDetailActivity.this.f38993Z = faqRecommendResponse.m51983a();
                if (!FaqCommonUtils.isEmpty(FaqQuestionDetailActivity.this.f38993Z)) {
                    FaqQuestionDetailActivity faqQuestionDetailActivity = FaqQuestionDetailActivity.this;
                    faqQuestionDetailActivity.f38992Y = ((FaqRecommendResponse.RecommendResponse) faqQuestionDetailActivity.f38993Z.get(0)).m51984a();
                    FaqQuestionDetailActivity faqQuestionDetailActivity2 = FaqQuestionDetailActivity.this;
                    faqQuestionDetailActivity2.m52147c(faqQuestionDetailActivity2.f38992Y);
                    return;
                }
            }
            FaqQuestionDetailActivity.this.f38972E0 = true;
            FaqQuestionDetailActivity.this.f38985R.setEnabled(true);
            FaqQuestionDetailActivity.this.f38985R.m52468g(FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$h */
    public class C8381h extends FaqCallback<C8344d> {
        public C8381h(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8344d c8344d) throws Throwable {
            if (th2 == null) {
                FaqQuestionDetailActivity.this.f38998e0 = 2;
                if (c8344d != null && c8344d.m51999a() != null) {
                    FaqQuestionDetailActivity.this.f38996c0.clear();
                    FaqQuestionDetailActivity.this.f38996c0.addAll(c8344d.m51999a());
                }
            } else {
                FaqLogger.m51840e("FaqQuestionDetail", "recommend，Json parse fail :" + th2);
                FaqQuestionDetailActivity.this.f38998e0 = 3;
            }
            if (FaqQuestionDetailActivity.this.f38972E0) {
                return;
            }
            FaqQuestionDetailActivity.this.m52164u0();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$i */
    public class C8382i extends FaqCallback<C8348h> {
        public C8382i(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8348h c8348h) {
            if (th2 != null || c8348h == null || c8348h.m52009a() == null) {
                return;
            }
            FaqQuestionDetailActivity.this.f38966B0 = c8348h.m52009a();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$j */
    public class C8383j extends FaqCallback<C8341a> {

        /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$j$a */
        public class a implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            public final /* synthetic */ C8287a f39030a;

            public a(C8287a c8287a) {
                this.f39030a = c8287a;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                List<C8341a.a> listM51746b = this.f39030a.m51746b();
                if (listM51746b == null) {
                    return;
                }
                Iterator<C8341a.a> it = listM51746b.iterator();
                while (it.hasNext()) {
                    it.next().m51989b(false);
                }
                C8341a.a item = this.f39030a.getItem(i10);
                if (item == null) {
                    return;
                }
                FaqQuestionDetailActivity.this.f38964A0 = item.m51988a();
                item.m51989b(true);
                this.f39030a.notifyDataSetChanged();
                FaqQuestionDetailActivity.this.f38981N.setEnabled(true);
            }
        }

        public C8383j(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8341a c8341a) {
            FaqQuestionDetailActivity.this.f38984Q.setVisibility(8);
            if (th2 != null || c8341a == null || c8341a.m51987a() == null || c8341a.m51987a().size() <= 0) {
                FaqQuestionDetailActivity.this.f38967C.setVisibility(8);
                FaqQuestionDetailActivity.this.m52163t0();
                return;
            }
            C8287a c8287a = new C8287a(c8341a.m51987a());
            FaqQuestionDetailActivity.this.f38978K.setAdapter((ListAdapter) c8287a);
            FaqQuestionDetailActivity.this.f38978K.setOnItemClickListener(new a(c8287a));
            FaqQuestionDetailActivity.this.f38967C.setVisibility(8);
            FaqQuestionDetailActivity.this.f38971E.setVisibility(0);
            if (FaqQuestionDetailActivity.this.f38963A == null || !FaqQuestionDetailActivity.this.f38981N.isShown()) {
                return;
            }
            FaqQuestionDetailActivity.this.m52161r0();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity$k */
    public static class C8384k implements Callback {
        public C8384k() {
        }

        public /* synthetic */ C8384k(C8375b c8375b) {
            this();
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onFailure(Submit submit, Throwable th2) {
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onResponse(Submit submit, Response response) throws IOException {
        }
    }

    /* renamed from: A0 */
    public static void m52116A0(Context context, String str, String str2, String str3, boolean z10, String str4) {
        Intent intent = new Intent(context, (Class<?>) FaqQuestionDetailActivity.class);
        intent.putExtra("title", str);
        intent.putExtra("url", str2);
        intent.putExtra("Isdetails", z10);
        intent.putExtra("knowledgeId", str3);
        intent.putExtra("totadescriptionl", str4);
        intent.putExtra(FaqConstants.FAQ_EMUI_LANGUAGE, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ISOLANGUAGE));
        intent.putExtra("emuilanguage", SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE));
        intent.putExtra("brands", SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_MODEL));
        intent.putExtra("country", SdkFaqManager.getSdk().getSdk("country"));
        intent.putExtra(FaqConstants.FAQ_LEVEL, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LEVEL));
        intent.putExtra("accessToken", SdkFaqManager.getSdk().getSdk("accessToken"));
        intent.putExtra(FaqConstants.FAQ_REFRESH, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_REFRESH));
        intent.putExtra(FaqConstants.FAQ_CHANNEL, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL));
        intent.putExtra("appVersion", SdkFaqManager.getSdk().getSdk("appVersion"));
        intent.putExtra(FaqConstants.FAQ_SHASN, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_SHASN));
        intent.putExtra(FaqConstants.FAQ_ROMVERSION, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION));
        intent.putExtra(FaqConstants.FAQ_EMUIVERSION, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION));
        intent.putExtra(FaqConstants.FAQ_OSVERSION, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_OSVERSION));
        intent.putExtra("countrycode", SdkFaqManager.getSdk().getSdk("countryCode"));
        intent.putExtra(FaqConstants.FAQ_CALLFUNCTION, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CALLFUNCTION));
        intent.putExtra(FaqConstants.FAQ_WECHATID, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WECHATID));
        intent.putExtra(FaqConstants.FAQ_WEIBOID, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WEIBOID));
        intent.putExtra(FaqConstants.FAQ_PICID, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_PICID));
        context.startActivity(intent);
    }

    /* renamed from: X0 */
    private void m52139X0() {
        SdkFaqCommonManager.INSTANCE.getFaqStatisticsKnowledge(this, this.f39000g0, "", m51648n0(), new C8384k(null));
    }

    /* renamed from: Y0 */
    private void m52140Y0() throws Throwable {
        FaqCommonUtils.hideIme(this);
        if (FaqCommonUtils.isConnectionAvailable(this)) {
            m52148c1();
        } else {
            FaqToastUtils.makeText(this, getString(R$string.faq_sdk_no_network_toast));
        }
    }

    /* renamed from: a */
    private void m52142a(List<C8344d.a> list) {
        if (list == null || list.isEmpty() || this.f38998e0 != 2) {
            this.f38974G.setVisibility(8);
            this.f38973F.setVisibility(8);
            return;
        }
        this.f38974G.setVisibility(0);
        this.f38973F.setVisibility(0);
        int size = list.size();
        int i10 = 0;
        while (i10 < this.f38987T.size()) {
            View view = this.f38987T.get(i10);
            if (i10 < size) {
                view.setVisibility(0);
                C8344d.a aVar = list.get(i10);
                TextView textView = (TextView) view.findViewById(R$id.text_content);
                view.findViewById(R$id.split_line).setVisibility(i10 == size + (-1) ? 8 : 0);
                textView.setText(aVar.m52001b());
                view.setOnClickListener(this);
                view.setTag(aVar);
            } else {
                view.setVisibility(8);
            }
            i10++;
        }
    }

    /* renamed from: a1 */
    private void m52144a1() throws Throwable {
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            FaqToastUtils.makeText(this, getString(R$string.faq_sdk_no_network_toast));
            return;
        }
        this.f38967C.setVisibility(8);
        this.f38969D.setVisibility(0);
        FaqTrack.event(this.f39005l0 + "+SDK+Detail", "Click on Yes", this.f38986S);
        m52145b("5");
    }

    /* renamed from: b */
    private void m52145b(String str) {
        SdkFaqCommonManager.INSTANCE.getFaqEvaluateKnowledge(this, this.f39000g0, str, m51648n0(), new C8384k(null));
    }

    /* renamed from: c */
    public void m52147c(String str) {
        if (FaqWebActivityUtil.isUrl(str)) {
            this.f38965B.loadUrl(str);
            return;
        }
        this.f38972E0 = true;
        this.f38985R.m52468g(FaqConstants.FaqErrorCode.LOAD_DATA_ERROR);
        this.f38985R.setEnabled(true);
    }

    /* renamed from: c1 */
    private void m52148c1() {
        this.f38981N.setEnabled(false);
        this.f38971E.setVisibility(8);
        m52163t0();
        SdkFaqCommonManager.INSTANCE.faqEvaluateSubmit(this, this.f38979L.getText().toString(), this.f38964A0, this.f39000g0, new C8384k(null));
    }

    /* renamed from: f1 */
    private void m52151f1() throws Throwable {
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            FaqToastUtils.makeText(this, getString(R$string.faq_sdk_no_network_toast));
            return;
        }
        if (TextUtils.isEmpty(this.f38966B0)) {
            this.f38967C.setVisibility(8);
            m52163t0();
        } else {
            m52170k1();
        }
        FaqTrack.event(this.f39005l0 + "+SDK+Detail", "Click on No", this.f38986S);
        m52145b("1");
    }

    /* renamed from: h1 */
    private void m52153h1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f38986S = intent.getStringExtra("title");
            this.f38992Y = intent.getStringExtra("url");
            this.f39001h0 = intent.getStringExtra("brands");
            this.f39005l0 = intent.getStringExtra(FaqConstants.FAQ_CHANNEL);
            this.f39006m0 = intent.getStringExtra(FaqConstants.FAQ_LEVEL);
            this.f39007n0 = intent.getStringExtra("country");
            this.f38988U = intent.getStringExtra(FaqConstants.FAQ_EMUI_LANGUAGE);
            this.f38989V = intent.getStringExtra("emuilanguage");
            this.f39000g0 = intent.getStringExtra("knowledgeId");
            this.f39011r0 = intent.getStringExtra("appVersion");
            this.f39012s0 = intent.getStringExtra(FaqConstants.FAQ_SHASN);
            this.f39008o0 = intent.getStringExtra(FaqConstants.FAQ_ROMVERSION);
            this.f39009p0 = intent.getStringExtra(FaqConstants.FAQ_EMUIVERSION);
            this.f39013t0 = intent.getStringExtra(FaqConstants.FAQ_OSVERSION);
            this.f39014u0 = intent.getStringExtra("countrycode");
            this.f39015v0 = intent.getStringExtra(FaqConstants.FAQ_CALLFUNCTION);
            this.f39010q0 = intent.getStringExtra("accessToken");
            this.f38994a0 = intent.getBooleanExtra("Isdetails", false);
            this.f39016w0 = intent.getStringExtra(FaqConstants.FAQ_WECHATID);
            this.f39017x0 = intent.getStringExtra(FaqConstants.FAQ_WEIBOID);
            this.f39018y0 = intent.getStringExtra(FaqConstants.FAQ_PICID);
            this.f39019z0 = intent.getStringExtra("totadescriptionl");
        }
    }

    /* renamed from: j1 */
    private void m52155j1() {
        SdkFaqCommonManager.INSTANCE.getRecommendDetails(this, this.f39000g0, new C8380g(FaqRecommendResponse.class, this));
    }

    /* renamed from: l1 */
    private void m52156l1() {
        SdkFaqCommonManager.INSTANCE.getFaqSiteCode(this, new C8382i(C8348h.class, this));
    }

    /* renamed from: m1 */
    private void m52157m1() {
        this.f38979L.setFilters(new InputFilter[]{new AttackCharFilter()});
        this.f38979L.setOnTouchListener(new ViewOnTouchListenerC8377d());
        this.f38979L.addTextChangedListener(new C8378e());
    }

    /* renamed from: n1 */
    private void m52158n1() throws Throwable {
        this.f38965B.getSettings().setJavaScriptEnabled(true);
        this.f38965B.getSettings().setBlockNetworkImage(true);
        this.f38965B.getSettings().setMixedContentMode(2);
        this.f38965B.getSettings().setUseWideViewPort(true);
        this.f38965B.getSettings().setLoadWithOverviewMode(true);
        this.f38965B.getSettings().setCacheMode(-1);
        this.f38965B.setHorizontalScrollBarEnabled(false);
        this.f38965B.setVerticalScrollBarEnabled(false);
        try {
            if (C1378c.m7915a("FORCE_DARK")) {
                WebSettings settings = this.f38965B.getSettings();
                int i10 = getResources().getConfiguration().uiMode & 48;
                if (i10 == 0 || i10 == 16) {
                    C1377b.m7914b(settings, 0);
                } else if (i10 != 32) {
                    FaqLogger.m51840e("FaqQuestionDetail", "dark disable");
                } else {
                    C1377b.m7914b(settings, 2);
                }
            }
        } catch (Throwable th2) {
            FaqLogger.m51840e("FaqQuestionDetail", th2.getMessage());
        }
        FaqWebActivityUtil.initWebView(this.f38965B);
    }

    /* renamed from: p0 */
    private void m52159p0() {
        this.f38965B.setWebViewClient(new C8379f());
    }

    /* renamed from: q0 */
    public void m52160q0() throws Throwable {
        FaqFastServicesResponse.ModuleListBean moduleListBean = new FaqFastServicesResponse.ModuleListBean();
        moduleListBean.m51928d(21);
        moduleListBean.m51929e(FaqConstants.OPEN_TYPE_IN);
        FaqIpccBean faqIpccBean = new FaqIpccBean();
        faqIpccBean.m51945c(this.f39010q0);
        faqIpccBean.m51957p(this.f38988U);
        faqIpccBean.m51949g(this.f39005l0);
        faqIpccBean.m51951i(this.f39007n0);
        faqIpccBean.m51955n(this.f39006m0);
        faqIpccBean.m51961t(this.f39001h0);
        faqIpccBean.m51956o(this.f39009p0);
        faqIpccBean.m51962v(this.f39013t0);
        faqIpccBean.m51953l(this.f39014u0);
        faqIpccBean.m51947e(this.f39011r0);
        faqIpccBean.m51939L(this.f39012s0);
        faqIpccBean.m51937I(this.f39008o0);
        faqIpccBean.m51941N(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_TYPECODE));
        faqIpccBean.m51942O(this.f39016w0);
        faqIpccBean.m51943P(this.f39017x0);
        faqIpccBean.m51936A(this.f39018y0);
        faqIpccBean.m51958q(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID));
        faqIpccBean.m51960s(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_SECRET_KEY));
        faqIpccBean.m51959r(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_LOG_PATH));
        C8406a.m52330f(this, moduleListBean, faqIpccBean, this.f39015v0);
        FaqTrack.event(this.f39005l0 + "+SDK", "Click on Contact us", "contact us");
    }

    /* renamed from: r0 */
    public void m52161r0() {
        this.f38963A.postDelayed(new RunnableC8374a(), 200L);
    }

    /* renamed from: s0 */
    private void m52162s0() {
        this.f38965B.setWebChromeClient(new WebChromeClient() { // from class: com.huawei.phoneservice.faq.ui.FaqQuestionDetailActivity.11
            WebChromeClient.CustomViewCallback customViewCallback;

            public C837311() {
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                return new TextView(FaqQuestionDetailActivity.this);
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (FaqQuestionDetailActivity.this.f38990W != null) {
                    WebChromeClient.CustomViewCallback customViewCallback = this.customViewCallback;
                    if (customViewCallback != null) {
                        customViewCallback.onCustomViewHidden();
                    }
                    FrameLayout frameLayout = (FrameLayout) FaqQuestionDetailActivity.this.getWindow().getDecorView();
                    FaqQuestionDetailActivity.this.f38990W.removeAllViews();
                    frameLayout.removeView(FaqQuestionDetailActivity.this.f38990W);
                    FaqQuestionDetailActivity.this.f38990W = null;
                    if (FaqCommonUtils.isPad()) {
                        FaqQuestionDetailActivity.this.setRequestedOrientation(2);
                    } else {
                        FaqQuestionDetailActivity.this.setRequestedOrientation(1);
                    }
                    FaqQuestionDetailActivity.this.m52143a(true);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (FaqQuestionDetailActivity.this.f38990W != null) {
                    WebChromeClient.CustomViewCallback customViewCallback2 = this.customViewCallback;
                    if (customViewCallback2 != null) {
                        customViewCallback2.onCustomViewHidden();
                        return;
                    }
                    return;
                }
                FaqQuestionDetailActivity.this.f38985R.setVisibility(8);
                this.customViewCallback = customViewCallback;
                FaqQuestionDetailActivity.this.setRequestedOrientation(6);
                FaqQuestionDetailActivity.this.m52143a(false);
                FrameLayout frameLayout = (FrameLayout) FaqQuestionDetailActivity.this.getWindow().getDecorView();
                FaqQuestionDetailActivity.this.f38990W = new FaqBaseWebActivity.FullscreenHolder(FaqQuestionDetailActivity.this);
                FaqBaseWebActivity.FullscreenHolder fullscreenHolder = FaqQuestionDetailActivity.this.f38990W;
                FrameLayout.LayoutParams layoutParams = FaqBaseWebActivity.f38506W;
                fullscreenHolder.addView(view, layoutParams);
                frameLayout.addView(FaqQuestionDetailActivity.this.f38990W, layoutParams);
            }
        });
    }

    /* renamed from: t0 */
    public void m52163t0() {
        (ModuleConfigUtils.contactEnabled() ? this.f38982O : this.f38969D).setVisibility(0);
    }

    /* renamed from: u0 */
    public void m52164u0() {
        int i10;
        FaqNoticeView faqNoticeView;
        FaqConstants.FaqErrorCode faqErrorCode;
        int i11 = this.f38998e0;
        if (i11 == 0 || i11 == 1 || (i10 = this.f38997d0) == 0 || i10 == 1) {
            this.f38985R.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
            this.f38985R.setEnabled(false);
            return;
        }
        if (i10 != 3) {
            m52142a(this.f38996c0);
            this.f38985R.setVisibility(8);
            return;
        }
        if (FaqCommonUtils.isConnectionAvailable(this)) {
            this.f38972E0 = true;
            faqNoticeView = this.f38985R;
            faqErrorCode = FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR;
        } else {
            faqNoticeView = this.f38985R;
            faqErrorCode = FaqConstants.FaqErrorCode.INTERNET_ERROR;
        }
        faqNoticeView.m52468g(faqErrorCode);
        this.f38985R.setEnabled(true);
    }

    /* renamed from: z0 */
    public static void m52169z0(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, boolean z10, String str19, String str20, String str21, String str22) {
        Intent intent = new Intent(context, (Class<?>) FaqQuestionDetailActivity.class);
        intent.putExtra(FaqConstants.FAQ_EMUI_LANGUAGE, str);
        intent.putExtra("emuilanguage", str2);
        intent.putExtra("title", str3);
        intent.putExtra("url", str4);
        intent.putExtra("brands", str5);
        intent.putExtra("knowledgeId", str6);
        intent.putExtra("country", str7);
        intent.putExtra(FaqConstants.FAQ_LEVEL, str8);
        intent.putExtra("accessToken", str9);
        intent.putExtra(FaqConstants.FAQ_REFRESH, str10);
        intent.putExtra(FaqConstants.FAQ_CHANNEL, str11);
        intent.putExtra("appVersion", str12);
        intent.putExtra(FaqConstants.FAQ_SHASN, str13);
        intent.putExtra(FaqConstants.FAQ_ROMVERSION, str14);
        intent.putExtra(FaqConstants.FAQ_EMUIVERSION, str15);
        intent.putExtra(FaqConstants.FAQ_OSVERSION, str16);
        intent.putExtra("countrycode", str17);
        intent.putExtra(FaqConstants.FAQ_CALLFUNCTION, str18);
        intent.putExtra("Isdetails", z10);
        intent.putExtra(FaqConstants.FAQ_WECHATID, str19);
        intent.putExtra(FaqConstants.FAQ_WEIBOID, str20);
        intent.putExtra(FaqConstants.FAQ_PICID, str21);
        intent.putExtra("totadescriptionl", str22);
        context.startActivity(intent);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() {
        setTitle(this.f38986S);
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            this.f38985R.m52468g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            this.f38985R.setEnabled(true);
            return;
        }
        if (ModuleConfigUtils.relevanceKnowledgeEnabled()) {
            m52171o0();
        } else {
            this.f38998e0 = 3;
        }
        this.f38985R.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
        this.f38985R.setEnabled(false);
        if (FaqStringUtil.isEmpty(this.f38992Y) && this.f38994a0) {
            m52155j1();
        } else {
            m52147c(this.f38992Y);
        }
        m52139X0();
        m52156l1();
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f0 */
    public int mo51678f0() {
        return R$layout.faq_sdk_activity_faq_question_detail_layout;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: g0 */
    public int[] mo52017g0() {
        return new int[]{R$id.faq_webView, R$id.textView_tech_detail, R$id.faq_question_detail_evaluate_host, R$id.thanks_container, R$id.recommend_container};
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: h0 */
    public void mo51671h0() {
        this.f38985R.setOnClickListener(this);
        Button button = this.f38975H;
        if (button != null) {
            button.setOnClickListener(this);
        }
        Button button2 = this.f38976I;
        if (button2 != null) {
            button2.setOnClickListener(this);
        }
        Button button3 = this.f38981N;
        if (button3 != null) {
            button3.setOnClickListener(this);
        }
        Button button4 = this.f38983P;
        if (button4 != null) {
            button4.setOnClickListener(this);
        }
        m52162s0();
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: i0 */
    public void mo51672i0() throws Throwable {
        this.f38963A = (ScrollView) findViewById(R$id.faq_container);
        this.f38969D = (RelativeLayout) findViewById(R$id.thanks_container);
        this.f38971E = (LinearLayout) findViewById(R$id.faq_question_detail_evaluate_list_host);
        this.f38973F = (LinearLayout) findViewById(R$id.recommend_container);
        this.f38974G = findViewById(R$id.recommend_section);
        for (int i10 = 0; i10 < 4; i10++) {
            View viewInflate = LayoutInflater.from(this).inflate(R$layout.faq_sdk_adapter_faq_recommend_list_item, (ViewGroup) this.f38973F, false);
            this.f38987T.add(viewInflate);
            this.f38973F.addView(viewInflate);
        }
        this.f38977J = (TextView) findViewById(R$id.thanks_text);
        this.f38967C = (LinearLayout) findViewById(R$id.faq_question_detail_evaluate_host);
        this.f38978K = (ListView) findViewById(R$id.faq_question_detail_evaluate_list);
        TextView textView = (TextView) findViewById(R$id.faq_question_detail_evaluate_content_count);
        this.f38980M = textView;
        textView.setText(String.format(getResources().getString(R$string.faq_sdk_input_text_count), 0, 500));
        this.f38979L = (EditText) findViewById(R$id.faq_question_detail_evaluate_content);
        m52157m1();
        Button button = (Button) findViewById(R$id.faq_question_detail_evaluate_submit);
        this.f38981N = button;
        C8417g.m52396b(this, button);
        this.f38975H = (Button) findViewById(R$id.faq_question_detail_resolved);
        this.f38976I = (Button) findViewById(R$id.faq_question_detail_unresolved);
        this.f38984Q = (ProgressBar) findViewById(R$id.faq_question_detail_progress);
        this.f38982O = (LinearLayout) findViewById(R$id.faq_question_detail_online_host);
        Button button2 = (Button) findViewById(R$id.faq_question_detail_online);
        this.f38983P = button2;
        C8417g.m52396b(this, button2);
        this.f38965B = (WebView) findViewById(R$id.faq_webView);
        FaqNoticeView faqNoticeView = (FaqNoticeView) findViewById(R$id.notice_view);
        this.f38985R = faqNoticeView;
        faqNoticeView.setCallback(this.f38968C0);
        this.f38985R.setEnabled(false);
        this.f38991X = getWindow().getDecorView().getSystemUiVisibility();
        m52158n1();
        m52159p0();
    }

    /* renamed from: k1 */
    public final void m52170k1() {
        this.f38984Q.setVisibility(0);
        SdkFaqCommonManager.INSTANCE.getFaqEvaluateList(this, this.f38966B0, new C8383j(C8341a.class, this));
    }

    /* renamed from: o0 */
    public void m52171o0() {
        int i10 = this.f38998e0;
        if (i10 == 0 || i10 == 3) {
            this.f38998e0 = 1;
            FaqRecommendKnowledgeRequest faqRecommendKnowledgeRequest = new FaqRecommendKnowledgeRequest();
            String brand = FaqDeviceUtils.getBrand();
            faqRecommendKnowledgeRequest.setLanguage(this.f38989V);
            faqRecommendKnowledgeRequest.setBrand(brand);
            faqRecommendKnowledgeRequest.setSite(this.f39002i0);
            faqRecommendKnowledgeRequest.setKnowledgeId(this.f39000g0);
            faqRecommendKnowledgeRequest.setSize(this.f39003j0);
            faqRecommendKnowledgeRequest.setqAppName(this.f39004k0);
            SdkFaqCommonManager.INSTANCE.getFAQRecommendKnowledge(this, faqRecommendKnowledgeRequest, new C8381h(C8344d.class, this));
        }
    }

    /* renamed from: o1 */
    public final boolean m52172o1() throws Throwable {
        String str;
        if (!"CN".equals(this.f39007n0)) {
            str = "share to other because countryCode is " + this.f39007n0;
        } else {
            if (!TextUtils.isEmpty(this.f39016w0)) {
                return false;
            }
            str = "share to other because both weChatId and weiboId are empty. ";
        }
        FaqLogger.m51836d("FaqQuestionDetail", str);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws Throwable {
        super.onActivityResult(i10, i11, intent);
        try {
            if (i10 == 1 && i11 == -1) {
                this.f38967C.setVisibility(8);
                this.f38982O.setVisibility(8);
                this.f38969D.setVisibility(0);
                this.f38977J.setVisibility(0);
                if (intent != null && intent.getExtras() != null) {
                    String string = intent.getExtras().getString("result");
                    if (!TextUtils.isEmpty(string)) {
                        this.f38977J.setText(string);
                    }
                }
            } else {
                if (i10 != 2 || intent == null) {
                    return;
                }
                if (intent.getExtras() != null) {
                    Bundle extras = intent.getExtras();
                    String string2 = extras.getString("FAQURL");
                    String string3 = extras.getString("FAQID");
                    if (!FaqStringUtil.isEmpty(string3)) {
                        this.f38995b0.put(string3, string2);
                    }
                }
            }
        } catch (Throwable th2) {
            FaqLogger.m51840e("FaqQuestionDetail", th2.getMessage());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.f38972E0 = false;
        WebView webView = this.f38965B;
        if (webView != null && webView.canGoBack()) {
            this.f38965B.goBack();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("FAQURL", this.f38992Y);
        intent.putExtra("FAQID", this.f39000g0);
        setResult(3, intent);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (NoDoubleClickUtil.isDoubleClick(view)) {
            return;
        }
        if (view.getId() == R$id.faq_question_detail_resolved) {
            m52144a1();
            return;
        }
        if (view.getId() == R$id.faq_question_detail_unresolved) {
            m52151f1();
            return;
        }
        if (!(view.getTag() instanceof C8344d.a)) {
            if (view.getId() == R$id.notice_view) {
                this.f38972E0 = false;
                mo51677f();
                return;
            } else if (view.getId() == R$id.faq_question_detail_evaluate_submit) {
                m52140Y0();
                return;
            } else {
                if (view.getId() == R$id.faq_question_detail_online) {
                    m52160q0();
                    return;
                }
                return;
            }
        }
        C8344d.a aVar = (C8344d.a) view.getTag();
        Intent intent = new Intent(this, (Class<?>) FaqQuestionDetailActivity.class);
        intent.putExtra(FaqConstants.FAQ_EMUI_LANGUAGE, this.f38988U);
        intent.putExtra("emuilanguage", this.f38989V);
        intent.putExtra("title", aVar.m52001b());
        String str = this.f38995b0.get(aVar.m52000a());
        if (FaqStringUtil.isEmpty(str)) {
            str = "";
        }
        intent.putExtra("url", str);
        intent.putExtra("brands", this.f39001h0);
        intent.putExtra("knowledgeId", aVar.m52000a());
        intent.putExtra("country", this.f39007n0);
        intent.putExtra(FaqConstants.FAQ_LEVEL, this.f39006m0);
        intent.putExtra("accessToken", this.f39010q0);
        intent.putExtra(FaqConstants.FAQ_CHANNEL, this.f39005l0);
        intent.putExtra("appVersion", this.f39011r0);
        intent.putExtra(FaqConstants.FAQ_SHASN, this.f39012s0);
        intent.putExtra(FaqConstants.FAQ_ROMVERSION, this.f39008o0);
        intent.putExtra(FaqConstants.FAQ_EMUIVERSION, this.f39009p0);
        intent.putExtra(FaqConstants.FAQ_OSVERSION, this.f39013t0);
        intent.putExtra("countrycode", this.f39014u0);
        intent.putExtra(FaqConstants.FAQ_CALLFUNCTION, this.f39015v0);
        intent.putExtra("Isdetails", true);
        intent.putExtra(FaqConstants.FAQ_WECHATID, this.f39016w0);
        intent.putExtra(FaqConstants.FAQ_WEIBOID, this.f39017x0);
        intent.putExtra(FaqConstants.FAQ_PICID, this.f39018y0);
        startActivityForResult(intent, 2);
        FaqTrack.event(this.f39005l0 + "+SDK+Detail", "Click on Related FAQ", aVar.m52001b());
        finish();
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != getResources().getConfiguration().orientation) {
            FaqLanguageUtils.changeAppLanguage(this, this.f38988U, this.f39007n0, configuration);
        }
        C8417g.m52396b(this, this.f38981N);
        C8417g.m52396b(this, this.f38983P);
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        m52153h1();
        super.onCreate(bundle);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        FaqWebActivityUtil.destroyWeb(this.f38965B);
        super.onDestroy();
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R$id.faq_sdk_menu_sendto) {
            WebView webView = this.f38965B;
            if (webView != null && !TextUtils.isEmpty(webView.getTitle()) && !TextUtils.isEmpty(this.f38965B.getUrl())) {
                if (m52172o1()) {
                    C8414d.m52381c(this.f39005l0, this, this.f38986S, this.f38992Y);
                } else {
                    FaqShareActivity.m52260p0(this, this.f38986S, this.f38992Y, this.f39007n0, this.f39005l0, this.f39016w0, this.f39017x0, this.f39018y0, this.f39019z0);
                }
            }
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return false;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        WebView webView = this.f38965B;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R$menu.faq_sdk_manual_menu, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        WebView webView = this.f38965B;
        if (webView != null) {
            webView.onResume();
        }
    }

    /* renamed from: a */
    public void m52143a(boolean z10) {
        getWindow().getDecorView().setSystemUiVisibility(z10 ? this.f38991X : FaqBaseWebActivity.f38505V);
        getWindow().setFlags(z10 ? 0 : 1024, 1024);
    }
}
