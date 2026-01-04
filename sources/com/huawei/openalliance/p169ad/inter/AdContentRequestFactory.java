package com.huawei.openalliance.p169ad.inter;

import android.content.Context;
import android.location.Location;
import android.util.Pair;
import com.huawei.hms.ads.jsb.inner.data.C5092a;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7095ek;
import com.huawei.openalliance.p169ad.C7544ol;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.inner.ApiReqParam;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import java.util.Arrays;

@OuterVisible
/* loaded from: classes2.dex */
public class AdContentRequestFactory {
    /* renamed from: a */
    public static String m43953a(Context context, int i10, RequestOptions requestOptions, C5092a c5092a) {
        return m43954a(context, new String[0], -1, i10, requestOptions, c5092a, null);
    }

    @OuterVisible
    public static String getAdRequestParameters(Context context, int i10, RequestOptions requestOptions) {
        return getAdRequestParameters(context, new String[0], -1, i10, requestOptions);
    }

    @OuterVisible
    public static void prepareRequestParam(final Context context, final RequestOptions requestOptions) {
        try {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.AdContentRequestFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    Context context2 = context;
                    RequestOptions requestOptions2 = requestOptions;
                    if (requestOptions2 == null) {
                        requestOptions2 = new RequestOptions();
                    }
                    AdContentRequestFactory.getAdRequestParameters(context2, 4, requestOptions2);
                }
            });
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AdContentRequestFactory", "prepare Param err, %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static String m43954a(Context context, String[] strArr, int i10, int i11, RequestOptions requestOptions, C5092a c5092a, ApiReqParam apiReqParam) {
        String str;
        AbstractC7185ho.m43820b("AdContentRequestFactory", "getAdRequestParameters");
        if (context == null) {
            str = "empty request parameter";
        } else {
            if (AbstractC7741ao.m47562b(context)) {
                C7762bi.m47788b(context.getApplicationContext(), requestOptions);
                C7095ek.m42934a(context).m42944e();
                if (strArr == null) {
                    strArr = new String[0];
                }
                AdSlotParam.Builder builder = new AdSlotParam.Builder();
                builder.setAdIds(Arrays.asList(strArr)).setDeviceType(i11).setWidth(AbstractC7807d.m48229d(context)).setHeight(AbstractC7807d.m48233e(context)).setRequestOptions(requestOptions);
                if (c5092a != null) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("AdContentRequestFactory", "api req param: %s.", AbstractC7758be.m47742b(c5092a));
                    }
                    builder.setDetailedCreativeTypeList(c5092a.m30375a());
                    builder.m40709b(c5092a.m30376b());
                    builder.setAdWidth(c5092a.m30377c());
                    builder.setAdHeight(c5092a.m30378d());
                    builder.setLocation(c5092a.m30379e());
                    builder.setContentBundle(c5092a.m30380f());
                }
                Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(context, true);
                if (pairM48217b != null) {
                    AbstractC7185ho.m43820b("AdContentRequestFactory", "use cached oaid " + System.currentTimeMillis());
                    builder.setOaid((String) pairM48217b.first);
                    builder.setTrackLimited((Boolean) pairM48217b.second);
                }
                return new C7544ol(context).m46334a(AbstractC7741ao.m47539a(), i10, builder.build(), apiReqParam);
            }
            str = "api level too low";
        }
        AbstractC7185ho.m43823c("AdContentRequestFactory", str);
        return "";
    }

    @OuterVisible
    public static String getAdRequestParameters(Context context, int i10, RequestOptions requestOptions, ApiReqParam apiReqParam) {
        return m43954a(context, new String[0], -1, i10, requestOptions, null, apiReqParam);
    }

    @OuterVisible
    public static String getAdRequestParameters(Context context, String[] strArr, int i10, int i11, Location location, RequestOptions requestOptions) {
        C5092a.a aVar = new C5092a.a();
        aVar.m30381a(location);
        return m43954a(context, strArr, i10, i11, requestOptions, aVar.m30385a(), null);
    }

    @OuterVisible
    public static String getAdRequestParameters(Context context, String[] strArr, int i10, int i11, RequestOptions requestOptions) {
        return m43954a(context, strArr, i10, i11, requestOptions, null, null);
    }

    @OuterVisible
    public static String getAdRequestParameters(Context context, String[] strArr, int i10, int i11, RequestOptions requestOptions, ApiReqParam apiReqParam) {
        return m43954a(context, strArr, i10, i11, requestOptions, null, apiReqParam);
    }
}
