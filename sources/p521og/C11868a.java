package p521og;

import android.app.Activity;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import java.util.Iterator;
import java.util.Stack;
import p809yg.C13981a;

/* renamed from: og.a */
/* loaded from: classes4.dex */
public class C11868a {

    /* renamed from: a */
    public static final Stack<Activity> f54923a = new Stack<>();

    /* renamed from: og.a$b */
    public static class b {

        /* renamed from: a */
        public static final C11868a f54924a = new C11868a();
    }

    /* renamed from: d */
    public static C11868a m71128d() {
        return b.f54924a;
    }

    /* renamed from: a */
    public void m71129a(Activity activity) {
        C13981a.m83987d("ActivityStackManager", "addActivity");
        if (activity != null) {
            f54923a.push(activity);
        }
    }

    /* renamed from: b */
    public void m71130b(Class<?> cls) {
        if (cls == null) {
            return;
        }
        C13981a.m83989i("ActivityStackManager", "finishActivity");
        Iterator<Activity> it = f54923a.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next != null && cls.equals(next.getClass())) {
                next.finish();
                it.remove();
            }
        }
    }

    /* renamed from: c */
    public void m71131c() {
        C13981a.m83987d("ActivityStackManager", "phone finder exit, finish activity");
        Iterator<Activity> it = f54923a.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if ((next instanceof WapFindPhoneActivity) && ((WapFindPhoneActivity) next).m27843h4()) {
                next.finish();
                it.remove();
            }
        }
    }

    /* renamed from: e */
    public void m71132e(Activity activity) {
        C13981a.m83987d("ActivityStackManager", "removeActivity");
        if (activity != null) {
            f54923a.remove(activity);
        }
    }

    public C11868a() {
    }
}
