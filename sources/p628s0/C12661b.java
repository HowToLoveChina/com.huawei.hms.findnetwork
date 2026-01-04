package p628s0;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.AbstractC0780b0;
import androidx.lifecycle.C0782c0;
import androidx.lifecycle.C0786e0;
import androidx.lifecycle.C0801q;
import androidx.lifecycle.InterfaceC0796l;
import androidx.lifecycle.InterfaceC0802r;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p243e0.C9367b;
import p438l.C11214h;

/* renamed from: s0.b */
/* loaded from: classes.dex */
public class C12661b extends AbstractC12660a {

    /* renamed from: c */
    public static boolean f58144c = false;

    /* renamed from: a */
    public final InterfaceC0796l f58145a;

    /* renamed from: b */
    public final b f58146b;

    /* renamed from: s0.b$a */
    public static class a<D> extends C0801q<D> implements Loader.InterfaceC0813b<D> {

        /* renamed from: l */
        public final int f58147l;

        /* renamed from: m */
        public final Bundle f58148m;

        /* renamed from: n */
        public final Loader<D> f58149n;

        /* renamed from: o */
        public InterfaceC0796l f58150o;

        /* renamed from: p */
        public Loader<D> f58151p;

        @Override // androidx.loader.content.Loader.InterfaceC0813b
        /* renamed from: a */
        public void mo5049a(Loader<D> loader, D d10) {
            if (C12661b.f58144c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                mo4896n(d10);
                return;
            }
            if (C12661b.f58144c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            mo4894l(d10);
        }

        @Override // androidx.lifecycle.LiveData
        /* renamed from: j */
        public void mo4892j() {
            if (C12661b.f58144c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f58149n.m5045v();
        }

        @Override // androidx.lifecycle.LiveData
        /* renamed from: k */
        public void mo4893k() {
            if (C12661b.f58144c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f58149n.m5046w();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        /* renamed from: m */
        public void mo4895m(InterfaceC0802r<? super D> interfaceC0802r) {
            super.mo4895m(interfaceC0802r);
            this.f58150o = null;
        }

        @Override // androidx.lifecycle.C0801q, androidx.lifecycle.LiveData
        /* renamed from: n */
        public void mo4896n(D d10) {
            super.mo4896n(d10);
            Loader<D> loader = this.f58151p;
            if (loader != null) {
                loader.m5043t();
                this.f58151p = null;
            }
        }

        /* renamed from: o */
        public Loader<D> m76207o(boolean z10) {
            if (C12661b.f58144c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f58149n.m5032b();
            this.f58149n.m5031a();
            this.f58149n.m5048y(this);
            if (!z10) {
                return this.f58149n;
            }
            this.f58149n.m5043t();
            return this.f58151p;
        }

        /* renamed from: p */
        public void m76208p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f58147l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f58148m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f58149n);
            this.f58149n.mo5016g(str + "  ", fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(m76209q().m5034d(m4888f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(m4889g());
        }

        /* renamed from: q */
        public Loader<D> m76209q() {
            return this.f58149n;
        }

        /* renamed from: r */
        public void m76210r() {
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f58147l);
            sb2.append(" : ");
            C9367b.m58728a(this.f58149n, sb2);
            sb2.append("}}");
            return sb2.toString();
        }
    }

    /* renamed from: s0.b$b */
    public static class b extends AbstractC0780b0 {

        /* renamed from: f */
        public static final C0782c0.b f58152f = new a();

        /* renamed from: d */
        public C11214h<a> f58153d = new C11214h<>();

        /* renamed from: e */
        public boolean f58154e = false;

        /* renamed from: s0.b$b$a */
        public static class a implements C0782c0.b {
            @Override // androidx.lifecycle.C0782c0.b
            /* renamed from: a */
            public <T extends AbstractC0780b0> T mo4828a(Class<T> cls) {
                return new b();
            }
        }

        /* renamed from: g */
        public static b m76211g(C0786e0 c0786e0) {
            return (b) new C0782c0(c0786e0, f58152f).m4929a(b.class);
        }

        @Override // androidx.lifecycle.AbstractC0780b0
        /* renamed from: d */
        public void mo4815d() {
            super.mo4815d();
            int iM67346n = this.f58153d.m67346n();
            for (int i10 = 0; i10 < iM67346n; i10++) {
                this.f58153d.m67347o(i10).m76207o(true);
            }
            this.f58153d.m67337c();
        }

        /* renamed from: f */
        public void m76212f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f58153d.m67346n() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f58153d.m67346n(); i10++) {
                    a aVarM67347o = this.f58153d.m67347o(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f58153d.m67343k(i10));
                    printWriter.print(": ");
                    printWriter.println(aVarM67347o.toString());
                    aVarM67347o.m76208p(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* renamed from: h */
        public void m76213h() {
            int iM67346n = this.f58153d.m67346n();
            for (int i10 = 0; i10 < iM67346n; i10++) {
                this.f58153d.m67347o(i10).m76210r();
            }
        }
    }

    public C12661b(InterfaceC0796l interfaceC0796l, C0786e0 c0786e0) {
        this.f58145a = interfaceC0796l;
        this.f58146b = b.m76211g(c0786e0);
    }

    @Override // p628s0.AbstractC12660a
    @Deprecated
    /* renamed from: a */
    public void mo76205a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f58146b.m76212f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // p628s0.AbstractC12660a
    /* renamed from: c */
    public void mo76206c() {
        this.f58146b.m76213h();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        C9367b.m58728a(this.f58145a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
