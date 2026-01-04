package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7791ck;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.m */
/* loaded from: classes8.dex */
public class C7417m {

    /* renamed from: a */
    private static C7417m f34449a;

    /* renamed from: b */
    private static final byte[] f34450b = new byte[0];

    /* renamed from: c */
    private final Map<String, InterfaceC7143g> f34451c = new HashMap();

    /* renamed from: d */
    private final Map<String, Class<? extends InterfaceC7143g>> f34452d;

    /* renamed from: e */
    private final List<String> f34453e;

    private C7417m() {
        HashMap map = new HashMap();
        this.f34452d = map;
        ArrayList arrayList = new ArrayList();
        this.f34453e = arrayList;
        map.put("pps.native.request", C7854v.class);
        map.put("pps.reward.request", C8232x.class);
        map.put("pps.interstitial.request", C7705u.class);
        map.put("pps.placement.request", C8205w.class);
        map.put("pps.action.click", C7170h.class);
        map.put("pps.download.progress", C6944av.class);
        map.put("pps.download.status", C6945aw.class);
        map.put("pps.download.reserveapp", C6946ax.class);
        map.put("pps.download.start", C6948az.class);
        map.put("pps.click.complianceele", C7353k.class);
        map.put("pps.click.share", C7380l.class);
        map.put("pps.download.resume", C6947ay.class);
        map.put("pps.download.pause", C6943au.class);
        map.put("pps.download.cancel", C6913ah.class);
        map.put("pps.listener.appstatus", C6938ap.class);
        map.put("pps.listener.offDownloadChange", C6914ai.class);
        map.put("pps.listener.browserappstatus", C6917al.class);
        map.put("pps.listener.appprogress", C6937ao.class);
        map.put("pps.listener.appopen", C6916ak.class);
        map.put("pps.listener.downloadcancel", C6918am.class);
        map.put("pps.activity.reward", C6853ac.class);
        map.put("pps.activity.interstitial", C6852ab.class);
        map.put("pps.advertiserinfo.show", C6851aa.class);
        map.put("pps.feedback.click", C7532o.class);
        map.put("pps.feedback.toggle", C7566p.class);
        map.put("pps.common.report", C6953bd.class);
        map.put("pps.common.analysis", C7492n.class);
        map.put("pps.listener.webopen", C6942at.class);
        map.put("pps.listener.webclose", C6940ar.class);
        map.put("pps.listener.webloadfinish", C6941as.class);
        map.put("pps.event.showstart", C6968bl.class);
        map.put("pps.event.praise", C6966bj.class);
        map.put("pps.event.show", C6967bk.class);
        map.put("pps.event.click", C6951bb.class);
        map.put("pps.event.close", C6952bc.class);
        map.put("pps.event.playtime", C6965bi.class);
        map.put("pps.event.playstart", C6964bh.class);
        map.put("pps.event.playpause", C6962bf.class);
        map.put("pps.event.playresume", C6963bg.class);
        map.put("pps.event.playend", C6954be.class);
        map.put("pps.settings", C8250y.class);
        map.put("pps.process.whythisad", C7678t.class);
        map.put("pps.listener.appreservestatus", C6915aj.class);
        if (AbstractC7791ck.m48070c(Constants.CONSENT_SDK)) {
            map.put("pps.consent.query", C6909ad.class);
            map.put("pps.set.consentstatus", C6911af.class);
            map.put("pps.set.consentpromise", C6910ae.class);
        }
        map.put("pps.api.req.getbody", C7598q.class);
        map.put("pps.api.parse.ad", C7651s.class);
        arrayList.add("pps.action.click");
        arrayList.add("pps.activity.reward");
        arrayList.add("pps.activity.interstitial");
    }

    /* renamed from: a */
    public InterfaceC7143g m45654a(String str) {
        StringBuilder sb2;
        String str2;
        String string;
        if (!TextUtils.isEmpty(str)) {
            InterfaceC7143g interfaceC7143gNewInstance = this.f34451c.get(str);
            if (interfaceC7143gNewInstance == null) {
                AbstractC7185ho.m43818a("JsbCmdManager", "create action %s", str);
                Class<? extends InterfaceC7143g> cls = this.f34452d.get(str);
                if (cls == null) {
                    sb2 = new StringBuilder();
                    str2 = "no class found for cmd: ";
                } else {
                    try {
                        interfaceC7143gNewInstance = cls.newInstance();
                    } catch (InstantiationException unused) {
                        AbstractC7185ho.m43824c("JsbCmdManager", "get cmd %s InstantiationException", str);
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43824c("JsbCmdManager", "get cmd %s: %s", str, th2.getClass().getSimpleName());
                    }
                    if (interfaceC7143gNewInstance == null) {
                        sb2 = new StringBuilder();
                        str2 = "no instance created for cmd: ";
                    } else {
                        this.f34451c.put(str, interfaceC7143gNewInstance);
                    }
                }
                sb2.append(str2);
                sb2.append(str);
                string = sb2.toString();
            }
            return interfaceC7143gNewInstance;
        }
        string = "get cmd, method is empty";
        AbstractC7185ho.m43823c("JsbCmdManager", string);
        return null;
    }

    /* renamed from: a */
    public static C7417m m45653a() {
        C7417m c7417m;
        synchronized (f34450b) {
            try {
                if (f34449a == null) {
                    f34449a = new C7417m();
                }
                c7417m = f34449a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7417m;
    }
}
