package p341hj;

import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11282e;
import p709vj.C13452e;
import p746wn.C13622a;
import p836z8.C14157f;

/* renamed from: hj.u */
/* loaded from: classes5.dex */
public class C10266u extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49719b;

    /* renamed from: c */
    public Filter f49720c;

    /* renamed from: d */
    public String f49721d;

    /* renamed from: e */
    public ChannelInfo f49722e;

    /* renamed from: f */
    public boolean f49723f;

    /* renamed from: g */
    public boolean f49724g;

    /* renamed from: h */
    public boolean f49725h;

    /* renamed from: i */
    public long f49726i;

    /* renamed from: j */
    public boolean f49727j;

    /* renamed from: k */
    public long f49728k;

    public C10266u(Handler handler, Filter filter, String str, ChannelInfo channelInfo, boolean z10) {
        this.f49726i = 0L;
        this.f49728k = 0L;
        this.f49719b = handler;
        this.f49720c = filter;
        this.f49721d = str;
        this.f49722e = channelInfo;
        this.f49723f = z10;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        GetAvailableGradePackagesResp getAvailableGradePackagesRespM61697u;
        C1442a.m8290i("GetAvailableGradePackagesTask", "task start.");
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06008"), "getAvailableGradePackages", C13452e.m80781L().m80971t0());
        try {
            try {
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                if (this.f49727j) {
                    C1442a.m8290i("GetAvailableGradePackagesTask", "task isTotalSpaceNeeded.");
                    getAvailableGradePackagesRespM61697u = C9948a.m61631C().m61699v(c11060cM66626a, this.f49720c, this.f49721d, this.f49722e, this.f49728k);
                } else if (this.f49725h) {
                    C1442a.m8290i("GetAvailableGradePackagesTask", "task need spaceNeeded.");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("bs.dsu.cloud.usage");
                    List<C4987f> listM84949i = C14157f.m84942g().m84949i(arrayList, null, "GetPackages");
                    if (listM84949i == null || listM84949i.isEmpty()) {
                        C1442a.m8290i("GetAvailableGradePackagesTask", "params is null or empty.");
                        getAvailableGradePackagesRespM61697u = C9948a.m61631C().m61697u(c11060cM66626a, this.f49720c, this.f49721d, this.f49722e);
                    } else {
                        C4987f c4987f = listM84949i.get(0);
                        if (c4987f != null) {
                            long j10 = Long.parseLong(c4987f.m30027c()) + this.f49726i;
                            C1442a.m8290i("GetAvailableGradePackagesTask", "getAvailableGradePackages with spaceNeeded start  spaceNeeded " + j10);
                            getAvailableGradePackagesRespM61697u = C9948a.m61631C().m61699v(c11060cM66626a, this.f49720c, this.f49721d, this.f49722e, j10);
                        } else {
                            C1442a.m8290i("GetAvailableGradePackagesTask", "paramsValue is null.");
                            getAvailableGradePackagesRespM61697u = C9948a.m61631C().m61697u(c11060cM66626a, this.f49720c, this.f49721d, this.f49722e);
                        }
                    }
                } else {
                    C1442a.m8290i("GetAvailableGradePackagesTask", "task not need spaceNeeded.");
                    getAvailableGradePackagesRespM61697u = C9948a.m61631C().m61697u(c11060cM66626a, this.f49720c, this.f49721d, this.f49722e);
                }
                if (this.f49723f) {
                    C11282e.m67709b(C0213f.m1377a()).m67716h("get_available_packages_cache_key", new Gson().toJson(getAvailableGradePackagesRespM61697u));
                }
                m63430i(getAvailableGradePackagesRespM61697u);
            } catch (C9721b e10) {
                C1442a.m8289e("GetAvailableGradePackagesTask", "getAvailableGradePackages err. " + e10.m60659c() + " " + e10.getMessage());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("114_");
                sb2.append(e10.m60659c());
                c11060cM66626a.m66665u(sb2.toString());
                c11060cM66626a.m66635A(e10.getMessage());
                if (this.f49723f) {
                    String strM67711c = C11282e.m67709b(C0213f.m1377a()).m67711c("get_available_packages_cache_key");
                    if (!TextUtils.isEmpty(strM67711c)) {
                        C1442a.m8291w("GetAvailableGradePackagesTask", "GetAvailableGradePackagesTask get info faild, use cache. ");
                        try {
                            m63430i((GetAvailableGradePackagesResp) new Gson().fromJson(strM67711c, GetAvailableGradePackagesResp.class));
                            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
                            return;
                        } catch (JsonSyntaxException e11) {
                            C1442a.m8291w("GetAvailableGradePackagesTask", "GetAvailableGradePackagesTask jsonSyntaxException exception is: " + e11.getMessage());
                            m63429h(e10);
                            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
                        }
                    }
                }
                m63429h(e10);
            }
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        } catch (Throwable th2) {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            throw th2;
        }
    }

    /* renamed from: h */
    public final void m63429h(C9721b c9721b) {
        if (this.f49724g) {
            m63379e(this.f49719b, 6037, c9721b);
        } else {
            m63379e(this.f49719b, 6020, c9721b);
        }
    }

    /* renamed from: i */
    public final void m63430i(GetAvailableGradePackagesResp getAvailableGradePackagesResp) {
        m63380f(this.f49719b, 6028, getAvailableGradePackagesResp);
        int showPlace = this.f49720c.getShowPlace();
        if (this.f49724g) {
            m63380f(this.f49719b, 6035, getAvailableGradePackagesResp);
            return;
        }
        if (showPlace == 2) {
            m63380f(this.f49719b, 6019, getAvailableGradePackagesResp);
        } else if (showPlace == 1) {
            m63380f(this.f49719b, 6019, getAvailableGradePackagesResp);
        } else {
            if (TextUtils.isEmpty(this.f49720c.getPackageId())) {
                return;
            }
            m63380f(this.f49719b, 6027, getAvailableGradePackagesResp);
        }
    }

    public C10266u(Handler handler, Filter filter, String str, boolean z10, ChannelInfo channelInfo, boolean z11, long j10) {
        this.f49728k = 0L;
        this.f49719b = handler;
        this.f49720c = filter;
        this.f49721d = str;
        this.f49722e = channelInfo;
        this.f49723f = z11;
        this.f49725h = z10;
        this.f49726i = j10;
    }

    public C10266u(Handler handler, Filter filter, String str, ChannelInfo channelInfo, boolean z10, boolean z11) {
        this.f49726i = 0L;
        this.f49728k = 0L;
        this.f49719b = handler;
        this.f49720c = filter;
        this.f49721d = str;
        this.f49722e = channelInfo;
        this.f49723f = z10;
        this.f49724g = z11;
    }

    public C10266u(Handler handler, Filter filter, String str, ChannelInfo channelInfo, boolean z10, boolean z11, long j10) {
        this.f49726i = 0L;
        this.f49719b = handler;
        this.f49720c = filter;
        this.f49721d = str;
        this.f49722e = channelInfo;
        this.f49723f = z10;
        this.f49727j = z11;
        this.f49728k = j10;
    }
}
