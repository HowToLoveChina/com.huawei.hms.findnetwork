package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.p171db.bean.EventMonitorRecord;

/* renamed from: com.huawei.openalliance.ad.jc */
/* loaded from: classes8.dex */
public class C7329jc {

    /* renamed from: a */
    private static final byte[] f34139a = new byte[0];

    /* renamed from: b */
    private static C7329jc f34140b;

    /* renamed from: c */
    private int f34141c;

    /* renamed from: d */
    private C7108ex f34142d;

    public C7329jc(Context context) {
        this.f34142d = C7108ex.m43156a(context);
    }

    /* renamed from: a */
    public static C7329jc m45247a(Context context) {
        return m45248b(context);
    }

    /* renamed from: b */
    private static C7329jc m45248b(Context context) {
        C7329jc c7329jc;
        synchronized (f34139a) {
            try {
                if (f34140b == null) {
                    f34140b = new C7329jc(context);
                }
                f34140b.f34141c = C7124fh.m43316b(context).mo43421bv() * 100;
                c7329jc = f34140b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7329jc;
    }

    /* renamed from: a */
    public boolean m45249a(int i10, String str) {
        if (TextUtils.isEmpty(str) || this.f34141c <= 0) {
            return false;
        }
        EventMonitorRecord eventMonitorRecordM43160a = this.f34142d.m43160a(str);
        if (eventMonitorRecordM43160a != null) {
            this.f34142d.m43168a(eventMonitorRecordM43160a.m41660a(), System.currentTimeMillis());
            return true;
        }
        EventMonitorRecord eventMonitorRecord = new EventMonitorRecord();
        eventMonitorRecord.m41662a(System.currentTimeMillis());
        eventMonitorRecord.m41661a(i10);
        eventMonitorRecord.m41663a(str);
        this.f34142d.m43165a(eventMonitorRecord, this.f34141c);
        return false;
    }
}
