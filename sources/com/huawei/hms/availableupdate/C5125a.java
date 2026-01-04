package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.huawei.hms.availableupdate.a */
/* loaded from: classes8.dex */
public class C5125a {

    /* renamed from: c */
    public static final C5125a f23382c = new C5125a();

    /* renamed from: d */
    private static final Object f23383d = new Object();

    /* renamed from: a */
    private final AtomicBoolean f23384a = new AtomicBoolean(false);

    /* renamed from: b */
    private final List<Activity> f23385b = new ArrayList(1);

    /* renamed from: a */
    public void m30607a(Activity activity) {
        synchronized (f23383d) {
            try {
                for (Activity activity2 : this.f23385b) {
                    if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                        activity2.finish();
                    }
                }
                this.f23385b.add(activity);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m30609b(Activity activity) {
        synchronized (f23383d) {
            this.f23385b.remove(activity);
        }
    }

    /* renamed from: a */
    public void m30608a(boolean z10) {
        this.f23384a.set(z10);
    }

    /* renamed from: a */
    public AtomicBoolean m30606a() {
        return this.f23384a;
    }
}
