package com.huawei.android.hicloud.sync.service.aidl;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.service.aidl.IToolSyncService;
import com.huawei.android.hicloud.sync.service.aidl.ToolSyncService;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.android.hicloud.task.frame.RequestDispatcher;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import je.C10800n;
import je.C10812z;
import md.C11442e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p514o9.C11839m;
import p609rc.C12487a;
import p616rk.C12515a;
import p664u0.C13108a;
import p770xc.C13746i;
import sb.C12767a;

/* loaded from: classes3.dex */
public class ToolSyncService extends Service {
    public static final String IS_BATCHES_SEND_OVER_KEY = "is_send_over";
    public static final String IS_SEND_DATA_IN_BATCHES_KEY = "is_in_batches";
    private static final int MGS_SYNC_CALLBACK_HANDLER = 6;
    public static final String SEND_MESSAGE_IN_BATCHES_DATA_BYTES_KEY = "batches_data_bytes_key";
    private static final String TAG = "ToolSyncService";
    private HandlerThread callbackHandlerThread;
    private boolean isSendMessageInBatches;
    private static final Map<String, Integer> SYNC_TYPE_PACKAGE_NAME_MAP = new HashMap();
    private static final Map<String, String> SYNC_TYPE_2_REAL_PKG_NAME = new HashMap(10);
    private final Map<String, Map<String, RemoteCallbackList<ISyncServiceCallback>>> mCallbacks = new HashMap();
    private final SyncServiceStub mBinder = new SyncServiceStub();
    private Context appContext = null;
    private final RequestDispatcher mDispatcher = new RequestDispatcher(this);
    private LocalReceiver mLocalReceiver = null;

