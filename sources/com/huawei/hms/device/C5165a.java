package com.huawei.hms.device;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.hms.device.a */
/* loaded from: classes8.dex */
public class C5165a {
    /* renamed from: a */
    public static boolean m30782a(X509Certificate x509Certificate, List<X509Certificate> list) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (list == null || list.size() == 0) {
            HMSLog.m36986e(C5335e.f24725a, "certChain is null,verify failed ");
            return false;
        }
        if (x509Certificate == null) {
            HMSLog.m36986e(C5335e.f24725a, "rootCert is null,verify failed ");
            return false;
        }
        PublicKey publicKey = x509Certificate.getPublicKey();
        for (X509Certificate x509Certificate2 : list) {
            if (x509Certificate2 != null) {
                try {
                    x509Certificate2.checkValidity();
                    x509Certificate2.verify(publicKey);
                    publicKey = x509Certificate2.getPublicKey();
                } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e10) {
                    HMSLog.m36986e(C5335e.f24725a, "verify failed " + e10.getMessage());
                }
            }
            return false;
        }
        return m30784a(list);
    }

    /* renamed from: b */
    public static List<X509Certificate> m30786b(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            X509Certificate x509CertificateM30777a = m30777a(it.next());
            if (x509CertificateM30777a != null) {
                arrayList.add(x509CertificateM30777a);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private static List<String> m30789c(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 1) {
                return Collections.emptyList();
            }
            int length = jSONArray.length();
            if (jSONArray.length() > 3) {
                length = 3;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(jSONArray.getString(i10));
            }
            return arrayList;
        } catch (JSONException e10) {
            HMSLog.m36986e(C5335e.f24725a, "Failed to getCertChain: " + e10.getMessage());
            return Collections.emptyList();
        }
    }

    /* renamed from: b */
    public static List<X509Certificate> m30785b(String str) {
        return m30786b(m30789c(str));
    }

    /* renamed from: b */
    public static boolean m30788b(X509Certificate x509Certificate, String str, String str2) {
        if (x509Certificate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(m30775a(x509Certificate.getSubjectDN().getName(), str));
    }

    /* renamed from: b */
    public static boolean m30787b(X509Certificate x509Certificate, String str) {
        return m30788b(x509Certificate, C5335e.f24728d, str);
    }

    /* renamed from: a */
    public static X509Certificate m30777a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return m30778a(Base64.decode(str));
        } catch (IllegalArgumentException e10) {
            HMSLog.m36986e(C5335e.f24725a, "getCert failed : " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static X509Certificate m30778a(byte[] bArr) throws CertificateException {
        Certificate certificateGenerateCertificate;
        if (bArr == null) {
            HMSLog.m36986e(C5335e.f24725a, "Failed to get cert, params is invalid.");
            return null;
        }
        try {
            certificateGenerateCertificate = CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(new ByteArrayInputStream(bArr));
        } catch (CertificateException e10) {
            HMSLog.m36986e(C5335e.f24725a, "Failed to get cert: " + e10.getMessage());
        }
        if (certificateGenerateCertificate instanceof X509Certificate) {
            return (X509Certificate) certificateGenerateCertificate;
        }
        HMSLog.m36986e(C5335e.f24725a, "Failed to get cert, certificate is invalid.");
        return null;
    }

    /* renamed from: a */
    private static String m30775a(String str, String str2) {
        int iIndexOf = str.toUpperCase(Locale.getDefault()).indexOf(str2 + "=");
        if (iIndexOf == -1) {
            return null;
        }
        int iIndexOf2 = str.indexOf(",", iIndexOf);
        if (iIndexOf2 != -1) {
            return str.substring(iIndexOf + str2.length() + 1, iIndexOf2);
        }
        return str.substring(iIndexOf + str2.length() + 1);
    }

    /* renamed from: a */
    public static boolean m30779a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (5 < keyUsage.length) {
            return keyUsage[5];
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m30784a(List<X509Certificate> list) {
        for (int i10 = 0; i10 < list.size() - 1; i10++) {
            if (!m30779a(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m30780a(X509Certificate x509Certificate, String str) {
        return m30788b(x509Certificate, "CN", str);
    }

    /* renamed from: a */
    public static boolean m30781a(X509Certificate x509Certificate, String str, String str2) {
        try {
            return m30783a(x509Certificate, str.getBytes(Constants.UTF_8), Base64.decode(str2));
        } catch (UnsupportedEncodingException | IllegalArgumentException e10) {
            HMSLog.m36986e(C5335e.f24725a, " plainText exception: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m30783a(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        try {
            Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
            signature.initVerify(x509Certificate.getPublicKey());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e10) {
            HMSLog.m36986e(C5335e.f24725a, "failed checkSignature : " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static X509Certificate m30776a(Context context) throws IOException {
        byte[] assetsFile = IOUtils.readAssetsFile(context.getAssets(), "base_hms_app_root.cer");
        if (assetsFile != null && assetsFile.length != 0) {
            return m30778a(assetsFile);
        }
        HMSLog.m36986e(C5335e.f24725a, "Get root cert is invalid.");
        HMSPackageManager.getInstance(context).setUseOldCertificate(true);
        return null;
    }
}
