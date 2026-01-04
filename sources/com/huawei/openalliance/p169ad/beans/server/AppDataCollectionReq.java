package com.huawei.openalliance.p169ad.beans.server;

import android.content.Context;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.base.ReqBean;
import com.huawei.openalliance.p169ad.beans.metadata.AppCollection;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.C7732af;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AppDataCollectionReq extends ReqBean {
    private List<AppCollection> appList;

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: a */
    public String mo39254a() {
        return Constants.SDK_APP_DATA_REPORT_SERVER_REALM;
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: b */
    public String mo39256b() {
        return Constants.SDK_APP_DATA_REPORT_SERVER_URI;
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: c */
    public String mo39257c() {
        return "100003";
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: a */
    public String mo39255a(Context context) {
        return context.getString(C7732af.m47471a() ? C6849R.string.hiad_pps_sdk_report_data_backup_sig : C6849R.string.hiad_pps_sdk_report_data_server_sig);
    }

    /* renamed from: a */
    public void m40941a(List<AppCollection> list) {
        this.appList = list;
    }
}
