package lc;

import com.huawei.android.hicloud.servercontrol.ServerControlResultCallback;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.request.basic.bean.PostOpDescReq;
import io.C10582a;
import java.net.InetAddress;
import java.util.HashMap;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11827a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: lc.c */
/* loaded from: classes3.dex */
public class C11269c extends AbstractC12367d {

    /* renamed from: a */
    public ServerControlResultCallback f52895a;

    /* renamed from: b */
    public String f52896b = "";

    public C11269c(ServerControlResultCallback serverControlResultCallback) {
        this.f52895a = serverControlResultCallback;
    }

    /* renamed from: c */
    public void m67632c(String str) {
        this.f52896b = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        String strM66627b = C11058a.m66627b("07013");
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "opDesc", C13452e.m80781L().m80971t0());
        HashMap map = new HashMap();
        try {
            C11268b.m67619i().m67629o(1);
            C11839m.m70688i("ServerControlNotifyTask", "notifyStatus:" + C11268b.m67619i().m67624j());
            String strM70478c = C11827a.m70478c();
            c11060cM66626a.m66667w(strM70478c);
            c11060cM66626a.m66639E(InetAddress.getByName(strM70478c).getHostAddress());
            c11060cM66626a.m66665u("120_0");
            map.put("result", "notifyStatus not finish, code 1");
            C13622a.m81971q(c11060cM66626a, map, false, true);
            C10582a c10582a = new C10582a(strM66627b);
            PostOpDescReq postOpDescReq = new PostOpDescReq();
            postOpDescReq.setOpDesc(this.f52896b);
            BasicBaseResp basicBaseRespM64915P = c10582a.m64915P(postOpDescReq);
            basicBaseRespM64915P.setResult(0);
            if (basicBaseRespM64915P.getResult() != 0) {
                this.f52895a.mo17196c();
                C11839m.m70687e("ServerControlNotifyTask", "POST_OP_DESC_RET_CODE failed");
                map.put("result", "POST_OP_DESC_RET_CODE failed");
                c11060cM66626a.m66635A("POST_OP_DESC_RET_CODE failed");
                c11060cM66626a.m66665u("120_" + basicBaseRespM64915P.getResult());
                C13622a.m81971q(c11060cM66626a, map, false, true);
                return;
            }
            C11268b.m67619i().m67629o(0);
            c11060cM66626a.m66665u("120_0");
            map.put("result", "notifyStatus finish, code 0");
            C13622a.m81971q(c11060cM66626a, map, false, true);
            c11060cM66626a.m66665u("120_" + basicBaseRespM64915P.getResult());
            HashMap map2 = new HashMap();
            map2.put("result", "POST_OP_DESC_RET_CODE success");
            C13622a.m81971q(c11060cM66626a, map2, false, true);
            this.f52895a.mo17197d();
        } catch (Exception e10) {
            C11839m.m70687e("ServerControlNotifyTask", "ServerControlNotifyTask exception: " + e10.toString());
            this.f52895a.mo17196c();
        }
    }
}
