package cn.com.miaozhen.mobile.tracking.api;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import cn.com.miaozhen.mobile.tracking.api.C1480d;
import cn.com.miaozhen.mobile.tracking.p055a.C1471h;
import cn.com.miaozhen.mobile.tracking.p056b.p058b.C1483b;
import cn.com.miaozhen.mobile.tracking.viewability.origin.InterfaceC1496a;
import cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack;
import ijiami_release01.NCall;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class MzCountly {
    private static final String EVENT_CLICK = "onClick";
    private static final String EVENT_EXPOSE = "onExpose";
    private static final String EVENT_TRACKADS = "onTrackExpose";
    private static final String EVENT_VIEWABILITY_EXPOSE = "onAdViewExpose";
    private static final String EVENT_VIEWABILITY_VIDEOEXPOSE = "onVideoExpose";
    private static MzCountly mInstance;
    private Context mContext;
    private C1478b mUrildBuilder;
    private C1471h sdk;
    private C1483b viewJavascriptInterface;
    private C1479c sendNormalMessageThread = null;
    private C1479c sendFailedMessageThread = null;
    private Timer normalTimer = null;
    private Timer failedTimer = null;
    private C1480d mzViewAbilityHandler = null;
    private volatile boolean sIsInitialized = false;
    private boolean isTrackLocation = false;
    private String injectjsname = "miaozhen-viewability-mobile.js";
    private InterfaceC1496a viewAbilityEventListener = new C1476b();

    /* renamed from: cn.com.miaozhen.mobile.tracking.api.MzCountly$a */
    public class C1475a extends TimerTask {
        public C1475a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            NCall.m64618IV(new Object[]{3, this});
        }
    }

    /* renamed from: cn.com.miaozhen.mobile.tracking.api.MzCountly$b */
    public class C1476b implements InterfaceC1496a {

        /* renamed from: cn.com.miaozhen.mobile.tracking.api.MzCountly$b$a */
        public class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f6313a;

            /* renamed from: b */
            final /* synthetic */ MzCallBack f6314b;

            /* renamed from: c */
            final /* synthetic */ C1480d.a f6315c;

            public a(String str, MzCallBack mzCallBack, C1480d.a aVar) {
                this.f6313a = str;
                this.f6314b = mzCallBack;
                this.f6315c = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                NCall.m64618IV(new Object[]{4, this});
            }
        }

        public C1476b() {
        }

        @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.InterfaceC1496a
        /* renamed from: a */
        public void mo8367a(String str, MzCallBack mzCallBack, C1480d.a aVar) {
            NCall.m64618IV(new Object[]{5, this, str, mzCallBack, aVar});
        }
    }

    static {
        NCall.m64618IV(new Object[]{25});
    }

    public static MzCountly sharedInstance() {
        return (MzCountly) NCall.m64616IL(new Object[]{26});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFailedRun() {
        NCall.m64618IV(new Object[]{27, this});
    }

    private void startTask() {
        NCall.m64618IV(new Object[]{28, this});
    }

    private void triggerEvent(String str, String str2, View view, int i10, int i11, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{29, this, str, str2, view, Integer.valueOf(i10), Integer.valueOf(i11), mzCallBack});
    }

    private void triggerVideoEvent(String str, String str2, View view, int i10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{31, this, str, str2, view, Integer.valueOf(i10), mzCallBack});
    }

    public void SetAddJavascriptMonitor(Context context, WebView webView) {
        NCall.m64618IV(new Object[]{32, this, context, webView});
    }

    public void disPlayImp(String str, View view, int i10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{33, this, str, view, Integer.valueOf(i10), mzCallBack});
    }

    public String getMsaOaid() {
        return (String) NCall.m64616IL(new Object[]{34, this});
    }

    public void init(Context context, String str) {
        NCall.m64618IV(new Object[]{35, this, context, str});
    }

    public void onClick(String str, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{36, this, str, mzCallBack});
    }

    public void onExpose(String str, View view, int i10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{37, this, str, view, Integer.valueOf(i10), mzCallBack});
    }

    public void onTrackExpose(String str, View view, int i10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{39, this, str, view, Integer.valueOf(i10), mzCallBack});
    }

    public void onVideoExpose(String str, View view, int i10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{40, this, str, view, Integer.valueOf(i10), mzCallBack});
    }

    public void setLogState(boolean z10) {
        NCall.m64618IV(new Object[]{41, this, Boolean.valueOf(z10)});
    }

    public void stop(String str) {
        NCall.m64618IV(new Object[]{42, this, str});
    }

    public void terminateSDK() {
        NCall.m64618IV(new Object[]{43, this});
    }

    public void videoImp(String str, View view, int i10, int i11, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{44, this, str, view, Integer.valueOf(i10), Integer.valueOf(i11), mzCallBack});
    }

    public void webViewImp(String str, View view, int i10, boolean z10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{45, this, str, view, Integer.valueOf(i10), Boolean.valueOf(z10), mzCallBack});
    }

    public void webViewVideoImp(String str, View view, int i10, int i11, boolean z10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{46, this, str, view, Integer.valueOf(i10), Integer.valueOf(i11), Boolean.valueOf(z10), mzCallBack});
    }

    private void triggerEvent(String str, String str2, View view, int i10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{30, this, str, str2, view, Integer.valueOf(i10), mzCallBack});
    }

    public void onExpose(String str, View view, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{38, this, str, view, mzCallBack});
    }
}
