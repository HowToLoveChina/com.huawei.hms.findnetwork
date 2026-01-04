package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.annotations.SecretField;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.utils.cg */
/* loaded from: classes2.dex */
public class C7787cg {

    /* renamed from: i */
    private static final byte[] f35990i = new byte[0];

    /* renamed from: j */
    private static final byte[] f35991j = new byte[0];

    /* renamed from: k */
    private static final byte[] f35992k = new byte[0];

    /* renamed from: l */
    private static final byte[] f35993l = new byte[0];

    /* renamed from: m */
    private static C7787cg f35994m;

    /* renamed from: a */
    private Context f35995a;

    /* renamed from: b */
    private SharedPreferences f35996b;

    /* renamed from: c */
    private SharedPreferences f35997c;

    /* renamed from: d */
    private SharedPreferences f35998d;

    /* renamed from: e */
    private SharedPreferences f35999e;

    /* renamed from: f */
    private SharedPreferences f36000f;

    /* renamed from: g */
    private final byte[] f36001g = new byte[0];

    /* renamed from: h */
    private final byte[] f36002h = new byte[0];

    /* renamed from: n */
    private a f36003n;

    /* renamed from: o */
    private e f36004o;

    /* renamed from: p */
    private c f36005p;

    /* renamed from: q */
    private f f36006q;

    /* renamed from: r */
    private d f36007r;

    /* renamed from: com.huawei.openalliance.ad.utils.cg$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ SharedPreferences f36008a;

        /* renamed from: b */
        final /* synthetic */ b f36009b;

