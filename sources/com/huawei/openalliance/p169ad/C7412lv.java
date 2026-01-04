package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.lv */
/* loaded from: classes8.dex */
public class C7412lv {
    /* renamed from: a */
    public static InterfaceC7413lw m45638a(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return new C7411lu();
        }
        if (contentRecord.m41419S() != null || (contentRecord.m41421T() != null && MimeType.MP4.equals(contentRecord.m41421T().m40243a()))) {
            if (C7415ly.m45648e()) {
                return new C7415ly();
            }
        } else if (C7408lr.m45635a()) {
            return new C7408lr();
        }
        return new C7411lu();
    }
}
