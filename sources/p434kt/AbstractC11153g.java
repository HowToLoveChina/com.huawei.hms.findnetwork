package p434kt;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

/* renamed from: kt.g */
/* loaded from: classes2.dex */
public abstract class AbstractC11153g {
    /* renamed from: a */
    public static String m67071a(String str) {
        int i10;
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf >= 0 && (i10 = iLastIndexOf + 1) < str.length()) {
            str = str.substring(i10);
        }
        int length = str.length();
        if (length > 3) {
            return str.substring(0, 3) + Constants.CONFUSION_CHARS;
        }
        if (length <= 1) {
            return Constants.CONFUSION_CHARS;
        }
        return str.substring(0, length - 1) + Constants.CONFUSION_CHARS;
    }

    /* renamed from: b */
    public static String m67072b(String str, Object[] objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: c */
    public static String m67073c(String str) {
        String strSubstring;
        StringBuilder sb2 = new StringBuilder();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme != null) {
            sb2.append(scheme);
            sb2.append("://");
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            try {
                lastPathSegment = new URL(str).getHost();
            } catch (MalformedURLException unused) {
                lastPathSegment = Uri.parse(str.replaceAll(SplitAppUtil.SPLIT_APP_SUFFIX, "")).getHost();
            }
        } else {
            sb2.append(Constants.CONFUSION_CHARS);
            sb2.append(C5929g4.f26852n);
        }
        if (lastPathSegment != null) {
            int length = lastPathSegment.length();
            if (length > 3) {
                strSubstring = lastPathSegment.substring(0, 3);
            } else if (length > 1) {
                strSubstring = lastPathSegment.substring(0, length - 1);
            }
            sb2.append(strSubstring);
        }
        sb2.append(Constants.CONFUSION_CHARS);
        return sb2.toString();
    }

    /* renamed from: d */
    public static String m67074d(String str) {
        return TextUtils.isEmpty(str) ? "" : str.contains("://") ? m67073c(str) : m67071a(str);
    }
}
