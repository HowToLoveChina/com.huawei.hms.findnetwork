package p795y1;

import android.net.Uri;
import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: y1.b */
/* loaded from: classes.dex */
public final class C13902b {
    /* renamed from: a */
    public static boolean m83313a(Uri uri) {
        return m83314b(uri) && !m83317e(uri);
    }

    /* renamed from: b */
    public static boolean m83314b(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* renamed from: c */
    public static boolean m83315c(Uri uri) {
        return m83314b(uri) && m83317e(uri);
    }

    /* renamed from: d */
    public static boolean m83316d(int i10, int i11) {
        return i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE && i10 <= 512 && i11 <= 384;
    }

    /* renamed from: e */
    public static boolean m83317e(Uri uri) {
        return uri.getPathSegments().contains(Constants.VIDEO_SUB_DIR);
    }
}
