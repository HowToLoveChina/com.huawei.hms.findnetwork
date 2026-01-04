package com.huawei.location.gwi;

import as.C1016d;
import com.huawei.location.gwi.config.CarGwiSoFileConstant;
import com.huawei.location.gwi.listener.ICarGwiSoLoadListener;
import com.huawei.location.lite.common.util.filedownload.C6795a;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.DownloadFileParam;
import com.huawei.location.lite.common.util.filedownload.InterfaceC6799e;
import com.huawei.location.lite.common.util.filedownload.InterfaceC6800f;
import es.C9540e;
import es.C9549n;
import java.io.File;
import p237du.AbstractC9308a;
import p346hs.C10337b;
import p784xq.C13850f;

/* loaded from: classes8.dex */
public class CarGwiFileManager {
    private static final int RETRY_COUNT_THRESHOLD = 3;
    private static final String TAG = "CarGwiFileManager";
    private static final String THREAD_NAME = "Location-CarGwiFile";
    private ICarGwiSoLoadListener gwiSoLoadListener;
    private C9549n locationPreferences;
    private int retryCount = 0;
    private String versionNumSp;

    private void check() {
        C9540e.m59581d().m59582a(new Runnable() { // from class: com.huawei.location.gwi.CarGwiFileManager.1
            @Override // java.lang.Runnable
            public void run() {
                Thread.currentThread().setName(CarGwiFileManager.THREAD_NAME);
                try {
                    CarGwiFileManager.this.checkGwiSoFile();
                } catch (Exception unused) {
                    C1016d.m6183c(CarGwiFileManager.TAG, "checkGwiSoFile error.");
                    CarGwiFileManager.this.handleLoadResult(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGwiSoFile() {
        synchronized (CarGwiFileManager.class) {
            try {
                C9549n c9549n = new C9549n(CarGwiSoFileConstant.SP_CAR_GWI_FILE_NAME);
                this.locationPreferences = c9549n;
                long jCurrentTimeMillis = System.currentTimeMillis() - c9549n.m59623a(CarGwiSoFileConstant.SP_CAR_GWI_LAST_SAVE_TIME);
                this.versionNumSp = this.locationPreferences.m59624b(CarGwiSoFileConstant.SP_CAR_GWI_VERSION_NUM);
                if (!isFileExist() || jCurrentTimeMillis >= 86400000) {
                    C1016d.m6186f(TAG, "libGwi file is not exists or determine whether the libGwi file needs to be updated ");
                    DownloadFileParam downloadFileParam = new DownloadFileParam();
                    downloadFileParam.setFileName(CarGwiSoFileConstant.CAR_GWI_FILE_NAME);
                    downloadFileParam.setSaveFilePath(CarGwiSoFileConstant.FILE_PATH);
                    downloadFileParam.setServiceType(CarGwiSoFileConstant.SERVICE_TYPE);
                    downloadFileParam.setSubType("libCarGwiVdrV3");
                    new C6795a(downloadFileParam, new InterfaceC6800f() { // from class: com.huawei.location.gwi.a
                        @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6800f
                        /* renamed from: a */
                        public final boolean mo38290a(DownLoadFileBean downLoadFileBean) {
                            return this.f31328a.lambda$checkGwiSoFile$0(downLoadFileBean);
                        }
                    }).m38476c(new InterfaceC6799e() { // from class: com.huawei.location.gwi.CarGwiFileManager.2
                        @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6799e
                        public void onFail(int i10, String str) {
                            CarGwiFileManager carGwiFileManager;
                            boolean z10;
                            if (i10 == 10005) {
                                CarGwiFileManager.this.locationPreferences.m59626d(CarGwiSoFileConstant.SP_CAR_GWI_LAST_SAVE_TIME, System.currentTimeMillis());
                                carGwiFileManager = CarGwiFileManager.this;
                                z10 = true;
                            } else {
                                carGwiFileManager = CarGwiFileManager.this;
                                z10 = false;
                            }
                            carGwiFileManager.handleLoadResult(z10);
                            C1016d.m6183c(CarGwiFileManager.TAG, "download error errorCode:" + i10 + " errorDesc:" + str);
                        }

                        @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6799e
                        public void onSuccess(DownLoadFileBean downLoadFileBean, File file) {
                            if (downLoadFileBean == null) {
                                CarGwiFileManager.this.handleLoadResult(false);
                            } else {
                                C1016d.m6186f(CarGwiFileManager.TAG, "libCarGwi download Success");
                                CarGwiFileManager.this.downLoadSuccessDeal(file, downLoadFileBean.getFileAccessInfo().getFileSha256(), downLoadFileBean.getFileAccessInfo().getVersion());
                            }
                        }
                    });
                } else {
                    C1016d.m6186f(TAG, "libGwi file is exists and is not need update");
                    handleLoadResult(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private boolean deleteFile(String str) {
        try {
            return new File(str).delete();
        } catch (Exception e10) {
            C1016d.m6183c(TAG, "deleteFile error: " + e10.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downLoadSuccessDeal(File file, String str, String str2) {
        synchronized (CarGwiFileManager.class) {
            try {
                boolean zFileIntegrityCheck = fileIntegrityCheck(file, str);
                StringBuilder sb2 = new StringBuilder();
                String str3 = CarGwiSoFileConstant.FILE_PATH;
                sb2.append(str3);
                sb2.append(File.separator);
                sb2.append(CarGwiSoFileConstant.CAR_GWI_FILE_NAME);
                String string = sb2.toString();
                if (!zFileIntegrityCheck) {
                    C1016d.m6186f(TAG, "file is not integrity");
                    deleteFile(string);
                    handleLoadResult(false);
                } else if (!new C10337b().mo63648a(string, str3)) {
                    C1016d.m6186f(TAG, "unzip file fail!");
                    deleteFile(string);
                    handleLoadResult(false);
                } else {
                    handleLoadResult(true);
                    this.locationPreferences.m59627e(CarGwiSoFileConstant.SP_CAR_GWI_VERSION_NUM, str2);
                    this.locationPreferences.m59626d(CarGwiSoFileConstant.SP_CAR_GWI_LAST_SAVE_TIME, System.currentTimeMillis());
                    C1016d.m6186f(TAG, "CarGwi unzip plugin success!");
                    deleteFile(string);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private boolean fileIntegrityCheck(File file, String str) {
        return AbstractC9308a.m58613e(file, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadResult(boolean z10) {
        int i10;
        if (!z10 && (i10 = this.retryCount) < 3) {
            this.retryCount = i10 + 1;
            C13850f.m83120a(new StringBuilder("handleLoadResult fail, retryCount: "), this.retryCount, TAG);
            check();
        } else {
            ICarGwiSoLoadListener iCarGwiSoLoadListener = this.gwiSoLoadListener;
            if (iCarGwiSoLoadListener != null) {
                iCarGwiSoLoadListener.handleLoadResult(isFileExist());
            }
        }
    }

    public static boolean isFileExist() {
        try {
            File file = new File(CarGwiSoFileConstant.SO_PATH);
            C1016d.m6186f(TAG, "the file isFileExist is " + file.exists());
            return file.exists();
        } catch (Exception e10) {
            C1016d.m6183c(TAG, "isFileExist error: " + e10.getMessage());
            return false;
        }
    }

    private boolean isVersionAvailable(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        C1016d.m6186f(TAG, "versionNumFromServer is: " + str + ", versionNumSp is: " + str2);
        return str.compareTo(str2) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$checkGwiSoFile$0(DownLoadFileBean downLoadFileBean) {
        return !isFileExist() || isVersionAvailable(downLoadFileBean.getFileAccessInfo().getVersion(), this.versionNumSp);
    }

    public void checkGwiSoService(ICarGwiSoLoadListener iCarGwiSoLoadListener) {
        this.gwiSoLoadListener = iCarGwiSoLoadListener;
        check();
    }
}
