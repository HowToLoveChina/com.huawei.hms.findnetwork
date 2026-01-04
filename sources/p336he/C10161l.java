package p336he;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: he.l */
/* loaded from: classes3.dex */
public final class C10161l {

    /* renamed from: b */
    public static C10161l f49468b;

    /* renamed from: a */
    public ArrayList<Activity> f49469a = null;

    /* renamed from: b */
    public static C10161l m63342b() {
        C10161l c10161l;
        synchronized (C10161l.class) {
            try {
                if (f49468b == null) {
                    f49468b = new C10161l();
                }
                c10161l = f49468b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c10161l;
    }

    /* renamed from: a */
    public void m63343a() {
        ArrayList<Activity> arrayList = this.f49469a;
        if (arrayList != null) {
            Iterator<Activity> it = arrayList.iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                if (next != null) {
                    next.finish();
                }
            }
        }
    }

    /* renamed from: c */
    public void m63344c(Activity activity) {
        ArrayList<Activity> arrayList;
        if (activity == null || (arrayList = this.f49469a) == null) {
            return;
        }
        arrayList.remove(activity);
    }

    /* renamed from: d */
    public void m63345d(Activity activity) {
        ArrayList<Activity> arrayList = this.f49469a;
        if (arrayList != null) {
            arrayList.add(activity);
            return;
        }
        ArrayList<Activity> arrayList2 = new ArrayList<>();
        this.f49469a = arrayList2;
        arrayList2.add(activity);
    }
}
