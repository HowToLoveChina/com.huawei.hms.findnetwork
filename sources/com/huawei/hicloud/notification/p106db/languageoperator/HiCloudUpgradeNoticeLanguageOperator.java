package com.huawei.hicloud.notification.p106db.languageoperator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.script.HiCloudUpgradeNoticeLanguageScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class HiCloudUpgradeNoticeLanguageOperator extends AbstractC0315c<CommonLanguageDbString> {
    private static final String TAG = "HiCloudUpgradeNoticeLanguageOperator";

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
        execSQL4Batch(HiCloudUpgradeNoticeLanguageScript.INSERT_STRING, arrayList2);
        NotifyLogger.m29913d(TAG, "batchInsert success.");
    }

    public void clear() throws SQLException {
        NotifyLogger.m29915i(TAG, "clear notice language db");
        try {
            execSQL(HiCloudUpgradeNoticeLanguageScript.CLEAR);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear fail: " + e10.getMessage());
        }
    }

    public boolean hasRecord() {
        try {
            return queryCount(HiCloudUpgradeNoticeLanguageScript.GET_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }

    public List<CommonLanguageDbString> queryAllString(String str, String str2, String str3) {
        NotifyLogger.m29913d(TAG, "queryAllString");
        try {
            return queryResult4Vo(HiCloudUpgradeNoticeLanguageScript.SQL_QUERY_ALL_STRING_VALUE, new String[]{str, str2 + '%', str3});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "queryAllString exception: " + e10.toString());
            return null;
        }
    }

    public String queryContent(String str, String str2) throws Throwable {
        List<CommonLanguageDbString> listQueryResult4Vo;
        CommonLanguageDbString commonLanguageDbString;
        NotifyLogger.m29913d(TAG, "queryContent by language and textName");
        try {
            listQueryResult4Vo = queryResult4Vo(HiCloudUpgradeNoticeLanguageScript.QUERY_VALUE, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "queryContent error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0 || (commonLanguageDbString = listQueryResult4Vo.get(0)) == null) {
            return null;
        }
        return commonLanguageDbString.getValue();
    }

    public List<CommonLanguageDbString> queryString(String str, String str2, String str3, String str4) {
        NotifyLogger.m29913d(TAG, "queryString");
        try {
            return queryResult4Vo(HiCloudUpgradeNoticeLanguageScript.SQL_QUERY_STRING_VALUE, new String[]{str, str2 + '%', str3, str4});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "queryString exception: " + e10.toString());
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

    public void clear(String str) throws SQLException {
        NotifyLogger.m29915i(TAG, "clear notice language db");
        try {
            execSQL(HiCloudUpgradeNoticeLanguageScript.CLEAR_BY_INSTANCE_ID, new String[]{'%' + str + "/%"});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear fail: " + e10.getMessage());
        }
    }
}
