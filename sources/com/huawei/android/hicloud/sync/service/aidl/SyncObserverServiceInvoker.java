package com.huawei.android.hicloud.sync.service.aidl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.ContactManager;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteBrowserLocalDataTask;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteCalendarLocalDataTask;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteContactLocalDataTask;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteFrameworkLocalDataTask;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteNotepadLocalDataTask;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteWlanLocalDataTask;
import com.huawei.android.hicloud.sync.syncutil.C2972a;
import com.huawei.android.hicloud.sync.syncutil.C2986o;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.p106db.operator.DriveConfigOperator;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import je.C10812z;
import md.C11440c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0240y;
import p020ap.C1006a;
import p020ap.C1008c;
import p286fd.C9684b;
import p335hd.C10147j;
import p336he.C10155f;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p573qc.C12338d;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p675uc.C13153a;
import p684un.C13226e;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;
import p783xp.C13843a;
import p836z8.C14159h;
import sd.C12778a;

/* loaded from: classes3.dex */
public class SyncObserverServiceInvoker {
    private static final SyncObserverServiceInvoker INSTANCE = new SyncObserverServiceInvoker();
    private static final String TAG = "SyncObserverServiceInvoker";
    private Handler mHandler;
    private final CloudSync mCloudSync = CloudSync.getInstance();
    private final HashMap<String, Integer> closeSyncOptionsMap = new HashMap<>();
    private Context mContext = C0213f.m1377a();

    /* renamed from: com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker$1 */
    public class HandlerC29631 extends Handler {
        public HandlerC29631(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 32336) {
                if (C10028c.m62182c0().m62388s("browser")) {
                    C11839m.m70688i(SyncObserverServiceInvoker.TAG, "browser sync");
                    SyncObserverServiceInvoker syncObserverServiceInvoker = SyncObserverServiceInvoker.this;
                    syncObserverServiceInvoker.startBrowserSync(syncObserverServiceInvoker.mContext, 3, "");
                }
                return;
            }
            if (i10 == 32997) {
                SyncObserverServiceInvoker.this.startFirst(3, "");
                return;
            }
            switch (i10) {
                case 32331:
                    C11839m.m70688i(SyncObserverServiceInvoker.TAG, "contact sync");
                    SyncObserverServiceInvoker.this.mCloudSync.doAutoSyncContact(SyncType.MAMUNAL_OPENAUTO_SYNC);
                    break;
                case 32332:
                    C11839m.m70688i(SyncObserverServiceInvoker.TAG, "wlan sync");
                    SyncObserverServiceInvoker.this.mCloudSync.doAutoSyncWlan(SyncType.WlanSyncType.MAMUNAL_OPENAUTO_SYNC);
                    break;
                case 32333:
                    if (C10028c.m62182c0().m62388s("calendar")) {
                        C11839m.m70688i(SyncObserverServiceInvoker.TAG, "calendar sync");
                        SyncObserverServiceInvoker syncObserverServiceInvoker2 = SyncObserverServiceInvoker.this;
                        syncObserverServiceInvoker2.startCalendarSync(syncObserverServiceInvoker2.mContext, 3, "");
                        break;
                    }
                    break;
                case 32334:
                    if (C10028c.m62182c0().m62388s("notepad")) {
                        C11839m.m70688i(SyncObserverServiceInvoker.TAG, "notepad sync");
                        SyncObserverServiceInvoker syncObserverServiceInvoker3 = SyncObserverServiceInvoker.this;
                        syncObserverServiceInvoker3.startNotepadSync(syncObserverServiceInvoker3.mContext, 3, "");
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker$2 */
    public class C29642 extends CommandForReportNotePadPackageName {
        public C29642(Context context, String str, boolean z10) {
            super(context, str, z10);
        }
    }

    public class CommandForReportNotePadPackageName extends AbstractC12367d {
        private Context context;
        private String notePadPackageName;
        private boolean supportProviderSync;

        public /* synthetic */ CommandForReportNotePadPackageName(SyncObserverServiceInvoker syncObserverServiceInvoker, Context context, String str, boolean z10, HandlerC29631 handlerC29631) {
            this(context, str, z10);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70686d(SyncObserverServiceInvoker.TAG, "reportNotePadPackageName." + this.notePadPackageName);
            String strM65832a = C10812z.m65832a("03001");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("supportProviderSync", String.valueOf(this.supportProviderSync));
            C10812z.m65839h(this.context, "notepad", 0, "", this.notePadPackageName, "03001", "getNotePadPackageName", strM65832a, linkedHashMap, false);
        }

        private CommandForReportNotePadPackageName(Context context, String str, boolean z10) {
            this.context = context;
            this.notePadPackageName = str;
            this.supportProviderSync = z10;
        }
    }

    public static class NotifyDriveSyncTask extends AbstractC12367d {
        private Context context;
        private String[] packageNames;
        private int scene;
        private String syncType;

        public /* synthetic */ NotifyDriveSyncTask(Context context, String str, int i10, String[] strArr, HandlerC29631 handlerC29631) {
            this(context, str, i10, strArr);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1008c.m6035v().m6051P(C0213f.m1377a(), null, false);
            for (String str : this.packageNames) {
                SyncObserverServiceInvoker.notifyDriveSync(this.context, this.syncType, this.scene, str);
            }
        }

        private NotifyDriveSyncTask(Context context, String str, int i10, String[] strArr) {
            this.context = context;
            this.syncType = str;
            this.scene = i10;
            this.packageNames = strArr;
        }
    }

    public static class NotifyFrameworkSync extends AbstractC12367d {
        private Context context;
        private String prepareTraceId;
        private int scene;
        private SyncConfigService syncConfig;
        private String syncType;

        public /* synthetic */ NotifyFrameworkSync(Context context, String str, SyncConfigService syncConfigService, int i10, String str2, HandlerC29631 handlerC29631) {
            this(context, str, syncConfigService, i10, str2);
        }

        /* JADX WARN: Removed duplicated region for block: B:99:0x0206  */
        @Override // p616rk.AbstractRunnableC12516b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 635
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker.NotifyFrameworkSync.call():void");
        }

        private NotifyFrameworkSync(Context context, String str, SyncConfigService syncConfigService, int i10, String str2) {
            this.context = context;
            this.syncType = str;
            this.syncConfig = syncConfigService;
            this.scene = i10;
            this.prepareTraceId = str2;
        }
    }

    public static class NotifySwitchChangeTask extends AbstractC12367d {
        private Context context;
        private String from;
        private boolean isSwitchOn;
        private String syncType;

        public /* synthetic */ NotifySwitchChangeTask(Context context, String str, boolean z10, String str2, HandlerC29631 handlerC29631) {
            this(context, str, z10, str2);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C2786g.m16213b();
            C1008c.m6035v().m6051P(this.context, null, false);
            boolean z10 = this.isSwitchOn;
            if (z10) {
                CloudSyncUtil.m15984W0(this.context, this.syncType, z10);
                C10155f.m63262O(this.context, this.isSwitchOn);
                C13612b.m81829B().m81870k0(this.context);
                String strM81958d = C13622a.m81958d("03003");
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.syncType);
                C12515a.m75110o().m75172d(new C10147j(this.context, arrayList, "03003", strM81958d));
                SyncObserverServiceInvoker.getInstance().startSync(this.context, this.syncType, 1, "");
            } else {
                SyncObserverServiceInvoker.getInstance().stopSync(this.context, this.syncType, 101, 2012, "local_close_switch");
            }
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("syncType", this.syncType);
            linkedHashMap.put("switchState", Boolean.valueOf(this.isSwitchOn));
            linkedHashMap.put(RemoteMessageConst.FROM, this.from);
            C13226e.m79491f1().m79567R("setSwitchState", linkedHashMap);
            UBAAnalyze.m29947H("CKC", "setSwitchState", linkedHashMap);
        }

        private NotifySwitchChangeTask(Context context, String str, boolean z10, String str2) {
            this.context = context;
            this.syncType = str;
            this.isSwitchOn = z10;
            this.from = str2;
        }
    }

