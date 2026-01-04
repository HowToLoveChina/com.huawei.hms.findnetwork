package com.huawei.android.hicloud.cloudbackup.p076db.temp;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Albums;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class AlbumsTempOperator {
    private static final String TAG = "AlbumsTempOperator";

    /* renamed from: db */
    private SQLiteDatabase f11665db;

    public AlbumsTempOperator() throws C9721b {
        try {
            this.f11665db = AlbumsTempDBManager.getDB();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getDB exception: " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "getDB exception. " + e10.getMessage(), TAG);
        }
    }

    private void dbEndTransaction() throws C9721b {
        try {
            this.f11665db.endTransaction();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "execSQL4Batch db.endTransaction : " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL4Batch db.endTransaction" + e10.getMessage(), "AlbumsTempOperator_execSQL4Batch");
        }
    }

    private void execSQL4Batch(String str, List<String[]> list) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.f11665db;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "sqldb is null.");
            return;
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                SQLiteStatement sQLiteStatementCompileStatement = this.f11665db.compileStatement(str);
                for (String[] strArr : list) {
                    sQLiteStatementCompileStatement.clearBindings();
                    sQLiteStatementCompileStatement.bindAllArgsAsStrings(strArr);
                    sQLiteStatementCompileStatement.execute();
                }
                this.f11665db.setTransactionSuccessful();
                dbEndTransaction();
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "catch exception when execSQL4Batch: " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "execSQL4Batch Exception" + e10.getMessage(), "AlbumsTempOperator_execSQL4Batch");
            }
        } catch (Throwable th2) {
            dbEndTransaction();
            throw th2;
        }
    }

    private List<Albums> queryResult4Vo(String str, String[] strArr) throws Throwable {
        ArrayList arrayList;
        SQLiteDatabase sQLiteDatabase = this.f11665db;
        Cursor cursor = null;
        arrayList = null;
        ArrayList arrayList2 = null;
        cursor = null;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "sqldb is null.");
            return null;
        }
        try {
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr);
                if (cursorRawQuery != null) {
                    try {
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                arrayList = new ArrayList();
                                do {
                                    try {
                                        arrayList.add(getVo(cursorRawQuery));
                                    } catch (Exception unused) {
                                        cursor = cursorRawQuery;
                                        C11839m.m70687e(TAG, "catch exception when queryResult4Vo!");
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        return arrayList;
                                    }
                                } while (cursorRawQuery.moveToNext());
                                arrayList2 = arrayList;
                            }
                        } catch (Exception unused2) {
                            arrayList = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery == null) {
                    return arrayList2;
                }
                cursorRawQuery.close();
                return arrayList2;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused3) {
            arrayList = null;
        }
    }

    public void clear() throws C9721b, SQLException {
        SQLiteDatabase sQLiteDatabase = this.f11665db;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "clear: db is null");
            return;
        }
        try {
            sQLiteDatabase.execSQL("delete from albums");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "sql exec err when clear!" + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "clear " + e10.getMessage(), "AlbumsTempOperator_clear");
        }
    }

    public void close() throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.f11665db;
        if (sQLiteDatabase == null) {
            C11839m.m70689w(TAG, "close: db is null");
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "close " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "close " + e10.getMessage(), "AlbumsTempOperator_close");
        }
    }

    public Map<String, Integer> getPathAndOutSide() throws Throwable {
        HashMap map = new HashMap();
        List<Albums> listQueryAllAlbums = queryAllAlbums();
        if (!listQueryAllAlbums.isEmpty()) {
            for (Albums albums : listQueryAllAlbums) {
                map.put(albums.getRelativePath(), Integer.valueOf(albums.getOutside()));
            }
        }
        return map;
    }

    public Albums getVo(Cursor cursor) {
        Albums albums = new Albums();
        albums.setAlbumId(cursor.getString(0));
        albums.setTempId(cursor.getInt(1));
        albums.setAlbumName(cursor.getString(2));
        albums.setAlbumType(cursor.getInt(3));
        albums.setDisplayName(cursor.getString(4));
        albums.setRelativePath(cursor.getString(5));
        albums.setSwitchStatus(cursor.getInt(6));
        albums.setOutside(cursor.getInt(7));
        return albums;
    }

    public List<Albums> queryAllAlbums() throws Throwable {
        ArrayList arrayList = new ArrayList();
        List<Albums> listQueryResult4Vo = queryResult4Vo("select albumId,tempId,albumName,albumType,displayName,relativePath,switchStatus,outside from albums;", null);
        if (listQueryResult4Vo != null && !listQueryResult4Vo.isEmpty()) {
            arrayList.addAll(listQueryResult4Vo);
        }
        return arrayList;
    }

    public void replace(Albums[] albumsArr) throws C9721b {
        if (albumsArr == null || albumsArr.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Albums albums : albumsArr) {
            arrayList.add(new String[]{albums.getAlbumId(), String.valueOf(albums.getTempId()), albums.getAlbumName(), String.valueOf(albums.getAlbumType()), albums.getDisplayName(), albums.getRelativePath(), String.valueOf(albums.getSwitchStatus()), String.valueOf(albums.getOutside())});
        }
        execSQL4Batch("replace into albums(albumId,tempId,albumName,albumType,displayName,relativePath,switchStatus,outside) VALUES (?,?,?,?,?,?,?,?); ", arrayList);
    }
}
