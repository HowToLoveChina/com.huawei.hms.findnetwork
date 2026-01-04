package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.InterfaceC0414k;
import p273f0.C9615n0;

/* renamed from: androidx.appcompat.widget.r */
/* loaded from: classes.dex */
public interface InterfaceC0543r {
    /* renamed from: a */
    void mo3006a(Menu menu, InterfaceC0414k.a aVar);

    /* renamed from: b */
    boolean mo3007b();

    /* renamed from: c */
    void mo3008c();

    void collapseActionView();

    /* renamed from: d */
    boolean mo3009d();

    /* renamed from: e */
    boolean mo3010e();

    /* renamed from: f */
    boolean mo3011f();

    /* renamed from: g */
    boolean mo3012g();

    Context getContext();

    CharSequence getTitle();

    /* renamed from: h */
    void mo3013h();

    /* renamed from: i */
    void mo3014i(ScrollingTabContainerView scrollingTabContainerView);

    /* renamed from: j */
    boolean mo3015j();

    /* renamed from: k */
    void mo3016k(int i10);

    /* renamed from: l */
    void mo3017l(int i10);

    /* renamed from: m */
    int mo3018m();

    /* renamed from: n */
    C9615n0 mo3019n(int i10, long j10);

    /* renamed from: o */
    void mo3020o(boolean z10);

    /* renamed from: p */
    int mo3021p();

    /* renamed from: q */
    void mo3022q();

    /* renamed from: r */
    void mo3023r();

    /* renamed from: s */
    void mo3024s(boolean z10);

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setVisibility(int i10);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
