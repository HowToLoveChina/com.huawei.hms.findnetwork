package p386j6;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.ArrayList;

/* renamed from: j6.c */
/* loaded from: classes.dex */
public class C10713c {
    /* renamed from: a */
    public static boolean m65391a(Bundle bundle, String str) {
        return m65392b(bundle, str, false);
    }

    /* renamed from: b */
    public static boolean m65392b(Bundle bundle, String str, boolean z10) {
        if (bundle == null || !bundle.containsKey(str)) {
            return z10;
        }
        try {
            return bundle.getBoolean(str, z10);
        } catch (BadParcelableException | IllegalArgumentException unused) {
            C2111d.m12649e("BundleUtils", "Bundle bad name :", str);
            return z10;
        }
    }

    /* renamed from: c */
    public static Bundle m65393c(Bundle bundle, String str) {
        if (bundle != null && bundle.containsKey(str)) {
            try {
                return bundle.getBundle(str);
            } catch (BadParcelableException | IllegalArgumentException unused) {
                C2111d.m12649e("BundleUtils", "getSafeBundle failed, key = ", str);
            }
        }
        return null;
    }

    /* renamed from: d */
    public static int m65394d(Bundle bundle, String str) {
        return m65395e(bundle, str, 0);
    }

    /* renamed from: e */
    public static int m65395e(Bundle bundle, String str, int i10) {
        if (bundle == null || !bundle.containsKey(str)) {
            return i10;
        }
        try {
            return bundle.getInt(str, i10);
        } catch (BadParcelableException | IllegalArgumentException unused) {
            C2111d.m12649e("BundleUtils", "Bundle bad name :", str);
            return i10;
        }
    }

    /* renamed from: f */
    public static long m65396f(Bundle bundle, String str) {
        return m65397g(bundle, str, 0L);
    }

    /* renamed from: g */
    public static long m65397g(Bundle bundle, String str, long j10) {
        if (bundle == null || !bundle.containsKey(str)) {
            return j10;
        }
        try {
            return bundle.getLong(str, j10);
        } catch (BadParcelableException | IllegalArgumentException unused) {
            C2111d.m12649e("BundleUtils", "Bundle bad name :", str);
            return j10;
        }
    }

    /* renamed from: h */
    public static <T extends Parcelable> T m65398h(Bundle bundle, String str) {
        if (bundle != null && bundle.containsKey(str)) {
            try {
                return (T) bundle.getParcelable(str);
            } catch (BadParcelableException | IllegalArgumentException unused) {
                C2111d.m12649e("BundleUtils", "getSafeParcelable failed, key = ", str);
            }
        }
        return null;
    }

    /* renamed from: i */
    public static int m65399i(Bundle bundle) {
        if (bundle == null) {
            return 0;
        }
        try {
            return bundle.size();
        } catch (BadParcelableException unused) {
            C2111d.m12648d("BundleUtils", "getSafeSize BadParcelableException");
            return 0;
        }
    }

    /* renamed from: j */
    public static String m65400j(Bundle bundle, String str) {
        if (bundle == null || !bundle.containsKey(str)) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (BadParcelableException | IllegalArgumentException unused) {
            C2111d.m12649e("BundleUtils", "Bundle bad name :", str);
            return null;
        }
    }

    /* renamed from: k */
    public static ArrayList<String> m65401k(Bundle bundle, String str) {
        ArrayList<String> stringArrayList;
        if (bundle == null) {
            return new ArrayList<>(0);
        }
        if (bundle.containsKey(str)) {
            try {
                stringArrayList = bundle.getStringArrayList(str);
            } catch (BadParcelableException | IllegalArgumentException | IndexOutOfBoundsException unused) {
                C2111d.m12649e("BundleUtils", "Bundle bad name :", str);
            }
        } else {
            stringArrayList = null;
        }
        return stringArrayList != null ? stringArrayList : new ArrayList<>(0);
    }

    /* renamed from: l */
    public static boolean m65402l(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        try {
            return bundle.isEmpty();
        } catch (BadParcelableException unused) {
            C2111d.m12648d("BundleUtils", "isSafeEmpty BadParcelableException");
            return false;
        }
    }

    /* renamed from: m */
    public static void m65403m(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            bundle.clear();
        } catch (BadParcelableException unused) {
            C2111d.m12648d("BundleUtils", "safeClear BadParcelableException");
        }
    }
}
