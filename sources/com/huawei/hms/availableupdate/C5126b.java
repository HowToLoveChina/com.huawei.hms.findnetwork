package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.availableupdate.b */
/* loaded from: classes8.dex */
public class C5126b {

    /* renamed from: b */
    public static final C5126b f23386b = new C5126b();

    /* renamed from: c */
    private static final Object f23387c = new Object();

    /* renamed from: a */
    private final List<Activity> f23388a = new ArrayList(1);

    /* renamed from: a */
    public void m30610a(Activity activity) {
        synchronized (f23387c) {
            try {
                for (Activity activity2 : this.f23388a) {
                    if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                        activity2.finish();
                    }
                }
                this.f23388a.add(activity);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m30611b(Activity activity) {
        synchronized (f23387c) {
            this.f23388a.remove(activity);
        }
    }
}
