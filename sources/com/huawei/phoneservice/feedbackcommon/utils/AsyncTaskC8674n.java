package com.huawei.phoneservice.feedbackcommon.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.n */
/* loaded from: classes5.dex */
public class AsyncTaskC8674n extends AsyncTask<Object, Void, Integer> {

    /* renamed from: a */
    public String f40451a;

    /* renamed from: b */
    public String f40452b;

    /* renamed from: c */
    public long f40453c;

    /* renamed from: d */
    public ZipCompressListener f40454d;

    /* renamed from: e */
    public WeakReference<Context> f40455e;

    public AsyncTaskC8674n(Context context, long j10, ZipCompressListener zipCompressListener) {
        this.f40453c = j10;
        this.f40454d = zipCompressListener;
        this.f40455e = new WeakReference<>(context);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Object... objArr) throws Throwable {
        String sdk;
        Context context;
        File file;
        StringBuilder sb2;
        String str;
        String str2;
        int iFileToZip = -1;
        try {
            sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_LOG_PATH);
            context = this.f40455e.get();
        } catch (Exception e10) {
            FaqLogger.m51840e("ZipCompressTask", e10.getMessage());
        }
        if (context == null) {
            return -1;
        }
        if (TextUtils.isEmpty(sdk) || sdk.startsWith(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
            file = new File(FeedbackWebConstants.getLogPath(context));
        } else {
            file = new File(FeedbackWebConstants.getLogPath(context) + File.separator + sdk);
        }
        FaqLogger.m51840e("ZipCompressTask", "  logPath: " + file.getCanonicalPath());
        if (file.exists()) {
            String sdk2 = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL);
            String sdk3 = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SOFT_VERSION);
            String sdk4 = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION);
            String sdk5 = FaqSdk.getSdk().getSdk("appVersion");
            String string = "";
            if (!TextUtils.isEmpty(sdk2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sdk2);
                sb3.append("_");
                if (TextUtils.isEmpty(sdk3)) {
                    str = "";
                } else {
                    str = sdk3 + "_";
                }
                sb3.append(str);
                if (TextUtils.isEmpty(sdk4)) {
                    str2 = "";
                } else {
                    str2 = sdk4 + "_";
                }
                sb3.append(str2);
                sb3.append(UUID.randomUUID());
                sb3.append("_app-");
                sb3.append(context.getPackageName());
                if (!TextUtils.isEmpty(sdk5)) {
                    string = "_" + sdk5;
                }
                sb3.append(string);
                string = sb3.toString();
            }
            this.f40451a = string;
            this.f40452b = FeedbackWebConstants.getZipFilePath(context);
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                iFileToZip = ZipUtil.fileToZip(file.getCanonicalPath(), this.f40452b, this.f40451a, this.f40453c);
                return Integer.valueOf(iFileToZip);
            }
            sb2 = new StringBuilder();
            sb2.append(file.getCanonicalPath());
            sb2.append(" FOLDER IS EMPTY");
        } else {
            sb2 = new StringBuilder();
            sb2.append(file.getCanonicalPath());
            sb2.append(" FILE NOT EXISTS");
        }
        FaqLogger.print("ZipCompressTask", sb2.toString());
        return Integer.valueOf(iFileToZip);
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) throws Throwable {
        super.onPostExecute(num);
        FaqLogger.print("ZipCompressTask", "integer:" + num);
        this.f40454d.zipCompressFinished(num.intValue(), this.f40452b, this.f40451a);
    }

    public AsyncTaskC8674n(Context context, ZipCompressListener zipCompressListener) {
        this.f40454d = zipCompressListener;
        this.f40455e = new WeakReference<>(context);
    }
}
