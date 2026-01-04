package se;

import android.text.TextUtils;
import com.huawei.android.remotecontrol.alarm.C4328a;
import java.util.ArrayList;
import java.util.Iterator;
import p809yg.C13981a;

/* renamed from: se.h */
/* loaded from: classes4.dex */
public class C12786h {

    /* renamed from: a */
    public static ArrayList<C4328a> f58459a = new ArrayList<>();

    /* renamed from: a */
    public static void m76746a(C4328a c4328a) {
        if (c4328a != null) {
            f58459a.add(c4328a);
        }
    }

    /* renamed from: b */
    public static boolean m76747b(String[] strArr) {
        if (strArr != null) {
            return strArr.length == 2 || "0".equals(strArr[0]);
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m76748c(String[] strArr) {
        return strArr != null && strArr.length == 1 && "1".equals(strArr[0]);
    }

    /* renamed from: d */
    public static boolean m76749d(String[] strArr) {
        return strArr != null && strArr.length == 1 && "2".equals(strArr[0]);
    }

    /* renamed from: e */
    public static void m76750e(String str) {
        m76751f(str, false);
    }

    /* renamed from: f */
    public static void m76751f(String str, boolean z10) {
        if (TextUtils.isEmpty(str) || f58459a.size() <= 0) {
            return;
        }
        Iterator<C4328a> it = f58459a.iterator();
        while (it.hasNext()) {
            C4328a next = it.next();
            if (str.equals(next.m25990h0())) {
                C13981a.m83989i("AlsAlarmUtils", "remove old alarm task");
                next.m26022D0(z10);
                next.m26023E0();
                it.remove();
            }
        }
    }
}
