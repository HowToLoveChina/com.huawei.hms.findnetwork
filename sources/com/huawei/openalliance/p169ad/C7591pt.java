package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.ContentExt;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.inter.data.C7303f;
import com.huawei.openalliance.p169ad.inter.data.IPreCheckInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7792cl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.pt */
/* loaded from: classes8.dex */
public class C7591pt {

    /* renamed from: a */
    private static Map<String, Integer> f35444a;

    /* renamed from: a */
    private static int m46953a(String str, List<InterfaceC7597pz> list, Content content, int i10, int i11) {
        if (list == null) {
            return -1;
        }
        boolean zMo46967a = false;
        int iMo46966b = -1;
        for (InterfaceC7597pz interfaceC7597pz : list) {
            zMo46967a |= interfaceC7597pz.mo46967a(str, i10, i11, content);
            if (zMo46967a && iMo46966b == -1) {
                iMo46966b = interfaceC7597pz.mo46966b();
            }
        }
        return iMo46966b;
    }

    /* renamed from: b */
    private static void m46963b(List<IPreCheckInfo> list, Ad30 ad30, C7599qa c7599qa) {
        List<Content> listM39428c = ad30.m39428c();
        if (AbstractC7760bg.m47767a(listM39428c)) {
            return;
        }
        for (Content content : listM39428c) {
            if (content != null) {
                list.add(m46956a(ad30, false, c7599qa, content));
            }
        }
    }

    /* renamed from: a */
    private static int m46954a(List<InterfaceC7597pz> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return 0;
        }
        Iterator<InterfaceC7597pz> it = list.iterator();
        while (it.hasNext()) {
            int iMo46966b = it.next().mo46966b();
            if (iMo46966b == 3) {
                return iMo46966b;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static AdContentRsp m46955a(Context context, AdContentRsp adContentRsp, int i10) {
        long jM47566c = AbstractC7741ao.m47566c();
        f35444a = new HashMap();
        if (adContentRsp == null) {
            return null;
        }
        List<Ad30> listM40830c = adContentRsp.m40830c();
        if (AbstractC7760bg.m47767a(listM40830c)) {
            return adContentRsp;
        }
        for (Ad30 ad30 : listM40830c) {
            List<Content> listM39428c = ad30.m39428c();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<ImpEX> listM39433f = ad30.m39433f();
            if (!AbstractC7760bg.m47767a(listM39428c)) {
                for (Content content : listM39428c) {
                    if (content != null) {
                        content.m39925a(adContentRsp.m40847h(), i10);
                        content.m39959f(adContentRsp.m40855o());
                        content.m39965g(m46959a(listM39433f, content.m39901P()));
                        List<InterfaceC7597pz> listM46958a = m46958a(context, content.m40005y());
                        int iM46953a = m46953a(ad30.m39419a(), listM46958a, content, i10, adContentRsp.m40855o());
                        if (iM46953a == -1) {
                            arrayList.add(content);
                            C7792cl.m48071a(context, content, m46954a(listM46958a), i10);
                        } else {
                            m46961a(iM46953a);
                            arrayList2.add(content);
                        }
                    }
                }
            }
            ad30.m39423a(arrayList);
            ad30.m39430c(arrayList2);
        }
        if (!C7765bl.m47802a(f35444a)) {
            adContentRsp.m40825a(f35444a);
        }
        long jM47566c2 = AbstractC7741ao.m47566c() - jM47566c;
        adContentRsp.m40821a(jM47566c2);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AdFilterManager", "filter ad contents, duration: %s ms", Long.valueOf(jM47566c2));
        }
        return adContentRsp;
    }

    /* renamed from: a */
    private static C7303f m46956a(Ad30 ad30, boolean z10, C7599qa c7599qa, Content content) {
        C7303f c7303f = new C7303f();
        c7303f.m44863b(content.m39962g());
        c7303f.m44860a(ad30.m39419a());
        c7303f.m44862a(z10);
        c7303f.m44861a(m46960a(content));
        c7303f.m44859a(c7599qa.m46978a(content.m39944c()));
        return c7303f;
    }

    /* renamed from: a */
    public static List<IPreCheckInfo> m46957a(Context context, AdContentRsp adContentRsp) {
        ArrayList arrayList = new ArrayList();
        if (context != null && adContentRsp != null) {
            List<Ad30> listM40830c = adContentRsp.m40830c();
            if (AbstractC7760bg.m47767a(adContentRsp.m40830c())) {
                return arrayList;
            }
            for (Ad30 ad30 : listM40830c) {
                if (ad30 != null) {
                    C7599qa c7599qa = new C7599qa(context);
                    m46963b(arrayList, ad30, c7599qa);
                    m46962a(arrayList, ad30, c7599qa);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<InterfaceC7597pz> m46958a(Context context, List<Integer> list) {
        Object c7592pu;
        if (list == null || context == null) {
            if (list == null) {
                AbstractC7185ho.m43823c("AdFilterManager", "createFilters filterList is null");
            }
            if (context != null) {
                return null;
            }
            AbstractC7185ho.m43823c("AdFilterManager", "createFilters context is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 1) {
                    c7592pu = new C7592pu(context);
                } else if (iIntValue == 2) {
                    c7592pu = new C7593pv(context);
                } else if (iIntValue == 3) {
                    c7592pu = new C7599qa(context);
                } else if (iIntValue == 4) {
                    c7592pu = new C7594pw(context);
                } else if (iIntValue == 99) {
                    c7592pu = new C7596py(context);
                }
                arrayList.add(c7592pu);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<ImpEX> m46959a(List<ImpEX> list, List<ImpEX> list2) {
        ArrayList arrayList = new ArrayList();
        if (!AbstractC7760bg.m47767a(list2)) {
            arrayList.addAll(list2);
        }
        if (!AbstractC7760bg.m47767a(list)) {
            arrayList.addAll(list);
        }
        if (AbstractC7760bg.m47767a(arrayList)) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    private static Map<String, String> m46960a(Content content) {
        HashMap map = new HashMap();
        List<ContentExt> listM39902Q = content.m39902Q();
        if (!AbstractC7760bg.m47767a(listM39902Q)) {
            for (ContentExt contentExt : listM39902Q) {
                if (contentExt != null) {
                    map.put(contentExt.m40009a(), AbstractC7806cz.m48168c(contentExt.m40011b()));
                }
            }
        }
        List<ImpEX> listM39901P = content.m39901P();
        if (!AbstractC7760bg.m47767a(listM39901P)) {
            for (ImpEX impEX : listM39901P) {
                if (impEX != null) {
                    map.put(impEX.m40188a(), AbstractC7806cz.m48168c(impEX.m40190b()));
                }
            }
        }
        return map;
    }

    /* renamed from: a */
    private static void m46961a(int i10) {
        if (i10 != -1) {
            String strM48153a = AbstractC7806cz.m48153a(Integer.valueOf(i10));
            if (!f35444a.containsKey(strM48153a)) {
                f35444a.put(strM48153a, 1);
            } else {
                f35444a.put(strM48153a, Integer.valueOf(f35444a.get(strM48153a).intValue() + 1));
            }
        }
    }

    /* renamed from: a */
    private static void m46962a(List<IPreCheckInfo> list, Ad30 ad30, C7599qa c7599qa) {
        List<Content> listM39435h = ad30.m39435h();
        if (AbstractC7760bg.m47767a(listM39435h)) {
            return;
        }
        for (Content content : listM39435h) {
            if (content != null) {
                list.add(m46956a(ad30, true, c7599qa, content));
            }
        }
    }
}
