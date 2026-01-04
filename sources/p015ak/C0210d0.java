package p015ak;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;
import mk.C11476b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p399jk.AbstractC10896a;

/* renamed from: ak.d0 */
/* loaded from: classes6.dex */
public class C0210d0 {

    /* renamed from: ak.d0$b */
    public static class b {

        /* renamed from: a */
        public static C0210d0 f793a = new C0210d0();
    }

    /* renamed from: a */
    public static String m1335a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            cArr2[i11] = cArr[(b10 >>> 4) & 15];
            cArr2[i11 + 1] = cArr[b10 & BaseType.Obj];
        }
        return new String(cArr2);
    }

    /* renamed from: d */
    public static String m1336d(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        Signature[] apkContentsSigners;
        if (context == null || TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            if (packageInfo != null && (apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners()) != null && apkContentsSigners.length > 0) {
                Signature signature = apkContentsSigners[0];
                if (signature != null) {
                    return C11476b.m68627i(signature.toByteArray()).toUpperCase(Locale.ENGLISH);
                }
                AbstractC10896a.m65886e("SignatureChecker", "getAppSha256 sign is null.");
                return "";
            }
            return null;
        } catch (Exception unused) {
            AbstractC10896a.m65886e("SignatureChecker", str + " not found");
            return null;
        }
    }

    /* renamed from: e */
    public static String m1337e(Context context, String str) throws JSONException, PackageManager.NameNotFoundException {
        if (context == null) {
            AbstractC10896a.m65886e("SignatureChecker", "getBackAppSignsSha256: context is null");
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            AbstractC10896a.m65886e("SignatureChecker", "getBackAppSignsSha256: packageManager is null");
            return "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo == null) {
                AbstractC10896a.m65886e("SignatureChecker", "getBackAppSignsSha256: packageInfo is null");
                return "";
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null && signatureArr.length != 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < signatureArr.length && i10 < 3; i10++) {
                    JSONObject jSONObject = new JSONObject();
                    String strM1340h = m1340h(signatureArr[i10]);
                    if (!TextUtils.isEmpty(strM1340h)) {
                        jSONObject.put("index", String.valueOf(i10));
                        jSONObject.put(HwPayConstant.KEY_SIGN, strM1340h);
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray.toString();
            }
            AbstractC10896a.m65886e("SignatureChecker", "getBackAppSignsSha256: signs is null or signs.length < 1");
            return "";
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SignatureChecker", "getBackAppSignsSha256 error: " + e10.toString());
            return "";
        }
    }

    /* renamed from: f */
    public static C0210d0 m1338f() {
        return b.f793a;
    }

    /* renamed from: g */
    public static String m1339g(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null || TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("SignatureChecker", "getSignForPkgName context or pkgName is null");
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                AbstractC10896a.m65886e("SignatureChecker", "getSignForPkgName packageManager is null");
                return "";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo == null) {
                AbstractC10896a.m65886e("SignatureChecker", "getSignForPkgName packageInfo is null");
                return "";
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null && signatureArr.length >= 1) {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
                if (x509Certificate == null) {
                    AbstractC10896a.m65886e("SignatureChecker", "getSignForPkgName cert is null");
                    return "";
                }
                PublicKey publicKey = x509Certificate.getPublicKey();
                if (publicKey != null) {
                    return m1335a(publicKey.getEncoded());
                }
                AbstractC10896a.m65886e("SignatureChecker", "getSignForPkgName publicKey is null");
                return "";
            }
            AbstractC10896a.m65886e("SignatureChecker", "getSignForPkgName signs is null or signs.length < 1");
            return "";
        } catch (PackageManager.NameNotFoundException e10) {
            AbstractC10896a.m65886e("SignatureChecker", "getSignForPkgName NameNotFoundException = " + e10.toString());
            return "";
        } catch (RuntimeException e11) {
            AbstractC10896a.m65886e("SignatureChecker", "getSignForPkgName RuntimeException = " + e11.toString());
            return "";
        } catch (CertificateException e12) {
            AbstractC10896a.m65886e("SignatureChecker", "getSignForPkgName CertificateException = " + e12.toString());
            return "";
        }
    }

    /* renamed from: h */
    public static String m1340h(Signature signature) {
        if (signature != null) {
            return C11476b.m68626h(signature.toCharsString());
        }
        AbstractC10896a.m65886e("SignatureChecker", "tranSignToSha256 sign is null.");
        return "";
    }

    /* renamed from: b */
    public boolean m1341b(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return str2.equals(m1336d(context, str));
        }
        AbstractC10896a.m65886e("SignatureChecker", "checkPkgNameAndSign params is null");
        return false;
    }

    /* renamed from: c */
    public boolean m1342c(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        if (context == null) {
            AbstractC10896a.m65886e("SignatureChecker", "check context null");
            return false;
        }
        String strM1339g = m1339g(context, str);
        String strM1339g2 = m1339g(context, str2);
        if (!TextUtils.isEmpty(strM1339g) && !TextUtils.isEmpty(strM1339g2)) {
            return strM1339g.equals(strM1339g2);
        }
        AbstractC10896a.m65886e("SignatureChecker", "currentSign or checksign empty");
        return false;
    }

    public C0210d0() {
    }
}
