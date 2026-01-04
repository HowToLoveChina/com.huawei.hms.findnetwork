package com.huawei.android.hicloud.cloudbackup.process;

import am.InterfaceC0278j1;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.internal.LinkedTreeMap;
import com.huawei.android.backup.backupremoteservice.IRemoteClientCallback;
import com.huawei.android.backup.backupremoteservice.IRemoteService;
import com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback;
import com.huawei.android.backup.service.logic.BackupLogicService;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.cloudbackup.process.clone.ClonePowerKit;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9721b;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0213f;
import p037bp.C1270a;
import p232dp.InterfaceC9284c;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p582ql.C12370a;
import p617rl.C12526j;
import p618rm.C12540b1;
import p618rm.C12590s0;
import p709vj.C13452e;
import p746wn.C13622a;
import p848zl.C14333b;
import p851zp.InterfaceC14355b;

/* loaded from: classes2.dex */
public class CloneService {
    private static final int CLIENT_ID = 1001;
    public static final String KEY_ACTION_FLAG = "ActionFlag";
    private static final int PROGRESS_OUTPUT_TIME_INTERVAL = 2000;
    private static final int SECONDS = 10;
    private static final String TAG = "CloneService";
    private static final int WAIT_NUMBER_MODULE_INFO_OTHER = 1800;
    private static final int WAIT_NUMBER_MODULE_INFO_PHONEMANAGER = 1800;
    private static final int WAIT_NUMBER_MODULE_INFO_SECOND = 1800;
    private static final int WAIT_SHORT = 400;
    private static final int WAIT_TIME = 500;
    private InterfaceC0278j1 cloneCopyProgressCallback;
    private ServiceConnection connection;
    private HandlerThread handlerThread;
    private IRemoteService service;
    private static final CloneService INSTANCE = new CloneService();
    private static final Object LOCK = new Object();
    private static final Object PROGRESS_LOCK = new Object();
    private CountDownLatch currentDownLatch = null;
    private final List<Handler> mCallbacks = new ArrayList();
    private final Context mContext = C0213f.m1377a();
    private boolean isBound = false;
    private boolean isRegister = false;
    private long lastProgressCallbackTime = 0;
    private ArrayList<C12370a> moduleInfoList = new ArrayList<>();
    private final IRemoteServiceCallback serviceCallback = new IRemoteServiceCallback.AbstractBinderC2103a() { // from class: com.huawei.android.hicloud.cloudbackup.process.CloneService.1
        public BinderC24971() {
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback
        public void callback(int i10, int i11, int i12, String str, Bundle bundle, IRemoteClientCallback iRemoteClientCallback) throws RemoteException {
            Bundle bundle2 = new Bundle(bundle);
            if (str != null) {
                bundle2.putString("appId", str);
            }
            C11839m.m70686d(CloneService.TAG, "IRemoteService callback, appId = " + str + " what = " + i10 + " arg1 = " + i11 + " arg2 = " + i12);
            CloneService.this.updateCloneProgress((long) i11, (long) i12);
            synchronized (CloneService.this.mCallbacks) {
                try {
                    for (Handler handler : CloneService.this.mCallbacks) {
                        if (handler != null) {
                            handler.handleMessage(Message.obtain(null, i10, i11, i12, bundle2));
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    /* renamed from: com.huawei.android.hicloud.cloudbackup.process.CloneService$1 */
    public class BinderC24971 extends IRemoteServiceCallback.AbstractBinderC2103a {
        public BinderC24971() {
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback
        public void callback(int i10, int i11, int i12, String str, Bundle bundle, IRemoteClientCallback iRemoteClientCallback) throws RemoteException {
            Bundle bundle2 = new Bundle(bundle);
            if (str != null) {
                bundle2.putString("appId", str);
            }
            C11839m.m70686d(CloneService.TAG, "IRemoteService callback, appId = " + str + " what = " + i10 + " arg1 = " + i11 + " arg2 = " + i12);
            CloneService.this.updateCloneProgress((long) i11, (long) i12);
            synchronized (CloneService.this.mCallbacks) {
                try {
                    for (Handler handler : CloneService.this.mCallbacks) {
                        if (handler != null) {
                            handler.handleMessage(Message.obtain(null, i10, i11, i12, bundle2));
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.process.CloneService$2 */
    public class ServiceConnectionC24982 implements ServiceConnection {
        final /* synthetic */ CountDownLatch val$downLatch;

        public ServiceConnectionC24982(CountDownLatch countDownLatch) {
            countDownLatch = countDownLatch;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C11839m.m70688i(CloneService.TAG, "clone service bind isSuccess.");
            try {
                try {
                    if (CloneService.this.isBound) {
                        C11839m.m70687e(CloneService.TAG, " service already connect.");
                    } else {
                        CloneService.this.service = IRemoteService.AbstractBinderC2101a.m12576a(iBinder);
                        if (CloneService.this.service.registerCallback(1001, 1, CloneService.this.serviceCallback) == 0) {
                            C11839m.m70688i(CloneService.TAG, " register callback isSuccess.");
                            CloneService.this.isBound = true;
                        } else {
                            C11839m.m70689w(CloneService.TAG, " register callback service occupied.");
                            CloneService.this.isBound = false;
                        }
                    }
                } catch (RemoteException unused) {
                    CloneService.this.isBound = false;
                }
                countDownLatch.countDown();
            } catch (Throwable th2) {
                countDownLatch.countDown();
                throw th2;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C11839m.m70687e(CloneService.TAG, "backup service disconnected.");
            CloneService.this.isBound = false;
        }
    }

    public static class AppRiskInfoHandler extends Handler {
        CountDownLatch downLatch;
        Bundle[] infos;

        public AppRiskInfoHandler(CountDownLatch countDownLatch, Bundle[] bundleArr, Looper looper) {
            super(looper);
            this.downLatch = countDownLatch;
            this.infos = bundleArr;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1074) {
                this.infos[0] = (Bundle) message.obj;
                this.downLatch.countDown();
            }
        }
    }

    public static class BackupModuleInfoHandler extends Handler {
        CountDownLatch downLatch;
        Bundle[] infos;
        boolean isFromBackup;
        String module;

        public BackupModuleInfoHandler(CountDownLatch countDownLatch, Bundle[] bundleArr, String str, boolean z10, Looper looper) {
            super(looper);
            this.downLatch = countDownLatch;
            this.infos = bundleArr;
            this.module = str;
            this.isFromBackup = z10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1061) {
                Bundle[] bundleArr = this.infos;
                Bundle bundle = (Bundle) message.obj;
                bundleArr[0] = bundle;
                if (bundle == null) {
                    C11839m.m70687e(CloneService.TAG, "request module: " + this.module + ", bundle from clone is null.");
                    this.infos[0] = new Bundle();
                }
                this.downLatch.countDown();
                C11839m.m70688i(CloneService.TAG, "request module: " + this.module + ", bundle: " + this.infos[0].getBundle(this.module) + ", isFromBackup: " + this.isFromBackup);
            }
        }
    }

    public static class BackupOneModuleHandler extends Handler {
        CloneErr cloneErr;
        CountDownLatch downLatch;

        public BackupOneModuleHandler(CountDownLatch countDownLatch, CloneErr cloneErr, Looper looper) {
            super(looper);
            this.downLatch = countDownLatch;
            this.cloneErr = cloneErr;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == 0) {
                C11839m.m70686d(CloneService.TAG, "doBackupOneModule. total = " + message.arg2);
                return;
            }
            if (i10 == 4) {
                this.downLatch.countDown();
                return;
            }
            if (i10 == 15 || i10 == 23 || i10 == 36 || i10 == 11 || i10 == 12) {
                C11839m.m70689w(CloneService.TAG, "doBackupOneModule error. errCode = " + message.what);
                CloneErr cloneErr = this.cloneErr;
                cloneErr.isSuccess = false;
                cloneErr.retCode = message.what;
                this.downLatch.countDown();
            }
        }
    }

    public interface CloneCallback {
        void onCallback(Message message, int i10);

        void onError(int i10);
    }

    public static class CloneErr {
        public int retCode;
        public boolean isSuccess = true;
        public int failedRecordsNum = 0;
        public boolean isBundleAppRestore = false;
    }

    public static class CloneErrorReportHandler extends Handler {
        public CloneErrorReportHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1100:
                case 1101:
                    CloudBackupReport.reportCloneInfo(message, (Bundle) message.obj);
                    break;
                case 1102:
                    CloudBackupReport.reportCloneFinishInfo(message);
                    CloneService.getInstance().onReceiveModuleInfo(message);
                    break;
            }
        }
    }

    public static class NewDeviceInfoHandler extends Handler {
        CountDownLatch downLatch;
        Bundle[] infos;

        public NewDeviceInfoHandler(CountDownLatch countDownLatch, Bundle[] bundleArr, Looper looper) {
            super(looper);
            this.downLatch = countDownLatch;
            this.infos = bundleArr;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1073) {
                this.infos[0] = (Bundle) message.obj;
                this.downLatch.countDown();
            }
        }
    }

    public static class RestoreOneModuleHandler extends Handler {
        CloneCallback callback;
        CloneErr cloneErr;
        CountDownLatch downLatch;

        public RestoreOneModuleHandler(CountDownLatch countDownLatch, CloneErr cloneErr, CloneCallback cloneCallback, Looper looper) {
            super(looper);
            this.downLatch = countDownLatch;
            this.cloneErr = cloneErr;
            this.callback = cloneCallback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                case 25:
                    this.callback.onCallback(message, this.cloneErr.failedRecordsNum);
                    break;
                case 3:
                    this.downLatch.countDown();
                    break;
                case 7:
                case 9:
                case 11:
                case 15:
                case 36:
                case 1067:
                    C11839m.m70689w(CloneService.TAG, "doRestoreOneModule error. errCode = " + message.what);
                    this.callback.onError(message.what);
                    CloneErr cloneErr = this.cloneErr;
                    cloneErr.isSuccess = false;
                    cloneErr.retCode = message.what;
                    this.downLatch.countDown();
                    break;
                case 13:
                case 27:
                    C11839m.m70689w(CloneService.TAG, "doRestoreOneModule error. errCode = " + message.what + " cloneErr.retCode = " + this.cloneErr.retCode);
                    if (this.cloneErr.retCode != 7) {
                        this.callback.onError(message.what);
                        CloneErr cloneErr2 = this.cloneErr;
                        cloneErr2.isSuccess = false;
                        cloneErr2.retCode = message.what;
                        cloneErr2.failedRecordsNum++;
                        break;
                    }
                    break;
            }
        }
    }

    private CloneService() {
    }

    private int checkFileSize(File file) throws C9721b {
        C11839m.m70688i(TAG, "clone backup check file path: " + C10279b.m63452a(file));
        if (!file.exists()) {
            return 0;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return 0;
            }
            int iCheckFileSize = 0;
            for (File file2 : fileArrListFiles) {
                iCheckFileSize += checkFileSize(file2);
            }
            return iCheckFileSize;
        }
        if (file.length() != 0) {
            return 1;
        }
        C11839m.m70687e(TAG, "clone backup data error, file length is zero, file path: " + C10279b.m63452a(file));
        throw new C9721b(2012, "clone backup data error, file length is zero, file path: " + C10279b.m63452a(file));
    }

    private int convertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private void executeWithPowerKit(String str, InterfaceC14355b interfaceC14355b) throws C9721b {
        try {
            if (TextUtils.isEmpty(str)) {
                ClonePowerKit.getInstance().keepAllAlive();
            } else {
                ClonePowerKit.getInstance().keepAlive(str);
            }
            interfaceC14355b.execute();
            if (TextUtils.isEmpty(str)) {
                ClonePowerKit.getInstance().unKeepAliveAll();
            } else {
                ClonePowerKit.getInstance().unKeepAlive(str);
            }
        } catch (Throwable th2) {
            if (TextUtils.isEmpty(str)) {
                ClonePowerKit.getInstance().unKeepAliveAll();
            } else {
                ClonePowerKit.getInstance().unKeepAlive(str);
            }
            throw th2;
        }
    }

    public static CloneService getInstance() {
        return INSTANCE;
    }

    private Looper initLooper() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return Looper.getMainLooper();
        }
        if (this.handlerThread == null) {
            HandlerThread handlerThread = new HandlerThread(TAG);
            this.handlerThread = handlerThread;
            handlerThread.start();
        }
        return this.handlerThread.getLooper();
    }

    public /* synthetic */ void lambda$doBackupOneModule$1(String str, String str2, Bundle bundle, Handler handler, CountDownLatch countDownLatch) throws C9721b {
        try {
            int iDoBackupOneModule = this.service.doBackupOneModule(1001, str, str2, str2, bundle);
            if (iDoBackupOneModule == 0) {
                syncLock(countDownLatch);
                return;
            }
            unregisterCallback(handler);
            countDownLatch.countDown();
            C11839m.m70687e(TAG, "doBackupOneModule, backup logic service occupied: " + iDoBackupOneModule);
            throw new C9721b(2003, "doBackupOneModule,backup logic service occupied: " + iDoBackupOneModule, "doBackupOneModule");
        } catch (RemoteException e10) {
            unregisterCallback(handler);
            countDownLatch.countDown();
            C11839m.m70687e(TAG, "clone service remote exception. " + e10);
            throw new C9721b(2001, e10.getMessage(), "doBackupOneModule");
        }
    }

    public /* synthetic */ void lambda$doRestoreOneModule$2(Handler handler, String str, String str2, Bundle bundle, CountDownLatch countDownLatch) throws C9721b {
        try {
            registerCallback(handler);
            int iDoRestoreOneModule = this.service.doRestoreOneModule(1001, str, str2, str2, bundle);
            if (iDoRestoreOneModule == 0) {
                syncLock(countDownLatch);
                return;
            }
            unregisterCallback(handler);
            countDownLatch.countDown();
            C11839m.m70687e(TAG, "doRestoreOneModule, backup logic service occupied: " + iDoRestoreOneModule + " ,appId " + str2);
            throw new C9721b(2003, "doRestoreOneModule,backup logic service occupied: " + iDoRestoreOneModule + " ,appId " + str2, "doRestoreOneModule");
        } catch (RemoteException e10) {
            unregisterCallback(handler);
            countDownLatch.countDown();
            C11839m.m70687e(TAG, "clone service remote exception. " + e10);
            throw new C9721b(2001, e10.getMessage(), "doRestoreOneModule");
        }
    }

    public /* synthetic */ void lambda$getModuleInfoFromClone$0(Handler handler, String str, CountDownLatch countDownLatch, long j10, boolean z10) throws C9721b {
        try {
            registerCallback(handler);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_ACTION_FLAG, 10);
            int backupModuleInfo = this.service.getBackupModuleInfo(1001, new String[]{str}, bundle);
            if (backupModuleInfo == 0) {
                syncLockForModuleInfo(countDownLatch, j10, z10);
                return;
            }
            unregisterCallback(handler);
            countDownLatch.countDown();
            C11839m.m70687e(TAG, "getModuleInfoFromClone, backup logic service occupied: " + backupModuleInfo + " ,module :" + str);
            throw new C9721b(2003, "getModuleInfoFromClone,backup logic service occupied: " + backupModuleInfo + " ,module :" + str, "getBackupModuleInfo");
        } catch (RemoteException e10) {
            unregisterCallback(handler);
            countDownLatch.countDown();
            C11839m.m70687e(TAG, "clone service remote exception. " + e10);
            throw new C9721b(2001, e10.getMessage(), "getBackupModuleInfo");
        }
    }

    public /* synthetic */ void lambda$getNewDeviceInfo$3(Handler handler, CountDownLatch countDownLatch) throws C9721b {
        try {
            registerCallback(handler);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_ACTION_FLAG, 11);
            int newDeviceInfo = this.service.getNewDeviceInfo(1001, bundle);
            if (newDeviceInfo == 0) {
                syncLock(countDownLatch);
                unregisterCallback(handler);
                return;
            }
            unregisterCallback(handler);
            countDownLatch.countDown();
            C11839m.m70687e(TAG, "getNewDeviceInfo, backup logic service occupied: " + newDeviceInfo);
            throw new C9721b(2003, "getNewDeviceInfo,backup logic service occupied: " + newDeviceInfo, "getNewDeviceInfo");
        } catch (RemoteException e10) {
            unregisterCallback(handler);
            countDownLatch.countDown();
            C11839m.m70687e(TAG, "clone service remote exception. " + e10);
            throw new C9721b(2001, e10.getMessage(), "getNewDeviceInfo");
        }
    }

    private void onConnect(CountDownLatch countDownLatch) {
        this.connection = new ServiceConnection() { // from class: com.huawei.android.hicloud.cloudbackup.process.CloneService.2
            final /* synthetic */ CountDownLatch val$downLatch;

            public ServiceConnectionC24982(CountDownLatch countDownLatch2) {
                countDownLatch = countDownLatch2;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                C11839m.m70688i(CloneService.TAG, "clone service bind isSuccess.");
                try {
                    try {
                        if (CloneService.this.isBound) {
                            C11839m.m70687e(CloneService.TAG, " service already connect.");
                        } else {
                            CloneService.this.service = IRemoteService.AbstractBinderC2101a.m12576a(iBinder);
                            if (CloneService.this.service.registerCallback(1001, 1, CloneService.this.serviceCallback) == 0) {
                                C11839m.m70688i(CloneService.TAG, " register callback isSuccess.");
                                CloneService.this.isBound = true;
                            } else {
                                C11839m.m70689w(CloneService.TAG, " register callback service occupied.");
                                CloneService.this.isBound = false;
                            }
                        }
                    } catch (RemoteException unused) {
                        CloneService.this.isBound = false;
                    }
                    countDownLatch.countDown();
                } catch (Throwable th2) {
                    countDownLatch.countDown();
                    throw th2;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                C11839m.m70687e(CloneService.TAG, "backup service disconnected.");
                CloneService.this.isBound = false;
            }
        };
    }

    private void registerCallback(Handler handler) {
        if (handler != null) {
            synchronized (this.mCallbacks) {
                C11839m.m70686d(TAG, "register callback");
                this.mCallbacks.add(handler);
            }
        }
    }

    private void registerProgressCallback(InterfaceC0278j1 interfaceC0278j1) {
        synchronized (PROGRESS_LOCK) {
            if (interfaceC0278j1 != null) {
                try {
                    C11839m.m70686d(TAG, "registerProgressCallback");
                    this.cloneCopyProgressCallback = interfaceC0278j1;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private void releaseSyncLock() {
        CountDownLatch countDownLatch = this.currentDownLatch;
        if (countDownLatch == null) {
            return;
        }
        countDownLatch.countDown();
    }

    private void reportBackupGetModuleInfoTimeOut(String str, String str2) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02011"), "backupGetModuleInfoTimeOut", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_2014");
        c11060cM66626a.m66635A("appId: " + str + ", errorReason: " + str2);
        C11839m.m70688i(TAG, str2);
        C13622a.m81968n(this.mContext, c11060cM66626a);
    }

    private void syncLock(CountDownLatch countDownLatch) {
        if (countDownLatch == null) {
            return;
        }
        this.currentDownLatch = countDownLatch;
        while (countDownLatch.getCount() > 0 && this.isBound) {
            try {
                if (!countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                    C11839m.m70686d(TAG, "syncLock await false");
                }
            } catch (InterruptedException unused) {
                C11839m.m70688i(TAG, "syncLock wait catch InterruptedException.");
            }
        }
        this.currentDownLatch = null;
    }

    private void syncLockForModuleInfo(CountDownLatch countDownLatch, long j10, boolean z10) throws C9721b {
        if (countDownLatch == null) {
            return;
        }
        long j11 = j10 / 500;
        this.currentDownLatch = countDownLatch;
        if (countDownLatch.getCount() > 0 && this.isBound) {
            int i10 = 0;
            while (true) {
                if (i10 >= j11) {
                    break;
                }
                try {
                    if (!countDownLatch.await(500L, TimeUnit.MILLISECONDS)) {
                        if (!z10 && CBAccess.hasTaskWorking()) {
                            C11839m.m70688i(TAG, "syncLock for moduleInfo await break, has task working.");
                            break;
                        }
                        i10++;
                    } else {
                        C11839m.m70686d(TAG, "syncLock for moduleInfo await finish.");
                        break;
                    }
                } catch (InterruptedException unused) {
                    C11839m.m70687e(TAG, "syncLock wait catch InterruptedException.");
                }
            }
            if (countDownLatch.getCount() > 0 && this.isBound) {
                throw new C9721b(2014, "syncLock for moduleInfo await time out", "getBackupModuleInfo");
            }
        }
        this.currentDownLatch = null;
    }

    private void unregisterCallback(Handler handler) {
        if (handler != null) {
            synchronized (this.mCallbacks) {
                C11839m.m70686d(TAG, "unregister callback");
                this.mCallbacks.remove(handler);
            }
        }
        unregisterProgressCallback();
    }

    private void unregisterProgressCallback() {
        synchronized (PROGRESS_LOCK) {
            try {
                if (this.cloneCopyProgressCallback != null) {
                    C11839m.m70686d(TAG, "unregisterProgressCallback");
                    this.cloneCopyProgressCallback = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void updateCloneProgress(long j10, long j11) {
        synchronized (PROGRESS_LOCK) {
            try {
                if (this.cloneCopyProgressCallback == null) {
                    return;
                }
                if (j10 > 0 && j11 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - this.lastProgressCallbackTime < RippleView.SINGLE_RIPPLE_TIME) {
                        return;
                    }
                    this.lastProgressCallbackTime = jCurrentTimeMillis;
                    this.cloneCopyProgressCallback.mo1768a(j10, j11);
                }
            } finally {
            }
        }
    }

    public synchronized Bundle checkAppRiskInfo(Bundle bundle) throws C9721b {
        Bundle[] bundleArr;
        doBindService("checkAppRiskInfo");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        bundleArr = new Bundle[]{null};
        AppRiskInfoHandler appRiskInfoHandler = new AppRiskInfoHandler(countDownLatch, bundleArr, initLooper());
        try {
            C11839m.m70688i(TAG, "backup service checkAppRiskInfo.");
            registerCallback(appRiskInfoHandler);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(KEY_ACTION_FLAG, 11);
            bundle2.putBundle("AppPackageList", bundle);
            int iCheckAppRiskInfo = this.service.checkAppRiskInfo(1001, bundle2);
            if (iCheckAppRiskInfo != 0) {
                unregisterCallback(appRiskInfoHandler);
                countDownLatch.countDown();
                C11839m.m70687e(TAG, "checkAppRiskInfo, backup logic service occupied: " + iCheckAppRiskInfo);
                throw new C9721b(2003, "checkAppRiskInfo,backup logic service occupied: " + iCheckAppRiskInfo, "checkAppRiskInfo");
            }
            syncLock(countDownLatch);
            if (!this.isBound) {
                unregisterCallback(appRiskInfoHandler);
                throw new C9721b(2010, "connect timeout.", "checkAppRiskInfo");
            }
            if (bundleArr[0] == null) {
                unregisterCallback(appRiskInfoHandler);
                throw new C9721b(FamilyShareConstants.MessageCode.ENABLE_SPACE_SHARE_FAILED, "result is empty.", "checkAppRiskInfo");
            }
            unregisterCallback(appRiskInfoHandler);
        } catch (RemoteException e10) {
            unregisterCallback(appRiskInfoHandler);
            countDownLatch.countDown();
            C11839m.m70687e(TAG, "clone service remote exception. " + e10);
            throw new C9721b(2001, e10.getMessage(), "checkAppRiskInfo");
        }
        return bundleArr[0];
    }

    public void clearModuleInfoList() {
        this.moduleInfoList.clear();
    }

    public void doBackupOneModule(final String str, final String str2, final Bundle bundle, InterfaceC0278j1 interfaceC0278j1) throws C9721b {
        doBindService("doBackupOneModule");
        boolean zMo17121e0 = true;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CloneErr cloneErr = new CloneErr();
        final BackupOneModuleHandler backupOneModuleHandler = new BackupOneModuleHandler(countDownLatch, cloneErr, initLooper());
        C11839m.m70688i(TAG, "cloudbackup doBackupOneModule. appId = " + str);
        registerCallback(backupOneModuleHandler);
        registerProgressCallback(interfaceC0278j1);
        executeWithPowerKit(str, new InterfaceC14355b() { // from class: com.huawei.android.hicloud.cloudbackup.process.w
            @Override // p851zp.InterfaceC14355b
            public final void execute() throws C9721b {
                this.f11761a.lambda$doBackupOneModule$1(str2, str, bundle, backupOneModuleHandler, countDownLatch);
            }
        });
        if (!this.isBound) {
            unregisterCallback(backupOneModuleHandler);
            throw new C9721b(2010, "doBackupOneModule disconnect. appId = " + str, "doBackupOneModule");
        }
        unregisterCallback(backupOneModuleHandler);
        if (cloneErr.isSuccess) {
            if (C14333b.m85446B().contains(str)) {
                String str3 = str2 + File.separator + str;
                if (checkFileSize(new File(str3)) <= 0) {
                    C11839m.m70687e(TAG, "clone backup data error, file count is zero, file path: " + str3);
                    if (!HNConstants.DataType.CONTACT.equalsIgnoreCase(str)) {
                        throw new C9721b(2013, "clone backup data error, file count is zero, " + str3);
                    }
                    InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
                    if (interfaceC9284c != null) {
                        C11839m.m70689w(TAG, "cloudSyncRouter is null");
                        zMo17121e0 = interfaceC9284c.mo17121e0();
                    }
                    throw new C9721b(2013, "clone backup data error, file count is zero, " + str3 + ", contact has data: " + zMo17121e0);
                }
                return;
            }
            return;
        }
        int i10 = cloneErr.retCode;
        String str4 = "CloneService return fail, retcode: " + i10 + " | appid: " + str;
        C11839m.m70687e(TAG, "doBackupOneModule fail upMsg: " + str4);
        if (i10 != 15) {
            throw new C9721b(2013, str4, "doBackupOneModule");
        }
        long j10 = bundle.getLong("ModuleSize", 0L);
        if ("soundrecorder".equals(str) || "callRecorder".equals(str)) {
            j10 = 0;
        }
        long jM75856h0 = j10 + C12590s0.m75856h0();
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        C11839m.m70686d(TAG, "local not enough moduleSize: " + jM75856h0 + " localLeftSpace: " + localLeftSpace);
        if (localLeftSpace != null) {
            long jLongValue = jM75856h0 - localLeftSpace.longValue();
            if (jLongValue > 0) {
                C12590s0.m75777N2(jLongValue);
            }
        }
        throw new C9721b(1007, str4, "doBackupOneModule");
    }

    public void doBindService(String str) throws C9721b {
        synchronized (LOCK) {
            try {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                if (this.isBound) {
                    countDownLatch.countDown();
                } else {
                    onConnect(countDownLatch);
                    ComponentName componentName = new ComponentName(this.mContext.getPackageName(), BackupLogicService.class.getName());
                    Intent intent = new Intent();
                    intent.setComponent(componentName);
                    if (!this.mContext.bindService(intent, this.connection, 1)) {
                        countDownLatch.countDown();
                        C11839m.m70687e(TAG, "bind clone service failed.");
                        throw new C9721b(2004, "bind clone service failed.", str);
                    }
                    if (!this.isRegister) {
                        registerCallback(new CloneErrorReportHandler(initLooper()));
                        this.isRegister = true;
                    }
                }
                try {
                    if (!countDownLatch.await(10L, TimeUnit.SECONDS)) {
                        C11839m.m70686d(TAG, "doBindService await false");
                    }
                } catch (InterruptedException e10) {
                    C11839m.m70689w(TAG, "bind service wait interrupted." + e10);
                }
                if (!this.isBound) {
                    throw new C9721b(2009, "connect clone service error.", str);
                }
                if (this.service == null) {
                    C11839m.m70689w(TAG, "clone service is null.");
                    throw new C9721b(2004, "backup service is null", str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized CloneErr doRestoreOneModule(final String str, final String str2, final Bundle bundle, CloneCallback cloneCallback) throws C9721b {
        CloneErr cloneErr;
        doBindService("doRestoreOneModule");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        cloneErr = new CloneErr();
        final RestoreOneModuleHandler restoreOneModuleHandler = new RestoreOneModuleHandler(countDownLatch, cloneErr, cloneCallback, initLooper());
        C11839m.m70688i(TAG, "cloudbackup doRestoreOneModule, appId = " + str);
        executeWithPowerKit(str, new InterfaceC14355b() { // from class: com.huawei.android.hicloud.cloudbackup.process.y
            @Override // p851zp.InterfaceC14355b
            public final void execute() throws C9721b {
                this.f11774a.lambda$doRestoreOneModule$2(restoreOneModuleHandler, str2, str, bundle, countDownLatch);
            }
        });
        C11839m.m70688i(TAG, "cloudbackup doRestoreOneModule end, appId = " + str + " isBound = " + this.isBound);
        if (!this.isBound) {
            unregisterCallback(restoreOneModuleHandler);
            C11839m.m70687e(TAG, "doRestoreOneModule disconnect.");
            throw new C9721b(2004, "doRestoreOneModule disconnect. appId = " + str, "doRestoreOneModule");
        }
        unregisterCallback(restoreOneModuleHandler);
        return cloneErr;
    }

    public synchronized Bundle getBackupModuleInfo(String str, boolean z10) throws C9721b {
        Bundle moduleInfoFromClone;
        long jM75336G = new C12526j().m75336G();
        int i10 = 1;
        moduleInfoFromClone = null;
        while (i10 >= 0) {
            try {
                moduleInfoFromClone = getModuleInfoFromClone(str, z10, jM75336G);
            } catch (C9721b e10) {
                if (e10.m60659c() != 2014) {
                    throw e10;
                }
                unBindService();
                SystemClock.sleep(500L);
                String str2 = "request module info from clone time out, appId: " + str;
                reportBackupGetModuleInfoTimeOut(str, str2);
                C11839m.m70688i(TAG, "getBackupModuleInfo, isFromBackup: " + z10 + " , times: " + i10 + " , errorMsg: " + str2);
                if (z10 && i10 <= 0 && !C14333b.f63656h.contains(str)) {
                    throw new C9721b(2014, str2, "getBackupModuleInfo");
                }
            }
            if (moduleInfoFromClone != null && moduleInfoFromClone.getBundle(str) != null) {
                break;
            }
            i10--;
            C11839m.m70688i(TAG, "get module info from clone is null, appId: " + str);
        }
        return moduleInfoFromClone;
    }

    public Bundle getModuleInfoFromClone(final String str, final boolean z10, final long j10) throws C9721b {
        doBindService("getBackupModuleInfo");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Bundle[] bundleArr = {null};
        final BackupModuleInfoHandler backupModuleInfoHandler = new BackupModuleInfoHandler(countDownLatch, bundleArr, str, z10, initLooper());
        C11839m.m70688i(TAG, "backup service getBackupModuleInfo, appId: " + str + ", isFromBackup: " + z10 + ", timeoutDuration: " + j10);
        executeWithPowerKit(str, new InterfaceC14355b() { // from class: com.huawei.android.hicloud.cloudbackup.process.x
            @Override // p851zp.InterfaceC14355b
            public final void execute() throws C9721b {
                this.f11767a.lambda$getModuleInfoFromClone$0(backupModuleInfoHandler, str, countDownLatch, j10, z10);
            }
        });
        unregisterCallback(backupModuleInfoHandler);
        if (this.isBound) {
            return bundleArr[0];
        }
        throw new C9721b(2010, "connect timeout.", "getBackupModuleInfo. module: " + str);
    }

    public ArrayList<C12370a> getModuleInfoList() {
        return this.moduleInfoList;
    }

    public synchronized Bundle getNewDeviceInfo() throws C9721b {
        Bundle bundle;
        try {
            doBindService("getNewDeviceInfo");
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            Bundle[] bundleArr = {null};
            final NewDeviceInfoHandler newDeviceInfoHandler = new NewDeviceInfoHandler(countDownLatch, bundleArr, initLooper());
            C11839m.m70688i(TAG, "backup service getNewDeviceInfo.");
            executeWithPowerKit(null, new InterfaceC14355b() { // from class: com.huawei.android.hicloud.cloudbackup.process.z
                @Override // p851zp.InterfaceC14355b
                public final void execute() throws C9721b {
                    this.f11780a.lambda$getNewDeviceInfo$3(newDeviceInfoHandler, countDownLatch);
                }
            });
            if (!this.isBound) {
                throw new C9721b(2010, "connect timeout.", "getNewDeviceInfo");
            }
            bundle = bundleArr[0];
            if (bundle == null) {
                throw new C9721b(FamilyShareConstants.MessageCode.ENABLE_SPACE_SHARE_FAILED, "result is empty.", "getNewDeviceInfo");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return bundle;
    }

    public void onReceiveModuleInfo(Message message) {
        Bundle bundle = (Bundle) message.obj;
        ArrayList arrayList = (ArrayList) C12540b1.m75483a(bundle.getString(C2126b.MODULE_INFO_LIST), ArrayList.class);
        if (arrayList == null) {
            return;
        }
        String string = bundle.getString("app_id");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkedTreeMap linkedTreeMap = (LinkedTreeMap) it.next();
            C12370a c12370a = new C12370a();
            String str = (String) linkedTreeMap.get(C2126b.MODULE_INFO_URI);
            int iConvertToInt = convertToInt((String) linkedTreeMap.get(C2126b.MODULE_INFO_IS_NEED_BACKUP_URI));
            int iConvertToInt2 = convertToInt((String) linkedTreeMap.get(C2126b.MODULE_INFO_IS_NEED_COUNT_URI));
            int iConvertToInt3 = convertToInt((String) linkedTreeMap.get(C2126b.MODULE_INFO_PREPARE_COUNT));
            int iConvertToInt4 = convertToInt((String) linkedTreeMap.get("count"));
            String str2 = (String) linkedTreeMap.get(C2126b.MODULE_INFO_ERROR_INFO);
            c12370a.m74402n(string);
            c12370a.m74414z(str);
            c12370a.m74411w(iConvertToInt);
            c12370a.m74412x(iConvertToInt2);
            c12370a.m74413y(iConvertToInt3);
            c12370a.m74403o(iConvertToInt4);
            c12370a.m74410v(str2);
            this.moduleInfoList.add(c12370a);
        }
    }

    public void reportBackupOneModuleError(String str, String str2, String str3, int i10) {
        C11060c c11060cM66626a = C11058a.m66626a(str3, "backupOneModuleError", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_2002");
        c11060cM66626a.m66635A("appId: " + str + ", errorReason: " + str2 + ", retryTime: " + i10);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
    }

    public void unBindService() {
        synchronized (this.mCallbacks) {
            C11839m.m70686d(TAG, "unBindService");
            this.mCallbacks.clear();
        }
        if (this.isBound && this.service != null) {
            try {
                C11839m.m70688i(TAG, "unbind clone service.");
                this.service.abortDoing(1001);
                this.service.unregisterCallback(1001, this.serviceCallback);
                ServiceConnection serviceConnection = this.connection;
                if (serviceConnection != null) {
                    this.mContext.unbindService(serviceConnection);
                    this.isBound = false;
                    if (this.isRegister) {
                        this.isRegister = false;
                    }
                    releaseSyncLock();
                    C11839m.m70688i(TAG, "unbind clone service isSuccess.");
                }
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "unregisterCallback error" + e10);
            }
        }
    }
}
