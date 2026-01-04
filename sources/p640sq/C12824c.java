package p640sq;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import iq.InterfaceC10596j;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: sq.c */
/* loaded from: classes8.dex */
public class C12824c {

    /* renamed from: a */
    public static InterfaceC10596j f58540a = null;

    /* renamed from: b */
    public static InterfaceC10596j f58541b = null;

    /* renamed from: c */
    public static InterfaceC10596j f58542c = null;

    /* renamed from: d */
    public static InterfaceC10596j f58543d = null;

    /* renamed from: e */
    public static InterfaceC10596j f58544e = null;

    /* renamed from: f */
    public static InterfaceC10596j f58545f = null;

    /* renamed from: g */
    public static InterfaceC10596j f58546g = null;

    /* renamed from: h */
    public static InterfaceC10596j f58547h = null;

    /* renamed from: i */
    public static InterfaceC10596j f58548i = null;

    /* renamed from: j */
    public static String f58549j = "";

    /* renamed from: k */
    public static String f58550k;

    /* renamed from: l */
    public static ArrayList<String> f58551l = new ArrayList<>();

    /* renamed from: sq.c$a */
    public class a implements PrivilegedAction<Object> {

        /* renamed from: a */
        public final /* synthetic */ Object f58552a;

        /* renamed from: b */
        public final /* synthetic */ String f58553b;

        /* renamed from: c */
        public final /* synthetic */ Object[] f58554c;

        /* renamed from: d */
        public final /* synthetic */ Class[] f58555d;

        public a(Object obj, String str, Object[] objArr, Class[] clsArr) {
            this.f58552a = obj;
            this.f58553b = str;
            this.f58554c = objArr;
            this.f58555d = clsArr;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            Method methodM77013p = C12824c.m77013p(this.f58552a, this.f58553b, this.f58554c, this.f58555d);
            if (methodM77013p != null) {
                methodM77013p.setAccessible(true);
                try {
                    return methodM77013p.invoke(this.f58552a, this.f58554c);
                } catch (IllegalAccessException e10) {
                    C12836o.m77097b("BaseUtil", e10.getClass().getSimpleName(), true);
                } catch (IllegalArgumentException e11) {
                    C12836o.m77097b("BaseUtil", e11.getClass().getSimpleName(), true);
                } catch (InvocationTargetException e12) {
                    C12836o.m77097b("BaseUtil", e12.getClass().getSimpleName(), true);
                }
            }
            return null;
        }
    }

