package com.huawei.android.hicloud.album.service.logic.callable;

import android.os.Bundle;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.album.service.p075vo.RiskInform;
import com.huawei.android.hicloud.drive.cloudphoto.model.InformCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.InformRecord;
import com.huawei.android.hicloud.drive.cloudphoto.request.Risks;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p283fa.C9678a;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import p804ya.C13924a;

/* loaded from: classes2.dex */
public class ReportRisksCallable extends AbstractC12367d {
    public static final int RISK_INFO_CREATE_DATABASE = 10880002;
    public static final String RISK_INFO_CREATE_KIND = "Media";
    private static final String TAG = "ReportRisksCallable";
    private CallbackHandler callbackHandler;
    private List<RiskInform> riskInforms;

    public ReportRisksCallable(CallbackHandler callbackHandler, List<RiskInform> list) {
        this.callbackHandler = callbackHandler;
        this.riskInforms = list;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        int iM6802l0;
        String string;
        C1120a.m6677i(TAG, "ReportRisksCallable begin");
        Bundle bundle = new Bundle();
        try {
            try {
                List<RiskInform> list = this.riskInforms;
                if (list != null && !list.isEmpty()) {
                    C13924a c13924aM60445d = C9678a.m60442e().m60445d();
                    if (c13924aM60445d == null) {
                        C1120a.m6676e(TAG, "ReportRisksCallable cloudPhotoClient is null");
                        bundle.putParcelable("HttpResult", new HttpResult(200, 1, "ReportRisksCallable cloudPhotoClient is null"));
                        this.callbackHandler.sendMessage(9205, bundle);
                        C1122c.m6750X1(C0213f.m1377a(), C1122c.m6713L0(String.valueOf(1), true), "ReportRisksCallable cloudPhotoClient is null", "04011", "ReportRisks", C1122c.m6755Z0("04011"), true);
                        return;
                    }
                    InformCreateRequest informCreateRequest = new InformCreateRequest();
                    ArrayList arrayList = new ArrayList();
                    for (RiskInform riskInform : this.riskInforms) {
                        InformRecord informRecord = new InformRecord();
                        informRecord.setFileId(riskInform.getFileID());
                        informRecord.setOwnerId(riskInform.getOwnerId());
                        informRecord.setRiskLabels(Arrays.asList(riskInform.getLabel()));
                        informRecord.setScene(riskInform.getScene());
                        arrayList.add(informRecord);
                    }
                    informCreateRequest.setRecordList(arrayList);
                    informCreateRequest.setUserId(C13452e.m80781L().m80971t0());
                    informCreateRequest.setCreatedTime(new C4644l(System.currentTimeMillis()));
                    Risks.InformCreate informCreate = c13924aM60445d.m83559p().informCreate(informCreateRequest);
                    informCreate.setRiskToken();
                    informCreate.setKind(RISK_INFO_CREATE_KIND).execute();
                    bundle.putParcelable("HttpResult", new HttpResult(200, 0, "OK"));
                    this.callbackHandler.sendMessage(9205, bundle);
                    C1122c.m6750X1(C0213f.m1377a(), C1122c.m6713L0(String.valueOf(0), true), "OK", "04011", "ReportRisks", C1122c.m6755Z0("04011"), true);
                    return;
                }
                C1120a.m6677i(TAG, "ReportRisksCallable riskInforms is empty");
                bundle.putParcelable("HttpResult", new HttpResult(200, 0, "OK"));
                this.callbackHandler.sendMessage(9205, bundle);
                C1122c.m6750X1(C0213f.m1377a(), C1122c.m6713L0(String.valueOf(0), true), "OK", "04011", "ReportRisks", C1122c.m6755Z0("04011"), true);
            } catch (IOException e10) {
                C1120a.m6676e(TAG, "ReportRisksCallable failed: " + e10.getMessage());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                bundle.putParcelable("HttpResult", new HttpResult(200, iM6802l0, string));
                this.callbackHandler.sendMessage(9205, bundle);
                C1122c.m6750X1(C0213f.m1377a(), C1122c.m6713L0(String.valueOf(iM6802l0), true), string, "04011", "ReportRisks", C1122c.m6755Z0("04011"), true);
            }
        } catch (Throwable th2) {
            bundle.putParcelable("HttpResult", new HttpResult(200, 0, "OK"));
            this.callbackHandler.sendMessage(9205, bundle);
            C1122c.m6750X1(C0213f.m1377a(), C1122c.m6713L0(String.valueOf(0), true), "OK", "04011", "ReportRisks", C1122c.m6755Z0("04011"), true);
            throw th2;
        }
    }
}
