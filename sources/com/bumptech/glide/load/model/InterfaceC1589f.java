package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.InterfaceC1563d;
import java.util.Collections;
import java.util.List;
import p630s2.C12676k;
import p759x1.C13684i;
import p759x1.InterfaceC13681f;

/* renamed from: com.bumptech.glide.load.model.f */
/* loaded from: classes.dex */
public interface InterfaceC1589f<Model, Data> {

    /* renamed from: com.bumptech.glide.load.model.f$a */
    public static class a<Data> {

        /* renamed from: a */
        public final InterfaceC13681f f7021a;

        /* renamed from: b */
        public final List<InterfaceC13681f> f7022b;

        /* renamed from: c */
        public final InterfaceC1563d<Data> f7023c;

        public a(InterfaceC13681f interfaceC13681f, InterfaceC1563d<Data> interfaceC1563d) {
            this(interfaceC13681f, Collections.emptyList(), interfaceC1563d);
        }

        public a(InterfaceC13681f interfaceC13681f, List<InterfaceC13681f> list, InterfaceC1563d<Data> interfaceC1563d) {
            this.f7021a = (InterfaceC13681f) C12676k.m76276d(interfaceC13681f);
            this.f7022b = (List) C12676k.m76276d(list);
            this.f7023c = (InterfaceC1563d) C12676k.m76276d(interfaceC1563d);
        }
    }

    /* renamed from: a */
    boolean mo9070a(Model model);

    /* renamed from: b */
    a<Data> mo9071b(Model model, int i10, int i11, C13684i c13684i);
}