    /* renamed from: A */
    public static boolean m76979A(Context context) {
        C12836o.m77097b("BaseUtil", "enter networkIsAvaiable", true);
        if (context == null) {
            return false;
        }
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        if (systemService == null) {
            C12836o.m77097b("BaseUtil", "connectivity is null,so networkIsAvaiable is unaviable", true);
            return false;
        }
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) systemService).getAllNetworkInfo();
        if (allNetworkInfo == null || allNetworkInfo.length == 0) {
            C12836o.m77097b("BaseUtil", "NetworkInfo is null,so networkIsAvaiable is unaviable", true);
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        C12836o.m77097b("BaseUtil", "NetworkInfo state is unaviable", true);
        return false;
    }

    /* renamed from: B */
    public static InterfaceC10596j m76980B() {
        return f58543d;
    }

    /* renamed from: C */
    public static String m76981C(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().toLowerCase(Locale.getDefault());
    }

    /* renamed from: D */
    public static String m76982D(String str) {
        return str != null ? str.replaceAll("\\s", "") : "";
    }

    /* renamed from: E */
    public static Bundle m76983E(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    String str3 = strArrSplit[0];
                    String str4 = strArrSplit[1];
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        bundle.putString(m76986H(str3), m76986H(str4));
                    }
                }
            }
        }
        return bundle;
    }

    /* renamed from: F */
    public static InterfaceC10596j m76984F() {
        return f58541b;
    }

    /* renamed from: G */
    public static InterfaceC10596j m76985G() {
        return f58544e;
    }

    /* renamed from: H */
    public static String m76986H(String str) {
        try {
            return URLDecoder.decode(str, Constants.UTF_8);
        } catch (UnsupportedEncodingException | IllegalArgumentException e10) {
            C12836o.m77099d("BaseUtil", "Exception:" + e10.getClass().getSimpleName(), true);
            return str;
        } catch (Exception e11) {
            C12836o.m77099d("BaseUtil", "Exception:" + e11.getClass().getSimpleName(), true);
            return str;
        }
    }

    /* renamed from: I */
    public static InterfaceC10596j m76987I() {
        return f58546g;
    }

    /* renamed from: J */
    public static InterfaceC10596j m76988J() {
        return f58547h;
    }

    /* renamed from: K */
    public static InterfaceC10596j m76989K() {
        return f58548i;
    }

    /* renamed from: L */
    public static InterfaceC10596j m76990L() {
        return f58545f;
    }

    /* renamed from: M */
    public static String m76991M() {
        return f58549j;
    }

    /* renamed from: N */
    public static String m76992N() {
        try {
            Object objM77086b = C12834m.m77086b("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.config.marketing_name"});
            return objM77086b != null ? (String) objM77086b : "";
        } catch (Exception e10) {
            C12836o.m77098c("BaseUtil", e10.getClass().getSimpleName(), true);
            return "";
        }
    }

    /* renamed from: O */
    public static String m76993O() {
        return f58550k;
    }

    /* renamed from: P */
    public static ArrayList<String> m76994P() {
        return f58551l;
    }

    /* renamed from: Q */
    public static String m76995Q() {
        return System.currentTimeMillis() + m76996R();
    }

    /* renamed from: R */
    public static String m76996R() {
        SecureRandom secureRandomM77122a = C12842u.m77122a();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 19; i10++) {
            sb2.append(secureRandomM77122a.nextInt(10));
        }
        return sb2.toString();
    }

    /* renamed from: S */
    public static String m76997S() {
        try {
            Object objM77086b = C12834m.m77086b("android.os.SystemProperties", "get", new Class[]{String.class, String.class}, new Object[]{"ro.build.version.emui", ""});
            return objM77086b != null ? (String) objM77086b : "";
        } catch (Exception e10) {
            C12836o.m77098c("BaseUtil", e10.getClass().getSimpleName(), true);
            return "";
        }
    }

    /* renamed from: a */
    public static Object m76998a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        if (obj == null) {
            return null;
        }
        try {
            AccessController.doPrivileged(new a(obj, str, objArr, clsArr));
        } catch (Exception e10) {
            C12836o.m77099d("BaseUtil", "Exception: " + e10.getClass().getSimpleName(), true);
        }
        return null;
    }

    /* renamed from: b */
    public static String m76999b() {
        return Build.VERSION.SDK_INT >= 33 ? "android.permission.READ_MEDIA_IMAGES" : "android.permission.WRITE_EXTERNAL_STORAGE";
    }

    /* renamed from: c */
    public static String m77000c(Context context) {
        return context.getResources().getConfiguration().locale.getCountry().toLowerCase(Locale.getDefault());
    }

    /* renamed from: d */
    public static String m77001d(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : strArr) {
            sb2.append(str);
            sb2.append(" ");
        }
        return sb2.toString();
    }

    /* renamed from: e */
    public static void m77002e(Activity activity) throws IllegalAccessException, IllegalArgumentException {
        if (C12829h.m77057b()) {
            try {
                activity.getWindow().getAttributes().getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).set(activity.getWindow().getAttributes(), 1);
            } catch (RuntimeException e10) {
                C12836o.m77099d("BaseUtil", "RuntimeException: " + e10.getClass().getSimpleName(), true);
            } catch (Exception e11) {
                C12836o.m77099d("BaseUtil", "Exception: " + e11.getClass().getSimpleName(), true);
            }
        }
    }

    /* renamed from: f */
    public static void m77003f(ArrayList<String> arrayList) {
        f58551l = arrayList;
    }

    /* renamed from: g */
    public static boolean m77004g(Bundle bundle) {
        return (bundle == null || TextUtils.isEmpty(bundle.getString("code", null))) ? false : true;
    }

    /* renamed from: h */
    public static byte[] m77005h(String str) {
        if (TextUtils.isEmpty(str)) {
            C12836o.m77099d("BaseUtil", "getUTF8Bytes, str is empty", true);
            return new byte[0];
        }
        try {
            return str.getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            C12836o.m77099d("BaseUtil", "getBytes error", true);
            return new byte[0];
        }
    }

    /* renamed from: i */
    public static int m77006i(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e10) {
            C12836o.m77099d("BaseUtil", "parseInt error " + e10.getClass().getSimpleName(), true);
            return -1;
        }
    }

    /* renamed from: j */
    public static String m77007j(Context context) {
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(m77012o(context))) {
            return m76981C(context) + "-" + m77000c(context).toUpperCase(Locale.getDefault());
        }
        return m76981C(context) + "-" + m77012o(context) + "-" + m77000c(context).toUpperCase(Locale.getDefault());
    }

    /* renamed from: l */
    public static void m77009l(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        m76998a(activity.getWindow(), "addPrivateFlags", new Object[]{Integer.valueOf(ARImageMetadata.LENS_APERTURE)}, new Class[]{Integer.TYPE});
    }

    /* renamed from: m */
    public static synchronized void m77010m(InterfaceC10596j interfaceC10596j) {
        f58540a = interfaceC10596j;
    }

    /* renamed from: n */
    public static boolean m77011n() {
        return C12829h.m77058c() || m77014q();
    }

    /* renamed from: o */
    public static String m77012o(Context context) {
        Locale locale;
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration == null || (locale = configuration.locale) == null) {
            return null;
        }
        return locale.getScript();
    }

    /* renamed from: p */
    public static Method m77013p(Object obj, String str, Object[] objArr, Class[] clsArr) {
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e10) {
                C12836o.m77097b("BaseUtil", e10.getClass().getSimpleName(), true);
            } catch (SecurityException e11) {
                C12836o.m77097b("BaseUtil", e11.getClass().getSimpleName(), true);
            }
        }
        return null;
    }

    /* renamed from: q */
    public static boolean m77014q() {
        return C12829h.m77059d() || m77017t();
    }

    /* renamed from: r */
    public static boolean m77015r(String str) throws ClassNotFoundException {
        try {
            Class.forName(str);
            C12836o.m77097b("BaseUtil", "isExsitOfClass", true);
            return true;
        } catch (ClassNotFoundException unused) {
            C12836o.m77099d("BaseUtil", "The class is not existing: ", true);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle m77016s(java.lang.String r3) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 1
            if (r0 != 0) goto L21
            r0 = 63
            int r0 = r3.indexOf(r0)
            if (r0 >= 0) goto L15
            r0 = 35
            int r0 = r3.indexOf(r0)
        L15:
            if (r0 <= 0) goto L21
            int r0 = r0 + r1
            java.lang.String r3 = com.huawei.secure.android.common.util.SafeString.substring(r3, r0)
            android.os.Bundle r3 = m76983E(r3)
            goto L22
        L21:
            r3 = 0
        L22:
            java.lang.String r0 = "BaseUtil"
            java.lang.String r2 = "parseUrl"
            p640sq.C12836o.m77097b(r0, r2, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p640sq.C12824c.m77016s(java.lang.String):android.os.Bundle");
    }

    /* renamed from: t */
    public static boolean m77017t() {
        return C12829h.m77060e();
    }

    /* renamed from: u */
    public static boolean m77018u(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo("com.tencent.mm", 0);
            C12836o.m77097b("BaseUtil", "WXApp Installed", true);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: v */
    public static int m77019v(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            C12836o.m77099d("BaseUtil", "NameNotFoundException getVersionTag error", true);
            return 0;
        }
    }

    /* renamed from: w */
    public static InterfaceC10596j m77020w() {
        return f58540a;
    }

    /* renamed from: x */
    public static synchronized void m77021x(String str) {
        f58549j = str;
    }

    /* renamed from: y */
    public static InterfaceC10596j m77022y() {
        return f58542c;
    }

    /* renamed from: z */
    public static void m77023z(String str) {
        f58550k = str;
    }
}
