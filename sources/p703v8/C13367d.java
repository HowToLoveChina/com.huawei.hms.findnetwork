package p703v8;

import android.content.Context;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import p015ak.C0212e0;
import p015ak.C0213f;
import p336he.C10155f;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p846zj.C14306d;
import to.C13049a;

/* renamed from: v8.d */
/* loaded from: classes2.dex */
public class C13367d {

    /* renamed from: a */
    public static final Object f60250a = new Object();

    /* renamed from: v8.d$b */
    public static class b {

        /* renamed from: a */
        public static C13367d f60251a = new C13367d();
    }

    public /* synthetic */ C13367d(a aVar) {
        this();
    }

    /* renamed from: a */
    public static void m80177a(QuotaSpaceInfo quotaSpaceInfo) {
        if (quotaSpaceInfo == null || quotaSpaceInfo.getTotal() <= 0) {
            return;
        }
        synchronized (f60250a) {
            C11839m.m70686d("CloudSpaceUtil", "cache space info");
            Context contextM1377a = C0213f.m1377a();
            C0212e0.m1370t(contextM1377a, "switch_suggest_dialog_sp", "total_size", quotaSpaceInfo.getTotal());
            C0212e0.m1370t(contextM1377a, "switch_suggest_dialog_sp", "used_size", quotaSpaceInfo.getUsed());
            C0212e0.m1370t(contextM1377a, "switch_suggest_dialog_sp", "available_size", quotaSpaceInfo.getAvailable());
            C0212e0.m1370t(contextM1377a, "switch_suggest_dialog_sp", "guide_backup_cache_info_time", System.currentTimeMillis());
        }
    }

    /* renamed from: b */
    public static QuotaSpaceInfo m80178b() {
        synchronized (f60250a) {
            try {
                Context contextM1377a = C0213f.m1377a();
                long jM1359i = C0212e0.m1359i(contextM1377a, "switch_suggest_dialog_sp", "total_size", 0L);
                if (jM1359i <= 0) {
                    return null;
                }
                QuotaSpaceInfo quotaSpaceInfo = new QuotaSpaceInfo();
                quotaSpaceInfo.setTotal(jM1359i);
                quotaSpaceInfo.setUsed(C0212e0.m1359i(contextM1377a, "switch_suggest_dialog_sp", "used_size", 0L));
                quotaSpaceInfo.setAvailable(C0212e0.m1359i(contextM1377a, "switch_suggest_dialog_sp", "available_size", 0L));
                return quotaSpaceInfo;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public static long m80179c() {
        long jM1359i;
        synchronized (f60250a) {
            jM1359i = C0212e0.m1359i(C0213f.m1377a(), "switch_suggest_dialog_sp", "guide_backup_cache_info_time", 0L);
        }
        return jM1359i;
    }

    /* renamed from: e */
    public static C13367d m80180e() {
        return b.f60251a;
    }

    /* renamed from: d */
    public CloudSpace m80181d() {
        try {
            C14306d.m85218s();
            CloudSpace cloudSpaceM78753q = new C13049a(EnumC12999a.CLOUD_MORE, null).m78753q();
            if (cloudSpaceM78753q.getTotal() > 0 || C10155f.m63292p()) {
                return cloudSpaceM78753q;
            }
            C11839m.m70687e("CloudSpaceUtil", "getCloudSpace totalSpace is 0");
            return null;
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceUtil", "getCloudSpace exception: " + e10.toString());
            return null;
        }
    }

    public C13367d() {
    }
}
