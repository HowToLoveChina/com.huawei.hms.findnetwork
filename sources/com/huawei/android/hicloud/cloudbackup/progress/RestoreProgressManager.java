package com.huawei.android.hicloud.cloudbackup.progress;

import android.content.Context;
import android.content.res.Resources;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.BackupPowerKitKeepTimer;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.report.MobileTrafficReport;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p514o9.C11839m;
import p581qk.AbstractC12369f;
import p616rk.C12515a;
import p709vj.C13452e;
import p847zk.C14317j;

/* loaded from: classes2.dex */
public class RestoreProgressManager {
    private static final int FIFTY_NINE_MINUTE = 59;
    private static final float MAXIMUM_PERCENTAGE = 99.99f;
    private static final int ONE_HOUR_MINUTE = 60;
    private static final String TAG = "RestoreProgressManager";
    private boolean isCanShowSpeedRate;
    private boolean isFromOOBE;
    private float lastProgress;
    private boolean newBmRecord;
    private float oobeLastProgress;
    private AbstractC12369f progressTimer;
    private static final RestoreProgressManager MANAGER = new RestoreProgressManager();
    private static final Object LOCK = new Object();
    private long bytesDownloaded = 0;
    private long contentLength = 0;
    private long firstContentLength = 0;
    private long lastTimeMillis = 0;
    private long lastRxBytes = 0;
    private int count = 0;
    private int firstCount = 0;
    private List<String> restoreFirstData = new ArrayList();
    private long oobeAlreadyCompletedData = 0;

    private RestoreProgressManager() {
    }

    private float calcRestoreProgress(float f10) {
        long j10 = this.contentLength;
        return formatProgress(Math.min(MAXIMUM_PERCENTAGE, j10 > 0 ? f10 / j10 : 0.0f));
    }

    private float formatProgress(float f10) {
        try {
            return Float.parseFloat(new DecimalFormat("#.00").format(f10));
        } catch (NumberFormatException unused) {
            return f10;
        }
    }

    private Context getContext() {
        return C0213f.m1377a();
    }

    public static RestoreProgressManager getInstance() {
        return MANAGER;
    }

    private int getItemCount(List<CloudRestoreItem> list) {
        Iterator<CloudRestoreItem> it = list.iterator();
        int itemCount = 0;
        while (it.hasNext()) {
            List<CloudRestoreItem> listM29202r = it.next().m29202r();
            itemCount = (listM29202r == null || listM29202r.isEmpty()) ? itemCount + 1 : itemCount + getItemCount(listM29202r);
        }
        return itemCount;
    }

    private float getItemProgress(List<CloudRestoreItem> list) {
        float itemProgress = 0.0f;
        for (CloudRestoreItem cloudRestoreItem : list) {
            List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
            if (listM29202r == null || listM29202r.isEmpty()) {
                long itemSize = RestoreProgress.getItemSize(cloudRestoreItem, this.newBmRecord);
                this.contentLength += itemSize;
                float moduleProgress = cloudRestoreItem.getModuleProgress(itemSize, cloudRestoreItem);
                if (this.restoreFirstData.contains(cloudRestoreItem.getAppId())) {
                    this.oobeAlreadyCompletedData = (long) (this.oobeAlreadyCompletedData + (itemSize * moduleProgress));
                }
                itemProgress += itemSize * moduleProgress;
                isCanShowSpeedRate(cloudRestoreItem, moduleProgress, itemSize);
                C11839m.m70686d(TAG, "getItemProgress: " + moduleProgress + ", totalRestoreSize: " + itemProgress + ", bytesDownloadedFiles: " + cloudRestoreItem.getBytesDownloadedFiles() + ", bytesDownloadedApp: " + cloudRestoreItem.getBytesDownloadedApp() + ", itemRestoreSize: " + itemSize + ", appId: " + cloudRestoreItem.getAppId() + ", status:" + cloudRestoreItem.getStatus() + ", subStatus:" + cloudRestoreItem.getSubStatus() + ", pmsAlreadyBytes:" + cloudRestoreItem.getPmsAlreadyBytes() + ", total:" + this.contentLength + ", oobeAlreadyCompletedData:" + this.oobeAlreadyCompletedData + ", Type:" + cloudRestoreItem.getType() + ", current:" + cloudRestoreItem.getCurrent());
            } else {
                itemProgress += getItemProgress(listM29202r);
            }
        }
        return itemProgress;
    }

