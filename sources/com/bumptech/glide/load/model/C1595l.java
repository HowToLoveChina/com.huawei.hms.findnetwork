package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.C1560a;
import com.bumptech.glide.load.data.C1568i;
import com.bumptech.glide.load.data.C1573n;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p214d2.InterfaceC8994h;
import p599r2.C12459b;
import p759x1.C13684i;

/* renamed from: com.bumptech.glide.load.model.l */
/* loaded from: classes.dex */
public class C1595l<Data> implements InterfaceC1589f<Uri, Data> {

    /* renamed from: b */
    public static final Set<String> f7052b = Collections.unmodifiableSet(new HashSet(Arrays.asList(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, "android.resource", "content")));

    /* renamed from: a */
    public final c<Data> f7053a;

    /* renamed from: com.bumptech.glide.load.model.l$a */
    public static final class a implements InterfaceC8994h<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a */
        public final ContentResolver f7054a;

        public a(ContentResolver contentResolver) {
            this.f7054a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.C1595l.c
        /* renamed from: a */
        public InterfaceC1563d<AssetFileDescriptor> mo9122a(Uri uri) {
            return new C1560a(this.f7054a, uri);
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Uri, AssetFileDescriptor> mo9074b(C1591h c1591h) {
            return new C1595l(this);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.l$b */
    public static class b implements InterfaceC8994h<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a */
        public final ContentResolver f7055a;

        public b(ContentResolver contentResolver) {
            this.f7055a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.C1595l.c
        /* renamed from: a */
        public InterfaceC1563d<ParcelFileDescriptor> mo9122a(Uri uri) {
            return new C1568i(this.f7055a, uri);
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Uri, ParcelFileDescriptor> mo9074b(C1591h c1591h) {
            return new C1595l(this);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.l$c */
    public interface c<Data> {
        /* renamed from: a */
        InterfaceC1563d<Data> mo9122a(Uri uri);
    }

    /* renamed from: com.bumptech.glide.load.model.l$d */
    public static class d implements InterfaceC8994h<Uri, InputStream>, c<InputStream> {

        /* renamed from: a */
        public final ContentResolver f7056a;

        public d(ContentResolver contentResolver) {
            this.f7056a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.C1595l.c
        /* renamed from: a */
        public InterfaceC1563d<InputStream> mo9122a(Uri uri) {
            return new C1573n(this.f7056a, uri);
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Uri, InputStream> mo9074b(C1591h c1591h) {
            return new C1595l(this);
        }
    }

    public C1595l(c<Data> cVar) {
        this.f7053a = cVar;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<Data> mo9071b(Uri uri, int i10, int i11, C13684i c13684i) {
        return new InterfaceC1589f.a<>(new C12459b(uri), this.f7053a.mo9122a(uri));
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(Uri uri) {
        return f7052b.contains(uri.getScheme());
    }
}
