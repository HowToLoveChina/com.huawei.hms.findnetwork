package com.huawei.openalliance.p169ad.beans.server;

import android.content.Context;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.base.ReqBean;
import com.huawei.openalliance.p169ad.beans.metadata.AdEvent;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.C7732af;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class EventReportReq extends ReqBean {
    private List<AdEvent> event;
    private String version = Constants.INTER_VERSION;
    private String sdkversion = Config.SDK_VERSION;

    public EventReportReq() {
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: a */
    public String mo39254a() {
        return Constants.CONTENT_SERVER_REALM;
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: b */
    public String mo39256b() {
        return Constants.CONTENT_SERVER_REQ_URI;
    }

    public EventReportReq(List<AdEvent> list) {
        this.event = list;
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: a */
    public String mo39255a(Context context) {
        return context.getString(C7732af.m47471a() ? C6849R.string.hiad_content_backup_sig : C6849R.string.hiad_content_server_sig);
    }
}
