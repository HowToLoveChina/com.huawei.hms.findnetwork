package bs;

import android.os.Process;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;

/* renamed from: bs.g */
/* loaded from: classes8.dex */
public class C1280g {
    /* renamed from: a */
    public static String m7589a(String str, int i10, int i11) {
        return "(" + i10 + "|" + i11 + ")" + str;
    }

    /* renamed from: b */
    public static void m7590b(String str, String str2, Throwable th2) {
        if (C1279f.m7565p()) {
            C1282i.m7604k().m7605j(new C1274a("E", m7589a(str, Process.myPid(), Process.myTid()), str2, th2));
        }
    }

    /* renamed from: c */
    public static void m7591c(String str, String str2, Throwable th2) {
        if (C1279f.m7565p()) {
            C1282i.m7604k().m7605j(new C1274a("I", m7589a(str, Process.myPid(), Process.myTid()), str2, th2));
        }
    }

    /* renamed from: d */
    public static void m7592d(C1283j c1283j) {
        if (c1283j != null) {
            C1282i.m7604k().m7606l(c1283j);
        } else {
            Log.e("LogWriteApi", "logWriteParam is null stop init LogWriteManager");
        }
    }

    /* renamed from: e */
    public static void m7593e(String str, boolean z10) {
        if (C1279f.m7565p() && z10) {
            C1282i.m7604k().m7605j(new C1274a(str, JsbMapKeyNames.H5_LOC));
        }
    }

    /* renamed from: f */
    public static void m7594f(String str, String str2, Throwable th2) {
        if (C1279f.m7565p()) {
            C1282i.m7604k().m7605j(new C1274a("W", m7589a(str, Process.myPid(), Process.myTid()), str2, th2));
        }
    }
}
