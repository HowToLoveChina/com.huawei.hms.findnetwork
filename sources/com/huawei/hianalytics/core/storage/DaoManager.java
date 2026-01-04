package com.huawei.hianalytics.core.storage;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.hianalytics.core.C4736b;
import com.huawei.hianalytics.core.C4737c;
import com.huawei.hianalytics.core.C4738d;
import com.huawei.hianalytics.core.C4739e;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class DaoManager {
    public static final String TAG = "DaoManager";
    public C4737c eventDao;
    public C4736b headerDao;
    public boolean initialized;
    public C4738d mcInfoDao;
    public C4739e mcTagDao;

    /* renamed from: com.huawei.hianalytics.core.storage.DaoManager$b */
    public static class C4743b {

        /* renamed from: a */
        public static final DaoManager f21691a = new DaoManager();
    }

    public DaoManager() {
    }

    public static DaoManager getInstance() {
        return C4743b.f21691a;
    }

    public boolean checkAndClearTable() throws SQLException {
        if (this.mcTagDao.mo28789b() > 500) {
            this.mcTagDao.m28791c();
        }
        if (this.mcInfoDao.mo28789b() < 500) {
            return false;
        }
        this.mcInfoDao.m28791c();
        return true;
    }

    public long countBySubCount(String str, String str2, String str3) {
        long j10 = 0;
        if (!this.initialized) {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
            return 0L;
        }
        C4737c c4737c = this.eventDao;
        if (!c4737c.m28787a()) {
            try {
                Cursor cursorRawQuery = c4737c.f21667b.rawQuery(C4737c.f21672g, new String[]{str, str2, str3, ""});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j11 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        j10 = j11;
                    } else {
                        HiLog.m28808e("EventDao", "cursor is empty");
                        cursorRawQuery.close();
                    }
                } finally {
                }
            } catch (Exception unused) {
                HiLog.m28808e("EventDao", "query sub count error");
            }
        }
        return j10;
    }

    public long countEvents() {
        if (this.initialized) {
            return this.eventDao.mo28789b();
        }
        HiLog.m28812w(TAG, "DaoManager not initialized, return");
        return 0L;
    }

    public void createEventTable(SQLiteDatabase sQLiteDatabase) {
        DBUtil.exec(sQLiteDatabase, C4737c.f21671f);
    }

    public void createHeaderTable(SQLiteDatabase sQLiteDatabase) throws SQLException {
        DBUtil.exec(sQLiteDatabase, C4736b.f21670e);
        HiLog.m28809i("CommonHeaderExDao", "createTable");
    }

    public void createMcInfoTable(SQLiteDatabase sQLiteDatabase) throws SQLException {
        DBUtil.exec(sQLiteDatabase, C4738d.f21677h);
        HiLog.m28809i("MetricMcInfoDao", "createTable");
    }

    public void createMcTagTable(SQLiteDatabase sQLiteDatabase) throws SQLException {
        DBUtil.exec(sQLiteDatabase, C4739e.f21684k);
        HiLog.m28809i("MetricMcTagDao", "createTable");
    }

    public void deleteAllEvents() {
        if (this.initialized) {
            this.eventDao.m28791c();
        } else {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
        }
    }

    public void deleteAllHeaders() {
        if (this.initialized) {
            this.headerDao.m28791c();
        } else {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
        }
    }

    public void deleteAllInfo() {
        if (this.initialized) {
            this.mcInfoDao.m28791c();
        } else {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
        }
    }

    public void deleteEvents(String str, String str2) {
        String str3;
        if (!this.initialized) {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
            return;
        }
        C4737c c4737c = this.eventDao;
        c4737c.getClass();
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            str3 = null;
        } else {
            arrayList.add(str);
            str3 = Event.COLUMN_SERVICE_TAG.columnName + "=?";
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            str3 = str3 + " AND " + Event.COLUMN_EVT_TYPE.columnName + "=?";
        }
        if (str3 == null) {
            return;
        }
        c4737c.m28788b(str3, (String[]) arrayList.toArray(new String[0]));
    }

    public int deleteMcInfo(List<String> list) {
        C4738d c4738d = this.mcInfoDao;
        c4738d.getClass();
        if (list == null || list.isEmpty()) {
            return -1;
        }
        StringBuilder sb2 = new StringBuilder();
        String[] strArr = new String[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10] = list.get(i10);
            sb2.append(Constants.QUESTION_STR);
            if (i10 != list.size() - 1) {
                sb2.append(",");
            }
        }
        return c4738d.m28788b(C4738d.f21674e.columnName + " in( " + ((Object) sb2) + " )", strArr);
    }

    public int deleteMcTag(List<String> list) {
        C4739e c4739e = this.mcTagDao;
        c4739e.getClass();
        return c4739e.m28796a(list, C4739e.f21678e.columnName);
    }

    public void dropAllTable(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C4737c.m28793a(sQLiteDatabase);
        C4736b.m28792a(sQLiteDatabase);
        C4739e.m28795a(sQLiteDatabase);
        C4738d.m28794a(sQLiteDatabase);
        HiLog.m28809i(TAG, "dropAllTable");
    }

    public void init(SQLiteDatabase sQLiteDatabase) {
        this.eventDao = new C4737c(sQLiteDatabase);
        this.headerDao = new C4736b(sQLiteDatabase);
        this.mcTagDao = new C4739e(sQLiteDatabase);
        this.mcInfoDao = new C4738d(sQLiteDatabase);
        this.initialized = true;
    }

    public long insert(CommonHeaderEx commonHeaderEx) {
        if (!this.initialized) {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
            return 0L;
        }
        C4736b c4736b = this.headerDao;
        c4736b.getClass();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(commonHeaderEx);
        return c4736b.m28783a((List) arrayList, true);
    }

    public void insertEvents(List<Event> list) {
        if (this.initialized) {
            this.eventDao.m28783a((List) list, false);
        } else {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
        }
    }

    public long insertHeaders(List<CommonHeaderEx> list) {
        if (this.initialized) {
            return this.headerDao.m28783a((List) list, true);
        }
        HiLog.m28812w(TAG, "DaoManager not initialized, return");
        return 0L;
    }

    public long insertMcInfo(String str) {
        return insertMcInfoList(Collections.singletonList(str));
    }

    public long insertMcInfoList(List<String> list) {
        return this.mcInfoDao.m28783a((List) list, false);
    }

    public long insertMcTagList(List<String> list) {
        C4739e c4739e = this.mcTagDao;
        c4739e.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(new JSONObject(it.next()).optString(C4739e.f21679f.columnName, ""));
            } catch (JSONException e10) {
                HiLog.m28812w("MetricMcTagDao", e10.getMessage());
            }
        }
        c4739e.m28796a(arrayList, C4739e.f21679f.columnName);
        return c4739e.m28783a((List) list, false);
    }

    public List<String> queryMcInfo() {
        C4738d c4738d = this.mcInfoDao;
        c4738d.getClass();
        String str = C4738d.f21674e.columnName;
        String str2 = C4738d.f21675f.columnName;
        Property property = C4738d.f21676g;
        return c4738d.m28785a(new String[]{str, str2, property.columnName}, null, null, null, null, property.columnName + " DESC", null);
    }

    public List<String> queryMcTag(String str) {
        C4739e c4739e = this.mcTagDao;
        c4739e.getClass();
        String str2 = C4739e.f21678e.columnName;
        String str3 = C4739e.f21679f.columnName;
        String str4 = C4739e.f21680g.columnName;
        String str5 = C4739e.f21681h.columnName;
        Property property = C4739e.f21682i;
        return c4739e.m28785a(new String[]{str2, str3, str4, str5, property.columnName, C4739e.f21683j.columnName}, property.columnName + " =?", new String[]{str}, null, null, null, "1000");
    }

    public List<Event> readEvents(String str, String str2, String str3, long j10) {
        String[] strArr;
        if (!this.initialized) {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
            return new ArrayList();
        }
        C4737c c4737c = this.eventDao;
        c4737c.getClass();
        String str4 = Event.COLUMN_ID.columnName;
        String str5 = Event.COLUMN_IS_ENCRYPTED.columnName;
        String str6 = Event.COLUMN_SESSION_ID.columnName;
        String str7 = Event.COLUMN_CONTENT.columnName;
        String str8 = Event.COLUMN_EVT_ID.columnName;
        Property property = Event.COLUMN_PROCESS_NAME;
        String str9 = property.columnName;
        String str10 = Event.COLUMN_EVT_EX_HASH_CODE.columnName;
        String str11 = Event.COLUMN_SESSION_NAME.columnName;
        Property property2 = Event.COLUMN_SERVICE_TAG;
        String str12 = property2.columnName;
        Property property3 = Event.COLUMN_EVT_TIME;
        String str13 = property3.columnName;
        Property property4 = Event.COLUMN_EVT_TYPE;
        String[] strArr2 = {str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, property4.columnName, Event.COLUMN_SUB_COUNT.columnName};
        String str14 = "";
        if (j10 > 0) {
            str14 = property3.columnName + "<? AND ";
            strArr = new String[]{String.valueOf(j10), str, str2, str3, ""};
        } else {
            strArr = new String[]{str, str2, str3, ""};
        }
        return c4737c.m28785a(strArr2, str14 + property2.columnName + "=? AND " + property4.columnName + "=? AND (" + property.columnName + "=? or " + property.columnName + "=?)", strArr, null, null, null, "1000");
    }

    public CommonHeaderEx readHeader(String str) {
        if (!this.initialized) {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
            return new CommonHeaderEx();
        }
        C4736b c4736b = this.headerDao;
        c4736b.getClass();
        Property property = CommonHeaderEx.COLUMN_HASHCODE;
        ArrayList arrayList = (ArrayList) c4736b.m28785a(new String[]{property.columnName, CommonHeaderEx.COLUMN_HEADER.columnName}, property.columnName + " =?", new String[]{str}, null, null, null, "1000");
        return !arrayList.isEmpty() ? (CommonHeaderEx) arrayList.get(0) : new CommonHeaderEx();
    }

    public void deleteEvents(List<Event> list) {
        if (!this.initialized) {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
            return;
        }
        C4737c c4737c = this.eventDao;
        c4737c.getClass();
        String[] strArr = new String[list.size()];
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10] = String.valueOf(list.get(i10).getId());
            sb2.append(Constants.QUESTION_STR);
            if (i10 != list.size() - 1) {
                sb2.append(", ");
            }
        }
        c4737c.m28788b(Event.COLUMN_ID.columnName + " in( " + ((Object) sb2) + " )", strArr);
    }

    public long insert(Event event) {
        if (!this.initialized) {
            HiLog.m28812w(TAG, "DaoManager not initialized, return");
            return 0L;
        }
        C4737c c4737c = this.eventDao;
        c4737c.getClass();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(event);
        return c4737c.m28783a((List) arrayList, false);
    }
}
