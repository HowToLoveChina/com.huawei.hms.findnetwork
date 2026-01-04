package p222da;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import ca.C1400c;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.p106db.bean.H5Resource;
import com.huawei.openalliance.p169ad.inter.INativeAdLoader;
import com.huawei.openalliance.p169ad.inter.NativeAdLoader;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: da.a */
/* loaded from: classes3.dex */
public class C9057a extends AbstractC12367d {

    /* renamed from: a */
    public String f45740a;

    /* renamed from: b */
    public String f45741b;

    /* renamed from: c */
    public int f45742c;

    /* renamed from: d */
    public Handler f45743d;

    /* renamed from: e */
    public int f45744e;

    /* renamed from: f */
    public INativeAdLoader f45745f;

    /* renamed from: da.a$a */
    public class a implements NativeAdListener {

        /* renamed from: a */
        public int f45746a;

        public a(int i10) {
            this.f45746a = i10;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdFailed(int i10) {
            C11839m.m70687e("GetAdsForGuideTask", "load Ad failed, code = " + i10);
            C9057a.this.m57115h(7013, 0);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdsLoaded(Map<String, List<INativeAd>> map) {
            if (map == null) {
                C11839m.m70688i("GetAdsForGuideTask", "on ads loaded error, ads is null");
                C9057a.this.m57115h(7013, 0);
                return;
            }
            C11839m.m70688i("GetAdsForGuideTask", "on ads loaded, adId size = " + map.size());
            for (Map.Entry<String, List<INativeAd>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && key.equals(C9057a.this.f45740a)) {
                    List<INativeAd> value = entry.getValue();
                    List<INativeAd> listM8062e = C1400c.m8057c().m8062e(value);
                    C11839m.m70688i("GetAdsForGuideTask", "onAdsLoaded, ad list size = " + value.size() + ", valid ad list size = " + listM8062e.size());
                    int size = listM8062e.size();
                    if (size >= this.f45746a) {
                        C11839m.m70687e("GetAdsForGuideTask", "valid AdsNum validAdsNum >= 1");
                        C9057a.this.m57114g(7016);
                        return;
                    } else {
                        C11839m.m70687e("GetAdsForGuideTask", "valid AdsNum validAdsNum < 1");
                        C9057a.this.m57115h(7017, Integer.valueOf(size));
                        return;
                    }
                }
            }
            C9057a.this.m57115h(7017, 0);
        }
    }

    public C9057a(String str, int i10, String str2, Handler handler, int i11) {
        this.f45741b = str;
        this.f45742c = i10;
        this.f45740a = str2;
        this.f45743d = handler;
        this.f45744e = i11;
        C11839m.m70688i("GetAdsForGuideTask", "GetAdsForGuideTask resourceId = [" + str + "], adId = [" + str2 + "], source = [" + i11 + "]");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        if (!C11829c.m70530L0()) {
            C11839m.m70688i("GetAdsForGuideTask", "not support activity");
            m57114g(7013);
            return;
        }
        if (!C11829c.m70538P0()) {
            C11839m.m70687e("GetAdsForGuideTask", "not support pps ads");
            m57115h(7013, 0);
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("GetAdsForGuideTask", "context is null");
            m57114g(7013);
        } else if (!m57113f()) {
            m57116j(contextM1377a);
        } else {
            C11839m.m70687e("GetAdsForGuideTask", "no resource in om config");
            m57114g(7013);
        }
    }

    /* renamed from: f */
    public final boolean m57113f() throws InterruptedException {
        if (TextUtils.isEmpty(this.f45741b)) {
            C11839m.m70687e("GetAdsForGuideTask", "noResourceInOmConfig error , resourceId is null");
            return true;
        }
        H5Resource h5ResourceById = HicloudH5ConfigManager.getInstance().getH5ResourceById(this.f45741b);
        if (this.f45744e == 1002) {
            HicloudH5ConfigManager.getInstance().checkResource(h5ResourceById);
        }
        if (h5ResourceById != null) {
            return false;
        }
        C11839m.m70687e("GetAdsForGuideTask", "noResourceInOmConfig error , resource is null");
        return true;
    }

    /* renamed from: g */
    public final void m57114g(int i10) {
        Handler handler = this.f45743d;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage(i10);
            messageObtainMessage.arg1 = this.f45744e;
            this.f45743d.sendMessage(messageObtainMessage);
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.INIT_AD_LOADER;
    }

    /* renamed from: h */
    public final void m57115h(int i10, Object obj) {
        Handler handler = this.f45743d;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage(i10);
            messageObtainMessage.arg1 = this.f45744e;
            messageObtainMessage.obj = obj;
            this.f45743d.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: j */
    public final void m57116j(Context context) {
        C1400c.m8059f(context);
        NativeAdLoader nativeAdLoader = new NativeAdLoader(context, new String[]{this.f45740a}, 9, null);
        this.f45745f = nativeAdLoader;
        nativeAdLoader.setRequestOptions(AdSwitchManager.getInstance().getPpsRequestOptionsBuilder().build());
        this.f45745f.setListener(new a(this.f45742c));
        this.f45745f.loadAds(C1400c.m8056b(), false);
    }
}
