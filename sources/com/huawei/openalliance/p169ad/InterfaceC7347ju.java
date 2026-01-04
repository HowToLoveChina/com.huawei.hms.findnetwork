package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.beans.server.AdContentReq;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.beans.server.AdPreReq;
import com.huawei.openalliance.p169ad.beans.server.AdPreRsp;
import com.huawei.openalliance.p169ad.beans.server.AnalysisReportReq;
import com.huawei.openalliance.p169ad.beans.server.AppConfigReq;
import com.huawei.openalliance.p169ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.p169ad.beans.server.ConsentConfigReq;
import com.huawei.openalliance.p169ad.beans.server.ConsentConfigRsp;
import com.huawei.openalliance.p169ad.beans.server.EventReportReq;
import com.huawei.openalliance.p169ad.beans.server.EventReportRsp;
import com.huawei.openalliance.p169ad.beans.server.PermissionReq;
import com.huawei.openalliance.p169ad.beans.server.PermissionRsp;
import com.huawei.openalliance.p169ad.net.http.Response;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.ju */
/* loaded from: classes8.dex */
public interface InterfaceC7347ju {
    @InterfaceC7365kl(m45451a = "adxServerFb")
    @InterfaceC7360kg
    /* renamed from: a */
    Response<AdContentRsp> m45413a(@InterfaceC7354ka int i10, @InterfaceC7352jz AdContentReq adContentReq, @InterfaceC7358ke Map<String, String> map);

    @InterfaceC7365kl(m45451a = "adxServer")
    @InterfaceC7360kg
    /* renamed from: a */
    Response<AdPreRsp> m45414a(@InterfaceC7352jz AdPreReq adPreReq);

    @InterfaceC7365kl(m45451a = "analyticsServer")
    @InterfaceC7360kg
    /* renamed from: a */
    Response<EventReportRsp> m45415a(@InterfaceC7352jz AnalysisReportReq analysisReportReq, @InterfaceC7358ke Map<String, String> map);

    @InterfaceC7365kl(m45451a = "consentConfigServer")
    @InterfaceC7360kg
    /* renamed from: a */
    Response<ConsentConfigRsp> m45416a(@InterfaceC7352jz ConsentConfigReq consentConfigReq, @InterfaceC7358ke Map<String, String> map);

    @InterfaceC7365kl(m45451a = "eventServer")
    @InterfaceC7360kg
    /* renamed from: a */
    Response<EventReportRsp> m45417a(@InterfaceC7352jz EventReportReq eventReportReq, @InterfaceC7358ke Map<String, String> map);

    @InterfaceC7365kl(m45451a = "permissionServer")
    @InterfaceC7360kg
    /* renamed from: a */
    Response<PermissionRsp> m45418a(@InterfaceC7352jz PermissionReq permissionReq, @InterfaceC7358ke Map<String, String> map);

    @InterfaceC7365kl(m45451a = "adxServer")
    @InterfaceC7360kg
    /* renamed from: a */
    Response<AdContentRsp> m45419a(@InterfaceC7356kc boolean z10, @InterfaceC7352jz AdContentReq adContentReq, @InterfaceC7358ke Map<String, String> map);

    @InterfaceC7365kl(m45451a = "configServer")
    @InterfaceC7360kg
    /* renamed from: a */
    Response<AppConfigRsp> m45420a(@InterfaceC7356kc boolean z10, @InterfaceC7352jz AppConfigReq appConfigReq, @InterfaceC7358ke Map<String, String> map);

    @InterfaceC7365kl(m45451a = "adxServer")
    @InterfaceC7360kg
    /* renamed from: b */
    Response<String> m45421b(@InterfaceC7356kc boolean z10, @InterfaceC7352jz AdContentReq adContentReq, @InterfaceC7358ke Map<String, String> map);
}
