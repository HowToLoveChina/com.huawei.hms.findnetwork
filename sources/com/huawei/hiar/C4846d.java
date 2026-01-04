package com.huawei.hiar;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.huawei.hiar.d */
/* loaded from: classes5.dex */
public class C4846d {

    /* renamed from: a */
    public static final String f22043a = "d";

    /* renamed from: a */
    public static Signature m29084a(Context context, String str) throws PackageManager.NameNotFoundException {
        Signature[] signatureArrM29086c = m29086c(context, str);
        if (signatureArrM29086c == null || signatureArrM29086c.length <= 0) {
            return null;
        }
        return signatureArrM29086c[0];
    }

    /* renamed from: b */
    public static boolean m29085b(Signature signature, String str) {
        String str2;
        String str3;
        if (signature == null && str == null) {
            Log.e(f22043a, "checkSignature serverSignature and localSignature null!");
            return true;
        }
        if (signature == null) {
            str2 = f22043a;
            str3 = "checkSignature serverSignature null!";
        } else {
            if (str != null) {
                return str.equals(signature.toCharsString());
            }
            str2 = f22043a;
            str3 = "checkSignature localSignature null!";
        }
        Log.e(str2, str3);
        return false;
    }

    /* renamed from: c */
    public static Signature[] m29086c(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null || str == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            Log.e(f22043a, "getPackageManager fail!");
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            SigningInfo signingInfo = packageInfo != null ? packageInfo.signingInfo : null;
            if (signingInfo != null) {
                return signingInfo.getApkContentsSigners();
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(f22043a, "getSignature Name not found");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* renamed from: d */
    public static String m29087d(Context context, String str) throws Throwable {
        InputStream inputStreamOpen;
        ?? r02 = 0;
        try {
            if (context == null) {
                return null;
            }
            try {
                inputStreamOpen = context.getAssets().open(str);
            } catch (IOException unused) {
                inputStreamOpen = null;
            } catch (Throwable th2) {
                th = th2;
                C4847e.m29088a(r02);
                throw th;
            }
            try {
                byte[] bArr = new byte[inputStreamOpen.available()];
                if (inputStreamOpen.read(bArr) < 0) {
                    C4847e.m29088a(inputStreamOpen);
                    return null;
                }
                String str2 = new String(bArr, Constants.UTF_8);
                C4847e.m29088a(inputStreamOpen);
                return str2;
            } catch (IOException unused2) {
                Log.e(f22043a, "getSignatureFromCertificate IOException!");
                C4847e.m29088a(inputStreamOpen);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            r02 = context;
        }
    }
}
