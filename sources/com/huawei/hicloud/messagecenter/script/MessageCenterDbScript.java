package com.huawei.hicloud.messagecenter.script;

/* loaded from: classes6.dex */
public interface MessageCenterDbScript {
    public static final String CLEAR = "delete from message_center;";
    public static final String DELETE_CAMPAIGN_TASK_MSG = "delete from message_center where category='campaignTask';";
    public static final String DELETE_CAMPAIGN_TASK_TYPE_SIX_MSG = "delete from message_center where category='campaignNotify_6';";
    public static final String DELETE_EXPIRED_MSG = "delete from message_center where remainValidityTime!=0 and remainValidityTime<?;";
    public static final String DELETE_MSG_BY_BACKUP_CAT = "delete from message_center where category='local_sync_backup';";
    public static final String DELETE_MSG_BY_CAT = "delete from message_center where category='local';";
    public static final String DELETE_MSG_BY_ID = "delete from message_center where uniqueId=?;";
    public static final String DELETE_SAME_RICH_MSG = "delete from message_center where alreadyRead=0 and category='product' and msgType='richMsg' and richMsgContent like ?;";
    public static final String DELETE_SAME_TXT_MSG = "delete from message_center where alreadyRead=0 and category='product' and msgType='txtMsg' and titleText=? and mainText=? and msgGotoType=? and msgGotoUri=?;";
    public static final String QUERY_ALL_MSG_DESC = "select * from message_center order by notifyTime desc;";
    public static final String QUERY_BADGE_COUNT = "select * from message_center where needShowBadge=1 and alreadyRead=0 and ((readValidityTime>=? and remainValidityTime>=?) or (readValidityTime=0 and remainValidityTime=0));";
    public static final String QUERY_PRODUCT_MSG_DESC = "select * from message_center where category='product'";
    public static final String SELETE_ALREADY_READ_UNIQUEID = "select uniqueId from message_center  where alreadyRead=?;";
    public static final String SQL_INSERT = "insert into message_center values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_ALREADY_READ = "update message_center set alreadyRead=1;";
    public static final String UPDATE_ALREADY_READ_BY_ID = "update message_center set alreadyRead=1 where uniqueId=?;";
}
