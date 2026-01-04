package com.huawei.android.hicloud.cloudbackup.p076db.operator;

import android.database.Cursor;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Albums;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* loaded from: classes2.dex */
public class AlbumOperator extends AbstractC11478a<Albums> {
    private static final String DELETE_TABLE_ALBUMS = "delete from albums";
    private static final String SQL_DELETE_ALBUM = "delete from albums where tempId = ?;";
    private static final String SQL_QUERY_ALBUM_BY_ALBUMID = "select albumId,tempId,albumName,albumType,displayName,relativePath,switchStatus,outside from albums where albumId=?;";
    private static final String SQL_QUERY_ALL_ALBUMS = "select albumId,tempId,albumName,albumType,displayName,relativePath,switchStatus,outside from albums;";
    private static final String SQL_QUERY_ALL_ALBUM_PATH = "select relativePath from albums";
    private static final String SQL_REPLACE_ALBUM = "replace into albums(albumId,tempId,albumName,albumType,displayName,relativePath,switchStatus,outside) VALUES (?,?,?,?,?,?,?,?); ";
    private static final String SQL_UPDATE_SWITCHSTAT = "update albums set switch = ? where albumId=?";
    private static final String TAG = "AlbumOperator";

    public AlbumOperator() {
        super(C13216j.m79427l(C13216j.c.GALLEY, null));
    }

    public void clear() {
        try {
            execSQL(DELETE_TABLE_ALBUMS);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "clear albums error." + e10.getMessage());
        }
    }

    public void delete(Albums[] albumsArr) throws C9721b {
        if (albumsArr == null || albumsArr.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Albums albums : albumsArr) {
            arrayList.add(new String[]{String.valueOf(albums.getTempId())});
        }
        execute(SQL_DELETE_ALBUM, arrayList);
    }

    public Albums getScreenshotAlbum() throws C9721b {
        List<Albums> listQuery = query(SQL_QUERY_ALBUM_BY_ALBUMID, new String[]{"default-album-2"});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    public List<Albums> queryAllAlbums() throws C9721b {
        return query(SQL_QUERY_ALL_ALBUMS, null);
    }

    public Map<Integer, Albums> queryAllAlbumsWithId() throws C9721b {
        HashMap map = new HashMap();
        List<Albums> listQuery = query(SQL_QUERY_ALL_ALBUMS, null);
        if (!listQuery.isEmpty()) {
            for (Albums albums : listQuery) {
                map.put(Integer.valueOf(albums.getTempId()), albums);
            }
        }
        return map;
    }

    public List<String> queryBackupAlbumsPath() throws C9721b {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = rawQuery(SQL_QUERY_ALL_ALBUM_PATH, null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorRawQuery.getString(0));
                    } while (cursorRawQuery.moveToNext());
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        arrayList.add(0, "/DCIM/Camera");
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
        execute(SQL_REPLACE_ALBUM, arrayList);
    }

    public void update(String str, int i10) throws C9721b {
        execSQL(SQL_UPDATE_SWITCHSTAT, new String[]{i10 + "", str});
    }

    @Override // ml.AbstractC11478a
    public String[] getColumns(Albums albums) {
        return new String[]{albums.getAlbumId(), String.valueOf(albums.getTempId()), albums.getAlbumName(), String.valueOf(albums.getAlbumType()), albums.getDisplayName(), albums.getRelativePath(), String.valueOf(albums.getSwitchStatus()), String.valueOf(albums.getOutside())};
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // ml.AbstractC11478a
    public Albums getObject(Cursor cursor) {
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
}
