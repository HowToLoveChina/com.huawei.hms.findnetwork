package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.data.C1567h;
import com.bumptech.glide.load.data.C1572m;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import java.io.InputStream;
import p214d2.InterfaceC8994h;
import p599r2.C12459b;
import p759x1.C13684i;

/* renamed from: com.bumptech.glide.load.model.a */
/* loaded from: classes.dex */
public class C1584a<Data> implements InterfaceC1589f<Uri, Data> {

    /* renamed from: c */
    public static final int f6999c = 22;

    /* renamed from: a */
    public final AssetManager f7000a;

    /* renamed from: b */
    public final a<Data> f7001b;

    /* renamed from: com.bumptech.glide.load.model.a$a */
    public interface a<Data> {
        /* renamed from: a */
        InterfaceC1563d<Data> mo9077a(AssetManager assetManager, String str);
    }

    /* renamed from: com.bumptech.glide.load.model.a$b */
    public static class b implements InterfaceC8994h<Uri, AssetFileDescriptor>, a<AssetFileDescriptor> {

        /* renamed from: a */
        public final AssetManager f7002a;

        public b(AssetManager assetManager) {
            this.f7002a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.C1584a.a
        /* renamed from: a */
        public InterfaceC1563d<AssetFileDescriptor> mo9077a(AssetManager assetManager, String str) {
            return new C1567h(assetManager, str);
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Uri, AssetFileDescriptor> mo9074b(C1591h c1591h) {
            return new C1584a(this.f7002a, this);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.a$c */
    public static class c implements InterfaceC8994h<Uri, InputStream>, a<InputStream> {

        /* renamed from: a */
        public final AssetManager f7003a;

        public c(AssetManager assetManager) {
            this.f7003a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.C1584a.a
        /* renamed from: a */
        public InterfaceC1563d<InputStream> mo9077a(AssetManager assetManager, String str) {
            return new C1572m(assetManager, str);
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Uri, InputStream> mo9074b(C1591h c1591h) {
            return new C1584a(this.f7003a, this);
        }
    }

    public C1584a(AssetManager assetManager, a<Data> aVar) {
        this.f7000a = assetManager;
        this.f7001b = aVar;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<Data> mo9071b(Uri uri, int i10, int i11, C13684i c13684i) {
        return new InterfaceC1589f.a<>(new C12459b(uri), this.f7001b.mo9077a(this.f7000a, uri.toString().substring(f6999c)));
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(Uri uri) {
        return CloudBackupConstant.Command.PMS_OPTION_ONE_FILE.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
