package com.huawei.hicloud.notification.task;

import android.text.TextUtils;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.exception.SyncCommonException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import p015ak.C0227m;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class ActivityEntryPictureTask extends AbstractRunnableC12516b {
    private static final String TAG = "ActivityEntryPictureTask";
    private CountDownLatch count;
    private String destPath;
    private String mHash;
    private String picUrl;

    public ActivityEntryPictureTask(String str, String str2, String str3) {
        this.destPath = str;
        this.picUrl = str2;
        this.mHash = str3;
    }

    private String generateFileHash(String str) {
        try {
            return C0227m.m1591d(str);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "generateFileHash exceptions:" + e10.toString());
            return "";
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        File file;
        try {
            try {
                NotifyLogger.m29913d(TAG, "ActivityEntryPictureTask start");
                C4896a c4896a = new C4896a(this.picUrl, this.destPath, 0L);
                NotifyUtil.downloadFileToPath(this.destPath, c4896a.getUrl(), c4896a);
                file = new File(this.destPath);
            } catch (Exception e10) {
                NotifyLogger.m29914e(TAG, e10.toString());
                CountDownLatch countDownLatch = this.count;
                if (countDownLatch != null) {
                }
            }
            if (!file.exists()) {
                throw new SyncCommonException("download picture to local failed. picUrl = " + this.picUrl + " destPath = " + this.destPath);
            }
            try {
                if (!TextUtils.isEmpty(this.mHash) && !this.mHash.equals(generateFileHash(this.destPath)) && file.delete()) {
                    NotifyLogger.m29914e(TAG, "picture hash not equals, delete file successed");
                }
            } catch (Exception e11) {
                NotifyLogger.m29914e(TAG, "picture hash exception:" + e11.toString());
            }
        } finally {
            CountDownLatch countDownLatch2 = this.count;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            NotifyLogger.m29913d(TAG, "ActivityEntryPictureTask end");
        }
    }

    public String getDestPath() {
        return this.destPath;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
        C12515a.m75110o().m75165a1(this);
    }

    public void setCount(CountDownLatch countDownLatch) {
        this.count = countDownLatch;
    }

    public void setDestPath(String str) {
        this.destPath = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return true;
    }
}
