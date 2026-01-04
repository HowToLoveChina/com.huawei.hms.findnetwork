package com.huawei.android.hicloud.album.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.huawei.android.hicloud.album.service.ICallbackHelper;
import com.huawei.android.hicloud.album.service.ICloudAlbumSdkServiceCallback;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import p031b7.C1120a;
import p281f8.C9674k;

/* renamed from: com.huawei.android.hicloud.album.service.a */
/* loaded from: classes2.dex */
public class C2414a implements CallbackHandler {

    /* renamed from: a */
    public final c f11513a;

    /* renamed from: b */
    public c f11514b;

    /* renamed from: c */
    public ICallbackHelper f11515c;

    /* renamed from: d */
    public ConcurrentLinkedQueue<Message> f11516d;

    /* renamed from: e */
    public Context f11517e;

    /* renamed from: f */
    public Map<Object, Handler> f11518f;

    /* renamed from: g */
    public d f11519g;

    /* renamed from: com.huawei.android.hicloud.album.service.a$b */
    public static class b {

        /* renamed from: a */
        public static C2414a f11520a = new C2414a();
    }

    /* renamed from: com.huawei.android.hicloud.album.service.a$c */
    public class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1120a.m6677i("CallbackHelper", "onServiceConnected");
            if (componentName == null || !"com.huawei.android.hicloud.album.service.CloudAlbumSdkService".equals(componentName.getClassName())) {
                C1120a.m6676e("CallbackHelper", "service connect invalid");
                return;
            }
            C2414a.this.f11515c = ICallbackHelper.AbstractBinderC2408a.m15030a(iBinder);
            C2414a.this.m15055j();
            try {
                if (C2414a.this.f11515c != null) {
                    C2414a.this.f11515c.registerCallback(C2414a.this.f11519g);
                }
            } catch (RemoteException e10) {
                C1120a.m6676e("CallbackHelper", "registerCallback error: " + e10.toString());
            }
            C1120a.m6675d("CallbackHelper", "onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C1120a.m6677i("CallbackHelper", "onServiceDisconnected");
            C2414a.this.f11516d.clear();
            if (C2414a.this.f11515c != null) {
                try {
                    C2414a.this.f11515c.unregisterCallback(C2414a.this.f11519g);
                } catch (RemoteException unused) {
                    C1120a.m6676e("CallbackHelper", "unregisterCallback error!");
                }
            }
            C2414a.this.f11515c = null;
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.a$d */
    public class d extends ICloudAlbumSdkServiceCallback.Stub {
        public d() {
        }

        @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkServiceCallback
        public void onApplyBatch(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkServiceCallback
        public void onResult(int i10, Bundle bundle) throws RemoteException {
            C2414a.this.m15053h(i10, bundle);
        }
    }

    /* renamed from: l */
    public static C2414a m15051l() {
        return b.f11520a;
    }

    @Override // com.huawei.android.hicloud.album.service.CallbackHandler
    public boolean canStartDownloading(boolean z10, int i10) {
        return false;
    }

    /* renamed from: g */
    public final void m15052g(int i10, Bundle bundle, int i11) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i10;
        messageObtain.obj = bundle;
        messageObtain.arg1 = i11;
        if (this.f11516d.contains(messageObtain)) {
            return;
        }
        this.f11516d.add(messageObtain);
    }

    @Override // com.huawei.android.hicloud.album.service.CallbackHandler
    public C9674k getSyncStrategy() {
        return null;
    }

    /* renamed from: h */
    public final void m15053h(int i10, Bundle bundle) {
        C1120a.m6675d("CallbackHelper", "broadcastEvent id: " + i10 + ", for handler: " + this.f11518f.size());
        Iterator<Map.Entry<Object, Handler>> it = this.f11518f.entrySet().iterator();
        while (it.hasNext()) {
            Handler value = it.next().getValue();
            value.sendMessage(value.obtainMessage(i10, bundle));
        }
    }

    /* renamed from: i */
    public final void m15054i() {
        if (m15058n() || this.f11517e == null) {
            C1120a.m6678w("CallbackHelper", "Service has connect or never call disConnectService last times! connectService call MUST after ApplicationContext is init!");
            return;
        }
        C1120a.m6675d("CallbackHelper", "begin connectService");
        this.f11514b = this.f11513a;
        Intent intent = new Intent();
        intent.setClassName("com.huawei.hidisk", "com.huawei.android.hicloud.album.service.CloudAlbumSdkService");
        intent.setAction(ICallbackHelper.class.getName());
        this.f11517e.bindService(intent, this.f11514b, 1);
    }

    @Override // com.huawei.android.hicloud.album.service.CallbackHandler
    public boolean invokeEvent(int i10, Bundle bundle) {
        C1120a.m6677i("CallbackHelper", "invokeEvent, msgId: " + i10);
        try {
            if (m15058n()) {
                ICallbackHelper iCallbackHelper = this.f11515c;
                if (iCallbackHelper != null) {
                    iCallbackHelper.invokeEvent(i10, bundle);
                }
                if (!this.f11516d.isEmpty()) {
                    return true;
                }
                m15061q();
                return true;
            }
            C1120a.m6678w("CallbackHelper", "Service has not connected! Will auto connect and invoke event, funcId: " + i10);
            m15052g(i10, bundle, 2);
            m15054i();
            return true;
        } catch (RemoteException e10) {
            C1120a.m6676e("CallbackHelper", "invokeEvent call remote service error! " + e10.toString() + "funcId: " + i10);
            return false;
        }
    }

    /* renamed from: j */
    public final void m15055j() {
        while (!this.f11516d.isEmpty()) {
            Message messagePoll = this.f11516d.poll();
            int i10 = messagePoll.arg1;
            if (i10 == 1) {
                sendMessage(messagePoll.what, (Bundle) messagePoll.obj);
            } else if (i10 == 2) {
                invokeEvent(messagePoll.what, (Bundle) messagePoll.obj);
            }
            if (!m15058n()) {
                C1120a.m6677i("CallbackHelper", "dealMessage service disconnected");
                this.f11516d.clear();
                return;
            }
        }
    }

    /* renamed from: k */
    public final void m15056k() {
        C1120a.m6677i("CallbackHelper", "disConnectService");
        if (!m15058n()) {
            C1120a.m6678w("CallbackHelper", "Service has disconnect!");
            return;
        }
        try {
            this.f11517e.unbindService(this.f11514b);
        } catch (Exception e10) {
            C1120a.m6676e("CallbackHelper", "disConnectService error: " + e10.toString());
        }
        this.f11515c = null;
        this.f11514b = null;
    }

    /* renamed from: m */
    public void m15057m(Context context) {
        C1120a.m6677i("CallbackHelper", "init");
        this.f11517e = context;
    }

    /* renamed from: n */
    public final boolean m15058n() {
        return (this.f11514b == null || this.f11515c == null) ? false : true;
    }

    /* renamed from: o */
    public void m15059o(Object obj, Handler handler) {
        C1120a.m6677i("CallbackHelper", "register");
        if (obj == null || handler == null) {
            C1120a.m6676e("CallbackHelper", "register params is invalid!");
            return;
        }
        if (!m15058n()) {
            m15054i();
        }
        this.f11518f.put(obj, handler);
        C1120a.m6675d("CallbackHelper", "Handler size add to: " + this.f11518f.size());
    }

    /* renamed from: p */
    public void m15060p(int i10, Bundle bundle) {
        C1120a.m6675d("CallbackHelper", "sendCallbackMassage id: " + i10 + ", for handler: " + this.f11518f.size());
        m15053h(i10, bundle);
    }

    /* renamed from: q */
    public final void m15061q() {
        if (this.f11518f.size() == 0 && m15058n()) {
            m15056k();
        }
    }

    /* renamed from: r */
    public void m15062r(Object obj) {
        C1120a.m6677i("CallbackHelper", "unregister");
        if (obj == null) {
            C1120a.m6676e("CallbackHelper", "unregister params is invalid!");
            return;
        }
        this.f11518f.remove(obj);
        C1120a.m6675d("CallbackHelper", "Handler size remove to: " + this.f11518f.size());
        m15061q();
    }

    @Override // com.huawei.android.hicloud.album.service.CallbackHandler
    public void sendMessage(int i10, Bundle bundle) {
        C1120a.m6677i("CallbackHelper", "sendMessage, msgId: " + i10);
        try {
            if (m15058n()) {
                ICallbackHelper iCallbackHelper = this.f11515c;
                if (iCallbackHelper != null) {
                    iCallbackHelper.sendMessage(i10, bundle);
                }
                if (this.f11516d.isEmpty()) {
                    m15061q();
                    return;
                }
                return;
            }
            C1120a.m6678w("CallbackHelper", "Service has not connected! Will auto connect and send message, msgId: " + i10);
            m15052g(i10, bundle, 1);
            m15054i();
        } catch (RemoteException e10) {
            C1120a.m6676e("CallbackHelper", "sendMessage call remote service error! " + e10.toString() + "funcId: " + i10);
        }
    }

    @Override // com.huawei.android.hicloud.album.service.CallbackHandler
    public void stInvalid(boolean z10) {
    }

    public C2414a() {
        this.f11513a = new c();
        this.f11516d = new ConcurrentLinkedQueue<>();
        this.f11518f = new ConcurrentHashMap();
        this.f11519g = new d();
    }
}
