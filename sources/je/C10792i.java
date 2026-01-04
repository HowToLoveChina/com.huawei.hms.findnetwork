package je;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.cloud.pay.model.Response;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.messagecenter.bean.ClientMessageBody;
import com.huawei.hicloud.messagecenter.manager.MessageCenterReportUtil;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0213f;
import p015ak.InterfaceC0231p;
import p020ap.C1008c;
import p020ap.C1010e;
import p341hj.C10228g;
import p514o9.C11839m;
import p572qb.C12303d;
import p709vj.C13452e;

/* renamed from: je.i */
/* loaded from: classes3.dex */
public class C10792i implements InterfaceC0231p {

    /* renamed from: je.i$a */
    public class a implements C10228g.a {
        @Override // p341hj.C10228g.a
        /* renamed from: a */
        public void mo63392a(Response response) {
            C11839m.m70688i("CommonModuleUtil", "CampaignReportAfterMsgTask success, resp: " + response.getResultDesc());
            MessageCenterReportUtil.reportMsgActivityEnd("finish", response.getResultDesc());
        }

        @Override // p341hj.C10228g.a
        public void onError(String str) {
            C11839m.m70687e("CommonModuleUtil", "CampaignReportAfterMsgTask fail, error: " + str);
            MessageCenterReportUtil.reportMsgActivityEnd(VastAttribute.ERROR, str);
        }
    }

    /* renamed from: je.i$b */
    public static class b {

        /* renamed from: a */
        public static C10792i f51542a = new C10792i(null);
    }

    public /* synthetic */ C10792i(a aVar) {
        this();
    }

    /* renamed from: d */
    public static C10792i m65668d() {
        return b.f51542a;
    }

    /* renamed from: f */
    public static boolean m65669f(ClientMessageBody clientMessageBody) {
        C11839m.m70688i("CommonModuleUtil", "isSatisfyReport");
        if (clientMessageBody == null) {
            C11839m.m70689w("CommonModuleUtil", "message is null");
            return false;
        }
        if (!TextUtils.equals("operation", clientMessageBody.getCategory())) {
            C11839m.m70689w("CommonModuleUtil", "not operation type");
            return false;
        }
        NotifyWay[] notifyWays = clientMessageBody.getNotifyWays();
        ArrayList arrayList = new ArrayList();
        for (NotifyWay notifyWay : notifyWays) {
            arrayList.add(notifyWay.getName());
        }
        if (!arrayList.contains("message") && !arrayList.contains("notification_bar")) {
            C11839m.m70689w("CommonModuleUtil", "not notifyWay type");
            return false;
        }
        String notifyType = clientMessageBody.getNotifyType();
        if (TextUtils.equals(notifyType, "campaignNotify_8") || TextUtils.equals(notifyType, "campaignNotify_9")) {
            return true;
        }
        C11839m.m70689w("CommonModuleUtil", "not notifyType");
        return false;
    }

    /* renamed from: g */
    public static void m65670g(ClientMessageBody clientMessageBody) {
        C11839m.m70688i("CommonModuleUtil", "reportAfterMsg");
        if (!m65669f(clientMessageBody)) {
            C11839m.m70689w("CommonModuleUtil", "no need report");
            return;
        }
        Map<String, String> params = clientMessageBody.getParams();
        if (params == null) {
            C11839m.m70689w("CommonModuleUtil", "params is null");
            return;
        }
        HashMap map = new HashMap();
        map.put("activityId", params.get("activityId"));
        map.put("msgType", Integer.valueOf(TextUtils.equals(clientMessageBody.getNotifyType(), "campaignNotify_8") ? 8 : 9));
        map.put("sessionId", params.get("sessionId"));
        new C10228g(new Gson().toJson(map), new a()).m63381g();
    }

    @Override // p015ak.InterfaceC0231p
    /* renamed from: a */
    public void mo1614a() {
        C12303d.m73958f().m73962h("user-contact_sync_apply");
    }

    @Override // p015ak.InterfaceC0231p
    /* renamed from: b */
    public void mo1615b() {
        C1008c.m6035v().m6064b();
    }

    @Override // p015ak.InterfaceC0231p
    /* renamed from: c */
    public boolean mo1616c() {
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            return m65671e();
        }
        return true;
    }

    /* renamed from: e */
    public boolean m65671e() {
        if (C10028c.m62182c0().m62388s("backup_key")) {
            return true;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CommonModuleUtil", "context is null");
            return false;
        }
        if (C1010e.m6125b().m6138d(contextM1377a)) {
            return true;
        }
        return C1008c.m6035v().m6044I(contextM1377a);
    }

    public C10792i() {
    }
}
