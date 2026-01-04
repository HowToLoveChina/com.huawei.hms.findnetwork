package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.InterfaceC7372ks;
import com.huawei.openalliance.p169ad.analysis.C6920a;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6923d;
import com.huawei.openalliance.p169ad.analysis.C6924e;
import com.huawei.openalliance.p169ad.analysis.C6927h;
import com.huawei.openalliance.p169ad.beans.inner.AdRequestParam;
import com.huawei.openalliance.p169ad.beans.inner.ApiReqParam;
import com.huawei.openalliance.p169ad.beans.metadata.AdTimeStatistics;
import com.huawei.openalliance.p169ad.beans.metadata.App;
import com.huawei.openalliance.p169ad.beans.metadata.CheckResult;
import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Location;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.beans.server.AdContentReq;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.AdConfigMapKey;
import com.huawei.openalliance.p169ad.constant.AnalyticsEventType;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.IntervalMethods;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.constant.SpKeys;
import com.huawei.openalliance.p169ad.constant.TagKey;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.HiAdSplash;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.net.http.Response;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7754ba;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7779bz;
import com.huawei.openalliance.p169ad.utils.C7786cf;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import com.huawei.openalliance.p169ad.utils.C7790cj;
import com.huawei.openalliance.p169ad.utils.C7794cn;
import com.huawei.openalliance.p169ad.utils.C7812de;
import com.huawei.openalliance.p169ad.utils.C7826e;
import com.huawei.openalliance.p169ad.utils.C7829h;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.ol */
/* loaded from: classes8.dex */
public class C7544ol implements InterfaceC7610ql {

    /* renamed from: a */
    private Context f35006a;

    /* renamed from: b */
    private InterfaceC7135fs f35007b;

    /* renamed from: c */
    private InterfaceC7147gd f35008c;

    /* renamed from: d */
    private InterfaceC7141fy f35009d;

    /* renamed from: e */
    private InterfaceC7140fx f35010e;

    /* renamed from: f */
    private InterfaceC7146gc f35011f;

    /* renamed from: g */
    private DelayInfo f35012g;

    /* renamed from: com.huawei.openalliance.ad.ol$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: com.huawei.openalliance.ad.ol$1$1 */
        public class C144731 implements RemoteCallResultCallback<String> {

            /* renamed from: a */
            final /* synthetic */ InterfaceC7151gh f35014a;

