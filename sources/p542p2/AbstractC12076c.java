package p542p2;

import android.graphics.drawable.Drawable;
import p507o2.InterfaceC11790c;
import p630s2.C12677l;

/* renamed from: p2.c */
/* loaded from: classes.dex */
public abstract class AbstractC12076c<T> implements InterfaceC12082i<T> {

    /* renamed from: a */
    public final int f55893a;

    /* renamed from: b */
    public final int f55894b;

    /* renamed from: c */
    public InterfaceC11790c f55895c;

    public AbstractC12076c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: a */
    public final InterfaceC11790c mo72224a() {
        return this.f55895c;
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: b */
    public final void mo72230b(InterfaceC12081h interfaceC12081h) {
        interfaceC12081h.mo70289d(this.f55893a, this.f55894b);
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: d */
    public final void mo72231d(InterfaceC12081h interfaceC12081h) {
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: e */
    public final void mo72225e(InterfaceC11790c interfaceC11790c) {
        this.f55895c = interfaceC11790c;
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: f */
    public void mo72226f(Drawable drawable) {
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: g */
    public void mo72227g(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public void onStop() {
    }

    public AbstractC12076c(int i10, int i11) {
        if (C12677l.m76296s(i10, i11)) {
            this.f55893a = i10;
            this.f55894b = i11;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i10 + " and height: " + i11);
    }
}
