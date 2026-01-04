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

/* renamed from: ub.a */
/* loaded from: classes3.dex */
public class C13144a extends AbstractC12367d {

    /* renamed from: a */
    public String f59641a;

    public C13144a(String str) {
        this.f59641a = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("CheckErrorCodeTask", "CheckErrorCodeTask start");
        UrgencyPolicy urgencyPolicyM79105r = C13152i.m79070o().m79105r(this.f59641a);
        C13152i.m79070o().m79081J(urgencyPolicyM79105r);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (urgencyPolicyM79105r == null) {
            C11839m.m70688i("CheckErrorCodeTask", "policy null");
            linkedHashMap.put("match scenarioId failed", "policy null");
            C12318k0.m74089a("policy scenarioId", linkedHashMap);
            return;
        }
        UrgencyScenario scenario = urgencyPolicyM79105r.getScenario();
        if (scenario == null) {
            C11839m.m70688i("CheckErrorCodeTask", "scenario null");
            linkedHashMap.put("match scenarioId failed", "scenario null");
            C12318k0.m74089a("policy scenarioId", linkedHashMap);
            return;
        }
        List<String> errorScenarioIds = scenario.getErrorScenarioIds();
        if (errorScenarioIds == null) {
            C11839m.m70688i("CheckErrorCodeTask", "errorScenarioIds null");
            linkedHashMap.put("match scenarioId failed", "errorScenarioIds null");
            C12318k0.m74089a("policy scenarioId", linkedHashMap);
            return;
        }
        String id2 = scenario.getId();
        if (id2 == null) {
            C11839m.m70688i("CheckErrorCodeTask", "errorScenarioIds null");
            linkedHashMap.put("match scenarioId failed", "id null");
            C12318k0.m74089a("policy scenarioId", linkedHashMap);
            return;
        }
        for (String str : errorScenarioIds) {
            if (!TextUtils.isEmpty(str) && str.equals(this.f59641a)) {
                linkedHashMap.put("match scenarioId Success", String.valueOf("server scenarioId = " + this.f59641a + ",policy scenarioId = " + str));
                C12318k0.m74089a("policy scenarioId", linkedHashMap);
                C13152i.m79070o().m79085N(urgencyPolicyM79105r, str, id2);
                return;
            }
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.URGENCT_NOTICE_SINGLE;
    }
}
