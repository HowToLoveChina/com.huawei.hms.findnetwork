package p366if;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.android.remotecontrol.config.ParamConfig;
import p809yg.C13981a;

/* renamed from: if.a */
/* loaded from: classes4.dex */
public abstract class AbstractC10476a {

    /* renamed from: a */
    public Context f50489a;

    /* renamed from: b */
    public Handler f50490b;

    /* renamed from: c */
    public C10485j f50491c;

    /* renamed from: d */
    public InterfaceC10483h f50492d;

    /* renamed from: e */
    public long f50493e;

    /* renamed from: f */
    public long f50494f;

    /* renamed from: g */
    public int f50495g;

    /* renamed from: h */
    public long f50496h;

    /* renamed from: i */
    public int f50497i;

    /* renamed from: j */
    public C10495t f50498j;

    /* renamed from: if.a$a */
    public static class a extends Handler {

        /* renamed from: a */
        public final AbstractC10476a f50499a;

        public a(AbstractC10476a abstractC10476a) {
            super(Looper.getMainLooper());
            this.f50499a = abstractC10476a;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f50499a == null) {
                C13981a.m83988e("AbstractLocationPolicy", "locate is null");
                return;
            }
            if (message == null) {
                C13981a.m83988e("AbstractLocationPolicy", "msg is null");
                return;
            }
            C13981a.m83989i("AbstractLocationPolicy", "handleMessage: " + message.what);
            int i10 = message.what;
            if (i10 == 0) {
                this.f50499a.mo64385a();
            } else if (i10 == 1) {
                this.f50499a.mo64388d();
            } else if (i10 == 2) {
                this.f50499a.mo64392h();
            } else if (i10 == 3) {
                this.f50499a.mo64386b();
            } else if (i10 == 4) {
                this.f50499a.mo64394j();
            } else if (i10 == 5) {
                this.f50499a.mo64389e(5);
            } else if (i10 == 6) {
                this.f50499a.mo64389e(6);
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: a */
    public abstract void mo64385a();

    /* renamed from: b */
    public abstract void mo64386b();

    /* renamed from: c */
    public void mo64387c() {
        this.f50495g = ParamConfig.getInstance().getGpsLocDisInterval();
        this.f50494f = ParamConfig.getInstance().getGpsTimeOffset();
        this.f50497i = ParamConfig.getInstance().getNetworkLocDisInterval();
        this.f50496h = ParamConfig.getInstance().getNetworkTimeOffset();
    }

    /* renamed from: d */
    public abstract void mo64388d();

    /* renamed from: e */
    public abstract void mo64389e(int i10);

    /* renamed from: f */
    public void m64390f() {
        if (this.f50491c == null || this.f50498j == null) {
            return;
        }
        C13981a.m83989i("AbstractLocationPolicy", "removeUpdates");
        this.f50491c.m64511P(this.f50498j);
        this.f50491c.m64508M(this.f50498j);
    }

    /* renamed from: g */
    public abstract void mo64391g();

    /* renamed from: h */
    public abstract void mo64392h();

    /* renamed from: i */
    public abstract boolean mo64393i(Location location);

    /* renamed from: j */
    public abstract boolean mo64394j();
}
