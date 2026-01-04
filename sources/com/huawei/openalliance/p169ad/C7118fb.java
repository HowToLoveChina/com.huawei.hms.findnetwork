package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.ads.adsrec.AdRecommendEngine;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.p169ad.InterfaceC7382lb;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6927h;
import com.huawei.openalliance.p169ad.beans.base.ReqBean;
import com.huawei.openalliance.p169ad.beans.inner.AdRequestParam;
import com.huawei.openalliance.p169ad.beans.inner.LocationSwitches;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.AdEvent;
import com.huawei.openalliance.p169ad.beans.metadata.AdEventResult;
import com.huawei.openalliance.p169ad.beans.metadata.AdEventResultV2;
import com.huawei.openalliance.p169ad.beans.metadata.AdSlot30;
import com.huawei.openalliance.p169ad.beans.metadata.AdTimeStatistics;
import com.huawei.openalliance.p169ad.beans.metadata.App;
import com.huawei.openalliance.p169ad.beans.metadata.AppCollection;
import com.huawei.openalliance.p169ad.beans.metadata.AppExt;
import com.huawei.openalliance.p169ad.beans.metadata.Device;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.metadata.Location;
import com.huawei.openalliance.p169ad.beans.metadata.Options;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.CachedContent;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.parameter.BiddingParam;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.beans.server.AdContentReq;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.beans.server.AdPreReq;
import com.huawei.openalliance.p169ad.beans.server.AnalysisReportReq;
import com.huawei.openalliance.p169ad.beans.server.AppConfigReq;
import com.huawei.openalliance.p169ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.p169ad.beans.server.AppDataCollectionReq;
import com.huawei.openalliance.p169ad.beans.server.AppDataCollectionRsp;
import com.huawei.openalliance.p169ad.beans.server.ConsentConfigReq;
import com.huawei.openalliance.p169ad.beans.server.ConsentConfigRsp;
import com.huawei.openalliance.p169ad.beans.server.EventReportReq;
import com.huawei.openalliance.p169ad.beans.server.EventReportRsp;
import com.huawei.openalliance.p169ad.beans.server.PermissionReq;
import com.huawei.openalliance.p169ad.beans.server.PermissionRsp;
import com.huawei.openalliance.p169ad.beans.server.ThirdReportRsp;
import com.huawei.openalliance.p169ad.beans.tags.TagCfgModel;
import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.constant.TagKey;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.SearchTerm;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.net.http.C7502e;
import com.huawei.openalliance.p169ad.net.http.Response;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7791ck;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7733ag;
import com.huawei.openalliance.p169ad.utils.C7735ai;
import com.huawei.openalliance.p169ad.utils.C7757bd;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import com.huawei.openalliance.p169ad.utils.C7790cj;
import com.huawei.openalliance.p169ad.utils.C7798cr;
import com.huawei.openalliance.p169ad.utils.C7823dp;
import com.huawei.openalliance.p169ad.utils.C7828g;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import p277f4.C9655a;

/* renamed from: com.huawei.openalliance.ad.fb */
/* loaded from: classes8.dex */
public class C7118fb implements InterfaceC7140fx {

    /* renamed from: a */
    static final Map<Integer, Integer> f32775a;

    /* renamed from: b */
    private static InterfaceC7140fx f32776b;

    /* renamed from: c */
    private static final byte[] f32777c = new byte[0];

    /* renamed from: d */
    private Context f32778d;

    /* renamed from: e */
    private InterfaceC7146gc f32779e;

    /* renamed from: f */
    private InterfaceC7144ga f32780f;

    /* renamed from: g */
    private InterfaceC7347ju f32781g;

    /* renamed from: h */
    private InterfaceC7349jw f32782h;

    /* renamed from: i */
    private int f32783i;

    /* renamed from: j */
    private boolean f32784j;

    /* renamed from: k */
    private int f32785k;

    /* renamed from: l */
    private final byte[] f32786l = new byte[0];

    /* renamed from: m */
    private final byte[] f32787m = new byte[0];

    /* renamed from: n */
    private final byte[] f32788n = new byte[0];

    /* renamed from: o */
    private final byte[] f32789o = new byte[0];

    /* renamed from: p */
    private InterfaceC7348jv f32790p;

    /* renamed from: q */
    private InterfaceC7151gh f32791q;

    /* renamed from: com.huawei.openalliance.ad.fb$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f32792a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7798cr.m48109a(context);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.fb$2 */
    public class AnonymousClass2 implements RemoteCallResultCallback<String> {

        /* renamed from: a */
        final /* synthetic */ Response f32794a;

        /* renamed from: b */
        final /* synthetic */ CountDownLatch f32795b;

        /* renamed from: c */
        final /* synthetic */ AtomicBoolean f32796c;

        /* renamed from: d */
        final /* synthetic */ AdContentReq f32797d;

        /* renamed from: com.huawei.openalliance.ad.fb$2$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.get()) {
                    return;
                }
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                Response responseM43235b = C7118fb.this.m43235b(adContentReq);
                if (responseM43235b != null) {
                    synchronized (response) {
                        response.m45982a(responseM43235b);
                        response.m45983a((Response) responseM43235b.m45987b());
                    }
                }
                countDownLatch.countDown();
            }
        }

        public AnonymousClass2(Response response, CountDownLatch countDownLatch, AtomicBoolean atomicBoolean, AdContentReq adContentReq) {
            response = response;
            countDownLatch = countDownLatch;
            atomicBoolean = atomicBoolean;
            adContentReq = adContentReq;
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x0065 A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #0 {all -> 0x0062, blocks: (B:30:0x0004, B:32:0x000c, B:35:0x001e, B:39:0x0049, B:43:0x0065), top: B:48:0x0004 }] */
        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onRemoteCallResult(java.lang.String r5, com.huawei.openalliance.p169ad.ipc.CallResult<java.lang.String> r6) {
            /*
                r4 = this;
                java.lang.String r5 = "NetHandler"
                if (r6 == 0) goto L65
                int r0 = r6.getCode()     // Catch: java.lang.Throwable -> L62
                r1 = 200(0xc8, float:2.8E-43)
                if (r0 != r1) goto L65
                java.lang.String r0 = "recall ads from hms success"
                com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r5, r0)     // Catch: java.lang.Throwable -> L62
                java.lang.Object r6 = r6.getData()     // Catch: java.lang.Throwable -> L62
                java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L62
                boolean r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48165b(r6)     // Catch: java.lang.Throwable -> L62
                if (r0 == 0) goto L1e
                return
            L1e:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L62
                r0.<init>(r6)     // Catch: java.lang.Throwable -> L62
                java.lang.String r6 = "adRspStr"
                java.lang.String r6 = r0.optString(r6)     // Catch: java.lang.Throwable -> L62
                java.lang.Class<com.huawei.openalliance.ad.beans.server.AdContentRsp> r1 = com.huawei.openalliance.p169ad.beans.server.AdContentRsp.class
                r2 = 0
                java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L62
                java.lang.Object r6 = com.huawei.openalliance.p169ad.utils.AbstractC7758be.m47739b(r6, r1, r3)     // Catch: java.lang.Throwable -> L62
                com.huawei.openalliance.ad.beans.server.AdContentRsp r6 = (com.huawei.openalliance.p169ad.beans.server.AdContentRsp) r6     // Catch: java.lang.Throwable -> L62
                java.lang.String r1 = "rspStr"
                java.lang.String r0 = r0.optString(r1)     // Catch: java.lang.Throwable -> L62
                java.lang.Class<com.huawei.openalliance.ad.net.http.Response> r1 = com.huawei.openalliance.p169ad.net.http.Response.class
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L62
                java.lang.Object r0 = com.huawei.openalliance.p169ad.utils.AbstractC7758be.m47739b(r0, r1, r2)     // Catch: java.lang.Throwable -> L62
                com.huawei.openalliance.ad.net.http.Response r0 = (com.huawei.openalliance.p169ad.net.http.Response) r0     // Catch: java.lang.Throwable -> L62
                if (r6 == 0) goto L64
                if (r0 != 0) goto L49
                goto L64
            L49:
                com.huawei.openalliance.ad.net.http.Response r1 = r2     // Catch: java.lang.Throwable -> L62
                r1.m45982a(r0)     // Catch: java.lang.Throwable -> L62
                com.huawei.openalliance.ad.net.http.Response r1 = r2     // Catch: java.lang.Throwable -> L62
                r1.m45983a(r6)     // Catch: java.lang.Throwable -> L62
                com.huawei.openalliance.ad.net.http.Response r6 = r2     // Catch: java.lang.Throwable -> L62
                long r0 = r0.m46013r()     // Catch: java.lang.Throwable -> L62
                r6.m45998e(r0)     // Catch: java.lang.Throwable -> L62
                java.util.concurrent.CountDownLatch r4 = r3     // Catch: java.lang.Throwable -> L62
                r4.countDown()     // Catch: java.lang.Throwable -> L62
                goto L7f
            L62:
                r4 = move-exception
                goto L6e
            L64:
                return
            L65:
                com.huawei.openalliance.ad.fb$2$1 r6 = new com.huawei.openalliance.ad.fb$2$1     // Catch: java.lang.Throwable -> L62
                r6.<init>()     // Catch: java.lang.Throwable -> L62
                com.huawei.openalliance.p169ad.utils.AbstractC7834m.m48481b(r6)     // Catch: java.lang.Throwable -> L62
                goto L7f
            L6e:
                java.lang.Class r4 = r4.getClass()
                java.lang.String r4 = r4.getSimpleName()
                java.lang.Object[] r4 = new java.lang.Object[]{r4}
                java.lang.String r6 = "parse ads from hms rec engine error: %s"
                com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r5, r6, r4)
            L7f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7118fb.AnonymousClass2.onRemoteCallResult(java.lang.String, com.huawei.openalliance.ad.ipc.CallResult):void");
        }
    }

    /* renamed from: com.huawei.openalliance.ad.fb$3 */
    public class AnonymousClass3 implements RemoteCallResultCallback<String> {

        /* renamed from: a */
        final /* synthetic */ Response f32800a;

        /* renamed from: b */
        final /* synthetic */ AdContentRsp f32801b;

        /* renamed from: c */
        final /* synthetic */ CountDownLatch f32802c;

        public AnonymousClass3(Response response, AdContentRsp adContentRsp, CountDownLatch countDownLatch) {
            response = response;
            adContentRsp = adContentRsp;
            countDownLatch = countDownLatch;
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x0057 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:30:0x0004, B:32:0x000c, B:35:0x001e, B:39:0x0049, B:44:0x005e, B:43:0x0057), top: B:48:0x0004 }] */
        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onRemoteCallResult(java.lang.String r5, com.huawei.openalliance.p169ad.ipc.CallResult<java.lang.String> r6) {
            /*
                r4 = this;
                java.lang.String r5 = "NetHandler"
                if (r6 == 0) goto L57
                int r0 = r6.getCode()     // Catch: java.lang.Throwable -> L54
                r1 = 200(0xc8, float:2.8E-43)
                if (r0 != r1) goto L57
                java.lang.String r0 = "recall api ads from hms success"
                com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r5, r0)     // Catch: java.lang.Throwable -> L54
                java.lang.Object r6 = r6.getData()     // Catch: java.lang.Throwable -> L54
                java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L54
                boolean r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48165b(r6)     // Catch: java.lang.Throwable -> L54
                if (r0 == 0) goto L1e
                return
            L1e:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L54
                r0.<init>(r6)     // Catch: java.lang.Throwable -> L54
                java.lang.String r6 = "adRspStr"
                java.lang.String r6 = r0.optString(r6)     // Catch: java.lang.Throwable -> L54
                java.lang.Class<com.huawei.openalliance.ad.beans.server.AdContentRsp> r1 = com.huawei.openalliance.p169ad.beans.server.AdContentRsp.class
                r2 = 0
                java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L54
                java.lang.Object r6 = com.huawei.openalliance.p169ad.utils.AbstractC7758be.m47739b(r6, r1, r3)     // Catch: java.lang.Throwable -> L54
                com.huawei.openalliance.ad.beans.server.AdContentRsp r6 = (com.huawei.openalliance.p169ad.beans.server.AdContentRsp) r6     // Catch: java.lang.Throwable -> L54
                java.lang.String r1 = "rspStr"
                java.lang.String r0 = r0.optString(r1)     // Catch: java.lang.Throwable -> L54
                java.lang.Class<com.huawei.openalliance.ad.net.http.Response> r1 = com.huawei.openalliance.p169ad.net.http.Response.class
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L54
                java.lang.Object r0 = com.huawei.openalliance.p169ad.utils.AbstractC7758be.m47739b(r0, r1, r2)     // Catch: java.lang.Throwable -> L54
                com.huawei.openalliance.ad.net.http.Response r0 = (com.huawei.openalliance.p169ad.net.http.Response) r0     // Catch: java.lang.Throwable -> L54
                if (r6 == 0) goto L56
                if (r0 != 0) goto L49
                goto L56
            L49:
                com.huawei.openalliance.ad.net.http.Response r1 = r2     // Catch: java.lang.Throwable -> L54
                r1.m45982a(r0)     // Catch: java.lang.Throwable -> L54
                com.huawei.openalliance.ad.net.http.Response r0 = r2     // Catch: java.lang.Throwable -> L54
                r0.m45983a(r6)     // Catch: java.lang.Throwable -> L54
                goto L5e
            L54:
                r4 = move-exception
                goto L64
            L56:
                return
            L57:
                com.huawei.openalliance.ad.net.http.Response r6 = r2     // Catch: java.lang.Throwable -> L54
                com.huawei.openalliance.ad.beans.server.AdContentRsp r0 = r3     // Catch: java.lang.Throwable -> L54
                r6.m45983a(r0)     // Catch: java.lang.Throwable -> L54
            L5e:
                java.util.concurrent.CountDownLatch r4 = r4     // Catch: java.lang.Throwable -> L54
                r4.countDown()     // Catch: java.lang.Throwable -> L54
                goto L75
            L64:
                java.lang.Class r4 = r4.getClass()
                java.lang.String r4 = r4.getSimpleName()
                java.lang.Object[] r4 = new java.lang.Object[]{r4}
                java.lang.String r6 = "parse ads from hms rec engine error: %s"
                com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r5, r6, r4)
            L75:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7118fb.AnonymousClass3.onRemoteCallResult(java.lang.String, com.huawei.openalliance.ad.ipc.CallResult):void");
        }
    }

    /* renamed from: com.huawei.openalliance.ad.fb$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f32804a;

        public AnonymousClass4(List list) {
            list = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7019dh.m41937a(C7118fb.this.f32778d, Constants.NORMAL_CACHE).m41961a(list, true);
            C7019dh.m41937a(C7118fb.this.f32778d, Constants.AR_CACHE).m41961a(list, true);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.fb$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdContentReq f32806a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f32807b;

        public AnonymousClass5(AdContentReq adContentReq, C7787cg c7787cg) {
            adContentReq = adContentReq;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Long lM48564g;
            Long lM48568h;
            HashMap map = new HashMap();
            try {
                Device deviceM40801i = adContentReq.m40801i();
                int iMo43026D = C7118fb.this.f32779e.mo43026D();
                map.put(TagKey.HW_D001, AbstractC7807d.m48263z(C7118fb.this.f32778d));
                map.put(TagKey.HW_D002, AbstractC7807d.m48262y(C7118fb.this.f32778d));
                if (deviceM40801i != null) {
                    lM48564g = deviceM40801i.m40086H();
                    lM48568h = deviceM40801i.m40088J();
                } else {
                    lM48564g = C7845x.m48564g(C7118fb.this.f32778d, iMo43026D);
                    lM48568h = C7845x.m48568h(C7118fb.this.f32778d, iMo43026D);
                }
                if (lM48564g != null) {
                    map.put(TagKey.HW_D003, Long.toString(lM48564g.longValue()));
                }
                if (lM48568h != null) {
                    map.put(TagKey.HW_D004, Long.toString(lM48568h.longValue()));
                }
                Integer numM48589o = C7845x.m48589o(C7118fb.this.f32778d, iMo43026D);
                if (numM48589o != null) {
                    map.put(TagKey.HW_D005, Integer.toString(numM48589o.intValue()));
                }
                Integer numM48592p = C7845x.m48592p(C7118fb.this.f32778d, iMo43026D);
                if (numM48592p != null) {
                    map.put(TagKey.HW_D006, Integer.toString(numM48592p.intValue()));
                }
                map.put(TagKey.HW_D007, C7845x.m48580l(C7118fb.this.f32778d, iMo43026D));
                String strM47941T = C7787cg.m47900a(C7118fb.this.f32778d).m47941T();
                if (!AbstractC7806cz.m48165b(strM47941T)) {
                    map.put(TagKey.HW_U001, strM47941T);
                }
                map.put(TagKey.HW_U002, C7845x.m48562f(C7118fb.this.f32778d) ? "1" : "0");
                map.put(TagKey.HW_M001, Integer.toString(C7762bi.m47779a(C7118fb.this.f32778d).m39413c()));
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("NetHandler", "config tag error:%s", th2.getClass().getSimpleName());
            }
            c7787cg.m47956a(map);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.fb$6 */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdTimeStatistics f32809a;

        /* renamed from: b */
        final /* synthetic */ int f32810b;

        /* renamed from: c */
        final /* synthetic */ String f32811c;

        /* renamed from: d */
        final /* synthetic */ int f32812d;

        /* renamed from: e */
        final /* synthetic */ long f32813e;

        /* renamed from: f */
        final /* synthetic */ boolean f32814f;

        /* renamed from: g */
        final /* synthetic */ Response f32815g;

        /* renamed from: h */
        final /* synthetic */ int f32816h;

        /* renamed from: i */
        final /* synthetic */ String f32817i;

        public AnonymousClass6(AdTimeStatistics adTimeStatistics, int i10, String str, int i11, long j10, boolean z10, Response response, int i12, String str2) {
            adTimeStatistics = adTimeStatistics;
            i = i10;
            str = str;
            i = i11;
            j = j10;
            z = z10;
            response = response;
            i = i12;
            str = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C6927h c6927h = new C6927h(C7118fb.this.f32778d);
            String strM47742b = AbstractC7758be.m47742b(adTimeStatistics);
            if (C7118fb.this.m43228a(i)) {
                c6927h.m39182a(str, i, i, j, z, response, strM47742b);
            } else {
                c6927h.m39184a(str, i, i, str, i, j, z, response);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.fb$7 */
    public class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C7653sb f32819a;

        public AnonymousClass7(C7653sb c7653sb) {
            c7653sb = c7653sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            new C6922c(C7118fb.this.f32778d).mo39084a(c7653sb);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.fb$8 */
    public class AnonymousClass8 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f32821a;

        /* renamed from: b */
        final /* synthetic */ List f32822b;

        /* renamed from: c */
        final /* synthetic */ Map f32823c;

        /* renamed from: d */
        final /* synthetic */ String f32824d;

        public AnonymousClass8(List list, List list2, Map map, String str) {
            list = list;
            list = list2;
            map = map;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractC7760bg.m47767a(list) || AbstractC7760bg.m47767a(list) || C7765bl.m47802a(map)) {
                return;
            }
            new C6922c(C7118fb.this.f32778d).mo39109a(C7118fb.this.f32778d.getPackageName(), list, list, map, str);
        }
    }

    static {
        HashMap map = new HashMap();
        f32775a = map;
        map.put(3, Integer.valueOf(Constants.NATIVE_TEMPLATE_MIN_VER));
        map.put(9, Integer.valueOf(Constants.ICON_TEMPLATE_MIN_VER));
        map.put(7, Integer.valueOf(Constants.REWARD_TEMPLATE_MIN_VER));
        map.put(12, Integer.valueOf(Constants.INTERSTITIAL_TEMPLATE_MIN_VER));
    }

    private C7118fb(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f32778d = applicationContext;
        this.f32779e = C7124fh.m43316b(context);
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.fb.1

            /* renamed from: a */
            final /* synthetic */ Context f32792a;

            public AnonymousClass1(Context applicationContext2) {
                context = applicationContext2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7798cr.m48109a(context);
            }
        });
        this.f32791q = C7131fo.m43547a(context);
    }

