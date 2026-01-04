package p250e7;

import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Locale;

/* renamed from: e7.c */
/* loaded from: classes2.dex */
public class C9421c {
    /* renamed from: a */
    public static String m59091a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (i10 % 2 != 0) {
                charArray[i10] = '*';
            }
        }
        return new String(charArray);
    }

    /* renamed from: b */
    public static String m59092b(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    /* renamed from: c */
    public static boolean m59093c(String str, boolean z10) {
        return !z10 ? str.equals("zh") || str.equals(FaqConstants.DEFAULT_ISO_LANGUAGE) || str.equals("zz") : str.equals(HNConstants.Language.CN_STANDARD) || str.equals("zh");
    }
}
