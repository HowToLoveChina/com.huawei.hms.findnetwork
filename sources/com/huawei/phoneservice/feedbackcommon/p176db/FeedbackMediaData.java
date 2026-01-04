package com.huawei.phoneservice.feedbackcommon.p176db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Keep;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.feedbackcommon.entity.MediaEntity;
import java.util.ArrayList;
import java.util.List;
import p408jw.C10951q;
import p692uw.C13264g;
import p692uw.C13267j;

@Keep
/* loaded from: classes5.dex */
public final class FeedbackMediaData extends SQLiteOpenHelper {
    private static final String ATTACH = "attach";
    private static final String CACHE = "cache";
    private static final String CREATE_TIME = "createTime";
    public static final Companion Companion = new Companion(null);
    private static final String DB_NAME = "db_media_data";
    private static final int DB_VERSION = 4;
    private static final String DURATION = "duration";
    private static final String PATH = "path";
    private static final String TAB_CREATE = "create table if not exists table_media_entity(_id INTEGER primary key autoincrement,attach String ,cache String ,createTime long ,duration long ,path String ,uri String ,type String ,updateTime long ,url String);";
    private static final String TAB_ROM = "table_media_entity";
    private static final String TAG = "FeedbackMediaData";
    private static final String TYPE = "type";
    private static final String UPDATE_TIME = "updateTime";
    private static final String URI = "uri";
    private static final String URL = "url";

    /* renamed from: db */
    private static SQLiteDatabase f40031db;
    private static FeedbackMediaData mInstance;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(C13264g c13264g) {
            this();
        }

