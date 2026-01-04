package p764x6;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.android.hicloud.drive.cloudphoto.model.Quota;
import com.huawei.android.hicloud.drive.cloudphoto.request.Quotas;
import com.huawei.android.p069cg.request.response.QueryUserSpaceResponse;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import fk.C9721b;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p652t9.EnumC12999a;
import p703v8.C13377n;
import to.C13049a;

/* renamed from: x6.j */
/* loaded from: classes2.dex */
public class C13718j extends AbstractC13710b<QueryUserSpaceResponse> {

    /* renamed from: h */
    public String f61712h;

    /* renamed from: i */
    public String f61713i;

    /* renamed from: j */
    public String f61714j;

    /* renamed from: k */
    public boolean f61715k;

    public C13718j(String str) {
        super(str);
        this.f61712h = "0";
        mo82454j(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [E, com.huawei.android.cg.request.response.QueryUserSpaceResponse] */
    @Override // p764x6.AbstractC13710b
    /* renamed from: k */
    public int mo82455k() throws Exception {
        ?? queryUserSpaceResponse = new QueryUserSpaceResponse();
        this.f61705f = queryUserSpaceResponse;
        queryUserSpaceResponse.setTotalSpaceSize(0L);
        ((QueryUserSpaceResponse) this.f61705f).setUseSpaceSize(0L);
        ((QueryUserSpaceResponse) this.f61705f).setCloudPhotoSize(0L);
        ((QueryUserSpaceResponse) this.f61705f).setRecyclePhotoSize(0L);
        if (!TextUtils.isEmpty(this.f61713i)) {
            Quotas.Get get = this.f61708b.m83558o().get();
            get.setAlbumOwner(Boolean.TRUE);
            get.setFields2("usedSpace,userCapacity");
            get.getHeaders().set("x-hw-album-Id", this.f61713i).set("x-hw-album-owner-Id", this.f61714j);
            if (this.f61715k) {
                get.setAlbumClientHeader(C1122c.m6755Z0("04019"));
            }
            Quota quotaExecute = get.execute();
            ((QueryUserSpaceResponse) this.f61705f).setTotalSpaceSize(C0241z.m1688f(quotaExecute.getUserCapacity()));
            ((QueryUserSpaceResponse) this.f61705f).setUseSpaceSize(C0241z.m1688f(quotaExecute.getUsedSpace()));
            return 0;
        }
        boolean zEquals = this.f61712h.equals("0");
        boolean zEquals2 = this.f61712h.equals("1");
        if (zEquals2) {
            zEquals = true;
        }
        if (this.f61712h.equals("2")) {
            zEquals = false;
            zEquals2 = true;
        }
        boolean zEquals3 = this.f61712h.equals("3");
        if (zEquals3) {
            zEquals = true;
            zEquals2 = true;
        }
        boolean z10 = !zEquals3;
        if (zEquals) {
            QuotaSpaceInfo quotaSpaceInfoM80306b = new C13377n().m80306b();
            if (quotaSpaceInfoM80306b == null) {
                throw new C9721b(4000, "QuotaSpaceInfo error");
            }
            ((QueryUserSpaceResponse) this.f61705f).setTotalSpaceSize(quotaSpaceInfoM80306b.getTotal());
            ((QueryUserSpaceResponse) this.f61705f).setUseSpaceSize(quotaSpaceInfoM80306b.getUsed());
        }
        if (zEquals2) {
            if (z10 && 1 == C1136q.b.m7029U(C0213f.m1377a())) {
                C1120a.m6677i("UserSpaceExecutor", "shelveStatus size = 0");
                ((QueryUserSpaceResponse) this.f61705f).setCloudPhotoSize(0L);
                ((QueryUserSpaceResponse) this.f61705f).setRecyclePhotoSize(0L);
                return 0;
            }
            m82468l();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l */
    public final void m82468l() throws C9721b {
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_ALBUM, null);
        try {
            String strM78761z = c13049a.m78761z("10880002", "collection=photo and (trashed=false)");
            C1120a.m6675d("UserSpaceExecutor", "getQuotaUsedInfo response=" + strM78761z);
            QuotaUsedInfoRsp quotaUsedInfoRsp = (QuotaUsedInfoRsp) new Gson().fromJson(strM78761z, QuotaUsedInfoRsp.class);
            if (quotaUsedInfoRsp.getRetCode() == 0) {
                C1120a.m6677i("UserSpaceExecutor", "getQuotaUsedInfo request success");
                ((QueryUserSpaceResponse) this.f61705f).setCloudPhotoSize(quotaUsedInfoRsp.getUsed());
            } else {
                C1120a.m6678w("UserSpaceExecutor", "getQuotaUsedInfo request failed");
            }
            String strM78761z2 = c13049a.m78761z("10880002", "collection=photo and (trashed=true)");
            C1120a.m6675d("UserSpaceExecutor", "getQuotaUsedInfo trashed response=" + strM78761z2);
            QuotaUsedInfoRsp quotaUsedInfoRsp2 = (QuotaUsedInfoRsp) new Gson().fromJson(strM78761z2, QuotaUsedInfoRsp.class);
            if (quotaUsedInfoRsp2.getRetCode() != 0) {
                C1120a.m6678w("UserSpaceExecutor", "getQuotaUsedInfo trashed failed");
            } else {
                C1120a.m6677i("UserSpaceExecutor", "getQuotaUsedInfo trashed success");
                ((QueryUserSpaceResponse) this.f61705f).setRecyclePhotoSize(quotaUsedInfoRsp2.getUsed());
            }
        } catch (C9721b e10) {
            C1120a.m6676e("UserSpaceExecutor", "getQuotaUsedInfo error:" + e10.toString());
            throw e10;
        }
    }

    /* renamed from: m */
    public void m82469m(boolean z10) {
        this.f61715k = z10;
    }

    /* renamed from: n */
    public void m82470n(String str) {
        this.f61714j = str;
    }

    /* renamed from: o */
    public void m82471o(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f61712h = str;
    }

    /* renamed from: p */
    public void m82472p(String str) {
        this.f61713i = str;
    }
}
