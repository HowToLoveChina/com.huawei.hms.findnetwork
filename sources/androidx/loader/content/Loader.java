package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p243e0.C9367b;

/* loaded from: classes.dex */
public class Loader<D> {

    /* renamed from: a */
    public int f4239a;

    /* renamed from: b */
    public InterfaceC0813b<D> f4240b;

    /* renamed from: c */
    public Context f4241c;

    /* renamed from: d */
    public boolean f4242d = false;

    /* renamed from: e */
    public boolean f4243e = false;

    /* renamed from: f */
    public boolean f4244f = true;

    /* renamed from: g */
    public boolean f4245g = false;

    /* renamed from: h */
    public boolean f4246h = false;

    /* renamed from: androidx.loader.content.Loader$a */
    public final class C0812a extends ContentObserver {
        public C0812a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            Loader.this.m5042o();
        }
    }

    /* renamed from: androidx.loader.content.Loader$b */
    public interface InterfaceC0813b<D> {
        /* renamed from: a */
        void mo5049a(Loader<D> loader, D d10);
    }

    public Loader(Context context) {
        this.f4241c = context.getApplicationContext();
    }

    /* renamed from: a */
    public void m5031a() {
        this.f4243e = true;
        m5041m();
    }

    /* renamed from: b */
    public boolean m5032b() {
        return mo5017n();
    }

    /* renamed from: c */
    public void m5033c() {
        this.f4246h = false;
    }

    /* renamed from: d */
    public String m5034d(D d10) {
        StringBuilder sb2 = new StringBuilder(64);
        C9367b.m58728a(d10, sb2);
        sb2.append("}");
        return sb2.toString();
    }

    /* renamed from: e */
    public void m5035e() {
    }

    /* renamed from: f */
    public void mo5027f(D d10) {
        InterfaceC0813b<D> interfaceC0813b = this.f4240b;
        if (interfaceC0813b != null) {
            interfaceC0813b.mo5049a(this, d10);
        }
    }

    @Deprecated
    /* renamed from: g */
    public void mo5016g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f4239a);
        printWriter.print(" mListener=");
        printWriter.println(this.f4240b);
        if (this.f4242d || this.f4245g || this.f4246h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f4242d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f4245g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f4246h);
        }
        if (this.f4243e || this.f4244f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f4243e);
            printWriter.print(" mReset=");
            printWriter.println(this.f4244f);
        }
    }

    /* renamed from: h */
    public void m5036h() {
        mo5018p();
    }

    /* renamed from: i */
    public Context m5037i() {
        return this.f4241c;
    }

    /* renamed from: j */
    public boolean m5038j() {
        return this.f4243e;
    }

    /* renamed from: k */
    public boolean m5039k() {
        return this.f4244f;
    }

    /* renamed from: l */
    public boolean m5040l() {
        return this.f4242d;
    }

    /* renamed from: m */
    public void m5041m() {
    }

    /* renamed from: n */
    public boolean mo5017n() {
        return false;
    }

    /* renamed from: o */
    public void m5042o() {
        if (this.f4242d) {
            m5036h();
        } else {
            this.f4245g = true;
        }
    }

    /* renamed from: p */
    public void mo5018p() {
    }

    /* renamed from: q */
    public void mo5028q() {
    }

    /* renamed from: r */
    public void mo5029r() {
    }

    /* renamed from: s */
    public void mo5030s() {
    }

    /* renamed from: t */
    public void m5043t() {
        mo5028q();
        this.f4244f = true;
        this.f4242d = false;
        this.f4243e = false;
        this.f4245g = false;
        this.f4246h = false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        C9367b.m58728a(this, sb2);
        sb2.append(" id=");
        sb2.append(this.f4239a);
        sb2.append("}");
        return sb2.toString();
    }

    /* renamed from: u */
    public void m5044u() {
        if (this.f4246h) {
            m5042o();
        }
    }

    /* renamed from: v */
    public final void m5045v() {
        this.f4242d = true;
        this.f4244f = false;
        this.f4243e = false;
        mo5029r();
    }

    /* renamed from: w */
    public void m5046w() {
        this.f4242d = false;
        mo5030s();
    }

    /* renamed from: x */
    public boolean m5047x() {
        boolean z10 = this.f4245g;
        this.f4245g = false;
        this.f4246h |= z10;
        return z10;
    }

    /* renamed from: y */
    public void m5048y(InterfaceC0813b<D> interfaceC0813b) {
        InterfaceC0813b<D> interfaceC0813b2 = this.f4240b;
        if (interfaceC0813b2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0813b2 != interfaceC0813b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f4240b = null;
    }
}
