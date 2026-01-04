package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.UpgradeConfigString;
import com.huawei.hicloud.notification.p106db.script.UpgradeConfigLanguageScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class UpgradeConfigLanguageOperator extends AbstractC0315c<UpgradeConfigString> {
    private static final String TAG = "UpgradeConfigLanguageOperator";

    private String[] getBatchInsertArgs(UpgradeConfigString upgradeConfigString) {
        return new String[]{upgradeConfigString.getCountry(), upgradeConfigString.getName(), upgradeConfigString.getValue()};
    }

    public void batchInsert(ArrayList<UpgradeConfigString> arrayList) throws C9721b {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList2 = new ArrayList();
        Iterator<UpgradeConfigString> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getBatchInsertArgs(it.next()));
        }
        execSQL4Batch(UpgradeConfigLanguageScript.INSERT_STRING, arrayList2);
    }

    public void clear() throws SQLException {
        NotifyLogger.m29913d(TAG, "clear");
        try {
            execSQL(UpgradeConfigLanguageScript.CLEAR);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear fail: " + e10.getMessage());
        }
    }

    public boolean hasRecord() {
        NotifyLogger.m29913d(TAG, "hasRecord");
        try {
            return queryCount(UpgradeConfigLanguageScript.QUERY_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, e10.toString());
            return false;
        }
    }

    public String queryContent(String str, String str2) throws Throwable {
        List<UpgradeConfigString> listQueryResult4Vo;
        NotifyLogger.m29913d(TAG, "queryContent by language and textName");
        try {
            listQueryResult4Vo = queryResult4Vo(UpgradeConfigLanguageScript.QUERY_VALUE, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "queryContent error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0).getValue();
    }

    public List<UpgradeConfigString> queryString(String str, String str2, String str3, String str4) {
        NotifyLogger.m29913d(TAG, "queryString");
        try {
            return queryResult4Vo(UpgradeConfigLanguageScript.SQL_QUERY_STRING_VALUE, new String[]{str, str2 + '%', str3, str4});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, e10.toString());
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public UpgradeConfigString getVo(Cursor cursor) {
        UpgradeConfigString upgradeConfigString = new UpgradeConfigString();
        upgradeConfigString.setCountry(cursor.getString(0));
        upgradeConfigString.setName(cursor.getString(1));
        upgradeConfigString.setValue(cursor.getString(2));
        return upgradeConfigString;
    }
}
