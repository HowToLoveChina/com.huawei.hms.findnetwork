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
import com.huawei.android.hicloud.sync.service.aidl.IRequireDownService;
import com.huawei.android.hicloud.sync.service.aidl.RequireDownLogicService;
import com.huawei.android.hicloud.task.frame.RequestDispatcher;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
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
import p015ak.C0240y;
import p514o9.C11839m;
import p572qb.C12308f0;
import p609rc.C12487a;
import p664u0.C13108a;
import sb.C12767a;

/* loaded from: classes3.dex */
public class RequireDownLogicService extends Service {
    public static final String IS_BATCHES_SEND_OVER_KEY = "is_send_over";
    public static final String IS_SEND_DATA_IN_BATCHES_KEY = "is_in_batches";
    private static final int MGS_SYNC_CALLBACK_HANDLER = 6;
    public static final String SEND_MESSAGE_IN_BATCHES_DATA_BYTES_KEY = "batches_data_bytes_key";
    private static final String TAG = "RequireDownLogicService";
    private HandlerThread callbackHandlerThread;
    private boolean isSendMessageInBatches;
    private final Map<String, Map<String, RemoteCallbackList<ISyncServiceCallback>>> mCallbacks = new HashMap();
    private final SyncServiceStub mBinder = new SyncServiceStub();
    private Context appContext = null;
    private final RequestDispatcher mDispatcher = new RequestDispatcher(this);
    private LocalReceiver mLocalReceiver = null;
    private final Map<String, StringBuffer> batchesBufferMap = new HashMap(10);

