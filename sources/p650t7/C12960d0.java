package p650t7;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.p075vo.UserSpace;
import com.huawei.android.hicloud.drive.cloudphoto.model.Quota;
import com.huawei.android.hicloud.drive.cloudphoto.request.Quotas;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import fk.C9721b;
import p015ak.C0241z;
import p031b7.C1120a;
import p037bp.C1270a;
import p232dp.InterfaceC9285d;

/* renamed from: t7.d0 */
/* loaded from: classes2.dex */
public class C12960d0 extends AbstractC12988v {

    /* renamed from: g */
    public String f59040g;

    /* renamed from: h */
    public String f59041h;

    public C12960d0(String str, String str2) {
        mo82454j(false);
        this.f59040g = str;
        this.f59041h = str2;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        long total;
        long used;
        C1120a.m6677i("QueryUserSpaceExecutor", "execute begin");
        this.f59133f = new Bundle();
        if (TextUtils.isEmpty(this.f59040g)) {
            QuotaSpaceInfo quotaSpaceInfoMo17175h = ((InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class)).mo17175h();
            if (quotaSpaceInfoMo17175h == null) {
                C1120a.m6676e("QueryUserSpaceExecutor", "getQuotaSummary return null");
                throw new C9721b(4000, "getQuotaSummary error");
            }
            total = quotaSpaceInfoMo17175h.getTotal();
            used = quotaSpaceInfoMo17175h.getUsed();
        } else {
            Quotas.Get get = this.f61708b.m83558o().get();
            get.setFields2("usedSpace,userCapacity");
            get.getHeaders().set("x-hw-album-Id", this.f59040g).set("x-hw-album-owner-Id", this.f59041h).set("x-hw-trace-id", this.f61710d);
            Quota quotaExecute = get.execute();
            total = C0241z.m1688f(quotaExecute.getUserCapacity());
            used = C0241z.m1688f(quotaExecute.getUsedSpace());
        }
        this.f59133f.putParcelable("UserSpace", new UserSpace(used, total, 0L, 0L));
        this.f59133f.putInt("code", 0);
        this.f59133f.putString("info", "success");
        return "";
    }
}
