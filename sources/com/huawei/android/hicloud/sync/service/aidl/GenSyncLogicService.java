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
import com.huawei.android.hicloud.sync.service.aidl.IGenSyncService;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.android.hicloud.task.frame.RequestDispatcher;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.bean.SyncConfigServiceDataType;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigDataTypeOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0240y;
import p514o9.C11839m;
import p572qb.C12329u;
import p609rc.C12487a;
import p616rk.C12515a;
import p664u0.C13108a;
import p770xc.C13746i;
import sb.C12767a;
import tc.C13007b;

/* loaded from: classes3.dex */
public class GenSyncLogicService extends Service {
    private static final String BUSINESS_ID = "business_id";
    private static final int FIRST_ORDER = 1;
    public static final String IS_BATCHES_SEND_OVER_KEY = "is_send_over";
    public static final String IS_INCREMENT_SEND_DATA_KEY = "is_increment_send_data";
    public static final String IS_SEND_DATA_IN_BATCHES_KEY = "is_in_batches";
    private static final int MAX_BUNDLE_SIZE = 102400;
    private static final long MAX_RESPONSE_TIME = 600000;
    private static final int MGS_SYNC_CALLBACK_HANDLER = 6;
    private static final String RETURN_CODE = "returnCode";
    public static final String SEND_MESSAGE_IN_BATCHES_DATA_BYTES_KEY = "batches_data_bytes_key";
    private static final String SYNC_INFO = "syncInfo";
    private static final String SYNC_INFO_TYPE = "syncInfoType";
    private static final String TAG = "GenSyncLogicService";
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
    private static final Map<String, String> SYNC_TYPE_2_REAL_PKG_NAME = new HashMap(10);
    private static final Map<String, String> SYNC_TYPE_2_CALLING_PKG_NAME = new HashMap(10);
    private static final ConcurrentHashMap<String, Boolean> SYNC_FLOW_CONTROL_EFFECTED_MAP = new ConcurrentHashMap<>();
    private final Map<String, RemoteCallbackList<ISyncServiceCallback>> mCallbacks = new HashMap();
    private final SyncServiceStub mBinder = new SyncServiceStub();
    private Context appContext = null;
    private final RequestDispatcher mDispatcher = new RequestDispatcher(this);
    private LocalReceiver mLocalReceiver = null;
    private final Map<String, String> traceIdMap = new HashMap(10);
    private final Map<String, String> syncRsnMap = new HashMap(10);
    private StringBuffer batchesBuffer = new StringBuffer();

    @SuppressLint({"HandlerLeak"})
    private Handler callbackHandler = null;
    private final Handler mHandler = new Handler(Looper.myLooper()) { // from class: com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicService.1
        public HandlerC29401(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            try {
                int i10 = message.what;
                Bundle bundle = (Bundle) message.obj;
                String string = bundle.getString("syncType");
                String string2 = bundle.getString("packageName");
                if (GenSyncLogicService.SYNC_TYPE_TIME_OUT_MSG_MAP.containsValue(Integer.valueOf(i10)) && GenSyncLogicService.this.checkTimeOutExceedMaxTime(string)) {
                    C11839m.m70688i(GenSyncLogicService.TAG, "receive cloud sdk response time out message, syncType = " + string + ", msgWhat = " + i10 + ", syncModulePackageName = " + string2);
                    GenSyncLogicService.this.mBinder.endSyncByTimeout(string, new ArrayList(), new ArrayList(), true, string2, 2025);
                }
            } catch (Exception e10) {
                C11839m.m70687e(GenSyncLogicService.TAG, "handleMessage error: " + e10.toString());
            }
        }
    };

