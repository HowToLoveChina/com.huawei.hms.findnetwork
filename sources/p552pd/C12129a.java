package p552pd;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreRetry;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import p015ak.C0209d;
import p514o9.C11839m;
import p581qk.AbstractC12369f;
import p711vl.C13464d;

/* renamed from: pd.a */
/* loaded from: classes3.dex */
public class C12129a extends AbstractC12369f {

    /* renamed from: a */
    public Context f56241a;

    /* renamed from: b */
    public Handler f56242b;

    /* renamed from: c */
    public boolean f56243c;

    /* renamed from: d */
    public boolean f56244d;

    /* renamed from: e */
    public boolean f56245e;

    public C12129a(Context context, Handler handler, long j10, long j11) {
        super(j10, j11);
        this.f56243c = false;
        this.f56244d = false;
        this.f56241a = context;
        this.f56242b = handler;
    }

    /* renamed from: c */
    public void m72708c() {
        Handler handler = this.f56242b;
        if (handler == null || !handler.hasMessages(3201)) {
            return;
        }
        this.f56242b.removeMessages(3201);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        boolean zIsSmartCharging = CloudBackupConditionsUtil.isSmartCharging();
        this.f56245e = zIsSmartCharging;
        if (this.f56243c || zIsSmartCharging) {
            PowerManager powerManager = (PowerManager) this.f56241a.getSystemService("power");
            if (powerManager != null) {
                this.f56244d = powerManager.isInteractive();
            }
            m72709d();
        }
        C11839m.m70688i("CBObserverRestoreTimer", "CBObserverRestoreTimer call end");
    }

    /* renamed from: d */
    public void m72709d() {
        if (this.f56244d) {
            C11839m.m70688i("CBObserverRestoreTimer", "sendCheckRestoreTaskMsg isSrceenOn");
            return;
        }
        if (!C0209d.m1254f2(this.f56241a)) {
            C11839m.m70688i("CBObserverRestoreTimer", "sendCheckRestoreTaskMsg Wifi not connect");
            return;
        }
        if (this.f56242b.hasMessages(3201)) {
            C11839m.m70688i("CBObserverRestoreTimer", "sendCheckRestoreTaskMsg hasMessages");
            return;
        }
        RestoreRetry restoreRetryM81038i = C13464d.m81030f(this.f56241a).m81038i();
        try {
            int intExtra = new SafeIntent(this.f56241a.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))).getIntExtra(FaqConstants.FAQ_LEVEL, 0);
            int restartBattery = restoreRetryM81038i.getRestartBattery();
            if (intExtra < restartBattery) {
                C11839m.m70688i("CBObserverRestoreTimer", "sendCheckRestoreTaskMsg battery level lower than " + restartBattery + "%");
                return;
            }
        } catch (RuntimeException unused) {
            C11839m.m70688i("CBObserverRestoreTimer", "sendCheckRestoreTaskMsg intent Serializable error.");
        }
        C11839m.m70688i("CBObserverRestoreTimer", "ACTION_POWER_CONNECTED send retore message.");
        Message messageObtain = Message.obtain();
        messageObtain.what = 3201;
        messageObtain.arg1 = 2;
        this.f56242b.sendMessage(messageObtain);
    }

    @Override // p581qk.AbstractC12369f, p616rk.AbstractRunnableC12516b
    public void release() {
        super.release();
    }
}
