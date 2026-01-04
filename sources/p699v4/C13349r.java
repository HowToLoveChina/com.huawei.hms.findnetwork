package p699v4;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.C2157a;

/* renamed from: v4.r */
/* loaded from: classes.dex */
public class C13349r {
    /* renamed from: a */
    public static boolean m80085a() {
        int iM13211s = C2157a.m13211s();
        C2111d.m12654j("VersionUtils", "EmuiApiLevel : ", Integer.valueOf(iM13211s));
        return iM13211s >= 25;
    }

    /* renamed from: b */
    public static boolean m80086b(Context context) {
        return C2157a.m13177L(context);
    }

    /* renamed from: c */
    public static boolean m80087c() {
        return true;
    }

    /* renamed from: d */
    public static boolean m80088d() {
        return true;
    }
}
