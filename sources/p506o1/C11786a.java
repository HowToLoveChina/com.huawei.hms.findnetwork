package p506o1;

import android.content.Context;
import android.os.Vibrator;
import android.p018os.HapticPlayer;
import com.apprichtap.haptic.player.C1515d;
import p629s1.C12665d;
import p644t1.C12917e;
import p644t1.C12919g;
import p644t1.InterfaceC12914b;
import p644t1.InterfaceC12915c;
import p665u1.InterfaceC13109a;

/* renamed from: o1.a */
/* loaded from: classes.dex */
public class C11786a implements InterfaceC12915c {

    /* renamed from: a */
    public Context f54592a;

    /* renamed from: b */
    public Vibrator f54593b;

    /* renamed from: c */
    public InterfaceC12915c f54594c;

    /* renamed from: d */
    public C1515d f54595d;

    public C11786a(Context context, int i10) {
        C11786a c11786a;
        this.f54592a = context.getApplicationContext();
        this.f54593b = (Vibrator) context.getSystemService("vibrator");
        C1515d c1515d = new C1515d(this.f54592a);
        this.f54595d = c1515d;
        if (i10 == 0) {
            c11786a = new C11786a(new C12917e(this.f54593b));
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    C12665d.a.m76245d("RichTapPlayer", "unknown player type:" + i10);
                } else {
                    this.f54594c = new C11786a(c1515d);
                }
                C12665d.f58160b = this.f54592a;
            }
            c11786a = new C11786a(new C12919g());
        }
        this.f54594c = c11786a;
        C12665d.f58160b = this.f54592a;
    }

    /* renamed from: d */
    public static C11786a m70246d(Context context, int i10) {
        if (context == null) {
            C12665d.a.m76243b("RichTapPlayer", "context == null");
            return null;
        }
        if (m70248f(i10)) {
            return new C11786a(context, i10);
        }
        C12665d.a.m76243b("RichTapPlayer", "specified player type not available!");
        return null;
    }

    /* renamed from: e */
    public static int m70247e(Context context) {
        try {
            if (context != null) {
                return new C1515d(context).mo8621d();
            }
            C12665d.a.m76243b("RichTapPlayer", "getRichTapCoreMajorVersion, null == context");
            return -1;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    /* renamed from: f */
    public static boolean m70248f(int i10) {
        if (i10 == 0) {
            return true;
        }
        try {
            if (i10 == 1) {
                return HapticPlayer.isAvailable();
            }
            if (i10 != 2) {
                return false;
            }
            return C1515d.m8617f();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    @Override // p644t1.InterfaceC12915c
    /* renamed from: a */
    public void mo70249a() {
        InterfaceC12915c interfaceC12915c = this.f54594c;
        if (interfaceC12915c == null) {
            C12665d.a.m76243b("RichTapPlayer", "null == mPlayer!");
        } else {
            interfaceC12915c.mo70249a();
        }
    }

    @Override // p644t1.InterfaceC12915c
    /* renamed from: b */
    public void mo70250b(String str, int i10, int i11, int i12, int i13, InterfaceC13109a interfaceC13109a) {
        InterfaceC12915c interfaceC12915c = this.f54594c;
        if (interfaceC12915c == null) {
            C12665d.a.m76243b("RichTapPlayer", "null == mPlayer!");
        } else {
            interfaceC12915c.mo70250b(str, i10, i11, i12, i13, interfaceC13109a);
        }
    }

    @Override // p644t1.InterfaceC12915c
    public boolean isPlaying() {
        InterfaceC12915c interfaceC12915c = this.f54594c;
        if (interfaceC12915c != null) {
            return interfaceC12915c.isPlaying();
        }
        C12665d.a.m76243b("RichTapPlayer", "null == mPlayer!");
        return false;
    }

    @Override // p644t1.InterfaceC12915c
    public void release() {
        InterfaceC12915c interfaceC12915c = this.f54594c;
        if (interfaceC12915c != null) {
            interfaceC12915c.release();
        }
        this.f54594c = null;
    }

    @Override // p644t1.InterfaceC12915c
    public void reset() {
        InterfaceC12915c interfaceC12915c = this.f54594c;
        if (interfaceC12915c == null) {
            C12665d.a.m76243b("RichTapPlayer", "null == mPlayer!");
        } else {
            interfaceC12915c.reset();
        }
    }

    @Override // p644t1.InterfaceC12915c
    public void start() {
        InterfaceC12915c interfaceC12915c = this.f54594c;
        if (interfaceC12915c == null) {
            C12665d.a.m76243b("RichTapPlayer", "null == mPlayer!");
        } else {
            interfaceC12915c.start();
        }
    }

    @Override // p644t1.InterfaceC12915c
    public void stop() {
        InterfaceC12915c interfaceC12915c = this.f54594c;
        if (interfaceC12915c == null) {
            C12665d.a.m76243b("RichTapPlayer", "null == mPlayer!");
        } else {
            interfaceC12915c.stop();
        }
    }

    public C11786a(InterfaceC12914b interfaceC12914b) {
        this.f54594c = InterfaceC12915c.m77552c(interfaceC12914b);
    }
}
