package p650t7;

import android.os.Bundle;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.api.ConnectionResult;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1136q;
import p546p6.C12106s;

/* renamed from: t7.w */
/* loaded from: classes2.dex */
public class C12989w extends AbstractC12988v {
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() {
        String str = "OK";
        this.f59133f = new Bundle();
        int i10 = 0;
        try {
            try {
                Lock lockM72512d = C12106s.m72509c().m72512d(false);
                Integer lockInterval = 600;
                if (lockM72512d != null) {
                    C1120a.m6675d("KeepLockExecutor", "lock runTask: " + lockM72512d.toString());
                    lockInterval = lockM72512d.getLockInterval();
                } else {
                    i10 = FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED;
                    str = "lock is null";
                }
                this.f59133f.putInt("Interval", lockInterval.intValue());
                C1136q.b.m7010K0(C0213f.m1377a(), lockInterval.intValue());
                SyncSessionManager.m15153t().m15176W();
                this.f59133f.putInt("code", i10);
                this.f59133f.putString("info", str);
                return "";
            } catch (Exception e10) {
                C1120a.m6676e("KeepLockExecutor", "KeepLockExecutor runTask Exception: " + e10.toString());
                i10 = ConnectionResult.NETWORK_ERROR;
                String string = e10.toString();
                this.f59133f.putInt("code", ConnectionResult.NETWORK_ERROR);
                this.f59133f.putString("info", string);
                return "";
            }
        } catch (Throwable th2) {
            this.f59133f.putInt("code", i10);
            this.f59133f.putString("info", str);
            throw th2;
        }
    }
}
