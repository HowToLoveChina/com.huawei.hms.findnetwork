package ye;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.wearengine.auth.Permission;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.monitor.MonitorData;
import com.huawei.wearengine.monitor.MonitorItem;
import com.huawei.wearengine.p2p.C8902a;
import com.huawei.wearengine.p2p.C8907f;
import eg.AbstractC9478g;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import p015ak.C0209d;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p227dg.C9120m0;
import p514o9.C11839m;
import p521og.C11873f;
import p558pu.C12226a;
import p591qu.C12415a;
import p616rk.C12515a;
import p660tu.C13071a;
import p664u0.C13108a;
import p690uu.C13254b;
import p809yg.C13981a;
import ru.C12628b;
import ru.InterfaceC12627a;
import sg.C12797b;
import su.C12859a;
import ve.C13428t;
import vu.InterfaceC13490b;
import vu.InterfaceC13491c;
import vu.InterfaceC13492d;

/* renamed from: ye.y */
/* loaded from: classes4.dex */
public class C13978y {

    /* renamed from: o */
    public static String f62635o = "";

    /* renamed from: p */
    public static final byte[] f62636p = {1};

    /* renamed from: q */
    public static final byte[] f62637q = {0};

    /* renamed from: r */
    public static final Object f62638r = new Object();

    /* renamed from: s */
    public static C13978y f62639s = null;

    /* renamed from: e */
    public boolean f62644e;

    /* renamed from: c */
    public String f62642c = null;

    /* renamed from: d */
    public String f62643d = null;

    /* renamed from: f */
    public Context f62645f = C11873f.m71178f().m71181c();

    /* renamed from: g */
    public volatile List<Device> f62646g = new ArrayList();

    /* renamed from: h */
    public final Set<String> f62647h = Collections.synchronizedSet(new HashSet());

    /* renamed from: l */
    public InterfaceC12627a f62651l = new a();

