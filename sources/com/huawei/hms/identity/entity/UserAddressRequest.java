package com.huawei.hms.identity.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public final class UserAddressRequest implements IMessageEntity {

    @Packed
    private List<String> countries = new ArrayList();
}
