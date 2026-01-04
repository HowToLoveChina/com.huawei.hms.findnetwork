package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.UserTags;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import fk.C9721b;
import java.util.HashMap;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: hj.p */
/* loaded from: classes5.dex */
public class C10255p extends AbstractC10259q0 {

    /* renamed from: a */
    public Handler f49682a;

    /* renamed from: b */
    public int f49683b;

    /* renamed from: c */
    public UserTags f49684c;

    public C10255p(Handler handler, UserTags userTags, int i10) {
        this.f49682a = handler;
        this.f49683b = i10;
        this.f49684c = userTags;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07017"), "getActivityEntry", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        if (this.f49684c == null) {
            this.f49684c = new UserTags();
        }
        map.put("requestSource", String.valueOf(this.f49683b));
        try {
            try {
                GetActivityEntryResp getActivityEntryRespM61689q = C9948a.m61631C().m61689q(this.f49684c, this.f49683b, c11060cM66626a);
                m63427e(this.f49682a, 414 == this.f49683b ? 7027 : 7001, getActivityEntryRespM61689q);
                if (getActivityEntryRespM61689q != null) {
                    map.put(TrackConstants$Opers.RESPONSE, getActivityEntryRespM61689q.toString());
                }
            } catch (C9721b e10) {
                C1442a.m8289e("GetActivityEntryTask", "getActivityEntry error: " + e10.toString());
                m63425c(this.f49682a, 414 == this.f49683b ? 7028 : 7002, e10);
                map.put("responseError", e10.toString());
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        }
    }
}
