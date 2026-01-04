package com.huawei.hicloud.messagecenter.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.messagecenter.bean.DeskPopupMsgObj;
import com.huawei.hicloud.messagecenter.script.MessageDeskPopupDbScript;
import com.huawei.hicloud.notification.log.NotifyLogger;
import fk.C9721b;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class MessageDeskPopupDbOperator extends AbstractC0315c<DeskPopupMsgObj> {
    private static final String TAG = "MessageDeskPopupDbScript";

    private void batchInsert(DeskPopupMsgObj deskPopupMsgObj) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        execSQL(MessageDeskPopupDbScript.SQL_INSERT, getBatchInsertArgs(deskPopupMsgObj));
    }

    private void deleteAlreadyReadmsg(int i10) throws Exception {
        execSQL(MessageDeskPopupDbScript.DELETE_ALREADY_READ_UNDERLYING_DATA_DESK_POPUP, new Object[]{Integer.valueOf(i10)});
    }

    private void deleteLastMsg(int i10) throws Exception {
        execSQL(MessageDeskPopupDbScript.DELETE_UNDERLYING_DATA_DESK_POPUP, new Object[]{Integer.valueOf(i10)});
    }

    private Object[] getBatchInsertArgs(DeskPopupMsgObj deskPopupMsgObj) {
        return new Object[]{deskPopupMsgObj.getUniqueId(), deskPopupMsgObj.getDesktopTitle(), deskPopupMsgObj.getDesktopText(), Long.valueOf(deskPopupMsgObj.getReadValidityTime()), Long.valueOf(deskPopupMsgObj.getRemainValidityTime()), Long.valueOf(deskPopupMsgObj.getNotifyTime()), Integer.valueOf(deskPopupMsgObj.getAlreadyRead()), deskPopupMsgObj.getResourceInfo(), Integer.valueOf(deskPopupMsgObj.getPriority()), deskPopupMsgObj.getTrigger(), Integer.valueOf(deskPopupMsgObj.getSupportTrigger()), deskPopupMsgObj.getMessageId(), deskPopupMsgObj.getDesktopGotoForJson(), Integer.valueOf(deskPopupMsgObj.getDeskPopupAction()), deskPopupMsgObj.getCfgInstanceId(), deskPopupMsgObj.getSecondWindowsForJson(), deskPopupMsgObj.getExtras(), deskPopupMsgObj.getContext()};
    }

    public void clear() {
        try {
            execSQL(MessageDeskPopupDbScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear exception. e: " + e10.getMessage());
        }
    }

    public void deleteExpiredPopup() throws SQLException {
        try {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            execSQL(MessageDeskPopupDbScript.DELETE_EXPIRED_MSG, new Object[]{strValueOf, strValueOf});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "deleteExpiredMsg exception. e: " + e10.getMessage());
        }
    }

    public void deletePopupById(String str) {
        try {
            execSQL(MessageDeskPopupDbScript.DELETE_MSG_BY_ID, new Object[]{str});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "deleteMsgById exception. e: " + e10.getMessage());
        }
    }

    public void insertDeskPopupMsg(DeskPopupMsgObj deskPopupMsgObj) throws Exception {
        NotifyLogger.m29915i(TAG, "insertDeskPopupMsg");
        if (deskPopupMsgObj.getDeskPopupAction() == 19) {
            deleteAlreadyReadmsg(19);
            NotifyLogger.m29915i(TAG, "deleteAlreadyReadmsg");
        } else {
            deleteLastMsg(deskPopupMsgObj.getDeskPopupAction());
        }
        batchInsert(deskPopupMsgObj);
    }

    public List<DeskPopupMsgObj> queryUnShowPopup() throws SQLException {
        deleteExpiredPopup();
        try {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            return queryResult4Vo(MessageDeskPopupDbScript.QUERY_VALID_MSG_ASC, new String[]{strValueOf, strValueOf});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryUnReadDialogs exception. e: " + e10.getMessage());
            return null;
        }
    }

    public void setAlreadyRead(String str) {
        try {
            execSQL(MessageDeskPopupDbScript.UPDATE_ALREADY_READ_BY_ID, new Object[]{str});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "setAlreadyRead exception. e: " + e10.getMessage());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public DeskPopupMsgObj getVo(Cursor cursor) {
        DeskPopupMsgObj deskPopupMsgObj = new DeskPopupMsgObj();
        deskPopupMsgObj.setUniqueId(cursor.getString(0));
        deskPopupMsgObj.setDesktopTitle(cursor.getString(1));
        deskPopupMsgObj.setDesktopText(cursor.getString(2));
        deskPopupMsgObj.setReadValidityTime(cursor.getLong(3));
        deskPopupMsgObj.setRemainValidityTime(cursor.getLong(4));
        deskPopupMsgObj.setNotifyTime(cursor.getLong(5));
        deskPopupMsgObj.setAlreadyRead(cursor.getInt(6));
        deskPopupMsgObj.setResourceInfo(cursor.getString(7));
        deskPopupMsgObj.setPriority(cursor.getInt(8));
        deskPopupMsgObj.setTrigger(cursor.getString(9));
        deskPopupMsgObj.setSupportTrigger(cursor.getInt(10));
        deskPopupMsgObj.setMessageId(cursor.getString(11));
        deskPopupMsgObj.setDesktopGotoByJson(cursor.getString(12));
        deskPopupMsgObj.setDeskPopupAction(cursor.getInt(13));
        deskPopupMsgObj.setCfgInstanceId(cursor.getString(14));
        deskPopupMsgObj.setSecondWindowsByJson(cursor.getString(15));
        deskPopupMsgObj.setExtras(cursor.getString(16));
        deskPopupMsgObj.setContext(cursor.getString(17));
        return deskPopupMsgObj;
    }
}