        public AnonymousClass1(SharedPreferences sharedPreferences, b bVar) {
            sharedPreferences = sharedPreferences;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("cache_data", AbstractC7758be.m47740b(C7787cg.this.f35995a, bVar));
            editorEdit.commit();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.cg$a */
    public static final class a extends b {

        @OuterVisible
        List<String> aVideoCodec;

        @OuterVisible
        String acceler;

        @OuterVisible
        String agCountryCode;

        @OuterVisible
        String agVersion;

        @OuterVisible
        String agcAaid;

        @OuterVisible
        String arEngineVersion;

        @OuterVisible
        String baro;

        @OuterVisible
        Boolean baseLocationSwitch;

        @OuterVisible
        String battery;

        @OuterVisible
        String brandCust;

        @OuterVisible
        String charging;

        @OuterVisible
        String colorOSVersionName;

        @OuterVisible
        String countryCode;

        @OuterVisible
        String cpuCoreCnt;

        @OuterVisible
        String cpuModel;

        @OuterVisible
        String cpuSpeed;

        @OuterVisible
        String deviceMark;

        @OuterVisible
        Integer emuiSdkInt;

        @OuterVisible
        String emuiVersionName;

        @OuterVisible
        String freeSto;

        @OuterVisible
        String funtouchOSVersionName;

        @OuterVisible
        String gaid;

        @OuterVisible
        Boolean gaidLimit;

        @OuterVisible
        String gpuModel;

        @OuterVisible
        Integer grpIdCode;

        @OuterVisible
        String gyro;

        @OuterVisible
        Boolean hasAccAndRotate;

        @OuterVisible
        String hmsVersion;

        @OuterVisible
        String hosVersionName;

        @OuterVisible
        String hsfVersion;

        @OuterVisible
        String insAppTypes;

        @OuterVisible
        Boolean isDebug;

        @OuterVisible
        Boolean isEmulator;

        @OuterVisible
        String isHuaweiPhone;

        @OuterVisible
        Boolean isLimitTracking;

        @OuterVisible
        String isMIPhone;

        @OuterVisible
        String isOPPOPhone;

        @OuterVisible
        Boolean isProxy;

        @OuterVisible
        Boolean isTv;

        @OuterVisible
        String isVIVOPhone;

        @OuterVisible
        String magicuiVersionName;

        @OuterVisible
        String magnet;

        @OuterVisible
        String memorySize;

        @OuterVisible
        String miuiVersionName;

        @OuterVisible
        String oaid;

        @OuterVisible
        String pdtName;

        @OuterVisible
        String routerCountry;

        @OuterVisible
        String storageSize;

        @OuterVisible
        String totalMem;

        @OuterVisible
        String totalSto;

        @OuterVisible
        Integer type;

        @OuterVisible
        Boolean usb;

        @OuterVisible
        String useragent;

        @OuterVisible
        String uuid;

        @OuterVisible
        String vendCountry;

        @OuterVisible
        String vendor;

        @OuterVisible
        String wifiName;

        @OuterVisible
        String xrKitAppVersion;

        @OuterVisible
        public a() {
            super();
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7787cg.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.useragent = this.useragent;
            aVar.isHuaweiPhone = this.isHuaweiPhone;
            aVar.isMIPhone = this.isMIPhone;
            aVar.isVIVOPhone = this.isVIVOPhone;
            aVar.isOPPOPhone = this.isOPPOPhone;
            aVar.hsfVersion = this.hsfVersion;
            aVar.emuiVersionName = this.emuiVersionName;
            aVar.hosVersionName = this.hosVersionName;
            aVar.magicuiVersionName = this.magicuiVersionName;
            aVar.miuiVersionName = this.miuiVersionName;
            aVar.funtouchOSVersionName = this.funtouchOSVersionName;
            aVar.colorOSVersionName = this.colorOSVersionName;
            aVar.hmsVersion = this.hmsVersion;
            aVar.oaid = this.oaid;
            aVar.isLimitTracking = this.isLimitTracking;
            aVar.deviceMark = this.deviceMark;
            aVar.uuid = this.uuid;
            aVar.agVersion = this.agVersion;
            aVar.agCountryCode = this.agCountryCode;
            aVar.wifiName = this.wifiName;
            aVar.pdtName = this.pdtName;
            aVar.cpuModel = this.cpuModel;
            aVar.cpuCoreCnt = this.cpuCoreCnt;
            aVar.cpuSpeed = this.cpuSpeed;
            aVar.gpuModel = this.gpuModel;
            aVar.totalMem = this.totalMem;
            aVar.totalSto = this.totalSto;
            aVar.freeSto = this.freeSto;
            aVar.vendor = this.vendor;
            aVar.vendCountry = this.vendCountry;
            aVar.routerCountry = this.routerCountry;
            aVar.gyro = this.gyro;
            aVar.acceler = this.acceler;
            aVar.magnet = this.magnet;
            aVar.baro = this.baro;
            aVar.battery = this.battery;
            aVar.charging = this.charging;
            aVar.baseLocationSwitch = this.baseLocationSwitch;
            aVar.countryCode = this.countryCode;
            aVar.emuiSdkInt = this.emuiSdkInt;
            aVar.arEngineVersion = this.arEngineVersion;
            aVar.xrKitAppVersion = this.xrKitAppVersion;
            aVar.brandCust = this.brandCust;
            aVar.isTv = this.isTv;
            aVar.type = this.type;
            aVar.gaid = this.gaid;
            aVar.gaidLimit = this.gaidLimit;
            aVar.hasAccAndRotate = this.hasAccAndRotate;
            aVar.agcAaid = this.agcAaid;
            aVar.aVideoCodec = this.aVideoCodec;
            aVar.isProxy = this.isProxy;
            aVar.isDebug = this.isDebug;
            aVar.usb = this.usb;
            aVar.isEmulator = this.isEmulator;
            aVar.grpIdCode = this.grpIdCode;
            aVar.insAppTypes = this.insAppTypes;
            aVar.storageSize = this.storageSize;
            aVar.memorySize = this.memorySize;
            return aVar;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.cg$b */
    public static class b implements Cloneable {
        private b() {
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // 
        /* renamed from: b */
        public b clone() {
            return new b();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.cg$c */
    public static final class c extends b {

        @OuterVisible
        String freeSdcard;

        @OuterVisible
        Boolean honorLimitTracking;

        @OuterVisible
        String honorOaid;

        @OuterVisible
        Boolean isChildMode;

        @OuterVisible
        Boolean isCoppa;

        @OuterVisible
        String isHonor6UpPhone;

        @OuterVisible
        String isHuaweiPhoneNew;

        @OuterVisible
        Boolean isTFua;

        @OuterVisible
        Boolean isWelinkUser;

        @OuterVisible
        Integer sdkType;

        @OuterVisible
        Integer sptImgFormat;

        @OuterVisible
        public c() {
            super();
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7787cg.b
        /* renamed from: a */
        public c clone() {
            c cVar = new c();
            cVar.isHuaweiPhoneNew = this.isHuaweiPhoneNew;
            cVar.isHonor6UpPhone = this.isHonor6UpPhone;
            cVar.sdkType = this.sdkType;
            cVar.freeSdcard = this.freeSdcard;
            cVar.sptImgFormat = this.sptImgFormat;
            cVar.isWelinkUser = this.isWelinkUser;
            cVar.isChildMode = this.isChildMode;
            cVar.isCoppa = this.isCoppa;
            cVar.isTFua = this.isTFua;
            cVar.honorOaid = this.honorOaid;
            cVar.honorLimitTracking = this.honorLimitTracking;
            return cVar;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.cg$d */
    public static final class d extends b {

        @OuterVisible
        String trackVersion;

        @OuterVisible
        public d() {
            super();
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7787cg.b
        /* renamed from: b */
        public b clone() {
            d dVar = new d();
            dVar.trackVersion = this.trackVersion;
            return dVar;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.cg$e */
    public static final class e extends b {

        @SecretField
        String androidID;

        @SecretField
        String groupId;

        @SecretField
        String hiadUTag;

        @OuterVisible
        public e() {
            super();
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7787cg.b
        /* renamed from: a */
        public e clone() {
            e eVar = new e();
            eVar.androidID = this.androidID;
            eVar.groupId = this.groupId;
            eVar.hiadUTag = this.hiadUTag;
            return eVar;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.cg$f */
    public static final class f extends b {

        @OuterVisible
        String tag;

        @OuterVisible
        public f() {
            super();
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7787cg.b
        /* renamed from: b */
        public b clone() {
            f fVar = new f();
            fVar.tag = this.tag;
            return fVar;
        }
    }

    private C7787cg(Context context) {
        this.f35996b = null;
        this.f35997c = null;
        this.f35998d = null;
        this.f35999e = null;
        this.f36000f = null;
        try {
            this.f35996b = context.getSharedPreferences("hiad_sp_properties_cache", 0);
            this.f35997c = context.getSharedPreferences("hiad_sp_sec_properties_cache", 0);
            this.f35998d = context.getSharedPreferences("hiad_sp_nor_properties_cache", 0);
            this.f35999e = context.getSharedPreferences("hiad_sp_tag_cache", 0);
            this.f36000f = context.getSharedPreferences("hiad_sp_other_cache", 0);
            this.f35995a = context.getApplicationContext();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PropertiesCache", "get SharedPreference error: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: ai */
    private void m47907ai() {
        SharedPreferences sharedPreferences;
        if (this.f36003n != null || (sharedPreferences = this.f35996b) == null) {
            return;
        }
        a aVar = null;
        String string = sharedPreferences.getString("cache_data", null);
        if (string != null && string.length() > 0) {
            aVar = (a) AbstractC7758be.m47737b(this.f35995a, string, a.class, new Class[0]);
        }
        if (aVar == null) {
            aVar = new a();
        }
        this.f36003n = aVar;
    }

    /* renamed from: aj */
    private void m47908aj() {
        SharedPreferences sharedPreferences;
        if (this.f36004o != null || (sharedPreferences = this.f35997c) == null) {
            return;
        }
        String string = sharedPreferences.getString("cache_data", null);
        e eVar = TextUtils.isEmpty(string) ? null : (e) AbstractC7758be.m47737b(this.f35995a, string, e.class, new Class[0]);
        if (eVar == null) {
            eVar = new e();
        }
        this.f36004o = eVar;
    }

    /* renamed from: ak */
    private void m47909ak() {
        c cVar;
        if (this.f36005p == null) {
            SharedPreferences sharedPreferences = this.f35998d;
            if (sharedPreferences == null) {
                cVar = new c();
            } else {
                String string = sharedPreferences.getString("cache_data", null);
                cVar = (string == null || string.length() <= 0) ? null : (c) AbstractC7758be.m47737b(this.f35995a, string, c.class, new Class[0]);
                if (cVar == null) {
                    cVar = new c();
                }
            }
            this.f36005p = cVar;
        }
    }

    /* renamed from: al */
    private void m47910al() {
        if (this.f36006q == null) {
            String string = this.f35999e.getString("cache_data", null);
            f fVar = TextUtils.isEmpty(string) ? null : (f) AbstractC7758be.m47737b(this.f35995a, string, f.class, new Class[0]);
            if (fVar == null) {
                fVar = new f();
            }
            this.f36006q = fVar;
        }
    }

    /* renamed from: am */
    private void m47911am() {
        if (this.f36007r == null) {
            String string = this.f36000f.getString("cache_data", null);
            d dVar = TextUtils.isEmpty(string) ? null : (d) AbstractC7758be.m47737b(this.f35995a, string, d.class, new Class[0]);
            if (dVar == null) {
                dVar = new d();
            }
            this.f36007r = dVar;
        }
    }

    /* renamed from: A */
    public String m47912A() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.battery;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: B */
    public String m47914B() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.charging;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: C */
    public void m47916C(String str) {
        synchronized (this.f36002h) {
            try {
                m47908aj();
                e eVar = this.f36004o;
                if (eVar == null) {
                    return;
                }
                eVar.hiadUTag = str;
                m47905a(eVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: D */
    public String m47918D() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.brandCust;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: E */
    public Boolean m47920E() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return null;
                }
                Boolean bool = aVar.isTv;
                if (bool != null) {
                    return bool;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: F */
    public Integer m47922F() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return null;
                }
                Integer num = aVar.type;
                if (num != null) {
                    return num;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: G */
    public String m47924G() {
        synchronized (this.f36002h) {
            try {
                m47908aj();
                e eVar = this.f36004o;
                if (eVar == null) {
                    return "";
                }
                return eVar.androidID;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: H */
    public String m47926H() {
        String str;
        synchronized (this.f36002h) {
            m47908aj();
            e eVar = this.f36004o;
            str = eVar == null ? null : eVar.hiadUTag;
        }
        return str;
    }

    /* renamed from: I */
    public String m47928I() {
        synchronized (this.f36002h) {
            try {
                m47908aj();
                e eVar = this.f36004o;
                if (eVar == null) {
                    return "";
                }
                return eVar.groupId;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: J */
    public String m47930J() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.gaid;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: K */
    public Boolean m47932K() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return null;
                }
                return aVar.gaidLimit;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: L */
    public Boolean m47933L() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return null;
                }
                return aVar.hasAccAndRotate;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: M */
    public String m47934M() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.agcAaid;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: N */
    public List<String> m47935N() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return null;
                }
                return aVar.aVideoCodec;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: O */
    public Boolean m47936O() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return null;
                }
                Boolean bool = aVar.isProxy;
                return bool != null ? bool : bool;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: P */
    public Boolean m47937P() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return null;
                }
                Boolean bool = aVar.isDebug;
                return bool != null ? bool : bool;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: Q */
    public Boolean m47938Q() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return null;
                }
                Boolean bool = aVar.usb;
                return bool != null ? bool : bool;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: R */
    public Boolean m47939R() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return null;
                }
                Boolean bool = aVar.isEmulator;
                if (bool != null) {
                    return bool;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: S */
    public int m47940S() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return 8;
                }
                Integer num = aVar.grpIdCode;
                if (num == null) {
                    return 8;
                }
                return num.intValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: T */
    public String m47941T() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.insAppTypes;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: U */
    public String m47942U() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.memorySize;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: V */
    public String m47943V() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.storageSize;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: W */
    public String m47944W() {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return null;
                }
                String str = cVar.isHuaweiPhoneNew;
                if (str != null) {
                    return str;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: X */
    public String m47945X() {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return null;
                }
                String str = cVar.isHonor6UpPhone;
                if (str != null) {
                    return str;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: Y */
    public String m47946Y() {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return null;
                }
                String str = cVar.freeSdcard;
                if (str != null) {
                    return str;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: Z */
    public Integer m47947Z() {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return null;
                }
                return cVar.sdkType;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: aa */
    public Map<String, String> m47958aa() {
        synchronized (f35992k) {
            try {
                m47910al();
                f fVar = this.f36006q;
                Map<String, String> map = null;
                if (fVar == null) {
                    return null;
                }
                Map<String, String> map2 = (Map) AbstractC7758be.m47739b(fVar.tag, Map.class, new Class[0]);
                if (!C7765bl.m47802a(map2)) {
                    map = map2;
                }
                return map;
            } finally {
            }
        }
    }

    /* renamed from: ab */
    public String m47959ab() {
        synchronized (f35993l) {
            try {
                m47911am();
                d dVar = this.f36007r;
                if (dVar == null) {
                    return null;
                }
                return dVar.trackVersion;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: ac */
    public Integer m47960ac() {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return null;
                }
                Integer num = cVar.sptImgFormat;
                if (num != null) {
                    return num;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: ad */
    public Boolean m47961ad() {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return null;
                }
                return cVar.isWelinkUser;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: ae */
    public Boolean m47962ae() {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return null;
                }
                return cVar.isChildMode;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: af */
    public Boolean m47963af() {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return Boolean.FALSE;
                }
                Boolean bool = cVar.isCoppa;
                return Boolean.valueOf(bool == null ? false : bool.booleanValue());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: ag */
    public Boolean m47964ag() {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return Boolean.FALSE;
                }
                Boolean bool = cVar.isTFua;
                return Boolean.valueOf(bool == null ? false : bool.booleanValue());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: ah */
    public Pair<String, Boolean> m47965ah() {
        synchronized (f35991j) {
            try {
                m47909ak();
                if (TextUtils.isEmpty(this.f36005p.honorOaid) || this.f36005p.honorLimitTracking == null) {
                    return null;
                }
                c cVar = this.f36005p;
                return new Pair<>(cVar.honorOaid, cVar.honorLimitTracking);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public String m47966b() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.useragent;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public String m47973c() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.isHuaweiPhone;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public String m47977d() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.hsfVersion;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public String m47981e() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.hmsVersion;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public String m47985f() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.emuiVersionName;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public String m47989g() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.hosVersionName;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: h */
    public String m47992h() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.magicuiVersionName;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: i */
    public Pair<String, Boolean> m47995i() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return null;
                }
                if (TextUtils.isEmpty(aVar.oaid) && this.f36003n.isLimitTracking == null) {
                    return null;
                }
                a aVar2 = this.f36003n;
                return new Pair<>(aVar2.oaid, aVar2.isLimitTracking);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: j */
    public String m47998j() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.deviceMark;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: k */
    public String m48000k() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.uuid;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: l */
    public String m48002l() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.agVersion;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public String m48004m() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.agCountryCode;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: n */
    public String m48006n() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.pdtName;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: o */
    public String m48008o() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.cpuModel;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: p */
    public String m48010p() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.cpuCoreCnt;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: q */
    public String m48012q() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.cpuSpeed;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: r */
    public String m48014r() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.totalMem;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: s */
    public String m48016s() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.totalSto;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: t */
    public String m48018t() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.freeSto;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: u */
    public String m48020u() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.vendor;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: v */
    public String m48022v() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.vendCountry;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: w */
    public String m48024w() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.gyro;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: x */
    public String m48026x() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.acceler;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: y */
    public String m48028y() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.magnet;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: z */
    public String m48030z() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return "";
                }
                return aVar.baro;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static C7787cg m47900a(Context context) {
        C7787cg c7787cg;
        synchronized (f35990i) {
            try {
                if (f35994m == null) {
                    f35994m = new C7787cg(context);
                }
                c7787cg = f35994m;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7787cg;
    }

    /* renamed from: A */
    public void m47913A(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.brandCust = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: B */
    public void m47915B(String str) {
        synchronized (this.f36002h) {
            try {
                m47908aj();
                e eVar = this.f36004o;
                if (eVar == null) {
                    return;
                }
                eVar.androidID = str;
                m47905a(eVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: C */
    public boolean m47917C() {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return false;
                }
                Boolean bool = aVar.baseLocationSwitch;
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: D */
    public void m47919D(String str) {
        synchronized (this.f36002h) {
            try {
                m47908aj();
                e eVar = this.f36004o;
                if (eVar == null) {
                    return;
                }
                eVar.groupId = str;
                m47905a(eVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: E */
    public void m47921E(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.gaid = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: F */
    public void m47923F(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.agcAaid = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: G */
    public void m47925G(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.memorySize = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: H */
    public void m47927H(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.storageSize = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: I */
    public void m47929I(String str) {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return;
                }
                cVar.freeSdcard = str;
                m47903a(cVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: J */
    public void m47931J(String str) {
        synchronized (f35993l) {
            try {
                m47911am();
                d dVar = this.f36007r;
                if (dVar == null) {
                    return;
                }
                dVar.trackVersion = str;
                m47904a(dVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m47967b(int i10) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.grpIdCode = Integer.valueOf(i10);
                m47901a(this.f36003n);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public void m47974c(Boolean bool) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.isProxy = bool;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m47978d(Boolean bool) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.isDebug = bool;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public void m47982e(Boolean bool) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.usb = bool;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public void m47986f(Boolean bool) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.isEmulator = bool;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public void m47990g(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.deviceMark = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: h */
    public void m47993h(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.uuid = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: i */
    public void m47996i(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.agVersion = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: j */
    public void m47999j(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.agCountryCode = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: k */
    public void m48001k(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.pdtName = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: l */
    public void m48003l(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.cpuModel = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public void m48005m(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.cpuCoreCnt = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: n */
    public void m48007n(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.cpuSpeed = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: o */
    public void m48009o(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.totalMem = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: p */
    public void m48011p(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.totalSto = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: q */
    public void m48013q(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.freeSto = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: r */
    public void m48015r(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.vendor = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: s */
    public void m48017s(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.vendCountry = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: t */
    public void m48019t(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.gyro = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: u */
    public void m48021u(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.acceler = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: v */
    public void m48023v(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.magnet = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: w */
    public void m48025w(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.baro = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: x */
    public void m48027x(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.battery = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: y */
    public void m48029y(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.charging = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: z */
    public void m48031z(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.countryCode = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m47948a() {
        synchronized (this.f36001g) {
            m47907ai();
        }
        synchronized (this.f36002h) {
            m47908aj();
            m47909ak();
        }
        synchronized (f35992k) {
            m47910al();
        }
    }

    /* renamed from: b */
    public void m47968b(Boolean bool) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.hasAccAndRotate = bool;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public void m47975c(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.hmsVersion = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m47979d(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.emuiVersionName = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public void m47983e(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.hosVersionName = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public void m47987f(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.magicuiVersionName = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public void m47991g(boolean z10) {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return;
                }
                cVar.isChildMode = Boolean.valueOf(z10);
                m47903a(this.f36005p);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: h */
    public void m47994h(boolean z10) {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return;
                }
                cVar.isCoppa = Boolean.valueOf(z10);
                m47903a(this.f36005p);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: i */
    public void m47997i(boolean z10) {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return;
                }
                cVar.isTFua = Boolean.valueOf(z10);
                m47903a(this.f36005p);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m47949a(int i10) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.type = Integer.valueOf(i10);
                m47901a(this.f36003n);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m47969b(Integer num) {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return;
                }
                cVar.sptImgFormat = num;
                m47903a(cVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public void m47976c(boolean z10) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.isTv = Boolean.valueOf(z10);
                m47901a(this.f36003n);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m47980d(boolean z10) {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return;
                }
                cVar.isHuaweiPhoneNew = String.valueOf(z10);
                m47903a(this.f36005p);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public void m47984e(boolean z10) {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return;
                }
                cVar.isHonor6UpPhone = String.valueOf(z10);
                m47903a(this.f36005p);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public void m47988f(boolean z10) {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return;
                }
                cVar.isWelinkUser = Boolean.valueOf(z10);
                m47903a(this.f36005p);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private void m47901a(a aVar) {
        m47902a(aVar, this.f35996b);
    }

    /* renamed from: b */
    public void m47970b(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.hsfVersion = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private void m47902a(b bVar, SharedPreferences sharedPreferences) {
        if (bVar == null || sharedPreferences == null) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.cg.1

            /* renamed from: a */
            final /* synthetic */ SharedPreferences f36008a;

            /* renamed from: b */
            final /* synthetic */ b f36009b;

            public AnonymousClass1(SharedPreferences sharedPreferences2, b bVar2) {
                sharedPreferences = sharedPreferences2;
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("cache_data", AbstractC7758be.m47740b(C7787cg.this.f35995a, bVar));
                editorEdit.commit();
            }
        });
    }

    /* renamed from: b */
    public void m47971b(List<String> list) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                if (this.f36003n == null) {
                    return;
                }
                if (list == null || list.isEmpty()) {
                    this.f36003n.insAppTypes = "";
                } else {
                    this.f36003n.insAppTypes = AbstractC7806cz.m48156a(list, ",");
                }
                m47901a(this.f36003n);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private void m47903a(c cVar) {
        m47902a(cVar, this.f35998d);
    }

    /* renamed from: b */
    public void m47972b(boolean z10) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.baseLocationSwitch = Boolean.valueOf(z10);
                m47901a(this.f36003n);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private void m47904a(d dVar) {
        m47902a(dVar, this.f36000f);
    }

    /* renamed from: a */
    private void m47905a(e eVar) {
        m47902a(eVar, this.f35997c);
    }

    /* renamed from: a */
    private void m47906a(f fVar) {
        m47902a(fVar, this.f35999e);
    }

    /* renamed from: a */
    public void m47950a(Boolean bool) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.gaidLimit = bool;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m47951a(Integer num) {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                if (cVar == null) {
                    return;
                }
                cVar.sdkType = num;
                m47903a(cVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m47952a(String str) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.useragent = str;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m47953a(String str, Boolean bool) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.oaid = str;
                aVar.isLimitTracking = bool;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m47954a(String str, Boolean bool, boolean z10) {
        synchronized (f35991j) {
            try {
                m47909ak();
                c cVar = this.f36005p;
                cVar.honorOaid = str;
                cVar.honorLimitTracking = bool;
                if (z10) {
                    a aVar = this.f36003n;
                    aVar.oaid = str;
                    aVar.isLimitTracking = bool;
                }
                m47903a(cVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m47955a(List<String> list) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.aVideoCodec = list;
                m47901a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m47956a(Map<String, String> map) {
        synchronized (f35992k) {
            try {
                m47910al();
                f fVar = this.f36006q;
                if (fVar == null) {
                    return;
                }
                fVar.tag = AbstractC7758be.m47742b(map);
                m47906a(this.f36006q);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m47957a(boolean z10) {
        synchronized (this.f36001g) {
            try {
                m47907ai();
                a aVar = this.f36003n;
                if (aVar == null) {
                    return;
                }
                aVar.isHuaweiPhone = String.valueOf(z10);
                m47901a(this.f36003n);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
