package com.huawei.hms.p109a.p110a.p114d;

import android.content.Context;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.utils.PickerHiAnalyticsUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.PickerCommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import iq.C10588b;
import iq.InterfaceC10596j;
import p208cq.C8941i;
import p640sq.C12836o;

/* renamed from: com.huawei.hms.a.a.d.c */
/* loaded from: classes8.dex */
public class C5043c implements InterfaceC10596j<C10588b> {

    /* renamed from: a */
    private C8941i<Void> f23029a = new C8941i<>();

    /* renamed from: b */
    private Context f23030b;

    /* renamed from: c */
    private String f23031c;

    public C5043c(Context context, String str) {
        this.f23030b = context;
        this.f23031c = str;
    }

    /* renamed from: a */
    public C8941i<Void> m30093a() {
        return this.f23029a;
    }

    @Override // iq.InterfaceC10596j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResult(C10588b c10588b) {
        if (c10588b.m64965b()) {
            C12836o.m77097b("[ACCOUNTSDK]AccountPickerSignOutCallBack", "ClearAccountResult is success.", true);
            this.f23029a.m56658d(null);
            m30092a(0);
            return;
        }
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerSignOutCallBack", "ClearAccountResult is error: " + c10588b.m64964a().m64995a(), true);
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerSignOutCallBack", "ClearAccountResult is error: " + c10588b.m64964a().m64995a() + " status message " + c10588b.m64964a().m64996b(), false);
        this.f23029a.m56657c(new ApiException(new Status(2015, c10588b.m64964a().m64996b())));
        m30092a(2015);
    }

    /* renamed from: a */
    private void m30092a(int i10) {
        HiAnalyticsClient.reportExit(this.f23030b, PickerCommonNaming.AccountPickerSignout, this.f23031c, PickerHiAnalyticsUtil.getHiAnalyticsStatus(i10), i10);
    }
}
