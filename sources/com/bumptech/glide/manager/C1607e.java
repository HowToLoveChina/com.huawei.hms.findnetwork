package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.manager.InterfaceC1605c;

/* renamed from: com.bumptech.glide.manager.e */
/* loaded from: classes.dex */
public final class C1607e implements InterfaceC1605c {

    /* renamed from: a */
    public final Context f7114a;

    /* renamed from: b */
    public final InterfaceC1605c.a f7115b;

    public C1607e(Context context, InterfaceC1605c.a aVar) {
        this.f7114a = context.getApplicationContext();
        this.f7115b = aVar;
    }

    /* renamed from: i */
    public final void m9189i() {
        C1621s.m9220a(this.f7114a).m9223d(this.f7115b);
    }

    /* renamed from: j */
    public final void m9190j() {
        C1621s.m9220a(this.f7114a).m9224e(this.f7115b);
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public void onStart() {
        m9189i();
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public void onStop() {
        m9190j();
    }
}
