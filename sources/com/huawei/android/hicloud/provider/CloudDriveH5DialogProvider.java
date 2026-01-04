package com.huawei.android.hicloud.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.p106db.bean.H5DialogInfo;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class CloudDriveH5DialogProvider extends ContentProvider {

    /* renamed from: b */
    public static final UriMatcher f12716b = new UriMatcher(-1);

    /* renamed from: a */
    public Context f12717a;

    /* renamed from: a */
    public final String m17072a() {
        return m17074c("drive_h5_dialog_entry_data_sp", "drive_h5_dialog_entry_data");
    }

    /* renamed from: b */
    public final String m17073b() {
        return m17074c("drive_h5_dialog_exit_data_sp", "drive_h5_dialog_exit_data");
    }

    /* renamed from: c */
    public String m17074c(String str, String str2) {
        if (!C0212e0.m1363m(this.f12717a, str, str2 + "_pageType", "").equals("drive")) {
            C11839m.m70688i("CloudDriveH5DialogProvider", "getBundleJson pageType error");
            return "";
        }
        String strM1363m = C0212e0.m1363m(this.f12717a, str, str2 + "_" + FrequencyManager.H5DialogConstant.SCENETYPE, "");
        if ((str.equals("drive_h5_dialog_entry_data_sp") && !strM1363m.equals(NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE)) || (str.equals("drive_h5_dialog_exit_data_sp") && !strM1363m.equals("exit"))) {
            C11839m.m70688i("CloudDriveH5DialogProvider", "getBundleJson sceneType error");
            return "";
        }
        int iM1357g = C0212e0.m1357g(this.f12717a, str, str2 + "_num", -1);
        String strM1363m2 = C0212e0.m1363m(this.f12717a, str, str2 + "_" + FrequencyManager.H5DialogConstant.H5URL, "");
        if (TextUtils.isEmpty(strM1363m2) || iM1357g == -1) {
            C11839m.m70688i("CloudDriveH5DialogProvider", "getBundleJson h5Url == null:  true");
            return "";
        }
        int iM1357g2 = C0212e0.m1357g(this.f12717a, str, str2 + "_frequency", 1);
        FrequencyManager frequencyManager = new FrequencyManager();
        C11839m.m70688i("CloudDriveH5DialogProvider", "getBundleJson frequency: " + iM1357g2);
        int iM1357g3 = 0;
        if (iM1357g2 == 0) {
            iM1357g3 = C0212e0.m1357g(this.f12717a, str, str2 + "_interval", 0);
        }
        if (!frequencyManager.checkGuideH5DialogFrequency(this.f12717a, iM1357g2, -1, iM1357g3)) {
            C11839m.m70688i("CloudDriveH5DialogProvider", "getBundleJson checkGuideH5DialogFrequency:  false");
            return "";
        }
        String strM1363m3 = C0212e0.m1363m(this.f12717a, str, str2 + "_" + FrequencyManager.H5DialogConstant.ACTIVEURL, "");
        return (iM1357g == 3 || iM1357g == 4) ? m17075d(iM1357g, strM1363m2, C0212e0.m1363m(this.f12717a, str, str2 + "_" + FrequencyManager.H5DialogConstant.PACKAGEID, ""), C0212e0.m1363m(this.f12717a, str, str2 + "_" + FrequencyManager.H5DialogConstant.NOTIFYTYPE, ""), C0212e0.m1363m(this.f12717a, str, str2 + "_" + FrequencyManager.H5DialogConstant.NOTIFYURL, ""), strM1363m3, C0212e0.m1363m(this.f12717a, str, str2 + "_gradeCode", ""), C0212e0.m1363m(this.f12717a, str, str2 + "_expireTime", "")) : "";
    }

    /* renamed from: d */
    public String m17075d(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        try {
            H5DialogInfo h5DialogInfo = new H5DialogInfo(str, true, str3, str4, str5, str2, i10, str6, str7);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0212e0.m1370t(this.f12717a, FrequencyManager.CHECK_GUID_H5_DIALOG_SP, FrequencyManager.CHECK_GUID_H5_DIALOG_TIME, jCurrentTimeMillis);
            C11839m.m70688i("CloudDriveH5DialogProvider", " bundle2Json  showGuidH5 System.currentTimeMillis(): " + jCurrentTimeMillis);
            return new Gson().toJson(h5DialogInfo);
        } catch (Exception e10) {
            C11839m.m70687e("CloudDriveH5DialogProvider", "viewWeb Exception: " + e10.toString());
            return "";
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        UriMatcher uriMatcher = f12716b;
        uriMatcher.addURI("com.huawei.android.hicloud.clouddriveh5dialogprovider", "path_get_entry_h5_dialog_info", 1);
        uriMatcher.addURI("com.huawei.android.hicloud.clouddriveh5dialogprovider", "path_get_exit_h5_dialog_info", 2);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!C0209d.m1247e(getContext())) {
            return null;
        }
        int iMatch = f12716b.match(uri);
        C11839m.m70688i("CloudDriveH5DialogProvider", "match result: " + iMatch);
        this.f12717a = C0213f.m1377a();
        if (iMatch == 1) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cloud_drive_h5_dialog_provider_result"});
            matrixCursor.addRow(new Object[]{m17072a()});
            return matrixCursor;
        }
        if (iMatch != 2) {
            return null;
        }
        MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"cloud_drive_h5_dialog_provider_result"});
        matrixCursor2.addRow(new Object[]{m17073b()});
        return matrixCursor2;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
