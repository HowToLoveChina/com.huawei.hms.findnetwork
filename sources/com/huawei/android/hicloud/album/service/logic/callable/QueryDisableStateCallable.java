package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import com.huawei.android.hicloud.album.service.hihttp.request.DisableStateRequest;
import com.huawei.android.hicloud.album.service.hihttp.request.response.DisableStateResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.SaveOriginalInfo;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import java.util.concurrent.Callable;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p251e8.C9423b;
import p850zo.InterfaceC14350a;

/* loaded from: classes2.dex */
public class QueryDisableStateCallable implements Callable {
    private static final String TAG = "QueryDisableStateCallable";
    private Context context = C0213f.m1377a();
    private InterfaceC14350a queryDisableListener;

    public QueryDisableStateCallable(InterfaceC14350a interfaceC14350a) {
        this.queryDisableListener = interfaceC14350a;
    }

    private void callBackDisableStatus(int i10, long j10, long j11, int i11) {
        int iM6683B0 = C1122c.m6683B0(this.context);
        if (CloudAlbumSettings.m14363h().m14385u()) {
            C9423b.m59097e(this.context, i10, iM6683B0);
        }
    }

    private void querySaveOriginalStatus(long j10, int i10) throws Throwable {
        if (!C1136q.e.m7166d(this.context)) {
            this.queryDisableListener.mo13565d(6, 0, j10, i10);
            return;
        }
        if (!CloudAlbumSettings.m14363h().m14385u()) {
            this.queryDisableListener.mo13565d(0, 0, j10, i10);
            return;
        }
        SaveOriginalInfo saveOriginalInfoM59103j = new C9423b().m59103j(this.context);
        if (saveOriginalInfoM59103j == null) {
            this.queryDisableListener.mo13563b();
            return;
        }
        int saveOriginalStatus = saveOriginalInfoM59103j.getSaveOriginalStatus();
        int haveAnotherNum = saveOriginalInfoM59103j.getHaveAnotherNum();
        C1120a.m6677i(TAG, "saveOriginalStatus sdk: " + saveOriginalStatus + ",haveAnotherNum:" + haveAnotherNum + ",remain:" + i10);
        this.queryDisableListener.mo13565d(saveOriginalStatus, haveAnotherNum, j10, i10);
        C1136q.b.m7049c1(this.context, saveOriginalStatus);
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        if (this.queryDisableListener == null) {
            throw new IllegalArgumentException("the QueryDisableListener can not be null");
        }
        try {
            if (CloudAlbumSettings.m14363h().m14378n()) {
                C1120a.m6677i(TAG, "QueryDisableStateCallable nonSupport");
                this.queryDisableListener.mo13564c();
                return null;
            }
            DisableStateResponse disableStateResponseM80113o = new DisableStateRequest(this.context).m80113o(DisableStateResponse.class);
            if (disableStateResponseM80113o == null) {
                C1120a.m6676e(TAG, "DisableStateRequest disableStateResponse is null");
                this.queryDisableListener.mo13563b();
                return null;
            }
            int code = disableStateResponseM80113o.getCode();
            C1120a.m6677i(TAG, "status.query code: " + code + ", info: " + disableStateResponseM80113o.getInfo());
            if (code == 0) {
                C1136q.b.m6992B0(this.context, disableStateResponseM80113o.getStatus());
                int status = disableStateResponseM80113o.getStatus();
                long disableTime = disableStateResponseM80113o.getDisableTime();
                long deleteTime = disableStateResponseM80113o.getDeleteTime();
                int remain = disableStateResponseM80113o.getRemain();
                C1136q.b.m7097s1(C0213f.m1377a(), status, deleteTime);
                if (status == 0) {
                    this.queryDisableListener.mo13562a();
                } else if (status == 1) {
                    querySaveOriginalStatus(deleteTime, remain);
                } else if (status == -1) {
                    this.queryDisableListener.mo13564c();
                }
                callBackDisableStatus(status, disableTime, deleteTime, remain);
            } else {
                this.queryDisableListener.mo13563b();
            }
            return null;
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "DisableStateRequest Exception: " + e10.toString());
            this.queryDisableListener.mo13563b();
            return null;
        } finally {
            C1122c.m6747W1(C0213f.m1377a(), "0:1", "OK", "04001", TAG, C1122c.m6755Z0("04001"));
        }
    }
}
