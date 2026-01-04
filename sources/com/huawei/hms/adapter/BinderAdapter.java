package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* loaded from: classes8.dex */
public class BinderAdapter implements ServiceConnection {

    /* renamed from: a */
    private final Context f23103a;

    /* renamed from: b */
    private final String f23104b;

    /* renamed from: c */
    private final String f23105c;

    /* renamed from: d */
    private BinderCallBack f23106d;

    /* renamed from: e */
    private IBinder f23107e;

    /* renamed from: f */
    private final Object f23108f = new Object();

    /* renamed from: g */
    private boolean f23109g = false;

    /* renamed from: h */
    private Handler f23110h = null;

    /* renamed from: i */
    private Handler f23111i = null;

    public interface BinderCallBack {
        void onBinderFailed(int i10);

        void onBinderFailed(int i10, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.f23103a = context;
        this.f23104b = str;
        this.f23105c = str2;
    }

    /* renamed from: c */
    private void m30206c() {
        synchronized (this.f23108f) {
            try {
                Handler handler = this.f23110h;
                if (handler != null) {
                    handler.removeMessages(getConnTimeOut());
                    this.f23110h = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    private void m30207d() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message == null || message.what != BinderAdapter.this.getMsgDelayDisconnect()) {
                    return false;
                }
                HMSLog.m36988i("BinderAdapter", "The serviceConnection has been bind for 1800s, need to unbind.");
                BinderAdapter.this.unBind();
                BinderCallBack binderCallBackM30209f = BinderAdapter.this.m30209f();
                if (binderCallBackM30209f == null) {
                    return true;
                }
                binderCallBackM30209f.onTimedDisconnected();
                return true;
            }
        });
        this.f23111i = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
    }

    /* renamed from: e */
    private void m30208e() {
        HMSLog.m36986e("BinderAdapter", "In connect, bind core service fail");
        try {
            ComponentName componentName = new ComponentName(this.f23103a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
            BinderCallBack binderCallBackM30209f = m30209f();
            if (binderCallBackM30209f != null) {
                binderCallBackM30209f.onBinderFailed(-1, intent);
            }
        } catch (RuntimeException e10) {
            HMSLog.m36986e("BinderAdapter", "getBindFailPendingIntent failed " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public BinderCallBack m30209f() {
        return this.f23106d;
    }

    /* renamed from: g */
    private void m30210g() {
        Handler handler = this.f23110h;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.f23110h = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != BinderAdapter.this.getConnTimeOut()) {
                        return false;
                    }
                    HMSLog.m36986e("BinderAdapter", "In connect, bind core service time out");
                    BinderAdapter.this.m30205b();
                    return true;
                }
            });
        }
        this.f23110h.sendEmptyMessageDelayed(getConnTimeOut(), 10000L);
    }

    /* renamed from: h */
    private void m30211h() {
        HMSLog.m36983d("BinderAdapter", "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            try {
                Handler handler = this.f23111i;
                if (handler != null) {
                    handler.removeMessages(getMsgDelayDisconnect());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack == null) {
            return;
        }
        this.f23106d = binderCallBack;
        m30202a();
    }

    public int getConnTimeOut() {
        return 0;
    }

    public int getMsgDelayDisconnect() {
        return 0;
    }

    public String getServiceAction() {
        return this.f23104b;
    }

    public IBinder getServiceBinder() {
        return this.f23107e;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        HMSLog.m36986e("BinderAdapter", "Enter onNullBinding, than unBind.");
        if (this.f23109g) {
            this.f23109g = false;
            return;
        }
        unBind();
        m30206c();
        BinderCallBack binderCallBackM30209f = m30209f();
        if (binderCallBackM30209f != null) {
            binderCallBackM30209f.onNullBinding(componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.m36988i("BinderAdapter", "BinderAdapter Enter onServiceConnected.");
        this.f23107e = iBinder;
        m30206c();
        BinderCallBack binderCallBackM30209f = m30209f();
        if (binderCallBackM30209f != null) {
            binderCallBackM30209f.onServiceConnected(componentName, iBinder);
        }
        m30207d();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.m36988i("BinderAdapter", "Enter onServiceDisconnected.");
        BinderCallBack binderCallBackM30209f = m30209f();
        if (binderCallBackM30209f != null) {
            binderCallBackM30209f.onServiceDisconnected(componentName);
        }
        m30211h();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.f23103a, this);
    }

    public void updateDelayTask() {
        HMSLog.m36983d("BinderAdapter", "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            try {
                Handler handler = this.f23111i;
                if (handler != null) {
                    handler.removeMessages(getMsgDelayDisconnect());
                    this.f23111i.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private void m30202a() {
        if (TextUtils.isEmpty(this.f23104b) || TextUtils.isEmpty(this.f23105c)) {
            m30208e();
        }
        Intent intent = new Intent(this.f23104b);
        try {
            intent.setPackage(this.f23105c);
        } catch (IllegalArgumentException unused) {
            HMSLog.m36986e("BinderAdapter", "IllegalArgumentException when bindCoreService intent.setPackage");
            m30208e();
        }
        synchronized (this.f23108f) {
            try {
                if (this.f23103a.bindService(intent, this, 1)) {
                    m30210g();
                } else {
                    this.f23109g = true;
                    m30208e();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m30205b() {
        BinderCallBack binderCallBackM30209f = m30209f();
        if (binderCallBackM30209f != null) {
            binderCallBackM30209f.onBinderFailed(-1);
        }
    }
}
