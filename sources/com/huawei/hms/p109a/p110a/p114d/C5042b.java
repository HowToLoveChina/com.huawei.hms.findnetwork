package com.huawei.hms.p109a.p110a.p114d;

import android.content.Context;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.utils.PickerHiAnalyticsUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.PickerCommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import iq.C10597k;
import iq.InterfaceC10596j;
import p208cq.C8941i;
import p640sq.C12836o;

/* renamed from: com.huawei.hms.a.a.d.b */
/* loaded from: classes8.dex */
public class C5042b implements InterfaceC10596j<C10597k> {

    /* renamed from: a */
    private Context f23026a;

    /* renamed from: b */
    private String f23027b;

    /* renamed from: c */
    private C8941i<Void> f23028c = new C8941i<>();

    public C5042b(Context context, String str) {
        this.f23026a = context;
        this.f23027b = str;
    }

    /* renamed from: a */
    public C8941i<Void> m30090a() {
        return this.f23028c;
    }

    @Override // iq.InterfaceC10596j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResult(C10597k c10597k) {
        int iM64995a = c10597k.m64991a().m64995a();
        if (200 == iM64995a) {
            C12836o.m77097b("[ACCOUNTSDK]AccountPickerRevokeCallBack", "RevokeResult is success.", true);
            this.f23028c.m56658d(null);
            m30089a(0);
            return;
        }
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerRevokeCallBack", "RevokeResult is error: " + iM64995a, true);
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerRevokeCallBack", "RevokeResult is error: " + iM64995a + " status message " + c10597k.m64991a().m64996b(), false);
        String strM64996b = c10597k.m64991a().m64996b();
        if (404 == iM64995a) {
            this.f23028c.m56657c(new ApiException(new Status(iM64995a, "cancel authorization request error.")));
            m30089a(2005);
        } else {
            this.f23028c.m56657c(new ApiException(new Status(iM64995a, strM64996b)));
            m30089a(iM64995a);
        }
    }

    /* renamed from: a */
    private void m30089a(int i10) {
        HiAnalyticsClient.reportExit(this.f23026a, PickerCommonNaming.AccountPickerRevokeAccess, this.f23027b, PickerHiAnalyticsUtil.getHiAnalyticsStatus(i10), i10);
    }
}
