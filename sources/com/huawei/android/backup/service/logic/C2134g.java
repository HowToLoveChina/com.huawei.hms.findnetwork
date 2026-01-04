package com.huawei.android.backup.service.logic;

import android.os.Bundle;
import com.huawei.android.backup.service.logic.C2153l;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import p386j6.C10713c;

/* renamed from: com.huawei.android.backup.service.logic.g */
/* loaded from: classes.dex */
public class C2134g {
    /* renamed from: a */
    public static AbstractC2131d m12824a(C2153l.b bVar) {
        Bundle bundle;
        if (bVar == null || (bundle = bVar.f9690f) == null) {
            return new C2135h();
        }
        int iM65395e = C10713c.m65395e(bundle, CloneService.KEY_ACTION_FLAG, -1);
        return iM65395e >= 0 ? (iM65395e == 2 || iM65395e == 3) ? new C2132e() : (iM65395e == 10 || iM65395e == 11) ? new C2133f() : new C2135h() : m12825b();
    }

    /* renamed from: b */
    public static AbstractC2131d m12825b() {
        return new C2135h();
    }
}
