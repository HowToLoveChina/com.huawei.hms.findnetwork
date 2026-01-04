package p713vo;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.util.SafeBase64;
import fk.C9721b;
import lk.C11305b;
import lk.C11306c;
import p514o9.C11839m;
import p782xo.C13842a;

/* renamed from: vo.a */
/* loaded from: classes6.dex */
public class C13473a {
    /* renamed from: a */
    public static String m81138a(String str, String str2) throws Exception {
        byte[] bArrDecode = SafeBase64.decode(str2, 0);
        if (bArrDecode == null || bArrDecode.length == 0) {
            C11839m.m70687e("STUtil", "decrypt decodeKey is empty");
            return "";
        }
        byte[] bArrM67867a = C11305b.m67867a(C11306c.m67869a(str), bArrDecode);
        if (bArrM67867a != null && bArrM67867a.length != 0) {
            return new String(bArrM67867a, Constants.UTF_8);
        }
        C11839m.m70687e("STUtil", "strBytes is empty");
        return "";
    }

    /* renamed from: b */
    public static String m81139b(String str, String str2) throws C9721b {
        String strM83034m = C13842a.m83010i().m83034m(str2);
        if (TextUtils.isEmpty(strM83034m)) {
            throw new C9721b(4005, "ByNow cbc key is empty");
        }
        try {
            return m81138a(str, strM83034m);
        } catch (Exception e10) {
            C11839m.m70687e("STUtil", "encrypt exception: " + e10.toString());
            return "";
        }
    }
}
