package p431ko;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.request.basic.bean.UserOperationReportReq;
import fk.C9721b;
import io.C10582a;
import java.util.ArrayList;
import org.json.JSONArray;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: ko.f */
/* loaded from: classes6.dex */
public class C11080f extends AbstractC12367d {
    /* renamed from: c */
    public final void m66732c() {
        C11839m.m70688i("UserOperationReportRetryTask", "clearUserOperationRecord");
        Context contextM1377a = C0213f.m1377a();
        C0212e0.m1372v(contextM1377a, "hicloud_user_operation_report_sp", "user_operation_report_list", "");
        C0212e0.m1370t(contextM1377a, "hicloud_user_operation_report_sp", "user_operation_report_time", 0L);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("UserOperationReportRetryTask", "getCurrentUserOperationRecord start");
        try {
            Context contextM1377a = C0213f.m1377a();
            if (!C0209d.m1333z1(contextM1377a)) {
                C11839m.m70689w("UserOperationReportRetryTask", "UserOperationReportRetryTask not network");
                return;
            }
            if (TextUtils.isEmpty(m66733d())) {
                C11839m.m70689w("UserOperationReportRetryTask", "UserOperationReportRetryTask list empty");
                return;
            }
            long jM1359i = C0212e0.m1359i(contextM1377a, "hicloud_user_operation_report_sp", "user_operation_report_time", 0L);
            C11839m.m70688i("UserOperationReportRetryTask", "UserOperationReportRetryTask localRecordTime: " + jM1359i);
            if (System.currentTimeMillis() - jM1359i < 86400000) {
                C11839m.m70689w("UserOperationReportRetryTask", "UserOperationReportRetryTask time no match one day");
                return;
            }
            C0212e0.m1370t(contextM1377a, "hicloud_user_operation_report_sp", "user_operation_report_time", System.currentTimeMillis());
            C10582a c10582a = new C10582a(null);
            UserOperationReportReq userOperationReportReq = new UserOperationReportReq();
            userOperationReportReq.setOpRecordList(m66733d());
            BasicBaseResp basicBaseRespM64949n0 = c10582a.m64949n0(userOperationReportReq);
            if (basicBaseRespM64949n0 == null) {
                C11839m.m70687e("UserOperationReportRetryTask", "UserOperationReportRetryTask fail responseResult is null");
                return;
            }
            C11839m.m70688i("UserOperationReportRetryTask", "UserOperationReportRetryTask end, responseResult result: " + basicBaseRespM64949n0.getResult() + ", info: " + basicBaseRespM64949n0.getInfo());
            if (basicBaseRespM64949n0.getResult() == 0) {
                m66732c();
            }
        } catch (Exception e10) {
            C11839m.m70687e("UserOperationReportRetryTask", "getCurrentUserOperationRecord exception: " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public final String m66733d() {
        C11839m.m70688i("UserOperationReportRetryTask", "getLocalUserOperationRecord");
        try {
            String strM1363m = C0212e0.m1363m(C0213f.m1377a(), "hicloud_user_operation_report_sp", "user_operation_report_list", "");
            if (TextUtils.isEmpty(strM1363m)) {
                return "";
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(strM1363m);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                arrayList.add(jSONArray.getJSONObject(i10));
            }
            return arrayList.toString();
        } catch (Exception e10) {
            C11839m.m70687e("UserOperationReportRetryTask", "getLocalUserOperationRecord exception: " + e10.getMessage());
            return "";
        }
    }
}
