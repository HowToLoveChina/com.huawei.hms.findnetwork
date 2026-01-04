package com.huawei.android.hicloud.complexutil;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.uiextend.HiCloudItemView;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.android.hicloud.sync.bean.StatusInfo;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.drive.model.Cipher;
import com.huawei.hicloud.base.drive.model.KeyChain;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import fk.C9722c;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import je.C10812z;
import md.C11440c;
import nc.C11662a;
import org.apache.http.conn.ConnectTimeoutException;
import p012ab.C0087b;
import p015ak.C0206b0;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0221j;
import p015ak.C0224k0;
import p020ap.C1006a;
import p020ap.C1007b;
import p020ap.C1009d;
import p035bk.C1249b;
import p037bp.C1270a;
import p232dp.InterfaceC9285d;
import p283fa.C9679b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p664u0.C13108a;
import p684un.C13226e;
import p709vj.C13452e;
import p783xp.C13843a;
import sc.C12776i;
import tc.C13007b;
import za.C14165b;

/* loaded from: classes3.dex */
public class CloudSyncUtil {

    /* renamed from: a */
    public static final Map<String, Integer> f12070a = new HashMap(10);

    /* renamed from: b */
    public static final Map<String, Boolean> f12071b = new HashMap(10);

    /* renamed from: c */
    public static final Map<String, Boolean> f12072c = new HashMap(10);

    /* renamed from: d */
    public static final Map<String, String> f12073d = new HashMap(10);

    /* renamed from: e */
    public static long f12074e = -1;

    /* renamed from: f */
    public static long f12075f = -1;

    /* renamed from: g */
    public static long f12076g = -1;

    /* renamed from: h */
    public static int f12077h = 0;

    /* renamed from: i */
    public static int f12078i = 0;

    /* renamed from: j */
    public static final Map<String, Integer> f12079j = new HashMap(10);

    /* renamed from: k */
    public static final String[] f12080k = {"00:00:00", "05:00:00", "05:30:00", "06:00:00", "06:30:00", "07:00:00", "07:30:00", "23:59:00"};

    /* renamed from: l */
    public static final String[] f12081l = {"00:00:59", "05:00:59", "05:30:59", "06:00:59", "06:30:59", "07:00:59", "07:30:59", "23:59:59"};

    /* renamed from: m */
    public static final Map<String, String> f12082m = Collections.unmodifiableMap(new C2779a());

    /* renamed from: n */
    public static volatile boolean f12083n = false;

    public static class ClearSyncTempFileTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f12084a;

