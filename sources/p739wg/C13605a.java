package p739wg;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import p809yg.C13981a;

/* renamed from: wg.a */
/* loaded from: classes4.dex */
public class C13605a {
    /* renamed from: a */
    public static String m81793a(byte[] bArr) {
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

    /* renamed from: b */
    public static String m81794b(Context context) throws IOException {
        return context.getString(R$string.phonefinder_slave_state) + "c6a2731190bc8aef3bf031a46e0d3b3be1dac562a7d18f821e481f53445fe4f2729bf8c4907249dc65c151caae4096a6ff860be6f4af3c8dc588547a63ed48b7d85cd61ff0395665c84f6c419fe57b3f62dcafba230dad6f5d4a43aaf4ffded18515" + m81796d(context, "phoneFinderSetting");
    }

    /* renamed from: c */
    public static String m81795c(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null || TextUtils.isEmpty(str)) {
            C13981a.m83988e("KeyUtil", "getSignForPkgName: context or pkgName is null");
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                C13981a.m83988e("KeyUtil", "getSignForPkgName: packageManager is null");
                return "";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo == null) {
                C13981a.m83988e("KeyUtil", "getSignForPkgName: packageInfo is null");
                return "";
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null && signatureArr.length >= 1) {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
                if (x509Certificate == null) {
                    C13981a.m83988e("KeyUtil", "getSignForPkgName: cert is null");
                    return "";
                }
                PublicKey publicKey = x509Certificate.getPublicKey();
                if (publicKey != null) {
                    return m81793a(publicKey.getEncoded());
                }
                C13981a.m83988e("KeyUtil", "getSignForPkgName: publicKey is null");
                return "";
            }
            C13981a.m83988e("KeyUtil", "getSignForPkgName: signs is null or signs.length < 1");
            return "";
        } catch (PackageManager.NameNotFoundException e10) {
            C13981a.m83988e("KeyUtil", "getSignForPkgName: NameNotFoundException = " + e10.toString());
            return "";
        } catch (Exception e11) {
            C13981a.m83988e("KeyUtil", "getSignForPkgName: CertificateException = " + e11.toString());
            return "";
        }
    }

    /* renamed from: d */
    public static String m81796d(Context context, String str) throws IOException {
        String string = "";
        if (context == null || TextUtils.isEmpty(str)) {
            C13981a.m83988e("KeyUtil", "getSignFromAssets: context or fileName is null");
            return "";
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[40];
                    while (true) {
                        int i10 = inputStreamOpen.read(bArr);
                        if (i10 <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i10);
                    }
                    string = byteArrayOutputStream.toString("utf-8");
                    byteArrayOutputStream.close();
                    inputStreamOpen.close();
                } finally {
                }
            } finally {
            }
        } catch (Exception e10) {
            C13981a.m83988e("KeyUtil", "Assets Exception2" + e10.getMessage());
        }
        return string;
    }

    /* renamed from: e */
    public static boolean m81797e(Context context, String str) throws PackageManager.NameNotFoundException {
        String strM81795c = m81795c(context, str);
        return strM81795c.equals(m81794b(context)) || strM81795c.equals(m81795c(context, context.getPackageName()));
    }
}
