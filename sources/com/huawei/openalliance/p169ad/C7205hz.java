package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.io.File;

/* renamed from: com.huawei.openalliance.ad.hz */
/* loaded from: classes8.dex */
public class C7205hz {

    /* renamed from: a */
    private File f33162a;

    /* renamed from: b */
    private InterfaceC7146gc f33163b;

    public C7205hz(Context context, String str) {
        File cacheDir = C7845x.m48571i(context).getCacheDir();
        StringBuilder sb2 = new StringBuilder();
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(Constants.PPS_ROOT_PATH);
        sb2.append(str2);
        sb2.append(str);
        sb2.append("_diskcache");
        File file = new File(cacheDir, sb2.toString());
        this.f33162a = file;
        if (!file.exists() && !this.f33162a.mkdirs()) {
            AbstractC7185ho.m43826d("CacheConfig", "Create cache dir failed");
        }
        this.f33163b = C7124fh.m43316b(context);
    }

    /* renamed from: a */
    public File m43893a() {
        return this.f33162a;
    }

    /* renamed from: b */
    public String m43895b() {
        File file = this.f33162a;
        if (file == null) {
            return null;
        }
        return file.getPath();
    }

    /* renamed from: c */
    public long m43896c() {
        return this.f33163b.mo43363au() * 1048576;
    }

    /* renamed from: d */
    public long m43897d() {
        return this.f33163b.mo43335aB();
    }

    /* renamed from: a */
    public void m43894a(long j10) {
        this.f33163b.mo43428c(j10);
    }
}
