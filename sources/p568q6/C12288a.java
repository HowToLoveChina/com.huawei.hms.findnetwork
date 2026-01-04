package p568q6;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import aq.C1011a;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.receiver.DownloadingNotifyClickReceiver;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.Locale;
import p015ak.C0213f;
import p015ak.C0221j;
import p015ak.C0238w;
import p783xp.C13843a;

/* renamed from: q6.a */
/* loaded from: classes2.dex */
public class C12288a {

    /* renamed from: g */
    public static final String f56926g = "a";

    /* renamed from: a */
    public NotificationManager f56927a;

    /* renamed from: b */
    public Context f56928b;

    /* renamed from: c */
    public int f56929c;

    /* renamed from: d */
    public int f56930d;

    /* renamed from: e */
    public int f56931e;

    /* renamed from: f */
    public String f56932f;

    /* renamed from: q6.a$b */
    public static class b {

        /* renamed from: a */
        public static final C12288a f56933a = new C12288a();
    }

    public /* synthetic */ C12288a(a aVar) {
        this();
    }

    /* renamed from: d */
    public static C12288a m73827d() {
        return b.f56933a;
    }

    /* renamed from: a */
    public final void m73828a(NotificationCompat.Builder builder, int i10) {
        if (i10 == 1) {
            builder.m3801a(0, this.f56928b.getString(R$string.album_download_cancel), m73831e(1)).m3801a(0, this.f56928b.getString(R$string.album_download_pause), m73831e(2));
        } else if (i10 == 2 || i10 == 4 || i10 == 5) {
            builder.m3801a(0, this.f56928b.getString(R$string.album_download_cancel), m73831e(1)).m3801a(0, this.f56928b.getString(R$string.album_download_continue), m73831e(3));
        }
    }

    /* renamed from: b */
    public final void m73829b(RemoteViews remoteViews, int i10) {
        if (i10 == 4) {
            remoteViews.setTextViewText(R$id.progress_content, this.f56928b.getString(R$string.album_media_download_network_error));
        } else {
            if (i10 != 5) {
                return;
            }
            remoteViews.setTextViewText(R$id.progress_content, this.f56928b.getString(R$string.album_media_download_server_error));
        }
    }

    /* renamed from: c */
    public void m73830c() {
        NotificationManager notificationManager = this.f56927a;
        if (notificationManager != null) {
            notificationManager.cancel(385);
        }
    }

    /* renamed from: e */
    public final PendingIntent m73831e(int i10) {
        Intent intent = new Intent();
        if (i10 == 1) {
            intent.setAction("com.huawei.android.cg.notification.gallerydownloadnotification.cancel");
        } else if (i10 == 2) {
            intent.setAction("com.huawei.android.cg.notification.gallerydownloadnotification.pause");
        } else if (i10 == 3) {
            intent.setAction("com.huawei.android.cg.notification.gallerydownloadnotification.continue");
        }
        intent.setComponent(new ComponentName(this.f56928b, (Class<?>) DownloadingNotifyClickReceiver.class));
        return PendingIntent.getBroadcast(this.f56928b, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    /* renamed from: f */
    public void m73832f(int i10, int i11) throws Resources.NotFoundException {
        String string;
        String string2 = this.f56928b.getString(R$string.album_media_download_completed);
        if (i10 != i11) {
            Resources resources = this.f56928b.getResources();
            int i12 = R$plurals.album_media_download_result_number;
            int i13 = i11 - i10;
            string = this.f56928b.getString(R$string.album_media_download_result_new, resources.getQuantityString(i12, i10, Integer.valueOf(i10)), this.f56928b.getResources().getQuantityString(i12, i13, Integer.valueOf(i13)));
        } else {
            string = this.f56928b.getString(R$string.album_media_download_result_only_success, this.f56928b.getResources().getQuantityString(R$plurals.album_media_download_result_number, i10, Integer.valueOf(i10)));
        }
        NotificationCompat.Builder builderM1669j = C0238w.m1663f().m1669j(this.f56928b, f56926g);
        builderM1669j.m3824y(R$drawable.logo_about_system).m3817r("com.huawei.android.hicloud.cg").m3811l(string2).m3810k(string).m3823x(true).m3800C(System.currentTimeMillis()).m3807h(true);
        builderM1669j.m3809j(PendingIntent.getActivity(this.f56928b, 0, this.f56928b.getPackageManager().getLaunchIntentForPackage(C13843a.m83054F(this.f56928b)), HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK));
        Notification notificationM3804d = builderM1669j.m3804d();
        this.f56927a.cancel(385);
        this.f56927a.notify(386, notificationM3804d);
    }

    /* renamed from: g */
    public void m73833g(int i10, int i11, int i12, int i13, String str) throws Resources.NotFoundException {
        this.f56929c = i11;
        this.f56930d = i12;
        this.f56931e = i13;
        this.f56932f = str;
        if (i10 == 3) {
            m73832f(i12, i13);
            return;
        }
        String string = this.f56928b.getString(R$string.wish_list_input_count, C1011a.m6163c(Integer.valueOf(i12)), C1011a.m6163c(Integer.valueOf(i13)));
        NotificationCompat.Builder builderM1669j = C0238w.m1663f().m1669j(this.f56928b, f56926g);
        RemoteViews remoteViews = new RemoteViews(this.f56928b.getPackageName(), R$layout.album_notification_remote_view);
        String strM1500j = C0221j.m1500j(i11);
        String language = Locale.getDefault().getLanguage();
        if (language.equalsIgnoreCase(Constants.URDU_LANG) || language.equalsIgnoreCase("fa")) {
            strM1500j = "\u200f\u200e" + strM1500j;
        }
        String str2 = String.format(this.f56928b.getString(R$string.album_media_download_complete_percentage), strM1500j);
        String string2 = i10 == 1 ? this.f56928b.getString(R$string.album_media_download_origin_pic) : this.f56928b.getString(R$string.album_media_download_has_paused);
        remoteViews.setTextViewText(R$id.main_content, string2);
        remoteViews.setTextViewText(R$id.sub_content, string);
        remoteViews.setProgressBar(R$id.progressbar, 100, i11, false);
        remoteViews.setTextViewText(R$id.progress_content, str);
        m73829b(remoteViews, i10);
        builderM1669j.m3824y(R$drawable.logo_about_system).m3811l(string2).m3798A(str2).m3812m(remoteViews).m3817r("com.huawei.android.hicloud.cg").m3823x(true).m3800C(System.currentTimeMillis()).m3807h(false).m3810k(str).m3825z(new NotificationCompat.C0607d()).m3819t(true);
        m73828a(builderM1669j, i10);
        this.f56927a.notify(385, builderM1669j.m3804d());
    }

    /* renamed from: h */
    public void m73834h() throws Resources.NotFoundException {
        m73827d().m73833g(1, this.f56929c, this.f56930d, this.f56931e, this.f56932f);
    }

    /* renamed from: i */
    public void m73835i() throws Resources.NotFoundException {
        m73827d().m73833g(2, this.f56929c, this.f56930d, this.f56931e, this.f56932f);
    }

    public C12288a() {
        Context contextM1377a = C0213f.m1377a();
        this.f56928b = contextM1377a;
        this.f56927a = (NotificationManager) contextM1377a.getSystemService("notification");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.cg.notification.gallerydownloadnotification.cancel");
        intentFilter.addAction("com.huawei.android.cg.notification.gallerydownloadnotification.pause");
        intentFilter.addAction("com.huawei.android.cg.notification.gallerydownloadnotification.continue");
    }
}
