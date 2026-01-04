package p657tp;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import p015ak.C0213f;
import p714vp.C13478c;

/* renamed from: tp.d */
/* loaded from: classes8.dex */
public final class C13053d extends C13050a {

    /* renamed from: tp.d$b */
    public static class b {

        /* renamed from: a */
        public static final C13053d f59397a = new C13053d();
    }

    /* renamed from: i */
    public static C13053d m78770i() {
        return b.f59397a;
    }

    /* renamed from: j */
    public static String m78771j(Context context, final int i10) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        return runningAppProcesses == null ? "" : (String) runningAppProcesses.stream().filter(new Predicate() { // from class: tp.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C13053d.m78772k(i10, (ActivityManager.RunningAppProcessInfo) obj);
            }
        }).findAny().map(new Function() { // from class: tp.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ActivityManager.RunningAppProcessInfo) obj).processName;
            }
        }).orElse("");
    }

    /* renamed from: k */
    public static /* synthetic */ boolean m78772k(int i10, ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.pid == i10;
    }

    public C13053d() {
        String strM78771j = m78771j(C0213f.m1377a(), Process.myPid());
        if (C0213f.m1377a().getPackageName().equals(strM78771j)) {
            this.f59395c = new C13478c("configurable");
            return;
        }
        this.f59395c = new C13478c("configurable_" + strM78771j);
    }
}
