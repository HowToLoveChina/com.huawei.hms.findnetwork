package com.huawei.android.backup.service.logic;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import com.huawei.android.backup.backupremoteservice.IRemoteClientCallback;
import com.huawei.android.backup.backupremoteservice.IRemoteService;
import com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback;
import com.huawei.android.backup.filelogic.utils.C2109b;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.receiver.RestoreWifiCompleteReceiver;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import p047c5.C1386a;
import p217d5.C9041b;
import p229di.C9148m;
import p386j6.C10713c;
import p601r4.C12461a;
import p699v4.C13334c;
import p699v4.C13335d;
import p699v4.C13338g;
import p699v4.C13349r;
import p763x5.C13703a;
import p832z4.C14127a;
import p832z4.C14129c;
import p832z4.InterfaceC14130d;

/* loaded from: classes.dex */
public class BackupLogicService extends Service {

    /* renamed from: g */
    public static final boolean f9553g;

    /* renamed from: h */
    public static final int[][] f9554h;

    /* renamed from: i */
    public static final ArrayList<String> f9555i;

    /* renamed from: a */
    public final ConcurrentHashMap<Integer, IRemoteServiceCallback> f9556a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public HashMap<String, Integer> f9557b = new HashMap<>();

    /* renamed from: c */
    public int f9558c = -1;

    /* renamed from: d */
    public RestoreWifiCompleteReceiver f9559d = new RestoreWifiCompleteReceiver();

    /* renamed from: e */
    public BroadcastReceiver f9560e = null;

    /* renamed from: f */
    public final IRemoteService.AbstractBinderC2101a f9561f = new BinderC2117c();

    /* renamed from: com.huawei.android.backup.service.logic.BackupLogicService$b */
    public static class C2116b {

        /* renamed from: a */
        public String f9562a;

        /* renamed from: b */
        public String f9563b;

        /* renamed from: c */
        public Bundle f9564c;

        public C2116b(String str, String str2, Bundle bundle) {
            this.f9562a = str;
            this.f9563b = str2;
            this.f9564c = bundle;
        }

        /* renamed from: a */
        public String m12697a() {
            return this.f9563b;
        }

        /* renamed from: b */
        public String m12698b() {
            return this.f9562a;
        }

