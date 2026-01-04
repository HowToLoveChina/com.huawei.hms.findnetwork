package pr;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.concurrent.atomic.AtomicInteger;
import p531or.C11991a;

/* renamed from: pr.a */
/* loaded from: classes8.dex */
public abstract class AbstractC12208a {

    /* renamed from: a */
    public SafeBroadcastReceiver f56593a;

    /* renamed from: b */
    public SafeBroadcastReceiver f56594b;

    /* renamed from: c */
    public AtomicInteger f56595c;

    /* renamed from: d */
    public boolean f56596d = true;

    /* renamed from: e */
    public final byte[] f56597e = new byte[0];

    /* renamed from: pr.a$a */
    public class a extends SafeBroadcastReceiver {
        public a() {
        }

        @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
        /* renamed from: d */
        public void mo38377d(Intent intent) {
            if (TextUtils.equals(new SafeIntent(intent).getAction(), "android.location.MODE_CHANGED")) {
                AbstractC12208a.this.mo65017c();
            }
        }

        @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
        /* renamed from: e */
        public String mo38378e() {
            return "Loc-Receive-GNSS";
        }
    }

    /* renamed from: pr.a$b */
    public class b extends SafeBroadcastReceiver {
        public b() {
        }

        @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
        /* renamed from: d */
        public void mo38377d(Intent intent) {
            if (TextUtils.equals(new SafeIntent(intent).getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                boolean z10 = AbstractC12208a.this.f56596d;
                AbstractC12208a abstractC12208a = AbstractC12208a.this;
                if (z10) {
                    abstractC12208a.f56596d = false;
                } else {
                    abstractC12208a.mo65017c();
                }
            }
        }

        @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
        /* renamed from: e */
        public String mo38378e() {
            return "Loc-Receive-Network";
        }
    }

    public AbstractC12208a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.MODE_CHANGED");
        this.f56593a = new a();
        C11991a.m72145a().registerReceiver(this.f56593a, intentFilter);
        C1016d.m6186f("GnssAndNetReceiver", "register gnss receiver ");
    }

    /* renamed from: c */
    public abstract void mo65017c();

    /* renamed from: d */
    public void m73376d() {
        synchronized (this.f56597e) {
            try {
                if (this.f56595c == null) {
                    this.f56595c = new AtomicInteger(0);
                }
                this.f56595c.incrementAndGet();
                C1016d.m6181a("GnssAndNetReceiver", "network observe cnt incrementAndGet:" + this.f56595c.get());
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (this.f56594b != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f56594b = new b();
        C11991a.m72145a().registerReceiver(this.f56594b, intentFilter);
        C1016d.m6186f("GnssAndNetReceiver", "register network receiver");
    }

    /* renamed from: e */
    public void m73377e() {
        SafeBroadcastReceiver safeBroadcastReceiver = this.f56594b;
        if (safeBroadcastReceiver != null) {
            m73379g(safeBroadcastReceiver);
            this.f56594b = null;
            C1016d.m6186f("GnssAndNetReceiver", "unregister network receiver");
        }
        SafeBroadcastReceiver safeBroadcastReceiver2 = this.f56593a;
        if (safeBroadcastReceiver2 != null) {
            m73379g(safeBroadcastReceiver2);
            this.f56593a = null;
            C1016d.m6186f("GnssAndNetReceiver", "unregister gnss receiver");
        }
    }

    /* renamed from: f */
    public void m73378f() {
        if (this.f56595c == null || this.f56594b == null) {
            return;
        }
        synchronized (this.f56597e) {
            try {
                this.f56595c.decrementAndGet();
                C1016d.m6181a("GnssAndNetReceiver", "network observe cnt decrementAndGet:" + this.f56595c.get());
                if (this.f56595c.get() <= 0) {
                    m73379g(this.f56594b);
                    this.f56596d = true;
                    this.f56594b = null;
                    this.f56595c = null;
                    C1016d.m6186f("GnssAndNetReceiver", "unregister network receiver");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public final void m73379g(BroadcastReceiver broadcastReceiver) {
        try {
            C11991a.m72145a().unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e10) {
            C1016d.m6183c("GnssAndNetReceiver", e10.getMessage());
        }
    }
}
