package id;

import android.content.Context;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import p015ak.C0209d;
import p514o9.C11839m;
import p571q9.C12295b;
import p581qk.AbstractC12369f;
import p709vj.C13452e;

/* renamed from: id.b */
/* loaded from: classes3.dex */
public abstract class AbstractC10468b extends AbstractC12369f {

    /* renamed from: a */
    public boolean f50449a;

    /* renamed from: b */
    public Context f50450b;

    /* renamed from: c */
    public BackupSpaceNotEnoughNeedData f50451c;

    /* renamed from: d */
    public C12295b f50452d;

    /* renamed from: e */
    public boolean f50453e;

    public AbstractC10468b() {
        super(0L, 10L);
        this.f50449a = false;
    }

    /* renamed from: c */
    public boolean m64342c() {
        return C0209d.m1265i1(this.f50450b) || C0209d.m1245d1(this.f50450b, "com.huawei.android.hicloud.ui.activity.BackupMainActivity") || C0209d.m1245d1(this.f50450b, MainActivity.class.getName());
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        if (!m64344e()) {
            m64343d();
            return;
        }
        if (!this.f50449a && m64342c()) {
            if (!this.f50453e || !NotifyUtil.isDialogSilent(this.f50450b, mo64336f())) {
                mo64338n();
                this.f50449a = true;
                m64343d();
                return;
            }
            boolean zIsSilentDelay = NotifyUtil.isSilentDelay();
            C11839m.m70687e("BackupFailCheckBaseTimer", "in silent time, dialog not show silentDelay = " + zIsSilentDelay);
            if (zIsSilentDelay) {
                super.cancel();
            } else {
                m64343d();
                mo64337h();
            }
        }
    }

    /* renamed from: d */
    public void m64343d() {
        super.cancel();
    }

    /* renamed from: e */
    public boolean m64344e() {
        return C13452e.m80781L().m80842P0();
    }

    /* renamed from: f */
    public abstract BaseNotifyBean mo64336f();

    /* renamed from: g */
    public void m64345g(Context context) {
        this.f50450b = context;
    }

    /* renamed from: h */
    public abstract void mo64337h();

    /* renamed from: j */
    public void m64346j(boolean z10) {
        this.f50453e = z10;
    }

    /* renamed from: k */
    public void m64347k(C12295b c12295b) {
        this.f50452d = c12295b;
    }

    /* renamed from: l */
    public void m64348l(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        this.f50451c = backupSpaceNotEnoughNeedData;
    }

    /* renamed from: m */
    public void m64349m(boolean z10) {
        this.f50449a = z10;
    }

    /* renamed from: n */
    public abstract void mo64338n();
}
