package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.analysis.C6921b;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.inner.AdEventReport;
import com.huawei.openalliance.p169ad.beans.inner.DownloadBlockInfo;
import com.huawei.openalliance.p169ad.beans.metadata.AdEventResult;
import com.huawei.openalliance.p169ad.beans.metadata.AdEventResultV2;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.PostBackEvent;
import com.huawei.openalliance.p169ad.beans.server.EventReportRsp;
import com.huawei.openalliance.p169ad.constant.AnalyticsEventType;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.constant.InterstitialMethods;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import com.huawei.openalliance.p169ad.utils.C7789ci;
import com.huawei.openalliance.p169ad.utils.C7790cj;
import com.huawei.openalliance.p169ad.utils.C7793cm;
import com.huawei.openalliance.p169ad.utils.C7829h;
import com.huawei.openalliance.p169ad.utils.C7844w;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ou */
/* loaded from: classes8.dex */
public class C7560ou implements InterfaceC7615qq {

    /* renamed from: a */
    private InterfaceC7671st f35192a;

    /* renamed from: b */
    private ContentRecord f35193b;

    /* renamed from: c */
    private InterfaceC7146gc f35194c;

    /* renamed from: d */
    private Context f35195d;

    /* renamed from: e */
    private C7329jc f35196e;

    /* renamed from: f */
    private InterfaceC7140fx f35197f;

    /* renamed from: g */
    private InterfaceC7144ga f35198g;

    /* renamed from: h */
    private int f35199h;

    /* renamed from: com.huawei.openalliance.ad.ou$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f35200a;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7560ou.this.f35193b == null) {
                AbstractC7185ho.m43826d("EventProcessor", "contentRecord is null, can't report HA show event");
            } else {
                C7829h.m48406a(C7560ou.this.f35195d, C7560ou.this.f35195d.getPackageName(), AnalyticsEventType.AD_IMP, C7560ou.this.f35193b.m41585m(), str);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$10 */
    public class AnonymousClass10 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C7587b f35202a;