        /* renamed from: c */
        public Bundle m12699c() {
            return this.f9564c;
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.BackupLogicService$c */
    public class BinderC2117c extends IRemoteService.AbstractBinderC2101a {

        /* renamed from: com.huawei.android.backup.service.logic.BackupLogicService$c$a */
        public class a implements InterfaceC14130d {
            public a() {
            }

            @Override // p832z4.InterfaceC14130d
            /* renamed from: a */
            public void mo12700a() {
                C2111d.m12653i("BackupLogicService", "load done start preload.");
                C2152k.m12988n().m12996t(BackupLogicService.this);
                C14129c.m84798b().m84802f();
            }
        }

        public BinderC2117c() {
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int abortDoing(int i10) throws RemoteException {
            C2111d.m12654j("BackupLogicService", "Abort doing,clientId is：", Integer.valueOf(i10));
            if (BackupLogicService.this.m12691u(i10)) {
                return -2;
            }
            if (i10 == 0) {
                BackupLogicService.this.f9558c = 0;
            }
            C2153l.m13034b(BackupLogicService.this.new C2118d(i10));
            return 0;
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int checkAppRiskInfo(int i10, Bundle bundle) throws RemoteException {
            if (BackupLogicService.this.m12691u(i10)) {
                return -2;
            }
            if (bundle == null) {
                return -1;
            }
            BackupLogicService backupLogicService = BackupLogicService.this;
            C2153l.m13012G(backupLogicService, bundle, backupLogicService.new C2118d(i10));
            return 0;
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int doBackup(int i10, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException {
            C2111d.m12654j("BackupLogicService", "doBackup start!moduleName:", strArr != null ? Arrays.toString(strArr) : "");
            if (BackupLogicService.this.m12691u(i10)) {
                return -2;
            }
            if (BackupLogicService.this.m12693w(str, str2, strArr, bundle)) {
                return -1;
            }
            C2111d.m12647c("BackupLogicService", "doBackup ", Boolean.valueOf(BackupLogicService.this.m12682j(i10, str, str2, strArr, bundle)));
            return 0;
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int doBackupOneModule(int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException {
            C2111d.m12654j("BackupLogicService", "doBackupOneModule start!moduleName:", str3, ";clientId:", Integer.valueOf(i10));
            if (BackupLogicService.this.m12691u(i10)) {
                return -2;
            }
            if (C2157a.m13170E(str, str2, str3) || bundle == null) {
                return -1;
            }
            String[] strArrM12686p = BackupLogicService.this.m12686p(new String[]{str3});
            C2116b c2116b = new C2116b(str, str2, bundle);
            BackupLogicService backupLogicService = BackupLogicService.this;
            C2153l.m13055l0(backupLogicService, strArrM12686p, c2116b, backupLogicService.new C2118d(i10));
            return 0;
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int doRestore(int i10, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException {
            C2111d.m12654j("BackupLogicService", "doRestore start!moduleName:", strArr != null ? Arrays.toString(strArr) : "");
            if (BackupLogicService.this.m12691u(i10)) {
                return -2;
            }
            if (BackupLogicService.this.m12693w(str, str2, strArr, bundle)) {
                return -1;
            }
            C2111d.m12647c("BackupLogicService", "doRestore ", Boolean.valueOf(BackupLogicService.this.m12679A(i10, str, str2, BackupLogicService.this.m12686p(strArr), bundle)));
            return 0;
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int doRestoreOneModule(int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException {
            C2111d.m12654j("BackupLogicService", "doRestoreOneModule start!moduleName:", str3, ";clientId:", Integer.valueOf(i10));
            if (BackupLogicService.this.m12691u(i10)) {
                C2111d.m12657m("BackupLogicService", "Service is occupied.");
                return -2;
            }
            if (C2157a.m13170E(str, str2, str3) || bundle == null) {
                C2111d.m12657m("BackupLogicService", "Parameter error.");
                return -1;
            }
            String[] strArrM12686p = BackupLogicService.this.m12686p(new String[]{str3});
            C2116b c2116b = new C2116b(str, str2, bundle);
            BackupLogicService backupLogicService = BackupLogicService.this;
            C2153l.m13057m0(backupLogicService, strArrM12686p, c2116b, backupLogicService.new C2118d(i10));
            return 0;
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int getAppsSize(int i10, String[] strArr) throws RemoteException {
            if (BackupLogicService.this.m12691u(i10)) {
                return -2;
            }
            if (C2157a.m13170E(strArr)) {
                return -1;
            }
            String[] strArrM12686p = BackupLogicService.this.m12686p(strArr);
            BackupLogicService backupLogicService = BackupLogicService.this;
            C2153l.m13015J(backupLogicService, strArrM12686p, backupLogicService.new C2118d(i10));
            return 0;
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int getBackupModuleInfo(int i10, String[] strArr, Bundle bundle) throws RemoteException {
            C2111d.m12654j("BackupLogicService", "ModuleName:", strArr != null ? Arrays.toString(strArr) : "");
            if (BackupLogicService.this.m12691u(i10)) {
                return -2;
            }
            if (C2157a.m13170E(strArr) || bundle == null) {
                return -1;
            }
            String[] strArrM12686p = BackupLogicService.this.m12686p(strArr);
            BackupLogicService backupLogicService = BackupLogicService.this;
            C2153l.m13019N(backupLogicService, strArrM12686p, bundle, backupLogicService.new C2118d(i10));
            return 0;
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int getNewDeviceInfo(int i10, Bundle bundle) throws RemoteException {
            if (BackupLogicService.this.m12691u(i10)) {
                return -2;
            }
            if (bundle == null) {
                return -1;
            }
            BackupLogicService backupLogicService = BackupLogicService.this;
            C2153l.m13028W(backupLogicService, bundle, backupLogicService.new C2118d(i10));
            return 0;
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int registerCallback(int i10, int i11, IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException {
            C2111d.m12654j("BackupLogicService", "Register callback,clientId is：", Integer.valueOf(i10), ";aidlVersion is:", Integer.valueOf(i11));
            if (i11 < 1) {
                return -3;
            }
            if (i11 > 1) {
                return -4;
            }
            if (iRemoteServiceCallback == null) {
                C2111d.m12648d("BackupLogicService", "IRemoteServiceCallback is null");
                return -1;
            }
            if (BackupLogicService.this.m12691u(i10)) {
                C2111d.m12648d("BackupLogicService", "BackupService is occupied.");
                return -2;
            }
            BackupLogicService.this.f9558c = i10 / 1000;
            BackupLogicService.this.f9556a.put(Integer.valueOf(i10), iRemoteServiceCallback);
            return 0;
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public void startPreloadModuleInfo(int i10) throws RemoteException {
            C2152k.m12988n().m12995s();
            if (!C14129c.m84798b().m84799c()) {
                C14129c.m84798b().m84801e(new a());
                return;
            }
            C2111d.m12653i("BackupLogicService", "when go here load is done.");
            C2152k.m12988n().m12996t(BackupLogicService.this);
            C14129c.m84798b().m84802f();
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public void stopLoadModuleData() throws RemoteException {
            C2111d.m12653i("BackupLogicService", "stop load module data");
            C2153l.m13032a();
            C2152k.m12988n().m12995s();
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public void stopPreloadModuleInfo() throws RemoteException {
            C2152k.m12988n().m12995s();
        }

        @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
        public int unregisterCallback(int i10, IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException {
            C2111d.m12654j("BackupLogicService", "unregisterCallback start,clientId is：", Integer.valueOf(i10));
            if (iRemoteServiceCallback == null || !BackupLogicService.this.f9556a.containsKey(Integer.valueOf(i10))) {
                return -1;
            }
            BackupLogicService.this.f9558c = -1;
            BackupLogicService.this.f9556a.remove(Integer.valueOf(i10));
            return 0;
        }

        public /* synthetic */ BinderC2117c(BackupLogicService backupLogicService, C2115a c2115a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.BackupLogicService$d */
    public class C2118d implements Handler.Callback {

        /* renamed from: a */
        public int f9567a;

        public C2118d(int i10) {
            this.f9567a = i10;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null) {
                C2111d.m12648d("BackupLogicService", "message is null");
                return false;
            }
            message.what = BackupLogicService.m12677k(message.what);
            if (BackupLogicService.this.f9556a.containsKey(Integer.valueOf(this.f9567a))) {
                BackupLogicService backupLogicService = BackupLogicService.this;
                return backupLogicService.m12680B(message, (IRemoteServiceCallback) backupLogicService.f9556a.get(Integer.valueOf(this.f9567a)));
            }
            if (this.f9567a != 0 || message.what != 19) {
                C2111d.m12646b("BackupLogicService", "error msg");
                return false;
            }
            for (Integer num : BackupLogicService.this.f9556a.keySet()) {
                num.intValue();
                message.what = 80;
                BackupLogicService backupLogicService2 = BackupLogicService.this;
                backupLogicService2.m12680B(message, (IRemoteServiceCallback) backupLogicService2.f9556a.get(num));
            }
            return true;
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.BackupLogicService$e */
    public static class C2119e extends BroadcastReceiver {
        public C2119e() {
        }

        /* renamed from: a */
        public final boolean m12701a(String str) {
            return str.equals("android.intent.action.MEDIA_MOUNTED") || str.equals("android.intent.action.MEDIA_UNMOUNTED") || str.equals("android.intent.action.MEDIA_BAD_REMOVAL") || str.equals("android.intent.action.MEDIA_EJECT") || str.equals("android.intent.action.MEDIA_REMOVED");
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C2111d.m12653i("BackupLogicService", "intent is null.");
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C2111d.m12653i("BackupLogicService", "action is null.");
            } else if (!(C13338g.m80010a(intent, "filemanager.flag", false) && action.equals("android.intent.action.MEDIA_MOUNTED")) && m12701a(action)) {
                C13334c.m79958B(context);
                C12461a.m74714a(context);
            }
        }

        public /* synthetic */ C2119e(C2115a c2115a) {
            this();
        }
    }

    static {
        f9553g = C13349r.m80085a() && C2157a.m13178M();
        f9554h = new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}, new int[]{4, 4}, new int[]{5, 5}, new int[]{6, 6}, new int[]{11, 11}, new int[]{12, 12}, new int[]{13, 13}, new int[]{14, 14}, new int[]{15, 15}, new int[]{19, 19}, new int[]{20, 20}, new int[]{21, 21}, new int[]{23, 23}, new int[]{24, 24}, new int[]{25, 25}, new int[]{27, 27}, new int[]{28, 28}, new int[]{29, 29}, new int[]{33, 33}, new int[]{79, 79}, new int[]{36, 67}, new int[]{1067, 1067}, new int[]{1065, 1061}, new int[]{1068, 1068}, new int[]{1069, 1069}, new int[]{37, 1073}, new int[]{9, 9}, new int[]{38, 1074}, new int[]{7, 7}, new int[]{71, 71}, new int[]{1100, 1100}, new int[]{1101, 1101}, new int[]{1102, 1102}};
        f9555i = new ArrayList<>(Arrays.asList(HNConstants.DataType.CONTACT, "setting", "notepad", "Memo", "fmradio", "chatSms", "callRecorder", "soundrecorder"));
    }

    /* renamed from: k */
    public static int m12677k(int i10) {
        for (int[] iArr : f9554h) {
            if (iArr[0] == i10) {
                return iArr[1];
            }
        }
        return 6;
    }

    /* renamed from: l */
    public static void m12678l(int i10, int i11) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("dalvik.system.Zygote");
            Class<?> cls2 = Integer.TYPE;
            Integer num = (Integer) cls.getMethod("ctrlSockets", cls2, cls2).invoke(null, Integer.valueOf(i10), Integer.valueOf(i11));
            num.intValue();
            C2111d.m12654j("BackupLogicService", "ctrlSockets ", num);
        } catch (ClassNotFoundException unused) {
            C2111d.m12648d("BackupLogicService", "ctrlSockets ClassNotFoundException");
        } catch (IllegalAccessException | InvocationTargetException unused2) {
            C2111d.m12648d("BackupLogicService", "ctrlSockets fail");
        } catch (NoSuchMethodException unused3) {
            C2111d.m12648d("BackupLogicService", "This framework doesn't contain 'ctrlSockets' socket!");
        }
    }

    /* renamed from: A */
    public final boolean m12679A(int i10, String str, String str2, String[] strArr, Bundle bundle) {
        return C2153l.m13057m0(this, strArr, new C2116b(str, str2, bundle), new C2118d(i10));
    }

    /* renamed from: B */
    public final boolean m12680B(Message message, IRemoteServiceCallback iRemoteServiceCallback) {
        IRemoteClientCallback iRemoteClientCallbackM57003a;
        if (iRemoteServiceCallback == null) {
            return false;
        }
        Object obj = message.obj;
        String strM57004b = null;
        if (obj == null) {
            iRemoteClientCallbackM57003a = null;
        } else if (obj instanceof String) {
            strM57004b = (String) obj;
            iRemoteClientCallbackM57003a = null;
        } else if (obj instanceof C9041b) {
            C9041b c9041b = (C9041b) obj;
            strM57004b = c9041b.m57004b();
            iRemoteClientCallbackM57003a = c9041b.m57003a();
        } else {
            C2111d.m12646b("BackupLogicService", "sendMsg, wrong type");
            iRemoteClientCallbackM57003a = null;
        }
        if (!this.f9557b.containsKey(strM57004b)) {
            this.f9557b.put(strM57004b, 0);
        }
        m12684n(message, strM57004b);
        return m12683m(message, iRemoteServiceCallback, strM57004b, iRemoteClientCallbackM57003a);
    }

    /* renamed from: C */
    public final void m12681C() {
        BroadcastReceiver broadcastReceiver = this.f9560e;
        if (broadcastReceiver == null) {
            return;
        }
        unregisterReceiver(broadcastReceiver);
        this.f9560e = null;
    }

    /* renamed from: j */
    public final boolean m12682j(int i10, String str, String str2, String[] strArr, Bundle bundle) {
        if (!new File(str).exists()) {
            C2111d.m12648d("BackupLogicService", "Backup directory doesn't exist. iniSDcardLocation.");
        }
        return C2153l.m13055l0(this, strArr, new C2116b(str, str2, bundle), new C2118d(i10));
    }

    /* renamed from: m */
    public final boolean m12683m(Message message, IRemoteServiceCallback iRemoteServiceCallback, String str, IRemoteClientCallback iRemoteClientCallback) {
        try {
            if (!m12692v(str)) {
                iRemoteServiceCallback.callback(message.what, message.arg1, message.arg2, str, message.getData(), iRemoteClientCallback);
                return true;
            }
            int i10 = message.what;
            if (i10 == 0) {
                this.f9557b.put(str, Integer.valueOf(this.f9557b.get(str).intValue() + 1));
                m12696z(str, message, iRemoteServiceCallback, iRemoteClientCallback, CloudBackupConstant.Command.PMS_CMD_BACKUP);
                return true;
            }
            if (i10 == 1) {
                this.f9557b.put(str, Integer.valueOf(this.f9557b.get(str).intValue() + 1));
                m12696z(str, message, iRemoteServiceCallback, iRemoteClientCallback, "restore");
                return true;
            }
            if (i10 == 3) {
                Message messageObtain = Message.obtain(message);
                messageObtain.what = 1;
                m12696z(str, messageObtain, iRemoteServiceCallback, iRemoteClientCallback, "restore");
                iRemoteServiceCallback.callback(message.what, message.arg1, message.arg2, str, message.getData(), iRemoteClientCallback);
            } else {
                iRemoteServiceCallback.callback(i10, message.arg1, message.arg2, str, message.getData(), iRemoteClientCallback);
            }
            return true;
        } catch (RemoteException unused) {
            C2111d.m12648d("BackupLogicService", "Service callback unknow Err");
            return false;
        }
    }

    /* renamed from: n */
    public final void m12684n(Message message, String str) {
        if (!C2111d.m12655k() || str == null || message.what == 1068) {
            return;
        }
        if (!m12690t(message)) {
            C2111d.m12653i("BackupLogicService", m12685o(message, str));
        } else if (message.arg1 == message.arg2) {
            C2111d.m12653i("BackupLogicService", m12685o(message, str));
        }
    }

    /* renamed from: o */
    public final String m12685o(Message message, String str) {
        return "handleMessage callback,msg.what=" + message.what + ", msg.arg1=" + message.arg1 + ", msg.arg2=" + message.arg2 + ", logicName=" + str + ", msg.getData().size()=" + message.getData().size();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C2111d.m12653i("BackupLogicService", "service onBind start");
        return this.f9561f;
    }

    @Override // android.app.Service
    public void onCreate() throws IllegalAccessException, NoSuchMethodException, PackageManager.NameNotFoundException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C2111d.m12653i("BackupLogicService", "life_cycle:onCreate.");
        super.onCreate();
        Context applicationContext = getApplicationContext();
        C2109b.m12625b(applicationContext);
        C2111d.m12656l(C2109b.m12624a());
        C1386a.m7942b(applicationContext);
        C2157a.m13190Y(applicationContext);
        m12678l(0, 1);
        m12687q();
        if (C13334c.m79958B(applicationContext)) {
            C13335d.m79995b();
            m12694x();
        }
        C13334c.m79971d();
        C13334c.m79973f(applicationContext);
        C2153l.m13031Z(applicationContext);
        C13703a.m82444c().m82447e(getApplicationContext());
        C12461a.m74714a(applicationContext);
        C14129c.m84798b().m84800d(applicationContext);
        C14127a.m84766g(applicationContext);
        m12695y();
        BackupObject.setRestoreWifiComplete(false);
    }

    @Override // android.app.Service
    public void onDestroy() {
        C2111d.m12653i("BackupLogicService", "life_cycle:service onDestroy");
        super.onDestroy();
        m12681C();
        unregisterReceiver(this.f9559d);
        this.f9556a.clear();
        C13703a.m82444c().m82450h();
        C2153l.m13008D();
        C13334c.m79971d();
        Process.killProcess(Process.myPid());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 2;
    }

    /* renamed from: p */
    public final String[] m12686p(String[] strArr) {
        if (f9553g) {
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            arrayList.removeAll(f9555i);
            strArr = (String[]) arrayList.toArray();
            Object[] objArr = new Object[2];
            objArr[0] = "After filter bloom not support modules: ";
            objArr[1] = strArr != null ? Arrays.toString(strArr) : "";
            C2111d.m12654j("BackupLogicService", objArr);
        }
        return strArr;
    }

    /* renamed from: q */
    public final void m12687q() {
        C2111d.m12653i("BackupLogicService", "Init file backup service.");
        try {
            C9148m.m57485a();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            C2111d.m12648d("BackupLogicService", "Init file backup service err");
        }
    }

    /* renamed from: r */
    public final boolean m12688r(String str, Message message) {
        if (this.f9557b.get(str).intValue() < 50) {
            int i10 = message.arg1;
            int i11 = message.arg2;
            if ((i10 != i11 || i11 <= 0) && !m12689s(str, message) && !C2153l.m13035b0()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: s */
    public final boolean m12689s(String str, Message message) {
        return (C10713c.m65391a(message.getData(), "isTarMsg") || message.arg2 == 0) && BackupObject.isRecordModule(str);
    }

    /* renamed from: t */
    public final boolean m12690t(Message message) {
        int i10 = message.what;
        return i10 == 0 || i10 == 1 || i10 == 71;
    }

    /* renamed from: u */
    public final boolean m12691u(int i10) {
        int i11;
        C2111d.m12654j("BackupLogicService", "check isServiceOccupied begin, mCurrentBindingAppID:", Integer.valueOf(this.f9558c), ";clientId:", Integer.valueOf(i10));
        return (i10 == 0 || (i11 = this.f9558c) == -1 || i11 == i10 / 1000) ? false : true;
    }

    /* renamed from: v */
    public final boolean m12692v(String str) {
        return (BackupObject.isMediaModule(str) || "galleryData".equals(str) || NavigationUtils.SMS_SCHEMA_PREF.equals(str) || HNConstants.DataType.CONTACT.equals(str)) ? false : true;
    }

    /* renamed from: w */
    public final boolean m12693w(String str, String str2, String[] strArr, Bundle bundle) {
        return C2157a.m13170E(str, str2) || C2157a.m13170E(strArr) || bundle == null;
    }

    /* renamed from: x */
    public final void m12694x() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addDataScheme(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE);
        C2119e c2119e = new C2119e();
        this.f9560e = c2119e;
        if (registerReceiver(c2119e, intentFilter) == null) {
            C2111d.m12657m("BackupLogicService", "RegisterReceiver is fail");
        }
    }

    /* renamed from: y */
    public final void m12695y() {
        C2111d.m12653i("BackupLogicService", "register RESTORE_WIFICONFIG_COMPLETE_ACTION Receiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.hicloud.android.clone.RESTORE_WIFICONFIG_COMPLETE");
        registerReceiver(this.f9559d, intentFilter);
    }

    /* renamed from: z */
    public final void m12696z(String str, Message message, IRemoteServiceCallback iRemoteServiceCallback, IRemoteClientCallback iRemoteClientCallback, String str2) throws RemoteException {
        if (m12688r(str, message)) {
            if ("restore".equals(str2)) {
                Bundle data = message.getData();
                data.putInt("delta_restore_success_num", this.f9557b.get(str).intValue());
                iRemoteServiceCallback.callback(message.what, message.arg1, message.arg2, str, data, iRemoteClientCallback);
                this.f9557b.put(str, 0);
            }
            if (CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(str2)) {
                Bundle data2 = message.getData();
                data2.putInt("delta_backup_success_num", this.f9557b.get(str).intValue());
                iRemoteServiceCallback.callback(message.what, message.arg1, message.arg2, str, data2, iRemoteClientCallback);
                this.f9557b.put(str, 0);
            }
        }
    }
}
