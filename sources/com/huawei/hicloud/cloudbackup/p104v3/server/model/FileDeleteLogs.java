package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Locale;
import p015ak.C0241z;
import p618rm.C12540b1;

/* loaded from: classes6.dex */
public class FileDeleteLogs {

    /* renamed from: LC */
    private static final Locale f22595LC = new Locale(FaqConstants.DEFAULT_ISO_LANGUAGE);
    private String backupAction;
    private String fileExtension;
    private long fileSize;
    private String fileType;

    public static FileDeleteLogs getFileDeleteLogs(long j10, int i10, String str, boolean z10, String str2) {
        String lowerCase;
        int iLastIndexOf;
        FileDeleteLogs fileDeleteLogs = new FileDeleteLogs();
        fileDeleteLogs.setFileType(String.valueOf(i10));
        if (i10 == 7) {
            j10 = TextUtils.isEmpty(str) ? RuleConfig.DEFAULT_TAR_SIZE : C0241z.m1688f(str);
            lowerCase = "tar";
        } else {
            lowerCase = (TextUtils.isEmpty(str2) || (iLastIndexOf = str2.lastIndexOf(".") + 1) <= 0 || iLastIndexOf >= str2.length()) ? "" : str2.substring(iLastIndexOf).toLowerCase(f22595LC);
        }
        fileDeleteLogs.setBackupAction(z10 ? "Refurbishment" : "Origin");
        fileDeleteLogs.setFileSize(j10);
        fileDeleteLogs.setFileExtension(lowerCase);
        return fileDeleteLogs;
    }

    public String getBackupAction() {
        return this.backupAction;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setBackupAction(String str) {
        this.backupAction = str;
    }

    public void setFileExtension(String str) {
        this.fileExtension = str;
    }

    public void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }

    public String toString() {
        return C12540b1.m75485c(this);
    }
}
