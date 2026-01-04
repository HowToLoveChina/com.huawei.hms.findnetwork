package mc;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.hicloud.p088ui.activity.SiteChangeDialogActivity;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p514o9.C11839m;
import p664u0.C13108a;
import p709vj.C13452e;

/* renamed from: mc.b */
/* loaded from: classes3.dex */
public class C11437b {

    /* renamed from: a */
    public static C11437b f53280a = new C11437b();

    /* renamed from: e */
    public static C11437b m68501e() {
        return f53280a;
    }

    /* renamed from: a */
    public void m68502a(Context context) {
        if (context != null) {
            C13108a.m78878b(context).m78881d(new Intent("com.huawei.hicloud.CLOSE_DIALOG_ACTION"));
        }
    }

    /* renamed from: b */
    public void m68503b(Context context) {
        if (context != null) {
            new HiCloudNotificationManager(context).cancelNotification(289);
        }
    }

    /* renamed from: c */
    public void m68504c(Context context) {
        m68503b(context);
        m68502a(context);
    }

    /* renamed from: d */
    public void m68505d(Context context) {
        if (context != null) {
            new HiCloudNotificationManager(context).cancelNotification(290);
        }
    }

    /* renamed from: f */
    public void m68506f(Context context, boolean z10) {
        if (context == null) {
            C11839m.m70687e("SiteStatusChangeNoticeManager", "showSiteChangedNoticeAndDialog context is null");
            return;
        }
        if (C13452e.m80781L().m80943m0() != 0) {
            C11839m.m70688i("SiteStatusChangeNoticeManager", "site change notice or dialog has shown, do not show again");
            return;
        }
        new HiCloudNotificationManager(context).sendSiteChangedNotification();
        if (z10 && C0209d.m1265i1(context)) {
            Intent intent = new Intent();
            intent.setClass(context, SiteChangeDialogActivity.class);
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(intent);
        }
        C13452e.m80781L().m80836N2(1);
    }

    /* renamed from: g */
    public void m68507g(Context context) {
        if (C13452e.m80781L().m80959q0() != 0) {
            C11839m.m70688i("SiteStatusChangeNoticeManager", "site offline notice has shown, do not show again");
        } else {
            new HiCloudNotificationManager(context).sendSiteOfflineNotification();
            C13452e.m80781L().m80852R2(1);
        }
    }
}
