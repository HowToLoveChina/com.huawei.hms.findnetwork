package p835z7;

import android.database.SQLException;
import com.huawei.android.hicloud.exiter.IExitProcessor;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import p015ak.C0213f;

/* renamed from: z7.a */
/* loaded from: classes2.dex */
public class C14151a implements IExitProcessor {
    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: a */
    public void mo15561a(boolean z10) throws SQLException {
        CloudAlbumManager.m14456v().m14466K(C0213f.m1377a());
    }

    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: b */
    public void mo15562b() throws InterruptedException, SQLException {
        CloudAlbumManager.m14456v().m14479Y(C0213f.m1377a());
    }

    @Override // com.huawei.android.hicloud.exiter.IExitProcessor
    /* renamed from: c */
    public void mo15563c(boolean z10) throws SQLException {
        mo15561a(z10);
    }
}