    /* renamed from: m */
    public Handler f62652m = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: ye.s
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f62625a.m83971i0(message);
        }
    });

    /* renamed from: n */
    public InterfaceC13491c f62653n = new c();

    /* renamed from: a */
    public final C8907f f62640a = C12226a.m73418d(this.f62645f);

    /* renamed from: b */
    public final C12415a f62641b = C12226a.m73415a(this.f62645f);

    /* renamed from: i */
    public final C12628b f62648i = C12226a.m73419e(this.f62645f, this.f62651l);

    /* renamed from: j */
    public final C13071a f62649j = C12226a.m73416b(this.f62645f);

    /* renamed from: k */
    public final C13254b f62650k = C12226a.m73417c(this.f62645f);

    /* renamed from: ye.y$a */
    public class a implements InterfaceC12627a {
        public a() {
        }

        @Override // ru.InterfaceC12627a
        /* renamed from: a */
        public void mo76147a() {
            C13981a.m83989i("WearDeviceApi", "service Connection");
        }

        @Override // ru.InterfaceC12627a
        /* renamed from: b */
        public void mo76148b() {
            C13981a.m83989i("WearDeviceApi", "service disconnection");
        }
    }

    /* renamed from: ye.y$b */
    public class b extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Device f62655a;

        /* renamed from: b */
        public final /* synthetic */ String f62656b;

        /* renamed from: c */
        public final /* synthetic */ byte[] f62657c;

        /* renamed from: d */
        public final /* synthetic */ String f62658d;

        public b(Device device, String str, byte[] bArr, String str2) {
            this.f62655a = device;
            this.f62656b = str;
            this.f62657c = bArr;
            this.f62658d = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Task<MonitorData> taskM79648c = C13978y.this.f62650k.m79648c(this.f62655a, MonitorItem.f45316k);
            final String str = this.f62656b;
            final byte[] bArr = this.f62657c;
            final String str2 = this.f62658d;
            final Device device = this.f62655a;
            taskM79648c.addOnSuccessListener(new InterfaceC8939g() { // from class: ye.z
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    this.f62661a.m83986e(str, bArr, str2, device, (MonitorData) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: ye.a0
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    C13981a.m83988e("WearDeviceApi", "query fail");
                }
            });
        }

        /* renamed from: e */
        public final /* synthetic */ void m83986e(String str, byte[] bArr, String str2, Device device, MonitorData monitorData) {
            String str3 = monitorData.m56556a() == 1 ? "liteWearable" : "wearable";
            C13981a.m83989i("WearDeviceApi", "query success, deviceType: " + str3);
            C13978y.m83900H0(str3);
            C13978y.this.m83979w0(str, bArr, str2, device);
        }
    }

    /* renamed from: ye.y$c */
    public class c implements InterfaceC13491c {
        public c() {
        }

        @Override // vu.InterfaceC13491c
        /* renamed from: a */
        public void mo81179a(C8902a c8902a) {
            byte[] bArrM56588a = c8902a.m56588a();
            if (bArrM56588a == null || bArrM56588a.length == 0) {
                C13981a.m83988e("WearDeviceApi", "Receiver wear devices message is empty");
                C13978y.this.m83944F0(false, 1);
                return;
            }
            if ("alarm".equals(C13978y.this.f62643d)) {
                if (!C13978y.this.f62644e) {
                    C13978y.this.f62644e = true;
                    boolean zM83962X = C13978y.this.m83962X(bArrM56588a);
                    C13978y.this.m83944F0(zM83962X, !zM83962X ? 1 : 0);
                    return;
                } else {
                    boolean zM83962X2 = C13978y.this.m83962X(bArrM56588a);
                    C13978y.this.m83944F0(!zM83962X2, zM83962X2 ? 1 : 0);
                    C13978y.this.m83950J0(this);
                    return;
                }
            }
            if ("stopAlarm".equals(C13978y.this.f62643d)) {
                boolean zM83962X3 = C13978y.this.m83962X(bArrM56588a);
                C13978y.this.m83944F0(!zM83962X3, zM83962X3 ? 1 : 0);
                C13978y.this.m83950J0(this);
                return;
            }
            C13981a.m83988e("WearDeviceApi", "receiver other cmd:" + C13978y.this.f62643d);
        }
    }

    /* renamed from: ye.y$d */
    public static class d implements InterfaceC13492d {
        public d() {
        }

        @Override // vu.InterfaceC13492d
        /* renamed from: b */
        public void mo81180b(long j10) {
        }

        @Override // vu.InterfaceC13492d
        /* renamed from: c */
        public void mo81181c(int i10) {
            C13981a.m83987d("WearDeviceApi", "onSendResult:" + i10);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: H0 */
    public static void m83900H0(String str) {
        f62635o = str;
    }

    /* renamed from: R */
    public static String m83901R() {
        return f62635o;
    }

    /* renamed from: S */
    public static String m83902S() {
        return "com.huawei.health";
    }

    /* renamed from: T */
    public static C13978y m83903T() {
        C13978y c13978y;
        synchronized (f62638r) {
            try {
                if (f62639s == null) {
                    f62639s = new C13978y();
                }
                c13978y = f62639s;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c13978y;
    }

    /* renamed from: W */
    public static boolean m83904W(Context context, String str) {
        Uri uri;
        Cursor cursorQuery = null;
        try {
            try {
                uri = Uri.parse("content://com.huawei.healthcloud.health.provider/wear_device_state");
            } catch (Exception e10) {
                C13981a.m83988e("WearDeviceApi", "hasWearableDevice query deviceState has an exception:" + e10.getMessage());
                if (0 != 0) {
                }
            }
            if (!C0209d.m1227Y1(context, uri)) {
                C11839m.m70687e("WearDeviceApi", "hasWearableDevice TargetApp is not SystemApp");
                return true;
            }
            cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToNext()) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return true;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex(str));
            if (string == null || Boolean.FALSE.toString().equals(string)) {
                C13981a.m83989i("WearDeviceApi", "has no wear devices, queryType is " + str);
                cursorQuery.close();
                return false;
            }
            cursorQuery.close();
            return true;
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: b0 */
    public static /* synthetic */ void m83908b0(InterfaceC13956c0 interfaceC13956c0, Exception exc) {
        C13981a.m83988e("WearDeviceApi", "check wear permission fail:" + exc.getMessage());
        interfaceC13956c0.mo83892a();
    }

    /* renamed from: j0 */
    public static /* synthetic */ void m83917j0(int i10) {
        C13981a.m83987d("WearDeviceApi", "PingCallback result:" + i10);
    }

    /* renamed from: r0 */
    public static /* synthetic */ void m83927r0(Exception exc) {
        C13981a.m83989i("WearDeviceApi", "releaseConnection fail:" + exc.getMessage());
    }

    /* renamed from: s0 */
    public static /* synthetic */ void m83929s0(Device device, Void r92) {
        C13981a.m83989i("WearDeviceApi", "send message onSuccess:");
        C13428t.m80716a(device.m56534m(), "2", "0", "ancillaryDevice send message onSuccess", "ancillaryDeviceBell", "wearEngineDevice", null);
    }

    /* renamed from: u0 */
    public static /* synthetic */ void m83932u0(Exception exc) {
        C13981a.m83988e("WearDeviceApi", "unregister Receiver fail:" + exc.getMessage());
    }

    /* renamed from: A0 */
    public final void m83939A0() {
        if (this.f62648i == null) {
            return;
        }
        C13981a.m83989i("WearDeviceApi", "releaseConnection");
        this.f62648i.m76152d().addOnSuccessListener(new InterfaceC8939g() { // from class: ye.l
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                C13981a.m83989i("WearDeviceApi", "releaseConnection success");
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: ye.q
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                C13978y.m83927r0(exc);
            }
        });
    }

    /* renamed from: B0 */
    public void m83940B0(String str) {
        if (this.f62647h.isEmpty()) {
            return;
        }
        C13981a.m83989i("WearDeviceApi", "remove cmd:" + this.f62647h.size());
        this.f62647h.remove(str);
        C13981a.m83989i("WearDeviceApi", "cmd list:" + this.f62647h.size());
        if (this.f62647h.isEmpty()) {
            C13981a.m83989i("WearDeviceApi", "no wear devices cmd, releaseConnection");
            m83939A0();
        }
    }

    /* renamed from: C0 */
    public final void m83941C0(String str, String str2, int i10) {
        C13981a.m83989i("WearDeviceApi", "reportExecuteFail, deviceId: " + C9120m0.m57351R(str) + ", cmd: " + str2 + ", errorCode: " + i10);
        if (JsbMapKeyNames.H5_LOC.equals(str2)) {
            m83945G0(str, false, -1, i10);
        } else if ("alarm".equals(str2) || "stopAlarm".equals(str2)) {
            m83944F0(false, i10);
        } else {
            C13981a.m83988e("WearDeviceApi", "handleControlCmd cmd is not define");
        }
    }

    /* renamed from: D0 */
    public final void m83942D0(final Device device, byte[] bArr, final String str) {
        C8902a.a aVar = new C8902a.a();
        aVar.m56598f(bArr);
        C8902a c8902aM56596c = aVar.m56596c();
        d dVar = new d(null);
        if (device == null || c8902aM56596c == null) {
            return;
        }
        this.f62640a.m56608j(device, c8902aM56596c, dVar).addOnSuccessListener(new InterfaceC8939g() { // from class: ye.j
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                C13978y.m83929s0(device, (Void) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: ye.k
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f62616a.m83978t0(str, device, exc);
            }
        });
    }

    /* renamed from: E0 */
    public final void m83943E0(String str, byte[] bArr, String str2) {
        C13981a.m83989i("WearDeviceApi", "sendControlMessage, deviceId: " + C9120m0.m57351R(str) + ", message: " + bArr);
        Device deviceM83960U = m83960U(str);
        if (deviceM83960U == null) {
            C13981a.m83988e("WearDeviceApi", "targetDevice is empty");
            m83944F0(false, 1);
            return;
        }
        int iM56525c = deviceM83960U.m56525c();
        C13981a.m83989i("WearDeviceApi", "wearDeviceType: " + iM56525c);
        String str3 = "liteWearable";
        if (-1 != iM56525c) {
            if (iM56525c != 0) {
                m83980x0(str, bArr, str2, deviceM83960U);
                return;
            } else {
                m83900H0("liteWearable");
                m83979w0(str, bArr, str2, deviceM83960U);
                return;
            }
        }
        String strM56526d = deviceM83960U.m56526d();
        C13981a.m83987d("WearDeviceApi", "device Model:" + strM56526d);
        if (strM56526d != null && strM56526d.contains("Galileo")) {
            str3 = "wearable";
        }
        m83900H0(str3);
        m83979w0(str, bArr, str2, deviceM83960U);
    }

    /* renamed from: F0 */
    public final void m83944F0(boolean z10, int i10) {
        C13981a.m83989i("WearDeviceApi", "sendControlResultBroadcast: " + z10);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
        hiCloudSafeIntent.setAction("com.huawei.android.remotecontrol.action.WEAR_DEVICE_CONTROL");
        hiCloudSafeIntent.putExtra("controlResult", z10);
        hiCloudSafeIntent.putExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, i10);
        C13108a.m78878b(C11873f.m71178f().m71181c()).m78881d(hiCloudSafeIntent);
    }

    /* renamed from: G0 */
    public final void m83945G0(String str, boolean z10, int i10, int i11) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
        hiCloudSafeIntent.setAction("com.huawei.android.remotecontrol.action.LOCATE_WEAR_DEVICE_RESULT");
        hiCloudSafeIntent.putExtra("deviceId", str);
        hiCloudSafeIntent.putExtra("isConnect", z10);
        hiCloudSafeIntent.putExtra("battery", i10);
        hiCloudSafeIntent.putExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, i11);
        C13108a.m78878b(C11873f.m71178f().m71181c()).m78881d(hiCloudSafeIntent);
    }

    /* renamed from: H */
    public final void m83946H(Context context) {
        C13981a.m83989i("WearDeviceApi", "activePairedWearDevice getBondedDevices");
        this.f62649j.m78838b().addOnSuccessListener(new InterfaceC8939g() { // from class: ye.o
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                this.f62619a.m83963Y((List) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: ye.p
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f62620a.m83964Z(exc);
            }
        });
    }

    /* renamed from: I */
    public final void m83947I(final InterfaceC13956c0 interfaceC13956c0) {
        this.f62641b.m74551b(Permission.f45263b).addOnSuccessListener(new InterfaceC8939g() { // from class: ye.t
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                interfaceC13956c0.mo83892a();
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: ye.u
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                C13978y.m83908b0(interfaceC13956c0, exc);
            }
        });
    }

    /* renamed from: I0 */
    public final void m83948I0(String str) {
        C13981a.m83989i("WearDeviceApi", "device type: " + str);
        if (TextUtils.isEmpty(str) || this.f62640a == null) {
            return;
        }
        if ("wearable".equalsIgnoreCase(str)) {
            this.f62640a.m56610l("com.huawei.watch.home").m56609k("603AC6A57E2023E00C9C93BB539CA653DF3003EBA4E92EA1904BA4AAA5D938F0");
        } else {
            this.f62640a.m56610l("in.huawei.finddevice").m56609k("SystemApp");
        }
    }

    /* renamed from: J */
    public void m83949J(final Context context) {
        m83947I(new InterfaceC13956c0() { // from class: ye.a
            @Override // ye.InterfaceC13956c0
            /* renamed from: a */
            public final void mo83892a() {
                this.f62586a.m83965c0(context);
            }
        });
    }

    /* renamed from: J0 */
    public final void m83950J0(InterfaceC13491c interfaceC13491c) {
        this.f62640a.m56611m(interfaceC13491c).addOnSuccessListener(new InterfaceC8939g() { // from class: ye.m
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                C13981a.m83989i("WearDeviceApi", "register Receiver success");
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: ye.n
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                C13978y.m83932u0(exc);
            }
        });
    }

    /* renamed from: K */
    public final AncillaryDeviceInfo m83951K(Device device) {
        AncillaryDeviceInfo ancillaryDeviceInfo = new AncillaryDeviceInfo();
        ancillaryDeviceInfo.setPerDeviceType("2");
        ancillaryDeviceInfo.setDeviceID(device.m56534m());
        ancillaryDeviceInfo.setDeviceType("0");
        ancillaryDeviceInfo.setModelId(device.m56526d());
        ancillaryDeviceInfo.setConnected(device.m56535n());
        ancillaryDeviceInfo.setSubDeviceType("1");
        C13981a.m83989i("WearDeviceApi", "get wear device name:" + device.m56528f());
        ancillaryDeviceInfo.setDeviceName(device.m56528f());
        return ancillaryDeviceInfo;
    }

    /* renamed from: K0 */
    public final List<AncillaryDeviceInfo> m83952K0(List<Device> list) {
        if (list.isEmpty()) {
            C13981a.m83988e("WearDeviceApi", "wearDeviceList is empty");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Device> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m83951K(it.next()));
        }
        return arrayList;
    }

    /* renamed from: L */
    public final void m83953L(String str, String str2, String str3) {
        C13981a.m83989i("WearDeviceApi", "executeCmd, deviceId: " + C9120m0.m57351R(str) + ", cmd: " + str2);
        if (JsbMapKeyNames.H5_LOC.equals(str2)) {
            m83981y0(str, str3);
            return;
        }
        if ("alarm".equals(str2)) {
            this.f62644e = false;
            this.f62643d = "alarm";
            m83943E0(str, f62636p, str3);
        } else if (!"stopAlarm".equals(str2)) {
            C13981a.m83988e("WearDeviceApi", "handleControlCmd cmd is not define");
        } else {
            this.f62643d = "stopAlarm";
            m83943E0(str, f62637q, str3);
        }
    }

    /* renamed from: L0 */
    public final int m83954L0(int i10) {
        if (i10 == 14) {
            return 12;
        }
        if (i10 == 4) {
            return 14;
        }
        return i10 == 13 ? 15 : -1;
    }

    /* renamed from: M */
    public final void m83968f0(final String str, final String str2, final String str3) {
        C13981a.m83989i("WearDeviceApi", "executePushCmd, deviceId: " + C9120m0.m57351R(str));
        this.f62647h.add(str + str2);
        this.f62646g.clear();
        final Bundle bundle = new Bundle();
        bundle.putString("deviceId", str);
        bundle.putString("cmd", str2);
        bundle.putString("traceId", str3);
        this.f62649j.m78838b().addOnSuccessListener(new InterfaceC8939g() { // from class: ye.f
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                this.f62604a.m83966d0(bundle, str, (List) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: ye.g
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f62607a.m83967e0(bundle, str2, str3, str, exc);
            }
        });
    }

    /* renamed from: N */
    public void m83956N(final String str, final String str2, final String str3) {
        m83947I(new InterfaceC13956c0() { // from class: ye.r
            @Override // ye.InterfaceC13956c0
            /* renamed from: a */
            public final void mo83892a() {
                this.f62621a.m83968f0(str, str2, str3);
            }
        });
    }

    /* renamed from: O */
    public final LinkedHashMap<String, String> m83957O(String str) {
        String str2;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (str.length() < 4) {
            str2 = "*******" + str;
        } else {
            str2 = "*******" + str.substring(str.length() - 4);
        }
        linkedHashMap.put("perDeviceId", str2);
        linkedHashMap.put("perDeviceType", "2");
        return linkedHashMap;
    }

    /* renamed from: P */
    public final void m83965c0(final Context context) {
        C13981a.m83989i("WearDeviceApi", "queryAvailableDevices");
        this.f62649j.m78839d().addOnSuccessListener(new InterfaceC8939g() { // from class: ye.h
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                this.f62612a.m83969g0(context, (Boolean) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: ye.i
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f62614a.m83970h0(exc);
            }
        });
    }

    /* renamed from: Q */
    public void m83959Q(String str, String str2, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("WearDeviceApi", "getDeviceOnlineStatus " + str2);
    }

    /* renamed from: U */
    public final Device m83960U(String str) {
        if (this.f62646g == null || this.f62646g.isEmpty() || TextUtils.isEmpty(str)) {
            C13981a.m83988e("WearDeviceApi", "deviceList or deviceId is empty");
            return null;
        }
        for (Device device : this.f62646g) {
            if (str.equals(device.m56534m())) {
                return device;
            }
        }
        return null;
    }

    /* renamed from: V */
    public final void m83961V(boolean z10, Bundle bundle) {
        C13981a.m83989i("WearDeviceApi", "handleControlCmd, isQuerySuccess: " + z10);
        if (bundle == null) {
            C13981a.m83988e("WearDeviceApi", "handleControlCmd bundle is empty");
            return;
        }
        C10343b c10343b = new C10343b(bundle);
        String strM63694p = c10343b.m63694p("deviceId");
        String strM63694p2 = c10343b.m63694p("cmd");
        String strM63694p3 = c10343b.m63694p("traceId");
        int iM63686h = c10343b.m63686h(AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
        if (TextUtils.isEmpty(strM63694p) || TextUtils.isEmpty(strM63694p2)) {
            C13981a.m83988e("WearDeviceApi", "handleControlCmd deviceId or cmd is empty");
            return;
        }
        C13981a.m83989i("WearDeviceApi", "handleControlCmd is:" + z10 + ", errorCode: " + iM63686h);
        this.f62642c = strM63694p2;
        if (z10) {
            m83953L(strM63694p, strM63694p2, strM63694p3);
        } else {
            m83941C0(strM63694p, strM63694p2, iM63686h);
        }
    }

    /* renamed from: X */
    public final boolean m83962X(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            C13981a.m83989i("WearDeviceApi", "Receiver wear devices message:" + Arrays.toString(bArr));
            int length = bArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (1 == bArr[i10]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: Y */
    public final /* synthetic */ void m83963Y(List list) {
        C13981a.m83989i("WearDeviceApi", "getBondedDevices onSuccess, size = " + list.size());
        AncillaryDeviceManager.m26080y().m26107v(m83952K0(list));
        m83939A0();
    }

    /* renamed from: Z */
    public final /* synthetic */ void m83964Z(Exception exc) {
        C13981a.m83988e("WearDeviceApi", "getBondedDevices onFailure, Exception = " + exc.getMessage());
        C12797b c12797b = new C12797b();
        String strM76774a = C12797b.m76774a("01024");
        c12797b.m76784j(this.f62645f, "WearDeviceApi", "WearDevice", exc.getMessage() + C12859a.m77195b(exc.getMessage()), "01024", "WearDevicegetDeviceList", strM76774a, "getWearDeviceList", true);
        m83939A0();
    }

    /* renamed from: d0 */
    public final /* synthetic */ void m83966d0(Bundle bundle, String str, List list) {
        this.f62646g.addAll(list);
        C13981a.m83989i("WearDeviceApi", "get device list success, size: " + this.f62646g.size());
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.setData(bundle);
        this.f62652m.sendMessage(messageObtain);
        C13428t.m80716a(str, "2", "0", "ancillaryDevice get device list success", "ancillaryDeviceLocate", "wearEngineDevice", null);
    }

    /* renamed from: e0 */
    public final /* synthetic */ void m83967e0(Bundle bundle, String str, String str2, String str3, Exception exc) {
        C13981a.m83988e("WearDeviceApi", "get device list fail:" + exc.getMessage());
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, m83954L0(C12859a.m77195b(exc.getMessage())));
        messageObtain.setData(bundle);
        this.f62652m.sendMessage(messageObtain);
        new C12797b().m76785k(this.f62645f, "WearDeviceApi", "WearDevice", exc.getMessage() + C12859a.m77195b(exc.getMessage()), "01024", "WearDevice" + str, str2, "get_wearDeviceList", true, m83957O(str3));
        C13428t.m80716a(str3, "2", "1", "ancillaryDevice get device list fail", "ancillaryDeviceLocate", "wearEngineDevice", null);
    }

    /* renamed from: g0 */
    public final /* synthetic */ void m83969g0(Context context, Boolean bool) {
        C13981a.m83989i("WearDeviceApi", "queryAvailableDevices onSuccess, result = " + bool);
        m83946H(context);
    }

    /* renamed from: h0 */
    public final /* synthetic */ void m83970h0(Exception exc) {
        C13981a.m83988e("WearDeviceApi", "queryAvailableDevices onFailed, Exception=" + exc.getMessage());
        C12797b c12797b = new C12797b();
        String strM76774a = C12797b.m76774a("01024");
        c12797b.m76784j(this.f62645f, "WearDeviceApi", "WearDevice", exc.getMessage() + C12859a.m77195b(exc.getMessage()), "01024", "WearDevicehasAvailableDevices", strM76774a, "getWearDeviceList", true);
        m83939A0();
    }

    /* renamed from: i0 */
    public final /* synthetic */ boolean m83971i0(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            m83961V(true, message.getData());
        } else if (i10 == 2) {
            m83961V(false, message.getData());
        }
        return false;
    }

    /* renamed from: k0 */
    public final /* synthetic */ void m83972k0(Device device, byte[] bArr, String str, String str2, Void r13) {
        C13981a.m83989i("WearDeviceApi", "PingCallback onSuccess");
        m83982z0(device, bArr, str);
        C13428t.m80716a(str2, "2", "0", "ancillaryDevice PingCallback onSuccess", "ancillaryDeviceBell", "wearEngineDevice", null);
    }

    /* renamed from: l0 */
    public final /* synthetic */ void m83973l0(String str, String str2, Exception exc) {
        C13981a.m83988e("WearDeviceApi", "PingCallback fail:" + exc.getMessage());
        m83944F0(false, 1);
        new C12797b().m76785k(this.f62645f, "WearDeviceApi", "WearDevice", exc.getMessage() + C12859a.m77195b(exc.getMessage()), "01025", "WearDevice" + this.f62642c, str, "ping_wearDevice", true, m83957O(str2));
        C13428t.m80716a(str2, "2", "1", "ancillaryDevice PingCallback fail", "ancillaryDeviceBell", "wearEngineDevice", null);
    }

    /* renamed from: m0 */
    public final /* synthetic */ void m83974m0(boolean z10, String str, MonitorData monitorData) {
        String str2 = "query state success,isConnect:" + z10 + ",battery:" + monitorData.m56556a();
        C13981a.m83989i("WearDeviceApi", str2);
        m83945G0(str, z10, monitorData.m56556a(), 0);
        C13428t.m80716a(str, "2", "0", "ancillaryDevice " + str2, "ancillaryDeviceLocate", "wearEngineDevice", null);
    }

    /* renamed from: n0 */
    public final /* synthetic */ void m83975n0(boolean z10, String str, String str2, Exception exc) {
        String str3 = "query state fail,isConnect:" + z10 + ",battery:-1, error:" + exc.getMessage();
        C13981a.m83989i("WearDeviceApi", str3);
        m83945G0(str, z10, -1, 0);
        new C12797b().m76785k(this.f62645f, "WearDeviceApi", "WearDevice", exc.getMessage() + C12859a.m77195b(exc.getMessage()), "01026", "WearDevice" + this.f62642c, str2, "query_wearDeviceState", true, m83957O(str));
        C13428t.m80716a(str, "2", "0", "ancillaryDevice " + str3, "ancillaryDeviceLocate", "wearEngineDevice", null);
    }

    /* renamed from: o0 */
    public final /* synthetic */ void m83976o0(String str, Device device, Exception exc) {
        C13981a.m83988e("WearDeviceApi", "register Receiver fail:" + exc.getMessage());
        m83944F0(false, 1);
        new C12797b().m76785k(this.f62645f, "WearDeviceApi", "WearDevice", exc.getMessage() + C12859a.m77195b(exc.getMessage()), "01027", "WearDevice" + this.f62642c, str, "register_wearDevice", true, m83957O(device.m56534m()));
        C13428t.m80716a(device.m56534m(), "2", "1", "ancillaryDevice register Receiver fail", "ancillaryDeviceBell", "wearEngineDevice", null);
    }

    /* renamed from: p0 */
    public final /* synthetic */ void m83977p0(Device device, byte[] bArr, String str, Void r12) {
        C13981a.m83988e("WearDeviceApi", "register Receiver success");
        m83942D0(device, bArr, str);
        C13428t.m80716a(device.m56534m(), "2", "0", "ancillaryDevice register Receiver success", "ancillaryDeviceBell", "wearEngineDevice", null);
    }

    /* renamed from: t0 */
    public final /* synthetic */ void m83978t0(String str, Device device, Exception exc) {
        C13981a.m83989i("WearDeviceApi", "send message onFailure:" + exc.getMessage());
        m83944F0(false, 1);
        new C12797b().m76785k(this.f62645f, "WearDeviceApi", "WearDevice", exc.getMessage() + C12859a.m77195b(exc.getMessage()), "01028", "WearDevice" + this.f62642c, str, "send_controlMessage", true, m83957O(device.m56534m()));
        C13428t.m80716a(device.m56534m(), "2", "0", "ancillaryDevice send message onFailure", "ancillaryDeviceBell", "wearEngineDevice", null);
    }

    /* renamed from: w0 */
    public final void m83979w0(final String str, final byte[] bArr, final String str2, final Device device) {
        C13981a.m83989i("WearDeviceApi", "pingClient, deviceId: " + C9120m0.m57351R(str));
        m83948I0(m83901R());
        m83900H0("");
        this.f62640a.m56606h(device, new InterfaceC13490b() { // from class: ye.x
            @Override // vu.InterfaceC13490b
            /* renamed from: a */
            public final void mo81178a(int i10) {
                C13978y.m83917j0(i10);
            }
        }).addOnSuccessListener(new InterfaceC8939g() { // from class: ye.b
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                this.f62588a.m83972k0(device, bArr, str2, str, (Void) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: ye.c
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f62594a.m83973l0(str2, str, exc);
            }
        });
    }

    /* renamed from: x0 */
    public final void m83980x0(String str, byte[] bArr, String str2, Device device) {
        C13981a.m83989i("WearDeviceApi", "getQueryDeviceType");
        C12515a.m75110o().m75172d(new b(device, str, bArr, str2));
    }

    /* renamed from: y0 */
    public final void m83981y0(final String str, final String str2) {
        Device deviceM83960U = m83960U(str);
        if (deviceM83960U == null) {
            C13981a.m83988e("WearDeviceApi", "targetDevice is empty");
            return;
        }
        C13981a.m83989i("WearDeviceApi", "query device state, traceId: " + str2);
        final boolean zM56535n = deviceM83960U.m56535n();
        try {
            this.f62650k.m79648c(deviceM83960U, MonitorItem.f45312g).addOnSuccessListener(new InterfaceC8939g() { // from class: ye.v
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    this.f62628a.m83974m0(zM56535n, str, (MonitorData) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: ye.w
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    this.f62631a.m83975n0(zM56535n, str, str2, exc);
                }
            });
        } catch (Exception e10) {
            C13981a.m83988e("WearDeviceApi", "query wear device state exception:" + e10.getMessage());
        }
    }

    /* renamed from: z0 */
    public final void m83982z0(final Device device, final byte[] bArr, final String str) {
        this.f62640a.m56607i(device, this.f62653n).addOnFailureListener(new InterfaceC8938f() { // from class: ye.d
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f62597a.m83976o0(str, device, exc);
            }
        }).addOnSuccessListener(new InterfaceC8939g() { // from class: ye.e
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                this.f62600a.m83977p0(device, bArr, str, (Void) obj);
            }
        });
    }
}
