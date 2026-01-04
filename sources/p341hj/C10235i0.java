package p341hj;

import com.huawei.cloud.pay.model.reward.GetRewardsResp;
import fk.C9721b;
import java.util.function.Consumer;
import p015ak.C0226l0;
import p315gj.C9949b;
import p429kk.C11058a;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: hj.i0 */
/* loaded from: classes5.dex */
public class C10235i0 extends AbstractC10222e {

    /* renamed from: b */
    public String f49607b;

    /* renamed from: c */
    public Integer f49608c;

    /* renamed from: d */
    public final Integer f49609d;

    /* renamed from: e */
    public final Consumer<GetRewardsResp> f49610e;

    public C10235i0(String str, Integer num, Integer num2, Consumer<GetRewardsResp> consumer) {
        this.f49607b = str;
        this.f49608c = num;
        this.f49609d = num2;
        this.f49610e = consumer;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            final GetRewardsResp getRewardsRespM61714k = C9949b.m61704j().m61714k(C11058a.m66626a(C11058a.m66627b("06015"), "getRewards", C13452e.m80781L().m80971t0()), this.f49607b, this.f49609d, this.f49608c);
            C11839m.m70688i("GetRewardsTask", "GetRewardsTask rsp:" + getRewardsRespM61714k.getResultDesc());
            C0226l0.m1584d(new Runnable() { // from class: hj.g0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49589a.m63396j(getRewardsRespM61714k);
                }
            });
        } catch (C9721b e10) {
            C11839m.m70688i("GetRewardsTask", "GetRewardsTask error:" + e10.getMessage());
            C0226l0.m1584d(new Runnable() { // from class: hj.h0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49598a.m63397k();
                }
            });
        }
    }

    /* renamed from: j */
    public final /* synthetic */ void m63396j(GetRewardsResp getRewardsResp) {
        this.f49610e.accept(getRewardsResp);
    }

    /* renamed from: k */
    public final /* synthetic */ void m63397k() {
        this.f49610e.accept(null);
    }
}