    public class NotifySyncSceneChange extends AbstractC12367d {
        private static final String PROVIDER_CALL_STATE = "CALL_STATE";
        private Context context;
        private String packageName;
        private String prepareTraceId;
        private int syncScene;
        private String syncType;

        public /* synthetic */ NotifySyncSceneChange(SyncObserverServiceInvoker syncObserverServiceInvoker, Context context, String str, String str2, int i10, String str3, HandlerC29631 handlerC29631) {
            this(context, str, str2, i10, str3);
        }

        /* JADX WARN: Not initialized variable reg: 18, insn: 0x00e2: MOVE (r3 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:86:0x00e2 */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0213  */
        @Override // p616rk.AbstractRunnableC12516b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 623
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker.NotifySyncSceneChange.call():void");
        }

        private NotifySyncSceneChange(Context context, String str, String str2, int i10, String str3) {
            this.context = context;
            this.packageName = str;
            this.syncType = str2;
            this.syncScene = i10;
            this.prepareTraceId = str3;
        }
    }

    public class NotifySyncSwitchChange extends AbstractC12367d {
        private Context context;
        private String packageName;
        private int switchState;
        private String syncType;

        public /* synthetic */ NotifySyncSwitchChange(SyncObserverServiceInvoker syncObserverServiceInvoker, Context context, String str, String str2, int i10, HandlerC29631 handlerC29631) {
            this(context, str, str2, i10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0145  */
        /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v7, types: [android.content.ContentProviderClient] */
        /* JADX WARN: Type inference failed for: r2v8 */
        @Override // p616rk.AbstractRunnableC12516b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 382
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker.NotifySyncSwitchChange.call():void");
        }

        private NotifySyncSwitchChange(Context context, String str, String str2, int i10) {
            this.context = context;
            this.packageName = str;
            this.syncType = str2;
            this.switchState = i10;
        }
    }

    private SyncObserverServiceInvoker() {
    }

    private void deleteBrowserData(String str) {
        Integer num = this.closeSyncOptionsMap.get("browser");
        if (num != null) {
            C12515a.m75110o().m75172d(new DeleteBrowserLocalDataTask(this.mContext, num.intValue(), str));
        }
    }

    private void deleteCalendarData(String str) {
        C11839m.m70688i(TAG, "deleteCalendarData");
        Integer num = this.closeSyncOptionsMap.get("calendar");
        if (num != null) {
            C12515a.m75110o().m75172d(new DeleteCalendarLocalDataTask(this.mContext, num.intValue(), str));
        }
    }

    private void deleteFrameworkData(String str, String str2) {
        C11839m.m70688i(TAG, "deleteFrameworkData, syncType: " + str);
        Integer num = this.closeSyncOptionsMap.get(str);
        if (num != null) {
            C12515a.m75110o().m75172d(new DeleteFrameworkLocalDataTask(this.mContext, str, num.intValue(), str2));
        }
    }

    private void deleteNotepadData(String str) {
        C11839m.m70688i(TAG, "deleteNotepadData");
        Integer num = this.closeSyncOptionsMap.get("notepad");
        if (num != null) {
            C12515a.m75110o().m75172d(new DeleteNotepadLocalDataTask(this.mContext, num.intValue(), str));
        }
    }

    private boolean executeStopSyncTask(String str, int i10) {
        C11839m.m70688i(TAG, "executeStopSyncTask");
        return !C11440c.m68542u(str, i10);
    }

    public static SyncObserverServiceInvoker getInstance() {
        return INSTANCE;
    }

    private boolean isAllSyncSwitchClose(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "isAllSyncSwitchClose context null");
            return false;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        return (c10028cM62182c0.m62388s("addressbook") || c10028cM62182c0.m62388s("wlan") || c10028cM62182c0.m62388s("backup_key") || CloudSyncUtil.m16028m0(context) || C1006a.m5936k().m5975v(context)) ? false : true;
    }

    private boolean isShownBrowser() {
        return C10155f.m63296t(C0213f.m1377a()) && !C0209d.m1293p1();
    }

    private boolean isShownCalendar() {
        return C10155f.m63297u() && C11019b.m66371t().m66401U("funcfg_calendar");
    }

    private boolean isShownContact() {
        return C10155f.m63302z() && C11019b.m66371t().m66401U("funcfg_contacts");
    }

    private boolean isShownNotepad() {
        return C10155f.m63252E() && C11019b.m66371t().m66401U("funcfg_notes") && C0209d.m1215U1(C0213f.m1377a());
    }

    private boolean isShownSyncType(String str) {
        str.hashCode();
        switch (str) {
            case "addressbook":
                if (isShownContact()) {
                    return true;
                }
                break;
            case "calendar":
                if (isShownCalendar()) {
                    return true;
                }
                break;
            case "wlan":
                if (isShownWlan()) {
                    return true;
                }
                break;
            case "browser":
                if (isShownBrowser()) {
                    return true;
                }
                break;
            case "notepad":
                if (isShownNotepad()) {
                    return true;
                }
                break;
            default:
                List<String> shownSyncServiceId = NotifyUtil.getShownSyncServiceId(C0213f.m1377a());
                if (shownSyncServiceId != null && shownSyncServiceId.contains(str)) {
                    return true;
                }
                break;
        }
        return false;
    }

