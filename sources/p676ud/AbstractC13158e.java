package p676ud;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.p075vo.SyncPrompt;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import hu.C10343b;
import p514o9.C11839m;

/* renamed from: ud.e */
/* loaded from: classes3.dex */
public abstract class AbstractC13158e extends AbstractC13155b {
    @Override // p676ud.AbstractC13155b
    /* renamed from: a */
    public void mo79141a(Context context, String str) {
    }

    @Override // p676ud.AbstractC13155b
    /* renamed from: b */
    public void mo79142b(Context context, String str, String str2) {
    }

    @Override // p676ud.AbstractC13155b
    /* renamed from: e */
    public void mo79143e(Context context, Bundle bundle, int i10) {
        if (context == null || bundle == null) {
            C11839m.m70687e("SDKTipsHelper", "getGalleryTips invalid param");
            return;
        }
        C10343b c10343b = new C10343b(bundle);
        long jM63688j = c10343b.m63688j("updatetime");
        int iM63686h = c10343b.m63686h(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
        int iM63686h2 = c10343b.m63686h("stoppedState");
        C11839m.m70688i("SDKTipsHelper", "MSGID_SYNC_STATUS_CHANGE status= " + iM63686h + ", status= " + iM63686h + ", stoppedState= " + iM63686h2 + ", updateTime= " + jM63688j + ", msgID= " + i10);
        if (mo69537d() && mo69536c(context)) {
            mo69538f();
            return;
        }
        if (i10 != 9000) {
            return;
        }
        if (iM63686h == 0) {
            mo69542j(context);
            return;
        }
        if (iM63686h == 913) {
            mo69540h(context, iM63686h2);
            return;
        }
        if (iM63686h != 914) {
            switch (iM63686h) {
                case 901:
                    mo69545m(context, iM63686h2);
                    return;
                case 902:
                case SyncPrompt.SYNC_STATE_START_SYNC /* 906 */:
                    mo69548p(context);
                    return;
                case 903:
                    mo69549q(context);
                    return;
                case 904:
                    mo69547o(context, iM63686h2);
                    return;
                case 905:
                    mo69544l(context);
                    return;
                default:
                    switch (iM63686h) {
                        case SyncPrompt.SYNC_STATE_SYNC_FAIL /* 908 */:
                            mo69541i(context);
                            break;
                        case 909:
                            mo69546n(context, iM63686h2);
                            break;
                        case SyncPrompt.SYNC_STATE_DEFAULT /* 910 */:
                            mo69539g(context, jM63688j);
                            break;
                        case SyncPrompt.SYNC_STATE_BATTERY_TOO_LOW /* 911 */:
                            break;
                        default:
                            C11839m.m70687e("SDKTipsHelper", "invalid status: " + iM63686h);
                            mo69542j(context);
                            break;
                    }
                    return;
            }
        }
        mo69543k(context, iM63686h2);
    }

    /* renamed from: h */
    public abstract void mo69540h(Context context, int i10);

    /* renamed from: i */
    public abstract void mo69541i(Context context);

    /* renamed from: j */
    public abstract void mo69542j(Context context);

    /* renamed from: k */
    public abstract void mo69543k(Context context, int i10);

    /* renamed from: l */
    public abstract void mo69544l(Context context);

    /* renamed from: m */
    public abstract void mo69545m(Context context, int i10);

    /* renamed from: n */
    public abstract void mo69546n(Context context, int i10);

    /* renamed from: o */
    public abstract void mo69547o(Context context, int i10);

    /* renamed from: p */
    public abstract void mo69548p(Context context);

    /* renamed from: q */
    public abstract void mo69549q(Context context);
}
