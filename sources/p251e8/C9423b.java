package p251e8;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.hihttp.request.response.SaveOriginalInfo;
import com.huawei.android.p069cg.persistence.p070db.operator.FileInfoOperator;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import java.io.IOException;
import java.util.ArrayList;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p431ko.C11079e;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p709vj.C13452e;
import p783xp.C13843a;

/* renamed from: e8.b */
/* loaded from: classes2.dex */
public class C9423b {

    /* renamed from: b */
    public static final Uri f47089b;

    /* renamed from: c */
    public static final Uri f47090c;

    /* renamed from: d */
    public static final Uri f47091d;

    /* renamed from: e */
    public static final Uri f47092e;

    /* renamed from: f */
    public static final Uri f47093f;

    /* renamed from: g */
    public static final Uri f47094g;

    /* renamed from: h */
    public static final Uri f47095h;

    /* renamed from: a */
    public final String[] f47096a = {"latest_version", "share_version", "save_original_status", "have_another_num", "download_num"};

    /* renamed from: e8.b$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public int f47097a;

        /* renamed from: b */
        public int f47098b;

        public a(int i10, int i11) {
            this.f47097a = i10;
            this.f47098b = i11;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C9423b.m59097e(C0213f.m1377a(), this.f47097a, this.f47098b);
        }
    }

    static {
        Uri uriM83100v = C13843a.m83100v();
        f47089b = uriM83100v;
        f47090c = Uri.withAppendedPath(uriM83100v, "save_original");
        f47091d = Uri.withAppendedPath(uriM83100v, "download_all_cloud_file");
        f47092e = Uri.withAppendedPath(uriM83100v, "save_original_status");
        f47093f = Uri.withAppendedPath(uriM83100v, "empty_original_path_count");
        f47094g = Uri.withAppendedPath(uriM83100v, "empty_original_path_size");
        f47095h = Uri.withAppendedPath(uriM83100v, "disable_status_changed");
    }

    /* renamed from: b */
    public static void m59095b(Context context, int i10, int i11) {
        C12515a.m75110o().m75175e(new a(i10, i11), true);
    }

    /* renamed from: d */
    public static /* synthetic */ void m59096d(boolean z10, Context context, ContentResolver contentResolver, UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo == null || userDataStateInfo.getBmType() == -1) {
            return;
        }
        if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
            C1120a.m6677i("DisableOperator", "bs grade:" + userDataStateInfo.getBsGrade());
            C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
        }
        int i10 = 1;
        if (userDataStateInfo.getBmType() == 1) {
            C13452e.m80781L().m80985w2(true);
            C1120a.m6677i("DisableOperator", "new bm type:true");
        } else if (userDataStateInfo.getBmType() == 0) {
            C1120a.m6677i("DisableOperator", "new bm type:false");
            C13452e.m80781L().m80985w2(false);
        }
        C1120a.m6677i("DisableOperator", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
        C1136q.m6954L(userDataStateInfo.getBmGradeState());
        C1136q.m6953K(userDataStateInfo.getDataPeriod());
        C1136q.m6955M(System.currentTimeMillis());
        ContentValues contentValues = new ContentValues();
        int remainDwnldDays = userDataStateInfo.getRemainDwnldDays() - userDataStateInfo.getDwnldPeriod2Days();
        if (remainDwnldDays < 1) {
            remainDwnldDays = 1;
        }
        int iM6977r = C1136q.m6977r();
        int iM6976q = C1136q.m6976q();
        if (iM6977r != 0 || (iM6976q != 1 && iM6976q != 2)) {
            i10 = iM6977r;
        }
        contentValues.put("remainState", Integer.valueOf(i10));
        contentValues.put("remainTime", Integer.valueOf(remainDwnldDays));
        contentValues.put("remainMax", Integer.valueOf(userDataStateInfo.getDwnldPeriod1Days()));
        contentValues.put("forceDownload", Boolean.valueOf(z10));
        new FileInfoOperator(context).m14552a();
        Uri uri = f47091d;
        if (C0209d.m1227Y1(context, uri)) {
            contentResolver.update(uri, contentValues, null, null);
        }
    }

    /* renamed from: e */
    public static void m59097e(Context context, int i10, int i11) {
        C1120a.m6677i("DisableOperator", "notifyDisableStatusChanged: disableStatus: " + i10 + ", remain: " + i11);
        if (context == null) {
            C1120a.m6676e("DisableOperator", "notifyDisableStatusChanged is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C1120a.m6676e("DisableOperator", "notifyDisableStatusChanged resolver is null");
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("disableStatus", Integer.valueOf(i10));
            contentValues.put("Remain", Integer.valueOf(i11));
            Uri uri = f47095h;
            if (C0209d.m1227Y1(context, uri)) {
                contentResolver.update(uri, contentValues, null, null);
            }
        } catch (Exception e10) {
            C1120a.m6676e("DisableOperator", "notifySaveOriginal error: " + e10.toString());
        }
    }

    /* renamed from: f */
    public static void m59098f(final Context context, final boolean z10) {
        C1120a.m6677i("DisableOperator", "notifyDownloadAllCloudFile start.");
        if (context == null) {
            C1120a.m6676e("DisableOperator", "notifyDownloadAllCloudFile context is null");
            return;
        }
        final ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C1120a.m6676e("DisableOperator", "notifyDownloadAllCloudFile resolver is null");
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("bs.bm.type");
            arrayList.add("bs.bm.usergrade.info");
            C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: e8.a
                @Override // p431ko.C11079e.a
                /* renamed from: a */
                public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                    C9423b.m59096d(z10, context, contentResolver, userDataStateInfo);
                }
            }, false, arrayList, "DownloadAll"), false);
        } catch (Exception unused) {
            C1120a.m6676e("DisableOperator", "notifyDownloadAllCloudFile error");
        }
    }

    /* renamed from: g */
    public static void m59099g(Context context, int i10, boolean z10) {
        C1120a.m6677i("DisableOperator", "notifySaveOriginal: saveOriginalType: " + i10 + "force: " + z10);
        if (context == null) {
            C1120a.m6676e("DisableOperator", "notifySaveOriginal is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C1120a.m6676e("DisableOperator", "notifySaveOriginal resolver is null");
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("SaveOriginalType", Integer.valueOf(i10));
            contentValues.put("EnableMobileDataSync", Boolean.valueOf(z10));
            Uri uri = f47090c;
            if (C0209d.m1227Y1(context, uri)) {
                contentResolver.update(uri, contentValues, null, null);
            }
        } catch (Exception unused) {
            C1120a.m6676e("DisableOperator", "notifySaveOriginal error");
        }
    }

    /* renamed from: h */
    public static int m59100h(Context context) throws IOException {
        int i10 = -1;
        if (context == null) {
            C1120a.m6676e("DisableOperator", "queryCountByEmptyRealPath is null");
            return -1;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C1120a.m6676e("DisableOperator", "queryCountByEmptyRealPath resolver is null");
            return -1;
        }
        try {
            try {
                Uri uri = f47093f;
                cursorQuery = C0209d.m1227Y1(context, uri) ? contentResolver.query(uri, null, null, null, null) : null;
            } catch (Exception e10) {
                C1120a.m6676e("DisableOperator", "queryCountByEmptyRealPath error: " + e10.toString());
            }
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                i10 = cursorQuery.getInt(0);
                C1120a.m6675d("DisableOperator", "queryCountByEmptyRealPath count: " + i10);
                C1122c.m6832t(cursorQuery);
                return i10;
            }
            C1120a.m6676e("DisableOperator", "queryCountByEmptyRealPath resolver no record");
            C1122c.m6832t(cursorQuery);
            return -1;
        } catch (Throwable th2) {
            C1122c.m6832t(null);
            throw th2;
        }
    }

    /* renamed from: i */
    public static long m59101i(Context context) throws IOException {
        long j10 = -1;
        if (context == null) {
            C1120a.m6676e("DisableOperator", "queryEmptyPathSize is null");
            return -1L;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C1120a.m6676e("DisableOperator", "queryEmptyPathSize resolver is null");
            return -1L;
        }
        try {
            try {
                Uri uri = f47094g;
                cursorQuery = C0209d.m1227Y1(context, uri) ? contentResolver.query(uri, null, null, null, null) : null;
            } catch (Exception e10) {
                C1120a.m6676e("DisableOperator", "queryEmptyPathSize error: " + e10.toString());
            }
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                j10 = cursorQuery.getLong(0);
                C1120a.m6675d("DisableOperator", "queryEmptyPathSize size: " + j10);
                C1122c.m6832t(cursorQuery);
                return j10;
            }
            C1120a.m6676e("DisableOperator", "queryEmptyPathSize resolver no record");
            C1122c.m6832t(cursorQuery);
            return -1L;
        } catch (Throwable th2) {
            C1122c.m6832t(null);
            throw th2;
        }
    }

    /* renamed from: c */
    public final SaveOriginalInfo m59102c(Cursor cursor) {
        SaveOriginalInfo saveOriginalInfo = new SaveOriginalInfo();
        saveOriginalInfo.setLatestVersion(cursor.getLong(0));
        saveOriginalInfo.setShareVersion(cursor.getString(1));
        saveOriginalInfo.setSaveOriginalStatus(cursor.getInt(2));
        saveOriginalInfo.setHaveAnotherNum(cursor.getInt(3));
        saveOriginalInfo.setDownloadNum(cursor.getInt(4));
        C1120a.m6675d("DisableOperator", "dealInfo: " + saveOriginalInfo.toString());
        return saveOriginalInfo;
    }

    /* renamed from: j */
    public SaveOriginalInfo m59103j(Context context) throws Throwable {
        SaveOriginalInfo saveOriginalInfo;
        C1120a.m6677i("DisableOperator", "querySaveOriginalInfo");
        Cursor cursor = null;
        if (context == null) {
            C1120a.m6676e("DisableOperator", "querySaveOriginalInfo is null");
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C1120a.m6676e("DisableOperator", "querySaveOriginalInfo resolver is null");
            return null;
        }
        try {
            try {
                Uri uri = f47092e;
                Cursor cursorQuery = C0209d.m1227Y1(context, uri) ? contentResolver.query(uri, this.f47096a, null, null, null) : null;
                try {
                    if (cursorQuery == null) {
                        C1120a.m6676e("DisableOperator", "querySaveOriginalInfo cursor is null");
                        C1122c.m6832t(cursorQuery);
                        return null;
                    }
                    if (!cursorQuery.moveToFirst()) {
                        C1120a.m6676e("DisableOperator", "querySaveOriginalInfo resolver no record");
                        C1122c.m6832t(cursorQuery);
                        return null;
                    }
                    SaveOriginalInfo saveOriginalInfoM59102c = m59102c(cursorQuery);
                    C1120a.m6675d("DisableOperator", "querySaveOriginalInfo count: " + cursorQuery.getCount());
                    C1122c.m6832t(cursorQuery);
                    return saveOriginalInfoM59102c;
                } catch (Exception e10) {
                    e = e10;
                    cursor = cursorQuery;
                    saveOriginalInfo = null;
                    C1120a.m6676e("DisableOperator", "querySaveOriginalInfo error: " + e.toString());
                    C1122c.m6832t(cursor);
                    return saveOriginalInfo;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    C1122c.m6832t(cursor);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
            saveOriginalInfo = null;
        }
    }
}
