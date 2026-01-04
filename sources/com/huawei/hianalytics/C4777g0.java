package com.huawei.hianalytics;

import android.app.ActivityManager;
import android.content.pm.ActivityInfo;
import com.huawei.android.app.ActivityManagerEx;
import java.util.List;

/* renamed from: com.huawei.hianalytics.g0 */
/* loaded from: classes5.dex */
public class C4777g0 implements InterfaceC4783i0 {

    /* renamed from: a */
    public C4749e0 f21822a;

    /* renamed from: b */
    public C4749e0 f21823b;

    @Override // com.huawei.hianalytics.InterfaceC4783i0
    /* renamed from: a */
    public ActivityInfo mo28827a() {
        return ActivityManagerEx.getLastResumedActivity();
    }

    @Override // com.huawei.hianalytics.InterfaceC4783i0
    /* renamed from: b */
    public InterfaceC4780h0 mo28830b() {
        if (this.f21822a == null) {
            this.f21822a = new C4749e0(1);
        }
        return this.f21822a;
    }

    @Override // com.huawei.hianalytics.InterfaceC4783i0
    /* renamed from: a */
    public InterfaceC4780h0 mo28828a() {
        if (this.f21823b == null) {
            this.f21823b = new C4749e0(2);
        }
        return this.f21823b;
    }

    @Override // com.huawei.hianalytics.InterfaceC4783i0
    /* renamed from: a */
    public List<ActivityManager.RunningTaskInfo> mo28829a(int i10) {
        return ActivityManagerEx.getTasks(i10);
    }
}
