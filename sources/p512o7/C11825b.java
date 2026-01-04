package p512o7;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p031b7.C1120a;
import p604r7.C12470c;

/* renamed from: o7.b */
/* loaded from: classes2.dex */
public class C11825b extends SQLiteOpenHelper {

    /* renamed from: a */
    public static C11825b f54732a;

    public C11825b(Context context) {
        super(context, "album_client.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    /* renamed from: c */
    public static synchronized C11825b m70446c(Context context) {
        try {
            if (f54732a == null) {
                f54732a = new C11825b(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f54732a;
    }

    /* renamed from: b */
    public void m70447b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C1120a.m6677i("AlbumClientDatabaseHelper", "AlbumClientDatabaseHelper clear.");
        if (sQLiteDatabase == null) {
            C1120a.m6678w("AlbumClientDatabaseHelper", "db is null.");
            return;
        }
        try {
            sQLiteDatabase.execSQL("delete from t_album");
            sQLiteDatabase.execSQL("delete from t_message");
            sQLiteDatabase.execSQL("delete from t_media");
            sQLiteDatabase.execSQL("delete from t_photo_upload");
        } catch (Exception e10) {
            C1120a.m6678w("AlbumClientDatabaseHelper", "exec clear sql Exception：" + e10.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C1120a.m6677i("AlbumClientDatabaseHelper", "AlbumClientDatabaseHelper onCreate.");
        sQLiteDatabase.execSQL("create table if not exists t_album (albumId TEXT PRIMARY KEY NOT NULL, albumName TEXT, albumOwnerId TEXT, albumVersion TEXT, babyInfo TEXT, backgroundImage TEXT, coverImage TEXT, createdTime LONG, editedTime LONG, localPath TEXT, onlyFrdCanBeShared INTEGER, permissions TEXT, privilege INTEGER, properties TEXT, resource TEXT, shareType INTEGER, source TEXT, type INTEGER, opType INTEGER DEFAULT 0, hide INTEGER DEFAULT 0, defaultAlbum INTEGER DEFAULT 0, topAlbum INTEGER DEFAULT 0,nextCursor TEXT,recycled INTEGER, flversion LONG );");
        sQLiteDatabase.execSQL("create index if not exists album_idx_album_id on t_album(albumId)");
        sQLiteDatabase.execSQL("create index if not exists album_idx_op_type on t_album(opType)");
        sQLiteDatabase.execSQL("create index if not exists album_idx_album_type on t_album(type,opType,recycled,hide)");
        sQLiteDatabase.execSQL("create table if not exists t_message (albumId TEXT, applicantId TEXT, createdTime LONG, expirationTime LONG, messageId TEXT, messageType INTEGER, parameters TEXT, receiverId TEXT, receiverName TEXT, senderId TEXT, senderName TEXT, read INTEGER, auditStatus TEXT,albumName TEXT);");
        sQLiteDatabase.execSQL("create table if not exists t_media (localId INTEGER PRIMARY KEY AUTOINCREMENT, albumId TEXT, batchId TEXT, createdTime LONG, editedTime LONG, description TEXT, favorite INTEGER, fileName TEXT, fileType INTEGER, mediaId TEXT, mediaOwnerId TEXT, mediaCreatorId TEXT, pictureMetadata TEXT, videoMetadata TEXT, properties TEXT, recycled INTEGER, recycledTime LONG, scaDetail TEXT, size LONG, source TEXT, opType INTEGER DEFAULT 0, localThumbPath TEXT, localBigThumbPath TEXT, localRealPath TEXT, albumVersion TEXT, albumType INTEGER, hashId TEXT, sha256 TEXT, videoThumbId TEXT,thumbFileId TEXT,lcdFileId TEXT,mediaCreatorName TEXT,batchV1Id LONG, batchV1Time LONG, localBatchId LONG, uploadState INTEGER, hwBurstType INTEGER DEFAULT 0, isCloudExist INTEGER DEFAULT 1, day_mode TEXT,month_mode TEXT,scaRank INTEGER,scaState INTEGER,unique(fileName, hashId, albumId, mediaId));");
        sQLiteDatabase.execSQL("create index if not exists idx_recycled on t_media(recycled)");
        sQLiteDatabase.execSQL("create index if not exists idx_op_type on t_media(opType)");
        sQLiteDatabase.execSQL("create index if not exists idx_media_id on t_media(mediaId)");
        sQLiteDatabase.execSQL("create index if not exists idx_batch_v1_time on t_media(albumId,opType,recycled,batchV1Time)");
        sQLiteDatabase.execSQL("create index if not exists idx_query_count on t_media(hwBurstType,opType,fileType,albumType,recycled,albumId,fileName)");
        sQLiteDatabase.execSQL("create index if not exists idx_query_day_mode on t_media(opType,favorite,fileType,albumType,recycled,albumId,day_mode)");
        sQLiteDatabase.execSQL("create index if not exists idx_query_album_c_time on t_media(createdTime,opType,favorite,fileType,albumType,albumId,recycled)");
        sQLiteDatabase.execSQL("create index if not exists idx_query_album_e_time on t_media(editedTime,opType,albumId,recycled)");
        sQLiteDatabase.execSQL("create index if not exists idx_query_upload_name on t_media(opType,recycled,albumId,fileName,hashId)");
        sQLiteDatabase.execSQL("create table if not exists t_photo_upload (localId INTEGER PRIMARY KEY AUTOINCREMENT, userId TEXT, albumId TEXT, shareId TEXT, fileName TEXT, fileType INTEGER, createTime LONG, hash TEXT, size LONG, lpath TEXT, localThumbPath TEXT, localBigThumbPath TEXT, localRealPath TEXT, uploadState INTEGER, mobileNetUpload INTEGER, createrId TEXT, dataVersion TEXT, expand TEXT, localBatchId LONG, batchId TEXT, batchTime LONG, isRename BOOLEAN);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        C1120a.m6677i("AlbumClientDatabaseHelper", "AlbumClientDatabaseHelper onDowngrade.");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C1120a.m6677i("AlbumClientDatabaseHelper", "AlbumClientDatabaseHelper onUpgrade, " + i10 + ", " + i11);
        if (i10 == 1) {
            C12470c.m74770d().m74771a();
            sQLiteDatabase.execSQL("drop table if exists t_album");
            sQLiteDatabase.execSQL("drop table if exists t_message");
            sQLiteDatabase.execSQL("drop table if exists t_media");
            sQLiteDatabase.execSQL("drop table if exists t_photo_upload");
            sQLiteDatabase.execSQL("create table if not exists t_album (albumId TEXT PRIMARY KEY NOT NULL, albumName TEXT, albumOwnerId TEXT, albumVersion TEXT, babyInfo TEXT, backgroundImage TEXT, coverImage TEXT, createdTime LONG, editedTime LONG, localPath TEXT, onlyFrdCanBeShared INTEGER, permissions TEXT, privilege INTEGER, properties TEXT, resource TEXT, shareType INTEGER, source TEXT, type INTEGER, opType INTEGER DEFAULT 0, hide INTEGER DEFAULT 0, defaultAlbum INTEGER DEFAULT 0, topAlbum INTEGER DEFAULT 0,nextCursor TEXT,recycled INTEGER, flversion LONG );");
            sQLiteDatabase.execSQL("create index if not exists album_idx_album_id on t_album(albumId)");
            sQLiteDatabase.execSQL("create index if not exists album_idx_op_type on t_album(opType)");
            sQLiteDatabase.execSQL("create index if not exists album_idx_album_type on t_album(type,opType,recycled,hide)");
            sQLiteDatabase.execSQL("create table if not exists t_message (albumId TEXT, applicantId TEXT, createdTime LONG, expirationTime LONG, messageId TEXT, messageType INTEGER, parameters TEXT, receiverId TEXT, receiverName TEXT, senderId TEXT, senderName TEXT, read INTEGER, auditStatus TEXT,albumName TEXT);");
            sQLiteDatabase.execSQL("create table if not exists t_media (localId INTEGER PRIMARY KEY AUTOINCREMENT, albumId TEXT, batchId TEXT, createdTime LONG, editedTime LONG, description TEXT, favorite INTEGER, fileName TEXT, fileType INTEGER, mediaId TEXT, mediaOwnerId TEXT, mediaCreatorId TEXT, pictureMetadata TEXT, videoMetadata TEXT, properties TEXT, recycled INTEGER, recycledTime LONG, scaDetail TEXT, size LONG, source TEXT, opType INTEGER DEFAULT 0, localThumbPath TEXT, localBigThumbPath TEXT, localRealPath TEXT, albumVersion TEXT, albumType INTEGER, hashId TEXT, sha256 TEXT, videoThumbId TEXT,thumbFileId TEXT,lcdFileId TEXT,mediaCreatorName TEXT,batchV1Id LONG, batchV1Time LONG, localBatchId LONG, uploadState INTEGER, hwBurstType INTEGER DEFAULT 0, isCloudExist INTEGER DEFAULT 1, day_mode TEXT,month_mode TEXT,scaRank INTEGER,scaState INTEGER,unique(fileName, hashId, albumId, mediaId));");
            sQLiteDatabase.execSQL("create index if not exists idx_recycled on t_media(recycled)");
            sQLiteDatabase.execSQL("create index if not exists idx_op_type on t_media(opType)");
            sQLiteDatabase.execSQL("create index if not exists idx_media_id on t_media(mediaId)");
            sQLiteDatabase.execSQL("create index if not exists idx_batch_v1_time on t_media(albumId,opType,recycled,batchV1Time)");
            sQLiteDatabase.execSQL("create index if not exists idx_query_count on t_media(hwBurstType,opType,fileType,albumType,recycled,albumId,fileName)");
            sQLiteDatabase.execSQL("create index if not exists idx_query_day_mode on t_media(opType,favorite,fileType,albumType,recycled,albumId,day_mode)");
            sQLiteDatabase.execSQL("create index if not exists idx_query_album_c_time on t_media(createdTime,opType,favorite,fileType,albumType,albumId,recycled)");
            sQLiteDatabase.execSQL("create index if not exists idx_query_album_e_time on t_media(editedTime,opType,albumId,recycled)");
            sQLiteDatabase.execSQL("create index if not exists idx_query_upload_name on t_media(opType,recycled,albumId,fileName,hashId)");
            sQLiteDatabase.execSQL("create table if not exists t_photo_upload (localId INTEGER PRIMARY KEY AUTOINCREMENT, userId TEXT, albumId TEXT, shareId TEXT, fileName TEXT, fileType INTEGER, createTime LONG, hash TEXT, size LONG, lpath TEXT, localThumbPath TEXT, localBigThumbPath TEXT, localRealPath TEXT, uploadState INTEGER, mobileNetUpload INTEGER, createrId TEXT, dataVersion TEXT, expand TEXT, localBatchId LONG, batchId TEXT, batchTime LONG, isRename BOOLEAN);");
        }
    }
}
