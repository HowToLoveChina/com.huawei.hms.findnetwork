package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.C1591h;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.InputStream;
import p214d2.InterfaceC8994h;
import p599r2.C12459b;
import p759x1.C13684i;
import p795y1.C13902b;
import p795y1.C13903c;

/* loaded from: classes.dex */
public class MediaStoreImageThumbLoader implements InterfaceC1589f<Uri, InputStream> {

    /* renamed from: a */
    public final Context f7059a;

    public static class Factory implements InterfaceC8994h<Uri, InputStream> {

        /* renamed from: a */
        public final Context f7060a;

        public Factory(Context context) {
            this.f7060a = context;
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Uri, InputStream> mo9074b(C1591h c1591h) {
            return new MediaStoreImageThumbLoader(this.f7060a);
        }
    }

    public MediaStoreImageThumbLoader(Context context) {
        this.f7059a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<InputStream> mo9071b(Uri uri, int i10, int i11, C13684i c13684i) {
        if (C13902b.m83316d(i10, i11)) {
            return new InterfaceC1589f.a<>(new C12459b(uri), C13903c.m83319f(this.f7059a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(Uri uri) {
        return C13902b.m83313a(uri);
    }
}
