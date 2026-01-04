package us;

import as.C1016d;
import java.io.File;
import java.io.IOException;
import p531or.C11991a;
import ws.C13635i;

/* renamed from: us.a */
/* loaded from: classes8.dex */
public final class C13246a {

    /* renamed from: d */
    public static final String f59927d;

    /* renamed from: a */
    public C13635i f59928a;

    /* renamed from: b */
    public int f59929b;

    /* renamed from: c */
    public int f59930c;

    static {
        String str;
        try {
            str = C11991a.m72145a().getCacheDir().getCanonicalPath() + File.separator + "tileFile";
        } catch (IOException unused) {
            C1016d.m6183c("TileCacheManager", "failed to get tile cache file path");
            str = "";
        }
        f59927d = str;
    }

    public C13246a(int i10, int i11) {
        this.f59929b = i10;
        this.f59930c = i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0175  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] m79633a(long r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: us.C13246a.m79633a(long):byte[]");
    }
}
