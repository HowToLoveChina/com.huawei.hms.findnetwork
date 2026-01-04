package com.huawei.hicloud.messagecenter.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.messagecenter.bean.H5WindowMsgObj;
import com.huawei.hicloud.messagecenter.script.MessageH5DbScript;
import com.huawei.hicloud.notification.log.NotifyLogger;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class MessageH5DbOperator extends AbstractC0315c<H5WindowMsgObj> {
    private static final String TAG = "MessageH5DbOperator";

    private void batchInsert(H5WindowMsgObj h5WindowMsgObj) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        execSQL(MessageH5DbScript.SQL_INSERT, getBatchInsertArgs(h5WindowMsgObj));
    }

    private void deleteLastMsg(int i10) throws Exception {
        if (i10 == 5) {
            execSQL(MessageH5DbScript.DELETE_CAMPAIGN_TASK_MSG);
        } else if (i10 == 6) {
            execSQL(MessageH5DbScript.DELETE_CAMPAIGN_TASK_TYPE_SIX_MSG);
        } else if (i10 == 11) {
            execSQL(MessageH5DbScript.DELETE_CAMPAIGN_REMINDER_BEFORE_EXPIRATION);
        }
    }

    private Object[] getBatchInsertArgs(H5WindowMsgObj h5WindowMsgObj) {
        return new Object[]{h5WindowMsgObj.getUniqueId(), h5WindowMsgObj.getMsgGotoType(), h5WindowMsgObj.getMsgGotoUri(), Integer.valueOf(h5WindowMsgObj.getH5DialogAction()), h5WindowMsgObj.getH5DialogUrl(), Long.valueOf(h5WindowMsgObj.getReadValidityTime()), Long.valueOf(h5WindowMsgObj.getRemainValidityTime()), Long.valueOf(h5WindowMsgObj.getNotifyTime()), Integer.valueOf(h5WindowMsgObj.getAlreadyRead()), h5WindowMsgObj.getResourceInfo(), h5WindowMsgObj.getAgdParameters(), Integer.valueOf(h5WindowMsgObj.getPriority()), h5WindowMsgObj.getParamForString(), h5WindowMsgObj.getRealTimeParamForString(), h5WindowMsgObj.getTrigger(), Integer.valueOf(h5WindowMsgObj.getSupportTrigger())};
    }

    public void batchSetAlreadyRead(List<String> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new String[]{it.next()});
                }
                execSQL4Batch(MessageH5DbScript.UPDATE_ALREADY_READ_BY_ID, arrayList);
            } catch (Exception e10) {
                NotifyLogger.m29914e(TAG, "batchSetAlreadyRead exception. e: " + e10.getMessage());
            }
        }
    }

    public void clear() {
        try {
            execSQL(MessageH5DbScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear exception. e: " + e10.getMessage());
        }
    }

    public void deleteExpiredMsg() throws SQLException {
        try {
            execSQL(MessageH5DbScript.DELETE_EXPIRED_MSG, new Object[]{String.valueOf(System.currentTimeMillis())});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "deleteExpiredMsg exception. e: " + e10.getMessage());
        }
    }

    public void insertH5WindowMsg(H5WindowMsgObj h5WindowMsgObj) throws Exception {
        NotifyLogger.m29915i(TAG, "insertH5WindowMsg");
        if (5 == h5WindowMsgObj.getH5DialogAction() || 6 == h5WindowMsgObj.getH5DialogAction() || 11 == h5WindowMsgObj.getH5DialogAction()) {
            deleteLastMsg(h5WindowMsgObj.getH5DialogAction());
        }
        batchInsert(h5WindowMsgObj);
    }

    public String isMsgAlreadyRead(String str) {
        List<String> arrayList = new ArrayList<>();
        try {
            arrayList = queryStringList(MessageH5DbScript.QUERY_MSG_HAS_ALREADY_READ, new String[]{str});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "setAlreadyRead exception. e: " + e10.getMessage());
        }
        return (arrayList == null || arrayList.isEmpty()) ? "" : arrayList.get(0);
    }

    public List<H5WindowMsgObj> queryUnReadWindows() throws SQLException {
        deleteExpiredMsg();
        try {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            return queryResult4Vo(MessageH5DbScript.QUERY_VALID_MSG_ASC, new String[]{strValueOf, strValueOf});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryUnReadDialogs exception. e: " + e10.getMessage());
            return null;
        }
    }

    public void setAlreadyRead(String str) {
        try {
            execSQL(MessageH5DbScript.UPDATE_ALREADY_READ_BY_ID, new Object[]{str});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "setAlreadyRead exception. e: " + e10.getMessage());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public H5WindowMsgObj getVo(Cursor cursor) {
        H5WindowMsgObj h5WindowMsgObj = new H5WindowMsgObj();
        h5WindowMsgObj.setUniqueId(cursor.getString(0));
        h5WindowMsgObj.setMsgGotoType(cursor.getString(1));
        h5WindowMsgObj.setMsgGotoUri(cursor.getString(2));
        h5WindowMsgObj.setH5DialogAction(cursor.getInt(3));
        h5WindowMsgObj.setH5DialogUrl(cursor.getString(4));
        h5WindowMsgObj.setReadValidityTime(cursor.getLong(5));
        h5WindowMsgObj.setRemainValidityTime(cursor.getLong(6));
        h5WindowMsgObj.setNotifyTime(cursor.getLong(7));
        h5WindowMsgObj.setAlreadyRead(cursor.getInt(8));
        h5WindowMsgObj.setResourceInfo(cursor.getString(9));
        h5WindowMsgObj.setAgdParameters(cursor.getString(10));
        h5WindowMsgObj.setPriority(cursor.getInt(11));
        h5WindowMsgObj.setParamByString(cursor.getString(12));
        h5WindowMsgObj.setRealTimeParamByString(cursor.getString(13));
        h5WindowMsgObj.setTrigger(cursor.getString(14));
        h5WindowMsgObj.setSupportTrigger(cursor.getInt(15));
        return h5WindowMsgObj;
    }
}
