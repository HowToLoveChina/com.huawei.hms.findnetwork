package cm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.common.receiver.FlowControlReceiver;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockKeepResult;
import fk.C9721b;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: cm.a */
/* loaded from: classes6.dex */
public abstract class AbstractC1455a {

    /* renamed from: c */
    public static final Object f6225c = new Object();

    /* renamed from: a */
    public long f6226a = 0;

    /* renamed from: b */
    public volatile long f6227b = 0;

    /* renamed from: a */
    public void m8326a() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return;
        }
        C11839m.m70688i("AbstractV3Lock", "cancel keep lock alarm");
        AlarmManager alarmManager = (AlarmManager) contextM1377a.getSystemService("alarm");
        Intent intent = new Intent(contextM1377a, (Class<?>) FlowControlReceiver.class);
        intent.setAction(CloudBackupConstant.BackupFlowControl.FLOW_CONTROL_ACTION);
        alarmManager.cancel(PendingIntent.getBroadcast(contextM1377a, CloudBackupConstant.BackupFlowControl.FLOW_CONTROL_CLENT_ID, intent, 1073741824));
    }

    /* renamed from: b */
    public void m8327b() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return;
        }
        m8326a();
        C11839m.m70688i("AbstractV3Lock", "create keep lock alarm");
        AlarmManager alarmManager = (AlarmManager) contextM1377a.getSystemService("alarm");
        Intent intent = new Intent(contextM1377a, (Class<?>) FlowControlReceiver.class);
        intent.setAction(CloudBackupConstant.BackupFlowControl.FLOW_CONTROL_ACTION);
        alarmManager.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + this.f6227b, PendingIntent.getBroadcast(contextM1377a, CloudBackupConstant.BackupFlowControl.FLOW_CONTROL_CLENT_ID, intent, 1073741824));
    }

    /* renamed from: c */
    public void m8328c() throws C9721b {
        synchronized (f6225c) {
            try {
                if (this.f6226a == 0) {
                    SystemClock.sleep(400L);
                }
                if (System.currentTimeMillis() - this.f6226a > this.f6227b) {
                    m8331f(mo8330e());
                    this.f6226a = System.currentTimeMillis();
                    m8327b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public abstract Lock mo8329d();

    /* renamed from: e */
    public abstract LockKeepResult mo8330e() throws C9721b;

    /* renamed from: f */
    public void m8331f(LockKeepResult lockKeepResult) {
        if (lockKeepResult != null) {
            this.f6227b = lockKeepResult.getLockKeepAlivePeriod() * 1000;
        } else if (this.f6227b <= 0) {
            C11839m.m70688i("AbstractV3Lock", "keepLock is null and lockPeriodMillis <= 0: " + this.f6227b);
            this.f6227b = 480000L;
        }
        C11839m.m70686d("AbstractV3Lock", "lockPeriodSet: " + lockKeepResult + " ,lockPeriodMillis: " + this.f6227b);
    }

    /* renamed from: g */
    public abstract boolean mo8332g(C9721b c9721b, String str) throws C9721b;
}
