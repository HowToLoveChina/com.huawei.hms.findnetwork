package p765x7;

import android.text.TextUtils;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.cloud.base.http.C4609l;
import p031b7.C1120a;
import p237du.C9310c;
import p650t7.C12976l0;
import p709vj.C13452e;

/* renamed from: x7.a */
/* loaded from: classes2.dex */
public class C13719a {

    /* renamed from: a */
    public static String f61716a;

    /* renamed from: a */
    public static String m82473a(String str, C4609l c4609l) {
        if (TextUtils.isEmpty(str) || !str.contains(C13452e.m80781L().m80971t0())) {
            return str;
        }
        c4609l.put("x-hw-album-Id", (Object) str);
        return C9310c.m58618b(str);
    }

    /* renamed from: b */
    public static String m82474b(Long l10) {
        return l10 == null ? "" : String.valueOf(l10.longValue() + 1000000000000L);
    }

    /* renamed from: c */
    public static String m82475c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return String.valueOf(Long.parseLong(str) + 1000000000000L);
        } catch (NumberFormatException unused) {
            C1120a.m6676e("ExecutorHelper", "formatCursor type error");
            return "";
        }
    }

    /* renamed from: d */
    public static String m82476d() {
        return f61716a;
    }

    /* renamed from: e */
    public static String m82477e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return String.valueOf(Long.parseLong(str) - 1000000000000L);
        } catch (NumberFormatException unused) {
            C1120a.m6676e("ExecutorHelper", "formatCursor type error");
            return "";
        }
    }

    /* renamed from: f */
    public static void m82478f(String str) {
        f61716a = str;
    }

    /* renamed from: g */
    public static void m82479g(String str, String str2) {
        if (CloudAlbumSettings.m14363h().m14376l()) {
            new C12976l0(m82477e(str), str2).m77924k();
        }
    }
}
