package com.huawei.android.remotecontrol.registration;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import java.util.Timer;
import java.util.TimerTask;
import p015ak.C0209d;
import p015ak.C0241z;
import p226df.C9094b;
import p520of.C11853c;
import p520of.C11860j;
import p521og.C11873f;
import p521og.C11877j;
import p521og.C11881n;
import p575qe.C12347f;
import p611rf.C12494b;
import p611rf.C12498f;
import p611rf.C12499g;
import p664u0.C13108a;
import p681uj.C13195l;
import p709vj.C13452e;
import p783xp.AbstractC13844b;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12796a;
import sg.C12797b;
import ug.C13172b;

/* loaded from: classes4.dex */
public class ControlService extends Service {

    /* renamed from: i */
    public static boolean f20093i = false;

    /* renamed from: a */
    public Context f20094a;

    /* renamed from: b */
    public Messenger f20095b;

    /* renamed from: c */
    public Timer f20096c;

    /* renamed from: d */
    public Timer f20097d;

    /* renamed from: f */
    public C4400e f20099f;

    /* renamed from: e */
    public String f20098e = "";

    /* renamed from: g */
    public boolean f20100g = false;

    /* renamed from: h */
    public IBinder f20101h = null;

    /* renamed from: com.huawei.android.remotecontrol.registration.ControlService$a */
    public class C4396a extends TimerTask {
        public C4396a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (ControlService.this.f20098e != null && !ControlService.this.f20098e.isEmpty()) {
                C13981a.m83989i("ControlService", "GetTokenTask:token is not empty");
            } else {
                C13981a.m83989i("ControlService", "GetTokenTask:HttpUtil.GetPushToken");
                C11881n.m71368r(ControlService.this.f20094a);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.registration.ControlService$b */
    public class C4397b implements Handler.Callback {

        /* renamed from: a */
        public final int f20103a;

        /* renamed from: b */
        public int f20104b;

        /* renamed from: c */
        public int f20105c;

        public C4397b(int i10, int i11) {
            this.f20103a = i10;
            this.f20105c = i11;
        }

        /* renamed from: a */
        public void m26521a(int i10) {
            C13981a.m83989i("ControlService", "handleDoNormalRegistrationSuccess dealPushAfterRegister,push:" + i10);
            if (1 != i10) {
                C11881n.m71368r(ControlService.this.f20094a);
            } else {
                C13981a.m83987d("ControlService", "push has been registered");
                C11877j.m71274i1(ControlService.this.f20094a, Boolean.TRUE);
            }
        }

        /* renamed from: b */
        public void m26522b(int i10, String str, boolean z10) throws RemoteException {
            C13981a.m83989i("ControlService", "handleDoNormalRegistrationSuccess handleActive,active:" + i10 + ";bIsBack:" + ControlService.f20093i + ";isRegOnPushTokenChanged:" + z10);
            if (1 == i10) {
                C13981a.m83989i("ControlService", "need setLogoutIntent2");
                new C9094b().m82860b();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isBack", ControlService.f20093i);
            if (1 == i10 && !ControlService.f20093i) {
                C4375j.m26421w(false);
                C13172b.m79213i(ControlService.this.f20094a, this.f20105c);
                bundle.putString("ticket", C4347e.m26235f(str));
                bundle.putString("resp_ticket", str);
                ControlService.this.m26520s(16, bundle);
                return;
            }
            if (1 != i10 && z10) {
                C11877j.m71274i1(ControlService.this.f20094a, Boolean.FALSE);
                return;
            }
            if (1 != i10 && ControlService.f20093i) {
                C11877j.a.m71321a(ControlService.this.f20094a);
                C1175a.m7398t(false, ControlService.this.f20094a);
                C11877j.m71274i1(ControlService.this.f20094a, Boolean.FALSE);
                ControlService.this.m26518q(20);
                return;
            }
            if (1 != i10) {
                C11877j.a.m71321a(ControlService.this.f20094a);
                C1175a.m7398t(false, ControlService.this.f20094a);
                C11877j.m71274i1(ControlService.this.f20094a, Boolean.FALSE);
                ControlService.this.m26518q(6);
            }
        }

        /* renamed from: c */
        public boolean m26523c(C12494b c12494b, boolean z10) throws RemoteException {
            if (c12494b == null && z10) {
                C13981a.m83988e("ControlService", "activeResult is null isregOnPushTokenChanged");
                C11877j.m71274i1(ControlService.this.f20094a, Boolean.FALSE);
                return true;
            }
            if (c12494b == null && ControlService.f20093i) {
                C13981a.m83988e("ControlService", "activeResult is null bIsBack");
                ControlService.this.m26518q(20);
                return true;
            }
            if (c12494b == null) {
                C13981a.m83988e("ControlService", "activeResult is null !bIsBack");
                ControlService.this.m26518q(6);
                return true;
            }
            C13981a.m83987d("ControlService", "activeResult->" + c12494b.toString());
            return false;
        }

        /* renamed from: d */
        public void m26524d(boolean z10, int i10) throws RemoteException {
            C13981a.m83988e("ControlService", " normal register result=" + this.f20104b);
            Bundle bundle = new Bundle();
            bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, i10);
            if (z10) {
                C11877j.m71274i1(ControlService.this.f20094a, Boolean.FALSE);
                ControlService.this.m26519r(20, bundle);
            } else if (!ControlService.f20093i) {
                ControlService.this.m26519r(6, bundle);
            } else {
                C13981a.m83988e("ControlService", "handleDoNormalRegistrationFail clearUISwitchToFile,switch is off");
                ControlService.this.m26519r(20, bundle);
            }
        }

        /* renamed from: e */
        public void m26525e(Message message, boolean z10, String str) throws RemoteException {
            if (message == null) {
                C13981a.m83988e("ControlService", "handleDoNormalRegistrationSuccess null msg");
                return;
            }
            int iM26233d = C4347e.m26233d(str);
            C13981a.m83989i("ControlService", "register resultCode:" + iM26233d + ";isRegOnPushTokenChanged:" + z10);
            if (m26527g(message, iM26233d, z10)) {
                C13981a.m83988e("ControlService", "handleDoNormalRegistrationSuccess handleResultCode error");
                return;
            }
            C12494b c12494bM74991a = C12494b.m74991a(str);
            if (c12494bM74991a == null) {
                C13981a.m83988e("ControlService", "handleDoNormalRegistrationSuccess null activeResult");
            } else {
                if (m26523c(c12494bM74991a, z10)) {
                    return;
                }
                m26522b(c12494bM74991a.m74992b(), str, z10);
                if (1 == c12494bM74991a.m74994d()) {
                    C13981a.m83988e("ControlService", "sim has been registered");
                }
                m26521a(c12494bM74991a.m74993c());
            }
        }

        /* renamed from: f */
        public void m26526f(Message message) throws RemoteException {
            this.f20104b = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i("ControlService", "MSG_NORMAL_REGISTRATION result:" + this.f20104b);
            C12796a c12796a = new C12796a();
            ControlService.this.m26513l();
            boolean zM7389k = C1175a.m7389k(ControlService.this.f20094a);
            int i10 = this.f20104b;
            if (200 == i10) {
                String string = message.getData().getString("response_info");
                m26525e(message, zM7389k, string);
                int iM26233d = C4347e.m26233d(string);
                C13981a.m83989i("ControlService", "phone finder active on handleRegisterResult, resultCode:" + iM26233d);
                if (iM26233d == 0 || iM26233d == 3211) {
                    C13981a.m83989i("ControlService", "phoneFinder active on handleRegisterResult is success");
                    c12796a.m76772e(ControlService.this.f20094a, "ControlService", "0", String.valueOf(C11873f.m71178f().m71183e()), null, "01011", null, "active", null);
                } else {
                    c12796a.m76772e(ControlService.this.f20094a, "ControlService", "001_3004", "handleRegisterResult is fail,resultCode" + iM26233d, null, "01011", null, "active", null);
                }
            } else {
                m26524d(zM7389k, i10);
                c12796a.m76772e(ControlService.this.f20094a, "ControlService", "001_3003", "handleRegisterResult is fail,result" + this.f20104b, null, "01011", null, "active", null);
            }
            boolean unused = ControlService.f20093i = false;
        }

        /* renamed from: g */
        public boolean m26527g(Message message, int i10, boolean z10) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, i10);
            if (i10 == 401) {
                C13195l.m79272J().m79325o0(message.getData().getString("access_token"));
                if (ControlService.this.f20100g) {
                    ControlService.this.m26519r(10, bundle);
                } else {
                    C11860j.m71051f0(ControlService.this.f20094a, 9, false);
                    ControlService.this.f20100g = true;
                }
                return true;
            }
            if (i10 != 0 && z10) {
                C11877j.m71274i1(ControlService.this.f20094a, Boolean.FALSE);
                return true;
            }
            if (i10 == 3210 || i10 == 3212) {
                ControlService.this.m26519r(ControlService.f20093i ? 20 : 6, bundle);
                return true;
            }
            if (i10 == 3211 || i10 == 0) {
                return false;
            }
            return ControlService.this.m26515n(i10, bundle);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws RemoteException {
            if (3003 != this.f20103a) {
                return true;
            }
            m26526f(message);
            return true;
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.registration.ControlService$c */
    public class HandlerC4398c extends Handler {
        public HandlerC4398c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1 == message.what) {
                ControlService.this.m26516o(message);
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.registration.ControlService$d */
    public class C4399d extends TimerTask {
        public C4399d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws RemoteException {
            C13981a.m83989i("ControlService", "MyTimerTask time out");
            if (ControlService.this.f20097d != null) {
                ControlService.this.f20097d.cancel();
                ControlService.this.f20097d = null;
            }
            Bundle bundle = new Bundle();
            int i10 = (ControlService.this.f20098e == null || ControlService.this.f20098e.isEmpty()) ? 31 : 32;
            if (C1175a.m7389k(ControlService.this.f20094a)) {
                C11877j.m71274i1(ControlService.this.f20094a, Boolean.FALSE);
                if (C1175a.m7390l(ControlService.this.f20094a, C13452e.m80781L().m80971t0())) {
                    ControlService.this.m26518q(5);
                }
            } else {
                bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, i10);
                if (ControlService.f20093i) {
                    ControlService.this.m26519r(20, bundle);
                } else {
                    ControlService.this.m26519r(6, bundle);
                }
            }
            new C12797b().m76784j(ControlService.this.f20094a, "ControlService", "001_" + i10, "open phoneFinder switch time out", null, "01011", null, "active", true);
            boolean unused = ControlService.f20093i = false;
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.registration.ControlService$e */
    public class C4400e extends BroadcastReceiver {
        public C4400e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws RemoteException {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (!"com.huawei.remotecontrol.intent.action.REGISTRATION".equals(hiCloudSafeIntent.getAction())) {
                C13981a.m83988e("ControlService", "not push token send");
                return;
            }
            C13981a.m83989i("ControlService", "receive push token");
            ControlService.this.f20098e = hiCloudSafeIntent.getStringExtra("push_token");
            if (TextUtils.isEmpty(ControlService.this.f20098e)) {
                C13981a.m83988e("ControlService", "token is null");
                return;
            }
            C11877j.m71209G0(ControlService.this.f20094a, ControlService.this.f20098e);
            if (C11873f.m71178f().m71184g()) {
                C13981a.m83989i("ControlService", "Open phoneFinder is handling, event break");
            } else {
                ControlService controlService = ControlService.this;
                controlService.m26514m(controlService.f20098e);
            }
        }
    }

    /* renamed from: t */
    public static void m26512t(Bundle bundle) {
        f20093i = bundle.getBoolean("isBack");
    }

    /* renamed from: l */
    public final void m26513l() {
        C13981a.m83989i("ControlService", "cancelTimer");
        Timer timer = this.f20096c;
        if (timer != null) {
            timer.cancel();
            this.f20096c = null;
        }
        Timer timer2 = this.f20097d;
        if (timer2 != null) {
            timer2.cancel();
            this.f20097d = null;
        }
    }

    /* renamed from: m */
    public void m26514m(String str) throws RemoteException {
        byte[] bArrM7391m;
        C13981a.m83989i("ControlService", "doNormalRegistration");
        if (!C0209d.m1166E1()) {
            C13981a.m83988e("ControlService", "not OwnerUser");
            return;
        }
        if (!C11853c.m70968g().m70972h(C12347f.m74285n().m74301m())) {
            C13981a.m83989i("ControlService", "check client key fail");
            return;
        }
        if (this.f20094a != null) {
            Bundle bundle = new Bundle();
            if (C1175a.m7395q(this.f20094a, C13452e.m80781L().m80971t0())) {
                C13981a.m83989i("ControlService", "open phoneFinder fail: uid not match");
                m26519r(42, bundle);
                return;
            }
            C12797b c12797b = new C12797b();
            String deviceID = AbstractC12139d.m72766e(this.f20094a).getDeviceID();
            if (!C12498f.m75019f(deviceID)) {
                C13981a.m83988e("ControlService", "doNormalRegistration->deviceID is not validated");
                bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 33);
                m26519r(6, bundle);
                c12797b.m76784j(this, "ControlService", "001_1000", "deviceID is not validated", null, "01011", null, "active", true);
                return;
            }
            String deviceType = AbstractC12139d.m72766e(this.f20094a).getDeviceType();
            String strM75016c = C12498f.m75016c(this.f20094a, deviceID, deviceType);
            if (strM75016c == null) {
                C13981a.m83988e("ControlService", "deviceIdAlias is invalidate.");
                m26513l();
                if (f20093i) {
                    bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 34);
                    m26519r(25, bundle);
                    c12797b.m76784j(this, "ControlService", "001_1000", "deviceID is invalidate", null, "01011", null, "active", true);
                    return;
                } else {
                    bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 34);
                    m26519r(24, bundle);
                    c12797b.m76784j(this, "ControlService", "001_1000", "deviceID is invalidate,bIsBack is false", null, "01011", null, "active", true);
                    return;
                }
            }
            if (TextUtils.isEmpty(deviceType)) {
                C13981a.m83988e("ControlService", "doNormalRegistration:deviceType is empty");
                bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 35);
                m26519r(6, bundle);
                c12797b.m76784j(this, "ControlService", "001_1000", "deviceType is null", null, "01011", null, "active", true);
                return;
            }
            String serviceToken = AbstractC12139d.m72766e(this.f20094a).getServiceToken();
            String deviceTicket = AbstractC12139d.m72766e(this.f20094a).getDeviceTicket();
            C13981a.m83987d("ControlService", "site id is:" + AbstractC12139d.m72766e(this.f20094a).getSiteID());
            int iM79205a = C13172b.m79205a(this.f20094a);
            String strM83105a = null;
            if (!C1175a.m7385g(true) && C0209d.m1301r1(this.f20094a) && C11860j.m71031Y() && (bArrM7391m = C1175a.m7391m()) != null && bArrM7391m.length != 0) {
                strM83105a = AbstractC13844b.m83105a(bArrM7391m);
            }
            new C12499g(str, deviceID, strM75016c, C0241z.m1685c(deviceType), serviceToken, "v11", strM83105a, "", 1, new C4397b(SNSCode.Status.GET_GROUP_LIST_FAIL, iM79205a), this.f20094a, iM79205a, deviceTicket, C1175a.m7388j()).m75025f();
        }
    }

