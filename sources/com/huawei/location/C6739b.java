package com.huawei.location;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.huawei.riemann.common.api.location.CityTileCallback;
import com.huawei.riemann.location.SdmLocationAlgoWrapper;
import com.huawei.riemann.location.bean.obs.Pvt;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.huawei.location.b */
/* loaded from: classes8.dex */
public final class C6739b {

    /* renamed from: a */
    public Context f31195a;

    /* renamed from: b */
    public e f31196b;

    /* renamed from: c */
    public b f31197c;

    /* renamed from: d */
    public c f31198d;

    /* renamed from: e */
    public ArrayList<InterfaceC6729a> f31199e;

    /* renamed from: f */
    public boolean f31200f;

    /* renamed from: g */
    public SdmLocationAlgoWrapper f31201g;

    /* renamed from: h */
    public d f31202h;

    /* renamed from: i */
    public CityTileCallback f31203i;

    /* renamed from: j */
    public volatile boolean f31204j;

    /* renamed from: com.huawei.location.b$a */
    public class a implements Runnable {

        /* renamed from: a */
        public long f31205a;

        /* renamed from: b */
        public byte[] f31206b;

        public a(long j10, byte[] bArr) {
            this.f31205a = j10;
            this.f31206b = bArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.d("SdmLocationManager", "TileUpdateRunnable run");
            SdmLocationAlgoWrapper sdmLocationAlgoWrapper = C6739b.this.f31201g;
            if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.f40562a) {
                Log.e("SdmLocationManager", "wp is null");
            } else {
                sdmLocationAlgoWrapper.sdmUpdateTileById(this.f31205a, this.f31206b);
            }
        }
    }

    /* renamed from: com.huawei.location.b$b */
    public static class b extends HandlerThread {

        /* renamed from: a */
        public C6739b f31208a;

        public b(C6739b c6739b) {
            super("SdmLocationManagerThread");
            this.f31208a = c6739b;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            if (this.f31208a == null) {
                Log.i("SdmLocationManager", "slmgr null");
            }
        }
    }

    /* renamed from: com.huawei.location.b$c */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            String str2;
            try {
                super.handleMessage(message);
                int i10 = message.what;
                if (i10 == 11) {
                    Log.d("SdmLocationManager", "handleMessage REGISTER LISTENER");
                    Object obj = message.obj;
                    if (obj instanceof InterfaceC6729a) {
                        C6739b.this.f31199e.add((InterfaceC6729a) obj);
                        return;
                    }
                    return;
                }
                if (i10 == 12) {
                    Log.d("SdmLocationManager", "handleMessage UNREGISTER LISTENER");
                    Object obj2 = message.obj;
                    if (obj2 instanceof InterfaceC6729a) {
                        C6739b.this.f31199e.remove((InterfaceC6729a) obj2);
                        return;
                    }
                    return;
                }
                if (i10 == 17) {
                    str = "handleMessage DELIVER RAW OBS";
                } else {
                    if (i10 == 18) {
                        Log.d("SdmLocationManager", "handleMessage REQUEST REMOTE TILE");
                        Bundle data = message.getData();
                        if (data == null) {
                            Log.e("SdmLocationManager", "bundle is null");
                            return;
                        }
                        long j10 = data.getLong("tileId");
                        CityTileCallback cityTileCallback = C6739b.this.f31203i;
                        if (cityTileCallback != null) {
                            byte[] bArr = cityTileCallback.get(j10);
                            C6739b c6739b = C6739b.this;
                            c6739b.getClass();
                            Log.d("SdmLocationManager", "update local tile");
                            e eVar = c6739b.f31196b;
                            if (eVar != null) {
                                eVar.postAtFrontOfQueue(c6739b.new a(j10, bArr));
                                return;
                            }
                            str2 = "result hd is null";
                        } else {
                            str2 = "rcb null";
                        }
                        Log.e("SdmLocationManager", str2);
                        return;
                    }
                    str = "handleMessage unknown " + message.what;
                }
                Log.d("SdmLocationManager", str);
            } catch (ClassCastException e10) {
                Log.e("SdmLocationManager", e10.getMessage() != null ? e10.getMessage() : "ClassCastException2");
                Log.e("SdmLocationManager", "SdmOpsHandler-".concat(0 == 0 ? "handleMessage" : null));
            }
        }
    }

    /* renamed from: com.huawei.location.b$d */
    public static class d implements CityTileCallback {

        /* renamed from: a */
        public CityTileCallback f31210a;

        /* renamed from: b */
        public Handler f31211b;

        public d(Handler handler, CityTileCallback cityTileCallback) {
            this.f31211b = handler;
            this.f31210a = cityTileCallback;
        }

        @Override // com.huawei.riemann.common.api.location.CityTileCallback
        public final byte[] get(long j10) {
            if (this.f31211b == null) {
                if (this.f31210a != null) {
                    Log.d("SdmLocationManager", "direct");
                    return this.f31210a.get(j10);
                }
                Log.e("SdmLocationManager", "hd and remote cb null");
                return new byte[0];
            }
            Log.d("SdmLocationManager", "through hd");
            Bundle bundle = new Bundle();
            bundle.putLong("tileId", j10);
            Message messageObtain = Message.obtain();
            messageObtain.what = 18;
            messageObtain.setData(bundle);
            this.f31211b.sendMessageAtFrontOfQueue(messageObtain);
            return new byte[0];
        }
    }

    /* renamed from: com.huawei.location.b$e */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                Log.d("SdmLocationManager", "SdmHandler msg - " + message.what);
                int i10 = message.what;
                if (i10 == 10001) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 10002;
                    messageObtain.setData(message.getData());
                    C6739b.this.f31196b.sendMessageAtFrontOfQueue(messageObtain);
                    return;
                }
                if (i10 != 10002) {
                    return;
                }
                Bundle data = message.getData();
                if (data == null) {
                    Log.e("SdmLocationManager", "bundle is null");
                    return;
                }
                Pvt pvt = (Pvt) data.getParcelable("imp-pvt");
                Iterator<InterfaceC6729a> it = C6739b.this.f31199e.iterator();
                while (it.hasNext()) {
                    it.next().m38280a(pvt);
                }
            } catch (ClassCastException e10) {
                Log.e("SdmLocationManager", e10.getMessage() != null ? e10.getMessage() : "ClassCastException1");
                Log.e("SdmLocationManager", "SdmResultHandler-".concat(0 == 0 ? "handleMessage" : null));
            }
        }

        public e(Looper looper) {
            super(looper);
        }
    }

    public C6739b(Context context, Intent intent, Looper looper, String str) {
        this.f31199e = new ArrayList<>();
        this.f31200f = false;
        this.f31201g = null;
        this.f31202h = null;
        this.f31203i = null;
        this.f31204j = false;
        this.f31195a = context;
        this.f31201g = SdmLocationAlgoWrapper.m53566a(context, str);
        m38292a(looper);
        int i10 = C6758e.f31321a;
    }

    /* renamed from: a */
    public final void m38292a(Looper looper) {
        if (!this.f31200f) {
            if (looper == null) {
                this.f31196b = Looper.myLooper() == null ? new e(this.f31195a.getMainLooper()) : new e();
            } else {
                this.f31196b = new e(looper);
            }
            b bVar = new b(this);
            this.f31197c = bVar;
            bVar.start();
            this.f31198d = new c(this.f31197c.getLooper());
        }
        this.f31200f = true;
    }

    public C6739b(Context context, Intent intent, String str) {
        this(context, intent, null, str);
    }

    public C6739b(Context context, Looper looper, String str) {
        this(context, null, looper, str);
    }

    public C6739b(Context context, String str) {
        this(context, null, null, str);
    }
}
