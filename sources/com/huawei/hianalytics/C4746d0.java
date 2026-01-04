package com.huawei.hianalytics;

import android.os.Bundle;
import com.hihonor.android.app.ActivityManagerEx;
import com.hihonor.android.app.IHwActivityNotifierEx;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.hianalytics.d0 */
/* loaded from: classes5.dex */
public class C4746d0 extends IHwActivityNotifierEx implements InterfaceC4780h0 {

    /* renamed from: a */
    public final int f21698a;

    /* renamed from: a */
    public final CopyOnWriteArrayList<AbstractC4786j0> f21699a = new CopyOnWriteArrayList<>();

    public C4746d0(int i10) {
        this.f21698a = i10;
    }

    @Override // com.huawei.hianalytics.InterfaceC4780h0
    /* renamed from: a */
    public void mo28814a() {
        this.f21699a.clear();
    }

    @Override // com.huawei.hianalytics.InterfaceC4780h0
    /* renamed from: b */
    public void mo28816b() {
        String str;
        int i10 = this.f21698a;
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
            while (i10 < this.f21699a.size()) {
                this.f21699a.get(i10).mo28776a(bundle);
                i10++;
            }
        } else {
            HiLog.m28807d("HnAM", "call, screen is off");
            while (i10 < this.f21699a.size()) {
                this.f21699a.get(i10).mo28775a();
                i10++;
            }
        }
    }

    @Override // com.huawei.hianalytics.InterfaceC4780h0
    /* renamed from: a */
    public void mo28815a(AbstractC4786j0 abstractC4786j0) {
        this.f21699a.add(abstractC4786j0);
    }
}
