package com.huawei.android.hicloud.sync.service.aidl;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.TransactionTooLargeException;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.hicloud.sync.service.aidl.ISyncService;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.sync.syncutil.C2981j;
import com.huawei.android.hicloud.sync.syncutil.C2986o;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.android.hicloud.task.frame.RequestDispatcher;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.bean.SyncConfigServiceDataType;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigDataTypeOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import je.C10800n;
import je.C10812z;
import md.C11440c;
import md.C11442e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0214f0;
import p015ak.C0240y;
import p514o9.C11839m;
import p572qb.C12316j0;
import p572qb.C12329u;
import p609rc.C12487a;
import p616rk.C12515a;
import p664u0.C13108a;
import p770xc.C13746i;
import p783xp.C13843a;
import sb.C12767a;

/* loaded from: classes3.dex */
public class SyncLogicService extends Service {
    private static final int FIRST_ORDER = 1;
    public static final String IS_BATCHES_SEND_OVER_KEY = "is_send_over";
    public static final String IS_INCREMENT_SEND_DATA_KEY = "is_increment_send_data";
    public static final String IS_SEND_DATA_IN_BATCHES_KEY = "is_in_batches";
    private static final int MAX_BUNDLE_SIZE = 102400;
    private static final long MAX_RESPONSE_TIME = 600000;
    private static final int MGS_SYNC_CALLBACK_HANDLER = 6;
    private static final int MSG_BROWSER_RESPONSE_TIMEOUT = 3;
    private static final int MSG_CALENDAR_RESPONSE_TIMEOUT = 2;
    private static final int MSG_CONTACT_RESPONSE_TIMEOUT = 4;
    private static final int MSG_GALLERY_ATLAS_RESPONSE_TIMEOUT = 5;
    private static final int MSG_NOTEPAD_RESPONSE_TIMEOUT = 1;
    public static final String SEND_MESSAGE_IN_BATCHES_DATA_BYTES_KEY = "batches_data_bytes_key";
    private static final String TAG = "SyncLogicService";
    private HandlerThread callbackHandlerThread;
    private boolean isSendMessageInBatches;
    private static final Map<String, Integer> SYNC_TYPE_TIME_OUT_MSG_MAP = new HashMap();
    private static final Map<String, Boolean> SYNC_TYPE_IS_ENDING_MAP = new HashMap();
    private static final Map<String, Integer> SYNC_TYPE_PACKAGE_NAME_MAP = new HashMap();
    private static final Map<String, String> PACKAGE_NAME_SYNC_TYPE_MAP = new HashMap();
    private static final Map<String, C12329u> SYNC_TYPE_LOST_REFUND_MAP = new HashMap();
    private static final Map<String, ReportSyncEndInfo> SYNC_TYPE_REPORT_SYNC_END_MAP = new HashMap();
    private static final Map<String, Boolean> SYNC_SDK_SUPPORT_DOWN_PARTICAL_SUC_MAP = new HashMap();
    private static final Map<String, String> SYNC_AFTER_DOWN_PARTICAL_SUC_MAP = new HashMap();
    private static final ConcurrentHashMap<String, Boolean> SYNC_FLOW_CONTROL_EFFECTED_MAP = new ConcurrentHashMap<>();
    private static final Map<String, String> SYNC_TYPE_2_REAL_PKG_NAME = new HashMap(10);
    private static final Map<String, String> SYNC_TYPE_2_CALLING_PKG_NAME = new HashMap(10);
    private final Map<String, RemoteCallbackList<ISyncServiceCallback>> mCallbacks = new HashMap();
    private final SyncServiceStub mBinder = new SyncServiceStub();
    private Context appContext = null;
    private final RequestDispatcher mDispatcher = new RequestDispatcher(this);
    private LocalReceiver mLocalReceiver = null;
    private C10028c mSettingMgr = null;
    private final Map<String, String> traceIdMap = new HashMap(10);
    private final Map<String, String> syncRsnMap = new HashMap(10);
    private StringBuffer batchesBuffer = new StringBuffer();

