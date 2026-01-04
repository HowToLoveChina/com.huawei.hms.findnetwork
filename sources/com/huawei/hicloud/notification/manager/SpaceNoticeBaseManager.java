package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.task.ActivityEntryPictureTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0227m;

/* loaded from: classes6.dex */
public class SpaceNoticeBaseManager {
    private static final String TAG = "SpaceNoticeBaseManager";

    public boolean isLocalFileExist(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "isLocalFileExist context is null");
            return false;
        }
        String strM1363m = C0212e0.m1363m(contextM1377a, NotifyConstants.ACTIVITY_ENTRY_PICTURE_URL_SP_PATH, C0227m.m1593f(str), null);
        if (TextUtils.isEmpty(strM1363m)) {
            NotifyLogger.m29914e(TAG, " SP record not exist, url = " + str);
            return false;
        }
        if (new File(strM1363m).exists()) {
            return true;
        }
        NotifyLogger.m29914e(TAG, "local file do not exist, SP record exist, url = " + str + " file path = " + strM1363m);
        C0212e0.m1374x(contextM1377a, NotifyConstants.ACTIVITY_ENTRY_PICTURE_URL_SP_PATH, C0227m.m1593f(str));
        return false;
    }

    public boolean storeLocalPathInSpFile(ArrayList<ActivityEntryPictureTask> arrayList) {
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                NotifyLogger.m29914e(TAG, "storeLocalPathInSpFile context is null ");
                return false;
            }
            SharedPreferences.Editor editorEdit = contextM1377a.getSharedPreferences(NotifyConstants.ACTIVITY_ENTRY_PICTURE_URL_SP_PATH, 0).edit();
            Iterator<ActivityEntryPictureTask> it = arrayList.iterator();
            while (it.hasNext()) {
                ActivityEntryPictureTask next = it.next();
                if (new File(next.getDestPath()).exists()) {
                    editorEdit.putString(C0227m.m1593f(next.getPicUrl()), next.getDestPath());
                }
            }
            editorEdit.apply();
            return true;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "storeLocalPathInSpFile exception: " + e10.toString());
            return false;
        }
    }
}
