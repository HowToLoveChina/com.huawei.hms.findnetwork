package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.script.H5LanguageConfigScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class H5LanguageConfigOperator extends AbstractC0315c<CommonLanguageDbString> {
    private static final String TAG = "H5LanguageConfigOperator";

    private String[] getBatchInsertArgs(CommonLanguageDbString commonLanguageDbString) {
        return new String[]{commonLanguageDbString.getLanguage(), commonLanguageDbString.getName(), commonLanguageDbString.getValue()};
    }

    public void batchInsert(ArrayList<CommonLanguageDbString> arrayList) throws C9721b {
        NotifyLogger.m29913d(TAG, "batchInsert begin size = " + arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        Iterator<CommonLanguageDbString> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getBatchInsertArgs(it.next()));
        }
        execSQL4Batch(H5LanguageConfigScript.INSETT_H5_LANGUAGE_CONFIG_CONTENT, arrayList2);
        NotifyLogger.m29913d(TAG, "batchInsert success.");
    }

    public void clear() throws SQLException {
        try {
            execSQL(H5LanguageConfigScript.CLEAR_H5_LANGUAGE_CONFIG_CONTENT);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear spacenotify error." + e10.getMessage());
        }
    }

    public boolean hasRecord() {
        try {
            return queryCount(H5LanguageConfigScript.GET_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }

    public void insertContent(List<String[]> list) {
        try {
            execSQL4Batch(H5LanguageConfigScript.INSETT_H5_LANGUAGE_CONFIG_CONTENT, list);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "insert default rules error." + e10.getMessage());
        }
    }

    public CommonLanguageDbString queryH5Config(String str, String str2) throws Throwable {
        List<CommonLanguageDbString> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(H5LanguageConfigScript.QUERY_H5_LANGUAGE_CONFIG_CONTENT, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "query rules error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0);
    }

    public List<CommonLanguageDbString> queryString(String str, String str2, String str3, String str4) {
        NotifyLogger.m29913d(TAG, "queryString");
        try {
            return queryResult4Vo(H5LanguageConfigScript.SQL_QUERY_STRING_VALUE, new String[]{str, str2 + '%', str3, str4});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, e10.toString());
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public CommonLanguageDbString getVo(Cursor cursor) {
        CommonLanguageDbString commonLanguageDbString = new CommonLanguageDbString();
        commonLanguageDbString.setLanguage(cursor.getString(0));
        commonLanguageDbString.setName(cursor.getString(1));
        commonLanguageDbString.setValue(cursor.getString(2));
        return commonLanguageDbString;
    }
}