    private String getRateStr(long j10, long j11) throws Resources.NotFoundException {
        long j12 = j10 - this.bytesDownloaded;
        if (j12 < 0) {
            C11839m.m70686d(TAG, "getRateStr bytesDownloaded =" + this.bytesDownloaded + " totalLength =" + j10);
            j12 = 0L;
        }
        if (j11 <= 0) {
            return "";
        }
        long jFloor = (long) Math.floor(j12 / j11);
        Context applicationContext = getContext().getApplicationContext();
        String strM1524g = C0223k.m1524g(getContext(), j11);
        int iFloor = (int) Math.floor(new BigDecimal(jFloor).divide(new BigDecimal(AsCache.TIME_HOUR), 2, RoundingMode.HALF_UP).floatValue());
        int iCeil = (int) Math.ceil((jFloor / 60.0d) % 60.0d);
        if (iCeil == 60) {
            iCeil = 59;
        }
        int iMax = Math.max(iCeil, 1);
        String quantityString = applicationContext.getResources().getQuantityString(R$plurals.cloud_restore_remain_time1, iFloor, Integer.valueOf(iFloor));
        String quantityString2 = applicationContext.getResources().getQuantityString(R$plurals.cloud_restore_remain_time2, iMax, Integer.valueOf(iMax));
        if (iFloor >= 3) {
            quantityString2 = applicationContext.getString(R$string.more_than_three_hours, 3);
        } else if (iFloor > 0) {
            quantityString2 = applicationContext.getString(R$string.cloudpay_package_urse_space_detail, quantityString, quantityString2);
        }
        return applicationContext.getString(R$string.cloud_restore_rate, strM1524g, quantityString2);
    }

