package sb;

import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import p015ak.C0219i;
import p514o9.C11839m;
import p572qb.C12303d;
import p608rb.C12486b;

/* renamed from: sb.a */
/* loaded from: classes3.dex */
public class C12767a {

    /* renamed from: a */
    public long f58425a;

    /* renamed from: sb.a$b */
    public static class b {

        /* renamed from: a */
        public static C12767a f58426a = new C12767a();
    }

    /* renamed from: c */
    public static C12767a m76619c() {
        return b.f58426a;
    }

    /* renamed from: a */
    public void m76620a(String str) {
        if ("addressbook".equals(str) && C0219i.m1463a() >= 21 && 1 == CloudSyncUtil.m15979U(str) && C12303d.m73958f().m73961g(null)) {
            C11839m.m70688i("CloudSyncTimerManager", "CloudSyncExecuteTime is upper 30 minites, need to retry apply powerkit.");
            C12303d.m73958f().m73959d("user-contact_sync_apply", new C12486b());
        }
    }

    /* renamed from: b */
    public synchronized long m76621b() {
        C11839m.m70686d("CloudSyncTimerManager", "getCloudSyncExecuteTime:" + this.f58425a);
        return this.f58425a;
    }

    /* renamed from: d */
    public synchronized void m76622d(String str) {
        C11839m.m70686d("CloudSyncTimerManager", "setCloudSyncExecuteTime");
        m76620a(str);
        this.f58425a = System.currentTimeMillis();
    }

    public C12767a() {
        this.f58425a = 0L;
    }
}
