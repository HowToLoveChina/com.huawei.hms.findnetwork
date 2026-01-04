package p786xs;

import as.C1016d;
import com.huawei.location.activity.C6738e;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import ws.C13635i;

/* renamed from: xs.b */
/* loaded from: classes8.dex */
public final class C13855b {

    /* renamed from: a */
    public static AtomicInteger f62139a = new AtomicInteger(0);

    /* renamed from: a */
    public static void m83162a() throws IOException {
        C13859f.m83179f(new File(C6738e.m38291a(new StringBuilder(), C13635i.f61309e, "DailyDownloads")), String.valueOf(f62139a.decrementAndGet()));
    }

    /* renamed from: b */
    public static int m83163b() throws IOException {
        String strM38291a = C6738e.m38291a(new StringBuilder(), C13635i.f61309e, "DailyDownloads");
        File file = new File(strM38291a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
        String str2 = simpleDateFormat.format(Long.valueOf(file.lastModified()));
        if (file.exists() && str.equals(str2)) {
            AtomicInteger atomicInteger = f62139a;
            if (atomicInteger.get() <= 0) {
                try {
                    atomicInteger.set(Integer.parseInt(C13859f.m83174a(strM38291a)));
                } catch (NumberFormatException e10) {
                    C1016d.m6183c("DailyDownloadsUtil", "get delay downloads error:" + e10.getMessage());
                    if (file.delete()) {
                        C1016d.m6183c("DailyDownloadsUtil", "downloads file delete error:" + e10.getMessage());
                    }
                }
            }
        } else {
            C13859f.m83179f(file, String.valueOf(0));
            f62139a.set(0);
        }
        return f62139a.get();
    }

    /* renamed from: c */
    public static void m83164c() {
        C13859f.m83179f(new File(C6738e.m38291a(new StringBuilder(), C13635i.f61309e, "DailyDownloads")), String.valueOf(f62139a.incrementAndGet()));
    }
}
