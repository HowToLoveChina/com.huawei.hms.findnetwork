package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.NDCount;
import com.huawei.hicloud.notification.p106db.script.NotificationScript;
import fk.C9721b;
import java.util.List;
import p015ak.C0241z;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class NDCOperator extends AbstractC0315c<NDCount> {
    private static final String TAG = "NDCOperator";

    private void insertDefaultRules(String str, String str2) throws SQLException {
        try {
            execSQL(NotificationScript.INSERT_RULE, new String[]{str, str2, "0", "0", "0"});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "insert default rules error." + e10.getMessage());
        }
    }

    public void clear() throws SQLException {
        try {
            execSQL(NotificationScript.CLEAR);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear NDC error." + e10.getMessage());
        }
    }

    public long getLastNotifyTime(String str, String str2) throws Throwable {
        List<NDCount> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(NotificationScript.QUERY_RULE_INFO, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "get NDC notify time error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo != null) {
            return listQueryResult4Vo.get(0).getLastTimeStamp();
        }
        insertDefaultRules(str, str2);
        return 0L;
    }

    public int needCheckInit(String str, String str2) throws Throwable {
        List<NDCount> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(NotificationScript.QUERY_RULE_INFO, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "query rules error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo != null) {
            return listQueryResult4Vo.get(0).getCheckInit();
        }
        insertDefaultRules(str, str2);
        return 0;
    }

    public void updateCheckInit(int i10, String str, String str2) throws SQLException {
        NotifyLogger.m29915i(TAG, "updateCheckInit");
        try {
            execSQL(NotificationScript.UPDATE_CHECK_INIT, new String[]{String.valueOf(i10), str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "update check init error." + e10.getMessage());
        }
    }

    public void updateCount(String str, String str2) throws SQLException {
        try {
            execSQL(NotificationScript.UPDATE_COUNT, new String[]{String.valueOf(System.currentTimeMillis()), str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "update count error." + e10.getMessage());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public NDCount getVo(Cursor cursor) {
        NDCount nDCount = new NDCount();
        nDCount.setNdCount(cursor.getInt(0));
        nDCount.setCheckInit(cursor.getInt(1));
        nDCount.setLastTimeStamp(C0241z.m1688f(cursor.getString(2)));
        return nDCount;
    }
}
