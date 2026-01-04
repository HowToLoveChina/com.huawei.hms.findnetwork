package com.huawei.hwcloudjs.service.hms;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hwcloudjs.service.hms.s */
/* loaded from: classes8.dex */
public class C6687s {

    /* renamed from: a */
    private static final C6687s f31009a = new C6687s();

    /* renamed from: b */
    private final Map<String, Parcelable> f31010b = new HashMap();

    /* renamed from: a */
    public Intent m37980a(String str) {
        synchronized (this.f31010b) {
            try {
                Parcelable parcelable = this.f31010b.get(str);
                if (!(parcelable instanceof Intent)) {
                    return null;
                }
                return (Intent) parcelable;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public PendingIntent m37983b(String str) {
        synchronized (this.f31010b) {
            try {
                Parcelable parcelable = this.f31010b.get(str);
                if (!(parcelable instanceof PendingIntent)) {
                    return null;
                }
                return (PendingIntent) parcelable;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static C6687s m37979a() {
        return f31009a;
    }

    /* renamed from: a */
    public void m37981a(String str, PendingIntent pendingIntent) {
        synchronized (this.f31010b) {
            this.f31010b.put(str, pendingIntent);
        }
    }

    /* renamed from: a */
    public void m37982a(String str, Intent intent) {
        synchronized (this.f31010b) {
            this.f31010b.put(str, intent);
        }
    }
}
