package com.huawei.hms.identity;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes8.dex */
public class Address {
    private Address() {
    }

    public static AddressClient getAddressClient(Activity activity) {
        return new C5663a(activity);
    }

    public static AddressClient getAddressClient(Context context) {
        return new C5663a(context);
    }
}
