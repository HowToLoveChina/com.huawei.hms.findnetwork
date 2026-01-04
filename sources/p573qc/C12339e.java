package p573qc;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import md.C11440c;
import p015ak.C0206b0;
import p514o9.C11839m;

/* renamed from: qc.e */
/* loaded from: classes3.dex */
public class C12339e extends ContentObserver {

    /* renamed from: a */
    public volatile boolean f57117a;

    /* renamed from: b */
    public Handler f57118b;

    /* renamed from: c */
    public boolean f57119c;

    /* renamed from: d */
    public Context f57120d;

    public C12339e(Context context, Handler handler) {
        super(handler);
        this.f57117a = false;
        this.f57119c = false;
        this.f57120d = context;
        this.f57118b = handler;
    }

    /* renamed from: a */
    public final void m74263a() {
        synchronized (this) {
            try {
                if (this.f57117a) {
                    this.f57118b.removeMessages(130);
                } else {
                    m74265c(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m74264b();
    }

    /* renamed from: b */
    public final void m74264b() {
        synchronized (this) {
            try {
                boolean zM68531i = C11440c.m68531i("autosmslistkey");
                C11839m.m70686d("SMSContentObserver", "is have backup task: " + zM68531i);
                if (!this.f57117a || zM68531i) {
                    C11839m.m70688i("SMSContentObserver", "Ignore backup request, isRunning");
                } else {
                    boolean zM1131c = C0206b0.m1131c("autosmslistkey", this.f57120d);
                    this.f57119c = zM1131c;
                    if (zM1131c) {
                        Message message = new Message();
                        message.what = 130;
                        this.f57118b.sendMessageDelayed(message, 10000L);
                        C11839m.m70686d("SMSContentObserver", "send sms change msg");
                    } else {
                        C11839m.m70688i("SMSContentObserver", "[Ignore backup request, backup switch is off");
                        m74265c(false);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public void m74265c(boolean z10) {
        synchronized (this) {
            this.f57117a = z10;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        synchronized (this) {
            try {
                boolean zM1131c = C0206b0.m1131c("autosmslistkey", this.f57120d);
                this.f57119c = zM1131c;
                if (zM1131c) {
                    m74263a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
