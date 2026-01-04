package com.huawei.hms.network.embedded;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.InterfaceC5886d1;
import com.huawei.hms.network.httpclient.excutor.PolicyExecutor;
import org.chromium.net.CronetEngine;

/* renamed from: com.huawei.hms.network.embedded.k2 */
/* loaded from: classes8.dex */
public class C5979k2 implements InterfaceC5886d1.a {

    /* renamed from: d */
    public static final String f27234d = "CronetRequestTaskFactory";

    /* renamed from: a */
    public CronetEngine f27235a;

    /* renamed from: b */
    public boolean f27236b;

    /* renamed from: c */
    public PolicyExecutor f27237c;

    public C5979k2(Context context, PolicyExecutor policyExecutor) {
        this.f27236b = false;
        if (context == null) {
            Logger.m32145w(f27234d, "the context is null,and the CronetRequestTaskFactory cann't been Initialized!");
            return;
        }
        this.f27237c = policyExecutor;
        C5873c2 cronetEngineFeature = C5887d2.getInstance().getCronetEngineFeature(context, policyExecutor);
        if (cronetEngineFeature != null) {
            this.f27235a = cronetEngineFeature.getCronetEngine();
            this.f27236b = cronetEngineFeature.isEnableConnectionMigrated();
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1.a
    public String getChannel() {
        return "type_cronet";
    }

    public PolicyExecutor getPolicyExecutor() {
        return this.f27237c;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1.a
    public boolean isAvailable() {
        return this.f27235a != null;
    }

    public boolean isEnableConnectionMigrated() {
        return this.f27236b;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1.a
    public InterfaceC5886d1 newTask() {
        return new C5966j2(this.f27235a, this);
    }
}
