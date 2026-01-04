package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.p169ad.beans.metadata.C6957Om;
import com.iab.omid.library.huawei.Omid;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;
import com.iab.omid.library.huawei.adsession.AdSessionContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.lp */
/* loaded from: classes8.dex */
public class C7406lp implements InterfaceC7474mi {

    /* renamed from: a */
    private static boolean f34434a = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.AdSession");

    /* renamed from: b */
    private final List<AdSession> f34435b = new ArrayList();

    /* renamed from: c */
    private Context f34436c;

    /* renamed from: a */
    public void m45631a(Context context, List<C6957Om> list, C7423me c7423me) throws Throwable {
        if (!m45629a() || context == null || list == null) {
            AbstractC7185ho.m43820b("AdsessionAgent", "not available, not init");
            return;
        }
        if (list.isEmpty() || c7423me == null) {
            AbstractC7185ho.m43820b("AdsessionAgent", "oms is empty or sessionWrapper is null, not init");
            return;
        }
        AbstractC7185ho.m43820b("AdsessionAgent", "init");
        this.f34436c = context;
        m45628a(list, c7423me);
    }

    /* renamed from: b */
    public List<AdSession> m45632b() {
        return this.f34435b;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7474mi
    /* renamed from: c */
    public void mo45616c() {
        if (this.f34435b.isEmpty()) {
            return;
        }
        try {
            for (AdSession adSession : this.f34435b) {
                AbstractC7185ho.m43817a("AdsessionAgent", "adsession start");
                adSession.start();
            }
        } catch (Throwable unused) {
            AbstractC7185ho.m43820b("AdsessionAgent", "start, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7474mi
    /* renamed from: d */
    public void mo45617d() {
        if (!this.f34435b.isEmpty()) {
            try {
                Iterator<AdSession> it = this.f34435b.iterator();
                while (it.hasNext()) {
                    it.next().finish();
                    AbstractC7185ho.m43817a("AdsessionAgent", " adSession finish");
                }
            } catch (Throwable unused) {
                AbstractC7185ho.m43820b("AdsessionAgent", "finish, fail");
            }
        }
        this.f34435b.clear();
    }

    /* renamed from: e */
    public Context m45633e() {
        return this.f34436c;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7474mi
    /* renamed from: a */
    public void mo45608a(View view) {
        if (this.f34435b.isEmpty()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.f34435b.iterator();
            while (it.hasNext()) {
                it.next().registerAdView(view);
            }
        } catch (Throwable unused) {
            AbstractC7185ho.m43820b("AdsessionAgent", "registerAdView, fail");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7474mi
    /* renamed from: a */
    public void mo45609a(View view, EnumC7473mh enumC7473mh, String str) {
        if (this.f34435b.isEmpty() || enumC7473mh == null || !EnumC7473mh.m45837a()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.f34435b.iterator();
            while (it.hasNext()) {
                it.next().addFriendlyObstruction(view, EnumC7473mh.m45836a(enumC7473mh), str);
            }
        } catch (Throwable unused) {
            AbstractC7185ho.m43820b("AdsessionAgent", "addFriendlyObstruction-f, fail");
        }
    }

    /* renamed from: a */
    private void m45626a(C7423me c7423me, C7477ml c7477ml) throws Throwable {
        String str;
        if (c7477ml == null) {
            str = "init AdSessionContext failed";
        } else {
            if (!C7471mf.m45832a()) {
                return;
            }
            AdSessionContext adSessionContextM45833a = new C7471mf(this.f34436c).m45833a(c7477ml, null);
            if (adSessionContextM45833a != null) {
                m45627a(adSessionContextM45833a, c7423me);
                return;
            }
            str = "adSessionContext is null";
        }
        AbstractC7185ho.m43820b("AdsessionAgent", str);
    }

    /* renamed from: a */
    private void m45627a(AdSessionContext adSessionContext, C7423me c7423me) {
        try {
            if (C7423me.m45680a() && c7423me != null) {
                AdSessionConfiguration adSessionConfigurationM45681b = c7423me.m45681b();
                if (adSessionConfigurationM45681b == null) {
                    AbstractC7185ho.m43820b("AdsessionAgent", "adSessionConfiguration is null");
                    return;
                }
                AbstractC7185ho.m43820b("AdsessionAgent", "initAdSession");
                AdSession adSessionCreateAdSession = m45630a(this.f34436c) ? AdSession.createAdSession(adSessionConfigurationM45681b, adSessionContext) : null;
                if (adSessionCreateAdSession == null) {
                    AbstractC7185ho.m43820b("AdsessionAgent", "adSession is null");
                    return;
                } else {
                    this.f34435b.add(adSessionCreateAdSession);
                    return;
                }
            }
            AbstractC7185ho.m43820b("AdsessionAgent", "init AdSession failed");
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("AdsessionAgent", "initAdSession error");
        }
    }

    /* renamed from: a */
    private void m45628a(List<C6957Om> list, C7423me c7423me) throws Throwable {
        if (!C7477ml.m45843a()) {
            AbstractC7185ho.m43820b("AdsessionAgent", "init VerficationScriptResourceWrapper failed");
            return;
        }
        for (C6957Om c6957Om : list) {
            AbstractC7185ho.m43820b("AdsessionAgent", "Init Verfication Script");
            C7477ml c7477ml = new C7477ml();
            c7477ml.m45844a(c6957Om);
            m45626a(c7423me, c7477ml);
        }
    }

    /* renamed from: a */
    public static boolean m45629a() {
        return f34434a;
    }

    /* renamed from: a */
    private static boolean m45630a(Context context) {
        Omid.activate(context);
        return true;
    }
}
