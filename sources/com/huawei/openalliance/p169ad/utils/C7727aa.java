package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.ads.uiengine.InterfaceC5110e;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7084e;
import com.huawei.openalliance.p169ad.C7563ox;
import com.huawei.openalliance.p169ad.C7580pn;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.utils.aa */
/* loaded from: classes2.dex */
public class C7727aa {
    /* renamed from: a */
    public static void m47422a(final Context context, final Map<String, List<IRewardAd>> map) {
        if (context == null || C7765bl.m47802a(map)) {
            return;
        }
        AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aa.1
            @Override // java.lang.Runnable
            public void run() {
                List listM47428e = C7727aa.m47428e(context, map);
                if (AbstractC7760bg.m47767a(listM47428e)) {
                    AbstractC7185ho.m43820b("EngineCacheUtil", "3.0 null");
                    return;
                }
                InterfaceC5110e interfaceC5110eM42838b = C7084e.m42838b();
                if (!C7780c.m47861a() || interfaceC5110eM42838b == null) {
                    AbstractC7185ho.m43823c("EngineCacheUtil", "not support engine down or engineUtil is null");
                }
                AbstractC7185ho.m43820b("EngineCacheUtil", "trigger ui engine download.");
                try {
                    interfaceC5110eM42838b.mo30524a(AbstractC7758be.m47742b(listM47428e), (Bundle) null);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("EngineCacheUtil", "trigger engine download ex: %s", th2.getClass().getSimpleName());
                }
            }
        });
    }

    /* renamed from: b */
    public static void m47424b(final Context context, final Map<String, List<InterfaceC7299b>> map) {
        if (C7765bl.m47802a(map) || context == null) {
            AbstractC7185ho.m43820b("EngineCacheUtil", "adsMap or context is empty.");
        } else {
            AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aa.2
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    if (C7727aa.m47425b()) {
                        List listM47429f = C7727aa.m47429f(context, map);
                        if (!AbstractC7760bg.m47767a(listM47429f)) {
                            try {
                                C7084e.m42838b().mo30524a(AbstractC7758be.m47742b(listM47429f), (Bundle) null);
                                return;
                            } catch (RemoteException unused) {
                                AbstractC7185ho.m43823c("EngineCacheUtil", "triggerEngineDown RemoteException.");
                                return;
                            } catch (Throwable th2) {
                                AbstractC7185ho.m43824c("EngineCacheUtil", "triggerEngineDown err: %s.", th2.getClass().getSimpleName());
                                return;
                            }
                        }
                        str = "template ads is empty.";
                    } else {
                        str = "uiengine is not loaded or can't support download.";
                    }
                    AbstractC7185ho.m43820b("EngineCacheUtil", str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static List<AdContentData> m47428e(Context context, Map<String, List<IRewardAd>> map) {
        if (context == null || C7765bl.m47802a(map)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<IRewardAd>> entry : map.entrySet()) {
            if (entry != null && !AbstractC7760bg.m47767a(entry.getValue())) {
                for (IRewardAd iRewardAd : entry.getValue()) {
                    if (iRewardAd instanceof C7305h) {
                        C7305h c7305h = (C7305h) iRewardAd;
                        if (c7305h.m44957al() != null && c7305h.m44957al().intValue() == 3) {
                            AbstractC7185ho.m43821b("EngineCacheUtil", "add v3 rewardAd: %s", c7305h.getContentId());
                            arrayList.add(AdContentData.m39271a(context, C7580pn.m46793a(c7305h)));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static List<AdContentData> m47429f(Context context, Map<String, List<InterfaceC7299b>> map) {
        if (C7765bl.m47802a(map) || context == null) {
            AbstractC7185ho.m43820b("EngineCacheUtil", "getTptAds, adsMap or context is empty.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (List<InterfaceC7299b> list : map.values()) {
            if (!AbstractC7760bg.m47767a(list)) {
                for (InterfaceC7299b interfaceC7299b : list) {
                    if ((interfaceC7299b instanceof C7301d) && interfaceC7299b.mo44680d_()) {
                        arrayList.add(AdContentData.m39271a(context, C7563ox.m46653a((C7301d) interfaceC7299b)));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m47425b() {
        return C7780c.m47861a() && C7084e.m42838b() != null;
    }
}
