package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7123fg;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import com.huawei.openalliance.p169ad.constant.ConfigMapKeys;
import com.huawei.openalliance.p169ad.constant.SpDefaultValues;
import com.huawei.openalliance.p169ad.constant.TradeMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p216d4.C8998a;
import p216d4.InterfaceC9004d;
import p216d4.InterfaceC9006e;
import p247e4.C9407c;

/* renamed from: com.huawei.openalliance.ad.utils.cj */
/* loaded from: classes2.dex */
public class C7790cj {

    /* renamed from: a */
    private static long f36011a = 0;

    /* renamed from: b */
    private static boolean f36012b = false;

    /* renamed from: com.huawei.openalliance.ad.utils.cj$a */
    public static class a implements InterfaceC9004d {

        /* renamed from: a */
        private final Context f36014a;

        public a(Context context) {
            this.f36014a = context;
        }

        @Override // p216d4.InterfaceC9004d
        public void eventProcess(C9407c c9407c) {
            new C6922c(this.f36014a).mo39086a(c9407c);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.cj$b */
    public static class b implements InterfaceC9006e {

        /* renamed from: a */
        private final Context f36015a;

        public b(Context context) {
            this.f36015a = context;
        }

        public String aes128Decrypt(String str) {
            return AbstractC7827f.m48400b(str, AbstractC7796cp.m48089b(this.f36015a));
        }

        public String aes128Encrypt(String str) {
            return AbstractC7827f.m48394a(str, AbstractC7796cp.m48089b(this.f36015a));
        }

        public String[] getAllowCachedTradeModeList(String str) {
            return C7790cj.m48053c(this.f36015a);
        }

        @Override // p216d4.InterfaceC9006e
        public String getConfig(String str) {
            return null;
        }

        public Long getCostEndTime(int i10) {
            return 0L;
        }

        public List<String> getDailyIntentId(int i10, int i11) {
            return null;
        }

        public byte[] getDeviceAiParamKey() {
            return new byte[0];
        }

        public int getMediaType(String str) {
            return 0;
        }

        public Map<String, Double> getUserCost(int i10) {
            return null;
        }

        @Override // p216d4.InterfaceC9006e
        public boolean isInHmsProcess() {
            return false;
        }

        @Override // p216d4.InterfaceC9006e
        public String[] getAllowCachedTradeModeList(String str, String str2) {
            return C7790cj.m48050a(this.f36015a, str2);
        }
    }

    /* renamed from: b */
    public static int m48051b(String str) {
        int iM48145a;
        if (!AbstractC7806cz.m48165b(str) && (iM48145a = AbstractC7806cz.m48145a(str, 3)) > 0) {
            return iM48145a;
        }
        return 3;
    }

    /* renamed from: c */
    public static String[] m48053c(Context context) {
        List<String> listMo43079m = C7124fh.m43316b(context).mo43079m();
        return AbstractC7760bg.m47767a(listMo43079m) ? new String[0] : (String[]) listMo43079m.toArray(new String[listMo43079m.size()]);
    }

    /* renamed from: a */
    public static List<String> m48043a(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return TradeMode.DEFAULT_VALUE;
        }
        String[] strArrSplit = str.split(",");
        if (AbstractC7760bg.m47769a(strArrSplit)) {
            return TradeMode.DEFAULT_VALUE;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            if (TradeMode.OPTIONAL_VALUE.contains(str2)) {
                arrayList.add(str2);
            }
        }
        return AbstractC7760bg.m47767a(arrayList) ? TradeMode.DEFAULT_VALUE : arrayList;
    }

