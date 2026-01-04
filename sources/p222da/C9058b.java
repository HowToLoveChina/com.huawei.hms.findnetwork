package p222da;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import ba.C1148b;
import ca.C1400c;
import com.huawei.android.hicloud.manager.PPSDownloadingAdsManager;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.p106db.bean.FrontApp;
import com.huawei.hicloud.notification.p106db.bean.H5Resource;
import com.huawei.openalliance.p169ad.inter.INativeAdLoader;
import com.huawei.openalliance.p169ad.inter.NativeAdLoader;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import fk.C9721b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: da.b */
/* loaded from: classes3.dex */
public class C9058b extends AbstractC12367d {

    /* renamed from: a */
    public String f45748a;

    /* renamed from: b */
    public String f45749b;

    /* renamed from: c */
    public Handler f45750c;

    /* renamed from: d */
    public INativeAdLoader f45751d;

    /* renamed from: e */
    public boolean f45752e;

    /* renamed from: da.b$a */
    public class a implements NativeAdListener {
        public a() {
        }

        /* renamed from: a */
        public final C1148b m57125a(List<INativeAd> list, String str) {
            String packageName;
            INativeAd next;
            AppInfo appInfo;
            Iterator<INativeAd> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    packageName = "";
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && (appInfo = next.getAppInfo()) != null) {
                    packageName = appInfo.getPackageName();
                    if (!TextUtils.isEmpty(packageName)) {
                        if (!PPSDownloadingAdsManager.m16469e().m16474f("frontApp", packageName)) {
                            break;
                        }
                        C11839m.m70689w("GetFrontAdsTask", "getFirstValidPpsAdResult isFilterAds, appPackageName = " + packageName);
                    } else {
                        continue;
                    }
                }
            }
            if (next != null) {
                return new C1148b(next, str, packageName);
            }
            return null;
        }

        /* renamed from: b */
        public final C1148b m57126b(H5Resource h5Resource, List<INativeAd> list) {
            AppInfo appInfo;
            if (h5Resource == null) {
                C11839m.m70689w("GetFrontAdsTask", "getMatchedAd resource is null");
                return null;
            }
            List<FrontApp> frontAppList = h5Resource.getFrontAppList();
            if (frontAppList == null || frontAppList.size() <= 0) {
                C11839m.m70689w("GetFrontAdsTask", "getMatchedAd frontApps is null or empty");
                return null;
            }
            if (list == null || list.size() <= 0) {
                C11839m.m70689w("GetFrontAdsTask", "getMatchedAd validPpsAds is null or empty");
                return null;
            }
            for (FrontApp frontApp : frontAppList) {
                if (frontApp == null) {
                    C11839m.m70687e("GetFrontAdsTask", "configApp is null.");
                } else {
                    String application = frontApp.getApplication();
                    if (TextUtils.isEmpty(application)) {
                        C11839m.m70687e("GetFrontAdsTask", "configPackageName is empty.");
                    } else {
                        if (application.equalsIgnoreCase("all")) {
                            return m57125a(list, HicloudH5ConfigManager.getInstance().getTextFromConfig(frontApp.getText()));
                        }
                        if (PPSDownloadingAdsManager.m16469e().m16474f("frontApp", application)) {
                            C11839m.m70689w("GetFrontAdsTask", "PPSDownloadingAdsManager isFilterAds, configPackageName = " + application);
                        } else {
                            for (INativeAd iNativeAd : list) {
                                if (iNativeAd != null && (appInfo = iNativeAd.getAppInfo()) != null) {
                                    String packageName = appInfo.getPackageName();
                                    if (application.equalsIgnoreCase(packageName)) {
                                        return new C1148b(iNativeAd, HicloudH5ConfigManager.getInstance().getTextFromConfig(frontApp.getText()), packageName);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            C11839m.m70689w("GetFrontAdsTask", "getMatchedAd , has not same package.");
            return null;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdFailed(int i10) {
            C11839m.m70687e("GetFrontAdsTask", "load Ad failed, code = " + i10);
            C9058b.this.m57122h(7016);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdsLoaded(Map<String, List<INativeAd>> map) {
            if (map == null) {
                C11839m.m70688i("GetFrontAdsTask", "on ads loaded error, ads is null");
                C9058b.this.m57122h(7016);
                return;
            }
            C11839m.m70688i("GetFrontAdsTask", "on ads loaded, mAdId size = " + map.size());
            for (Map.Entry<String, List<INativeAd>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && key.equals(C9058b.this.f45748a)) {
                    List<INativeAd> value = entry.getValue();
                    List<INativeAd> listM8062e = C1400c.m8057c().m8062e(value);
                    int size = listM8062e.size();
                    C11839m.m70688i("GetFrontAdsTask", "onAdsLoaded, ad list size = " + value.size() + ", valid ad list size = " + size);
                    H5Resource h5ResourceById = HicloudH5ConfigManager.getInstance().getH5ResourceById(C9058b.this.f45749b);
                    if (h5ResourceById != null) {
                        C11839m.m70688i("GetFrontAdsTask", "getMatchedAd, frontAppNumber = " + h5ResourceById.getFrontAppNumber() + " isPreAppUrl = " + C9058b.this.f45752e);
                        C1148b c1148bM57126b = m57126b(h5ResourceById, listM8062e);
                        if (c1148bM57126b != null) {
                            PPSDownloadingAdsManager.m16469e().m16472c("frontApp");
                            PPSDownloadingAdsManager.m16469e().m16471b("frontApp", c1148bM57126b.m7217c());
                            C9058b.this.m57124j(7017, c1148bM57126b);
                            return;
                        } else if (size >= 1) {
                            C9058b.this.m57122h(7018);
                            return;
                        } else {
                            C9058b.this.m57122h(7016);
                            return;
                        }
                    }
                    C11839m.m70687e("GetFrontAdsTask", "on ads loaded error, resource is null");
                }
            }
            C9058b.this.m57122h(7016);
        }
    }

    public C9058b(String str, String str2, Handler handler, boolean z10) {
        this.f45750c = handler;
        this.f45749b = str;
        this.f45748a = str2;
        this.f45752e = z10;
    }

    /* renamed from: h */
    public void m57122h(int i10) {
        m57124j(i10, null);
    }

    /* renamed from: k */
    private void m57123k(Context context) {
        C1400c.m8059f(context);
        NativeAdLoader nativeAdLoader = new NativeAdLoader(context, new String[]{this.f45748a}, 9, null);
        this.f45751d = nativeAdLoader;
        nativeAdLoader.setRequestOptions(AdSwitchManager.getInstance().getPpsRequestOptionsBuilder().build());
        this.f45751d.setListener(new a());
        this.f45751d.loadAds(C1400c.m8056b(), false);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        if (!C11829c.m70530L0()) {
            C11839m.m70688i("GetFrontAdsTask", "not support activity");
            m57122h(7016);
        } else {
            if (!C11829c.m70538P0()) {
                C11839m.m70687e("GetFrontAdsTask", "not support pps ads");
                m57122h(7013);
                return;
            }
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                m57123k(contextM1377a);
            } else {
                C11839m.m70687e("GetFrontAdsTask", "context is null");
                m57122h(7016);
            }
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.INIT_AD_LOADER;
    }

    /* renamed from: j */
    public final void m57124j(int i10, C1148b c1148b) {
        Handler handler = this.f45750c;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage(i10);
            messageObtainMessage.obj = c1148b;
            this.f45750c.sendMessage(messageObtainMessage);
        }
    }
}
