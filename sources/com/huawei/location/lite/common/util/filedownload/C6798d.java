package com.huawei.location.lite.common.util.filedownload;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.location.BuildConfig;
import com.huawei.location.lite.common.chain.AbstractC6777a;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.InterfaceC6778b;
import com.huawei.location.lite.common.http.HttpClientEx;
import java.util.UUID;
import org.json.JSONException;
import p531or.C11991a;
import p688ur.C13244d;
import p688ur.C13245e;
import p785xr.C13851a;
import p785xr.C13852b;
import p785xr.C13853c;
import sr.C12847b;

/* renamed from: com.huawei.location.lite.common.util.filedownload.d */
/* loaded from: classes8.dex */
public class C6798d extends C6796b {
    @Override // com.huawei.location.lite.common.util.filedownload.C6796b, com.huawei.location.lite.common.chain.InterfaceC6778b
    /* renamed from: a */
    public void mo38411a(InterfaceC6778b.a aVar) throws JSONException {
        super.mo38411a(aVar);
        DownloadFileParam downloadFileParam = this.f31393c;
        if (downloadFileParam == null) {
            m38477b(10000, "param error");
            return;
        }
        String serviceType = downloadFileParam.getServiceType();
        String subType = this.f31393c.getSubType();
        if (TextUtils.isEmpty(serviceType) || TextUtils.isEmpty(subType)) {
            m38477b(10000, "param error");
        } else {
            m38485c(serviceType, subType);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public final void m38485c(String str, String str2) throws JSONException {
        StringBuilder sb2;
        String strM79632d;
        C13245e c13245e;
        try {
            DownLoadFileBean downLoadFileBean = (DownLoadFileBean) new HttpClientEx(C11991a.m72146b()).m38437a(new C13851a.a("/location/v1/getFileDownloadUrl").m83146p(new C13852b(UUID.randomUUID().toString())).m83144n(new C13853c.a().m83159d(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_SERVICETYPE, str).m83159d("subType", str2).m83160e()).m83143m(C12847b.m77149d(BuildConfig.LIBRARY_PACKAGE_NAME)).m83147q("POST").m83141k()).mo38439b(DownLoadFileBean.class);
            C1016d.m6186f("ReqDownloadUrlTask", "url request success url and fileVersion:" + downLoadFileBean.getFileAccessInfo().getVersion());
            m38486d(downLoadFileBean);
        } catch (C13244d e10) {
            sb2 = new StringBuilder("apiErrorCode====");
            sb2.append(e10.m79631c());
            sb2.append("apiErrorMsg=====");
            strM79632d = e10.m79632d();
            c13245e = e10;
            sb2.append(strM79632d);
            C1016d.m6183c("ReqDownloadUrlTask", sb2.toString());
            m38477b(c13245e.m79628b().f59923a, c13245e.m79628b().f59924b);
        } catch (C13245e e11) {
            sb2 = new StringBuilder("errorCode====");
            sb2.append(e11.m79628b().f59923a);
            sb2.append("errorMsg=====");
            strM79632d = e11.m79628b().f59924b;
            c13245e = e11;
            sb2.append(strM79632d);
            C1016d.m6183c("ReqDownloadUrlTask", sb2.toString());
            m38477b(c13245e.m79628b().f59923a, c13245e.m79628b().f59924b);
        }
    }

    /* renamed from: d */
    public final void m38486d(DownLoadFileBean downLoadFileBean) {
        this.f31391a.m38435k(AbstractC6777a.m38409d(new Data.C6776a().m38402c(this.f31391a.m38427c()).m38405f("download_entity", downLoadFileBean).m38400a()), this.f31392b);
    }
}
