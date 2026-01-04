package com.huawei.android.hicloud.common.accountreceiver;

import android.content.BroadcastReceiver;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.activity.LogoutProcessActivity;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.notification.manager.HiCLoudStockActiveManager;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.openalliance.p169ad.constant.Action;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p020ap.C1008c;
import p223db.C9062b;
import p372ip.C10583a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p709vj.C13452e;
import p711vl.C13462b;
import p742wj.C13612b;
import tm.C13042e;

/* loaded from: classes3.dex */
public class HwIdAccountRemoveReceiver extends BroadcastReceiver {

    public static class NotifyCloudSyncLogoutTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f11918a;

        public NotifyCloudSyncLogoutTask(Context context) {
            this.f11918a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (this.f11918a == null) {
                C11839m.m70687e("HwIdAccountRemoveReceiver", "notifyCloudSync context null");
                return;
            }
            try {
                List<String> listM6100t = C1008c.m6035v().m6100t(this.f11918a);
                C11839m.m70688i("HwIdAccountRemoveReceiver", "notifySyncSwitchChanged syncType:" + listM6100t);
                Iterator<String> it = listM6100t.iterator();
                while (it.hasNext()) {
                    C1008c.m6035v().m6047L(this.f11918a, it.next(), false);
                }
            } catch (Exception e10) {
                C11839m.m70687e("HwIdAccountRemoveReceiver", "notifySyncSwitchChanged exception:" + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.common.accountreceiver.HwIdAccountRemoveReceiver$a */
    public static class HandlerC2745a extends Handler {

        /* renamed from: a */
        public Context f11919a;

        /* renamed from: b */
        public boolean f11920b;

        public HandlerC2745a(Context context, boolean z10) {
            this.f11919a = context;
            this.f11920b = z10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 4) {
                return;
            }
            C11839m.m70688i("HwIdAccountRemoveReceiver", "sync del ok");
            C9062b.m57146k().m57155h(false, this.f11920b);
            C11839m.m70688i("HwIdAccountRemoveReceiver", "mark sp_stop_use_cloud_services sync_del isManual " + this.f11920b);
            if (this.f11920b) {
                C0212e0.m1365o(C0213f.m1377a(), "sp_stop_use_cloud_services", "key_stop_use_cloud_services", true);
            }
            C9062b.m57149s(true);
            Intent intent = new Intent();
            intent.setAction("quit_account");
            C13108a.m78878b(this.f11919a).m78881d(intent);
        }
    }

    /* renamed from: com.huawei.android.hicloud.common.accountreceiver.HwIdAccountRemoveReceiver$b */
    public static class C2746b extends AbstractC12367d {

        /* renamed from: a */
        public String f11921a;

        /* renamed from: b */
        public Context f11922b;

        public C2746b(Context context, String str) {
            this.f11921a = str;
            this.f11922b = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws RemoteException {
            try {
                Context context = this.f11922b;
                if (context == null) {
                    C11839m.m70687e("HwIdAccountRemoveReceiver", "notifyFileManager context null");
                    return;
                }
                if (!C0209d.m1227Y1(context, Uri.parse("content://com.huawei.filemanager.accountexit"))) {
                    C11839m.m70687e("HwIdAccountRemoveReceiver", "is not Target App or System App");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(JsbMapKeyNames.H5_USER_ID, this.f11921a);
                bundle.putString("account_logout", Action.ACTION_HW_ACCOUNT_LOGOUT);
                ContentResolver contentResolver = this.f11922b.getContentResolver();
                if (contentResolver == null) {
                    C11839m.m70688i("HwIdAccountRemoveReceiver", "notify logout contentResolver is null.");
                    return;
                }
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(Uri.parse("content://com.huawei.filemanager.accountexit"));
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    C11839m.m70688i("HwIdAccountRemoveReceiver", "notify logout client is null.");
                    return;
                }
                Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("account_exit", null, bundle);
                if (bundleCall != null) {
                    C11839m.m70688i("HwIdAccountRemoveReceiver", "notifyFileManager: " + bundleCall.getBoolean("account_exit"));
                }
            } catch (Exception e10) {
                C11839m.m70687e("HwIdAccountRemoveReceiver", "notifyFileManager task exception:" + e10.toString());
            }
        }
    }

    /* renamed from: a */
    public final void m15566a(Context context) {
        C12515a.m75110o().m75175e(new NotifyCloudSyncLogoutTask(context), false);
    }

    /* renamed from: b */
    public final void m15567b(Context context, String str) {
        C12515a.m75110o().m75175e(new C2746b(context, str), false);
    }

    /* renamed from: c */
    public final void m15568c(Context context) {
        ArrayList<DriveConfigService> shownDriveServiceItems = NotifyUtil.getShownDriveServiceItems(context);
        if (shownDriveServiceItems.isEmpty()) {
            C11839m.m70688i("HwIdAccountRemoveReceiver", "processDriveLogoutNotification driveConfigService is empty");
            return;
        }
        for (DriveConfigService driveConfigService : shownDriveServiceItems) {
            if (driveConfigService != null) {
                C1008c.m6035v().m6046K(context, driveConfigService.getId(), 2);
            }
        }
    }

    /* renamed from: d */
    public final void m15569d(Context context, String str, boolean z10, String str2) {
        if (C13612b.m81829B().m81855T() || context == null) {
            return;
        }
        HiCLoudStockActiveManager.getInstance().setProcessExit(true);
        m15567b(context, str);
        m15568c(context);
        m15566a(context);
        C13452e.m80781L().m80885a();
        C10028c.m62182c0().m62343j();
        C10028c.m62182c0().m62377p3("is_exit_finish", false);
        m15571f(context);
        if (C9062b.m57146k().m57158l()) {
            C11839m.m70688i("HwIdAccountRemoveReceiver", "onActivityResult HWID is logout");
            if (!C13612b.m81829B().m81855T()) {
                C1008c.m6035v().m6092p(context, new HandlerC2745a(context, z10), C9062b.m57146k().m57157j(), str2);
                C13612b.m81829B().m81881q0(true);
                C11839m.m70688i("HwIdAccountRemoveReceiver", "is process exit = true");
            }
            Intent intent = new Intent();
            intent.setClass(context, LogoutProcessActivity.class);
            try {
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                context.startActivity(intent);
            } catch (Exception e10) {
                C11839m.m70687e("HwIdAccountRemoveReceiver", "LogoutProcessActivity fail" + e10.toString());
                C9062b.m57149s(false);
            }
        } else {
            C11839m.m70688i("HwIdAccountRemoveReceiver", "no delete data");
            C1008c.m6035v().m6058W(context, str2);
            C9062b.m57146k().m57155h(false, z10);
            C11839m.m70688i("HwIdAccountRemoveReceiver", "mark sp_stop_use_cloud_services isManual " + z10);
            if (z10) {
                C0212e0.m1365o(C0213f.m1377a(), "sp_stop_use_cloud_services", "key_stop_use_cloud_services", true);
            }
        }
        m15570e();
    }

    /* renamed from: e */
    public final void m15570e() {
        C13462b.m81015c().m81016a();
    }

    /* renamed from: f */
    public final void m15571f(Context context) {
        Iterator<String> it = NotifyUtil.getShownSyncServiceId(context).iterator();
        while (it.hasNext()) {
            C12515a.m75110o().m75172d(new C10583a(context, it.next(), -1));
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C11839m.m70686d("HwIdAccountRemoveReceiver", "onReceive");
        if (intent == null) {
            C11839m.m70686d("HwIdAccountRemoveReceiver", "intent is empty");
            return;
        }
        try {
            C11839m.m70688i("HwIdAccountRemoveReceiver", "removeType=" + intent.getStringExtra("removedAccountByHand"));
            boolean zM80854S0 = C13452e.m80781L().m80854S0();
            C11839m.m70688i("HwIdAccountRemoveReceiver", "isManual=" + zM80854S0);
            if (zM80854S0) {
                C13452e.m80781L().m80953o2(false);
            }
            boolean z10 = C13612b.m81829B().m81843F(context) == 1;
            C11839m.m70688i("HwIdAccountRemoveReceiver", "isLogin=" + z10);
            if (!z10 || zM80854S0) {
                String stringExtra = intent.getStringExtra(JsbMapKeyNames.H5_USER_ID);
                boolean zIsEmpty = TextUtils.isEmpty(stringExtra);
                C11839m.m70686d("HwIdAccountRemoveReceiver", "userIdIsNull=" + zIsEmpty);
                if (zIsEmpty) {
                    return;
                }
                C13042e.m78686e(stringExtra);
                m15569d(context, stringExtra, zM80854S0, "local_logout_account");
            }
        } catch (Exception unused) {
            C11839m.m70687e("HwIdAccountRemoveReceiver", "intent Serializable error.");
        }
    }
}
