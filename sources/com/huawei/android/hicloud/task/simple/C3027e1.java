package com.huawei.android.hicloud.task.simple;

import android.text.TextUtils;
import ca.C1403f;
import com.google.gson.Gson;
import com.huawei.android.hicloud.agd.ads.AdInfo;
import com.huawei.android.hicloud.agd.ads.AdSlot;
import com.huawei.cloud.pay.model.AdAppInfo;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.cloud.pay.model.HicloudAdRespone;
import com.huawei.cloud.pay.model.QueryAdListRsp;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.openalliance.p169ad.constant.UrlConstant;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import je.C10776a;
import p015ak.C0209d;
import p260ek.C9499a;
import p292fn.C9733f;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.task.simple.e1 */
/* loaded from: classes3.dex */
public class C3027e1 extends AbstractC12367d implements Consumer<Map<String, List<HiCloudNativeAd>>> {

    /* renamed from: a */
    public final String f13231a;

    /* renamed from: b */
    public String f13232b = "";

    /* renamed from: c */
    public CountDownLatch f13233c = new CountDownLatch(1);

    /* renamed from: d */
    public boolean f13234d;

    /* renamed from: e */
    public int f13235e;

    /* renamed from: f */
    public String f13236f;

    public C3027e1(String str, int i10, String str2) {
        this.f13231a = str;
        this.f13235e = i10;
        this.f13236f = str2;
    }

    /* renamed from: h */
    public static /* synthetic */ void m18299h(boolean z10, String str, boolean z11, String str2, boolean z12, String str3, HiCloudNativeAd hiCloudNativeAd) {
        AdAppInfo appInfo = hiCloudNativeAd.getAppInfo();
        String packageName = appInfo.getPackageName();
        if (z10) {
            appInfo.setAppDetailUrl(str + "?mediaPackageName=com.huawei.hidisk");
        }
        if (z11) {
            appInfo.setPrivacyLink(str2 + "?packageName=" + packageName + "&mediaPackageName=com.huawei.hidisk");
        }
        if (z12) {
            appInfo.setPermissionUrl(str3 + "?packageName=" + packageName + "&mediaPackageName=com.huawei.hidisk");
        }
    }

