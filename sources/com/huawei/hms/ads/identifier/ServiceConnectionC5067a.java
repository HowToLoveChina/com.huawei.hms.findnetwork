package com.huawei.hms.ads.identifier;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.ads.identifier.a */
/* loaded from: classes8.dex */
public final class ServiceConnectionC5067a implements ServiceConnection {

    /* renamed from: a */
    public static final ThreadPoolExecutor f23178a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: b */
    boolean f23179b = false;

    /* renamed from: c */
    private final LinkedBlockingQueue<IBinder> f23180c = new LinkedBlockingQueue<>(1);

    /* renamed from: a */
    public IBinder m30248a() throws InterruptedException {
        if (this.f23179b) {
            throw new IllegalStateException();
        }
        this.f23179b = true;
        return this.f23180c.take();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        Log.d("PPSSerivceConnection", "onServiceConnected");
        f23178a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
                    ServiceConnectionC5067a.this.f23180c.offer(iBinder);
                } catch (Throwable th2) {
                    Log.w("PPSSerivceConnection", "onServiceConnected  " + th2.getClass().getSimpleName());
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
