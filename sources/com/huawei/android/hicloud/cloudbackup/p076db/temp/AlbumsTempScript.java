package com.huawei.android.hicloud.cloudbackup.p076db.temp;

/* loaded from: classes2.dex */
public class AlbumsTempScript {
    static final int CUR_VERSION = 1;
    public static final String DATABASE_NAME = "gallery.db";
    static final String SQL_CLEAR_ALBUM = "delete from albums";
    static final String SQL_QUERY_ALL_ALBUM = "select albumId,tempId,albumName,albumType,displayName,relativePath,switchStatus,outside from albums;";
    static final String SQL_REPLACE_ALBUM = "replace into albums(albumId,tempId,albumName,albumType,displayName,relativePath,switchStatus,outside) VALUES (?,?,?,?,?,?,?,?); ";
}
