package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.C1581c;
import java.io.File;

/* loaded from: classes.dex */
public final class InternalCacheDiskCacheFactory extends C1581c {

    /* renamed from: com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory$a */
    public class C1576a implements C1581c.a {

        /* renamed from: a */
        public final /* synthetic */ Context f6971a;

        /* renamed from: b */
        public final /* synthetic */ String f6972b;

        public C1576a(Context context, String str) {
            this.f6971a = context;
            this.f6972b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.C1581c.a
        /* renamed from: a */
        public File mo9054a() {
            File cacheDir = this.f6971a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f6972b != null ? new File(cacheDir, this.f6972b) : cacheDir;
        }
    }

    public InternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public InternalCacheDiskCacheFactory(Context context, String str, long j10) {
        super(new C1576a(context, str), j10);
    }
}
