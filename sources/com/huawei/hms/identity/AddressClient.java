package com.huawei.hms.identity;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.identity.entity.GetUserAddressResult;
import com.huawei.hms.identity.entity.UserAddressRequest;

/* loaded from: classes8.dex */
public interface AddressClient {
    Task<GetUserAddressResult> getUserAddress(UserAddressRequest userAddressRequest);
}
