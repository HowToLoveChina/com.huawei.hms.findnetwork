package com.huawei.hianalytics;

import android.app.ActivityManager;
import android.content.pm.ActivityInfo;
import com.hihonor.android.app.ActivityManagerEx;
import java.util.List;

/* renamed from: com.huawei.hianalytics.f0 */
/* loaded from: classes5.dex */
public class C4752f0 implements InterfaceC4783i0 {

    /* renamed from: a */
    public C4746d0 f21736a;

    /* renamed from: b */
    public C4746d0 f21737b;

    @Override // com.huawei.hianalytics.InterfaceC4783i0
    /* renamed from: a */
    public ActivityInfo mo28827a() {
        return ActivityManagerEx.getLastResumedActivity();
    }

    @Override // com.huawei.hianalytics.InterfaceC4783i0
    /* renamed from: b */
    public InterfaceC4780h0 mo28830b() {
        if (this.f21736a == null) {
            this.f21736a = new C4746d0(1);
        }
        return this.f21736a;
    }

    @Override // com.huawei.hianalytics.InterfaceC4783i0
    /* renamed from: a */
    public InterfaceC4780h0 mo28828a() {
        if (this.f21737b == null) {
            this.f21737b = new C4746d0(2);
        }
        return this.f21737b;
    }

    @Override // com.huawei.hianalytics.InterfaceC4783i0
    /* renamed from: a */
    public List<ActivityManager.RunningTaskInfo> mo28829a(int i10) {
        return ActivityManagerEx.getTasks(i10);
    }
}
