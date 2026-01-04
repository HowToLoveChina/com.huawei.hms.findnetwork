package p521og;

import android.app.ActivityOptions;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.android.app.ActivityManagerEx;
import com.huawei.android.os.SystemPropertiesEx;
import com.huawei.android.remotecontrol.sdk.R$plurals;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.p129ai.C5807k0;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.util.SafeBase64;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0224k0;
import p037bp.C1270a;
import p232dp.InterfaceC9285d;
import p292fn.C9733f;
import p514o9.C11829c;
import p575qe.C12347f;
import p611rf.C12498f;
import p681uj.C13198o;
import p681uj.InterfaceC13189f;
import p684un.C13230i;
import p709vj.C13452e;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12797b;
import tm.C13040c;

/* renamed from: og.n */
/* loaded from: classes4.dex */
public class C11881n {

    /* renamed from: a */
    public static Method f54935a;

    /* renamed from: b */
    public static Method f54936b;

    /* renamed from: c */
    public static final Map<String, String> f54937c;

    /* renamed from: og.n$a */
    public class a implements InterfaceC13189f {

        /* renamed from: a */
        public final /* synthetic */ Context f54938a;

        public a(Context context) {
            this.f54938a = context;
        }

        @Override // p681uj.InterfaceC13189f
        /* renamed from: a */
        public void mo14508a() throws ClassNotFoundException {
            C11881n.m71369s(this.f54938a);
        }

        @Override // p681uj.InterfaceC13189f
        public void onSuccess(String str) {
            InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
            if (interfaceC9285d == null || TextUtils.isEmpty(str)) {
                return;
            }
            interfaceC9285d.mo17174g(this.f54938a.getApplicationContext(), str, true);
        }
    }

    static {
        try {
            f54935a = m71366p(Class.forName("com.android.internal.widget.LockPatternUtils"), "getKeyguardStoredPasswordQuality", Integer.TYPE);
            f54936b = m71366p(UserHandle.class, "myUserId", new Class[0]);
        } catch (ClassNotFoundException unused) {
            C13981a.m83988e("Util", "getKeyguardStoredPasswordQuality error");
        }
        f54937c = new HashMap();
    }

    /* renamed from: A */
    public static boolean m71338A(Context context) {
        return C0219i.m1463a() >= 23 && !"CN".equalsIgnoreCase(AbstractC12139d.m72766e(context).getCountryCode());
    }

    /* renamed from: B */
    public static boolean m71339B(Context context) {
        Object objM71374x = m71374x(f54935a, C0224k0.m1538H(context), m71374x(f54936b, UserHandle.class, new Object[0]));
        return (objM71374x instanceof Integer) && ((Integer) objM71374x).intValue() >= 65536;
    }

