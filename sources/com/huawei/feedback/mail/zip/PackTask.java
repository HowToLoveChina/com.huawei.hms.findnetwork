package com.huawei.feedback.mail.zip;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.feedback.mail.util.Accessory;
import com.huawei.feedback.mail.util.FeedbackUtils;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import java.io.File;
import java.util.ArrayList;
import p664u0.C13108a;

/* loaded from: classes5.dex */
public class PackTask implements Runnable {
    private static final String ACTION_FILE = "com.huawei.android.hicloud.DocumentSendmessage";
    private static final String ACTION_HICLOUD = "com.huawei.android.hicloud.sendmessage";
    private static final String TAG = "PackTask";
    private static final String ZIPNAME = "accessoryName";
    private String accessoryName;
    private Context context;
    private boolean document;
    private boolean isSdcard;
    private String logfilePath;
    private String logsdcardpath;
    private String logwritePath;
    private ArrayList<String> logwritePathList;
    private String logzipPath;
    C13108a mLocalBroadcastManager;

    public PackTask(String str, String str2, String str3, String str4, ArrayList<String> arrayList, boolean z10, Context context, boolean z11, String str5) {
        this.logfilePath = str;
        this.logzipPath = str2;
        this.logwritePath = str3;
        this.logsdcardpath = str4;
        this.logwritePathList = arrayList;
        this.isSdcard = z10;
        this.context = context;
        this.document = z11;
        this.accessoryName = str5;
    }

    private boolean fileRenameTo(File file, File file2) {
        return file.renameTo(file2);
    }

    private void packageFile(String str, File file, boolean z10) throws Throwable {
        BaseLogger.m28729d(TAG, "packageFile zippackage");
        File fileAccessoryZipFile = Accessory.accessoryZipFile(file, this.isSdcard, this.context);
        this.mLocalBroadcastManager = C13108a.m78878b(this.context);
        if (fileAccessoryZipFile != null && fileAccessoryZipFile.exists()) {
            fileRenameTo(fileAccessoryZipFile, new File(str));
            BaseLogger.m28729d(TAG, "fileRenameTo is ok");
        }
        Intent intent = z10 ? new Intent(ACTION_FILE) : new Intent(ACTION_HICLOUD);
        intent.putExtra(ZIPNAME, this.accessoryName);
        this.mLocalBroadcastManager.m78881d(intent);
        if (file.exists()) {
            for (int i10 = 0; i10 < 2; i10++) {
                boolean zDelete = file.delete();
                BaseLogger.m28729d(TAG, "resultZipFile delete success ? " + zDelete);
                if (zDelete) {
                    return;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String[] fileName;
        if (!TextUtils.isEmpty(this.logsdcardpath)) {
            FeedbackUtils.deleteZipfiles(this.logsdcardpath);
            FeedbackUtils.deleteZipfiles(this.logfilePath);
        }
        ArrayList<String> arrayList = this.logwritePathList;
        if (arrayList != null && arrayList.size() > 0) {
            BaseLogger.m28729d(TAG, "logwritePathList");
            fileName = FeedbackUtils.getFileNameList(this.logwritePathList);
        } else if (TextUtils.isEmpty(this.logwritePath)) {
            fileName = null;
        } else {
            BaseLogger.m28729d(TAG, "logwritePath" + this.logwritePath);
            fileName = FeedbackUtils.getFileName(this.logwritePath);
        }
        if (fileName == null) {
            Log.e(TAG, "file name is empty");
            return;
        }
        int length = fileName.length;
        if (length > 0) {
            File[] fileArr = new File[length];
            for (int i10 = 0; i10 < length; i10++) {
                BaseLogger.m28729d(TAG, ContentResource.FILE_NAME + fileName[i10]);
                fileArr[i10] = new File(fileName[i10]);
            }
            File file = new File(this.logzipPath);
            BaseLogger.m28729d(TAG, "waitUploadZipfile" + file.getPath());
            for (int i11 = 0; i11 < 2; i11++) {
                if (FeedbackUtils.zipFiles(fileArr, file, this.context)) {
                    BaseLogger.m28729d(TAG, "waitUploadZipfile zipflag good");
                    packageFile(this.logfilePath, file, this.document);
                    return;
                } else {
                    if (i11 == 1) {
                        BaseLogger.m28733i(TAG, "zipflag fail!");
                    }
                }
            }
        }
    }
}