    private boolean isShownWlan() {
        return C10028c.m62183d0(C0213f.m1377a()).m62395t1("funcfg_wlan");
    }

    private boolean isSyncAutoListBackupOn(Context context, C10028c c10028c) {
        return c10028c.m62388s("addressbook") || c10028c.m62388s("wlan") || c10028c.m62388s("notepad") || c10028c.m62388s("calendar") || c10028c.m62388s("browser") || C1006a.m5936k().m5975v(context);
    }

    public static void notifyDriveSync(Context context, String str, int i10, String str2) {
        LinkedHashMap linkedHashMap;
        C11839m.m70688i(TAG, "notifyDriveSync syncType =" + str + " packageName =" + str2 + " scene =" + i10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("content://");
        sb2.append(str2);
        sb2.append(".cloudSync");
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(Uri.parse(sb2.toString()));
        String message = "";
        try {
            try {
            } catch (Exception e10) {
                message = e10.getMessage();
                C11839m.m70687e(TAG, "notifyDriveSync exception =" + e10.getMessage());
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
                linkedHashMap = new LinkedHashMap();
            }
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                C11839m.m70688i(TAG, "notifyDriveSync cpClient is null");
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("syncScene", String.valueOf(i10));
                linkedHashMap2.put("packageName", str2);
                linkedHashMap2.put("versionName", C0240y.m1681c(context, str2));
                linkedHashMap2.put("isCharging", String.valueOf(C0209d.m1196O0(context)));
                linkedHashMap2.put("networkType", C0209d.m1228Z(C0209d.m1225Y(context)));
                C10812z.m65846o(context, str, 0, "cpClient is null", "03001", "notify_sync", C10812z.m65832a("03001"), linkedHashMap2, true);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("syncType", str);
            bundle.putInt("syncScene", i10);
            contentProviderClientAcquireUnstableContentProviderClient.call("sync_scene_change", null, bundle);
            C11839m.m70688i(TAG, "notifyDriveSync call provider success.");
            contentProviderClientAcquireUnstableContentProviderClient.release();
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("syncScene", String.valueOf(i10));
            linkedHashMap.put("packageName", str2);
            linkedHashMap.put("versionName", C0240y.m1681c(context, str2));
            linkedHashMap.put("isCharging", String.valueOf(C0209d.m1196O0(context)));
            linkedHashMap.put("networkType", C0209d.m1228Z(C0209d.m1225Y(context)));
            C10812z.m65846o(context, str, 0, message, "03001", "notify_sync", C10812z.m65832a("03001"), linkedHashMap, true);
        } catch (Throwable th2) {
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put("syncScene", String.valueOf(i10));
            linkedHashMap3.put("packageName", str2);
            linkedHashMap3.put("versionName", C0240y.m1681c(context, str2));
            linkedHashMap3.put("isCharging", String.valueOf(C0209d.m1196O0(context)));
            linkedHashMap3.put("networkType", C0209d.m1228Z(C0209d.m1225Y(context)));
            C10812z.m65846o(context, str, 0, "", "03001", "notify_sync", C10812z.m65832a("03001"), linkedHashMap3, true);
            throw th2;
        }
    }

    public static void notifySwitchChange(Context context, String str, boolean z10, String str2) {
        C12515a.m75110o().m75175e(new NotifySwitchChangeTask(context, str, z10, str2), false);
    }

    private void reportNotePadPackageName(Context context, String str, boolean z10) {
        C12515a.m75110o().m75172d(new CommandForReportNotePadPackageName(context, str, z10) { // from class: com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker.2
            public C29642(Context context2, String str2, boolean z102) {
                super(context2, str2, z102);
            }
        });
    }

    public void sendStartSyncBroadCast(Context context, String str, String str2, int i10, String str3) {
        C11839m.m70688i(TAG, "Start sync with aidl, scene = " + i10 + ", syncType = " + str2);
        Intent intent = new Intent(C13843a.m83062N(str2));
        C0209d.m1302r2(intent, str);
        intent.putExtra("syncType", str2);
        intent.putExtra("syncScene", i10);
        intent.putExtra("prepareTraceId", str3);
        context.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudSync");
    }

    private synchronized void setBroadcastSyncSwitchBackupOn(String str, boolean z10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e(TAG, "setBroadcastSyncSwitchBackupOn context is null!");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(new Intent());
        safeIntent.setAction("com.huawei.android.hicloud.intent.SWITCH_CHANGED");
        safeIntent.putExtra("syncType", str);
        safeIntent.putExtra("switchState", z10);
        C13108a.m78878b(contextM1377a).m78881d(safeIntent);
    }

    public void startFirst(int i10, String str) {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62388s("addressbook")) {
            C11839m.m70686d(TAG, "contact sync");
            this.mCloudSync.doAutoSyncContact(SyncType.MAMUNAL_OPENAUTO_SYNC);
        }
        if (c10028cM62182c0.m62388s("calendar")) {
            C11839m.m70686d(TAG, "calendar sync");
            startCalendarSync(this.mContext, i10, str);
        }
    }

    private void unRegisterObserver(Context context, String str) {
        if (C11829c.m70611r0() && "autocallloglistkey".equals(str)) {
            Intent intent = new Intent(context, (Class<?>) SyncObserverService.class);
            intent.setAction("com.huawei.android.hicloud.sync.unregisterCallLogChangeObserver");
            context.startService(intent);
        }
    }

