package im;

import cm.AbstractC1455a;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Revisions;
import fk.C9721b;
import java.io.IOException;
import java.util.List;
import p814yl.C14000c0;

/* renamed from: im.j */
/* loaded from: classes6.dex */
public class C10560j extends AbstractC10571u {

    /* renamed from: U */
    public String f50786U;

    public C10560j(String str, String str2, AbstractC1455a abstractC1455a, String str3, String str4, String str5, String str6, String str7) {
        super(str, str2, abstractC1455a, str3, "", "App", str6, str5, str7, 0);
        this.f50786U = str4;
    }

    @Override // im.AbstractC10571u
    /* renamed from: P */
    public Asset mo64708P(final String str, final List<String> list, String str2, final boolean z10) throws C9721b {
        return m64854L(new C14000c0<>(new C14000c0.a() { // from class: im.i
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f50782a.m64776q0(str, list, z10, cloudBackupV3Server);
            }
        }), "Backup.asset.revisions.get");
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Get] */
    /* renamed from: q0 */
    public final /* synthetic */ CloudBackupV3Request m64776q0(String str, List list, boolean z10, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        AbstractC1455a abstractC1455a = this.f50867k;
        String lockId = (abstractC1455a == null || abstractC1455a.mo8329d() == null) ? null : this.f50867k.mo8329d().getLockId();
        Revisions.Get get = cloudBackupV3Server.backup().asset().revisions().get();
        get.setFields(str).setBackupAction(this.f50786U).setLockId(lockId).setVersionId(this.f50873q).setKindId(this.f50870n).setRecordId(this.f50871o).setAssetId(this.f50872p);
        if (list != null && !list.isEmpty()) {
            get.setObjectIds(list);
        }
        if (z10) {
            get.setAutoFix(true);
        }
        return get;
    }

    public C10560j(String str, String str2, AbstractC1455a abstractC1455a, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(str, str2, abstractC1455a, str3, "", str8, str6, str5, str7, 0);
        this.f50786U = str4;
    }
}
