package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6927h;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.FlowControl;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.qj */
/* loaded from: classes8.dex */
public class C7608qj {
    /* renamed from: a */
    private static Map<String, Integer> m47036a(List<String> list) {
        HashMap map = new HashMap();
        if (AbstractC7760bg.m47767a(list)) {
            return map;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next(), 0);
        }
        return map;
    }

    /* renamed from: a */
    public static void m47037a(Context context, AdContentRsp adContentRsp) {
        try {
            if (context == null || adContentRsp == null) {
                AbstractC7185ho.m43820b("FlowControlManager", "para is empty");
                return;
            }
            List<Ad30> listM40830c = adContentRsp.m40830c();
            if (AbstractC7760bg.m47767a(listM40830c)) {
                return;
            }
            for (Ad30 ad30 : listM40830c) {
                if (ad30 != null && ad30.m39436i() != null) {
                    C7124fh.m43316b(context).mo43326a(ad30.m39419a(), ad30.m39436i());
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("FlowControlManager", "save fc err, %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private static void m47038a(final Context context, final String str, final int i10) {
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.qj.1
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                if (context2 == null) {
                    return;
                }
                InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context2);
                int iMo43489w = interfaceC7146gcM43316b.mo43489w(str);
                AbstractC7185ho.m43818a("FlowControlManager", "fc counts: %d", Integer.valueOf(iMo43489w));
                if (iMo43489w <= 0) {
                    AbstractC7185ho.m43820b("FlowControlManager", "no need report");
                } else {
                    new C6927h(context).m39181a(str, iMo43489w, i10);
                    interfaceC7146gcM43316b.mo43490x(str);
                }
            }
        });
    }

    /* renamed from: a */
    private static void m47039a(Context context, Map<String, Integer> map, List<String> list, SecureRandom secureRandom, String str, FlowControl flowControl, int i10) {
        if (System.currentTimeMillis() > flowControl.m40168b()) {
            m47038a(context, str, i10);
            map.put(str, 0);
            return;
        }
        int iM40165a = flowControl.m40165a();
        if (iM40165a <= 0 || iM40165a > 100) {
            map.put(str, 0);
        } else {
            if (secureRandom.nextInt(101) > iM40165a) {
                map.put(str, 1);
                return;
            }
            AbstractC7185ho.m43821b("FlowControlManager", "discard slot %s", str);
            C7124fh.m43316b(context).mo43488v(str);
            list.remove(str);
        }
    }

    /* renamed from: a */
    public static boolean m47040a(Context context, AdSlotParam adSlotParam) {
        HashMap map = new HashMap();
        if (adSlotParam == null) {
            return false;
        }
        List<String> listM40627a = adSlotParam.m40627a();
        if (AbstractC7760bg.m47767a(listM40627a) || context == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(listM40627a);
        try {
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("FlowControlManager", "filter err, %s", th2.getClass().getSimpleName());
        }
        if (C7124fh.m43316b(context).mo43437ch() == 0) {
            adSlotParam.m40637a(m47036a(listM40627a));
            return true;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (String str : listM40627a) {
            FlowControl flowControlMo43487u = C7124fh.m43316b(context).mo43487u(str);
            if (flowControlMo43487u != null) {
                m47039a(context, map, arrayList, secureRandom, str, flowControlMo43487u, adSlotParam.m40620D());
            } else {
                map.put(str, 0);
            }
        }
        if (AbstractC7760bg.m47767a(arrayList)) {
            return false;
        }
        adSlotParam.m40637a(map);
        adSlotParam.m40636a(arrayList);
        return true;
    }
}
