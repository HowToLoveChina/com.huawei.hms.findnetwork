package p009a8;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.cloudphoto.model.About;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.request.basic.bean.PostOpDescReq;
import fk.C9721b;
import io.C10582a;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1136q;
import p292fn.C9733f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p764x6.C13713e;
import p764x6.C13714f;

/* renamed from: a8.k */
/* loaded from: classes2.dex */
public class C0073k {

    /* renamed from: a */
    public long f274a;

    /* renamed from: a8.k$b */
    public static class b extends AbstractC12367d {

        /* renamed from: a */
        public String f275a;

        /* renamed from: b */
        public String f276b;

        public b(String str, String str2) {
            this.f275a = str;
            this.f276b = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C10582a c10582a = new C10582a(this.f275a);
            PostOpDescReq postOpDescReq = new PostOpDescReq();
            postOpDescReq.setOpDesc(this.f276b);
            postOpDescReq.setStored(false);
            postOpDescReq.setEventTime(System.currentTimeMillis());
            try {
                C11839m.m70688i("RequestCacheManager", "BasicReportTask result: " + c10582a.m64915P(postOpDescReq).getResult());
            } catch (Exception e10) {
                C11839m.m70687e("RequestCacheManager", "BasicReportTask error: " + e10);
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.QUERY_KEY;
        }
    }

    /* renamed from: a8.k$c */
    public static class c {

        /* renamed from: a */
        public static C0073k f277a = new C0073k();
    }

    public /* synthetic */ C0073k(a aVar) {
        this();
    }

    /* renamed from: d */
    public static C0073k m595d() {
        return c.f277a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.huawei.android.hicloud.drive.cloudphoto.model.About m596a(java.lang.String r14, boolean r15, java.lang.String r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p009a8.C0073k.m596a(java.lang.String, boolean, java.lang.String):com.huawei.android.hicloud.drive.cloudphoto.model.About");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.huawei.android.hicloud.drive.cloudphoto.model.About m597b(java.lang.String r7, boolean r8, java.lang.String r9) throws fk.C9721b, java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "RequestCacheManager"
            android.content.Context r1 = p015ak.C0213f.m1377a()
            java.lang.String r1 = p031b7.C1136q.b.m7053e(r1)
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r3.<init>()     // Catch: java.lang.Exception -> L35
            java.lang.String r4 = "get about cache:"
            r3.append(r4)     // Catch: java.lang.Exception -> L35
            r3.append(r1)     // Catch: java.lang.Exception -> L35
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L35
            p031b7.C1120a.m6675d(r0, r3)     // Catch: java.lang.Exception -> L35
            oi.a r3 = p523oi.C11903a.m71435l()     // Catch: java.lang.Exception -> L35
            ni.e r1 = r3.mo69832e(r1)     // Catch: java.lang.Exception -> L35
            java.lang.Class<com.huawei.android.hicloud.drive.cloudphoto.model.About> r3 = com.huawei.android.hicloud.drive.cloudphoto.model.About.class
            java.lang.Object r1 = r1.m69886u(r3)     // Catch: java.lang.Exception -> L35
            com.huawei.android.hicloud.drive.cloudphoto.model.About r1 = (com.huawei.android.hicloud.drive.cloudphoto.model.About) r1     // Catch: java.lang.Exception -> L35
            r6.m600f(r1)     // Catch: java.lang.Exception -> L33
            goto L51
        L33:
            r2 = move-exception
            goto L39
        L35:
            r1 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L39:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getAboutCache error:"
            r3.append(r4)
            java.lang.String r2 = r2.toString()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            p031b7.C1120a.m6676e(r0, r2)
        L51:
            if (r1 != 0) goto L5c
            java.lang.String r1 = "getAboutCache error retry get cloud about"
            p031b7.C1120a.m6677i(r0, r1)
            com.huawei.android.hicloud.drive.cloudphoto.model.About r1 = r6.m596a(r7, r8, r9)
        L5c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p009a8.C0073k.m597b(java.lang.String, boolean, java.lang.String):com.huawei.android.hicloud.drive.cloudphoto.model.About");
    }

    /* renamed from: c */
    public About m598c(String str, boolean z10, String str2) throws C9721b, IOException {
        m599e();
        long jM7015N = C1136q.b.m7015N(C0213f.m1377a());
        String strM7053e = C1136q.b.m7053e(C0213f.m1377a());
        C1120a.m6675d("RequestCacheManager", "time:" + jM7015N + " aboutCacheTime :" + this.f274a);
        return (System.currentTimeMillis() - jM7015N > this.f274a || TextUtils.isEmpty(strM7053e) || 1 == C1136q.b.m7095s(C0213f.m1377a())) ? m596a(str, z10, str2) : m597b(str, z10, str2);
    }

    /* renamed from: e */
    public final void m599e() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            int aboutResopnseCacheTime = hiCloudSysParamMapM60757p.getAboutResopnseCacheTime();
            this.f274a = aboutResopnseCacheTime * 60000;
            C1120a.m6677i("RequestCacheManager", "hiCloudSysParamMap get about cache time" + aboutResopnseCacheTime);
        }
    }

    /* renamed from: f */
    public final void m600f(About about) {
        C1136q.d.m7162z(about.getStatus().getBigSuspendCursor());
        Integer maxBatchNumber = about.getMaxBatchNumber();
        if (maxBatchNumber != null) {
            C1136q.d.m7128E(maxBatchNumber.intValue());
        }
        Integer maxBatchGetNumber = about.getMaxBatchGetNumber();
        if (maxBatchGetNumber != null) {
            C1120a.m6677i("RequestCacheManager", "maxBatchGetNumber:" + maxBatchGetNumber);
            C1136q.d.m7127D(maxBatchGetNumber.intValue());
        }
        Optional.ofNullable(about.getUser()).map(new C13713e()).ifPresent(new C13714f());
        Optional.ofNullable(about.getMaxShareNumber()).ifPresent(new Consumer() { // from class: a8.i
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C1136q.d.m7130G(((Integer) obj).intValue());
            }
        });
        Optional.ofNullable(about.getMaxBatchUpdateNumber()).ifPresent(new Consumer() { // from class: a8.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C1136q.d.m7129F(((Integer) obj).intValue());
            }
        });
    }

    /* renamed from: g */
    public void m601g(String str) {
        C1136q.b.m7075l0(C0213f.m1377a(), str);
    }

    public C0073k() {
        this.f274a = 300000L;
    }
}