    private void unregisterSyncSwitch(Context context, String str) {
        if (context == null) {
            C11839m.m70689w(TAG, "unregisterSyncSwitch context null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        String strM65832a = C10812z.m65832a("03004");
        C11839m.m70688i(TAG, "Unregister " + str + " sync switch, traceId: " + strM65832a);
        CloudSyncUtil.m15996b1(context, arrayList, "03004", strM65832a);
        C12515a.m75110o().m75175e(new C9684b(this.mContext, arrayList, false), false);
    }

    public void closeAllSyncSwitch() {
        C11839m.m70688i(TAG, "closeAllSyncSwitch");
        C10028c.m62182c0().m62312c2(false, getInstance().getAllSyncType());
    }

    public void deleteContactData(String str) {
        C11839m.m70688i(TAG, "deleteContactData");
        Integer num = this.closeSyncOptionsMap.get("addressbook");
        if (num != null) {
            C12515a.m75110o().m75172d(new DeleteContactLocalDataTask(this.mContext, num.intValue(), str));
        }
    }

    public void deleteWlanData(String str) {
        C11839m.m70688i(TAG, "deleteWlanData");
        Integer num = this.closeSyncOptionsMap.get("wlan");
        if (num != null) {
            C12515a.m75110o().m75172d(new DeleteWlanLocalDataTask(this.mContext, num.intValue(), str));
        }
    }

    public ArrayList<String> getAllOpenSyncTypes(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (context == null) {
            C11839m.m70687e(TAG, "context is null");
            return arrayList;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        if (C1006a.m5936k().m5975v(context)) {
            arrayList.add("atlas");
        }
        if (c10028cM62183d0.m62388s("addressbook")) {
            arrayList.add("addressbook");
        }
        if (c10028cM62183d0.m62388s("notepad")) {
            arrayList.add("notepad");
        }
        if (c10028cM62183d0.m62388s("calendar")) {
            arrayList.add("calendar");
        }
        if (c10028cM62183d0.m62388s("browser")) {
            arrayList.add("browser");
        }
        if (c10028cM62183d0.m62388s("wlan")) {
            arrayList.add("wlan");
        }
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(context);
        if (shownSyncServiceItems.size() > 0) {
            Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
            while (it.hasNext()) {
                SyncConfigService next = it.next();
                if (next != null) {
                    String id2 = next.getId();
                    if (!TextUtils.isEmpty(id2) && c10028cM62183d0.m62388s(id2)) {
                        arrayList.add(id2);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<String> getAllSyncType() {
        ArrayList arrayList = new ArrayList(Arrays.asList("addressbook", "notepad", "calendar", "wlan", "browser", "atlas"));
        for (SyncConfigService syncConfigService : NotifyUtil.getShownSyncServiceItems(this.mContext)) {
            if (syncConfigService != null && !TextUtils.isEmpty(syncConfigService.getId())) {
                arrayList.add(syncConfigService.getId());
            }
        }
        return arrayList;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public List<String> getPackageNamesForSyncType(Context context, String str) {
        ArrayList arrayList;
        C11839m.m70688i(TAG, "getPackageNamesForSyncType: syncType = " + str);
        arrayList = new ArrayList();
        str.hashCode();
        switch (str) {
            case "addressbook":
                arrayList.add(C13843a.m83094p(context));
                return arrayList;
            case "calendar":
                arrayList.add("com.android.providers.calendar");
                return arrayList;
            case "browser":
                if (C13843a.m83078b0(context, "com.android.browser")) {
                    arrayList.add("com.android.browser");
                }
                String strM83092n = C13843a.m83092n(context);
                if (strM83092n != null) {
                    arrayList.add(strM83092n);
                }
                return arrayList;
            case "notepad":
                arrayList.add(C13843a.m83050B(context));
                return arrayList;
            default:
                return arrayList;
        }
    }

    public Map<String, Integer> getSyncSwitchStatus() {
        HashMap map = new HashMap();
        if (C0213f.m1377a() == null) {
            C11839m.m70687e(TAG, "context is null");
            return map;
        }
        if (isShownContact()) {
            if (C10028c.m62182c0().m62388s("addressbook")) {
                map.put("addressbook", 1);
            } else {
                map.put("addressbook", 0);
            }
        }
        if (isShownNotepad()) {
            if (C10028c.m62182c0().m62388s("notepad")) {
                map.put("notepad", 1);
            } else {
                map.put("notepad", 0);
            }
        }
        if (isShownCalendar()) {
            if (C10028c.m62182c0().m62388s("calendar")) {
                map.put("calendar", 1);
            } else {
                map.put("calendar", 0);
            }
        }
        if (isShownBrowser()) {
            if (C10028c.m62182c0().m62388s("browser")) {
                map.put("browser", 1);
            } else {
                map.put("browser", 0);
            }
        }
        if (isShownWlan()) {
            if (C10028c.m62182c0().m62388s("wlan")) {
                map.put("wlan", 1);
            } else {
                map.put("wlan", 0);
            }
        }
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(C0213f.m1377a());
        if (shownSyncServiceItems != null && shownSyncServiceItems.size() > 0) {
            for (SyncConfigService syncConfigService : shownSyncServiceItems) {
                if (syncConfigService != null) {
                    String id2 = syncConfigService.getId();
                    if (!TextUtils.isEmpty(id2)) {
                        if (C10028c.m62182c0().m62388s(id2)) {
                            map.put(id2, 1);
                        } else {
                            map.put(id2, 0);
                        }
                    }
                }
            }
        }
        return map;
    }

    public boolean hasContactLocalData() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return C13843a.m83073Y(contextM1377a) ? C13153a.m79135u(contextM1377a) : new ContactManager(contextM1377a).m17212O();
        }
        C11839m.m70687e(TAG, "queryLocalContactsNumber context is null!");
        return false;
    }

    public boolean hasSyncSwitchOn(Context context) {
        if (context == null) {
            C11839m.m70687e(TAG, "hasSyncSwitchOn context is null");
            return false;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        if (isSyncAutoListBackupOn(context, c10028cM62183d0)) {
            return true;
        }
        Iterator<SyncConfigService> it = NotifyUtil.getShownSyncServiceItems(this.mContext).iterator();
        while (it.hasNext()) {
            if (c10028cM62183d0.m62388s(it.next().getId())) {
                return true;
            }
        }
        return false;
    }

    public void initContext(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void initHandler() {
        Looper mainLooper = Looper.getMainLooper();
        if (this.mHandler == null) {
            this.mHandler = new Handler(mainLooper) { // from class: com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker.1
                public HandlerC29631(Looper mainLooper2) {
                    super(mainLooper2);
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i10 = message.what;
                    if (i10 == 32336) {
                        if (C10028c.m62182c0().m62388s("browser")) {
                            C11839m.m70688i(SyncObserverServiceInvoker.TAG, "browser sync");
                            SyncObserverServiceInvoker syncObserverServiceInvoker = SyncObserverServiceInvoker.this;
                            syncObserverServiceInvoker.startBrowserSync(syncObserverServiceInvoker.mContext, 3, "");
                        }
                        return;
                    }
                    if (i10 == 32997) {
                        SyncObserverServiceInvoker.this.startFirst(3, "");
                        return;
                    }
                    switch (i10) {
                        case 32331:
                            C11839m.m70688i(SyncObserverServiceInvoker.TAG, "contact sync");
                            SyncObserverServiceInvoker.this.mCloudSync.doAutoSyncContact(SyncType.MAMUNAL_OPENAUTO_SYNC);
                            break;
                        case 32332:
                            C11839m.m70688i(SyncObserverServiceInvoker.TAG, "wlan sync");
                            SyncObserverServiceInvoker.this.mCloudSync.doAutoSyncWlan(SyncType.WlanSyncType.MAMUNAL_OPENAUTO_SYNC);
                            break;
                        case 32333:
                            if (C10028c.m62182c0().m62388s("calendar")) {
                                C11839m.m70688i(SyncObserverServiceInvoker.TAG, "calendar sync");
                                SyncObserverServiceInvoker syncObserverServiceInvoker2 = SyncObserverServiceInvoker.this;
                                syncObserverServiceInvoker2.startCalendarSync(syncObserverServiceInvoker2.mContext, 3, "");
                                break;
                            }
                            break;
                        case 32334:
                            if (C10028c.m62182c0().m62388s("notepad")) {
                                C11839m.m70688i(SyncObserverServiceInvoker.TAG, "notepad sync");
                                SyncObserverServiceInvoker syncObserverServiceInvoker3 = SyncObserverServiceInvoker.this;
                                syncObserverServiceInvoker3.startNotepadSync(syncObserverServiceInvoker3.mContext, 3, "");
                                break;
                            }
                            break;
                    }
                }
            };
        }
    }

    public boolean isCloudSyncSwitchOpen(Context context) throws Throwable {
        if (context == null) {
            C11839m.m70687e(TAG, "context is null");
            return false;
        }
        if (C1006a.m5936k().m5975v(context) || C10028c.m62182c0().m62388s("addressbook") || C10028c.m62182c0().m62388s("notepad") || C10028c.m62182c0().m62388s("calendar") || C10028c.m62182c0().m62388s("browser") || C10028c.m62182c0().m62388s("wlan")) {
            return true;
        }
        List<SyncConfigService> allServices = new SyncConfigOperator().getAllServices();
        if (allServices != null && allServices.size() > 0) {
            for (SyncConfigService syncConfigService : allServices) {
                if (syncConfigService != null) {
                    String id2 = syncConfigService.getId();
                    if (!TextUtils.isEmpty(id2) && C10028c.m62182c0().m62388s(id2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void notifyDriveConfigSwitchChanged(Context context, String str, int i10) throws Throwable {
        if (context == null) {
            C11839m.m70687e(TAG, "notifySwitchAndExitSync, context is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "notifySwitchAndExitSync, syncType is empty");
            return;
        }
        DriveConfigService serviceById = new DriveConfigOperator().getServiceById(str);
        if (serviceById == null) {
            C11839m.m70687e(TAG, "notifySwitchAndExitSync service is null");
            return;
        }
        String[] pkgNames = serviceById.getPkgNames();
        if (pkgNames == null || pkgNames.length == 0) {
            C11839m.m70687e(TAG, "notifySwitchAndExitSync pkgNames is empty");
        } else {
            C12515a.m75110o().m75175e(new NotifyDriveSyncTask(context, str, i10, pkgNames), false);
        }
    }

    public void notifySyncSwitchChanged(Context context, String str, boolean z10) {
        if (context == null) {
            C11839m.m70689w(TAG, "notifySyncSwitchChanged error: context is null");
            return;
        }
        List<String> packageNamesForSyncType = getPackageNamesForSyncType(context, str);
        if (packageNamesForSyncType.size() != 0) {
            for (String str2 : packageNamesForSyncType) {
                C11839m.m70688i(TAG, "notifySyncSwitchChanged: syncType = " + str + ", packageName = " + str2 + ", state = " + (z10 ? 1 : 0));
                Intent intent = new Intent("com.huawei.android.hicloud.intent.SWITCH_CHANGED");
                C0209d.m1302r2(intent, str2);
                intent.putExtra("syncType", str);
                intent.putExtra("switchState", z10 ? 1 : 0);
                context.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudSync");
            }
        }
    }

    public void registerGalleryAtlasSwitch(Context context, boolean z10) {
        if (context != null) {
            if (!z10) {
                C11839m.m70688i(TAG, "registerGalleryAtlasSwitch, switch: false");
                unregisterSyncSwitch(context, "atlas");
                return;
            }
            C11839m.m70688i(TAG, "registerGalleryAtlasSwitch, switch: true");
            CloudSyncUtil.m15984W0(context, "atlas", true);
            String strM65832a = C10812z.m65832a("03003");
            C13612b.m81829B().m81870k0(context.getApplicationContext());
            ArrayList arrayList = new ArrayList();
            arrayList.add("atlas");
            CloudSyncUtil.m15996b1(context, arrayList, "03003", strM65832a);
        }
    }

    public void resetSyncSetting() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C12515a.m75110o().m75175e(new C12778a(this.mContext, countDownLatch), false);
        try {
            C11839m.m70686d(TAG, "reset setting countDownLatch await: " + countDownLatch.await(500L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            C11839m.m70687e(TAG, "reset setting countDownLatch exception");
        }
    }

    public void retainSyncData(Context context, String str) throws InterruptedException {
        if (context == null) {
            C11839m.m70688i(TAG, "retainSyncData error, context is null");
            return;
        }
        getInstance().resetSyncSetting();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("browser");
        C11839m.m70688i(TAG, "retainSyncData isBrowserSwitchOn = " + zM62388s);
        if (zM62388s) {
            C12515a.m75110o().m75172d(new DeleteBrowserLocalDataTask(context, 101, str));
        }
        boolean zM62388s2 = c10028cM62182c0.m62388s("addressbook");
        C11839m.m70688i(TAG, "retainSyncData isContactSwitchOn = " + zM62388s2);
        if (zM62388s2) {
            C12515a.m75110o().m75172d(new DeleteContactLocalDataTask(context, 101, str));
        }
        boolean zM62388s3 = c10028cM62182c0.m62388s("notepad");
        C11839m.m70688i(TAG, "retainSyncData isNotepadSwitchOn = " + zM62388s3);
        if (zM62388s3) {
            C12515a.m75110o().m75172d(new DeleteNotepadLocalDataTask(context, 101, str));
        }
        boolean zM62388s4 = c10028cM62182c0.m62388s("calendar");
        C11839m.m70688i(TAG, "retainSyncData isCalendarSwitchOn = " + zM62388s4);
        if (zM62388s4) {
            C12515a.m75110o().m75172d(new DeleteCalendarLocalDataTask(context, 101, str));
        }
        for (String str2 : NotifyUtil.getShownSyncServiceId(this.mContext)) {
            if (c10028cM62182c0.m62388s(str2)) {
                C11839m.m70688i(TAG, "retainSyncData, delete data, syncType: " + str2);
                C12515a.m75110o().m75172d(new DeleteFrameworkLocalDataTask(context, str2, 101, str));
            }
        }
    }

    public void sendEmptyMessageDelayed(int i10, long j10) {
        Handler handler = this.mHandler;
        if (handler == null) {
            C11839m.m70687e(TAG, "handler null");
        } else {
            handler.sendEmptyMessageDelayed(i10, j10);
        }
    }

    public int setSyncSwitchStatus(String str, int i10, String str2) {
        C11839m.m70688i(TAG, "setSyncSwitchStatus syncType: " + str + " switchState: " + i10);
        if (C0213f.m1377a() == null) {
            C11839m.m70687e(TAG, "setSyncSwitchStatus context is null");
            return 1;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "setSyncSwitchStatus syncType is null");
            return 1;
        }
        if (i10 != 1 && i10 != 0) {
            C11839m.m70687e(TAG, "setSyncSwitchStatus status invalid: " + i10);
            return 1;
        }
        boolean z10 = C13452e.m80781L().m80791C0() && C1006a.m5936k().m5973t();
        if (!isShownSyncType(str) && !z10 && i10 == 1) {
            C11839m.m70687e(TAG, "setSyncSwitchStatus syncType invalid: " + str + " inRetentionPeriod" + z10);
            return 1;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s(str);
        if ((i10 == 1 && zM62388s) || (i10 == 0 && !zM62388s)) {
            C11839m.m70689w(TAG, "setSyncSwitchStatus status equals switchState");
            return 0;
        }
        boolean z11 = i10 == 1;
        C10028c.m62182c0().m62336h2(str, z11);
        setBroadcastSyncSwitchBackupOn(str, z11);
        getInstance();
        notifySwitchChange(C0213f.m1377a(), str, z11, str2);
        return 0;
    }

    public void startBrowserSync(Context context, int i10, String str) {
        String strM83092n = C13843a.m83092n(context);
        if (C13843a.m83078b0(context, "com.android.browser")) {
            startThirdBrowserSync(context, i10, str);
        } else if (strM83092n != null) {
            startHuaweiSelfBrowserSync(context, i10, strM83092n, str);
        }
    }

    public void startCalendarSync(Context context, int i10, String str) {
        if (context == null) {
            C11839m.m70687e(TAG, "startCalendarSync, context is null");
            return;
        }
        if (CloudSyncUtil.m16019j0("calendar")) {
            C11839m.m70689w(TAG, "Synchronize calendar interrupt: calendar is restoring");
            return;
        }
        if (i10 == 1) {
            CloudSyncUtil.m15984W0(context, "calendar", true);
        }
        C11839m.m70688i(TAG, "Start calendar sync, scene = " + i10);
        if (C0209d.m1304s0(context, "com.android.providers.calendar") < 100) {
            sendStartSyncBroadCast(context, "com.android.providers.calendar", "calendar", i10, str);
        } else {
            C12515a.m75110o().m75175e(new NotifySyncSceneChange(context, "com.android.providers.calendar", "calendar", i10, str), false);
        }
    }

    public void startContactSync(int i10) {
        C11839m.m70688i(TAG, "Start contact sync");
        if (i10 == 133) {
            this.mCloudSync.doAutoSyncContact(SyncType.INTELLIGENCE_SYNC_MANUAL);
        } else if (i10 == 135) {
            this.mCloudSync.doAutoSyncContact(SyncType.RISK_SYNC);
        } else {
            this.mCloudSync.doAutoSyncContact(SyncType.INTELLIGENCE_SYNC_FROM_GUIDE);
        }
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70689w(TAG, "startContactSync error: mContext is null");
        } else {
            C2986o.m17944a(context, "com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
            C14159h.m84968b(this.mContext, "com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
        }
    }

    public void startContactSyncWithAIDL(Context context, int i10, String str) {
        if (context == null) {
            C11839m.m70689w(TAG, "startContactSyncWithAIDL error: context is null");
            return;
        }
        if (CloudSyncUtil.m16019j0("addressbook")) {
            C11839m.m70689w(TAG, "Synchronize contact interrupt: contact is restoring");
            return;
        }
        String strM83096r = C13843a.m83096r();
        if (i10 == 1) {
            CloudSyncUtil.m15984W0(context, "addressbook", true);
        }
        if (!CloudSyncUtil.m15977T(context, strM83096r)) {
            sendStartSyncBroadCast(context, strM83096r, "addressbook", i10, str);
        } else {
            C12515a.m75110o().m75175e(new NotifySyncSceneChange(context, strM83096r, "addressbook", i10, str), false);
        }
    }

    public void startFrameworkSync(Context context, String str, int i10, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "startFrameworkSync, parameter invalid");
            return;
        }
        SyncConfigService serviceById = new SyncConfigOperator().getServiceById(str);
        if (serviceById == null || serviceById.getApplications().length <= 0) {
            return;
        }
        startFrameworkSync(context, str, serviceById, i10, str2);
    }

    public void startGalleryAtlasSync(Context context, int i10, String str) {
        if (context == null) {
            C11839m.m70687e(TAG, "startNotepadSync, context is null");
            return;
        }
        if (i10 == 1) {
            CloudSyncUtil.m15984W0(context, "atlas", true);
        }
        C11839m.m70688i(TAG, "Start gallery atlas sync, scene = " + i10);
        Intent intent = new Intent("com.huawei.android.hicloud.intent.STARTSYNC");
        C0209d.m1302r2(intent, C13843a.m83054F(context));
        intent.putExtra("syncType", "atlas");
        intent.putExtra("syncScene", i10);
        intent.putExtra("prepareTraceId", str);
        context.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudSync");
    }

    public void startHuaweiSelfBrowserSync(Context context, int i10, String str, String str2) {
        if (context == null) {
            C11839m.m70687e(TAG, "startHuaweiSelfBrowserSync, context is null");
            return;
        }
        if (CloudSyncUtil.m16019j0("browser")) {
            C11839m.m70689w(TAG, "Synchronize self research browser interrupt: browser is restoring");
            return;
        }
        if (i10 == 1) {
            CloudSyncUtil.m15984W0(context, "browser", true);
            if (str != null) {
                C12515a.m75110o().m75175e(new NotifySyncSwitchChange(context, str, "browser", 1), false);
            }
        }
        C12515a.m75110o().m75175e(new NotifySyncSceneChange(context, str, "browser", i10, str2), false);
    }

    public void startNotepadSync(Context context, int i10, String str) {
        if (context == null) {
            C11839m.m70687e(TAG, "startNotepadSync, context is null");
            return;
        }
        if (CloudSyncUtil.m16019j0("notepad")) {
            C11839m.m70689w(TAG, "Synchronize notepad interrupt: notepad is restoring");
            return;
        }
        if (i10 == 1) {
            CloudSyncUtil.m15984W0(context, "notepad", true);
        }
        String strM83050B = C13843a.m83050B(context);
        C11839m.m70688i(TAG, "Start notepad sync, scene: " + i10 + ", package name: " + strM83050B);
        boolean zM15977T = CloudSyncUtil.m15977T(context, strM83050B);
        if (zM15977T) {
            C12515a.m75110o().m75175e(new NotifySyncSceneChange(context, strM83050B, "notepad", i10, str), false);
        } else {
            sendStartSyncBroadCast(context, strM83050B, "notepad", i10, str);
        }
        reportNotePadPackageName(context, strM83050B, zM15977T);
    }

    public void startService(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "startService context null");
            return;
        }
        if (!C11829c.m70611r0()) {
            C12338d.m74195s().m74251u();
            C12338d.m74195s().m74253v();
        } else {
            C11839m.m70688i(TAG, "Start service");
            Intent intent = new Intent(context, (Class<?>) SyncObserverService.class);
            intent.setAction("com.huawei.android.hicloud.sync.syncobserverservice");
            context.startService(intent);
        }
    }

    public void startSync(Context context, String str, int i10, String str2) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "syncType is null");
        }
        if (!C10028c.m62183d0(this.mContext).m62388s(str)) {
            C11839m.m70687e(TAG, "switch is close syncType: " + str);
            return;
        }
        str.hashCode();
        switch (str) {
            case "addressbook":
                if (!C13843a.m83073Y(context)) {
                    startContactSync(i10);
                    break;
                } else {
                    startContactSyncWithAIDL(context, i10, str2);
                    break;
                }
            case "calendar":
                startCalendarSync(context, i10, str2);
                break;
            case "wlan":
                startWlanSync(context);
                break;
            case "browser":
                startBrowserSync(context, i10, str2);
                break;
            case "notepad":
                startNotepadSync(context, i10, str2);
                break;
            default:
                startFrameworkSync(context, str, i10, str2);
                break;
        }
    }

    public void startThirdBrowserSync(Context context, int i10, String str) {
        if (context == null) {
            C11839m.m70687e(TAG, "startThirdBrowserSync, context is null");
            return;
        }
        if (CloudSyncUtil.m16019j0("browser")) {
            C11839m.m70689w(TAG, "Synchronize browser interrupt: browser is restoring");
            return;
        }
        if (i10 == 1) {
            CloudSyncUtil.m15984W0(context, "browser", true);
        }
        C11839m.m70688i(TAG, "Start browser sync, scene = " + i10);
        Intent intent = new Intent("com.huawei.android.hicloud.intent.STARTSYNC");
        C0209d.m1302r2(intent, "com.android.browser");
        intent.putExtra("syncType", "browser");
        intent.putExtra("syncScene", i10);
        intent.putExtra("prepareTraceId", str);
        context.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudSync");
    }

    public void startWlanSync(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "startWlanSync context null");
            return;
        }
        C11839m.m70688i(TAG, "Start wlan sync");
        this.mCloudSync.doAutoSyncWlan(SyncType.WlanSyncType.COMMON_SYNC);
        C2986o.m17944a(context, "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
        C14159h.m84968b(context, "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
    }

    public void stopBrowserSync(Context context, String str, int i10, int i11, String str2) {
        if (context == null) {
            C11839m.m70689w(TAG, "stopBrowserSync context null");
            return;
        }
        String strM83092n = C13843a.m83092n(this.mContext);
        if (strM83092n != null) {
            C12515a.m75110o().m75175e(new NotifySyncSwitchChange(context, strM83092n, "browser", 0), false);
        }
        C11839m.m70688i(TAG, "Stop browser sync");
        this.closeSyncOptionsMap.put(str, Integer.valueOf(i10));
        executeStopSyncTask("browser", i11);
        deleteBrowserData(str2);
        unregisterSyncSwitch(context, "browser");
    }

    public void stopCalendarSync(Context context, String str, int i10, int i11, String str2) {
        if (context == null) {
            C11839m.m70689w(TAG, "stopCalendarSync context null");
            return;
        }
        this.closeSyncOptionsMap.put(str, Integer.valueOf(i10));
        executeStopSyncTask("calendar", i11);
        deleteCalendarData(str2);
        unregisterSyncSwitch(context, "calendar");
    }

    public void stopContactSync(Context context, String str, int i10, int i11, String str2) {
        if (context == null) {
            C11839m.m70689w(TAG, "stopContactSync context null");
            return;
        }
        this.closeSyncOptionsMap.put(str, Integer.valueOf(i10));
        C11839m.m70688i(TAG, "stopContactSync begin");
        if (!executeStopSyncTask("addressbook", i11)) {
            C11839m.m70688i(TAG, "stopContactSync");
            deleteContactData(str2);
        }
        unregisterSyncSwitch(context, "addressbook");
    }

    public void stopContactSyncWithAIDL(Context context, String str, int i10, int i11, String str2) {
        if (context == null) {
            C11839m.m70689w(TAG, "stopContactSyncWithAIDL context null");
            return;
        }
        this.closeSyncOptionsMap.put(str, Integer.valueOf(i10));
        executeStopSyncTask("addressbook", i11);
        deleteContactData(str2);
        unregisterSyncSwitch(context, "addressbook");
    }

    public void stopFrameworkSync(Context context, String str, int i10, int i11, String str2) {
        if (context == null) {
            C11839m.m70689w(TAG, "stopFrameworkSync, context is null, syncType: " + str);
            return;
        }
        this.closeSyncOptionsMap.put(str, Integer.valueOf(i10));
        executeStopSyncTask(str, i11);
        deleteFrameworkData(str, str2);
        unregisterSyncSwitch(context, str);
    }

    public void stopNotepadSync(Context context, String str, int i10, int i11, String str2) {
        if (context == null) {
            C11839m.m70689w(TAG, "stopNotepadSync context null");
            return;
        }
        this.closeSyncOptionsMap.put(str, Integer.valueOf(i10));
        executeStopSyncTask("notepad", i11);
        deleteNotepadData(str2);
        unregisterSyncSwitch(context, "notepad");
    }

    public void stopService(Context context, String str) {
        if (context == null) {
            C11839m.m70689w(TAG, "stopService context null");
            return;
        }
        if ("autorecordingkey".equals(str)) {
            if (CloudSyncUtil.m15954H0(context)) {
                C12338d.m74195s().m74256w0();
                SharedPreferences.Editor editorEdit = C0214f0.m1382b(C0213f.m1377a(), "deviceNameSp", 0).edit();
                editorEdit.putLong("recordingtimestamp", 0L);
                editorEdit.commit();
            } else {
                Intent intent = new Intent(context, (Class<?>) SyncObserverService.class);
                intent.setAction("com.huawei.android.hicloud.sync.stopFileListener");
                context.startService(intent);
            }
        }
        unRegisterObserver(context, str);
        if (C11829c.m70611r0() && (!"autorecordingkey".equals(str) || !CloudSyncUtil.m15954H0(context))) {
            if (isAllSyncSwitchClose(context)) {
                C11839m.m70688i(TAG, "Stop service");
                context.stopService(new Intent(context, (Class<?>) SyncObserverService.class));
                return;
            }
            return;
        }
        if ("addressbook".equals(str)) {
            C12338d.m74195s().m74247r0();
            C2986o.m17948e("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
            return;
        }
        if ("wlan".equals(str)) {
            C12338d.m74195s().m74197A0();
            C2986o.m17948e("com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
            return;
        }
        if ("autosmslistkey".equals(str)) {
            C12338d.m74195s().m74262z0();
            C12338d.m74195s().m74258x0();
            C2972a.m17808b(NavigationUtils.SMS_SCHEMA_PREF);
        } else if ("autocallloglistkey".equals(str)) {
            C12338d.m74195s().m74239n0();
            C2972a.m17808b("callLog");
        } else if ("autophonemanagerkey".equals(str)) {
            C12338d.m74195s().m74252u0();
            C2972a.m17808b("phonemanager");
        } else if ("autorecordingkey".equals(str)) {
            C2972a.m17808b("recording");
        }
    }

    public void stopSync(Context context, String str, int i10, int i11, String str2) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "syncType is null");
        }
        str.hashCode();
        switch (str) {
            case "addressbook":
                if (!C13843a.m83073Y(context)) {
                    stopContactSync(context, str, i10, i11, str2);
                    break;
                } else {
                    stopContactSyncWithAIDL(context, str, i10, i11, str2);
                    break;
                }
            case "calendar":
                stopCalendarSync(context, str, i10, i11, str2);
                break;
            case "wlan":
                stopWlanSync(context, str, i10, i11, str2);
                break;
            case "browser":
                stopBrowserSync(context, str, i10, i11, str2);
                break;
            case "notepad":
                stopNotepadSync(context, str, i10, i11, str2);
                break;
            default:
                stopFrameworkSync(context, str, i10, i11, str2);
                break;
        }
    }

    public boolean stopSyncTask(String str, int i10) {
        C11839m.m70688i(TAG, "stopSyncTask: syncType = " + str + ", syncErrorCode = " + i10);
        return !executeStopSyncTask(str, i10);
    }

    public void stopWlanSync(Context context, String str, int i10, int i11, String str2) {
        if (context == null) {
            C11839m.m70689w(TAG, "stopWlanSync context null");
            return;
        }
        this.closeSyncOptionsMap.put(str, Integer.valueOf(i10));
        CloudSyncUtil.m16048t("wlannotAllSucess");
        if (!executeStopSyncTask("wlan", i11)) {
            C11839m.m70688i(TAG, "stopWlanSync");
            deleteWlanData(str2);
        }
        unregisterSyncSwitch(context, "wlan");
    }

    private void startFrameworkSync(Context context, String str, SyncConfigService syncConfigService, int i10, String str2) {
        if (syncConfigService == null) {
            C11839m.m70687e(TAG, "startFrameworkSync, syncConfig is null");
            return;
        }
        if (CloudSyncUtil.m16019j0(str)) {
            C11839m.m70689w(TAG, "startFrameworkSync interrupt: " + str + " is restoring");
            return;
        }
        C12515a.m75110o().m75175e(new NotifyFrameworkSync(context, str, syncConfigService, i10, str2), false);
    }

    public void startService(Context context, String str) {
        if (context == null) {
            C11839m.m70689w(TAG, "startService context null");
            return;
        }
        if (C11829c.m70611r0()) {
            C11839m.m70688i(TAG, "Start service, action = " + str);
            Intent intent = new Intent(context, (Class<?>) SyncObserverService.class);
            intent.setAction(str);
            context.startService(intent);
        }
    }

    public void startSync(Context context) {
        startSync(context, 1, "");
    }

    public void startSync(Context context, int i10, String str) {
        C11839m.m70688i(TAG, "Start Sync according to scene:" + i10);
        if (this.mContext == null && context != null) {
            this.mContext = context;
        }
        Context context2 = this.mContext;
        if (context2 == null) {
            return;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context2);
        if (c10028cM62183d0.m62388s("addressbook")) {
            C11839m.m70688i(TAG, "startSync, contact sync");
            if (C13843a.m83073Y(context)) {
                getInstance().startContactSyncWithAIDL(context, i10, str);
            } else {
                this.mCloudSync.doAutoSyncContact(SyncType.MAMUNAL_OPENAUTO_SYNC);
                if (!C11829c.m70611r0()) {
                    C12338d.m74195s().m74218V();
                    C12338d.m74195s().m74219W();
                }
            }
        }
        if (c10028cM62183d0.m62388s("wlan")) {
            C11839m.m70688i(TAG, "startSync, wlan sync");
            this.mCloudSync.doAutoSyncWlan(SyncType.WlanSyncType.MAMUNAL_OPENAUTO_SYNC);
        }
        if (c10028cM62183d0.m62388s("notepad")) {
            C11839m.m70688i(TAG, "startSync, notepad sync");
            startNotepadSync(this.mContext, i10, str);
        }
        if (c10028cM62183d0.m62388s("calendar")) {
            C11839m.m70688i(TAG, "startSync, calendar sync");
            startCalendarSync(this.mContext, i10, str);
        }
        if (c10028cM62183d0.m62388s("browser")) {
            C11839m.m70688i(TAG, "startSync, browser sync");
            startBrowserSync(this.mContext, i10, str);
        }
        for (SyncConfigService syncConfigService : NotifyUtil.getShownSyncServiceItems(this.mContext)) {
            if (syncConfigService != null) {
                String id2 = syncConfigService.getId();
                if (c10028cM62183d0.m62388s(id2)) {
                    C11839m.m70688i(TAG, "startSync, " + id2 + " sync");
                    startFrameworkSync(this.mContext, id2, i10, str);
                }
            }
        }
    }

    public void stopService(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "stopService context null");
        } else if (C11829c.m70611r0() && isAllSyncSwitchClose(context)) {
            C11839m.m70688i(TAG, "Stop service");
            context.stopService(new Intent(context, (Class<?>) SyncObserverService.class));
        }
    }
}
