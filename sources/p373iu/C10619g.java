package p373iu;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import p435ku.C11155a;
import p435ku.C11156b;
import p435ku.C11160f;

/* renamed from: iu.g */
/* loaded from: classes5.dex */
public class C10619g {

    /* renamed from: a */
    public static final String f51062a = "SecureX509SingleInstance";

    /* renamed from: b */
    public static volatile SecureX509TrustManager f51063b;

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static SecureX509TrustManager m65081a(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        InputStream inputStreamOpen;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        C11156b.m67082a(context);
        if (f51063b == null) {
            synchronized (C10619g.class) {
                if (f51063b == null) {
                    try {
                        inputStreamOpen = C11155a.m67081d(context);
                    } catch (RuntimeException unused) {
                        C11160f.m67095d(f51062a, "get files bks error");
                        inputStreamOpen = null;
                    }
                    if (inputStreamOpen == null) {
                        C11160f.m67096e(f51062a, "get assets bks");
                        inputStreamOpen = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        C11160f.m67096e(f51062a, "get files bks");
                    }
                    f51063b = new SecureX509TrustManager(inputStreamOpen, "");
                }
            }
        }
        C11160f.m67093b(f51062a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f51063b;
    }
}
