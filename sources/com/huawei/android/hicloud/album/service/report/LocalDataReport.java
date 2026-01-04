package com.huawei.android.hicloud.album.service.report;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import java.util.Locale;
import p031b7.C1120a;
import p031b7.C1136q;
import p514o9.C11829c;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13224c;

/* loaded from: classes2.dex */
public class LocalDataReport {

    /* renamed from: a */
    public final Context f11619a;

    /* renamed from: b */
    public long f11620b;

    /* renamed from: c */
    public long f11621c;

    /* renamed from: d */
    public long f11622d;

    /* renamed from: e */
    public long f11623e;

    /* renamed from: f */
    public long f11624f;

    /* renamed from: g */
    public long f11625g;

    /* renamed from: h */
    public long f11626h;

    /* renamed from: i */
    public long f11627i;

    public static class LocalDataDailyTask extends AbstractC12367d {

        /* renamed from: a */
        public final Context f11628a;

        public LocalDataDailyTask(Context context) {
            this.f11628a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1120a.m6677i("LocalDataReport", "LocalDataCheckTask call begin!");
            LocalDataReport localDataReport = new LocalDataReport(this.f11628a);
            localDataReport.m15249c();
            C1136q.b.m7026S0(this.f11628a, System.currentTimeMillis());
            C1136q.b.m7028T0(this.f11628a, localDataReport.f11623e + localDataReport.f11627i);
            C1120a.m6677i("LocalDataReport", "LocalDataCheckTask call end!");
        }
    }

    public static class LocalDataReportTask extends AbstractC12367d {

        /* renamed from: a */
        public final Context f11629a;

        public LocalDataReportTask(Context context) {
            this.f11629a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1120a.m6677i("LocalDataReport", "call begin");
            LocalDataReport localDataReport = new LocalDataReport(this.f11629a);
            localDataReport.m15249c();
            localDataReport.m15252f();
        }
    }

    public LocalDataReport(Context context) {
        this.f11619a = context;
    }

    /* renamed from: g */
    public static void m15248g(Context context) {
        if (System.currentTimeMillis() - C1136q.b.m7011L(context) < 604800000) {
            C1120a.m6675d("LocalDataReport", "tryReport less than 7 days, ignore it");
        } else {
            C1120a.m6677i("LocalDataReport", "tryReport begin");
            C12515a.m75110o().m75175e(new LocalDataReportTask(context), true);
        }
    }

    /* renamed from: c */
    public void m15249c() {
        C1120a.m6677i("LocalDataReport", "collectLocalData");
        m15250d();
        m15251e();
    }

    /* renamed from: d */
    public final void m15250d() {
        C1120a.m6677i("LocalDataReport", "queryImages");
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f11619a.getContentResolver().query(MediaStore.Images.Media.getContentUri("external"), new String[]{"_id", "bucket_display_name", "_size"}, "_size > " + (C11829c.f54756b ? 1000 : 1024), null, "_id asc");
                if (cursorQuery != null) {
                    int columnIndex = cursorQuery.getColumnIndex("_size");
                    int columnIndex2 = cursorQuery.getColumnIndex("bucket_display_name");
                    while (cursorQuery.moveToNext()) {
                        this.f11623e += cursorQuery.getLong(columnIndex);
                        this.f11622d++;
                        String string = cursorQuery.getString(columnIndex2);
                        if (!TextUtils.isEmpty(string) && string.toLowerCase(Locale.US).equals("camera")) {
                            this.f11621c += cursorQuery.getLong(columnIndex);
                            this.f11620b++;
                        }
                    }
                }
                C1120a.m6677i("LocalDataReport", "scan images success:" + this.f11621c + "/" + this.f11620b + "," + this.f11623e + "/" + this.f11622d);
                if (cursorQuery == null) {
                    return;
                }
            } catch (Exception e10) {
                C1120a.m6676e("LocalDataReport", "scan media database error. " + e10.getMessage());
                if (cursorQuery == null) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: e */
    public final void m15251e() {
        C1120a.m6677i("LocalDataReport", "queryVideos");
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f11619a.getContentResolver().query(MediaStore.Video.Media.getContentUri("external"), new String[]{"_id", "bucket_display_name", "_size"}, "_size > 1", null, "_id asc");
                if (cursorQuery != null) {
                    int columnIndex = cursorQuery.getColumnIndex("_size");
                    int columnIndex2 = cursorQuery.getColumnIndex("bucket_display_name");
                    while (cursorQuery.moveToNext()) {
                        this.f11627i += cursorQuery.getLong(columnIndex);
                        this.f11626h++;
                        String string = cursorQuery.getString(columnIndex2);
                        if (!TextUtils.isEmpty(string) && string.toLowerCase(Locale.US).equals("camera")) {
                            this.f11625g += cursorQuery.getLong(columnIndex);
                            this.f11624f++;
                        }
                    }
                }
                C1120a.m6677i("LocalDataReport", "scan Videos success: " + this.f11625g + "/" + this.f11624f + "," + this.f11627i + "/" + this.f11626h);
                if (cursorQuery == null) {
                    return;
                }
            } catch (Exception e10) {
                C1120a.m6676e("LocalDataReport", "scan media database error. " + e10.getMessage());
                if (cursorQuery == null) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: f */
    public void m15252f() {
        C1120a.m6677i("LocalDataReport", "reportToCloud");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("syncType", PowerKitApplyUtil.GROUP_ALBUM);
        linkedHashMap.put("dataType", "camera");
        linkedHashMap.put("localImagesDataSize", String.valueOf(this.f11621c));
        linkedHashMap.put("localImagesDataCount", String.valueOf(this.f11620b));
        linkedHashMap.put("localVideosDataSize", String.valueOf(this.f11625g));
        linkedHashMap.put("localVideosDataCount", String.valueOf(this.f11624f));
        C13224c.m79487f1().m79567R("mecloud_cloud_album_data_size", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "mecloud_cloud_album_data_size", linkedHashMap);
        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
        linkedHashMap2.put("syncType", PowerKitApplyUtil.GROUP_ALBUM);
        linkedHashMap2.put("dataType", "all");
        linkedHashMap2.put("localImagesDataSize", String.valueOf(this.f11623e));
        linkedHashMap2.put("localImagesDataCount", String.valueOf(this.f11622d));
        linkedHashMap2.put("localVideosDataSize", String.valueOf(this.f11627i));
        linkedHashMap2.put("localVideosDataCount", String.valueOf(this.f11626h));
        C13224c.m79487f1().m79567R("mecloud_cloud_album_data_size", linkedHashMap2);
        UBAAnalyze.m29947H("CKC", "mecloud_cloud_album_data_size", linkedHashMap2);
        C1136q.b.m7030U0(this.f11619a, System.currentTimeMillis());
    }
}
