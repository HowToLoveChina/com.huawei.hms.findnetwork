package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class NoticeContentScript {
    public static final String CLEAR_SPACE_NOTIFY_CONTENT = "delete from space_notify_content";
    public static final String INSETT_SPACE_NOTIFY_CONTENT = "insert into space_notify_content values(?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?, ?)";
    public static final String QUERY_SPACE_NOTIFY_CONTENT = "select language, title, main_text, sub_title, remind_mode, button_first, buttonSecond, description, description_second, main_text_second, content_type from space_notify_content where notify_type=? and id=? and language=? and remind_mode=? and content_type=?";
    public static final String QUERY_SPACE_NOTIFY_CONTENT_BY_LANGUAGE = "select language, title, main_text, sub_title, remind_mode, button_first, buttonSecond, description, description_second, main_text_second, content_type from space_notify_content where notify_type=? and id=? and language like ? and remind_mode=? and content_type=?";
}
