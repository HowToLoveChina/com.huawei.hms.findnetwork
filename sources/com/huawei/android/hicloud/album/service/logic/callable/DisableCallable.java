package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.hihttp.request.DisuseRequest;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.hms.network.embedded.C5963j;
import java.util.concurrent.Callable;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p251e8.C9423b;
import p850zo.InterfaceC14351b;

/* loaded from: classes2.dex */
public class DisableCallable implements Callable {
    private static final String TAG = "DisableCallable";
    private Context context = C0213f.m1377a();
    private InterfaceC14351b mCloudAlbumListener;

    public DisableCallable(InterfaceC14351b interfaceC14351b) {
        this.mCloudAlbumListener = interfaceC14351b;
    }

    private void notifyDisuseResult(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(C5963j.f27041j, i10);
        InterfaceC14351b interfaceC14351b = this.mCloudAlbumListener;
        if (interfaceC14351b != null) {
            interfaceC14351b.onResult(bundle);
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        int i10 = 1;
        try {
            BaseResponse baseResponseM80113o = new DisuseRequest(this.context).m80113o(BaseResponse.class);
            if (baseResponseM80113o != null) {
                int code = baseResponseM80113o.getCode();
                try {
                    C1120a.m6677i(TAG, "status.disable code: " + code + ", info: " + baseResponseM80113o.getInfo());
                    if (code == 0 || code == 30) {
                        if (CloudAlbumSettings.m14363h().m14385u()) {
                            C9423b.m59097e(this.context, 1, C1122c.m6798k0());
                        } else {
                            C1136q.b.m6992B0(this.context, 1);
                            C1136q.b.m7082n1(this.context, false);
                        }
                    }
                    i10 = code;
                } catch (Exception e10) {
                    e = e10;
                    i10 = code;
                    C1120a.m6676e(TAG, "DisuseRequest err: " + e.toString());
                    notifyDisuseResult(i10);
                    return null;
                }
            }
        } catch (Exception e11) {
            e = e11;
        }
        notifyDisuseResult(i10);
        return null;
    }
}
