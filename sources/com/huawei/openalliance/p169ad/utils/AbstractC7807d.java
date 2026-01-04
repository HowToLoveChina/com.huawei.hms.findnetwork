package com.huawei.openalliance.p169ad.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.hihonor.android.os.Build;
import com.huawei.appgallery.markethomecountrysdk.api.HomeCountryApi;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C6985cb;
import com.huawei.openalliance.p169ad.C7114ey;
import com.huawei.openalliance.p169ad.C7120fd;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7484ms;
import com.huawei.openalliance.p169ad.InterfaceC7139fw;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.IntervalMethods;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.opendeviceidentifier.OAIDServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p208cq.C8943k;

/* renamed from: com.huawei.openalliance.ad.utils.d */
/* loaded from: classes2.dex */
public abstract class AbstractC7807d {

    /* renamed from: a */
    private static String f36047a;

    /* renamed from: com.huawei.openalliance.ad.utils.d$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36048a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36049b;

        /* renamed from: com.huawei.openalliance.ad.utils.d$1$1 */
        public class C144761 implements RemoteCallResultCallback<String> {
            public C144761() {
            }

            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != 200) {
                    AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid failed");
                } else {
                    AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid success");
                    c7787cg.m47993h(callResult.getData());
                }
            }
        }

        public AnonymousClass1(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6982bz.m41152b(context)) {
                if (AbstractC7807d.m48195F(context)) {
                    AbstractC7185ho.m43817a("AdInfoUtil", "within uuid request interval, skip query uuid.");
                } else {
                    AbstractC7185ho.m43820b("AdInfoUtil", "start to request UUID");
                    C7484ms.m45854a(context).m45855a(RTCMethods.QUERY_UUID, "", new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.d.1.1
                        public C144761() {
                        }

                        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                        public void onRemoteCallResult(String str, CallResult<String> callResult) {
                            if (callResult.getCode() != 200) {
                                AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid failed");
                            } else {
                                AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid success");
                                c7787cg.m47993h(callResult.getData());
                            }
                        }
                    }, String.class);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$10 */
    public static class AnonymousClass10 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36051a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36052b;

        public AnonymousClass10(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7807d.m48242h(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$11 */
    public static class AnonymousClass11 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36053a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36054b;

        public AnonymousClass11(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7807d.m48246j(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$12 */
    public static class AnonymousClass12 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36055a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36056b;

        public AnonymousClass12(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7807d.m48248k(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$13 */
    public static class AnonymousClass13 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36057a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36058b;

        public AnonymousClass13(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7807d.m48244i(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$14 */
    public static class AnonymousClass14 implements Callable<String> {

        /* renamed from: a */
        final /* synthetic */ Context f36059a;

        public AnonymousClass14(Context context) {
            context = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() {
            try {
                return (String) C8943k.m56661a(HomeCountryApi.getHomeCountry(context, "PPSSDK", false));
            } catch (Throwable unused) {
                AbstractC7185ho.m43826d("AdInfoUtil", "getAgCountryCodeFromAg Throwable ");
                return Constants.NOT_FOUND;
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ Context f36061b;

        public AnonymousClass2(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7807d.m48236e(c7787cg, context);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$3 */
    public static class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36062a;

        public AnonymousClass3(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7787cg.m47900a(context).m47925G(C7845x.m48539b(context));
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$4 */
    public static class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36063a;

        public AnonymousClass4(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7787cg.m47900a(context).m47927H(C7845x.m48544c(context));
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$5 */
    public static class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36064a;

        /* renamed from: b */
        final /* synthetic */ Integer f36065b;

        public AnonymousClass5(Context context, Integer num) {
            context = context;
            num = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7787cg.m47900a(context).m47951a(num);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$6 */
    public static class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36066a;

        public AnonymousClass6(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43817a("AdInfoUtil", "adid_double_frame start to getAdid from hms");
            if (!AbstractC7811dd.m48330g()) {
                AbstractC7185ho.m43817a("AdInfoUtil", "adid_double_frame not inside device");
                return;
            }
            boolean zMo43052a = C7124fh.m43316b(context).mo43052a("adid", 180);
            AbstractC7185ho.m43818a("AdInfoUtil", "adid_double_frame getAdid in Interval : %s", Boolean.valueOf(zMo43052a));
            if (zMo43052a) {
                return;
            }
            long jM47566c = AbstractC7741ao.m47566c();
            AbstractC7185ho.m43818a("AdInfoUtil", "adid_double_frame get adid start time : %s", Long.valueOf(jM47566c));
            Pair<Integer, String> pairM47851a = C7779bz.m47851a(context, "/adid/sync", "");
            C7124fh.m43316b(context).mo43485s("adid");
            if (pairM47851a == null || ((Integer) pairM47851a.first).intValue() != 200) {
                AbstractC7185ho.m43817a("AdInfoUtil", "adid_double_frame get adid error");
                return;
            }
            long jM47566c2 = AbstractC7741ao.m47566c();
            AbstractC7185ho.m43818a("AdInfoUtil", "adid_double_frame get adid end time : %s, diff : %s, adid is : %s", Long.valueOf(jM47566c2), Long.valueOf(jM47566c2 - jM47566c), AbstractC7806cz.m48176g((String) pairM47851a.second));
            InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
            Object obj = pairM47851a.second;
            interfaceC7146gcM43316b.mo43323C(obj != null ? (String) obj : "");
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$7 */
    public static class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36067a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36068b;

        /* renamed from: com.huawei.openalliance.ad.utils.d$7$1 */
        public class AnonymousClass1 implements RemoteCallResultCallback<String> {

            /* renamed from: a */
            final /* synthetic */ AtomicInteger f36069a;

            public AnonymousClass1(AtomicInteger atomicInteger) {
                atomicInteger = atomicInteger;
            }

            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                atomicInteger.incrementAndGet();
                if (callResult.getCode() != 200) {
                    AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid failed");
                    return;
                }
                AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid success");
                c7787cg.m47993h(callResult.getData());
                AtomicInteger atomicInteger = atomicInteger;
                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                AbstractC7807d.m48221b(atomicInteger, c7787cg, context);
            }
        }

        /* renamed from: com.huawei.openalliance.ad.utils.d$7$2 */
        public class AnonymousClass2 extends OAIDServiceManager.OaidResultCallback {

            /* renamed from: a */
            final /* synthetic */ AtomicInteger f36071a;

            public AnonymousClass2(AtomicInteger atomicInteger) {
                atomicInteger = atomicInteger;
            }

            @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
            /* renamed from: a */
            public void mo44091a() {
                AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquireFailed");
                c7787cg.m47953a((String) null, (Boolean) null);
            }

            @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
            /* renamed from: a */
            public void mo44092a(String str, boolean z10) {
                AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquired");
                c7787cg.m47953a(str, Boolean.valueOf(z10));
                atomicInteger.incrementAndGet();
                AtomicInteger atomicInteger = atomicInteger;
                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                AbstractC7807d.m48221b(atomicInteger, c7787cg, context);
            }
        }

        public AnonymousClass7(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6982bz.m41152b(context)) {
                AtomicInteger atomicInteger = new AtomicInteger(0);
                C7484ms.m45854a(context).m45855a(RTCMethods.QUERY_UUID, "", new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.d.7.1

                    /* renamed from: a */
                    final /* synthetic */ AtomicInteger f36069a;

                    public AnonymousClass1(AtomicInteger atomicInteger2) {
                        atomicInteger = atomicInteger2;
                    }

                    @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        atomicInteger.incrementAndGet();
                        if (callResult.getCode() != 200) {
                            AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid failed");
                            return;
                        }
                        AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid success");
                        c7787cg.m47993h(callResult.getData());
                        AtomicInteger atomicInteger2 = atomicInteger;
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        AbstractC7807d.m48221b(atomicInteger2, c7787cg, context);
                    }
                }, String.class);
                OAIDServiceManager.getInstance(context).requireOaid(new OAIDServiceManager.OaidResultCallback() { // from class: com.huawei.openalliance.ad.utils.d.7.2

                    /* renamed from: a */
                    final /* synthetic */ AtomicInteger f36071a;

                    public AnonymousClass2(AtomicInteger atomicInteger2) {
                        atomicInteger = atomicInteger2;
                    }

                    @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                    /* renamed from: a */
                    public void mo44091a() {
                        AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquireFailed");
                        c7787cg.m47953a((String) null, (Boolean) null);
                    }

                    @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                    /* renamed from: a */
                    public void mo44092a(String str, boolean z10) {
                        AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquired");
                        c7787cg.m47953a(str, Boolean.valueOf(z10));
                        atomicInteger.incrementAndGet();
                        AtomicInteger atomicInteger2 = atomicInteger;
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        AbstractC7807d.m48221b(atomicInteger2, c7787cg, context);
                    }
                });
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$8 */
    public static class AnonymousClass8 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36073a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36074b;

        /* renamed from: com.huawei.openalliance.ad.utils.d$8$1 */
        public class AnonymousClass1 extends OAIDServiceManager.OaidResultCallback {
            public AnonymousClass1() {
            }

            @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
            /* renamed from: a */
            public void mo44091a() {
                AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquireFailed");
                C7787cg c7787cg = c7787cg;
                if (c7787cg != null) {
                    c7787cg.m47953a((String) null, (Boolean) null);
                }
            }

            @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
            /* renamed from: a */
            public void mo44092a(String str, boolean z10) {
                AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquired");
                C7787cg c7787cg = c7787cg;
                if (c7787cg != null) {
                    c7787cg.m47953a(str, Boolean.valueOf(z10));
                }
            }
        }

        public AnonymousClass8(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6982bz.m41158h(context)) {
                OAIDServiceManager.getInstance(context).requireOaid(new OAIDServiceManager.OaidResultCallback() { // from class: com.huawei.openalliance.ad.utils.d.8.1
                    public AnonymousClass1() {
                    }

                    @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                    /* renamed from: a */
                    public void mo44091a() {
                        AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquireFailed");
                        C7787cg c7787cg = c7787cg;
                        if (c7787cg != null) {
                            c7787cg.m47953a((String) null, (Boolean) null);
                        }
                    }

                    @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                    /* renamed from: a */
                    public void mo44092a(String str, boolean z10) {
                        AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquired");
                        C7787cg c7787cg = c7787cg;
                        if (c7787cg != null) {
                            c7787cg.m47953a(str, Boolean.valueOf(z10));
                        }
                    }
                });
                return;
            }
            AbstractC7185ho.m43820b("AdInfoUtil", "thirdDevice, get oaid.");
            Pair<String, Boolean> pairM48357a = C7814dg.m48357a(context);
            if (pairM48357a == null || c7787cg == null) {
                c7787cg.m47953a((String) null, Boolean.FALSE);
                AbstractC7185ho.m43820b("AdInfoUtil", "get oaid fail.");
            } else {
                AbstractC7185ho.m43820b("AdInfoUtil", "oaid acquired.");
                c7787cg.m47953a((String) pairM48357a.first, (Boolean) pairM48357a.second);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$9 */
    public static class AnonymousClass9 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36076a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36077b;

        /* renamed from: c */
        final /* synthetic */ long f36078c;

        public AnonymousClass9(Context context, C7787cg c7787cg, long j10) {
            context = context;
            c7787cg = c7787cg;
            j = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c7787cg.m47952a(AbstractC7807d.m48199J(context));
            C7124fh.m43316b(context).mo43463i(j);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.d$a */
    public static class a implements Runnable {

        /* renamed from: a */
        private final Context f36079a;

        /* renamed from: b */
        private final String f36080b;

        /* renamed from: c */
        private final boolean f36081c;

        public a(Context context, String str, boolean z10) {
            this.f36079a = context;
            this.f36080b = str;
            this.f36081c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7787cg.m47900a(this.f36079a).m47953a(this.f36080b, Boolean.valueOf(this.f36081c));
        }
    }

    /* renamed from: A */
    public static Integer m48190A(Context context) {
        Integer numM47947Z = C7787cg.m47900a(context).m47947Z();
        return numM47947Z == null ? m48191B(context) : numM47947Z;
    }

    /* renamed from: B */
    public static Integer m48191B(Context context) {
        Integer numM47581g = AbstractC7741ao.m47581g(context);
        AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.5

            /* renamed from: a */
            final /* synthetic */ Context f36064a;

            /* renamed from: b */
            final /* synthetic */ Integer f36065b;

            public AnonymousClass5(Context context2, Integer numM47581g2) {
                context = context2;
                num = numM47581g2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7787cg.m47900a(context).m47951a(num);
            }
        });
        return numM47581g2;
    }

    /* renamed from: C */
    public static void m48192C(Context context) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.6

            /* renamed from: a */
            final /* synthetic */ Context f36066a;

            public AnonymousClass6(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43817a("AdInfoUtil", "adid_double_frame start to getAdid from hms");
                if (!AbstractC7811dd.m48330g()) {
                    AbstractC7185ho.m43817a("AdInfoUtil", "adid_double_frame not inside device");
                    return;
                }
                boolean zMo43052a = C7124fh.m43316b(context).mo43052a("adid", 180);
                AbstractC7185ho.m43818a("AdInfoUtil", "adid_double_frame getAdid in Interval : %s", Boolean.valueOf(zMo43052a));
                if (zMo43052a) {
                    return;
                }
                long jM47566c = AbstractC7741ao.m47566c();
                AbstractC7185ho.m43818a("AdInfoUtil", "adid_double_frame get adid start time : %s", Long.valueOf(jM47566c));
                Pair<Integer, String> pairM47851a = C7779bz.m47851a(context, "/adid/sync", "");
                C7124fh.m43316b(context).mo43485s("adid");
                if (pairM47851a == null || ((Integer) pairM47851a.first).intValue() != 200) {
                    AbstractC7185ho.m43817a("AdInfoUtil", "adid_double_frame get adid error");
                    return;
                }
                long jM47566c2 = AbstractC7741ao.m47566c();
                AbstractC7185ho.m43818a("AdInfoUtil", "adid_double_frame get adid end time : %s, diff : %s, adid is : %s", Long.valueOf(jM47566c2), Long.valueOf(jM47566c2 - jM47566c), AbstractC7806cz.m48176g((String) pairM47851a.second));
                InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
                Object obj = pairM47851a.second;
                interfaceC7146gcM43316b.mo43323C(obj != null ? (String) obj : "");
            }
        });
    }

    /* renamed from: F */
    public static boolean m48195F(Context context) {
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
        long jMo43394bU = interfaceC7146gcM43316b.mo43394bU();
        long jMo43041S = interfaceC7146gcM43316b.mo43041S() * 60000;
        long jM47566c = AbstractC7741ao.m47566c();
        if (jM47566c < jMo43394bU + jMo43041S) {
            AbstractC7185ho.m43818a("AdInfoUtil", "request UUID time limit, timeInterval= %s min, lastTime= %s", Long.valueOf(jMo43041S / 60000), AbstractC7741ao.m47545a(Constants.TIME_FORMAT_WITHOUT_MILLS).format(Long.valueOf(jMo43394bU)));
            return true;
        }
        interfaceC7146gcM43316b.mo43470k(jM47566c);
        return false;
    }

    /* renamed from: G */
    private static boolean m48196G(Context context) {
        String packageName = context.getPackageName();
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
        long jMo43393bT = interfaceC7146gcM43316b.mo43393bT();
        long jMo43040R = interfaceC7146gcM43316b.mo43040R() * 60000;
        if (System.currentTimeMillis() - jMo43393bT >= jMo43040R) {
            interfaceC7146gcM43316b.mo43466j(System.currentTimeMillis());
            return false;
        }
        AbstractC7185ho.m43817a("AdInfoUtil", "request OAID time limit, timeInter=" + jMo43040R + ", lastTime=" + jMo43393bT + " callerPkg: " + packageName);
        return true;
    }

    /* renamed from: H */
    private static Pair<String, Boolean> m48197H(Context context) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        AbstractC7185ho.m43820b("AdInfoUtil", "thirdDevice, get oaid.");
        Pair<String, Boolean> pairM47995i = c7787cgM47900a.m47995i();
        if (m48196G(context)) {
            return pairM47995i;
        }
        Pair<String, Boolean> pairM48357a = C7814dg.m48357a(context);
        if (pairM48357a != null) {
            AbstractC7185ho.m43820b("AdInfoUtil", "oaid acquired.");
            c7787cgM47900a.m47953a((String) pairM48357a.first, (Boolean) pairM48357a.second);
            return pairM48357a;
        }
        AbstractC7185ho.m43820b("AdInfoUtil", "derectOaid is null.");
        c7787cgM47900a.m47953a((String) null, (Boolean) null);
        return null;
    }

    /* renamed from: I */
    private static DisplayMetrics m48198I(Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null || (windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return null;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0050 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* renamed from: J */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m48199J(android.content.Context r3) {
        /*
            java.lang.String r0 = "AdInfoUtil"
            com.huawei.openalliance.p169ad.utils.AbstractC7811dd.m48331h(r3)     // Catch: java.lang.Throwable -> L19 android.util.AndroidRuntimeException -> L47
            java.lang.String r3 = android.webkit.WebSettings.getDefaultUserAgent(r3)     // Catch: java.lang.Throwable -> L19 android.util.AndroidRuntimeException -> L47
            boolean r1 = com.huawei.openalliance.p169ad.AbstractC7185ho.m43819a()     // Catch: java.lang.Throwable -> L19 android.util.AndroidRuntimeException -> L47
            if (r1 == 0) goto L1b
            java.lang.String r1 = "get ua:%s"
            java.lang.Object[] r2 = new java.lang.Object[]{r3}     // Catch: java.lang.Throwable -> L19 android.util.AndroidRuntimeException -> L47
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r0, r1, r2)     // Catch: java.lang.Throwable -> L19 android.util.AndroidRuntimeException -> L47
            goto L1b
        L19:
            r3 = move-exception
            goto L26
        L1b:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L19 android.util.AndroidRuntimeException -> L47
            if (r1 == 0) goto L4a
            java.lang.String r3 = m48234e()     // Catch: java.lang.Throwable -> L19 android.util.AndroidRuntimeException -> L47
            goto L4a
        L26:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getUserAgent fail: "
            r1.append(r2)
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r1.append(r3)
            java.lang.String r3 = r1.toString()
        L3f:
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c(r0, r3)
            java.lang.String r3 = m48234e()
            goto L4a
        L47:
            java.lang.String r3 = "getUserAgent fail"
            goto L3f
        L4a:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L52
            java.lang.String r3 = "NOT_FOUND"
        L52:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.utils.AbstractC7807d.m48199J(android.content.Context):java.lang.String");
    }

    /* renamed from: K */
    private static String m48200K(Context context) {
        AbstractC7185ho.m43820b("AdInfoUtil", "getAgCountryCodeFromAg");
        String str = (String) AbstractC7810dc.m48268a(new Callable<String>() { // from class: com.huawei.openalliance.ad.utils.d.14

            /* renamed from: a */
            final /* synthetic */ Context f36059a;

            public AnonymousClass14(Context context2) {
                context = context2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public String call() {
                try {
                    return (String) C8943k.m56661a(HomeCountryApi.getHomeCountry(context, "PPSSDK", false));
                } catch (Throwable unused) {
                    AbstractC7185ho.m43826d("AdInfoUtil", "getAgCountryCodeFromAg Throwable ");
                    return Constants.NOT_FOUND;
                }
            }
        }, 100L, Constants.NOT_FOUND);
        AbstractC7185ho.m43817a("AdInfoUtil", "ag country code=" + str);
        return str;
    }

    /* renamed from: L */
    private static int m48201L(Context context) {
        String string;
        if (context == null) {
            return -1;
        }
        if (AbstractC7741ao.m47534a(context) >= 10 || C6982bz.m41155e(context)) {
            try {
                int iMo41198a = Settings.Secure.getInt(context.getContentResolver(), "accessibility_screenreader_enabled");
                if (iMo41198a == -1) {
                    iMo41198a = C6985cb.m41166a(context).mo41198a(context);
                }
                if (iMo41198a == 1) {
                    return 1;
                }
                return iMo41198a == 0 ? 0 : -1;
            } catch (Settings.SettingNotFoundException unused) {
                AbstractC7185ho.m43826d("AdInfoUtil", "get ScreenReader status error, setting not found.");
                return -1;
            } catch (Throwable unused2) {
                AbstractC7185ho.m43826d("AdInfoUtil", "get ScreenReader status error.");
                return -1;
            }
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled") != 1 || (string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services")) == null) {
                return 0;
            }
            return (string.contains(new ComponentName("com.google.android.marvin.talkback", "com.google.android.marvin.talkback.TalkBackService").flattenToString()) || string.contains(new ComponentName("com.bjbyhd.screenreader_huawei", "com.bjbyhd.screenreader_huawei.ScreenReaderService").flattenToString()) || string.contains(new ComponentName("com.google.android.marvin.talkback", ".TalkBackService").flattenToString()) || string.contains(new ComponentName("com.samsung.accessibility", "com.samsung.android.app.talkback.TalkBackService").flattenToString())) ? 1 : 0;
        } catch (Settings.SettingNotFoundException unused3) {
            AbstractC7185ho.m43826d("AdInfoUtil", "get ScreenReader status error, setting not found.");
            return -1;
        } catch (Throwable unused4) {
            AbstractC7185ho.m43826d("AdInfoUtil", "get ScreenReader status error.");
            return -1;
        }
    }

    /* renamed from: a */
    public static int m48202a(Context context) {
        if (context == null) {
            return 0;
        }
        return m48237f(context).heightPixels;
    }

    /* renamed from: b */
    public static int m48215b(Context context) {
        if (context == null) {
            return 0;
        }
        return m48237f(context).widthPixels;
    }

    /* renamed from: c */
    public static int m48223c(Context context) {
        if (context == null) {
            return 0;
        }
        return AbstractC7741ao.m47557b(context, m48229d(context));
    }

    /* renamed from: d */
    public static int m48229d(Context context) {
        if (context == null) {
            return 0;
        }
        int iM48202a = m48202a(context);
        int iM48215b = m48215b(context);
        return iM48202a > iM48215b ? iM48215b : iM48202a;
    }

    /* renamed from: e */
    public static int m48233e(Context context) {
        if (context == null) {
            return 0;
        }
        int iM48202a = m48202a(context);
        int iM48215b = m48215b(context);
        return iM48202a > iM48215b ? iM48202a : iM48215b;
    }

    /* renamed from: f */
    public static DisplayMetrics m48237f(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null || (windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)) == null) {
            return displayMetrics;
        }
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: g */
    public static String m48239g(Context context) {
        if (context == null) {
            return null;
        }
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47924G = c7787cgM47900a.m47924G();
        if (TextUtils.isEmpty(strM47924G)) {
            return m48235e(context, c7787cgM47900a);
        }
        boolean zEqualsIgnoreCase = Constants.NOT_FOUND.equalsIgnoreCase(strM47924G);
        if (AbstractC7185ho.m43819a() && !zEqualsIgnoreCase) {
            AbstractC7185ho.m43817a("AdInfoUtil", "use cached androidID.");
        }
        if (zEqualsIgnoreCase) {
            return null;
        }
        return strM47924G;
    }

    /* renamed from: h */
    public static String m48241h(Context context) {
        if (!HiAd.getInstance(context).isEnableUserInfo()) {
            AbstractC7185ho.m43820b("AdInfoUtil", "not enable userinfo, skip udid.");
            return null;
        }
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47926H = c7787cgM47900a.m47926H();
        if (TextUtils.isEmpty(strM47926H)) {
            return m48238f(context, c7787cgM47900a);
        }
        AbstractC7185ho.m43820b("AdInfoUtil", "use cached udid");
        if (Constants.NOT_FOUND.equalsIgnoreCase(strM47926H)) {
            return null;
        }
        return strM47926H;
    }

    /* renamed from: i */
    public static int m48243i(Context context) {
        try {
            DisplayMetrics displayMetricsM48198I = m48198I(context);
            if (displayMetricsM48198I != null) {
                return displayMetricsM48198I.densityDpi;
            }
            return 0;
        } catch (RuntimeException | Exception unused) {
            AbstractC7185ho.m43823c("AdInfoUtil", "getDensityDpi fail");
            return 0;
        }
    }

    /* renamed from: j */
    public static float m48245j(Context context) {
        try {
            DisplayMetrics displayMetricsM48198I = m48198I(context);
            if (displayMetricsM48198I != null) {
                return displayMetricsM48198I.density;
            }
            return 0.0f;
        } catch (RuntimeException | Exception unused) {
            AbstractC7185ho.m43823c("AdInfoUtil", "getDensity fail");
            return 0.0f;
        }
    }

    /* renamed from: k */
    public static String m48247k(Context context) {
        if (context == null) {
            return null;
        }
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47966b = c7787cgM47900a.m47966b();
        if (TextUtils.isEmpty(strM47966b)) {
            strM47966b = m48199J(context);
            c7787cgM47900a.m47952a(strM47966b);
        } else if (!Constants.HW_INTELLIEGNT_PACKAGE.equalsIgnoreCase(context.getPackageName())) {
            m48240g(context, c7787cgM47900a);
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM47966b)) {
            return null;
        }
        return strM47966b;
    }

    /* renamed from: l */
    public static String m48249l(Context context) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47977d = c7787cgM47900a.m47977d();
        if (TextUtils.isEmpty(strM47977d)) {
            strM47977d = m48242h(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48358a("getHsfVersionCode")) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.10

                /* renamed from: a */
                final /* synthetic */ Context f36051a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36052b;

                public AnonymousClass10(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7807d.m48242h(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM47977d)) {
            return null;
        }
        return strM47977d;
    }

    /* renamed from: m */
    public static String m48250m(Context context) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47981e = c7787cgM47900a.m47981e();
        if (TextUtils.isEmpty(strM47981e)) {
            strM47981e = m48246j(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48358a("getHmsVersionCode")) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.11

                /* renamed from: a */
                final /* synthetic */ Context f36053a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36054b;

                public AnonymousClass11(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7807d.m48246j(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM47981e)) {
            return null;
        }
        return strM47981e;
    }

    /* renamed from: n */
    public static String m48251n(Context context) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48002l = c7787cgM47900a.m48002l();
        if (TextUtils.isEmpty(strM48002l)) {
            strM48002l = m48248k(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48358a("getAgVersionCode")) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.12

                /* renamed from: a */
                final /* synthetic */ Context f36055a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36056b;

                public AnonymousClass12(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7807d.m48248k(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM48002l)) {
            return null;
        }
        return strM48002l;
    }

    /* renamed from: o */
    public static String m48252o(Context context) {
        if (!C6982bz.m41152b(context)) {
            return null;
        }
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48004m = c7787cgM47900a.m48004m();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AdInfoUtil", "cached agCountryCode: %s", strM48004m);
        }
        if (TextUtils.isEmpty(strM48004m) || AbstractC7815dh.m48358a("getAgCountryCode")) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.13

                /* renamed from: a */
                final /* synthetic */ Context f36057a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36058b;

                public AnonymousClass13(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7807d.m48244i(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM48004m)) {
            return null;
        }
        return strM48004m;
    }

    /* renamed from: p */
    public static boolean m48253p(Context context) {
        if (C6982bz.m41148a(context).mo41175d() && (AbstractC7741ao.m47534a(context) >= 10 || C6982bz.m41155e(context))) {
            if (context == null) {
                return true;
            }
            try {
                try {
                    Object obj = context.getPackageManager().getApplicationInfo(Constants.PARENT_CONTROL_PACKAGE_NAME, 128).metaData.get(Constants.CONTENT_SWITCH_SUPPORT_KEY);
                    if (obj == null) {
                        return false;
                    }
                    return "1".equals(obj.toString());
                } catch (Throwable unused) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException | Exception unused2) {
            }
        }
        return false;
    }

    /* renamed from: q */
    public static int m48254q(Context context) {
        if (context != null && m48253p(context)) {
            try {
                int i10 = Settings.Secure.getInt(context.getContentResolver(), Constants.PATH_CHILDMODE_STATUS);
                int i11 = Settings.Secure.getInt(context.getContentResolver(), Constants.PATH_PARENTMODE_STATUS);
                if (i10 == 0) {
                    return i11 == 0 ? -1 : 0;
                }
                return 1;
            } catch (Settings.SettingNotFoundException unused) {
                AbstractC7185ho.m43826d("AdInfoUtil", "get childMode and parentMode error, setting not found.");
            } catch (Throwable unused2) {
                AbstractC7185ho.m43826d("AdInfoUtil", "get childMode and parentMode error.");
                return 1;
            }
        }
        return -1;
    }

    /* renamed from: r */
    public static int m48255r(Context context) {
        String str;
        if (context == null) {
            return 1;
        }
        try {
            return Settings.Global.getInt(context.getContentResolver(), Constants.NAVIGATIONBAR_IS_MIN) == 1 ? 1 : 0;
        } catch (Settings.SettingNotFoundException unused) {
            str = "get navigation status error, setting not found.";
            AbstractC7185ho.m43826d("AdInfoUtil", str);
            return 1;
        } catch (Throwable unused2) {
            str = "get navigation status error.";
            AbstractC7185ho.m43826d("AdInfoUtil", str);
            return 1;
        }
    }

    /* renamed from: s */
    public static int m48256s(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iM48201L = m48201L(context);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AdInfoUtil", "getScreenReaderStatus end duration: %d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        }
        return iM48201L;
    }

    /* renamed from: t */
    public static boolean m48257t(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                try {
                    String string = Settings.Global.getString(context.getContentResolver(), "ex_splash_block_list");
                    if ((!TextUtils.isEmpty(string) && Arrays.asList(string.split(";")).contains(packageName)) || Settings.Global.getInt(context.getContentResolver(), "ex_splash_func_status", 0) == 0) {
                        return false;
                    }
                    String string2 = Settings.Global.getString(context.getContentResolver(), "ex_splash_list");
                    if (TextUtils.isEmpty(string2)) {
                        return false;
                    }
                    return Arrays.asList(string2.split(";")).contains(packageName);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43823c("AdInfoUtil", "exception happen: " + th2.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    /* renamed from: u */
    public static int m48258u(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "secure_gesture_navigation", 0);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("AdInfoUtil", "exception happen: " + th2.getClass().getSimpleName());
            return 0;
        }
    }

    /* renamed from: v */
    public static String m48259v(Context context) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47918D = c7787cgM47900a.m47918D();
        if (TextUtils.isEmpty(strM47918D)) {
            strM47918D = m48236e(c7787cgM47900a, context);
        } else if (AbstractC7815dh.m48358a("getBrandCust")) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.2

                /* renamed from: b */
                final /* synthetic */ Context f36061b;

                public AnonymousClass2(Context context2) {
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7807d.m48236e(c7787cg, context);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM47918D)) {
            return null;
        }
        return strM47918D;
    }

    /* renamed from: w */
    public static List<String> m48260w(Context context) {
        String str;
        ArrayList arrayList = new ArrayList();
        String strMo43176a = C7114ey.m43174a(context).mo43176a();
        if (TextUtils.equals(strMo43176a, "")) {
            return arrayList;
        }
        try {
            return new ArrayList(Arrays.asList(strMo43176a.split(",")));
        } catch (RuntimeException unused) {
            str = "fromString RuntimeException";
            AbstractC7185ho.m43823c("AdInfoUtil", str);
            return arrayList;
        } catch (Exception unused2) {
            str = "fromString Exception";
            AbstractC7185ho.m43823c("AdInfoUtil", str);
            return arrayList;
        }
    }

    /* renamed from: x */
    public static int m48261x(Context context) {
        try {
            return Integer.parseInt(C7114ey.m43174a(context).mo43180b());
        } catch (NumberFormatException unused) {
            AbstractC7185ho.m43823c("AdInfoUtil", "EncodingMode fromString Exception");
            return 1;
        }
    }

    /* renamed from: y */
    public static String m48262y(Context context) {
        String strM47942U = C7787cg.m47900a(context).m47942U();
        if (TextUtils.isEmpty(strM47942U)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.3

                /* renamed from: a */
                final /* synthetic */ Context f36062a;

                public AnonymousClass3(Context context2) {
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7787cg.m47900a(context).m47925G(C7845x.m48539b(context));
                }
            });
        }
        return strM47942U;
    }

    /* renamed from: z */
    public static String m48263z(Context context) {
        String strM47943V = C7787cg.m47900a(context).m47943V();
        if (TextUtils.isEmpty(strM47943V)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.4

                /* renamed from: a */
                final /* synthetic */ Context f36063a;

                public AnonymousClass4(Context context2) {
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7787cg.m47900a(context).m47927H(C7845x.m48544c(context));
                }
            });
        }
        return strM47943V;
    }

    /* renamed from: a */
    public static int m48203a(Context context, int i10) {
        return i10 == 0 ? m48233e(context) : m48229d(context);
    }

    /* renamed from: b */
    public static int m48216b(Context context, int i10) {
        return i10 == 0 ? m48229d(context) : m48233e(context);
    }

    /* renamed from: c */
    public static String m48224c() {
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    }

    /* renamed from: e */
    private static String m48234e() {
        String str;
        try {
            return System.getProperty("http.agent");
        } catch (IllegalArgumentException unused) {
            str = "getSystemUserAgent fail";
            AbstractC7185ho.m43823c("AdInfoUtil", str);
            return null;
        } catch (Exception unused2) {
            str = "getSystemUserAgent Exception";
            AbstractC7185ho.m43823c("AdInfoUtil", str);
            return null;
        }
    }

    /* renamed from: f */
    private static String m48238f(Context context, C7787cg c7787cg) {
        StringBuilder sb2;
        String str;
        Object objInvoke;
        if (!HiAd.getInstance(context).isEnableUserInfo()) {
            AbstractC7185ho.m43820b("AdInfoUtil", "not enable userinfo, skip udid.");
            return null;
        }
        if (C7124fh.m43316b(context).mo43071b(IntervalMethods.REQ_UDID)) {
            AbstractC7185ho.m43817a("AdInfoUtil", "within udid call time interval");
            return null;
        }
        try {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43817a("AdInfoUtil", "no cached udid, direct get.");
            }
            C7124fh.m43316b(context).mo43485s(IntervalMethods.REQ_UDID);
            Class<?> cls = Class.forName(C6985cb.m41166a(context).mo41209f());
            objInvoke = cls.getDeclaredMethod("getUDID", new Class[0]).invoke(cls, new Object[0]);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "getUDID RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d("AdInfoUtil", sb2.toString());
            return null;
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            str = "getUDID Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d("AdInfoUtil", sb2.toString());
            return null;
        }
        if (objInvoke instanceof String) {
            c7787cg.m47916C((String) objInvoke);
            return (String) objInvoke;
        }
        c7787cg.m47916C(Constants.NOT_FOUND);
        return null;
    }

    /* renamed from: g */
    private static void m48240g(Context context, C7787cg c7787cg) {
        long jMo43380bG = C7124fh.m43316b(context).mo43380bG();
        long jM47566c = AbstractC7741ao.m47566c();
        if (jM47566c - jMo43380bG >= Constants.TWO_WEEK) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.9

                /* renamed from: a */
                final /* synthetic */ Context f36076a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36077b;

                /* renamed from: c */
                final /* synthetic */ long f36078c;

                public AnonymousClass9(Context context2, C7787cg c7787cg2, long jM47566c2) {
                    context = context2;
                    c7787cg = c7787cg2;
                    j = jM47566c2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c7787cg.m47952a(AbstractC7807d.m48199J(context));
                    C7124fh.m43316b(context).mo43463i(j);
                }
            });
        } else {
            AbstractC7185ho.m43820b("AdInfoUtil", "query ua once 2 week");
        }
    }

    /* renamed from: h */
    public static String m48242h(Context context, C7787cg c7787cg) {
        String strM48207a = m48207a(context, Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE);
        if (strM48207a == null) {
            strM48207a = m48207a(context, Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE_NEW);
        }
        if (strM48207a == null) {
            strM48207a = Constants.NOT_FOUND;
        }
        c7787cg.m47970b(strM48207a);
        return strM48207a;
    }

    /* renamed from: i */
    public static String m48244i(Context context, C7787cg c7787cg) {
        String strM48200K = m48200K(context);
        if (strM48200K == null) {
            strM48200K = Constants.NOT_FOUND;
        }
        if (!TextUtils.equals(Constants.NOT_FOUND, strM48200K)) {
            c7787cg.m47999j(strM48200K);
        }
        return strM48200K;
    }

    /* renamed from: j */
    public static String m48246j(Context context, C7787cg c7787cg) {
        String strM48207a = m48207a(context, C7830i.m48434e(context));
        if (strM48207a == null) {
            strM48207a = Constants.NOT_FOUND;
        }
        c7787cg.m47975c(strM48207a);
        return strM48207a;
    }

    /* renamed from: k */
    public static String m48248k(Context context, C7787cg c7787cg) {
        String strM48207a = m48207a(context, "com.huawei.appmarket");
        if (strM48207a == null) {
            strM48207a = Constants.NOT_FOUND;
        }
        c7787cg.m47996i(strM48207a);
        return strM48207a;
    }

    /* renamed from: a */
    public static String m48204a() {
        return Locale.getDefault().getLanguage();
    }

    /* renamed from: b */
    public static Pair<String, Boolean> m48217b(Context context, boolean z10) {
        if (context == null) {
            return null;
        }
        if (!HiAd.getInstance(context).isEnableUserInfo()) {
            AbstractC7185ho.m43820b("AdInfoUtil", "not enable user info, skip oaid");
            return null;
        }
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        AbstractC7185ho.m43820b("AdInfoUtil", "query oaid");
        if (C6982bz.m41158h(context)) {
            Pair<String, Boolean> pairM47846a = C7778by.m47846a(context);
            if (pairM47846a != null && !m48196G(context)) {
                AbstractC7185ho.m43820b("AdInfoUtil", "read from setting");
                m48231d(C6982bz.m41148a(context).mo41175d() ? c7787cgM47900a : null, context.getApplicationContext());
            }
            if (pairM47846a != null) {
                return pairM47846a;
            }
        } else {
            Pair<String, Boolean> pairM48197H = m48197H(context);
            if (pairM48197H != null) {
                return pairM48197H;
            }
        }
        if (!C6982bz.m41148a(context).mo41175d()) {
            return null;
        }
        String strM48532a = C7845x.m48532a(context);
        if (!TextUtils.isEmpty(strM48532a) && !strM48532a.equalsIgnoreCase(c7787cgM47900a.m47998j())) {
            m48226c(c7787cgM47900a, context.getApplicationContext());
            return null;
        }
        if (z10 && C6982bz.m41158h(context) && !C7124fh.m43316b(context).mo43052a(IntervalMethods.DIRECT_REQ_OAID, 2)) {
            AbstractC7185ho.m43820b("AdInfoUtil", "start to request oaid");
            C7124fh.m43316b(context).mo43485s(IntervalMethods.DIRECT_REQ_OAID);
            m48231d(c7787cgM47900a, context.getApplicationContext());
        }
        AbstractC7185ho.m43820b("AdInfoUtil", "read from cache");
        Pair<String, Boolean> pairM47995i = c7787cgM47900a.m47995i();
        return (Build.BRAND.equalsIgnoreCase("HONOR") && pairM47995i == null) ? C7743aq.m47598a(context) : pairM47995i;
    }

    /* renamed from: d */
    private static void m48231d(C7787cg c7787cg, Context context) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.8

            /* renamed from: a */
            final /* synthetic */ Context f36073a;

            /* renamed from: b */
            final /* synthetic */ C7787cg f36074b;

            /* renamed from: com.huawei.openalliance.ad.utils.d$8$1 */
            public class AnonymousClass1 extends OAIDServiceManager.OaidResultCallback {
                public AnonymousClass1() {
                }

                @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                /* renamed from: a */
                public void mo44091a() {
                    AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquireFailed");
                    C7787cg c7787cg = c7787cg;
                    if (c7787cg != null) {
                        c7787cg.m47953a((String) null, (Boolean) null);
                    }
                }

                @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                /* renamed from: a */
                public void mo44092a(String str, boolean z10) {
                    AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquired");
                    C7787cg c7787cg = c7787cg;
                    if (c7787cg != null) {
                        c7787cg.m47953a(str, Boolean.valueOf(z10));
                    }
                }
            }

            public AnonymousClass8(Context context2, C7787cg c7787cg2) {
                context = context2;
                c7787cg = c7787cg2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C6982bz.m41158h(context)) {
                    OAIDServiceManager.getInstance(context).requireOaid(new OAIDServiceManager.OaidResultCallback() { // from class: com.huawei.openalliance.ad.utils.d.8.1
                        public AnonymousClass1() {
                        }

                        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                        /* renamed from: a */
                        public void mo44091a() {
                            AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquireFailed");
                            C7787cg c7787cg2 = c7787cg;
                            if (c7787cg2 != null) {
                                c7787cg2.m47953a((String) null, (Boolean) null);
                            }
                        }

                        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                        /* renamed from: a */
                        public void mo44092a(String str, boolean z10) {
                            AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquired");
                            C7787cg c7787cg2 = c7787cg;
                            if (c7787cg2 != null) {
                                c7787cg2.m47953a(str, Boolean.valueOf(z10));
                            }
                        }
                    });
                    return;
                }
                AbstractC7185ho.m43820b("AdInfoUtil", "thirdDevice, get oaid.");
                Pair<String, Boolean> pairM48357a = C7814dg.m48357a(context);
                if (pairM48357a == null || c7787cg == null) {
                    c7787cg.m47953a((String) null, Boolean.FALSE);
                    AbstractC7185ho.m43820b("AdInfoUtil", "get oaid fail.");
                } else {
                    AbstractC7185ho.m43820b("AdInfoUtil", "oaid acquired.");
                    c7787cg.m47953a((String) pairM48357a.first, (Boolean) pairM48357a.second);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0064  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m48235e(android.content.Context r4, com.huawei.openalliance.p169ad.utils.C7787cg r5) {
        /*
            if (r4 != 0) goto L5
            java.lang.String r4 = ""
            return r4
        L5:
            boolean r0 = com.huawei.openalliance.p169ad.AbstractC7185ho.m43819a()
            java.lang.String r1 = "AdInfoUtil"
            if (r0 == 0) goto L12
            java.lang.String r0 = "no cached androidID, direct get."
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r1, r0)
        L12:
            java.lang.String r0 = com.huawei.openalliance.p169ad.utils.AbstractC7807d.f36047a
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L1b
            return r0
        L1b:
            android.content.ContentResolver r0 = r4.getContentResolver()     // Catch: java.lang.Exception -> L26 java.lang.RuntimeException -> L28
            java.lang.String r2 = "android_id"
            java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r2)     // Catch: java.lang.Exception -> L26 java.lang.RuntimeException -> L28
            goto L50
        L26:
            r0 = move-exception
            goto L2a
        L28:
            r0 = move-exception
            goto L47
        L2a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getAndroidID Exception:"
        L31:
            r2.append(r3)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c(r1, r0)
            goto L4f
        L47:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getAndroidID RuntimeException:"
            goto L31
        L4f:
            r0 = 0
        L50:
            if (r5 != 0) goto L56
            com.huawei.openalliance.ad.utils.cg r5 = com.huawei.openalliance.p169ad.utils.C7787cg.m47900a(r4)
        L56:
            com.huawei.openalliance.p169ad.utils.AbstractC7807d.f36047a = r0
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L64
            java.lang.String r4 = "NOT_FOUND"
        L60:
            r5.m47915B(r4)
            goto L67
        L64:
            java.lang.String r4 = com.huawei.openalliance.p169ad.utils.AbstractC7807d.f36047a
            goto L60
        L67:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.utils.AbstractC7807d.m48235e(android.content.Context, com.huawei.openalliance.ad.utils.cg):java.lang.String");
    }

    /* renamed from: a */
    public static String m48205a(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "2" : "5" : "4" : "3";
    }

    /* renamed from: b */
    public static String m48218b() {
        return Locale.getDefault().getScript();
    }

    /* renamed from: c */
    private static void m48226c(C7787cg c7787cg, Context context) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.7

            /* renamed from: a */
            final /* synthetic */ Context f36067a;

            /* renamed from: b */
            final /* synthetic */ C7787cg f36068b;

            /* renamed from: com.huawei.openalliance.ad.utils.d$7$1 */
            public class AnonymousClass1 implements RemoteCallResultCallback<String> {

                /* renamed from: a */
                final /* synthetic */ AtomicInteger f36069a;

                public AnonymousClass1(AtomicInteger atomicInteger2) {
                    atomicInteger = atomicInteger2;
                }

                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    atomicInteger.incrementAndGet();
                    if (callResult.getCode() != 200) {
                        AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid failed");
                        return;
                    }
                    AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid success");
                    c7787cg.m47993h(callResult.getData());
                    AtomicInteger atomicInteger2 = atomicInteger;
                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                    AbstractC7807d.m48221b(atomicInteger2, c7787cg, context);
                }
            }

            /* renamed from: com.huawei.openalliance.ad.utils.d$7$2 */
            public class AnonymousClass2 extends OAIDServiceManager.OaidResultCallback {

                /* renamed from: a */
                final /* synthetic */ AtomicInteger f36071a;

                public AnonymousClass2(AtomicInteger atomicInteger2) {
                    atomicInteger = atomicInteger2;
                }

                @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                /* renamed from: a */
                public void mo44091a() {
                    AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquireFailed");
                    c7787cg.m47953a((String) null, (Boolean) null);
                }

                @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                /* renamed from: a */
                public void mo44092a(String str, boolean z10) {
                    AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquired");
                    c7787cg.m47953a(str, Boolean.valueOf(z10));
                    atomicInteger.incrementAndGet();
                    AtomicInteger atomicInteger2 = atomicInteger;
                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                    AbstractC7807d.m48221b(atomicInteger2, c7787cg, context);
                }
            }

            public AnonymousClass7(Context context2, C7787cg c7787cg2) {
                context = context2;
                c7787cg = c7787cg2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C6982bz.m41152b(context)) {
                    AtomicInteger atomicInteger2 = new AtomicInteger(0);
                    C7484ms.m45854a(context).m45855a(RTCMethods.QUERY_UUID, "", new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.d.7.1

                        /* renamed from: a */
                        final /* synthetic */ AtomicInteger f36069a;

                        public AnonymousClass1(AtomicInteger atomicInteger22) {
                            atomicInteger = atomicInteger22;
                        }

                        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                        public void onRemoteCallResult(String str, CallResult<String> callResult) {
                            atomicInteger.incrementAndGet();
                            if (callResult.getCode() != 200) {
                                AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid failed");
                                return;
                            }
                            AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid success");
                            c7787cg.m47993h(callResult.getData());
                            AtomicInteger atomicInteger22 = atomicInteger;
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            AbstractC7807d.m48221b(atomicInteger22, c7787cg, context);
                        }
                    }, String.class);
                    OAIDServiceManager.getInstance(context).requireOaid(new OAIDServiceManager.OaidResultCallback() { // from class: com.huawei.openalliance.ad.utils.d.7.2

                        /* renamed from: a */
                        final /* synthetic */ AtomicInteger f36071a;

                        public AnonymousClass2(AtomicInteger atomicInteger22) {
                            atomicInteger = atomicInteger22;
                        }

                        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                        /* renamed from: a */
                        public void mo44091a() {
                            AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquireFailed");
                            c7787cg.m47953a((String) null, (Boolean) null);
                        }

                        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                        /* renamed from: a */
                        public void mo44092a(String str, boolean z10) {
                            AbstractC7185ho.m43820b("AdInfoUtil", "onOaidAcquired");
                            c7787cg.m47953a(str, Boolean.valueOf(z10));
                            atomicInteger.incrementAndGet();
                            AtomicInteger atomicInteger22 = atomicInteger;
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            AbstractC7807d.m48221b(atomicInteger22, c7787cg, context);
                        }
                    });
                }
            }
        });
    }

    /* renamed from: d */
    public static boolean m48232d() {
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th2) {
            Log.e("AdInfoUtil", "isHonor6UpPhone Error:" + th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: e */
    public static String m48236e(C7787cg c7787cg, Context context) {
        String strM48289a = AbstractC7811dd.m48289a("hw_sc.product.useBrandCust");
        if (strM48289a == null) {
            strM48289a = Constants.NOT_FOUND;
        }
        c7787cg.m47913A(strM48289a);
        return strM48289a;
    }

    /* renamed from: c */
    public static boolean m48227c(Context context, int i10) {
        if (i10 != 1) {
            AbstractC7185ho.m43818a("AdInfoUtil", "ad type %s not support kit preload", Integer.valueOf(i10));
            return false;
        }
        if (!C7845x.m48587n(context) && !C7845x.m48590o(context)) {
            AbstractC7185ho.m43817a("AdInfoUtil", "kit preload only support phone or pad");
            return false;
        }
        if (!C6982bz.m41152b(context)) {
            AbstractC7185ho.m43817a("AdInfoUtil", "kit preload only support inner device");
            return false;
        }
        if (C7845x.m48593p(context)) {
            AbstractC7185ho.m43817a("AdInfoUtil", "kit preload not support eink");
            return false;
        }
        if (C7830i.m48431c(context)) {
            return true;
        }
        AbstractC7185ho.m43817a("AdInfoUtil", "hms not installed");
        return false;
    }

    /* renamed from: a */
    public static String m48207a(Context context, String str) {
        try {
            PackageInfo packageInfoM48427b = C7830i.m48427b(context, str);
            if (packageInfoM48427b == null) {
                return null;
            }
            return String.valueOf(packageInfoM48427b.versionCode);
        } catch (AndroidRuntimeException | Exception unused) {
            AbstractC7185ho.m43823c("AdInfoUtil", "getVersionCode fail");
            return null;
        }
    }

    /* renamed from: b */
    private static void m48220b(C7787cg c7787cg, Context context) {
        if (HiAd.getInstance(context).isEnableUserInfo()) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.1

                /* renamed from: a */
                final /* synthetic */ Context f36048a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36049b;

                /* renamed from: com.huawei.openalliance.ad.utils.d$1$1 */
                public class C144761 implements RemoteCallResultCallback<String> {
                    public C144761() {
                    }

                    @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != 200) {
                            AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid failed");
                        } else {
                            AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid success");
                            c7787cg.m47993h(callResult.getData());
                        }
                    }
                }

                public AnonymousClass1(Context context2, C7787cg c7787cg2) {
                    context = context2;
                    c7787cg = c7787cg2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C6982bz.m41152b(context)) {
                        if (AbstractC7807d.m48195F(context)) {
                            AbstractC7185ho.m43817a("AdInfoUtil", "within uuid request interval, skip query uuid.");
                        } else {
                            AbstractC7185ho.m43820b("AdInfoUtil", "start to request UUID");
                            C7484ms.m45854a(context).m45855a(RTCMethods.QUERY_UUID, "", new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.d.1.1
                                public C144761() {
                                }

                                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                    if (callResult.getCode() != 200) {
                                        AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid failed");
                                    } else {
                                        AbstractC7185ho.m43820b("AdInfoUtil", "requestUuid success");
                                        c7787cg.m47993h(callResult.getData());
                                    }
                                }
                            }, String.class);
                        }
                    }
                }
            });
        } else {
            AbstractC7185ho.m43820b("AdInfoUtil", "not enable userinfo, skip uuid.");
        }
    }

    /* renamed from: c */
    public static boolean m48228c(Context context, String str) {
        int iMo43290a;
        return TextUtils.isEmpty(str) || 1 == (iMo43290a = C7120fd.m43288a(context).mo43290a(str)) || iMo43290a == 0;
    }

    /* renamed from: a */
    public static String m48208a(Context context, boolean z10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48532a = C7845x.m48532a(context);
        if (!TextUtils.isEmpty(strM48532a) && !strM48532a.equalsIgnoreCase(c7787cgM47900a.m47998j())) {
            m48226c(c7787cgM47900a, context.getApplicationContext());
            return null;
        }
        if (z10 && context != null) {
            m48220b(c7787cgM47900a, context.getApplicationContext());
        }
        return c7787cgM47900a.m48000k();
    }

    /* renamed from: b */
    public static void m48221b(AtomicInteger atomicInteger, C7787cg c7787cg, Context context) {
        if (atomicInteger.get() >= 2) {
            c7787cg.m47990g(C7845x.m48532a(context));
        }
    }

    /* renamed from: b */
    public static boolean m48222b(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return (applicationInfo.flags & 1) > 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:48:0x003b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m48210a(java.lang.String r5) {
        /*
            boolean r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48165b(r5)
            java.lang.String r1 = "0"
            if (r0 == 0) goto L9
            return r1
        L9:
            int r0 = r5.hashCode()
            java.lang.String r2 = "2"
            r3 = 1
            r4 = 2
            switch(r0) {
                case 50: goto L33;
                case 51: goto L29;
                case 52: goto L1f;
                case 53: goto L15;
                default: goto L14;
            }
        L14:
            goto L3b
        L15:
            java.lang.String r0 = "5"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3b
            r5 = r4
            goto L3c
        L1f:
            java.lang.String r0 = "4"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3b
            r5 = r3
            goto L3c
        L29:
            java.lang.String r0 = "3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3b
            r5 = 0
            goto L3c
        L33:
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L3b
            r5 = 3
            goto L3c
        L3b:
            r5 = -1
        L3c:
            if (r5 == 0) goto L44
            if (r5 == r3) goto L43
            if (r5 == r4) goto L43
            return r1
        L43:
            return r2
        L44:
            java.lang.String r5 = "1"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.utils.AbstractC7807d.m48210a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static void m48211a(Context context, String str, boolean z10) {
        AbstractC7834m.m48486f(new a(context, str, z10));
    }

    /* renamed from: a */
    public static void m48212a(Context context, List<String> list) {
        String strM48156a = AbstractC7806cz.m48156a(list, ",");
        InterfaceC7139fw interfaceC7139fwM43174a = C7114ey.m43174a(context);
        if (AbstractC7760bg.m47767a(list)) {
            interfaceC7139fwM43174a.mo43179a("");
        } else {
            interfaceC7139fwM43174a.mo43179a(strM48156a);
        }
    }

    /* renamed from: a */
    public static boolean m48214a(Context context, IAd iAd) {
        if (iAd == null) {
            return false;
        }
        return AbstractC7741ao.m47549a(context, iAd);
    }
}
