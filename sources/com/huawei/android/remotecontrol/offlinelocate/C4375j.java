package com.huawei.android.remotecontrol.offlinelocate;

import android.content.Context;
import android.text.TextUtils;
import az.C1081e;
import bf.C1175a;
import com.baidu.location.p065a.C1529a;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.android.remotecontrol.http.PhoneFinderServer;
import com.huawei.android.remotecontrol.offlinelocate.bean.TrustCircleInfo;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.FindNetworkEngine;
import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;
import com.huawei.hms.findnetwork.comm.request.option.OfflineBroadcastParam;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkStatusResult;
import com.huawei.secure.android.common.util.SafeBase64;
import eg.AbstractC9478g;
import fk.C9721b;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0227m;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p521og.C11877j;
import p575qe.C12347f;
import p616rk.C12515a;
import p709vj.C13452e;
import p756wy.C13666a;
import p792xy.C13894a;
import p809yg.C13981a;
import p846zj.C14306d;
import pg.AbstractC12139d;
import sg.C12797b;

/* renamed from: com.huawei.android.remotecontrol.offlinelocate.j */
/* loaded from: classes4.dex */
public class C4375j {

    /* renamed from: a */
    public static final ReentrantLock f20004a = new ReentrantLock();

    /* renamed from: com.huawei.android.remotecontrol.offlinelocate.j$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Context f20005a;

        /* renamed from: b */
        public final /* synthetic */ boolean f20006b;

        /* renamed from: c */
        public final /* synthetic */ Consumer f20007c;

        public a(Context context, boolean z10, Consumer consumer) {
            this.f20005a = context;
            this.f20006b = z10;
            this.f20007c = consumer;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            new PhoneFinderTrustCircleManager(this.f20005a).checkTrustCircleStatus(this.f20006b, this.f20007c);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.offlinelocate.j$b */
    public class b extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Context f20008a;

        /* renamed from: b */
        public final /* synthetic */ Consumer f20009b;

        /* renamed from: c */
        public final /* synthetic */ String f20010c;

        public b(Context context, Consumer consumer, String str) {
            this.f20008a = context;
            this.f20009b = consumer;
            this.f20010c = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            boolean zM26204o;
            C4375j.f20004a.lock();
            try {
                try {
                } catch (Exception e10) {
                    C13981a.m83988e("OfflineLocateUtil", "getRootKeyAndReport exception: " + e10.getMessage());
                    Consumer consumer = this.f20009b;
                    if (consumer != null) {
                        consumer.accept(Boolean.FALSE);
                    }
                }
                if (C11877j.m71261e0(this.f20008a)) {
                    C13981a.m83989i("OfflineLocateUtil", "getRootKeyAndReport readRootPkStatus true");
                    Consumer consumer2 = this.f20009b;
                    if (consumer2 != null) {
                        consumer2.accept(Boolean.TRUE);
                    }
                } else if (C0209d.m1277l1()) {
                    Consumer consumer3 = this.f20009b;
                    if (consumer3 != null) {
                        consumer3.accept(Boolean.FALSE);
                    }
                } else {
                    Context context = this.f20008a;
                    byte[] bArrM26432h = C4376k.m26432h(context, AbstractC12139d.m72766e(context).getUserID());
                    if (bArrM26432h.length != 0) {
                        C11877j.m71289n1(this.f20008a, 0L);
                        try {
                            zM26204o = new PhoneFinderServer(this.f20008a).m26204o(C4375j.m26410l(bArrM26432h), this.f20010c);
                        } catch (C9721b e11) {
                            C13981a.m83988e("OfflineLocateUtil", "openOfflineLocateSwitch exc:" + e11.getMessage());
                            zM26204o = false;
                        }
                        if (zM26204o) {
                            C11877j.m71286m1(this.f20008a, true);
                            C11877j.m71262e1(this.f20008a, 1);
                            C4375j.m26397K(this.f20008a);
                        }
                        Consumer consumer4 = this.f20009b;
                        if (consumer4 != null) {
                            consumer4.accept(Boolean.valueOf(zM26204o));
                        }
                        UBAAnalyze.m29977f0("PVP", "mecloud_findmyphone_click_offline_locate", "1", "19", "1", "2", C13452e.m80781L().m80790C());
                        return;
                    }
                    Consumer consumer5 = this.f20009b;
                    if (consumer5 != null) {
                        consumer5.accept(Boolean.FALSE);
                    }
                    new C12797b().m76784j(this.f20008a, "OfflineLocateUtil", "001_3006", "get asset private key error", "001_3006", "01035", "", "offlinePrivateKey", true);
                    UBAAnalyze.m29977f0("PVP", "mecloud_findmyphone_click_offline_locate", "1", "19", "1", "2", C13452e.m80781L().m80790C());
                    C13981a.m83988e("OfflineLocateUtil", "rootKey ie empty:");
                }
            } finally {
                C13981a.m83989i("OfflineLocateUtil", "getRootKeyAndReport unlock");
                C4375j.f20004a.unlock();
            }
        }
    }