    /* renamed from: C */
    public static boolean m71340C(String[] strArr, String[] strArr2) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS, Locale.getDefault());
        try {
            Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            C13981a.m83989i("Util", "isPeakTime now: " + date);
            for (int i10 = 0; i10 < strArr.length; i10++) {
                Date date2 = simpleDateFormat.parse(strArr[i10]);
                Date date3 = simpleDateFormat.parse(strArr2[i10]);
                C13981a.m83987d("Util", "isPeakTime after: " + date.after(date2) + ", before: " + date.before(date3) + ", i: " + i10);
                if (date.after(date2) && date.before(date3)) {
                    return true;
                }
            }
        } catch (ParseException e10) {
            C13981a.m83988e("Util", "isPeakTime exception: " + e10.getMessage());
        }
        return false;
    }

    /* renamed from: D */
    public static boolean m71341D() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return false;
        }
        String language = locale.getLanguage();
        return language == null || language.equals(Constants.URDU_LANG);
    }

    /* renamed from: E */
    public static boolean m71342E(Context context) {
        C13981a.m83989i("Util", "check supper privacy mode");
        if (!m71344G(context, 1).booleanValue() || !m71344G(context, 2).booleanValue()) {
            C13981a.m83989i("Util", "not support supper privacy mode");
            return false;
        }
        if (m71357g().intValue() == 2) {
            return true;
        }
        C13981a.m83989i("Util", "supper privacy mode not open");
        return false;
    }

    /* renamed from: F */
    public static boolean m71343F() {
        if (C0209d.m1269j1()) {
            return false;
        }
        try {
            return SystemPropertiesEx.getBoolean("hw_mc.sle.support.off_find", false);
        } catch (Exception e10) {
            C13981a.m83988e("Util", "is Support Close Find exception:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: G */
    public static Boolean m71344G(Context context, int i10) throws ClassNotFoundException {
        if (context == null) {
            C13981a.m83988e("Util", "context null");
            return Boolean.FALSE;
        }
        try {
            Class<?> cls = Class.forName("com.huawei.android.hardware.SensorPrivacyManagerEx");
            Boolean bool = (Boolean) cls.getMethod("supportsSensorToggle", Integer.TYPE).invoke(cls.getConstructor(Context.class).newInstance(context), Integer.valueOf(i10));
            if (bool != null && bool.booleanValue()) {
                C13981a.m83987d("Util", "support super privacy: " + i10);
                return Boolean.TRUE;
            }
        } catch (Exception e10) {
            C13981a.m83990w("Util", "isSupportSuperPrivacy exception: " + e10.getMessage());
        }
        return Boolean.FALSE;
    }

    /* renamed from: H */
    public static boolean m71345H(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return !((Boolean) Class.forName("android.net.ConnectivityManager").getDeclaredMethod("isNetworkSupported", Integer.TYPE).invoke((ConnectivityManager) context.getSystemService("connectivity"), 0)).booleanValue();
        } catch (Exception e10) {
            C13981a.m83988e("Util", "isWifiOnly Exception: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: I */
    public static void m71346I(Context context) {
        String strM80790C = C13452e.m80781L().m80790C();
        C13230i.m79504I().m79586g0("mecloud_findmyphone_click_jump_wap", C13452e.m80781L().m80971t0(), strM80790C);
        UBAAnalyze.m29956Q("PVP", "mecloud_findmyphone_click_jump_wap", "1", "19", strM80790C);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        try {
            String strM78625Q = C13040c.m78609F().m78625Q();
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            intent.setData(Uri.parse(strM78625Q));
            context.startActivity(intent);
        } catch (C9721b e10) {
            C13981a.m83988e("Util", "jumpBrowser CException " + e10.toString());
        } catch (Exception e11) {
            C13981a.m83988e("Util", "jumpBrowser exception" + e11.toString());
        }
    }

    /* renamed from: J */
    public static String m71347J(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: K */
    public static void m71348K(ActivityOptions activityOptions, int i10, Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (C0209d.m1277l1()) {
                return;
            }
            ActivityManagerEx.class.getMethod("setLaunchWindowingMode", ActivityOptions.class, Integer.TYPE, Context.class).invoke(null, activityOptions, Integer.valueOf(i10), context);
        } catch (Exception e10) {
            C13981a.m83990w("Util", "setLaunchWindowingMode exception: " + e10.getMessage());
        }
    }

    /* renamed from: L */
    public static void m71349L() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int iM1552g = C0224k0.m1552g();
        Bundle bundle = new Bundle();
        bundle.putInt("SUPER_PRIVACY", 0);
        try {
            Class<?> cls = Class.forName("com.huawei.securitycenter.HwPermissionManager");
            cls.getMethod("setAccessPrivacyMode", Integer.TYPE, Bundle.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(cls, new Object[0]), Integer.valueOf(iM1552g), bundle);
        } catch (Exception e10) {
            C13981a.m83990w("Util", "getAccessPrivacyMode exception: " + e10.getMessage());
        }
    }

    /* renamed from: M */
    public static void m71350M(Bundle bundle) {
        Context contextM74301m = C12347f.m74285n().m74301m();
        if (contextM74301m == null || bundle == null) {
            C13981a.m83988e("Util", "staticMapCardReport context or bundle null");
            return;
        }
        C13981a.m83989i("Util", "staticMapCardReport");
        String string = bundle.getString("operationType");
        String string2 = bundle.getString(C5807k0.f25949l);
        new C12797b().m76784j(contextM74301m, "Util", "", bundle.getString("errorReason"), "", string, "", string2, true);
    }

    /* renamed from: b */
    public static byte[] m71352b(String str) {
        try {
            return SafeBase64.decode(str, 0);
        } catch (Exception e10) {
            C13981a.m83988e("Util", "encryptData Exception:" + e10.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: c */
    public static String m71353c(Context context, int i10, int i11, int i12) {
        return context.getResources().getString(i12, m71372v(context, i10, i11));
    }

    /* renamed from: d */
    public static String m71354d(Context context, long j10, int i10) {
        if (j10 <= 0 || j10 == Long.MAX_VALUE) {
            return "";
        }
        int i11 = (int) (j10 / 60000);
        int i12 = i11 / 60;
        int i13 = i11 - (i12 * 60);
        C13981a.m83989i("Util", "minute: " + i13 + " hour: " + i12);
        return m71353c(context, i13, i12, i10);
    }

    /* renamed from: e */
    public static long m71355e(int i10, int i11) {
        if (i10 < 0 || i11 < 0) {
            return 0L;
        }
        return ((i11 * 60) + i10) * 60000;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m71356f(android.content.Context r10, long r11, int r13) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        /*
            java.lang.String r0 = "Util"
            boolean r1 = p015ak.C0209d.m1277l1()     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            if (r1 == 0) goto Lf
            java.lang.String r1 = "com.hihonor.android.text.format.DateUtilsEx"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            goto L15
        Lf:
            java.lang.String r1 = "com.huawei.android.text.format.DateUtilsEx"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
        L15:
            java.lang.Object r1 = r1.newInstance()     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class r2 = r1.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.String r3 = "formatChinaDateTime"
            r4 = 3
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r7 = 0
            r5[r7] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            r8 = 1
            r5[r8] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            r9 = 2
            r5[r9] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            r3[r7] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Long r4 = java.lang.Long.valueOf(r11)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            r3[r8] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            r3[r9] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.reflect.InvocationTargetException -> L4c java.lang.IllegalArgumentException -> L52 java.lang.IllegalAccessException -> L58 java.lang.NoSuchMethodException -> L5e java.lang.InstantiationException -> L64 java.lang.ClassNotFoundException -> L6a
            goto L70
        L4c:
            java.lang.String r1 = "formatDateTime：InvocationTargetException"
            p809yg.C13981a.m83988e(r0, r1)
            goto L6f
        L52:
            java.lang.String r1 = "formatDateTime：IllegalArgumentException"
            p809yg.C13981a.m83988e(r0, r1)
            goto L6f
        L58:
            java.lang.String r1 = "formatDateTime：IllegalAccessException"
            p809yg.C13981a.m83988e(r0, r1)
            goto L6f
        L5e:
            java.lang.String r1 = "formatDateTime：NoSuchMethodException"
            p809yg.C13981a.m83988e(r0, r1)
            goto L6f
        L64:
            java.lang.String r1 = "formatDateTime：InstantiationException"
            p809yg.C13981a.m83988e(r0, r1)
            goto L6f
        L6a:
            java.lang.String r1 = "formatDateTime：ClassNotFoundException"
            p809yg.C13981a.m83988e(r0, r1)
        L6f:
            r1 = 0
        L70:
            if (r1 != 0) goto L76
            java.lang.String r1 = android.text.format.DateUtils.formatDateTime(r10, r11, r13)
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p521og.C11881n.m71356f(android.content.Context, long, int):java.lang.String");
    }

    /* renamed from: g */
    public static Integer m71357g() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int iM1552g = C0224k0.m1552g();
        try {
            Class<?> cls = Class.forName("com.huawei.securitycenter.HwPermissionManager");
            Integer num = (Integer) cls.getMethod("getAccessPrivacyMode", Integer.TYPE, String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(cls, new Object[0]), Integer.valueOf(iM1552g), "SUPER_PRIVACY");
            C13981a.m83987d("Util", "getAccessPrivacyMode mode: " + num);
            return num;
        } catch (Exception e10) {
            C13981a.m83990w("Util", "getAccessPrivacyMode exception: " + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: h */
    public static String m71358h() {
        return TimeZone.getDefault().getDisplayName(false, 0);
    }

    /* renamed from: i */
    public static String m71359i(Context context) {
        C13981a.m83988e("Util", "getDeviceImeiCode");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            C13981a.m83988e("Util", "TelephonyManager is null");
            return "";
        }
        try {
            String imei = telephonyManager.getImei(0);
            if (!TextUtils.isEmpty(imei)) {
                C13981a.m83988e("Util", "imei1 not empty");
                return imei;
            }
            String imei2 = telephonyManager.getImei(1);
            C13981a.m83988e("Util", "return imei2");
            return imei2;
        } catch (Exception unused) {
            C13981a.m83988e("Util", "getDeviceImeiCode error!");
            return "";
        }
    }

    /* renamed from: j */
    public static String m71360j() {
        String name = BluetoothAdapter.getDefaultAdapter().getName();
        return TextUtils.isEmpty(name) ? C11829c.f54755a : name;
    }

    /* renamed from: k */
    public static String m71361k(Context context) {
        int defaultSNLength;
        C13981a.m83989i("Util", "getDeviceSNCode");
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            defaultSNLength = hiCloudSysParamMapM60757p.getDefaultSNLength();
            C13981a.m83989i("Util", "hiCloudSysParamMap not null, defaultSNLength is :" + defaultSNLength);
        } else {
            defaultSNLength = 8;
        }
        String strM75015b = C12498f.m75015b(context);
        if (strM75015b.length() > defaultSNLength) {
            C13981a.m83988e("Util", "sn length > defaultSNLength, return serialNumber");
            return strM75015b;
        }
        String strM71359i = m71359i(context);
        if (TextUtils.isEmpty(strM71359i)) {
            C13981a.m83989i("Util", "deviceImeiCode is empty, return serialNumber");
            return strM75015b;
        }
        C13981a.m83988e("Util", "deviceImeiCode not empty, return deviceImeiCode");
        return strM71359i;
    }

    /* renamed from: l */
    public static String m71362l(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e10) {
            C13981a.m83988e("Util", "getFromJson error:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: m */
    public static String m71363m(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), "hw_frp_token");
    }

    /* renamed from: n */
    public static int m71364n(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return -1;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException e10) {
            C13981a.m83988e("Util", "getFromJson error:" + e10.getMessage());
            return -1;
        }
    }

    /* renamed from: o */
    public static long m71365o(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return 0L;
        }
        try {
            return jSONObject.getLong(str);
        } catch (JSONException e10) {
            C13981a.m83988e("Util", "getLongFromJson error:" + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: p */
    public static Method m71366p(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            C13981a.m83990w("", "getMethod->clazz is null, method name is " + str);
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Exception e10) {
            C13981a.m83988e("Util", "getMethod err: " + e10.toString());
            return null;
        }
    }

    /* renamed from: q */
    public static String m71367q(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(HwPayConstant.KEY_SITE_ID)) {
                return jSONObject.getString(HwPayConstant.KEY_SITE_ID);
            }
            return null;
        } catch (Exception unused) {
            C13981a.m83988e("Util", "JsonException occur when getSiteId");
            return null;
        }
    }

    /* renamed from: r */
    public static void m71368r(Context context) {
        if (context == null) {
            C13981a.m83988e("Util", "GetPushToken error");
        } else {
            C13981a.m83989i("Util", "GetPushToken begin");
            C13198o.m79385c().m79387d(context.getApplicationContext(), new a(context));
        }
    }

    /* renamed from: s */
    public static void m71369s(Context context) throws ClassNotFoundException {
        C13981a.m83989i("Util", "get quickPushToken begin");
        if (context == null) {
            C13981a.m83988e("Util", "get quickPushToken error");
            return;
        }
        C11877j.m71197A0(context, true);
        Intent intent = new Intent("com.huawei.android.push.intent.REGISTER_SPECIAL");
        intent.putExtra("pkg_name", context.getPackageName());
        C0209d.m1302r2(intent, OsType.ANDROID);
        int iM71373w = m71373w();
        if (-999 != iM71373w) {
            intent.putExtra("userid", String.valueOf(iM71373w));
        }
        context.sendBroadcast(intent, "com.huawei.android.permission.ANTITHEFT");
    }

    /* renamed from: t */
    public static String m71370t(String str) throws UnknownHostException {
        String hostAddress = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Map<String, String> map = f54937c;
        if (map.containsKey(str)) {
            hostAddress = map.get(str);
            if (!TextUtils.isEmpty(hostAddress)) {
                return hostAddress;
            }
        }
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName.length > 0) {
                hostAddress = allByName[0].getHostAddress();
            }
            map.put(str, hostAddress);
            return hostAddress;
        } catch (UnknownHostException e10) {
            C13981a.m83988e("Util", "getServerIP " + e10.getMessage());
            return hostAddress;
        }
    }

    /* renamed from: u */
    public static String m71371u() {
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry().toLowerCase(Locale.US);
    }

    /* renamed from: v */
    public static String m71372v(Context context, int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return i10 > 0 ? context.getResources().getQuantityString(R$plurals.share_remain_time_minute, i10, Integer.valueOf(i10)).replace(' ', (char) 160) : i11 > 0 ? context.getResources().getQuantityString(R$plurals.share_remain_time_hour, i11, Integer.valueOf(i11)).replace(' ', (char) 160) : i10 == 0 ? context.getResources().getQuantityString(R$plurals.share_remain_time_minute, 1, 1).replace(' ', (char) 160) : "";
        }
        String strReplace = context.getResources().getQuantityString(R$plurals.share_remain_time_hour, i11, Integer.valueOf(i11)).replace(' ', (char) 160);
        String strReplace2 = context.getResources().getQuantityString(R$plurals.share_remain_time_minute, i10, Integer.valueOf(i10)).replace(' ', (char) 160);
        return context.getString(R$string.time_str, strReplace, " " + strReplace2);
    }

    /* renamed from: w */
    public static int m71373w() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.UserHandle");
            return ((Integer) cls.getDeclaredMethod("myUserId", new Class[0]).invoke(cls, new Object[0])).intValue();
        } catch (Exception e10) {
            C13981a.m83987d("Util", " getUserID wrong" + e10.getMessage());
            return Constants.COORDINATE_FAIL_DEF;
        }
    }

    /* renamed from: x */
    public static Object m71374x(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e10) {
            C13981a.m83988e("Util", "invoke error: " + e10.toString());
            return null;
        }
    }

    /* renamed from: y */
    public static boolean m71375y(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            int intExtra = new SafeIntent(intentRegisterReceiver).getIntExtra("status", -1);
            z = intExtra == 2 || intExtra == 5;
            C13981a.m83989i("Util", "battery status charging: " + z + ", status: " + intExtra);
        }
        return z;
    }

    /* renamed from: z */
    public static boolean m71376z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }
}
