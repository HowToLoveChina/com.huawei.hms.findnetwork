package p651t8;

import android.text.TextUtils;
import com.huawei.android.hicloud.agd.ads.AdInfo;
import com.huawei.android.hicloud.cloudspace.campaign.bean.H5DownloadApp;
import com.huawei.android.hicloud.task.simple.C3019c1;
import com.huawei.android.hicloud.task.simple.C3047j1;
import com.huawei.cloud.pay.model.AdAppInfo;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import je.C10776a;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p616rk.C12515a;
import p672u8.C13135e;

/* renamed from: t8.a */
/* loaded from: classes2.dex */
public class C12993a {

    /* renamed from: a */
    public static final HashMap<String, List<HiCloudNativeAd>> f59147a = new HashMap<>();

    /* renamed from: b */
    public static final HashMap<String, List<HiCloudNativeAd>> f59148b = new HashMap<>();

    /* renamed from: c */
    public static final List<HiCloudNativeAd> f59149c = new ArrayList();

    /* renamed from: a */
    public static void m77957a(HiCloudNativeAd hiCloudNativeAd) {
        f59149c.add(hiCloudNativeAd);
    }

    /* renamed from: b */
    public static void m77958b() {
        f59147a.clear();
        f59148b.clear();
        f59149c.clear();
    }

