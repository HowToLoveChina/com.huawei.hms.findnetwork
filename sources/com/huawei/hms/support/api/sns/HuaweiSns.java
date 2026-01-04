package com.huawei.hms.support.api.sns;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.support.api.entity.auth.Scope;

/* loaded from: classes8.dex */
public final class HuaweiSns {
    public static final Scope SCOPE_SNS_READ = new Scope("https://www.huawei.com/auth/sns/read");
    public static final Scope SCOPE_SNS_WRITE = new Scope("https://www.huawei.com/auth/sns/write");
    public static final Scope SCOPE_SNS_FRIENDS_ACCOUNT = new Scope("https://www.huawei.com/auth/sns/friends.account");
    public static final HuaweiSnsApi HUAWEISNSAPI = new HuaweiSnsApiImpl();
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>(HuaweiApiAvailability.HMS_API_NAME_SNS);

    private HuaweiSns() {
    }
}
