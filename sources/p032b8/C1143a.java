package p032b8;

import android.content.Context;
import p031b7.C1120a;
import p572qb.C12297a;
import p608rb.C12485a;

/* renamed from: b8.a */
/* loaded from: classes2.dex */
public class C1143a extends C12485a {

    /* renamed from: a */
    public int f5404a = 0;

    @Override // p608rb.C12485a
    /* renamed from: a */
    public boolean mo7208a(Context context) {
        boolean zM73913f = C12297a.m73908c().m73913f("auto-album-sync_apply");
        C1120a.m6677i("AutoSyncApply", "needRetryApplyPowerKit: " + zM73913f + ", currentApplyNumber: " + this.f5404a);
        if (!zM73913f) {
            return false;
        }
        this.f5404a++;
        return true;
    }
}