    /* renamed from: c */
    public static List<HiCloudNativeAd> m77959c(String str) throws InterruptedException {
        List<HiCloudNativeAd> list;
        C11839m.m70688i("CampaignAdLoad", "getAGD");
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CampaignAdLoad", "getAGD adSlotId isEmpty");
            return arrayList;
        }
        C3047j1.a aVar = new C3047j1.a();
        C12515a.m75110o().m75175e(new C3047j1(null, str, aVar, 10, true), false);
        try {
            C11839m.m70688i("CampaignAdLoad", "getAGD:" + aVar.m18347b().await(60000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e10) {
            C11839m.m70687e("CampaignAdLoad", "getAGD exception:" + e10.getMessage());
        }
        Map<String, List<HiCloudNativeAd>> mapM18348c = aVar.m18348c();
        if (mapM18348c != null && (list = mapM18348c.get(str)) != null) {
            arrayList.addAll(list);
        }
        C11839m.m70686d("CampaignAdLoad", "getAGD result:" + arrayList);
        return arrayList;
    }

    /* renamed from: d */
    public static HashMap<String, List<HiCloudNativeAd>> m77960d() {
        HashMap<String, List<HiCloudNativeAd>> map = new HashMap<>();
        for (Map.Entry<String, List<HiCloudNativeAd>> entry : f59148b.entrySet()) {
            String key = entry.getKey();
            List<HiCloudNativeAd> value = entry.getValue();
            if (key != null && value != null) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < value.size(); i10++) {
                    if (!m77966j(value.get(i10))) {
                        arrayList.add(value.get(i10));
                    }
                }
                map.put(key, arrayList);
            }
        }
        return map;
    }

    /* renamed from: e */
    public static HiCloudNativeAd m77961e(String str, String str2, String str3) {
        C11839m.m70686d("CampaignAdLoad", "getCacheDownloadApp questId: " + str3);
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("CampaignAdLoad", "getCacheDownloadApp: appSource is empty");
            return null;
        }
        String strM77998l = C12996d.m77971n().m77998l(str3);
        if (TextUtils.isEmpty(strM77998l)) {
            C11839m.m70688i("CampaignAdLoad", "getCacheDownloadApp: cache is empty");
            return null;
        }
        H5DownloadApp h5DownloadApp = (H5DownloadApp) C13135e.m79002b(strM77998l, H5DownloadApp.class);
        if (h5DownloadApp == null) {
            C11839m.m70688i("CampaignAdLoad", "getCacheDownloadApp: downloadApp is empty");
            return null;
        }
        if (!str.equals(h5DownloadApp.getAppSource())) {
            C11839m.m70688i("CampaignAdLoad", "getCacheDownloadApp: appSource not equal");
            return null;
        }
        if (HiCloudNativeAd.CHANNEL_PPS.equals(str)) {
            Object objM77976x = C12996d.m77976x(str3);
            INativeAd iNativeAd = objM77976x instanceof INativeAd ? (INativeAd) objM77976x : null;
            if (iNativeAd == null) {
                C11839m.m70688i("CampaignAdLoad", "getCacheDownloadApp: pps data null");
                return null;
            }
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(iNativeAd);
            map.put(str2, arrayList);
            C12996d.m77971n().m77982F(map);
            return C10776a.m65607c(iNativeAd, HiCloudNativeAd.CHANNEL_PPS);
        }
        if (!HiCloudNativeAd.CHANNEL_AGD.equals(str)) {
            C11839m.m70688i("CampaignAdLoad", "getCacheDownloadApp: appSource not support");
            return null;
        }
        AdInfo agd = h5DownloadApp.getAgd();
        if (agd == null) {
            C11839m.m70688i("CampaignAdLoad", "getCacheDownloadApp: agd data null");
            return null;
        }
        HashMap map2 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(agd);
        map2.put(str2, arrayList2);
        C12996d.m77971n().m77980D(map2);
        return C3047j1.m18340e(agd);
    }

    /* renamed from: f */
    public static List<HiCloudNativeAd> m77962f(String str, String str2, int i10) {
        HiCloudNativeAd hiCloudNativeAdM77964h;
        HiCloudNativeAd hiCloudNativeAdM77964h2;
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        if (HiCloudNativeAd.CHANNEL_PPS.equals(str)) {
            HashMap<String, List<HiCloudNativeAd>> map = f59147a;
            List<HiCloudNativeAd> list = map.get(str2);
            if (list != null && list.size() > 0 && (hiCloudNativeAdM77964h2 = m77964h(list)) != null && hiCloudNativeAdM77964h2.getAppInfo() != null) {
                C11839m.m70688i("CampaignAdLoad", "getPPS from cache");
                return list;
            }
            List<HiCloudNativeAd> listM77963g = m77963g(str2, i10);
            List<HiCloudNativeAd> list2 = map.get(str2);
            if (list2 != null) {
                listM77963g.addAll(list2);
            }
            map.put(str2, listM77963g);
            return listM77963g;
        }
        if (!HiCloudNativeAd.CHANNEL_AGD.equals(str)) {
            return new ArrayList();
        }
        HashMap<String, List<HiCloudNativeAd>> map2 = f59148b;
        List<HiCloudNativeAd> list3 = map2.get(str2);
        if (list3 != null && list3.size() > 0 && (hiCloudNativeAdM77964h = m77964h(list3)) != null && hiCloudNativeAdM77964h.getAppInfo() != null) {
            C11839m.m70688i("CampaignAdLoad", "getAGD from cache");
            return list3;
        }
        List<HiCloudNativeAd> listM77959c = m77959c(str2);
        List<HiCloudNativeAd> list4 = map2.get(str2);
        if (list4 != null) {
            listM77959c.addAll(list4);
        }
        map2.put(str2, listM77959c);
        return listM77959c;
    }

    /* renamed from: g */
    public static List<HiCloudNativeAd> m77963g(String str, int i10) throws InterruptedException {
        List<HiCloudNativeAd> list;
        C11839m.m70688i("CampaignAdLoad", "getPPS");
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CampaignAdLoad", "getPPS adIds isEmpty");
            return arrayList;
        }
        C3019c1 c3019c1 = new C3019c1(false, null, new String[]{str}, i10, null, true, true);
        C12515a.m75110o().m75175e(c3019c1, false);
        try {
            C11839m.m70688i("CampaignAdLoad", "getPPS:" + c3019c1.m18227q().await(60000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e10) {
            C11839m.m70687e("CampaignAdLoad", "getPPS exception:" + e10.getMessage());
        }
        Map<String, List<HiCloudNativeAd>> mapM18229s = c3019c1.m18229s();
        if (mapM18229s != null && (list = mapM18229s.get(str)) != null) {
            arrayList.addAll(list);
        }
        C11839m.m70686d("CampaignAdLoad", "getPPS result:" + arrayList);
        return arrayList;
    }

    /* renamed from: h */
    public static HiCloudNativeAd m77964h(List<HiCloudNativeAd> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                HiCloudNativeAd hiCloudNativeAd = list.get(i10);
                if (hiCloudNativeAd != null && !m77966j(hiCloudNativeAd) && !m77965i(hiCloudNativeAd)) {
                    arrayList.add(hiCloudNativeAd);
                }
            }
            int size2 = arrayList.size();
            if (size2 > 0) {
                return (HiCloudNativeAd) arrayList.get(new SecureRandom().nextInt(size2));
            }
            C11839m.m70688i("CampaignAdLoad", "cacheAdList is empty");
        }
        return null;
    }

    /* renamed from: i */
    public static boolean m77965i(HiCloudNativeAd hiCloudNativeAd) {
        AdAppInfo appInfo = hiCloudNativeAd.getAppInfo();
        if (appInfo == null) {
            C11839m.m70689w("CampaignAdLoad", "appInfo null");
            return false;
        }
        String packageName = appInfo.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            C11839m.m70689w("CampaignAdLoad", "packageName is empty");
            return false;
        }
        if (!C0209d.m1187L0(C0213f.m1377a(), packageName)) {
            return false;
        }
        C11839m.m70686d("CampaignAdLoad", "App installed:" + packageName);
        return true;
    }

    /* renamed from: j */
    public static boolean m77966j(HiCloudNativeAd hiCloudNativeAd) {
        String packageName;
        AdAppInfo appInfo = hiCloudNativeAd.getAppInfo();
        if (appInfo != null) {
            packageName = appInfo.getPackageName();
            C11839m.m70686d("CampaignAdLoad", "app:" + packageName);
        } else {
            packageName = null;
        }
        int i10 = 0;
        while (true) {
            List<HiCloudNativeAd> list = f59149c;
            if (i10 >= list.size()) {
                C11839m.m70686d("CampaignAdLoad", "not contain");
                return false;
            }
            AdAppInfo appInfo2 = list.get(i10).getAppInfo();
            String packageName2 = appInfo2 != null ? appInfo2.getPackageName() : null;
            if (packageName2 != null && packageName2.equals(packageName)) {
                C11839m.m70686d("CampaignAdLoad", "contain app:" + packageName);
                return true;
            }
            i10++;
        }
    }
}
