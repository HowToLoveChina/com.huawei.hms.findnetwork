package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p214d2.C8988b;
import p214d2.InterfaceC8994h;
import p759x1.C13684i;

/* renamed from: com.bumptech.glide.load.model.m */
/* loaded from: classes.dex */
public class C1596m<Data> implements InterfaceC1589f<Uri, Data> {

    /* renamed from: b */
    public static final Set<String> f7057b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a */
    public final InterfaceC1589f<C8988b, Data> f7058a;

    /* renamed from: com.bumptech.glide.load.model.m$a */
    public static class a implements InterfaceC8994h<Uri, InputStream> {
        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Uri, InputStream> mo9074b(C1591h c1591h) {
            return new C1596m(c1591h.m9105d(C8988b.class, InputStream.class));
        }
    }

    public C1596m(InterfaceC1589f<C8988b, Data> interfaceC1589f) {
        this.f7058a = interfaceC1589f;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<Data> mo9071b(Uri uri, int i10, int i11, C13684i c13684i) {
        return this.f7058a.mo9071b(new C8988b(uri.toString()), i10, i11, c13684i);
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(Uri uri) {
        return f7057b.contains(uri.getScheme());
    }
}
