package p521og;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import java.math.BigDecimal;
import java.util.regex.Pattern;

/* renamed from: og.d */
/* loaded from: classes4.dex */
public class C11871d {

    /* renamed from: a */
    public static final Pattern f54925a = Pattern.compile("[0-9]+");

    /* renamed from: a */
    public static String m71158a(int i10) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < i10; i11++) {
            stringBuffer.append("*");
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static String m71159b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split(SplitAppUtil.SPLIT_APP_SUFFIX);
        return (strArrSplit.length != 2 || strArrSplit[0].length() <= 0 || strArrSplit[1].length() <= 0) ? !str.contains(SplitAppUtil.SPLIT_APP_SUFFIX) ? m71162e(str, 0.5d, 2, 5) : str : m71161d(strArrSplit[0], strArrSplit[1]);
    }

    /* renamed from: c */
    public static boolean m71160c(String str) {
        return f54925a.matcher(str).matches();
    }

    /* renamed from: d */
    public static String m71161d(String str, String str2) {
        String strM71162e = (str.length() <= 6 || !m71160c(str)) ? str.length() > 8 ? m71162e(str, 0.6d, 0, 3) : m71162e(str, 0.5d, 0, 3) : str.length() >= 8 ? m71162e(str, 0.6d, 4, 3) : m71162e(str, 0.5d, 3, 3);
        int iIntValue = new BigDecimal((str2.length() + 1) * 0.3d).setScale(0, 4).intValue();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strM71162e);
        stringBuffer.append(SplitAppUtil.SPLIT_APP_SUFFIX);
        for (int i10 = 0; i10 < str2.length(); i10++) {
            if (i10 < iIntValue) {
                stringBuffer.append("*");
            } else {
                stringBuffer.append(str2.charAt(i10));
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: e */
    public static String m71162e(String str, double d10, int i10, int i11) {
        if (str.length() < i11) {
            return "*****".substring(0, str.length());
        }
        int iIntValue = new BigDecimal(str.length() * d10).setScale(0, 4).intValue();
        if (iIntValue > str.length() - i10) {
            iIntValue = str.length() - i10;
        }
        int length = (str.length() - i10) - iIntValue;
        int length2 = str.length() - i10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) str, 0, length);
        sb2.append(m71158a(iIntValue));
        sb2.append(str.substring(length2));
        return sb2.toString();
    }
}
