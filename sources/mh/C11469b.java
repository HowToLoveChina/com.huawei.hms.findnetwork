package mh;

import android.content.Context;
import java.io.File;

/* renamed from: mh.b */
/* loaded from: classes4.dex */
public class C11469b {

    /* renamed from: a */
    public static final String f53364a;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("marketInstall");
        String str = File.separator;
        sb2.append(str);
        sb2.append("download");
        sb2.append(str);
        sb2.append("hiSpace.apk");
        f53364a = sb2.toString();
    }

    /* renamed from: a */
    public static String m68596a(Context context) {
        return context.getFilesDir() + File.separator + f53364a;
    }
}
