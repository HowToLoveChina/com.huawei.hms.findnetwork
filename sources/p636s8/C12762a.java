package p636s8;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import md.C11440c;
import p015ak.C0206b0;
import p514o9.C11839m;

/* renamed from: s8.a */
/* loaded from: classes2.dex */
public class C12762a extends ContentObserver {

    /* renamed from: a */
    public final Object f58399a;

    /* renamed from: b */
    public Context f58400b;

    /* renamed from: c */
    public Handler f58401c;

    /* renamed from: d */
    public boolean f58402d;

    public C12762a(Context context, Handler handler) {
        super(handler);
        this.f58399a = new Object();
        this.f58402d = false;
        this.f58400b = context;
        this.f58401c = handler;
    }

    /* renamed from: a */
    public final void m76587a() {
        synchronized (this.f58399a) {
            try {
                if (m76588b()) {
                    this.f58401c.removeMessages(SyncType.AUTO_SYNC_CALLLOG);
                } else {
                    m76590d(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m76589c();
    }

    /* renamed from: b */
    public boolean m76588b() {
        boolean z10;
        synchronized (this.f58399a) {
            z10 = this.f58402d;
        }
        return z10;
    }

    /* renamed from: c */
    public void m76589c() {
        synchronized (this.f58399a) {
            try {
                boolean zM68531i = C11440c.m68531i("autocallloglistkey");
                if (m76588b() && !zM68531i) {
                    if (C0206b0.m1131c("autocallloglistkey", this.f58400b)) {
                        C11839m.m70686d("CallLogContentObserver", "send calllog change msg");
                        if (CloudSyncUtil.m15939A(this.f58400b) < 10) {
                            m76590d(false);
                            C11839m.m70686d("CallLogContentObserver", "batterylever lower than 10%");
                        } else {
                            Message message = new Message();
                            message.what = SyncType.AUTO_SYNC_CALLLOG;
                            this.f58401c.sendMessageDelayed(message, 10000L);
                        }
                    } else {
                        m76590d(false);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m76590d(boolean z10) {
        synchronized (this.f58399a) {
            this.f58402d = z10;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        boolean zM1131c = C0206b0.m1131c("autocallloglistkey", this.f58400b);
        C11839m.m70686d("CallLogContentObserver", "autocallloglistkey is " + zM1131c);
        if (zM1131c) {
            m76587a();
        }
    }
}
