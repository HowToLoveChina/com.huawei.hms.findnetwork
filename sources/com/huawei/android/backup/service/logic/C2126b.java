package com.huawei.android.backup.service.logic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: com.huawei.android.backup.service.logic.b */
/* loaded from: classes.dex */
public class C2126b {
    public static final String ERROR_MESSAGE_INFO = "errorMsg";
    public static final String MODULE_INFO_APP_ID = "app_id";
    public static final String MODULE_INFO_COUNT = "count";
    public static final String MODULE_INFO_ERROR_INFO = "error_info";
    public static final String MODULE_INFO_IS_NEED_BACKUP_URI = "is_need_backup_uri";
    public static final String MODULE_INFO_IS_NEED_COUNT_URI = "is_need_count_uri";
    public static final String MODULE_INFO_LIST = "module_info_list";
    public static final String MODULE_INFO_PREPARE_COUNT = "prepare_count";
    public static final String MODULE_INFO_URI = "uri";
    public static final String MODULE_INFO_VALUE_NEED_BACKUP = "1";
    public static final String MODULE_INFO_VALUE_NEED_COUNT = "1";
    public static final String MODULE_INFO_VALUE_NOT_NEED_BACKUP = "0";
    public static final String MODULE_INFO_VALUE_NOT_NEED_COUNT = "0";
    public static final int MSG_ABORT_DOING_DONE = 24;
    public static final int MSG_BACKUP_DONE = 1;
    public static final int MSG_BACKUP_FAIL = 2;
    public static final int MSG_BACKUP_FAIL_LOG = 100;
    public static final int MSG_BACKUP_FILE_IS_NOT_EXIST = 22;
    public static final int MSG_BACKUP_FINISH_LOG = 102;
    public static final int MSG_BACKUP_SUCCESS = 0;
    public static final int MSG_DATA_MISMATCH = 9;
    public static final int MSG_DECRYPT_SUCCESS = 71;
    public static final int MSG_FILE_OPEN_FAIL = 25;
    public static final int MSG_INSUFFICIENT_STORAGE = 17;
    public static final int MSG_ONE_APK_BACKUP_FAIL = 11;
    public static final int MSG_ONE_APK_BACKUP_START = 15;
    public static final int MSG_ONE_APK_BACKUP_SUCCESS = 14;
    public static final int MSG_ONE_APK_RESTORE_FAIL = 12;
    public static final int MSG_ONE_APK_RESTORE_START = 16;
    public static final int MSG_ONE_APK_RESTORE_SUCCESS = 13;
    public static final int MSG_RESTORE_DONE = 4;
    public static final int MSG_RESTORE_FAIL = 5;
    public static final int MSG_RESTORE_FAIL_LOG = 101;
    public static final int MSG_RESTORE_SUCCESS = 3;
    public static final int MSG_RESTORE_UNSUPPORT = 7;
    public static final int MSG_UNKNOWN = 6;
    private static final String TAG = "BackupObjectMsgDefine";

    /* renamed from: com.huawei.android.backup.service.logic.b$a */
    public static class a {

        /* renamed from: a */
        public Handler.Callback f9594a;

        /* renamed from: b */
        public Object f9595b;

        /* renamed from: c */
        public int f9596c = 0;

        /* renamed from: d */
        public int f9597d = 0;

        public a(Handler.Callback callback, Object obj) {
            this.f9594a = callback;
            this.f9595b = obj;
        }

        /* renamed from: c */
        public void m12764c() {
            this.f9597d++;
        }

        /* renamed from: d */
        public void m12765d() {
            this.f9596c++;
        }

        /* renamed from: e */
        public int m12766e() {
            return this.f9596c;
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.b$b */
    public static class b {

        /* renamed from: a */
        public int f9598a;

        /* renamed from: b */
        public int f9599b;

        /* renamed from: c */
        public int f9600c;

        public b(int i10, int i11, int i12) {
            this.f9598a = i10;
            this.f9599b = i11;
            this.f9600c = i12;
        }

        /* renamed from: a */
        public int m12767a() {
            return this.f9598a;
        }

        /* renamed from: b */
        public int m12768b() {
            return this.f9599b;
        }

        /* renamed from: c */
        public int m12769c() {
            return this.f9600c;
        }
    }

    public boolean handleCallbackMessage(Message message) {
        if (message == null) {
            return false;
        }
        Object obj = message.obj;
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar == null) {
            return false;
        }
        int i10 = message.what;
        if (i10 == 0) {
            aVar.m12765d();
        } else if (i10 == 2) {
            aVar.m12764c();
        } else {
            C2111d.m12647c(TAG, "handleCallbackMessage: ", Integer.valueOf(i10));
        }
        sendMsg(storeHandlerMsgToObjectMsg(message.what), message.arg1, message.arg2, aVar.f9594a, aVar.f9595b);
        return true;
    }

    public void sendMsg(int i10, int i11, int i12, Handler.Callback callback, Object obj) {
        if (callback != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = i11;
            messageObtain.arg2 = i12;
            messageObtain.obj = obj;
            callback.handleMessage(messageObtain);
        }
    }

    public int storeHandlerMsgToObjectMsg(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 != 1) {
            return i10 != 2 ? 6 : 2;
        }
        return 1;
    }

    public void sendMsg(b bVar, Handler.Callback callback, Object obj, Bundle bundle) {
        if (callback == null || bVar == null || bundle == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = bVar.m12767a();
        messageObtain.arg1 = bVar.m12768b();
        messageObtain.arg2 = bVar.m12769c();
        messageObtain.obj = obj;
        messageObtain.setData(bundle);
        callback.handleMessage(messageObtain);
    }

    public void sendMsg(int i10, Bundle bundle, Handler.Callback callback, Object obj) {
        if (callback != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.setData(bundle);
            messageObtain.obj = obj;
            callback.handleMessage(messageObtain);
        }
    }

    public void sendMsg(int i10, String str, Handler.Callback callback, Object obj) {
        Bundle bundle = new Bundle();
        bundle.putString(ERROR_MESSAGE_INFO, str);
        if (callback != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.setData(bundle);
            messageObtain.obj = obj;
            callback.handleMessage(messageObtain);
        }
    }
}
