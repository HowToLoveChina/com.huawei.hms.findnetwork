package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.ads.adsrec.AdRecommendEngine;
import com.huawei.openalliance.p169ad.beans.inner.UserIntent;
import com.huawei.openalliance.p169ad.beans.metadata.AdSlot30;
import com.huawei.openalliance.p169ad.beans.metadata.App;
import com.huawei.openalliance.p169ad.beans.metadata.PostBackEvent;
import com.huawei.openalliance.p169ad.beans.server.AdContentReq;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.AdRecommendEvent;
import com.huawei.openalliance.p169ad.net.http.Response;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7790cj;
import com.huawei.openalliance.p169ad.utils.C7840s;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import p247e4.C9405a;
import p277f4.C9655a;
import p277f4.InterfaceC9656b;
import p384j4.AbstractC10702a;

/* renamed from: com.huawei.openalliance.ad.el */
/* loaded from: classes8.dex */
public class C7096el {

    /* renamed from: a */
    private static volatile boolean f32690a = false;

    /* renamed from: b */
    private static final Map<String, Integer> f32691b = new ConcurrentHashMap();

    /* renamed from: a */
    public static Response<AdContentRsp> m42946a(Context context, AdContentReq adContentReq, List<String> list, int i10, Integer num) {
        long jM47566c = AbstractC7741ao.m47566c();
        C9655a c9655aM42954b = m42954b(context, adContentReq, list, i10, num);
        if (c9655aM42954b == null) {
            AbstractC7185ho.m43823c("AdRecommendEngineCaller", "request ads param is null");
            return null;
        }
        Response<AdContentRsp> response = new Response<>();
        response.m45978a(200);
        JSONObject jSONObjectM42948a = m42948a(context, adContentReq, c9655aM42954b, response);
        AbstractC7185ho.m43818a("AdRecommendEngineCaller", "recall result: %s", jSONObjectM42948a);
        if (jSONObjectM42948a == null) {
            response.m45978a(-1);
        }
        AdContentRsp adContentRsp = (AdContentRsp) AbstractC7758be.m47719a(context, jSONObjectM42948a, AdContentRsp.class, new Class[0]);
        response.m45983a((Response<AdContentRsp>) adContentRsp);
        if (adContentRsp != null) {
            response.m45990b(adContentRsp.toString());
        } else {
            response.m45978a(-1);
        }
        response.m45998e(AbstractC7741ao.m47566c() - jM47566c);
        return response;
    }

    /* renamed from: b */
    private static C9655a m42954b(Context context, AdContentReq adContentReq, List<String> list, int i10, Integer num) {
        AdSlot30 adSlot30;
        String str;
        App appM40798h = adContentReq.m40798h();
        if (appM40798h == null) {
            str = "compose param - app is null";
        } else {
            String strM39704c = appM40798h.m39704c();
            if (!AbstractC7760bg.m47767a(list)) {
                C9655a c9655a = new C9655a(strM39704c, adContentReq.m40810r(), list, num, i10);
                c9655a.m60314t(Arrays.asList(C7790cj.m48050a(context, String.valueOf(i10))));
                c9655a.m60316v(Integer.valueOf(C7124fh.m43316b(context).mo43080n()));
                c9655a.m60315u(context.getPackageName());
                c9655a.m60317w(m42947a(adContentReq));
                c9655a.m60318x(m42957c(adContentReq));
                c9655a.m60319y(adContentReq.m40760K());
                List<AdSlot30> listM40803k = adContentReq.m40803k();
                if (listM40803k != null && (adSlot30 = listM40803k.get(0)) != null) {
                    c9655a.m60320z(adSlot30.m39534m());
                }
                return c9655a;
            }
            str = "slots is empty";
        }
        AbstractC7185ho.m43823c("AdRecommendEngineCaller", str);
        return null;
    }

    /* renamed from: c */
    private static String m42957c(AdContentReq adContentReq) {
        List<UserIntent> listM42955b = m42955b(adContentReq);
        if (AbstractC7760bg.m47767a(listM42955b)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < listM42955b.size(); i10++) {
            UserIntent userIntent = listM42955b.get(i10);
            if (userIntent != null) {
                String strM39418b = userIntent.m39418b();
                if (!AbstractC7806cz.m48165b(strM39418b) && strM39418b.length() >= 8) {
                    sb2.append(strM39418b.substring(0, 8));
                    sb2.append(":");
                    sb2.append(userIntent.m39417a());
                    sb2.append(",");
                }
            }
        }
        AbstractC7806cz.m48159a(sb2, ',');
        return sb2.toString();
    }

