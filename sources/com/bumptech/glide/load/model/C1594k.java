package com.bumptech.glide.load.model;

import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import p214d2.InterfaceC8994h;
import p599r2.C12459b;
import p759x1.C13684i;
import p759x1.EnumC13676a;

/* renamed from: com.bumptech.glide.load.model.k */
/* loaded from: classes.dex */
public class C1594k<Model> implements InterfaceC1589f<Model, Model> {

    /* renamed from: a */
    public static final C1594k<?> f7049a = new C1594k<>();

    /* renamed from: com.bumptech.glide.load.model.k$a */
    public static class a<Model> implements InterfaceC8994h<Model, Model> {

        /* renamed from: a */
        public static final a<?> f7050a = new a<>();

        @Deprecated
        public a() {
        }

        /* renamed from: a */
        public static <T> a<T> m9119a() {
            return (a<T>) f7050a;
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Model, Model> mo9074b(C1591h c1591h) {
            return C1594k.m9118c();
        }
    }

    /* renamed from: com.bumptech.glide.load.model.k$b */
    public static class b<Model> implements InterfaceC1563d<Model> {

        /* renamed from: a */
        public final Model f7051a;

        public b(Model model) {
            this.f7051a = model;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: a */
        public Class<Model> mo9017a() {
            return (Class<Model>) this.f7051a.getClass();
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: b */
        public void mo9022b() {
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: d */
        public EnumC13676a mo9024d() {
            return EnumC13676a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: e */
        public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super Model> aVar) {
            aVar.mo9031f(this.f7051a);
        }
    }

    @Deprecated
    public C1594k() {
    }

    /* renamed from: c */
    public static <T> C1594k<T> m9118c() {
        return (C1594k<T>) f7049a;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: a */
    public boolean mo9070a(Model model) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: b */
    public InterfaceC1589f.a<Model> mo9071b(Model model, int i10, int i11, C13684i c13684i) {
        return new InterfaceC1589f.a<>(new C12459b(model), new b(model));
    }
}