    /* renamed from: b */
    public static boolean m48052b(final Context context) {
        if (AbstractC7741ao.m47566c() - f36011a > AiCoreSdkConstant.CHECK_SUPPORT_INTERVAL) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.cj.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7185ho.m43820b("RecommendEngineUtil", "do check ds version");
                    int iM48145a = AbstractC7806cz.m48145a(C7124fh.m43316b(context).mo43070b(ConfigMapKeys.SUPPORT_DS_ENGINE_VER, String.valueOf(SpDefaultValues.DEFAULT_DS_VER)), SpDefaultValues.DEFAULT_DS_VER);
                    int iM48436f = C7830i.m48436f(context, AiCoreSdkConstant.DECISION_PKG_NAME);
                    AbstractC7185ho.m43818a("RecommendEngineUtil", "check ds, local ver: %s, cfg ver: %s", Integer.valueOf(iM48436f), Integer.valueOf(iM48145a));
                    boolean unused = C7790cj.f36012b = iM48436f >= iM48145a;
                    long unused2 = C7790cj.f36011a = AbstractC7741ao.m47566c();
                }
            });
        }
        return f36012b;
    }

    /* renamed from: a */
    public static void m48044a(Context context) {
        C8998a.m56862f(new b(context));
        C8998a.m56861e(new a(context));
    }

    /* renamed from: a */
    public static void m48045a(Context context, AdContentRsp adContentRsp) {
        String str;
        if (adContentRsp == null) {
            return;
        }
        List<Ad30> listM40830c = adContentRsp.m40830c();
        if (AbstractC7760bg.m47767a(listM40830c)) {
            return;
        }
        for (Ad30 ad30 : listM40830c) {
            if (ad30 != null) {
                String strM39419a = ad30.m39419a();
                if (AbstractC7806cz.m48165b(strM39419a)) {
                    str = "empty slot id";
                } else {
                    String strM39434g = ad30.m39434g();
                    if (AbstractC7806cz.m48165b(strM39434g)) {
                        str = "empty config map";
                    } else {
                        Map<String, String> map = (Map) AbstractC7758be.m47739b(strM39434g, Map.class, new Class[0]);
                        if (!C7765bl.m47802a(map)) {
                            C7123fg.m43308a(context).mo43311a(strM39419a, map);
                        }
                    }
                }
                AbstractC7185ho.m43817a("RecommendEngineUtil", str);
            }
        }
    }

    /* renamed from: a */
    public static boolean m48046a(Context context, int i10, List<String> list) {
        if (m48047a(context, list)) {
            AbstractC7185ho.m43817a("RecommendEngineUtil", "rec disabled");
            return false;
        }
        if (C7845x.m48576j(context) || i10 == 2) {
            return false;
        }
        int iMo43026D = C7124fh.m43316b(context).mo43026D();
        if (C7845x.m48612v(context, iMo43026D)) {
            AbstractC7185ho.m43820b("RecommendEngineUtil", "child mode, do not req from rec");
            return false;
        }
        if (!C7845x.m48609u(context, iMo43026D) || C7124fh.m43316b(context).mo43078l()) {
            return true;
        }
        AbstractC7185ho.m43817a("RecommendEngineUtil", "hw user disabled");
        return false;
    }

    /* renamed from: a */
    private static boolean m48047a(Context context, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (C7123fg.m43308a(context).mo43312a(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m48048a(Context context, List<String> list, AdContentRsp adContentRsp) {
        if (adContentRsp == null) {
            return false;
        }
        if (AbstractC7760bg.m47767a(adContentRsp.m40842f())) {
            return m48046a(context, 1, list);
        }
        AbstractC7185ho.m43817a("RecommendEngineUtil", "preload request not use rec engine");
        return false;
    }

    /* renamed from: a */
    public static String[] m48050a(Context context, String str) {
        Map<String, String> mapM47729a = AbstractC7758be.m47729a(C7124fh.m43316b(context).mo43070b(ConfigMapKeys.TRADE_MODE_IN_AD_TYPE, null));
        if (mapM47729a == null || !mapM47729a.containsKey(str)) {
            return m48053c(context);
        }
        String str2 = mapM47729a.get(str);
        return str2 == null ? new String[0] : str2.split(",");
    }
}
