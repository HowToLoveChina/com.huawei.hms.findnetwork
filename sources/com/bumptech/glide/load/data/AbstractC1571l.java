package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import java.io.FileNotFoundException;
import java.io.IOException;
import p759x1.EnumC13676a;

/* renamed from: com.bumptech.glide.load.data.l */
/* loaded from: classes.dex */
public abstract class AbstractC1571l<T> implements InterfaceC1563d<T> {

    /* renamed from: a */
    public final Uri f6963a;

    /* renamed from: b */
    public final ContentResolver f6964b;

    /* renamed from: c */
    public T f6965c;

    public AbstractC1571l(ContentResolver contentResolver, Uri uri) {
        this.f6964b = contentResolver;
        this.f6963a = uri;
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: b */
    public void mo9022b() {
        T t10 = this.f6965c;
        if (t10 != null) {
            try {
                mo9018c(t10);
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: c */
    public abstract void mo9018c(T t10) throws IOException;

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
    public final void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super T> aVar) {
        try {
            T tMo9019f = mo9019f(this.f6963a, this.f6964b);
            this.f6965c = tMo9019f;
            aVar.mo9031f(tMo9019f);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e10);
            }
            aVar.mo9030c(e10);
        }
    }

    /* renamed from: f */
    public abstract T mo9019f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
