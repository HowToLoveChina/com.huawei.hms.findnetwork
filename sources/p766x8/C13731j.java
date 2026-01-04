package p766x8;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.huawei.hicloud.base.common.CommonBaseBroadcastReceiver;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0213f;
import p020ap.C1006a;
import p020ap.C1007b;
import p514o9.C11829c;
import p514o9.C11839m;
import p664u0.C13108a;
import p674ub.C13149f;

/* renamed from: x8.j */
/* loaded from: classes2.dex */
public class C13731j {

    /* renamed from: a */
    public static CommonBaseBroadcastReceiver f61724a = new a();

    /* renamed from: x8.j$a */
    public class a extends CommonBaseBroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                C11839m.m70687e("NotificationUtil", "intent or context is empty");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if (NotifyConstants.Report.ACTION_GALLERY_NOTICE_CLICK.equals(safeIntent.getAction())) {
                C11839m.m70688i("NotificationUtil", "receive ACTION_GALLERY_NOTICE_CLICK");
                C13731j.m82514d(context, safeIntent);
            } else if (NotifyConstants.Report.ACTION_SITE_CHANGE_LATER_NOTICE_CLICK.equals(safeIntent.getAction())) {
                C11839m.m70688i("NotificationUtil", "receive ACTION_GALLERY_NOTICE_CLICK");
                C1007b.m5980s().m6011c(context);
            }
        }
    }

    /* renamed from: b */
    public static void m82512b() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null || f61724a == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NotifyConstants.Report.ACTION_GALLERY_NOTICE_CLICK);
        intentFilter.addAction(NotifyConstants.Report.ACTION_SITE_CHANGE_LATER_NOTICE_CLICK);
        f61724a.m29111a(contextM1377a, intentFilter);
    }

    /* renamed from: c */
    public static boolean m82513c(Context context) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return true;
        }
        return notificationManager.areNotificationsEnabled();
    }

    /* renamed from: d */
    public static void m82514d(Context context, SafeIntent safeIntent) {
        Class clsM5963i = C1006a.m5936k().m5963i();
        if (clsM5963i == null) {
            C11839m.m70687e("NotificationUtil", "galleryMainClass is null");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) clsM5963i);
        Bundle extras = safeIntent.getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        if (!C11829c.m70581h0(clsM5963i, context) && !C11829c.m70632y0()) {
            context.startActivity(intent);
            return;
        }
        C11839m.m70688i("NotificationUtil", "GalleryMainActivity at top of the stack, no need to show");
        intent.setAction("com.huawei.hicloud.intent.action.NOTIFY_OPEN_AND_RELEASE");
        C13108a.m78878b(context).m78881d(intent);
        new C13149f().m79065c(context, intent, "2");
    }

    /* renamed from: e */
    public static void m82515e(Context context) {
        CommonBaseBroadcastReceiver commonBaseBroadcastReceiver = f61724a;
        if (commonBaseBroadcastReceiver != null) {
            commonBaseBroadcastReceiver.m29112b(context);
        }
    }
}
