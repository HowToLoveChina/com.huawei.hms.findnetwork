package p431ko;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.UserOperationReportReq;
import fk.C9721b;
import io.C10582a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0212e0;
import p015ak.C0213f;
import p336he.C10159j;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: ko.g */
/* loaded from: classes6.dex */
public class C11081g extends AbstractC12367d {

    /* renamed from: a */
    public ArrayList<JSONObject> f52283a;

    /* renamed from: b */
    public JSONObject f52284b;

    /* renamed from: c */
    public String f52285c;

    /* renamed from: d */
    public String f52286d;

    /* renamed from: e */
    public String f52287e;

    /* renamed from: f */
    public String f52288f;

    public C11081g(String str, String str2) {
        this.f52283a = new ArrayList<>();
        this.f52284b = new JSONObject();
        this.f52286d = "";
        this.f52287e = "";
        this.f52285c = str;
        this.f52286d = C10159j.m63329e(System.currentTimeMillis() / 1000);
        this.f52287e = str2;
    }

    /* renamed from: c */
    public final void m66734c() throws JSONException {
        C11839m.m70688i("UserOperationReportTask", "initOpRecordList");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionDesc", this.f52285c);
            jSONObject.put("actionTime", this.f52286d);
            jSONObject.put("appVersion", C1443a.f6213a);
            jSONObject.put("notifyChannel", this.f52287e);
            jSONObject.put(NotifyConstants.Keys.NOTIFY_TYPE, this.f52287e);
            this.f52284b.put("uid", C13452e.m80781L().m80971t0());
            this.f52284b.put("terminalType", Build.MODEL);
            this.f52284b.put("dataType", 105);
            this.f52284b.put("opType", this.f52288f);
            this.f52284b.put("lastUpdateTime", this.f52286d);
            this.f52284b.put("extend", jSONObject);
            this.f52283a.add(this.f52284b);
        } catch (Exception e10) {
            C11839m.m70687e("UserOperationReportTask", "initExtend exception: " + e10.getMessage());
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        try {
            if (TextUtils.isEmpty(this.f52288f)) {
                C11839m.m70687e("UserOperationReportTask", "opType is empty, not report");
                return;
            }
            C10582a c10582a = new C10582a(null);
            m66734c();
            UserOperationReportReq userOperationReportReq = new UserOperationReportReq();
            C11839m.m70686d("UserOperationReportTask", "UserOperationReportTask properties: " + this.f52283a.toString());
            userOperationReportReq.setOpRecordList(this.f52283a.toString());
            BasicBaseResp basicBaseRespM64949n0 = c10582a.m64949n0(userOperationReportReq);
            if (basicBaseRespM64949n0 == null) {
                C11839m.m70687e("UserOperationReportTask", "userOperationReport fail responseResult is null");
                m66735d();
                return;
            }
            C11839m.m70688i("UserOperationReportTask", "userOperationReport end, responseResult result: " + basicBaseRespM64949n0.getResult() + ", info: " + basicBaseRespM64949n0.getInfo());
            if (basicBaseRespM64949n0.getResult() != 0) {
                m66735d();
            }
            m66736e(String.valueOf(basicBaseRespM64949n0.getResult()), basicBaseRespM64949n0.getInfo());
        } catch (Exception e10) {
            C11839m.m70687e("UserOperationReportTask", "UserOperationReportTask exception:" + e10.toString());
            m66735d();
        }
    }

    /* renamed from: d */
    public final void m66735d() {
        C11839m.m70688i("UserOperationReportTask", "saveCurrentUserOperationRecord");
        try {
            Context contextM1377a = C0213f.m1377a();
            String strM1363m = C0212e0.m1363m(contextM1377a, "hicloud_user_operation_report_sp", "user_operation_report_list", "");
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(strM1363m)) {
                arrayList.add(this.f52284b);
            } else {
                JSONArray jSONArray = new JSONArray(strM1363m);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    arrayList.add(jSONArray.getJSONObject(i10));
                }
                arrayList.add(this.f52284b);
            }
            C0212e0.m1372v(contextM1377a, "hicloud_user_operation_report_sp", "user_operation_report_list", arrayList.toString());
        } catch (Exception e10) {
            C11839m.m70687e("UserOperationReportTask", "saveCurrentUserOperationRecord exception: " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public final void m66736e(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("actionDesc", this.f52285c);
        linkedHashMap.put("actionTime", this.f52286d);
        linkedHashMap.put("notifyChannel", this.f52287e);
        linkedHashMap.put("responseResult", str);
        linkedHashMap.put("responseInfo", str2);
        C13230i.m79504I().m79591l0("userOperationReport", linkedHashMap);
        UBAAnalyze.m29958S("PVC", "userOperationReport", "8", "71", linkedHashMap);
    }

    public C11081g(String str, String str2, int i10) {
        this(str, str2);
        if (i10 == 12 || i10 == 13) {
            this.f52288f = "ura1";
        }
        if (i10 == 14) {
            this.f52288f = "ura2";
        }
        if (i10 == 18) {
            this.f52288f = "ura3";
        }
    }
}
