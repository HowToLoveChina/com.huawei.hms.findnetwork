package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7607qi;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.AdEventResult;
import com.huawei.openalliance.p169ad.beans.metadata.AdEventResultV2;
import com.huawei.openalliance.p169ad.beans.server.EventReportRsp;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7793cm;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.utils.RunnableC7813df;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.openalliance.ad.qc */
/* loaded from: classes8.dex */
abstract class AbstractC7601qc implements InterfaceC7604qf {

    /* renamed from: a */
    private Context f35455a;

    /* renamed from: b */
    private InterfaceC7138fv f35456b;

    /* renamed from: c */
    private InterfaceC7671st f35457c;

    /* renamed from: d */
    private InterfaceC7140fx f35458d;

    /* renamed from: com.huawei.openalliance.ad.qc$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ EventRecord f35459a;

        /* renamed from: b */
        final /* synthetic */ ContentRecord f35460b;

        public AnonymousClass1(EventRecord eventRecord, ContentRecord contentRecord) {
            eventRecord = eventRecord;
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentRecord contentRecord;
            if ((TextUtils.equals(eventRecord.m41752j(), EventType.SHOW.value()) || TextUtils.equals(eventRecord.m41752j(), EventType.SUPPLEMENTIMP.value())) && (contentRecord = contentRecord) != null && contentRecord.m41484af() != null) {
                String packageName = contentRecord.m41484af().getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    int i10 = C7830i.m48419a(AbstractC7601qc.this.f35455a, packageName) ? 10 : 11;
                    eventRecord.m41763m(String.valueOf(i10));
                    AbstractC7185ho.m43820b(AbstractC7601qc.this.mo46982c(), "appStatus: " + i10);
                }
            }
            AbstractC7601qc.this.m47002b(eventRecord, contentRecord);
            AbstractC7601qc.this.mo46980a(System.currentTimeMillis());
            AbstractC7601qc.this.mo47016f();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.qc$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ EventRecord f35462a;

        /* renamed from: b */
        final /* synthetic */ ContentRecord f35463b;

