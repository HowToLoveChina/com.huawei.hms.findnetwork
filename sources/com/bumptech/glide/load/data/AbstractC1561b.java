package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import java.io.IOException;
import p759x1.EnumC13676a;

/* renamed from: com.bumptech.glide.load.data.b */
/* loaded from: classes.dex */
public abstract class AbstractC1561b<T> implements InterfaceC1563d<T> {

    /* renamed from: a */
    public final String f6939a;

    /* renamed from: b */
    public final AssetManager f6940b;

    /* renamed from: c */
    public T f6941c;

    public AbstractC1561b(AssetManager assetManager, String str) {
        this.f6940b = assetManager;
        this.f6939a = str;
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: b */
    public void mo9022b() {
        T t10 = this.f6941c;
        if (t10 == null) {
            return;
        }
        try {
            mo9023c(t10);
        } catch (IOException unused) {
        }
    }

    /* renamed from: c */
    public abstract void mo9023c(T t10) throws IOException;

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
    public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super T> aVar) {
        try {
            T tMo9026f = mo9026f(this.f6940b, this.f6939a);
            this.f6941c = tMo9026f;
            aVar.mo9031f(tMo9026f);
        } catch (IOException e10) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e10);
            }
            aVar.mo9030c(e10);
        }
    }

    /* renamed from: f */
    public abstract T mo9026f(AssetManager assetManager, String str) throws IOException;
}