            public C144731(InterfaceC7151gh interfaceC7151gh) {
                interfaceC7151gh = interfaceC7151gh;
            }

            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult == null || callResult.getCode() != 200) {
                    return;
                }
                AbstractC7185ho.m43817a("AdReqProcessor", "async query user tag success");
                interfaceC7151gh.mo43551a(callResult.getData());
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7124fh.m43316b(C7544ol.this.f35006a).mo43075i()) {
                InterfaceC7151gh interfaceC7151ghM43547a = C7131fo.m43547a(C7544ol.this.f35006a);
                if (AbstractC7741ao.m47566c() - interfaceC7151ghM43547a.mo43549a() <= 43200000) {
                    return;
                }
                AbstractC7185ho.m43817a("AdReqProcessor", "async query user tag");
                interfaceC7151ghM43547a.mo43550a(AbstractC7741ao.m47566c());
                try {
                    C7484ms.m45854a(C7544ol.this.f35006a).m45855a(RTCMethods.QUERY_USER_TAG, null, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.ol.1.1

                        /* renamed from: a */
                        final /* synthetic */ InterfaceC7151gh f35014a;

                        public C144731(InterfaceC7151gh interfaceC7151ghM43547a2) {
                            interfaceC7151gh = interfaceC7151ghM43547a2;
                        }

                        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                        public void onRemoteCallResult(String str, CallResult<String> callResult) {
                            if (callResult == null || callResult.getCode() != 200) {
                                return;
                            }
                            AbstractC7185ho.m43817a("AdReqProcessor", "async query user tag success");
                            interfaceC7151gh.mo43551a(callResult.getData());
                        }
                    }, String.class);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("AdReqProcessor", "asyn query user tag failed: %s", th2.getClass().getSimpleName());
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$10 */
    public class AnonymousClass10 implements Runnable {
        public AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6982bz.m41152b(C7544ol.this.f35006a)) {
                if (Constants.HW_INTELLIEGNT_PACKAGE.equalsIgnoreCase(C7544ol.this.f35006a.getPackageName()) || !C7124fh.m43316b(C7544ol.this.f35006a).mo43419bt()) {
                    C7484ms.m45854a(C7544ol.this.f35006a).m45855a(RTCMethods.REPORT_CONSENT, null, null, null);
                } else {
                    C7484ms.m45854a(C7544ol.this.f35006a).m45857i();
                }
                long jMo43418bs = C7544ol.this.f35011f.mo43418bs();
                long jM47566c = AbstractC7741ao.m47566c();
                if (jM47566c - jMo43418bs > C5863b6.g.f26453g) {
                    C7544ol.this.f35011f.mo43453f(jM47566c);
                    HiAd.m44014a(C7544ol.this.f35006a).mo44046a(C7544ol.this.f35011f.mo43345aL());
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$11 */
    public class AnonymousClass11 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdContentRsp f35017a;

        public AnonymousClass11(AdContentRsp adContentRsp) {
            adContentRsp = adContentRsp;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7544ol.this.f35011f.mo43456g(adContentRsp.m40850j());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$12 */
    public class AnonymousClass12 implements Runnable {

        /* renamed from: com.huawei.openalliance.ad.ol$12$1 */
        public class AnonymousClass1 implements RemoteCallResultCallback<String> {

            /* renamed from: a */
            final /* synthetic */ InterfaceC7133fq f35020a;

            public AnonymousClass1(InterfaceC7133fq interfaceC7133fq) {
                interfaceC7133fq = interfaceC7133fq;
            }

            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult == null || callResult.getCode() != 200) {
                    return;
                }
                AbstractC7185ho.m43817a("AdReqProcessor", "asyn query aud id success");
                interfaceC7133fq.mo42974a(callResult.getData());
            }
        }

        public AnonymousClass12() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7124fh.m43316b(C7544ol.this.f35006a).mo43076j()) {
                InterfaceC7133fq interfaceC7133fqM42970a = C7099eo.m42970a(C7544ol.this.f35006a);
                if (AbstractC7741ao.m47566c() - interfaceC7133fqM42970a.mo42972a() <= 43200000) {
                    return;
                }
                AbstractC7185ho.m43817a("AdReqProcessor", "asyn query aud id");
                interfaceC7133fqM42970a.mo42973a(AbstractC7741ao.m47566c());
                try {
                    C7484ms.m45854a(C7544ol.this.f35006a).m45855a(RTCMethods.QUERY_AUD_ID, null, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.ol.12.1

                        /* renamed from: a */
                        final /* synthetic */ InterfaceC7133fq f35020a;

                        public AnonymousClass1(InterfaceC7133fq interfaceC7133fqM42970a2) {
                            interfaceC7133fq = interfaceC7133fqM42970a2;
                        }

                        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                        public void onRemoteCallResult(String str, CallResult<String> callResult) {
                            if (callResult == null || callResult.getCode() != 200) {
                                return;
                            }
                            AbstractC7185ho.m43817a("AdReqProcessor", "asyn query aud id success");
                            interfaceC7133fq.mo42974a(callResult.getData());
                        }
                    }, String.class);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("AdReqProcessor", "asyn query aud id failed: %s", th2.getClass().getSimpleName());
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$13 */
    public class AnonymousClass13 implements Runnable {
        public AnonymousClass13() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new C7017df(C7544ol.this.f35006a).m41931a();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$14 */
    public class AnonymousClass14 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdContentRsp f35023a;

        public AnonymousClass14(AdContentRsp adContentRsp) {
            adContentRsp = adContentRsp;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7790cj.m48045a(C7544ol.this.f35006a, adContentRsp);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$15 */
    public class AnonymousClass15 implements Runnable {
        public AnonymousClass15() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7544ol.this.m46323g();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$16 */
    public class AnonymousClass16 implements Runnable {
        public AnonymousClass16() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC7139fw interfaceC7139fwM43174a = C7114ey.m43174a(C7544ol.this.f35006a);
            if (!AbstractC7741ao.m47576e(C7544ol.this.f35006a)) {
                C7544ol.this.m46295a(interfaceC7139fwM43174a);
                return;
            }
            if (C7544ol.this.m46322f()) {
                AbstractC7185ho.m43820b("AdReqProcessor", "do query ins app");
                Pair<Integer, String> pairM47851a = C7779bz.m47851a(C7544ol.this.f35006a, "/insapp/query", "");
                C7544ol.this.f35011f.mo43485s(SpKeys.METHOD_QUERY_INSTALL_LIST);
                if (pairM47851a == null) {
                    AbstractC7185ho.m43820b("AdReqProcessor", "query ins app failed");
                    return;
                }
                AbstractC7185ho.m43821b("AdReqProcessor", "query ins app return code: %s", pairM47851a.first);
                AbstractC7185ho.m43818a("AdReqProcessor", "query ins app return result: %s", pairM47851a.second);
                interfaceC7139fwM43174a.mo43177a(((Integer) pairM47851a.first).intValue());
                C7544ol.this.m46296a(interfaceC7139fwM43174a, pairM47851a);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$17 */
    public class AnonymousClass17 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f35027a;

        /* renamed from: b */
        final /* synthetic */ boolean f35028b;

        /* renamed from: c */
        final /* synthetic */ AdContentRsp f35029c;

        /* renamed from: com.huawei.openalliance.ad.ol$17$1 */
        public class AnonymousClass1 implements RemoteCallResultCallback<String> {
            public AnonymousClass1() {
            }

            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult == null || callResult.getCode() != 200) {
                    return;
                }
                AbstractC7185ho.m43817a("AdReqProcessor", "update media config success");
                String data = callResult.getData();
                if (AbstractC7806cz.m48165b(data)) {
                    return;
                }
                C7120fd.m43288a(C7544ol.this.f35006a).mo43292a((Map<String, String>) AbstractC7758be.m47739b(data, Map.class, new Class[0]));
            }
        }

        public AnonymousClass17(int i10, boolean z10, AdContentRsp adContentRsp) {
            i = i10;
            z = z10;
            adContentRsp = adContentRsp;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (1 == i) {
                Map<String, String> mapM47898b = z ? C7786cf.m47898b(adContentRsp) : C7786cf.m47897a(adContentRsp);
                if (C7765bl.m47802a(mapM47898b)) {
                    return;
                }
                C7120fd.m43288a(C7544ol.this.f35006a).mo43292a(mapM47898b);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AdConfigMapKey.SPLASH_PRELOAD_MODE, AbstractC7758be.m47742b(mapM47898b));
                    C7484ms.m45854a(C7544ol.this.f35006a).m45855a(RTCMethods.UPDATE_MEDIA_CONFIG, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.ol.17.1
                        public AnonymousClass1() {
                        }

                        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                        public void onRemoteCallResult(String str, CallResult<String> callResult) {
                            if (callResult == null || callResult.getCode() != 200) {
                                return;
                            }
                            AbstractC7185ho.m43817a("AdReqProcessor", "update media config success");
                            String data = callResult.getData();
                            if (AbstractC7806cz.m48165b(data)) {
                                return;
                            }
                            C7120fd.m43288a(C7544ol.this.f35006a).mo43292a((Map<String, String>) AbstractC7758be.m47739b(data, Map.class, new Class[0]));
                        }
                    }, String.class);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("AdReqProcessor", "update media config to kit error:%s", th2.getClass().getSimpleName());
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$18 */
    public class AnonymousClass18 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdContentRsp f35032a;

        /* renamed from: b */
        final /* synthetic */ int f35033b;

        public AnonymousClass18(AdContentRsp adContentRsp, int i10) {
            adContentRsp = adContentRsp;
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdContentRsp adContentRsp = adContentRsp;
            if (adContentRsp != null) {
                C7544ol.this.m46311b(adContentRsp, i);
            }
            C7790cj.m48045a(C7544ol.this.f35006a, adContentRsp);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$19 */
    public class AnonymousClass19 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ InterfaceC7618qt f35035a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC7609qk f35036b;

        /* renamed from: com.huawei.openalliance.ad.ol$19$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractC7185ho.m43817a("AdReqProcessor", "deleteInvalidContents");
                    interfaceC7618qt.mo46783a();
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("AdReqProcessor", "deleteInvalidContents err: %s", th2.getClass().getSimpleName());
                }
            }
        }

        public AnonymousClass19(InterfaceC7618qt interfaceC7618qt, InterfaceC7609qk interfaceC7609qk) {
            interfaceC7618qt = interfaceC7618qt;
            interfaceC7609qk = interfaceC7609qk;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.ol.19.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AbstractC7185ho.m43817a("AdReqProcessor", "deleteInvalidContents");
                        interfaceC7618qt.mo46783a();
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43824c("AdReqProcessor", "deleteInvalidContents err: %s", th2.getClass().getSimpleName());
                    }
                }
            }, C7544ol.this.f35011f.mo43060ah());
            interfaceC7618qt.mo46789b();
            if (interfaceC7609qk == null) {
                interfaceC7618qt.mo46792d();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35039a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC7618qt f35040b;

        /* renamed from: c */
        final /* synthetic */ long f35041c;

        public AnonymousClass2(ContentRecord contentRecord, InterfaceC7618qt interfaceC7618qt, long j10) {
            contentRecord = contentRecord;
            interfaceC7618qt = interfaceC7618qt;
            j = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentRecord contentRecord = contentRecord;
            if (contentRecord == null || contentRecord.m41568i() == null || AbstractC7760bg.m47767a(contentRecord.m41568i().m40315g())) {
                return;
            }
            interfaceC7618qt.mo46784a(contentRecord.m41568i().m40315g().get(0), contentRecord, j);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DelayInfo f35043a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC7618qt f35044b;

        /* renamed from: c */
        final /* synthetic */ String f35045c;

        /* renamed from: d */
        final /* synthetic */ int f35046d;

        /* renamed from: e */
        final /* synthetic */ int f35047e;

        /* renamed from: f */
        final /* synthetic */ String f35048f;

        public AnonymousClass3(DelayInfo delayInfo, InterfaceC7618qt interfaceC7618qt, String str, int i10, int i11, String str2) {
            delayInfo = delayInfo;
            interfaceC7618qt = interfaceC7618qt;
            str = str;
            i = i10;
            i = i11;
            str = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strM39882c;
            int i10;
            ContentRecord contentRecordM41885h = AbstractC7014dc.m41885h();
            C6922c c6922c = new C6922c(C7544ol.this.f35006a);
            String strM39881b = null;
            if (contentRecordM41885h == null) {
                c6922c.mo39065a(new C6920a(str, str, i), 101, (String) null, (String) null);
                return;
            }
            String strM41585m = contentRecordM41885h.m41585m();
            String strM41588n = contentRecordM41885h.m41588n();
            delayInfo.m40049e(contentRecordM41885h.m41588n());
            AbstractC7185ho.m43817a("AdReqProcessor", "check spare ad exist");
            CheckResult checkResultMo46779a = interfaceC7618qt.mo46779a(contentRecordM41885h);
            C6920a c6920a = new C6920a(str, strM41585m, i);
            c6920a.m38868a(strM41588n);
            if (checkResultMo46779a == null || !checkResultMo46779a.m39880a()) {
                AbstractC7014dc.m41877b((ContentRecord) null);
                if (checkResultMo46779a != null) {
                    strM39881b = checkResultMo46779a.m39881b();
                    strM39882c = checkResultMo46779a.m39882c();
                } else {
                    strM39882c = null;
                }
                c6922c.mo39065a(c6920a, 104, strM39881b, strM39882c);
                return;
            }
            contentRecordM41885h.m41571i(checkResultMo46779a.m39881b());
            contentRecordM41885h.m41575j(checkResultMo46779a.m39882c());
            contentRecordM41885h.m41599q(checkResultMo46779a.m39883d());
            interfaceC7618qt.mo46785a(contentRecordM41885h, contentRecordM41885h.m41588n());
            ContentRecord contentRecordMo46781a = interfaceC7618qt.mo46781a(contentRecordM41885h, i, AbstractC7741ao.m47566c());
            AbstractC7014dc.m41877b(contentRecordMo46781a);
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(contentRecordMo46781a != null);
            AbstractC7185ho.m43818a("AdReqProcessor", "spare ad downloaded: %s", objArr);
            if (contentRecordMo46781a != null) {
                contentRecordMo46781a.m41618y(str);
                contentRecordMo46781a.m41538c(true);
                delayInfo.m40039b(true);
                i10 = 200;
            } else {
                AbstractC7014dc.m41877b((ContentRecord) null);
                i10 = 103;
            }
            c6922c.mo39065a(c6920a, i10, (String) null, (String) null);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ InterfaceC7618qt f35050a;

        /* renamed from: b */
        final /* synthetic */ int f35051b;

        /* renamed from: c */
        final /* synthetic */ long f35052c;

        /* renamed from: d */
        final /* synthetic */ int f35053d;

        /* renamed from: e */
        final /* synthetic */ String f35054e;

        public AnonymousClass4(InterfaceC7618qt interfaceC7618qt, int i10, long j10, int i11, String str) {
            interfaceC7618qt = interfaceC7618qt;
            i = i10;
            j = j10;
            i = i11;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentRecord contentRecordM41884g = AbstractC7014dc.m41884g();
            if (contentRecordM41884g != null) {
                ContentRecord contentRecordMo46782a = interfaceC7618qt.mo46782a(contentRecordM41884g, i, j, AbstractC7796cp.m48089b(C7544ol.this.f35006a), i);
                if (contentRecordMo46782a == null) {
                    AbstractC7014dc.m41868a((ContentRecord) null);
                    return;
                }
                ContentRecord contentRecordMo46781a = interfaceC7618qt.mo46781a(contentRecordMo46782a, i, AbstractC7741ao.m47566c());
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(contentRecordMo46781a != null);
                AbstractC7185ho.m43818a("AdReqProcessor", "normal ad downloaded: %s", objArr);
                if (contentRecordMo46781a != null) {
                    contentRecordMo46781a.m41618y(str);
                }
                AbstractC7014dc.m41868a(contentRecordMo46781a);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f35056a;

        /* renamed from: b */
        final /* synthetic */ boolean f35057b;

        public AnonymousClass5(List list, boolean z10) {
            list = list;
            z = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7544ol.this.m46306a((List<String>) list, z);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$6 */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f35059a;

        /* renamed from: b */
        final /* synthetic */ String f35060b;

        /* renamed from: c */
        final /* synthetic */ List f35061c;

        /* renamed from: d */
        final /* synthetic */ int f35062d;

        /* renamed from: e */
        final /* synthetic */ Response f35063e;

        public AnonymousClass6(Context context, String str, List list, int i10, Response response) {
            context = context;
            str = str;
            list = list;
            i = i10;
            response = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            new C6927h(context).m39192a(str, list, i, response);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$7 */
    public class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f35065a;

        /* renamed from: b */
        final /* synthetic */ int f35066b;

        /* renamed from: c */
        final /* synthetic */ long f35067c;

        /* renamed from: d */
        final /* synthetic */ AdSlotParam f35068d;

        /* renamed from: e */
        final /* synthetic */ Response f35069e;

        /* renamed from: f */
        final /* synthetic */ List f35070f;

        public AnonymousClass7(String str, int i10, long j10, AdSlotParam adSlotParam, Response response, List list) {
            str = str;
            i = i10;
            j = j10;
            adSlotParam = adSlotParam;
            response = response;
            list = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7544ol.this.m46313b(str, i, j, adSlotParam, response, list);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$8 */
    public class AnonymousClass8 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdSlotParam f35072a;

        /* renamed from: b */
        final /* synthetic */ String f35073b;

        /* renamed from: c */
        final /* synthetic */ int f35074c;

        public AnonymousClass8(AdSlotParam adSlotParam, String str, int i10) {
            adSlotParam = adSlotParam;
            str = str;
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C6927h c6927h = new C6927h(C7544ol.this.f35006a);
            List<String> listM40627a = adSlotParam.m40627a();
            int size = AbstractC7760bg.m47767a(listM40627a) ? 0 : listM40627a.size();
            Integer numValueOf = adSlotParam.m40660m() > 0 ? Integer.valueOf(adSlotParam.m40660m()) : null;
            boolean zM40657j = adSlotParam.m40657j();
            AdTimeStatistics adTimeStatistics = new AdTimeStatistics();
            adTimeStatistics.m39558a(C7544ol.this.m46328a().m40070u().m39557a());
            adTimeStatistics.m39564d(C7544ol.this.m46328a().m40070u().m39563d());
            adTimeStatistics.m39562c(C7544ol.this.m46328a().m40070u().m39561c());
            c6927h.m39183a(str, i, size, numValueOf, zM40657j, adTimeStatistics);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ol$9 */
    public class AnonymousClass9 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdContentRsp f35076a;

        /* renamed from: b */
        final /* synthetic */ int f35077b;

        public AnonymousClass9(AdContentRsp adContentRsp, int i10) {
            adContentRsp = adContentRsp;
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7544ol.this.m46311b(adContentRsp, i);
        }
    }

    public C7544ol(Context context) {
        this.f35006a = context.getApplicationContext();
        this.f35007b = C7103es.m43094a(context);
        this.f35008c = C7127fk.m43505a(context);
        this.f35009d = C7119fc.m43281a(context);
        this.f35010e = C7118fb.m43196a(context);
        this.f35011f = C7124fh.m43316b(context);
    }

    /* renamed from: c */
    private void m46314c() {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ol.12

            /* renamed from: com.huawei.openalliance.ad.ol$12$1 */
            public class AnonymousClass1 implements RemoteCallResultCallback<String> {

                /* renamed from: a */
                final /* synthetic */ InterfaceC7133fq f35020a;

                public AnonymousClass1(InterfaceC7133fq interfaceC7133fqM42970a2) {
                    interfaceC7133fq = interfaceC7133fqM42970a2;
                }

                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult == null || callResult.getCode() != 200) {
                        return;
                    }
                    AbstractC7185ho.m43817a("AdReqProcessor", "asyn query aud id success");
                    interfaceC7133fq.mo42974a(callResult.getData());
                }
            }

            public AnonymousClass12() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C7124fh.m43316b(C7544ol.this.f35006a).mo43076j()) {
                    InterfaceC7133fq interfaceC7133fqM42970a2 = C7099eo.m42970a(C7544ol.this.f35006a);
                    if (AbstractC7741ao.m47566c() - interfaceC7133fqM42970a2.mo42972a() <= 43200000) {
                        return;
                    }
                    AbstractC7185ho.m43817a("AdReqProcessor", "asyn query aud id");
                    interfaceC7133fqM42970a2.mo42973a(AbstractC7741ao.m47566c());
                    try {
                        C7484ms.m45854a(C7544ol.this.f35006a).m45855a(RTCMethods.QUERY_AUD_ID, null, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.ol.12.1

                            /* renamed from: a */
                            final /* synthetic */ InterfaceC7133fq f35020a;

                            public AnonymousClass1(InterfaceC7133fq interfaceC7133fqM42970a22) {
                                interfaceC7133fq = interfaceC7133fqM42970a22;
                            }

                            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                if (callResult == null || callResult.getCode() != 200) {
                                    return;
                                }
                                AbstractC7185ho.m43817a("AdReqProcessor", "asyn query aud id success");
                                interfaceC7133fq.mo42974a(callResult.getData());
                            }
                        }, String.class);
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43824c("AdReqProcessor", "asyn query aud id failed: %s", th2.getClass().getSimpleName());
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private void m46321e() {
        AbstractC7185ho.m43817a("AdReqProcessor", "query install app list");
        if (m46322f()) {
            long jNextInt = new SecureRandom().nextInt(60000);
            AbstractC7185ho.m43818a("AdReqProcessor", "query ins app random : %s", Long.valueOf(jNextInt));
            AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.ol.15
                public AnonymousClass15() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7544ol.this.m46323g();
                }
            }, jNextInt);
        }
    }

    /* renamed from: f */
    public boolean m46322f() {
        if (-1 == this.f35011f.mo43081o()) {
            AbstractC7185ho.m43820b("AdReqProcessor", "query ins app disabled");
            return false;
        }
        if (!this.f35011f.mo43052a(SpKeys.METHOD_QUERY_INSTALL_LIST, 180)) {
            return true;
        }
        AbstractC7185ho.m43817a("AdReqProcessor", "query ins app later");
        return false;
    }

    /* renamed from: g */
    public void m46323g() {
        if (C7845x.m48576j(this.f35006a)) {
            AbstractC7185ho.m43817a("AdReqProcessor", "no need to query ins app on tv");
        } else if (C6982bz.m41152b(this.f35006a)) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ol.16
                public AnonymousClass16() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC7139fw interfaceC7139fwM43174a = C7114ey.m43174a(C7544ol.this.f35006a);
                    if (!AbstractC7741ao.m47576e(C7544ol.this.f35006a)) {
                        C7544ol.this.m46295a(interfaceC7139fwM43174a);
                        return;
                    }
                    if (C7544ol.this.m46322f()) {
                        AbstractC7185ho.m43820b("AdReqProcessor", "do query ins app");
                        Pair<Integer, String> pairM47851a = C7779bz.m47851a(C7544ol.this.f35006a, "/insapp/query", "");
                        C7544ol.this.f35011f.mo43485s(SpKeys.METHOD_QUERY_INSTALL_LIST);
                        if (pairM47851a == null) {
                            AbstractC7185ho.m43820b("AdReqProcessor", "query ins app failed");
                            return;
                        }
                        AbstractC7185ho.m43821b("AdReqProcessor", "query ins app return code: %s", pairM47851a.first);
                        AbstractC7185ho.m43818a("AdReqProcessor", "query ins app return result: %s", pairM47851a.second);
                        interfaceC7139fwM43174a.mo43177a(((Integer) pairM47851a.first).intValue());
                        C7544ol.this.m46296a(interfaceC7139fwM43174a, pairM47851a);
                    }
                }
            });
        } else {
            AbstractC7185ho.m43817a("AdReqProcessor", "only query ins app on hw device");
        }
    }

    /* renamed from: h */
    private void m46324h() {
        C7787cg c7787cgM47900a = C7787cg.m47900a(this.f35006a);
        c7787cgM47900a.m47971b(new ArrayList());
        Map<String, String> mapM47958aa = c7787cgM47900a.m47958aa();
        if (!C7765bl.m47802a(mapM47958aa)) {
            mapM47958aa.put(TagKey.HW_U001, "");
        }
        c7787cgM47900a.m47956a(mapM47958aa);
    }

    /* renamed from: i */
    private List<String> m46325i() {
        try {
            return C7084e.m42838b().mo30521a((Bundle) null);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("AdReqProcessor", "get blkTptList err: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: j */
    private void m46326j() {
        if (this.f35011f.mo43071b(IntervalMethods.NOTIFY_KIT_AD_REQ)) {
            AbstractC7185ho.m43818a("AdReqProcessor", "within time interval, skip: %s", IntervalMethods.NOTIFY_KIT_AD_REQ);
        } else {
            this.f35011f.mo43485s(IntervalMethods.NOTIFY_KIT_AD_REQ);
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ol.10
                public AnonymousClass10() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C6982bz.m41152b(C7544ol.this.f35006a)) {
                        if (Constants.HW_INTELLIEGNT_PACKAGE.equalsIgnoreCase(C7544ol.this.f35006a.getPackageName()) || !C7124fh.m43316b(C7544ol.this.f35006a).mo43419bt()) {
                            C7484ms.m45854a(C7544ol.this.f35006a).m45855a(RTCMethods.REPORT_CONSENT, null, null, null);
                        } else {
                            C7484ms.m45854a(C7544ol.this.f35006a).m45857i();
                        }
                        long jMo43418bs = C7544ol.this.f35011f.mo43418bs();
                        long jM47566c = AbstractC7741ao.m47566c();
                        if (jM47566c - jMo43418bs > C5863b6.g.f26453g) {
                            C7544ol.this.f35011f.mo43453f(jM47566c);
                            HiAd.m44014a(C7544ol.this.f35006a).mo44046a(C7544ol.this.f35011f.mo43345aL());
                        }
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public AdContentRsp m46337b(AdSlotParam adSlotParam) {
        m46320d(adSlotParam);
        if (adSlotParam != null) {
            adSlotParam.m40627a();
        }
        adSlotParam.m40630a(m46280a(this.f35006a.getPackageName(), adSlotParam));
        return m46281a(12, adSlotParam, (List<String>) null, (List<String>) null, (List<String>) null);
    }

    /* renamed from: b */
    private void m46309b() {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ol.1

            /* renamed from: com.huawei.openalliance.ad.ol$1$1 */
            public class C144731 implements RemoteCallResultCallback<String> {

                /* renamed from: a */
                final /* synthetic */ InterfaceC7151gh f35014a;

                public C144731(InterfaceC7151gh interfaceC7151ghM43547a2) {
                    interfaceC7151gh = interfaceC7151ghM43547a2;
                }

                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult == null || callResult.getCode() != 200) {
                        return;
                    }
                    AbstractC7185ho.m43817a("AdReqProcessor", "async query user tag success");
                    interfaceC7151gh.mo43551a(callResult.getData());
                }
            }

            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C7124fh.m43316b(C7544ol.this.f35006a).mo43075i()) {
                    InterfaceC7151gh interfaceC7151ghM43547a2 = C7131fo.m43547a(C7544ol.this.f35006a);
                    if (AbstractC7741ao.m47566c() - interfaceC7151ghM43547a2.mo43549a() <= 43200000) {
                        return;
                    }
                    AbstractC7185ho.m43817a("AdReqProcessor", "async query user tag");
                    interfaceC7151ghM43547a2.mo43550a(AbstractC7741ao.m47566c());
                    try {
                        C7484ms.m45854a(C7544ol.this.f35006a).m45855a(RTCMethods.QUERY_USER_TAG, null, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.ol.1.1

                            /* renamed from: a */
                            final /* synthetic */ InterfaceC7151gh f35014a;

                            public C144731(InterfaceC7151gh interfaceC7151ghM43547a22) {
                                interfaceC7151gh = interfaceC7151ghM43547a22;
                            }

                            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                if (callResult == null || callResult.getCode() != 200) {
                                    return;
                                }
                                AbstractC7185ho.m43817a("AdReqProcessor", "async query user tag success");
                                interfaceC7151gh.mo43551a(callResult.getData());
                            }
                        }, String.class);
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43824c("AdReqProcessor", "asyn query user tag failed: %s", th2.getClass().getSimpleName());
                    }
                }
            }
        });
    }

    /* renamed from: c */
    private void m46315c(AdSlotParam adSlotParam) {
        String str;
        try {
            HiAd.m44014a(this.f35006a).mo44045a(adSlotParam.m40627a().get(0));
        } catch (RuntimeException unused) {
            str = "refreshConfig RuntimeException";
            AbstractC7185ho.m43823c("AdReqProcessor", str);
        } catch (Exception unused2) {
            str = "refreshConfig Exception";
            AbstractC7185ho.m43823c("AdReqProcessor", str);
        }
    }

    /* renamed from: d */
    private void m46319d() {
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.ol.13
            public AnonymousClass13() {
            }

            @Override // java.lang.Runnable
            public void run() {
                new C7017df(C7544ol.this.f35006a).m41931a();
            }
        });
    }

    /* renamed from: a */
    public Pair<String, Map<Integer, AdContentRsp>> m46327a(String str, long j10, Set<Integer> set, boolean z10) {
        AbstractC7185ho.m43817a("AdReqProcessor", "requestAdViaApi");
        ArrayList arrayList = new ArrayList();
        Map<Integer, AdContentRsp> mapMo43275a = this.f35010e.mo43275a(str, j10, arrayList);
        long jM47566c = AbstractC7741ao.m47566c() - j10;
        Response response = new Response();
        response.m45988b(1);
        String strM40851k = "";
        if (mapMo43275a.isEmpty()) {
            m46304a("", -1, jM47566c, (AdSlotParam) null, response, (List<String>) null);
            return new Pair<>("", mapMo43275a);
        }
        for (Map.Entry<Integer, AdContentRsp> entry : mapMo43275a.entrySet()) {
            Integer key = entry.getKey();
            int iIntValue = key.intValue();
            AdContentRsp value = entry.getValue();
            strM40851k = value.m40851k();
            C7787cg.m47900a(this.f35006a).m47931J(value.m40852l());
            AbstractC7185ho.m43818a("AdReqProcessor", "response return from content trackVersion is : %s", value.m40852l());
            if (iIntValue == 60) {
                m46316c(value);
            }
            if (!set.contains(key)) {
                AbstractC7185ho.m43821b("AdReqProcessor", "adContentRsp is discard, adType: %s ", key);
                value = null;
            }
            C7591pt.m46955a(this.f35006a, value, iIntValue);
            response.m45983a((Response) value);
            m46285a(iIntValue, value);
        }
        if (z10 && !AbstractC7760bg.m47767a(arrayList)) {
            HiAd.m44014a(this.f35006a).mo44045a((String) arrayList.get(0));
        }
        return new Pair<>(strM40851k, mapMo43275a);
    }

    /* renamed from: a */
    private App m46280a(String str, AdSlotParam adSlotParam) {
        RequestOptions requestOptionsM40659l;
        if (WhiteListPkgList.inWhiteList(str, C7830i.m48435e(this.f35006a, str))) {
            App appM40656i = adSlotParam.m40656i();
            return (appM40656i != null || (requestOptionsM40659l = adSlotParam.m40659l()) == null || requestOptionsM40659l.getApp() == null) ? appM40656i : new App(this.f35006a, requestOptionsM40659l.getApp());
        }
        AbstractC7185ho.m43823c("AdReqProcessor", "can not set app info:" + str);
        return null;
    }

    /* renamed from: b */
    private void m46310b(AdContentRsp adContentRsp) {
        DelayInfo delayInfoM46328a = m46328a();
        if (adContentRsp == null) {
            delayInfoM46328a.m40034b(-1);
            return;
        }
        delayInfoM46328a.m40041c(adContentRsp.m40861u());
        delayInfoM46328a.m40034b(adContentRsp.m40819a());
        delayInfoM46328a.m40043c(adContentRsp.m40859s());
    }

    /* renamed from: c */
    private void m46316c(AdContentRsp adContentRsp) {
        if (adContentRsp == null) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ol.11

            /* renamed from: a */
            final /* synthetic */ AdContentRsp f35017a;

            public AnonymousClass11(AdContentRsp adContentRsp2) {
                adContentRsp = adContentRsp2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7544ol.this.f35011f.mo43456g(adContentRsp.m40850j());
            }
        });
    }

    /* renamed from: d */
    private void m46320d(AdSlotParam adSlotParam) {
        m46315c(adSlotParam);
        m46326j();
        RequestOptions requestOptionsM48075a = C7794cn.m48075a(this.f35006a, adSlotParam.m40659l());
        Location locationM47781a = C7762bi.m47781a(this.f35006a, requestOptionsM48075a, adSlotParam.m40658k() != null ? adSlotParam.m40658k().m40229a() : null);
        adSlotParam.m40631a(locationM47781a);
        adSlotParam.m40629a(locationM47781a.m40240f());
        adSlotParam.m40632a(requestOptionsM48075a);
        if (C7845x.m48576j(this.f35006a)) {
            return;
        }
        m46309b();
        m46314c();
        C7812de.m48352a(this.f35006a);
    }

    /* renamed from: b */
    public void m46311b(AdContentRsp adContentRsp, int i10) {
        List<ContentRecord> listM46757a = AbstractC7573pg.m46757a(adContentRsp, i10);
        byte[] bArrM48089b = AbstractC7796cp.m48089b(this.f35006a);
        ArrayList arrayList = new ArrayList();
        for (ContentRecord contentRecord : listM46757a) {
            if (contentRecord != null) {
                contentRecord.m41857a(bArrM48089b);
                Context context = this.f35006a;
                C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
                c7560ou.mo46590a(contentRecord);
                c7560ou.mo46631n();
                AppInfo appInfoM41484af = contentRecord.m41484af();
                if (appInfoM41484af != null && appInfoM41484af.m44383c() == 1) {
                    C6924e c6924e = new C6924e(1);
                    c6924e.m39143a(appInfoM41484af);
                    c6924e.m39141a(contentRecord);
                    new C6922c(this.f35006a).mo39066a(c6924e);
                }
                if (contentRecord.m41472aX() == 1) {
                    arrayList.add(contentRecord);
                }
            }
        }
        new C6922c(this.f35006a).mo39111a(arrayList);
    }

    /* renamed from: a */
    public DelayInfo m46328a() {
        if (this.f35012g == null) {
            this.f35012g = new DelayInfo();
        }
        return this.f35012g;
    }

    /* renamed from: a */
    private AdContentRsp m46281a(int i10, AdSlotParam adSlotParam, List<String> list, List<String> list2, List<String> list3) {
        return m46282a(new AdRequestParam.Builder().m39345a(i10).m39346a(adSlotParam).m39348a(list).m39350b(list2).m39351c(list3).m39349a());
    }

    /* renamed from: b */
    public void m46313b(String str, int i10, long j10, AdSlotParam adSlotParam, Response response, List<String> list) {
        new C6927h(this.f35006a).m39185a(str, i10, j10, adSlotParam, response, AbstractC7758be.m47742b(m46328a().m40070u()), list);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7610ql
    /* renamed from: a */
    public AdContentRsp mo46329a(Context context, AdSlotParam adSlotParam, int i10) {
        App appM46280a;
        if (adSlotParam == null) {
            return null;
        }
        try {
            m46320d(adSlotParam);
            int allowMobileTraffic = -1;
            if (context != null) {
                allowMobileTraffic = HiAdSplash.getInstance(context).getAllowMobileTraffic();
                appM46280a = m46280a(context.getPackageName(), adSlotParam);
            } else {
                appM46280a = null;
            }
            adSlotParam.m40634a(allowMobileTraffic);
            adSlotParam.m40630a(appM46280a);
            AdContentRsp adContentRspM46281a = m46281a(i10, adSlotParam, (List<String>) null, (List<String>) null, (List<String>) null);
            m46286a(i10, adContentRspM46281a, adSlotParam.m40657j());
            return adContentRspM46281a;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AdReqProcessor", "request splash ad error: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    public AdContentRsp m46330a(Context context, AdSlotParam adSlotParam, String str, int i10, List<String> list) {
        m46320d(adSlotParam);
        List<String> listMo43508a = this.f35008c.mo43508a();
        App appM46280a = m46280a(context.getPackageName(), adSlotParam);
        if (appM46280a == null) {
            appM46280a = new App(context);
        }
        appM46280a.m39705c(str);
        adSlotParam.m40630a(appM46280a);
        return m46281a(i10, adSlotParam, list, (List<String>) null, listMo43508a);
    }

    /* renamed from: a */
    private AdContentRsp m46282a(AdRequestParam adRequestParam) {
        int iM39333a = adRequestParam.m39333a();
        AdSlotParam adSlotParamM39337b = adRequestParam.m39337b();
        List<String> listM39338c = adRequestParam.m39338c();
        adSlotParamM39337b.m40648d(iM39333a);
        if (!C7608qj.m47040a(this.f35006a, adSlotParamM39337b)) {
            AbstractC7185ho.m43820b("AdReqProcessor", "request discard");
            return null;
        }
        String strM40666s = adSlotParamM39337b.m40666s();
        if (AbstractC7806cz.m48165b(strM40666s) || adSlotParamM39337b.m40657j()) {
            strM40666s = AbstractC7741ao.m47539a();
        }
        String str = strM40666s;
        long jM47566c = AbstractC7741ao.m47566c();
        adRequestParam.m39336a(str);
        adRequestParam.m39334a(jM47566c);
        adRequestParam.m39335a(m46328a().m40070u());
        Response<AdContentRsp> responseMo43272a = this.f35010e.mo43272a(adRequestParam);
        AdContentRsp adContentRspM45987b = responseMo43272a != null ? responseMo43272a.m45987b() : null;
        long jM47566c2 = AbstractC7741ao.m47566c() - jM47566c;
        m46289a(adSlotParamM39337b, responseMo43272a, adContentRspM45987b);
        AdContentRsp adContentRspM46955a = C7591pt.m46955a(this.f35006a, adContentRspM45987b, iM39333a);
        m46310b(adContentRspM46955a);
        if (responseMo43272a != null) {
            m46328a().m40056h(responseMo43272a.m46013r());
            m46328a().m40058i(responseMo43272a.m46014s());
        }
        if (adContentRspM46955a != null) {
            adContentRspM46955a.m40848h(m46283a(adSlotParamM39337b.m40656i(), this.f35006a.getPackageName()));
            adContentRspM46955a.m40832c(str);
            adContentRspM46955a.m40822a(adSlotParamM39337b);
            C7787cg.m47900a(this.f35006a).m47931J(adContentRspM46955a.m40852l());
            AbstractC7185ho.m43818a("AdReqProcessor", "response return from content trackVersion is : %s", adContentRspM46955a.m40852l());
            m46292a(adContentRspM46955a, iM39333a);
        } else {
            m46288a(this.f35006a, str, adSlotParamM39337b.m40627a(), iM39333a, responseMo43272a);
        }
        m46305a(str, iM39333a, adSlotParamM39337b);
        m46304a(str, iM39333a, jM47566c2, adSlotParamM39337b, responseMo43272a, listM39338c);
        m46307a(adSlotParamM39337b.m40657j(), adSlotParamM39337b.m40627a());
        m46319d();
        m46291a(adContentRspM46955a);
        m46321e();
        InterfaceC7612qn interfaceC7612qnM41147a = C6981by.m41146a(this.f35006a).m41147a(1, adSlotParamM39337b.m40647d());
        if (interfaceC7612qnM41147a != null) {
            interfaceC7612qnM41147a.mo46362b();
        }
        return adContentRspM46955a;
    }

    /* renamed from: a */
    public AdContentRsp m46331a(AdSlotParam adSlotParam) {
        m46320d(adSlotParam);
        adSlotParam.m40630a(m46280a(this.f35006a.getPackageName(), adSlotParam));
        return m46281a(7, adSlotParam, (List<String>) null, (List<String>) null, (List<String>) null);
    }

    /* renamed from: a */
    public AdContentRsp m46332a(AdSlotParam adSlotParam, String str) {
        m46320d(adSlotParam);
        List<String> listMo43284a = this.f35009d.mo43284a();
        App appM46280a = m46280a(this.f35006a.getPackageName(), adSlotParam);
        if (appM46280a == null) {
            appM46280a = new App(this.f35006a);
        }
        appM46280a.m39705c(str);
        adSlotParam.m40630a(appM46280a);
        AdContentRsp adContentRspM46281a = m46281a(60, adSlotParam, listMo43284a, (List<String>) null, (List<String>) null);
        m46316c(adContentRspM46281a);
        return adContentRspM46281a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7610ql
    /* renamed from: a */
    public AdContentRsp mo46333a(AdSlotParam adSlotParam, List<String> list, List<String> list2) {
        if (adSlotParam == null) {
            return null;
        }
        m46320d(adSlotParam);
        return m46282a(new AdRequestParam.Builder().m39345a(2).m39346a(adSlotParam).m39348a(list).m39352d(list2).m39349a());
    }

    /* renamed from: a */
    private String m46283a(App app, String str) {
        return (app == null || TextUtils.isEmpty(app.m39704c())) ? str : app.m39704c();
    }

    /* renamed from: a */
    public String m46334a(String str, int i10, AdSlotParam adSlotParam, ApiReqParam apiReqParam) {
        m46320d(adSlotParam);
        adSlotParam.m40630a(m46280a(this.f35006a.getPackageName(), adSlotParam));
        AdContentReq adContentReqMo43277b = this.f35010e.mo43277b(new AdRequestParam.Builder().m39347a(str).m39345a(i10).m39346a(adSlotParam).m39349a());
        adContentReqMo43277b.m40778b(str);
        m46284a(i10, apiReqParam, adContentReqMo43277b);
        try {
            try {
                return InterfaceC7372ks.a.m45457a(this.f35006a, adContentReqMo43277b.getClass()).mo45455a(adContentReqMo43277b, new C7345js());
            } catch (Exception unused) {
                AbstractC7185ho.m43823c("AdReqProcessor", "getAdContentReq error");
                C7095ek.m42934a(this.f35006a).m42945f();
                return "";
            }
        } finally {
            C7095ek.m42934a(this.f35006a).m42945f();
        }
    }

    /* renamed from: a */
    private void m46284a(int i10, ApiReqParam apiReqParam, AdContentReq adContentReq) {
        if (AbstractC7741ao.m47582g()) {
            if (7 == i10 || 12 == i10) {
                m46290a(adContentReq);
            }
            if (m46308a(apiReqParam)) {
                m46290a(adContentReq);
                adContentReq.m40780b(apiReqParam.m39354b());
            }
        }
    }

    /* renamed from: a */
    private void m46285a(int i10, AdContentRsp adContentRsp) {
        AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.ol.18

            /* renamed from: a */
            final /* synthetic */ AdContentRsp f35032a;

            /* renamed from: b */
            final /* synthetic */ int f35033b;

            public AnonymousClass18(AdContentRsp adContentRsp2, int i102) {
                adContentRsp = adContentRsp2;
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                AdContentRsp adContentRsp2 = adContentRsp;
                if (adContentRsp2 != null) {
                    C7544ol.this.m46311b(adContentRsp2, i);
                }
                C7790cj.m48045a(C7544ol.this.f35006a, adContentRsp);
            }
        });
    }

    /* renamed from: a */
    private void m46286a(int i10, AdContentRsp adContentRsp, boolean z10) {
        if (adContentRsp == null) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ol.17

            /* renamed from: a */
            final /* synthetic */ int f35027a;

            /* renamed from: b */
            final /* synthetic */ boolean f35028b;

            /* renamed from: c */
            final /* synthetic */ AdContentRsp f35029c;

            /* renamed from: com.huawei.openalliance.ad.ol$17$1 */
            public class AnonymousClass1 implements RemoteCallResultCallback<String> {
                public AnonymousClass1() {
                }

                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult == null || callResult.getCode() != 200) {
                        return;
                    }
                    AbstractC7185ho.m43817a("AdReqProcessor", "update media config success");
                    String data = callResult.getData();
                    if (AbstractC7806cz.m48165b(data)) {
                        return;
                    }
                    C7120fd.m43288a(C7544ol.this.f35006a).mo43292a((Map<String, String>) AbstractC7758be.m47739b(data, Map.class, new Class[0]));
                }
            }

            public AnonymousClass17(int i102, boolean z102, AdContentRsp adContentRsp2) {
                i = i102;
                z = z102;
                adContentRsp = adContentRsp2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (1 == i) {
                    Map<String, String> mapM47898b = z ? C7786cf.m47898b(adContentRsp) : C7786cf.m47897a(adContentRsp);
                    if (C7765bl.m47802a(mapM47898b)) {
                        return;
                    }
                    C7120fd.m43288a(C7544ol.this.f35006a).mo43292a(mapM47898b);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(AdConfigMapKey.SPLASH_PRELOAD_MODE, AbstractC7758be.m47742b(mapM47898b));
                        C7484ms.m45854a(C7544ol.this.f35006a).m45855a(RTCMethods.UPDATE_MEDIA_CONFIG, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.ol.17.1
                            public AnonymousClass1() {
                            }

                            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                if (callResult == null || callResult.getCode() != 200) {
                                    return;
                                }
                                AbstractC7185ho.m43817a("AdReqProcessor", "update media config success");
                                String data = callResult.getData();
                                if (AbstractC7806cz.m48165b(data)) {
                                    return;
                                }
                                C7120fd.m43288a(C7544ol.this.f35006a).mo43292a((Map<String, String>) AbstractC7758be.m47739b(data, Map.class, new Class[0]));
                            }
                        }, String.class);
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43824c("AdReqProcessor", "update media config to kit error:%s", th2.getClass().getSimpleName());
                    }
                }
            }
        });
    }

    /* renamed from: a */
    private void m46287a(long j10, InterfaceC7618qt interfaceC7618qt, ContentRecord contentRecord) {
        AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.ol.2

            /* renamed from: a */
            final /* synthetic */ ContentRecord f35039a;

            /* renamed from: b */
            final /* synthetic */ InterfaceC7618qt f35040b;

            /* renamed from: c */
            final /* synthetic */ long f35041c;

            public AnonymousClass2(ContentRecord contentRecord2, InterfaceC7618qt interfaceC7618qt2, long j102) {
                contentRecord = contentRecord2;
                interfaceC7618qt = interfaceC7618qt2;
                j = j102;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentRecord contentRecord2 = contentRecord;
                if (contentRecord2 == null || contentRecord2.m41568i() == null || AbstractC7760bg.m47767a(contentRecord.m41568i().m40315g())) {
                    return;
                }
                interfaceC7618qt.mo46784a(contentRecord.m41568i().m40315g().get(0), contentRecord, j);
            }
        });
    }

    /* renamed from: a */
    private void m46288a(Context context, String str, List<String> list, int i10, Response<AdContentRsp> response) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ol.6

            /* renamed from: a */
            final /* synthetic */ Context f35059a;

            /* renamed from: b */
            final /* synthetic */ String f35060b;

            /* renamed from: c */
            final /* synthetic */ List f35061c;

            /* renamed from: d */
            final /* synthetic */ int f35062d;

            /* renamed from: e */
            final /* synthetic */ Response f35063e;

            public AnonymousClass6(Context context2, String str2, List list2, int i102, Response response2) {
                context = context2;
                str = str2;
                list = list2;
                i = i102;
                response = response2;
            }

            @Override // java.lang.Runnable
            public void run() {
                new C6927h(context).m39192a(str, list, i, response);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7610ql
    /* renamed from: a */
    public void mo46335a(DelayInfo delayInfo) {
        this.f35012g = delayInfo;
    }

    /* renamed from: a */
    private void m46289a(AdSlotParam adSlotParam, Response<AdContentRsp> response, AdContentRsp adContentRsp) {
        Integer numM40619C = adSlotParam.m40619C();
        if (numM40619C != null) {
            if (response != null) {
                response.m45988b(numM40619C.intValue());
            }
            if (adContentRsp != null) {
                adContentRsp.m40843f(numM40619C.intValue());
            }
        }
    }

    /* renamed from: a */
    private void m46290a(AdContentReq adContentReq) {
        AbstractC7185ho.m43820b("AdReqProcessor", "configBasicTemplateParam");
        adContentReq.m40794f(C7084e.m42836a());
        adContentReq.m40783c(m46325i());
    }

    /* renamed from: a */
    private void m46291a(AdContentRsp adContentRsp) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ol.14

            /* renamed from: a */
            final /* synthetic */ AdContentRsp f35023a;

            public AnonymousClass14(AdContentRsp adContentRsp2) {
                adContentRsp = adContentRsp2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7790cj.m48045a(C7544ol.this.f35006a, adContentRsp);
            }
        });
    }

    /* renamed from: a */
    private void m46292a(AdContentRsp adContentRsp, int i10) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ol.9

            /* renamed from: a */
            final /* synthetic */ AdContentRsp f35076a;

            /* renamed from: b */
            final /* synthetic */ int f35077b;

            public AnonymousClass9(AdContentRsp adContentRsp2, int i102) {
                adContentRsp = adContentRsp2;
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7544ol.this.m46311b(adContentRsp, i);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7610ql
    /* renamed from: a */
    public void mo46336a(AdContentRsp adContentRsp, AdSlotParam adSlotParam, InterfaceC7621qw interfaceC7621qw, InterfaceC7609qk interfaceC7609qk, long j10, int i10) {
        C7579pm c7579pm;
        int i11;
        List<ContentRecord> list;
        String str;
        ContentRecord contentRecord;
        long jM47566c;
        String str2;
        ContentRecord contentRecord2;
        if (adContentRsp == null) {
            AbstractC7185ho.m43823c("AdReqProcessor", "dealResponse adContentRsp is null");
            m46328a().m40036b((Integer) (-1));
            if (interfaceC7609qk != null) {
                interfaceC7609qk.mo45200a(null);
                return;
            }
            return;
        }
        AbstractC7185ho.m43820b("AdReqProcessor", "dealResponse");
        m46328a().m40070u().m39572h(AbstractC7741ao.m47566c());
        List<ContentRecord> listMo44095b = interfaceC7621qw.mo44095b(adContentRsp);
        m46328a().m40070u().m39574i(AbstractC7741ao.m47566c());
        int iM40639b = adSlotParam.m40639b();
        List<String> listM40627a = adSlotParam.m40627a();
        String str3 = (listM40627a == null || listM40627a.size() <= 0) ? null : listM40627a.get(0);
        C7579pm c7579pm2 = new C7579pm(this.f35006a, listMo44095b, false, adSlotParam.m40620D());
        c7579pm2.mo46788a(adContentRsp.m40834d());
        c7579pm2.mo46790b(adContentRsp.m40838e());
        c7579pm2.mo46786a(Integer.valueOf(iM40639b));
        if (interfaceC7609qk != null) {
            c7579pm = c7579pm2;
            i11 = iM40639b;
            String str4 = str3;
            list = listMo44095b;
            str = null;
            m46302a(c7579pm2, iM40639b, adContentRsp.m40851k(), str4, m46328a(), adSlotParam.m40620D());
        } else {
            c7579pm = c7579pm2;
            i11 = iM40639b;
            list = listMo44095b;
            str = null;
        }
        long jM47566c2 = AbstractC7741ao.m47566c();
        ContentRecord contentRecordMo46780a = c7579pm.mo46780a(j10, i11, i10);
        m46328a().m40048e(AbstractC7741ao.m47566c() - jM47566c2);
        if (interfaceC7609qk != null) {
            contentRecord = contentRecordMo46780a;
            m46303a(c7579pm, j10, i11, adContentRsp.m40851k(), i10);
        } else {
            contentRecord = contentRecordMo46780a;
        }
        if (contentRecord != null) {
            jM47566c = AbstractC7741ao.m47566c();
            TemplateData templateDataM41469aU = contentRecord.m41469aU();
            ContentRecord contentRecordMo46781a = c7579pm.mo46781a(contentRecord, i11, jM47566c);
            AbstractC7185ho.m43820b("AdReqProcessor", "query content record: " + AbstractC7806cz.m48162b(contentRecordMo46781a));
            if (contentRecordMo46781a != null) {
                contentRecordMo46781a.m41618y(adContentRsp.m40851k());
                contentRecordMo46781a.m41479ab(adContentRsp.m40852l());
                contentRecordMo46781a.m41422T(adContentRsp.m40862v());
                String strM41588n = contentRecordMo46781a.m41588n();
                if (contentRecordMo46781a.m41464aP() == -1 || 2 == contentRecordMo46781a.m41464aP()) {
                    contentRecordMo46781a.m41440a(templateDataM41469aU);
                }
                str = strM41588n;
            }
            contentRecord2 = contentRecordMo46781a;
            str2 = str;
        } else {
            jM47566c = 0;
            str2 = str;
            contentRecord2 = str2;
        }
        long j11 = jM47566c;
        m46287a(j10, c7579pm, contentRecord2);
        m46294a(contentRecord2);
        C7579pm c7579pm3 = c7579pm;
        m46293a(adContentRsp, list, i11, str2, contentRecord2, j11);
        if (interfaceC7609qk != null) {
            interfaceC7609qk.mo45200a(contentRecord2);
        }
        c7579pm3.mo46791c();
        new C7579pm(this.f35006a, interfaceC7621qw.mo44094a(adContentRsp), true, adSlotParam.m40620D()).mo46780a(j10, i11, i10);
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.ol.19

            /* renamed from: a */
            final /* synthetic */ InterfaceC7618qt f35035a;

            /* renamed from: b */
            final /* synthetic */ InterfaceC7609qk f35036b;

            /* renamed from: com.huawei.openalliance.ad.ol$19$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AbstractC7185ho.m43817a("AdReqProcessor", "deleteInvalidContents");
                        interfaceC7618qt.mo46783a();
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43824c("AdReqProcessor", "deleteInvalidContents err: %s", th2.getClass().getSimpleName());
                    }
                }
            }

            public AnonymousClass19(InterfaceC7618qt c7579pm32, InterfaceC7609qk interfaceC7609qk2) {
                interfaceC7618qt = c7579pm32;
                interfaceC7609qk = interfaceC7609qk2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.ol.19.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AbstractC7185ho.m43817a("AdReqProcessor", "deleteInvalidContents");
                            interfaceC7618qt.mo46783a();
                        } catch (Throwable th2) {
                            AbstractC7185ho.m43824c("AdReqProcessor", "deleteInvalidContents err: %s", th2.getClass().getSimpleName());
                        }
                    }
                }, C7544ol.this.f35011f.mo43060ah());
                interfaceC7618qt.mo46789b();
                if (interfaceC7609qk == null) {
                    interfaceC7618qt.mo46792d();
                }
            }
        }, AbstractC7834m.a.DISK_CACHE, false);
    }

    /* renamed from: a */
    private void m46293a(AdContentRsp adContentRsp, List<ContentRecord> list, int i10, String str, ContentRecord contentRecord, long j10) {
        ContentRecord contentRecord2;
        DelayInfo delayInfoM46328a = m46328a();
        delayInfoM46328a.m40036b(Integer.valueOf(C6923d.m39126a(adContentRsp, contentRecord, str, i10, j10, list)));
        if (AbstractC7760bg.m47767a(list) || (contentRecord2 = list.get(0)) == null) {
            return;
        }
        delayInfoM46328a.m40029a(Integer.valueOf(contentRecord2.m41392E()));
        delayInfoM46328a.m40038b(Collections.singletonList(contentRecord2.m41588n()));
    }

    /* renamed from: a */
    private void m46294a(ContentRecord contentRecord) {
        if (contentRecord == null || contentRecord.m41568i() == null || contentRecord.m41568i().m40275L() == null) {
            return;
        }
        C7826e.m48392a(this.f35006a, contentRecord.m41568i().m40275L());
    }

    /* renamed from: a */
    public void m46295a(InterfaceC7139fw interfaceC7139fw) {
        AbstractC7185ho.m43817a("AdReqProcessor", "clear ins app info");
        interfaceC7139fw.mo43183c(Constants.INS_APPS_ENCODED);
        interfaceC7139fw.mo43183c(Constants.ENCODING_MODE);
        interfaceC7139fw.mo43183c(Constants.LABEL_GEN_TIME);
        m46324h();
    }

    /* renamed from: a */
    public void m46296a(InterfaceC7139fw interfaceC7139fw, Pair<Integer, String> pair) {
        if (200 != ((Integer) pair.first).intValue()) {
            m46295a(interfaceC7139fw);
            return;
        }
        String str = (String) pair.second;
        if (AbstractC7806cz.m48165b(str)) {
            AbstractC7185ho.m43820b("AdReqProcessor", "query ins app result blank");
        } else {
            AbstractC7754ba.m47704a(this.f35006a, str);
        }
    }

    /* renamed from: a */
    private void m46302a(InterfaceC7618qt interfaceC7618qt, int i10, String str, String str2, DelayInfo delayInfo, int i11) {
        AbstractC7185ho.m43820b("AdReqProcessor", "recordSpareAd");
        AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.ol.3

            /* renamed from: a */
            final /* synthetic */ DelayInfo f35043a;

            /* renamed from: b */
            final /* synthetic */ InterfaceC7618qt f35044b;

            /* renamed from: c */
            final /* synthetic */ String f35045c;

            /* renamed from: d */
            final /* synthetic */ int f35046d;

            /* renamed from: e */
            final /* synthetic */ int f35047e;

            /* renamed from: f */
            final /* synthetic */ String f35048f;

            public AnonymousClass3(DelayInfo delayInfo2, InterfaceC7618qt interfaceC7618qt2, String str3, int i112, int i102, String str22) {
                delayInfo = delayInfo2;
                interfaceC7618qt = interfaceC7618qt2;
                str = str3;
                i = i112;
                i = i102;
                str = str22;
            }

            @Override // java.lang.Runnable
            public void run() {
                String strM39882c;
                int i102;
                ContentRecord contentRecordM41885h = AbstractC7014dc.m41885h();
                C6922c c6922c = new C6922c(C7544ol.this.f35006a);
                String strM39881b = null;
                if (contentRecordM41885h == null) {
                    c6922c.mo39065a(new C6920a(str, str, i), 101, (String) null, (String) null);
                    return;
                }
                String strM41585m = contentRecordM41885h.m41585m();
                String strM41588n = contentRecordM41885h.m41588n();
                delayInfo.m40049e(contentRecordM41885h.m41588n());
                AbstractC7185ho.m43817a("AdReqProcessor", "check spare ad exist");
                CheckResult checkResultMo46779a = interfaceC7618qt.mo46779a(contentRecordM41885h);
                C6920a c6920a = new C6920a(str, strM41585m, i);
                c6920a.m38868a(strM41588n);
                if (checkResultMo46779a == null || !checkResultMo46779a.m39880a()) {
                    AbstractC7014dc.m41877b((ContentRecord) null);
                    if (checkResultMo46779a != null) {
                        strM39881b = checkResultMo46779a.m39881b();
                        strM39882c = checkResultMo46779a.m39882c();
                    } else {
                        strM39882c = null;
                    }
                    c6922c.mo39065a(c6920a, 104, strM39881b, strM39882c);
                    return;
                }
                contentRecordM41885h.m41571i(checkResultMo46779a.m39881b());
                contentRecordM41885h.m41575j(checkResultMo46779a.m39882c());
                contentRecordM41885h.m41599q(checkResultMo46779a.m39883d());
                interfaceC7618qt.mo46785a(contentRecordM41885h, contentRecordM41885h.m41588n());
                ContentRecord contentRecordMo46781a = interfaceC7618qt.mo46781a(contentRecordM41885h, i, AbstractC7741ao.m47566c());
                AbstractC7014dc.m41877b(contentRecordMo46781a);
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(contentRecordMo46781a != null);
                AbstractC7185ho.m43818a("AdReqProcessor", "spare ad downloaded: %s", objArr);
                if (contentRecordMo46781a != null) {
                    contentRecordMo46781a.m41618y(str);
                    contentRecordMo46781a.m41538c(true);
                    delayInfo.m40039b(true);
                    i102 = 200;
                } else {
                    AbstractC7014dc.m41877b((ContentRecord) null);
                    i102 = 103;
                }
                c6922c.mo39065a(c6920a, i102, (String) null, (String) null);
            }
        });
    }

    /* renamed from: a */
    private void m46303a(InterfaceC7618qt interfaceC7618qt, long j10, int i10, String str, int i11) {
        AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.ol.4

            /* renamed from: a */
            final /* synthetic */ InterfaceC7618qt f35050a;

            /* renamed from: b */
            final /* synthetic */ int f35051b;

            /* renamed from: c */
            final /* synthetic */ long f35052c;

            /* renamed from: d */
            final /* synthetic */ int f35053d;

            /* renamed from: e */
            final /* synthetic */ String f35054e;

            public AnonymousClass4(InterfaceC7618qt interfaceC7618qt2, int i102, long j102, int i112, String str2) {
                interfaceC7618qt = interfaceC7618qt2;
                i = i102;
                j = j102;
                i = i112;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentRecord contentRecordM41884g = AbstractC7014dc.m41884g();
                if (contentRecordM41884g != null) {
                    ContentRecord contentRecordMo46782a = interfaceC7618qt.mo46782a(contentRecordM41884g, i, j, AbstractC7796cp.m48089b(C7544ol.this.f35006a), i);
                    if (contentRecordMo46782a == null) {
                        AbstractC7014dc.m41868a((ContentRecord) null);
                        return;
                    }
                    ContentRecord contentRecordMo46781a = interfaceC7618qt.mo46781a(contentRecordMo46782a, i, AbstractC7741ao.m47566c());
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(contentRecordMo46781a != null);
                    AbstractC7185ho.m43818a("AdReqProcessor", "normal ad downloaded: %s", objArr);
                    if (contentRecordMo46781a != null) {
                        contentRecordMo46781a.m41618y(str);
                    }
                    AbstractC7014dc.m41868a(contentRecordMo46781a);
                }
            }
        });
    }

    /* renamed from: a */
    private void m46304a(String str, int i10, long j10, AdSlotParam adSlotParam, Response response, List<String> list) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ol.7

            /* renamed from: a */
            final /* synthetic */ String f35065a;

            /* renamed from: b */
            final /* synthetic */ int f35066b;

            /* renamed from: c */
            final /* synthetic */ long f35067c;

            /* renamed from: d */
            final /* synthetic */ AdSlotParam f35068d;

            /* renamed from: e */
            final /* synthetic */ Response f35069e;

            /* renamed from: f */
            final /* synthetic */ List f35070f;

            public AnonymousClass7(String str2, int i102, long j102, AdSlotParam adSlotParam2, Response response2, List list2) {
                str = str2;
                i = i102;
                j = j102;
                adSlotParam = adSlotParam2;
                response = response2;
                list = list2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7544ol.this.m46313b(str, i, j, adSlotParam, response, list);
            }
        });
    }

    /* renamed from: a */
    private void m46305a(String str, int i10, AdSlotParam adSlotParam) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ol.8

            /* renamed from: a */
            final /* synthetic */ AdSlotParam f35072a;

            /* renamed from: b */
            final /* synthetic */ String f35073b;

            /* renamed from: c */
            final /* synthetic */ int f35074c;

            public AnonymousClass8(AdSlotParam adSlotParam2, String str2, int i102) {
                adSlotParam = adSlotParam2;
                str = str2;
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                C6927h c6927h = new C6927h(C7544ol.this.f35006a);
                List<String> listM40627a = adSlotParam.m40627a();
                int size = AbstractC7760bg.m47767a(listM40627a) ? 0 : listM40627a.size();
                Integer numValueOf = adSlotParam.m40660m() > 0 ? Integer.valueOf(adSlotParam.m40660m()) : null;
                boolean zM40657j = adSlotParam.m40657j();
                AdTimeStatistics adTimeStatistics = new AdTimeStatistics();
                adTimeStatistics.m39558a(C7544ol.this.m46328a().m40070u().m39557a());
                adTimeStatistics.m39564d(C7544ol.this.m46328a().m40070u().m39563d());
                adTimeStatistics.m39562c(C7544ol.this.m46328a().m40070u().m39561c());
                c6927h.m39183a(str, i, size, numValueOf, zM40657j, adTimeStatistics);
            }
        });
    }

    /* renamed from: a */
    public void m46306a(List<String> list, boolean z10) {
        if (list == null || list.size() == 0) {
            AbstractC7185ho.m43826d("AdReqProcessor", "slotIds is empty");
            return;
        }
        String packageName = this.f35006a.getPackageName();
        String strValueOf = String.valueOf(z10 ? 2 : 1);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            C7829h.m48407a(this.f35006a, packageName, AnalyticsEventType.AD_REQ, strValueOf, it.next(), "");
        }
    }

    /* renamed from: a */
    private void m46307a(boolean z10, List<String> list) {
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.ol.5

            /* renamed from: a */
            final /* synthetic */ List f35056a;

            /* renamed from: b */
            final /* synthetic */ boolean f35057b;

            public AnonymousClass5(List list2, boolean z102) {
                list = list2;
                z = z102;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7544ol.this.m46306a((List<String>) list, z);
            }
        });
    }

    /* renamed from: a */
    private boolean m46308a(ApiReqParam apiReqParam) {
        return apiReqParam != null && apiReqParam.m39353a();
    }
}
