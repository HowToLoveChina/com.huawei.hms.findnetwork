package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.File;
import java.io.InputStream;
import p214d2.InterfaceC8994h;
import p759x1.C13684i;

/* renamed from: com.bumptech.glide.load.model.j */
/* loaded from: classes.dex */
public class C1593j<Data> implements InterfaceC1589f<String, Data> {

    /* renamed from: a */
    public final InterfaceC1589f<Uri, Data> f7048a;

    /* renamed from: com.bumptech.glide.load.model.j$a */
    public static final class a implements InterfaceC8994h<String, AssetFileDescriptor> {
        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<String, AssetFileDescriptor> mo9074b(C1591h c1591h) {
            return new C1593j(c1591h.m9105d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* renamed from: com.bumptech.glide.load.model.j$b */
    public static class b implements InterfaceC8994h<String, ParcelFileDescriptor> {
        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<String, ParcelFileDescriptor> mo9074b(C1591h c1591h) {
            return new C1593j(c1591h.m9105d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* renamed from: com.bumptech.glide.load.model.j$c */
    public static class c implements InterfaceC8994h<String, InputStream> {
        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<String, InputStream> mo9074b(C1591h c1591h) {
            return new C1593j(c1591h.m9105d(Uri.class, InputStream.class));
        }
    }

    public C1593j(InterfaceC1589f<Uri, Data> interfaceC1589f) {
        this.f7048a = interfaceC1589f;
    }

    /* renamed from: e */
    public static Uri m9114e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return m9115f(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? m9115f(str) : uri;
    }

    /* renamed from: f */
    public static Uri m9115f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<Data> mo9071b(String str, int i10, int i11, C13684i c13684i) {
        Uri uriM9114e = m9114e(str);
        if (uriM9114e == null || !this.f7048a.mo9070a(uriM9114e)) {
            return null;
        }
        return this.f7048a.mo9071b(uriM9114e, i10, i11, c13684i);
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(String str) {
        return true;
    }
}