    @SuppressLint({"HandlerLeak"})
    private Handler callbackHandler = null;
    private final Handler mHandler = new Handler() { // from class: com.huawei.android.hicloud.sync.service.aidl.SyncLogicService.1
        public HandlerC29591() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    int i10 = message.what;
                    Bundle bundle = (Bundle) message.obj;
                    String string = bundle.getString("syncType");
                    String string2 = bundle.getString("packageName");
                    if (SyncLogicService.SYNC_TYPE_TIME_OUT_MSG_MAP.values().contains(Integer.valueOf(i10)) && SyncLogicService.this.checkTimeOutExceedMaxTime(string)) {
                        C11839m.m70688i(SyncLogicService.TAG, "receive cloud sdk response time out message, syncType = " + string + ", msgWhat = " + i10 + ", syncModulePackageName = " + string2);
                        SyncLogicService.this.mBinder.endSyncByTimeout(string, new ArrayList(), new ArrayList(), true, string2, 2025);
                    }
                } catch (Exception e10) {
                    C11839m.m70687e(SyncLogicService.TAG, "handleMessage error: " + e10.toString());
                }
            }
        }
    };

    /* renamed from: com.huawei.android.hicloud.sync.service.aidl.SyncLogicService$1 */
    public class HandlerC29591 extends Handler {
        public HandlerC29591() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    int i10 = message.what;
                    Bundle bundle = (Bundle) message.obj;
                    String string = bundle.getString("syncType");
                    String string2 = bundle.getString("packageName");
                    if (SyncLogicService.SYNC_TYPE_TIME_OUT_MSG_MAP.values().contains(Integer.valueOf(i10)) && SyncLogicService.this.checkTimeOutExceedMaxTime(string)) {
                        C11839m.m70688i(SyncLogicService.TAG, "receive cloud sdk response time out message, syncType = " + string + ", msgWhat = " + i10 + ", syncModulePackageName = " + string2);
                        SyncLogicService.this.mBinder.endSyncByTimeout(string, new ArrayList(), new ArrayList(), true, string2, 2025);
                    }
                } catch (Exception e10) {
                    C11839m.m70687e(SyncLogicService.TAG, "handleMessage error: " + e10.toString());
                }
            }
        }
    }

    public class CallBackHandler extends Handler {
        public CallBackHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                if (message.what != 6) {
                    return;
                }
                Bundle bundle = (Bundle) message.obj;
                Bundle data = message.getData();
                int i10 = data.getInt("msgID");
                String string = data.getString("msgType");
                int i11 = bundle.getInt(MapKeyNames.RESULT_CODE);
                String string2 = bundle.getString("sync_module_package_name");
                if (!bundle.getBoolean("increment_bundle", false)) {
                    SyncLogicService.this.isSendMessageInBatches = false;
                    SyncLogicService.this.sendCallbackMessage(string, i10, bundle, string2);
                    if (SyncLogicService.this.isSendMessageInBatches) {
                        SyncLogicService.this.sendMessageOver(string, i10, i11, string2, bundle);
                        SyncLogicService.this.isSendMessageInBatches = false;
                    }
                } else if (bundle.getBoolean("is_send_over", false)) {
                    SyncLogicService.this.sendMessageOver(string, i10, i11, string2, bundle);
                } else {
                    SyncLogicService.this.sendCallbackMessage(string, i10, bundle, string2);
                }
                if (SyncLogicService.this.mCallbacks.get(string2) == null || !SyncLogicService.this.isNeedSendTimeOutMessage(i10)) {
                    return;
                }
                SyncLogicService.this.sendTimeOutMessage(string, string2);
            } catch (Exception e10) {
                C11839m.m70687e(SyncLogicService.TAG, "handleMessage:" + e10.toString());
            }
        }
    }

    public class LocalReceiver extends BroadcastReceiver {
        public LocalReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundleExtra;
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if ("com.huawei.android.hicloud.intent.SENDCALLBACK".equals(safeIntent.getAction()) || "com.huawei.android.hicloud.intent.INCREMENTSENDCALLBACK".equals(safeIntent.getAction())) {
                try {
                    int intExtra = safeIntent.getIntExtra("msgID", 0);
                    String stringExtra = safeIntent.getStringExtra("msgType");
                    if (intExtra == 0 || (bundleExtra = safeIntent.getBundleExtra("bundle")) == null) {
                        return;
                    }
                    if (intExtra == 10009) {
                        SyncLogicService.SYNC_TYPE_IS_ENDING_MAP.put(stringExtra, Boolean.FALSE);
                    }
                    Message messageObtainMessage = SyncLogicService.this.callbackHandler.obtainMessage();
                    messageObtainMessage.what = 6;
                    messageObtainMessage.obj = bundleExtra;
                    Bundle bundle = new Bundle();
                    bundle.putInt("msgID", intExtra);
                    bundle.putString("msgType", stringExtra);
                    messageObtainMessage.setData(bundle);
                    try {
                        if (SyncLogicService.this.callbackHandlerThread.isAlive()) {
                            SyncLogicService.this.callbackHandler.sendMessage(messageObtainMessage);
                        } else {
                            C11839m.m70689w(SyncLogicService.TAG, "sendMessage error service has destroyed");
                        }
                    } catch (Exception e10) {
                        C11839m.m70687e(SyncLogicService.TAG, "callbackHandler exception:" + e10.getMessage());
                    }
                } catch (Exception e11) {
                    C11839m.m70687e(SyncLogicService.TAG, "onReceive:" + e11.toString());
                }
            }
        }
    }

    private void appendExtraParam(Bundle bundle, Bundle bundle2, int i10) {
        if (bundle2 == null || bundle == null) {
            return;
        }
        if (i10 == 10001) {
            bundle.putBoolean("is_incrementally_query", bundle2.getBoolean("is_incrementally_query", false));
            return;
        }
        if (i10 == 10002) {
            bundle.putBoolean("isCloudDataParticalSuc", bundle2.getBoolean("isCloudDataParticalSuc", false));
            bundle.putSerializable("fail_error_code_map", bundle2.getSerializable("fail_error_code_map"));
        } else if (i10 == 10004) {
            bundle.putBoolean("isCloudDataParticalSuc", bundle2.getBoolean("isCloudDataParticalSuc", false));
            bundle.putInt("cloudDataParticalErrCode", bundle2.getInt("cloudDataParticalErrCode", -1));
        } else {
            if (i10 != 10007) {
                return;
            }
            bundle.putBoolean("fail_error_need_update_sync_result", bundle2.getBoolean("fail_error_need_update_sync_result", false));
        }
    }

    private Bundle buildBatchBundle(int i10, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putByteArray("batches_data_bytes_key", bArr);
        bundle.putBoolean("is_in_batches", true);
        bundle.putBoolean("is_send_over", false);
        return bundle;
    }

    public boolean checkTimeOutExceedMaxTime(String str) throws NumberFormatException {
        long j10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (CloudSyncUtil.m15983W() != null) {
            String str2 = CloudSyncUtil.m15983W().get(str);
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            j10 = Long.parseLong(str2);
        } else {
            j10 = 0;
        }
        long j11 = jCurrentTimeMillis - j10;
        if (j11 < 600000) {
            return false;
        }
        C11839m.m70689w(TAG, "checkTimeOutExceedMaxTime = true, lastTimeOutMsgTime = " + j10 + ", deviation = " + j11);
        return true;
    }

    public void clearReportInfo(String str) {
        SYNC_TYPE_REPORT_SYNC_END_MAP.remove(str);
        C2980i.m17867b(PACKAGE_NAME_SYNC_TYPE_MAP.get(str));
    }

    private void clearSyncTypeMap() {
        SYNC_TYPE_2_REAL_PKG_NAME.clear();
        SYNC_TYPE_2_CALLING_PKG_NAME.clear();
    }

    public static boolean cloudSyncSDKHasCollaborativeAbility(String str) {
        Integer num = SYNC_TYPE_PACKAGE_NAME_MAP.get(str);
        if (num == null) {
            C11839m.m70688i(TAG, "cloudSyncSDKHasCollaborativeAbility error : sdkVersion is null");
            return false;
        }
        C11839m.m70688i(TAG, "syncModulePackageName = " + str + ", sdkVersion = " + num);
        return num.intValue() >= 2;
    }

    public String getCallingPackageName(String str) {
        String callingPackageName = getCallingPackageName();
        if (!TextUtils.isEmpty(callingPackageName)) {
            SYNC_TYPE_2_CALLING_PKG_NAME.put(str, callingPackageName);
        }
        if (!TextUtils.isEmpty(callingPackageName)) {
            return callingPackageName;
        }
        Map<String, String> map = SYNC_TYPE_2_CALLING_PKG_NAME;
        return !map.isEmpty() ? map.get(str) : callingPackageName;
    }

    public String getRealCallingPackageName(Context context, String str) {
        String strM17967L = DriveSyncUtil.m17967L(context);
        if (!TextUtils.isEmpty(strM17967L)) {
            SYNC_TYPE_2_REAL_PKG_NAME.put(str, strM17967L);
        }
        if (!TextUtils.isEmpty(strM17967L)) {
            return strM17967L;
        }
        Map<String, String> map = SYNC_TYPE_2_REAL_PKG_NAME;
        return !map.isEmpty() ? map.get(str) : strM17967L;
    }

    public ReportSyncEndInfo getReportInfo(String str, String str2) {
        Map<String, ReportSyncEndInfo> map = SYNC_TYPE_REPORT_SYNC_END_MAP;
        ReportSyncEndInfo reportSyncEndInfo = map.get(str);
        if (reportSyncEndInfo != null) {
            return reportSyncEndInfo;
        }
        ReportSyncEndInfo reportSyncEndInfo2 = new ReportSyncEndInfo(str2);
        map.put(str, reportSyncEndInfo2);
        return reportSyncEndInfo2;
    }

    public static int getSdkVersion(String str) {
        Integer num = SYNC_TYPE_PACKAGE_NAME_MAP.get(str);
        if (num == null) {
            C11839m.m70688i(TAG, "isSdkSupportIncrementalProcess error: sdkVersion is null");
            return -1;
        }
        C11839m.m70688i(TAG, "getSdkVersion, syncModulePackageName = " + str + ", sdkVersion = " + num);
        return num.intValue();
    }

    public int getSyncRsnForJson(String str) throws JSONException, NumberFormatException {
        int i10 = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 1) {
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    if (jSONObject.has("syncInfo")) {
                        String[] strArrSplit = jSONObject.getString("syncInfo").split("=");
                        if (strArrSplit.length > 1) {
                            i10 = Integer.parseInt(strArrSplit[strArrSplit.length - 1].trim());
                        }
                    }
                }
            } catch (Exception unused) {
                C11839m.m70689w(TAG, "reportSyncRsn error: JSONException");
            }
        }
        C11839m.m70688i(TAG, "getSyncRsnForJson: syncRsn = " + i10);
        return i10;
    }

    private void handleTransParcelDataTooLarge(String str, int i10, Bundle bundle, String str2) {
        C11839m.m70688i(TAG, "handleTranParcelDataTooLarge:  msgID = " + i10);
        byte[] byteDataFromBundle = parseByteDataFromBundle(i10, bundle, str2);
        if (byteDataFromBundle == null || byteDataFromBundle.length <= 0) {
            return;
        }
        int length = byteDataFromBundle.length;
        int i11 = bundle.getInt(MapKeyNames.RESULT_CODE, -1);
        if (length <= 102400) {
            C11839m.m70688i(TAG, "resolveTooLarge: syncType: " + str + ", totalDataLength = " + length);
            byte[] bArr = new byte[102400];
            System.arraycopy(byteDataFromBundle, 0, bArr, 0, 102400);
            Bundle bundleBuildBatchBundle = buildBatchBundle(i11, bArr);
            SystemClock.sleep(200L);
            sendTooLargeCallbackMessage(str, i10, bundleBuildBatchBundle, str2);
            return;
        }
        int i12 = 0;
        int length2 = 0;
        while (length > 0) {
            C11839m.m70688i(TAG, "resolveTooLarge: syncType: " + str + ", times[" + i12 + "] remainLength: " + length);
            byte[] bArr2 = length >= 102400 ? new byte[102400] : new byte[length];
            System.arraycopy(byteDataFromBundle, length2, bArr2, 0, bArr2.length);
            length -= bArr2.length;
            length2 += bArr2.length;
            i12++;
            Bundle bundleBuildBatchBundle2 = buildBatchBundle(i11, bArr2);
            SystemClock.sleep(200L);
            sendTooLargeCallbackMessage(str, i10, bundleBuildBatchBundle2, str2);
        }
    }

    public void initBaseParameter(C10800n c10800n, String str, String str2, String str3, String str4) {
        if (c10800n == null) {
            return;
        }
        c10800n.m65743h("synctype", str);
        c10800n.m65743h("datatype", str2);
        c10800n.m65743h("trace_id_key", str3);
        c10800n.m65743h("sync_moudle_package_name", str4);
        c10800n.m65743h("sync_report_end_info", getReportInfo(str4, str));
        c10800n.m65743h("sync_flow_control_effect_flag", SYNC_FLOW_CONTROL_EFFECTED_MAP);
    }

    private void initFileBackupNativeService() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = C0209d.m1277l1() ? Class.forName("com.hihonor.android.os.FileBackupEx") : Class.forName("com.huawei.android.os.FileBackupEx");
            cls.getMethod("startFileBackup", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "init filebackup native service err : " + e10.toString());
        }
    }

    private void initTimeOutMap() {
        Map<String, Integer> map = SYNC_TYPE_TIME_OUT_MSG_MAP;
        map.put("notepad", 1);
        map.put("calendar", 2);
        map.put("browser", 3);
        map.put("addressbook", 4);
        int i10 = 5;
        map.put("atlas", 5);
        ArrayList<SyncConfigService> arrayList = new ArrayList<>();
        try {
            arrayList = NotifyUtil.getShownSyncServiceItems(this.appContext);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "initTimeOutMap: e = " + e10.toString());
        }
        if (!arrayList.isEmpty()) {
            Iterator<SyncConfigService> it = arrayList.iterator();
            while (it.hasNext()) {
                String id2 = it.next().getId();
                if (!TextUtils.isEmpty(id2)) {
                    i10++;
                    SYNC_TYPE_TIME_OUT_MSG_MAP.put(id2, Integer.valueOf(i10));
                }
            }
        }
        C11839m.m70688i(TAG, "initTimeOutMap: syncTypeTimeOutMsgMap.size = " + SYNC_TYPE_TIME_OUT_MSG_MAP.size());
    }

    public boolean isNeedSendTimeOutMessage(int i10) {
        return i10 == 10001 || i10 == 10002 || i10 == 10004 || i10 == 10008 || i10 == 10007 || i10 == 10003 || i10 == 10012;
    }

    public static boolean isPersistedDataSavedInCloudSyncSDK(String str) {
        Integer num = SYNC_TYPE_PACKAGE_NAME_MAP.get(str);
        if (num == null) {
            C11839m.m70688i(TAG, "isPersistedDataSavedInCloudSyncSDK error : sdkVersion is null");
            return false;
        }
        C11839m.m70688i(TAG, "syncModulePackageName = " + str + ", sdkVersion = " + num);
        return num.intValue() >= 100;
    }

    public static boolean isSdkSupportIncrementalProcess(String str) {
        Integer num = SYNC_TYPE_PACKAGE_NAME_MAP.get(str);
        if (num == null) {
            C11839m.m70688i(TAG, "isSdkSupportIncrementalProcess error: sdkVersion is null");
            return false;
        }
        C11839m.m70688i(TAG, "syncModulePackageName = " + str + ", sdkVersion = " + num);
        return num.intValue() >= 101;
    }

    public static boolean isSdkSupportRecycleProcess(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Integer num = SYNC_TYPE_PACKAGE_NAME_MAP.get(str);
        if (num != null) {
            return num.intValue() >= 104;
        }
        C11839m.m70688i(TAG, "isSdkSupportRecycleProcess error: sdkVersion is null");
        return false;
    }

    public static boolean isServiceSupportRecycleProcess(String str) {
        String str2;
        str.hashCode();
        switch (str) {
            case "addressbook":
                str2 = "reccfg_contacts";
                break;
            case "hinote":
                str2 = "reccfg_hinote";
                break;
            case "notepad":
                str2 = "reccfg_notes";
                break;
            default:
                str2 = "";
                break;
        }
        return C10028c.m62182c0().m62395t1(str2);
    }

    private boolean needSendMessageId(int i10) {
        return i10 == 10009 || i10 == 10015;
    }

    private byte[] parseByteDataFromBundle(int i10, Bundle bundle, String str) {
        byte[] bArr = new byte[0];
        if (bundle.getBoolean("is_in_batches", false)) {
            return bundle.getByteArray("batches_data_bytes_key");
        }
        if (i10 == 10001) {
            return SyncLogicServiceUtil.parseBeginSyncResult(bundle, str);
        }
        if (i10 != 10002) {
            return i10 != 10004 ? i10 != 10005 ? i10 != 10007 ? i10 != 10009 ? i10 != 10017 ? bArr : SyncLogicServiceUtil.parseGetSyncLostListResult(bundle) : SyncLogicServiceUtil.parseEndsyncResult(bundle) : SyncLogicServiceUtil.parseUploadResult(bundle) : SyncLogicServiceUtil.parseDownloadUnstructResult(bundle) : SyncLogicServiceUtil.parseDownloadSaveResult(bundle);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("cdata");
        return parcelableArrayList != null ? SyncLogicServiceUtil.parseQueryCloudData(parcelableArrayList) : bArr;
    }

    private void registerLocalBroadcastReceiver() {
        if (this.mLocalReceiver == null) {
            this.mLocalReceiver = new LocalReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        C13108a.m78878b(this).m78880c(this.mLocalReceiver, intentFilter);
    }

    public void removeSyncTypeMap(String str) {
        SYNC_TYPE_2_REAL_PKG_NAME.remove(str);
        SYNC_TYPE_2_CALLING_PKG_NAME.remove(str);
    }

    public void removeTimeOutMessage(String str) {
        Integer num;
        C11839m.m70688i(TAG, "removeTimeOutMessage syncType = " + str);
        if (str == null || str.isEmpty() || (num = SYNC_TYPE_TIME_OUT_MSG_MAP.get(str)) == null) {
            return;
        }
        this.mHandler.removeMessages(num.intValue());
    }

    private void resolveRemoteEx(String str, int i10, Bundle bundle, String str2) {
        if (CloudSyncUtil.m15942B0(str)) {
            SystemClock.sleep(3000L);
            sendTooLargeCallbackMessage(str, i10, bundle, str2);
        }
    }

    public void sendCallbackMessage(String str, int i10, Bundle bundle, String str2) {
        if (bundle == null) {
            return;
        }
        try {
            sendMessage(str, i10, bundle, str2);
        } catch (TransactionTooLargeException e10) {
            if (SYNC_TYPE_PACKAGE_NAME_MAP.size() <= 0) {
                C11839m.m70689w(TAG, "onReceive TransactionTooLargeException: sdk version is too old, not support trans parcel data.");
                return;
            }
            int iIntValue = SYNC_TYPE_PACKAGE_NAME_MAP.get(str2).intValue();
            C11839m.m70689w(TAG, "onReceive TransactionTooLargeException:" + e10.toString() + ", syncPackageName = " + str2 + ", sdkVersion = " + iIntValue);
            if (iIntValue >= 1) {
                this.isSendMessageInBatches = true;
                handleTransParcelDataTooLarge(str, i10, bundle, str2);
            }
        } catch (RemoteException e11) {
            C11839m.m70687e(TAG, "sendMessage exception:" + e11.toString());
            if (CloudSyncUtil.m15942B0(str)) {
                SystemClock.sleep(3000L);
                sendCallbackMessage(str, i10, bundle, str2);
            }
        }
    }

    private void sendMessage(String str, int i10, Bundle bundle, String str2) throws RemoteException {
        C11839m.m70686d(TAG, "Begin sendMessage , syncType = " + str + " , msgID = " + i10 + ", syncPackageName = " + str2);
        RemoteCallbackList<ISyncServiceCallback> remoteCallbackList = this.mCallbacks.get(str2);
        if (remoteCallbackList == null) {
            C11839m.m70687e(TAG, "callback is null");
            return;
        }
        int iBeginBroadcast = remoteCallbackList.beginBroadcast();
        C11839m.m70686d(TAG, "N = " + iBeginBroadcast);
        for (int i11 = 0; i11 < iBeginBroadcast; i11++) {
            try {
                Boolean bool = SYNC_TYPE_IS_ENDING_MAP.get(str);
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
                C11839m.m70688i(TAG, "handleMessage No:" + i11 + ", isEnding:" + bool + "; MSG content is:" + SyncLogicServiceUtil.getMessageDetial(i10, bundle));
                if (needSendMessageId(i10) || !bool.booleanValue()) {
                    ((ISyncServiceCallback) remoteCallbackList.getBroadcastItem(i11)).handlerEventMsg(i10, 0, 0, bundle);
                }
            } catch (Throwable th2) {
                remoteCallbackList.finishBroadcast();
                throw th2;
            }
        }
        C12767a.m76619c().m76622d(str);
        remoteCallbackList.finishBroadcast();
    }

    public void sendMessageOver(String str, int i10, int i11, String str2, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(MapKeyNames.RESULT_CODE, i11);
            bundle2.putBoolean("is_in_batches", true);
            bundle2.putBoolean("is_send_over", true);
            appendExtraParam(bundle2, bundle, i10);
            sendMessage(str, i10, bundle2, str2);
        } catch (RemoteException e10) {
            C11839m.m70687e(TAG, "sendMessageOver:" + e10.toString());
        }
    }

    public void sendTimeOutMessage(String str, String str2) {
        Integer num;
        C11839m.m70688i(TAG, "sendSDKTimeOutMessage syncType = " + str);
        if (str == null || str.isEmpty() || (num = SYNC_TYPE_TIME_OUT_MSG_MAP.get(str)) == null) {
            return;
        }
        Message message = new Message();
        message.what = num.intValue();
        Bundle bundle = new Bundle();
        bundle.putString("syncType", str);
        bundle.putString("packageName", str2);
        CloudSyncUtil.m15983W().put(str, String.valueOf(System.currentTimeMillis()));
        message.obj = bundle;
        this.mHandler.sendMessageDelayed(message, 600000L);
    }

    private void sendTooLargeCallbackMessage(String str, int i10, Bundle bundle, String str2) {
        if (bundle == null) {
            C11839m.m70689w(TAG, "sendTooLargeCallbackMessage msgBundle is null");
            return;
        }
        try {
            try {
                sendMessage(str, i10, bundle, str2);
            } catch (TransactionTooLargeException unused) {
                C11839m.m70689w(TAG, "sendTooLargeCallbackMessage tooLarge need twice send");
                SystemClock.sleep(400L);
                sendMessage(str, i10, bundle, str2);
            } catch (RemoteException e10) {
                C11839m.m70687e(TAG, "sendTooLargeCallbackMessage remote error:" + e10.toString());
                resolveRemoteEx(str, i10, bundle, str2);
            }
        } catch (RemoteException e11) {
            C11839m.m70687e(TAG, "sendTooLargeCallbackMessage twice remote error:" + e11.toString());
            resolveRemoteEx(str, i10, bundle, str2);
        } catch (Exception e12) {
            C11839m.m70687e(TAG, "sendTooLargeCallbackMessage twice error:" + e12.toString());
        }
    }

    public void syncTransTooLargeFailCallBack(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<String, String> entry : PACKAGE_NAME_SYNC_TYPE_MAP.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value) && str.equals(value)) {
                C11839m.m70687e(TAG, "syncTransTooLargeFailCallBack mSyncType = " + str + ", callPackageName = " + key);
                SyncLogicServiceUtil.syncFailedCallBack(str, key, this.appContext, 2238, i10);
                return;
            }
        }
    }

    private void unregisterLocalReceiver() {
        if (this.mLocalReceiver != null) {
            C13108a.m78878b(this).m78883f(this.mLocalReceiver);
            this.mLocalReceiver = null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70686d(TAG, "service onCreate");
        super.onCreate();
        this.appContext = getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("SYNC_CALLBACK", 10);
        this.callbackHandlerThread = handlerThread;
        handlerThread.start();
        this.callbackHandler = new CallBackHandler(this.callbackHandlerThread.getLooper());
        C12487a.m74966b(this.appContext);
        initFileBackupNativeService();
        registerLocalBroadcastReceiver();
        this.mSettingMgr = C10028c.m62183d0(this.appContext);
        if (SYNC_TYPE_TIME_OUT_MSG_MAP.isEmpty()) {
            initTimeOutMap();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            C11839m.m70688i(TAG, "onDestroy");
            unregisterLocalReceiver();
            this.callbackHandlerThread.quitSafely();
            C12316j0.m74076d().m74087l();
            for (Map.Entry<String, RemoteCallbackList<ISyncServiceCallback>> entry : this.mCallbacks.entrySet()) {
                String key = entry.getKey();
                String str = PACKAGE_NAME_SYNC_TYPE_MAP.get(key);
                removeTimeOutMessage(str);
                if (entry.getValue() != null) {
                    this.mBinder.endSyncByDestroy(str, key, 2204);
                    entry.getValue().kill();
                } else {
                    C11440c.m68542u(str, 2204);
                }
                C2981j.m17895i(key);
            }
            Iterator<Map.Entry<String, Boolean>> it = CloudSyncUtil.m15981V().entrySet().iterator();
            while (it.hasNext()) {
                String key2 = it.next().getKey();
                String str2 = PACKAGE_NAME_SYNC_TYPE_MAP.get(key2);
                C11839m.m70688i(TAG, "onDestroy syncType: " + str2);
                removeTimeOutMessage(str2);
                this.mBinder.endSyncByDestroy(str2, key2, 2204);
            }
            Iterator<Map.Entry<String, RemoteCallbackList<ISyncServiceCallback>>> it2 = this.mCallbacks.entrySet().iterator();
            while (it2.hasNext()) {
                String key3 = it2.next().getKey();
                Map<String, String> map = PACKAGE_NAME_SYNC_TYPE_MAP;
                String str3 = map.get(key3);
                if (SYNC_TYPE_LOST_REFUND_MAP.get(str3) != null) {
                    map.remove(str3);
                }
                clearReportInfo(key3);
            }
            clearSyncTypeMap();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "onDestroy err : " + e10.toString());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 1;
    }

    public class SyncServiceStub extends ISyncService.Stub {
        public SyncServiceStub() {
        }

        private C10800n buildEndSyncParameter(String str, List<String> list, List<String> list2, String str2) {
            C10800n c10800n = new C10800n();
            c10800n.m65743h("synctype", str);
            c10800n.m65743h("datatypelist", list);
            c10800n.m65743h("datatyperesultlist", list2);
            c10800n.m65743h("trace_id_key", SyncLogicService.this.traceIdMap.get(str));
            c10800n.m65743h("sync_moudle_package_name", str2);
            c10800n.m65743h("sync_report_end_info", SyncLogicService.this.getReportInfo(str2, str));
            c10800n.m65743h("sync_flow_control_effect_flag", SyncLogicService.SYNC_FLOW_CONTROL_EFFECTED_MAP);
            return c10800n;
        }

        public void endSyncByDestroy(String str, String str2, int i10) {
            C11839m.m70688i(SyncLogicService.TAG, "endSyncByDestroy, isDestroy = true");
            C10800n c10800nBuildEndSyncParameter = buildEndSyncParameter(str, new ArrayList(), new ArrayList(), str2);
            c10800nBuildEndSyncParameter.m65741f("is_destroy", true);
            endSync(str, c10800nBuildEndSyncParameter, i10);
        }

        public void endSyncByTimeout(String str, List<String> list, List<String> list2, boolean z10, String str2, int i10) {
            C11839m.m70688i(SyncLogicService.TAG, "endSyncByTimeout, isTimeout: " + z10);
            C10800n c10800nBuildEndSyncParameter = buildEndSyncParameter(str, list, list2, str2);
            if (z10) {
                c10800nBuildEndSyncParameter.m65741f("is_timeout", true);
            }
            endSync(str, c10800nBuildEndSyncParameter, i10);
        }

        private void errEndByStartSync(String str, String str2, Context context, int i10, String str3, int i11) {
            if (i11 == 1) {
                SyncLogicServiceUtil.endSyncCallBack(str, str2, SyncLogicService.this.appContext);
            } else {
                SyncLogicServiceUtil.startSyncFailedCallBack(str, str2, SyncLogicService.this.appContext, i10);
            }
            C10812z.m65846o(context, str, i10, str3, "03001", "err_end_before_startsync", C10812z.m65832a("03001"), new LinkedHashMap(C10812z.m65833b(str2)), false);
        }

        private int getIntFromJSONObject(JSONObject jSONObject, String str) throws JSONException {
            if (jSONObject.has(str)) {
                return jSONObject.getInt(str);
            }
            return 0;
        }

        private JSONArray getJSONArrayFromJSONObject(JSONObject jSONObject, String str) throws JSONException {
            if (jSONObject.has(str) && (jSONObject.get(str) instanceof JSONArray)) {
                return jSONObject.getJSONArray(str);
            }
            return null;
        }

        private String getStringFromJSONObject(JSONObject jSONObject, String str) throws JSONException {
            if (jSONObject.has(str)) {
                return jSONObject.getString(str);
            }
            return null;
        }

        private boolean isNeedReleaseLock(String str) {
            Boolean bool;
            if (str == null) {
                return true;
            }
            if (!str.contains(C13843a.m83091m())) {
                return (str.contains("com.android.browser") && (bool = CloudSyncUtil.m15981V().get(C13843a.m83091m())) != null && bool.booleanValue()) ? false : true;
            }
            Boolean bool2 = CloudSyncUtil.m15981V().get("com.android.browser");
            return bool2 == null || !bool2.booleanValue();
        }

        private List<LocalId> parseLocalIdListFromJsonArray(JSONArray jSONArray) throws JSONException {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    if (jSONObject != null) {
                        LocalId localId = new LocalId();
                        localId.setId(jSONObject.getString("id"));
                        localId.setDirty(jSONObject.getInt("dirty"));
                        arrayList.add(localId);
                    }
                }
            }
            return arrayList;
        }

        private void parseSyncDataList(List<SyncDataCompatible> list, String str) {
            if (SyncLogicService.getSdkVersion(str) >= 107 && list != null) {
                for (SyncDataCompatible syncDataCompatible : list) {
                    if (syncDataCompatible != null) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        List<UnstructDataV107> newFileList = syncDataCompatible.getNewFileList();
                        if (newFileList != null) {
                            for (UnstructDataV107 unstructDataV107 : newFileList) {
                                arrayList.add(new UnstructData(unstructDataV107.getId(), unstructDataV107.getName(), unstructDataV107.getUnstructUuid(), unstructDataV107.getHash(), unstructDataV107.getVersion(), unstructDataV107.getOptType()));
                            }
                        }
                        List<UnstructDataV107> newDownFileList = syncDataCompatible.getNewDownFileList();
                        if (newDownFileList != null) {
                            for (UnstructDataV107 unstructDataV1072 : newDownFileList) {
                                arrayList2.add(new UnstructData(unstructDataV1072.getId(), unstructDataV1072.getName(), unstructDataV1072.getUnstructUuid(), unstructDataV1072.getHash(), unstructDataV1072.getVersion(), unstructDataV1072.getOptType()));
                            }
                        }
                        List<UnstructDataV107> newDeleteFileList = syncDataCompatible.getNewDeleteFileList();
                        if (newDeleteFileList != null) {
                            for (UnstructDataV107 unstructDataV1073 : newDeleteFileList) {
                                arrayList3.add(new UnstructData(unstructDataV1073.getId(), unstructDataV1073.getName(), unstructDataV1073.getUnstructUuid(), unstructDataV1073.getHash(), unstructDataV1073.getVersion(), unstructDataV1073.getOptType()));
                            }
                        }
                        syncDataCompatible.setFileList(arrayList);
                        syncDataCompatible.setDownFileList(arrayList2);
                        syncDataCompatible.setDeleteFileList(arrayList3);
                    }
                }
            }
        }

        private List<SyncData> parseSyncDataListFromJSONArray(JSONArray jSONArray, String str) throws JSONException {
            JSONArray jSONArrayFromJSONObject;
            JSONArray jSONArrayFromJSONObject2;
            JSONArray jSONArrayFromJSONObject3;
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject != null) {
                    SyncData syncData = new SyncData();
                    syncData.setLuid(getStringFromJSONObject(jSONObject, SyncProtocol.Constant.LUID));
                    syncData.setGuid(getStringFromJSONObject(jSONObject, SyncProtocol.Constant.GUID));
                    syncData.setUnstructUuid(getStringFromJSONObject(jSONObject, "unstruct_uuid"));
                    syncData.setEtag(getStringFromJSONObject(jSONObject, SyncProtocol.Constant.ETAG));
                    syncData.setData(getStringFromJSONObject(jSONObject, "data"));
                    syncData.setUuid(getStringFromJSONObject(jSONObject, "uuid"));
                    syncData.setStatus(getIntFromJSONObject(jSONObject, "status"));
                    syncData.setHash(getStringFromJSONObject(jSONObject, HicloudH5ConfigManager.KEY_HASH));
                    syncData.setRecycleStatus(getIntFromJSONObject(jSONObject, "recycleStatus"));
                    syncData.setRecycleTime(jSONObject.optLong(SyncProtocol.Constant.RECYCLE_TIME));
                    syncData.setExtensionData(getStringFromJSONObject(jSONObject, "extensionData"));
                    syncData.setExtraParam(getStringFromJSONObject(jSONObject, "extraParam"));
                    if (SyncLogicService.getSdkVersion(str) >= 107) {
                        jSONArrayFromJSONObject = getJSONArrayFromJSONObject(jSONObject, "newDownFileList");
                        jSONArrayFromJSONObject2 = getJSONArrayFromJSONObject(jSONObject, "newDeleteFileList");
                        jSONArrayFromJSONObject3 = getJSONArrayFromJSONObject(jSONObject, "newFileList");
                    } else {
                        jSONArrayFromJSONObject = getJSONArrayFromJSONObject(jSONObject, "downFileList");
                        jSONArrayFromJSONObject2 = getJSONArrayFromJSONObject(jSONObject, "deleteFileList");
                        jSONArrayFromJSONObject3 = getJSONArrayFromJSONObject(jSONObject, "filelist");
                    }
                    syncData.setDownFileList(parseUnstructDataListFromJSONArray(jSONArrayFromJSONObject));
                    syncData.setDeleteFileList(parseUnstructDataListFromJSONArray(jSONArrayFromJSONObject2));
                    syncData.setFileList(parseUnstructDataListFromJSONArray(jSONArrayFromJSONObject3));
                    arrayList.add(syncData);
                }
            }
            return arrayList;
        }

        private List<UnstructData> parseUnstructDataListFromJSONArray(JSONArray jSONArray) throws JSONException {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject != null) {
                    UnstructData unstructData = new UnstructData();
                    unstructData.setId(getStringFromJSONObject(jSONObject, "id"));
                    unstructData.setUnstructUuid(getStringFromJSONObject(jSONObject, "unstruct_uuid"));
                    unstructData.setName(getStringFromJSONObject(jSONObject, "name"));
                    unstructData.setHash(getStringFromJSONObject(jSONObject, HicloudH5ConfigManager.KEY_HASH));
                    unstructData.setVersion(getIntFromJSONObject(jSONObject, "version"));
                    unstructData.setOptType(getIntFromJSONObject(jSONObject, "optType"));
                    arrayList.add(unstructData);
                }
            }
            return arrayList;
        }

        private void processNetNotConnected(String str) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(SyncLogicService.this.appContext, "sync_contact_spfile", 0).edit();
            editorEdit.putInt(str + "sync_retcode", 19);
            editorEdit.commit();
            if ("addressbook".equals(str)) {
                CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END", "addressbook");
            } else if ("wlan".equals(str)) {
                CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END", "wlan");
            }
        }

        private void startSync(String str, String str2, C10800n c10800n, int i10, boolean z10, String str3, String str4) {
            String strM65832a;
            Map map = SyncLogicService.SYNC_TYPE_IS_ENDING_MAP;
            Boolean bool = Boolean.FALSE;
            map.put(str, bool);
            if (i10 == 1) {
                C2980i.m17870e(SyncLogicService.this.appContext, str, SyncLogicService.this.getReportInfo(str3, str));
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            if (CloudSyncUtil.m16060y0(str)) {
                C11839m.m70689w(SyncLogicService.TAG, str + ":data is restoring before startSync");
                errEndByStartSync(str, str3, SyncLogicService.this.appContext, 2206, "data is restoring before startSync", i10);
                return;
            }
            if (!C0209d.m1208S0(SyncLogicService.this.appContext)) {
                processNetNotConnected(str);
                C11839m.m70689w(SyncLogicService.TAG, str + ":net is not available before startSync");
                errEndByStartSync(str, str3, SyncLogicService.this.appContext, 2028, "net is not available before startSync", i10);
                return;
            }
            if (i10 == 1 && CloudSyncUtil.m15962L0(str3, str)) {
                C11839m.m70689w(SyncLogicService.TAG, str + ":exsist syncing before startSync");
                errEndByStartSync(str, str3, SyncLogicService.this.appContext, 2026, "exsist syncing before startSync", i10);
                return;
            }
            if (!z10 && str3 != null && str3.contains(C13843a.m83091m())) {
                C11839m.m70689w(SyncLogicService.TAG, str + ":Huawei browser use old sync interface");
                errEndByStartSync(str, str3, SyncLogicService.this.appContext, 2261, "Huawei browser use old sync interface", i10);
                return;
            }
            if (CloudSyncUtil.m15965N() == 1) {
                C11839m.m70689w(SyncLogicService.TAG, str + ":Server Control Reset before startSync");
                errEndByStartSync(str, str3, SyncLogicService.this.appContext, 2029, "Server Control Reset before startSync", i10);
                return;
            }
            if (i10 == 1 && C2786g.m16219h(SyncLogicService.this.appContext, str, C0240y.m1681c(SyncLogicService.this.appContext, str4))) {
                C11839m.m70689w(SyncLogicService.TAG, str + ":syncFlowControlPolicy effect before startSync");
                errEndByStartSync(str, str3, SyncLogicService.this.appContext, 2268, "syncFlowControlPolicy effect before startSync", i10);
                return;
            }
            if (i10 == 1) {
                SyncLogicService.PACKAGE_NAME_SYNC_TYPE_MAP.put(str3, str);
                SyncLogicService.SYNC_FLOW_CONTROL_EFFECTED_MAP.put(str, bool);
                if (!C10812z.m65835d(str3)) {
                    String strM1681c = C0240y.m1681c(SyncLogicService.this.appContext, str4);
                    C11839m.m70688i(SyncLogicService.TAG, "calling packageName: " + str4 + " versionName: " + strM1681c);
                    C10812z.m65848q(str3, strM1681c, str4);
                }
                strM65832a = C10812z.m65832a("03001");
                SyncLogicService.this.traceIdMap.put(str, strM65832a);
                CloudSyncUtil.m16026l1(str, 0);
                if (str3 != null && SyncLogicService.this.syncRsnMap.containsKey(str3)) {
                    C12515a.m75110o().m75172d(new C13746i(SyncLogicService.this.appContext, str, str3, (String) SyncLogicService.this.syncRsnMap.get(str3), "03001", "", (String) SyncLogicService.this.traceIdMap.get(str)));
                }
                C2980i.m17885t(SyncLogicService.this.appContext, str, SyncLogicService.this.getReportInfo(str3, str), str4);
                C2980i.m17880o(SyncLogicService.this.getReportInfo(str3, str), str, (String) SyncLogicService.this.syncRsnMap.get(str3));
                C2980i.m17884s(SyncLogicService.this.getReportInfo(str3, str), strM65832a);
                C2980i.m17886u(SyncLogicService.this.getReportInfo(str3, str), str3);
            } else {
                strM65832a = (String) SyncLogicService.this.traceIdMap.get(str);
            }
            C11839m.m70688i(SyncLogicService.TAG, "startSync syncType = " + str + ", dataType = " + str2 + ", traceId = " + strM65832a);
            SyncLogicService.SYNC_TYPE_LOST_REFUND_MAP.put(str, new C12329u(SyncLogicService.this.appContext, str, str2, "03001", strM65832a, str3, SyncLogicService.SYNC_FLOW_CONTROL_EFFECTED_MAP));
            C12487a.m74966b(SyncLogicService.this.appContext);
            SyncLogicService.this.initBaseParameter(c10800n, str, str2, strM65832a, str3);
            c10800n.m65743h(NotifyConstants.NotificationReport.KEY_ORDER, Integer.valueOf(i10));
            SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000007, c10800n), str);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            CloudSyncUtil.m15981V().put(str3, Boolean.TRUE);
        }

        private ArrayList<String> string2Arrays(String str) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (str != null && str.length() > 1) {
                String strSubstring = str.substring(1, str.length() - 1);
                if (strSubstring.length() == 0) {
                    return arrayList;
                }
                for (String str2 : strSubstring.split(",")) {
                    arrayList.add(str2.trim());
                }
            }
            return arrayList;
        }

        private void uploadData(String str, String str2, List<? extends SyncData> list, List<? extends SyncData> list2, List<? extends SyncData> list3, List<String> list4, C10800n c10800n, boolean z10, String str3) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "uploadData");
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            C12487a.m74966b(SyncLogicService.this.appContext);
            SyncLogicService syncLogicService = SyncLogicService.this;
            syncLogicService.initBaseParameter(c10800n, str, str2, (String) syncLogicService.traceIdMap.get(str), str3);
            c10800n.m65743h("addList", list);
            c10800n.m65743h("modifyList", list2);
            c10800n.m65743h("deleteList", list4);
            c10800n.m65743h("lostRefundList", list3);
            c10800n.m65743h("havefile", Boolean.valueOf(z10));
            SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000009, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void checkRisk(String str, String str2, int i10, int i11, int i12) {
            C11839m.m70688i(SyncLogicService.TAG, "checkRisk syncType = " + str);
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "checkRisk not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            C10800n c10800n = new C10800n();
            SyncLogicService syncLogicService2 = SyncLogicService.this;
            syncLogicService2.initBaseParameter(c10800n, str, str2, (String) syncLogicService2.traceIdMap.get(str), callingPackageName);
            c10800n.m65743h("data_add_key", Integer.valueOf(i10));
            c10800n.m65743h("data_del_key", Integer.valueOf(i11));
            c10800n.m65743h("data_upd_key", Integer.valueOf(i12));
            SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000024, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public int doAutoSyncContact(SyncType syncType) {
            C11839m.m70688i(SyncLogicService.TAG, "doAutoSyncContact");
            if (!C0209d.m1208S0(SyncLogicService.this.appContext)) {
                C11839m.m70689w(SyncLogicService.TAG, "net is not available");
                processNetNotConnected("addressbook");
                return -4;
            }
            if (CloudSyncUtil.m15965N() == 1) {
                C11839m.m70689w(SyncLogicService.TAG, "Server Control Reset");
                return -13;
            }
            if (SyncLogicService.this.mSettingMgr.m62388s("addressbook") && !C11440c.m68534l("addressbook")) {
                C10800n c10800n = new C10800n();
                c10800n.m65743h("BackupModuleArray", new String[]{"addressbook"});
                c10800n.m65743h("synctype", syncType);
                c10800n.m65743h("synauto", Boolean.FALSE);
                c10800n.m65743h("sync_report_end_info", new ReportSyncEndInfo());
                SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000004, c10800n), "addressbook");
                HiCloudNotification.getInstance().executeFromDataUse();
                C2986o.m17946c(SyncLogicService.this.appContext, "com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
            }
            return -4;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public int doAutoSyncWlan(int i10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "doAutoSyncWlan");
            if (!C0209d.m1208S0(SyncLogicService.this.appContext)) {
                C11839m.m70689w(SyncLogicService.TAG, "net is not available");
                processNetNotConnected("wlan");
                return -4;
            }
            if (CloudSyncUtil.m15965N() == 1) {
                C11839m.m70689w(SyncLogicService.TAG, "Server Control Reset");
                return -13;
            }
            if (SyncLogicService.this.mSettingMgr.m62388s("wlan") && !C11440c.m68534l("wlan")) {
                ConcurrentHashMap concurrentHashMap = SyncLogicService.SYNC_FLOW_CONTROL_EFFECTED_MAP;
                Boolean bool = Boolean.FALSE;
                concurrentHashMap.put("wlan", bool);
                C10800n c10800n = new C10800n();
                c10800n.m65743h("BackupModuleArray", new String[]{"wlan"});
                c10800n.m65743h("synctype", Integer.valueOf(i10));
                c10800n.m65743h("synauto", bool);
                c10800n.m65743h("sync_report_end_info", new ReportSyncEndInfo());
                c10800n.m65743h("sync_flow_control_effect_flag", SyncLogicService.SYNC_FLOW_CONTROL_EFFECTED_MAP);
                SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000005, c10800n), "wlan");
                HiCloudNotification.getInstance().executeFromDataUse();
                C2986o.m17946c(SyncLogicService.this.appContext, "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
            }
            return -4;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void downUnstructFile(String str, String str2, List<UnstructData> list) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "downUnstructFile");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "downUnstructFile not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            C12487a.m74966b(SyncLogicService.this.appContext);
            C10800n c10800n = new C10800n();
            SyncLogicService.this.initBaseParameter(c10800n, str, str2, C10812z.m65832a("03001"), callingPackageName);
            c10800n.m65743h("unstructlist", list);
            SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000013, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "downUnstructFileForTransTooLarge not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (z10) {
                    downUnstructFile(str, str2, parseUnstructDataListFromJSONArray(new JSONArray(SyncLogicService.this.batchesBuffer.toString())));
                    SyncLogicService.this.batchesBuffer = new StringBuffer();
                } else {
                    SyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(SyncLogicService.TAG, "downUnstructFileForTransTooLarge:" + th2.toString());
                SyncLogicService.this.syncTransTooLargeFailCallBack(str, 10005);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void endSync(String str, List<String> list, List<String> list2) throws RemoteException {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                endSyncByTimeout(str, list, list2, false, callingPackageName, 2027);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "endSync not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void endSyncForTransTooLarge(String str, byte[] bArr, boolean z10) throws RemoteException {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "endSyncForTransTooLarge not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (!z10) {
                    SyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                    return;
                }
                JSONObject jSONObject = new JSONObject(SyncLogicService.this.batchesBuffer.toString());
                ArrayList<String> arrayListString2Arrays = string2Arrays(jSONObject.getString("dataTypeList"));
                ArrayList<String> arrayListString2Arrays2 = string2Arrays(jSONObject.getString("dataTypeResultList"));
                if (jSONObject.has("dataTypeCtagList")) {
                    endSyncV100(str, arrayListString2Arrays, arrayListString2Arrays2, string2Arrays(jSONObject.getString("dataTypeCtagList")));
                } else {
                    endSync(str, arrayListString2Arrays, arrayListString2Arrays2);
                }
                SyncLogicService.this.batchesBuffer = new StringBuffer();
            } catch (Throwable th2) {
                C11839m.m70687e(SyncLogicService.TAG, "downUnstructFileForTransTooLarge:" + th2.toString());
                SyncLogicService.this.syncTransTooLargeFailCallBack(str);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void endSyncV100(String str, List<String> list, List<String> list2, List<String> list3) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "endSyncV100");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C10800n c10800nBuildEndSyncParameter = buildEndSyncParameter(str, list, list2, callingPackageName);
                c10800nBuildEndSyncParameter.m65743h("data_type_ctag_list", list3);
                endSync(str, c10800nBuildEndSyncParameter, 2027);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "endSyncV100 not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void getExceedLimitNum(String str, List<String> list) {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "getExceedLimitNum not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C11839m.m70688i(SyncLogicService.TAG, "getExceedLimitNum syncType = " + str + ", dateTypes = " + list.toString() + ", packageName = " + callingPackageName);
            C10800n c10800n = new C10800n();
            c10800n.m65743h("synctype", str);
            c10800n.m65743h("sync_moudle_package_name", callingPackageName);
            c10800n.m65743h("sync_module_real_package_name", realCallingPackageName);
            c10800n.m65743h("datatypelist", list);
            c10800n.m65743h("trace_id_key", C10812z.m65832a("03001"));
            SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000025, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public int getHisyncNewVersion() throws RemoteException {
            return 107;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public int getHisyncVersionCode() throws RemoteException {
            return 2;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void getStructData(String str, String str2, List<String> list) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "getStructData");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "getStructData not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            C12487a.m74966b(SyncLogicService.this.appContext);
            C10800n c10800n = new C10800n();
            SyncLogicService syncLogicService2 = SyncLogicService.this;
            syncLogicService2.initBaseParameter(c10800n, str, str2, (String) syncLogicService2.traceIdMap.get(str), callingPackageName);
            c10800n.m65743h("guidList", list);
            c10800n.m65743h("isSdkSupportDownPartical", SyncLogicService.SYNC_SDK_SUPPORT_DOWN_PARTICAL_SUC_MAP.get(callingPackageName));
            SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000008, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void getStructDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "getStructDataForTransTooLarge not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (z10) {
                    getStructData(str, str2, string2Arrays(SyncLogicService.this.batchesBuffer.toString()));
                    SyncLogicService.this.batchesBuffer = new StringBuffer();
                } else {
                    SyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(SyncLogicService.TAG, "getStructDataForTransTooLarge:" + th2.toString());
                SyncLogicService.this.syncTransTooLargeFailCallBack(str, 10002);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void getSyncLostList(String str, String str2) {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "getSyncLostList not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C11839m.m70688i(SyncLogicService.TAG, "getSyncLostList: syncType = " + str + ", dateTypes = " + str2 + ", packageName = " + callingPackageName);
            C10800n c10800n = new C10800n();
            SyncLogicService syncLogicService2 = SyncLogicService.this;
            syncLogicService2.initBaseParameter(c10800n, str, str2, (String) syncLogicService2.traceIdMap.get(str), callingPackageName);
            c10800n.m65743h("sync_moudle_lost_refund_impl", SyncLogicService.SYNC_TYPE_LOST_REFUND_MAP.get(str));
            SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000016, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void notifyMsg(String str, String str2, String str3) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "notifyMsg syncType = " + str + ", dataType = " + str2 + ", msg = " + str3);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "notifyMsg not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            try {
                SyncLogicService.SYNC_AFTER_DOWN_PARTICAL_SUC_MAP.remove(callingPackageName);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                SyncLogicService.SYNC_AFTER_DOWN_PARTICAL_SUC_MAP.put(callingPackageName, str3);
            } catch (Exception e10) {
                C11839m.m70687e(SyncLogicService.TAG, "notifyMsg err " + e10.getMessage());
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void notifySyncModel(String str, String str2, int i10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "notifySyncModel syncType = " + str + ", dataType = " + str2 + ", syncModel = " + i10);
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C2981j.m17896j(callingPackageName, str2, 0);
                C2981j.m17896j(callingPackageName, str2, i10);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "notifySyncModel not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "registerCallback");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "registerCallback not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return false;
            }
            C12767a.m76619c().m76622d(str);
            if (iSyncServiceCallback == null) {
                C11839m.m70688i(SyncLogicService.TAG, "cb is null");
                return false;
            }
            if (((RemoteCallbackList) SyncLogicService.this.mCallbacks.get(callingPackageName)) == null) {
                RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
                C11839m.m70688i(SyncLogicService.TAG, "callback is null , result = " + remoteCallbackList.register(iSyncServiceCallback));
                SyncLogicService.this.mCallbacks.put(callingPackageName, remoteCallbackList);
                return true;
            }
            SyncLogicService.this.mCallbacks.remove(callingPackageName);
            RemoteCallbackList remoteCallbackList2 = new RemoteCallbackList();
            C11839m.m70688i(SyncLogicService.TAG, "callback is not null , result = " + remoteCallbackList2.register(iSyncServiceCallback));
            SyncLogicService.this.mCallbacks.put(callingPackageName, remoteCallbackList2);
            return true;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void reportEvent(String str, String str2) throws RemoteException {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C12767a.m76619c().m76622d(str);
                reportInfo(str, str2);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "reportEvent not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void reportInfo(String str, String str2) {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C12767a.m76619c().m76622d(str);
                C12515a.m75110o().m75172d(new C13746i(SyncLogicService.this.appContext, str, callingPackageName, str2, "03001", "", (String) SyncLogicService.this.traceIdMap.get(str)));
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "reportInfo not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void reportSDKVersionCode(int i10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "reportSDKVersionCode sdkVersionCode = " + i10);
            String callingPackageName = SyncLogicService.this.getCallingPackageName();
            if (callingPackageName != null) {
                SyncLogicService.SYNC_TYPE_PACKAGE_NAME_MAP.put(callingPackageName, Integer.valueOf(i10));
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void reportSyncInfo(String str, String str2, String str3, String str4, String str5) throws JSONException {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            C11839m.m70688i(SyncLogicService.TAG, "reportSyncInfo appId: " + str2 + " packageName:" + realCallingPackageName + " versionName:" + str4 + " extendInfo: " + str5);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "reportSyncInfo not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            if (TextUtils.isEmpty(callingPackageName)) {
                C11839m.m70687e(SyncLogicService.TAG, "reportSyncInfo callingPackageName null");
                return;
            }
            if (!TextUtils.isEmpty(realCallingPackageName)) {
                C10812z.m65849r(callingPackageName, str2, C0240y.m1681c(SyncLogicService.this.appContext, realCallingPackageName), realCallingPackageName);
            }
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str5);
                if (jSONObject.has("syncRsn")) {
                    JSONObject jSONObject2 = new JSONObject();
                    int iOptInt = jSONObject.optInt("syncRsn", -1);
                    jSONObject2.putOpt("syncRsn", Integer.valueOf(iOptInt));
                    SyncLogicService.this.syncRsnMap.put(callingPackageName, jSONObject2.toString());
                    if ("addressbook".equals(str)) {
                        CloudSyncUtil.m15990Z0(str, iOptInt);
                    }
                }
                SyncLogicService.this.syncRsnMap.put(callingPackageName, str5);
                if (jSONObject.has("isSdkSupportDownPartical")) {
                    SyncLogicService.SYNC_SDK_SUPPORT_DOWN_PARTICAL_SUC_MAP.remove(callingPackageName);
                    SyncLogicService.SYNC_SDK_SUPPORT_DOWN_PARTICAL_SUC_MAP.put(callingPackageName, Boolean.valueOf(jSONObject.getBoolean("isSdkSupportDownPartical")));
                }
            } catch (Exception e10) {
                C11839m.m70687e(SyncLogicService.TAG, "reportSyncInfo json error " + e10.getMessage());
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void reportSyncRsn(String str, String str2, String str3, String str4) {
            C11839m.m70688i(SyncLogicService.TAG, "reportSyncRsn packageName = " + str2 + ", versionName = " + str3 + ", reportJson = " + str4);
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "reportSyncRsn not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            if (CloudSyncUtil.m15962L0(callingPackageName, str)) {
                C11839m.m70687e(SyncLogicService.TAG, "reportSyncRsn " + str + " is Syncing...");
                return;
            }
            if (!TextUtils.isEmpty(callingPackageName) && !TextUtils.isEmpty(realCallingPackageName) && !C10812z.m65835d(callingPackageName)) {
                C10812z.m65848q(callingPackageName, C0240y.m1681c(SyncLogicService.this.appContext, realCallingPackageName), realCallingPackageName);
            }
            if (TextUtils.isEmpty(callingPackageName) || TextUtils.isEmpty(str4)) {
                return;
            }
            SyncLogicService.this.syncRsnMap.put(callingPackageName, str4);
            if ("addressbook".equals(str)) {
                CloudSyncUtil.m15990Z0(str, SyncLogicService.this.getSyncRsnForJson(str4));
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void saveSyncResult(String str, String str2, List<SyncData> list, List<String> list2, boolean z10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "saveSyncResult");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "saveSyncResult not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            C12487a.m74966b(SyncLogicService.this.appContext);
            C10800n c10800n = new C10800n();
            SyncLogicService syncLogicService2 = SyncLogicService.this;
            syncLogicService2.initBaseParameter(c10800n, str, str2, (String) syncLogicService2.traceIdMap.get(str), callingPackageName);
            c10800n.m65743h("saveresult", list);
            c10800n.m65743h("deleteList", list2);
            c10800n.m65743h("isupload", Boolean.valueOf(z10));
            c10800n.m65743h("isCloudDataParticalSuc", SyncLogicService.SYNC_AFTER_DOWN_PARTICAL_SUC_MAP.get(callingPackageName));
            SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000010, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void saveSyncResultForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "saveSyncResultForTransTooLarge not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (z11) {
                    JSONObject jSONObject = new JSONObject(SyncLogicService.this.batchesBuffer.toString());
                    saveSyncResult(str, str2, parseSyncDataListFromJSONArray(jSONObject.optJSONArray("saveData"), callingPackageName), string2Arrays(jSONObject.optString("deleteList")), z10);
                    SyncLogicService.this.batchesBuffer = new StringBuffer();
                } else {
                    SyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(SyncLogicService.TAG, "saveSyncResultForTransTooLarge:" + th2.toString());
                SyncLogicService.this.syncTransTooLargeFailCallBack(str, 10004);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void startSyncForTransTooLarge(String str, String str2, byte[] bArr, int i10, boolean z10) throws RemoteException {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "startSyncForTransTooLarge not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (z10) {
                    startSync(str, str2, parseLocalIdListFromJsonArray(new JSONArray(SyncLogicService.this.batchesBuffer.toString())), i10);
                    SyncLogicService.this.batchesBuffer = new StringBuffer();
                } else {
                    SyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(SyncLogicService.TAG, "startSyncForTransTooLarge:" + th2.toString());
                SyncLogicService.this.syncTransTooLargeFailCallBack(str, 10001);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void startSyncV100(String str, String str2, String str3, int i10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "startSyncV100 syncType = " + str + ", dataType = " + str2);
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C10800n c10800n = new C10800n();
                c10800n.m65743h("data_type_local_ctag_value", str3);
                startSync(str, str2, c10800n, i10, true, callingPackageName, realCallingPackageName);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "startSyncV100 not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void startSyncV101(String str, String str2, List<CtagInfoCompatible> list, int i10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "startSyncV101 syncType = " + str + ", dataType = " + str2);
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C10800n c10800n = new C10800n();
                c10800n.m65743h("data_type_local_ctag_info", list);
                startSync(str, str2, c10800n, i10, true, callingPackageName, realCallingPackageName);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "startSyncV101 not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str) {
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "unregisterCallback not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            if (iSyncServiceCallback != null) {
                C11839m.m70688i(SyncLogicService.TAG, "unregister callback");
                if (SyncLogicService.this.mCallbacks.get(callingPackageName) != null) {
                    if (CloudSyncUtil.m15962L0(callingPackageName, str)) {
                        C11440c.m68542u(str, 2207);
                        endSync(str, buildEndSyncParameter(str, new ArrayList(), new ArrayList(), callingPackageName), 2207);
                    }
                    ((RemoteCallbackList) SyncLogicService.this.mCallbacks.get(callingPackageName)).unregister(iSyncServiceCallback);
                    SyncLogicService.this.mCallbacks.remove(callingPackageName);
                    SyncLogicService.this.removeSyncTypeMap(str);
                    SyncLogicService.this.clearReportInfo(callingPackageName);
                }
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void updateCtag(String str, String str2) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "updateCtag");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "downUnstructFileForTransTooLarge not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            C12487a.m74966b(SyncLogicService.this.appContext);
            C10800n c10800n = new C10800n();
            SyncLogicService syncLogicService2 = SyncLogicService.this;
            syncLogicService2.initBaseParameter(c10800n, str, str2, (String) syncLogicService2.traceIdMap.get(str), callingPackageName);
            SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000012, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "uploadDataForTransTooLarge");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                uploadDataTooLarge(str, str2, bArr, z10, z11, false, callingPackageName);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "uploadDataForTransTooLarge not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        public void uploadDataTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11, boolean z12, String str3) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "uploadDataTooLarge: isV100 = " + z12);
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            List<UnstructData> arrayList = new ArrayList<>();
            try {
                if (!z11) {
                    SyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                    return;
                }
                JSONObject jSONObject = new JSONObject(SyncLogicService.this.batchesBuffer.toString());
                JSONArray jSONArray = jSONObject.getJSONArray(SyncProtocol.Constant.ADD);
                JSONArray jSONArray2 = jSONObject.getJSONArray("modify");
                if (z12) {
                    arrayList = parseUnstructDataListFromJSONArray(jSONObject.getJSONArray("localFile"));
                }
                List<UnstructData> list = arrayList;
                String string = jSONObject.getString("delete");
                List<SyncData> syncDataListFromJSONArray = parseSyncDataListFromJSONArray(jSONArray, str3);
                List<SyncData> syncDataListFromJSONArray2 = parseSyncDataListFromJSONArray(jSONArray2, str3);
                ArrayList<String> arrayListString2Arrays = string2Arrays(string);
                if (z12) {
                    uploadDataV102(str, str2, syncDataListFromJSONArray, syncDataListFromJSONArray2, list, arrayListString2Arrays, z10);
                } else {
                    uploadData(str, str2, syncDataListFromJSONArray, syncDataListFromJSONArray2, arrayListString2Arrays, z10);
                }
                SyncLogicService.this.batchesBuffer = new StringBuffer();
            } catch (Throwable th2) {
                C11839m.m70687e(SyncLogicService.TAG, "uploadDataForTransTooLarge:" + th2.toString());
                SyncLogicService.this.syncTransTooLargeFailCallBack(str, 10003);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataV102(String str, String str2, List<SyncData> list, List<SyncData> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "uploadDataV102");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C10800n c10800n = new C10800n();
                c10800n.m65743h("local_file_list", list3);
                uploadData(str, str2, list, list2, new ArrayList(), list4, c10800n, z10, callingPackageName);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "uploadDataV102 not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataV102ForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "uploadDataV102ForTransTooLarge");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                uploadDataTooLarge(str, str2, bArr, z10, z11, true, callingPackageName);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "uploadDataV102ForTransTooLarge not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataV104(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "uploadDataV104");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C10800n c10800n = new C10800n();
                c10800n.m65743h("local_file_list", list3);
                parseSyncDataList(list, callingPackageName);
                parseSyncDataList(list2, callingPackageName);
                uploadData(str, str2, list, list2, new ArrayList(), list4, c10800n, z10, callingPackageName);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "uploadDataV104 not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataWithLost(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<String> list3, List<SyncDataCompatible> list4, boolean z10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "uploadDataWithLost: lost = " + list4.size());
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C10800n c10800n = new C10800n();
                parseSyncDataList(list, callingPackageName);
                parseSyncDataList(list2, callingPackageName);
                parseSyncDataList(list4, callingPackageName);
                c10800n.m65743h("sync_moudle_lost_refund_impl", SyncLogicService.SYNC_TYPE_LOST_REFUND_MAP.get(str));
                uploadData(str, str2, list, list2, list4, list3, c10800n, z10, callingPackageName);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "uploadDataWithLost not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataWithLostForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "uploadDataWithLostForTransTooLarge");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                uploadDataWithLostTooLarge(str, str2, bArr, z10, z11, callingPackageName);
                return;
            }
            C11839m.m70689w(SyncLogicService.TAG, "uploadDataWithLostForTransTooLarge not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
            SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
        }

        public void uploadDataWithLostTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11, String str3) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "uploadDataWithLostTooLarge");
            C12767a.m76619c().m76622d(str);
            SyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (z11) {
                    JSONObject jSONObject = new JSONObject(SyncLogicService.this.batchesBuffer.toString());
                    JSONArray jSONArray = jSONObject.getJSONArray(SyncProtocol.Constant.ADD);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("modify");
                    String string = jSONObject.getString("delete");
                    JSONArray jSONArray3 = jSONObject.getJSONArray("lost");
                    List<SyncData> syncDataListFromJSONArray = parseSyncDataListFromJSONArray(jSONArray, str3);
                    List<SyncData> syncDataListFromJSONArray2 = parseSyncDataListFromJSONArray(jSONArray2, str3);
                    ArrayList<String> arrayListString2Arrays = string2Arrays(string);
                    List<SyncData> syncDataListFromJSONArray3 = parseSyncDataListFromJSONArray(jSONArray3, str3);
                    C10800n c10800n = new C10800n();
                    c10800n.m65743h("sync_moudle_lost_refund_impl", SyncLogicService.SYNC_TYPE_LOST_REFUND_MAP.get(str));
                    uploadData(str, str2, syncDataListFromJSONArray, syncDataListFromJSONArray2, syncDataListFromJSONArray3, arrayListString2Arrays, c10800n, z10, str3);
                    SyncLogicService.this.batchesBuffer = new StringBuffer();
                } else {
                    SyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(SyncLogicService.TAG, "uploadDataWithLostTooLarge:" + th2.toString());
                SyncLogicService.this.syncTransTooLargeFailCallBack(str, 10003);
            }
        }

        private void endSync(String str, C10800n c10800n, int i10) {
            SyncLogicService.SYNC_TYPE_IS_ENDING_MAP.put(str, Boolean.TRUE);
            C12767a.m76619c().m76622d(str);
            String strM65740e = c10800n.m65740e("sync_moudle_package_name", "");
            if (TextUtils.isEmpty(strM65740e)) {
                strM65740e = SyncLogicService.this.getCallingPackageName(str);
            }
            C11839m.m70688i(SyncLogicService.TAG, "endSync: syncType = " + str + ", callingPackageName = " + strM65740e);
            if (!CloudSyncUtil.m15981V().containsKey(strM65740e)) {
                C11839m.m70689w(SyncLogicService.TAG, "endSync: not have syncTask, callingPackageName = " + strM65740e);
                SyncLogicServiceUtil.endSyncCallBack(str, strM65740e, SyncLogicService.this.appContext);
                return;
            }
            SyncLogicService.this.removeTimeOutMessage(str);
            C12487a.m74966b(SyncLogicService.this.appContext);
            C11440c.m68542u(str, i10);
            if (isNeedReleaseLock(strM65740e)) {
                SyncLogicService.this.mDispatcher.m18035b(new C11442e(55000011, c10800n), str);
            } else {
                C11839m.m70689w(SyncLogicService.TAG, "Don't need release lock, end sync with do nothing...");
                SyncLogicServiceUtil.endSyncCallBack(str, strM65740e, SyncLogicService.this.appContext);
            }
            CloudSyncUtil.m15981V().remove(strM65740e);
            SyncLogicService.SYNC_TYPE_LOST_REFUND_MAP.remove(str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadData(String str, String str2, List<SyncData> list, List<SyncData> list2, List<String> list3, boolean z10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "uploadData");
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "uploadData not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            uploadData(str, str2, list, list2, new ArrayList(), list3, new C10800n(), z10, callingPackageName);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void startSync(String str, String str2, List<LocalId> list, int i10) throws RemoteException {
            C11839m.m70688i(SyncLogicService.TAG, "startSync syncType = " + str + ", dataType = " + str2);
            SyncLogicService syncLogicService = SyncLogicService.this;
            String realCallingPackageName = syncLogicService.getRealCallingPackageName(syncLogicService.appContext, str);
            String callingPackageName = SyncLogicService.this.getCallingPackageName(str);
            if (!DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70689w(SyncLogicService.TAG, "startSync not avabliable, syncType = " + str + ", realPkgName = " + realCallingPackageName);
                SyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, SyncLogicService.this.appContext);
                return;
            }
            C10800n c10800n = new C10800n();
            c10800n.m65743h("localid", list);
            startSync(str, str2, c10800n, i10, false, callingPackageName, realCallingPackageName);
        }
    }

    public String getCallingPackageName() {
        PackageManager packageManager;
        String nameForUid = "";
        try {
            Context context = this.appContext;
            if (context != null && (packageManager = context.getPackageManager()) != null) {
                nameForUid = packageManager.getNameForUid(Binder.getCallingUid());
            }
            C11839m.m70688i(TAG, "getCallingPackageName: callingAppPackageName = " + nameForUid);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getCallingPackageName error: " + e10.getMessage());
        }
        return nameForUid;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean isServiceSupportRecycleProcess(Context context, String str, String str2) throws Throwable {
        str.hashCode();
        boolean z10 = true;
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1376863011:
                if (str.equals("addressbook")) {
                    c10 = 0;
                    break;
                }
                break;
            case -178324674:
                if (str.equals("calendar")) {
                    c10 = 1;
                    break;
                }
                break;
            case 3652034:
                if (str.equals("wlan")) {
                    c10 = 2;
                    break;
                }
                break;
            case 93144203:
                if (str.equals("atlas")) {
                    c10 = 3;
                    break;
                }
                break;
            case 150940456:
                if (str.equals("browser")) {
                    c10 = 4;
                    break;
                }
                break;
            case 2129240929:
                if (str.equals("notepad")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        String str3 = "";
        switch (c10) {
            case 0:
                str3 = "reccfg_contacts";
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                str3 = "reccfg_notes";
                break;
            default:
                z10 = false;
                break;
        }
        if (z10) {
            return C10028c.m62182c0().m62395t1(str3);
        }
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(context);
        if (shownSyncServiceItems.size() <= 0) {
            return false;
        }
        Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
        while (true) {
            if (it.hasNext()) {
                if (str.equals(it.next().getId())) {
                    SyncConfigServiceDataType[] dataTypesByServiceId = new SyncConfigDataTypeOperator().getDataTypesByServiceId(str);
                    if (dataTypesByServiceId.length > 0) {
                        for (SyncConfigServiceDataType syncConfigServiceDataType : dataTypesByServiceId) {
                            if (syncConfigServiceDataType != null && str2.equals(syncConfigServiceDataType.getTypeId())) {
                                return syncConfigServiceDataType.isRcycSync();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void syncTransTooLargeFailCallBack(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<String, String> entry : PACKAGE_NAME_SYNC_TYPE_MAP.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value) && str.equals(value)) {
                C11839m.m70687e(TAG, "syncTransTooLargeFailCallBack mSyncType = " + str + ", callPackageName = " + key);
                SyncLogicServiceUtil.endSyncCallBack(str, key, this.appContext);
                return;
            }
        }
    }
}
