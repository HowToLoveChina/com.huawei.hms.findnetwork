package p649t6;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.huawei.android.hicloud.album.service.p075vo.GalleryAlbum;
import com.huawei.android.hicloud.constant.CommonConstants;
import com.huawei.hicloud.router.data.AppInfo;
import java.util.ArrayList;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;

/* renamed from: t6.d */
/* loaded from: classes2.dex */
public class C12944d {

    /* renamed from: a */
    public static final String[] f58995a = {"albumName", "lPath", "uploadStatus"};

    /* renamed from: c */
    public static ArrayList<GalleryAlbum> m77766c() {
        Cursor cursorQuery;
        ContentResolver contentResolverM77767d = m77767d();
        Cursor cursor = null;
        if (contentResolverM77767d == null) {
            C1120a.m6676e("AppInfoOperator", "getGalleryAlbum resolver is null");
            return null;
        }
        ArrayList<GalleryAlbum> arrayList = new ArrayList<>();
        try {
            try {
                cursorQuery = contentResolverM77767d.query(CommonConstants.GalleryInfo.f12128h, f58995a, null, null, null);
                try {
                } catch (SQLiteException unused) {
                    cursor = cursorQuery;
                    C1120a.m6676e("AppInfoOperator", "getGalleryAlbum SQLiteException");
                    C1122c.m6832t(cursor);
                    return arrayList;
                } catch (Exception e10) {
                    e = e10;
                    cursor = cursorQuery;
                    C1120a.m6676e("AppInfoOperator", "getGalleryAlbum error: " + e.toString());
                    C1122c.m6832t(cursor);
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    C1122c.m6832t(cursor);
                    throw th;
                }
            } catch (SQLiteException unused2) {
            } catch (Exception e11) {
                e = e11;
            }
            if (cursorQuery == null) {
                C1120a.m6676e("AppInfoOperator", "getGalleryAlbum cursor is null");
                C1122c.m6832t(cursorQuery);
                return null;
            }
            C1120a.m6675d("AppInfoOperator", "getGalleryAlbum count is: " + cursorQuery.getCount());
            if (!cursorQuery.moveToFirst()) {
                C1120a.m6675d("AppInfoOperator", "getGalleryAlbum no record");
                C1122c.m6832t(cursorQuery);
                return null;
            }
            do {
                GalleryAlbum galleryAlbum = new GalleryAlbum();
                galleryAlbum.setAlbumName(cursorQuery.getString(0));
                galleryAlbum.setlPath(cursorQuery.getString(1));
                galleryAlbum.setUploadStatus(cursorQuery.getString(2));
                arrayList.add(galleryAlbum);
                C1120a.m6675d("AppInfoOperator", "getGalleryAlbum info: " + galleryAlbum.toString());
            } while (cursorQuery.moveToNext());
            C1122c.m6832t(cursorQuery);
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: d */
    public static ContentResolver m77767d() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C1120a.m6676e("AppInfoOperator", "context is null");
            return null;
        }
        ContentResolver contentResolver = contextM1377a.getContentResolver();
        if (contentResolver != null) {
            return contentResolver;
        }
        C1120a.m6676e("AppInfoOperator", "resolver is null");
        return null;
    }

    /* renamed from: a */
    public ArrayList<AppInfo> m77768a() throws Throwable {
        ArrayList<AppInfo> arrayListM77769b = m77769b();
        if (arrayListM77769b == null) {
            return null;
        }
        return arrayListM77769b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* renamed from: b */
    public final ArrayList<AppInfo> m77769b() throws Throwable {
        Cursor cursorQuery;
        Exception e10;
        ?? M77767d = m77767d();
        Cursor cursor = null;
        if (M77767d == 0) {
            C1120a.m6676e("AppInfoOperator", "getAllGeneralAlbumInfo resolver is null");
            return null;
        }
        ArrayList<AppInfo> arrayList = new ArrayList<>();
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                cursorQuery = M77767d.query(CommonConstants.GalleryInfo.f12126f, null, null, null, null);
                try {
                } catch (SQLiteException unused) {
                    cursor = cursorQuery;
                    C1120a.m6676e("AppInfoOperator", "getAllGeneralAlbumInfo SQLiteException");
                    C1122c.m6832t(cursor);
                    return arrayList;
                } catch (Exception e11) {
                    e10 = e11;
                    C1120a.m6676e("AppInfoOperator", "getAllGeneralAlbumInfo error: " + e10.toString());
                    C1122c.m6832t(cursorQuery);
                    return arrayList;
                }
            } catch (SQLiteException unused2) {
            } catch (Exception e12) {
                cursorQuery = null;
                e10 = e12;
            }
            if (cursorQuery == null) {
                C1120a.m6676e("AppInfoOperator", "getAllGeneralAlbumInfo cursor is null");
                C1122c.m6832t(cursorQuery);
                return null;
            }
            C1120a.m6675d("AppInfoOperator", "getAllGeneralAlbumInfo count is: " + cursorQuery.getCount());
            if (!cursorQuery.moveToFirst()) {
                C1120a.m6675d("AppInfoOperator", "getAllGeneralAlbumInfo no record");
                C1122c.m6832t(cursorQuery);
                return null;
            }
            do {
                AppInfo appInfo = new AppInfo();
                appInfo.setAlbumName(cursorQuery.getString(0));
                appInfo.setRelativePath(cursorQuery.getString(1));
                appInfo.setAlbumId(cursorQuery.getString(2));
                appInfo.setTempId(cursorQuery.getInt(3));
                appInfo.setAlbumType(cursorQuery.getInt(4));
                appInfo.setSwitchStatus(cursorQuery.getInt(5));
                appInfo.setDisplayName(cursorQuery.getString(6));
                if (7 < cursorQuery.getColumnNames().length) {
                    String string = cursorQuery.getString(7);
                    C1120a.m6677i("AppInfoOperator", "getAllGeneralAlbumInfo coverPath : " + string);
                    if (string == null) {
                        string = "";
                    }
                    appInfo.setCoverPath(string);
                } else {
                    appInfo.setCoverPath(null);
                }
                arrayList.add(appInfo);
                C1120a.m6675d("AppInfoOperator", "getAllGeneralAlbumInfo info: " + appInfo.toString());
            } while (cursorQuery.moveToNext());
            C1122c.m6832t(cursorQuery);
            return arrayList;
        } catch (Throwable th3) {
            M77767d = cursor;
            th = th3;
            C1122c.m6832t(M77767d);
            throw th;
        }
    }
}