        @Keep
        public final FeedbackMediaData getInstance(Context context) {
            C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
            if (FeedbackMediaData.mInstance == null) {
                synchronized (FeedbackMediaData.class) {
                    try {
                        if (FeedbackMediaData.mInstance == null) {
                            Context applicationContext = context.getApplicationContext();
                            C13267j.m79676d(applicationContext, "context.applicationContext");
                            FeedbackMediaData.mInstance = new FeedbackMediaData(applicationContext);
                        }
                        C10951q c10951q = C10951q.f51861a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return FeedbackMediaData.mInstance;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackMediaData(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 4);
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        synchronized (FeedbackMediaData.class) {
            try {
                if (f40031db == null) {
                    f40031db = getWritableDatabase();
                }
                C10951q c10951q = C10951q.f51861a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final List<MediaEntity> getAllMedias() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = f40031db;
        Cursor cursorQuery = sQLiteDatabase != null ? sQLiteDatabase.query(TAB_ROM, null, null, null, null, null, null) : null;
        while (true) {
            Boolean boolValueOf = cursorQuery != null ? Boolean.valueOf(cursorQuery.moveToNext()) : null;
            C13267j.m79674b(boolValueOf);
            if (!boolValueOf.booleanValue()) {
                cursorQuery.close();
                return arrayList;
            }
            arrayList.add(getMediaEntity(cursorQuery));
        }
    }

    private final MediaEntity getCursor(String str, String str2) {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabase = f40031db;
        if (sQLiteDatabase != null) {
            cursorQuery = sQLiteDatabase.query(TAB_ROM, null, str + "= ?", new String[]{str2}, null, null, null);
        } else {
            cursorQuery = null;
        }
        Boolean boolValueOf = cursorQuery != null ? Boolean.valueOf(cursorQuery.moveToFirst()) : null;
        C13267j.m79674b(boolValueOf);
        if (boolValueOf.booleanValue()) {
            return getMediaEntity(cursorQuery);
        }
        cursorQuery.close();
        return null;
    }

    @Keep
    public static final FeedbackMediaData getInstance(Context context) {
        return Companion.getInstance(context);
    }

    private final MediaEntity getMediaEntity(Cursor cursor) {
        MediaEntity mediaEntity = new MediaEntity();
        mediaEntity.attach = cursor.getString(cursor.getColumnIndex(ATTACH));
        mediaEntity.cache = cursor.getString(cursor.getColumnIndex(CACHE));
        mediaEntity.createTime = Long.valueOf(cursor.getLong(cursor.getColumnIndex("createTime")));
        mediaEntity.duration = Long.valueOf(cursor.getLong(cursor.getColumnIndex("duration")));
        mediaEntity.path = cursor.getString(cursor.getColumnIndex(PATH));
        mediaEntity.strUri = cursor.getString(cursor.getColumnIndex("uri"));
        mediaEntity.type = cursor.getString(cursor.getColumnIndex("type"));
        mediaEntity.updateTime = Long.valueOf(cursor.getLong(cursor.getColumnIndex("updateTime")));
        mediaEntity.url = cursor.getString(cursor.getColumnIndex("url"));
        return mediaEntity;
    }

    private final void updateValues(ContentValues contentValues, String str, String str2) {
        String[] strArr = {str2};
        SQLiteDatabase sQLiteDatabase = f40031db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.update(TAB_ROM, contentValues, str + "=?", strArr);
        }
    }

    @Keep
    public final MediaEntity getMediaEntityByAttach(String str) {
        C13267j.m79677e(str, ATTACH);
        return getCursor(ATTACH, str);
    }

    @Keep
    public final MediaEntity getMediaEntityByPath(String str) {
        SQLiteDatabase sQLiteDatabase = f40031db;
        Cursor cursorQuery = sQLiteDatabase != null ? sQLiteDatabase.query(TAB_ROM, null, "path= ?", new String[]{str}, null, null, "updateTime desc") : null;
        Boolean boolValueOf = cursorQuery != null ? Boolean.valueOf(cursorQuery.moveToFirst()) : null;
        C13267j.m79674b(boolValueOf);
        if (boolValueOf.booleanValue()) {
            return getMediaEntity(cursorQuery);
        }
        cursorQuery.close();
        return null;
    }

    @Keep
    public final MediaEntity getMediaEntityByUrl(String str) {
        C13267j.m79677e(str, "url");
        return getCursor("url", str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C13267j.m79677e(sQLiteDatabase, "db");
        sQLiteDatabase.execSQL(TAB_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws Throwable {
        try {
            if (i10 != 1 && i10 != 2) {
                if (i10 == 3 && sQLiteDatabase != null) {
                    sQLiteDatabase.execSQL(TAB_CREATE);
                    return;
                }
                return;
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.execSQL("ALTER TABLE \"table_media_entity\" ADD COLUMN \"uri\" String");
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.execSQL(TAB_CREATE);
            }
        } catch (SQLException e10) {
            FaqLogger.print(TAG, e10.getMessage());
        }
    }

    @Keep
    public final void saveMediaEntity(MediaEntity mediaEntity) {
        C13267j.m79677e(mediaEntity, "data");
        ContentValues contentValues = new ContentValues();
        contentValues.put(ATTACH, mediaEntity.attach);
        contentValues.put(CACHE, mediaEntity.cache);
        contentValues.put("createTime", mediaEntity.createTime);
        contentValues.put("duration", mediaEntity.duration);
        contentValues.put(PATH, mediaEntity.path);
        contentValues.put("uri", mediaEntity.strUri);
        contentValues.put("type", mediaEntity.type);
        contentValues.put("updateTime", mediaEntity.updateTime);
        contentValues.put("url", mediaEntity.url);
        SQLiteDatabase sQLiteDatabase = f40031db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.insert(TAB_ROM, null, contentValues);
        }
    }

    @Keep
    public final void updateAttachByCache(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ATTACH, str2);
        updateValues(contentValues, CACHE, str);
    }

    @Keep
    public final void updateAttachByPath(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ATTACH, str2);
        updateValues(contentValues, PATH, str);
    }

    @Keep
    public final void updateCacheByAttach(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CACHE, str2);
        updateValues(contentValues, ATTACH, str);
    }

    @Keep
    public final void updateCacheByPath(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CACHE, str2);
        updateValues(contentValues, PATH, str);
    }

    @Keep
    public final void updateDurationByAttach(String str, Long l10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("duration", l10);
        updateValues(contentValues, ATTACH, str);
    }
}
