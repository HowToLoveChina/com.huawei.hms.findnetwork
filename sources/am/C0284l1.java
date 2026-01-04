package am;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import fk.C9721b;
import gp.C10028c;
import java.util.HashMap;
import java.util.List;
import p495nm.C11725f;
import p514o9.C11839m;
import p572qb.C12299b;
import p711vl.C13465e;
import p744wl.C13617a;
import p840zd.C14229k2;
import p847zk.C14315h;
import tl.C13026e;
import tl.C13029h;
import tl.C13030i;

/* renamed from: am.l1 */
/* loaded from: classes6.dex */
public class C0284l1 implements InterfaceC0260d1 {
    @Override // am.InterfaceC0260d1
    /* renamed from: a */
    public Boolean mo1756a(String str) {
        try {
            BackupOptionItem backupOptionItemM78401y = mo1759d().m78401y(str);
            if (backupOptionItemM78401y != null) {
                return Boolean.valueOf(backupOptionItemM78401y.getBackupSwitch());
            }
            return null;
        } catch (Exception e10) {
            C11839m.m70688i("TempBackupOpr", "getModuleSwitch e " + e10.getMessage());
            return null;
        }
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: b */
    public C11725f mo1757b() {
        try {
            C13029h c13029hM78495f = new C13030i().m78495f(5);
            if (c13029hM78495f == null) {
                C11839m.m70688i("TempBackupOpr", "queryLocalBaks backupTag isEmpty");
                return null;
            }
            if (TextUtils.equals(c13029hM78495f.m78465h(), "empty_default_id")) {
                C11839m.m70688i("TempBackupOpr", "queryLocalBaks backupTag bakid isEmpty");
                return null;
            }
            C11725f c11725f = new C11725f();
            HashMap map = new HashMap();
            String strM78465h = c13029hM78495f.m78465h();
            map.put(strM78465h, CBSBaseReq.CURRENT_API_VERSION);
            c11725f.m69960d(strM78465h);
            c11725f.m69962f(map);
            C11839m.m70686d("TempBackupOpr", "queryLocalBaks: " + c11725f);
            return c11725f;
        } catch (C9721b e10) {
            C11839m.m70689w("TempBackupOpr", "queryLocalBaks error: " + e10);
            return null;
        }
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: c */
    public void mo1758c() {
        CloudBackupJobManager.getInstance().startAutoBackupListenerWithSwitchOpen();
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: d */
    public C13026e mo1759d() {
        return new C14229k2();
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: e */
    public void mo1760e(String str) {
        C11839m.m70688i("TempBackupOpr", "clearSuccessData delete snapshot bakId: " + str);
        if (!TextUtils.isEmpty(str)) {
            C13617a.m81936r(str);
        }
        if (!C10028c.m62182c0().m62388s("backup_key")) {
            C14315h.m85247M(false, 0, true);
        }
        C12299b.m73932n("backupAction", "");
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: g */
    public long mo1761g() {
        return C13465e.m81052f().m81062k();
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: h */
    public void mo1762h() {
        C13465e.m81052f().m81072u(System.currentTimeMillis());
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: i */
    public void mo1763i(List<String> list) {
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: j */
    public void mo1764j() {
    }
}
