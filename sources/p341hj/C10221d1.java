package p341hj;

import com.huawei.android.hicloud.agd.ads.AdInfo;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import p581qk.AbstractC12367d;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: hj.d1 */
/* loaded from: classes5.dex */
public class C10221d1 extends AbstractC12367d {

    /* renamed from: a */
    public final Consumer<List<AdInfo>> f49566a;

    /* renamed from: b */
    public final String f49567b;

    public C10221d1(Consumer<List<AdInfo>> consumer, String str) {
        this.f49566a = consumer;
        this.f49567b = str;
    }

    /* renamed from: g */
    public static /* synthetic */ boolean m63374g(AdInfo adInfo) {
        return Objects.nonNull(adInfo) && Objects.nonNull(adInfo.getMaterial());
    }

    /* renamed from: h */
    public /* synthetic */ void m63375h(List list) {
        this.f49566a.accept(list);
    }

    /* renamed from: l */
    private void m63376l(int i10, int i11) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("load_ad_num", String.valueOf(i10));
        linkedHashMapM79497A.put("request_agd_ads_count_key", String.valueOf(10));
        linkedHashMapM79497A.put("filter_agd_ads_count_key", String.valueOf(i11));
        linkedHashMapM79497A.put("sce_request_agd_ads_key", "sce_request_agd_ads_query");
        C13227f.m79492i1().m79567R("load_agd_ads_event", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "load_agd_ads_event", linkedHashMapM79497A);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x009a, code lost:
    