    /* renamed from: a */
    private static String m42947a(AdContentReq adContentReq) {
        List<UserIntent> listM42955b = m42955b(adContentReq);
        if (AbstractC7760bg.m47767a(listM42955b)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < listM42955b.size(); i10++) {
            UserIntent userIntent = listM42955b.get(i10);
            if (userIntent != null) {
                String strM39418b = userIntent.m39418b();
                if (!AbstractC7806cz.m48165b(strM39418b) && strM39418b.length() >= 4) {
                    sb2.append(strM39418b.substring(0, 4));
                    sb2.append(",");
                }
            }
        }
        AbstractC7806cz.m48159a(sb2, ',');
        return sb2.toString();
    }

    /* renamed from: b */
    private static List<UserIntent> m42955b(AdContentReq adContentReq) {
        Map<String, String> mapM40754E = adContentReq.m40754E();
        if (C7765bl.m47802a(mapM40754E)) {
            return null;
        }
        String str = mapM40754E.get("intents");
        if (AbstractC7806cz.m48165b(str)) {
            return null;
        }
        List<UserIntent> list = (List) AbstractC7758be.m47739b(str, List.class, UserIntent.class);
        if (AbstractC7760bg.m47767a(list)) {
            return null;
        }
        return list;
    }

    /* renamed from: a */
    private static JSONObject m42948a(final Context context, final AdContentReq adContentReq, C9655a c9655a, final Response response) {
        return new AdRecommendEngine(context).m12452j(c9655a, new InterfaceC9656b() { // from class: com.huawei.openalliance.ad.el.1
            @Override // p277f4.InterfaceC9656b
            public String requestAd() {
                AbstractC7185ho.m43817a("AdRecommendEngineCaller", "do ad request");
                Response<String> responseMo43273a = C7118fb.m43196a(context).mo43273a(adContentReq);
                response.m45982a((Response) responseMo43273a);
                return responseMo43273a.m45987b();
            }
        });
    }

    /* renamed from: b */
    private static synchronized void m42956b(Context context) {
        if (!f32690a) {
            C7840s.m48502a(context);
            m42949a();
            f32690a = true;
            AbstractC7185ho.m43820b("AdRecommendEngineCaller", "common lib inited");
            C7790cj.m48044a(context);
        }
    }

    /* renamed from: a */
    private static void m42949a() {
        AbstractC10702a.m65326e(new AbstractC10702a.a());
    }

    /* renamed from: a */
    public static void m42950a(Context context, PostBackEvent postBackEvent) {
        String strM40404g = postBackEvent.m40404g();
        if (!AdRecommendEvent.eventTypeList.contains(strM40404g)) {
            AbstractC7185ho.m43817a("AdRecommendEngineCaller", "no need report to rec engine");
            return;
        }
        AbstractC7185ho.m43818a("AdRecommendEngineCaller", "post ad affair to rec engine: %s", strM40404g);
        AdRecommendEngine adRecommendEngine = new AdRecommendEngine(context);
        C9405a.a aVar = new C9405a.a();
        String strM40388a = postBackEvent.m40388a();
        if (TextUtils.isEmpty(strM40388a)) {
            strM40388a = context.getPackageName();
        }
        aVar.m58967g(strM40388a).m58970j(postBackEvent.m40392b()).m58963c(postBackEvent.m40396c()).m58969i(postBackEvent.m40398d()).m58968h(Long.valueOf(postBackEvent.m40400e())).m58966f(Integer.valueOf(postBackEvent.m40402f())).m58965e(strM40404g).m58964d(Long.valueOf(postBackEvent.m40405h())).m58962b(postBackEvent.m40406i());
        adRecommendEngine.m12451i(aVar.m58961a());
    }

    /* renamed from: a */
    public static void m42951a(List<String> list, int i10) {
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            f32691b.put(it.next(), Integer.valueOf(i10));
        }
    }

    /* renamed from: a */
    public static boolean m42952a(Context context) {
        try {
            m42956b(context);
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43827d("AdRecommendEngineCaller", "check ad rec engine error:%s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m42953a(String str) {
        Integer num = f32691b.get(str);
        return num != null && num.intValue() == 1;
    }
}
