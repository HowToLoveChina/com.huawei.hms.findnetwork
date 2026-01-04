package p699v4;

import android.net.Uri;
import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: v4.p */
/* loaded from: classes.dex */
public class C13347p {
    /* renamed from: a */
    public static String m80078a(String str) {
        if (str == null) {
            C2111d.m12648d("UriHelper", "parse uriString is null");
            return "";
        }
        Uri uriM80079b = m80079b(str);
        return uriM80079b != null ? uriM80079b.getLastPathSegment() : "";
    }

    /* renamed from: b */
    public static Uri m80079b(String str) {
        if (str != null) {
            return Uri.parse(str);
        }
        C2111d.m12648d("UriHelper", "parse uriString is null");
        return null;
    }

    /* renamed from: c */
    public static Uri m80080c(Uri uri, String str) {
        if (uri != null) {
            return Uri.withAppendedPath(uri, str);
        }
        C2111d.m12648d("UriHelper", "withAppendedPath baseUri is null");
        return null;
    }
}