    /* renamed from: n */
    public final boolean m26515n(int i10, Bundle bundle) throws RemoteException {
        if (3001 == i10 && 5 != C11873f.m71178f().m71183e()) {
            bundle.putBoolean("socId_has_register", true);
        }
        if (3201 == i10) {
            bundle.putBoolean("lock_oversea_repeat", true);
        }
        m26519r(f20093i ? 20 : 6, bundle);
        return true;
    }

    /* renamed from: o */
    public void m26516o(Message message) {
        this.f20095b = message.replyTo;
        C13981a.m83989i("ControlService", "handleMessage->MSG_PHONEFINDER_ON");
        m26517p(message);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f20101h;
    }

    @Override // android.app.Service
    public void onCreate() {
        C13981a.m83989i("ControlService", "onCreate");
        super.onCreate();
        this.f20101h = new Messenger(new HandlerC4398c(Looper.getMainLooper())).getBinder();
        this.f20094a = getApplicationContext();
    }

    @Override // android.app.Service
    public void onDestroy() {
        C13981a.m83989i("ControlService", "control service destroy!");
        this.f20095b = null;
        if (this.f20099f != null) {
            C13108a.m78878b(this.f20094a).m78883f(this.f20099f);
            this.f20099f = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (intent == null) {
            C13981a.m83988e("ControlService", "onStartCommand intent is null");
            return 2;
        }
        String action = new HiCloudSafeIntent(intent).getAction();
        if (action == null) {
            C13981a.m83988e("ControlService", "onStartCommand action is null");
            return 2;
        }
        C13981a.m83989i("ControlService", "onStartCommand->" + action);
        return 2;
    }

    /* renamed from: p */
    public void m26517p(Message message) {
        Bundle data = message.getData();
        m26512t(data);
        int i10 = data.getInt("regist_type", 0);
        C11881n.m71368r(this.f20094a);
        if (this.f20099f == null) {
            C13981a.m83989i("ControlService", "register receive push token receiver");
            this.f20099f = new C4400e();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.remotecontrol.intent.action.REGISTRATION");
            C13108a.m78878b(this.f20094a).m78880c(this.f20099f, intentFilter);
        }
        if (i10 == 5 && this.f20097d == null) {
            C4396a c4396a = new C4396a();
            Timer timer = new Timer();
            this.f20097d = timer;
            timer.schedule(c4396a, 5000L, 5000L);
        }
        C11873f.m71178f().m71187j(i10);
        C11873f.m71178f().m71182d().put("activetrue", C12797b.m76774a("01011"));
        C11873f.m71178f().m71179a(false);
        C4399d c4399d = new C4399d();
        Timer timer2 = new Timer();
        this.f20096c = timer2;
        timer2.schedule(c4399d, 60000L);
    }

    /* renamed from: q */
    public void m26518q(int i10) throws RemoteException {
        try {
            Message messageObtain = Message.obtain((Handler) null, i10);
            Messenger messenger = this.f20095b;
            if (messenger != null) {
                messenger.send(messageObtain);
            } else {
                C13981a.m83988e("ControlService", "sendMessageToUI->replyToMsg is null");
            }
        } catch (RemoteException e10) {
            C13981a.m83988e("ControlService", "sendMessageToUI RemoteException" + e10.getMessage());
        }
    }

    /* renamed from: r */
    public void m26519r(int i10, Bundle bundle) throws RemoteException {
        try {
            Message messageObtain = Message.obtain((Handler) null, i10);
            if (bundle != null) {
                messageObtain.setData(bundle);
            }
            Messenger messenger = this.f20095b;
            if (messenger != null) {
                messenger.send(messageObtain);
            } else {
                C13981a.m83988e("ControlService", "sendMessageToUI->replyToMsg is null");
            }
        } catch (RemoteException e10) {
            C13981a.m83988e("ControlService", "sendMessageToUI RemoteException" + e10.getMessage());
        }
    }

    /* renamed from: s */
    public void m26520s(int i10, Bundle bundle) throws RemoteException {
        try {
            Message messageObtain = Message.obtain((Handler) null, i10);
            messageObtain.setData(bundle);
            Messenger messenger = this.f20095b;
            if (messenger != null) {
                messenger.send(messageObtain);
            } else {
                C13981a.m83988e("ControlService", "sendTickMessageToUI->replyToMsg is null");
            }
        } catch (RemoteException e10) {
            C13981a.m83988e("ControlService", "sendMessageToUI RemoteException" + e10.getMessage());
        }
    }
}