    /* renamed from: A */
    public static boolean m26387A() {
        if (C14306d.m85207h()) {
            return true;
        }
        C13981a.m83989i("OfflineLocateUtil", "country not support");
        return false;
    }

    /* renamed from: B */
    public static /* synthetic */ void m26388B(Consumer consumer, FindNetworkStatusResult findNetworkStatusResult) {
        String version = findNetworkStatusResult.getVersion();
        C13981a.m83989i("OfflineLocateUtil", "nearby version is: " + version);
        consumer.accept(Boolean.valueOf(m26398L(version) >= m26398L("6.1.0.301")));
    }

    /* renamed from: C */
    public static /* synthetic */ void m26389C(Consumer consumer, Exception exc) {
        consumer.accept(Boolean.FALSE);
        C13981a.m83988e("OfflineLocateUtil", "get nearby version exception:" + exc.getMessage());
    }

    /* renamed from: D */
    public static /* synthetic */ void m26390D(Boolean bool) {
        C13981a.m83989i("OfflineLocateUtil", "checkRootKeyAndReport response: " + bool);
    }

    /* renamed from: E */
    public static /* synthetic */ void m26391E(Context context, boolean z10, TrustCircleInfo trustCircleInfo) {
        boolean zIsJoinTrustCircle = trustCircleInfo.isJoinTrustCircle();
        C13981a.m83989i("OfflineLocateUtil", "initRootPk checkTrustCircleStatus:" + zIsJoinTrustCircle);
        C11877j.m71292o1(context, System.currentTimeMillis());
        if (zIsJoinTrustCircle) {
            m26413o(trustCircleInfo.getMkVersion(), z10);
        }
    }

    /* renamed from: F */
    public static /* synthetic */ void m26392F(Consumer consumer, Context context, boolean z10, C12797b c12797b, String str, FindNetworkResult findNetworkResult) {
        C13981a.m83989i("OfflineLocateUtil", "sendFindNetworkStatusToNearby success:" + findNetworkResult.getRespCode() + findNetworkResult.getDescription());
        boolean z11 = findNetworkResult.getRespCode() == 0;
        if (consumer != null) {
            consumer.accept(Boolean.valueOf(z11));
        }
        if (z11) {
            C11877j.m71239V0(context, z10);
        }
        String str2 = z11 ? "success" : "fail";
        c12797b.m76785k(context, "OfflineLocateUtil", "", "enable success", str2 + "_" + findNetworkResult.getRespCode() + findNetworkResult.getDescription(), "notify_nearby", "", str, true, null);
        UBAAnalyze.m29946G("CKP", str, "enable success", str2, C13452e.m80781L().m80790C());
    }

