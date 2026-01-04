package com.huawei.hms.videokit.player;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.huawei.hms.videokit.player.i0 */
/* loaded from: classes8.dex */
public class C6563i0 {
    /* renamed from: a */
    public static final void m37397a(Closeable closeable) throws IOException {
        String str;
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            e = e10;
            str = "close input stream IOException:";
            C6550c1.m37258a("CloseUtils", str, e);
        } catch (Exception e11) {
            e = e11;
            str = "close input stream Exception:";
            C6550c1.m37258a("CloseUtils", str, e);
        }
    }
}