        public ClearSyncTempFileTask(Context context) {
            this.f12084a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                String strM63452a = C10279b.m63452a(C10278a.m63442h(this.f12084a.getFilesDir() + "/sync"));
                if (C10278a.m63442h(strM63452a).exists()) {
                    C11839m.m70688i("CloudSyncUtil", "delete cloudSyncTempDir result = " + C0221j.m1499i(strM63452a));
                }
                String strM63452a2 = C10279b.m63452a(C10278a.m63442h(this.f12084a.getFilesDir() + "/wifi"));
                if (C10278a.m63442h(strM63452a2).exists()) {
                    C11839m.m70688i("CloudSyncUtil", "delete syncWifiTempDir result = " + C0221j.m1499i(strM63452a2));
                }
                CloudSyncUtil.m16051u(this.f12084a);
                String strM1512v = C0221j.m1512v();
                String strM1513w = C0221j.m1513w();
                if (strM1512v == null) {
                    C0221j.m1509s(this.f12084a);
                    strM1512v = C0221j.m1512v();
                    strM1513w = C0221j.m1513w();
                }
                String strM1192N = C0209d.m1192N();
                String lowerCase = C0209d.m1269j1() ? TextUtils.isEmpty(strM1192N) ? "honor" : strM1192N.toLowerCase(Locale.ENGLISH) : "huawei";
                if (strM1512v != null) {
                    String strM63452a3 = C10279b.m63452a(C10278a.m63442h(strM1512v + File.separator + lowerCase + "/HwCloud/sysdata"));
                    C0221j.m1494d(strM63452a3, "notepad");
                    C0221j.m1494d(strM63452a3, "phonemanager");
                    C0221j.m1494d(strM63452a3, "recording");
                    C11839m.m70688i("CloudSyncUtil", "delete locationPcardFile end");
                }
                if (strM1513w != null) {
                    String strM63452a4 = C10279b.m63452a(C10278a.m63442h(strM1513w + File.separator + lowerCase + "/HwCloud/sysdata"));
                    C0221j.m1494d(strM63452a4, "notepad");
                    C0221j.m1494d(strM63452a4, "phonemanager");
                    C0221j.m1494d(strM63452a4, "recording");
                    C11839m.m70688i("CloudSyncUtil", "delete locationSdcardFile end");
                }
            } catch (Exception e10) {
                C11839m.m70687e("CloudSyncUtil", "clearSyncTempFile error : " + e10.getMessage());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.EXIT;
        }
    }

    /* renamed from: com.huawei.android.hicloud.complexutil.CloudSyncUtil$a */
    public class C2779a extends HashMap<String, String> {
        public C2779a() {
            put("1000", "Contact");
            put("1001", "Notepad");
            put("1002", "Calendar");
            put("1003", "Atlas");
            put(FaqConstants.CHANNEL_HICARE, "Wlan");
            put("1005", "Browser");
            put("1006", "HuaweiMap");
            put("1008", "AIReader");
            put("1009", "HuaweiNote");
        }
    }

    /* renamed from: A */
    public static int m15939A(Context context) {
        if (context == null) {
            C11839m.m70687e("CloudSyncUtil", "getBatteryLevel context is null");
            return 25;
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return 25;
        }
        try {
            return intentRegisterReceiver.getIntExtra(FaqConstants.FAQ_LEVEL, 25);
        } catch (Exception e10) {
            C11839m.m70689w("CloudSyncUtil", "getBatteryLevel level err " + e10.getMessage());
            return 25;
        }
    }

    /* renamed from: A0 */
    public static boolean m15940A0(Context context, String str) {
        boolean z10;
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if ("autorecordingkey".equals(str)) {
            z10 = sharedPreferencesM1382b.getBoolean("recording_need_wifi_condition", true);
            C11839m.m70686d("CloudSyncUtil", "isSatifyWifiAutoConstruction recording, isNeedWifi =" + z10);
        } else {
            z10 = false;
        }
        return (z10 && C0209d.m1254f2(context)) || (!z10 && C0209d.m1333z1(context));
    }

    /* renamed from: B */
    public static boolean m15941B(Context context) {
        if (context == null) {
            C11839m.m70687e("CloudSyncUtil", "getChargingStatus context is null");
            return false;
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return false;
        }
        try {
            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        } catch (Exception e10) {
            C11839m.m70689w("CloudSyncUtil", "getChargingStatus status err " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: B0 */
    public static boolean m15942B0(String str) {
        Map<String, Integer> map = f12070a;
        int iIntValue = map.containsKey(str) ? map.get(str).intValue() : 0;
        C11839m.m70688i("CloudSyncUtil", "isSendMessageDelayed: syncType = " + str + ", count = " + iIntValue);
        if (iIntValue >= 2) {
            return false;
        }
        m16026l1(str, iIntValue + 1);
        return true;
    }

    /* renamed from: C */
    public static int m15943C(Context context) {
        int i10 = 0;
        if (context == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        if (c10028cM62183d0.m62395t1("funcfg_call_log_up")) {
            arrayList.add(Boolean.valueOf(c10028cM62183d0.m62388s("autocallloglistkey")));
        }
        if (c10028cM62183d0.m62395t1("funcfg_messaging_up")) {
            arrayList.add(Boolean.valueOf(C10028c.m62182c0().m62388s("autosmslistkey")));
        }
        if (c10028cM62183d0.m62395t1("funcfg_recordings_up")) {
            arrayList.add(Boolean.valueOf(C10028c.m62182c0().m62388s("autorecordingkey")));
        }
        if (c10028cM62183d0.m62395t1("funcfg_blocked_up")) {
            arrayList.add(Boolean.valueOf(C10028c.m62182c0().m62388s("autophonemanagerkey")));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((Boolean) it.next()).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: C0 */
    public static boolean m15944C0(Context context) {
        return context != null && C11829c.m70546T0(context) && C10028c.m62182c0().m62395t1("funcfg_call_log_up");
    }

    /* renamed from: D */
    public static long m15945D() {
        return f12074e;
    }

    /* renamed from: D0 */
    public static boolean m15946D0(Context context) {
        return (context == null || C0209d.m1258g2(context) || !C10028c.m62182c0().m62395t1("funcfg_blocked_up")) ? false : true;
    }

    /* renamed from: E */
    public static long m15947E() {
        return f12075f;
    }

    /* renamed from: E0 */
    public static boolean m15948E0(Context context) {
        return context != null && C10028c.m62182c0().m62395t1("funcfg_recordings_up");
    }

    /* renamed from: F */
    public static long m15949F() {
        return f12076g;
    }

    /* renamed from: F0 */
    public static boolean m15950F0(Context context) {
        return context != null && C11829c.m70523I0(context) && C10028c.m62182c0().m62395t1("funcfg_messaging_up");
    }

    /* renamed from: G */
    public static Map<String, Boolean> m15951G() {
        return f12072c;
    }

    /* renamed from: G0 */
    public static boolean m15952G0() {
        long jM15947E = m15947E();
        long jM15949F = m15949F();
        if (jM15949F <= 0 || jM15949F < jM15947E) {
            return false;
        }
        C11839m.m70688i("CloudSyncUtil", "space is already full");
        return true;
    }

    /* renamed from: H */
    public static String m15953H(Context context) {
        StorageManager storageManager;
        StorageVolume[] storageVolumeArrM7483f;
        if (context == null || (storageManager = (StorageManager) context.getSystemService("storage")) == null || (storageVolumeArrM7483f = C1249b.m7483f(storageManager)) == null) {
            return "";
        }
        for (StorageVolume storageVolume : storageVolumeArrM7483f) {
            if (storageVolume.isPrimary() && storageVolume.isEmulated()) {
                return C1249b.m7481d(storageVolume);
            }
        }
        return "";
    }

    /* renamed from: H0 */
    public static boolean m15954H0(Context context) {
        if (!C10028c.m62182c0().m62221H1()) {
            C11839m.m70688i("CloudSyncUtil", "disagree hicloud terms");
            return false;
        }
        try {
            String strM83058J = C13843a.m83058J(context);
            int i10 = context.getPackageManager().getApplicationInfo(strM83058J, 128).metaData.getInt("support_broadcast_sync", 0);
            C11839m.m70688i("CloudSyncUtil", "get metaData, packageName: " + strM83058J + ", broadcast_new: " + i10);
            return i10 == 1;
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncUtil", "get recording metaData error: " + e10.toString());
            return false;
        }
    }

    /* renamed from: I */
    public static boolean m15955I(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b;
        if (context == null || str == null || (sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0)) == null) {
            return false;
        }
        return sharedPreferencesM1382b.getBoolean(str + "is_open_switch", false);
    }

    /* renamed from: I0 */
    public static boolean m15956I0(String str) {
        str.hashCode();
        return str.equals("addressbook") || str.equals("atlas");
    }

    /* renamed from: J */
    public static Map<String, List<String>> m15957J(List<SyncData> list) {
        List<UnstructData> fileList;
        HashMap map = new HashMap();
        for (SyncData syncData : list) {
            if (syncData != null && (fileList = syncData.getFileList()) != null && fileList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<UnstructData> it = fileList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getName());
                }
                map.put(syncData.getGuid(), arrayList);
            }
        }
        return map;
    }

    /* renamed from: J0 */
    public static boolean m15958J0(Context context, String str) {
        boolean z10 = false;
        if (context == null || TextUtils.isEmpty(str)) {
            C11839m.m70689w("CloudSyncUtil", "isSupportModifyFullZip param empty");
            return false;
        }
        try {
            z10 = context.getPackageManager().getApplicationInfo(str, 128).metaData.getBoolean("cloudSync.SUPPORT_FULL_ZIP");
            C11839m.m70688i("CloudSyncUtil", "isSupportModifyFullZip, packageName: " + str + ", dataType = " + z10);
            return z10;
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncUtil", "isSupportModifyFullZip error, " + e10.toString());
            return z10;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* renamed from: K */
    public static String m15959K(Context context, String str, String str2) throws Throwable {
        String strM83054F;
        C11839m.m70688i("CloudSyncUtil", "getPackageNamesForSyncType: syncType = " + str);
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1376863011:
                if (str.equals("addressbook")) {
                    c10 = 0;
                    break;
                }
                break;
            case -178324674:
                if (str.equals("calendar")) {
                    c10 = 1;
                    break;
                }
                break;
            case 93144203:
                if (str.equals("atlas")) {
                    c10 = 2;
                    break;
                }
                break;
            case 150940456:
                if (str.equals("browser")) {
                    c10 = 3;
                    break;
                }
                break;
            case 2129240929:
                if (str.equals("notepad")) {
                    c10 = 4;
                    break;
                }
                break;
        }
        strM83054F = "";
        switch (c10) {
            case 0:
                strM83054F = "com.huawei.contacts.sync";
                break;
            case 1:
                strM83054F = "com.android.providers.calendar";
                break;
            case 2:
                strM83054F = C13843a.m83054F(context);
                break;
            case 3:
                strM83054F = C13843a.m83078b0(context, "com.android.browser") ? "com.android.browser" : "";
                String strM83092n = C13843a.m83092n(context);
                if (strM83092n != null) {
                    strM83054F = strM83092n;
                    break;
                }
                break;
            case 4:
                strM83054F = C13843a.m83050B(context);
                break;
            default:
                SyncConfigService serviceById = new SyncConfigOperator().getServiceById(str);
                if (serviceById != null && serviceById.getApplications().length > 0) {
                    strM83054F = C0209d.m1300r0(context, serviceById.getApplications());
                    break;
                }
                break;
        }
        C11839m.m70688i("CloudSyncUtil", "getPackageNamesForSyncType: syncType = " + str + ", packageName = " + strM83054F);
        return strM83054F;
    }

    /* renamed from: K0 */
    public static boolean m15960K0() {
        return C10028c.m62182c0().m62395t1("funcfg_contacts") || C10028c.m62182c0().m62395t1("funcfg_calendar") || C10028c.m62182c0().m62390s1() || C10028c.m62182c0().m62395t1("funcfg_wlan") || C10028c.m62182c0().m62395t1("funcfg_browser") || C10028c.m62182c0().m62315d1() || C10028c.m62182c0().m62395t1("funcfg_notes");
    }

    /* renamed from: L */
    public static EnumC12999a m15961L(String str) {
        boolean z10 = C13007b.m78205Y(C0213f.m1377a()).m78249a0() || C13007b.m78205Y(C0213f.m1377a()).m78255d0();
        return TextUtils.isEmpty(str) ? z10 ? EnumC12999a.CLOUD_SYNC_QUIC : EnumC12999a.CLOUD_SYNC : str.startsWith("addressbook") ? z10 ? EnumC12999a.CLOUDSYNC_UNSTRUCT_CONTACT_QUIC : EnumC12999a.CLOUDSYNC_UNSTRUCT_CONTACT : str.startsWith("notepad") ? z10 ? EnumC12999a.CLOUDSYNC_UNSTRUCT_NOTEPAD_QUIC : EnumC12999a.CLOUDSYNC_UNSTRUCT_NOTEPAD : z10 ? EnumC12999a.CLOUD_SYNC_QUIC : EnumC12999a.CLOUD_SYNC;
    }

    /* renamed from: L0 */
    public static boolean m15962L0(String str, String str2) {
        Boolean bool;
        if (str == null) {
            return false;
        }
        if (str.contains(C13843a.m83091m())) {
            Boolean bool2 = f12071b.get("com.android.browser");
            if (bool2 != null && bool2.booleanValue()) {
                C11839m.m70687e("CloudSyncUtil", "Ignore StartSync Request, com.android.browser is Syncing...");
                return true;
            }
        } else if (str.contains("com.android.browser") && (bool = f12071b.get(C13843a.m83091m())) != null && bool.booleanValue()) {
            C11839m.m70687e("CloudSyncUtil", "Ignore StartSync Request, " + C13843a.m83091m() + " is Syncing...");
            return true;
        }
        Boolean bool3 = f12071b.get(str);
        if (bool3 != null && bool3.booleanValue()) {
            C11839m.m70687e("CloudSyncUtil", "Ignore StartSync Request, Another task is Syncing, callingPackageName = " + str);
            return true;
        }
        if (!C11440c.m68538q(str2)) {
            return false;
        }
        C11839m.m70687e("CloudSyncUtil", "Ignore StartSync Request, The current task has not stopped, callingPackageName = " + str);
        return true;
    }

    /* renamed from: M */
    public static int m15963M() {
        return f12077h;
    }

    /* renamed from: M0 */
    public static boolean m15964M0(Context context) {
        boolean zM69652b = C11662a.m69650c(context).m69652b("wlan");
        C11839m.m70686d("CloudSyncUtil", "get switch wlan: " + zM69652b);
        return zM69652b;
    }

    /* renamed from: N */
    public static int m15965N() {
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            return interfaceC9285d.mo17189v();
        }
        return 0;
    }

    /* renamed from: N0 */
    public static /* synthetic */ void m15966N0(List list, String str, List list2) {
        if (list2 != null) {
            list.addAll(list2);
        }
    }

    /* renamed from: O */
    public static boolean m15967O(Context context) {
        if (context == null) {
            C11839m.m70687e("CloudSyncUtil", "getScreenStatus context is null");
            return false;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isInteractive();
        }
        return false;
    }

    /* renamed from: O0 */
    public static /* synthetic */ void m15968O0(List list, String str, List list2) {
        if (list2 != null) {
            list.addAll(list2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0078  */
    /* renamed from: P */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m15969P(android.content.Context r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17) {
        /*
            r0 = 1
            r1 = r17
            if (r1 > r0) goto Lf
            java.lang.String r0 = "addressbook"
            r2 = r14
            boolean r0 = r14.equals(r0)
            if (r0 != 0) goto Ld8
            goto L10
        Lf:
            r2 = r14
        L10:
            long r0 = m15945D()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getSpaceAvailable: availableEnough = "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "CloudSyncUtil"
            p514o9.C11839m.m70688i(r4, r3)
            r5 = 0
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto Ld8
            to.a r0 = new to.a     // Catch: fk.C9721b -> L53
            t9.a r1 = m15995b0(r14)     // Catch: fk.C9721b -> L53
            r8 = r16
            r0.<init>(r1, r8)     // Catch: fk.C9721b -> L50
            com.huawei.hicloud.base.bean.CloudSpace r0 = r0.m78754r()     // Catch: fk.C9721b -> L50
            long r9 = r0.getTotal()     // Catch: fk.C9721b -> L50
            long r0 = r0.getUsed()     // Catch: fk.C9721b -> L4e
            r3 = 0
            java.lang.String r7 = ""
            r10 = r9
            r9 = r7
            r7 = r3
            goto L74
        L4e:
            r0 = move-exception
            goto L57
        L50:
            r0 = move-exception
        L51:
            r9 = r5
            goto L57
        L53:
            r0 = move-exception
            r8 = r16
            goto L51
        L57:
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "getSpaceAvailable: error = "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            p514o9.C11839m.m70687e(r4, r1)
            r1 = 5
            r7 = r1
            r10 = r9
            r9 = r0
            r0 = r5
        L74:
            int r3 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r3 <= 0) goto L7a
            long r5 = r10 - r0
        L7a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r12 = "getSpaceAvailable: spaceTotal = "
            r3.append(r12)
            r3.append(r10)
            java.lang.String r12 = ", spaceUsed = "
            r3.append(r12)
            r3.append(r0)
            java.lang.String r12 = ", spaceAvailable = "
            r3.append(r12)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            p514o9.C11839m.m70688i(r4, r3)
            m15976S0(r0)
            m15980U0(r10)
            m15982V0(r0)
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>()
            java.lang.String r3 = "spaceTotal"
            java.lang.String r4 = java.lang.String.valueOf(r10)
            r12.put(r3, r4)
            java.lang.String r3 = "spaceUsed"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r12.put(r3, r0)
            java.lang.String r0 = "spaceAvailable"
            java.lang.String r1 = java.lang.String.valueOf(r5)
            r12.put(r0, r1)
            java.lang.String r0 = "local_upload_query_space"
            r10 = 0
            java.lang.String r6 = "03001"
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r7
            r5 = r9
            r7 = r0
            r8 = r16
            r9 = r12
            je.C10812z.m65847p(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
        Ld8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.complexutil.CloudSyncUtil.m15969P(android.content.Context, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    /* renamed from: P0 */
    public static void m15970P0(List<HiCloudItemView> list) {
        for (HiCloudItemView hiCloudItemView : list) {
            if (hiCloudItemView != null) {
                hiCloudItemView.onConfigurationChanged();
            }
        }
    }

    /* renamed from: Q */
    public static int m15971Q(Map<String, List<String>> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        final ArrayList arrayList = new ArrayList();
        map.forEach(new BiConsumer() { // from class: com.huawei.android.hicloud.complexutil.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                CloudSyncUtil.m15968O0(arrayList, (String) obj, (List) obj2);
            }
        });
        return arrayList.size();
    }

    /* renamed from: Q0 */
    public static void m15972Q0(String str, String str2) {
        Intent intent = new Intent(str);
        intent.putExtra("", str2);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: R */
    public static boolean m15973R(Context context, String str, String str2) {
        try {
            z = 1 == context.getPackageManager().getApplicationInfo(m15959K(context, str, str2), 128).metaData.getInt("cloudsync.SUPPORT_INCREMENT_SEND_MSG_FLAG", 0);
            C11839m.m70688i("CloudSyncUtil", "getSupportIncrementSendEtag, packageName: " + str2 + ", getSupportIncrementSendEtag = " + z);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncUtil", "getSupportIncrementSendEtag, " + e10.toString());
        }
        return z;
    }

    /* renamed from: R0 */
    public static void m15974R0(Context context) {
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17171d(context);
        }
    }

    /* renamed from: S */
    public static boolean m15975S(Context context, String str) {
        boolean z10 = false;
        try {
            z10 = context.getPackageManager().getApplicationInfo(str, 128).metaData.getBoolean("cloudSync.SUPPORT_PROVIDER_SYNC_RESULT", false);
            C11839m.m70688i("CloudSyncUtil", "getSupportProviderResult, packageName: " + str + ", getSupportProviderResult = " + z10);
            return z10;
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncUtil", "getSupportProviderResult, " + e10.toString());
            return z10;
        }
    }

    /* renamed from: S0 */
    public static void m15976S0(long j10) {
        f12074e = j10;
    }

    /* renamed from: T */
    public static boolean m15977T(Context context, String str) {
        boolean z10 = false;
        try {
            z10 = context.getPackageManager().getApplicationInfo(str, 128).metaData.getBoolean("cloudSync.SUPPORT_PROVIDER_SYNC", false);
            C11839m.m70688i("CloudSyncUtil", "getSupportProviderSync, packageName: " + str + ", getSupportProviderSync = " + z10);
            return z10;
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncUtil", "getSupportProviderSync, " + e10.toString());
            return z10;
        }
    }

    /* renamed from: T0 */
    public static void m15978T0(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        C0214f0.m1382b(context, "sync_contact_spfile", 0).edit().putBoolean(str + "cloudSpaceNotEnough", true).commit();
    }

    /* renamed from: U */
    public static int m15979U(String str) {
        Map<String, Integer> map = f12079j;
        int iIntValue = -1;
        if (map.isEmpty()) {
            return -1;
        }
        if (map.containsKey(str) && map.get(str) != null) {
            iIntValue = map.get(str).intValue();
        }
        C11839m.m70688i("CloudSyncUtil", "getSyncRsn: syncRsn = " + iIntValue);
        return iIntValue;
    }

    /* renamed from: U0 */
    public static void m15980U0(long j10) {
        f12075f = j10;
    }

    /* renamed from: V */
    public static Map<String, Boolean> m15981V() {
        return f12071b;
    }

    /* renamed from: V0 */
    public static void m15982V0(long j10) {
        f12076g = j10;
    }

    /* renamed from: W */
    public static Map<String, String> m15983W() {
        return f12073d;
    }

    /* renamed from: W0 */
    public static void m15984W0(Context context, String str, boolean z10) {
        SharedPreferences sharedPreferencesM1382b;
        if (context == null || str == null || (sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0)) == null) {
            return;
        }
        sharedPreferencesM1382b.edit().putBoolean(str + "is_open_switch", z10).commit();
    }

    /* renamed from: X */
    public static ArrayList<String> m15985X(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (context != null) {
            C10028c c10028cM62183d0 = C10028c.m62183d0(context);
            if (c10028cM62183d0.m62388s("addressbook")) {
                arrayList.add("addressbook");
            }
            if (c10028cM62183d0.m62388s("browser")) {
                arrayList.add("browser");
            }
            if (c10028cM62183d0.m62388s("calendar")) {
                arrayList.add("calendar");
            }
            if (c10028cM62183d0.m62388s("notepad")) {
                arrayList.add("notepad");
            }
            if (c10028cM62183d0.m62388s("wlan")) {
                arrayList.add("wlan");
            }
            if (C1006a.m5936k().m5975v(context)) {
                arrayList.add("atlas");
            }
            for (SyncConfigService syncConfigService : NotifyUtil.getShownSyncServiceItems(context)) {
                if (c10028cM62183d0.m62388s(syncConfigService.getId())) {
                    arrayList.add(syncConfigService.getId());
                }
            }
        }
        C11839m.m70688i("CloudSyncUtil", "getSyncTypesForOpenSwitch: syncTypes.size = " + arrayList.size());
        return arrayList;
    }

    /* renamed from: X0 */
    public static void m15986X0(Context context, String str, boolean z10) {
        if (context == null || str == null) {
            return;
        }
        C0214f0.m1382b(context, "sync_contact_spfile", 0).edit().putBoolean(str + "notAllSucess", z10).commit();
    }

    /* renamed from: Y */
    public static List<Record> m15987Y(Map<String, List<Attachment>> map, List<Record> list) {
        if (map == null || map.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Record record : list) {
            if (map.containsKey(record.getId())) {
                arrayList.add(record);
            }
        }
        return arrayList;
    }

    /* renamed from: Y0 */
    public static void m15988Y0(Context context, String str, boolean z10) {
        if (context == null || str == null) {
            return;
        }
        C0214f0.m1382b(context, "sync_contact_spfile", 0).edit().putBoolean(str + "reportFileNotAllSucess", z10).commit();
    }

    /* renamed from: Z */
    public static String m15989Z(String str) {
        return !TextUtils.isEmpty(str) ? str.startsWith("addressbook") ? "com.huawei.hidisk.contact" : str.startsWith("browser") ? "com.huawei.hidisk.browser" : str.startsWith("calendar") ? "com.huawei.hidisk.calendar" : str.startsWith("notepad") ? "com.huawei.hidisk.notepad" : str.startsWith("wlan") ? "com.huawei.hidisk.wlan" : str.startsWith("atlas") ? "com.huawei.hidisk.atlas" : "com.huawei.hidisk.syncmodule" : "";
    }

    /* renamed from: Z0 */
    public static void m15990Z0(String str, int i10) {
        f12079j.put(str, Integer.valueOf(i10));
    }

    /* renamed from: a0 */
    public static long m15992a0() {
        return 86400000L;
    }

    /* renamed from: a1 */
    public static void m15993a1(Context context, String str, int i10) {
        if (context == null || str == null || i10 == 0) {
            return;
        }
        C0214f0.m1382b(context, "sync_contact_spfile", 0).edit().putInt(str + "sync_retcode", i10).commit();
    }

    /* renamed from: b0 */
    public static EnumC12999a m15995b0(String str) {
        return TextUtils.isEmpty(str) ? EnumC12999a.CLOUD_SYNC : str.startsWith("addressbook") ? EnumC12999a.CLOUDSYNC_UNSTRUCT_CONTACT : str.startsWith("notepad") ? EnumC12999a.CLOUDSYNC_UNSTRUCT_NOTEPAD : EnumC12999a.CLOUD_SYNC;
    }

    /* renamed from: b1 */
    public static void m15996b1(Context context, ArrayList<String> arrayList, String str, String str2) {
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17178k(context, arrayList, str, str2);
        }
    }

    /* renamed from: c0 */
    public static String m15998c0(String str, Object obj) {
        return (str == null || obj == null) ? str : str.replace(String.valueOf(obj), C13843a.m83104z(obj));
    }

    /* renamed from: c1 */
    public static void m15999c1() {
        f12074e = -1L;
    }

    /* renamed from: d */
    public static void m16000d(Map<String, String> map, String str, String str2) {
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.put(str, str2);
    }

    /* renamed from: d0 */
    public static void m16001d0(Context context, String str, String str2) {
        if (!C0209d.m1184K0(context, str2)) {
            C11839m.m70688i("CloudSyncUtil", "gotoSyncApp " + str2 + " not install ");
            C11841o.m70708d(context, context.getString(R$string.general_no_tips, ""), 0);
            return;
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str2);
        if (launchIntentForPackage != null) {
            new HiCloudSafeIntent(launchIntentForPackage).setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(launchIntentForPackage);
            return;
        }
        C11839m.m70688i("CloudSyncUtil", "gotoSyncApp " + str2 + " getLaunchIntentForPackage intent null");
    }

    /* renamed from: d1 */
    public static void m16002d1(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        C0214f0.m1382b(context, "sync_contact_spfile", 0).edit().remove(str + "cloudSpaceNotEnough").commit();
    }

    /* renamed from: e */
    public static String m16003e(Context context) {
        if (context == null) {
            return null;
        }
        return C0209d.m1262h2() ? context.getResources().getString(R$string.autobackup_toast_wlan) : context.getResources().getString(R$string.autobackup_toast_wifi);
    }

    /* renamed from: e0 */
    public static boolean m16004e0() {
        return f12083n;
    }

    /* renamed from: e1 */
    public static void m16005e1() {
        f12075f = -1L;
    }

    /* renamed from: f */
    public static void m16006f(Context context, String str, int i10) {
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17165B(context, str, i10);
        }
    }

    /* renamed from: f0 */
    public static boolean m16007f0() {
        return C11440c.m68532j();
    }

    /* renamed from: f1 */
    public static void m16008f1() {
        f12076g = -1L;
    }

    /* renamed from: g */
    public static void m16009g(Context context, String str) {
        if (context == null) {
            return;
        }
        if ("autophonemanagerkey".equals(str)) {
            m16006f(context, "autobackupphonemanagertimeraction", 7007);
        } else if ("autorecordingkey".equals(str)) {
            C11839m.m70686d("CloudSyncUtil", "Cancel recording alarm");
            m16006f(context, "autobackuprecording", 7006);
        }
    }

    /* renamed from: g0 */
    public static boolean m16010g0(String str) {
        if (str == null) {
            return false;
        }
        int iCodePointCount = str.codePointCount(0, str.length());
        int iOffsetByCodePoints = str.offsetByCodePoints(0, 0);
        int iOffsetByCodePoints2 = str.offsetByCodePoints(0, iCodePointCount - 1);
        while (iOffsetByCodePoints <= iOffsetByCodePoints2) {
            int iCodePointAt = str.codePointAt(iOffsetByCodePoints);
            if (m16031n0(iCodePointAt)) {
                return true;
            }
            iOffsetByCodePoints += Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1;
        }
        return false;
    }

    /* renamed from: g1 */
    public static void m16011g1(String str) {
        f12079j.remove(str);
    }

    /* renamed from: h */
    public static void m16012h(Context context, String str) {
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17193z(context, str);
        }
    }

    /* renamed from: h0 */
    public static boolean m16013h0(File file) {
        if (m15952G0()) {
            return false;
        }
        long length = file.exists() ? file.length() : 0L;
        long jM15945D = m15945D();
        C11839m.m70686d("CloudSyncUtil", "isUploadForSize: fileSize = " + length + ", availableEnough = " + jM15945D);
        return jM15945D < 0 || jM15945D >= length;
    }

    /* renamed from: h1 */
    public static void m16014h1(String str, String str2) {
        C11839m.m70686d("CloudSyncUtil", "replaceStatusInfo key: " + str + " value: " + str2);
        try {
            StatusInfo statusInfo = new StatusInfo();
            statusInfo.setKey(str);
            statusInfo.setValue(str2);
            statusInfo.setTime(String.valueOf(System.currentTimeMillis()));
            new C12776i().m76684j(statusInfo);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncUtil", "replaceStatusInfo error: " + e10.getMessage());
        }
    }

    /* renamed from: i */
    public static boolean m16015i(String str, List<Attachment> list) {
        Iterator<Attachment> it = list.iterator();
        while (it.hasNext()) {
            if (!m16013h0(C10278a.m63442h(str + "/" + it.next().getUsage()))) {
                C11839m.m70688i("CloudSyncUtil", "syncv2 checkHasEnoughSpace space not enough, errorCode = 3001");
                return false;
            }
        }
        return true;
    }

    /* renamed from: i0 */
    public static boolean m16016i0(String str) {
        return C11440c.m68533k(str);
    }

    /* renamed from: i1 */
    public static void m16017i1(String str, String str2) {
        String str3 = "service:client,action:dataInit,bus:" + str + ",scene:" + str2 + ",result:ok";
        C11839m.m70686d("CloudSyncUtil", "clearSyncCache reportBasic = " + str3);
        C12515a.m75110o().m75175e(new SyncProcessBase.C2874a(C10812z.m65832a("03001"), str3), true);
    }

    /* renamed from: j */
    public static void m16018j(String str, String str2, ConcurrentHashMap<String, Integer> concurrentHashMap, ConcurrentHashMap<String, Integer> concurrentHashMap2, String str3, String str4) throws C9722c {
        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
            Iterator<Map.Entry<String, Integer>> it = concurrentHashMap2.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                throw new C9722c(next.getValue().intValue(), "modify get attachment zip invalid " + key + ", usage = " + str3, str, str4);
            }
        }
        if (str3 == null || TextUtils.isEmpty(str3) || concurrentHashMap.get(str3) == null) {
            return;
        }
        long length = C10278a.m63442h(str2 + "/" + str3).length();
        C11839m.m70689w("CloudSyncUtil", "modify get attachment unzip invalid, usage = " + str3 + ", fileSize = " + length);
        throw new C9722c(concurrentHashMap.get(str3).intValue(), "modify get attachment zip invalid, usage = " + str3 + ", fileSize = " + length, str, str4);
    }

    /* renamed from: j0 */
    public static boolean m16019j0(String str) {
        return C1007b.m5980s().m5985E(str);
    }

    /* renamed from: j1 */
    public static void m16020j1(String str, String str2, String str3, int i10) {
        String str4;
        String str5;
        str.hashCode();
        switch (str) {
            case "addressbook":
                str4 = "mecloud_main_click_contacts";
                str5 = DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN;
                break;
            case "calendar":
                str4 = "mecloud_main_click_calendar";
                str5 = "11";
                break;
            case "wlan":
                str4 = "mecloud_clouddiskmain_click_wlan";
                str5 = PriorInstallWay.PRIOR_ACTION_LANDING_PAGE;
                break;
            case "browser":
                str4 = "mecloud_clouddiskmain_click_browser";
                str5 = "20";
                break;
            case "notepad":
                str4 = "mecloud_main_click_notepad";
                str5 = "10";
                break;
            default:
                str4 = "mecloud_main_click_" + str;
                str5 = "29";
                break;
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        String str6 = str4;
        C13226e.m79491f1().m79588i0(str6, str2, str3, C13452e.m80781L().m80971t0(), i10);
        UBAAnalyze.m29973d0("PVC", str6, "1", str5, str2, str3, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0065 A[RETURN] */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m16021k(android.content.Context r5, int r6, java.lang.String r7, java.lang.String r8, java.io.File r9, java.lang.String r10, java.lang.String r11) throws fk.C9722c {
        /*
            r0 = 0
            r1 = 2246(0x8c6, float:3.147E-42)
            java.lang.String r2 = "CloudSyncUtil"
            r3 = 1
            if (r6 == r3) goto Lf
            r4 = 2
            if (r6 == r4) goto L15
            r5 = 3
            if (r6 == r5) goto L5e
            goto L65
        Lf:
            boolean r6 = r9.exists()
            if (r6 == 0) goto L66
        L15:
            java.util.LinkedHashMap r6 = je.C10812z.m65833b(r8)
            java.lang.String r8 = "packageName"
            java.lang.Object r6 = r6.get(r8)
            java.lang.String r6 = (java.lang.String) r6
            boolean r5 = m15958J0(r5, r6)
            if (r5 == 0) goto L57
            boolean r5 = r9.exists()
            if (r5 == 0) goto L2e
            goto L5e
        L2e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "modify get attachment local file not exsit, usage = "
            r5.append(r6)
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            p514o9.C11839m.m70689w(r2, r5)
            fk.c r5 = new fk.c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            r8.append(r10)
            java.lang.String r6 = r8.toString()
            r5.<init>(r1, r6, r7, r11)
            throw r5
        L57:
            boolean r5 = r9.exists()
            if (r5 != 0) goto L5e
            return r0
        L5e:
            boolean r5 = r9.exists()
            if (r5 != 0) goto L65
            return r0
        L65:
            return r3
        L66:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "add get attachment local file not exsit, usage = "
            r5.append(r6)
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            p514o9.C11839m.m70689w(r2, r5)
            fk.c r5 = new fk.c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            r8.append(r10)
            java.lang.String r6 = r8.toString()
            r5.<init>(r1, r6, r7, r11)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.complexutil.CloudSyncUtil.m16021k(android.content.Context, int, java.lang.String, java.lang.String, java.io.File, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: k0 */
    public static boolean m16022k0() {
        return C1007b.m5980s().m5984D();
    }

    /* renamed from: k1 */
    public static void m16023k1(Context context, String str) {
        C11839m.m70686d("CloudSyncUtil", "setAutoItemBackupTimer: " + str);
        long jM15992a0 = m15992a0();
        if ("autophonemanagerkey".equals(str)) {
            C1009d.m6109e().m6123o(context, "autobackupphonemanagertimeraction", 7007, jM15992a0);
        } else if ("autorecordingkey".equals(str)) {
            C1009d.m6109e().m6123o(context, "autobackuprecording", 7006, jM15992a0);
        }
    }

    /* renamed from: l */
    public static void m16024l(String str, String str2, List<UnstructData> list, ConcurrentHashMap<String, Integer> concurrentHashMap, ConcurrentHashMap<String, Integer> concurrentHashMap2, String str3) throws C9722c {
        if (list == null || list.size() <= 0) {
            C11839m.m70687e("CloudSyncUtil", "checkZipFileAvaliable fileList is null");
            return;
        }
        for (UnstructData unstructData : list) {
            if (unstructData != null) {
                m16018j(str, str2, concurrentHashMap, concurrentHashMap2, unstructData.getName(), str3);
            }
        }
    }

    /* renamed from: l0 */
    public static boolean m16025l0() {
        return C10028c.m62182c0().m62395t1("funcfg_cloud_backup");
    }

    /* renamed from: l1 */
    public static void m16026l1(String str, int i10) {
        C11839m.m70688i("CloudSyncUtil", "setCurrentMsgExceptionCount: syncType = " + str + ", count = " + i10);
        if (i10 >= 0) {
            f12070a.put(str, Integer.valueOf(i10));
        }
    }

    /* renamed from: m */
    public static void m16027m(String str, String str2, String str3) throws InterruptedException {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("CloudSyncUtil", "clearAndReport clear status is empty");
            return;
        }
        if (!TextUtils.equals(str, "1")) {
            C11839m.m70688i("CloudSyncUtil", "clearAndReport clear status is not success");
            return;
        }
        if (TextUtils.equals(str3, "notepad")) {
            C11440c.m68542u(NotifyUtil.HI_NOTE_SYNC_TYPE, 4977);
        }
        m16047s1();
        int iM18004n = DriveSyncUtil.m18004n(C0213f.m1377a(), str3);
        C11839m.m70688i("CloudSyncUtil", "clearAndReport deleteTagInfo: syncType = " + str3 + ", result = " + iM18004n);
        if (TextUtils.equals(str3, "notepad")) {
            int iM18004n2 = DriveSyncUtil.m18004n(C0213f.m1377a(), NotifyUtil.HI_NOTE_SYNC_TYPE);
            C11839m.m70688i("CloudSyncUtil", "clearAndReport deleteTagInfo: special syncType = hinote, result = " + iM18004n2);
            if (iM18004n2 != 0) {
                C11839m.m70689w("CloudSyncUtil", "clearSyncCache special deleteTagInfo fail");
                return;
            }
        }
        if (iM18004n != 0) {
            C11839m.m70689w("CloudSyncUtil", "clearAndReport deleteTagInfo fail");
            return;
        }
        C11839m.m70688i("CloudSyncUtil", "clearAndReport report basic");
        String str4 = f12082m.get(str2);
        if (TextUtils.isEmpty(str4)) {
            C11839m.m70689w("CloudSyncUtil", "clearAndReport serviceName is empty, not report");
        } else {
            m16017i1(str4, "2");
        }
    }

    /* renamed from: m0 */
    public static boolean m16028m0(Context context) {
        return m15943C(context) > 0;
    }

    /* renamed from: m1 */
    public static void m16029m1(List<Record> list, Map<String, List<String>> map) {
        if (list == null || list.size() <= 0 || map == null || map.size() <= 0) {
            return;
        }
        for (Record record : list) {
            List<String> list2 = map.get(record.getId());
            if (list2 != null) {
                record.setAttachmentsDeleteCount(Integer.valueOf(list2.size()));
            }
        }
    }

    /* renamed from: n */
    public static void m16030n() {
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17183p();
        }
    }

    /* renamed from: n0 */
    public static boolean m16031n0(int i10) {
        return (i10 >= 9728 && i10 <= 10175) || i10 == 12349 || i10 == 8265 || i10 == 8252 || (i10 >= 8192 && i10 <= 8207) || ((i10 >= 8232 && i10 <= 8239) || i10 == 8287 || ((i10 >= 8293 && i10 <= 8303) || ((i10 >= 8448 && i10 <= 8527) || ((i10 >= 8960 && i10 <= 9215) || ((i10 >= 11008 && i10 <= 11263) || ((i10 >= 10496 && i10 <= 10623) || ((i10 >= 12800 && i10 <= 13055) || ((i10 >= 55296 && i10 <= 57343) || ((i10 >= 57344 && i10 <= 63743) || ((i10 >= 65024 && i10 <= 65039) || i10 >= 65536))))))))));
    }

    /* renamed from: n1 */
    public static void m16032n1(boolean z10) {
        f12083n = z10;
    }

    /* renamed from: o */
    public static void m16033o(Context context, String str) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0);
        if (sharedPreferencesM1382b == null || (editorEdit = sharedPreferencesM1382b.edit()) == null) {
            return;
        }
        C11839m.m70688i("CloudSyncUtil", "clearLastSyncInfo: " + str);
        editorEdit.remove(str + "sync_retcode");
        editorEdit.apply();
    }

    /* renamed from: o0 */
    public static boolean m16034o0(int i10) {
        return i10 == 3001;
    }

    /* renamed from: o1 */
    public static void m16035o1(int i10) {
        f12077h = i10;
    }

    /* renamed from: p */
    public static void m16036p(Context context) {
        if (context == null) {
            C11839m.m70687e("CloudSyncUtil", "clearSyncTempFile context is null");
        } else {
            C12515a.m75110o().m75172d(new ClearSyncTempFileTask(context));
        }
    }

    /* renamed from: p0 */
    public static boolean m16037p0(int i10) {
        switch (i10) {
            case 10002:
            case 10003:
            case 40100:
            case 50001:
            case 70001:
            case 90001:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: p1 */
    public static void m16038p1(int i10) {
        f12078i = i10;
    }

    /* renamed from: q */
    public static void m16039q(int i10, int i11) {
        UserKeyUtils.getInstance().clearUserKeyByBusinessType(i10);
        if (i10 == 0) {
            C11440c.m68541t(SyncObserverServiceInvoker.getInstance().getAllSyncType(), i11);
        }
    }

    /* renamed from: q0 */
    public static boolean m16040q0(String str, String str2, List<UnstructData> list, String str3) throws C9722c {
        if (list != null && list.size() > 0) {
            if (100 >= list.size()) {
                return false;
            }
            C11839m.m70688i("CloudSyncUtil", "fileSize is upper maxLimits, create attachment after, dataType = " + str2);
            return true;
        }
        C11839m.m70687e("CloudSyncUtil", "syncData fileList is empty, mdataType = " + str2);
        throw new C9722c(2249, "syncData fileList is empty, mdataType = " + str2, str, str3);
    }

    /* renamed from: q1 */
    public static void m16041q1(File file) {
        if (file.exists()) {
            long length = file.length();
            long jM15945D = m15945D();
            C11839m.m70686d("CloudSyncUtil", "setSpaceAvailable: availableEnough = " + jM15945D + ", fileSize = " + length);
            if (jM15945D >= length) {
                m15976S0(jM15945D - length);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005b  */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m16042r(java.lang.String r9) throws java.lang.InterruptedException {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r1 = "CloudSyncUtil"
            if (r0 == 0) goto Le
            java.lang.String r9 = "stop and delete, push body is empty"
            p514o9.C11839m.m70689w(r1, r9)
            return
        Le:
            r0 = 0
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch: com.google.gson.JsonSyntaxException -> L32
            r2.<init>()     // Catch: com.google.gson.JsonSyntaxException -> L32
            java.lang.Class<com.huawei.android.hicloud.hisync.model.CloseDataBody> r3 = com.huawei.android.hicloud.hisync.model.CloseDataBody.class
            java.lang.Object r9 = r2.fromJson(r9, r3)     // Catch: com.google.gson.JsonSyntaxException -> L32
            com.huawei.android.hicloud.hisync.model.CloseDataBody r9 = (com.huawei.android.hicloud.hisync.model.CloseDataBody) r9     // Catch: com.google.gson.JsonSyntaxException -> L32
            java.lang.String r2 = r9.getServiceTypes()     // Catch: com.google.gson.JsonSyntaxException -> L32
            java.lang.String r0 = r9.getClearStatus()     // Catch: com.google.gson.JsonSyntaxException -> L2d
            if (r0 == 0) goto L4f
            if (r2 != 0) goto L4f
            java.lang.String r2 = r9.getCid()     // Catch: com.google.gson.JsonSyntaxException -> L2d
            goto L4f
        L2d:
            r9 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
            goto L34
        L32:
            r9 = move-exception
            r2 = r0
        L34:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "stop and delete, json parse error: "
            r3.append(r4)
            java.lang.String r9 = r9.getMessage()
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            p514o9.C11839m.m70687e(r1, r9)
            r8 = r2
            r2 = r0
            r0 = r8
        L4f:
            boolean r9 = android.text.TextUtils.isEmpty(r2)
            if (r9 == 0) goto L5b
            java.lang.String r9 = "stop and delete, service types is empty"
            p514o9.C11839m.m70689w(r1, r9)
            return
        L5b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r3 = "stop and delete, sync types is "
            r9.append(r3)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            p514o9.C11839m.m70688i(r1, r9)
            java.lang.String r9 = ","
            java.lang.String[] r9 = r2.split(r9)
            int r2 = r9.length
            r3 = 0
        L77:
            if (r3 >= r2) goto Lcc
            r4 = r9[r3]
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L87
            java.lang.String r4 = "stop and delete, service type is empty"
            p514o9.C11839m.m70689w(r1, r4)
            goto Lc9
        L87:
            java.lang.String r5 = "10880002"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L97
            ap.a r4 = p020ap.C1006a.m5936k()
            r4.m5961g()
            goto Lc9
        L97:
            java.lang.String r5 = com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil.m17969N(r4)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto La7
            java.lang.String r4 = "stop and delete, sync type is empty"
            p514o9.C11839m.m70689w(r1, r4)
            goto Lc9
        La7:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            java.lang.String r7 = "com.huawei.hidisk"
            p015ak.C0209d.m1302r2(r6, r7)
            java.lang.String r7 = "com.huawei.hicloud.action.CLOSE_SYNC_SWITCH"
            r6.setAction(r7)
            java.lang.String r7 = "syncType"
            r6.putExtra(r7, r5)
            android.content.Context r7 = p015ak.C0213f.m1377a()
            u0.a r7 = p664u0.C13108a.m78878b(r7)
            r7.m78881d(r6)
            m16027m(r0, r4, r5)
        Lc9:
            int r3 = r3 + 1
            goto L77
        Lcc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.complexutil.CloudSyncUtil.m16042r(java.lang.String):void");
    }

    /* renamed from: r0 */
    public static boolean m16043r0(String str, String str2) {
        if (str == null) {
            return false;
        }
        Boolean bool = f12072c.get(str);
        if (bool != null && bool.booleanValue()) {
            C11839m.m70687e("CloudSyncUtil", "Gen task is Syncing, callingPackageName = " + str);
            return true;
        }
        if (!C11440c.m68538q(str2)) {
            return false;
        }
        C11839m.m70687e("CloudSyncUtil", "Gen task has not stopped, callingPackageName = " + str);
        return true;
    }

    /* renamed from: r1 */
    public static void m16044r1(Context context, long j10, String str) {
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17169b(context, j10, str);
        }
    }

    /* renamed from: s */
    public static boolean m16045s() {
        int iM1562q;
        try {
            WifiManager wifiManager = (WifiManager) C0213f.m1377a().getApplicationContext().getSystemService(C6661f.f30885g);
            if (wifiManager == null || C0224k0.f835c == (iM1562q = C0224k0.m1562q(C0213f.m1377a())) || C0224k0.f836d == iM1562q) {
                return false;
            }
            return wifiManager.isWifiEnabled();
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncUtil", "conditionPermit exception =" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: s0 */
    public static boolean m16046s0() throws ParseException {
        boolean zM1289o1 = C0209d.m1289o1(f12080k, f12081l);
        C11839m.m70686d("CloudSyncUtil", "isInDelayTime: " + zM1289o1);
        return zM1289o1;
    }

    /* renamed from: s1 */
    public static void m16047s1() throws InterruptedException {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e10) {
            C11839m.m70687e("CloudSyncUtil", "sleepSeconds sleep exception:" + e10.toString());
        }
    }

    /* renamed from: t */
    public static void m16048t(String str) {
        try {
            C11839m.m70686d("CloudSyncUtil", "deleteStatusInfoByKey key: " + str);
            new C12776i().m76679e(str);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncUtil", "deleteStatusInfoByKey error: " + e10.getMessage());
        }
    }

    /* renamed from: t0 */
    public static boolean m16049t0(Context context, String str, String str2, List<UnstructData> list, String str3, String str4) throws C9722c {
        if (list != null && list.size() > 0) {
            return false;
        }
        C11839m.m70687e("CloudSyncUtil", "syncData fileList is empty, mdataType = " + str2);
        if (!m15958J0(context, C10812z.m65833b(str3).get("packageName"))) {
            return true;
        }
        throw new C9722c(2249, "syncData fileList is empty, mdataType = " + str2, str, str4);
    }

    /* renamed from: t1 */
    public static String m16050t1(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getString(R$string.upload_tip_wifi, context.getResources().getString(C0209d.m1167E2(R$string.autoupload_condition_wlan, R$string.autoupload_condition_wifi)));
    }

    /* renamed from: u */
    public static void m16051u(Context context) {
        String str = context.getFilesDir() + "/syncConfig";
        if (new File(str).exists()) {
            C11839m.m70688i("CloudSyncUtil", "deleteTemporaryFiles syncFile result = " + C0221j.m1499i(str));
        }
        String str2 = context.getFilesDir() + "/driveConfig";
        if (new File(str2).exists()) {
            C11839m.m70688i("CloudSyncUtil", "deleteTemporaryFiles driveFile result = " + C0221j.m1499i(str2));
        }
    }

    /* renamed from: u0 */
    public static boolean m16052u0(Context context, String str) {
        boolean zM69652b = C11662a.m69650c(context).m69652b(str);
        C11839m.m70688i("CloudSyncUtil", "get switch to ds " + str + ": " + zM69652b);
        return zM69652b;
    }

    /* renamed from: v */
    public static void m16053v(String str) {
        if ("atlas".equals(str)) {
            return;
        }
        C11839m.m70688i("CloudSyncUtil", "doAfterStartSyncTask syncType = " + str);
        HiCloudNotification.getInstance().executeFromDataUse();
    }

    /* renamed from: v0 */
    public static boolean m16054v0(IOException iOException) {
        boolean z10;
        boolean z11;
        return (iOException instanceof SocketException) || (iOException instanceof SocketTimeoutException) || (iOException instanceof UnknownHostException) || (iOException instanceof SSLException) || (iOException instanceof ProtocolException) || (iOException instanceof MalformedURLException) || (iOException instanceof ConnectTimeoutException) || (iOException instanceof ConnectException) || ((z10 = iOException instanceof SSLProtocolException)) || ((z11 = iOException instanceof SSLHandshakeException)) || (iOException instanceof SSLKeyException) || (iOException instanceof SSLPeerUnverifiedException) || (iOException instanceof NoRouteToHostException) || z11 || z10 || iOException.toString().contains("SocketTimeout") || iOException.toString().contains("timeout");
    }

    /* renamed from: w */
    public static void m16055w(Context context) {
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17173f(context);
        }
    }

    /* renamed from: w0 */
    public static boolean m16056w0(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("addressbook") || str.startsWith("browser") || str.startsWith("calendar") || str.startsWith("notepad") || str.startsWith("wlan") || str.startsWith("atlas")) ? false : true;
    }

    /* renamed from: x */
    public static List<Record> m16057x(List<Record> list, List<Record> list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<Record> it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().getId());
            }
            for (Record record : list) {
                if (arrayList2.contains(record.getId())) {
                    arrayList.add(record);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: x0 */
    public static boolean m16058x0(int i10) {
        return m16037p0(i10) || m16034o0(i10);
    }

    /* renamed from: y */
    public static Cipher m16059y(String str, String str2, String str3) throws C9721b {
        String strM17962G = DriveSyncUtil.m17962G(str2);
        C0087b c0087b = new C0087b(C9679b.m60452d().m60455e());
        UserKeyObject userKeyObjectM680c = c0087b.m680c(str, Integer.parseInt(strM17962G), UserKeyBaseReq.KEY_TYPE_AES_128);
        UserKeyObject userKeyObjectM681d = c0087b.m681d(str, Integer.parseInt(strM17962G), UserKeyBaseReq.KEY_TYPE_AES_256);
        String strM85033f = C14165b.m85033f(str3);
        String strM85031d = C14165b.m85031d(str3);
        String strM85030c = C14165b.m85030c(strM85031d, userKeyObjectM680c.getUserKey());
        String strM85030c2 = C14165b.m85030c(strM85031d, userKeyObjectM681d.getUserKey());
        Cipher cipher = new Cipher();
        ArrayList arrayList = new ArrayList();
        cipher.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL);
        cipher.setIv(strM85033f);
        cipher.setDataType(Integer.valueOf(Integer.parseInt(strM17962G)));
        cipher.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL);
        KeyChain keyChain = new KeyChain();
        keyChain.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL);
        keyChain.setType(1);
        keyChain.setEkey(strM85030c);
        keyChain.setId(userKeyObjectM680c.getUserKeyGuid());
        arrayList.add(keyChain);
        KeyChain keyChain2 = new KeyChain();
        keyChain2.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_256_FULL);
        keyChain2.setType(3);
        keyChain2.setEkey(strM85030c2);
        keyChain2.setId(userKeyObjectM681d.getUserKeyGuid());
        arrayList.add(keyChain2);
        cipher.setKeyChains(arrayList);
        return cipher;
    }

    /* renamed from: y0 */
    public static boolean m16060y0(String str) {
        if ("notepad".equals(str)) {
            if (!m16019j0(str)) {
                return false;
            }
            C11839m.m70689w("CloudSyncUtil", "Notepad is restoring");
            return true;
        }
        if ("calendar".equals(str)) {
            if (!m16019j0(str)) {
                return false;
            }
            C11839m.m70689w("CloudSyncUtil", "Calendar is restoring");
            return true;
        }
        if ("browser".equals(str)) {
            if (!m16019j0(str)) {
                return false;
            }
            C11839m.m70689w("CloudSyncUtil", "Browser is restoring");
            return true;
        }
        if ("addressbook".equals(str)) {
            if (!m16019j0(str)) {
                return false;
            }
            C11839m.m70689w("CloudSyncUtil", "Contact is restoring");
            return true;
        }
        if (!m16019j0(str)) {
            return false;
        }
        C11839m.m70689w("CloudSyncUtil", "is restoring: " + str);
        return true;
    }

    /* renamed from: z */
    public static int m16061z(Map<String, List<Attachment>> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        final ArrayList arrayList = new ArrayList();
        map.forEach(new BiConsumer() { // from class: com.huawei.android.hicloud.complexutil.b
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                CloudSyncUtil.m15966N0(arrayList, (String) obj, (List) obj2);
            }
        });
        return arrayList.size();
    }

    /* renamed from: z0 */
    public static boolean m16062z0(Context context, String str) {
        boolean zM1135g;
        if ("autorecordingkey".equals(str)) {
            zM1135g = C0206b0.m1135g("recording_need_wifi_condition", context);
            C11839m.m70686d("CloudSyncUtil", "isSatifyAutoConstructionProvider notepad, isNeedWifi =" + zM1135g);
        } else {
            zM1135g = false;
        }
        boolean z10 = m15939A(context) >= 10;
        return (zM1135g && C0209d.m1254f2(context) && z10 && !C11440c.m68533k(str)) || (!zM1135g && C0209d.m1333z1(context) && z10 && !C11440c.m68533k(str));
    }
}
