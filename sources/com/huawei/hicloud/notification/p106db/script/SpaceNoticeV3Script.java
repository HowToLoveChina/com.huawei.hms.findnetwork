package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class SpaceNoticeV3Script {
    public static final String CLEAR_SPACE_NOTIFY_FREQUENCY = "delete from space_notify_frequency";
    public static final String INSERT_SPACE_NOTIFY_FREQUENCY = "insert into space_notify_frequency values(?, ?, ?, ?)";
    public static final String QUERY_SPACE_NOTIFY_FREQUENCY = "select times as ndcCount, lastTimeStamp from space_notify_frequency where notifyType=? and dataType=?";
    public static final String UPDATE_SPACE_NOTIFY_FREQUENCY = "update space_notify_frequency set times=times+1, lastTimeStamp=? where notifyType=? and dataType=?";
}
