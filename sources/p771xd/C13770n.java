package p771xd;

import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler;
import gp.C10028c;
import p514o9.C11839m;
import p654tb.C13003b;
import p654tb.C13004c;

/* renamed from: xd.n */
/* loaded from: classes3.dex */
public class C13770n implements ISpaceRemindHandler {

    /* renamed from: a */
    public final C13003b f61871a;

    public C13770n(C13003b c13003b) {
        this.f61871a = c13003b;
    }

    @Override // com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler
    /* renamed from: a */
    public C13004c mo24386a() {
        boolean z10 = (CBAccess.inBackup() || CBAccess.isBackupPause() || !m82681c()) ? false : true;
        if (this.f61871a == null) {
            C11839m.m70687e("SpaceRemindPreCheckHandler", "context is null");
            return C13004c.m78185a("context is null", null, null, false);
        }
        C11839m.m70688i("SpaceRemindPreCheckHandler", "isPreCheckPass:" + z10);
        this.f61871a.m78181e(z10);
        return C13004c.m78186f(null, null, false);
    }

    @Override // com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler
    /* renamed from: b */
    public boolean mo24387b() {
        return true;
    }

    /* renamed from: c */
    public final boolean m82681c() {
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        C11839m.m70688i("SpaceRemindPreCheckHandler", "isBackupSwitchOpen:" + zM62388s);
        return zM62388s;
    }
}
