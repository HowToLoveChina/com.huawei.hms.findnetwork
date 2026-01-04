package p222da;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import ca.C1400c;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.H5Resource;
import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import com.huawei.openalliance.p169ad.inter.INativeAdLoader;
import com.huawei.openalliance.p169ad.inter.NativeAdLoader;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import gp.C10028c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: da.d */
/* loaded from: classes3.dex */
public class C9060d extends AbstractC12367d {

    /* renamed from: a */
    public final String f45758a;

    /* renamed from: b */
    public final String f45759b;

    /* renamed from: c */
    public final int f45760c;

    /* renamed from: d */
    public final int f45761d;

    /* renamed from: e */
    public final Handler f45762e;

    /* renamed from: f */
    public final int f45763f;

    /* renamed from: g */
    public INativeAdLoader f45764g;

    /* renamed from: h */
    public boolean f45765h = false;

    /* renamed from: da.d$a */
    public class a implements NativeAdListener {

        /* renamed from: a */
        public int f45766a;

        /* renamed from: b */
        public int f45767b;

        public a(int i10, int i11) {
            this.f45766a = i10;
            this.f45767b = i11;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdFailed(int i10) {
            C11839m.m70687e("InitAdLoaderTask", "load Ad failed, code = " + i10);
            StringBuilder sb2 = new StringBuilder(C9060d.this.f45763f);
            sb2.append(" : errorCode = " + i10);
            C11839m.m70688i("InitAdLoaderTask", "onAdFailed  launchNo = " + this.f45767b + " minLimit = " + this.f45766a);
            if (C9060d.this.f45765h) {
                C9060d.this.m57143q(0);
            }
            if (this.f45767b >= this.f45766a) {
                sb2.append(", result = 7015");
                NotificationReportUtil.reportPpsAdCheck("0009", sb2.toString());
                C9060d.this.m57136r(7015);
            } else {
                sb2.append(", result = 7014");
                NotificationReportUtil.reportPpsAdCheck("0009", sb2.toString());
                C9060d.this.m57137s(7014, 0);
            }
            C9060d.this.m57140n(i10);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdsLoaded(Map<String, List<INativeAd>> map) {
            if (map == null) {
                C11839m.m70688i("InitAdLoaderTask", "on ads loaded error, ads is null");
                C9060d.this.m57136r(7013);
                C9060d.this.m57141o(0);
                return;
            }
            C11839m.m70688i("InitAdLoaderTask", "on ads loaded, adId size = " + map.size());
            for (Map.Entry<String, List<INativeAd>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && key.equals(C9060d.this.f45758a)) {
                    List<INativeAd> value = entry.getValue();
                    List<INativeAd> listM8062e = C1400c.m8057c().m8062e(value);
                    C11839m.m70688i("InitAdLoaderTask", "onAdsLoaded, ad list size = " + value.size() + ", valid ad list size = " + listM8062e.size());
                    int size = listM8062e.size();
                    if (C9060d.this.f45765h) {
                        C9060d.this.m57143q(size);
                    }
                    StringBuilder sb2 = new StringBuilder(C9060d.this.f45763f);
                    sb2.append(" : onAdsLoaded, ad list size = " + value.size() + ", valid ad list size = " + listM8062e.size());
                    NotificationReportUtil.reportPpsAdCheck("0009", sb2.toString());
                    C9060d.this.m57141o(size);
                    C11839m.m70688i("InitAdLoaderTask", "onAdsLoaded  launchNo = " + this.f45767b + " validAdsNum = " + size + " minLimit = " + this.f45766a);
                    C9060d.this.m57139l(this.f45766a, this.f45767b, sb2, size);
                    return;
                }
            }
            C9060d.this.m57141o(0);
            NotificationReportUtil.reportPpsAdCheck("0009", C9060d.this.f45763f + " : no ads");
            C9060d.this.m57137s(7014, 0);
        }
    }

    public C9060d(String str, int i10, int i11, String str2, Handler handler, int i12, boolean z10) {
        this.f45759b = str;
        this.f45760c = i10;
        this.f45761d = i11;
        this.f45758a = str2;
        this.f45762e = handler;
        this.f45763f = i12;
        C11839m.m70688i("InitAdLoaderTask", "InitAdLoaderTask resourceId = [" + str + "], adId = [" + str2 + "], source = [" + i12 + "]");
    }

    /* renamed from: m */
    private boolean m57135m() throws InterruptedException {
        if (TextUtils.isEmpty(this.f45759b)) {
            C11839m.m70687e("InitAdLoaderTask", "noResourceInOmConfig error , resourceId is null");
            return true;
        }
        H5Resource h5ResourceById = HicloudH5ConfigManager.getInstance().getH5ResourceById(this.f45759b);
        if (this.f45763f == 1002) {
            HicloudH5ConfigManager.getInstance().checkResource(h5ResourceById);
        }
        if (h5ResourceById != null) {
            return false;
        }
        C11839m.m70687e("InitAdLoaderTask", "noResourceInOmConfig error , resource is null");
        return true;
    }