    /* renamed from: G */
    public static /* synthetic */ void m26393G(Consumer consumer, C12797b c12797b, Context context, String str, Exception exc) {
        C13981a.m83988e("OfflineLocateUtil", "sendFindNetworkStatusToNearby exception:" + exc.getMessage());
        if (consumer != null) {
            consumer.accept(Boolean.FALSE);
        }
        c12797b.m76785k(context, "OfflineLocateUtil", "", "enable fail", "fail" + exc.getMessage(), "notify_nearby", "", str, true, null);
        UBAAnalyze.m29946G("CKP", str, "enable fail", "fail", C13452e.m80781L().m80790C());
    }

    /* renamed from: H */
    public static /* synthetic */ void m26394H(C12797b c12797b, Context context, Void r13) {
        C13981a.m83989i("OfflineLocateUtil", "setPubKeysToNearby setPublicKeys success");
        c12797b.m76784j(context, "OfflineLocateUtil", "", "setPubKeysToNearby success", "", "call_nearby_api_result", "", "call_nearby_api_result", true);
        C11877j.m71289n1(context, System.currentTimeMillis());
        C11877j.m71286m1(context, true);
    }

    /* renamed from: I */
    public static /* synthetic */ void m26395I(C12797b c12797b, Context context, Exception exc) {
        C13981a.m83989i("OfflineLocateUtil", "setPubKeysToNearby setPublicKeys fail");
        c12797b.m76784j(context, "OfflineLocateUtil", "", "setPubKeysToNearby addOnFailureListener", "", "call_nearby_api_result", "", "call_nearby_api_result", true);
        C11877j.m71289n1(context, 0L);
    }

