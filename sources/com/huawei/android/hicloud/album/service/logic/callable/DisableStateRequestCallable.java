package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import com.huawei.android.hicloud.album.service.hihttp.request.DisableStateRequest;
import com.huawei.android.hicloud.album.service.hihttp.request.response.DisableStateResponse;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p581qk.AbstractC12367d;

/* loaded from: classes2.dex */
public class DisableStateRequestCallable extends AbstractC12367d {
    private static final String TAG = "DisableStateRequestCallable";
    private Context context;
    private DisableStateResponse response;

    public DisableStateRequestCallable(Context context) {
        this.context = context;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            try {
                this.response = new DisableStateRequest(this.context).m80113o(DisableStateResponse.class);
            } catch (Exception e10) {
                C1120a.m6676e(TAG, "queryDisableState error: " + e10.toString());
            }
        } finally {
            C1122c.m6747W1(C0213f.m1377a(), "0:1", "OK", "04001", TAG, C1122c.m6755Z0("04001"));
        }
    }

    public DisableStateResponse getResponse() {
        return this.response;
    }

    public void setResponse(DisableStateResponse disableStateResponse) {
        this.response = disableStateResponse;
    }
}
