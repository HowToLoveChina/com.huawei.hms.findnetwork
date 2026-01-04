package p608rb;

import android.content.Context;
import p514o9.C11839m;
import sb.C12767a;

/* renamed from: rb.b */
/* loaded from: classes3.dex */
public class C12486b extends C12485a {

    /* renamed from: a */
    public long f57492a = 600000;

    @Override // p608rb.C12485a
    /* renamed from: a */
    public boolean mo7208a(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis() - C12767a.m76619c().m76621b();
        C11839m.m70688i("ContactSyncApply", "ContactSyncApply：business interval time:" + (jCurrentTimeMillis / 1000));
        if (jCurrentTimeMillis <= this.f57492a) {
            return true;
        }
        C11839m.m70688i("ContactSyncApply", "ContactSyncApply：ContactSyncExecuteTime Exceed 10 minutes.");
        return false;
    }
}