    /* renamed from: J */
    public static void m26396J(final Context context, final boolean z10, final Consumer<Boolean> consumer) {
        C13981a.m83989i("OfflineLocateUtil", "sendFindNetworkStatusToNearby:" + z10);
        final C12797b c12797b = new C12797b();
        final String str = z10 ? "mecloud_findmyphone_notify_nearby_open" : "mecloud_findmyphone_notify_nearby_close";
        if (z10 && !C1175a.m7389k(context)) {
            C13981a.m83990w("OfflineLocateUtil", "enableFindNetwork fail：phone finder closed");
            if (consumer != null) {
                consumer.accept(Boolean.FALSE);
            }
            c12797b.m76785k(context, "OfflineLocateUtil", "0", "enableFindNetwork fail：phone finder closed", "fail", "notify_nearby", "", str, true, null);
            return;
        }
        try {
            Task<FindNetworkResult> taskEnableFindNetwork = FindNetwork.getFindNetworkEngine(context).enableFindNetwork(z10);
            taskEnableFindNetwork.addOnSuccessListener(new InterfaceC8939g() { // from class: com.huawei.android.remotecontrol.offlinelocate.b
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    C4375j.m26392F(consumer, context, z10, c12797b, str, (FindNetworkResult) obj);
                }
            });
            taskEnableFindNetwork.addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.android.remotecontrol.offlinelocate.c
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    C4375j.m26393G(consumer, c12797b, context, str, exc);
                }
            });
        } catch (Exception e10) {
            C13981a.m83988e("OfflineLocateUtil", "sendFindNetworkStatusToNearby :" + e10.getMessage());
            if (consumer != null) {
                consumer.accept(Boolean.FALSE);
            }
        }
    }

    /* renamed from: K */
    public static void m26397K(final Context context) {
        C13981a.m83989i("OfflineLocateUtil", "setPubKeysToNearby start");
        if (context == null) {
            C13981a.m83988e("OfflineLocateUtil", "setPubKeysToNearby context is null");
            return;
        }
        List<OfflineBroadcastParam> listM26418t = m26418t(context);
        try {
            FindNetworkEngine findNetworkEngine = FindNetwork.getFindNetworkEngine(context);
            String strM80942m = C13452e.m80781L().m80942m();
            if (strM80942m == null) {
                strM80942m = "";
            }
            if (listM26418t.size() <= 0) {
                C13981a.m83988e("OfflineLocateUtil", "setPubKeysToNearby publicKeyList is empty");
                return;
            }
            final C12797b c12797b = new C12797b();
            try {
                findNetworkEngine.setPublicKeys(listM26418t, strM80942m).addOnSuccessListener(new InterfaceC8939g() { // from class: com.huawei.android.remotecontrol.offlinelocate.e
                    @Override // p208cq.InterfaceC8939g
                    public final void onSuccess(Object obj) {
                        C4375j.m26394H(c12797b, context, (Void) obj);
                    }
                }).addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.android.remotecontrol.offlinelocate.f
                    @Override // p208cq.InterfaceC8938f
                    public final void onFailure(Exception exc) {
                        C4375j.m26395I(c12797b, context, exc);
                    }
                });
            } catch (FindNetworkException e10) {
                C13981a.m83988e("OfflineLocateUtil", "setPubKeysToNearby exception, e: " + e10.getMessage());
                c12797b.m76784j(context, "OfflineLocateUtil", "", "setPubKeysToNearby fail", "", "call_nearby_api_result", "", "call_nearby_api_result", true);
                C11877j.m71289n1(context, 0L);
            }
            C13981a.m83987d("OfflineLocateUtil", "setPubKeysToNearby end");
        } catch (Exception unused) {
            C13981a.m83988e("OfflineLocateUtil", "setPubKeysToNearby exception");
        }
    }

    /* renamed from: L */
    public static long m26398L(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str.replaceAll("\\.", ""));
        } catch (NumberFormatException e10) {
            C13981a.m83988e("OfflineLocateUtil", "versionNameToCode exception:" + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: j */
    public static byte[] m26408j(String str, String str2) {
        int iM83298c;
        byte[] bArr;
        byte[] bArr2 = new byte[2];
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            C1081e c1081e = new C1081e(C11476b.m68628j(str2));
            C13894a c13894a = new C13894a(new C13666a());
            c13894a.m83299d(c1081e);
            c13894a.m83301h(bytes, 0, bytes.length);
            iM83298c = c13894a.m83298c();
            bArr = new byte[iM83298c];
            c13894a.m83296a(bArr, 0);
        } catch (Exception e10) {
            C13981a.m83988e("OfflineLocateUtil", "aesCmac error:" + e10.getMessage());
        }
        if (iM83298c < 2) {
            C13981a.m83988e("OfflineLocateUtil", "aesCmac error: result less than 2 bytes");
            return bArr2;
        }
        bArr2[0] = bArr[0];
        bArr2[1] = bArr[1];
        return bArr2;
    }

    /* renamed from: k */
    public static byte[] m26409k(String str) {
        return SafeBase64.decode(str, 2);
    }

    /* renamed from: l */
    public static String m26410l(byte[] bArr) {
        return SafeBase64.encodeToString(bArr, 2);
    }

    /* renamed from: m */
    public static String m26411m(byte[] bArr) {
        if (bArr.length <= 0) {
            return "";
        }
        try {
            return new String(bArr, StandardCharsets.UTF_8);
        } catch (Exception e10) {
            C13981a.m83988e("OfflineLocateUtil", "byteToStr error:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: n */
    public static void m26412n(Context context, final Consumer<Boolean> consumer) {
        C13981a.m83989i("OfflineLocateUtil", "check nearby version");
        try {
            Task<FindNetworkStatusResult> taskQueryFindNetworkStatus = FindNetwork.getFindNetworkEngine(context).queryFindNetworkStatus();
            taskQueryFindNetworkStatus.addOnSuccessListener(new InterfaceC8939g() { // from class: com.huawei.android.remotecontrol.offlinelocate.g
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    C4375j.m26388B(consumer, (FindNetworkStatusResult) obj);
                }
            });
            taskQueryFindNetworkStatus.addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.android.remotecontrol.offlinelocate.h
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    C4375j.m26389C(consumer, exc);
                }
            });
        } catch (Exception e10) {
            C13981a.m83988e("OfflineLocateUtil", "checkNearbyVersion :" + e10.getMessage());
            if (consumer != null) {
                consumer.accept(Boolean.FALSE);
            }
        }
    }

    /* renamed from: o */
    public static void m26413o(int i10, boolean z10) {
        C13981a.m83989i("OfflineLocateUtil", "checkRootKeyAndReport");
        Context contextM74301m = C12347f.m74285n().m74301m();
        boolean zM26434j = C4376k.m26434j();
        boolean zM26424z = m26424z(contextM74301m);
        C13981a.m83989i("OfflineLocateUtil", "checkRootKeyAndReport huksHasKey: " + zM26434j + ", isOfflineLocateSwitchOpen: " + zM26424z);
        if (zM26434j && zM26424z) {
            m26397K(contextM74301m);
            return;
        }
        if (zM26434j && z10 && C11877j.m71261e0(contextM74301m)) {
            m26397K(contextM74301m);
            return;
        }
        if (!zM26434j) {
            C13981a.m83989i("OfflineLocateUtil", "checkRootKeyAndReport huksHasKey false, reset report status");
            C11877j.m71286m1(contextM74301m, false);
        }
        m26419u(contextM74301m, String.valueOf(i10), new Consumer() { // from class: com.huawei.android.remotecontrol.offlinelocate.i
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C4375j.m26390D((Boolean) obj);
            }
        });
    }

    /* renamed from: p */
    public static void m26414p(Context context, boolean z10, Consumer<TrustCircleInfo> consumer) {
        C12515a.m75110o().m75175e(new a(context, z10, consumer), true);
    }

    /* renamed from: q */
    public static byte[] m26415q(byte[] bArr, String str) {
        String upperCase = C11476b.m68619a(C0227m.m1594g(bArr)).toUpperCase(Locale.ENGLISH);
        if (!C4633d0.m28404a(upperCase)) {
            return m26408j(upperCase, str);
        }
        C13981a.m83988e("OfflineLocateUtil", "publicKeyHash is null");
        return new byte[0];
    }

    /* renamed from: r */
    public static String m26416r(long j10) {
        return new SimpleDateFormat(C1529a.f6579e).format(new Date(j10));
    }

    /* renamed from: s */
    public static String m26417s() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("com.huawei.security.HwKeystoreManager");
            return (String) cls.getMethod("getHuksServiceVersion", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), new Object[0]);
        } catch (ClassNotFoundException e10) {
            C13981a.m83988e("OfflineLocateUtil", "ClassNotFoundException error: " + e10.getMessage());
            return "";
        } catch (IllegalAccessException e11) {
            C13981a.m83988e("OfflineLocateUtil", "IllegalAccessException error: " + e11.getMessage());
            return "";
        } catch (NoSuchMethodException e12) {
            C13981a.m83988e("OfflineLocateUtil", "NoSuchMethodException error: " + e12.getMessage());
            return "";
        } catch (InvocationTargetException e13) {
            C13981a.m83988e("OfflineLocateUtil", "InvocationTargetException error: " + e13.getMessage());
            return "";
        }
    }

    /* renamed from: t */
    public static List<OfflineBroadcastParam> m26418t(Context context) {
        ArrayList arrayList = new ArrayList();
        if (C0209d.m1277l1()) {
            return arrayList;
        }
        String strM71238V = C11877j.m71238V(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM80950o = C13452e.m80781L().m80950o();
        if (C4633d0.m28404a(strM71238V) || C4633d0.m28404a(strM80950o)) {
            C13981a.m83988e("OfflineLocateUtil", "cMacKey or deviceId is null");
            return arrayList;
        }
        for (int i10 = 0; i10 < 14; i10++) {
            OfflineBroadcastParam offlineBroadcastParam = new OfflineBroadcastParam();
            String strM26416r = m26416r((i10 * 86400000) + jCurrentTimeMillis);
            offlineBroadcastParam.setPubKeyDate(strM26416r);
            byte[] bArrM26431g = C4376k.m26431g(context, strM80950o + strM26416r, "FindPhoneMasterKey");
            if (bArrM26431g.length <= 0) {
                C13981a.m83988e("OfflineLocateUtil", "generatePublicKey is empty");
                new C12797b().m76784j(context, "OfflineLocateUtil", "", "setPubKeysToNearby generatePublicKey failed", "", "call_asset_api_result", "", "call_asset_api_result", true);
            } else {
                offlineBroadcastParam.setPublicKey(bArrM26431g);
                byte[] bArrM26415q = m26415q(bArrM26431g, strM71238V);
                if (bArrM26415q.length <= 0) {
                    C13981a.m83988e("OfflineLocateUtil", "getCmacSign is empty");
                } else {
                    offlineBroadcastParam.setMac(bArrM26415q);
                    new C12797b().m76784j(context, "OfflineLocateUtil", "", "OfflineBroadcastParam publicKey:" + C11476b.m68619a(C0227m.m1594g(bArrM26431g)).toUpperCase(Locale.ENGLISH) + ",date:" + strM26416r + ",cmacSign:" + Arrays.toString(bArrM26415q), "", "call_asset_api_result", "", "call_asset_api_result", true);
                    arrayList.add(offlineBroadcastParam);
                }
            }
        }
        C13981a.m83989i("OfflineLocateUtil", "getPublicKeyList list: " + arrayList);
        return arrayList;
    }

    /* renamed from: u */
    public static void m26419u(Context context, String str, Consumer<Boolean> consumer) {
        C13981a.m83989i("OfflineLocateUtil", "getRootKeyAndReport");
        C12515a.m75110o().m75175e(new b(context, consumer, str), true);
    }

    /* renamed from: v */
    public static void m26420v() {
        C13981a.m83989i("OfflineLocateUtil", "check brand and notify nearby");
        Context contextM74301m = C12347f.m74285n().m74301m();
        if (!AbstractC12139d.m72769h(contextM74301m)) {
            C13981a.m83990w("OfflineLocateUtil", "country not support");
            return;
        }
        boolean zM1285n1 = C0209d.m1285n1();
        C11877j.m71265f1(contextM74301m, zM1285n1);
        C11877j.m71211H0(contextM74301m, System.currentTimeMillis());
        m26396J(contextM74301m, zM1285n1, null);
        if (zM1285n1) {
            AncillaryDeviceManager.m26080y().m26082B();
        }
    }

    /* renamed from: w */
    public static void m26421w(final boolean z10) {
        C13981a.m83989i("OfflineLocateUtil", "initRootPk isNeedRefreshPublicKey:" + z10);
        final Context contextM74301m = C12347f.m74285n().m74301m();
        try {
            if (!C0209d.m1285n1()) {
                C13981a.m83988e("OfflineLocateUtil", "initRootPk not HuaWei product");
                return;
            }
            if (!m26387A()) {
                C13981a.m83990w("OfflineLocateUtil", "initRootPk no china");
            } else if (z10 || !C11877j.m71261e0(contextM74301m) || C11877j.m71264f0(contextM74301m) == 0) {
                m26414p(contextM74301m, true, new Consumer() { // from class: com.huawei.android.remotecontrol.offlinelocate.d
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C4375j.m26391E(contextM74301m, z10, (TrustCircleInfo) obj);
                    }
                });
            } else {
                C13981a.m83990w("OfflineLocateUtil", "initRootPk readRootPkStatus true or time");
            }
        } catch (Exception e10) {
            C13981a.m83988e("OfflineLocateUtil", "initRootPk Exception: " + e10.getMessage());
        }
    }

    /* renamed from: x */
    public static boolean m26422x(Context context) {
        if (context == null) {
            return false;
        }
        return C11877j.m71226P(context);
    }

    /* renamed from: y */
    public static boolean m26423y() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String strM26417s = m26417s();
        if (m26398L(strM26417s) >= m26398L("1.0.6")) {
            return true;
        }
        C13981a.m83989i("OfflineLocateUtil", "huks not support " + strM26417s);
        return false;
    }

    /* renamed from: z */
    public static boolean m26424z(Context context) {
        return context != null && C11877j.m71244Y(context) == 1;
    }
}