    /* renamed from: b */
    private int m43231b(Device device) {
        if (!m43246c(device)) {
            return 9;
        }
        if (this.f32779e.mo43058af()) {
            return 1 == AbstractC7807d.m48254q(this.f32778d) ? 6 : 0;
        }
        return 7;
    }

    /* renamed from: c */
    private int m43240c(AdContentReq adContentReq) {
        if (!AbstractC7791ck.m48066a("com.google.flatbuffers.FlatBufferBuilder")) {
            AbstractC7185ho.m43820b("NetHandler", "fb sdk not available.");
            return 0;
        }
        if (adContentReq == null || AbstractC7760bg.m47767a(adContentReq.m40803k())) {
            return 0;
        }
        boolean z10 = false;
        for (AdSlot30 adSlot30 : adContentReq.m40803k()) {
            if (adSlot30 != null && !TextUtils.isEmpty(adSlot30.m39502a())) {
                int iMo43315d = C7123fg.m43308a(this.f32778d).mo43315d(adSlot30.m39502a());
                if (1 == iMo43315d) {
                    return 1;
                }
                if (2 == iMo43315d) {
                    z10 = true;
                }
            }
        }
        return z10 ? 2 : 0;
    }

    /* renamed from: d */
    private AdContentRsp m43248d(int i10, List<String> list, AdContentRsp adContentRsp) {
        AdContentRsp adContentRspM43195a;
        if (AbstractC7760bg.m47767a(list) || adContentRsp == null || !C7790cj.m48048a(this.f32778d, list, adContentRsp) || (adContentRspM43195a = m43195a(i10, list, adContentRsp)) == null) {
            return adContentRsp;
        }
        adContentRspM43195a.m40843f(1);
        return adContentRspM43195a;
    }

    /* renamed from: e */
    private AppConfigReq m43255e(String str) {
        AppConfigReq appConfigReq = new AppConfigReq(str);
        Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(this.f32778d, true);
        if (pairM48217b != null) {
            appConfigReq.m40867b((String) pairM48217b.first);
        }
        m43220a(appConfigReq);
        appConfigReq.m40865a(this.f32779e.mo43349aP());
        appConfigReq.m40869c(AbstractC7807d.m48241h(this.f32778d));
        appConfigReq.m40870d(C6982bz.m41148a(this.f32778d).mo41186o());
        appConfigReq.m40871e(String.valueOf(30476300));
        App app = new App();
        app.m39703b(this.f32778d.getPackageName());
        app.m39711f(C7845x.m48535a(this.f32778d, app.m39704c()));
        app.m39699a(HiAd.m44014a(this.f32778d).mo44057j());
        appConfigReq.m40863a(app);
        Device device = new Device();
        device.m40106a(this.f32778d);
        m43212a(device);
        appConfigReq.m40864a(device);
        C7122ff c7122ffM43303a = C7122ff.m43303a(this.f32778d);
        appConfigReq.m40873g(c7122ffM43303a.m43306a(this.f32778d.getPackageName()));
        AbstractC7185ho.m43818a("NetHandler", "sha256 query from databases, sha256 is %s", c7122ffM43303a.m43306a(this.f32778d.getPackageName()));
        if (!AbstractC7806cz.m48165b(C7084e.m42836a())) {
            appConfigReq.m40866a(C7128fl.m43510a(this.f32778d).mo43523a());
            appConfigReq.m40874h(C7084e.m42836a());
        }
        appConfigReq.m40868b(C7128fl.m43510a(this.f32778d).mo43528b());
        return appConfigReq;
    }

