package com.huawei.fastengine.fastview.showrpkdetail;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.fastapp.engine.IFastAPPAidlInterface;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;

/* loaded from: classes5.dex */
public class ShowRpkDetail {
    private static final Object SHOW_RPK_DETAIL_LOCKER = new Object();
    private static final String TAG = "ShowRpkDetail";
    private static volatile ShowRpkDetail showRpkDetail;
    private ServiceConnection conn = new ServiceConnection() { // from class: com.huawei.fastengine.fastview.showrpkdetail.ShowRpkDetail.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            FastViewLogUtils.m28726i(ShowRpkDetail.TAG, "ShowRpkDetail onServiceConnected");
            try {
                ShowRpkDetail.this.myBinder = IFastAPPAidlInterface.Stub.m28714h(iBinder);
                ShowRpkDetail.this.myBinder.mo28705a(ShowRpkDetail.this.getPackageName());
                ShowRpkDetail showRpkDetail2 = ShowRpkDetail.this;
                showRpkDetail2.unbindService(showRpkDetail2.getContext());
            } catch (RemoteException unused) {
                FastViewLogUtils.m28724e(ShowRpkDetail.TAG, "showRpkDetail error");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            FastViewLogUtils.m28728w(ShowRpkDetail.TAG, "ShowRpkDetail onServiceDisconnected");
        }
    };
    private Context context;
    private IFastAPPAidlInterface myBinder;
    private String packageName;

    private ShowRpkDetail() {
    }

    public static ShowRpkDetail getInstance() {
        if (showRpkDetail == null) {
            synchronized (SHOW_RPK_DETAIL_LOCKER) {
                try {
                    if (showRpkDetail == null) {
                        showRpkDetail = new ShowRpkDetail();
                    }
                } finally {
                }
            }
        }
        return showRpkDetail;
    }

    public void bindService(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.huawei.fastapp.engine.action.AIDL_SERVICE");
        try {
            intent.setPackage(Config.getPackageName());
        } catch (IllegalArgumentException unused) {
            FastViewLogUtils.m28724e(TAG, "setPackage error");
        }
        context.bindService(intent, this.conn, 1);
    }

    public Context getContext() {
        return this.context;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void unbindService(Context context) {
        FastViewLogUtils.m28724e(TAG, "ShowRpkDetail unbind Service");
        context.unbindService(this.conn);
    }
}
