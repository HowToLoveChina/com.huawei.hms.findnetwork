package pm;

import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import fk.C9721b;
import gp.C10028c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: pm.f */
/* loaded from: classes6.dex */
public class C12179f extends AbstractC12367d {

    /* renamed from: a */
    public Handler f56519a;

    /* renamed from: b */
    public String f56520b;

    public C12179f(String str, Handler handler) {
        this.f56520b = str;
        this.f56519a = handler;
    }

    /* renamed from: c */
    public final void m73278c() {
        if (this.f56519a != null) {
            C11839m.m70688i("CloudBackupForce2v3Task", "send force2V3 error msg");
            Message message = new Message();
            message.what = -1;
            this.f56519a.sendMessage(message);
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        if ("2".equalsIgnoreCase(new SettingOperator().queryUploadTargetStrategy())) {
            C11839m.m70688i("CloudBackupForce2v3Task", "already v3, no need force2v3, send success msg");
            m73280e();
        } else {
            if (!C10028c.m62182c0().m62335h1()) {
                m73279d();
                return;
            }
            try {
                new C12176c(true).m73272a(this.f56520b);
                m73280e();
            } catch (C9721b unused) {
                m73278c();
            }
        }
    }

    /* renamed from: d */
    public final void m73279d() {
        if (this.f56519a != null) {
            C11839m.m70688i("CloudBackupForce2v3Task", "send do not support about msg");
            Message message = new Message();
            message.what = 1;
            this.f56519a.sendMessage(message);
        }
    }

    /* renamed from: e */
    public final void m73280e() {
        if (this.f56519a != null) {
            C11839m.m70688i("CloudBackupForce2v3Task", "send force2V3 success msg");
            Message message = new Message();
            message.what = 0;
            this.f56519a.sendMessage(message);
        }
    }
}
