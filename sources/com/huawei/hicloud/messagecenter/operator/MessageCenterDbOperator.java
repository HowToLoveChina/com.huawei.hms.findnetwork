package com.huawei.hicloud.messagecenter.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj;
import com.huawei.hicloud.messagecenter.script.MessageCenterDbScript;
import com.huawei.hicloud.notification.log.NotifyLogger;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class MessageCenterDbOperator extends AbstractC0315c<MessageCenterMsgObj> {
    private static final String TAG = "MessageCenterDbOperator";

    private void batchInsert(MessageCenterMsgObj messageCenterMsgObj) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        execSQL(MessageCenterDbScript.SQL_INSERT, getBatchInsertArgs(messageCenterMsgObj));
    }

    private void deleteLastMsg(String str) throws Exception {
        if ("campaignTask".equals(str)) {
            execSQL(MessageCenterDbScript.DELETE_CAMPAIGN_TASK_MSG);
        } else if ("campaignNotify_6".equals(str)) {
            execSQL(MessageCenterDbScript.DELETE_CAMPAIGN_TASK_TYPE_SIX_MSG);
        }
    }

    private Object[] getBatchInsertArgs(MessageCenterMsgObj messageCenterMsgObj) {
        return new Object[]{messageCenterMsgObj.getUniqueId(), messageCenterMsgObj.getMsgType(), messageCenterMsgObj.getMsgGotoType(), messageCenterMsgObj.getMsgGotoUri(), messageCenterMsgObj.getMainText(), messageCenterMsgObj.getTitleText(), messageCenterMsgObj.getRichMsgContent(), Integer.valueOf(messageCenterMsgObj.getNeedShowBadge()), Long.valueOf(messageCenterMsgObj.getReadValidityTime()), Long.valueOf(messageCenterMsgObj.getRemainValidityTime()), Long.valueOf(messageCenterMsgObj.getNotifyTime()), messageCenterMsgObj.getPictureUrl(), Integer.valueOf(messageCenterMsgObj.getAlreadyRead()), messageCenterMsgObj.getCategory(), messageCenterMsgObj.getResourceInfo(), messageCenterMsgObj.getRecommendNeedData(), messageCenterMsgObj.getMemberShareDetail(), Integer.valueOf(messageCenterMsgObj.getCheckFamilyMember()), Integer.valueOf(messageCenterMsgObj.getNotifyId()), messageCenterMsgObj.getAgdParameters(), messageCenterMsgObj.getGotoDeeplinkUri(), Long.valueOf(messageCenterMsgObj.getTotalNeedSpace()), messageCenterMsgObj.getIntroductionH5Url(), messageCenterMsgObj.getNotifyType(), messageCenterMsgObj.getContext()};
    }

    public void clear() {
        try {
            execSQL(MessageCenterDbScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear exception. e: " + e10.getMessage());
        }
    }

    public void deleteDuplicateMsg(MessageCenterMsgObj messageCenterMsgObj) throws Exception {
        if ("txtMsg".equals(messageCenterMsgObj.getMsgType())) {
            execSQL(MessageCenterDbScript.DELETE_SAME_TXT_MSG, new Object[]{messageCenterMsgObj.getTitleText(), messageCenterMsgObj.getMainText(), messageCenterMsgObj.getMsgGotoType(), messageCenterMsgObj.getMsgGotoUri()});
        } else if ("richMsg".equals(messageCenterMsgObj.getMsgType())) {
            execSQL(MessageCenterDbScript.DELETE_SAME_RICH_MSG, new Object[]{messageCenterMsgObj.getRichMsgContent()});
        }
    }

    public void deleteExpiredMsg() throws SQLException {
        try {
            execSQL(MessageCenterDbScript.DELETE_EXPIRED_MSG, new Object[]{String.valueOf(System.currentTimeMillis())});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "deleteExpiredMsg exception. e: " + e10.getMessage());
        }
    }

    public void deleteMsgByBackupCat() {
        try {
            execSQL(MessageCenterDbScript.DELETE_MSG_BY_BACKUP_CAT);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "deleteMsgByBackupCat exception. e: " + e10.getMessage());
        }
    }

    public void deleteMsgByCat() {
        try {
            execSQL(MessageCenterDbScript.DELETE_MSG_BY_CAT);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "deleteMsgByCat exception. e: " + e10.getMessage());
        }
    }

    public void deleteMsgById(String str) {
        try {
            execSQL(MessageCenterDbScript.DELETE_MSG_BY_ID, new Object[]{str});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "deleteMsgById exception. e: " + e10.getMessage());
        }
    }

    public List<String> getUniqueIdsByAlreadyRead(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            return queryStringList(MessageCenterDbScript.SELETE_ALREADY_READ_UNIQUEID, new String[]{str});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "getUniqueIdsByAlreadyRead exception. e: " + e10.getMessage());
            return arrayList;
        }
    }

    public void insertMessage(MessageCenterMsgObj messageCenterMsgObj) throws Exception {
        NotifyLogger.m29915i(TAG, "insertMessage");
        String category = messageCenterMsgObj.getCategory();
        if ("product".equals(category)) {
            deleteDuplicateMsg(messageCenterMsgObj);
        } else if ("campaignTask".equals(category) || "campaignNotify_6".equals(category)) {
            deleteLastMsg(category);
        } else if ("local".equals(category)) {
            deleteMsgByCat();
        } else if ("local_sync_backup".equals(category)) {
            deleteMsgByBackupCat();
        }
        batchInsert(messageCenterMsgObj);
    }

    public List<MessageCenterMsgObj> queryAllMessage() throws SQLException {
        deleteExpiredMsg();
        try {
            return queryResult4Vo(MessageCenterDbScript.QUERY_ALL_MSG_DESC, null);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryAllMessage exception. e: " + e10.getMessage());
            return null;
        }
    }

    public int queryBadgeCount() throws Exception {
        deleteExpiredMsg();
        String strValueOf = String.valueOf(System.currentTimeMillis());
        List<MessageCenterMsgObj> listQueryResult4Vo = queryResult4Vo(MessageCenterDbScript.QUERY_BADGE_COUNT, new String[]{strValueOf, strValueOf});
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            return 0;
        }
        return listQueryResult4Vo.size();
    }

    public List<MessageCenterMsgObj> queryProductMessage() {
        try {
            return queryResult4Vo(MessageCenterDbScript.QUERY_PRODUCT_MSG_DESC, null);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryProductMessage exception. e: " + e10.getMessage());
            return null;
        }
    }

    public void setAllAlreadyRead() {
        try {
            execSQL(MessageCenterDbScript.UPDATE_ALREADY_READ);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "setAllAlreadyRead exception. e: " + e10.getMessage());
        }
    }

    public void setAlreadyRead(String str) {
        try {
            execSQL(MessageCenterDbScript.UPDATE_ALREADY_READ_BY_ID, new Object[]{str});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "setAlreadyRead exception. e: " + e10.getMessage());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public MessageCenterMsgObj getVo(Cursor cursor) {
        MessageCenterMsgObj messageCenterMsgObj = new MessageCenterMsgObj();
        messageCenterMsgObj.setUniqueId(cursor.getString(0));
        messageCenterMsgObj.setMsgType(cursor.getString(1));
        messageCenterMsgObj.setMsgGotoType(cursor.getString(2));
        messageCenterMsgObj.setMsgGotoUri(cursor.getString(3));
        messageCenterMsgObj.setMainText(cursor.getString(4));
        messageCenterMsgObj.setTitleText(cursor.getString(5));
        messageCenterMsgObj.setRichMsgContent(cursor.getString(6));
        messageCenterMsgObj.setNeedShowBadge(cursor.getInt(7));
        messageCenterMsgObj.setReadValidityTime(cursor.getLong(8));
        messageCenterMsgObj.setRemainValidityTime(cursor.getLong(9));
        messageCenterMsgObj.setNotifyTime(cursor.getLong(10));
        messageCenterMsgObj.setPictureUrl(cursor.getString(11));
        messageCenterMsgObj.setAlreadyRead(cursor.getInt(12));
        messageCenterMsgObj.setCategory(cursor.getString(13));
        messageCenterMsgObj.setResourceInfo(cursor.getString(14));
        messageCenterMsgObj.setRecommendNeedData(cursor.getString(15));
        messageCenterMsgObj.setMemberShareDetail(cursor.getString(16));
        messageCenterMsgObj.setCheckFamilyMember(cursor.getInt(17));
        messageCenterMsgObj.setNotifyId(cursor.getInt(18));
        messageCenterMsgObj.setAgdParameters(cursor.getString(19));
        messageCenterMsgObj.setGotoDeeplinkUri(cursor.getString(20));
        messageCenterMsgObj.setTotalNeedSpace(cursor.getLong(21));
        messageCenterMsgObj.setIntroductionH5Url(cursor.getString(22));
        messageCenterMsgObj.setNotifyType(cursor.getString(23));
        messageCenterMsgObj.setContext(cursor.getString(24));
        return messageCenterMsgObj;
    }
}