        public AnonymousClass10(C7587b c7587b) {
            c7587b = c7587b;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7560ou.this.m46561f(c7587b);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$11 */
    public class AnonymousClass11 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f35204a;

        public AnonymousClass11(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7560ou.this.f35193b == null) {
                AbstractC7185ho.m43826d("EventProcessor", "contentRecord is null, can't report HA show event");
                return;
            }
            String packageName = C7560ou.this.f35195d.getPackageName();
            if (Constants.REWARD_ACTIVITY_NAME.equals(str) || Constants.INTERSTITIAL_ACTIVITY_NAME.equals(str)) {
                C7829h.m48406a(C7560ou.this.f35195d, packageName, AnalyticsEventType.AD_CLICK, C7560ou.this.f35193b.m41585m(), "");
            } else {
                C7829h.m48406a(C7560ou.this.f35195d, packageName, AnalyticsEventType.AD_CLICK, C7560ou.this.f35193b.m41585m(), str);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$12 */
    public class AnonymousClass12 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f35206a;

        /* renamed from: b */
        final /* synthetic */ EventRecord f35207b;

        /* renamed from: c */
        final /* synthetic */ C7587b f35208c;

        public AnonymousClass12(int i10, EventRecord eventRecord, C7587b c7587b) {
            i = i10;
            eventRecord = eventRecord;
            c7587b = c7587b;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strM46497a;
            boolean z10 = false;
            if (!C7560ou.this.m46537b(i)) {
                C7560ou.this.m46513a(eventRecord, EventType.CLICK, c7587b);
                C7560ou.this.m46546c(c7587b.m46896j());
                strM46497a = "";
            } else {
                if (C7560ou.this.f35193b == null) {
                    return;
                }
                C7560ou c7560ou = C7560ou.this;
                strM46497a = c7560ou.m46497a(c7560ou.f35193b, eventRecord.m41752j(), i);
                AbstractC7185ho.m43820b("EventProcessor", "onAdClick key: " + strM46497a);
                if (C7560ou.this.f35196e.m45249a(C7560ou.this.f35193b.m41552f(), strM46497a)) {
                    AbstractC7185ho.m43820b("EventProcessor", "onAdClick repeated event");
                    if (C7560ou.this.f35194c.mo43027E()) {
                        EventRecord eventRecord = eventRecord;
                        EventType eventType = EventType.REPEATEDCLICK;
                        eventRecord.m41727c(eventType.value());
                        C7560ou.this.m46513a(eventRecord, eventType, c7587b);
                    }
                    z10 = true;
                } else {
                    AbstractC7185ho.m43820b("EventProcessor", "onAdClick report event");
                    C7560ou.this.m46513a(eventRecord, EventType.CLICK, c7587b);
                    C7560ou.this.m46546c(c7587b.m46896j());
                }
            }
            C7560ou.this.m46522a(EventType.CLICK.value(), i, strM46497a, z10);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$13 */
    public class AnonymousClass13 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C6921b f35210a;

        /* renamed from: b */
        final /* synthetic */ boolean f35211b;

        /* renamed from: c */
        final /* synthetic */ ContentRecord f35212c;

        /* renamed from: d */
        final /* synthetic */ boolean f35213d;

        public AnonymousClass13(C6921b c6921b, boolean z10, ContentRecord contentRecord, boolean z11) {
            c6921b = c6921b;
            z = z10;
            contentRecord = contentRecord;
            z = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C7560ou c7560ou = C7560ou.this;
                EventType eventType = EventType.ANALYSIS;
                EventRecord eventRecordM46495a = c7560ou.m46495a(eventType, c6921b);
                if (C7560ou.m46539b(eventRecordM46495a, eventType)) {
                    return;
                }
                InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(C7560ou.this.f35195d, C7560ou.this.f35192a, eventType);
                interfaceC7604qfM47019a.mo47014c(eventRecordM46495a.m41752j() + "_" + c6921b.m38812aL(), eventRecordM46495a, z, contentRecord);
                if (z) {
                    interfaceC7604qfM47019a.mo47015e();
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43826d("EventProcessor", "onThirdPartException onAnalysis.addEventToCache exception");
                AbstractC7185ho.m43815a(5, th2);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$14 */
    public class AnonymousClass14 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C6921b f35215a;

        /* renamed from: b */
        final /* synthetic */ boolean f35216b;

        /* renamed from: c */
        final /* synthetic */ boolean f35217c;

        /* renamed from: d */
        final /* synthetic */ ContentRecord f35218d;

        public AnonymousClass14(C6921b c6921b, boolean z10, boolean z11, ContentRecord contentRecord) {
            c6921b = c6921b;
            z = z10;
            z = z11;
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C7560ou c7560ou = C7560ou.this;
                EventType eventType = EventType.ANALYSIS;
                EventRecord eventRecordM46495a = c7560ou.m46495a(eventType, c6921b);
                if (C7560ou.m46539b(eventRecordM46495a, eventType)) {
                    return;
                }
                InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(C7560ou.this.f35195d, C7560ou.this.f35192a, eventType);
                String str = eventRecordM46495a.m41752j() + "_" + c6921b.m38812aL();
                if (z) {
                    interfaceC7604qfM47019a.mo47011a(str, eventRecordM46495a, z, contentRecord);
                } else {
                    interfaceC7604qfM47019a.mo47013b(str, eventRecordM46495a, z, contentRecord);
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43826d("EventProcessor", "onAnalysis.addEventToCache exception");
                AbstractC7185ho.m43815a(5, th2);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$15 */
    public class AnonymousClass15 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ EventRecord f35220a;

        /* renamed from: b */
        final /* synthetic */ ContentRecord f35221b;

        public AnonymousClass15(EventRecord eventRecord, ContentRecord contentRecord) {
            eventRecord = eventRecord;
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractC7760bg.m47767a(C7607qi.m47022a(eventRecord.m41752j(), contentRecord, C7560ou.this.f35195d))) {
                AbstractC7185ho.m43817a("EventProcessor", "serve monitor is empty, cancel report ad serve event.");
                return;
            }
            int iM46471j = AbstractC7558os.m46471j(C7560ou.this.f35193b.m41427W());
            C7560ou c7560ou = C7560ou.this;
            String strM46497a = c7560ou.m46497a(c7560ou.f35193b, eventRecord.m41752j(), iM46471j);
            AbstractC7185ho.m43820b("EventProcessor", "onAdServe key: " + strM46497a);
            if (C7560ou.this.f35196e.m45249a(C7560ou.this.f35193b.m41552f(), strM46497a)) {
                AbstractC7185ho.m43820b("EventProcessor", "onAdServe second + time serve: don't report event");
                return;
            }
            AbstractC7185ho.m43820b("EventProcessor", "onAdServe first time serve: report  event");
            Context context = C7560ou.this.f35195d;
            InterfaceC7671st interfaceC7671st = C7560ou.this.f35192a;
            EventType eventType = EventType.SERVE;
            AbstractC7603qe.m47019a(context, interfaceC7671st, eventType).mo47011a(eventType.value(), eventRecord, true, C7560ou.this.f35193b);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f35223a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC7623qy f35224b;

        public AnonymousClass2(List list, InterfaceC7623qy interfaceC7623qy) {
            list = list;
            interfaceC7623qy = interfaceC7623qy;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (C6921b c6921b : list) {
                    C7560ou c7560ou = C7560ou.this;
                    EventType eventType = EventType.ANALYSIS;
                    EventRecord eventRecordM46495a = c7560ou.m46495a(eventType, c6921b);
                    if (C7560ou.m46539b(eventRecordM46495a, eventType)) {
                        return;
                    } else {
                        arrayList.add(eventRecordM46495a);
                    }
                }
                EventReportRsp eventReportRspMo43270a = C7560ou.this.f35197f.mo43270a(AbstractC7572pf.m46750a(arrayList, C7560ou.this.f35195d));
                if (C7560ou.m46548c(eventReportRspMo43270a) && C7560ou.this.m46538b(eventReportRspMo43270a)) {
                    interfaceC7623qy.mo30246a();
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43826d("EventProcessor", "onRealTimeAnalysis exception");
                AbstractC7185ho.m43815a(5, th2);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f35226a;

        public AnonymousClass3(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7560ou.this.f35193b == null) {
                AbstractC7185ho.m43826d("EventProcessor", "contentRecord is null, can't report HA show event");
            } else {
                C7829h.m48406a(C7560ou.this.f35195d, C7560ou.this.f35195d.getPackageName(), AnalyticsEventType.AD_REWARD, C7560ou.this.f35193b.m41585m(), str);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7603qe.m47019a(C7560ou.this.f35195d, C7560ou.this.f35192a, EventType.SHOW).mo47015e();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ PostBackEvent f35229a;

        public AnonymousClass5(PostBackEvent postBackEvent) {
            postBackEvent = postBackEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strM40392b = postBackEvent.m40392b();
            boolean zM42953a = C7096el.m42953a(strM40392b);
            boolean zM46565g = C7560ou.this.m46565g(strM40392b);
            if (zM42953a && zM46565g) {
                C7560ou.this.m46530b(postBackEvent);
                return;
            }
            if (zM42953a || zM46565g) {
                C7560ou.this.m46530b(postBackEvent);
            }
            C7560ou.this.m46502a(postBackEvent);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$6 */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C6921b f35231a;

        public AnonymousClass6(C6921b c6921b) {
            c6921b = c6921b;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C7560ou c7560ou = C7560ou.this;
                EventType eventType = EventType.ANALYSIS;
                EventRecord eventRecordM46495a = c7560ou.m46495a(eventType, c6921b);
                if (C7560ou.m46539b(eventRecordM46495a, eventType)) {
                    return;
                }
                AbstractC7603qe.m47019a(C7560ou.this.f35195d, C7560ou.this.f35192a, eventType).mo47009a(eventRecordM46495a.m41752j() + "_" + c6921b.m38812aL(), eventRecordM46495a);
            } catch (Throwable th2) {
                AbstractC7185ho.m43826d("EventProcessor", "onAnalysis.onAppDataCollectionAnalysis exception");
                AbstractC7185ho.m43815a(5, th2);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$7 */
    public class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ EventRecord f35233a;

        /* renamed from: b */
        final /* synthetic */ boolean f35234b;

        /* renamed from: c */
        final /* synthetic */ boolean f35235c;

        public AnonymousClass7(EventRecord eventRecord, boolean z10, boolean z11) {
            eventRecord = eventRecord;
            z = z10;
            z = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                EventRecord eventRecord = eventRecord;
                if (eventRecord == null) {
                    AbstractC7185ho.m43820b("EventProcessor", "eventRecord is null");
                    return;
                }
                String strM41752j = eventRecord.m41752j();
                if (!C7560ou.this.m46492A()) {
                    AbstractC7185ho.m43820b("EventProcessor", "enableUserInfo is closed");
                    return;
                }
                InterfaceC7604qf interfaceC7604qfM47020a = AbstractC7603qe.m47020a(C7560ou.this.f35195d, C7560ou.this.f35192a, strM41752j);
                if (z) {
                    interfaceC7604qfM47020a.mo47011a(strM41752j, eventRecord, z, C7560ou.this.f35193b);
                } else {
                    interfaceC7604qfM47020a.mo47013b(strM41752j, eventRecord, z, C7560ou.this.f35193b);
                }
            } catch (Throwable unused) {
                AbstractC7185ho.m43826d("EventProcessor", "onCommonReport exception");
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$8 */
    public class AnonymousClass8 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ EventType f35237a;

        /* renamed from: b */
        final /* synthetic */ int f35238b;

        /* renamed from: c */
        final /* synthetic */ EventRecord f35239c;

        /* renamed from: d */
        final /* synthetic */ C7586a f35240d;

        /* renamed from: e */
        final /* synthetic */ C7559ot f35241e;

        public AnonymousClass8(EventType eventType, int i10, EventRecord eventRecord, C7586a c7586a, C7559ot c7559ot) {
            eventType = eventType;
            i = i10;
            eventRecord = eventRecord;
            c7586a = c7586a;
            c7559ot = c7559ot;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strM46497a;
            EventType eventType = eventType;
            EventType eventType2 = EventType.SHOW;
            boolean z10 = false;
            if (!eventType.equals(eventType2) || !C7560ou.this.m46537b(i)) {
                if (eventType.equals(eventType2)) {
                    C7560ou.this.m46512a(eventRecord, eventType, c7586a, c7559ot);
                    C7560ou.this.m46536b(c7586a.m46854f());
                } else {
                    C7560ou.this.m46512a(eventRecord, eventType, c7586a, c7559ot);
                }
                strM46497a = "";
            } else {
                if (C7560ou.this.f35193b == null) {
                    return;
                }
                C7560ou c7560ou = C7560ou.this;
                strM46497a = c7560ou.m46497a(c7560ou.f35193b, eventType.value(), i);
                AbstractC7185ho.m43820b("EventProcessor", "onAdImp key: " + strM46497a);
                if (C7560ou.this.f35196e.m45249a(C7560ou.this.f35193b.m41552f(), strM46497a)) {
                    AbstractC7185ho.m43820b("EventProcessor", "onAdImp repeated event");
                    if (C7560ou.this.f35194c.mo43027E()) {
                        EventRecord eventRecord = eventRecord;
                        EventType eventType3 = EventType.REPEATEDIMP;
                        eventRecord.m41727c(eventType3.value());
                        C7560ou.this.m46512a(eventRecord, eventType3, c7586a, c7559ot);
                    } else {
                        C7560ou.this.m46493B();
                    }
                    z10 = true;
                } else {
                    AbstractC7185ho.m43820b("EventProcessor", "onAdImp report event");
                    C7560ou.this.m46512a(eventRecord, eventType, c7586a, c7559ot);
                    C7560ou.this.m46536b(c7586a.m46854f());
                    C7560ou c7560ou2 = C7560ou.this;
                    c7560ou2.m46531b(c7560ou2.f35193b);
                }
            }
            if (eventType.equals(eventType2)) {
                C7560ou.this.m46522a(eventType.value(), i, strM46497a, z10);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ou$9 */
    public class AnonymousClass9 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35243a;

        public AnonymousClass9(ContentRecord contentRecord) {
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7105eu.m43130a(C7560ou.this.f35195d).mo43143d(contentRecord.m41588n());
        }
    }

    public C7560ou(Context context, InterfaceC7671st interfaceC7671st) {
        this(context, interfaceC7671st, null);
    }

    /* renamed from: A */
    public boolean m46492A() {
        return this.f35194c.mo43345aL();
    }

    /* renamed from: B */
    public void m46493B() {
        AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.ou.4
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7603qe.m47019a(C7560ou.this.f35195d, C7560ou.this.f35192a, EventType.SHOW).mo47015e();
            }
        }, 100L);
    }

    /* renamed from: c */
    private AdEventReport m46542c(ContentRecord contentRecord) {
        AdEventReport adEventReport = new AdEventReport();
        if (contentRecord != null) {
            adEventReport.m39301a(contentRecord.m41552f());
            adEventReport.m39302a(contentRecord.m41588n());
            adEventReport.m39307b(contentRecord.m41577k());
            adEventReport.m39310c(contentRecord.m41486ah());
            adEventReport.m39312d(contentRecord.m41494ap());
        }
        return adEventReport;
    }

    /* renamed from: d */
    private PostBackEvent m46551d(EventRecord eventRecord) {
        if (eventRecord == null) {
            return null;
        }
        PostBackEvent postBackEvent = new PostBackEvent();
        postBackEvent.m40391a(eventRecord.m41714ak());
        postBackEvent.m40393b(eventRecord.m41761m());
        ContentRecord contentRecord = this.f35193b;
        postBackEvent.m40395b(contentRecord != null ? contentRecord.m41585m() : "");
        postBackEvent.m40401e(eventRecord.m41752j());
        postBackEvent.m40397c(eventRecord.m41687R());
        postBackEvent.m40399d(eventRecord.m41758l());
        postBackEvent.m40389a(eventRecord.m41744h());
        postBackEvent.m40390a(eventRecord.m41718b());
        postBackEvent.m40394b(eventRecord.m41755k());
        postBackEvent.m40403f(eventRecord.m41688S());
        return postBackEvent;
    }

    /* renamed from: v */
    private boolean m46569v() {
        ContentRecord contentRecord = this.f35193b;
        return C7780c.m47866a(contentRecord == null ? null : contentRecord.m41514ba());
    }

    /* renamed from: w */
    private void m46570w() {
        C7578pl c7578pl = new C7578pl(this.f35195d);
        c7578pl.m46777a(this.f35193b);
        c7578pl.m46776a();
    }

    /* renamed from: x */
    private boolean m46571x() {
        ContentRecord contentRecord = this.f35193b;
        if (contentRecord == null) {
            return false;
        }
        boolean zM45347a = C7340jn.m45347a(contentRecord.m41588n());
        AbstractC7185ho.m43818a("EventProcessor", "sdkMonitor is %s, cr sdkMonitor is %s, isDoNothing is %s", Integer.valueOf(this.f35199h), Integer.valueOf(this.f35193b.m41505b()), Boolean.valueOf(zM45347a));
        return (this.f35199h == this.f35193b.m41505b() || !C7340jn.m45345a(this.f35193b.m41505b()) || zM45347a) ? false : true;
    }

    /* renamed from: y */
    private boolean m46572y() {
        ContentRecord contentRecord = this.f35193b;
        return contentRecord != null && (3 == contentRecord.m41464aP() || 99 == this.f35193b.m41392E());
    }

    /* renamed from: z */
    private int m46573z() {
        int iMo43296a = this.f35198g.mo43296a();
        int iMo43300b = this.f35198g.mo43300b();
        if (iMo43296a < 0 || iMo43300b <= 0 || iMo43296a >= iMo43300b) {
            iMo43296a = 0;
            iMo43300b = 2000;
        }
        int iM48040a = C7789ci.m48040a(iMo43300b, iMo43296a);
        AbstractC7185ho.m43821b("EventProcessor", "clk millis: %s", Integer.valueOf(iM48040a));
        return iM48040a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public ContentRecord mo46574a() {
        return this.f35193b;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: e */
    public void mo46622e() {
        m46503a(EventType.REPLAY, -111111L, -111111L, -111111, -111111, (String) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: h */
    public void mo46625h() {
        Context context = this.f35195d;
        InterfaceC7671st interfaceC7671st = this.f35192a;
        EventType eventType = EventType.WEBLOADFINISH;
        AbstractC7603qe.m47019a(context, interfaceC7671st, eventType).mo47012b(eventType.value(), m46529b(eventType), this.f35193b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: i */
    public void mo46626i() {
        Context context = this.f35195d;
        InterfaceC7671st interfaceC7671st = this.f35192a;
        EventType eventType = EventType.SWIPEUP;
        AbstractC7603qe.m47019a(context, interfaceC7671st, eventType).mo47012b(eventType.value(), m46529b(eventType), this.f35193b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: j */
    public void mo46627j() {
        Context context = this.f35195d;
        InterfaceC7671st interfaceC7671st = this.f35192a;
        EventType eventType = EventType.REMOVE;
        AbstractC7603qe.m47019a(context, interfaceC7671st, eventType).mo47012b(eventType.value(), m46529b(eventType), this.f35193b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: k */
    public void mo46628k() {
        Context context = this.f35195d;
        InterfaceC7671st interfaceC7671st = this.f35192a;
        EventType eventType = EventType.SHARE;
        AbstractC7603qe.m47019a(context, interfaceC7671st, eventType).mo47012b(eventType.value(), m46529b(eventType), this.f35193b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: l */
    public void mo46629l() {
        Context context = this.f35195d;
        InterfaceC7671st interfaceC7671st = this.f35192a;
        EventType eventType = EventType.FAVORITE;
        AbstractC7603qe.m47019a(context, interfaceC7671st, eventType).mo47012b(eventType.value(), m46529b(eventType), this.f35193b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: m */
    public void mo46630m() {
        Context context = this.f35195d;
        InterfaceC7671st interfaceC7671st = this.f35192a;
        EventType eventType = EventType.SHOWEND;
        AbstractC7603qe.m47019a(context, interfaceC7671st, eventType).mo47012b(eventType.value(), m46529b(eventType), this.f35193b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: n */
    public void mo46631n() {
        EventType eventType = EventType.RESPONSE;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        eventRecordM46529b.m41731d((String) null);
        m46532b(eventRecordM46529b);
        m46510a(eventRecordM46529b);
        AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType).mo47012b(eventType.value(), eventRecordM46529b, this.f35193b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: o */
    public void mo46632o() {
        EventType eventType = EventType.ADLOADED;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        eventRecordM46529b.m41731d((String) null);
        AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType).mo47012b(eventType.value(), eventRecordM46529b, this.f35193b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: p */
    public void mo46633p() {
        EventType eventType = EventType.SERVE;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.ou.15

            /* renamed from: a */
            final /* synthetic */ EventRecord f35220a;

            /* renamed from: b */
            final /* synthetic */ ContentRecord f35221b;

            public AnonymousClass15(EventRecord eventRecordM46529b2, ContentRecord contentRecord) {
                eventRecord = eventRecordM46529b2;
                contentRecord = contentRecord;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC7760bg.m47767a(C7607qi.m47022a(eventRecord.m41752j(), contentRecord, C7560ou.this.f35195d))) {
                    AbstractC7185ho.m43817a("EventProcessor", "serve monitor is empty, cancel report ad serve event.");
                    return;
                }
                int iM46471j = AbstractC7558os.m46471j(C7560ou.this.f35193b.m41427W());
                C7560ou c7560ou = C7560ou.this;
                String strM46497a = c7560ou.m46497a(c7560ou.f35193b, eventRecord.m41752j(), iM46471j);
                AbstractC7185ho.m43820b("EventProcessor", "onAdServe key: " + strM46497a);
                if (C7560ou.this.f35196e.m45249a(C7560ou.this.f35193b.m41552f(), strM46497a)) {
                    AbstractC7185ho.m43820b("EventProcessor", "onAdServe second + time serve: don't report event");
                    return;
                }
                AbstractC7185ho.m43820b("EventProcessor", "onAdServe first time serve: report  event");
                Context context = C7560ou.this.f35195d;
                InterfaceC7671st interfaceC7671st = C7560ou.this.f35192a;
                EventType eventType2 = EventType.SERVE;
                AbstractC7603qe.m47019a(context, interfaceC7671st, eventType2).mo47011a(eventType2.value(), eventRecord, true, C7560ou.this.f35193b);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: q */
    public void mo46634q() {
        m46544c(EventType.VASTFIRSTQURAT);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: r */
    public void mo46635r() {
        m46544c(EventType.VASTMIDPOINT);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: s */
    public void mo46636s() {
        m46544c(EventType.VASTTHIRDQUART);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: t */
    public void mo46637t() {
        m46544c(EventType.VASTPLAYSTART);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: u */
    public void mo46638u() {
        m46544c(EventType.VASTPLAYCOMPLETE);
    }

    public C7560ou(Context context, InterfaceC7671st interfaceC7671st, ContentRecord contentRecord) {
        Context applicationContext = context.getApplicationContext();
        this.f35195d = applicationContext;
        this.f35192a = interfaceC7671st;
        this.f35194c = C7124fh.m43316b(applicationContext);
        this.f35197f = C7118fb.m43196a(this.f35195d);
        this.f35193b = contentRecord;
        this.f35196e = C7329jc.m45247a(this.f35195d);
        this.f35198g = C7121fe.m43293a(this.f35195d);
    }

    /* renamed from: b */
    private EventRecord m46529b(EventType eventType) {
        if (eventType != null) {
            return m46552d(eventType.value());
        }
        AbstractC7185ho.m43826d("EventProcessor", "event is null");
        return null;
    }

    /* renamed from: d */
    private EventRecord m46552d(String str) {
        if (this.f35193b == null || !m46492A()) {
            AbstractC7185ho.m43827d("EventProcessor", "fail to create %s event record", str);
            return null;
        }
        EventRecord eventRecord = new EventRecord();
        eventRecord.m41727c(str);
        eventRecord.m41729d(this.f35192a.mo47212a());
        eventRecord.m41700a(this.f35193b.m41395G());
        eventRecord.m41730d(AbstractC7741ao.m47566c());
        eventRecord.m41731d(this.f35193b.m41577k());
        eventRecord.m41857a(this.f35193b.m41859br());
        eventRecord.m41749i(this.f35193b.m41492an());
        eventRecord.m41788y(this.f35193b.m41486ah());
        eventRecord.m41786x(this.f35193b.m41588n());
        eventRecord.m41738f(this.f35193b.m41460aL());
        eventRecord.m41765n(this.f35193b.m41472aX());
        String strM41520bg = this.f35193b.m41520bg();
        if (TextUtils.isEmpty(strM41520bg)) {
            strM41520bg = this.f35195d.getPackageName();
        }
        eventRecord.m41674F(strM41520bg);
        if (EventType.SHOW.value().equals(str) || EventType.SUPPLEMENTIMP.value().equals(str)) {
            eventRecord.m41784w(this.f35193b.m41494ap());
        }
        if (EventType.VIDEOTIME.value().equals(str)) {
            eventRecord.m41742g(this.f35193b.m41519bf());
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("EventProcessor", "create event, type is : %s, rt : %d", str, Integer.valueOf(this.f35193b.m41492an()));
        }
        return eventRecord;
    }

    /* renamed from: i */
    private void m46568i(C7587b c7587b) {
        AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.ou.10

            /* renamed from: a */
            final /* synthetic */ C7587b f35202a;

            public AnonymousClass10(C7587b c7587b2) {
                c7587b = c7587b2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7560ou.this.m46561f(c7587b);
            }
        }, m46573z());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: f */
    public void mo46623f() {
        m46503a(EventType.VIDEOPLAYRESUME, -111111L, -111111L, -111111, -111111, (String) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: g */
    public void mo46624g() {
        Context context = this.f35195d;
        InterfaceC7671st interfaceC7671st = this.f35192a;
        EventType eventType = EventType.WEBOPEN;
        AbstractC7603qe.m47019a(context, interfaceC7671st, eventType).mo47012b(eventType.value(), m46529b(eventType), this.f35193b);
    }

    /* renamed from: a */
    public EventRecord m46495a(EventType eventType, C6921b c6921b) {
        String str;
        try {
            if (!m46492A()) {
                return null;
            }
            EventRecord eventRecord = new EventRecord();
            String strM47959ab = C7787cg.m47900a(this.f35195d).m47959ab();
            if (strM47959ab != null) {
                c6921b.m38973aj(strM47959ab);
            } else {
                ContentRecord contentRecord = this.f35193b;
                if (contentRecord != null) {
                    c6921b.m38973aj(contentRecord.m41529bp());
                }
            }
            eventRecord.m41729d(c6921b.m39040t() != null ? c6921b.m39040t().intValue() : -1);
            eventRecord.m41727c(eventType.value());
            eventRecord.m41730d(AbstractC7741ao.m47566c());
            eventRecord.m41735e(c6921b.m38952aJ());
            eventRecord.m41749i(c6921b.m38909N());
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("EventProcessor", "ExceptionType is %s, TrackVersion is %s", c6921b.m38812aL(), c6921b.m38951aI());
            }
            AbstractC7185ho.m43821b("EventProcessor", "create event, type is : %s, rt : %d", eventType + " " + c6921b.toString(), Integer.valueOf(c6921b.m38909N()));
            return eventRecord;
        } catch (RuntimeException unused) {
            str = "createAnalysisEvent RuntimeException";
            AbstractC7185ho.m43826d("EventProcessor", str);
            return null;
        } catch (Exception unused2) {
            str = "createAnalysisEvent error";
            AbstractC7185ho.m43826d("EventProcessor", str);
            return null;
        }
    }

    /* renamed from: e */
    private void m46558e(C7587b c7587b) {
        new C6922c(this.f35195d).m39083a(c7587b, this.f35193b);
    }

    /* renamed from: f */
    public void m46561f(C7587b c7587b) {
        if (this.f35193b == null) {
            return;
        }
        EventType eventTypeM46899m = c7587b.m46899m();
        EventRecord eventRecordM46529b = m46529b(eventTypeM46899m);
        if (m46539b(eventRecordM46529b, eventTypeM46899m)) {
            return;
        }
        if (c7587b.m46894h() != null) {
            m46564g(c7587b);
            m46514a(c7587b.m46894h());
            if (c7587b.m46894h().m44501a() != null) {
                eventRecordM46529b.m41701a(c7587b.m46894h().m44501a());
            }
            if (c7587b.m46894h().m44506b() != null) {
                eventRecordM46529b.m41721b(c7587b.m46894h().m44506b());
            }
            if (c7587b.m46894h().m44508c() != null) {
                eventRecordM46529b.m41667B(c7587b.m46894h().m44508c());
            }
            if (c7587b.m46894h().m44516g() != null) {
                eventRecordM46529b.m41697a(c7587b.m46894h().m44516g().floatValue());
            }
            if (c7587b.m46894h().m44510d() != null) {
                eventRecordM46529b.m41756k(c7587b.m46894h().m44510d().intValue());
            }
            if (c7587b.m46894h().m44512e() != null) {
                eventRecordM46529b.m41759l(c7587b.m46894h().m44512e().intValue());
            }
            if (c7587b.m46894h().m44514f() != null) {
                eventRecordM46529b.m41762m(c7587b.m46894h().m44514f().intValue());
            }
            if (c7587b.m46894h().m44518i() != null) {
                eventRecordM46529b.m41746h(c7587b.m46894h().m44518i().longValue());
            }
            if (c7587b.m46894h().m44517h() != null) {
                eventRecordM46529b.m41750i(c7587b.m46894h().m44517h().longValue());
            }
            if (!AbstractC7806cz.m48165b(c7587b.m46894h().m44520k())) {
                eventRecordM46529b.m41676G(c7587b.m46894h().m44520k());
            }
        }
        eventRecordM46529b.m41780u(c7587b.m46895i());
        eventRecordM46529b.m41665A(c7587b.m46898l());
        if (m46540b(c7587b)) {
            m46501a(AbstractC7558os.m46471j(this.f35193b.m41427W()), eventRecordM46529b, c7587b);
        } else {
            AbstractC7185ho.m43817a("EventProcessor", "is not a valid click");
            m46558e(c7587b);
        }
    }

    /* renamed from: g */
    private void m46564g(C7587b c7587b) {
        Integer numM44510d = c7587b.m46894h().m44510d();
        if (numM44510d == null) {
            return;
        }
        AbstractC7185ho.m43818a("EventProcessor", "adaptOldVersionSld orgSld is %s", numM44510d);
        if (numM44510d.intValue() == 3 && m46550c(c7587b) && !AbstractC7741ao.m47586i() && !m46541b(c7587b.m46893g())) {
            c7587b.m46894h().m44509c(5);
        }
    }

    /* renamed from: h */
    private boolean m46567h(C7587b c7587b) {
        if (m46569v() && c7587b != null && c7587b.m46889c()) {
            Integer numM46893g = c7587b.m46893g();
            if (numM46893g == null) {
                return true;
            }
            if (numM46893g.intValue() != 12 && numM46893g.intValue() != 13) {
                AbstractC7185ho.m43817a("EventProcessor", "is need delay");
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: b */
    public void mo46606b() {
        m46605a(true);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: c */
    public void mo46616c() {
        m46503a(EventType.VIDEOPLAYSTART, -111111L, -111111L, -111111, -111111, (String) null);
    }

    /* renamed from: e */
    private void m46559e(String str) {
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.ou.3

            /* renamed from: a */
            final /* synthetic */ String f35226a;

            public AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C7560ou.this.f35193b == null) {
                    AbstractC7185ho.m43826d("EventProcessor", "contentRecord is null, can't report HA show event");
                } else {
                    C7829h.m48406a(C7560ou.this.f35195d, C7560ou.this.f35195d.getPackageName(), AnalyticsEventType.AD_REWARD, C7560ou.this.f35193b.m41585m(), str);
                }
            }
        });
    }

    /* renamed from: f */
    private void m46562f(String str) {
        ContentRecord contentRecord = this.f35193b;
        if (contentRecord != null) {
            int iM41472aX = contentRecord.m41472aX();
            AbstractC7185ho.m43818a("EventProcessor", "onAdRecallReport, eventType:%s, recallSource:%s", str, Integer.valueOf(iM41472aX));
            if (iM41472aX == 1) {
                new C6922c(this.f35195d).mo39114b(this.f35193b, str);
            }
        }
    }

    /* renamed from: g */
    public boolean m46565g(String str) {
        return C6982bz.m41152b(this.f35195d) && 1 == C7123fg.m43308a(this.f35195d).mo43313b(str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: b */
    public void mo46607b(int i10, int i11) {
        EventType eventType = EventType.SKIP;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        eventRecordM46529b.m41733e(i10);
        eventRecordM46529b.m41737f(i11);
        ContentRecord contentRecord = this.f35193b;
        if (contentRecord == null || !contentRecord.m41495aq()) {
            AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType).mo47011a(eventType.value(), eventRecordM46529b, false, this.f35193b);
            this.f35192a.mo47224d();
        } else {
            AbstractC7185ho.m43817a("EventProcessor", "report exsplash close event");
            AdEventReport adEventReportM46542c = m46542c(this.f35193b);
            adEventReportM46542c.m39306b(i10);
            adEventReportM46542c.m39309c(i11);
            C7484ms.m45854a(this.f35195d).m45855a(MapKeyNames.REPORT_CLOSE_EVENT, AbstractC7758be.m47742b(adEventReportM46542c), null, null);
        }
        m46545c(eventRecordM46529b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: c */
    public void mo46617c(long j10, long j11, int i10, int i11) {
        m46503a(EventType.VIDEOPLAYEND, j10, j11, i10, i11, (String) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: d */
    public void mo46620d() {
        m46503a(EventType.PLAYBTNSTART, -111111L, -111111L, -111111, -111111, (String) null);
    }

    /* renamed from: a */
    public String m46497a(ContentRecord contentRecord, String str, int i10) {
        StringBuilder sb2 = new StringBuilder();
        if (contentRecord == null) {
            return sb2.toString();
        }
        sb2.append(contentRecord.m41552f());
        sb2.append("_");
        sb2.append(contentRecord.m41588n());
        sb2.append("_");
        String strM41486ah = contentRecord.m41486ah();
        if (!TextUtils.isEmpty(strM41486ah)) {
            sb2.append(strM41486ah);
            sb2.append("_");
        }
        if (i10 == 2 || (i10 == 1 && TextUtils.isEmpty(strM41486ah))) {
            sb2.append(contentRecord.m41577k());
            sb2.append("_");
        }
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: c */
    private void m46544c(EventType eventType) {
        ContentRecord contentRecord = this.f35193b;
        if (contentRecord == null || eventType == null) {
            return;
        }
        String strM46497a = m46497a(this.f35193b, eventType.value(), AbstractC7558os.m46471j(contentRecord.m41427W()));
        AbstractC7185ho.m43821b("EventProcessor", "vastMonitor, key: %s", strM46497a);
        if (!this.f35196e.m45249a(this.f35193b.m41552f(), strM46497a)) {
            m46554d(eventType);
        } else if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("EventProcessor", "event %s has reported", eventType.value());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: b */
    public void mo46608b(long j10, long j11, int i10, int i11) {
        m46503a(EventType.VIDEOPLAYPAUSE, j10, j11, i10, i11, (String) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: d */
    public void mo46621d(long j10, long j11, int i10, int i11) {
        m46503a(EventType.EASTEREGGEND, j10, j11, i10, i11, (String) null);
    }

    /* renamed from: c */
    private void m46545c(EventRecord eventRecord) {
        PostBackEvent postBackEventM46551d = m46551d(eventRecord);
        if (postBackEventM46551d == null || C7845x.m48576j(this.f35195d)) {
            return;
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ou.5

            /* renamed from: a */
            final /* synthetic */ PostBackEvent f35229a;

            public AnonymousClass5(PostBackEvent postBackEventM46551d2) {
                postBackEvent = postBackEventM46551d2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String strM40392b = postBackEvent.m40392b();
                boolean zM42953a = C7096el.m42953a(strM40392b);
                boolean zM46565g = C7560ou.this.m46565g(strM40392b);
                if (zM42953a && zM46565g) {
                    C7560ou.this.m46530b(postBackEvent);
                    return;
                }
                if (zM42953a || zM46565g) {
                    C7560ou.this.m46530b(postBackEvent);
                }
                C7560ou.this.m46502a(postBackEvent);
            }
        });
    }

    /* renamed from: d */
    private void m46554d(EventType eventType) {
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (eventRecordM46529b == null) {
            return;
        }
        AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType).mo47008a(eventRecordM46529b, this.f35193b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: b */
    public void mo46609b(C6921b c6921b, boolean z10, boolean z11) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ou.14

            /* renamed from: a */
            final /* synthetic */ C6921b f35215a;

            /* renamed from: b */
            final /* synthetic */ boolean f35216b;

            /* renamed from: c */
            final /* synthetic */ boolean f35217c;

            /* renamed from: d */
            final /* synthetic */ ContentRecord f35218d;

            public AnonymousClass14(C6921b c6921b2, boolean z102, boolean z112, ContentRecord contentRecord) {
                c6921b = c6921b2;
                z = z102;
                z = z112;
                contentRecord = contentRecord;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    C7560ou c7560ou = C7560ou.this;
                    EventType eventType = EventType.ANALYSIS;
                    EventRecord eventRecordM46495a = c7560ou.m46495a(eventType, c6921b);
                    if (C7560ou.m46539b(eventRecordM46495a, eventType)) {
                        return;
                    }
                    InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(C7560ou.this.f35195d, C7560ou.this.f35192a, eventType);
                    String str = eventRecordM46495a.m41752j() + "_" + c6921b.m38812aL();
                    if (z) {
                        interfaceC7604qfM47019a.mo47011a(str, eventRecordM46495a, z, contentRecord);
                    } else {
                        interfaceC7604qfM47019a.mo47013b(str, eventRecordM46495a, z, contentRecord);
                    }
                } catch (Throwable th2) {
                    AbstractC7185ho.m43826d("EventProcessor", "onAnalysis.addEventToCache exception");
                    AbstractC7185ho.m43815a(5, th2);
                }
            }
        });
    }

    /* renamed from: b */
    public void m46530b(PostBackEvent postBackEvent) {
        if (postBackEvent == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(postBackEvent.m40392b());
            if (!C7790cj.m48046a(this.f35195d, 1, arrayList)) {
                AbstractC7185ho.m43818a("EventProcessor", "%s not support recommend engine", postBackEvent.m40392b());
                return;
            }
            if (AbstractC7806cz.m48165b(postBackEvent.m40388a())) {
                postBackEvent.m40391a(this.f35195d.getPackageName());
            }
            C7484ms.m45854a(this.f35195d).m45855a(RTCMethods.REPORT_TO_REC_ENGINE, AbstractC7758be.m47742b(postBackEvent), null, null);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("EventProcessor", "report to hms recommend engine: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: d */
    private boolean m46555d(C7586a c7586a) {
        if (!m46569v() || c7586a == null || !c7586a.m46850b() || c7586a.m46860l()) {
            return false;
        }
        AbstractC7185ho.m43818a("EventProcessor", "isSupplementImp(), adShowInfo.impSource= %s", c7586a.m46853e());
        return (C7780c.m47868a(c7586a.m46853e()) || C7780c.m47872b(c7586a.m46853e())) ? false : true;
    }

    /* renamed from: a */
    public void m46575a(int i10) {
        this.f35199h = i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: c */
    public void mo46618c(C7586a c7586a) {
        m46506a(EventType.INTERACTSHOW, c7586a, (C7559ot) null);
    }

    /* renamed from: b */
    public void m46531b(ContentRecord contentRecord) {
        if (contentRecord != null) {
            if ((contentRecord.m41552f() == 1 || contentRecord.m41552f() == 18) && !TextUtils.isEmpty(contentRecord.m41588n())) {
                AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ou.9

                    /* renamed from: a */
                    final /* synthetic */ ContentRecord f35243a;

                    public AnonymousClass9(ContentRecord contentRecord2) {
                        contentRecord = contentRecord2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7105eu.m43130a(C7560ou.this.f35195d).mo43143d(contentRecord.m41588n());
                    }
                });
            }
        }
    }

    /* renamed from: d */
    private boolean m46556d(C7587b c7587b) {
        return !AbstractC7806cz.m48165b(c7587b.m46886a());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46576a(int i10, int i11) {
        m46499a(i10, i11, (List<String>) null, EventType.EASTEREGGCLOSE);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: c */
    public void mo46619c(Integer num, Integer num2, String str, String str2, String str3) {
        m46507a(EventType.APPINSTALLFAIL, num, num2, true, true, str, str2, str3);
    }

    /* renamed from: b */
    private void m46532b(EventRecord eventRecord) {
        ContentRecord contentRecord = this.f35193b;
        if (contentRecord != null) {
            eventRecord.m41772q(contentRecord.m41504az());
        }
    }

    /* renamed from: c */
    public void m46546c(String str) {
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.ou.11

            /* renamed from: a */
            final /* synthetic */ String f35204a;

            public AnonymousClass11(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C7560ou.this.f35193b == null) {
                    AbstractC7185ho.m43826d("EventProcessor", "contentRecord is null, can't report HA show event");
                    return;
                }
                String packageName = C7560ou.this.f35195d.getPackageName();
                if (Constants.REWARD_ACTIVITY_NAME.equals(str) || Constants.INTERSTITIAL_ACTIVITY_NAME.equals(str)) {
                    C7829h.m48406a(C7560ou.this.f35195d, packageName, AnalyticsEventType.AD_CLICK, C7560ou.this.f35193b.m41585m(), "");
                } else {
                    C7829h.m48406a(C7560ou.this.f35195d, packageName, AnalyticsEventType.AD_CLICK, C7560ou.this.f35193b.m41585m(), str);
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46577a(int i10, int i11, List<String> list) {
        m46499a(i10, i11, list, EventType.CLOSE);
    }

    /* renamed from: a */
    private void m46499a(int i10, int i11, List<String> list, EventType eventType) {
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        List<String> arrayList = new ArrayList<>();
        List<String> arrayList2 = new ArrayList<>();
        HashMap map = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ContentRecord contentRecord = this.f35193b;
        if (contentRecord != null) {
            arrayList = contentRecord.m41401J();
            if (!AbstractC7760bg.m47767a(arrayList)) {
                AbstractC7185ho.m43818a("onAdClose", "fullDoseKeyWords: %s", arrayList.toString());
            }
            arrayList2 = this.f35193b.m41403K();
            if (!AbstractC7760bg.m47767a(arrayList2)) {
                AbstractC7185ho.m43818a("onAdClose", "fullDoseKeyWordsType: %s", arrayList2.toString());
            }
        }
        if (!AbstractC7760bg.m47767a(arrayList) && !AbstractC7760bg.m47767a(arrayList2) && arrayList.size() == arrayList2.size()) {
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                map.put(arrayList.get(i12), arrayList2.get(i12));
            }
        }
        if (!map.isEmpty() && !AbstractC7760bg.m47767a(list)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList3.add(map.get(it.next()));
            }
        }
        if (!AbstractC7760bg.m47767a(list)) {
            AbstractC7185ho.m43818a("onAdClose", "selectedKeyWords: %s", list.toString());
        }
        if (!AbstractC7760bg.m47767a(arrayList3)) {
            AbstractC7185ho.m43818a("onAdClose", "selectedKeyWordsType: %s", arrayList3.toString());
        }
        eventRecordM46529b.m41733e(i10);
        eventRecordM46529b.m41737f(i11);
        eventRecordM46529b.m41703a(list);
        eventRecordM46529b.m41723b(arrayList3);
        ContentRecord contentRecord2 = this.f35193b;
        if (contentRecord2 == null || !contentRecord2.m41495aq()) {
            AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType).mo47011a(eventType.value(), eventRecordM46529b, false, this.f35193b);
            if (!EventType.EASTEREGGCLOSE.equals(eventType)) {
                this.f35192a.mo47224d();
            }
        } else {
            AbstractC7185ho.m43817a("EventProcessor", "report exsplash close event");
            AdEventReport adEventReportM46542c = m46542c(this.f35193b);
            adEventReportM46542c.m39306b(i10);
            adEventReportM46542c.m39309c(i11);
            adEventReportM46542c.m39303a(list);
            C7484ms.m45854a(this.f35195d).m45855a(MapKeyNames.REPORT_CLOSE_EVENT, AbstractC7758be.m47742b(adEventReportM46542c), null, null);
        }
        m46545c(eventRecordM46529b);
    }

    /* renamed from: b */
    private void m46533b(MaterialClickInfo materialClickInfo) {
        Integer numM44501a = materialClickInfo.m44501a();
        Integer numValueOf = Integer.valueOf(Constants.COORDINATE_FAIL_DEF);
        if (numM44501a == null || materialClickInfo.m44501a().intValue() == -111111) {
            materialClickInfo.m44503a(numValueOf);
        }
        if (materialClickInfo.m44506b() == null || materialClickInfo.m44506b().intValue() == -111111) {
            materialClickInfo.m44507b(numValueOf);
        }
        if (materialClickInfo.m44512e() == null || materialClickInfo.m44512e().intValue() == -111111) {
            materialClickInfo.m44511d(numValueOf);
        }
        if (materialClickInfo.m44514f() == null || materialClickInfo.m44514f().intValue() == -111111) {
            materialClickInfo.m44513e(numValueOf);
        }
    }

    /* renamed from: c */
    private boolean m46547c(int i10) {
        return i10 == 0 || i10 == 1 || i10 == 3 || i10 == 6;
    }

    /* renamed from: c */
    public static boolean m46548c(EventReportRsp eventReportRsp) {
        return eventReportRsp != null && eventReportRsp.responseCode == 0;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46578a(int i10, long j10) {
        EventType eventType = EventType.WEBCLOSE;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        eventRecordM46529b.m41741g(i10);
        eventRecordM46529b.m41699a(j10);
        AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType).mo47010a(eventType.value(), eventRecordM46529b, this.f35193b);
    }

    /* renamed from: a */
    private void m46500a(int i10, EventType eventType, C7586a c7586a, C7559ot c7559ot) {
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.ou.8

            /* renamed from: a */
            final /* synthetic */ EventType f35237a;

            /* renamed from: b */
            final /* synthetic */ int f35238b;

            /* renamed from: c */
            final /* synthetic */ EventRecord f35239c;

            /* renamed from: d */
            final /* synthetic */ C7586a f35240d;

            /* renamed from: e */
            final /* synthetic */ C7559ot f35241e;

            public AnonymousClass8(EventType eventType2, int i102, EventRecord eventRecordM46529b2, C7586a c7586a2, C7559ot c7559ot2) {
                eventType = eventType2;
                i = i102;
                eventRecord = eventRecordM46529b2;
                c7586a = c7586a2;
                c7559ot = c7559ot2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String strM46497a;
                EventType eventType2 = eventType;
                EventType eventType22 = EventType.SHOW;
                boolean z10 = false;
                if (!eventType2.equals(eventType22) || !C7560ou.this.m46537b(i)) {
                    if (eventType.equals(eventType22)) {
                        C7560ou.this.m46512a(eventRecord, eventType, c7586a, c7559ot);
                        C7560ou.this.m46536b(c7586a.m46854f());
                    } else {
                        C7560ou.this.m46512a(eventRecord, eventType, c7586a, c7559ot);
                    }
                    strM46497a = "";
                } else {
                    if (C7560ou.this.f35193b == null) {
                        return;
                    }
                    C7560ou c7560ou = C7560ou.this;
                    strM46497a = c7560ou.m46497a(c7560ou.f35193b, eventType.value(), i);
                    AbstractC7185ho.m43820b("EventProcessor", "onAdImp key: " + strM46497a);
                    if (C7560ou.this.f35196e.m45249a(C7560ou.this.f35193b.m41552f(), strM46497a)) {
                        AbstractC7185ho.m43820b("EventProcessor", "onAdImp repeated event");
                        if (C7560ou.this.f35194c.mo43027E()) {
                            EventRecord eventRecord = eventRecord;
                            EventType eventType3 = EventType.REPEATEDIMP;
                            eventRecord.m41727c(eventType3.value());
                            C7560ou.this.m46512a(eventRecord, eventType3, c7586a, c7559ot);
                        } else {
                            C7560ou.this.m46493B();
                        }
                        z10 = true;
                    } else {
                        AbstractC7185ho.m43820b("EventProcessor", "onAdImp report event");
                        C7560ou.this.m46512a(eventRecord, eventType, c7586a, c7559ot);
                        C7560ou.this.m46536b(c7586a.m46854f());
                        C7560ou c7560ou2 = C7560ou.this;
                        c7560ou2.m46531b(c7560ou2.f35193b);
                    }
                }
                if (eventType.equals(eventType22)) {
                    C7560ou.this.m46522a(eventType.value(), i, strM46497a, z10);
                }
            }
        });
    }

    /* renamed from: a */
    private void m46501a(int i10, EventRecord eventRecord, C7587b c7587b) {
        if (c7587b == null) {
            return;
        }
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.ou.12

            /* renamed from: a */
            final /* synthetic */ int f35206a;

            /* renamed from: b */
            final /* synthetic */ EventRecord f35207b;

            /* renamed from: c */
            final /* synthetic */ C7587b f35208c;

            public AnonymousClass12(int i102, EventRecord eventRecord2, C7587b c7587b2) {
                i = i102;
                eventRecord = eventRecord2;
                c7587b = c7587b2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String strM46497a;
                boolean z10 = false;
                if (!C7560ou.this.m46537b(i)) {
                    C7560ou.this.m46513a(eventRecord, EventType.CLICK, c7587b);
                    C7560ou.this.m46546c(c7587b.m46896j());
                    strM46497a = "";
                } else {
                    if (C7560ou.this.f35193b == null) {
                        return;
                    }
                    C7560ou c7560ou = C7560ou.this;
                    strM46497a = c7560ou.m46497a(c7560ou.f35193b, eventRecord.m41752j(), i);
                    AbstractC7185ho.m43820b("EventProcessor", "onAdClick key: " + strM46497a);
                    if (C7560ou.this.f35196e.m45249a(C7560ou.this.f35193b.m41552f(), strM46497a)) {
                        AbstractC7185ho.m43820b("EventProcessor", "onAdClick repeated event");
                        if (C7560ou.this.f35194c.mo43027E()) {
                            EventRecord eventRecord2 = eventRecord;
                            EventType eventType = EventType.REPEATEDCLICK;
                            eventRecord2.m41727c(eventType.value());
                            C7560ou.this.m46513a(eventRecord, eventType, c7587b);
                        }
                        z10 = true;
                    } else {
                        AbstractC7185ho.m43820b("EventProcessor", "onAdClick report event");
                        C7560ou.this.m46513a(eventRecord, EventType.CLICK, c7587b);
                        C7560ou.this.m46546c(c7587b.m46896j());
                    }
                }
                C7560ou.this.m46522a(EventType.CLICK.value(), i, strM46497a, z10);
            }
        });
    }

    /* renamed from: c */
    private boolean m46550c(C7587b c7587b) {
        return m46572y() && !m46556d(c7587b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: b */
    public void mo46610b(C7586a c7586a) {
        m46506a(EventType.EASTEREGGSHOW, c7586a, (C7559ot) null);
    }

    /* renamed from: a */
    public void m46579a(int i10, String str) {
        EventType eventType = EventType.ADPRECHECK;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("EventProcessor", "onPreCheckResult result: %d contentid: %s", Integer.valueOf(i10), this.f35193b.m41588n());
        }
        if (!TextUtils.isEmpty(str)) {
            eventRecordM46529b.m41768o(str);
        }
        eventRecordM46529b.m41763m(String.valueOf(i10));
        AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType).mo47010a(eventType.value(), eventRecordM46529b, this.f35193b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: b */
    public void mo46611b(Integer num, Integer num2, String str, String str2, String str3) {
        m46507a(EventType.APPINSTALLSTART, num, num2, false, true, str, str2, str3);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46580a(long j10) {
        ContentRecord contentRecord = this.f35193b;
        if (contentRecord != null) {
            contentRecord.m41570i(j10);
        }
        EventType eventType = EventType.VIDEOTIME;
        m46554d(eventType);
        AbstractC7185ho.m43821b("EventProcessor", " reportVideoPlayTime, event： %s , videoTime %s", eventType.value(), Long.valueOf(j10));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: b */
    public void mo46612b(Integer num, String str, int i10, String str2, String str3, String str4) {
        m46508a(EventType.APPDOWNLOADRESUME, num, str, false, true, null, null, Integer.valueOf(i10), str2, str3, str4);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46581a(long j10, int i10) {
        if (m46571x()) {
            return;
        }
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(Long.valueOf(j10)).m46873a(Integer.valueOf(i10));
        m46506a(EventType.PHYIMP, aVar.m46877a(), (C7559ot) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: b */
    public void mo46613b(Integer num, String str, DownloadBlockInfo downloadBlockInfo, int i10, String str2, String str3, String str4) {
        m46508a(EventType.APPDOWNLOAD, num, str, true, false, null, downloadBlockInfo, Integer.valueOf(i10), str2, str3, str4);
    }

    /* renamed from: b */
    public void m46536b(String str) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ou.1

            /* renamed from: a */
            final /* synthetic */ String f35200a;

            public AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C7560ou.this.f35193b == null) {
                    AbstractC7185ho.m43826d("EventProcessor", "contentRecord is null, can't report HA show event");
                } else {
                    C7829h.m48406a(C7560ou.this.f35195d, C7560ou.this.f35195d.getPackageName(), AnalyticsEventType.AD_IMP, C7560ou.this.f35193b.m41585m(), str);
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46582a(long j10, int i10, C7559ot c7559ot) {
        if (m46571x()) {
            return;
        }
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(Long.valueOf(j10)).m46873a(Integer.valueOf(i10));
        m46506a(EventType.PHYIMP, aVar.m46877a(), c7559ot);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46583a(long j10, long j11, int i10, int i11) {
        m46503a(EventType.PLAYBTNPAUSE, j10, j11, i10, i11, (String) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: b */
    public void mo46614b(List<FeedbackInfo> list) {
        EventType eventType = EventType.CLOSE;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!AbstractC7760bg.m47767a(list)) {
            for (FeedbackInfo feedbackInfo : list) {
                if (feedbackInfo != null && (1 == feedbackInfo.getType() || 3 == feedbackInfo.getType())) {
                    arrayList.add(feedbackInfo.getLabel());
                    arrayList2.add(String.valueOf(feedbackInfo.m44464a()));
                }
            }
        }
        if (!AbstractC7760bg.m47767a(arrayList)) {
            AbstractC7185ho.m43818a("EventProcessor", "onAdClose, selectedKeyWords: %s", arrayList.toString());
        }
        if (!AbstractC7760bg.m47767a(arrayList2)) {
            AbstractC7185ho.m43818a("EventProcessor", "onAdClose, selectedKeyWordsType: %s", arrayList2.toString());
        }
        eventRecordM46529b.m41733e(0);
        eventRecordM46529b.m41737f(0);
        eventRecordM46529b.m41703a(arrayList);
        eventRecordM46529b.m41723b(arrayList2);
        Context context = this.f35195d;
        InterfaceC7671st interfaceC7671st = this.f35192a;
        EventType eventType2 = EventType.CLOSE;
        AbstractC7603qe.m47019a(context, interfaceC7671st, eventType2).mo47011a(eventType2.value(), eventRecordM46529b, false, this.f35193b);
        this.f35192a.mo47224d();
        m46545c(eventRecordM46529b);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46584a(long j10, long j11, int i10, int i11, String str) {
        m46503a(EventType.INTERACTEND, j10, j11, i10, i11, str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: b */
    public void mo46615b(boolean z10) {
        EventType eventType = z10 ? EventType.SOUNDCLICKOFF : EventType.SOUNDCLICKON;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType);
        interfaceC7604qfM47019a.mo47012b(eventType.value(), eventRecordM46529b, this.f35193b);
        interfaceC7604qfM47019a.mo47008a(eventRecordM46529b, this.f35193b);
    }

    /* renamed from: b */
    public boolean m46537b(int i10) {
        return i10 == 2 || i10 == 1;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46585a(Context context, ContentRecord contentRecord) {
        m46503a(EventType.LINKEDCONTINUEPLAY, -111111L, -111111L, -111111, -111111, (String) null);
    }

    /* renamed from: b */
    public boolean m46538b(EventReportRsp eventReportRsp) {
        if (eventReportRsp.m40953b() != null && eventReportRsp.m40953b().intValue() == 0) {
            return true;
        }
        List<AdEventResult> listM40951a = eventReportRsp.m40951a();
        List<AdEventResultV2> listM40955c = eventReportRsp.m40955c();
        if (AbstractC7760bg.m47767a(listM40951a) && AbstractC7760bg.m47767a(listM40955c)) {
            AbstractC7185ho.m43826d("EventProcessor", "real time report failed");
            return false;
        }
        if (!AbstractC7760bg.m47767a(listM40955c)) {
            return false;
        }
        for (AdEventResult adEventResult : listM40951a) {
            if (adEventResult != null && 200 != adEventResult.m39499b()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m46586a(C6921b c6921b) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ou.6

            /* renamed from: a */
            final /* synthetic */ C6921b f35231a;

            public AnonymousClass6(C6921b c6921b2) {
                c6921b = c6921b2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    C7560ou c7560ou = C7560ou.this;
                    EventType eventType = EventType.ANALYSIS;
                    EventRecord eventRecordM46495a = c7560ou.m46495a(eventType, c6921b);
                    if (C7560ou.m46539b(eventRecordM46495a, eventType)) {
                        return;
                    }
                    AbstractC7603qe.m47019a(C7560ou.this.f35195d, C7560ou.this.f35192a, eventType).mo47009a(eventRecordM46495a.m41752j() + "_" + c6921b.m38812aL(), eventRecordM46495a);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43826d("EventProcessor", "onAnalysis.onAppDataCollectionAnalysis exception");
                    AbstractC7185ho.m43815a(5, th2);
                }
            }
        });
    }

    /* renamed from: b */
    public static boolean m46539b(EventRecord eventRecord, EventType eventType) {
        if (eventRecord != null) {
            return false;
        }
        AbstractC7185ho.m43827d("EventProcessor", "fail to create %s event record", eventType.value());
        return true;
    }

    /* renamed from: a */
    public void m46587a(C6921b c6921b, boolean z10, boolean z11) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ou.13

            /* renamed from: a */
            final /* synthetic */ C6921b f35210a;

            /* renamed from: b */
            final /* synthetic */ boolean f35211b;

            /* renamed from: c */
            final /* synthetic */ ContentRecord f35212c;

            /* renamed from: d */
            final /* synthetic */ boolean f35213d;

            public AnonymousClass13(C6921b c6921b2, boolean z112, ContentRecord contentRecord, boolean z102) {
                c6921b = c6921b2;
                z = z112;
                contentRecord = contentRecord;
                z = z102;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    C7560ou c7560ou = C7560ou.this;
                    EventType eventType = EventType.ANALYSIS;
                    EventRecord eventRecordM46495a = c7560ou.m46495a(eventType, c6921b);
                    if (C7560ou.m46539b(eventRecordM46495a, eventType)) {
                        return;
                    }
                    InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(C7560ou.this.f35195d, C7560ou.this.f35192a, eventType);
                    interfaceC7604qfM47019a.mo47014c(eventRecordM46495a.m41752j() + "_" + c6921b.m38812aL(), eventRecordM46495a, z, contentRecord);
                    if (z) {
                        interfaceC7604qfM47019a.mo47015e();
                    }
                } catch (Throwable th2) {
                    AbstractC7185ho.m43826d("EventProcessor", "onThirdPartException onAnalysis.addEventToCache exception");
                    AbstractC7185ho.m43815a(5, th2);
                }
            }
        });
    }

    /* renamed from: a */
    public void m46502a(PostBackEvent postBackEvent) {
        if (postBackEvent != null && C7096el.m42952a(this.f35195d)) {
            C7096el.m42950a(this.f35195d, postBackEvent);
        }
    }

    /* renamed from: b */
    private boolean m46540b(C7587b c7587b) {
        AbstractC7185ho.m43817a("EventProcessor", "check if it is a valid click");
        if (!C7123fg.m43308a(this.f35195d).mo43314c(this.f35193b.m41585m())) {
            AbstractC7185ho.m43817a("EventProcessor", "notNeedCheckClick");
            return true;
        }
        String strM48516a = C7844w.m48512a(this.f35195d).m48516a();
        if ((!"0".equals(strM48516a) && !"1".equals(strM48516a)) || this.f35193b.m41552f() == 1) {
            return true;
        }
        if (m46550c(c7587b) && !AbstractC7741ao.m47584h() && !m46541b(c7587b.m46893g())) {
            AbstractC7185ho.m43817a("EventProcessor", "It is a template ad & UiEngineVersion is old");
            return true;
        }
        if (m46556d(c7587b) && !AbstractC7326j.m45220i(c7587b.m46886a())) {
            AbstractC7185ho.m43818a("EventProcessor", "It is a js ad & jsVersion is old %s", c7587b.m46886a());
            return true;
        }
        if (c7587b.m46899m() == null) {
            return false;
        }
        if (c7587b.m46899m().getCategory() != 2 && !EventType.REPEATEDCLICK.value().equals(c7587b.m46899m().value())) {
            return true;
        }
        int[] iArrMo43069aq = C7124fh.m43316b(this.f35195d).mo43069aq();
        c7587b.m46887a(iArrMo43069aq[0] + "-" + iArrMo43069aq[1]);
        MaterialClickInfo materialClickInfoM46894h = c7587b.m46894h();
        if (materialClickInfoM46894h == null) {
            AbstractC7185ho.m43817a("EventProcessor", "clickInfo is null");
            return false;
        }
        if (materialClickInfoM46894h.m44510d() != null && materialClickInfoM46894h.m44510d().intValue() != 0) {
            AbstractC7185ho.m43817a("EventProcessor", "sld is not click");
            return true;
        }
        if (materialClickInfoM46894h.m44519j() != null && materialClickInfoM46894h.m44519j().intValue() == 1) {
            AbstractC7185ho.m43817a("EventProcessor", "marked");
            return true;
        }
        if (materialClickInfoM46894h.m44518i() == null || materialClickInfoM46894h.m44517h() == null) {
            return false;
        }
        long jLongValue = materialClickInfoM46894h.m44517h().longValue() - materialClickInfoM46894h.m44518i().longValue();
        return jLongValue >= ((long) iArrMo43069aq[0]) && jLongValue <= ((long) iArrMo43069aq[1]);
    }

    /* renamed from: a */
    private void m46503a(EventType eventType, long j10, long j11, int i10, int i11, String str) {
        AbstractC7185ho.m43821b("EventProcessor", "reportVideoPlayState eventType: %s startTime: %d, endtime: %d startProgress: %d endProgress: %d", eventType, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf(i10), Integer.valueOf(i11));
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        eventRecordM46529b.m41720b(j10);
        eventRecordM46529b.m41726c(j11);
        eventRecordM46529b.m41698a(i10);
        eventRecordM46529b.m41719b(i11);
        eventRecordM46529b.m41780u(str);
        m46532b(eventRecordM46529b);
        AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType).mo47011a(eventType.value(), eventRecordM46529b, false, this.f35193b);
    }

    /* renamed from: b */
    private boolean m46541b(Integer num) {
        return num != null && num.intValue() == 2;
    }

    /* renamed from: a */
    private void m46504a(EventType eventType, EventRecord eventRecord) {
        ContentRecord contentRecord;
        if (!m46524a(eventType) || eventRecord == null || (contentRecord = this.f35193b) == null) {
            return;
        }
        eventRecord.m41780u(contentRecord.m41450aB());
        eventRecord.m41782v(this.f35193b.m41451aC());
    }

    /* renamed from: a */
    private void m46505a(EventType eventType, AppDownloadTask appDownloadTask, boolean z10, boolean z11) {
        Integer numValueOf;
        EventRecord eventRecord;
        String str;
        if (eventType == null || appDownloadTask == null) {
            return;
        }
        Integer numM42226F = appDownloadTask.m42226F();
        String strM42225E = appDownloadTask.m42225E();
        EventType eventType2 = EventType.APPDOWNLOADPAUSE;
        if (eventType2.value().equalsIgnoreCase(eventType.value())) {
            numValueOf = Integer.valueOf((appDownloadTask.m42084p() != null ? appDownloadTask.m42084p() : DownloadTask.EnumC7031c.NONE).m42098a());
        } else {
            numValueOf = null;
        }
        DownloadBlockInfo downloadBlockInfoM42092x = appDownloadTask.m42092x();
        String strM42236P = appDownloadTask.m42236P();
        String strM42237Q = appDownloadTask.m42237Q();
        String strM42227G = appDownloadTask.m42227G();
        Integer numValueOf2 = appDownloadTask.m42076h() != null ? Integer.valueOf(appDownloadTask.m42076h().m42095a()) : null;
        String strValueOf = String.valueOf(appDownloadTask.m42240T());
        if (numM42226F == null) {
            return;
        }
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            eventRecord = eventRecordM46529b;
            str = strValueOf;
            AbstractC7185ho.m43818a("EventProcessor", "reportDownloadOrOpenEvent type: %s source: %s reason: %s blockInfo: %s agVerifyCode: %s installType: %s", eventType.value(), numM42226F, numValueOf, downloadBlockInfoM42092x, strM42236P, strM42237Q);
        } else {
            eventRecord = eventRecordM46529b;
            str = strValueOf;
        }
        eventRecord.m41757k(numM42226F.toString());
        eventRecord.m41760l(strM42225E);
        if (numValueOf != null) {
            eventRecord.m41770p(String.valueOf(numValueOf));
        }
        if (numValueOf2 != null) {
            eventRecord.m41776s(String.valueOf(numValueOf2));
        }
        if (downloadBlockInfoM42092x != null) {
            eventRecord.m41772q(String.valueOf(downloadBlockInfoM42092x.m39393a()));
            eventRecord.m41774r(String.valueOf(downloadBlockInfoM42092x.m39396b()));
            eventRecord.m41778t(String.valueOf(downloadBlockInfoM42092x.m39399c() ? 1 : 0));
        }
        if (strM42236P != null) {
            eventRecord.m41790z(strM42236P);
        }
        if (strM42237Q != null) {
            eventRecord.m41665A(strM42237Q);
        }
        eventRecord.m41669C(AbstractC7806cz.m48184m(strM42227G));
        m46504a(eventType, eventRecord);
        if (eventType2.value().equalsIgnoreCase(eventType.value())) {
            eventRecord.m41702a(str);
        }
        InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType);
        if (z10) {
            interfaceC7604qfM47019a.mo47011a(eventType.value(), eventRecord, z11, this.f35193b);
        } else {
            interfaceC7604qfM47019a.mo47013b(eventType.value(), eventRecord, z11, this.f35193b);
        }
    }

    /* renamed from: a */
    private void m46506a(EventType eventType, C7586a c7586a, C7559ot c7559ot) {
        int iIntValue;
        if (c7586a.m46857i() == null) {
            ContentRecord contentRecord = this.f35193b;
            if (contentRecord == null) {
                return;
            } else {
                iIntValue = AbstractC7558os.m46471j(contentRecord.m41427W());
            }
        } else {
            iIntValue = c7586a.m46857i().intValue();
        }
        if (eventType == null) {
            return;
        }
        if ("2".equals(C7793cm.m48073a(this.f35195d, this.f35193b))) {
            iIntValue = 1;
        }
        m46500a(iIntValue, eventType, c7586a, c7559ot);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46588a(EventType eventType, Integer num, Integer num2) {
        mo46589a(eventType, num, num2, true);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46589a(EventType eventType, Integer num, Integer num2, boolean z10) {
        if (eventType == null) {
            return;
        }
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        if (num != null) {
            eventRecordM46529b.m41751i(num.toString());
        }
        if (num2 != null) {
            eventRecordM46529b.m41754j(num2.toString());
        }
        InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType);
        EventType eventType2 = EventType.INTENTSUCCESS;
        if (eventType2 != eventType) {
            interfaceC7604qfM47019a.mo47012b(eventType.value(), eventRecordM46529b, this.f35193b);
            return;
        }
        m46504a(eventType2, eventRecordM46529b);
        String strValue = eventType.value();
        ContentRecord contentRecord = this.f35193b;
        if (z10) {
            interfaceC7604qfM47019a.mo47011a(strValue, eventRecordM46529b, false, contentRecord);
        } else {
            interfaceC7604qfM47019a.mo47013b(strValue, eventRecordM46529b, false, contentRecord);
        }
    }

    /* renamed from: a */
    private void m46507a(EventType eventType, Integer num, Integer num2, boolean z10, boolean z11, String str, String str2, String str3) {
        if (eventType == null || num == null) {
            return;
        }
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("EventProcessor", "reportInstallEvent type: %s source: %s agVerifyCode: %s installType: %s", eventType.value(), num, str, str2);
        }
        eventRecordM46529b.m41760l(num.toString());
        if (num2 != null) {
            eventRecordM46529b.m41757k(num2.toString());
        }
        if (str != null) {
            eventRecordM46529b.m41790z(str);
        }
        if (str2 != null) {
            eventRecordM46529b.m41665A(str2);
        }
        eventRecordM46529b.m41669C(AbstractC7806cz.m48184m(str3));
        InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType);
        String strValue = eventType.value();
        ContentRecord contentRecord = this.f35193b;
        if (z10) {
            interfaceC7604qfM47019a.mo47011a(strValue, eventRecordM46529b, z11, contentRecord);
        } else {
            interfaceC7604qfM47019a.mo47013b(strValue, eventRecordM46529b, z11, contentRecord);
        }
    }

    /* renamed from: a */
    private void m46508a(EventType eventType, Integer num, String str, boolean z10, boolean z11, Integer num2, DownloadBlockInfo downloadBlockInfo, Integer num3, String str2, String str3, String str4) {
        if (eventType == null || num == null) {
            return;
        }
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("EventProcessor", "reportDownloadOrOpenEvent type: %s source: %s reason: %s blockInfo: %s agVerifyCode: %s installType: %s", eventType.value(), num, num2, downloadBlockInfo, str2, str3);
        }
        eventRecordM46529b.m41757k(num.toString());
        eventRecordM46529b.m41760l(str);
        if (num2 != null) {
            eventRecordM46529b.m41770p(String.valueOf(num2));
        }
        if (num3 != null) {
            eventRecordM46529b.m41776s(String.valueOf(num3));
        }
        if (downloadBlockInfo != null) {
            eventRecordM46529b.m41772q(String.valueOf(downloadBlockInfo.m39393a()));
            eventRecordM46529b.m41774r(String.valueOf(downloadBlockInfo.m39396b()));
            eventRecordM46529b.m41778t(String.valueOf(downloadBlockInfo.m39399c() ? 1 : 0));
        }
        if (str2 != null) {
            eventRecordM46529b.m41790z(str2);
        }
        if (str3 != null) {
            eventRecordM46529b.m41665A(str3);
        }
        eventRecordM46529b.m41669C(AbstractC7806cz.m48184m(str4));
        m46504a(eventType, eventRecordM46529b);
        InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType);
        String strValue = eventType.value();
        ContentRecord contentRecord = this.f35193b;
        if (z10) {
            interfaceC7604qfM47019a.mo47011a(strValue, eventRecordM46529b, z11, contentRecord);
        } else {
            interfaceC7604qfM47019a.mo47013b(strValue, eventRecordM46529b, z11, contentRecord);
        }
    }

    /* renamed from: a */
    private void m46509a(EventType eventType, Integer num, boolean z10, boolean z11, Integer num2, DownloadBlockInfo downloadBlockInfo) {
        if (eventType == null || num == null) {
            return;
        }
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        AbstractC7185ho.m43818a("EventProcessor", "reportDownloadOrOpenEvent type: %s source: %s reason: %s blockInfo: %s", eventType.value(), num, num2, downloadBlockInfo);
        eventRecordM46529b.m41757k(num.toString());
        if (num2 != null) {
            eventRecordM46529b.m41770p(String.valueOf(num2));
        }
        if (downloadBlockInfo != null) {
            eventRecordM46529b.m41772q(String.valueOf(downloadBlockInfo.m39393a()));
            eventRecordM46529b.m41774r(String.valueOf(downloadBlockInfo.m39396b()));
            eventRecordM46529b.m41778t(String.valueOf(downloadBlockInfo.m39399c() ? 1 : 0));
        }
        m46504a(eventType, eventRecordM46529b);
        InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType);
        String strValue = eventType.value();
        ContentRecord contentRecord = this.f35193b;
        if (z10) {
            interfaceC7604qfM47019a.mo47011a(strValue, eventRecordM46529b, z11, contentRecord);
        } else {
            interfaceC7604qfM47019a.mo47013b(strValue, eventRecordM46529b, z11, contentRecord);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46590a(ContentRecord contentRecord) {
        if (contentRecord != null) {
            this.f35193b = contentRecord;
        }
    }

    /* renamed from: a */
    private void m46510a(EventRecord eventRecord) {
        ApkInfo apkInfoM40339s;
        ContentRecord contentRecord = this.f35193b;
        if (contentRecord == null || contentRecord.m41568i() == null || (apkInfoM40339s = this.f35193b.m41568i().m40339s()) == null) {
            return;
        }
        String str = apkInfoM40339s.m39666l() + "#" + apkInfoM40339s.m39614O();
        AbstractC7185ho.m43818a("EventProcessor", "install ways:%s", str);
        eventRecord.m41780u(str);
    }

    /* renamed from: a */
    private void m46511a(EventRecord eventRecord, EventType eventType, C7586a c7586a) {
        if (eventRecord == null || c7586a == null) {
            return;
        }
        eventRecord.m41780u(c7586a.m46855g());
        eventRecord.m41665A(c7586a.m46858j());
        eventRecord.m41673E(c7586a.m46859k());
        if (AbstractC7185ho.m43819a()) {
            Object[] objArr = new Object[6];
            objArr[0] = eventType;
            objArr[1] = c7586a.m46851c();
            objArr[2] = c7586a.m46852d();
            ContentRecord contentRecord = this.f35193b;
            objArr[3] = contentRecord == null ? "" : contentRecord.m41577k();
            objArr[4] = c7586a.m46853e();
            objArr[5] = c7586a.m46849a();
            AbstractC7185ho.m43818a("EventProcessor", "onAdImpEvent type: %s duration: %s ratio: %s showId: %s source: %s creativeSize: %s", objArr);
        }
        ContentRecord contentRecord2 = this.f35193b;
        if (contentRecord2 != null && (contentRecord2.m41552f() == 1 || this.f35193b.m41552f() == 18)) {
            eventRecord.m41747h(this.f35193b.m41423U());
        }
        if (c7586a.m46851c() != null) {
            eventRecord.m41699a(c7586a.m46851c().longValue());
        }
        if (c7586a.m46852d() != null) {
            eventRecord.m41725c(c7586a.m46852d().intValue());
        }
        if (c7586a.m46853e() != null) {
            eventRecord.m41766n(String.valueOf(c7586a.m46853e()));
        }
        if (c7586a.m46849a() != null) {
            eventRecord.m41667B(c7586a.m46849a());
        }
    }

    /* renamed from: a */
    public void m46512a(EventRecord eventRecord, EventType eventType, C7586a c7586a, C7559ot c7559ot) {
        m46511a(eventRecord, eventType, c7586a);
        if (c7559ot != null) {
            AbstractC7185ho.m43820b("EventProcessor", "add eventExtInfo data");
            Integer numM46490b = c7559ot.m46490b();
            if (numM46490b != null && numM46490b.intValue() >= 0) {
                eventRecord.m41753j(numM46490b.intValue());
            }
            Integer numM46488a = c7559ot.m46488a();
            if (numM46488a != null && numM46488a.intValue() >= 0) {
                eventRecord.m41671D(String.valueOf(numM46488a));
            }
        }
        ContentRecord contentRecord = this.f35193b;
        if (contentRecord != null) {
            eventRecord.m41745h(contentRecord.m41581l());
        }
        ContentRecord contentRecord2 = this.f35193b;
        if (contentRecord2 != null) {
            eventRecord.m41738f(contentRecord2.m41460aL());
        }
        EventType eventType2 = EventType.SHOW;
        if (eventType == eventType2 || eventType == EventType.SUPPLEMENTIMP) {
            m46532b(eventRecord);
        }
        InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType);
        if (c7586a.m46856h()) {
            interfaceC7604qfM47019a.mo47011a(eventType.value(), eventRecord, eventType != eventType2, this.f35193b);
            if (eventType == EventType.REPEATEDIMP) {
                m46493B();
            }
        } else {
            interfaceC7604qfM47019a.mo47013b(eventType.value(), eventRecord, eventType != eventType2, this.f35193b);
        }
        if (eventType2.equals(eventType)) {
            this.f35192a.mo47223c();
        }
        if (eventType.equals(eventType2) || eventType.equals(EventType.REPEATEDIMP)) {
            m46562f(eventType.value());
        }
        m46545c(eventRecord);
    }

    /* renamed from: a */
    public void m46513a(EventRecord eventRecord, EventType eventType, C7587b c7587b) {
        eventRecord.m41733e(c7587b.m46890d());
        eventRecord.m41737f(c7587b.m46891e());
        eventRecord.m41722b(c7587b.m46892f());
        if (c7587b.m46893g() != null) {
            eventRecord.m41757k(c7587b.m46893g().toString());
        }
        AbstractC7185ho.m43818a(InterstitialMethods.ON_AD_CLICK, "cacheAndReportEvent, clickSource: %s, sld: %s", c7587b.m46893g(), Integer.valueOf(eventRecord.m41707ad()));
        InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType);
        if (c7587b.m46897k()) {
            interfaceC7604qfM47019a.mo47011a(eventType.value(), eventRecord, eventType != EventType.CLICK, this.f35193b);
        } else {
            interfaceC7604qfM47019a.mo47013b(eventType.value(), eventRecord, eventType != EventType.CLICK, this.f35193b);
        }
        if (EventType.CLICK == eventType || EventType.REPEATEDCLICK == eventType) {
            m46562f(eventType.value());
        }
        m46545c(eventRecord);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46591a(EventRecord eventRecord, boolean z10, boolean z11) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ou.7

            /* renamed from: a */
            final /* synthetic */ EventRecord f35233a;

            /* renamed from: b */
            final /* synthetic */ boolean f35234b;

            /* renamed from: c */
            final /* synthetic */ boolean f35235c;

            public AnonymousClass7(EventRecord eventRecord2, boolean z102, boolean z112) {
                eventRecord = eventRecord2;
                z = z102;
                z = z112;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventRecord eventRecord2 = eventRecord;
                    if (eventRecord2 == null) {
                        AbstractC7185ho.m43820b("EventProcessor", "eventRecord is null");
                        return;
                    }
                    String strM41752j = eventRecord2.m41752j();
                    if (!C7560ou.this.m46492A()) {
                        AbstractC7185ho.m43820b("EventProcessor", "enableUserInfo is closed");
                        return;
                    }
                    InterfaceC7604qf interfaceC7604qfM47020a = AbstractC7603qe.m47020a(C7560ou.this.f35195d, C7560ou.this.f35192a, strM41752j);
                    if (z) {
                        interfaceC7604qfM47020a.mo47011a(strM41752j, eventRecord, z, C7560ou.this.f35193b);
                    } else {
                        interfaceC7604qfM47020a.mo47013b(strM41752j, eventRecord, z, C7560ou.this.f35193b);
                    }
                } catch (Throwable unused) {
                    AbstractC7185ho.m43826d("EventProcessor", "onCommonReport exception");
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46592a(AppDownloadTask appDownloadTask) {
        m46505a(EventType.APPDOWNLOADPAUSE, appDownloadTask, false, true);
    }

    /* renamed from: a */
    private void m46514a(MaterialClickInfo materialClickInfo) {
        if (materialClickInfo.m44510d() == null) {
            return;
        }
        if (m46547c(materialClickInfo.m44510d().intValue())) {
            m46533b(materialClickInfo);
            return;
        }
        materialClickInfo.m44503a((Integer) null);
        materialClickInfo.m44507b(null);
        materialClickInfo.m44511d(null);
        materialClickInfo.m44513e(null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46593a(C7586a c7586a) {
        if (m46571x()) {
            return;
        }
        m46506a(m46555d(c7586a) ? EventType.SUPPLEMENTIMP : EventType.SHOW, c7586a, (C7559ot) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46594a(C7587b c7587b) {
        if (m46571x()) {
            return;
        }
        AbstractC7185ho.m43817a("EventProcessor", "onAdClick()");
        if (c7587b == null) {
            return;
        }
        if (m46567h(c7587b)) {
            m46568i(c7587b);
        } else {
            m46561f(c7587b);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46595a(Integer num) {
        m46509a(EventType.APPOPEN, num, true, true, (Integer) null, (DownloadBlockInfo) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46596a(Integer num, Integer num2, String str, String str2, String str3) {
        m46507a(EventType.APPINSTALL, num, num2, true, false, str, str2, str3);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46597a(Integer num, String str, int i10, DownloadBlockInfo downloadBlockInfo, int i11, String str2, String str3, String str4) {
        m46508a(EventType.APPDOWNLOADFAIL, num, str, false, true, Integer.valueOf(i10), downloadBlockInfo, Integer.valueOf(i11), str2, str3, str4);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46598a(Integer num, String str, int i10, String str2, String str3, String str4) {
        m46508a(EventType.APPDOWNLOADSTART, num, str, true, true, null, null, Integer.valueOf(i10), str2, str3, str4);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46599a(Integer num, String str, DownloadBlockInfo downloadBlockInfo, int i10, String str2, String str3, String str4) {
        m46508a(EventType.APPDOWNLOADCANCEL, num, str, false, true, null, downloadBlockInfo, Integer.valueOf(i10), str2, str3, str4);
    }

    /* renamed from: a */
    public void m46600a(String str) {
        if (m46571x()) {
            return;
        }
        EventType eventType = EventType.SHOWSTART;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        eventRecordM46529b.m41780u(str);
        AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType).mo47011a(eventType.value(), eventRecordM46529b, false, this.f35193b);
        m46570w();
    }

    /* renamed from: a */
    public void m46522a(String str, int i10, String str2, boolean z10) {
        new C6922c(this.f35195d).mo39102a(str, Integer.valueOf(i10), str2, this.f35193b, z10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46601a(String str, String str2, String str3) {
        EventType eventType = EventType.ADREWARDED;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        eventRecordM46529b.m41780u(str);
        eventRecordM46529b.m41782v(str2);
        AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType).mo47011a(eventType.value(), eventRecordM46529b, false, this.f35193b);
        m46559e(str3);
    }

    /* renamed from: a */
    public void m46602a(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AbstractC7185ho.m43823c("EventProcessor", "param is null");
            return;
        }
        EventRecord eventRecordM46552d = m46552d(str);
        if (eventRecordM46552d == null) {
            return;
        }
        eventRecordM46552d.m41735e(str2);
        InterfaceC7604qf interfaceC7604qfM47020a = AbstractC7603qe.m47020a(this.f35195d, this.f35192a, str);
        ContentRecord contentRecord = this.f35193b;
        if (z10) {
            interfaceC7604qfM47020a.mo47010a(str, eventRecordM46552d, contentRecord);
        } else {
            interfaceC7604qfM47020a.mo47012b(str, eventRecordM46552d, contentRecord);
        }
    }

    /* renamed from: a */
    public void m46603a(String str, List<C6921b> list, InterfaceC7623qy interfaceC7623qy) {
        AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.ou.2

            /* renamed from: a */
            final /* synthetic */ List f35223a;

            /* renamed from: b */
            final /* synthetic */ InterfaceC7623qy f35224b;

            public AnonymousClass2(List list2, InterfaceC7623qy interfaceC7623qy2) {
                list = list2;
                interfaceC7623qy = interfaceC7623qy2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (C6921b c6921b : list) {
                        C7560ou c7560ou = C7560ou.this;
                        EventType eventType = EventType.ANALYSIS;
                        EventRecord eventRecordM46495a = c7560ou.m46495a(eventType, c6921b);
                        if (C7560ou.m46539b(eventRecordM46495a, eventType)) {
                            return;
                        } else {
                            arrayList.add(eventRecordM46495a);
                        }
                    }
                    EventReportRsp eventReportRspMo43270a = C7560ou.this.f35197f.mo43270a(AbstractC7572pf.m46750a(arrayList, C7560ou.this.f35195d));
                    if (C7560ou.m46548c(eventReportRspMo43270a) && C7560ou.this.m46538b(eventReportRspMo43270a)) {
                        interfaceC7623qy.mo30246a();
                    }
                } catch (Throwable th2) {
                    AbstractC7185ho.m43826d("EventProcessor", "onRealTimeAnalysis exception");
                    AbstractC7185ho.m43815a(5, th2);
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7615qq
    /* renamed from: a */
    public void mo46604a(List<FeedbackInfo> list) {
        EventType eventType = EventType.POSITIVEFEEDBACK;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!AbstractC7760bg.m47767a(list)) {
            for (FeedbackInfo feedbackInfo : list) {
                if (feedbackInfo != null && feedbackInfo.getType() == 2) {
                    arrayList.add(feedbackInfo.getLabel());
                    arrayList2.add(String.valueOf(feedbackInfo.m44464a()));
                }
            }
        }
        if (!AbstractC7760bg.m47767a(arrayList)) {
            AbstractC7185ho.m43818a("EventProcessor", "onAdPositiveFeedback, selectedKeyWords: %s", arrayList.toString());
        }
        if (!AbstractC7760bg.m47767a(arrayList2)) {
            AbstractC7185ho.m43818a("EventProcessor", "onAdPositiveFeedback, selectedKeyWordsType: %s", arrayList2.toString());
        }
        eventRecordM46529b.m41733e(0);
        eventRecordM46529b.m41737f(0);
        eventRecordM46529b.m41703a(arrayList);
        eventRecordM46529b.m41723b(arrayList2);
        Context context = this.f35195d;
        InterfaceC7671st interfaceC7671st = this.f35192a;
        EventType eventType2 = EventType.POSITIVEFEEDBACK;
        AbstractC7603qe.m47019a(context, interfaceC7671st, eventType2).mo47011a(eventType2.value(), eventRecordM46529b, false, this.f35193b);
    }

    /* renamed from: a */
    public void m46605a(boolean z10) {
        if (m46571x()) {
            return;
        }
        EventType eventType = EventType.SHOWSTART;
        EventRecord eventRecordM46529b = m46529b(eventType);
        if (m46539b(eventRecordM46529b, eventType)) {
            return;
        }
        InterfaceC7604qf interfaceC7604qfM47019a = AbstractC7603qe.m47019a(this.f35195d, this.f35192a, eventType);
        if (z10) {
            interfaceC7604qfM47019a.mo47011a(eventType.value(), eventRecordM46529b, false, this.f35193b);
        } else {
            interfaceC7604qfM47019a.mo47013b(eventType.value(), eventRecordM46529b, false, this.f35193b);
        }
        m46570w();
    }

    /* renamed from: a */
    private static boolean m46524a(EventType eventType) {
        return EventType.APPDOWNLOAD.equals(eventType) || EventType.APPOPEN.equals(eventType) || EventType.INTENTSUCCESS.equals(eventType);
    }
}
