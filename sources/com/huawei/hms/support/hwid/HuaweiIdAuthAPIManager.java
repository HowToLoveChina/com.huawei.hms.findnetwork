package com.huawei.hms.support.hwid;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl;
import java.util.List;

/* loaded from: classes8.dex */
public class HuaweiIdAuthAPIManager {
    public static final Scope HUAWEIID_BASE_SCOPE;
    public static final Api<HuaweiIdAuthParams> HUAWEI_OAUTH_API;
    public static final HuaweiIdAuthAPIService HuaweiIdAuthAPIService;

    /* renamed from: a */
    private static final Api.Options<HuaweiIdAuthParams> f29998a;

    /* renamed from: com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager$1 */
    public class C64441 extends Api.Options<HuaweiIdAuthParams> {
        @Override // com.huawei.hms.api.Api.Options
        /* renamed from: a */
        public List<Scope> getScopeList(HuaweiIdAuthParams huaweiIdAuthParams) {
            return huaweiIdAuthParams.getRequestScopeList();
        }

        @Override // com.huawei.hms.api.Api.Options
        /* renamed from: b */
        public List<PermissionInfo> getPermissionInfoList(HuaweiIdAuthParams huaweiIdAuthParams) {
            return huaweiIdAuthParams.getPermissionInfos();
        }
    }

    static {
        C64441 c64441 = new Api.Options<HuaweiIdAuthParams>() { // from class: com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager.1
            @Override // com.huawei.hms.api.Api.Options
            /* renamed from: a */
            public List<Scope> getScopeList(HuaweiIdAuthParams huaweiIdAuthParams) {
                return huaweiIdAuthParams.getRequestScopeList();
            }

            @Override // com.huawei.hms.api.Api.Options
            /* renamed from: b */
            public List<PermissionInfo> getPermissionInfoList(HuaweiIdAuthParams huaweiIdAuthParams) {
                return huaweiIdAuthParams.getPermissionInfos();
            }
        };
        f29998a = c64441;
        HuaweiIdAuthAPIService = new HuaweiIdAuthAPIServiceImpl();
        HUAWEI_OAUTH_API = new Api<>(HuaweiApiAvailability.HMS_API_NAME_ID, c64441);
        HUAWEIID_BASE_SCOPE = new Scope("https://www.huawei.com/auth/account/base.profile");
    }
}
