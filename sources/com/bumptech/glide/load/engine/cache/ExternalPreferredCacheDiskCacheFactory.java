package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.C1581c;
import java.io.File;

/* loaded from: classes.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends C1581c {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory$a */
    public class C1575a implements C1581c.a {

        /* renamed from: a */
        public final /* synthetic */ Context f6969a;

        /* renamed from: b */
        public final /* synthetic */ String f6970b;

        public C1575a(Context context, String str) {
            this.f6969a = context;
            this.f6970b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.C1581c.a
        /* renamed from: a */
        public File mo9054a() {
            File externalCacheDir;
            File fileM9055b = m9055b();
            return ((fileM9055b == null || !fileM9055b.exists()) && (externalCacheDir = this.f6969a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? this.f6970b != null ? new File(externalCacheDir, this.f6970b) : externalCacheDir : fileM9055b;
        }

        /* renamed from: b */
        public final File m9055b() {
            File cacheDir = this.f6969a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f6970b != null ? new File(cacheDir, this.f6970b) : cacheDir;
        }
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, String str, long j10) {
        super(new C1575a(context, str), j10);
    }
}
