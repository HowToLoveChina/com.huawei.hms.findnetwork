package je;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.hicloud.p088ui.activity.BrowserDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.CalendarDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.CallLogDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudCollectionDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.ContactDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.DriveConfigDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.HarassmentInterceptDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.MemorandumDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.MessageDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.SoundRecordDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.SyncConfigDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.WlanDetailActivity;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import p514o9.C11839m;
import p684un.C13223b;
import p684un.C13227f;
import p709vj.C13452e;

/* renamed from: je.m */
/* loaded from: classes3.dex */
public class C10799m {
    /* renamed from: a */
    public static void m65722a(Context context, String str, String str2) {
        if ("record".equals(str)) {
            C13223b.m79475c(context, "manage_recording", "1", C13452e.m80781L().m80971t0(), str2);
            UBAAnalyze.m29959T("PVC", "manage_recording", "1", "7", "1", str2);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_record", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_record", "1", "7");
            return;
        }
        if ("notepad".equals(str)) {
            C13223b.m79475c(context, "manage_notepad", "1", C13452e.m80781L().m80971t0(), str2);
            UBAAnalyze.m29959T("PVC", "manage_notepad", "1", "7", "1", str2);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_notepad", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_notepad", "1", "7");
            return;
        }
        if ("phonemanager".equals(str)) {
            C13223b.m79475c(context, "manage_phonemanager", "1", C13452e.m80781L().m80971t0(), str2);
            UBAAnalyze.m29959T("PVC", "manage_phonemanager", "1", "7", "1", str2);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_phonemanage", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_phonemanage", "1", "7");
            return;
        }
        if ("calendar".equals(str)) {
            C13223b.m79475c(context, "manage_calendar", "1", C13452e.m80781L().m80971t0(), str2);
            UBAAnalyze.m29959T("PVC", "manage_calendar", "1", "7", "1", str2);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_calendar", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_calendar", "1", "7");
            return;
        }
        if (HNConstants.DataType.CONTACT.equals(str)) {
            C13223b.m79475c(context, "manage_contact", "1", C13452e.m80781L().m80971t0(), str2);
            UBAAnalyze.m29959T("PVC", "manage_contact", "1", "7", "1", str2);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_contacts", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_contacts", "1", "7");
            return;
        }
        if ("wlan".equals(str)) {
            C13223b.m79475c(context, "manage_wlan", "1", C13452e.m80781L().m80971t0(), str2);
            UBAAnalyze.m29959T("PVC", "manage_wlan", "1", "7", "1", str2);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_wlan", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_wlan", "1", "7");
            return;
        }
        if ("browser".equals(str)) {
            C13223b.m79475c(context, "manage_browser", "1", C13452e.m80781L().m80971t0(), str2);
            UBAAnalyze.m29959T("PVC", "manage_browser", "1", "7", "1", str2);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_browser", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_browser", "1", "7");
            return;
        }
        if ("calllog".equals(str)) {
            C13223b.m79475c(context, "manage_calllog", "1", C13452e.m80781L().m80971t0(), str2);
            UBAAnalyze.m29959T("PVC", "manage_calllog", "1", "7", "1", str2);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_calllogs", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_calllogs", "1", "7");
            return;
        }
        if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
            C13223b.m79475c(context, "manage_sms", "1", C13452e.m80781L().m80971t0(), str2);
            UBAAnalyze.m29959T("PVC", "manage_sms", "1", "7", "1", str2);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_messages", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_messages", "1", "7");
            return;
        }
        if ("gallery_sync".equals(str)) {
            C13223b.m79475c(context, "manage_gallery", "1", C13452e.m80781L().m80971t0(), str2);
            UBAAnalyze.m29959T("PVC", "manage_gallery", "1", "7", "1", str2);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_gallery", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_gallery", "1", "7");
        }
    }

    /* renamed from: b */
    public static Intent m65723b(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, BrowserDetailActivity.class);
        return intent;
    }

    /* renamed from: c */
    public static Intent m65724c(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CalendarDetailActivity.class);
        return intent;
    }

    /* renamed from: d */
    public static Intent m65725d(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CallLogDetailActivity.class);
        return intent;
    }

    /* renamed from: e */
    public static Intent m65726e(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CloudCollectionDetailActivity.class);
        return intent;
    }

    /* renamed from: f */
    public static Intent m65727f(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, ContactDetailActivity.class);
        return intent;
    }

    /* renamed from: g */
    public static Intent m65728g(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, DriveConfigDetailActivity.class);
        return intent;
    }

    /* renamed from: h */
    public static Intent m65729h(Context context, String str) {
        if (str == null) {
            C11839m.m70688i("HiSyncSpaceDetailUtil", "getModuleIntent null");
            return null;
        }
        switch (str) {
            case "sync_config":
                return m65734m(context);
            case "phonemanager":
                return m65731j(context);
            case "record":
                return m65732k(context);
            case "clouddrive":
                return m65726e(context);
            case "calendar":
                return m65724c(context);
            case "sms":
                return m65733l(context);
            case "wlan":
                return m65735n(context);
            case "browser":
                return m65723b(context);
            case "calllog":
                return m65725d(context);
            case "drive_config":
                return m65728g(context);
            case "contact":
                return m65727f(context);
            case "notepad":
                return m65730i(context);
            default:
                return null;
        }
    }

    /* renamed from: i */
    public static Intent m65730i(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, MemorandumDetailActivity.class);
        return intent;
    }

    /* renamed from: j */
    public static Intent m65731j(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, HarassmentInterceptDetailActivity.class);
        return intent;
    }

    /* renamed from: k */
    public static Intent m65732k(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, SoundRecordDetailActivity.class);
        return intent;
    }

    /* renamed from: l */
    public static Intent m65733l(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, MessageDetailActivity.class);
        return intent;
    }

    /* renamed from: m */
    public static Intent m65734m(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, SyncConfigDetailActivity.class);
        return intent;
    }

    /* renamed from: n */
    public static Intent m65735n(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, WlanDetailActivity.class);
        return intent;
    }
}