    private long getSpeed() {
        if (!this.isCanShowSpeedRate || this.bytesDownloaded == 0 || this.contentLength <= 0) {
            C11839m.m70686d(TAG, "getSpeed nodown");
            return 0L;
        }
        if (this.lastTimeMillis == 0 || this.lastRxBytes == 0) {
            this.lastTimeMillis = System.currentTimeMillis();
            this.lastRxBytes = TrafficStats.getTotalRxBytes();
            C11839m.m70686d(TAG, "getSpeed init");
            return 0L;
        }
        long totalRxBytes = TrafficStats.getTotalRxBytes();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jFloor = (long) Math.floor((totalRxBytes - this.lastRxBytes) / new BigDecimal(jCurrentTimeMillis - this.lastTimeMillis).divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP).doubleValue());
        this.lastRxBytes = totalRxBytes;
        this.lastTimeMillis = jCurrentTimeMillis;
        C11839m.m70686d(TAG, "getSpeed  =" + jFloor + "  lastRxBytes =" + this.lastRxBytes + "  lastTimeMillis =" + this.lastTimeMillis);
        return jFloor;
    }

    private void initData() {
        C11839m.m70686d(TAG, "initData");
        this.count = 0;
        this.lastProgress = 0.0f;
        this.oobeLastProgress = 0.0f;
        this.bytesDownloaded = 0L;
        this.contentLength = 0L;
        this.lastTimeMillis = 0L;
        this.lastRxBytes = 0L;
        this.firstContentLength = 0L;
        this.firstCount = 0;
        this.isCanShowSpeedRate = false;
    }

    private void isCanShowSpeedRate(CloudRestoreItem cloudRestoreItem, float f10, long j10) {
        String subStatus = cloudRestoreItem.getSubStatus();
        subStatus.hashCode();
        switch (subStatus) {
            case "prepareDownloadBegin":
            case "prepareDownloadSnapshot":
            case "downloadFiles":
            case "prepareDownloadInfo":
                this.isCanShowSpeedRate = true;
                break;
            case "downloadApp":
                if (cloudRestoreItem.getType() != 1 && f10 < 83.0f && cloudRestoreItem.getCurrent() < 100) {
                    this.isCanShowSpeedRate = true;
                    break;
                }
                break;
        }
    }

    private void sendOOBERate(long j10) throws Resources.NotFoundException {
        String rateStr = getRateStr(this.firstContentLength, j10);
        Bundle bundle = new Bundle();
        bundle.putString("speed", rateStr);
        Message message = new Message();
        message.what = 32330;
        message.setData(bundle);
        CBCallBack.getInstance().sendMessage(message);
        C11839m.m70686d(TAG, "sendOOBERate");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendProgress() {
        List<CloudRestoreItem> itemList = RestoreProgress.getItemList();
        if (itemList.isEmpty()) {
            return;
        }
        this.contentLength = 0L;
        this.isCanShowSpeedRate = false;
        this.oobeAlreadyCompletedData = 0L;
        float itemProgress = getItemProgress(itemList);
        float fCalcRestoreProgress = calcRestoreProgress(itemProgress);
        sendProgressOOBE();
        int itemCount = this.count;
        if (itemCount <= 0) {
            itemCount = getItemCount(itemList);
        }
        this.count = itemCount;
        C11839m.m70688i(TAG, "progress " + fCalcRestoreProgress + " lastProgress " + this.lastProgress + " count = " + this.count + ",bytesDownloaded:" + this.bytesDownloaded + ",totalRestoreProgress:" + itemProgress + ",contentLength:" + this.contentLength);
        if (this.lastProgress == 0.0f) {
            this.lastProgress = C13452e.m80781L().m80911f0();
        }
        Context applicationContext = getContext().getApplicationContext();
        Bundle bundle = new Bundle();
        if (C0209d.m1253f1()) {
            bundle.putString("title", applicationContext.getString(R$string.notification_restoring_data));
            float f10 = this.lastProgress;
            if (f10 < fCalcRestoreProgress) {
                f10 = fCalcRestoreProgress;
            }
            bundle.putString("text", String.format(getContext().getString(R$string.restore_new_completed_part), C0209d.m1236b0(C2783d.m16085H(f10))));
        } else {
            bundle.putString("title", applicationContext.getString(R$string.restore_new_restoring_data));
        }
        Message message = new Message();
        message.what = 32327;
        float f11 = this.lastProgress;
        if (f11 >= fCalcRestoreProgress) {
            bundle.putFloat(VastAttribute.PROGRESS, f11);
            message.setData(bundle);
            CBCallBack.getInstance().sendMessage(message);
            C14317j.m85300d().m85315p(this.lastProgress);
            RestoreNotification.getInstance().updateNotification(bundle);
            return;
        }
        this.lastProgress = fCalcRestoreProgress;
        bundle.putFloat(VastAttribute.PROGRESS, fCalcRestoreProgress);
        message.what = 32327;
        message.setData(bundle);
        CBCallBack.getInstance().sendMessage(message);
        C14317j.m85300d().m85315p(fCalcRestoreProgress);
        C13452e.m80781L().m80909e3(fCalcRestoreProgress);
        RestoreNotification.getInstance().updateNotification(bundle);
    }

    private void sendProgressOOBE() {
        C11839m.m70688i(TAG, "sendProgressOOBE isFromOOBE:" + this.isFromOOBE);
        if (this.firstCount == 0 || !this.isFromOOBE) {
            C11839m.m70686d(TAG, "sendProgressOOBE firstQueue empty");
            return;
        }
        long j10 = this.firstContentLength;
        float progress = formatProgress(Math.min(MAXIMUM_PERCENTAGE, j10 > 0 ? this.oobeAlreadyCompletedData / j10 : 0.0f));
        BaseLogger.m28734i(TAG, "sendProgressOOBE " + progress + " oobeLastProgress " + this.oobeLastProgress, " ,oobeAlreadyCompletedData:" + this.oobeAlreadyCompletedData + " ,firstContentLength " + this.firstContentLength);
        if (this.oobeLastProgress < progress) {
            this.oobeLastProgress = progress;
            Bundle bundle = new Bundle();
            bundle.putFloat(VastAttribute.PROGRESS, progress);
            Message message = new Message();
            message.what = 32326;
            message.setData(bundle);
            CBCallBack.getInstance().sendMessage(message);
        }
    }

    private void sendRate(long j10) throws Resources.NotFoundException {
        String rateStr = getRateStr(this.contentLength, j10);
        Bundle bundle = new Bundle();
        bundle.putString("speed", rateStr);
        Message message = new Message();
        message.what = 32328;
        message.setData(bundle);
        CBCallBack.getInstance().sendMessage(message);
        C11839m.m70686d(TAG, "sendRate");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSpeedRate() throws Resources.NotFoundException {
        C11839m.m70688i(TAG, "sendSpeedRate isCanShowSpeedRate:" + this.isCanShowSpeedRate);
        long speed = getSpeed();
        sendRate(speed);
        sendOOBERate(speed);
    }

    public void addBytesDownloaded(long j10) {
        synchronized (LOCK) {
            this.bytesDownloaded += j10;
            MobileTrafficReport.getInstance().addDownloadSize(j10);
        }
    }

    public float getProgress() {
        return this.lastProgress;
    }

    public void init(boolean z10) {
        this.isFromOOBE = z10;
        this.newBmRecord = RestoreUtil.isNewBmRecord();
        initData();
        this.progressTimer = new AbstractC12369f(0L, 2L) { // from class: com.huawei.android.hicloud.cloudbackup.progress.RestoreProgressManager.1
            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws Resources.NotFoundException {
                BackupPowerKitKeepTimer.getInstance().keepAlive();
                CBAccess.keepLock();
                RestoreProgressManager.this.sendProgress();
                RestoreProgressManager.this.sendSpeedRate();
            }
        };
        C12515a.m75110o().m75172d(this.progressTimer);
    }

    public void release() {
        AbstractC12369f abstractC12369f = this.progressTimer;
        if (abstractC12369f != null) {
            abstractC12369f.cancel();
            this.progressTimer = null;
        }
        this.count = 0;
        this.lastProgress = 0.0f;
        this.oobeLastProgress = 0.0f;
        this.bytesDownloaded = 0L;
        this.contentLength = 0L;
        this.lastTimeMillis = 0L;
        this.lastRxBytes = 0L;
        this.firstContentLength = 0L;
        this.firstCount = 0;
    }

    public void setContentLength(long j10) {
        this.contentLength = j10;
    }

    public void setFirstContentLength(long j10) {
        this.firstContentLength = j10;
    }

    public void setFirstCount(int i10) {
        this.firstCount = i10;
    }

    public void setRestoreFirstData(List<String> list) {
        this.restoreFirstData = list;
    }
}
