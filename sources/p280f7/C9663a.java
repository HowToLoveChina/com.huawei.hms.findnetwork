package p280f7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.android.hicloud.p088ui.notification.NotificationRemoveReceiver;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.receiver.AlarmNotifyManager;
import p020ap.C1007b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;

/* renamed from: f7.a */
/* loaded from: classes2.dex */
public class C9663a {

    /* renamed from: c */
    public static final C9663a f47831c = new C9663a();

    /* renamed from: a */
    public BroadcastReceiver f47832a = new b();

    /* renamed from: b */
    public NotificationRemoveReceiver f47833b = new NotificationRemoveReceiver();

    /* renamed from: f7.a$b */
    public static class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                C11839m.m70687e("CommonReceiver", "MyReceiver context or intent is null");
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            C11839m.m70688i("CommonReceiver", "Receive broadcast, action=" + action);
            if ("com.huawei.hicloud.intent.action.CLOUDALBUM_PHOTO_TOO_MANY".equals(action)) {
                C1007b.m5980s().m6001U(context);
            }
            if ("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT".equals(action)) {
                C1007b.m5980s().m6003W(context);
            }
            if ("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY".equals(action)) {
                C1007b.m5980s().m5997Q(context);
            }
            if ("com.huawei.hicloud.intent.action.ALBUM_SYNC_NOTIFY".equals(action)) {
                C11839m.m70688i("CommonReceiver", "ALBUM_SYNC_NOTIFY");
                C12515a.m75110o().m75175e(new c(hiCloudSafeIntent), false);
            }
        }
    }

    /* renamed from: f7.a$c */
    public static class c extends AbstractC12367d {

        /* renamed from: a */
        public HiCloudSafeIntent f47834a;

        public c(HiCloudSafeIntent hiCloudSafeIntent) {
            this.f47834a = hiCloudSafeIntent;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            HiCloudNotification.getInstance().executeCloudAlbumNotify(this.f47834a);
        }
    }

    /* renamed from: a */
    public static C9663a m60338a() {
        return f47831c;
    }

    /* renamed from: b */
    public void m60339b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.intent.action.CLOUDALBUM_PHOTO_TOO_MANY");
        intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT");
        intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY");
        intentFilter.addAction("com.huawei.hicloud.intent.action.ALBUM_SYNC_NOTIFY");
        C13108a.m78878b(context).m78880c(this.f47832a, intentFilter);
        new AlarmNotifyManager().registerCallback(this.f47833b);
    }
}