    /* renamed from: com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicService$1 */
    public class HandlerC29401 extends Handler {
        public HandlerC29401(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            try {
                int i10 = message.what;
                Bundle bundle = (Bundle) message.obj;
                String string = bundle.getString("syncType");
                String string2 = bundle.getString("packageName");
                if (GenSyncLogicService.SYNC_TYPE_TIME_OUT_MSG_MAP.containsValue(Integer.valueOf(i10)) && GenSyncLogicService.this.checkTimeOutExceedMaxTime(string)) {
                    C11839m.m70688i(GenSyncLogicService.TAG, "receive cloud sdk response time out message, syncType = " + string + ", msgWhat = " + i10 + ", syncModulePackageName = " + string2);
                    GenSyncLogicService.this.mBinder.endSyncByTimeout(string, new ArrayList(), new ArrayList(), true, string2, 2025);
                }
            } catch (Exception e10) {
                C11839m.m70687e(GenSyncLogicService.TAG, "handleMessage error: " + e10.toString());
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
                    GenSyncLogicService.this.isSendMessageInBatches = false;
                    GenSyncLogicService.this.sendCallbackMessage(string, i10, bundle, string2);
                    if (GenSyncLogicService.this.isSendMessageInBatches) {
                        GenSyncLogicService.this.sendMessageOver(string, i10, i11, string2, bundle);
                        GenSyncLogicService.this.isSendMessageInBatches = false;
                    }
                } else if (bundle.getBoolean("is_send_over", false)) {
                    GenSyncLogicService.this.sendMessageOver(string, i10, i11, string2, bundle);
                } else {
                    GenSyncLogicService.this.sendCallbackMessage(string, i10, bundle, string2);
                }
                if (GenSyncLogicService.this.mCallbacks.get(string2) == null || !GenSyncLogicService.this.isSendTimeOutMessage(i10)) {
                    return;
                }
                GenSyncLogicService.this.sendTimeOutMessage(string, string2);
            } catch (Exception e10) {
                C11839m.m70687e(GenSyncLogicService.TAG, "CallBackHandler handleMessage:" + e10.toString());
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
            if ("com.huawei.android.hicloud.intent.GENSENDCALLBACK".equals(safeIntent.getAction()) || "com.huawei.android.hicloud.intent.GENINCREMENTSENDCALLBACK".equals(safeIntent.getAction())) {
                try {
                    int intExtra = safeIntent.getIntExtra("msgID", 0);
                    String stringExtra = safeIntent.getStringExtra("msgType");
                    if (intExtra == 0 || (bundleExtra = safeIntent.getBundleExtra("bundle")) == null) {
                        return;
                    }
                    if (intExtra == 10009) {
                        GenSyncLogicService.SYNC_TYPE_IS_ENDING_MAP.put(stringExtra, Boolean.FALSE);
                    }
                    Message messageObtainMessage = GenSyncLogicService.this.callbackHandler.obtainMessage();
                    messageObtainMessage.what = 6;
                    messageObtainMessage.obj = bundleExtra;
                    Bundle bundle = new Bundle();
                    bundle.putInt("msgID", intExtra);
                    bundle.putString("msgType", stringExtra);
                    messageObtainMessage.setData(bundle);
                    try {
                        if (GenSyncLogicService.this.callbackHandlerThread.isAlive()) {
                            GenSyncLogicService.this.callbackHandler.sendMessage(messageObtainMessage);
                        } else {
                            C11839m.m70689w(GenSyncLogicService.TAG, "sendMessage service has destroyed");
                        }
                    } catch (Exception e10) {
                        C11839m.m70687e(GenSyncLogicService.TAG, "callbackHandler exception: " + e10.getMessage());
                    }
                } catch (Exception e11) {
                    C11839m.m70687e(GenSyncLogicService.TAG, "onReceive:" + e11.toString());
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
        C13007b c13007bM78205Y = C13007b.m78205Y(C0213f.m1377a());
        Map<String, String> map = PACKAGE_NAME_SYNC_TYPE_MAP;
        c13007bM78205Y.m78274n(map.get(str));
        C13007b.m78205Y(C0213f.m1377a()).m78276o(map.get(str));
        C13007b.m78205Y(C0213f.m1377a()).m78254d(map.get(str));
        C13007b.m78205Y(C0213f.m1377a()).m78278p(map.get(str));
    }

    private void clearSyncTypeMap() {
        SYNC_TYPE_2_REAL_PKG_NAME.clear();
        SYNC_TYPE_2_CALLING_PKG_NAME.clear();
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

    private void handleTransParcelDataTooLarge(String str, int i10, Bundle bundle, String str2) {
        C11839m.m70688i(TAG, "handleTranParcelDataTooLarge msgID: " + i10);
        byte[] byteDataFromBundle = parseByteDataFromBundle(i10, bundle, str2);
        if (byteDataFromBundle == null || byteDataFromBundle.length <= 0) {
            return;
        }
        int length = byteDataFromBundle.length;
        int i11 = bundle.getInt(MapKeyNames.RESULT_CODE, -1);
        if (length <= 102400) {
            C11839m.m70688i(TAG, "genResolveTooLarge: syncType: " + str + ", totalDataLength = " + length);
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
            C11839m.m70688i(TAG, "genResolveTooLarge: syncType: " + str + ", times[" + i12 + "] remainLength: " + length);
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

    private void initTimeOutMap() {
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this.appContext);
        if (!shownSyncServiceItems.isEmpty()) {
            Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
            int i10 = 0;
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

    public boolean isCallPackageValid(String str, String str2) {
        C11839m.m70688i(TAG, "isCallPackageValid: calling package " + str + ", syncType " + str2);
        boolean zIsAppFingerPrintValid = NotifyUtil.isAppFingerPrintValid(getBaseContext(), str2, str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isCallPackageValid: ");
        sb2.append(zIsAppFingerPrintValid);
        C11839m.m70688i(TAG, sb2.toString());
        return zIsAppFingerPrintValid;
    }

    public boolean isSendTimeOutMessage(int i10) {
        return i10 == 10001 || i10 == 10002 || i10 == 10004 || i10 == 10008 || i10 == 10007 || i10 == 10003 || i10 == 10012;
    }

    public static boolean isServiceSupportRecycleProcess(Context context, String str, String str2) throws Throwable {
        C11839m.m70688i(TAG, "isServiceSupportRecycleProcess: syncType " + str + ", dataType " + str2);
        if ("notepad".equals(str)) {
            return C10028c.m62182c0().m62395t1("reccfg_notes");
        }
        if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(str)) {
            boolean zM62395t1 = C10028c.m62182c0().m62395t1("reccfg_hinote");
            C11839m.m70686d(TAG, "isServiceSupportRecycleProcess: hinote " + zM62395t1);
            return zM62395t1;
        }
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(context);
        if (shownSyncServiceItems.size() <= 0) {
            return false;
        }
        Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
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
        return false;
    }

    private boolean needSendMessageId(int i10) {
        return i10 == 10009 || i10 == 10016;
    }

    private byte[] parseByteDataFromBundle(int i10, Bundle bundle, String str) {
        byte[] bArr = new byte[0];
        if (bundle.getBoolean("is_in_batches", false)) {
            return bundle.getByteArray("batches_data_bytes_key");
        }
        if (i10 == 10001) {
            return GenSyncLogicServiceUtil.parseBeginSyncResult(bundle, str);
        }
        if (i10 != 10002) {
            return i10 != 10004 ? i10 != 10005 ? i10 != 10007 ? i10 != 10009 ? i10 != 10017 ? bArr : GenSyncLogicServiceUtil.parseGetSyncLostListResult(bundle) : GenSyncLogicServiceUtil.parseEndsyncResult(bundle) : GenSyncLogicServiceUtil.parseUploadResult(bundle) : GenSyncLogicServiceUtil.parseDownloadUnstructResult(bundle) : GenSyncLogicServiceUtil.parseDownloadSaveResult(bundle);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("cdata");
        return parcelableArrayList != null ? GenSyncLogicServiceUtil.parseQueryCloudData(parcelableArrayList) : bArr;
    }

    private void registerLocalBroadcastReceiver() {
        if (this.mLocalReceiver == null) {
            this.mLocalReceiver = new LocalReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
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
                C11839m.m70689w(TAG, "onReceive TransactionTooLargeException: sdk version is too low, not support trans parcel data.");
                return;
            }
            int iIntValue = SYNC_TYPE_PACKAGE_NAME_MAP.get(str2).intValue();
            C11839m.m70689w(TAG, "onReceive TransactionTooLargeException:" + e10.toString() + ", syncPackageName: " + str2 + ", sdkVersion: " + iIntValue);
            if (iIntValue >= 1) {
                this.isSendMessageInBatches = true;
                handleTransParcelDataTooLarge(str, i10, bundle, str2);
            }
        } catch (RemoteException e11) {
            C11839m.m70687e(TAG, "sendCallbackMessage sendMessage exception:" + e11.toString());
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
                C11839m.m70688i(TAG, "handleMessage No:" + i11 + ", isEnding:" + bool + "; MSG content is:" + GenSyncLogicServiceUtil.getMessageDetial(i10, bundle));
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
            C11839m.m70687e(TAG, "sendMessageOver: " + e10.toString());
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
            } catch (RemoteException e10) {
                C11839m.m70687e(TAG, "genSendTooLargeCallbackMessage twice remote, syncType = " + str + ", error:" + e10.toString());
                resolveRemoteEx(str, i10, bundle, str2);
            } catch (Exception e11) {
                C11839m.m70687e(TAG, "genSendTooLargeCallbackMessage twice error:" + e11.toString());
            }
        } catch (TransactionTooLargeException unused) {
            C11839m.m70689w(TAG, "genSendTooLargeCallbackMessage tooLarge need twice send, syncType = " + str);
            SystemClock.sleep(400L);
            sendMessage(str, i10, bundle, str2);
        } catch (RemoteException e12) {
            C11839m.m70687e(TAG, "genSendTooLargeCallbackMessage remote error:" + e12.toString());
            resolveRemoteEx(str, i10, bundle, str2);
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
                GenSyncLogicServiceUtil.syncFailedCallBack(str, key, this.appContext, 2238, i10);
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
        C11839m.m70688i(TAG, "onBind");
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        C11839m.m70686d(TAG, "service onCreate");
        super.onCreate();
        this.appContext = getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("SYNC_CALLBACK", 10);
        this.callbackHandlerThread = handlerThread;
        handlerThread.start();
        this.callbackHandler = new CallBackHandler(this.callbackHandlerThread.getLooper());
        C12487a.m74966b(this.appContext);
        registerLocalBroadcastReceiver();
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
            }
            Iterator<Map.Entry<String, Boolean>> it = CloudSyncUtil.m15951G().entrySet().iterator();
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

    public class SyncServiceStub extends IGenSyncService.Stub {
        public SyncServiceStub() {
        }

        private C10800n buildEndSyncParameter(String str, List<String> list, List<String> list2, String str2) {
            C10800n c10800n = new C10800n();
            c10800n.m65743h("synctype", str);
            c10800n.m65743h("datatypelist", list);
            c10800n.m65743h("datatyperesultlist", list2);
            c10800n.m65743h("trace_id_key", GenSyncLogicService.this.traceIdMap.get(str));
            c10800n.m65743h("sync_moudle_package_name", str2);
            c10800n.m65743h("sync_report_end_info", GenSyncLogicService.this.getReportInfo(str2, str));
            c10800n.m65743h("sync_flow_control_effect_flag", GenSyncLogicService.SYNC_FLOW_CONTROL_EFFECTED_MAP);
            return c10800n;
        }

        private String buildReportInfo(String str, int i10, String str2, String str3) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(GenSyncLogicService.BUSINESS_ID, str);
                jSONObject.put(GenSyncLogicService.RETURN_CODE, i10);
                jSONObject.put(GenSyncLogicService.SYNC_INFO, str2);
                jSONObject.put(GenSyncLogicService.SYNC_INFO_TYPE, str3);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                return jSONArray.toString();
            } catch (JSONException unused) {
                C11839m.m70687e(GenSyncLogicService.TAG, "parseReportInfo " + str + " error: JSONException");
                return "";
            }
        }

        public void endSyncByDestroy(String str, String str2, int i10) {
            C11839m.m70688i(GenSyncLogicService.TAG, "endSyncByDestroy, isDestroy = true");
            C10800n c10800nBuildEndSyncParameter = buildEndSyncParameter(str, new ArrayList(), new ArrayList(), str2);
            c10800nBuildEndSyncParameter.m65741f("is_destroy", true);
            endSync(str, c10800nBuildEndSyncParameter, i10);
        }

        public void endSyncByTimeout(String str, List<String> list, List<String> list2, boolean z10, String str2, int i10) {
            C11839m.m70688i(GenSyncLogicService.TAG, "endSyncByTimeout, isTimeout: " + z10);
            C10800n c10800nBuildEndSyncParameter = buildEndSyncParameter(str, list, list2, str2);
            if (z10) {
                c10800nBuildEndSyncParameter.m65741f("is_timeout", true);
            }
            endSync(str, c10800nBuildEndSyncParameter, i10);
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

        private String listToString(Collection<?> collection) {
            return collection == null ? "" : collection.toString();
        }

        private List<SyncData> parseSyncDataListFromJSONArray(JSONArray jSONArray) throws JSONException {
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
                    JSONArray jSONArrayFromJSONObject = getJSONArrayFromJSONObject(jSONObject, "downFileList");
                    JSONArray jSONArrayFromJSONObject2 = getJSONArrayFromJSONObject(jSONObject, "deleteFileList");
                    JSONArray jSONArrayFromJSONObject3 = getJSONArrayFromJSONObject(jSONObject, "filelist");
                    syncData.setDownFileList(parseUnstructDataListFromJSONArray(jSONArrayFromJSONObject));
                    syncData.setDeleteFileList(parseUnstructDataListFromJSONArray(jSONArrayFromJSONObject2));
                    syncData.setFileList(parseUnstructDataListFromJSONArray(jSONArrayFromJSONObject3));
                    if (!TextUtils.isEmpty(jSONObject.optString("extensionData"))) {
                        syncData.setExtensionData(jSONObject.optString("extensionData"));
                    }
                    if (!TextUtils.isEmpty(jSONObject.optString("extraParam"))) {
                        syncData.setExtensionData(jSONObject.optString("extraParam"));
                    }
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
                    arrayList.add(unstructData);
                }
            }
            return arrayList;
        }

        private void processNetNotConnected(String str) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(GenSyncLogicService.this.appContext, "sync_contact_spfile", 0).edit();
            editorEdit.putInt(str + "sync_retcode", 19);
            editorEdit.commit();
        }

        private void recordAppInfoWhenStartSync(String str, int i10, int i11) throws JSONException {
            C11839m.m70688i(GenSyncLogicService.TAG, "recordAppInfoWhenStartSync: syncType " + str);
            if (i11 == 1) {
                String strBuildReportInfo = "";
                if (i10 != -1) {
                    strBuildReportInfo = buildReportInfo("local_syncRsn", 0, "syncType = " + str + ", syncRsn = " + i10 + ", isCharging = " + C0209d.m1196O0(GenSyncLogicService.this.appContext), "");
                }
                try {
                    String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
                    if (C10812z.m65835d(callingPackageName)) {
                        return;
                    }
                    reportSyncRsn(str, callingPackageName, GenSyncLogicService.this.appContext.getPackageManager().getPackageInfo(callingPackageName, 0).versionName, strBuildReportInfo);
                } catch (Exception unused) {
                    C11839m.m70687e(GenSyncLogicService.TAG, "recordAppInfo: get calling package info failed.");
                }
            }
        }

        private void recordSdkVersion(int i10) {
            C11839m.m70688i(GenSyncLogicService.TAG, "reportSdkVersion: sdk version " + i10);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName();
            if (callingPackageName != null) {
                GenSyncLogicService.SYNC_TYPE_PACKAGE_NAME_MAP.put(callingPackageName, Integer.valueOf(i10));
            }
        }

        private void reportEndSync(String str, String str2, String str3) throws JSONException, RemoteException {
            String string;
            C11839m.m70688i(GenSyncLogicService.TAG, "reportEndSync: report end sync.");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("syncType", str);
                jSONObject.put("dataTypeList", str2);
                jSONObject.put("dataTypeResultList", str3);
                string = jSONObject.toString();
            } catch (JSONException unused) {
                C11839m.m70687e(GenSyncLogicService.TAG, "reportEndSync error: JSONException");
                string = "";
            }
            reportInfo(str, buildReportInfo("local_end_sync_result", 0, string, "json"));
        }

        private void reportSyncRsn(String str, String str2, String str3, String str4) {
            C11839m.m70688i(GenSyncLogicService.TAG, "reportSyncRsn packageName = " + str2 + ", versionName = " + str3 + ", reportJson = " + str4);
            C12767a.m76619c().m76622d(str);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (CloudSyncUtil.m16043r0(callingPackageName, str)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "reportSyncRsn " + str + " is Syncing...");
                return;
            }
            if (TextUtils.isEmpty(callingPackageName) || TextUtils.isEmpty(realCallingPackageName)) {
                return;
            }
            C10812z.m65848q(callingPackageName, C0240y.m1681c(GenSyncLogicService.this.appContext, realCallingPackageName), realCallingPackageName);
            if (TextUtils.isEmpty(str4)) {
                return;
            }
            GenSyncLogicService.this.syncRsnMap.put(callingPackageName, str4);
        }

        private void sendGetStructNumErrorMsg(String str, String str2, List<String> list) {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
            intent.putExtra("msgType", str);
            intent.putExtra("msgID", 10016);
            Bundle bundle = new Bundle();
            bundle.putInt(MapKeyNames.RESULT_CODE, 0);
            bundle.putString("sync_module_package_name", str2);
            HashMap map = new HashMap();
            if (list != null && !list.isEmpty()) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    map.put(it.next(), -1);
                }
            }
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(map);
            bundle.putSerializable("gen_get_struct_count_result", serializableMap);
            intent.putExtra("bundle", bundle);
            GenSyncLogicService.this.mLocalReceiver.onReceive(GenSyncLogicService.this.appContext, intent);
        }

