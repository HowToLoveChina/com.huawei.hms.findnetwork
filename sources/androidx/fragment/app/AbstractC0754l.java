package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p243e0.C9373h;

/* renamed from: androidx.fragment.app.l */
/* loaded from: classes.dex */
public abstract class AbstractC0754l<E> extends AbstractC0750i {

    /* renamed from: a */
    public final Activity f4059a;

    /* renamed from: b */
    public final Context f4060b;

    /* renamed from: c */
    public final Handler f4061c;

    /* renamed from: d */
    public final int f4062d;

    /* renamed from: e */
    public final FragmentManager f4063e;

    public AbstractC0754l(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    @Override // androidx.fragment.app.AbstractC0750i
    /* renamed from: d */
    public View mo4463d(int i10) {
        return null;
    }

    @Override // androidx.fragment.app.AbstractC0750i
    /* renamed from: e */
    public boolean mo4464e() {
        return true;
    }

    /* renamed from: f */
    public Activity m4797f() {
        return this.f4059a;
    }

    /* renamed from: i */
    public Context m4798i() {
        return this.f4060b;
    }

    /* renamed from: j */
    public Handler m4799j() {
        return this.f4061c;
    }

    /* renamed from: l */
    public void mo4483l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: n */
    public abstract E mo4484n();

    /* renamed from: p */
    public LayoutInflater mo4485p() {
        return LayoutInflater.from(this.f4060b);
    }

    /* renamed from: q */
    public void mo4486q() {
    }

    public AbstractC0754l(Activity activity, Context context, Handler handler, int i10) {
        this.f4063e = new C0762t();
        this.f4059a = activity;
        this.f4060b = (Context) C9373h.m58746g(context, "context == null");
        this.f4061c = (Handler) C9373h.m58746g(handler, "handler == null");
        this.f4062d = i10;
    }
}
