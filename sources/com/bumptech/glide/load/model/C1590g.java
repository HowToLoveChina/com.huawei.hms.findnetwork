package com.bumptech.glide.load.model;

import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p243e0.InterfaceC9370e;
import p630s2.C12676k;
import p759x1.C13684i;
import p759x1.EnumC13676a;
import p759x1.InterfaceC13681f;
import p829z1.C14078q;

/* renamed from: com.bumptech.glide.load.model.g */
/* loaded from: classes.dex */
public class C1590g<Model, Data> implements InterfaceC1589f<Model, Data> {

    /* renamed from: a */
    public final List<InterfaceC1589f<Model, Data>> f7024a;

    /* renamed from: b */
    public final InterfaceC9370e<List<Throwable>> f7025b;

    /* renamed from: com.bumptech.glide.load.model.g$a */
    public static class a<Data> implements InterfaceC1563d<Data>, InterfaceC1563d.a<Data> {

        /* renamed from: a */
        public final List<InterfaceC1563d<Data>> f7026a;

        /* renamed from: b */
        public final InterfaceC9370e<List<Throwable>> f7027b;

        /* renamed from: c */
        public int f7028c;

        /* renamed from: d */
        public EnumC1551g f7029d;

        /* renamed from: e */
        public InterfaceC1563d.a<? super Data> f7030e;

        /* renamed from: f */
        public List<Throwable> f7031f;

        /* renamed from: g */
        public boolean f7032g;

        public a(List<InterfaceC1563d<Data>> list, InterfaceC9370e<List<Throwable>> interfaceC9370e) {
            this.f7027b = interfaceC9370e;
            C12676k.m76275c(list);
            this.f7026a = list;
            this.f7028c = 0;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: a */
        public Class<Data> mo9017a() {
            return this.f7026a.get(0).mo9017a();
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: b */
        public void mo9022b() {
            List<Throwable> list = this.f7031f;
            if (list != null) {
                this.f7027b.mo58737a(list);
            }
            this.f7031f = null;
            Iterator<InterfaceC1563d<Data>> it = this.f7026a.iterator();
            while (it.hasNext()) {
                it.next().mo9022b();
            }
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d.a
        /* renamed from: c */
        public void mo9030c(Exception exc) {
            ((List) C12676k.m76276d(this.f7031f)).add(exc);
            m9100g();
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        public void cancel() {
            this.f7032g = true;
            Iterator<InterfaceC1563d<Data>> it = this.f7026a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: d */
        public EnumC13676a mo9024d() {
            return this.f7026a.get(0).mo9024d();
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: e */
        public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super Data> aVar) {
            this.f7029d = enumC1551g;
            this.f7030e = aVar;
            this.f7031f = this.f7027b.mo58738b();
            this.f7026a.get(this.f7028c).mo9025e(enumC1551g, this);
            if (this.f7032g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d.a
        /* renamed from: f */
        public void mo9031f(Data data) {
            if (data != null) {
                this.f7030e.mo9031f(data);
            } else {
                m9100g();
            }
        }

        /* renamed from: g */
        public final void m9100g() {
            if (this.f7032g) {
                return;
            }
            if (this.f7028c < this.f7026a.size() - 1) {
                this.f7028c++;
                mo9025e(this.f7029d, this.f7030e);
            } else {
                C12676k.m76276d(this.f7031f);
                this.f7030e.mo9030c(new C14078q("Fetch failed", new ArrayList(this.f7031f)));
            }
        }
    }

    public C1590g(List<InterfaceC1589f<Model, Data>> list, InterfaceC9370e<List<Throwable>> interfaceC9370e) {
        this.f7024a = list;
        this.f7025b = interfaceC9370e;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: a */
    public boolean mo9070a(Model model) {
        Iterator<InterfaceC1589f<Model, Data>> it = this.f7024a.iterator();
        while (it.hasNext()) {
            if (it.next().mo9070a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: b */
    public InterfaceC1589f.a<Data> mo9071b(Model model, int i10, int i11, C13684i c13684i) {
        InterfaceC1589f.a<Data> aVarMo9071b;
        int size = this.f7024a.size();
        ArrayList arrayList = new ArrayList(size);
        InterfaceC13681f interfaceC13681f = null;
        for (int i12 = 0; i12 < size; i12++) {
            InterfaceC1589f<Model, Data> interfaceC1589f = this.f7024a.get(i12);
            if (interfaceC1589f.mo9070a(model) && (aVarMo9071b = interfaceC1589f.mo9071b(model, i10, i11, c13684i)) != null) {
                interfaceC13681f = aVarMo9071b.f7021a;
                arrayList.add(aVarMo9071b.f7023c);
            }
        }
        if (arrayList.isEmpty() || interfaceC13681f == null) {
            return null;
        }
        return new InterfaceC1589f.a<>(interfaceC13681f, new a(arrayList, this.f7025b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f7024a.toArray()) + '}';
    }
}
