package com.huawei.android.hicloud.cloudbackup.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.android.hicloud.cloudbackup.bean.ReportAppMarketInfo;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.restore.ReportAppMarketFailedSp;
import com.huawei.appmarket.service.appprocess.IAppProcessor;
import fk.C9721b;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p783xp.C13843a;

/* loaded from: classes2.dex */
public class ReportAppMarketManager {
    private static final String APPMARKET_ACTION = "com.huawei.appmarket.service.intent.appprocess";
    private static final Object LOCK = new Object();
    private static final long RETRY_TIME_LIMIT = 604800000;
    private static final String TAG = "ReportAppMarketManager";
    private static ReportAppMarketManager instance;
    private IAppProcessor appProcessorService = null;
    private int count = 0;
    private boolean isBound;
    private ServiceConnection mConnection;

    private void addService() {
        synchronized (LOCK) {
            this.count++;
        }
    }

    public static synchronized ReportAppMarketManager getInstance() {
        try {
            if (instance == null) {
                instance = new ReportAppMarketManager();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeService() {
        synchronized (LOCK) {
            this.count--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportApp(final Bundle bundle) {
        final ReportAppMarketInfo reportAppMarketInfo = new ReportAppMarketInfo();
        reportAppMarketInfo.setFailedTime(System.currentTimeMillis());
        reportAppMarketInfo.setPackageName(bundle.getString("package", ""));
        reportAppMarketInfo.setVersion(bundle.getInt("version", 1100));
        reportAppMarketInfo.setSubSource(bundle.getString(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE, ""));
        reportAppMarketInfo.setPkgChannelId(bundle.getString(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID, ""));
        reportAppMarketInfo.setSpKey(reportAppMarketInfo.getPackageName() + "&" + reportAppMarketInfo.getFailedTime());
        ReportAppMarketFailedSp.getInstance().putReportInfo(reportAppMarketInfo);
        C11839m.m70686d(TAG, "installEvent execute, spKey=" + reportAppMarketInfo.getSpKey());
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ReportAppMarketManager.3
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                int iInstallEvent = ReportAppMarketManager.this.appProcessorService.installEvent(bundle);
                C11839m.m70688i(ReportAppMarketManager.TAG, "installEvent code: " + iInstallEvent);
                if (iInstallEvent == 1) {
                    ReportAppMarketFailedSp.getInstance().removeReportInfo(reportAppMarketInfo.getSpKey());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAppList(final List<ReportAppMarketInfo> list) {
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ReportAppMarketManager.5
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                for (ReportAppMarketInfo reportAppMarketInfo : list) {
                    if (reportAppMarketInfo != null) {
                        if (System.currentTimeMillis() - reportAppMarketInfo.getFailedTime() > 604800000) {
                            C11839m.m70688i(ReportAppMarketManager.TAG, "AppReportTask: More than 7 days. remove " + reportAppMarketInfo.getSpKey());
                            ReportAppMarketFailedSp.getInstance().removeReportInfo(reportAppMarketInfo.getSpKey());
                        } else {
                            C11839m.m70688i(ReportAppMarketManager.TAG, "AppReportTask: retry " + reportAppMarketInfo.getSpKey());
                            Bundle bundle = new Bundle();
                            bundle.putString(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE, reportAppMarketInfo.getSubSource());
                            bundle.putInt("version", reportAppMarketInfo.getVersion());
                            bundle.putString("package", reportAppMarketInfo.getPackageName());
                            bundle.putString(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID, reportAppMarketInfo.getPkgChannelId());
                            int iInstallEvent = ReportAppMarketManager.this.appProcessorService.installEvent(bundle);
                            C11839m.m70688i(ReportAppMarketManager.TAG, "installEvent code: " + iInstallEvent);
                            if (iInstallEvent == 1) {
                                ReportAppMarketFailedSp.getInstance().removeReportInfo(reportAppMarketInfo.getSpKey());
                            }
                        }
                    }
                }
            }
        });
    }

    public void installEvent(final Bundle bundle) {
        if (RestoreUtil.isAppMarketSupportedReport(C0213f.m1377a())) {
            C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.service.ReportAppMarketManager.2
                @Override // p616rk.AbstractRunnableC12516b
                public void call() throws C9721b {
                    ReportAppMarketManager.this.reportApp(bundle);
                }
            }, false);
        } else {
            C11839m.m70686d(TAG, "installEvent: app market not supported!");
        }
    }

    public void serviceConnection(final IServiceProtocol iServiceProtocol) {
        C11839m.m70688i(TAG, "bindAppMarketService");
        final Context contextM1377a = C0213f.m1377a();
        this.mConnection = new ServiceConnection() { // from class: com.huawei.android.hicloud.cloudbackup.service.ReportAppMarketManager.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                C11839m.m70688i(ReportAppMarketManager.TAG, "onServiceConnected");
                ReportAppMarketManager.this.appProcessorService = IAppProcessor.AbstractBinderC4587a.m28124a(iBinder);
                try {
                    iServiceProtocol.execute();
                } catch (RemoteException e10) {
                    C11839m.m70687e(ReportAppMarketManager.TAG, "ReportAppMarketManager: " + e10.toString());
                }
                ReportAppMarketManager.this.removeService();
                if (ReportAppMarketManager.this.count == 0 && ReportAppMarketManager.this.isBound) {
                    contextM1377a.unbindService(ReportAppMarketManager.this.mConnection);
                    ReportAppMarketManager.this.isBound = false;
                    ReportAppMarketManager.this.appProcessorService = null;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                C11839m.m70688i(ReportAppMarketManager.TAG, "onServiceDisconnected");
                ReportAppMarketManager.this.isBound = false;
            }
        };
        Intent intent = new Intent();
        C0209d.m1302r2(intent, C13843a.m83090l());
        intent.setAction(APPMARKET_ACTION);
        boolean zBindService = contextM1377a.bindService(intent, this.mConnection, 1);
        this.isBound = zBindService;
        if (zBindService) {
            return;
        }
        C11839m.m70687e(TAG, "bindAppMarketService failed");
    }

    public void installEvent(final List<ReportAppMarketInfo> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70689w(TAG, "AppReportTask: reportInfoList is null or empty!");
            return;
        }
        C11839m.m70688i(TAG, "AppReportTask: size=" + list.size());
        C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.service.ReportAppMarketManager.4
            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                ReportAppMarketManager.this.reportAppList(list);
            }
        }, false);
    }
}
