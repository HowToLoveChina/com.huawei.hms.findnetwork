package p281f8;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.p075vo.SyncPrompt;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import p031b7.C1120a;
import p031b7.C1123d;
import p031b7.C1136q;

/* renamed from: f8.j */
/* loaded from: classes2.dex */
public class C9673j {

    /* renamed from: a */
    public static SyncPrompt f47855a = new SyncPrompt();

    /* renamed from: a */
    public static void m60389a(Context context) {
        C1120a.m6675d("SyncPromptReceiver", "clearSyncPromptState");
        f47855a.setState(SyncPrompt.SYNC_STATE_DEFAULT_BLANK);
        C1136q.b.m7018O0(context, SyncPrompt.SYNC_STATE_DEFAULT_BLANK);
        C1136q.b.m7020P0(context, 0);
    }

    /* renamed from: b */
    public static Bundle m60390b(Context context) {
        Bundle bundleM60391c = m60391c(context, C1136q.b.m6999F(context), C1136q.b.m7001G(context), C1136q.b.m7003H(context));
        C1120a.m6675d("SyncPromptReceiver", "getBundle: " + bundleM60391c.toString());
        return bundleM60391c;
    }

    /* renamed from: c */
    public static Bundle m60391c(Context context, int i10, int i11, long j10) {
        Bundle bundle = new Bundle();
        C1120a.m6675d("SyncPromptReceiver", "getBundle state: " + i10);
        if (i10 == 901 && C1123d.m6855a(context) == 4) {
            bundle.putInt(CommonConstant.ReqAccessTokenParam.STATE_LABEL, 0);
            C1136q.b.m7018O0(context, 0);
        } else {
            bundle.putInt(CommonConstant.ReqAccessTokenParam.STATE_LABEL, i10);
        }
        bundle.putInt("stoppedState", i11);
        bundle.putInt("uploadPicCount", 0);
        bundle.putInt("uploadVideoCount", 0);
        bundle.putInt("emptyThumbCount", 0);
        bundle.putLong("updatetime", j10);
        bundle.putInt("msgID", ConnectionResult.NETWORK_ERROR);
        return bundle;
    }

    /* renamed from: d */
    public static Bundle m60392d(Context context, SyncPrompt syncPrompt) {
        return m60391c(context, syncPrompt.getState(), syncPrompt.getStoppedState(), syncPrompt.getLatestSyncTime());
    }

    /* renamed from: e */
    public static void m60393e(Context context) {
        C1120a.m6675d("SyncPromptReceiver", "init");
        f47855a.setState(C1136q.b.m6999F(context));
        f47855a.setStoppedState(C1136q.b.m7001G(context));
        f47855a.setLatestSyncTime(C1136q.b.m7003H(context));
    }

    /* renamed from: f */
    public static void m60394f(Context context, CallbackHandler callbackHandler, SyncPrompt syncPrompt) {
        C1120a.m6675d("SyncPromptReceiver", "promptUpdate, updateSyncPrompt: " + syncPrompt.toString());
        int state = syncPrompt.getState();
        if (state == 910) {
            long latestSyncTime = syncPrompt.getLatestSyncTime();
            if (latestSyncTime > 0) {
                C1136q.b.m7022Q0(context, latestSyncTime);
                f47855a.setLatestSyncTime(latestSyncTime);
            }
        } else if (state == 906 || state == 902) {
            C1136q.b.m7022Q0(context, 0L);
        }
        C1136q.b.m7018O0(context, state);
        C1136q.b.m7020P0(context, syncPrompt.getStoppedState());
        f47855a.setState(state);
        f47855a.setStoppedState(syncPrompt.getStoppedState());
        f47855a.setType(syncPrompt.getType());
        callbackHandler.sendMessage(9097, m60392d(context, f47855a));
    }
}
