package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.C1581c;
import java.io.File;

@Deprecated
/* loaded from: classes.dex */
public final class ExternalCacheDiskCacheFactory extends C1581c {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory$a */
    public class C1574a implements C1581c.a {

        /* renamed from: a */
        public final /* synthetic */ Context f6967a;

        /* renamed from: b */
        public final /* synthetic */ String f6968b;

        public C1574a(Context context, String str) {
            this.f6967a = context;
            this.f6968b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.C1581c.a
        /* renamed from: a */
        public File mo9054a() {
            File externalCacheDir = this.f6967a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.f6968b != null ? new File(externalCacheDir, this.f6968b) : externalCacheDir;
        }
    }

    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public ExternalCacheDiskCacheFactory(Context context, String str, int i10) {
        super(new C1574a(context, str), i10);
    }
}