        public AnonymousClass2(EventRecord eventRecord, ContentRecord contentRecord) {
            eventRecord = eventRecord;
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7607qi c7607qi = new C7607qi(AbstractC7601qc.this.f35455a, AbstractC7601qc.this.f35457c);
            c7607qi.m47034a(AbstractC7601qc.m47001b(eventRecord));
            c7607qi.m47033a(eventRecord.m41752j(), contentRecord);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.qc$3 */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7601qc.this.m47007h();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.qc$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ EventRecord f35466a;

        /* renamed from: b */
        final /* synthetic */ ContentRecord f35467b;

        public AnonymousClass4(EventRecord eventRecord, ContentRecord contentRecord) {
            eventRecord = eventRecord;
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7601qc.this.m47002b(eventRecord, contentRecord);
            if (AbstractC7601qc.this.m47006g()) {
                AbstractC7601qc.this.mo47016f();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.qc$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new C7607qi(AbstractC7601qc.this.f35455a, AbstractC7601qc.this.f35457c).m47032a();
            AbstractC7601qc.this.m47007h();
        }
    }

    public AbstractC7601qc(Context context, InterfaceC7671st interfaceC7671st) {
        this.f35455a = context.getApplicationContext();
        this.f35456b = C7108ex.m43156a(context);
        this.f35457c = interfaceC7671st;
        this.f35458d = C7118fb.m43196a(context);
    }

    /* renamed from: g */
    public boolean m47006g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - mo46983d() <= 900000) {
            return false;
        }
        mo46980a(jCurrentTimeMillis);
        return true;
    }

    /* renamed from: h */
    public void m47007h() {
        Map<String, EventRecord> mapMo43161a = this.f35456b.mo43161a(mo46979a(), Constants.HISUGGESTION_PKG_NAME.equals(this.f35455a.getPackageName()) ? C7124fh.m43316b(this.f35455a).mo43085s() : 50);
        String strValueOf = String.valueOf(System.currentTimeMillis());
        EventReportRsp eventReportRspMo43270a = this.f35458d.mo43270a(AbstractC7572pf.m46750a(mapMo43161a.values(), this.f35455a));
        if (eventReportRspMo43270a == null) {
            return;
        }
        if (m46995a(eventReportRspMo43270a)) {
            m46998a(mapMo43161a, strValueOf, eventReportRspMo43270a);
            return;
        }
        String strValueOf2 = eventReportRspMo43270a.errorReason;
        if (strValueOf2 == null) {
            strValueOf2 = String.valueOf(eventReportRspMo43270a.responseCode);
        }
        m46990a(strValueOf, strValueOf2, mapMo43161a.values());
    }

    /* renamed from: a */
    public abstract Class<? extends EventRecord> mo46979a();

    /* renamed from: a */
    public abstract void mo46980a(long j10);

    /* renamed from: b */
    public abstract Executor mo46981b();

    /* renamed from: c */
    public abstract String mo46982c();

    /* renamed from: d */
    public abstract long mo46983d();

    @Override // com.huawei.openalliance.p169ad.InterfaceC7604qf
    /* renamed from: e */
    public void mo47015e() {
        m46989a(new Runnable() { // from class: com.huawei.openalliance.ad.qc.3
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7601qc.this.m47007h();
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7604qf
    /* renamed from: f */
    public void mo47016f() {
        m46989a(new Runnable() { // from class: com.huawei.openalliance.ad.qc.5
            public AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                new C7607qi(AbstractC7601qc.this.f35455a, AbstractC7601qc.this.f35457c).m47032a();
                AbstractC7601qc.this.m47007h();
            }
        });
    }

    /* renamed from: b */
    private String m47000b(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return "";
        }
        String eventTypeIndex = EventType.getEventTypeIndex(str);
        return AbstractC7806cz.m48165b(eventTypeIndex) ? str.substring(str.indexOf("_") + 1) : eventTypeIndex;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7604qf
    /* renamed from: c */
    public void mo47014c(String str, EventRecord eventRecord, boolean z10, ContentRecord contentRecord) {
        if (eventRecord != null) {
            if ((z10 && m46997a(str, contentRecord)) || m46996a(str)) {
                return;
            }
            m47002b(eventRecord, contentRecord);
        }
    }

    /* renamed from: b */
    public static List<C7607qi.a> m47001b(EventRecord eventRecord) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C7657sf(eventRecord));
        arrayList.add(new C7660si(eventRecord));
        arrayList.add(new C7669sr(eventRecord));
        return arrayList;
    }

    /* renamed from: c */
    private boolean m47004c(String str) {
        return EventType.SHOW.value().equals(str) || EventType.CLICK.value().equals(str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7604qf
    /* renamed from: a */
    public void mo47008a(EventRecord eventRecord, ContentRecord contentRecord) {
        m46989a(new Runnable() { // from class: com.huawei.openalliance.ad.qc.2

            /* renamed from: a */
            final /* synthetic */ EventRecord f35462a;

            /* renamed from: b */
            final /* synthetic */ ContentRecord f35463b;

            public AnonymousClass2(EventRecord eventRecord2, ContentRecord contentRecord2) {
                eventRecord = eventRecord2;
                contentRecord = contentRecord2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7607qi c7607qi = new C7607qi(AbstractC7601qc.this.f35455a, AbstractC7601qc.this.f35457c);
                c7607qi.m47034a(AbstractC7601qc.m47001b(eventRecord));
                c7607qi.m47033a(eventRecord.m41752j(), contentRecord);
            }
        });
    }

    /* renamed from: a */
    private void m46986a(EventRecord eventRecord, ContentRecord contentRecord, boolean z10) {
        if (eventRecord == null || !m47004c(eventRecord.m41752j())) {
            return;
        }
        new C6922c(this.f35455a).m39101a(eventRecord.m41752j(), contentRecord, z10);
    }

    /* renamed from: b */
    public void m47002b(EventRecord eventRecord, ContentRecord contentRecord) {
        if (eventRecord == null) {
            AbstractC7185ho.m43826d(mo46982c(), "fail to add event to cache");
            return;
        }
        String strMo46982c = mo46982c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("addEventToCache, event:");
        sb2.append(eventRecord.m41752j());
        sb2.append(" showId:");
        sb2.append(eventRecord.m41758l());
        sb2.append(" reqId:");
        sb2.append(eventRecord.m41688S());
        sb2.append(" contentId:");
        sb2.append(contentRecord == null ? null : contentRecord.m41588n());
        sb2.append(" requestType:");
        sb2.append(eventRecord.m41686Q());
        AbstractC7185ho.m43820b(strMo46982c, sb2.toString());
        C7662sk.m47226a(this.f35455a);
        m46986a(eventRecord, contentRecord, this.f35456b.mo43159a(mo46979a(), eventRecord) > 0);
    }

    /* renamed from: a */
    private void m46987a(EventRecord eventRecord, boolean z10) {
        if (eventRecord == null || !m47004c(eventRecord.m41752j())) {
            return;
        }
        new C6922c(this.f35455a).m39094a(eventRecord.m41752j(), eventRecord.m41761m(), eventRecord.m41688S(), eventRecord.m41758l(), eventRecord.m41687R(), z10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7604qf
    /* renamed from: b */
    public void mo47012b(String str, EventRecord eventRecord, ContentRecord contentRecord) {
        mo47013b(str, eventRecord, true, contentRecord);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7604qf
    /* renamed from: b */
    public void mo47013b(String str, EventRecord eventRecord, boolean z10, ContentRecord contentRecord) {
        if (eventRecord != null) {
            if ((z10 && m46997a(str, contentRecord)) || m46996a(str)) {
                return;
            }
            AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.qc.4

                /* renamed from: a */
                final /* synthetic */ EventRecord f35466a;

                /* renamed from: b */
                final /* synthetic */ ContentRecord f35467b;

                public AnonymousClass4(EventRecord eventRecord2, ContentRecord contentRecord2) {
                    eventRecord = eventRecord2;
                    contentRecord = contentRecord2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7601qc.this.m47002b(eventRecord, contentRecord);
                    if (AbstractC7601qc.this.m47006g()) {
                        AbstractC7601qc.this.mo47016f();
                    }
                }
            });
            String strM48073a = C7793cm.m48073a(this.f35455a, contentRecord2);
            if ("1".equals(strM48073a) || "2".equals(strM48073a)) {
                mo47008a(eventRecord2, contentRecord2);
            }
        }
    }

    /* renamed from: a */
    private void m46989a(Runnable runnable) {
        mo46981b().execute(new RunnableC7813df(runnable));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7604qf
    /* renamed from: a */
    public void mo47009a(String str, EventRecord eventRecord) {
        if (eventRecord == null || m46996a(str)) {
            return;
        }
        m47002b(eventRecord, null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7604qf
    /* renamed from: a */
    public void mo47010a(String str, EventRecord eventRecord, ContentRecord contentRecord) {
        mo47011a(str, eventRecord, true, contentRecord);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7604qf
    /* renamed from: a */
    public void mo47011a(String str, EventRecord eventRecord, boolean z10, ContentRecord contentRecord) {
        if (eventRecord != null) {
            if ((z10 && m46997a(str, contentRecord)) || m46996a(str)) {
                return;
            }
            AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.qc.1

                /* renamed from: a */
                final /* synthetic */ EventRecord f35459a;

                /* renamed from: b */
                final /* synthetic */ ContentRecord f35460b;

                public AnonymousClass1(EventRecord eventRecord2, ContentRecord contentRecord2) {
                    eventRecord = eventRecord2;
                    contentRecord = contentRecord2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ContentRecord contentRecord2;
                    if ((TextUtils.equals(eventRecord.m41752j(), EventType.SHOW.value()) || TextUtils.equals(eventRecord.m41752j(), EventType.SUPPLEMENTIMP.value())) && (contentRecord2 = contentRecord) != null && contentRecord2.m41484af() != null) {
                        String packageName = contentRecord.m41484af().getPackageName();
                        if (!TextUtils.isEmpty(packageName)) {
                            int i10 = C7830i.m48419a(AbstractC7601qc.this.f35455a, packageName) ? 10 : 11;
                            eventRecord.m41763m(String.valueOf(i10));
                            AbstractC7185ho.m43820b(AbstractC7601qc.this.mo46982c(), "appStatus: " + i10);
                        }
                    }
                    AbstractC7601qc.this.m47002b(eventRecord, contentRecord);
                    AbstractC7601qc.this.mo46980a(System.currentTimeMillis());
                    AbstractC7601qc.this.mo47016f();
                }
            });
            mo47008a(eventRecord2, contentRecord2);
        }
    }

    /* renamed from: a */
    private void m46990a(String str, String str2, Collection<EventRecord> collection) {
        if (AbstractC7760bg.m47767a(collection)) {
            return;
        }
        for (EventRecord eventRecord : collection) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(eventRecord.m41748i());
            this.f35456b.mo43167a(mo46979a(), str, str2 == null ? eventRecord.m41781v() : str2, eventRecord.m41783w() + 1, arrayList);
            m46987a(eventRecord, false);
        }
    }

    /* renamed from: a */
    private void m46991a(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f35456b.mo43173b(mo46979a(), list);
    }

    /* renamed from: a */
    private void m46992a(List<String> list, ArrayList<String> arrayList, List<AdEventResultV2> list2) {
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        if (AbstractC7760bg.m47767a(list2)) {
            arrayList.addAll(list);
            return;
        }
        ArrayList arrayList2 = new ArrayList(list);
        for (AdEventResultV2 adEventResultV2 : list2) {
            if (adEventResultV2 != null) {
                arrayList2.remove(adEventResultV2.m39500a());
            }
        }
        arrayList.addAll(arrayList2);
    }

    /* renamed from: a */
    private void m46993a(Map<String, EventRecord> map, String str, ArrayList<String> arrayList, ArrayList<EventRecord> arrayList2, String str2, int i10) {
        EventRecord eventRecord = map.get(str2);
        if (!m46994a(i10)) {
            arrayList.add(str2);
            m46987a(eventRecord, true);
        } else if (eventRecord != null) {
            eventRecord.m41734e(eventRecord.m41783w() + 1);
            eventRecord.m41743g(String.valueOf(i10));
            eventRecord.m41739f(str);
            arrayList2.add(eventRecord);
        }
    }

    /* renamed from: a */
    private static boolean m46994a(int i10) {
        return (200 == i10 || 601 == i10 || 611 == i10) ? false : true;
    }

    /* renamed from: a */
    private static boolean m46995a(EventReportRsp eventReportRsp) {
        return eventReportRsp != null && eventReportRsp.responseCode == 0;
    }

    /* renamed from: a */
    private boolean m46996a(String str) {
        String strM47000b = m47000b(str);
        boolean z10 = false;
        if (AbstractC7806cz.m48165b(strM47000b)) {
            return false;
        }
        try {
            List<String> listMo43082p = C7124fh.m43316b(this.f35455a).mo43082p();
            if (!AbstractC7760bg.m47767a(listMo43082p)) {
                Iterator<String> it = listMo43082p.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (strM47000b.equals(it.next())) {
                        z10 = true;
                        break;
                    }
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43826d(mo46982c(), "isInBlackList, Exception:" + th2.getClass().getSimpleName());
        }
        AbstractC7185ho.m43818a(mo46982c(), "isInBlackList, result: %s, eventType: %s", Boolean.valueOf(z10), str);
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x007a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m46997a(java.lang.String r6, com.huawei.openalliance.p169ad.p171db.bean.ContentRecord r7) {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L58
            java.util.List r1 = r7.m41431Y()     // Catch: java.lang.Exception -> L27 java.lang.RuntimeException -> L29
            boolean r2 = com.huawei.openalliance.p169ad.utils.AbstractC7760bg.m47767a(r1)     // Catch: java.lang.Exception -> L27 java.lang.RuntimeException -> L29
            if (r2 != 0) goto L58
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L27 java.lang.RuntimeException -> L29
        L11:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L27 java.lang.RuntimeException -> L29
            if (r2 == 0) goto L58
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L27 java.lang.RuntimeException -> L29
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L27 java.lang.RuntimeException -> L29
            if (r6 == 0) goto L11
            boolean r2 = r6.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L27 java.lang.RuntimeException -> L29
            if (r2 == 0) goto L11
            r0 = 1
            goto L58
        L27:
            r1 = move-exception
            goto L2b
        L29:
            r1 = move-exception
            goto L4c
        L2b:
            java.lang.String r2 = r5.mo46982c()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "isDiscard, Exception:"
        L36:
            r3.append(r4)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r2, r1)
            goto L58
        L4c:
            java.lang.String r2 = r5.mo46982c()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "isDiscard, RuntimeException:"
            goto L36
        L58:
            java.lang.String r5 = r5.mo46982c()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isDiscard:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r2 = ", eventType:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = ", contentId:"
            r1.append(r6)
            if (r7 != 0) goto L7a
            r6 = 0
            goto L7e
        L7a:
            java.lang.String r6 = r7.m41588n()
        L7e:
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.AbstractC7601qc.m46997a(java.lang.String, com.huawei.openalliance.ad.db.bean.ContentRecord):boolean");
    }

    /* renamed from: a */
    private boolean m46998a(Map<String, EventRecord> map, String str, EventReportRsp eventReportRsp) {
        try {
            List<AdEventResult> listM40951a = eventReportRsp.m40951a();
            List<AdEventResultV2> listM40955c = eventReportRsp.m40955c();
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<EventRecord> arrayList2 = new ArrayList<>();
            if (eventReportRsp.m40953b() != null && eventReportRsp.m40953b().intValue() == 0) {
                arrayList.addAll(map.keySet());
            } else {
                if (AbstractC7760bg.m47767a(listM40951a) && AbstractC7760bg.m47767a(listM40955c)) {
                    m46990a(str, "no result", map.values());
                    return false;
                }
                if (AbstractC7760bg.m47767a(listM40955c)) {
                    for (AdEventResult adEventResult : listM40951a) {
                        if (adEventResult != null) {
                            m46993a(map, str, arrayList, arrayList2, adEventResult.m39498a(), adEventResult.m39499b());
                        }
                    }
                } else {
                    for (AdEventResultV2 adEventResultV2 : listM40955c) {
                        if (adEventResultV2 != null) {
                            m46993a(map, str, arrayList, arrayList2, adEventResultV2.m39500a(), adEventResultV2.m39501b());
                        }
                    }
                    m46992a(new ArrayList<>(map.keySet()), arrayList, listM40955c);
                }
            }
            m46991a(arrayList);
            m46990a(str, (String) null, arrayList2);
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("BaseEventReporter", "dealEventRsp err, %s", th2.getClass().getSimpleName());
            return true;
        }
    }
}
