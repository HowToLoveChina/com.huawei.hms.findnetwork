package p742wj;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hicloud.account.p102ui.activity.AccountInConsistentActivity;
import com.huawei.hicloud.account.p102ui.activity.StInvalidNotificationActivity;
import com.huawei.hicloud.account.p102ui.activity.ValidateHwIdActivity;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p399jk.AbstractC10896a;
import p429kk.C11058a;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p619rn.C12611a;
import p664u0.C13108a;
import p681uj.C13195l;
import p681uj.C13198o;
import p681uj.InterfaceC13189f;
import p683um.C13220a;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;
import p709vj.InterfaceC13454g;
import p709vj.InterfaceC13455h;
import p709vj.InterfaceC13456i;
import p777xj.C13818b;
import p777xj.C13819c;
import p846zj.C14303a;
import p846zj.C14306d;
import p846zj.InterfaceC14307e;
import tj.C13019a;
import tn.C13044b;
import tn.C13048f;
import tn.InterfaceC13043a;

/* renamed from: wj.b */
/* loaded from: classes5.dex */
public final class C13612b implements InterfaceC13449b, InterfaceC13455h {

    /* renamed from: k */
    public static final C13612b f61237k = new C13612b();

    /* renamed from: l */
    public static InterfaceC13449b f61238l = new e();

    /* renamed from: f */
    public Intent f61244f;

    /* renamed from: g */
    public Intent f61245g;

    /* renamed from: h */
    public Intent f61246h;

    /* renamed from: i */
    public InterfaceC14307e f61247i;

    /* renamed from: a */
    public volatile int f61239a = 0;

    /* renamed from: b */
    public boolean f61240b = false;

    /* renamed from: c */
    public boolean f61241c = false;

    /* renamed from: d */
    public boolean f61242d = false;

    /* renamed from: e */
    public final Object f61243e = new Object();

    /* renamed from: j */
    public BroadcastReceiver f61248j = new a();

