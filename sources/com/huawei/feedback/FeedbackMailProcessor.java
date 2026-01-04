package com.huawei.feedback;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.example.hilogemail.R$string;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.feedback.mail.zip.PackTask;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import hk.C10279b;
import java.io.File;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import p015ak.C0209d;

/* loaded from: classes5.dex */
public class FeedbackMailProcessor {
    private static final String TAG = "FeedbackMailProcessor";
    private static volatile FeedbackMailProcessor sInstance;
    private static Thread.UncaughtExceptionHandler uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() { // from class: com.huawei.feedback.FeedbackMailProcessor.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            BaseLogger.m28731e(FeedbackMailProcessor.TAG, thread.getName() + " : " + th2.getMessage());
        }
    };
    private String appFilePath;
    private String appFolderPath;
    private String sdcardFilePath;
    private String sdcardFolderPath;

    private FeedbackMailProcessor() {
    }

    public static FeedbackMailProcessor getInstance() {
        if (sInstance == null) {
            synchronized (FeedbackMailProcessor.class) {
                sInstance = new FeedbackMailProcessor();
            }
        }
        return sInstance;
    }

    public void jumpToMailView(Context context, String str, String str2) {
        BaseLogger.m28729d(TAG, "jumpToMailView");
        if (context == null || str == null || str2 == null) {
            BaseLogger.m28731e(TAG, "params is null.");
            return;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            BaseLogger.m28731e(TAG, "resource is null");
            return;
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        if (path == null) {
            BaseLogger.m28731e(TAG, "path is null");
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        String string = resources.getString(R$string.hifeedback_email_title);
        String string2 = resources.getString(R$string.hifeedback_email_content);
        String string3 = resources.getString(R$string.hifeedback_email_content_prompt);
        String string4 = resources.getString(R$string.hifeedback_email_content_prompt1, 1);
        String string5 = resources.getString(R$string.hifeedback_email_content_prompt2, 2);
        String string6 = resources.getString(R$string.hifeedback_email_content_prompt3, 3);
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str2});
        intent.putExtra("android.intent.extra.SUBJECT", string);
        intent.putExtra("android.intent.extra.TEXT", string2 + string3 + string4 + string5 + string6);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(path);
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append("huawei");
        sb2.append(str3);
        sb2.append("hicloud");
        sb2.append(str3);
        sb2.append(str);
        File file = new File(sb2.toString());
        if (file.exists()) {
            intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, FeedbackConst.Mail.HIDISK_FILE_PROVIDER, file));
        }
        if (C0209d.m1184K0(context, FeedbackConst.Mail.ANDROID_EMAIL)) {
            C0209d.m1302r2(intent, FeedbackConst.Mail.ANDROID_EMAIL);
        } else if (C0209d.m1184K0(context, FeedbackConst.Mail.EMUI10_EMAIL_PKG_NAME)) {
            C0209d.m1302r2(intent, FeedbackConst.Mail.EMUI10_EMAIL_PKG_NAME);
        } else {
            BaseLogger.m28733i(TAG, "setPackage is gmail");
            C0209d.m1302r2(intent, FeedbackConst.Mail.GMAIL);
        }
        intent.addFlags(1);
        try {
            context.startActivity(intent);
        } catch (Exception e10) {
            BaseLogger.m28731e(TAG, "jumpToMailView error: " + e10.toString());
        }
    }

    public void packLogToMail(Context context, boolean z10) {
        String str = "Log_" + new SimpleDateFormat("yyyyMMddHHmm", Locale.getDefault()).format(Calendar.getInstance().getTime()) + FeedbackWebConstants.SUFFIX;
        BaseLogger.m28729d(TAG, "document  ziputils" + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getFilesDir().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("hicloud");
        this.appFolderPath = sb2.toString();
        this.appFilePath = this.appFolderPath + str2 + "error.zip";
        if (C0209d.m1269j1()) {
            String strM1192N = C0209d.m1192N();
            this.sdcardFolderPath = C10279b.m63452a(Environment.getExternalStorageDirectory()) + str2 + (TextUtils.isEmpty(strM1192N) ? "honor" : strM1192N.toLowerCase(Locale.ENGLISH)) + "/hicloud";
        } else {
            this.sdcardFolderPath = C10279b.m63452a(Environment.getExternalStorageDirectory()) + "/huawei/hicloud";
        }
        this.sdcardFilePath = this.sdcardFolderPath + str2 + str;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("sdcardFolderPath: ");
        sb3.append(this.sdcardFilePath);
        BaseLogger.m28729d(TAG, sb3.toString());
        Thread thread = new Thread(new PackTask(this.sdcardFilePath, this.appFilePath, this.appFolderPath, this.sdcardFolderPath, null, true, context, z10, str));
        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        thread.setName("PackTask");
        thread.start();
    }
}