    @SuppressLint({"HandlerLeak"})
    private Handler callbackHandler = null;
    private final Map<String, StringBuffer> batchesBufferMap = new HashMap();

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
                String string3 = bundle.getString("callbackUuid");
                ToolSyncService.this.isSendMessageInBatches = false;
                ToolSyncService.this.sendCallbackMessage(string, i10, bundle, string2, string3);
                if (ToolSyncService.this.isSendMessageInBatches) {
                    ToolSyncService.this.sendMessageOver(string, i10, i11, string2, string3);
                    ToolSyncService.this.isSendMessageInBatches = false;
                }
            } catch (Exception e10) {
                C11839m.m70687e(ToolSyncService.TAG, "handleMessage:" + e10.toString());
            }
        }
    }

    public class LocalReceiver extends BroadcastReceiver {
        public LocalReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if ("com.huawei.android.hicloud.intent.TOOLSYNCCALLBACK".equals(safeIntent.getAction())) {
                try {
                    int intExtra = safeIntent.getIntExtra("msgID", 0);
                    String stringExtra = safeIntent.getStringExtra("msgType");
                    if (intExtra != 0) {
                        Bundle bundleExtra = safeIntent.getBundleExtra("bundle");
                        if (bundleExtra == null) {
                            return;
                        }
                        Message messageObtainMessage = ToolSyncService.this.callbackHandler.obtainMessage();
                        messageObtainMessage.what = 6;
                        messageObtainMessage.obj = bundleExtra;
                        Bundle bundle = new Bundle();
                        bundle.putInt("msgID", intExtra);
                        bundle.putString("msgType", stringExtra);
                        messageObtainMessage.setData(bundle);
                        if (ToolSyncService.this.callbackHandlerThread.isAlive()) {
                            ToolSyncService.this.callbackHandler.sendMessage(messageObtainMessage);
                        } else {
                            C11839m.m70689w(ToolSyncService.TAG, "sendMessage error service has destroyed");
                        }
                    }
                } catch (Exception e10) {
                    C11839m.m70687e(ToolSyncService.TAG, "onReceive error :" + e10.toString());
                }
            }
        }
    }

    public class SyncServiceStub extends IToolSyncService.Stub {
        public SyncServiceStub() {
        }

        private String getCallbackUuid(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return new JSONObject(str).getString("callbackUuid");
            } catch (Exception e10) {
                C11839m.m70687e(ToolSyncService.TAG, "parseBaseParam err " + e10.getMessage());
                return "";
            }
        }

        private int getIntFromJSONObject(JSONObject jSONObject, String str) throws JSONException {
            if (jSONObject.has(str)) {
                return jSONObject.getInt(str);
            }
            return 0;
        }

        private String getStringFromJSONObject(JSONObject jSONObject, String str) throws JSONException {
            if (jSONObject.has(str)) {
                return jSONObject.getString(str);
            }
            return null;
        }

        private void initSdkVersion(String str, String str2) throws JSONException {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                int i10 = new JSONObject(str2).getInt(ParamConstants.Param.SDK_VERSION);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ToolSyncService.SYNC_TYPE_PACKAGE_NAME_MAP.put(str, Integer.valueOf(i10));
            } catch (Exception e10) {
                C11839m.m70687e(ToolSyncService.TAG, "getSdkVersion err " + e10.getMessage());
            }
        }

        public static /* synthetic */ StringBuffer lambda$downUnstructFileForTransTooLarge$0(String str) {
            return new StringBuffer();
        }

        private void parseBaseParam(String str, C10800n c10800n) {
            if (c10800n == null) {
                c10800n = new C10800n();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                c10800n.m65743h("callbackUuid", jSONObject.getString("callbackUuid"));
                c10800n.m65742g("functionVersion", jSONObject.getInt("functionVersion"));
            } catch (Exception e10) {
                C11839m.m70687e(ToolSyncService.TAG, "parseBaseParam err " + e10.getMessage());
            }
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

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public void downUnstructFile(String str, String str2, List<UnstructData> list, String str3) throws JSONException, RemoteException {
            C11839m.m70688i(ToolSyncService.TAG, "newDownUnstructFile");
            C12767a.m76619c().m76622d(str);
            C12487a.m74966b(ToolSyncService.this.appContext);
            String callingPackageName = ToolSyncService.this.getCallingPackageName();
            initSdkVersion(callingPackageName, str3);
            C10800n c10800n = new C10800n();
            c10800n.m65743h("synctype", str);
            c10800n.m65743h("datatype", str2);
            c10800n.m65743h("unstructlist", list);
            c10800n.m65743h("trace_id_key", C10812z.m65832a("03001"));
            c10800n.m65743h("sync_moudle_package_name", callingPackageName);
            parseBaseParam(str3, c10800n);
            ToolSyncService.this.mDispatcher.m18035b(new C11442e(55000013, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, String str3) throws RemoteException {
            C12767a.m76619c().m76622d(str);
            try {
                String callbackUuid = getCallbackUuid(str3);
                StringBuffer stringBuffer = (StringBuffer) ToolSyncService.this.batchesBufferMap.computeIfAbsent(callbackUuid, new Function() { // from class: com.huawei.android.hicloud.sync.service.aidl.c
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ToolSyncService.SyncServiceStub.lambda$downUnstructFileForTransTooLarge$0((String) obj);
                    }
                });
                if (z10) {
                    downUnstructFile(str, str2, parseUnstructDataListFromJSONArray(new JSONArray(stringBuffer.toString())), str3);
                    ToolSyncService.this.batchesBufferMap.remove(callbackUuid);
                } else {
                    stringBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(ToolSyncService.TAG, "newDownUnstructFileForTransTooLarge:" + th2.toString());
            }
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public void getExceedLimitNum(String str, List<String> list, String str2) throws JSONException {
            String callingPackageName = ToolSyncService.this.getCallingPackageName();
            ToolSyncService toolSyncService = ToolSyncService.this;
            String realCallingPackageName = toolSyncService.getRealCallingPackageName(toolSyncService.appContext, str);
            C11839m.m70688i(ToolSyncService.TAG, "getNewExceedLimitNum syncType = " + str + ", dateTypes = " + list.toString() + ", packageName = " + callingPackageName + ", realPackageName = " + realCallingPackageName);
            initSdkVersion(callingPackageName, str2);
            C10800n c10800n = new C10800n();
            c10800n.m65743h("synctype", str);
            c10800n.m65743h("sync_moudle_package_name", callingPackageName);
            c10800n.m65743h("sync_module_real_package_name", realCallingPackageName);
            c10800n.m65743h("datatypelist", list);
            c10800n.m65743h("trace_id_key", C10812z.m65832a("03001"));
            parseBaseParam(str2, c10800n);
            ToolSyncService.this.mDispatcher.m18035b(new C11442e(55000025, c10800n), str);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws JSONException, RemoteException {
            C11839m.m70688i(ToolSyncService.TAG, "registerSingleCallback");
            C12767a.m76619c().m76622d(str);
            String callingPackageName = ToolSyncService.this.getCallingPackageName();
            if (iSyncServiceCallback == null) {
                C11839m.m70688i(ToolSyncService.TAG, "cb is null");
                return false;
            }
            initSdkVersion(callingPackageName, str2);
            String callbackUuid = getCallbackUuid(str2);
            Map map = (Map) ToolSyncService.this.mCallbacks.get(callingPackageName);
            if (map == null) {
                map = new HashMap();
            }
            RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
            boolean zRegister = remoteCallbackList.register(iSyncServiceCallback);
            map.put(callbackUuid, remoteCallbackList);
            C11839m.m70688i(ToolSyncService.TAG, "add callback , result = " + zRegister);
            ToolSyncService.this.mCallbacks.put(callingPackageName, map);
            return true;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public void reportInfo(String str, String str2, String str3) {
            C12767a.m76619c().m76622d(str);
            C12515a.m75110o().m75172d(new C13746i(ToolSyncService.this.appContext, str, ToolSyncService.this.getCallingPackageName(), str2, "03001", "", C10812z.m65832a("03001")));
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
            C12767a.m76619c().m76622d(str);
            if (iSyncServiceCallback != null) {
                C11839m.m70688i(ToolSyncService.TAG, "unregisterCallback");
                String callbackUuid = getCallbackUuid(str2);
                String callingPackageName = ToolSyncService.this.getCallingPackageName();
                Map map = (Map) ToolSyncService.this.mCallbacks.get(callingPackageName);
                if (map == null || map.get(callbackUuid) == null) {
                    return;
                }
                RemoteCallbackList remoteCallbackList = (RemoteCallbackList) map.get(callbackUuid);
                if (remoteCallbackList != null) {
                    remoteCallbackList.unregister(iSyncServiceCallback);
                    map.remove(remoteCallbackList);
                }
                ToolSyncService.this.mCallbacks.put(callingPackageName, map);
            }
        }
    }

    private Bundle buildBatchBundle(int i10, byte[] bArr, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putByteArray("batches_data_bytes_key", bArr);
        bundle.putBoolean("is_in_batches", true);
        bundle.putBoolean("is_send_over", false);
        bundle.putString("callbackUuid", str);
        return bundle;
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

    public String getCallingPackageName() {
        PackageManager packageManager;
        Context context = this.appContext;
        String nameForUid = (context == null || (packageManager = context.getPackageManager()) == null) ? null : packageManager.getNameForUid(Binder.getCallingUid());
        C11839m.m70688i(TAG, "getCallingPackageName: callingAppPackageName = " + nameForUid);
        return nameForUid;
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

    private void handleTransParcelDataTooLarge(String str, int i10, Bundle bundle, String str2, String str3) {
        C11839m.m70688i(TAG, "handleTranParcelDataTooLarge:  msgID = " + i10);
        byte[] byteDataFromBundle = parseByteDataFromBundle(i10, bundle, str2);
        if (byteDataFromBundle == null || byteDataFromBundle.length <= 0) {
            return;
        }
        int length = byteDataFromBundle.length / 2;
        byte[] bArr = new byte[length];
        int length2 = byteDataFromBundle.length - length;
        byte[] bArr2 = new byte[length2];
        System.arraycopy(byteDataFromBundle, 0, bArr, 0, length);
        System.arraycopy(byteDataFromBundle, byteDataFromBundle.length / 2, bArr2, 0, length2);
        int i11 = bundle.getInt(MapKeyNames.RESULT_CODE, -1);
        Bundle bundleBuildBatchBundle = buildBatchBundle(i11, bArr, str3);
        Bundle bundleBuildBatchBundle2 = buildBatchBundle(i11, bArr2, str3);
        sendCallbackMessage(str, i10, bundleBuildBatchBundle, str2, str3);
        sendCallbackMessage(str, i10, bundleBuildBatchBundle2, str2, str3);
    }

    private void initFileBackupNativeService() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = C0209d.m1277l1() ? Class.forName("com.hihonor.android.os.FileBackupEx") : Class.forName("com.huawei.android.os.FileBackupEx");
            cls.getMethod("startFileBackup", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e10) {
            C11839m.m70689w(TAG, "init filebackup native service err : " + e10.toString());
        }
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

    private byte[] parseByteDataFromBundle(int i10, Bundle bundle, String str) {
        return bundle.getBoolean("is_in_batches", false) ? bundle.getByteArray("batches_data_bytes_key") : i10 == 10005 ? SyncLogicServiceUtil.parseDownloadUnstructResult(bundle) : new byte[0];
    }

    private void registerLocalBroadcastReceiver() {
        if (this.mLocalReceiver == null) {
            this.mLocalReceiver = new LocalReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.hicloud.intent.TOOLSYNCCALLBACK");
        C13108a.m78878b(this).m78880c(this.mLocalReceiver, intentFilter);
    }

    public void sendCallbackMessage(String str, int i10, Bundle bundle, String str2, String str3) {
        if (bundle == null) {
            return;
        }
        try {
            sendMessage(str, i10, bundle, str2, str3);
        } catch (TransactionTooLargeException e10) {
            C11839m.m70689w(TAG, "onReceive TransactionTooLargeException:" + e10.toString() + ", syncPackageName = " + str2);
            this.isSendMessageInBatches = true;
            handleTransParcelDataTooLarge(str, i10, bundle, str2, str3);
        } catch (RemoteException e11) {
            C11839m.m70687e(TAG, "sendMessage exception:" + e11.toString());
            if (CloudSyncUtil.m15942B0(str)) {
                SystemClock.sleep(3000L);
                sendCallbackMessage(str, i10, bundle, str2, str3);
            }
        }
    }

    private void sendMessage(String str, int i10, Bundle bundle, String str2, String str3) throws RemoteException {
        C11839m.m70686d(TAG, "Begin sendMessage , syncType = " + str + " , msgID = " + i10 + ", syncPackageName = " + str2);
        Map<String, RemoteCallbackList<ISyncServiceCallback>> map = this.mCallbacks.get(str2);
        if (map == null) {
            C11839m.m70687e(TAG, "callback is null");
            return;
        }
        for (Map.Entry<String, RemoteCallbackList<ISyncServiceCallback>> entry : map.entrySet()) {
            if (TextUtils.equals(str3, entry.getKey())) {
                RemoteCallbackList<ISyncServiceCallback> value = entry.getValue();
                int iBeginBroadcast = value.beginBroadcast();
                C11839m.m70686d(TAG, "N = " + iBeginBroadcast);
                for (int i11 = 0; i11 < iBeginBroadcast; i11++) {
                    try {
                        C11839m.m70688i(TAG, "handleMessage No:" + i11 + ", MSG content is:" + SyncLogicServiceUtil.getMessageDetial(i10, bundle));
                        ((ISyncServiceCallback) value.getBroadcastItem(i11)).handlerEventMsg(i10, 0, 0, bundle);
                    } catch (Throwable th2) {
                        value.finishBroadcast();
                        throw th2;
                    }
                }
                C12767a.m76619c().m76622d(str);
                value.finishBroadcast();
            }
        }
    }

    public void sendMessageOver(String str, int i10, int i11, String str2, String str3) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(MapKeyNames.RESULT_CODE, i11);
            bundle.putBoolean("is_in_batches", true);
            bundle.putBoolean("is_send_over", true);
            bundle.putString("callbackUuid", str3);
            sendMessage(str, i10, bundle, str2, str3);
        } catch (RemoteException e10) {
            C11839m.m70687e(TAG, "sendMessageOver:" + e10.toString());
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
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            C11839m.m70688i(TAG, "onDestroy");
            unregisterLocalReceiver();
            this.callbackHandlerThread.quitSafely();
            Iterator<Map.Entry<String, Map<String, RemoteCallbackList<ISyncServiceCallback>>>> it = this.mCallbacks.entrySet().iterator();
            while (it.hasNext()) {
                Map<String, RemoteCallbackList<ISyncServiceCallback>> map = this.mCallbacks.get(it.next().getKey());
                if (map != null) {
                    for (Map.Entry<String, RemoteCallbackList<ISyncServiceCallback>> entry : map.entrySet()) {
                        if (entry.getValue() != null) {
                            entry.getValue().kill();
                        }
                    }
                }
            }
            this.mCallbacks.clear();
            SYNC_TYPE_PACKAGE_NAME_MAP.clear();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "onDestroy err : " + e10.toString());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 1;
    }
}