    /* renamed from: f */
    private List<String> m43260f(List<CachedContent> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<CachedContent> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m40521a());
        }
        return arrayList;
    }

    /* renamed from: g */
    private InterfaceC7348jv m43264g() {
        InterfaceC7348jv interfaceC7348jv;
        synchronized (this.f32788n) {
            try {
                if (this.f32790p == null || this.f32783i != this.f32779e.mo43406bg()) {
                    this.f32783i = this.f32779e.mo43406bg();
                    m43262f();
                }
                interfaceC7348jv = this.f32790p;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7348jv;
    }

    /* renamed from: h */
    private EventReportRsp m43267h(List<AdEvent> list) {
        String str;
        if (list == null || list.isEmpty()) {
            AbstractC7185ho.m43823c("NetHandler", "fail to upload cache events, events is empty");
            return null;
        }
        AnalysisReportReq analysisReportReq = new AnalysisReportReq(list);
        try {
            Map<String, String> mapM43205a = m43205a(analysisReportReq);
            C7351jy.m45435a(mapM43205a);
            Response<EventReportRsp> responseM45415a = m43243c().m45415a(analysisReportReq, mapM43205a);
            if (responseM45415a != null) {
                EventReportRsp eventReportRspM45987b = responseM45415a.m45987b();
                if (eventReportRspM45987b != null) {
                    eventReportRspM45987b.responseCode = responseM45415a.m45977a() == 200 ? 0 : 1;
                }
                return eventReportRspM45987b;
            }
        } catch (IllegalArgumentException unused) {
            str = "uploadEvents IllegalArgumentException";
            AbstractC7185ho.m43823c("NetHandler", str);
            return null;
        } catch (Exception unused2) {
            str = "uploadEvents Exception";
            AbstractC7185ho.m43823c("NetHandler", str);
            return null;
        }
        return null;
    }

    /* renamed from: a */
    private AdSlot30 m43192a(int i10, AdSlotParam adSlotParam, Map<String, Bundle> map, String str) {
        AdSlot30 adSlot30 = new AdSlot30(str, adSlotParam.m40650e(), adSlotParam.m40653f(), i10, adSlotParam.m40646c());
        int iM40660m = adSlotParam.m40660m();
        if (iM40660m > 0) {
            adSlot30.m39505a(Integer.valueOf(iM40660m));
        }
        int iM40661n = adSlotParam.m40661n();
        if (iM40661n > 0) {
            adSlot30.m39516d(Integer.valueOf(iM40661n));
        }
        List<String> listM40669v = adSlotParam.m40669v();
        if (!AbstractC7760bg.m47767a(listM40669v)) {
            adSlot30.m39511b(listM40669v);
        }
        if (1 == i10 || 18 == i10) {
            Integer numM40665r = adSlotParam.m40665r();
            if (numM40665r != null) {
                adSlot30.m39522f(numM40665r);
            }
            Integer numM40664q = adSlotParam.m40664q();
            if (numM40664q != null) {
                adSlot30.m39519e(numM40664q);
            }
            int iM40639b = adSlotParam.m40639b();
            if (iM40639b == 1 || iM40639b == 0) {
                adSlot30.m39524g(Integer.valueOf(iM40639b));
            }
        }
        adSlot30.m39528i(adSlotParam.m40671x());
        adSlot30.m39530j(adSlotParam.m40672y());
        adSlot30.m39532k(adSlotParam.m40673z());
        adSlot30.m39509b(adSlotParam.m40662o());
        adSlot30.m39513c(adSlotParam.m40663p());
        if (!C7765bl.m47802a(map)) {
            adSlot30.m39507a(m43202a(map.get(str)));
        }
        adSlot30.m39526h(adSlotParam.m40667t());
        if (i10 == 1) {
            m43209a(i10, adSlotParam, str, adSlot30);
        }
        if (C7757bd.m47714a(adSlotParam.m40619C()) && 7 != i10) {
            m43224a(str, adSlotParam, adSlot30, i10);
        } else if (!AbstractC7806cz.m48165b(C7084e.m42836a())) {
            m43225a(str, adSlotParam, adSlot30, i10, C7084e.m42836a());
        }
        m43214a(adSlotParam, adSlot30, str);
        return adSlot30;
    }

    /* renamed from: c */
    private AdContentReq m43241c(AdRequestParam adRequestParam) throws NumberFormatException {
        Integer numM43250d;
        boolean z10;
        List<String> listM40725e;
        Integer num;
        Map<String, Bundle> map;
        Integer num2;
        SearchInfo searchInfo;
        String str;
        String str2;
        Integer num3;
        Integer num4;
        String str3;
        String str4;
        AbstractC7185ho.m43820b("NetHandler", "prep req info");
        AdSlotParam adSlotParamM39337b = adRequestParam.m39337b();
        boolean z11 = false;
        if (m43259e() || C6982bz.m41149a()) {
            adSlotParamM39337b.m40641b((Integer) 0);
        }
        RequestOptions requestOptionsM40659l = adSlotParamM39337b.m40659l();
        Options optionsM43194a = m43194a(requestOptionsM40659l);
        if (requestOptionsM40659l != null) {
            if (requestOptionsM40659l.getTagForUnderAgeOfPromise() != null && requestOptionsM40659l.getTagForUnderAgeOfPromise().intValue() == 1) {
                z11 = true;
            }
            numM43250d = m43250d(requestOptionsM40659l);
            Integer numM43245c = m43245c(requestOptionsM40659l);
            Integer numM40722b = requestOptionsM40659l.m40722b();
            Integer numM40723c = requestOptionsM40659l.m40723c();
            String consent = requestOptionsM40659l.getConsent();
            String appLang = requestOptionsM40659l.getAppLang();
            String appCountry = requestOptionsM40659l.getAppCountry();
            String searchTerm = requestOptionsM40659l.getSearchTerm();
            Map<String, Bundle> extras = requestOptionsM40659l.getExtras();
            SearchInfo searchInfoM40726f = requestOptionsM40659l.m40726f();
            Integer tMax = requestOptionsM40659l.getTMax();
            listM40725e = requestOptionsM40659l.m40725e();
            if (TextUtils.isEmpty(consent)) {
                consent = this.f32779e.mo43360ar();
            }
            str4 = appCountry;
            str = searchTerm;
            str2 = consent;
            num2 = tMax;
            str3 = appLang;
            searchInfo = searchInfoM40726f;
            num4 = numM40722b;
            map = extras;
            num3 = numM40723c;
            z10 = z11;
            num = numM43245c;
        } else {
            numM43250d = null;
            z10 = false;
            listM40725e = null;
            num = null;
            map = null;
            num2 = null;
            searchInfo = null;
            str = null;
            str2 = null;
            num3 = null;
            num4 = null;
            str3 = null;
            str4 = null;
        }
        int iM39333a = adRequestParam.m39333a();
        boolean z12 = z10;
        ArrayList arrayList = new ArrayList(4);
        m43210a(iM39333a, adSlotParamM39337b, arrayList, map);
        int[] iArrM45349b = C7340jn.m45349b();
        String strM39342g = adRequestParam.m39342g();
        List<String> listM39338c = adRequestParam.m39338c();
        List<String> listM39339d = adRequestParam.m39339d();
        List<String> listM39340e = adRequestParam.m39340e();
        List<String> list = listM40725e;
        Integer num5 = num2;
        SearchInfo searchInfo2 = searchInfo;
        String str5 = str;
        String str6 = str2;
        Integer num6 = num3;
        Integer num7 = num4;
        AdContentReq adContentReq = new AdContentReq(this.f32778d, arrayList, listM39338c, listM39339d, listM39340e, adSlotParamM39337b, this.f32779e.mo43345aL());
        adContentReq.m40775a(iArrM45349b);
        if (optionsM43194a.m40378d()) {
            adContentReq.m40769a(optionsM43194a);
        }
        if (C7757bd.m47713a(adSlotParamM39337b) && !TextUtils.isEmpty(adSlotParamM39337b.m40618B())) {
            adContentReq.m40794f(adSlotParamM39337b.m40618B());
        }
        Location locationM40658k = adSlotParamM39337b.m40658k();
        if (locationM40658k != null && locationM40658k.m40242h()) {
            locationM40658k.m40231a(System.currentTimeMillis());
            adContentReq.m40768a(locationM40658k);
        }
        if (!TextUtils.isEmpty(str5)) {
            adContentReq.m40770a(new SearchTerm(str5));
        }
        if (searchInfo2 != null) {
            adContentReq.m40766a(searchInfo2);
        }
        adContentReq.m40777b(numM43250d);
        adContentReq.m40771a(num);
        adContentReq.m40781c(num7);
        adContentReq.m40785d(num6);
        adContentReq.m40790e(this.f32779e.mo43362at());
        adContentReq.m40786d(this.f32779e.mo43361as());
        adContentReq.m40782c(str6);
        adContentReq.m40799h(num5);
        adContentReq.m40791e(list);
        m43193a(iM39333a, adSlotParamM39337b, str3, str4, adContentReq);
        m43216a(adSlotParamM39337b, num, z12, adContentReq);
        adContentReq.m40776b(!this.f32779e.mo43346aM() ? 1 : 0);
        adContentReq.m40772a(this.f32779e.mo43350aQ());
        adContentReq.m40765a(adSlotParamM39337b.m40657j() ? 2 : 1);
        if (adSlotParamM39337b.m40657j()) {
            adContentReq.m40789e((Integer) 1);
        }
        m43215a(adSlotParamM39337b, adContentReq);
        adContentReq.m40774a(m43261f(adContentReq));
        adContentReq.m40793f(adSlotParamM39337b.m40619C());
        if (!C7845x.m48576j(this.f32778d)) {
            m43253d(adContentReq);
            m43218a(adContentReq, strM39342g);
        }
        if (adSlotParamM39337b.m40619C() != null) {
            adContentReq.m40793f(adSlotParamM39337b.m40619C());
        }
        return adContentReq;
    }

    /* renamed from: d */
    private InterfaceC7349jw m43249d() {
        InterfaceC7349jw interfaceC7349jw;
        synchronized (this.f32787m) {
            try {
                if (this.f32782h == null || this.f32785k != this.f32779e.mo43407bh()) {
                    this.f32785k = this.f32779e.mo43407bh();
                    m43208a();
                }
                interfaceC7349jw = this.f32782h;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7349jw;
    }

    /* renamed from: e */
    private Map<String, List<String>> m43256e(List<CachedContent> list) {
        HashMap map = new HashMap();
        if (AbstractC7760bg.m47767a(list)) {
            return map;
        }
        for (CachedContent cachedContent : list) {
            if (cachedContent != null) {
                map.put(cachedContent.m40521a(), cachedContent.m40523c());
            }
        }
        return map;
    }

    /* renamed from: f */
    private Map<String, String> m43261f(AdContentReq adContentReq) {
        if (C7845x.m48576j(this.f32778d)) {
            return null;
        }
        C7787cg c7787cgM47900a = C7787cg.m47900a(this.f32778d);
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.fb.5

            /* renamed from: a */
            final /* synthetic */ AdContentReq f32806a;

            /* renamed from: b */
            final /* synthetic */ C7787cg f32807b;

            public AnonymousClass5(AdContentReq adContentReq2, C7787cg c7787cgM47900a2) {
                adContentReq = adContentReq2;
                c7787cg = c7787cgM47900a2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Long lM48564g;
                Long lM48568h;
                HashMap map = new HashMap();
                try {
                    Device deviceM40801i = adContentReq.m40801i();
                    int iMo43026D = C7118fb.this.f32779e.mo43026D();
                    map.put(TagKey.HW_D001, AbstractC7807d.m48263z(C7118fb.this.f32778d));
                    map.put(TagKey.HW_D002, AbstractC7807d.m48262y(C7118fb.this.f32778d));
                    if (deviceM40801i != null) {
                        lM48564g = deviceM40801i.m40086H();
                        lM48568h = deviceM40801i.m40088J();
                    } else {
                        lM48564g = C7845x.m48564g(C7118fb.this.f32778d, iMo43026D);
                        lM48568h = C7845x.m48568h(C7118fb.this.f32778d, iMo43026D);
                    }
                    if (lM48564g != null) {
                        map.put(TagKey.HW_D003, Long.toString(lM48564g.longValue()));
                    }
                    if (lM48568h != null) {
                        map.put(TagKey.HW_D004, Long.toString(lM48568h.longValue()));
                    }
                    Integer numM48589o = C7845x.m48589o(C7118fb.this.f32778d, iMo43026D);
                    if (numM48589o != null) {
                        map.put(TagKey.HW_D005, Integer.toString(numM48589o.intValue()));
                    }
                    Integer numM48592p = C7845x.m48592p(C7118fb.this.f32778d, iMo43026D);
                    if (numM48592p != null) {
                        map.put(TagKey.HW_D006, Integer.toString(numM48592p.intValue()));
                    }
                    map.put(TagKey.HW_D007, C7845x.m48580l(C7118fb.this.f32778d, iMo43026D));
                    String strM47941T = C7787cg.m47900a(C7118fb.this.f32778d).m47941T();
                    if (!AbstractC7806cz.m48165b(strM47941T)) {
                        map.put(TagKey.HW_U001, strM47941T);
                    }
                    map.put(TagKey.HW_U002, C7845x.m48562f(C7118fb.this.f32778d) ? "1" : "0");
                    map.put(TagKey.HW_M001, Integer.toString(C7762bi.m47779a(C7118fb.this.f32778d).m39413c()));
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("NetHandler", "config tag error:%s", th2.getClass().getSimpleName());
                }
                c7787cg.m47956a(map);
            }
        });
        return c7787cgM47900a2.m47958aa();
    }

    /* renamed from: g */
    private List<AdEvent> m43265g(List<AdEvent> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdEvent> it = list.iterator();
        while (it.hasNext()) {
            AdEvent next = it.next();
            if (EventType.ANALYSIS.value().equals(next.m39437a())) {
                it.remove();
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: b */
    public AdContentReq mo43277b(AdRequestParam adRequestParam) throws NumberFormatException {
        AdContentReq adContentReqM43241c = m43241c(adRequestParam);
        if (adContentReqM43241c.m40803k().isEmpty()) {
            adContentReqM43241c.m40773a((List<AdSlot30>) null);
        }
        return adContentReqM43241c;
    }

    /* renamed from: a */
    private App m43193a(int i10, AdSlotParam adSlotParam, String str, String str2, AdContentReq adContentReq) {
        App appM40656i = adSlotParam.m40656i();
        if (appM40656i != null) {
            adContentReq.m40767a(appM40656i);
        }
        App appM40798h = adContentReq.m40798h();
        if (appM40798h != null) {
            if (!TextUtils.isEmpty(str)) {
                appM40798h.m39707d(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                appM40798h.m39709e(str2);
            }
            String strM40626a = adSlotParam.m40626a(this.f32778d, i10);
            if (AbstractC7806cz.m48165b(appM40798h.m39706d())) {
                appM40798h.m39705c(strM40626a);
            }
            LocationSwitches locationSwitchesM40668u = adSlotParam.m40668u();
            if (locationSwitchesM40668u != null) {
                appM40798h.m39702b(Integer.valueOf(locationSwitchesM40668u.m39413c()));
            }
            RequestOptions requestOptionsM40659l = adSlotParam.m40659l();
            AppExt appExt = new AppExt();
            appExt.m39860a(m43237b(requestOptionsM40659l));
            appM40798h.m39698a(appExt);
        } else {
            AbstractC7185ho.m43823c("NetHandler", "req.getApp__() is null and can't set lang or country");
        }
        return appM40798h;
    }

    /* renamed from: b */
    private AdContentRsp m43232b(int i10, List<String> list, AdContentRsp adContentRsp) {
        AbstractC7185ho.m43820b("NetHandler", "api request ads from sdk rec engine");
        int iMo43080n = C7124fh.m43316b(this.f32778d).mo43080n();
        List<String> listAsList = Arrays.asList(C7790cj.m48050a(this.f32778d, String.valueOf(i10)));
        C9655a c9655a = new C9655a(this.f32778d.getPackageName(), adContentRsp.m40851k(), list, null, i10);
        c9655a.m60316v(Integer.valueOf(iMo43080n));
        c9655a.m60314t(listAsList);
        c9655a.m60315u(this.f32778d.getPackageName());
        JSONObject jSONObjectM12453k = new AdRecommendEngine(this.f32778d).m12453k(c9655a, AbstractC7758be.m47742b(adContentRsp));
        AbstractC7185ho.m43818a("NetHandler", "api request recall result: %s", jSONObjectM12453k);
        AdContentRsp adContentRsp2 = (AdContentRsp) AbstractC7758be.m47719a(this.f32778d, jSONObjectM12453k, AdContentRsp.class, new Class[0]);
        return adContentRsp2 == null ? adContentRsp : adContentRsp2;
    }

    /* renamed from: c */
    private AdContentRsp m43242c(int i10, List<String> list, AdContentRsp adContentRsp) {
        try {
            AbstractC7185ho.m43820b("NetHandler", "api request ads from hms rec engine");
            C7484ms c7484msM45854a = C7484ms.m45854a(this.f32778d);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slotid", AbstractC7758be.m47742b(list));
            jSONObject.put(MapKeyNames.LOCAL_RECALL_MAX_COUNT, this.f32779e.mo43080n());
            jSONObject.put(MapKeyNames.API_RSP, AbstractC7758be.m47742b(adContentRsp));
            jSONObject.put(MapKeyNames.ALLOWED_TRADE_MODES, AbstractC7758be.m47742b(Arrays.asList(C7790cj.m48050a(this.f32778d, String.valueOf(i10)))));
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Response response = new Response();
            c7484msM45854a.m45855a(RTCMethods.RECALL_API_AD_BY_REC_ENGINE, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.fb.3

                /* renamed from: a */
                final /* synthetic */ Response f32800a;

                /* renamed from: b */
                final /* synthetic */ AdContentRsp f32801b;

                /* renamed from: c */
                final /* synthetic */ CountDownLatch f32802c;

                public AnonymousClass3(Response response2, AdContentRsp adContentRsp2, CountDownLatch countDownLatch2) {
                    response = response2;
                    adContentRsp = adContentRsp2;
                    countDownLatch = countDownLatch2;
                }

                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String v10, CallResult<String> v11) {
                    /*
                        this = this;
                        java.lang.String r5 = "NetHandler"
                        if (r6 == 0) goto L57
                        int r0 = r6.getCode()     // Catch: java.lang.Throwable -> L54
                        r1 = 200(0xc8, float:2.8E-43)
                        if (r0 != r1) goto L57
                        java.lang.String r0 = "recall api ads from hms success"
                        com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r5, r0)     // Catch: java.lang.Throwable -> L54
                        java.lang.Object r6 = r6.getData()     // Catch: java.lang.Throwable -> L54
                        java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L54
                        boolean r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48165b(r6)     // Catch: java.lang.Throwable -> L54
                        if (r0 == 0) goto L1e
                        return
                    L1e:
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L54
                        r0.<init>(r6)     // Catch: java.lang.Throwable -> L54
                        java.lang.String r6 = "adRspStr"
                        java.lang.String r6 = r0.optString(r6)     // Catch: java.lang.Throwable -> L54
                        java.lang.Class<com.huawei.openalliance.ad.beans.server.AdContentRsp> r1 = com.huawei.openalliance.p169ad.beans.server.AdContentRsp.class
                        r2 = 0
                        java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L54
                        java.lang.Object r6 = com.huawei.openalliance.p169ad.utils.AbstractC7758be.m47739b(r6, r1, r3)     // Catch: java.lang.Throwable -> L54
                        com.huawei.openalliance.ad.beans.server.AdContentRsp r6 = (com.huawei.openalliance.p169ad.beans.server.AdContentRsp) r6     // Catch: java.lang.Throwable -> L54
                        java.lang.String r1 = "rspStr"
                        java.lang.String r0 = r0.optString(r1)     // Catch: java.lang.Throwable -> L54
                        java.lang.Class<com.huawei.openalliance.ad.net.http.Response> r1 = com.huawei.openalliance.p169ad.net.http.Response.class
                        java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L54
                        java.lang.Object r0 = com.huawei.openalliance.p169ad.utils.AbstractC7758be.m47739b(r0, r1, r2)     // Catch: java.lang.Throwable -> L54
                        com.huawei.openalliance.ad.net.http.Response r0 = (com.huawei.openalliance.p169ad.net.http.Response) r0     // Catch: java.lang.Throwable -> L54
                        if (r6 == 0) goto L56
                        if (r0 != 0) goto L49
                        goto L56
                    L49:
                        com.huawei.openalliance.ad.net.http.Response r1 = r2     // Catch: java.lang.Throwable -> L54
                        r1.m45982a(r0)     // Catch: java.lang.Throwable -> L54
                        com.huawei.openalliance.ad.net.http.Response r0 = r2     // Catch: java.lang.Throwable -> L54
                        r0.m45983a(r6)     // Catch: java.lang.Throwable -> L54
                        goto L5e
                    L54:
                        r4 = move-exception
                        goto L64
                    L56:
                        return
                    L57:
                        com.huawei.openalliance.ad.net.http.Response r6 = r2     // Catch: java.lang.Throwable -> L54
                        com.huawei.openalliance.ad.beans.server.AdContentRsp r0 = r3     // Catch: java.lang.Throwable -> L54
                        r6.m45983a(r0)     // Catch: java.lang.Throwable -> L54
                    L5e:
                        java.util.concurrent.CountDownLatch r4 = r4     // Catch: java.lang.Throwable -> L54
                        r4.countDown()     // Catch: java.lang.Throwable -> L54
                        goto L75
                    L64:
                        java.lang.Class r4 = r4.getClass()
                        java.lang.String r4 = r4.getSimpleName()
                        java.lang.Object[] r4 = new java.lang.Object[]{r4}
                        java.lang.String r6 = "parse ads from hms rec engine error: %s"
                        com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r5, r6, r4)
                    L75:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7118fb.AnonymousClass3.onRemoteCallResult(java.lang.String, com.huawei.openalliance.ad.ipc.CallResult):void");
                }
            }, String.class);
            try {
                AbstractC7185ho.m43818a("NetHandler", "latch result: %s", Boolean.valueOf(countDownLatch2.await(2L, TimeUnit.SECONDS)));
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("NetHandler", "latch " + th2.getClass().getSimpleName());
            }
            return (AdContentRsp) response2.m45987b();
        } catch (Throwable th3) {
            AbstractC7185ho.m43824c("NetHandler", "api request ads from hms rec engine: %s", th3.getClass().getSimpleName());
            return adContentRsp2;
        }
    }

    /* renamed from: d */
    private Integer m43250d(RequestOptions requestOptions) {
        if (requestOptions != null) {
            return requestOptions.getIsQueryUseEnabled();
        }
        return null;
    }

    /* renamed from: e */
    private void m43257e(Device device) {
        C7733ag.a aVarM47474a;
        if (C7733ag.m47475b(this.f32778d) && this.f32779e.mo43345aL() && (aVarM47474a = C7733ag.m47474a(this.f32778d)) != null) {
            device.m40131e(aVarM47474a.m47479a());
            device.m40133f(aVarM47474a.m47480b() ? "0" : "1");
        }
    }

    /* renamed from: f */
    private void m43262f() {
        AbstractC7185ho.m43821b("NetHandler", "createAdServerRequester lib switch: %d", Integer.valueOf(this.f32783i));
        this.f32790p = (InterfaceC7348jv) new C7502e.a(this.f32778d).m46067c(this.f32783i).m46061a(new C7345js()).m46065b(new C7346jt()).m46063a().m46059a(InterfaceC7348jv.class);
    }

    /* renamed from: g */
    private void m43266g(Device device) {
        InterfaceC7139fw interfaceC7139fwM43174a = C7114ey.m43174a(this.f32778d);
        if (interfaceC7139fwM43174a.mo43185d(Constants.INS_APPS_RETURN_CODE) && 200 != interfaceC7139fwM43174a.mo43182c()) {
            m43263f(device);
            return;
        }
        List<String> listM48260w = AbstractC7807d.m48260w(this.f32778d);
        device.m40110a(listM48260w);
        if (AbstractC7760bg.m47767a(listM48260w)) {
            return;
        }
        device.m40126c(Integer.valueOf(AbstractC7807d.m48261x(this.f32778d)));
    }

    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* renamed from: a */
    private Options m43194a(RequestOptions requestOptions) {
        Options options = new Options();
        int iM48254q = AbstractC7807d.m48254q(this.f32778d);
        boolean zBooleanValue = C7787cg.m47900a(this.f32778d).m47963af().booleanValue();
        Boolean boolM47964ag = C7787cg.m47900a(this.f32778d).m47964ag();
        boolean zBooleanValue2 = boolM47964ag.booleanValue();
        ?? r42 = 1;
        r42 = 1;
        if (!zBooleanValue && iM48254q != 1) {
            r42 = 0;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("NetHandler", "actual coppa is %s, tfua is %s", Boolean.valueOf((boolean) r42), boolM47964ag);
        }
        options.m40373a(Integer.valueOf((int) r42));
        options.m40376b(Integer.valueOf(zBooleanValue2 ? 1 : 0));
        if (requestOptions != null) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("NetHandler", "media coppa is %s,tfua is %s", requestOptions.getTagForChildProtection(), requestOptions.getTagForUnderAgeOfPromise());
            }
            if (r42 == 0) {
                options.m40373a(requestOptions.getTagForChildProtection());
            }
            if (!zBooleanValue2) {
                options.m40376b(requestOptions.getTagForUnderAgeOfPromise());
            }
            options.m40374a(requestOptions.m40721a());
        }
        return options;
    }

    /* renamed from: c */
    private InterfaceC7347ju m43243c() {
        InterfaceC7347ju interfaceC7347ju;
        synchronized (this.f32786l) {
            try {
                boolean zM45430a = C7350jx.m45424a(this.f32778d).m45430a();
                if (this.f32781g == null || zM45430a != this.f32784j || this.f32783i != this.f32779e.mo43406bg()) {
                    this.f32783i = this.f32779e.mo43406bg();
                    m43239b();
                }
                interfaceC7347ju = this.f32781g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7347ju;
    }

    /* renamed from: d */
    private List<String> m43251d(List<AdSlot30> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AdSlot30> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m39502a());
        }
        return arrayList;
    }

    /* renamed from: e */
    private void m43258e(AdContentReq adContentReq) {
        App appM40798h;
        if (adContentReq == null || (appM40798h = adContentReq.m40798h()) == null || !AbstractC7806cz.m48165b(appM40798h.m39706d())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ImpEX(Constants.AUTOCONTENT_CONTENT_AUTO, "-"));
        HashMap map = new HashMap();
        map.put("contentBundle", arrayList);
        appM40798h.m39705c(AbstractC7758be.m47742b(map));
    }

    /* renamed from: f */
    private void m43263f(Device device) {
        device.m40110a((List<String>) null);
        device.m40126c((Integer) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: b */
    public AppDataCollectionRsp mo43278b(List<AppCollection> list) {
        String str;
        if (AbstractC7760bg.m47767a(list)) {
            return null;
        }
        AppDataCollectionReq appDataCollectionReq = new AppDataCollectionReq();
        appDataCollectionReq.m40941a(list);
        try {
            Response<AppDataCollectionRsp> responseM45422a = m43264g().m45422a(true, appDataCollectionReq, m43238b(appDataCollectionReq));
            if (responseM45422a != null) {
                return responseM45422a.m45987b();
            }
        } catch (IllegalArgumentException unused) {
            str = "reportAppDataCollection IllegalArgumentException";
            AbstractC7185ho.m43823c("NetHandler", str);
            return null;
        } catch (Exception unused2) {
            str = "reportAppDataCollection Exception";
            AbstractC7185ho.m43823c("NetHandler", str);
            return null;
        }
        return null;
    }

    /* renamed from: a */
    private AdContentRsp m43195a(int i10, List<String> list, AdContentRsp adContentRsp) {
        return m43247c(list) ? m43242c(i10, list, adContentRsp) : C7096el.m42952a(this.f32778d) ? m43232b(i10, list, adContentRsp) : adContentRsp;
    }

    /* renamed from: c */
    private Response m43244c(String str) {
        BufferedInputStream bufferedInputStream;
        InterfaceC7382lb interfaceC7382lbM45466a;
        ByteArrayInputStream byteArrayInputStream;
        int i10;
        Response response = new Response();
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            interfaceC7382lbM45466a = InterfaceC7382lb.a.m45466a(AdContentRsp.class);
            byteArrayInputStream = new ByteArrayInputStream((str == null ? "" : str).getBytes(Charset.defaultCharset()));
            try {
                bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
                i10 = str == null ? -1 : 200;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
        try {
            int iAvailable = bufferedInputStream.available();
            response.m45978a(i10);
            response.m45983a((Response) interfaceC7382lbM45466a.mo45460a(i10, bufferedInputStream, iAvailable, new C7346jt()));
            AbstractC7805cy.m48142a((Closeable) byteArrayInputStream);
        } catch (Throwable th4) {
            th = th4;
            byteArrayInputStream2 = byteArrayInputStream;
            try {
                AbstractC7185ho.m43823c("NetHandler", "fillResponseData error");
                response.m45985a(th);
                AbstractC7805cy.m48142a((Closeable) byteArrayInputStream2);
                AbstractC7805cy.m48142a((Closeable) bufferedInputStream);
                AbstractC7185ho.m43820b("NetHandler", "end request");
                return response;
            } catch (Throwable th5) {
                AbstractC7805cy.m48142a((Closeable) byteArrayInputStream2);
                AbstractC7805cy.m48142a((Closeable) bufferedInputStream);
                AbstractC7185ho.m43820b("NetHandler", "end request");
                throw th5;
            }
        }
        AbstractC7805cy.m48142a((Closeable) bufferedInputStream);
        AbstractC7185ho.m43820b("NetHandler", "end request");
        return response;
    }

    /* renamed from: d */
    private void m43252d(Device device) {
        if (AbstractC7806cz.m48165b(device.m40148p())) {
            return;
        }
        device.m40109a((String) null);
    }

    /* renamed from: e */
    private boolean m43259e() {
        C6982bz.m41152b(this.f32778d);
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: b */
    public ThirdReportRsp mo43279b(String str) {
        String str2;
        if (AbstractC7806cz.m48165b(str)) {
            AbstractC7185ho.m43826d("NetHandler", "fail to report to thirdParty event, thirdParty url is empty");
            return null;
        }
        try {
            Response<String> responseM45423a = m43249d().m45423a(str, this.f32779e.mo43408bi());
            ThirdReportRsp thirdReportRsp = new ThirdReportRsp();
            int iM45977a = responseM45423a.m45977a();
            thirdReportRsp.m40965a(iM45977a);
            thirdReportRsp.responseCode = ((iM45977a >= 200 && iM45977a < 300) || iM45977a == 302 || iM45977a == 301) ? 0 : 1;
            thirdReportRsp.errorReason = responseM45423a.m45995d();
            return thirdReportRsp;
        } catch (IllegalArgumentException unused) {
            str2 = "reportThirdPartyEvent IllegalArgumentException";
            AbstractC7185ho.m43823c("NetHandler", str2);
            return null;
        } catch (Exception unused2) {
            str2 = "reportThirdPartyEvent exception";
            AbstractC7185ho.m43823c("NetHandler", str2);
            return null;
        }
    }

    /* renamed from: b */
    private static InterfaceC7140fx m43233b(Context context) {
        InterfaceC7140fx interfaceC7140fx;
        synchronized (f32777c) {
            try {
                if (f32776b == null) {
                    f32776b = new C7118fb(context);
                }
                interfaceC7140fx = f32776b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7140fx;
    }

    /* renamed from: c */
    private Integer m43245c(RequestOptions requestOptions) {
        Integer npaAccordingToServerConsent;
        Integer nonPersonalizedAd = requestOptions.getNonPersonalizedAd();
        if ((nonPersonalizedAd != null && !requestOptions.m40728h()) || !AbstractC7741ao.m47575e() || (npaAccordingToServerConsent = Consent.getInstance(this.f32778d).getNpaAccordingToServerConsent()) == null) {
            return nonPersonalizedAd;
        }
        AbstractC7185ho.m43821b("NetHandler", "got npa according to server consent: %s", npaAccordingToServerConsent);
        return npaAccordingToServerConsent;
    }

    /* renamed from: d */
    private void m43253d(AdContentReq adContentReq) {
        int iMo43077k = this.f32779e.mo43077k();
        boolean zMo43075i = this.f32779e.mo43075i();
        boolean zMo43076j = this.f32779e.mo43076j();
        if (2 == iMo43077k) {
            return;
        }
        if (1 == iMo43077k) {
            m43219a(adContentReq, zMo43075i, zMo43076j);
            return;
        }
        String strM40148p = adContentReq.m40801i().m40148p();
        if (AbstractC7806cz.m48165b(strM40148p) || Constants.NIL_UUID.equals(strM40148p)) {
            m43219a(adContentReq, zMo43075i, zMo43076j);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: a */
    public AppConfigRsp mo43268a(String str) {
        String str2;
        try {
            AppConfigReq appConfigReqM43255e = m43255e(str);
            Response<AppConfigRsp> responseM45420a = m43243c().m45420a(this.f32779e.mo43384bK(), appConfigReqM43255e, m43205a((ReqBean) appConfigReqM43255e));
            if (responseM45420a == null) {
                return null;
            }
            AppConfigRsp appConfigRspM45987b = responseM45420a.m45987b();
            if (appConfigRspM45987b != null) {
                m43254d(appConfigRspM45987b.m40890M());
                this.f32779e.mo43458g(appConfigRspM45987b.m40926l());
                appConfigRspM45987b.responseCode = responseM45420a.m45977a() == 200 ? 0 : 1;
                C7128fl.m43510a(this.f32778d).mo43526a(appConfigRspM45987b.m40910ad());
                C7128fl.m43510a(this.f32778d).mo43531b(appConfigRspM45987b.m40912af());
            }
            return appConfigRspM45987b;
        } catch (IllegalArgumentException unused) {
            str2 = "requestAppConfig IllegalArgumentException";
            AbstractC7185ho.m43823c("NetHandler", str2);
            return null;
        } catch (Exception unused2) {
            str2 = "requestAppConfig Exception";
            AbstractC7185ho.m43823c("NetHandler", str2);
            return null;
        }
    }

    /* renamed from: c */
    private boolean m43246c(Device device) {
        return (!TextUtils.equals("1", device.m40149q()) || TextUtils.isEmpty(device.m40148p())) && (!TextUtils.equals("1", device.m40079A()) || TextUtils.isEmpty(device.m40158z()));
    }

    /* renamed from: d */
    private void m43254d(String str) {
        if (this.f32780f == null) {
            this.f32780f = C7121fe.m43293a(this.f32778d);
        }
        InterfaceC7144ga interfaceC7144ga = this.f32780f;
        if (interfaceC7144ga != null) {
            interfaceC7144ga.mo43302b(str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: a */
    public ConsentConfigRsp mo43269a(String str, ConsentConfigReq consentConfigReq) {
        String str2;
        try {
            if (!Config.SDK_VERSION.equals(consentConfigReq.m40944d())) {
                AbstractC7185ho.m43820b("NetHandler", "consent sdk version not match, reset version.");
                consentConfigReq.m40943a(Config.SDK_VERSION);
            }
            if (!TextUtils.isEmpty(consentConfigReq.m40944d()) && consentConfigReq.m40944d().startsWith("13.4.")) {
                AbstractC7185ho.m43820b("NetHandler", "replace inner consent sdk version.");
                consentConfigReq.m40943a(consentConfigReq.m40944d().replace("13.4.", "3.4."));
            }
            Response<ConsentConfigRsp> responseM45416a = m43243c().m45416a(consentConfigReq, m43206a(consentConfigReq));
            if (responseM45416a == null) {
                return null;
            }
            ConsentConfigRsp consentConfigRspM45987b = responseM45416a.m45987b();
            if (consentConfigRspM45987b != null) {
                consentConfigRspM45987b.responseCode = responseM45416a.m45977a() == 200 ? 0 : 1;
            }
            return consentConfigRspM45987b;
        } catch (IllegalArgumentException unused) {
            str2 = "requestConsentConfig IllegalArgumentException";
            AbstractC7185ho.m43823c("NetHandler", str2);
            return null;
        } catch (Exception unused2) {
            str2 = "requestConsentConfig Exception";
            AbstractC7185ho.m43823c("NetHandler", str2);
            return null;
        }
    }

    /* renamed from: b */
    public Response<AdContentRsp> m43235b(AdContentReq adContentReq) {
        int iM43240c = m43240c(adContentReq);
        AbstractC7185ho.m43821b("NetHandler", "request ad content from server, type: %s", Integer.valueOf(iM43240c));
        if (2 != iM43240c && 1 != iM43240c) {
            return m43243c().m45419a(this.f32779e.mo43383bJ(), adContentReq, m43205a((ReqBean) adContentReq));
        }
        adContentReq.m40800h(Constants.ACD_REALM_FB);
        adContentReq.m40797g(Constants.ACD_REQ_URI_FB);
        return m43243c().m45413a(iM43240c, adContentReq, m43205a((ReqBean) adContentReq));
    }

    /* renamed from: c */
    private boolean m43247c(List<String> list) {
        if (!C6982bz.m41152b(this.f32778d)) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (1 == C7123fg.m43308a(this.f32778d).mo43313b(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: a */
    public EventReportRsp mo43270a(List<AdEvent> list) {
        EventReportRsp eventReportRspM45987b;
        Exception e10;
        IllegalArgumentException e11;
        EventReportRsp eventReportRsp;
        AbstractC7185ho.m43820b("NetHandler", "upload events!");
        EventReportRsp eventReportRsp2 = null;
        if (list == null || list.isEmpty()) {
            AbstractC7185ho.m43823c("NetHandler", "fail to upload cache events, events is empty");
            return null;
        }
        List<AdEvent> listM43265g = m43265g(list);
        EventReportRsp eventReportRspM43267h = !listM43265g.isEmpty() ? m43267h(listM43265g) : null;
        if (list.isEmpty()) {
            return eventReportRspM43267h;
        }
        EventReportReq eventReportReq = new EventReportReq(list);
        try {
            Response<EventReportRsp> responseM45417a = m43243c().m45417a(eventReportReq, m43205a(eventReportReq));
            if (responseM45417a == null) {
                return null;
            }
            eventReportRspM45987b = responseM45417a.m45987b();
            try {
                String strM45995d = responseM45417a.m45995d();
                if (strM45995d == null) {
                    strM45995d = String.valueOf(responseM45417a.m45977a());
                }
                if (eventReportRspM45987b != null) {
                    eventReportRspM45987b.responseCode = responseM45417a.m45977a() == 200 ? 0 : 1;
                    eventReportRspM45987b.errorReason = strM45995d;
                    eventReportRsp2 = eventReportRspM45987b;
                } else {
                    EventReportRsp eventReportRsp3 = new EventReportRsp();
                    try {
                        eventReportRsp3.responseCode = 1;
                        eventReportRsp3.errorReason = strM45995d;
                        eventReportRsp2 = eventReportRsp3;
                    } catch (IllegalArgumentException e12) {
                        e11 = e12;
                        eventReportRspM45987b = eventReportRsp3;
                        AbstractC7185ho.m43823c("NetHandler", "uploadEvents IllegalArgumentException");
                        if (eventReportRspM45987b == null) {
                            eventReportRsp = new EventReportRsp();
                            eventReportRsp.responseCode = 1;
                            eventReportRsp.errorReason = e11.getClass().getSimpleName();
                            m43221a(eventReportRspM43267h, eventReportRsp);
                            return eventReportRsp;
                        }
                        return eventReportRspM45987b;
                    } catch (Exception e13) {
                        e10 = e13;
                        eventReportRspM45987b = eventReportRsp3;
                        AbstractC7185ho.m43823c("NetHandler", "uploadEvents Exception");
                        if (eventReportRspM45987b == null) {
                            eventReportRsp = new EventReportRsp();
                            eventReportRsp.errorReason = e10.getClass().getSimpleName();
                            eventReportRsp.responseCode = 1;
                            m43221a(eventReportRspM43267h, eventReportRsp);
                            return eventReportRsp;
                        }
                        return eventReportRspM45987b;
                    }
                }
                m43221a(eventReportRspM43267h, eventReportRsp2);
                return eventReportRsp2;
            } catch (IllegalArgumentException e14) {
                e11 = e14;
            } catch (Exception e15) {
                e10 = e15;
            }
        } catch (IllegalArgumentException e16) {
            eventReportRspM45987b = eventReportRsp2;
            e11 = e16;
        } catch (Exception e17) {
            eventReportRspM45987b = eventReportRsp2;
            e10 = e17;
        }
    }

    /* renamed from: b */
    private Response<AdContentRsp> m43236b(AdContentReq adContentReq, List<String> list, int i10, Integer num) {
        try {
            AbstractC7185ho.m43820b("NetHandler", "request ads from sdk rec engine");
            return C7096el.m42946a(this.f32778d, adContentReq, list, i10, num);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("NetHandler", "recall ads from sdk error: %s", th2.getClass().getSimpleName());
            AbstractC7185ho.m43813a(5, "NetHandler", "recall ads from sdk error", th2);
            return null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: a */
    public PermissionRsp mo43271a(String str, String str2, String str3, int i10, int i11) {
        String str4;
        try {
            PermissionReq permissionReq = new PermissionReq(str, str2, str3, i10, i11);
            Response<PermissionRsp> responseM45418a = m43243c().m45418a(permissionReq, m43205a(permissionReq));
            if (responseM45418a != null) {
                return responseM45418a.m45987b();
            }
            return null;
        } catch (IllegalArgumentException unused) {
            str4 = "requestPermission IllegalArgumentException";
            AbstractC7185ho.m43823c("NetHandler", str4);
            return null;
        } catch (Exception unused2) {
            str4 = "requestPermission Exception";
            AbstractC7185ho.m43823c("NetHandler", str4);
            return null;
        }
    }

    /* renamed from: a */
    public static InterfaceC7140fx m43196a(Context context) {
        return m43233b(context);
    }

    /* renamed from: b */
    private Integer m43237b(RequestOptions requestOptions) {
        Boolean boolM40727g = requestOptions != null ? requestOptions.m40727g() : null;
        int i10 = 0;
        int i11 = (C7828g.m48405a(this.f32778d) && C6982bz.m41148a(this.f32778d).mo41178g()) ? 1 : 0;
        if (boolM40727g == null) {
            return Integer.valueOf(i11);
        }
        if (boolM40727g.booleanValue() && i11 != 0) {
            i10 = 1;
        }
        return Integer.valueOf(i10);
    }

    /* renamed from: a */
    private Response<AdContentRsp> m43197a(int i10, Integer num, AdContentReq adContentReq) {
        if (adContentReq == null) {
            return null;
        }
        List<AdSlot30> listM40803k = adContentReq.m40803k();
        if (AbstractC7760bg.m47767a(listM40803k)) {
            AbstractC7185ho.m43823c("NetHandler", "slots is empty");
            return null;
        }
        List<String> listM43251d = m43251d(listM40803k);
        if (AbstractC7760bg.m47767a(listM43251d)) {
            return null;
        }
        return C7790cj.m48046a(this.f32778d, adContentReq.m40807o(), listM43251d) ? m43200a(adContentReq, listM43251d, i10, num) : m43235b(adContentReq);
    }

    /* renamed from: b */
    private Map<String, String> m43238b(ReqBean reqBean) {
        C7351jy c7351jy = new C7351jy(this.f32778d);
        c7351jy.m45444b(reqBean);
        return c7351jy.m46049a();
    }

    /* renamed from: b */
    private void m43239b() {
        AbstractC7185ho.m43821b("NetHandler", "createAdServerRequester lib switch: %d", Integer.valueOf(this.f32783i));
        C7350jx c7350jxM45424a = C7350jx.m45424a(this.f32778d);
        boolean zM45430a = c7350jxM45424a.m45430a();
        boolean zM45431b = c7350jxM45424a.m45431b();
        AbstractC7185ho.m43821b("NetHandler", "isNetworkKitEnable: %s, isQuicEnable: %s", Boolean.valueOf(zM45430a), Boolean.valueOf(zM45431b));
        int i10 = zM45430a ? 2 : this.f32783i;
        this.f32784j = zM45430a;
        this.f32781g = (InterfaceC7347ju) new C7502e.a(this.f32778d).m46067c(i10).m46061a(new C7345js()).m46065b(new C7346jt()).m46068c(zM45431b).m46063a().m46059a(InterfaceC7347ju.class);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: a */
    public Response<AdContentRsp> mo43272a(AdRequestParam adRequestParam) throws NumberFormatException {
        int iM39333a = adRequestParam.m39333a();
        AdSlotParam adSlotParamM39337b = adRequestParam.m39337b();
        AdTimeStatistics adTimeStatisticsM39344i = adRequestParam.m39344i();
        String strM39342g = adRequestParam.m39342g();
        long jM39343h = adRequestParam.m39343h();
        adTimeStatisticsM39344i.m39564d(jM39343h);
        AdContentReq adContentReqM43241c = m43241c(adRequestParam);
        adTimeStatisticsM39344i.m39562c(System.currentTimeMillis());
        adContentReqM43241c.m40778b(strM39342g);
        adContentReqM43241c.m40779b(adRequestParam.m39341f());
        C7823dp.m48385a(adSlotParamM39337b);
        AbstractC7185ho.m43820b("NetHandler", "do ad req");
        return m43199a(adContentReqM43241c, adSlotParamM39337b, iM39333a, strM39342g, jM39343h, adTimeStatisticsM39344i);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: a */
    public Response<String> mo43273a(AdContentReq adContentReq) {
        return m43243c().m45421b(this.f32779e.mo43383bJ(), adContentReq, m43205a((ReqBean) adContentReq));
    }

    /* renamed from: a */
    private Response<AdContentRsp> m43198a(AdContentReq adContentReq, int i10) {
        try {
            AbstractC7185ho.m43820b("NetHandler", "request ads from hms rec engine");
            long jM47566c = AbstractC7741ao.m47566c();
            C7484ms c7484msM45854a = C7484ms.m45854a(this.f32778d);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MapKeyNames.REMOTE_REQ, AbstractC7758be.m47742b(adContentReq));
            jSONObject.put(MapKeyNames.ALLOWED_TRADE_MODES, AbstractC7758be.m47742b(Arrays.asList(C7790cj.m48050a(this.f32778d, String.valueOf(i10)))));
            jSONObject.put(MapKeyNames.LOCAL_RECALL_MAX_COUNT, this.f32779e.mo43080n());
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Response<AdContentRsp> response = new Response<>();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            c7484msM45854a.m45855a(RTCMethods.RECALL_AD_BY_REC_ENGINE, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.fb.2

                /* renamed from: a */
                final /* synthetic */ Response f32794a;

                /* renamed from: b */
                final /* synthetic */ CountDownLatch f32795b;

                /* renamed from: c */
                final /* synthetic */ AtomicBoolean f32796c;

                /* renamed from: d */
                final /* synthetic */ AdContentReq f32797d;

                /* renamed from: com.huawei.openalliance.ad.fb$2$1 */
                public class AnonymousClass1 implements Runnable {
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (atomicBoolean.get()) {
                            return;
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        Response responseM43235b = C7118fb.this.m43235b(adContentReq);
                        if (responseM43235b != null) {
                            synchronized (response) {
                                response.m45982a(responseM43235b);
                                response.m45983a((Response) responseM43235b.m45987b());
                            }
                        }
                        countDownLatch.countDown();
                    }
                }

                public AnonymousClass2(Response response2, CountDownLatch countDownLatch2, AtomicBoolean atomicBoolean2, AdContentReq adContentReq2) {
                    response = response2;
                    countDownLatch = countDownLatch2;
                    atomicBoolean = atomicBoolean2;
                    adContentReq = adContentReq2;
                }

                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String v10, CallResult<String> v11) {
                    /*
                        this = this;
                        java.lang.String r5 = "NetHandler"
                        if (r6 == 0) goto L65
                        int r0 = r6.getCode()     // Catch: java.lang.Throwable -> L62
                        r1 = 200(0xc8, float:2.8E-43)
                        if (r0 != r1) goto L65
                        java.lang.String r0 = "recall ads from hms success"
                        com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r5, r0)     // Catch: java.lang.Throwable -> L62
                        java.lang.Object r6 = r6.getData()     // Catch: java.lang.Throwable -> L62
                        java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L62
                        boolean r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48165b(r6)     // Catch: java.lang.Throwable -> L62
                        if (r0 == 0) goto L1e
                        return
                    L1e:
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L62
                        r0.<init>(r6)     // Catch: java.lang.Throwable -> L62
                        java.lang.String r6 = "adRspStr"
                        java.lang.String r6 = r0.optString(r6)     // Catch: java.lang.Throwable -> L62
                        java.lang.Class<com.huawei.openalliance.ad.beans.server.AdContentRsp> r1 = com.huawei.openalliance.p169ad.beans.server.AdContentRsp.class
                        r2 = 0
                        java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L62
                        java.lang.Object r6 = com.huawei.openalliance.p169ad.utils.AbstractC7758be.m47739b(r6, r1, r3)     // Catch: java.lang.Throwable -> L62
                        com.huawei.openalliance.ad.beans.server.AdContentRsp r6 = (com.huawei.openalliance.p169ad.beans.server.AdContentRsp) r6     // Catch: java.lang.Throwable -> L62
                        java.lang.String r1 = "rspStr"
                        java.lang.String r0 = r0.optString(r1)     // Catch: java.lang.Throwable -> L62
                        java.lang.Class<com.huawei.openalliance.ad.net.http.Response> r1 = com.huawei.openalliance.p169ad.net.http.Response.class
                        java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L62
                        java.lang.Object r0 = com.huawei.openalliance.p169ad.utils.AbstractC7758be.m47739b(r0, r1, r2)     // Catch: java.lang.Throwable -> L62
                        com.huawei.openalliance.ad.net.http.Response r0 = (com.huawei.openalliance.p169ad.net.http.Response) r0     // Catch: java.lang.Throwable -> L62
                        if (r6 == 0) goto L64
                        if (r0 != 0) goto L49
                        goto L64
                    L49:
                        com.huawei.openalliance.ad.net.http.Response r1 = r2     // Catch: java.lang.Throwable -> L62
                        r1.m45982a(r0)     // Catch: java.lang.Throwable -> L62
                        com.huawei.openalliance.ad.net.http.Response r1 = r2     // Catch: java.lang.Throwable -> L62
                        r1.m45983a(r6)     // Catch: java.lang.Throwable -> L62
                        com.huawei.openalliance.ad.net.http.Response r6 = r2     // Catch: java.lang.Throwable -> L62
                        long r0 = r0.m46013r()     // Catch: java.lang.Throwable -> L62
                        r6.m45998e(r0)     // Catch: java.lang.Throwable -> L62
                        java.util.concurrent.CountDownLatch r4 = r3     // Catch: java.lang.Throwable -> L62
                        r4.countDown()     // Catch: java.lang.Throwable -> L62
                        goto L7f
                    L62:
                        r4 = move-exception
                        goto L6e
                    L64:
                        return
                    L65:
                        com.huawei.openalliance.ad.fb$2$1 r6 = new com.huawei.openalliance.ad.fb$2$1     // Catch: java.lang.Throwable -> L62
                        r6.<init>()     // Catch: java.lang.Throwable -> L62
                        com.huawei.openalliance.p169ad.utils.AbstractC7834m.m48481b(r6)     // Catch: java.lang.Throwable -> L62
                        goto L7f
                    L6e:
                        java.lang.Class r4 = r4.getClass()
                        java.lang.String r4 = r4.getSimpleName()
                        java.lang.Object[] r4 = new java.lang.Object[]{r4}
                        java.lang.String r6 = "parse ads from hms rec engine error: %s"
                        com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r5, r6, r4)
                    L7f:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7118fb.AnonymousClass2.onRemoteCallResult(java.lang.String, com.huawei.openalliance.ad.ipc.CallResult):void");
                }
            }, String.class);
            try {
                boolean zAwait = countDownLatch2.await(2L, TimeUnit.SECONDS);
                AbstractC7185ho.m43818a("NetHandler", "latch result: %s", Boolean.valueOf(zAwait));
                if (!zAwait) {
                    AbstractC7185ho.m43817a("NetHandler", "request directly from the realtime again");
                    atomicBoolean2.set(true);
                    Response<AdContentRsp> responseM43235b = m43235b(adContentReq2);
                    if (responseM43235b != null) {
                        synchronized (response2) {
                            response2.m45982a(responseM43235b);
                            response2.m45983a((Response<AdContentRsp>) responseM43235b.m45987b());
                        }
                    }
                }
                long jM47566c2 = AbstractC7741ao.m47566c() - jM47566c;
                AbstractC7185ho.m43818a("NetHandler", "recall ads from hms rec engine cost: %s", Long.valueOf(jM47566c2));
                response2.m46001f(jM47566c2);
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("NetHandler", "latch " + th2.getClass().getSimpleName());
            }
            return response2;
        } catch (Throwable th3) {
            AbstractC7185ho.m43824c("NetHandler", "request ads from hms rec engine error: %s", th3.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0118 A[Catch: all -> 0x0051, TryCatch #2 {all -> 0x0051, blocks: (B:87:0x001c, B:88:0x0020, B:92:0x002b, B:94:0x0036, B:103:0x005e, B:105:0x0064, B:108:0x0077, B:109:0x008d, B:113:0x00a1, B:115:0x00b8, B:132:0x0111, B:134:0x0118, B:135:0x011d, B:139:0x0152, B:142:0x016c, B:144:0x0173, B:145:0x0178, B:128:0x00da, B:129:0x00f2), top: B:152:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0173 A[Catch: all -> 0x0051, TryCatch #2 {all -> 0x0051, blocks: (B:87:0x001c, B:88:0x0020, B:92:0x002b, B:94:0x0036, B:103:0x005e, B:105:0x0064, B:108:0x0077, B:109:0x008d, B:113:0x00a1, B:115:0x00b8, B:132:0x0111, B:134:0x0118, B:135:0x011d, B:139:0x0152, B:142:0x016c, B:144:0x0173, B:145:0x0178, B:128:0x00da, B:129:0x00f2), top: B:152:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01a0  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.openalliance.p169ad.net.http.Response<com.huawei.openalliance.p169ad.beans.server.AdContentRsp> m43199a(com.huawei.openalliance.p169ad.beans.server.AdContentReq r20, com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam r21, int r22, java.lang.String r23, long r24, com.huawei.openalliance.p169ad.beans.metadata.AdTimeStatistics r26) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7118fb.m43199a(com.huawei.openalliance.ad.beans.server.AdContentReq, com.huawei.openalliance.ad.beans.parameter.AdSlotParam, int, java.lang.String, long, com.huawei.openalliance.ad.beans.metadata.AdTimeStatistics):com.huawei.openalliance.ad.net.http.Response");
    }

    /* renamed from: a */
    private Response<AdContentRsp> m43200a(AdContentReq adContentReq, List<String> list, int i10, Integer num) {
        if (m43247c(list)) {
            C7096el.m42951a(list, 1);
            return m43198a(adContentReq, i10);
        }
        if (!C7096el.m42952a(this.f32778d)) {
            return m43235b(adContentReq);
        }
        C7096el.m42951a(list, 0);
        return m43236b(adContentReq, list, i10, num);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: a */
    public C7654sc mo43274a(C7653sb c7653sb) {
        C7654sc c7654scM47158a = new C7650rz(this.f32778d, c7653sb).m47158a();
        if (c7654scM47158a == null && this.f32778d != null && c7653sb != null && c7653sb.m47197l() != null) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.fb.7

                /* renamed from: a */
                final /* synthetic */ C7653sb f32819a;

                public AnonymousClass7(C7653sb c7653sb2) {
                    c7653sb = c7653sb2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    new C6922c(C7118fb.this.f32778d).mo39084a(c7653sb);
                }
            });
        }
        return c7654scM47158a;
    }

    /* renamed from: a */
    private List<ImpEX> m43202a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : bundle.keySet()) {
                arrayList.add(new ImpEX(str, AbstractC7806cz.m48170d(bundle.getString(str))));
            }
            return arrayList;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("NetHandler", "toImpEXs err: %s", th2.getClass().getSimpleName());
            return arrayList;
        }
    }

    /* renamed from: a */
    private List<CachedContent> m43203a(List<CachedContent> list, List<CachedContent> list2) {
        if (AbstractC7760bg.m47767a(list2)) {
            return list;
        }
        Map<String, List<String>> mapM43256e = m43256e(list);
        Map<String, List<String>> mapM43256e2 = m43256e(list2);
        if (C7765bl.m47802a(mapM43256e2)) {
            return list;
        }
        for (Map.Entry<String, List<String>> entry : mapM43256e2.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (mapM43256e.containsKey(key)) {
                    List<String> arrayList = mapM43256e.get(key);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    HashSet hashSet = new HashSet(arrayList);
                    hashSet.addAll(value);
                    value = new ArrayList<>(hashSet);
                }
                mapM43256e.put(key, value);
            }
        }
        return m43204a(mapM43256e);
    }

    /* renamed from: a */
    private List<CachedContent> m43204a(Map<String, List<String>> map) {
        if (C7765bl.m47802a(map)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry != null) {
                arrayList.add(new CachedContent(entry.getKey(), 3, entry.getValue()));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private Map<String, String> m43205a(ReqBean reqBean) {
        C7351jy c7351jy = new C7351jy(this.f32778d);
        c7351jy.m45443a(this.f32779e.mo43345aL());
        c7351jy.m45441a(reqBean);
        return c7351jy.m46049a();
    }

    /* renamed from: a */
    private Map<String, String> m43206a(ConsentConfigReq consentConfigReq) {
        C7351jy c7351jy = new C7351jy(this.f32778d);
        c7351jy.m45442a(consentConfigReq);
        return c7351jy.m46049a();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: a */
    public Map<Integer, AdContentRsp> mo43275a(String str, long j10, List<String> list) {
        HashMap map = new HashMap(4);
        Response responseM43244c = m43244c(str);
        responseM43244c.m45988b(1);
        AdContentRsp adContentRsp = (AdContentRsp) responseM43244c.m45987b();
        long jM47566c = AbstractC7741ao.m47566c() - j10;
        if (adContentRsp == null) {
            m43211a(-1, "", -1, responseM43244c.m45977a(), responseM43244c.m45995d(), jM47566c, false, responseM43244c, null);
            return map;
        }
        adContentRsp.responseCode = responseM43244c.m45977a() == 200 ? 0 : 1;
        String strM40851k = adContentRsp.m40851k();
        this.f32779e.mo43461h(adContentRsp.m40845g());
        Map<Integer, AdContentRsp> mapM43207a = m43207a(map, adContentRsp, list, strM40851k, responseM43244c, jM47566c);
        for (Map.Entry<Integer, AdContentRsp> entry : mapM43207a.entrySet()) {
            Integer key = entry.getKey();
            if (key != null) {
                AdContentRsp adContentRspM43248d = m43248d(key.intValue(), list, entry.getValue());
                if (adContentRspM43248d != null) {
                    mapM43207a.put(key, adContentRspM43248d);
                }
            }
        }
        return mapM43207a;
    }

    /* renamed from: a */
    private Map<Integer, AdContentRsp> m43207a(Map<Integer, AdContentRsp> map, AdContentRsp adContentRsp, List<String> list, String str, Response response, long j10) {
        int iM40819a = adContentRsp.m40819a();
        if (200 != iM40819a) {
            AbstractC7185ho.m43821b("NetHandler", "ad failed, retcode: %s, reason: %s, requestId: %s.", Integer.valueOf(iM40819a), adContentRsp.m40826b(), str);
        }
        List<Ad30> listM40830c = adContentRsp.m40830c();
        if (listM40830c == null || listM40830c.isEmpty()) {
            map.put(-1, adContentRsp);
            m43211a(-1, str, iM40819a, response.m45977a(), response.m45995d(), j10, false, response, null);
            return map;
        }
        HashMap map2 = new HashMap();
        for (Ad30 ad30 : listM40830c) {
            if (ad30 != null) {
                int iM39431d = ad30.m39431d();
                String strM39419a = ad30.m39419a();
                int iM39424b = ad30.m39424b();
                if (200 != iM39424b) {
                    AbstractC7185ho.m43821b("NetHandler", "ad failed, retcode30: %s, slotId: %s.", Integer.valueOf(iM39424b), list);
                }
                list.add(strM39419a);
                if (!map2.containsKey(Integer.valueOf(iM39431d))) {
                    map2.put(Integer.valueOf(iM39431d), new ArrayList());
                }
                ((List) map2.get(Integer.valueOf(iM39431d))).add(ad30);
            }
        }
        for (Map.Entry entry : map2.entrySet()) {
            Integer num = (Integer) entry.getKey();
            num.intValue();
            List<Ad30> list2 = (List) entry.getValue();
            AdContentRsp adContentRspM40856p = adContentRsp.m40856p();
            adContentRspM40856p.m40832c(str);
            adContentRspM40856p.m40824a(list2);
            adContentRspM40856p.m40843f(1);
            map.put(num, adContentRspM40856p);
        }
        return map;
    }

    /* renamed from: a */
    private void m43208a() {
        AbstractC7185ho.m43821b("NetHandler", "createThirdRequester lib switch: %d", Integer.valueOf(this.f32785k));
        this.f32782h = (InterfaceC7349jw) new C7502e.a(this.f32778d).m46067c(this.f32785k).m46065b(new C7346jt()).m46062a(true).m46066b(false).m46063a().m46059a(InterfaceC7349jw.class);
    }

    /* renamed from: a */
    private void m43209a(int i10, AdSlotParam adSlotParam, String str, AdSlot30 adSlot30) {
        List<String> listM43106a = C7103es.m43094a(this.f32778d).m43106a(i10, str);
        if (!AbstractC7807d.m48228c(this.f32778d, str)) {
            AbstractC7185ho.m43817a("NetHandler", "assemble Kit cached 2.0 contentIds");
            List<String> listM41882e = AbstractC7014dc.m41882e();
            if (!AbstractC7760bg.m47767a(listM41882e)) {
                if (listM43106a == null) {
                    listM43106a = new ArrayList<>();
                }
                for (String str2 : listM41882e) {
                    if (!listM43106a.contains(str2)) {
                        listM43106a.add(str2);
                    }
                }
            }
        }
        m43227a(listM43106a, adSlotParam.m40657j());
        if (AbstractC7760bg.m47767a(listM43106a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listM43106a.iterator();
        while (it.hasNext()) {
            arrayList.add(new CachedContent(it.next(), 2, null));
        }
        adSlot30.m39517d(arrayList);
    }

    /* renamed from: a */
    private void m43210a(int i10, AdSlotParam adSlotParam, List<AdSlot30> list, Map<String, Bundle> map) {
        List<String> listM40627a = adSlotParam.m40627a();
        Map<String, Integer> mapM40624H = adSlotParam.m40624H();
        if (listM40627a == null || listM40627a.size() <= 0) {
            return;
        }
        for (String str : listM40627a) {
            AdSlot30 adSlot30M43192a = m43192a(i10, adSlotParam, map, str);
            Integer num = mapM40624H.get(str);
            if (num != null && 1 == num.intValue()) {
                adSlot30M43192a.m39504a(1);
            }
            list.add(adSlot30M43192a);
        }
    }

    /* renamed from: a */
    private void m43211a(int i10, String str, int i11, int i12, String str2, long j10, boolean z10, Response response, AdTimeStatistics adTimeStatistics) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.fb.6

            /* renamed from: a */
            final /* synthetic */ AdTimeStatistics f32809a;

            /* renamed from: b */
            final /* synthetic */ int f32810b;

            /* renamed from: c */
            final /* synthetic */ String f32811c;

            /* renamed from: d */
            final /* synthetic */ int f32812d;

            /* renamed from: e */
            final /* synthetic */ long f32813e;

            /* renamed from: f */
            final /* synthetic */ boolean f32814f;

            /* renamed from: g */
            final /* synthetic */ Response f32815g;

            /* renamed from: h */
            final /* synthetic */ int f32816h;

            /* renamed from: i */
            final /* synthetic */ String f32817i;

            public AnonymousClass6(AdTimeStatistics adTimeStatistics2, int i112, String str3, int i102, long j102, boolean z102, Response response2, int i122, String str22) {
                adTimeStatistics = adTimeStatistics2;
                i = i112;
                str = str3;
                i = i102;
                j = j102;
                z = z102;
                response = response2;
                i = i122;
                str = str22;
            }

            @Override // java.lang.Runnable
            public void run() {
                C6927h c6927h = new C6927h(C7118fb.this.f32778d);
                String strM47742b = AbstractC7758be.m47742b(adTimeStatistics);
                if (C7118fb.this.m43228a(i)) {
                    c6927h.m39182a(str, i, i, j, z, response, strM47742b);
                } else {
                    c6927h.m39184a(str, i, i, str, i, j, z, response);
                }
            }
        });
    }

    /* renamed from: a */
    private void m43212a(Device device) {
        String strMo43443cn = this.f32779e.mo43443cn();
        AbstractC7185ho.m43818a("NetHandler", "get the adid is : %s", AbstractC7806cz.m48176g(strMo43443cn));
        device.m40143k(strMo43443cn);
    }

    /* renamed from: a */
    private void m43213a(Device device, AdSlotParam adSlotParam) {
        String str;
        int iM43231b = m43231b(device);
        if (iM43231b == 0) {
            Pair<String, Integer> pairM47487a = C7735ai.m47487a(this.f32778d);
            str = (String) pairM47487a.first;
            iM43231b = ((Integer) pairM47487a.second).intValue();
            if (!TextUtils.isEmpty(str)) {
                device.m40141j(str);
                device.m40127c((String) null);
                device.m40131e(null);
                if (!this.f32779e.mo43059ag()) {
                    device.m40109a((String) null);
                    device.m40135g(null);
                    device.m40123b((String) null);
                    device.m40139i(null);
                }
            }
        } else {
            str = "";
        }
        device.m40141j(str);
        adSlotParam.m40651e(iM43231b);
    }

    /* renamed from: a */
    private void m43214a(AdSlotParam adSlotParam, AdSlot30 adSlot30, String str) {
        if (adSlotParam.m40659l() == null || adSlotParam.m40659l().getBiddingParam(str) == null) {
            return;
        }
        AbstractC7185ho.m43817a("NetHandler", "media request assembles biddingParam to AdSlot30");
        BiddingParam biddingParam = adSlotParam.m40659l().getBiddingParam(str);
        if (biddingParam.getBidFloor() != null) {
            adSlot30.m39503a(biddingParam.getBidFloor().floatValue());
        }
        if (biddingParam.getBidFloorCur() != null) {
            adSlot30.m39510b(biddingParam.getBidFloorCur());
        }
        if (biddingParam.getBpkgName() != null && !biddingParam.getBpkgName().isEmpty()) {
            adSlot30.m39520e(biddingParam.getBpkgName());
        }
        AbstractC7185ho.m43817a("NetHandler", "media request end assembles biddingParam to AdSlot30");
    }

    /* renamed from: a */
    private void m43215a(AdSlotParam adSlotParam, AdContentReq adContentReq) {
        if (adSlotParam.m40657j()) {
            return;
        }
        adContentReq.m40796g(C7790cj.m48052b(this.f32778d) ? AiCoreSdkConstant.SUPPORT_RELATION_RANK : AiCoreSdkConstant.NOT_SUPPORT_RELATION_RANK);
        AbstractC7185ho.m43818a("NetHandler", "support relate rank: %s .", adContentReq.m40761L());
    }

    /* renamed from: a */
    private void m43216a(AdSlotParam adSlotParam, Integer num, boolean z10, AdContentReq adContentReq) {
        Device deviceM40801i = adContentReq.m40801i();
        AbstractC7185ho.m43820b("NetHandler", "use ad slot oaid and limitedTracking");
        deviceM40801i.m40137h(AbstractC7807d.m48252o(this.f32778d));
        Boolean boolM40655h = adSlotParam.m40655h();
        if (boolM40655h != null) {
            deviceM40801i.m40129d(boolM40655h.booleanValue() ? "0" : "1");
        }
        m43222a(num, deviceM40801i, adSlotParam.m40654g());
        m43257e(deviceM40801i);
        m43212a(deviceM40801i);
        LocationSwitches locationSwitchesM40668u = adSlotParam.m40668u();
        if (locationSwitchesM40668u != null) {
            deviceM40801i.m40108a(Integer.valueOf(locationSwitchesM40668u.m39410b()));
            deviceM40801i.m40122b(Integer.valueOf(locationSwitchesM40668u.m39407a()));
        }
        m43223a(num, deviceM40801i, deviceM40801i.m40148p(), boolM40655h, z10);
        m43213a(deviceM40801i, adSlotParam);
    }

    /* renamed from: a */
    private void m43217a(AdContentReq adContentReq, TagCfgModel tagCfgModel, List<String> list, List<String> list2, Map<String, String> map) {
        String strM40966a = tagCfgModel.m40966a();
        AbstractC7185ho.m43821b("NetHandler", "do add tags: %s", strM40966a);
        long j10 = Long.parseLong(tagCfgModel.m40967b()) * 60000;
        long jMo43559d = this.f32791q.mo43559d(strM40966a);
        if (AbstractC7741ao.m47566c() - jMo43559d > j10) {
            AbstractC7185ho.m43818a("NetHandler", "tag %s expire, update time: %s, validTime is : %s", strM40966a, Long.valueOf(jMo43559d), Long.valueOf(j10));
            return;
        }
        Map<String, String> mapM40754E = adContentReq.m40754E();
        String strMo43556b = this.f32791q.mo43556b(strM40966a);
        if (AbstractC7806cz.m48165b(strMo43556b)) {
            AbstractC7185ho.m43818a("NetHandler", "tagVal is empty, type is : %s", strM40966a);
            return;
        }
        if (C7765bl.m47802a(mapM40754E)) {
            mapM40754E = new HashMap<>();
        }
        list.add(strM40966a);
        list2.add(String.valueOf(this.f32791q.mo43558c(strM40966a)));
        mapM40754E.put(strM40966a, strMo43556b);
        map.put(strM40966a, strMo43556b);
        adContentReq.m40774a(mapM40754E);
    }

    /* renamed from: a */
    private void m43218a(AdContentReq adContentReq, String str) throws NumberFormatException {
        List<TagCfgModel> listMo43440ck = this.f32779e.mo43440ck();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        for (TagCfgModel tagCfgModel : listMo43440ck) {
            int i10 = Integer.parseInt(tagCfgModel.m40969d());
            if (2 == i10) {
                AbstractC7185ho.m43818a("NetHandler", "no need report , type : %s", tagCfgModel.m40966a());
            } else if (1 == i10) {
                m43217a(adContentReq, tagCfgModel, arrayList, arrayList2, map);
                AbstractC7185ho.m43818a("NetHandler", "report anyway , type : %s", tagCfgModel.m40966a());
            } else {
                String strM40148p = adContentReq.m40801i().m40148p();
                if (AbstractC7806cz.m48165b(strM40148p) || Constants.NIL_UUID.equals(strM40148p)) {
                    m43217a(adContentReq, tagCfgModel, arrayList, arrayList2, map);
                    AbstractC7185ho.m43818a("NetHandler", "report nil oaid , type : %s", tagCfgModel.m40966a());
                }
            }
        }
        m43226a(arrayList, arrayList2, map, str);
    }

    /* renamed from: a */
    private void m43219a(AdContentReq adContentReq, boolean z10, boolean z11) {
        if (z11) {
            List<String> listMo42975b = C7099eo.m42970a(this.f32778d).mo42975b();
            if (!AbstractC7760bg.m47767a(listMo42975b)) {
                adContentReq.m40787d(listMo42975b);
            }
        }
        if (z10) {
            Map<String, String> mapM40754E = adContentReq.m40754E();
            Map<String, String> mapMo43557b = this.f32791q.mo43557b();
            if (C7765bl.m47802a(mapMo43557b)) {
                return;
            }
            if (!C7765bl.m47802a(mapM40754E)) {
                mapMo43557b.putAll(mapM40754E);
            }
            adContentReq.m40774a(mapMo43557b);
            m43258e(adContentReq);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7140fx
    /* renamed from: a */
    public void mo43276a(AdPreReq adPreReq) {
        try {
            AbstractC7185ho.m43820b("NetHandler", "preRequestAdContent, result:" + m43243c().m45414a(adPreReq).m45977a());
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("NetHandler", "requestAdContent Exception: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m43220a(AppConfigReq appConfigReq) {
        C7733ag.a aVarM47474a;
        if (C7733ag.m47475b(this.f32778d) && this.f32779e.mo43345aL() && (aVarM47474a = C7733ag.m47474a(this.f32778d)) != null) {
            appConfigReq.m40872f(aVarM47474a.m47479a());
        }
    }

    /* renamed from: a */
    private void m43221a(EventReportRsp eventReportRsp, EventReportRsp eventReportRsp2) {
        if (eventReportRsp != null) {
            if (eventReportRsp.responseCode == 0) {
                eventReportRsp2.responseCode = 0;
            }
            List<AdEventResultV2> listM40955c = eventReportRsp2.m40955c();
            if (listM40955c == null) {
                listM40955c = new ArrayList<>();
            }
            List<AdEventResult> listM40951a = eventReportRsp2.m40951a();
            if (listM40951a == null) {
                listM40951a = new ArrayList<>();
            }
            List<AdEventResult> listM40951a2 = eventReportRsp.m40951a();
            if (listM40951a2 != null) {
                listM40951a.addAll(listM40951a2);
            }
            List<AdEventResultV2> listM40955c2 = eventReportRsp.m40955c();
            if (listM40955c2 != null) {
                listM40955c.addAll(listM40955c2);
            }
            eventReportRsp2.m40952a(listM40951a);
            eventReportRsp2.m40954b(listM40955c);
        }
    }

    /* renamed from: a */
    private void m43222a(Integer num, Device device, String str) {
        if (this.f32779e.mo43395bV() != 1 && num != null && 1 == num.intValue()) {
            device.m40127c((String) null);
        } else {
            device.m40127c(str);
            m43252d(device);
        }
    }

    /* renamed from: a */
    private void m43223a(Integer num, Device device, String str, Boolean bool, boolean z10) {
        String str2;
        int iMo43039Q = C7124fh.m43316b(this.f32778d).mo43039Q();
        if (iMo43039Q == 0) {
            m43263f(device);
            str2 = "INSAPPS CLOSE";
        } else if (iMo43039Q == 2) {
            AbstractC7185ho.m43817a("NetHandler", "INSAPPS OPEN");
            m43266g(device);
            return;
        } else {
            if (iMo43039Q != 1) {
                return;
            }
            if (m43230a(num, str, bool, z10) && !"0".equals(device.m40079A()) && !"1".equals(C7124fh.m43316b(this.f32778d).mo43379bF())) {
                AbstractC7185ho.m43817a("NetHandler", "INSAPPS PERSONALIZED");
                m43263f(device);
                return;
            } else {
                m43266g(device);
                str2 = "INSAPPS NON PERSONALIZED";
            }
        }
        AbstractC7185ho.m43817a("NetHandler", str2);
    }

    /* renamed from: a */
    private void m43224a(String str, AdSlotParam adSlotParam, AdSlot30 adSlot30, int i10) {
        if (C7757bd.m47715b(i10) && adSlotParam.m40617A()) {
            adSlot30.m39514c(C7128fl.m43510a(this.f32778d).mo43530b(str, adSlotParam.m40623G()));
        }
    }

    /* renamed from: a */
    private void m43225a(String str, AdSlotParam adSlotParam, AdSlot30 adSlot30, int i10, String str2) {
        if (i10 != 1) {
            Map<Integer, Integer> map = f32775a;
            if (!map.containsKey(Integer.valueOf(i10)) || Integer.parseInt(str2) < map.get(Integer.valueOf(i10)).intValue()) {
                return;
            }
            if ((3 == i10 || 9 == i10) && !adSlotParam.m40617A()) {
                return;
            }
            adSlot30.m39514c(C7128fl.m43510a(this.f32778d).mo43525a(str, adSlotParam.m40623G()));
            adSlot30.m39506a(C7084e.m42836a());
            return;
        }
        adSlot30.m39506a(C7084e.m42836a());
        adSlot30.m39514c(C7128fl.m43510a(this.f32778d).mo43525a(str, adSlotParam.m40623G()));
        List<CachedContent> listM43124e = C7104et.m43127b(this.f32778d).m43124e(str);
        if (!AbstractC7807d.m48228c(this.f32778d, str)) {
            AbstractC7185ho.m43817a("NetHandler", "assemble kit cached templates");
            Map<String, List<CachedContent>> mapM41883f = AbstractC7014dc.m41883f();
            if (!C7765bl.m47802a(mapM41883f)) {
                listM43124e = m43203a(listM43124e, mapM41883f.get(str));
            }
        }
        if (AbstractC7760bg.m47767a(listM43124e)) {
            return;
        }
        List<String> listM43260f = m43260f(listM43124e);
        m43227a(listM43260f, adSlotParam.m40657j());
        if (AbstractC7760bg.m47767a(adSlot30.m39542u())) {
            adSlot30.m39517d(listM43124e);
            return;
        }
        for (CachedContent cachedContent : adSlot30.m39542u()) {
            if (!listM43260f.contains(cachedContent.m40521a())) {
                listM43124e.add(cachedContent);
            }
        }
        adSlot30.m39517d(listM43124e);
    }

    /* renamed from: a */
    private void m43226a(List<String> list, List<String> list2, Map<String, String> map, String str) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.fb.8

            /* renamed from: a */
            final /* synthetic */ List f32821a;

            /* renamed from: b */
            final /* synthetic */ List f32822b;

            /* renamed from: c */
            final /* synthetic */ Map f32823c;

            /* renamed from: d */
            final /* synthetic */ String f32824d;

            public AnonymousClass8(List list3, List list22, Map map2, String str2) {
                list = list3;
                list = list22;
                map = map2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC7760bg.m47767a(list) || AbstractC7760bg.m47767a(list) || C7765bl.m47802a(map)) {
                    return;
                }
                new C6922c(C7118fb.this.f32778d).mo39109a(C7118fb.this.f32778d.getPackageName(), list, list, map, str);
            }
        });
    }

    /* renamed from: a */
    private void m43227a(List<String> list, boolean z10) {
        if (!z10 || AbstractC7760bg.m47767a(list)) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.fb.4

            /* renamed from: a */
            final /* synthetic */ List f32804a;

            public AnonymousClass4(List list2) {
                list = list2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7019dh.m41937a(C7118fb.this.f32778d, Constants.NORMAL_CACHE).m41961a(list, true);
                C7019dh.m41937a(C7118fb.this.f32778d, Constants.AR_CACHE).m41961a(list, true);
            }
        });
    }

    /* renamed from: a */
    public boolean m43228a(int i10) {
        return i10 >= 200 && i10 < 300 && i10 != 204;
    }

    /* renamed from: a */
    private boolean m43230a(Integer num, String str, Boolean bool, boolean z10) {
        return !TextUtils.isEmpty(str) && (bool == null || !bool.booleanValue()) && !((num != null && 1 == num.intValue()) || z10 || AbstractC7807d.m48254q(this.f32778d) == 1);
    }
}
