package p229di;

import android.content.pm.ApplicationInfo;
import android.util.SparseArray;
import p229di.C9142g;

/* renamed from: di.d */
/* loaded from: classes4.dex */
public class C9139d {

    /* renamed from: a */
    public static final String f45937a;

    static {
        f45937a = C9142g.m57463b() ? "com.hihonor.android.content.pm.ApplicationInfoEx" : "com.huawei.android.content.pm.ApplicationInfoEx";
    }

    /* renamed from: a */
    public static SparseArray<int[]> m57457a(ApplicationInfo applicationInfo) {
        try {
            return (SparseArray) C9142g.a.m57468c(f45937a, ApplicationInfo.class).m57470d("getSplitDependencies", applicationInfo).m57472f();
        } catch (Exception unused) {
            return new SparseArray<>();
        }
    }
}