    /* renamed from: r */
    public void m57136r(int i10) {
        Handler handler = this.f45762e;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage(i10);
            messageObtainMessage.arg1 = this.f45763f;
            this.f45762e.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: s */
    public void m57137s(int i10, Object obj) {
        Handler handler = this.f45762e;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage(i10);
            messageObtainMessage.arg1 = this.f45763f;
            messageObtainMessage.obj = obj;
            this.f45762e.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: t */
    private void m57138t(Context context) {
        C1400c.m8059f(context);
        NativeAdLoader nativeAdLoader = new NativeAdLoader(context, new String[]{this.f45758a}, 9, null);
        this.f45764g = nativeAdLoader;
        nativeAdLoader.setRequestOptions(AdSwitchManager.getInstance().getPpsRequestOptionsBuilder().build());
        this.f45764g.setListener(new a(this.f45760c, this.f45761d));
        this.f45764g.loadAds(C1400c.m8056b(), false);
        m57142p();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        if (!C11829c.m70530L0()) {
            C11839m.m70688i("InitAdLoaderTask", "not support activity");
            m57136r(7013);
            return;
        }
        if (!C11829c.m70538P0()) {
            C11839m.m70687e("InitAdLoaderTask", "not support pps ads");
            if (this.f45761d >= this.f45760c) {
                m57136r(7015);
                return;
            } else {
                m57137s(7014, 0);
                return;
            }
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("InitAdLoaderTask", "context is null");
            m57136r(7013);
            return;
        }
        if (m57135m()) {
            C11839m.m70687e("InitAdLoaderTask", "no resource in om config");
            m57136r(7013);
            return;
        }
        if (this.f45763f != 1006) {
            C11839m.m70688i("InitAdLoaderTask", "no need preload");
            m57136r(7015);
            return;
        }
        if (!this.f45765h) {
            C11839m.m70688i("InitAdLoaderTask", "not use cache, resourceId: " + this.f45759b + ", adId: " + this.f45758a + ", source: " + this.f45763f);
            m57138t(contextM1377a);
            return;
        }
        long jM62364n0 = C10028c.m62182c0().m62364n0();
        int iM62210F0 = C10028c.m62182c0().m62210F0();
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11839m.m70688i("InitAdLoaderTask", "call ppsValidAdsNum = " + iM62210F0 + " lastPpsInfoTime = " + jM62364n0 + " currentTime = " + jCurrentTimeMillis);
        if (iM62210F0 > 0) {
            if (jCurrentTimeMillis - jM62364n0 > AiCoreSdkConstant.CHECK_SUPPORT_INTERVAL) {
                m57138t(contextM1377a);
                return;
            } else {
                m57139l(this.f45760c, this.f45761d, new StringBuilder(this.f45763f), iM62210F0);
                return;
            }
        }
        if (iM62210F0 != 0) {
            m57138t(contextM1377a);
        } else if (jCurrentTimeMillis - jM62364n0 > 600000) {
            m57138t(contextM1377a);
        } else {
            m57139l(this.f45760c, this.f45761d, new StringBuilder(this.f45763f), iM62210F0);
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.INIT_AD_LOADER;
    }

    /* renamed from: l */
    public void m57139l(int i10, int i11, StringBuilder sb2, int i12) {
        C11839m.m70688i("InitAdLoaderTask", "handleValidAdsLoaded  launchNo = " + i11 + " validAdsNum = " + i12 + " minLimit = " + i10);
        if (i11 + i12 < i10) {
            C11839m.m70687e("InitAdLoaderTask", "valid AdsNum less than quota");
            sb2.append(", result = 7014");
            NotificationReportUtil.reportPpsAdCheck("0009", sb2.toString());
            m57137s(7014, Integer.valueOf(i12));
            return;
        }
        C11839m.m70688i("InitAdLoaderTask", "valid AdsNum greater or equal than quota");
        sb2.append(", result = 7015");
        NotificationReportUtil.reportPpsAdCheck("0009", sb2.toString());
        m57136r(7015);
    }

    /* renamed from: n */
    public final void m57140n(int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ad_load_invoker", String.valueOf(this.f45763f));
        linkedHashMap.put("load_ad_error_code", String.valueOf(i10));
        C1400c.m8060g("PRE_LOAD_APP_NUM_FAIL", linkedHashMap);
    }

    /* renamed from: o */
    public final void m57141o(int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ad_load_invoker", String.valueOf(this.f45763f));
        linkedHashMap.put("load_ad_num", String.valueOf(i10));
        C1400c.m8060g("PRE_LOAD_APP_NUM_SUCCESS", linkedHashMap);
    }

    /* renamed from: p */
    public final void m57142p() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ad_load_invoker", String.valueOf(this.f45763f));
        C1400c.m8060g("PRE_LOAD_APP_NUM", linkedHashMap);
    }

    /* renamed from: q */
    public final void m57143q(int i10) {
        C10028c.m62182c0().m62313c3(System.currentTimeMillis());
        C10028c.m62182c0().m62412w3(i10);
    }
}