    @SuppressLint({"HandlerLeak"})
    private Handler callbackHandler = null;

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
                RequireDownLogicService.this.isSendMessageInBatches = false;
                RequireDownLogicService.this.sendCallbackMessage(string, i10, bundle, string2, string3);
                if (RequireDownLogicService.this.isSendMessageInBatches) {
                    RequireDownLogicService.this.sendMessageOver(string, i10, i11, string2, string3);
                    RequireDownLogicService.this.isSendMessageInBatches = false;
                }
            } catch (Exception e10) {
                C11839m.m70687e(RequireDownLogicService.TAG, "handleMessage:" + e10.toString());
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
            if ("com.huawei.android.hicloud.intent.REQUIREDOWNLOADCALLBACK".equals(safeIntent.getAction())) {
                try {
                    int intExtra = safeIntent.getIntExtra("msgID", 0);
                    String stringExtra = safeIntent.getStringExtra("msgType");
                    if (intExtra != 0) {
                        Bundle bundleExtra = safeIntent.getBundleExtra("bundle");
                        if (bundleExtra == null) {
                            return;
                        }
                        Message messageObtainMessage = RequireDownLogicService.this.callbackHandler.obtainMessage();
                        messageObtainMessage.what = 6;
                        messageObtainMessage.obj = bundleExtra;
                        Bundle bundle = new Bundle();
                        bundle.putInt("msgID", intExtra);
                        bundle.putString("msgType", stringExtra);
                        messageObtainMessage.setData(bundle);
                        if (RequireDownLogicService.this.callbackHandlerThread.isAlive()) {
                            RequireDownLogicService.this.callbackHandler.sendMessage(messageObtainMessage);
                        } else {
                            C11839m.m70689w(RequireDownLogicService.TAG, "sendMessage error service has destroyed");
                        }
                    }
                } catch (Exception e10) {
                    C11839m.m70687e(RequireDownLogicService.TAG, "onReceive error :" + e10.toString());
                }
            }
        }
    }

    public class SyncServiceStub extends IRequireDownService.Stub {
        public SyncServiceStub() {
        }

        private void abortDownloadFile(C10800n c10800n, String str, String str2, List<UnstructData> list, String str3) {
            String callingPackageName = RequireDownLogicService.this.getCallingPackageName();
            c10800n.m65743h("synctype", str);
            c10800n.m65743h("datatype", str2);
            c10800n.m65743h("sync_moudle_package_name", callingPackageName);
            c10800n.m65743h("requireList", list);
            c10800n.m65743h("session_id", str3);
            c10800n.m65743h("trace_id_key", C10812z.m65832a("03001"));
            RequireDownLogicService.this.mDispatcher.m18035b(new C11442e(55000502, c10800n), str);
        }

        private void abortDownloadFileForTooLarge(boolean z10, String str, String str2, byte[] bArr, String str3, String str4) {
            C12767a.m76619c().m76622d(str);
            StringBuffer stringBuffer = (StringBuffer) RequireDownLogicService.this.batchesBufferMap.computeIfAbsent(str4, new Function() { // from class: com.huawei.android.hicloud.sync.service.aidl.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return RequireDownLogicService.SyncServiceStub.lambda$abortDownloadFileForTooLarge$1((String) obj);
                }
            });
            try {
                if (z10) {
                    List<UnstructData> unstructDataListFromJSONArray = parseUnstructDataListFromJSONArray(new JSONObject(stringBuffer.toString()).getJSONArray("download_file"));
                    C10800n c10800n = new C10800n();
                    c10800n.m65743h("callbackUuid", str4);
                    abortDownloadFile(c10800n, str, str2, unstructDataListFromJSONArray, str3);
                    RequireDownLogicService.this.batchesBufferMap.remove(str4);
                } else {
                    stringBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(RequireDownLogicService.TAG, "ForTransTooLarge:" + th2.toString());
            }
        }

        private void downloadFileForTooLarge(boolean z10, String str, String str2, byte[] bArr, String str3, String str4) {
            C12767a.m76619c().m76622d(str);
            StringBuffer stringBuffer = (StringBuffer) RequireDownLogicService.this.batchesBufferMap.computeIfAbsent(str4, new Function() { // from class: com.huawei.android.hicloud.sync.service.aidl.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return RequireDownLogicService.SyncServiceStub.lambda$downloadFileForTooLarge$0((String) obj);
                }
            });
            try {
                if (z10) {
                    List<UnstructData> unstructDataListFromJSONArray = parseUnstructDataListFromJSONArray(new JSONObject(stringBuffer.toString()).getJSONArray("download_file"));
                    C10800n c10800n = new C10800n();
                    c10800n.m65743h("callbackUuid", str4);
                    downloadFiles(str, str2, unstructDataListFromJSONArray, true, true, str3, c10800n);
                    RequireDownLogicService.this.batchesBufferMap.remove(str4);
                } else {
                    stringBuffer.append(new String(bArr, Constants.UTF_8));
                }
            } catch (Throwable th2) {
                C11839m.m70687e(RequireDownLogicService.TAG, "ForTransTooLarge:" + th2.toString());
            }
        }

        private void downloadFiles(String str, String str2, List<UnstructData> list, boolean z10, boolean z11, String str3, C10800n c10800n) {
            String callingPackageName = RequireDownLogicService.this.getCallingPackageName();
            c10800n.m65743h("synctype", str);
            c10800n.m65743h("datatype", str2);
            c10800n.m65743h("sync_moudle_package_name", callingPackageName);
            c10800n.m65743h("requireList", list);
            c10800n.m65743h("need_progress", Boolean.valueOf(z10));
            c10800n.m65743h("force_download", Boolean.valueOf(z11));
            c10800n.m65743h("session_id", str3);
            c10800n.m65743h("trace_id_key", C10812z.m65832a("03001"));
            RequireDownLogicService.this.mDispatcher.m18035b(new C11442e(55000500, c10800n), str3);
        }

        private String getStringFromJSONObject(JSONObject jSONObject, String str) throws JSONException {
            if (jSONObject.has(str)) {
                return jSONObject.getString(str);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ StringBuffer lambda$abortDownloadFileForTooLarge$1(String str) {
            return new StringBuffer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ StringBuffer lambda$downloadFileForTooLarge$0(String str) {
            return new StringBuffer();
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

        private void recordAppInfo() {
            String callingPackageName = RequireDownLogicService.this.getCallingPackageName();
            String realCallingPackageName = RequireDownLogicService.this.getRealCallingPackageName();
            C10812z.m65848q(callingPackageName, C0240y.m1681c(RequireDownLogicService.this.appContext, realCallingPackageName), realCallingPackageName);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void cancelDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
            C12767a.m76619c().m76622d(str);
            C11839m.m70688i(RequireDownLogicService.TAG, "cancelDownloadFile syncType = " + str + ", dataType = " + str2);
            recordAppInfo();
            C10800n c10800n = new C10800n();
            c10800n.m65743h("callbackUuid", str4);
            abortDownloadFile(c10800n, str, str2, list, str3);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void cancelDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException {
            C11839m.m70688i(RequireDownLogicService.TAG, "cancelDownloadFileForTransTooLarge dataType = " + str2 + ", sessionId = " + str3);
            recordAppInfo();
            new C10800n().m65743h("callbackUuid", str4);
            abortDownloadFileForTooLarge(z10, str, str2, bArr, str3, str4);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void downLoadFile(String str, String str2, List<UnstructData> list, boolean z10, boolean z11, String str3, String str4) throws RemoteException {
            C11839m.m70688i(RequireDownLogicService.TAG, "downLoadFile syncType = " + str + ", dataType = " + str2 + ", needProgress = " + z10 + ", forceDown = " + z11 + ", sessionId = " + str3);
            C12767a.m76619c().m76622d(str);
            recordAppInfo();
            C10800n c10800n = new C10800n();
            c10800n.m65743h("callbackUuid", str4);
            downloadFiles(str, str2, list, z10, z11, str3, c10800n);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void downLoadFileForTransTooLarge(String str, String str2, boolean z10, boolean z11, String str3, byte[] bArr, boolean z12, String str4) throws RemoteException {
            C11839m.m70688i(RequireDownLogicService.TAG, "downLoadFileForTransTooLarge dataType = " + str2 + ", sessionId = " + str3);
            recordAppInfo();
            downloadFileForTooLarge(z12, str, str2, bArr, str3, str4);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void pauseDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
            C11839m.m70688i(RequireDownLogicService.TAG, "pauseDownloadFile syncType = " + str + ", dataType = " + str2 + ", packageName = " + RequireDownLogicService.this.getCallingPackageName());
            recordAppInfo();
            C10800n c10800n = new C10800n();
            c10800n.m65743h("callbackUuid", str4);
            abortDownloadFile(c10800n, str, str2, list, str3);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void pauseDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException {
            C11839m.m70688i(RequireDownLogicService.TAG, "pauseDownloadFileForTransTooLarge dataType = " + str2 + ", sessionId = " + str3);
            recordAppInfo();
            abortDownloadFileForTooLarge(z10, str, str2, bArr, str3, str4);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public boolean registerSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
            C11839m.m70688i(RequireDownLogicService.TAG, "registerSingleCallback");
            C12767a.m76619c().m76622d(str);
            String callingPackageName = RequireDownLogicService.this.getCallingPackageName();
            if (iSyncServiceCallback == null) {
                C11839m.m70688i(RequireDownLogicService.TAG, "cb is null");
                return false;
            }
            Map map = (Map) RequireDownLogicService.this.mCallbacks.get(callingPackageName);
            if (map == null) {
                map = new HashMap();
            }
            RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
            boolean zRegister = remoteCallbackList.register(iSyncServiceCallback);
            map.put(str2, remoteCallbackList);
            C11839m.m70688i(RequireDownLogicService.TAG, "add callback , result = " + zRegister);
            RequireDownLogicService.this.mCallbacks.put(callingPackageName, map);
            return true;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void startDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
            C12767a.m76619c().m76622d(str);
            C11839m.m70688i(RequireDownLogicService.TAG, "startDownloadFile syncType = " + str + ", dataType = " + str2 + ", sessionId = " + str3);
            recordAppInfo();
            C10800n c10800n = new C10800n();
            c10800n.m65743h("callbackUuid", str4);
            downloadFiles(str, str2, list, true, true, str3, c10800n);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void startDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException {
            C11839m.m70688i(RequireDownLogicService.TAG, "startDownloadFileForTransTooLarge dataType = " + str2 + ", sessionId = " + str3);
            recordAppInfo();
            downloadFileForTooLarge(z10, str, str2, bArr, str3, str4);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void unregisterSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
            C12767a.m76619c().m76622d(str);
            if (iSyncServiceCallback != null) {
                C11839m.m70688i(RequireDownLogicService.TAG, "unregisterSingleCallback");
                String callingPackageName = RequireDownLogicService.this.getCallingPackageName();
                Map map = (Map) RequireDownLogicService.this.mCallbacks.get(callingPackageName);
                if (map == null || map.get(str2) == null) {
                    return;
                }
                RemoteCallbackList remoteCallbackList = (RemoteCallbackList) map.get(str2);
                if (remoteCallbackList != null) {
                    remoteCallbackList.unregister(iSyncServiceCallback);
                    map.remove(remoteCallbackList);
                }
                RequireDownLogicService.this.mCallbacks.put(callingPackageName, map);
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

    /* JADX INFO: Access modifiers changed from: private */
    public String getCallingPackageName() {
        PackageManager packageManager;
        Context context = this.appContext;
        String nameForUid = (context == null || (packageManager = context.getPackageManager()) == null) ? null : packageManager.getNameForUid(Binder.getCallingUid());
        C11839m.m70688i(TAG, "getCallingPackageName: callingAppPackageName = " + nameForUid);
        return nameForUid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getRealCallingPackageName() {
        Context context = this.appContext;
        if (context != null) {
            return C0209d.m1256g0(context, Binder.getCallingPid());
        }
        return null;
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
            C11839m.m70687e(TAG, "init filebackup native service err : " + e10.toString());
        }
    }

    private byte[] parseByteDataFromBundle(int i10, Bundle bundle, String str) {
        byte[] bArr = new byte[0];
        if (bundle.getBoolean("is_in_batches", false)) {
            return bundle.getByteArray("batches_data_bytes_key");
        }
        if (i10 == 10025) {
            return SyncLogicServiceUtil.parseDownloadFileAbortResult(bundle);
        }
        switch (i10) {
            case 10018:
                return SyncLogicServiceUtil.parseDownloadFileProgressResult(bundle);
            case 10019:
                return SyncLogicServiceUtil.parseDownloadFileSuccessResult(bundle);
            case 10020:
                return SyncLogicServiceUtil.parseDownloadFileFailResult(bundle);
            case 10021:
                return SyncLogicServiceUtil.parseDownloadFileCompleteResult(bundle);
            default:
                return bArr;
        }
    }

    private void registerLocalBroadcastReceiver() {
        if (this.mLocalReceiver == null) {
            this.mLocalReceiver = new LocalReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.hicloud.intent.REQUIREDOWNLOADCALLBACK");
        C13108a.m78878b(this).m78880c(this.mLocalReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageOver(String str, int i10, int i11, String str2, String str3) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(MapKeyNames.RESULT_CODE, i11);
            bundle.putBoolean("is_in_batches", true);
            bundle.putBoolean("is_send_over", true);
            bundle.putString("callbackUuid", str3);
            sendMessage(str, i10, bundle, str2, str3);
        } catch (RemoteException e10) {
            C11839m.m70687e(TAG, "sendMessageOver exception: " + e10.toString());
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
            C12308f0.m74000d().m74006g();
            this.mCallbacks.clear();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "onDestroy err : " + e10.toString());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 1;
    }
}
