package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.bean.AppHistoryBean;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.script.AppHistoryScript;
import fk.C9721b;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;
import p815ym.AbstractC14026a;

/* loaded from: classes6.dex */
public class AppHistoryOperator extends AbstractC0315c<AppHistoryBean> {
    private static final long MAX_COUNT = 10000;
    private static final String TAG = "AppHistoryOperator";

    private Object[] getBatchInsertArgs(AppHistoryBean appHistoryBean) {
        return new Object[]{appHistoryBean.getAppId(), Integer.valueOf(appHistoryBean.getStatus()), Long.valueOf(appHistoryBean.getTime())};
    }

    public void batchDeleteReport(String str) throws SQLException {
        NotifyLogger.m29915i(TAG, "batchDeleteReport begin");
        try {
            execSQL("delete from history_application_distribute where appId in (" + str + ");");
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "batchUpdate error" + e10);
        }
    }

    public void batchInsert(List<AppHistoryBean> list) throws SQLException {
        if (AbstractC14026a.m84159a(list)) {
            NotifyLogger.m29916w(TAG, "batchInsert listInsert is null or empty!");
            return;
        }
        NotifyLogger.m29915i(TAG, "batchInsert begin");
        long historyCount = getHistoryCount();
        if (list.size() + historyCount > 10000) {
            try {
                execSQL("DELETE FROM history_application_distribute WHERE appId IN (SELECT appId FROM history_application_distribute ORDER BY time ASC LIMIT " + ((historyCount + list.size()) - 10000) + ");");
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "batchInsert DELETE_OLDEST failed :" + e10);
                return;
            }
        }
        Iterator<AppHistoryBean> it = list.iterator();
        while (it.hasNext()) {
            try {
                execSQL(AppHistoryScript.SQL_INSERT, getBatchInsertArgs(it.next()));
            } catch (C9721b e11) {
                NotifyLogger.m29914e(TAG, "batchInsert failed :" + e11);
            }
        }
        NotifyLogger.m29915i(TAG, "batchInsert end");
    }

    public void clear() {
        NotifyLogger.m29915i(TAG, "clear ");
        try {
            execSQL(AppHistoryScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10);
        }
    }

    public List<AppHistoryBean> getHistoryByPage(int i10, int i11) throws Throwable {
        NotifyLogger.m29915i(TAG, "getHistoryByPage pageSize = " + i10 + " ,start = " + i11);
        try {
            StringBuffer stringBuffer = new StringBuffer(AppHistoryScript.SQL_GET_HISTORY_BY_PAGE_PREFIX);
            stringBuffer.append(" LIMIT " + i10);
            stringBuffer.append(" OFFSET " + i11 + ";");
            String string = stringBuffer.toString();
            NotifyLogger.m29915i(TAG, "getHistoryByPage sql:" + string);
            List<AppHistoryBean> listQueryResult4Vo = queryResult4Vo(string, null);
            if (listQueryResult4Vo != null) {
                return listQueryResult4Vo;
            }
            NotifyLogger.m29916w(TAG, "appHistoryBeans is null, return empty list");
            return Collections.emptyList();
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getHistoryByPage exception:" + e10);
            return Collections.emptyList();
        }
    }

    public long getHistoryCount() {
        NotifyLogger.m29915i(TAG, "getHistoryCount");
        try {
            return queryCount(AppHistoryScript.SQL_GET_HISTORY_COUNT);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getHistoryCount exception:" + e10);
            return 0L;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public AppHistoryBean getVo(Cursor cursor) {
        AppHistoryBean appHistoryBean = new AppHistoryBean();
        appHistoryBean.setAppId(cursor.getString(0));
        appHistoryBean.setStatus(cursor.getInt(1));
        appHistoryBean.setTime(cursor.getLong(2));
        return appHistoryBean;
    }
}
