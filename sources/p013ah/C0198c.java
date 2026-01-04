package p013ah;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import mk.C11477c;
import p521og.C11877j;
import p521og.C11881n;
import p575qe.C12347f;
import p809yg.C13981a;

/* renamed from: ah.c */
/* loaded from: classes4.dex */
public class C0198c {
    /* renamed from: a */
    public static String m1097a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83990w("EncryptionUtils", "decryptCbc: st is empty");
            return null;
        }
        try {
            String strM68633c = C11477c.m68633c(str);
            if (!TextUtils.isEmpty(strM68633c)) {
                return strM68633c;
            }
            C13981a.m83990w("EncryptionUtils", "decodeStr is empty,use old decrypt way");
            byte[] bArrM1096a = C0197b.m1096a(str, m1099c(), 0);
            if (bArrM1096a != null) {
                return new String(bArrM1096a, Constants.UTF_8);
            }
            return null;
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "decryptCbc RuntimeException " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static String m1098b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83990w("EncryptionUtils", "encryptCbc: st is empty");
            return null;
        }
        try {
            return C11477c.m68636f(str);
        } catch (Exception e10) {
            C13981a.m83988e("EncryptionUtils", "encryptCbc Exception" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static byte[] m1099c() {
        return C11881n.m71352b(C11877j.m71290o(C12347f.m74285n().m74301m()));
    }
}
