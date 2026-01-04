package com.huawei.hicloud.notification.spacelanguage.operator;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.spacelanguage.bean.SpaceMultLanguageString;
import com.huawei.hicloud.notification.spacelanguage.script.SpaceMultLanguageDBScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class SpaceMultLanguageOperator extends AbstractC0315c<SpaceMultLanguageString> {
    private static final String TAG = "SpaceMultLanguageOperator";

    private String[] getBatchInsertArgs(SpaceMultLanguageString spaceMultLanguageString) {
        return new String[]{spaceMultLanguageString.getLanguage(), spaceMultLanguageString.getName(), spaceMultLanguageString.getValue()};
    }

    public void batchInsert(ArrayList<SpaceMultLanguageString> arrayList) {
        try {
            ArrayList arrayList2 = new ArrayList();
            Iterator<SpaceMultLanguageString> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(getBatchInsertArgs(it.next()));
            }
            execSQL4Batch(SpaceMultLanguageDBScript.INSERT_SPACE_MULT_LANGUAGE, arrayList2);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "batchInsert error." + e10.getMessage());
        }
    }

    public void clearDB() throws SQLException {
        NotifyLogger.m29915i(TAG, "clearDB");
        try {
            execSQL(SpaceMultLanguageDBScript.CLEAR_INSERT_SPACE_MULT_LANGUAGE);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clearDB error." + e10.getMessage());
        }
    }

    public int getDataCount() {
        SQLiteDatabase db2 = getDb();
        if (db2 == null) {
            NotifyLogger.m29914e(TAG, "getDataCount sqLiteDatabase is null.");
            return -1;
        }
        try {
            Cursor cursorRawQuery = db2.rawQuery(SpaceMultLanguageDBScript.COUNT_OF_DATA, null);
            if (cursorRawQuery != null) {
                return cursorRawQuery.getCount();
            }
            NotifyLogger.m29914e(TAG, "getDataCount cursor is null.");
            return -1;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getDataCount err:" + e10.toString());
            return -1;
        }
    }

    public boolean hasRecord() {
        try {
            return queryCount(SpaceMultLanguageDBScript.GET_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }

    public SpaceMultLanguageString queryLanguageValue(String str, String str2) throws Throwable {
        List<SpaceMultLanguageString> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(SpaceMultLanguageDBScript.QUERY_VALUE, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryLanguageValue error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo != null && listQueryResult4Vo.size() > 0) {
            return listQueryResult4Vo.get(0);
        }
        NotifyLogger.m29916w(TAG, "queryLanguageValue result is null. countryLanguage :" + str);
        return null;
    }

    public SpaceMultLanguageString queryLanguageValueByLanguage(String str, String str2) throws Throwable {
        List<SpaceMultLanguageString> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(SpaceMultLanguageDBScript.QUERY_VALUE_BY_LANGUAGE, new String[]{str + "%", str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryLanguageValueByLanguage error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo != null && listQueryResult4Vo.size() > 0) {
            return listQueryResult4Vo.get(0);
        }
        NotifyLogger.m29916w(TAG, "queryLanguageValueByLanguage result is null.");
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public SpaceMultLanguageString getVo(Cursor cursor) {
        SpaceMultLanguageString spaceMultLanguageString = new SpaceMultLanguageString();
        spaceMultLanguageString.setValue(cursor.getString(0));
        return spaceMultLanguageString;
    }
}
