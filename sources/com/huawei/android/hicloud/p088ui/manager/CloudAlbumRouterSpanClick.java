package com.huawei.android.hicloud.p088ui.manager;

import android.content.Context;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import p015ak.C0209d;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p514o9.C11839m;
import p684un.C13225d;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class CloudAlbumRouterSpanClick implements SpanClickText.ISpanClickListener {

    /* renamed from: a */
    public Context f18353a;

    public CloudAlbumRouterSpanClick(Context context) {
        this.f18353a = context;
    }

    @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
    public void onClick() {
        if (C0209d.m1226Y0()) {
            C11839m.m70687e("CloudAlbumRouterSpanClick", "do not fast click");
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58429h(this.f18353a, 0);
        }
        C13225d.m79490f1().m79585f0("action_code_jump_cloud_photos", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_jump_cloud_photos", "1", "from_cloud_homepage_linktext");
        C13225d.m79490f1().m79593q0("CLICK_MAIN_CLOUD_PHOTOS");
    }
}