        private void startSync(String str, String str2, C10800n c10800n, int i10) {
            String strM65832a;
            Map map = GenSyncLogicService.SYNC_TYPE_IS_ENDING_MAP;
            Boolean bool = Boolean.FALSE;
            map.put(str, bool);
            if (i10 == 1) {
                Context context = GenSyncLogicService.this.appContext;
                GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
                C2980i.m17870e(context, str, genSyncLogicService.getReportInfo(genSyncLogicService.getCallingPackageName(str), str));
            }
            C12767a.m76619c().m76622d(str);
            GenSyncLogicService.this.removeTimeOutMessage(str);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
            if (CloudSyncUtil.m16060y0(str)) {
                GenSyncLogicServiceUtil.syncFailedCallBack(str, callingPackageName, GenSyncLogicService.this.appContext, 2206, 10001);
                return;
            }
            if (!C0209d.m1208S0(GenSyncLogicService.this.appContext)) {
                C11839m.m70689w(GenSyncLogicService.TAG, "net is not available");
                processNetNotConnected(str);
                GenSyncLogicServiceUtil.syncFailedCallBack(str, callingPackageName, GenSyncLogicService.this.appContext, 2028, 10001);
                return;
            }
            if (i10 == 1 && CloudSyncUtil.m16043r0(callingPackageName, str)) {
                GenSyncLogicServiceUtil.syncFailedCallBack(str, callingPackageName, GenSyncLogicService.this.appContext, 2026, 10001);
                return;
            }
            if (CloudSyncUtil.m15965N() == 1) {
                C11839m.m70689w(GenSyncLogicService.TAG, "Server Control Reset");
                GenSyncLogicServiceUtil.syncFailedCallBack(str, callingPackageName, GenSyncLogicService.this.appContext, 2029, 10001);
                return;
            }
            if (i10 == 1 && C2786g.m16219h(GenSyncLogicService.this.appContext, str, C0240y.m1681c(GenSyncLogicService.this.appContext, callingPackageName))) {
                C11839m.m70689w(GenSyncLogicService.TAG, str + ":syncFlowControlPolicy effect");
                GenSyncLogicServiceUtil.endSyncCallBack(str, callingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (i10 == 1) {
                GenSyncLogicService.PACKAGE_NAME_SYNC_TYPE_MAP.put(callingPackageName, str);
                GenSyncLogicService.SYNC_FLOW_CONTROL_EFFECTED_MAP.put(callingPackageName, bool);
                if (!C10812z.m65835d(callingPackageName)) {
                    GenSyncLogicService genSyncLogicService2 = GenSyncLogicService.this;
                    String realCallingPackageName = genSyncLogicService2.getRealCallingPackageName(genSyncLogicService2.appContext, str);
                    String strM1681c = C0240y.m1681c(GenSyncLogicService.this.appContext, realCallingPackageName);
                    C11839m.m70688i(GenSyncLogicService.TAG, "calling packageName: " + realCallingPackageName + " versionName: " + strM1681c);
                    C10812z.m65848q(callingPackageName, strM1681c, realCallingPackageName);
                }
                strM65832a = C10812z.m65832a("03001");
                GenSyncLogicService.this.traceIdMap.put(str, strM65832a);
                CloudSyncUtil.m16026l1(str, 0);
                if (callingPackageName != null && GenSyncLogicService.this.syncRsnMap.containsKey(callingPackageName)) {
                    C12515a.m75110o().m75172d(new C13746i(GenSyncLogicService.this.appContext, str, callingPackageName, (String) GenSyncLogicService.this.syncRsnMap.get(callingPackageName), "03001", "", (String) GenSyncLogicService.this.traceIdMap.get(str)));
                }
                Context context2 = GenSyncLogicService.this.appContext;
                GenSyncLogicService genSyncLogicService3 = GenSyncLogicService.this;
                ReportSyncEndInfo reportInfo = genSyncLogicService3.getReportInfo(genSyncLogicService3.getCallingPackageName(str), str);
                GenSyncLogicService genSyncLogicService4 = GenSyncLogicService.this;
                C2980i.m17885t(context2, str, reportInfo, genSyncLogicService4.getRealCallingPackageName(genSyncLogicService4.appContext, str));
                GenSyncLogicService genSyncLogicService5 = GenSyncLogicService.this;
                C2980i.m17880o(genSyncLogicService5.getReportInfo(genSyncLogicService5.getCallingPackageName(str), str), str, (String) GenSyncLogicService.this.syncRsnMap.get(callingPackageName));
                GenSyncLogicService genSyncLogicService6 = GenSyncLogicService.this;
                C2980i.m17884s(genSyncLogicService6.getReportInfo(genSyncLogicService6.getCallingPackageName(str), str), strM65832a);
                GenSyncLogicService genSyncLogicService7 = GenSyncLogicService.this;
                C2980i.m17886u(genSyncLogicService7.getReportInfo(genSyncLogicService7.getCallingPackageName(str), str), callingPackageName);
            } else {
                strM65832a = (String) GenSyncLogicService.this.traceIdMap.get(str);
            }
            C11839m.m70688i(GenSyncLogicService.TAG, "GstartSync syncType = " + str + ", dataType = " + str2 + ", traceId = " + strM65832a);
            GenSyncLogicService.SYNC_TYPE_LOST_REFUND_MAP.put(str, new C12329u(GenSyncLogicService.this.appContext, str, str2, "03001", strM65832a, callingPackageName, GenSyncLogicService.SYNC_FLOW_CONTROL_EFFECTED_MAP));
            C12487a.m74966b(GenSyncLogicService.this.appContext);
            GenSyncLogicService.this.initBaseParameter(c10800n, str, str2, strM65832a, callingPackageName);
            c10800n.m65743h(NotifyConstants.NotificationReport.KEY_ORDER, Integer.valueOf(i10));
            GenSyncLogicService.this.mDispatcher.m18035b(new C11442e(55000026, c10800n), str);
            if (TextUtils.isEmpty(callingPackageName)) {
                return;
            }
            CloudSyncUtil.m15951G().put(callingPackageName, Boolean.TRUE);
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

        private void uploadDataTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "uploadDataTooLarge");
            C12767a.m76619c().m76622d(str);
            GenSyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (z11) {
                    JSONObject jSONObject = new JSONObject(GenSyncLogicService.this.batchesBuffer.toString());
                    JSONArray jSONArray = jSONObject.getJSONArray(SyncProtocol.Constant.ADD);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("modify");
                    List<UnstructData> unstructDataListFromJSONArray = parseUnstructDataListFromJSONArray(jSONObject.getJSONArray("localFile"));
                    String string = jSONObject.getString("delete");
                    List<SyncData> syncDataListFromJSONArray = parseSyncDataListFromJSONArray(jSONArray);
                    List<SyncData> syncDataListFromJSONArray2 = parseSyncDataListFromJSONArray(jSONArray2);
                    ArrayList<String> arrayListString2Arrays = string2Arrays(string);
                    C10800n c10800n = new C10800n();
                    c10800n.m65743h("local_file_list", unstructDataListFromJSONArray);
                    uploadData(str, str2, syncDataListFromJSONArray, syncDataListFromJSONArray2, new ArrayList(), arrayListString2Arrays, c10800n, z10);
                    GenSyncLogicService.this.batchesBuffer = new StringBuffer();
                } else {
                    GenSyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(GenSyncLogicService.TAG, "uploadDataForTransTooLarge:" + th2.toString());
                GenSyncLogicService.this.syncTransTooLargeFailCallBack(str, 10003);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void downUnstructFile(String str, String str2, List<UnstructData> list, int i10) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "downUnstructFile");
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "downUnstructFile: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "downUnstructFile: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            recordSdkVersion(i10);
            C12767a.m76619c().m76622d(str);
            GenSyncLogicService.this.removeTimeOutMessage(str);
            C12487a.m74966b(GenSyncLogicService.this.appContext);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
            C10800n c10800n = new C10800n();
            GenSyncLogicService genSyncLogicService2 = GenSyncLogicService.this;
            genSyncLogicService2.initBaseParameter(c10800n, str, str2, (String) genSyncLogicService2.traceIdMap.get(str), callingPackageName);
            c10800n.m65743h("unstructlist", list);
            GenSyncLogicService.this.mDispatcher.m18035b(new C11442e(55000028, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, int i10) throws RemoteException {
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "downUnstructFileForTransTooLarge: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "downUnstructFileForTransTooLarge: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            GenSyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (z10) {
                    downUnstructFile(str, str2, parseUnstructDataListFromJSONArray(new JSONArray(GenSyncLogicService.this.batchesBuffer.toString())), i10);
                    GenSyncLogicService.this.batchesBuffer = new StringBuffer();
                } else {
                    GenSyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(GenSyncLogicService.TAG, "downUnstructFileForTransTooLarge:" + th2.toString());
                GenSyncLogicService.this.syncTransTooLargeFailCallBack(str, 10005);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void endSync(String str, String str2, List<String> list, List<String> list2) throws JSONException, RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "endSync: type " + str);
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "endSync: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) && DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                reportEndSync(str, listToString(list), listToString(list2));
                C10800n c10800nBuildEndSyncParameter = buildEndSyncParameter(str, list, list2, GenSyncLogicService.this.getCallingPackageName(str));
                c10800nBuildEndSyncParameter.m65743h("sync_mode_info", str2);
                c10800nBuildEndSyncParameter.m65743h("data_type_ctag_list", null);
                endSync(str, c10800nBuildEndSyncParameter, 2027);
                return;
            }
            C11839m.m70687e(GenSyncLogicService.TAG, "downUnstructFileForTransTooLarge: calling pkg is not valid. pkg " + realCallingPackageName);
            GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public int getHisyncNewVersion() throws RemoteException {
            return 107;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void getStructData(String str, String str2, List<String> list) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "getStructData");
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "getStructData: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "getStructData: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
            GenSyncLogicService.this.removeTimeOutMessage(str);
            C12487a.m74966b(GenSyncLogicService.this.appContext);
            C10800n c10800n = new C10800n();
            GenSyncLogicService genSyncLogicService2 = GenSyncLogicService.this;
            genSyncLogicService2.initBaseParameter(c10800n, str, str2, (String) genSyncLogicService2.traceIdMap.get(str), callingPackageName);
            c10800n.m65743h("guidList", list);
            c10800n.m65743h("isSdkSupportDownPartical", GenSyncLogicService.SYNC_SDK_SUPPORT_DOWN_PARTICAL_SUC_MAP.get(callingPackageName));
            GenSyncLogicService.this.mDispatcher.m18035b(new C11442e(55000032, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void getStructDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException {
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "getStructDataForTransTooLarge: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "getStructDataForTransTooLarge: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            GenSyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (z10) {
                    getStructData(str, str2, string2Arrays(GenSyncLogicService.this.batchesBuffer.toString()));
                    GenSyncLogicService.this.batchesBuffer = new StringBuffer();
                } else {
                    GenSyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(GenSyncLogicService.TAG, "getStructDataForTransTooLarge:" + th2.toString());
                GenSyncLogicService.this.syncTransTooLargeFailCallBack(str, 10002);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void getStructDataNum(String str, List<String> list) throws RemoteException {
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "getStructDataCount: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "getStructDataCount: calling pkg is not valid. pkg " + realCallingPackageName);
                sendGetStructNumErrorMsg(str, realCallingPackageName, list);
                return;
            }
            if (str == null || str.isEmpty()) {
                C11839m.m70687e(GenSyncLogicService.TAG, "getStructDataCount: syncType is null or empty.");
                sendGetStructNumErrorMsg(str, realCallingPackageName, list);
                return;
            }
            if (list == null || list.isEmpty()) {
                C11839m.m70687e(GenSyncLogicService.TAG, "getStructDataCount: dataTypes is null or empty.");
                sendGetStructNumErrorMsg(str, realCallingPackageName, list);
                return;
            }
            C10800n c10800n = new C10800n();
            c10800n.m65743h("synctype", str);
            c10800n.m65743h("sync_moudle_package_name", realCallingPackageName);
            c10800n.m65743h("datatypelist", list);
            c10800n.m65743h("trace_id_key", C10812z.m65832a("03001"));
            c10800n.m65743h("sync_report_end_info", GenSyncLogicService.this.getReportInfo(realCallingPackageName, str));
            GenSyncLogicService.this.mDispatcher.m18035b(new C11442e(55000034, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void getSyncLostList(String str, String str2) {
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "Gen getSyncLostList: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "Gen getSyncLostList: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
            C11839m.m70688i(GenSyncLogicService.TAG, "Gen getSyncLostList: syncType = " + str + ", dateTypes = " + str2 + ", packageName = " + callingPackageName);
            C10800n c10800n = new C10800n();
            GenSyncLogicService genSyncLogicService2 = GenSyncLogicService.this;
            genSyncLogicService2.initBaseParameter(c10800n, str, str2, (String) genSyncLogicService2.traceIdMap.get(str), callingPackageName);
            c10800n.m65743h("sync_moudle_lost_refund_impl", GenSyncLogicService.SYNC_TYPE_LOST_REFUND_MAP.get(str));
            GenSyncLogicService.this.mDispatcher.m18035b(new C11442e(55000035, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void notifyMsg(String str, String str2, String str3) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "notifyMsg syncType = " + str + ", dataType = " + str2 + ", msg = " + str3);
            C12767a.m76619c().m76622d(str);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "notifyMsg: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "notifyMsg: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            try {
                GenSyncLogicService.SYNC_AFTER_DOWN_PARTICAL_SUC_MAP.remove(callingPackageName);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                GenSyncLogicService.SYNC_AFTER_DOWN_PARTICAL_SUC_MAP.put(callingPackageName, str3);
            } catch (Exception e10) {
                C11839m.m70687e(GenSyncLogicService.TAG, "notifyMsg err " + e10.getMessage());
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "registerCallback");
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "registerCallback: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return false;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "registerCallback: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return false;
            }
            C12767a.m76619c().m76622d(str);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
            if (iSyncServiceCallback == null) {
                C11839m.m70688i(GenSyncLogicService.TAG, "cb is null");
                return false;
            }
            if (((RemoteCallbackList) GenSyncLogicService.this.mCallbacks.get(callingPackageName)) == null) {
                RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
                C11839m.m70688i(GenSyncLogicService.TAG, "callback is null , result: " + remoteCallbackList.register(iSyncServiceCallback));
                GenSyncLogicService.this.mCallbacks.put(callingPackageName, remoteCallbackList);
                return true;
            }
            GenSyncLogicService.this.mCallbacks.remove(callingPackageName);
            RemoteCallbackList remoteCallbackList2 = new RemoteCallbackList();
            C11839m.m70688i(GenSyncLogicService.TAG, "callback is not null , result: " + remoteCallbackList2.register(iSyncServiceCallback));
            GenSyncLogicService.this.mCallbacks.put(callingPackageName, remoteCallbackList2);
            return true;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void reportInfo(String str, String str2) throws RemoteException {
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "reportInfo: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) && DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C12767a.m76619c().m76622d(str);
                C12515a.m75110o().m75172d(new C13746i(GenSyncLogicService.this.appContext, str, GenSyncLogicService.this.getCallingPackageName(str), str2, "03001", "", (String) GenSyncLogicService.this.traceIdMap.get(str)));
                return;
            }
            C11839m.m70687e(GenSyncLogicService.TAG, "reportInfo: calling pkg is not valid. pkg " + realCallingPackageName);
            GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void reportSyncInfo(String str, String str2, String str3, String str4, String str5) throws JSONException {
            C11839m.m70688i(GenSyncLogicService.TAG, "reportSyncInfo appId: " + str2 + " packageName:" + str3 + " versionName:" + str4 + " extendInfo: " + str5);
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "reportSyncInfo: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "Gen reportSyncInfo: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
            if (TextUtils.isEmpty(callingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "reportSyncInfo callingPackageName null");
                return;
            }
            if (!TextUtils.isEmpty(realCallingPackageName)) {
                C10812z.m65849r(callingPackageName, str2, C0240y.m1681c(GenSyncLogicService.this.appContext, realCallingPackageName), realCallingPackageName);
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
                    GenSyncLogicService.this.syncRsnMap.put(callingPackageName, jSONObject2.toString());
                    if ("addressbook".equals(str)) {
                        CloudSyncUtil.m15990Z0(str, iOptInt);
                    }
                }
                GenSyncLogicService.this.syncRsnMap.put(callingPackageName, str5);
                if (jSONObject.has("isSdkSupportDownPartical")) {
                    GenSyncLogicService.SYNC_SDK_SUPPORT_DOWN_PARTICAL_SUC_MAP.remove(callingPackageName);
                    GenSyncLogicService.SYNC_SDK_SUPPORT_DOWN_PARTICAL_SUC_MAP.put(callingPackageName, Boolean.valueOf(jSONObject.getBoolean("isSdkSupportDownPartical")));
                }
            } catch (Exception e10) {
                C11839m.m70687e(GenSyncLogicService.TAG, "reportSyncInfo json error " + e10.getMessage());
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void saveSyncResult(String str, String str2, List<SyncData> list, List<String> list2, boolean z10) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "saveSyncResult");
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "saveSyncResult: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "saveSyncResult: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            GenSyncLogicService.this.removeTimeOutMessage(str);
            C12487a.m74966b(GenSyncLogicService.this.appContext);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
            C10800n c10800n = new C10800n();
            GenSyncLogicService genSyncLogicService2 = GenSyncLogicService.this;
            genSyncLogicService2.initBaseParameter(c10800n, str, str2, (String) genSyncLogicService2.traceIdMap.get(str), callingPackageName);
            c10800n.m65743h("saveresult", list);
            c10800n.m65743h("deleteList", list2);
            c10800n.m65743h("isupload", Boolean.valueOf(z10));
            c10800n.m65743h("isCloudDataParticalSuc", GenSyncLogicService.SYNC_AFTER_DOWN_PARTICAL_SUC_MAP.get(callingPackageName));
            GenSyncLogicService.this.mDispatcher.m18035b(new C11442e(55000033, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void saveSyncResultForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "saveSyncResultForTransTooLarge: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "saveSyncResultForTransTooLarge: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            GenSyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (z11) {
                    JSONObject jSONObject = new JSONObject(GenSyncLogicService.this.batchesBuffer.toString());
                    saveSyncResult(str, str2, parseSyncDataListFromJSONArray(jSONObject.getJSONArray("saveData")), string2Arrays(jSONObject.getString("deleteList")), z10);
                    GenSyncLogicService.this.batchesBuffer = new StringBuffer();
                } else {
                    GenSyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(GenSyncLogicService.TAG, "saveSyncResultForTransTooLarge:" + th2.toString());
                GenSyncLogicService.this.syncTransTooLargeFailCallBack(str, 10004);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str) {
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "unregisterCallback: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (!GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) || !DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "unregisterCallback: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            C12767a.m76619c().m76622d(str);
            String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
            if (iSyncServiceCallback != null) {
                C11839m.m70688i(GenSyncLogicService.TAG, "unregister callback");
                if (GenSyncLogicService.this.mCallbacks.get(callingPackageName) != null) {
                    if (CloudSyncUtil.m16043r0(callingPackageName, str)) {
                        C11440c.m68542u(str, 2207);
                        endSync(str, buildEndSyncParameter(str, new ArrayList(), new ArrayList(), callingPackageName), 2207);
                    }
                    ((RemoteCallbackList) GenSyncLogicService.this.mCallbacks.get(callingPackageName)).unregister(iSyncServiceCallback);
                    GenSyncLogicService.this.mCallbacks.remove(callingPackageName);
                    GenSyncLogicService.this.removeSyncTypeMap(str);
                    GenSyncLogicService.this.clearReportInfo(callingPackageName);
                }
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void uploadData(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "uploadData");
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "uploadData: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) && DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C10800n c10800n = new C10800n();
                c10800n.m65743h("local_file_list", list3);
                uploadData(str, str2, list, list2, new ArrayList(), list4, c10800n, z10);
            } else {
                C11839m.m70687e(GenSyncLogicService.TAG, "uploadData: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void uploadDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "uploadDataForTransTooLarge");
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "uploadDataForTransTooLarge: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
            } else {
                if (GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) && DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                    uploadDataTooLarge(str, str2, bArr, z10, z11);
                    return;
                }
                C11839m.m70687e(GenSyncLogicService.TAG, "uploadDataForTransTooLarge: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void uploadDataWithLost(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<String> list3, List<SyncDataCompatible> list4, boolean z10) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "Gen uploadDataWithLost: lost = " + list4.size());
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "Gen uploadDataWithLost: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) && DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C12767a.m76619c().m76622d(str);
                C10800n c10800n = new C10800n();
                c10800n.m65743h("sync_moudle_lost_refund_impl", GenSyncLogicService.SYNC_TYPE_LOST_REFUND_MAP.get(str));
                uploadData(str, str2, list, list2, list4, list3, c10800n, z10);
                return;
            }
            C11839m.m70687e(GenSyncLogicService.TAG, "Gen uploadDataWithLost: calling pkg is not valid. pkg " + realCallingPackageName);
            GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void uploadDataWithLostForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "Gen uploadDataWithLostForTransTooLarge");
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "Gen uploadDataWithLostForTransTooLarge: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
            } else {
                if (GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) && DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                    C12767a.m76619c().m76622d(str);
                    uploadDataWithLostTooLarge(str, str2, bArr, z10, z11);
                    return;
                }
                C11839m.m70687e(GenSyncLogicService.TAG, "Gen uploadDataWithLostForTransTooLarge: calling pkg is not valid. pkg " + realCallingPackageName);
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
            }
        }

        public void uploadDataWithLostTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "Gen uploadDataWithLostTooLarge");
            C12767a.m76619c().m76622d(str);
            GenSyncLogicService.this.removeTimeOutMessage(str);
            try {
                if (z11) {
                    JSONObject jSONObject = new JSONObject(GenSyncLogicService.this.batchesBuffer.toString());
                    JSONArray jSONArray = jSONObject.getJSONArray(SyncProtocol.Constant.ADD);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("modify");
                    String string = jSONObject.getString("delete");
                    JSONArray jSONArray3 = jSONObject.getJSONArray("lost");
                    List<SyncData> syncDataListFromJSONArray = parseSyncDataListFromJSONArray(jSONArray);
                    List<SyncData> syncDataListFromJSONArray2 = parseSyncDataListFromJSONArray(jSONArray2);
                    ArrayList<String> arrayListString2Arrays = string2Arrays(string);
                    List<SyncData> syncDataListFromJSONArray3 = parseSyncDataListFromJSONArray(jSONArray3);
                    C10800n c10800n = new C10800n();
                    c10800n.m65743h("sync_moudle_lost_refund_impl", GenSyncLogicService.SYNC_TYPE_LOST_REFUND_MAP.get(str));
                    uploadData(str, str2, syncDataListFromJSONArray, syncDataListFromJSONArray2, syncDataListFromJSONArray3, arrayListString2Arrays, c10800n, z10);
                    GenSyncLogicService.this.batchesBuffer = new StringBuffer();
                } else {
                    GenSyncLogicService.this.batchesBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(GenSyncLogicService.TAG, "Gen uploadDataForTransTooLarge:" + th2.toString());
                GenSyncLogicService.this.syncTransTooLargeFailCallBack(str, 10003);
            }
        }

        private void uploadData(String str, String str2, List<? extends SyncData> list, List<? extends SyncData> list2, List<? extends SyncData> list3, List<String> list4, C10800n c10800n, boolean z10) throws RemoteException {
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) && DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                C12767a.m76619c().m76622d(str);
                GenSyncLogicService.this.removeTimeOutMessage(str);
                C12487a.m74966b(GenSyncLogicService.this.appContext);
                String callingPackageName = GenSyncLogicService.this.getCallingPackageName(str);
                GenSyncLogicService genSyncLogicService2 = GenSyncLogicService.this;
                genSyncLogicService2.initBaseParameter(c10800n, str, str2, (String) genSyncLogicService2.traceIdMap.get(str), callingPackageName);
                c10800n.m65743h("addList", list);
                c10800n.m65743h("modifyList", list2);
                c10800n.m65743h("deleteList", list4);
                c10800n.m65743h("lostRefundList", list3);
                c10800n.m65743h("havefile", Boolean.valueOf(z10));
                GenSyncLogicService.this.mDispatcher.m18035b(new C11442e(55000027, c10800n), str);
                return;
            }
            C11839m.m70687e(GenSyncLogicService.TAG, "Gen uploadData: calling pkg is not valid. pkg " + realCallingPackageName);
            GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
        }

        private void endSync(String str, C10800n c10800n, int i10) {
            GenSyncLogicService.SYNC_TYPE_IS_ENDING_MAP.put(str, Boolean.TRUE);
            C12767a.m76619c().m76622d(str);
            String strM65740e = c10800n.m65740e("sync_moudle_package_name", GenSyncLogicService.this.getCallingPackageName(str));
            C11839m.m70688i(GenSyncLogicService.TAG, "endSync: syncType = " + str + ", callingPackageName = " + strM65740e);
            if (!CloudSyncUtil.m15951G().containsKey(strM65740e)) {
                C11839m.m70689w(GenSyncLogicService.TAG, "endSync: not have syncTask, callingPackageName = " + strM65740e);
                GenSyncLogicServiceUtil.endSyncCallBack(str, strM65740e, GenSyncLogicService.this.appContext);
                return;
            }
            GenSyncLogicService.this.removeTimeOutMessage(str);
            C12487a.m74966b(GenSyncLogicService.this.appContext);
            C11440c.m68542u(str, i10);
            GenSyncLogicService.this.mDispatcher.m18035b(new C11442e(55000030, c10800n), str);
            CloudSyncUtil.m15951G().remove(strM65740e);
            GenSyncLogicService.SYNC_TYPE_LOST_REFUND_MAP.remove(str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void startSync(String str, String str2, String str3, List<CtagInfoCompatible> list, int i10, int i11, int i12) throws JSONException, RemoteException {
            C11839m.m70688i(GenSyncLogicService.TAG, "startSync syncType = " + str + ", dataType = " + str2);
            GenSyncLogicService genSyncLogicService = GenSyncLogicService.this;
            String realCallingPackageName = genSyncLogicService.getRealCallingPackageName(genSyncLogicService.appContext, str);
            if (TextUtils.isEmpty(realCallingPackageName)) {
                C11839m.m70687e(GenSyncLogicService.TAG, "startSync: real calling pkg is empty");
                GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
                return;
            }
            if (GenSyncLogicService.this.isCallPackageValid(realCallingPackageName, str) && DriveSyncUtil.m18001k(str, realCallingPackageName)) {
                recordSdkVersion(i11);
                recordAppInfoWhenStartSync(str, i12, i10);
                C10800n c10800n = new C10800n();
                c10800n.m65743h("data_type_local_ctag_info", list);
                c10800n.m65743h("sync_mode_info", str3);
                startSync(str, str2, c10800n, i10);
                return;
            }
            C11839m.m70687e(GenSyncLogicService.TAG, "startSync: calling pkg is not valid. pkg " + realCallingPackageName);
            GenSyncLogicServiceUtil.endSyncCallBack(str, realCallingPackageName, GenSyncLogicService.this.appContext);
        }
    }
}
