package com.huawei.hicloud.messagecenter.script;

/* loaded from: classes6.dex */
public interface MessageH5DbScript {
    public static final String CLEAR = "delete from message_h5_window;";
    public static final String DELETE_CAMPAIGN_REMINDER_BEFORE_EXPIRATION = "delete from message_h5_window where h5DialogAction=11;";
    public static final String DELETE_CAMPAIGN_TASK_MSG = "delete from message_h5_window where h5DialogAction=5;";
    public static final String DELETE_CAMPAIGN_TASK_TYPE_SIX_MSG = "delete from message_h5_window where h5DialogAction=6;";
    public static final String DELETE_EXPIRED_MSG = "delete from message_h5_window where remainValidityTime!=0 and remainValidityTime<?;";
    public static final String QUERY_MSG_HAS_ALREADY_READ = "select alreadyRead from message_h5_window where uniqueId=?";
    public static final String QUERY_VALID_MSG_ASC = "select * from message_h5_window where alreadyRead=0 and ((readValidityTime>=? and remainValidityTime>=?) or (readValidityTime=0 and remainValidityTime=0)) order by priority desc, notifyTime desc;";
    public static final String SQL_INSERT = "insert into message_h5_window values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_ALREADY_READ = "update message_h5_window set alreadyRead=1;";
    public static final String UPDATE_ALREADY_READ_BY_ID = "update message_h5_window set alreadyRead=1 where uniqueId=?;";
}
