package com.huawei.hms.network.file.upload.api;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hms.network.file.core.util.FLogger;
import java.io.File;

/* loaded from: classes8.dex */
public class FileEntity {
    private static final String TAG = "FileEntity";
    File file;
    String fileName;
    String name;
    long startPos;
    long uploadSize;
    Uri uri;

    public FileEntity(Uri uri) {
        this((String) null, (String) null, uri, 0L, -1L);
    }

    @Deprecated
    public File getFile() {
        return this.file;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getName() {
        return this.name;
    }

    public long getStartPos() {
        return this.startPos;
    }

    public long getUploadSize() {
        return this.uploadSize;
    }

    public Uri getUri() {
        return this.uri;
    }

    public String toString() {
        return "FileEntity{name='" + this.name + "', fileName='" + this.fileName + "', startPos=" + this.startPos + ", uploadSize=" + this.uploadSize + '}';
    }

    @Deprecated
    public FileEntity(File file) {
        this((String) null, file);
    }

    public FileEntity(String str, Uri uri) {
        this(str, (String) null, uri, 0L, -1L);
    }

    @Deprecated
    public FileEntity(String str, File file) {
        this(str, file.getName(), file, 0L, -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FileEntity(java.lang.String r6, java.lang.String r7, android.net.Uri r8, long r9, long r11) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.file.upload.api.FileEntity.<init>(java.lang.String, java.lang.String, android.net.Uri, long, long):void");
    }

    @Deprecated
    public FileEntity(String str, String str2, File file, long j10, long j11) {
        this.name = CloudBackupConstant.Command.PMS_OPTION_ONE_FILE;
        this.fileName = "default";
        if (!TextUtils.isEmpty(str)) {
            this.name = str;
        }
        this.fileName = str2;
        if (file.isDirectory()) {
            throw new IllegalArgumentException("filepath cannot be a file directory");
        }
        if (!file.exists()) {
            throw new IllegalArgumentException("no such file");
        }
        this.file = file;
        this.startPos = j10;
        this.uploadSize = j11 <= 0 ? file.length() - j10 : j11;
        FLogger.m36353i(TAG, "FileEntity fileName:" + str2 + ",startPos:" + this.startPos + ",uploadSize:" + this.uploadSize + ",fileSize:" + file.length(), new Object[0]);
    }
}
