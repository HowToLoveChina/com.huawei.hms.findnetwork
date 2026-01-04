package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.beans.inner.AdRequestParam;
import com.huawei.openalliance.p169ad.beans.metadata.AdEvent;
import com.huawei.openalliance.p169ad.beans.metadata.AppCollection;
import com.huawei.openalliance.p169ad.beans.server.AdContentReq;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.beans.server.AdPreReq;
import com.huawei.openalliance.p169ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.p169ad.beans.server.AppDataCollectionRsp;
import com.huawei.openalliance.p169ad.beans.server.ConsentConfigReq;
import com.huawei.openalliance.p169ad.beans.server.ConsentConfigRsp;
import com.huawei.openalliance.p169ad.beans.server.EventReportRsp;
import com.huawei.openalliance.p169ad.beans.server.PermissionRsp;
import com.huawei.openalliance.p169ad.beans.server.ThirdReportRsp;
import com.huawei.openalliance.p169ad.net.http.Response;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.fx */
/* loaded from: classes8.dex */
public interface InterfaceC7140fx {
    /* renamed from: a */
    AppConfigRsp mo43268a(String str);

    /* renamed from: a */
    ConsentConfigRsp mo43269a(String str, ConsentConfigReq consentConfigReq);

    /* renamed from: a */
    EventReportRsp mo43270a(List<AdEvent> list);

    /* renamed from: a */
    PermissionRsp mo43271a(String str, String str2, String str3, int i10, int i11);

    /* renamed from: a */
    Response<AdContentRsp> mo43272a(AdRequestParam adRequestParam);

    /* renamed from: a */
    Response<String> mo43273a(AdContentReq adContentReq);

    /* renamed from: a */
    C7654sc mo43274a(C7653sb c7653sb);

    /* renamed from: a */
    Map<Integer, AdContentRsp> mo43275a(String str, long j10, List<String> list);

    /* renamed from: a */
    void mo43276a(AdPreReq adPreReq);

    /* renamed from: b */
    AdContentReq mo43277b(AdRequestParam adRequestParam);

    /* renamed from: b */
    AppDataCollectionRsp mo43278b(List<AppCollection> list);

    /* renamed from: b */
    ThirdReportRsp mo43279b(String str);
}
