package com.huawei.hianalytics;

import android.os.Bundle;
import com.huawei.android.app.ActivityManagerEx;
import com.huawei.android.app.IHwActivityNotifierEx;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.hianalytics.e0 */
/* loaded from: classes5.dex */
public class C4749e0 extends IHwActivityNotifierEx implements InterfaceC4780h0 {

    /* renamed from: a */
    public final int f21707a;

    /* renamed from: a */
    public final CopyOnWriteArrayList<AbstractC4786j0> f21708a = new CopyOnWriteArrayList<>();

    public C4749e0(int i10) {
        this.f21707a = i10;
    }

    @Override // com.huawei.hianalytics.InterfaceC4780h0
    /* renamed from: a */
    public void mo28814a() {
        this.f21708a.clear();
    }

    @Override // com.huawei.hianalytics.InterfaceC4780h0
    /* renamed from: b */
    public void mo28816b() {
        String str;
        int i10 = this.f21707a;
        if (i10 == 1) {
            str = "appSwitch";
        } else if (i10 != 2) {
            return;
        } else {
            str = "activityLifeState";
        }
        ActivityManagerEx.registerHwActivityNotifier(this, str);
    }

    @Override // com.huawei.hianalytics.InterfaceC4780h0
    /* renamed from: c */
    public void mo28817c() {
        ActivityManagerEx.unregisterHwActivityNotifier(this);
    }

    public void call(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int i10 = 0;
        if (C4785j.m28943c(EnvUtils.getAppContext())) {
            while (i10 < this.f21708a.size()) {
                this.f21708a.get(i10).mo28776a(bundle);
                i10++;
            }
        } else {
            HiLog.m28807d("HwAM", "call, screen is off");
            while (i10 < this.f21708a.size()) {
                this.f21708a.get(i10).mo28775a();
                i10++;
            }
        }
    }

    @Override // com.huawei.hianalytics.InterfaceC4780h0
    /* renamed from: a */
    public void mo28815a(AbstractC4786j0 abstractC4786j0) {
        this.f21708a.add(abstractC4786j0);
    }
}
