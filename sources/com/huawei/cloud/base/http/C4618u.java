package com.huawei.cloud.base.http;

import com.huawei.hms.location.LocationRequest;

/* renamed from: com.huawei.cloud.base.http.u */
/* loaded from: classes.dex */
public class C4618u {
    /* renamed from: a */
    public static boolean m28332a(int i10) {
        if (i10 == 307) {
            return true;
        }
        switch (i10) {
            case LocationRequest.PRIORITY_MAG_POSITION /* 301 */:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: b */
    public static boolean m28333b(int i10) {
        return i10 >= 200 && i10 < 300;
    }
}
