package p675uc;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteBrowserLocalDataTask;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteCalendarLocalDataTask;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteContactLocalDataTask;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteFrameworkLocalDataTask;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteNotepadLocalDataTask;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteWlanLocalDataTask;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import p015ak.C0209d;
import p514o9.C11839m;
import p783xp.C13843a;

/* renamed from: uc.a */
/* loaded from: classes3.dex */
public class C13153a {

    /* renamed from: a */
    public static final Uri f59658a = Uri.parse("content://com.android.calendar/hw_sync/get_count");

    /* renamed from: b */
    public static boolean f59659b = false;

    /* renamed from: A */
    public static boolean m79113A() {
        return f59659b;
    }

    /* renamed from: B */
    public static int m79114B(Context context, String str) {
        if (context == null) {
            C11839m.m70687e("SyncThirdAppProvider", "queryBrowserDataCount, context is null");
            return -1;
        }
        String[] strArr = {"title"};
        Cursor cursor = null;
        try {
            try {
                Uri uriBuild = new Uri.Builder().authority(str).scheme("content").appendPath("bookmarks").appendQueryParameter("caller", "hw_system").build();
                if (!C0209d.m1227Y1(context, uriBuild)) {
                    C11839m.m70687e("SyncThirdAppProvider", "TargetApp is not SystemApp");
                    return -1;
                }
                Cursor cursorQuery = context.getContentResolver().query(uriBuild, strArr, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return -1;
                }
                int count = cursorQuery.getCount();
                cursorQuery.close();
                return count;
            } catch (Exception e10) {
                C11839m.m70687e("SyncThirdAppProvider", "queryBrowserDataCount error: " + e10.toString());
                if (0 != 0) {
                    cursor.close();
                }
                return -1;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* renamed from: a */
    public static void m79115a(Context context) {
        m79122h(context);
        m79120f(context);
        m79118d(context);
        m79128n(context);
        m79125k(context);
        for (SyncConfigService syncConfigService : NotifyUtil.getShownSyncServiceItems(context)) {
            if (syncConfigService != null) {
                for (String str : syncConfigService.getApplications()) {
                    if (C0209d.m1221W1(context, str)) {
                        m79123i(context, str);
                    } else {
                        C11839m.m70687e("SyncThirdAppProvider", "clearPrepare, package not support SyncAbility, packageName: " + str);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static void m79116b(Context context) {
        m79121g(context);
        m79117c(context);
        m79127m(context);
        m79126l(context);
        for (SyncConfigService syncConfigService : NotifyUtil.getShownSyncServiceItems(context)) {
            if (syncConfigService != null) {
                for (String str : syncConfigService.getApplications()) {
                    if (C0209d.m1221W1(context, str)) {
                        m79124j(context, str);
                    } else {
                        C11839m.m70687e("SyncThirdAppProvider", "deleteTag, package not support SyncAbility, packageName: " + str);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static int m79117c(Context context) {
        if (C13843a.m83092n(context) == null) {
            return 0;
        }
        return m79130p(context, C13843a.m83091m() + ".hicloud.deleteTagProvider");
    }

    /* renamed from: d */
    public static int m79118d(Context context) {
        if (C13843a.m83092n(context) == null) {
            return 0;
        }
        return m79129o(context, C13843a.m83091m() + ".hicloud.deleteTagProvider");
    }

    /* renamed from: e */
    public static int m79119e(Context context) {
        if (C0209d.m1304s0(context, "com.android.providers.calendar") >= 100) {
            return m79130p(context, "com.android.providers.calendar.hicloud.deleteTagProvider");
        }
        return 0;
    }

    /* renamed from: f */
    public static int m79120f(Context context) {
        if (C0209d.m1304s0(context, "com.android.providers.calendar") >= 100) {
            return m79129o(context, "com.android.providers.calendar.hicloud.deleteTagProvider");
        }
        return 0;
    }

    /* renamed from: g */
    public static int m79121g(Context context) {
        if (C13843a.m83073Y(context)) {
            return m79130p(context, "com.huawei.contacts.sync.hicloud.deleteTagProvider");
        }
        return 0;
    }

    /* renamed from: h */
    public static int m79122h(Context context) {
        if (C13843a.m83073Y(context)) {
            return m79129o(context, "com.huawei.contacts.sync.hicloud.deleteTagProvider");
        }
        return 0;
    }

    /* renamed from: i */
    public static int m79123i(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("SyncThirdAppProvider", "clearFrameworkTag: deleteTag packageName is empty");
            return -1;
        }
        return m79129o(context, str + ".hicloud.deleteTagProvider");
    }

    /* renamed from: j */
    public static int m79124j(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("SyncThirdAppProvider", "clearFrameworkTag: deleteTag packageName is empty");
            return -1;
        }
        return m79130p(context, str + ".hicloud.deleteTagProvider");
    }

    /* renamed from: k */
    public static int m79125k(Context context) {
        return m79129o(context, "com.android.gallery3d.hicloud.deleteTagProvider");
    }

    /* renamed from: l */
    public static int m79126l(Context context) {
        return m79130p(context, "com.android.gallery3d.hicloud.deleteTagProvider");
    }

    /* renamed from: m */
    public static int m79127m(Context context) {
        return m79130p(context, "com.example.android.notepad.hicloud.deleteTagProvider");
    }

    /* renamed from: n */
    public static int m79128n(Context context) {
        return m79129o(context, "com.example.android.notepad.hicloud.deleteTagProvider");
    }

    /* renamed from: o */
    public static int m79129o(Context context, String str) {
        C11839m.m70688i("SyncThirdAppProvider", "clearPrepareInfo, authority: " + str);
        if (context == null) {
            C11839m.m70687e("SyncThirdAppProvider", "clearPrepareInfo error, context is null");
            return -1;
        }
        Uri uriBuild = new Uri.Builder().authority(str).scheme("content").appendPath("clear_prepare").build();
        if (!C0209d.m1227Y1(context, uriBuild) && !NotifyUtil.isTargetAppInWhitelist(context, uriBuild)) {
            C11839m.m70687e("SyncThirdAppProvider", "clearPrepareInfo: TargetApp is not valid");
            return -1;
        }
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
        try {
            try {
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.call("clear_prepare", null, null);
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return 0;
                }
                C11839m.m70688i("SyncThirdAppProvider", "clearPrepareInfo: cpClient is null");
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
                return 0;
            } catch (Exception e10) {
                C11839m.m70687e("SyncThirdAppProvider", "clearPrepareInfo error: " + e10.toString());
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
                return -1;
            }
        } catch (Throwable th2) {
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            throw th2;
        }
    }

    /* renamed from: p */
    public static int m79130p(Context context, String str) {
        C11839m.m70688i("SyncThirdAppProvider", "deleteTag, authority: " + str);
        if (context == null) {
            C11839m.m70687e("SyncThirdAppProvider", "deleteTag error, context is null");
            return -1;
        }
        Uri uriBuild = new Uri.Builder().authority(str).scheme("content").appendPath("delete_tag").build();
        if (!C0209d.m1227Y1(context, uriBuild) && !NotifyUtil.isTargetAppInWhitelist(context, uriBuild)) {
            C11839m.m70687e("SyncThirdAppProvider", "clearThirdAppTag: TargetApp is not valid");
            return -1;
        }
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
        try {
            try {
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    int iDelete = contentProviderClientAcquireUnstableContentProviderClient.delete(uriBuild, null, null);
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return iDelete;
                }
                C11839m.m70688i("SyncThirdAppProvider", "clearThirdAppTag: cpClient is null");
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    return 0;
                }
                contentProviderClientAcquireUnstableContentProviderClient.release();
                return 0;
            } catch (Exception e10) {
                C11839m.m70687e("SyncThirdAppProvider", "clearThirdAppTag error: " + e10.toString());
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
                return -1;
            }
        } catch (Throwable th2) {
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            throw th2;
        }
    }

    /* renamed from: q */
    public static int m79131q(String str, Context context, int i10) throws Throwable {
        SyncConfigService serviceById = new SyncConfigOperator().getServiceById(str);
        if (serviceById == null) {
            return -1;
        }
        for (String str2 : serviceById.getApplications()) {
            if (C0209d.m1221W1(context, str2)) {
                i10 = m79124j(context, str2);
                if (i10 != 0) {
                    return i10;
                }
            } else {
                C11839m.m70687e("SyncThirdAppProvider", "deleteTag, package not support SyncAbility, packageName: " + str2);
            }
        }
        return i10;
    }

    /* renamed from: r */
    public static void m79132r(Context context, String str, int i10, String str2) throws Throwable {
        int i11;
        C11839m.m70688i("SyncThirdAppProvider", "deleteSyncData: start syncType = " + str + ", toDeleteType = " + i10);
        str.hashCode();
        switch (str) {
            case "addressbook":
                DeleteContactLocalDataTask.deleteContactData(context, i10, str2);
                break;
            case "calendar":
                DeleteCalendarLocalDataTask.deleteCalendarData(context, i10, str2);
                break;
            case "wlan":
                DeleteWlanLocalDataTask.deleteWlanData(context, i10, str2);
                break;
            case "browser":
                DeleteBrowserLocalDataTask.deleteBrowserData(context, i10, str2);
                break;
            case "notepad":
                if (TextUtils.equals("local_logout_account", str2)) {
                    C0209d.m1334z2(context, "hicloud_sync_notepad", 0);
                }
                DeleteNotepadLocalDataTask.deleteNotepadData(context, C13843a.m83050B(context), i10, str2);
                break;
            default:
                SyncConfigService serviceById = new SyncConfigOperator().getServiceById(str);
                if (serviceById == null) {
                    C11839m.m70687e("SyncThirdAppProvider", "deleteSyncData: syncConfig is null");
                    break;
                } else {
                    for (String str3 : serviceById.getApplications()) {
                        if (C0209d.m1221W1(context, str3)) {
                            DeleteFrameworkLocalDataTask.deleteFrameworkData(context, str3, i10, str2);
                        } else {
                            C11839m.m70687e("SyncThirdAppProvider", "deleteSyncData: package not support SyncAbility, packageName: " + str3);
                        }
                    }
                    break;
                }
        }
        C11839m.m70688i("SyncThirdAppProvider", "deleteSyncData: end syncType = " + str + ", toDeleteType = " + i10);
    }

    /* renamed from: s */
    public static int m79133s(String str, Context context) throws Exception {
        int iM79121g;
        C11839m.m70688i("SyncThirdAppProvider", "deleteTag: syncType = " + str);
        if (str == null || context == null) {
            throw new IllegalArgumentException("deleteTag: syncType or context is null");
        }
        str.hashCode();
        iM79121g = 0;
        switch (str) {
            case "addressbook":
                DeleteContactLocalDataTask.deleteContactTag();
                if (C13843a.m83073Y(context)) {
                    iM79121g = m79121g(context);
                    break;
                }
                break;
            case "calendar":
                DeleteCalendarLocalDataTask.deleteCalendarTag();
                iM79121g = m79119e(context);
                break;
            case "wlan":
                DeleteWlanLocalDataTask.deleteWlanTag();
                break;
            case "atlas":
                iM79121g = m79126l(context);
                break;
            case "browser":
                DeleteBrowserLocalDataTask.deleteBrowserTag();
                iM79121g = m79117c(context);
                break;
            case "notepad":
                DeleteNotepadLocalDataTask.deleteNotePadTag();
                iM79121g = m79127m(context);
                break;
            default:
                iM79121g = m79131q(str, context, 0);
                break;
        }
        C11839m.m70688i("SyncThirdAppProvider", "deleteTag: syncType = " + str + ", deleteState = " + iM79121g);
        return iM79121g;
    }

    /* renamed from: t */
    public static boolean m79134t(Context context) {
        Uri uri = f59658a;
        boolean z10 = false;
        if (!C0209d.m1227Y1(context, uri)) {
            C11839m.m70687e("SyncThirdAppProvider", "TargetApp is not SystemApp");
            return false;
        }
        Cursor cursorM1286n2 = C0209d.m1286n2(context, uri, null, null, null, null);
        if (cursorM1286n2 != null) {
            try {
                try {
                    if (cursorM1286n2.getCount() == 1 && cursorM1286n2.moveToFirst()) {
                        if (cursorM1286n2.getInt(cursorM1286n2.getColumnIndex("count")) > 0) {
                            z10 = true;
                        }
                    }
                } catch (Exception e10) {
                    C11839m.m70687e("SyncThirdAppProvider", "hasCalendarLocalData error: " + e10.toString());
                }
            } finally {
                cursorM1286n2.close();
            }
        }
        return z10;
    }

    /* renamed from: u */
    public static boolean m79135u(Context context) {
        if (context == null) {
            C11839m.m70687e("SyncThirdAppProvider", "query contact local data error : context is null");
            return false;
        }
        Cursor cursorM1286n2 = C0209d.m1286n2(context, new Uri.Builder().authority(C13843a.m83095q()).scheme("content").appendPath("query_local_data").build(), null, null, null, null);
        try {
            if (cursorM1286n2 != null) {
                try {
                    if (cursorM1286n2.getCount() > 0) {
                        cursorM1286n2.close();
                        return true;
                    }
                } catch (Exception e10) {
                    C11839m.m70687e("SyncThirdAppProvider", "hasContactLocalData error: " + e10.toString());
                }
            }
            return false;
        } finally {
            cursorM1286n2.close();
        }
    }

    /* renamed from: v */
    public static boolean m79136v(Context context, String str) {
        Cursor cursorM1286n2;
        if (!TextUtils.isEmpty(str)) {
            C11839m.m70688i("SyncThirdAppProvider", "hasFrameworkLocalData, packageName: " + str);
            Uri uriBuild = new Uri.Builder().authority(str + ".cloudSync").scheme("content").appendPath("query_local_data").build();
            if (!C0209d.m1227Y1(context, uriBuild) && !NotifyUtil.isTargetAppInWhitelist(context, uriBuild)) {
                C11839m.m70687e("SyncThirdAppProvider", "hasFrameworkLocalData, TargetApp is not valid");
                return false;
            }
            try {
                cursorM1286n2 = context.getContentResolver().query(uriBuild, null, null, null, null);
            } catch (Exception e10) {
                C11839m.m70687e("SyncThirdAppProvider", "hasFrameworkLocalData,queryProvider error = " + e10.toString() + ", retry.");
                cursorM1286n2 = C0209d.m1286n2(context, uriBuild, null, null, null, null);
            }
            try {
                if (cursorM1286n2 != null) {
                    try {
                        if (cursorM1286n2.getCount() > 0) {
                            return true;
                        }
                    } catch (Exception e11) {
                        C11839m.m70687e("SyncThirdAppProvider", "hasFrameworkLocalData error: " + e11.toString());
                    }
                }
            } finally {
                cursorM1286n2.close();
            }
        }
        return true;
    }

    /* renamed from: w */
    public static boolean m79137w(Context context, String[] strArr) {
        if (context == null) {
            C11839m.m70687e("SyncThirdAppProvider", "hasFrameworkLocalData, context is null");
            return false;
        }
        for (String str : strArr) {
            if (m79136v(context, str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: x */
    public static boolean m79138x(Context context) {
        return m79114B(context, C13843a.m83091m()) > 0;
    }

    /* renamed from: y */
    public static boolean m79139y(Context context) {
        Uri uri = Uri.parse("content://" + C13843a.m83052D() + "/is_need_sync");
        boolean z10 = false;
        if (!C0209d.m1227Y1(context, uri)) {
            C11839m.m70687e("SyncThirdAppProvider", "TargetApp is not SystemApp");
            return false;
        }
        Cursor cursorM1286n2 = C0209d.m1286n2(context, uri, null, null, null, null);
        if (cursorM1286n2 != null) {
            try {
                try {
                    if (cursorM1286n2.getCount() == 1 && cursorM1286n2.moveToFirst()) {
                        if (cursorM1286n2.getInt(cursorM1286n2.getColumnIndex("count")) > 0) {
                            z10 = true;
                        }
                    }
                } catch (Exception e10) {
                    C11839m.m70687e("SyncThirdAppProvider", "hasNoteLocalData error: " + e10.toString());
                }
            } finally {
                cursorM1286n2.close();
            }
        }
        return z10;
    }

    /* renamed from: z */
    public static boolean m79140z(Context context) {
        return m79114B(context, "com.android.browser") > 0;
    }
}
