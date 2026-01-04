package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.File;
import java.io.FileNotFoundException;
import p214d2.InterfaceC8994h;
import p599r2.C12459b;
import p759x1.C13684i;
import p759x1.EnumC13676a;
import p795y1.C13902b;

/* loaded from: classes.dex */
public final class MediaStoreFileLoader implements InterfaceC1589f<Uri, File> {

    /* renamed from: a */
    public final Context f6994a;

    public static final class Factory implements InterfaceC8994h<Uri, File> {

        /* renamed from: a */
        public final Context f6995a;

        public Factory(Context context) {
            this.f6995a = context;
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Uri, File> mo9074b(C1591h c1591h) {
            return new MediaStoreFileLoader(this.f6995a);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.MediaStoreFileLoader$a */
    public static class C1583a implements InterfaceC1563d<File> {

        /* renamed from: c */
        public static final String[] f6996c = {"_data"};

        /* renamed from: a */
        public final Context f6997a;

        /* renamed from: b */
        public final Uri f6998b;

        public C1583a(Context context, Uri uri) {
            this.f6997a = context;
            this.f6998b = uri;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: a */
        public Class<File> mo9017a() {
            return File.class;
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
        public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super File> aVar) {
            Cursor cursorQuery = this.f6997a.getContentResolver().query(this.f6998b, f6996c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.mo9031f(new File(string));
                return;
            }
            aVar.mo9030c(new FileNotFoundException("Failed to find file path for: " + this.f6998b));
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f6994a = context;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<File> mo9071b(Uri uri, int i10, int i11, C13684i c13684i) {
        return new InterfaceC1589f.a<>(new C12459b(uri), new C1583a(this.f6994a, uri));
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(Uri uri) {
        return C13902b.m83314b(uri);
    }
}
