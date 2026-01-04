package com.huawei.android.hicloud.sync.service.aidl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.sync.syncutil.C2973b;
import com.huawei.android.hicloud.sync.syncutil.C2986o;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0206b0;
import p015ak.C0214f0;
import p015ak.C0237v;
import p514o9.C11839m;
import p783xp.C13843a;
import tc.C13007b;

/* loaded from: classes3.dex */
public class ServiceSyncLogicUtil {
    private static final String TAG = "ServiceSyncLogicUtil";
    private Context mContext;

    public ServiceSyncLogicUtil(Context context) {
        this.mContext = context;
    }

    private void clearCloudSpaceNotEnough(SharedPreferences sharedPreferences, String str) {
        C11839m.m70688i(TAG, "Receive space push, start clear CloudSpaceNotEnough sp notify UI");
        CloudSyncUtil.m16002d1(this.mContext, str);
        CloudSyncUtil.m15999c1();
        CloudSyncUtil.m16005e1();
        CloudSyncUtil.m16008f1();
        int i10 = sharedPreferences.getInt(str + "sync_retcode", 5);
        C11839m.m70688i(TAG, "query " + str + " syncStatus=" + i10);
        if (20 == i10) {
            C0237v.m1661c();
            sharedPreferences.edit().putInt(str + "sync_retcode", -1).commit();
            CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END", str);
        }
    }

