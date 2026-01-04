package p674ub;

import android.text.TextUtils;
import com.huawei.hicloud.notification.p106db.bean.UrgencyPolicy;
import com.huawei.hicloud.notification.p106db.bean.UrgencyScenario;
import java.util.LinkedHashMap;
import java.util.List;
import p514o9.C11839m;
import p572qb.C12318k0;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: ub.b */
/* loaded from: classes3.dex */
public class C13145b extends AbstractC12367d {

    /* renamed from: a */
    public String f59642a;

    public C13145b(String str) {
        this.f59642a = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("CheckErrorCodeTask", "CheckErrorCodeTask start");
        UrgencyPolicy urgencyPolicyM79107t = C13152i.m79070o().m79107t(this.f59642a);
        C13152i.m79070o().m79082K(urgencyPolicyM79107t);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (urgencyPolicyM79107t == null) {
            C11839m.m70688i("CheckErrorCodeTask", "policy null");
            linkedHashMap.put("match userStatus failed", "policy null");
            C12318k0.m74089a("policy userStatus", linkedHashMap);
            return;
        }
        UrgencyScenario scenario = urgencyPolicyM79107t.getScenario();
        if (scenario == null) {
            C11839m.m70688i("CheckErrorCodeTask", "scenario null");
            linkedHashMap.put("match userStatus failed", "scenario null");
            C12318k0.m74089a("policy userStatus", linkedHashMap);
            return;
        }
        List<String> userStatus = scenario.getUserStatus();
        if (userStatus == null) {
            C11839m.m70688i("CheckErrorCodeTask", "userStatusList null");
            linkedHashMap.put("match userStatus failed", "userStatusList null");
            C12318k0.m74089a("policy userStatus", linkedHashMap);
            return;
        }
        String id2 = scenario.getId();
        if (id2 == null) {
            C11839m.m70688i("CheckErrorCodeTask", "errorScenarioIds null");
            linkedHashMap.put("match scenarioId failed", "id null");
            C12318k0.m74089a("policy scenarioId", linkedHashMap);
            return;
        }
        for (String str : userStatus) {
            if (!TextUtils.isEmpty(str) && str.equals(this.f59642a)) {
                linkedHashMap.put("match userStatus Success", String.valueOf("server scenarioId = " + this.f59642a + ",policy scenarioId = " + str));
                C12318k0.m74089a("policy userStatus", linkedHashMap);
                C13152i.m79070o().m79085N(urgencyPolicyM79107t, str, id2);
                return;
            }
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.URGENCT_NOTICE_SINGLE;
    }
}
