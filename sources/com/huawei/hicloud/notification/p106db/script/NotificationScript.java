package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class NotificationScript {
    public static final String CLEAR = "delete from notify_rule";
    public static final String CLEAR_SPACE_NOTIFY_CONTENT = "delete from space_notify_content_origin";
    public static final String CLEAR_SPACE_NOTIFY_DETAIL = "delete from space_notify_detail";
    public static final String INSERT_RULE = "insert into notify_rule values(?, ?, ?, ?, ?)";
    public static final String INSETT_SPACE_NOTIFY_CONTENT = "insert into space_notify_content_origin values(?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?, ?)";
    public static final String INSETT_SPACE_NOTIFY_DETAIL = "insert into space_notify_detail values(?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String QUERY_PULL_NEW_CONTENT = "select language, title, main_text, sub_title, remind_mode, button_first, buttonSecond, description, description_second, main_text_second, detail_link from space_notify_content_origin where notify_type=? and id=? and language=?";
    public static final String QUERY_PULL_NEW_CONTENT_BY_LANGUAGE = "select language, title, main_text, sub_title, remind_mode, button_first, buttonSecond, description, description_second, main_text_second, detail_link from space_notify_content_origin where notify_type=? and id=? and language like ?";
    public static final String QUERY_RULE_INFO = "select times as ndcCount, checkInit, lastTimeStamp from notify_rule where notifyType=? and dataType=?";
    public static final String QUERY_SPACE_NOTIFY_CONTENT = "select language, title, main_text, sub_title, remind_mode, button_first, buttonSecond, description, description_second, main_text_second, detail_link from space_notify_content_origin where notify_type=? and id=? and language=? and remind_mode=?";
    public static final String QUERY_SPACE_NOTIFY_CONTENT_BY_LANGUAGE = "select language, title, main_text, sub_title, remind_mode, button_first, buttonSecond, description, description_second, main_text_second, detail_link from space_notify_content_origin where notify_type=? and id=? and language like ? and remind_mode=?";
    public static final String QUERY_SPACE_NOTIFY_DETAIL = "select language, title, main_text, button_first, detail_link from space_notify_detail where notice_type=? and id=? and language=? and user_type=?";
    public static final String QUERY_SPACE_NOTIFY_DETAIL_BY_LANGUAGE = "select language, title, main_text, button_first, detail_link from space_notify_detail where notice_type=? and id=? and language like ? and user_type=?";
    public static final String UPDATE_CHECK_INIT = "update notify_rule set checkInit=? where notifyType=? and dataType=?";
    public static final String UPDATE_COUNT = "update notify_rule set times=times+1, lastTimeStamp=? where notifyType=? and dataType=?";
}