    private void parsePushData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        int i10 = jSONObject.getInt(CommonNotifyReceiver.COMMAND_KEY);
        String strOptString = "";
        try {
            if (jSONObject.has("body")) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("body"));
                if (jSONObject2.has(ParamConstants.Param.CONTEXT)) {
                    JSONObject jSONObject3 = new JSONObject(jSONObject2.getString(ParamConstants.Param.CONTEXT));
                    if (jSONObject3.has("prepareTraceId")) {
                        strOptString = jSONObject3.optString("prepareTraceId");
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "Receive push: context error " + e10.getMessage());
        }
        String str2 = strOptString;
        if (1 == i10) {
            C11839m.m70686d(TAG, "Receive push: command is 1, sync.");
            requestSyncFromPush(jSONObject.getString("source"), 2, str2);
            return;
        }
        if (3 == i10) {
            C11839m.m70686d(TAG, "Receive push: command is 3, updata.");
            return;
        }
        String strM18000j = DriveSyncUtil.m18000j(i10);
        if (TextUtils.isEmpty(strM18000j)) {
            return;
        }
        C11839m.m70686d(TAG, "Receive push syncv2: command is " + i10 + ", syncType = " + strM18000j + ", sync, prepareTraceId = " + str2);
        startSyncForSyncType(strM18000j, true, false, 2, str2);
    }

    private static ArrayList<String> parsePushSyncString(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArrSplit = str.split("\\|");
        if (strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    private void requestSyncFromPush(String str, int i10, String str2) {
        ArrayList<String> pushSyncString = parsePushSyncString(str);
        if (pushSyncString.size() != 0) {
            for (int i11 = 0; i11 < pushSyncString.size(); i11++) {
                startSyncForSyncType(pushSyncString.get(i11), true, false, i10, str2);
            }
        }
    }

    private void requestSyncFromSpaceChange() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.mContext, "sync_contact_spfile", 0);
        Iterator<String> it = CloudSyncUtil.m15985X(this.mContext).iterator();
        while (it.hasNext()) {
            String next = it.next();
            boolean z10 = sharedPreferencesM1382b.getBoolean(next + "cloudSpaceNotEnough", false);
            C11839m.m70688i(TAG, "requestSyncFromSpaceChange: syncType = " + next + ", isCloudSpaceNotEnough = " + z10);
            if (z10) {
                clearCloudSpaceNotEnough(sharedPreferencesM1382b, next);
                startSyncForSyncType(next, false, false, 2, "");
            }
        }
    }

    private void startFrameworkSync(String str, boolean z10, int i10, String str2) {
        if (C0206b0.m1131c(str, this.mContext)) {
            if (z10) {
                C2973b.m17824l(this.mContext, str);
            } else {
                C2973b.m17822j(this.mContext, str);
            }
            SyncObserverServiceInvoker.getInstance().startFrameworkSync(this.mContext, str, i10, str2);
        }
    }

    private void startGalleryAtlasSync(int i10, String str) {
        if (C0206b0.m1131c("atlas", this.mContext)) {
            SyncObserverServiceInvoker.getInstance().startGalleryAtlasSync(this.mContext, i10, str);
        }
    }

    private void startSyncBrowser(boolean z10, int i10, String str) {
        if (C0206b0.m1131c("browser", this.mContext)) {
            if (z10) {
                C2973b.m17824l(this.mContext, "browser");
            } else {
                C2973b.m17822j(this.mContext, "browser");
            }
            SyncObserverServiceInvoker.getInstance().startBrowserSync(this.mContext, i10, str);
        }
    }

    private void startSyncCalendar(boolean z10, int i10, String str) {
        if (C0206b0.m1131c("calendar", this.mContext)) {
            if (z10) {
                C2973b.m17824l(this.mContext, "calendar");
            } else {
                C2973b.m17822j(this.mContext, "calendar");
            }
            SyncObserverServiceInvoker.getInstance().startCalendarSync(this.mContext, i10, str);
        }
    }

    private void startSyncContact(int i10, boolean z10) {
        CloudSync cloudSync = CloudSync.getInstance();
        if (z10) {
            C2973b.m17824l(this.mContext, "addressbook");
        } else {
            C2973b.m17822j(this.mContext, "addressbook");
        }
        SyncType syncType = SyncType.COMMON_SYNC;
        if (i10 == 5) {
            syncType = SyncType.PUSH_SYNC;
        } else if (i10 == 16) {
            syncType = SyncType.HIDISK_RETRY_SYNC;
        }
        cloudSync.doAutoSyncContact(syncType);
        C2986o.m17946c(this.mContext, "com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
    }

    private void startSyncForSyncType(String str, boolean z10, boolean z11, int i10, String str2) {
        C11839m.m70688i(TAG, "Receive push, start sync for " + str);
        if ("./contact".equalsIgnoreCase(str) || "addressbook".equalsIgnoreCase(str)) {
            C11839m.m70688i(TAG, "Receive push, start sync contact");
            if (C0206b0.m1131c("addressbook", this.mContext)) {
                C13007b c13007bM78205Y = C13007b.m78205Y(this.mContext);
                if (z10 && c13007bM78205Y.m78206A("addressbook") && DriveSyncUtil.m17973R(this.mContext, "addressbook")) {
                    C11839m.m70688i(TAG, "contact first migrate v2.");
                    DriveSyncUtil.m17997h0(this.mContext, "addressbook", "v2PushReport", null);
                    return;
                } else {
                    if (!C13843a.m83073Y(this.mContext)) {
                        startSyncContact(i10, z11);
                        return;
                    }
                    if (z11) {
                        C2973b.m17824l(this.mContext, "addressbook");
                    }
                    SyncObserverServiceInvoker.getInstance().startContactSyncWithAIDL(this.mContext, i10, str2);
                    return;
                }
            }
            return;
        }
        if ("wlan".equalsIgnoreCase(str)) {
            C11839m.m70688i(TAG, "Receive push, start sync wlan");
            SyncType syncType = SyncType.WlanSyncType.COMMON_SYNC;
            if (i10 == 5) {
                syncType = SyncType.WlanSyncType.PUSH_SYNC;
            } else if (i10 == 16) {
                syncType = SyncType.WlanSyncType.HIDISK_RETRY_SYNC;
            }
            startSyncWlan(syncType);
            return;
        }
        if ("calendar".equalsIgnoreCase(str)) {
            C11839m.m70688i(TAG, "Receive push, start sync calendar");
            startSyncCalendar(z11, i10, str2);
            return;
        }
        if ("notepad".equalsIgnoreCase(str)) {
            C11839m.m70688i(TAG, "Receive push, start sync notepad");
            startSyncNotepad(z11, i10, str2);
            return;
        }
        if ("browser".equalsIgnoreCase(str)) {
            C11839m.m70688i(TAG, "Receive push, start sync browser");
            startSyncBrowser(z11, i10, str2);
        } else {
            if ("atlas".equalsIgnoreCase(str)) {
                C11839m.m70688i(TAG, "Receive push, start sync gallery atlas");
                startGalleryAtlasSync(i10, str2);
                return;
            }
            C11839m.m70688i(TAG, "Receive push, syncType: " + str);
            startFrameworkSync(str, z11, i10, str2);
        }
    }

    private void startSyncNotepad(boolean z10, int i10, String str) {
        if (C0206b0.m1131c("notepad", this.mContext)) {
            if (z10) {
                C2973b.m17824l(this.mContext, "notepad");
            } else {
                C2973b.m17822j(this.mContext, "notepad");
            }
            SyncObserverServiceInvoker.getInstance().startNotepadSync(this.mContext, i10, str);
        }
    }

    private void startSyncWlan(SyncType syncType) {
        if (C0206b0.m1131c("wlan", this.mContext)) {
            CloudSync.getInstance().doAutoSyncWlan(syncType);
            C2986o.m17946c(this.mContext, "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
        }
    }

    public void processPushMsg(int i10, String str) {
        C11839m.m70686d(TAG, "Process push message, type = " + i10);
        if (i10 != 4099) {
            if (i10 != 4100) {
                return;
            }
            requestSyncFromSpaceChange();
        } else {
            if (TextUtils.isEmpty(str)) {
                C11839m.m70686d(TAG, "Push broadcast data is null.");
                return;
            }
            try {
                parsePushData(str);
            } catch (JSONException e10) {
                C11839m.m70688i(TAG, e10.getMessage());
            }
        }
    }

    public void startSyncForSyncRetry(String str, int i10, String str2) {
        C11839m.m70688i(TAG, " sync retry, start sync for " + str);
        startSyncForSyncType(str, false, true, i10, str2);
    }
}
