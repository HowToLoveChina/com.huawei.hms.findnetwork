package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.hihttp.request.DisableStateRequest;
import com.huawei.android.hicloud.album.service.hihttp.request.ResumeRequest;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.DisableStateResponse;
import com.huawei.android.p069cg.request.response.QueryUserSpaceResponse;
import com.huawei.hms.network.embedded.C5963j;
import java.util.concurrent.Callable;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p251e8.C9423b;
import p701v6.C13361h;
import p850zo.InterfaceC14351b;

/* loaded from: classes2.dex */
public class ResumeCallable implements Callable {
    private static final String TAG = "ResumeCallable";
    private Context context;
    private InterfaceC14351b mCloudAlbumListener;

    public ResumeCallable(InterfaceC14351b interfaceC14351b, Context context) {
        this.context = context;
        this.mCloudAlbumListener = interfaceC14351b;
    }

    private void noticeAlbumStatusChange() {
        C9423b.m59097e(this.context, 0, 0);
        C1136q.b.m7049c1(this.context, 0);
    }

    private void notifyDisuseResult(int i10, QueryUserSpaceResponse queryUserSpaceResponse) {
        C1120a.m6677i(TAG, "notifyDisuseResult: " + i10);
        Bundle bundle = new Bundle();
        bundle.putInt(C5963j.f27041j, i10);
        if (queryUserSpaceResponse != null) {
            bundle.putLong("photoTotalSize", queryUserSpaceResponse.getCloudPhotoSize());
            bundle.putLong("recycleTotalSize", queryUserSpaceResponse.getRecyclePhotoSize());
        }
        InterfaceC14351b interfaceC14351b = this.mCloudAlbumListener;
        if (interfaceC14351b != null) {
            interfaceC14351b.onResult(bundle);
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        QueryUserSpaceResponse queryUserSpaceResponseM80113o;
        int code = 1;
        try {
            queryUserSpaceResponseM80113o = new C13361h(this.context, "3").m80113o(QueryUserSpaceResponse.class);
        } catch (Exception e10) {
            e = e10;
            queryUserSpaceResponseM80113o = null;
        }
        try {
            if (queryUserSpaceResponseM80113o == null) {
                C1120a.m6676e(TAG, "querySpaceResponse is null");
                notifyDisuseResult(1, null);
                return null;
            }
            int code2 = queryUserSpaceResponseM80113o.getCode();
            C1120a.m6677i(TAG, "query space code: " + code2 + ", info: " + queryUserSpaceResponseM80113o.getInfo() + queryUserSpaceResponseM80113o.toString());
            if (code2 != 0) {
                notifyDisuseResult(1, queryUserSpaceResponseM80113o);
                return null;
            }
            try {
                DisableStateResponse disableStateResponseM80113o = new DisableStateRequest(this.context).m80113o(DisableStateResponse.class);
                if (disableStateResponseM80113o == null) {
                    C1120a.m6676e(TAG, "DisableStateRequest disableStateResponse is null");
                    notifyDisuseResult(1, null);
                    return null;
                }
                int code3 = disableStateResponseM80113o.getCode();
                String info = disableStateResponseM80113o.getInfo();
                int status = disableStateResponseM80113o.getStatus();
                C1120a.m6677i(TAG, "status.query code: " + code3 + ", info: " + info);
                if (code3 != 0) {
                    notifyDisuseResult(1, null);
                    return null;
                }
                if (status == 1 && queryUserSpaceResponseM80113o.getTotalSpaceSize() - queryUserSpaceResponseM80113o.getUseSpaceSize() < queryUserSpaceResponseM80113o.getCloudPhotoSize() + queryUserSpaceResponseM80113o.getRecyclePhotoSize()) {
                    notifyDisuseResult(4, queryUserSpaceResponseM80113o);
                    return null;
                }
                try {
                    BaseResponse baseResponseM80113o = new ResumeRequest(this.context).m80113o(BaseResponse.class);
                    if (baseResponseM80113o != null) {
                        code = baseResponseM80113o.getCode();
                        C1120a.m6677i(TAG, "status.resume code: " + code + ", info: " + baseResponseM80113o.getInfo());
                        if (code == 0) {
                            noticeAlbumStatusChange();
                        }
                    }
                } catch (Exception e11) {
                    C1120a.m6676e(TAG, "ResumeRequest err: " + e11.toString());
                }
                notifyDisuseResult(code, queryUserSpaceResponseM80113o);
                return null;
            } catch (Exception unused) {
                C1120a.m6676e(TAG, "DisableStateRequest error");
                notifyDisuseResult(1, null);
                return null;
            } finally {
                C1122c.m6747W1(C0213f.m1377a(), "0:1", "OK", "04001", TAG, C1122c.m6755Z0("04001"));
            }
        } catch (Exception e12) {
            e = e12;
            C1120a.m6676e(TAG, "query space error: " + e.toString());
            notifyDisuseResult(1, queryUserSpaceResponseM80113o);
            return null;
        }
    }
}