    /* renamed from: wj.b$a */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                AbstractC10896a.m65886e("HisyncAccountManager", "intent or context is empty");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if ("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED".equals(safeIntent.getAction())) {
                if (C13452e.m80781L().m80927i1()) {
                    AbstractC10896a.m65887i("HisyncAccountManager", "Receive auth fail broadcast, but sync risk effective");
                    C13612b.this.m81866g0(context.getApplicationContext());
                    return;
                }
                boolean booleanExtra = safeIntent.getBooleanExtra("is_sure_st_invalid", false);
                AbstractC10896a.m65887i("HisyncAccountManager", "Receive auth fail broadcast, isSureStInvalid: " + booleanExtra);
                C13612b.this.m81865f0(context.getApplicationContext(), true, booleanExtra);
                return;
            }
            if ("com.huawei.hicloud.intent.action.RE_LOGIN".equals(safeIntent.getAction())) {
                AbstractC10896a.m65887i("HisyncAccountManager", "Receive re-login broadcast");
                if (!C13612b.this.isLogin()) {
                    C14306d.m85221v("com.huawei.hicloud.intent.action.RE_LOGIN_TO_GALLERY");
                    return;
                }
                if (C13452e.m80781L().m80927i1()) {
                    AbstractC10896a.m65887i("HisyncAccountManager", "sync risk effective, go to SyncRiskManagementActivity");
                    C14306d.m85221v("com.huawei.hicloud.intent.action.RE_LOGIN_TO_SYNC");
                    return;
                } else {
                    Intent intent2 = new Intent(context, (Class<?>) ValidateHwIdActivity.class);
                    intent2.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                    context.startActivity(intent2);
                    return;
                }
            }
            if ("com.huawei.hicloud.intent.action.PRIVATE_SPACE".equals(safeIntent.getAction())) {
                AbstractC10896a.m65887i("HisyncAccountManager", "receive PrivateSpace exit broadcast, isPrivacyUser, now exit Cloud!");
                C14306d.m85221v("com.huawei.hicloud.action.PRIVACY_SPACE_TO_EXIT");
                return;
            }
            if ("com.huawei.hicloud.intent.action.SYNC_RISK".equals(safeIntent.getAction())) {
                AbstractC10896a.m65887i("HisyncAccountManager", "Receive sync risk broadcast");
                C13612b.this.m81866g0(context.getApplicationContext());
            } else if ("com.huawei.hicloud.intent.action.MIGRATION_NOTICE".equals(safeIntent.getAction())) {
                C14306d.m85221v("com.huawei.hicloud.actoin.ACTION_SHOW_MIGRATION");
            } else if ("com.huawei.hicloud.intent.action.ACCOUNT_INCONSISTENT_NOTICE".equals(safeIntent.getAction())) {
                if (C0209d.m1241c1()) {
                    C13612b.this.m81889u0(context);
                } else {
                    C14306d.m85221v("com.huawei.hicloud.actoin.ACTION_ACCOUNT_INCONSISTENT_CLEAR_DATA");
                }
            }
        }
    }

    /* renamed from: wj.b$b */
    public class b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f61250a;

        /* renamed from: b */
        public final /* synthetic */ boolean f61251b;

        public b(Context context, boolean z10) {
            this.f61250a = context;
            this.f61251b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13612b.this.m81862c0(this.f61250a, this.f61251b);
        }
    }

    /* renamed from: wj.b$c */
    public class c implements InterfaceC13449b {
        public c() {
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: L */
        public void mo13808L(Exception exc) {
            AbstractC10896a.m65886e("HisyncAccountManager", "syncRefreshUserAccentName, authFailed");
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: Q */
        public boolean mo13814Q(Bundle bundle) {
            return false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: W */
        public void mo13820W(Bundle bundle) {
            if (bundle == null) {
                AbstractC10896a.m65886e("HisyncAccountManager", "aidlLoginForAccountInfo, getAccountInfo return null");
                return;
            }
            String string = bundle.getString("accountName");
            AbstractC10896a.m65887i("HisyncAccountManager", "aidlLoginForAccountInfo,refresh account Info!");
            if (string == null) {
                AbstractC10896a.m65886e("HisyncAccountManager", "accountinfo is null");
            } else {
                C13452e.m80781L().m80784A1(string);
            }
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: e */
        public void mo13829e(OperationCanceledException operationCanceledException) {
            AbstractC10896a.m65887i("HisyncAccountManager", "syncRefreshUserAccentName, authCanceled");
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: m0 */
        public void mo13838m0(Bundle bundle) {
            AbstractC10896a.m65887i("HisyncAccountManager", "syncRefreshUserAccentName, getUserInfoSuccess");
        }
    }

    /* renamed from: wj.b$d */
    public class d implements InterfaceC13449b {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f61254a;

        public d(CountDownLatch countDownLatch) {
            this.f61254a = countDownLatch;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: L */
        public void mo13808L(Exception exc) {
            if (exc == null) {
                AbstractC10896a.m65886e("HisyncAccountManager", "getAuthAccountCallback, authFailed");
            } else {
                AbstractC10896a.m65886e("HisyncAccountManager", "getAuthAccountCallback, authFailed: " + exc.toString());
            }
            if (exc instanceof ApiException) {
                if (((ApiException) exc).getStatusCode() == 2001) {
                    C13612b.this.f61239a = 2;
                } else {
                    C13612b.this.f61239a = 1;
                }
            }
            this.f61254a.countDown();
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: Q */
        public boolean mo13814Q(Bundle bundle) {
            return false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: W */
        public void mo13820W(Bundle bundle) {
            if (bundle == null) {
                AbstractC10896a.m65886e("HisyncAccountManager", "getAccountStStatus, getAuthAccountCallback authTokenSuccess return null");
                C13612b.this.f61239a = 1;
                this.f61254a.countDown();
                return;
            }
            String string = bundle.getString(JsbMapKeyNames.H5_USER_ID);
            if (!TextUtils.isEmpty(string) && !string.equals(C13452e.m80781L().m80971t0())) {
                AbstractC10896a.m65887i("HisyncAccountManager", "New userId is not equals to old userId");
                C13612b.this.f61239a = 1;
                this.f61254a.countDown();
                return;
            }
            AbstractC10896a.m65887i("HisyncAccountManager", "Obtain new ST, refresh accountInfo and set ST valid");
            C13612b.this.m81893w0();
            C13452e.m80781L().m80968s1(bundle);
            boolean zM80917g1 = C13452e.m80781L().m80917g1();
            C13452e.m80781L().m80919g3(false);
            C13612b.m81829B().m81863d0(bundle, null, C0213f.m1377a(), zM80917g1);
            C13612b.this.f61239a = 0;
            this.f61254a.countDown();
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: e */
        public void mo13829e(OperationCanceledException operationCanceledException) {
            C13612b.this.f61239a = 1;
            AbstractC10896a.m65888w("HisyncAccountManager", "getAccountStStatus, onLogout");
            this.f61254a.countDown();
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: m0 */
        public void mo13838m0(Bundle bundle) {
            C13612b.this.f61239a = 0;
            AbstractC10896a.m65888w("HisyncAccountManager", "getAuthAccountCallback getUserInfoSuccess");
            this.f61254a.countDown();
        }
    }

    /* renamed from: wj.b$e */
    public class e implements InterfaceC13449b {
        @Override // p709vj.InterfaceC13449b
        /* renamed from: L */
        public void mo13808L(Exception exc) {
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: Q */
        public boolean mo13814Q(Bundle bundle) {
            return false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: W */
        public void mo13820W(Bundle bundle) {
            if (bundle == null) {
                AbstractC10896a.m65886e("HisyncAccountManager", "mSilentLoginCallback, getAccountInfo return null");
                return;
            }
            String string = bundle.getString(JsbMapKeyNames.H5_USER_ID);
            if (!TextUtils.isEmpty(string) && !string.equals(C13452e.m80781L().m80971t0())) {
                AbstractC10896a.m65887i("HisyncAccountManager", "New userId is not equals to old userId");
                return;
            }
            C13452e.m80781L().m80968s1(bundle);
            C14306d.m85221v("com.huawei.hicloud.action.ON_LOGIN");
            boolean zM80917g1 = C13452e.m80781L().m80917g1();
            C13452e.m80781L().m80919g3(false);
            C13612b.m81829B().m81863d0(bundle, null, C0213f.m1377a(), zM80917g1);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: e */
        public void mo13829e(OperationCanceledException operationCanceledException) {
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: m0 */
        public void mo13838m0(Bundle bundle) {
        }
    }

    /* renamed from: wj.b$f */
    public class f extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f61256a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC13456i f61257b;

        public f(Context context, InterfaceC13456i interfaceC13456i) {
            this.f61256a = context;
            this.f61257b = interfaceC13456i;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ContentResolver contentResolver = this.f61256a.getContentResolver();
            Uri uri = Uri.parse("content://com.huawei.hwid.api.provider/has_login");
            boolean z10 = false;
            if (!C0209d.m1227Y1(this.f61256a, uri)) {
                AbstractC10896a.m65886e("HisyncAccountManager", "is not Target App or System App");
            } else if (C13612b.this.m81842E(uri, contentResolver) == 1) {
                z10 = true;
            }
            InterfaceC13456i interfaceC13456i = this.f61257b;
            if (interfaceC13456i != null) {
                interfaceC13456i.loginResult(z10);
            }
        }
    }

    /* renamed from: wj.b$g */
    public class g extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f61259a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC13454g f61260b;

        public g(Context context, InterfaceC13454g interfaceC13454g) {
            this.f61259a = context;
            this.f61260b = interfaceC13454g;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            int iM81841D = C13612b.this.m81841D(this.f61259a);
            InterfaceC13454g interfaceC13454g = this.f61260b;
            if (interfaceC13454g != null) {
                interfaceC13454g.mo63303a(iM81841D);
            }
        }
    }

    /* renamed from: wj.b$h */
    public static class h extends AbstractC12367d {

        /* renamed from: a */
        public Context f61262a;

        /* renamed from: b */
        public InterfaceC14307e f61263b;

        /* renamed from: wj.b$h$a */
        public class a implements InterfaceC13449b {
            public a() {
            }

            @Override // p709vj.InterfaceC13449b
            /* renamed from: L */
            public void mo13808L(Exception exc) {
                AbstractC10896a.m65886e("HisyncAccountManager", "sign in background, authFailed");
                C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07074"), "07074", C13452e.m80781L().m80971t0());
                InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(VastAttribute.ERROR, exc.toString());
                if (interfaceC13043aM80810H != null) {
                    interfaceC13043aM80810H.mo78693d(h.this.f61262a, c11060cM66626a, linkedHashMap);
                }
            }

            @Override // p709vj.InterfaceC13449b
            /* renamed from: Q */
            public boolean mo13814Q(Bundle bundle) {
                return false;
            }

            @Override // p709vj.InterfaceC13449b
            /* renamed from: W */
            public void mo13820W(Bundle bundle) {
                if (bundle == null) {
                    AbstractC10896a.m65886e("HisyncAccountManager", "aidlLoginForAccountInfo, getAccountInfo return null");
                    return;
                }
                String string = bundle.getString(JsbMapKeyNames.H5_USER_ID);
                AbstractC10896a.m65887i("HisyncAccountManager", "aidlLoginForAccountInfo,refresh account Info!");
                if (string == null) {
                    AbstractC10896a.m65886e("HisyncAccountManager", "accountinfo is null");
                } else {
                    h.this.m81902e(string);
                    C13452e.m80781L().m80968s1(bundle);
                }
            }

            @Override // p709vj.InterfaceC13449b
            /* renamed from: e */
            public void mo13829e(OperationCanceledException operationCanceledException) {
                AbstractC10896a.m65886e("HisyncAccountManager", "sign in background, authCanceled");
            }

            @Override // p709vj.InterfaceC13449b
            /* renamed from: m0 */
            public void mo13838m0(Bundle bundle) {
                AbstractC10896a.m65886e("HisyncAccountManager", "sign in background, getUserInfoSuccess");
            }
        }

        public h(Context context, InterfaceC14307e interfaceC14307e) {
            this.f61262a = context;
            this.f61263b = interfaceC14307e;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (this.f61262a == null) {
                AbstractC10896a.m65887i("HisyncAccountManager", "BackgroundLoginTask context null");
                return;
            }
            InterfaceC14307e interfaceC14307e = this.f61263b;
            if (interfaceC14307e == null) {
                AbstractC10896a.m65887i("HisyncAccountManager", "accountExternal is null");
                return;
            }
            boolean zMo61360c = interfaceC14307e.mo61360c();
            int iM81843F = C13612b.m81829B().m81843F(this.f61262a);
            boolean zMo61361d = this.f61263b.mo61361d();
            AbstractC10896a.m65887i("HisyncAccountManager", "aidlLoginForAccountInfo isHwidLogin=" + iM81843F + ",isAgreedHiCloudTerms=" + zMo61360c + ",isMainSwitchOpen=" + zMo61361d);
            if (iM81843F == 1 && zMo61360c && zMo61361d) {
                AbstractC10896a.m65887i("HisyncAccountManager", "AIDL Login for accountinfo");
                C13195l.m79272J().m79337u0(new a(), false);
            }
        }

        /* renamed from: e */
        public final void m81902e(String str) {
            int i10 = TextUtils.isEmpty(str) ? 4 : 0;
            if (str.equals(C13452e.m80781L().m80971t0())) {
                i10 |= 8;
            }
            C0209d.m1294p2(C0213f.m1377a(), "st_uid_status", i10);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.QUERY_KEY;
        }
    }

    /* renamed from: wj.b$i */
    public static class i implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            C13198o.m79385c().m79387d(C0213f.m1377a(), new j());
        }
    }

    /* renamed from: wj.b$j */
    public static class j implements InterfaceC13189f {
        @Override // p681uj.InterfaceC13189f
        /* renamed from: a */
        public void mo14508a() {
        }

        @Override // p681uj.InterfaceC13189f
        public void onSuccess(String str) {
            C14306d.m85224y(str);
        }
    }

    /* renamed from: wj.b$k */
    public static class k extends AbstractC12367d {

        /* renamed from: a */
        public Context f61265a;

        /* renamed from: b */
        public boolean f61266b;

        public k(Context context, boolean z10) {
            this.f61265a = context;
            this.f61266b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            AbstractC10896a.m65887i("HisyncAccountManager", "NotifyLoginTask call");
            ContentProviderClient contentProviderClient = null;
            try {
                try {
                    if (this.f61265a == null) {
                        AbstractC10896a.m65886e("HisyncAccountManager", "notifyFileManager context null");
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isOldStInvalid", this.f61266b);
                    bundle.putBoolean("isOverlayInstall", C0209d.m1162D1());
                    if (!C0209d.m1227Y1(this.f61265a, Uri.parse("content://com.huawei.filemanager.accountexit"))) {
                        AbstractC10896a.m65886e("HisyncAccountManager", "is not Target App or System App");
                        return;
                    }
                    ContentResolver contentResolver = this.f61265a.getContentResolver();
                    if (contentResolver == null) {
                        AbstractC10896a.m65887i("HisyncAccountManager", "notify login contentResolver is null.");
                        return;
                    }
                    ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(Uri.parse("content://com.huawei.filemanager.accountexit"));
                    try {
                        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                            AbstractC10896a.m65887i("HisyncAccountManager", "notify login client is null.");
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                                return;
                            }
                            return;
                        }
                        Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("post_login", null, bundle);
                        if (bundleCall != null) {
                            AbstractC10896a.m65887i("HisyncAccountManager", "notifyFileManagerLogin: " + bundleCall.getBoolean("post_login"));
                        }
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    } catch (Exception e10) {
                        contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                        e = e10;
                        AbstractC10896a.m65886e("HisyncAccountManager", "notifyFileManagerLogin task exception:" + e.toString());
                        if (contentProviderClient != null) {
                            contentProviderClient.close();
                        }
                    } catch (Throwable th2) {
                        contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                        th = th2;
                        if (contentProviderClient != null) {
                            contentProviderClient.close();
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.NOTIFY_FILEMANAGER;
        }
    }

    /* renamed from: B */
    public static C13612b m81829B() {
        return f61237k;
    }

    /* renamed from: Y */
    public static void m81830Y(Context context) {
        if (context != null && m81829B().isLogin()) {
            C14306d.m85221v("com.huawei.hicloud.actoin.NOTIFY_ACCOUNT_INFO");
        }
    }

    /* renamed from: A */
    public final ComponentName m81838A(Context context) throws SecurityException {
        if (context == null) {
            AbstractC10896a.m65886e("HisyncAccountManager", "isAllowToShowAuthFailDialog: false, context is null");
            return null;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            AbstractC10896a.m65886e("HisyncAccountManager", "isAllowToShowAuthFailDialog: false, ActivityManager is null");
            return null;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
        if (runningTasks == null || runningTasks.isEmpty()) {
            return null;
        }
        return runningTasks.get(0).topActivity;
    }

    /* renamed from: A0 */
    public final void m81839A0() {
        C13452e.m80781L().m80919g3(true);
    }

    /* renamed from: C */
    public Bundle m81840C() {
        Bundle bundle = new Bundle();
        bundle.putString(HwPayConstant.KEY_SITE_ID, String.valueOf(C13452e.m80781L().m80947n0()));
        bundle.putString("deviceID", C13452e.m80781L().m80950o());
        bundle.putString(JsbMapKeyNames.H5_DEVICE_TYPE, C13452e.m80781L().m80966s());
        bundle.putString("serviceToken", C13452e.m80781L().m80931j0());
        bundle.putString("accountName", C13452e.m80781L().m80900d());
        bundle.putString(HwPayConstant.KEY_USER_ID, C13452e.m80781L().m80971t0());
        return bundle;
    }

    /* renamed from: D */
    public int m81841D(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse("content://com.huawei.hwid.api.provider/has_login");
        if (C0209d.m1227Y1(context, uri)) {
            return m81842E(uri, contentResolver);
        }
        AbstractC10896a.m65886e("HisyncAccountManager", "getLoginResult, is not Target App or System App");
        return 0;
    }

    /* renamed from: E */
    public final int m81842E(Uri uri, ContentResolver contentResolver) {
        int i10 = -1;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uri, null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    i10 = cursorQuery.getInt(cursorQuery.getColumnIndex("hasLogin"));
                }
            } catch (Exception unused) {
                AbstractC10896a.m65886e("HisyncAccountManager", "getLoginResult error");
                if (cursorQuery != null) {
                }
            }
            AbstractC10896a.m65887i("HisyncAccountManager", "query provider, login result: " + i10);
            return i10;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: F */
    public int m81843F(Context context) {
        if (context != null) {
            try {
                AccountManager accountManager = AccountManager.get(context);
                if (accountManager == null) {
                    AbstractC10896a.m65888w("HisyncAccountManager", "getLoginStatus systemAccountManager is null");
                    return -1;
                }
                Account[] accountsByType = accountManager.getAccountsByType("com.huawei.hwid");
                if (accountsByType != null && accountsByType.length != 0) {
                    AbstractC10896a.m65887i("HisyncAccountManager", "hwid login");
                    return 1;
                }
                AbstractC10896a.m65887i("HisyncAccountManager", "hwid not login");
                return 0;
            } catch (Exception e10) {
                AbstractC10896a.m65886e("HisyncAccountManager", "get accounts exception, e:" + e10.toString());
            }
        }
        return -1;
    }

    /* renamed from: G */
    public void m81844G(Context context, long j10) {
        if (context == null) {
            return;
        }
        if ((System.currentTimeMillis() - C12611a.m76098a(context).m76099b()) / 86400000 >= 7) {
            AbstractC10896a.m65887i("HisyncAccountManager", "need get token,delayRandomTime:" + j10);
            new Handler(Looper.getMainLooper()).postDelayed(new i(), j10);
        }
    }

    /* renamed from: H */
    public String m81845H(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            return C11477c.m68633c(sharedPreferencesM1382b.getString("HiSyncAccountpushToken", null));
        }
        AbstractC10896a.m65887i("HisyncAccountManager", "getPushTokenForReport sp is null!");
        return null;
    }

    /* renamed from: I */
    public Intent m81846I() {
        return this.f61246h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: J */
    public void m81847J(InterfaceC13449b interfaceC13449b) {
        if (interfaceC13449b != 0) {
            this = interfaceC13449b;
        }
        C13195l.m79272J().m79343x0(this);
    }

    /* renamed from: K */
    public void m81848K(Handler handler) {
        AbstractC10896a.m65887i("HisyncAccountManager", "getUserInfoForPay");
        C13195l.m79272J().m79343x0(new C13611a(handler));
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        AbstractC10896a.m65887i("HisyncAccountManager", "Enter authFailed");
        m81829B().m81861b0();
    }

    /* renamed from: M */
    public void m81849M(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED");
        intentFilter.addAction("com.huawei.hicloud.intent.action.RE_LOGIN");
        intentFilter.addAction("com.huawei.hicloud.intent.action.PRIVATE_SPACE");
        intentFilter.addAction("com.huawei.hicloud.intent.action.SYNC_RISK");
        intentFilter.addAction("com.huawei.hicloud.intent.action.MIGRATION_NOTICE");
        intentFilter.addAction("com.huawei.hicloud.intent.action.ACCOUNT_INCONSISTENT_NOTICE");
        C13108a.m78878b(context).m78880c(this.f61248j, intentFilter);
    }

    /* renamed from: N */
    public final boolean m81850N(Context context) {
        return m81851O(context, false);
    }

    /* renamed from: O */
    public boolean m81851O(Context context, boolean z10) throws SecurityException {
        ComponentName componentNameM81838A = m81838A(context);
        if (componentNameM81838A == null) {
            AbstractC10896a.m65886e("HisyncAccountManager", "isAllowToShowAuthFailDialog: cn is null return false");
            return false;
        }
        String className = componentNameM81838A.getClassName();
        String packageName = componentNameM81838A.getPackageName();
        if (z10) {
            if ("com.huawei.hidisk".equals(packageName) && !className.startsWith("com.huawei.hidisk") && !className.endsWith("SyncRiskManagementActivity") && !className.endsWith("SyncRiskNotificationActivity") && !className.endsWith("PhoneFinderActivity") && !className.endsWith("PhoneFinderGuideActivity")) {
                AbstractC10896a.m65887i("HisyncAccountManager", "isAllowToShowAuthFailDialog: true, current class: " + className);
                return true;
            }
        } else if ("com.huawei.hidisk".equals(packageName) && !className.startsWith("com.huawei.hidisk") && !className.endsWith("StInvalidNotificationActivity")) {
            AbstractC10896a.m65887i("HisyncAccountManager", "isAllowToShowAuthFailDialog: true, current class: " + className);
            return true;
        }
        AbstractC10896a.m65887i("HisyncAccountManager", "isAllowToShowAuthFailDialog: false, current class: " + className);
        return false;
    }

    /* renamed from: P */
    public int m81852P() {
        synchronized (this.f61243e) {
            try {
                if (TextUtils.isEmpty(C13452e.m80781L().m80896c0())) {
                    return 0;
                }
                return TextUtils.isEmpty(C13452e.m80781L().m80971t0()) ? 2 : 1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: Q */
    public boolean mo13814Q(Bundle bundle) {
        return false;
    }

    /* renamed from: R */
    public boolean m81853R() {
        boolean zM80850R0;
        synchronized (this.f61243e) {
            zM80850R0 = C13452e.m80781L().m80850R0();
        }
        return zM80850R0;
    }

    /* renamed from: S */
    public boolean m81854S() {
        InterfaceC14307e interfaceC14307e = this.f61247i;
        if (interfaceC14307e != null) {
            return interfaceC14307e.mo61361d();
        }
        AbstractC10896a.m65887i("HisyncAccountManager", "isMainSwitchOpen, mAccountExternal is null");
        return false;
    }

    /* renamed from: T */
    public boolean m81855T() {
        AbstractC10896a.m65887i("HisyncAccountManager", "isProcessExit: " + this.f61242d);
        return this.f61242d;
    }

    /* renamed from: U */
    public void m81856U(Activity activity, InterfaceC13449b interfaceC13449b) {
        AbstractC10896a.m65887i("HisyncAccountManager", "login");
        C13195l.m79272J().m79310a0(activity, interfaceC13449b);
    }

    /* renamed from: V */
    public final void m81857V(Activity activity, InterfaceC13449b interfaceC13449b) {
        AbstractC10896a.m65887i("HisyncAccountManager", "loginToReAuth");
        C13195l.m79272J().m79311b0(activity, interfaceC13449b, 8801);
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
    }

    /* renamed from: X */
    public void m81858X(Activity activity, InterfaceC13449b interfaceC13449b) {
        AbstractC10896a.m65887i("HisyncAccountManager", "loginWithoutAidl");
        C13195l.m79272J().m79312c0(activity, interfaceC13449b, 8701);
    }

    /* renamed from: Z */
    public final void m81859Z(Context context, boolean z10, boolean z11) {
        if (!isLogin()) {
            AbstractC10896a.m65888w("HisyncAccountManager", "notifyAuthFail, Cloud hasn't login, don't notify");
            return;
        }
        if (C13044b.m78695a()) {
            AbstractC10896a.m65886e("HisyncAccountManager", "notifyAuthFail, all module disable, not show Auth fail notify");
            return;
        }
        if (z10 && !m81850N(context)) {
            AbstractC10896a.m65887i("HisyncAccountManager", "notifyAuthFail background, isSureStInvalid: " + z11);
            C12515a.m75110o().m75172d(new b(context, z11));
            return;
        }
        Activity activityM78351m = context instanceof Activity ? (Activity) context : null;
        if (activityM78351m == null) {
            activityM78351m = C13019a.m78347n().m78351m();
        }
        if (activityM78351m != null && "StInvalidNotificationActivity".equals(activityM78351m.getClass().getSimpleName())) {
            AbstractC10896a.m65887i("HisyncAccountManager", "notifyAuthFail, StInvalidNotificationActivity is in foreground, ignore");
        } else if (C0209d.m1333z1(context)) {
            m81857V(activityM78351m, this);
        } else {
            AbstractC10896a.m65886e("HisyncAccountManager", "network isn't available, set isProcessing false");
            this.f61240b = false;
        }
    }

    @Override // p709vj.InterfaceC13455h
    /* renamed from: a */
    public void mo80999a(Context context, InterfaceC13456i interfaceC13456i) {
        if (context == null) {
            AbstractC10896a.m65887i("HisyncAccountManager", "isHwIdLogin context is null");
        } else {
            C12515a.m75110o().m75175e(new f(context, interfaceC13456i), false);
        }
    }

    /* renamed from: a0 */
    public final void m81860a0(Context context, boolean z10) {
        AbstractC10896a.m65887i("HisyncAccountManager", "notifyFileManagerLogin");
        C12515a.m75110o().m75175e(new k(context, z10), false);
    }

    @Override // p709vj.InterfaceC13455h
    /* renamed from: b */
    public void mo81000b(Context context) {
        if (m81884s(context)) {
            return;
        }
        InterfaceC14307e interfaceC14307e = this.f61247i;
        if (interfaceC14307e == null) {
            AbstractC10896a.m65887i("HisyncAccountManager", "mAccountExternal is null");
        } else {
            C12515a.m75110o().m75175e(new h(context, interfaceC14307e), true);
        }
    }

    /* renamed from: b0 */
    public void m81861b0() {
        synchronized (this.f61243e) {
            AbstractC10896a.m65885d("HisyncAccountManager", "notifyProcessingFinish, set isProcessing false");
            this.f61240b = false;
        }
    }

    @Override // p709vj.InterfaceC13455h
    /* renamed from: c */
    public void mo81001c(Activity activity, InterfaceC13449b interfaceC13449b) {
        C13195l.m79272J().m79310a0(activity, interfaceC13449b);
    }

    /* renamed from: c0 */
    public final void m81862c0(Context context, boolean z10) {
        if (z10 || m81894x(context) == 1) {
            m81891v0(context);
        } else {
            AbstractC10896a.m65887i("HisyncAccountManager", "notifyStInvalidBackground, set isProcessing false");
            this.f61240b = false;
        }
    }

    /* renamed from: d0 */
    public void m81863d0(Bundle bundle, InterfaceC13449b interfaceC13449b, Context context, boolean z10) {
        if (z10) {
            AbstractC10896a.m65887i("HisyncAccountManager", "st valid retry migration");
            C14306d.m85221v("com.huawei.hicloud.action.NOTIFY_MIGRATION");
        }
        if (bundle == null) {
            return;
        }
        synchronized (this.f61243e) {
            try {
                AbstractC10896a.m65887i("HisyncAccountManager", "postLogin, set isProcessing false");
                this.f61240b = false;
                C13195l.m79272J().m79336u();
                new C13819c().m82860b();
                new C13818b().m82860b();
                C14306d.m85222w(bundle);
                m81860a0(context, z10);
                if (interfaceC13449b != null) {
                    interfaceC13449b.mo13820W(bundle);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        m81873m();
    }

    /* renamed from: e0 */
    public void m81864e0(Context context) {
        boolean zMo61362e;
        boolean zMo61359b;
        AbstractC10896a.m65887i("HisyncAccountManager", "processAfterCloudDisable");
        InterfaceC14307e interfaceC14307e = this.f61247i;
        if (interfaceC14307e != null) {
            zMo61362e = interfaceC14307e.mo61362e();
            zMo61359b = this.f61247i.mo61359b();
        } else {
            zMo61362e = false;
            zMo61359b = false;
        }
        if (C13452e.m80781L().m80912f1()) {
            AbstractC10896a.m65887i("HisyncAccountManager", "site not match, do not process other");
            return;
        }
        if (zMo61362e || zMo61359b) {
            C14306d.m85221v("com.huawei.hicloud.action.PROCESS_FORCE_UPGRADE");
        } else if (C13452e.m80781L().m80927i1()) {
            m81866g0(context);
        } else {
            m81865f0(context, false, true);
        }
    }

    /* renamed from: f0 */
    public final void m81865f0(Context context, boolean z10, boolean z11) {
        if (context != null) {
            synchronized (this.f61243e) {
                try {
                    if (!this.f61240b) {
                        this.f61240b = true;
                        AbstractC10896a.m65887i("HisyncAccountManager", "processAuthFailSync, set isProcessing true");
                        m81839A0();
                        C14306d.m85221v("com.huawei.hicloud.action.PROCESS_AUTH_FAILED");
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                        if (notificationManager != null && C14303a.m85185a().m85190f() == 0) {
                            notificationManager.cancelAll();
                        }
                        m81859Z(context, z10, z11);
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: g0 */
    public final void m81866g0(Context context) {
        C14306d.m85221v("com.huawei.hicloud.action.PROCESS_SYNC_RISK");
    }

    /* renamed from: h0 */
    public void m81867h0(Activity activity) {
        if (activity == null) {
            AbstractC10896a.m65886e("HisyncAccountManager", "reLogin context is null or callback is null");
            return;
        }
        synchronized (this.f61243e) {
            try {
                if (this.f61240b) {
                    AbstractC10896a.m65887i("HisyncAccountManager", "reLogin,isProcessing true");
                } else {
                    this.f61240b = true;
                    AbstractC10896a.m65887i("HisyncAccountManager", "reLogin, set isProcessing true");
                    m81858X(activity, this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: i0 */
    public void m81868i0(Context context, long j10) {
        if (context == null) {
            return;
        }
        C12611a.m76098a(context).m76100c(j10);
    }

    @Override // p709vj.InterfaceC13455h
    public boolean isLogin() {
        return C13452e.m80781L().m80842P0();
    }

    /* renamed from: j0 */
    public void m81869j0(Context context, String str) {
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).edit();
        editorEdit.putString("HiSyncAccountpushToken", C11477c.m68636f(str));
        editorEdit.commit();
    }

    /* renamed from: k0 */
    public void m81870k0(Context context) {
        AbstractC10896a.m65885d("HisyncAccountManager", "registPush()");
        C13198o.m79385c().m79387d(context.getApplicationContext(), new j());
    }

    /* renamed from: l */
    public void m81871l(Bundle bundle, InterfaceC13449b interfaceC13449b) {
        if (bundle != null) {
            AbstractC10896a.m65887i("HisyncAccountManager", "Activate PhoneFinder successfully");
            C13452e.m80781L().m80968s1(bundle);
            C14306d.m85221v("com.huawei.hidisk.HANDLE_AIDL_LOGIN_RESULT");
            boolean zM80917g1 = C13452e.m80781L().m80917g1();
            C13452e.m80781L().m80919g3(false);
            m81863d0(bundle, interfaceC13449b, C0213f.m1377a(), zM80917g1);
        }
    }

    /* renamed from: l0 */
    public void m81872l0(InterfaceC14307e interfaceC14307e) {
        this.f61247i = interfaceC14307e;
    }

    /* renamed from: m */
    public final void m81873m() {
        AbstractC10896a.m65887i("HisyncAccountManager", "Enter authCanceled");
        m81861b0();
        InterfaceC14307e interfaceC14307e = this.f61247i;
        if (interfaceC14307e == null) {
            AbstractC10896a.m65887i("HisyncAccountManager", "mAccountExternal is null");
            return;
        }
        interfaceC14307e.mo61358a();
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            interfaceC13043aM80810H.mo78690a(C0213f.m1377a(), "", "cancel_verify");
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
    }

    /* renamed from: n */
    public void m81874n() {
        C13195l.m79272J().m79337u0(f61238l, false);
    }

    /* renamed from: n0 */
    public void m81875n0(Intent intent) {
        this.f61245g = intent;
    }

    /* renamed from: o */
    public void m81876o() {
        C13195l.m79272J().m79345y0(new C13614d());
    }

    /* renamed from: o0 */
    public void m81877o0(Intent intent) {
        this.f61244f = intent;
    }

    /* renamed from: p */
    public void m81878p(Activity activity) {
        C13195l.m79272J().m79345y0(new C13614d(activity));
    }

    /* renamed from: p0 */
    public void m81879p0(boolean z10) {
        this.f61241c = z10;
    }

    /* renamed from: q */
    public void m81880q(Handler handler) {
        C13195l.m79272J().m79345y0(new C13613c(handler));
    }

    /* renamed from: q0 */
    public void m81881q0(boolean z10) {
        this.f61242d = z10;
    }

    /* renamed from: r */
    public void m81882r(Activity activity, Handler handler, int i10) {
        C13195l.m79272J().m79311b0(activity, new C13613c(handler), i10);
    }

    /* renamed from: r0 */
    public void m81883r0() {
        this.f61242d = false;
    }

    /* renamed from: s */
    public final boolean m81884s(Context context) {
        if (context == null) {
            AbstractC10896a.m65887i("HisyncAccountManager", "aidlLoginForAccountInfo context null");
            return true;
        }
        if (C0209d.m1246d2(context)) {
            return false;
        }
        AbstractC10896a.m65887i("HisyncAccountManager", "aidlLoginForAccountInfo user not unlock");
        return true;
    }

    /* renamed from: s0 */
    public void m81885s0(boolean z10) {
        synchronized (this.f61243e) {
            AbstractC10896a.m65887i("HisyncAccountManager", "set isProcessing: " + z10);
            this.f61240b = z10;
        }
    }

    /* renamed from: t */
    public boolean m81886t(Activity activity) {
        if (C13452e.m80781L().m80927i1()) {
            m81866g0(activity);
            return true;
        }
        if (!C13452e.m80781L().m80917g1()) {
            return false;
        }
        AbstractC10896a.m65888w("HisyncAccountManager", "Check st status: ST is invalid");
        m81865f0(activity, false, false);
        return true;
    }

    /* renamed from: t0 */
    public void m81887t0(Intent intent) {
        this.f61246h = intent;
    }

    /* renamed from: u */
    public void m81888u() {
        synchronized (this.f61243e) {
            AbstractC10896a.m65887i("HisyncAccountManager", "clearData set isProcessing false");
            this.f61240b = false;
        }
        this.f61241c = false;
    }

    /* renamed from: u0 */
    public final void m81889u0(Context context) {
        AbstractC10896a.m65887i("HisyncAccountManager", "showAccountInConsistentActivity");
        try {
            boolean zM1245d1 = C0209d.m1245d1(context, AccountInConsistentActivity.class.getName());
            AbstractC10896a.m65887i("HisyncAccountManager", "showAccountInConsistentActivity is showing: " + zM1245d1);
            if (context == null || zM1245d1 || !C0209d.m1241c1()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) AccountInConsistentActivity.class);
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(intent);
        } catch (Exception e10) {
            AbstractC10896a.m65887i("HisyncAccountManager", "showAccountInConsistentActivity exception: " + e10.toString());
        }
    }

    /* renamed from: v */
    public void m81890v(Context context, InterfaceC13454g interfaceC13454g) {
        if (context == null) {
            AbstractC10896a.m65887i("HisyncAccountManager", "customHwidLoginCheck context is null");
        } else {
            C12515a.m75110o().m75175e(new g(context, interfaceC13454g), false);
        }
    }

    /* renamed from: v0 */
    public final void m81891v0(Context context) {
        if (context == null) {
            AbstractC10896a.m65886e("HisyncAccountManager", "showAuthFailNotification context is null");
            return;
        }
        long jM85190f = C14303a.m85185a().m85190f();
        long jM85189e = C14303a.m85185a().m85189e();
        new C13048f().m78696a();
        if (System.currentTimeMillis() - jM85190f < 24 * C5863b6.g.f26453g) {
            AbstractC10896a.m65888w("HisyncAccountManager", "Do not show notification, lastNotifyTime: " + jM85190f + ", frequency hour: 24");
        } else {
            AbstractC10896a.m65887i("HisyncAccountManager", "showAuthFailNotification, show notification");
            new C13220a().m79453e();
        }
        if (System.currentTimeMillis() - jM85189e < 24 * C5863b6.g.f26453g) {
            AbstractC10896a.m65888w("HisyncAccountManager", "Do not show desktop notification, lastNotifyTime: " + jM85189e + ", frequency hour: 24");
        } else if (C0209d.m1265i1(context)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            AbstractC10896a.m65887i("HisyncAccountManager", "showAuthFailNotification, show desktop notification, currentTime: " + jCurrentTimeMillis);
            C14303a.m85185a().m85196l(jCurrentTimeMillis);
            InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
            if (interfaceC13043aM80810H != null) {
                interfaceC13043aM80810H.mo78694e(context, "show_desktop", "1");
                interfaceC13043aM80810H.mo78691b("CKC", "show_desktop", "value", "1");
                interfaceC13043aM80810H.mo78690a(context, "desktop", "notification");
            }
            Intent intent = new Intent();
            intent.setClass(context, StInvalidNotificationActivity.class);
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(intent);
        }
        AbstractC10896a.m65885d("HisyncAccountManager", "showAuthFailNotification, set isProcessing false");
        this.f61240b = false;
    }

    /* renamed from: w */
    public Intent m81892w() {
        return this.f61245g;
    }

    /* renamed from: w0 */
    public final void m81893w0() {
        if (C13452e.m80781L().m80917g1()) {
            String strM80873X = C13452e.m80781L().m80873X();
            InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
            if (interfaceC13043aM80810H != null) {
                interfaceC13043aM80810H.mo78690a(C0213f.m1377a(), "notifyEntry: " + strM80873X, "verify_account");
                if (TextUtils.isEmpty(strM80873X)) {
                    return;
                }
                interfaceC13043aM80810H.mo78694e(C0213f.m1377a(), strM80873X, "1");
                interfaceC13043aM80810H.mo78691b("CKC", strM80873X, "value", "1");
                C13452e.m80781L().m80789B2("");
            }
        }
    }

    /* renamed from: x */
    public final int m81894x(Context context) {
        if (context == null) {
            AbstractC10896a.m65886e("HisyncAccountManager", "getAccountStStatus, context is null");
            return 0;
        }
        if (!isLogin()) {
            AbstractC10896a.m65886e("HisyncAccountManager", "getAccountStStatus, Cloud hasn't login");
            return 1;
        }
        if (!C13452e.m80781L().m80917g1()) {
            AbstractC10896a.m65887i("HisyncAccountManager", "getAccountStStatus, local invalid flag is false");
            return 0;
        }
        synchronized (this.f61243e) {
            try {
                if (this.f61240b) {
                    AbstractC10896a.m65888w("HisyncAccountManager", "getAccountStStatus, local invalid flag is true & isProcessing is true");
                    return 1;
                }
                this.f61239a = 0;
                m81897y0();
                AbstractC10896a.m65887i("HisyncAccountManager", "getAccountStStatus accountStStatus = " + this.f61239a);
                return this.f61239a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: x0 */
    public void m81895x0() {
        C13195l.m79272J().m79337u0(new c(), false);
    }

    /* renamed from: y */
    public final InterfaceC13449b m81896y(CountDownLatch countDownLatch) {
        return new d(countDownLatch);
    }

    /* renamed from: y0 */
    public void m81897y0() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        InterfaceC13449b interfaceC13449bM81896y = m81896y(countDownLatch);
        AbstractC10896a.m65885d("HisyncAccountManager", "syncRefreshUserInfo, silentSignInForBackground");
        C13195l.m79272J().m79337u0(interfaceC13449bM81896y, false);
        try {
            if (countDownLatch.await(2L, TimeUnit.SECONDS)) {
                AbstractC10896a.m65885d("HisyncAccountManager", "syncRefreshUserInfo countDownLatch.await");
            }
        } catch (InterruptedException unused) {
            AbstractC10896a.m65886e("HisyncAccountManager", "syncRefreshUserInfo InterruptedException");
        }
    }

    /* renamed from: z */
    public Intent m81898z() {
        return this.f61244f;
    }

    /* renamed from: z0 */
    public Bundle m81899z0(Bundle bundle) {
        Bundle bundle2 = (Bundle) bundle.clone();
        bundle2.putString("authAccount", bundle.getString("accountName"));
        return bundle2;
    }
}
