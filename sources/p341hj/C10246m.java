package p341hj;

import android.os.Handler;
import com.google.gson.JsonSyntaxException;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.Response;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9949b;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;

/* renamed from: hj.m */
/* loaded from: classes5.dex */
public class C10246m extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49650b;

    /* renamed from: c */
    public String f49651c;

    /* renamed from: d */
    public ChannelInfo f49652d;

    /* renamed from: e */
    public long f49653e;

    /* renamed from: f */
    public int f49654f;

    public C10246m(Handler handler, String str, ChannelInfo channelInfo, long j10, int i10) {
        this.f49650b = handler;
        this.f49651c = str;
        this.f49652d = channelInfo;
        this.f49653e = j10;
        this.f49654f = i10;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06018"), "/exchangePackage", C13452e.m80781L().m80971t0());
        try {
            c11060cM66626a.m66665u(String.valueOf(0));
            c11060cM66626a.m66635A("success");
            m63380f(this.f49650b, 7046, C9949b.m61704j().m61707c(c11060cM66626a, this.f49651c, this.f49652d, this.f49653e, this.f49654f));
        } catch (C9721b e10) {
            C1442a.m8291w("ExchangePackageTask", "ExchangePackageTask err. " + e10.m60659c() + " " + e10.getMessage());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060cM66626a.m66665u(sb2.toString());
            c11060cM66626a.m66635A(e10.getMessage());
            if (30005 == e10.m60659c()) {
                try {
                    Response response = (Response) C9949b.m61704j().m61709e(e10.getMessage(), Response.class);
                    m63379e(this.f49650b, 7047, new C9721b(response.getResultCode(), response.getResultDesc()));
                    return;
                } catch (JsonSyntaxException e11) {
                    C1442a.m8289e("ExchangePackageTask", "runTask fromJson json err = " + e11.getMessage());
                    m63379e(this.f49650b, 7047, e10);
                } catch (C9721b e12) {
                    C1442a.m8289e("ExchangePackageTask", "runTask fromJson err = " + e12.getMessage());
                    m63379e(this.f49650b, 7047, e10);
                }
            }
            m63379e(this.f49650b, 7047, e10);
        }
    }
}
