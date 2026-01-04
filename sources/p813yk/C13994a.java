package p813yk;

import android.text.TextUtils;
import fk.C9721b;
import tm.C13040c;

/* renamed from: yk.a */
/* loaded from: classes6.dex */
public class C13994a {
    /* renamed from: a */
    public static String m84032a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String strM78619K = C13040c.m78609F().m78619K();
            String strM78618J = C13040c.m78609F().m78618J();
            if (TextUtils.isEmpty(strM78619K) || TextUtils.isEmpty(strM78618J) || strM78619K.equals(strM78618J) || !str.startsWith(strM78619K)) {
                return str;
            }
            String[] strArrSplit = str.split(strM78619K);
            if (strArrSplit.length <= 1) {
                return str;
            }
            return strM78618J + strArrSplit[1];
        } catch (C9721b | Exception unused) {
            return str;
        }
    }
}
