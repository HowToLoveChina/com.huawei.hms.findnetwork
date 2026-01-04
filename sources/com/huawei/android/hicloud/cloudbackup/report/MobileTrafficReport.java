package com.huawei.android.hicloud.cloudbackup.report;

import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import p684un.C13225d;

/* loaded from: classes2.dex */
public class MobileTrafficReport {
    private static final String DIALOG_CANCEL = "dialogCancel";
    private static final String DIALOG_CONTINUE = "dialogContinue";
    private static final MobileTrafficReport INSTANCE = new MobileTrafficReport();
    private static final String ONE_CLICK = "1";
    public static final String RESTORE_MAIN_DIALOG = "restoreMainDialog";
    public static final String RESTORE_OPTION_DIALOG = "restoreOptionDialog";
    private static final String RESTORE_TRAFFIC_SIZE = "restoreTrafficSize";
    private static final String TAG = "MobileTrafficReport";
    private static final String ZERO_CLICK = "0";
    private long downLoadSize;
    private boolean isMobile = false;
    private String dialogType = "";

    public static MobileTrafficReport getInstance() {
        return INSTANCE;
    }

    public void addDownloadSize(long j10) {
        if (this.isMobile) {
            this.downLoadSize += j10;
        }
    }

    public long getDownLoadSize() {
        return this.downLoadSize;
    }

    public void reportNetworkBackup(String str) {
        this.downLoadSize = 0L;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("network_backup", str);
        C13225d.m79490f1().m79567R("cloudbackup_network_backup", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_network_backup", linkedHashMap);
    }

    public void reportNetworkDialogShow() {
        this.downLoadSize = 0L;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("cloudbackup_network_show", String.valueOf(System.currentTimeMillis()));
        C13225d.m79490f1().m79567R("cloudbackup_network_backup", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_network_backup", linkedHashMap);
    }

    public void reportRestoreCancel(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(str, "1");
        linkedHashMap.put(DIALOG_CANCEL, "1");
        linkedHashMap.put(DIALOG_CONTINUE, "0");
        C13225d.m79490f1().m79567R("cloudbackup_network_restore", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_network_restore", linkedHashMap);
    }

    public void reportRestoreContinue() {
        if (RESTORE_OPTION_DIALOG.equals(this.dialogType) || RESTORE_MAIN_DIALOG.equals(this.dialogType)) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(this.dialogType, "1");
            linkedHashMap.put(DIALOG_CANCEL, "0");
            linkedHashMap.put(DIALOG_CONTINUE, "1");
            linkedHashMap.put(RESTORE_TRAFFIC_SIZE, String.valueOf(this.downLoadSize));
            C13225d.m79490f1().m79567R("cloudbackup_network_restore", linkedHashMap);
            UBAAnalyze.m29947H("CKC", "cloudbackup_network_restore", linkedHashMap);
            this.downLoadSize = 0L;
            this.isMobile = false;
            this.dialogType = "";
        }
    }

    public void setDialogType(String str) {
        this.dialogType = str;
        this.downLoadSize = 0L;
    }

    public void setMobile(boolean z10) {
        this.isMobile = z10;
    }
}