        m63376l(0, 0);
     */
    @Override // p616rk.AbstractRunnableC12516b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void call() {
        /*
            r9 = this;
            java.lang.String r0 = "QueryAdListTask"
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> L92
            r1.<init>()     // Catch: java.lang.Exception -> L92
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L92
            r4 = 0
            r5 = r4
        Le:
            if (r3 == 0) goto L9d
            int r3 = r3.intValue()     // Catch: java.lang.Exception -> L92
            if (r3 != r2) goto L9d
            int r3 = r1.size()     // Catch: java.lang.Exception -> L92
            r6 = 10
            if (r3 >= r6) goto L9d
            r3 = 5
            if (r5 >= r3) goto L9d
            int r5 = r5 + 1
            com.huawei.android.hicloud.agd.ads.AdSlot r3 = new com.huawei.android.hicloud.agd.ads.AdSlot     // Catch: java.lang.Exception -> L92
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L92
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L92
            java.lang.String r8 = r9.f49567b     // Catch: java.lang.Exception -> L92
            r3.<init>(r6, r7, r8)     // Catch: java.lang.Exception -> L92
            gj.a r6 = p315gj.C9948a.m61631C()     // Catch: java.lang.Exception -> L92
            com.huawei.cloud.pay.model.QueryAdListRsp r3 = r6.m61659a0(r3)     // Catch: java.lang.Exception -> L92
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92
            r6.<init>()     // Catch: java.lang.Exception -> L92
            java.lang.String r7 = "QueryAdListTask rsp:"
            r6.append(r7)     // Catch: java.lang.Exception -> L92
            java.lang.String r7 = r3.getResultDesc()     // Catch: java.lang.Exception -> L92
            r6.append(r7)     // Catch: java.lang.Exception -> L92
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L92
            p514o9.C11839m.m70688i(r0, r6)     // Catch: java.lang.Exception -> L92
            int r6 = r3.getResultCode()     // Catch: java.lang.Exception -> L92
            if (r6 != 0) goto L9a
            java.lang.Integer r6 = r3.getAdRetCode()     // Catch: java.lang.Exception -> L92
            int r6 = r6.intValue()     // Catch: java.lang.Exception -> L92
            if (r6 == 0) goto L63
            goto L9a
        L63:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92
            r6.<init>()     // Catch: java.lang.Exception -> L92
            java.lang.String r7 = "QueryAdListTask rsp size:"
            r6.append(r7)     // Catch: java.lang.Exception -> L92
            java.util.List r7 = r3.getAdlist()     // Catch: java.lang.Exception -> L92
            int r7 = r7.size()     // Catch: java.lang.Exception -> L92
            r6.append(r7)     // Catch: java.lang.Exception -> L92
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L92
            p514o9.C11839m.m70688i(r0, r6)     // Catch: java.lang.Exception -> L92
            java.util.List r6 = r3.getAdlist()     // Catch: java.lang.Exception -> L92
            r1.addAll(r6)     // Catch: java.lang.Exception -> L92
            int r6 = r1.size()     // Catch: java.lang.Exception -> L92
            if (r6 <= 0) goto L94
            java.lang.String r2 = "no need to request agd"
            p514o9.C11839m.m70688i(r0, r2)     // Catch: java.lang.Exception -> L92
            goto L9d
        L92:
            r1 = move-exception
            goto Lf2
        L94:
            java.lang.Integer r3 = r3.getHasNextPage()     // Catch: java.lang.Exception -> L92
            goto Le
        L9a:
            r9.m63376l(r4, r4)     // Catch: java.lang.Exception -> L92
        L9d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92
            r2.<init>()     // Catch: java.lang.Exception -> L92
            java.lang.String r3 = "adInFos size:"
            r2.append(r3)     // Catch: java.lang.Exception -> L92
            int r3 = r1.size()     // Catch: java.lang.Exception -> L92
            r2.append(r3)     // Catch: java.lang.Exception -> L92
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L92
            p054cj.C1442a.m8290i(r0, r2)     // Catch: java.lang.Exception -> L92
            boolean r2 = p015ak.C0209d.m1205R0(r1)     // Catch: java.lang.Exception -> L92
            if (r2 != 0) goto Le6
            java.util.stream.Stream r2 = r1.stream()     // Catch: java.lang.Exception -> L92
            hj.z0 r3 = new hj.z0     // Catch: java.lang.Exception -> L92
            r3.<init>()     // Catch: java.lang.Exception -> L92
            java.util.stream.Stream r2 = r2.filter(r3)     // Catch: java.lang.Exception -> L92
            java.util.stream.Collector r3 = java.util.stream.Collectors.toList()     // Catch: java.lang.Exception -> L92
            java.lang.Object r2 = r2.collect(r3)     // Catch: java.lang.Exception -> L92
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Exception -> L92
            int r1 = r1.size()     // Catch: java.lang.Exception -> L92
            int r3 = r2.size()     // Catch: java.lang.Exception -> L92
            r9.m63376l(r1, r3)     // Catch: java.lang.Exception -> L92
            hj.a1 r1 = new hj.a1     // Catch: java.lang.Exception -> L92
            r1.<init>()     // Catch: java.lang.Exception -> L92
            p015ak.C0226l0.m1584d(r1)     // Catch: java.lang.Exception -> L92
            goto L112
        Le6:
            hj.b1 r1 = new hj.b1     // Catch: java.lang.Exception -> L92
            r1.<init>()     // Catch: java.lang.Exception -> L92
            p015ak.C0226l0.m1584d(r1)     // Catch: java.lang.Exception -> L92
            r9.m63376l(r4, r4)     // Catch: java.lang.Exception -> L92
            goto L112
        Lf2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "QueryAdListTask errMsg = "
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            p054cj.C1442a.m8289e(r0, r1)
            hj.c1 r0 = new hj.c1
            r0.<init>()
            p015ak.C0226l0.m1584d(r0)
        L112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p341hj.C10221d1.call():void");
    }

    /* renamed from: j */
    public final /* synthetic */ void m63377j() {
        this.f49566a.accept(new ArrayList());
    }

    /* renamed from: k */
    public final /* synthetic */ void m63378k() {
        this.f49566a.accept(new ArrayList());
    }
}
