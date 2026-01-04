package bi;

import android.text.TextUtils;
import ci.C1441b;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: bi.c */
/* loaded from: classes4.dex */
public class C1246c {
    /* renamed from: a */
    public static String m7450a(String str, String str2) {
        int iIndexOf = str.toUpperCase(Locale.getDefault()).indexOf(str2 + "=");
        if (iIndexOf == -1) {
            return null;
        }
        int iIndexOf2 = str.indexOf(",", iIndexOf);
        int length = iIndexOf + str2.length() + 1;
        return iIndexOf2 != -1 ? str.substring(length, iIndexOf2) : str.substring(length);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.cert.X509Certificate m7451b(android.content.Context r4) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            java.lang.String r0 = "X509CertUtil"
            android.content.pm.PackageManager r1 = r4.getPackageManager()
            r2 = 0
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Exception -> L12 android.content.pm.PackageManager.NameNotFoundException -> L14
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r4 = r1.getApplicationInfo(r4, r3)     // Catch: java.lang.Exception -> L12 android.content.pm.PackageManager.NameNotFoundException -> L14
            goto L24
        L12:
            r4 = move-exception
            goto L16
        L14:
            r4 = move-exception
            goto L1e
        L16:
            ci.b r1 = ci.C1441b.f6211b
            java.lang.String r3 = "PackageInfo with Exception:"
        L1a:
            r1.m8285b(r0, r3, r4)
            goto L23
        L1e:
            ci.b r1 = ci.C1441b.f6211b
            java.lang.String r3 = "PackageInfo with NameNotFoundException:"
            goto L1a
        L23:
            r4 = r2
        L24:
            if (r4 == 0) goto L48
            android.os.Bundle r4 = r4.metaData
            if (r4 != 0) goto L32
            ci.b r4 = ci.C1441b.f6211b
            java.lang.String r1 = "failed getCBGRootCA metaData is null"
        L2e:
            r4.m8284a(r0, r1)
            return r2
        L32:
            java.lang.String r1 = "componentverify_ag_cbg_root"
            java.lang.String r4 = r4.getString(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L43
            ci.b r4 = ci.C1441b.f6211b
            java.lang.String r1 = "failed getCBGRootCA sdkCbgRoot is null"
            goto L2e
        L43:
            java.security.cert.X509Certificate r4 = m7452c(r4)
            return r4
        L48:
            ci.b r4 = ci.C1441b.f6211b
            java.lang.String r1 = "failed getCBGRootCA packageInfo is null"
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: bi.C1246c.m7451b(android.content.Context):java.security.cert.X509Certificate");
    }

    /* renamed from: c */
    public static X509Certificate m7452c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m7453d(C1244a.m7445a(str));
    }

    /* renamed from: d */
    public static X509Certificate m7453d(byte[] bArr) throws CertificateException {
        if (bArr != null && bArr.length != 0) {
            try {
                Certificate certificateGenerateCertificate = CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(new ByteArrayInputStream(bArr));
                if (certificateGenerateCertificate instanceof X509Certificate) {
                    return (X509Certificate) certificateGenerateCertificate;
                }
            } catch (CertificateException e10) {
                C1441b.f6211b.m8284a(C5335e.f24725a, "Failed to get cert: " + e10.getMessage());
            }
        }
        return null;
    }

    /* renamed from: e */
    public static boolean m7454e(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (keyUsage.length <= 5) {
            return false;
        }
        return keyUsage[5];
    }

    /* renamed from: f */
    public static boolean m7455f(X509Certificate x509Certificate, String str) {
        return m7456g(x509Certificate, "CN", str);
    }

    /* renamed from: g */
    public static boolean m7456g(X509Certificate x509Certificate, String str, String str2) {
        if (x509Certificate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(m7450a(x509Certificate.getSubjectDN().getName(), str));
    }

    /* renamed from: h */
    public static boolean m7457h(X509Certificate x509Certificate, List<X509Certificate> list) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (list != null && list.size() != 0) {
            if (x509Certificate == null) {
                C1441b.f6211b.m8284a(C5335e.f24725a, "rootCert is null,verify failed ");
                return false;
            }
            try {
                x509Certificate.checkValidity();
                PublicKey publicKey = x509Certificate.getPublicKey();
                for (int size = list.size() - 1; size >= 0; size--) {
                    X509Certificate x509Certificate2 = list.get(size);
                    if (x509Certificate2 != null) {
                        try {
                            x509Certificate2.verify(publicKey);
                            x509Certificate2.checkValidity();
                            publicKey = x509Certificate2.getPublicKey();
                        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e10) {
                            C1441b.f6211b.m8284a(C5335e.f24725a, "verify failed " + e10.getMessage());
                        }
                    }
                    return false;
                }
                return m7459j(list);
            } catch (CertificateExpiredException | CertificateNotYetValidException e11) {
                C1441b.f6211b.m8284a(C5335e.f24725a, "verifyCertChain Exception:" + e11.getMessage());
            }
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m7458i(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (x509Certificate == null || bArr == null || bArr2 == null || bArr2.length == 0) {
            C1441b.f6211b.m8287d(C5335e.f24725a, "checkSignature parameter is null");
            return false;
        }
        try {
            Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
            signature.initVerify(x509Certificate.getPublicKey());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e10) {
            C1441b.f6211b.m8285b(C5335e.f24725a, "failed checkSignature,Exception:", e10);
            return false;
        }
    }

    /* renamed from: j */
    public static boolean m7459j(List<X509Certificate> list) {
        for (int i10 = 1; i10 < list.size(); i10++) {
            if (!m7454e(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public static List<X509Certificate> m7460k(String str) {
        return m7461l(m7463n(str));
    }

    /* renamed from: l */
    public static List<X509Certificate> m7461l(List<String> list) {
        if (list == null) {
            C1441b.f6211b.m8287d(C5335e.f24725a, "base64 CertChain is null.");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            X509Certificate x509CertificateM7452c = m7452c(it.next());
            if (x509CertificateM7452c == null) {
                C1441b.f6211b.m8284a(C5335e.f24725a, "Failed to get cert from CertChain");
            } else {
                arrayList.add(x509CertificateM7452c);
            }
        }
        return arrayList;
    }

    /* renamed from: m */
    public static boolean m7462m(X509Certificate x509Certificate, String str) {
        return m7456g(x509Certificate, C5335e.f24728d, str);
    }

    /* renamed from: n */
    public static List<String> m7463n(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 1) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                arrayList.add(jSONArray.getString(i10));
            }
            return arrayList;
        } catch (JSONException unused) {
            C1441b.f6211b.m8284a(C5335e.f24725a, "Failed to getCertChain: ");
            return Collections.emptyList();
        }
    }
}
