package com.huawei.android.hicloud.cloudspace.manager;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import com.huawei.hms.network.embedded.C5963j;
import gp.C10028c;
import p514o9.C11839m;
import p572qb.C12330v;
import p850zo.InterfaceC14351b;

/* loaded from: classes2.dex */
public class FullUsedStorageRequestor implements InterfaceC14351b {

    /* renamed from: a */
    public C12330v f11839a;

    /* renamed from: b */
    public Context f11840b;

    /* renamed from: c */
    public long f11841c;

    public FullUsedStorageRequestor(Context context) {
        this.f11840b = context;
        m15489b();
    }

    /* renamed from: a */
    private void m15488a() {
        C11839m.m70688i("FullUsedStorageRequestor", "checkTask");
        if (this.f11839a.m74146b()) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* renamed from: b */
    public final void m15489b() {
        this.f11839a = new C12330v();
        C12330v.a aVar = new C12330v.a("used_size");
        C12330v.a aVar2 = new C12330v.a("total_size");
        this.f11839a.m74145a(aVar);
        this.f11839a.m74145a(aVar2);
        if (C10028c.m62182c0().m62420y1()) {
            this.f11839a.m74145a(new C12330v.a(PowerKitApplyUtil.GROUP_ALBUM));
        }
    }

    @Override // p850zo.InterfaceC14351b
    public void onResult(Bundle bundle) {
        if (bundle == null) {
            C11839m.m70688i("FullUsedStorageRequestor", "onResult bundle null");
            this.f11839a.m74150f(PowerKitApplyUtil.GROUP_ALBUM, false);
            return;
        }
        int i10 = bundle.getInt(C5963j.f27041j);
        C11839m.m70688i("FullUsedStorageRequestor", "query album onResult retCode=" + i10);
        if (i10 == 0) {
            long j10 = bundle.getLong("photoTotalSize");
            long j11 = bundle.getLong("recycleTotalSize");
            if (j10 < 0) {
                j10 = 0;
            }
            if (j11 < 0) {
                j11 = 0;
            }
            this.f11841c = j10 + j11;
            C11839m.m70688i("FullUsedStorageRequestor", "gallery space=" + j10 + " ,galleryDeleteSize = " + j11);
            this.f11839a.m74150f(PowerKitApplyUtil.GROUP_ALBUM, true);
        } else {
            C11839m.m70688i("FullUsedStorageRequestor", "get gallery space failed");
            this.f11839a.m74150f(PowerKitApplyUtil.GROUP_ALBUM, false);
        }
        m15488a();
    }
}
