package com.huawei.hicloud.messagecenter.script;

/* loaded from: classes6.dex */
public interface MessageDeskPopupDbScript {
    public static final String CLEAR = "delete from message_desk_popup;";
    public static final String DELETE_ALREADY_READ_UNDERLYING_DATA_DESK_POPUP = "delete from message_desk_popup where deskPopupAction = ? and alreadyRead=1;";
    public static final String DELETE_EXPIRED_MSG = "delete from message_desk_popup where ((remainValidityTime!=0 and remainValidityTime<?) or (readValidityTime!=0 and readValidityTime<?));";
    public static final String DELETE_MSG_BY_ID = "delete from message_desk_popup where uniqueId=?;";
    public static final String DELETE_UNDERLYING_DATA_DESK_POPUP = "delete from message_desk_popup where deskPopupAction = ?;";
    public static final String QUERY_VALID_MSG_ASC = "select * from message_desk_popup where alreadyRead=0 and ((readValidityTime>=? and remainValidityTime>=?) or (readValidityTime=0 and remainValidityTime=0)) order by priority desc, notifyTime desc;";
    public static final String SQL_INSERT = "insert into message_desk_popup values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_ALREADY_READ_BY_ID = "update message_desk_popup set alreadyRead=1 where uniqueId=?;";
}
