package p573qc;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import p015ak.C0206b0;
import p514o9.C11829c;
import p514o9.C11839m;
import p836z8.C14159h;

/* renamed from: qc.a */
/* loaded from: classes3.dex */
public class C12335a extends ContentObserver {

    /* renamed from: a */
    public volatile boolean f57096a;

    /* renamed from: b */
    public Handler f57097b;

    /* renamed from: c */
    public boolean f57098c;

    /* renamed from: d */
    public Context f57099d;

    /* renamed from: e */
    public int f57100e;

    public C12335a(Handler handler, Context context, int i10) {
        super(handler);
        this.f57096a = false;
        this.f57098c = false;
        this.f57097b = handler;
        this.f57099d = context;
        this.f57100e = i10;
    }

    /* renamed from: a */
    public final void m74180a() {
        synchronized (this) {
            try {
                if (this.f57096a) {
                    this.f57097b.removeMessages(this.f57100e);
                } else {
                    m74182c(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m74181b();
    }

    /* renamed from: b */
    public final void m74181b() {
        synchronized (this) {
            try {
                boolean zM84967a = C14159h.m84967a(this.f57099d, "addressbook");
                C11839m.m70686d("ContactsBaseObserver", "[sendSyncMsg] is have sync task: " + zM84967a);
                if (!this.f57096a || zM84967a) {
                    C11839m.m70688i("ContactsBaseObserver", "[sendSyncMsg] Ignore ContentObserver change. Syncing...");
                } else {
                    boolean zM1131c = C0206b0.m1131c("addressbook", this.f57099d);
                    this.f57098c = zM1131c;
                    if (zM1131c) {
                        if (!C11829c.m70611r0()) {
                            this.f57097b.removeMessages(9);
                            this.f57097b.removeMessages(16);
                        }
                        Message message = new Message();
                        message.what = this.f57100e;
                        this.f57097b.sendMessageDelayed(message, 10000L);
                        C11839m.m70688i("ContactsBaseObserver", "[sendSyncMsg] send message");
                    } else {
                        C11839m.m70688i("ContactsBaseObserver", "[sendSyncMsg] Ignore sync request, sync switch is off");
                        m74182c(false);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public void m74182c(boolean z10) {
        synchronized (this) {
            this.f57096a = z10;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        synchronized (this) {
            try {
                boolean zM1131c = C0206b0.m1131c("addressbook", this.f57099d);
                this.f57098c = zM1131c;
                if (zM1131c) {
                    m74180a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
