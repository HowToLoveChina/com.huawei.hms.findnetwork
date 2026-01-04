package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.FilterDataForRecommend;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;
import p454lj.C11296s;

/* renamed from: hj.d0 */
/* loaded from: classes5.dex */
public class C10220d0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49557b;

    /* renamed from: c */
    public C11060c f49558c;

    /* renamed from: d */
    public int f49559d;

    /* renamed from: e */
    public long f49560e;

    /* renamed from: f */
    public int f49561f;

    /* renamed from: g */
    public ChannelInfo f49562g;

    /* renamed from: h */
    public int f49563h;

    /* renamed from: i */
    public String f49564i;

    /* renamed from: j */
    public boolean f49565j;

    public C10220d0(Handler handler, C11060c c11060c, int i10, long j10, int i11, ChannelInfo channelInfo) {
        this.f49557b = handler;
        this.f49558c = c11060c;
        this.f49559d = i10;
        this.f49560e = j10;
        this.f49561f = i11;
        this.f49562g = channelInfo;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            GetPackagesBySpaceRuleResp getPackagesBySpaceRuleRespM61637F = this.f49561f == 5 ? C9948a.m61631C().m61637F(this.f49558c, this.f49559d, this.f49560e, this.f49561f, this.f49563h, this.f49564i, this.f49562g, this.f49565j) : C9948a.m61631C().m61638G(this.f49558c, this.f49559d, this.f49560e, this.f49561f, this.f49562g, this.f49565j);
            this.f49558c.m66665u(String.valueOf(0));
            this.f49558c.m66635A("success");
            FilterDataForRecommend filterDataForRecommend = new FilterDataForRecommend();
            filterDataForRecommend.setFilterAvailabalGradePackageList(C11296s.m67829n(getPackagesBySpaceRuleRespM61637F.getPackageGrades(), getPackagesBySpaceRuleRespM61637F.getSpacePackages()));
            filterDataForRecommend.setVoucherList(getPackagesBySpaceRuleRespM61637F.getVoucherList());
            m63380f(this.f49557b, 6009, filterDataForRecommend);
        } catch (C9721b e10) {
            C1442a.m8291w("GetPackagesBySpaceRuleTask", "get recommend package err : " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49558c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49558c.m66635A(e10.getMessage());
            m63379e(this.f49557b, 6010, e10);
        }
    }

    /* renamed from: h */
    public void m63369h(boolean z10) {
        this.f49565j = z10;
    }

    public C10220d0(Handler handler, C11060c c11060c, int i10, long j10, int i11, int i12, String str, ChannelInfo channelInfo) {
        this.f49557b = handler;
        this.f49558c = c11060c;
        this.f49559d = i10;
        this.f49560e = j10;
        this.f49561f = i11;
        this.f49563h = i12;
        this.f49564i = str;
        this.f49562g = channelInfo;
    }
}
