package fi;

import android.content.Intent;
import android.text.TextUtils;
import ba.C1159m;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import fk.C9721b;
import p015ak.C0209d;
import p015ak.C0213f;
import p258ei.C9494c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: fi.c */
/* loaded from: classes.dex */
public class C9711c extends AbstractC12367d {

    /* renamed from: a */
    public C1159m f47921a;

    /* renamed from: b */
    public Intent f47922b;

    public C9711c(C1159m c1159m, Intent intent) {
        this.f47921a = c1159m;
        this.f47922b = intent;
    }

    /* renamed from: c */
    public final String m60563c(INativeAd iNativeAd) {
        AppInfo appInfo;
        return (iNativeAd == null || (appInfo = iNativeAd.getAppInfo()) == null) ? "" : appInfo.getAppName();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C1159m c1159m = this.f47921a;
        if (c1159m == null || this.f47922b == null) {
            C11839m.m70687e("FrontOpenAppNotifyTask", "match result or intent is null, not show notify");
            return;
        }
        String strM60563c = m60563c(c1159m.m7236a());
        String strM7240e = this.f47921a.m7240e();
        String strM1303s = C0209d.m1303s(NoticeWithActivityUtil.getStrFromDBByResource(this.f47921a.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONT_APP_OPEN_TITLE), strM60563c);
        String strM1303s2 = C0209d.m1303s(NoticeWithActivityUtil.getStrFromDBByResource(this.f47921a.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONT_APP_OPEN_TEXT), strM7240e);
        if (!TextUtils.isEmpty(strM1303s) && !TextUtils.isEmpty(strM1303s2)) {
            C9494c.m59390r().m59403Q();
        }
        new HiCloudNotificationManager(C0213f.m1377a()).sendOpenFrontAppNotify(strM1303s, strM1303s2, this.f47922b);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return super.getEnum();
    }
}
