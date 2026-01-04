package p616rk;

import android.util.Log;
import fk.C9721b;
import java.util.concurrent.Future;

/* renamed from: rk.b */
/* loaded from: classes6.dex */
public abstract class AbstractRunnableC12516b implements Runnable {
    private Future<?> future;

    /* renamed from: rk.b$a */
    public enum a {
        CACHE,
        FIX,
        SINGLE,
        SCHEDULE,
        WLAN_CHANGE_SINGLE,
        QUERY_HAS_LOCAL_DATA_FIX,
        MAIN_PROC_SINGLE,
        SYNC_FIX,
        BANNER_DOWNLOAD_FIX,
        DRIVE,
        CLOUD_PHOTO_DRIVE,
        CLOUD_PHOTO_DRIVE_UPLOAD,
        SYNC_CONFIG,
        FAMILY_SHARE,
        EXIT,
        GET_USER_PUBLIC_INFO,
        PPS_ICON_DOWNLOAD,
        HICLOUD_ACTIVES,
        MARKETING_REQ_BUSINESS_FIX,
        PHONE_FINDER,
        PHONE_FINDER_PUBLIC_KEY,
        PHONE_FINDER_SINGLE,
        HMS_CONNECT_LOCK_NOTIFY_SINGLE,
        UBA_REPORT,
        GIF_DECODE_STREAM,
        DATA_ANALYZE,
        URGENCY_NOTICE_CONFIG,
        QUERY_BASIC_INIT_CONFIG,
        ONLINE_UPDATE_QUERY,
        DEV_CONF_INIT,
        HICLOUD_NOTIFICATION_WITH_ACTIVITY,
        QUERY_KEY,
        INIT_AD_LOADER,
        URGENCT_NOTICE_SINGLE,
        STOCK_ACTIVE,
        NOTIFY_TIMER_CHECK,
        STOCK_ACTIVE_CLICK_OPEN,
        CLOUD_SYNC_DRIVE,
        LOAD_AD,
        DRIVE_CONFIG,
        BACKUP_DELETE,
        BACKUP_LIFE_CYCLE,
        BACKUP_CARD_INFO,
        BACKUP_STATE_INFO_QUERY_PROVIDER,
        OPTIONS_SIZE_TASK,
        SPACE_V3_LANGUAGE_PARSE,
        RECOMMEND_CARD,
        SINGLE_RECOMMEND_CARD,
        SNS_MSG_NUM,
        FREQUENCY_CONTROL,
        COLLECT_DEVICE_INFO,
        BACKUP_SINGLE,
        BACKUP_RECORD_SINGLE,
        WISH_LIST_FIX,
        ANALYZE_CACHE,
        PROCESS_MESSAGE_SINGLE,
        MSG_CENTER_FIX,
        ALBUM_FIX,
        ALBUM_SHARE_UI,
        NORMAL_ALBUM_UI,
        GET_ALL_NORMAL_ALBUM,
        PIC_TAB_THUMB_UI,
        GET_NORMAL_ALBUM_ALL_PHOTOS,
        LOCAL_PHOTO_PICKER_THUMBNAIL,
        QUERY_GUIDE_H5_TASK,
        NOTIFY_FILEMANAGER,
        NOTIFY_FILEMANAGER_CONFIG,
        ENCRYPT_DATA_SINGLE,
        REPORT_AG_EVENT,
        QUERY_CLOUD_SPACE,
        CHECK_TEXT_LINK,
        QUERY_BIG_FILE,
        QUERY_DUPLICATE_FILE,
        QUERY_UNUSUAL_DEVICE,
        GET_SPACE_OPT_DATA,
        SINGLE_RECOMMEND_CARD_REFRESH,
        SPACE_V4_LANGUAGE_PARSE,
        SPACE_V5_LANGUAGE_PARSE,
        HICLOUD_UPGRADE,
        COMMON_PUSH,
        EXECUTE_NOW_TASK,
        SPACE_MULT_LANGUAGE,
        TEMP_BACKUP,
        MAIN_MENU,
        DATA_DICTIONARY,
        DEVICE_ICON_DOWNLOAD
    }

    public abstract void call() throws C9721b;

    public boolean cancel() {
        C12515a.m75110o().m75165a1(this);
        Future<?> future = this.future;
        if (future != null) {
            return future.cancel(true);
        }
        return false;
    }

    public abstract a getEnum();

    public Future<?> getFuture() {
        return this.future;
    }

    public String getTag() {
        return getClass().getName();
    }

    public abstract void release();

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                call();
            } catch (Exception e10) {
                Log.w(getTag(), "task error." + e10.toString());
            }
        } finally {
            release();
        }
    }

    public void setFuture(Future<?> future) {
        this.future = future;
    }

    public abstract boolean syncLock();
}
