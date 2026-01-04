package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.model.InterfaceC1589f;
import com.huawei.hms.network.embedded.C5929g4;
import java.io.InputStream;
import p214d2.InterfaceC8994h;
import p759x1.C13684i;

/* renamed from: com.bumptech.glide.load.model.i */
/* loaded from: classes.dex */
public class C1592i<Data> implements InterfaceC1589f<Integer, Data> {

    /* renamed from: a */
    public final InterfaceC1589f<Uri, Data> f7042a;

    /* renamed from: b */
    public final Resources f7043b;

    /* renamed from: com.bumptech.glide.load.model.i$a */
    public static final class a implements InterfaceC8994h<Integer, AssetFileDescriptor> {

        /* renamed from: a */
        public final Resources f7044a;

        public a(Resources resources) {
            this.f7044a = resources;
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Integer, AssetFileDescriptor> mo9074b(C1591h c1591h) {
            return new C1592i(this.f7044a, c1591h.m9105d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* renamed from: com.bumptech.glide.load.model.i$b */
    public static class b implements InterfaceC8994h<Integer, ParcelFileDescriptor> {

        /* renamed from: a */
        public final Resources f7045a;

        public b(Resources resources) {
            this.f7045a = resources;
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Integer, ParcelFileDescriptor> mo9074b(C1591h c1591h) {
            return new C1592i(this.f7045a, c1591h.m9105d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* renamed from: com.bumptech.glide.load.model.i$c */
    public static class c implements InterfaceC8994h<Integer, InputStream> {

        /* renamed from: a */
        public final Resources f7046a;

        public c(Resources resources) {
            this.f7046a = resources;
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Integer, InputStream> mo9074b(C1591h c1591h) {
            return new C1592i(this.f7046a, c1591h.m9105d(Uri.class, InputStream.class));
        }
    }

    /* renamed from: com.bumptech.glide.load.model.i$d */
    public static class d implements InterfaceC8994h<Integer, Uri> {

        /* renamed from: a */
        public final Resources f7047a;

        public d(Resources resources) {
            this.f7047a = resources;
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Integer, Uri> mo9074b(C1591h c1591h) {
            return new C1592i(this.f7047a, C1594k.m9118c());
        }
    }

    public C1592i(Resources resources, InterfaceC1589f<Uri, Data> interfaceC1589f) {
        this.f7043b = resources;
        this.f7042a = interfaceC1589f;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<Data> mo9071b(Integer num, int i10, int i11, C13684i c13684i) {
        Uri uriM9112d = m9112d(num);
        if (uriM9112d == null) {
            return null;
        }
        return this.f7042a.mo9071b(uriM9112d, i10, i11, c13684i);
    }

    /* renamed from: d */
    public final Uri m9112d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f7043b.getResourcePackageName(num.intValue()) + C5929g4.f26852n + this.f7043b.getResourceTypeName(num.intValue()) + C5929g4.f26852n + this.f7043b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e10) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e10);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(Integer num) {
        return true;
    }
}
