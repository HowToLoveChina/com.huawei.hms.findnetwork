package om;

import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import p514o9.C11839m;
import tl.C13032k;
import tl.C13033l;
import tl.C13034m;

/* renamed from: om.o */
/* loaded from: classes6.dex */
public class C11975o extends AbstractC11971k {

    /* renamed from: m */
    public long f55742m;

    /* renamed from: n */
    public boolean f55743n;

    @Override // om.AbstractC11971k
    /* renamed from: E */
    public C13032k mo72026E(boolean z10, boolean z11) {
        C13032k c13032kM78546d = mo72032L().m78546d(1);
        if (c13032kM78546d == null) {
            C11839m.m70689w(mo72029I(), "getBackupStateItem stateItem is null");
        }
        return c13032kM78546d;
    }

    @Override // om.AbstractC11971k
    /* renamed from: F */
    public int mo72027F() {
        return 5;
    }

    @Override // om.AbstractC11971k
    /* renamed from: G */
    public String mo72028G(BackupItem backupItem, String str) {
        return str;
    }

    @Override // om.AbstractC11971k
    /* renamed from: I */
    public String mo72029I() {
        return "TempBackupState";
    }

    @Override // om.AbstractC11971k
    /* renamed from: J */
    public int mo72030J() {
        return 33429;
    }

    @Override // om.AbstractC11971k
    /* renamed from: L */
    public C13033l mo72032L() {
        return new C13034m();
    }

    @Override // om.AbstractC11971k
    /* renamed from: N */
    public void mo72034N() {
        C11963c.m71961p("interim");
    }

    @Override // om.AbstractC11971k
    /* renamed from: P */
    public boolean mo72036P() {
        return true;
    }

    @Override // om.AbstractC11971k
    /* renamed from: Q */
    public boolean mo72037Q() {
        return CBAccess.isInTempBackup();
    }

    @Override // om.AbstractC11971k
    /* renamed from: R */
    public boolean mo72038R() {
        return false;
    }

    @Override // om.AbstractC11971k
    /* renamed from: U */
    public void mo72039U(boolean z10, CloudBackupState cloudBackupState, boolean z11, long j10) {
        C11839m.m70688i(mo72029I(), "overDayHandle:isExpired," + z11 + ",lastSuccessTime," + j10);
    }

    @Override // om.InterfaceC11973m
    /* renamed from: b */
    public CloudBackupState mo72075b() {
        return null;
    }

    @Override // om.InterfaceC11973m
    /* renamed from: c */
    public synchronized boolean mo72076c() {
        return this.f55743n;
    }

    @Override // om.AbstractC11971k, om.InterfaceC11973m
    /* renamed from: e */
    public long mo72050e() {
        return this.f55742m;
    }

    @Override // om.AbstractC11971k
    /* renamed from: e0 */
    public void mo72051e0() {
    }

    @Override // om.AbstractC11971k
    /* renamed from: f0 */
    public void mo72053f0() {
    }

    @Override // om.InterfaceC11973m
    public void init() {
    }

    @Override // om.InterfaceC11973m
    /* renamed from: k */
    public synchronized void mo72077k(boolean z10) {
        this.f55743n = z10;
    }

    @Override // om.InterfaceC11973m
    /* renamed from: m */
    public void mo72079m() {
    }

    @Override // om.AbstractC11971k, om.InterfaceC11973m
    /* renamed from: r */
    public void mo72066r(long j10) {
        this.f55742m = j10;
    }
}
