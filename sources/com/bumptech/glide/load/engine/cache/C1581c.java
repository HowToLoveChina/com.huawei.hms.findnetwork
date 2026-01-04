package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.InterfaceC1579a;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.c */
/* loaded from: classes.dex */
public class C1581c implements InterfaceC1579a.a {

    /* renamed from: a */
    public final long f6987a;

    /* renamed from: b */
    public final a f6988b;

    /* renamed from: com.bumptech.glide.load.engine.cache.c$a */
    public interface a {
        /* renamed from: a */
        File mo9054a();
    }

    public C1581c(a aVar, long j10) {
        this.f6987a = j10;
        this.f6988b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.cache.InterfaceC1579a.a
    public InterfaceC1579a build() {
        File fileMo9054a = this.f6988b.mo9054a();
        if (fileMo9054a == null) {
            return null;
        }
        if (fileMo9054a.isDirectory() || fileMo9054a.mkdirs()) {
            return C1582d.m9068c(fileMo9054a, this.f6987a);
        }
        return null;
    }
}
