package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.jn */
/* loaded from: classes8.dex */
public class C7340jn {

    /* renamed from: a */
    private static final HashMap<Integer, String> f34216a;

    /* renamed from: b */
    private static final ConcurrentHashMap<String, Boolean> f34217b;

    /* renamed from: c */
    private static String f34218c;

    /* renamed from: com.huawei.openalliance.ad.jn$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f34219a;

        /* renamed from: b */
        final /* synthetic */ int f34220b;

        /* renamed from: c */
        final /* synthetic */ ContentRecord f34221c;

        public AnonymousClass1(Context context, int i10, ContentRecord contentRecord) {
            context = context;
            i = i10;
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            new C6922c(context).mo39090a(C7340jn.f34218c, i, contentRecord);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.jn$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f34222a;

        /* renamed from: b */
        final /* synthetic */ int f34223b;

        /* renamed from: c */
        final /* synthetic */ ContentRecord f34224c;

        public AnonymousClass2(Context context, int i10, ContentRecord contentRecord) {
            context = context;
            i = i10;
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            new C6922c(context).mo39058a(i, contentRecord);
        }
    }

    static {
        HashMap<Integer, String> map = new HashMap<>();
        f34216a = map;
        f34217b = new ConcurrentHashMap<>();
        map.put(1, "miaozhen.com");
    }

    /* renamed from: a */
    private static InterfaceC7342jp m45338a(Context context, ContentRecord contentRecord, C7560ou c7560ou, boolean z10, boolean z11) {
        AbstractC7185ho.m43821b("CustMonitorFactory", "isCheckUiengine %s, isImage %s.", Boolean.valueOf(z10), Boolean.valueOf(z11));
        if (z10 && !m45344a()) {
            AbstractC7185ho.m43823c("CustMonitorFactory", "uiengine ver is too low to support mz");
            return new C7341jo();
        }
        List<String> listM45341a = m45341a(context, contentRecord, "imp");
        List<String> listM45341a2 = m45341a(context, contentRecord, "click");
        AbstractC7185ho.m43818a("CustMonitorFactory", "getMzMonitor, impUrls size is %s, clickUrls size is %s", Integer.valueOf(listM45341a.size()), Integer.valueOf(listM45341a2.size()));
        if (!AbstractC7760bg.m47767a(listM45341a) || !AbstractC7760bg.m47767a(listM45341a2)) {
            return z11 ? new C7343jq(listM45341a, listM45341a2, c7560ou, contentRecord) : new C7344jr(listM45341a, listM45341a2, c7560ou, contentRecord);
        }
        AbstractC7185ho.m43820b("CustMonitorFactory", "getMzMonitor, monitor url is blank.");
        m45342a(context, contentRecord.m41505b(), contentRecord);
        return new C7341jo();
    }

    /* renamed from: b */
    private static void m45348b(Context context, int i10, ContentRecord contentRecord) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.jn.2

            /* renamed from: a */
            final /* synthetic */ Context f34222a;

            /* renamed from: b */
            final /* synthetic */ int f34223b;

            /* renamed from: c */
            final /* synthetic */ ContentRecord f34224c;

            public AnonymousClass2(Context context2, int i102, ContentRecord contentRecord2) {
                context = context2;
                i = i102;
                contentRecord = contentRecord2;
            }

