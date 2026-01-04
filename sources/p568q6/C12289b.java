package p568q6;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.drive.cloudphoto.model.PushMessage;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.ShareAlbumApplicationInfoActivity;
import com.huawei.hicloud.bean.GraySwitch;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0235t;
import p015ak.C0238w;
import p031b7.C1120a;
import p031b7.C1136q;
import p037bp.C1270a;
import p232dp.InterfaceC9283b;
import p292fn.C9733f;
import p514o9.C11839m;
import p546p6.C12091d;

/* renamed from: q6.b */
/* loaded from: classes2.dex */
public class C12289b {

    /* renamed from: a */
    public NotificationManager f56934a;

    /* renamed from: q6.b$b */
    public static class b {

        /* renamed from: a */
        public static final C12289b f56935a = new C12289b();
    }

    /* renamed from: b */
    public static C12289b m73837b() {
        return b.f56935a;
    }

    /* renamed from: a */
    public final Context m73838a() {
        return C0213f.m1377a();
    }

    /* renamed from: c */
    public final boolean m73839c() {
        return Math.abs(System.currentTimeMillis() - C1136q.m6964e()) >= 604800000;
    }

    /* renamed from: d */
    public void m73840d(PushMessage.ApplicantInfo applicantInfo) {
        C1120a.m6675d("ShareAlbumNotification", "showApplicantNotify: applicantInfo=" + applicantInfo.toString());
        String displayName = applicantInfo.getDisplayName();
        if (TextUtils.isEmpty(displayName)) {
            displayName = C12091d.m72280a0().m72350e0(m73838a(), applicantInfo.getKinship());
        }
        String string = m73838a().getString(R$string.notification_applicant_msg, displayName, applicantInfo.getAlbumName());
        Intent intent = new Intent();
        intent.setClass(m73838a(), ShareAlbumApplicationInfoActivity.class);
        intent.putExtra("param_approval_id", applicantInfo.getApplicantId());
        C0216g0.m1402e(m73838a()).m1408F(intent, "SOURCE_ID_SHARE_ALBUM_APPLICANT_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(m73838a(), (int) System.currentTimeMillis(), intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        Resources resources = m73838a().getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        C0238w c0238wM1663f = C0238w.m1663f();
        Context contextM73838a = m73838a();
        Context contextM73838a2 = m73838a();
        int i11 = R$string.notification_applicant_title;
        NotificationCompat.Builder builderM1668i = c0238wM1663f.m1668i(contextM73838a, contextM73838a2.getString(i11));
        builderM1668i.m3824y(R$drawable.logo_about_system).m3825z(new NotificationCompat.C0605b()).m3799B(m73838a().getResources().getString(i10)).m3811l(m73838a().getString(i11)).m3810k(string).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3823x(true).m3807h(true).m3800C(System.currentTimeMillis());
        this.f56934a.notify(String.valueOf(System.currentTimeMillis()), 22, builderM1668i.m3804d());
    }

    /* renamed from: e */
    public void m73841e() throws JSONException {
        Intent intentMo58481M;
        String string;
        C1120a.m6677i("ShareAlbumNotification", "show not upload notification");
        if (!m73839c()) {
            C1120a.m6678w("ShareAlbumNotification", "Less than 7 days since last notification");
            return;
        }
        String string2 = m73838a().getString(R$string.notification_not_upload_msg);
        NotificationCompat.Builder builderM1648g = NotifyUtil.isSilentNotifyTime() ? C0235t.m1645e().m1648g(m73838a(), m73838a().getString(R$string.notification_not_upload_title), "2", m73838a().getString(R$string.channel_backup_notification)) : C0238w.m1663f().m1669j(m73838a(), m73838a().getString(R$string.notification_not_upload_title));
        C1120a.m6675d("ShareAlbumNotification", "jumpToUpgradeLink");
        new Intent();
        GraySwitch graySwitchM60764w = C9733f.m60705z().m60764w("newBusinessModelGalleryGuidePage");
        InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
        if (graySwitchM60764w == null || graySwitchM60764w.getStatus() == 0) {
            intentMo58481M = interfaceC9283b.mo58481M(m73838a());
        } else {
            try {
                string = new JSONObject(graySwitchM60764w.getParameters()).getString("url");
            } catch (JSONException e10) {
                C11839m.m70689w("ShareAlbumNotification", "FeatureSwitch parse failed: " + e10.getMessage());
                string = null;
            }
            SafeIntent safeIntent = new SafeIntent(new Intent());
            safeIntent.putExtra("srcChannel", "0");
            safeIntent.putExtra("salChannel", "0");
            intentMo58481M = !TextUtils.isEmpty(string) ? interfaceC9283b.mo58483O(m73838a(), string, safeIntent, "") : interfaceC9283b.mo58481M(m73838a());
        }
        builderM1648g.m3824y(R$drawable.logo_about_system).m3825z(new NotificationCompat.C0605b()).m3799B(m73838a().getResources().getString(R$string.HiCloud_app_name)).m3811l(m73838a().getString(R$string.notification_not_upload_title)).m3810k(string2).m3809j(C0209d.m1248e0(m73838a(), (int) System.currentTimeMillis(), intentMo58481M, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK)).m3817r("com.huawei.android.hicloud").m3823x(true).m3807h(true).m3800C(System.currentTimeMillis());
        this.f56934a.notify("BASIC_USER", 22, builderM1648g.m3804d());
        C1136q.m6948F();
    }

    public C12289b() {
        this.f56934a = (NotificationManager) m73838a().getSystemService("notification");
    }
}
