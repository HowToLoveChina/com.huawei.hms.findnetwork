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

/* renamed from: iu.b */
/* loaded from: classes5.dex */
public class C10614b {

    /* renamed from: a */
    public static final String f51026a = "SSFSecureX509SingleInstance";

    /* renamed from: b */
    public static volatile SecureX509TrustManager f51027b;

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static SecureX509TrustManager m65061a(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        C11156b.m67082a(context);
        if (f51027b == null) {
            synchronized (C10614b.class) {
                try {
                    if (f51027b == null) {
                        InputStream inputStreamM67081d = C11155a.m67081d(context);
                        if (inputStreamM67081d == null) {
                            C11160f.m67096e(f51026a, "get assets bks");
                            inputStreamM67081d = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            C11160f.m67096e(f51026a, "get files bks");
                        }
                        f51027b = new SecureX509TrustManager(inputStreamM67081d, "", true);
                    }
                } finally {
                }
            }
        }
        return f51027b;
    }
}
