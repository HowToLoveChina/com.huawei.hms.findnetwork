package es;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.LruCache;
import as.C1016d;
import com.huawei.location.lite.common.android.receiver.PackageReceiver;
import com.huawei.secure.android.common.util.SafeString;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import p531or.C11991a;
import pr.InterfaceC12209b;

/* renamed from: es.a */
/* loaded from: classes8.dex */
public class C9536a {

    /* renamed from: a */
    public static LruCache<String, b> f47422a;

    /* renamed from: es.a$a */
    public class a implements InterfaceC12209b {
        @Override // pr.InterfaceC12209b
        /* renamed from: a */
        public void mo59557a(String str) {
            C9536a.m59556p(str);
        }

        @Override // pr.InterfaceC12209b
        /* renamed from: b */
        public void mo59558b(String str) {
        }

        @Override // pr.InterfaceC12209b
        /* renamed from: c */
        public void mo59559c(String str) {
            C9536a.m59556p(str);
        }
    }

    /* renamed from: es.a$b */
    public static class b {

        /* renamed from: a */
        public long f47423a = -1;

        /* renamed from: b */
        public String f47424b;

        /* renamed from: c */
        public String f47425c;

        /* renamed from: d */
        public int f47426d;

        /* renamed from: e */
        public int f47427e;

        /* renamed from: f */
        public int f47428f;

        /* renamed from: g */
        public int f47429g;

        /* renamed from: h */
        public Signature f47430h;
    }

    static {
        PackageReceiver.m38376g().m38381i(new a());
    }

    /* renamed from: b */
    public static synchronized b m59542b(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            C1016d.m6181a("APKUtil", "package name is empty");
            return new b();
        }
        if (f47422a == null) {
            f47422a = new LruCache<>(4);
        }
        b bVarM59545e = f47422a.get(str);
        if (bVarM59545e != null) {
            C1016d.m6181a("APKUtil", "getPackageInfo From Cache");
            if (i10 == 1) {
                if (bVarM59545e.f47426d <= 0) {
                    bVarM59545e = m59545e(bVarM59545e, str, i10);
                }
                return bVarM59545e;
            }
            if (i10 == 64) {
                if (TextUtils.isEmpty(bVarM59545e.f47425c)) {
                    bVarM59545e = m59545e(bVarM59545e, str, i10);
                }
                return bVarM59545e;
            }
            if (i10 == 16384) {
                if (bVarM59545e.f47423a <= 0) {
                    bVarM59545e = m59545e(bVarM59545e, str, i10);
                }
                return bVarM59545e;
            }
        }
        return m59545e(bVarM59545e, str, i10);
    }

    /* renamed from: c */
    public static long m59543c(Context context) {
        if (context == null) {
            return -1L;
        }
        return m59553m(context.getPackageName());
    }

    /* renamed from: d */
    public static long m59544d() {
        return m59551k("com.huawei.lbs");
    }

    /* renamed from: e */
    public static b m59545e(b bVar, String str, int i10) throws PackageManager.NameNotFoundException {
        String str2;
        PackageInfo packageInfo;
        PackageManager packageManager = C11991a.m72145a().getPackageManager();
        if (bVar == null) {
            bVar = new b();
        }
        try {
            C1016d.m6181a("APKUtil", "getPackageInfo From PackageManager");
            packageInfo = packageManager.getPackageInfo(str, i10);
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "NameNotFoundException!";
            C1016d.m6181a("APKUtil", str2);
            return bVar;
        } catch (Exception unused2) {
            str2 = "Package  manager  has  died Exception";
            C1016d.m6181a("APKUtil", str2);
            return bVar;
        }
        if (packageInfo == null) {
            return bVar;
        }
        if (i10 == 1) {
            bVar.f47426d = packageInfo.applicationInfo.uid;
        } else if (i10 == 64) {
            bVar.f47430h = !C9537b.m59561b(packageInfo.signatures) ? packageInfo.signatures[0] : null;
            bVar.f47425c = m59547g(packageInfo.signatures);
        } else if (i10 == 16384) {
            bVar.f47424b = packageInfo.versionName;
            bVar.f47423a = packageInfo.getLongVersionCode();
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            bVar.f47427e = applicationInfo.targetSdkVersion;
            bVar.f47429g = applicationInfo.labelRes;
            bVar.f47428f = applicationInfo.flags;
        }
        if (i10 != 64) {
            f47422a.put(str, bVar);
        }
        return bVar;
    }

    /* renamed from: f */
    public static String m59546f(String str) {
        return m59555o(str);
    }

    /* renamed from: g */
    public static String m59547g(Signature[] signatureArr) {
        String str;
        if (C9537b.m59561b(signatureArr)) {
            str = "signatures is empty!";
        } else {
            try {
                return m59549i(signatureArr[0]);
            } catch (NoSuchAlgorithmException unused) {
                str = "NoSuchAlgorithmException!";
            }
        }
        C1016d.m6181a("APKUtil", str);
        return null;
    }

    /* renamed from: h */
    public static String m59548h(String str) {
        return m59542b(str, 64).f47425c;
    }

    /* renamed from: i */
    public static String m59549i(Signature signature) throws NoSuchAlgorithmException {
        byte[] bArrDigest = MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArrDigest) {
            sb2.append(SafeString.substring(Integer.toHexString((b10 & 255) | 256), 1, 3).toUpperCase(Locale.ROOT));
        }
        return sb2.toString();
    }

    /* renamed from: j */
    public static int m59550j(String str) {
        return m59542b(str, 16384).f47427e;
    }

    /* renamed from: k */
    public static long m59551k(String str) {
        return m59553m(str);
    }

    /* renamed from: l */
    public static int m59552l(String str) {
        if (str != null && !str.isEmpty()) {
            return m59542b(str, 1).f47426d;
        }
        C1016d.m6181a("APKUtil", "packageName is empty, return -1");
        return -1;
    }

    /* renamed from: m */
    public static long m59553m(String str) {
        return m59542b(str, 16384).f47423a;
    }

    /* renamed from: n */
    public static String m59554n() {
        return m59555o(C11991a.m72145a().getPackageName());
    }

    /* renamed from: o */
    public static String m59555o(String str) {
        return m59542b(str, 16384).f47424b;
    }

    /* renamed from: p */
    public static void m59556p(String str) {
        if (f47422a.get(str) != null) {
            f47422a.remove(str);
        }
    }
}