    /* renamed from: k */
    public static void m18300k(List<HiCloudNativeAd> list) {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        String agAdItemUrls = hiCloudSysParamMapM60758q == null ? "" : hiCloudSysParamMapM60758q.getAgAdItemUrls();
        C11839m.m70688i("LoadAgAdsTask", "agAdItemUrls：" + agAdItemUrls);
        if (TextUtils.isEmpty(agAdItemUrls)) {
            C11839m.m70688i("LoadAgAdsTask", "agAdItemUrls is Empty");
            return;
        }
        final String strM59436d = C9499a.m59436d(agAdItemUrls, "appsUrl");
        final String strM59436d2 = C9499a.m59436d(agAdItemUrls, UrlConstant.PRIVACY_URL);
        final String strM59436d3 = C9499a.m59436d(agAdItemUrls, "permissionUrl");
        final boolean z10 = !TextUtils.isEmpty(strM59436d);
        final boolean z11 = !TextUtils.isEmpty(strM59436d2);
        final boolean z12 = !TextUtils.isEmpty(strM59436d3);
        list.forEach(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.d1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C3027e1.m18299h(z10, strM59436d, z11, strM59436d2, z12, strM59436d3, (HiCloudNativeAd) obj);
            }
        });
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("LoadAgAdsTask", "loadAdsBySrc LoadAgAdsTask request size: " + this.f13235e);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07054"), "07054", C13452e.m80781L().m80971t0());
        try {
            try {
                ArrayList arrayList = new ArrayList();
                boolean z10 = true;
                Integer hasNextPage = 1;
                int i10 = 0;
                while (hasNextPage != null && hasNextPage.intValue() == 1) {
                    int size = arrayList.size();
                    int i11 = this.f13235e;
                    if (size < i11 && i10 < 5) {
                        i10++;
                        QueryAdListRsp queryAdListRspM61659a0 = C9948a.m61631C().m61659a0(new AdSlot(Integer.valueOf(i11), Integer.valueOf(i10), this.f13231a));
                        C11839m.m70688i("LoadAgAdsTask", "loadAdsBySrc LoadAgAdsTask rsp code:" + queryAdListRspM61659a0.getAdRetCode() + " desc:" + queryAdListRspM61659a0.getResultDesc());
                        if (queryAdListRspM61659a0.getResultCode() == 0 && queryAdListRspM61659a0.getAdRetCode().intValue() == 0) {
                            arrayList.addAll(queryAdListRspM61659a0.getAdlist());
                            hasNextPage = queryAdListRspM61659a0.getHasNextPage();
                        }
                        c11060cM66626a.m66665u(String.valueOf(queryAdListRspM61659a0.getAdRetCode()));
                        c11060cM66626a.m66635A(queryAdListRspM61659a0.getResultDesc());
                        C10776a.m65610f(c11060cM66626a, this.f13236f, this.f13235e);
                        z10 = false;
                        break;
                    }
                    break;
                }
                if (!C0209d.m1205R0(arrayList)) {
                    m18302e(c11060cM66626a, arrayList, this.f13235e);
                } else if (z10) {
                    C10776a.m65611g(c11060cM66626a, this.f13235e, 0, 0, this.f13236f);
                }
            } catch (C9721b e10) {
                String strM60660d = e10.m60660d();
                String message = e10.getMessage();
                C11839m.m70687e("LoadAgAdsTask", "loadAdsBySrc queryAdList errorCode:" + strM60660d + " exception:" + message);
                c11060cM66626a.m66665u(strM60660d);
                c11060cM66626a.m66635A(message);
                C10776a.m65610f(c11060cM66626a, this.f13236f, this.f13235e);
            }
            m18305j();
        } catch (Throwable th2) {
            m18305j();
            throw th2;
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void accept(Map<String, List<HiCloudNativeAd>> map) {
        C11839m.m70688i("LoadAgAdsTask", "loadAdsBySrc ag accept");
        HicloudAdRespone hicloudAdRespone = new HicloudAdRespone();
        hicloudAdRespone.setResultCode(0);
        hicloudAdRespone.setResponseMessage(new Gson().toJson(map));
        this.f13232b = new Gson().toJson(hicloudAdRespone);
    }

    /* renamed from: e */
    public final void m18302e(C11060c c11060c, List<AdInfo> list, int i10) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        HashMap map = new HashMap();
        map.put(this.f13231a, arrayList);
        if (HiCloudNativeAd.CHANNEL_AGD.equals(this.f13236f)) {
            C1403f.m8066n().m8075I(map);
        } else if (HiCloudNativeAd.CHANNEL_AGG.equals(this.f13236f)) {
            C1403f.m8066n().m8076J(map);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            HiCloudNativeAd hiCloudNativeAdM65606b = C10776a.m65606b((AdInfo) it2.next(), this.f13236f);
            if (arrayList2.size() >= this.f13235e) {
                break;
            } else {
                arrayList2.add(hiCloudNativeAdM65606b);
            }
        }
        m18300k(arrayList2);
        C11839m.m70688i("LoadAgAdsTask", "loadAdsBySrc ads: " + this.f13236f + " size: " + arrayList2.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(this.f13231a, arrayList2);
        accept(linkedHashMap);
        c11060c.m66665u(String.valueOf(0));
        c11060c.m66635A("");
        C10776a.m65611g(c11060c, i10, list.size(), arrayList2.size(), this.f13236f);
    }

    /* renamed from: f */
    public CountDownLatch m18303f() {
        return this.f13233c;
    }

    /* renamed from: g */
    public String m18304g() {
        return this.f13232b;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.LOAD_AD;
    }

    /* renamed from: j */
    public final void m18305j() {
        C11839m.m70688i("LoadAgAdsTask", "loadAdsBySrc LoadAgAdsTask finish.");
        this.f13233c.countDown();
        this.f13234d = true;
    }
}