            @Override // java.lang.Runnable
            public void run() {
                new C6922c(context).mo39058a(i, contentRecord);
            }
        });
    }

    /* renamed from: a */
    public static InterfaceC7342jp m45339a(Context context, boolean z10, C7560ou c7560ou, ContentRecord contentRecord, boolean z11) {
        if (context == null || contentRecord == null || c7560ou == null) {
            AbstractC7185ho.m43820b("CustMonitorFactory", "getMonitor, param is null.");
            return new C7341jo();
        }
        int iM41505b = contentRecord.m41505b();
        AbstractC7185ho.m43821b("CustMonitorFactory", "sdkMonitor is %s", Integer.valueOf(iM41505b));
        if (iM41505b != 0) {
            m45348b(context, iM41505b, contentRecord);
        }
        return iM41505b != 1 ? new C7341jo() : m45338a(context, contentRecord, c7560ou, z11, z10);
    }

    /* renamed from: b */
    public static int[] m45349b() {
        int[] iArr = new int[1];
        if (EnumC7338jl.m45325a().m45337b()) {
            AbstractC7185ho.m43820b("CustMonitorFactory", "req, support mz");
            iArr[0] = 1;
        } else {
            iArr[0] = 0;
        }
        f34218c = m45340a(iArr);
        return iArr;
    }

    /* renamed from: a */
    private static String m45340a(int[] iArr) {
        StringBuilder sb2 = new StringBuilder("{");
        for (int i10 : iArr) {
            sb2.append(i10);
            sb2.append(",");
        }
        sb2.append("}");
        return sb2.toString();
    }

    /* renamed from: a */
    private static List<String> m45341a(Context context, ContentRecord contentRecord, String str) {
        ArrayList arrayList = new ArrayList();
        List<Monitor> listM41435a = contentRecord.m41435a(context);
        if (!AbstractC7760bg.m47767a(listM41435a) && str != null) {
            for (Monitor monitor : listM41435a) {
                if (str.equals(monitor.m40347a())) {
                    for (String str2 : monitor.m40351b()) {
                        if (m45346a(contentRecord.m41505b(), str2)) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m45342a(Context context, int i10, ContentRecord contentRecord) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.jn.1

            /* renamed from: a */
            final /* synthetic */ Context f34219a;

            /* renamed from: b */
            final /* synthetic */ int f34220b;

            /* renamed from: c */
            final /* synthetic */ ContentRecord f34221c;

            public AnonymousClass1(Context context2, int i102, ContentRecord contentRecord2) {
                context = context2;
                i = i102;
                contentRecord = contentRecord2;
            }

            @Override // java.lang.Runnable
            public void run() {
                new C6922c(context).mo39090a(C7340jn.f34218c, i, contentRecord);
            }
        });
    }

    /* renamed from: a */
    public static void m45343a(String str, InterfaceC7342jp interfaceC7342jp) {
        if (str == null || interfaceC7342jp == null) {
            AbstractC7185ho.m43820b("CustMonitorFactory", "setContentIdToMonitor, param is null");
            return;
        }
        boolean z10 = interfaceC7342jp instanceof C7341jo;
        if (!z10) {
            AbstractC7185ho.m43821b("CustMonitorFactory", "setContentIdToMonitor, contentId is %s, monitor is %s", str, interfaceC7342jp.getClass().getSimpleName());
        }
        f34217b.put(str, Boolean.valueOf(z10));
    }

    /* renamed from: a */
    public static boolean m45344a() {
        return !AbstractC7806cz.m48165b(C7084e.m42836a()) && Integer.parseInt(C7084e.m42836a()) >= 30477310;
    }

    /* renamed from: a */
    public static boolean m45345a(int i10) {
        if (i10 == 1) {
            return EnumC7338jl.m45325a().m45337b();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m45346a(int i10, String str) {
        String strM48182k;
        try {
            HashMap<Integer, String> map = f34216a;
            if (map.containsKey(Integer.valueOf(i10)) && (strM48182k = AbstractC7806cz.m48182k(str)) != null) {
                return strM48182k.endsWith(map.get(Integer.valueOf(i10)));
            }
            return false;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("CustMonitorFactory", "checkUrlContainMonitor err: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m45347a(String str) {
        if (str == null) {
            return true;
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = f34217b;
        if (!concurrentHashMap.containsKey(str)) {
            return true;
        }
        AbstractC7185ho.m43818a("CustMonitorFactory", "checkIfDoNothing, contentId %s %s", str, concurrentHashMap.get(str));
        return Boolean.TRUE.equals(concurrentHashMap.get(str));
    }
}
