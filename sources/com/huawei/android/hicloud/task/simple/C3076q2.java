package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.hicloud.notification.constants.HNConstants;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p336he.C10155f;
import p514o9.C11839m;
import p684un.C13225d;

/* renamed from: com.huawei.android.hicloud.task.simple.q2 */
/* loaded from: classes3.dex */
public class C3076q2 extends C3071p1 {

    /* renamed from: e */
    public ArrayList<String> f13367e;

    /* renamed from: f */
    public Bundle f13368f;

    /* renamed from: g */
    public int f13369g;

    public C3076q2(Context context, Bundle bundle, int i10) {
        super(context, bundle);
        this.f13367e = new ArrayList<>();
        this.f13368f = bundle;
        this.f13369g = i10;
    }

    @Override // com.huawei.android.hicloud.task.simple.C3071p1, p616rk.AbstractRunnableC12516b
    public void call() {
        m18384h();
        m18367c();
        Iterator<String> it = this.f13367e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            C10155f.m63278c(this.f13355c, next, this.f13369g);
            C2783d.m16120Y0(this.f13355c, next, "local_close_switch");
        }
    }

    /* renamed from: f */
    public final void m18382f(boolean z10, String str) {
        if (z10) {
            this.f13356d.add(str);
        } else {
            this.f13367e.add(str);
        }
    }

    /* renamed from: g */
    public final void m18383g(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", z10);
        bundle.putBoolean("ShareAlbum", z10);
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("UniformGuideInitTask", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58396U(this.f13355c, bundle, 10);
            m18382f(z10, "atlas");
        }
    }

    /* renamed from: h */
    public void m18384h() {
        C11839m.m70688i("UniformGuideInitTask", "initSyncModule");
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        m18382f(this.f13368f.getBoolean("addressbook"), "addressbook");
        m18382f(this.f13368f.getBoolean("calendar"), "calendar");
        m18383g(this.f13368f.getBoolean(HNConstants.DataType.MEDIA));
        m18382f(this.f13368f.getBoolean("notepad"), "notepad");
        m18382f(this.f13368f.getBoolean("wlan"), "wlan");
        m18382f(this.f13368f.getBoolean("browser"), "browser");
        boolean zM62388s = c10028cM62182c0.m62388s("backup_key");
        CloudBackupService.getInstance().cloudbackupOpr(zM62388s);
        if (zM62388s) {
            C13225d.m79490f1().m79558J0(this.f13354b);
        }
    }
}
