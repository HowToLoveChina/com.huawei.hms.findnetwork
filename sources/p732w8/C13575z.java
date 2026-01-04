package p732w8;

import com.huawei.android.hicloud.cloudspace.manager.QuotaInfoModuleCallback;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.HashMap;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p703v8.C13375l;
import p703v8.C13376m;
import p783xp.C13843a;

/* renamed from: w8.z */
/* loaded from: classes2.dex */
public class C13575z extends AbstractC12367d {

    /* renamed from: a */
    public QuotaInfoModuleCallback f61069a;

    /* renamed from: b */
    public String f61070b;

    /* renamed from: c */
    public String f61071c;

    /* renamed from: d */
    public int f61072d;

    public C13575z(String str, String str2, QuotaInfoModuleCallback quotaInfoModuleCallback, int i10) {
        this.f61069a = quotaInfoModuleCallback;
        this.f61070b = str;
        this.f61071c = str2;
        this.f61072d = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        HashMap map = new HashMap();
        map.put(MapKeyNames.REQUEST_ID, String.valueOf(this.f61072d));
        try {
            long jM80300a = new C13375l().m80300a(this.f61071c);
            C11839m.m70688i("QuotaInfoModuleTask", "mService=" + this.f61070b + ", result=" + jM80300a);
            map.put("module_url", this.f61071c);
            map.put("module_used_size", C13843a.m83086h(C0213f.m1377a(), jM80300a));
            QuotaInfoModuleCallback quotaInfoModuleCallback = this.f61069a;
            if (quotaInfoModuleCallback == null) {
                C11839m.m70687e("QuotaInfoModuleTask", "callback is null");
            } else {
                if (jM80300a == -1) {
                    C11839m.m70687e("QuotaInfoModuleTask", "request failed");
                    this.f61069a.mo15492a(this.f61070b);
                    return;
                }
                quotaInfoModuleCallback.mo15493b(this.f61070b, jM80300a);
            }
        } catch (Exception e10) {
            C11839m.m70688i("QuotaInfoModuleTask", "mService=" + this.f61070b + ", exception=" + e10.toString());
            map.put("brief", e10.toString());
            QuotaInfoModuleCallback quotaInfoModuleCallback2 = this.f61069a;
            if (quotaInfoModuleCallback2 != null) {
                quotaInfoModuleCallback2.mo15492a(this.f61070b);
            }
        }
        C13376m.m80302a().m80304c(map);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.FAMILY_SHARE;
    }
}
