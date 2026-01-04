package p681uj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.account.util.ATTrafficController;
import com.huawei.hicloud.model.AccountConstant;
import com.huawei.hicloud.model.response.SMSRefreshResp;
import com.huawei.hicloud.service.C5009e0;
import com.huawei.hicloud.service.C5026t;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.support.hwid.HuaweiIdAdvancedManager;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import fk.C9721b;
import hu.C10342a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p399jk.AbstractC10896a;
import p429kk.C11058a;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p683um.C13220a;
import p683um.C13221b;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;
import p709vj.InterfaceC13450c;
import p709vj.InterfaceC13451d;
import p712vm.C13468a;
import p742wj.C13612b;
import p846zj.C14303a;
import p846zj.C14306d;
import tm.C13040c;

/* renamed from: uj.l */
/* loaded from: classes5.dex */
public class C13195l {

    /* renamed from: q */
    public static C13195l f59740q = new C13195l();

    /* renamed from: d */
    public String f59744d;

    /* renamed from: e */
    public String f59745e;

    /* renamed from: f */
    public String f59746f;

    /* renamed from: j */
    public long f59750j;

    /* renamed from: a */
    public final ReentrantLock f59741a = new ReentrantLock();

    /* renamed from: b */
    public ReadWriteLock f59742b = new ReentrantReadWriteLock();

    /* renamed from: c */
    public ReadWriteLock f59743c = new ReentrantReadWriteLock();

    /* renamed from: g */
    public boolean f59747g = false;

    /* renamed from: h */
    public volatile boolean f59748h = true;

    /* renamed from: i */
    public int f59749i = 1;

    /* renamed from: k */
    public CountDownLatch f59751k = null;

    /* renamed from: l */
    public CountDownLatch f59752l = null;

    /* renamed from: m */
    public long f59753m = 0;

    /* renamed from: n */
    public long f59754n = 0;

    /* renamed from: o */
    public HuaweiIdAuthService f59755o = C13200q.m79391a();

    /* renamed from: p */
    public ExecutorService f59756p = Executors.newSingleThreadExecutor();

    /* renamed from: uj.l$a */
    public class a implements InterfaceC8939g<AuthHuaweiId> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC13449b f59757a;

        /* renamed from: b */
        public final /* synthetic */ Activity f59758b;

        public a(InterfaceC13449b interfaceC13449b, Activity activity) {
            this.f59757a = interfaceC13449b;
            this.f59758b = activity;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(AuthHuaweiId authHuaweiId) {
            BaseLogger.m28733i("HmsHwId", "silentSignInForReLogin success");
            if (authHuaweiId == null) {
                BaseLogger.m28731e("HmsHwId", "silentSignInForReLogin success, but authHuaweiId is null");
                InterfaceC13449b interfaceC13449b = this.f59757a;
                if (interfaceC13449b != null) {
                    interfaceC13449b.mo13808L(new Exception("silentSignInForReLogin authHuaweiId is null"));
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isBackground", false);
            if (C13195l.this.m79320l0(bundle, authHuaweiId)) {
                C13195l.this.m79291D(this.f59758b, this.f59757a, true, bundle);
                return;
            }
            BaseLogger.m28731e("HmsHwId", "silentSignInForReLogin success, but key param not exist");
            InterfaceC13449b interfaceC13449b2 = this.f59757a;
            if (interfaceC13449b2 != null) {
                interfaceC13449b2.mo13808L(new Exception("silentSignInForReLogin success, but key param not exist"));
            }
        }
    }

    /* renamed from: uj.l$b */
    public class b implements InterfaceC8938f {

        /* renamed from: a */
        public final /* synthetic */ String f59760a;

        public b(String str) {
            this.f59760a = str;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            BaseLogger.m28733i("HmsHwId", " [AT OPERATION] [" + this.f59760a + "] silentSignIn fail: " + exc.toString());
            if (C13195l.this.f59752l != null) {
                C13195l.this.f59752l.countDown();
            }
        }
    }

    /* renamed from: uj.l$c */
    public class c implements InterfaceC8939g<AuthHuaweiId> {
        public c() {
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(AuthHuaweiId authHuaweiId) {
            BaseLogger.m28733i("HmsHwId", " [AT OPERATION] silentSignIn success");
            if (C13195l.this.f59752l != null) {
                C13195l.this.f59752l.countDown();
            }
        }
    }

    /* renamed from: uj.l$d */
    public class d extends AbstractC12367d {

        /* renamed from: uj.l$d$a */
        public class a implements InterfaceC8938f {
            public a() {
            }

            @Override // p208cq.InterfaceC8938f
            public void onFailure(Exception exc) {
                BaseLogger.m28733i("HmsHwId", " [AT OPERATION] sign out fail: " + exc.toString());
                if (C13195l.this.f59751k != null) {
                    C13195l.this.f59751k.countDown();
                }
            }
        }

        /* renamed from: uj.l$d$b */
        public class b implements InterfaceC8939g<Void> {
            public b() {
            }

            @Override // p208cq.InterfaceC8939g
            /* renamed from: a */
            public void onSuccess(Void r22) {
                BaseLogger.m28733i("HmsHwId", " [AT OPERATION] sign out success");
                if (C13195l.this.f59751k != null) {
                    C13195l.this.f59751k.countDown();
                }
            }
        }

        public d() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            BaseLogger.m28733i("HmsHwId", " [AT OPERATION] signOut");
            C13195l.this.f59741a.lock();
            try {
                if (C13195l.this.f59751k == null || C13195l.this.f59751k.getCount() != 1) {
                    C13195l.this.f59751k = new CountDownLatch(1);
                }
                if (C13195l.this.f59755o != null) {
                    C13195l.this.f59755o.signOut().addOnSuccessListener(C13195l.this.f59756p, new b()).addOnFailureListener(C13195l.this.f59756p, new a());
                    C13195l.this.f59741a.unlock();
                    return;
                }
                AbstractC10896a.m65886e("HmsHwId", " [AT OPERATION] signOut failed: IdAuthService null, clear invalid AT.");
                C13195l.this.f59746f = null;
                if (C13195l.this.f59751k != null) {
                    C13195l.this.f59751k.countDown();
                }
                C13195l.this.f59741a.unlock();
            } catch (Throwable th2) {
                C13195l.this.f59741a.unlock();
                throw th2;
            }
        }
    }

    /* renamed from: uj.l$e */
    public class e implements InterfaceC8939g<AuthHuaweiId> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC13449b f59766a;

        /* renamed from: b */
        public final /* synthetic */ Activity f59767b;

        public e(InterfaceC13449b interfaceC13449b, Activity activity) {
            this.f59766a = interfaceC13449b;
            this.f59767b = activity;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(AuthHuaweiId authHuaweiId) {
            BaseLogger.m28733i("HmsHwId", "silentSignInForLogin success");
            if (authHuaweiId == null) {
                BaseLogger.m28731e("HmsHwId", "silentSignInForLogin success, but authHuaweiId is null");
                InterfaceC13449b interfaceC13449b = this.f59766a;
                if (interfaceC13449b != null) {
                    interfaceC13449b.mo13808L(new Exception("silentSignInForLogin authHuaweiId is null"));
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isBackground", true);
            if (C13195l.this.m79320l0(bundle, authHuaweiId)) {
                C13195l.this.m79291D(this.f59767b, this.f59766a, true, bundle);
                return;
            }
            BaseLogger.m28731e("HmsHwId", "silentSignInForLogin success, but key param not exist");
            InterfaceC13449b interfaceC13449b2 = this.f59766a;
            if (interfaceC13449b2 != null) {
                interfaceC13449b2.mo13808L(new Exception("silentSignInForLogin success, but key param not exist"));
            }
        }
    }

    /* renamed from: uj.l$f */
    public class f implements InterfaceC8938f {

        /* renamed from: a */
        public final /* synthetic */ Activity f59769a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC13449b f59770b;

        /* renamed from: c */
        public final /* synthetic */ int f59771c;

        public f(Activity activity, InterfaceC13449b interfaceC13449b, int i10) {
            this.f59769a = activity;
            this.f59770b = interfaceC13449b;
            this.f59771c = i10;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            BaseLogger.m28731e("HmsHwId", "silentSignInForLogin onFailure, signIn foreground. e: " + exc.toString());
            C13195l.this.m79312c0(this.f59769a, this.f59770b, this.f59771c);
        }
    }

    /* renamed from: uj.l$g */
    public class g implements InterfaceC8939g<AuthHuaweiId> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC13449b f59773a;

        /* renamed from: b */
        public final /* synthetic */ boolean f59774b;

        public g(InterfaceC13449b interfaceC13449b, boolean z10) {
            this.f59773a = interfaceC13449b;
            this.f59774b = z10;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(AuthHuaweiId authHuaweiId) {
            BaseLogger.m28733i("HmsHwId", "silentSignInForBackground success");
            if (authHuaweiId == null) {
                BaseLogger.m28733i("HmsHwId", "silentSignInForBackground success, but authHuaweiId is null");
                InterfaceC13449b interfaceC13449b = this.f59773a;
                if (interfaceC13449b != null) {
                    interfaceC13449b.mo13808L(new Exception("silentSignInForBackground authHuaweiId is null"));
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            if (C13195l.this.m79320l0(bundle, authHuaweiId)) {
                C13195l.this.m79291D(C0213f.m1377a(), this.f59773a, this.f59774b, bundle);
                return;
            }
            BaseLogger.m28731e("HmsHwId", "silentSignInForBackground success, but key param not exist");
            InterfaceC13449b interfaceC13449b2 = this.f59773a;
            if (interfaceC13449b2 != null) {
                interfaceC13449b2.mo13808L(new Exception("silentSignInForBackground success, but key param not exist"));
            }
        }
    }

    /* renamed from: uj.l$h */
    public class h implements InterfaceC8939g<AuthHuaweiId> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC13449b f59776a;

        public h(InterfaceC13449b interfaceC13449b) {
            this.f59776a = interfaceC13449b;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(AuthHuaweiId authHuaweiId) {
            BaseLogger.m28733i("HmsHwId", "silentSignInWithoutAdvance success");
            if (authHuaweiId == null) {
                BaseLogger.m28733i("HmsHwId", "silentSignInWithoutAdvance success, but authHuaweiId is null");
                InterfaceC13449b interfaceC13449b = this.f59776a;
                if (interfaceC13449b != null) {
                    interfaceC13449b.mo13808L(new Exception("silentSignInWithoutAdvance authHuaweiId is null"));
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            if (C13195l.this.m79320l0(bundle, authHuaweiId)) {
                C13452e.m80781L().m80960q1(bundle);
                InterfaceC13449b interfaceC13449b2 = this.f59776a;
                if (interfaceC13449b2 != null) {
                    interfaceC13449b2.mo13820W(bundle);
                    return;
                }
                return;
            }
            BaseLogger.m28731e("HmsHwId", "silentSignInWithoutAdvance success, but key param not exist");
            InterfaceC13449b interfaceC13449b3 = this.f59776a;
            if (interfaceC13449b3 != null) {
                interfaceC13449b3.mo13808L(new Exception("silentSignInWithoutAdvance success, but key param not exist"));
            }
        }
    }

    /* renamed from: uj.l$i */
    public class i implements InterfaceC8939g<String> {

        /* renamed from: a */
        public final /* synthetic */ Bundle f59778a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC13449b f59779b;

        /* renamed from: c */
        public final /* synthetic */ Context f59780c;

        /* renamed from: d */
        public final /* synthetic */ boolean f59781d;

        public i(Bundle bundle, InterfaceC13449b interfaceC13449b, Context context, boolean z10) {
            this.f59778a = bundle;
            this.f59779b = interfaceC13449b;
            this.f59780c = context;
            this.f59781d = z10;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(String str) throws JSONException {
            try {
                BaseLogger.m28733i("HmsHwId", "getAccountInfoFromAdvancedSDK, onSuccess");
                JSONObject jSONObject = new JSONObject(str);
                if (C13195l.this.m79318j0(this.f59778a, jSONObject.getString("accountName"), jSONObject.getString("accountType"), jSONObject.getString(HwPayConstant.KEY_SITE_ID))) {
                    C13195l.this.m79294G(this.f59780c, this.f59779b, this.f59781d, this.f59778a);
                    return;
                }
                BaseLogger.m28731e("HmsHwId", "get device info success, but key param not exist");
                InterfaceC13449b interfaceC13449b = this.f59779b;
                if (interfaceC13449b != null) {
                    interfaceC13449b.mo13808L(new Exception("get device info success, but key param not exist"));
                }
            } catch (JSONException e10) {
                BaseLogger.m28731e("HmsHwId", "getAccountInfo onSuccess json exception:" + e10.toString());
                InterfaceC13449b interfaceC13449b2 = this.f59779b;
                if (interfaceC13449b2 != null) {
                    interfaceC13449b2.mo13808L(e10);
                }
            }
        }
    }

    /* renamed from: uj.l$j */
    public class j implements InterfaceC8939g<String> {

        /* renamed from: a */
        public final /* synthetic */ Bundle f59783a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC13449b f59784b;

        /* renamed from: c */
        public final /* synthetic */ boolean f59785c;

        public j(Bundle bundle, InterfaceC13449b interfaceC13449b, boolean z10) {
            this.f59783a = bundle;
            this.f59784b = interfaceC13449b;
            this.f59785c = z10;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(String str) throws JSONException {
            try {
                BaseLogger.m28733i("HmsHwId", "getDeviceInfoFromAdvancedSDK, onSuccess");
                JSONObject jSONObject = new JSONObject(str);
                if (!C13195l.this.m79319k0(this.f59783a, jSONObject.getString("deviceID"), jSONObject.getString(JsbMapKeyNames.H5_DEVICE_TYPE))) {
                    BaseLogger.m28731e("HmsHwId", "get device info success, but key param not exist");
                    InterfaceC13449b interfaceC13449b = this.f59784b;
                    if (interfaceC13449b != null) {
                        interfaceC13449b.mo13808L(new Exception("get device info success, but key param not exist"));
                        return;
                    }
                    return;
                }
                C13452e.m80781L().m80960q1(this.f59783a);
                C13452e.m80781L().m80964r1(this.f59783a);
                if (this.f59785c) {
                    C13452e.m80781L().m80968s1(this.f59783a);
                    C13195l.this.m79313d0(this.f59784b, this.f59783a);
                    C13452e.m80781L().m80945m2(false);
                } else {
                    InterfaceC13449b interfaceC13449b2 = this.f59784b;
                    if (interfaceC13449b2 != null) {
                        interfaceC13449b2.mo13820W(this.f59783a);
                    }
                }
            } catch (JSONException e10) {
                BaseLogger.m28731e("HmsHwId", "getDeviceInfoFromAdvancedSDK onSuccess json exception:" + e10.toString());
                InterfaceC13449b interfaceC13449b3 = this.f59784b;
                if (interfaceC13449b3 != null) {
                    interfaceC13449b3.mo13808L(e10);
                }
            }
        }
    }

    /* renamed from: uj.l$k */
    public static class k implements InterfaceC8938f {

        /* renamed from: a */
        public InterfaceC13449b f59787a;

        public k(InterfaceC13449b interfaceC13449b) {
            this.f59787a = interfaceC13449b;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            BaseLogger.m28731e("HmsHwId", "silentSignInForReLogin onFailure, signIn foreground. e: " + (exc == null ? "" : exc.toString()));
            InterfaceC13449b interfaceC13449b = this.f59787a;
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(new Exception("silentSignInForReLogin onFailure"));
            }
        }
    }

    /* renamed from: uj.l$l */
    public static class l implements InterfaceC8938f {

        /* renamed from: a */
        public InterfaceC13449b f59788a;

        /* renamed from: b */
        public String f59789b;

        public l(InterfaceC13449b interfaceC13449b, String str) {
            this.f59788a = interfaceC13449b;
            this.f59789b = str;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            BaseLogger.m28731e("HmsHwId", this.f59789b + " onFailure, signIn foreground. e: " + (exc == null ? "" : exc.toString()));
            InterfaceC13449b interfaceC13449b = this.f59788a;
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(exc);
            }
        }
    }

    /* renamed from: uj.l$m */
    public static class m implements InterfaceC8938f {

        /* renamed from: a */
        public InterfaceC13449b f59790a;

        public m(InterfaceC13449b interfaceC13449b) {
            this.f59790a = interfaceC13449b;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            BaseLogger.m28731e("HmsHwId", "silentSignInForUserInfo onFailure, signIn foreground. e: " + (exc == null ? "" : exc.toString()));
            InterfaceC13449b interfaceC13449b = this.f59790a;
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(exc);
            }
        }
    }

    /* renamed from: uj.l$n */
    public static class n implements InterfaceC8939g<AuthHuaweiId> {

        /* renamed from: a */
        public InterfaceC13449b f59791a;

        public n(InterfaceC13449b interfaceC13449b) {
            this.f59791a = interfaceC13449b;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(AuthHuaweiId authHuaweiId) {
            BaseLogger.m28733i("HmsHwId", "silentSignInForUserInfo success");
            InterfaceC13449b interfaceC13449b = this.f59791a;
            if (interfaceC13449b == null) {
                BaseLogger.m28733i("HmsHwId", "silentSignInForUserInfo callback is null");
                return;
            }
            if (authHuaweiId == null) {
                interfaceC13449b.mo13808L(new Exception("silentSignInForUserInfo authHuaweiId is null"));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(CommonConstant.KEY_DISPLAY_NAME, authHuaweiId.getDisplayName());
            bundle.putString("photoUrl", authHuaweiId.getAvatarUriString());
            bundle.putString("countryCode", authHuaweiId.getCountryCode());
            bundle.putString(CommonConstant.KEY_SERVICE_COUNTRY_CODE, authHuaweiId.getServiceCountryCode());
            bundle.putString(CommonConstant.KEY_AGE_RANGE, authHuaweiId.getAgeRange());
            C13452e.m80781L().m80960q1(bundle);
            String uid = authHuaweiId.getUid();
            String countryCode = authHuaweiId.getCountryCode();
            bundle.putString(JsbMapKeyNames.H5_USER_ID, uid);
            bundle.putString("countryCode", countryCode);
            if (StringUtils.strEquals(uid, C13452e.m80781L().m80971t0())) {
                this.f59791a.mo13838m0(bundle);
            } else {
                BaseLogger.m28735w("HmsHwId", "silentSignInForUserInfo uid is not success call authTokenSuccess");
                C13195l.m79279e0("silentSignInForUserInfo");
            }
        }
    }

    /* renamed from: H */
    public static String m79270H(Context context) {
        if (context == null) {
            context = C0213f.m1377a();
        }
        if (context == null) {
            BaseLogger.m28735w("HmsHwId", "context is null!");
            return null;
        }
        String hMSPackageName = HMSPackageManager.getInstance(context).getHMSPackageName();
        if (TextUtils.isEmpty(hMSPackageName)) {
            BaseLogger.m28735w("HmsHwId", "hmsPackageName is empty!");
            return null;
        }
        PackageManagerHelper.PackageStates hMSPackageStates = HMSPackageManager.getInstance(context).getHMSPackageStates();
        if (hMSPackageStates == PackageManagerHelper.PackageStates.ENABLED) {
            return hMSPackageName;
        }
        BaseLogger.m28735w("HmsHwId", "hmsPackage is invalid, packageStates is: " + hMSPackageStates);
        return null;
    }

    /* renamed from: I */
    public static Intent m79271I(Context context, String str) {
        String strM79270H = m79270H(context);
        if (TextUtils.isEmpty(strM79270H)) {
            BaseLogger.m28731e("HmsHwId", "hmsPackage is invalid!");
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        C0209d.m1302r2(intent, strM79270H);
        intent.putExtra("clientID", "10055832");
        return intent;
    }

    /* renamed from: J */
    public static C13195l m79272J() {
        return f59740q;
    }

    /* renamed from: Z */
    public static void m79273Z(Activity activity, String str) {
        if (activity == null) {
            BaseLogger.m28731e("HmsHwId", "jumpBindAccount activity is null!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BaseLogger.m28731e("HmsHwId", "bindType is empty!");
            return;
        }
        try {
            Intent intentM79271I = m79271I(activity, "hwid://com.huawei.hwid/BindAccount");
            if (intentM79271I == null) {
                BaseLogger.m28731e("HmsHwId", "hmsPackage is invalid!");
            } else {
                intentM79271I.putExtra("accountType", str);
                C10342a.m63678d(activity, intentM79271I, 10050);
            }
        } catch (Exception e10) {
            BaseLogger.m28731e("HmsHwId", "jumpBindAccount exception:" + e10.getMessage());
        }
    }

    /* renamed from: e0 */
    public static void m79279e0(String str) {
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                Intent intent = new Intent();
                intent.setPackage("com.huawei.hidisk");
                intent.setAction("com.huawei.hicloud.intent.action.ACCOUNT_INCONSISTENT_NOTICE");
                C13108a.m78878b(contextM1377a).m78881d(intent);
                C5009e0.m30045l("AccountInConsistent", str);
            }
        } catch (Exception e10) {
            AbstractC10896a.m65887i("HmsHwId", "notifyAccountInConsistent exception: " + e10.toString());
        }
    }

    /* renamed from: A */
    public String m79288A() {
        return this.f59744d;
    }

    /* renamed from: B */
    public final String m79289B(String str, String str2, String str3) throws C13199p, C13194k {
        if (C5009e0.m30044e().m30054j()) {
            this.f59741a.lock();
            try {
                if (!m79307W()) {
                    BaseLogger.m28735w("HmsHwId", "getAccessTokenFromSMSService use originGetAccessToken");
                    return m79316h0(str, str2, str3);
                }
                if (C5009e0.m30044e().m30054j()) {
                    BaseLogger.m28733i("HmsHwId", "start getAccessTokenFromSMSService");
                    if (C5009e0.m30044e().m30055k()) {
                        BaseLogger.m28729d("HmsHwId", "get new authCode success: " + this.f59745e);
                        m79338v(str, "AtExpired And SessionIdExpired");
                    } else {
                        m79340w(str, false);
                    }
                } else {
                    ATTrafficController.m29104b().m29105a(str);
                }
            } finally {
                this.f59741a.unlock();
            }
        } else {
            BaseLogger.m28729d("HmsHwId", "getAccessTokenFromSMSService At not Expired or isUseSessionAt = false");
        }
        String strM30050f = C5009e0.m30044e().m30050f();
        if (strM30050f == null || strM30050f.isEmpty()) {
            BaseLogger.m28733i("HmsHwId", "getAccessTokenFromSMSService failed, return origin accessToken");
            return m79316h0(str, str2, str3);
        }
        BaseLogger.m28733i("HmsHwId", "getAccessTokenFromSMSService return smsAccessToken");
        return strM30050f;
    }

    /* renamed from: C */
    public String m79290C(String str, String str2, String str3) throws C13199p, C13194k {
        return m79346z(str, str2, str3);
    }

    /* renamed from: D */
    public final void m79291D(Context context, InterfaceC13449b interfaceC13449b, boolean z10, Bundle bundle) {
        BaseLogger.m28733i("HmsHwId", "getAccountInfoFromAdvancedSDK");
        HuaweiIdAdvancedManager.getService(context).getAccountInfo(C13221b.m79455b()).addOnSuccessListener(new i(bundle, interfaceC13449b, context, z10)).addOnFailureListener(new l(interfaceC13449b, "getAccountInfoFromAdvancedSDK"));
    }

    /* renamed from: E */
    public final void m79292E(String str, String str2, String str3) throws C13199p, C13194k {
        m79328q();
        if ("CloudSync".equals(str2) || "DriveBuilder".equals(str2) || "CloudPhoto".equals(str2) || "OkHttpDownload".equals(str2) || "CommonHttpGet".equals(str2)) {
            C13185b.m79233a().m79234b();
        }
        C13202s c13202s = new C13202s(str2, str3);
        C12515a.m75110o().m75175e(c13202s, false);
        for (int i10 = 0; i10 < 3; i10++) {
            BaseLogger.m28733i("HmsHwId", " [AT OPERATION] silentSignIn retry times: " + i10);
            try {
            } catch (C13194k e10) {
                C13468a c13468aM81100c = C13468a.m81100c();
                boolean zM81101b = c13468aM81100c.m81101b();
                String str4 = c13468aM81100c.toString() + e10.toString();
                if (!zM81101b) {
                    throw new C13194k(PlayerConstants.ErrorCode.DEFAULT_ERROR, str4);
                }
                if (this.f59749i > 5) {
                    this.f59749i = 1;
                    this.f59750j = System.currentTimeMillis();
                    BaseLogger.m28731e("HmsHwId", " [AT OPERATION] MAX_NETWORK_ERROR_RETRY_TIMES lastNetworkErrorTime = " + System.currentTimeMillis());
                    throw new C13194k(e10.m79269b(), str4);
                }
                if (e10.m79269b() == 2001 || i10 >= 2) {
                    BaseLogger.m28731e("HmsHwId", " [AT OPERATION] getAT failed, code = " + e10.m79269b() + ", msg: " + e10.getMessage());
                    throw new C13194k(e10.m79269b(), str4);
                }
                if (e10.m79269b() == 2030) {
                    throw new C13194k(e10.m79269b(), str4);
                }
            }
            if (m79335t0(str, "originGetAccessToken")) {
                ATTrafficController.m29104b().m29105a(str);
                return;
            }
            continue;
        }
    }

    /* renamed from: F */
    public final void m79293F(AuthHuaweiId authHuaweiId) throws C13194k {
        m79323n0(authHuaweiId);
        String accessToken = authHuaweiId.getAccessToken();
        this.f59745e = authHuaweiId.getAuthorizationCode();
        String uid = authHuaweiId.getUid();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(strM80971t0) || uid.equals(strM80971t0)) {
            BaseLogger.m28731e("HmsHwId", " [AT OPERATION] userId same!");
            m79331r0(false);
        } else {
            BaseLogger.m28731e("HmsHwId", " [AT OPERATION] userId changed!");
            m79331r0(true);
            this.f59745e = "";
            C5009e0.m30044e().m30047b("getAtFromSignInResult  userId Invalid");
            BaseLogger.m28733i("HmsHwId", "getAtFromSignInResult notifyAccountInConsistent");
            m79279e0("getAtFromSignInResult");
        }
        if (accessToken == null || accessToken.isEmpty()) {
            throw new C13194k(4001, " [AT OPERATION] get AT from HMS is empty!");
        }
        if (accessToken.equals(this.f59746f)) {
            BaseLogger.m28735w("HmsHwId", " [AT OPERATION] silentSignIn new AT equals old invalid at!");
            return;
        }
        BaseLogger.m28733i("HmsHwId", " [AT OPERATION] silentSignIn get new AT successfully.");
        this.f59744d = accessToken;
        m79321m0();
        m79327p0(true);
    }

    /* renamed from: G */
    public final void m79294G(Context context, InterfaceC13449b interfaceC13449b, boolean z10, Bundle bundle) {
        BaseLogger.m28733i("HmsHwId", "getDeviceInfoFromAdvancedSDK");
        Task<String> deviceInfo = HuaweiIdAdvancedManager.getService(context).getDeviceInfo();
        deviceInfo.addOnSuccessListener(new j(bundle, interfaceC13449b, z10));
        deviceInfo.addOnFailureListener(new l(interfaceC13449b, "getDeviceInfoFromAdvancedSDK"));
    }

    /* renamed from: K */
    public final int m79295K(Task<AuthHuaweiId> task) {
        if (task == null) {
            BaseLogger.m28731e("HmsHwId", "getLoginRetCode fail  authTask is null");
            return 0;
        }
        try {
            int statusCode = task.getException() instanceof ApiException ? ((ApiException) task.getException()).getStatusCode() : 0;
            BaseLogger.m28729d("HmsHwId", "getLoginRetCode statusCode " + statusCode);
            return statusCode;
        } catch (Exception e10) {
            BaseLogger.m28731e("HmsHwId", "getLoginRetCode Exception " + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: L */
    public final String m79296L(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String strM29107d = ATTrafficController.m29104b().m29107d(str);
        try {
            if (TextUtils.isEmpty(strM29107d)) {
                jSONObject.putOpt("subSrcPackageName", "com.huawei.hidisk.common");
            } else {
                jSONObject.putOpt("subSrcPackageName", strM29107d);
            }
        } catch (JSONException e10) {
            BaseLogger.m28731e("HmsHwId", "getSinginParam json exception:" + e10.toString());
        }
        return jSONObject.toString();
    }

    /* renamed from: M */
    public void m79297M(Activity activity, InterfaceC13450c interfaceC13450c, int i10, Intent intent) {
        ErrorStatus errorStatus;
        if (interfaceC13450c == null) {
            AbstractC10896a.m65886e("HmsHwId", "handleCheckPasswdActivityResult callback is null ");
            return;
        }
        if (activity == null) {
            AbstractC10896a.m65886e("HmsHwId", "handleCheckPasswdActivityResult activity is null ");
            interfaceC13450c.mo20330a(new ErrorStatus(3400, "handleCheckPasswdActivityResult activity is null"));
            return;
        }
        if (i10 == -1) {
            interfaceC13450c.mo20331b();
            return;
        }
        if (intent != null) {
            try {
                errorStatus = (ErrorStatus) intent.getParcelableExtra(VastAttribute.ERROR);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("HmsHwId", "class ErrorStatus pkg path hms apk sdk not match  " + e10.getMessage());
            }
        } else {
            errorStatus = null;
        }
        interfaceC13450c.mo20330a(errorStatus);
    }

    /* renamed from: N */
    public void m79298N(Activity activity, InterfaceC13451d interfaceC13451d, int i10, Intent intent) {
        String stringExtra;
        ErrorStatus errorStatus;
        if (interfaceC13451d == null) {
            AbstractC10896a.m65886e("HmsHwId", "handleCheckPasswdByVerifyToken callback is null ");
            return;
        }
        if (activity == null) {
            AbstractC10896a.m65886e("HmsHwId", "handleCheckPasswdByVerifyToken activity is null ");
            interfaceC13451d.mo17021a(new ErrorStatus(3400, "handleCheckPasswdByVerifyToken activity is null"));
            return;
        }
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra(CommonConstant.KEY_ID_TOKEN);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("HmsHwId", "getStringExtra error  " + e10.getMessage());
            }
        } else {
            stringExtra = "";
        }
        AbstractC10896a.m65886e("HmsHwId", "handleCheckPasswdByVerifyToken is empty:" + TextUtils.isEmpty(stringExtra));
        if (i10 == -1 || !TextUtils.isEmpty(stringExtra)) {
            interfaceC13451d.mo17022b(stringExtra);
            return;
        }
        if (intent != null) {
            try {
                errorStatus = (ErrorStatus) intent.getParcelableExtra(VastAttribute.ERROR);
            } catch (Exception e11) {
                AbstractC10896a.m65886e("HmsHwId", "class ErrorStatus pkg path hms apk sdk not match  " + e11.getMessage());
            }
        } else {
            errorStatus = null;
        }
        interfaceC13451d.mo17021a(errorStatus);
    }

    /* renamed from: O */
    public void m79299O(Activity activity, InterfaceC13449b interfaceC13449b, int i10, int i11, Intent intent) {
        BaseLogger.m28733i("HmsHwId", "handleLoginActivityResult");
        if (activity == null || intent == null) {
            BaseLogger.m28731e("HmsHwId", "handleLoginActivityResult fail, activity or data is null");
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(new Exception("handleLoginActivityResult fail, activity or data is null"));
                return;
            }
            return;
        }
        Task<AuthHuaweiId> authResultFromIntent = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
        if (authResultFromIntent == null) {
            BaseLogger.m28731e("HmsHwId", "handleLoginActivityResult fail, authHuaweiIdTask is null");
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(new Exception("handleLoginActivityResult fail, authHuaweiIdTask is null"));
                return;
            }
            return;
        }
        if (authResultFromIntent.isSuccessful()) {
            BaseLogger.m28733i("HmsHwId", "handleLoginActivityResult, foreground auth success");
            m79300P(authResultFromIntent, activity, interfaceC13449b, i10);
        } else {
            BaseLogger.m28733i("HmsHwId", "handleLoginActivityResult, foreground auth failed");
            m79317i0(authResultFromIntent, i11, interfaceC13449b);
        }
    }

    /* renamed from: P */
    public final void m79300P(Task<AuthHuaweiId> task, Activity activity, InterfaceC13449b interfaceC13449b, int i10) {
        AuthHuaweiId result = task.getResult();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isBackground", false);
        if (!m79320l0(bundle, result)) {
            BaseLogger.m28731e("HmsHwId", "handleLoginActivityResult, but key param not exist");
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(new Exception("handleLoginActivityResult, but key param not exist"));
                return;
            }
            return;
        }
        BaseLogger.m28733i("HmsHwId", "authHuaweiIdTask.isSuccessful()");
        if (m79304T(i10)) {
            m79341w0(activity, interfaceC13449b);
        } else {
            m79291D(activity, interfaceC13449b, true, bundle);
        }
    }

    /* renamed from: Q */
    public void m79301Q(Activity activity, int i10, int i11, Intent intent) {
        if (activity == null || intent == null) {
            BaseLogger.m28733i("HmsHwId", "handleStInvalidResult activity or data is null");
        } else {
            BaseLogger.m28733i("HmsHwId", "handleStInvalidResult");
            m79299O(activity, C13612b.m81829B(), i10, i11, intent);
        }
    }

    /* renamed from: R */
    public final boolean m79302R() {
        this.f59742b.readLock().lock();
        try {
            BaseLogger.m28733i("HmsHwId", "start isAtValid: " + this.f59747g);
            return this.f59747g;
        } finally {
            this.f59742b.readLock().unlock();
        }
    }

    /* renamed from: S */
    public final boolean m79303S(Task<AuthHuaweiId> task, int i10) {
        return C14306d.m85211l() ? m79295K(task) == 2012 : i10 == 0;
    }

    /* renamed from: T */
    public final boolean m79304T(int i10) {
        return i10 == 8701;
    }

    /* renamed from: U */
    public boolean m79305U(Activity activity, InterfaceC13449b interfaceC13449b, Intent intent) {
        BaseLogger.m28733i("HmsHwId", "isStatusCodeNeedIgnore");
        if (activity == null || intent == null) {
            BaseLogger.m28731e("HmsHwId", "isStatusCodeNeedIgnore fail, activity or data is null");
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(new Exception("isStatusCodeNeedIgnore fail, activity or data is null"));
            }
            return false;
        }
        Task<AuthHuaweiId> authResultFromIntent = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
        if (authResultFromIntent != null) {
            return !authResultFromIntent.isSuccessful() && m79295K(authResultFromIntent) == 8;
        }
        BaseLogger.m28731e("HmsHwId", "isStatusCodeNeedIgnore fail, authHuaweiIdTask is null");
        if (interfaceC13449b != null) {
            interfaceC13449b.mo13808L(new Exception("isStatusCodeNeedIgnore fail, authHuaweiIdTask is null"));
        }
        return false;
    }

    /* renamed from: V */
    public boolean m79306V(String str) {
        return (TextUtils.isEmpty(str) || str.equals("0") || str.equals("1") || str.equals("2") || str.equals("8")) ? false : true;
    }

    /* renamed from: W */
    public final boolean m79307W() {
        this.f59743c.readLock().lock();
        try {
            BaseLogger.m28733i("HmsHwId", "isUseSessionAT = " + this.f59748h);
            return this.f59748h;
        } finally {
            this.f59743c.readLock().unlock();
        }
    }

    /* renamed from: X */
    public boolean m79308X() {
        return C13452e.m80781L().m80826L0() && m79307W();
    }

    /* renamed from: Y */
    public boolean m79309Y() {
        return C13452e.m80781L().m80936k1();
    }

    /* renamed from: a0 */
    public void m79310a0(Activity activity, InterfaceC13449b interfaceC13449b) {
        m79311b0(activity, interfaceC13449b, 8701);
    }

    /* renamed from: b0 */
    public void m79311b0(Activity activity, InterfaceC13449b interfaceC13449b, int i10) {
        if (activity != null && this.f59755o != null) {
            m79339v0(activity, interfaceC13449b, i10);
            return;
        }
        BaseLogger.m28731e("HmsHwId", "account sdk login error, activity or service is null");
        if (interfaceC13449b != null) {
            interfaceC13449b.mo13808L(new Exception("login activity or service is null"));
        }
    }

    /* renamed from: c0 */
    public void m79312c0(Activity activity, InterfaceC13449b interfaceC13449b, int i10) {
        HuaweiIdAuthService huaweiIdAuthService;
        if (activity == null || (huaweiIdAuthService = this.f59755o) == null) {
            BaseLogger.m28731e("HmsHwId", "loginInActivity activity or service null");
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(new Exception("loginInActivity activity or service is null"));
                return;
            }
            return;
        }
        try {
            Intent signInIntent = huaweiIdAuthService.getSignInIntent();
            signInIntent.putExtra("intent.extra.isfullscreen", true);
            activity.startActivityForResult(signInIntent, i10);
        } catch (Exception e10) {
            BaseLogger.m28731e("HmsHwId", "loginInActivity exception: " + e10.toString());
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(e10);
            }
        }
    }

    /* renamed from: d0 */
    public final void m79313d0(InterfaceC13449b interfaceC13449b, Bundle bundle) {
        C13452e.m80781L().m80919g3(false);
        C13452e.m80781L().m80899c3(true);
        C14303a.m85185a().m85197m(0L);
        C14303a.m85185a().m85196l(0L);
        new C13220a().m1136a(275, 22, "com.huawei.android.hicloud");
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            C13040c.m78609F().m78654j0(C0213f.m1377a(), C13452e.m80781L().m80942m(), true);
        }
        if (interfaceC13449b == null || !interfaceC13449b.mo13814Q(bundle)) {
            C14306d.m85221v("com.huawei.hidisk.HANDLE_AIDL_LOGIN_RESULT");
            boolean zM80917g1 = C13452e.m80781L().m80917g1();
            C13452e.m80781L().m80919g3(false);
            C13612b.m81829B().m81863d0(bundle, interfaceC13449b, C0213f.m1377a(), zM80917g1);
            m79314f0();
        }
    }

    /* renamed from: f0 */
    public final void m79314f0() {
        C14306d.m85221v("com.huawei.hicloud.ST_FIXED");
        AbstractC10896a.m65887i("HmsHwId", "Storage notifyStFixed");
    }

    /* renamed from: g0 */
    public final void m79315g0(Exception exc, String str) throws C13199p, C13194k {
        if (!(exc instanceof ApiException)) {
            BaseLogger.m28731e("HmsHwId", " [AT OPERATION] onSignResultError, status is null");
            throw new C13194k(4001, "onSignResultError, status is null.");
        }
        ApiException apiException = (ApiException) exc;
        int statusCode = apiException.getStatusCode();
        BaseLogger.m28731e("HmsHwId", " [AT OPERATION] status: " + statusCode + ", networkErrorRetryTimes: " + this.f59749i);
        if (statusCode == 2004 || statusCode == 2002) {
            if (C13452e.m80781L().m80842P0() && statusCode == 2002) {
                BaseLogger.m28733i("HmsHwId", "onSignResultError notifyAccountInConsistent");
                m79279e0("SIGN_IN_AUTH");
            }
            throw new C13199p(statusCode, " [AT OPERATION] silentSignIn fail, statusCode: " + statusCode + ", MSG: " + apiException.getStatusMessage());
        }
        if (statusCode == 2005) {
            int i10 = this.f59749i + 1;
            this.f59749i = i10;
            if (i10 > 5) {
                this.f59750j = System.currentTimeMillis();
                throw new C13194k(statusCode, " [AT OPERATION] silentSignIn fail, network error is more than 5 times, statusCode: " + statusCode + ", MSG: " + apiException.getStatusMessage());
            }
        }
        if (statusCode != 2030) {
            throw new C13194k(statusCode, " [AT OPERATION] silentSignIn fail, statusCode: " + statusCode + ", MSG: " + apiException.getStatusMessage());
        }
        BaseLogger.m28733i("HmsHwId", "status code at traffic control");
        ATTrafficController.m29104b().m29108e(str);
        throw new C13194k(statusCode, " [AT OPERATION] silentSignIn fail, AT traffic control, statusCode: " + statusCode + ", MSG: " + apiException.getStatusMessage());
    }

    /* renamed from: h0 */
    public String m79316h0(String str, String str2, String str3) throws C13199p, C13194k {
        m79330r();
        m79322n();
        if (m79302R()) {
            BaseLogger.m28733i("HmsHwId", "getAT return old");
        } else {
            this.f59741a.lock();
            try {
                if (m79302R()) {
                    ATTrafficController.m29104b().m29105a(str);
                    BaseLogger.m28733i("HmsHwId", "start clearFailEvent");
                } else {
                    BaseLogger.m28733i("HmsHwId", "start getAT");
                    m79292E(str, str2, str3);
                }
                this.f59741a.unlock();
                BaseLogger.m28733i("HmsHwId", "getAT return new");
            } catch (Throwable th2) {
                this.f59741a.unlock();
                throw th2;
            }
        }
        String str4 = this.f59744d;
        if (str4 == null || str4.isEmpty()) {
            throw new C13194k(4001, "get accessToken is null.");
        }
        return this.f59744d;
    }

    /* renamed from: i0 */
    public final void m79317i0(Task<AuthHuaweiId> task, int i10, InterfaceC13449b interfaceC13449b) {
        if (interfaceC13449b != null) {
            if (m79303S(task, i10)) {
                interfaceC13449b.mo13829e(null);
            } else {
                interfaceC13449b.mo13808L(task.getException());
            }
        }
    }

    /* renamed from: j0 */
    public final boolean m79318j0(Bundle bundle, String str, String str2, String str3) {
        bundle.putString("accountName", str);
        bundle.putString("accountType", str2);
        bundle.putString(HwPayConstant.KEY_SITE_ID, str3);
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) ? false : true;
    }

    /* renamed from: k0 */
    public final boolean m79319k0(Bundle bundle, String str, String str2) {
        bundle.putString("deviceID", str);
        bundle.putString(JsbMapKeyNames.H5_DEVICE_TYPE, str2);
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
    }

    /* renamed from: l0 */
    public final boolean m79320l0(Bundle bundle, AuthHuaweiId authHuaweiId) {
        if (authHuaweiId == null) {
            return false;
        }
        String uid = authHuaweiId.getUid();
        String countryCode = authHuaweiId.getCountryCode();
        bundle.putString(JsbMapKeyNames.H5_USER_ID, uid);
        bundle.putString("countryCode", countryCode);
        bundle.putString(CommonConstant.KEY_SERVICE_COUNTRY_CODE, authHuaweiId.getServiceCountryCode());
        bundle.putString(CommonConstant.KEY_DISPLAY_NAME, authHuaweiId.getDisplayName());
        bundle.putString("photoUrl", authHuaweiId.getAvatarUriString());
        bundle.putString(CommonConstant.KEY_AGE_RANGE, authHuaweiId.getAgeRange());
        bundle.putString("serverAuthCode", authHuaweiId.getAuthorizationCode());
        return (TextUtils.isEmpty(uid) || TextUtils.isEmpty(countryCode)) ? false : true;
    }

    /* renamed from: m0 */
    public final void m79321m0() {
        this.f59754n = System.currentTimeMillis();
        C0214f0.m1382b(C0213f.m1377a(), "account_info", 0).edit().putLong("get_at_time", this.f59754n).commit();
    }

    /* renamed from: n */
    public final void m79322n() {
        if (this.f59754n == 0) {
            this.f59754n = C0214f0.m1382b(C0213f.m1377a(), "account_info", 0).getLong("get_at_time", 0L);
        }
        BaseLogger.m28733i("HmsHwId", "System.currentTimeMillis() - starTimerTime: " + ((System.currentTimeMillis() - this.f59754n) / 1000));
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f59753m;
        BaseLogger.m28733i("HmsHwId", "checkAtInValid, intervalTime: " + jCurrentTimeMillis);
        if (System.currentTimeMillis() - this.f59754n < 3300000 || jCurrentTimeMillis <= 60000) {
            return;
        }
        this.f59753m = System.currentTimeMillis();
        m79272J().m79325o0(this.f59744d);
        m79329q0(true, "checkAtInValid setUseSessionAt true");
    }

    /* renamed from: n0 */
    public final void m79323n0(AuthHuaweiId authHuaweiId) {
        if (authHuaweiId == null) {
            BaseLogger.m28735w("HmsHwId", "refreshServiceCountryCode authHuaweiId is null");
            return;
        }
        String serviceCountryCode = authHuaweiId.getServiceCountryCode();
        BaseLogger.m28733i("HmsHwId", "refreshServiceCountryCode service country code is: " + serviceCountryCode);
        if (TextUtils.isEmpty(serviceCountryCode)) {
            BaseLogger.m28735w("HmsHwId", "refreshServiceCountryCode authHuaweiId is null");
        } else {
            C13452e.m80781L().m80821J2(serviceCountryCode);
            C13452e.m80781L().m80825K2(System.currentTimeMillis());
        }
    }

    /* renamed from: o */
    public void m79324o(Activity activity, String str, int i10, InterfaceC13450c interfaceC13450c) {
        if (activity == null) {
            AbstractC10896a.m65886e("HmsHwId", "checkHwIdPassword : activity is null");
            if (interfaceC13450c != null) {
                interfaceC13450c.mo20330a(new ErrorStatus(3400, "checkHwIdPassword, activity is null"));
                return;
            }
            return;
        }
        try {
            Intent intentM79271I = m79271I(activity, "hwid://com.huawei.hwid/VerifyPassword");
            if (intentM79271I == null) {
                AbstractC10896a.m65886e("HmsHwId", "hmsPackage is invalid!");
                return;
            }
            intentM79271I.putExtra("VERIFY_PASSWORD_TYPE", 0);
            intentM79271I.putExtra("accountType", str);
            activity.startActivityForResult(intentM79271I, i10);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HmsHwId", "checkHwIdPassword exception: " + e10.toString());
            if (interfaceC13450c != null) {
                interfaceC13450c.mo20330a(new ErrorStatus(3400, "checkHwIdPassword, exception"));
            }
        }
    }

    /* renamed from: o0 */
    public void m79325o0(String str) {
        this.f59742b.writeLock().lock();
        try {
            C5009e0.m30044e().m30046a(str);
            if (TextUtils.isEmpty(str)) {
                BaseLogger.m28733i("HmsHwId", "invalid oldAccessToken is empty!");
                this.f59747g = false;
            } else {
                if (!str.equals(this.f59746f)) {
                    BaseLogger.m28733i("HmsHwId", "setAtInValid and signout");
                    this.f59746f = str;
                    this.f59747g = false;
                    this.f59742b.writeLock().unlock();
                    m79333s0();
                    return;
                }
                BaseLogger.m28733i("HmsHwId", "this Token is already invalid!");
            }
        } finally {
            this.f59742b.writeLock().unlock();
        }
    }

    /* renamed from: p */
    public void m79326p(Activity activity, int i10, boolean z10, String str, InterfaceC13451d interfaceC13451d) {
        if (activity == null) {
            AbstractC10896a.m65886e("HmsHwId", "checkHwIdPasswordV2 : activity is null");
            if (interfaceC13451d != null) {
                interfaceC13451d.mo17021a(new ErrorStatus(3400, "checkHwIdPasswordV2, activity is null"));
                return;
            }
            return;
        }
        try {
            Intent intentM79271I = m79271I(activity, "hwid://com.huawei.hwid/VerifyPasswordV2");
            if (intentM79271I == null) {
                AbstractC10896a.m65886e("HmsHwId", "hmsPackage is invalid!");
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                intentM79271I.putExtra("VERIFY_SCENE", str);
            }
            intentM79271I.putExtra("VERIFY_PWD_TYPE", z10 ? 3 : 0);
            intentM79271I.putExtra("clientID", "10055832");
            intentM79271I.putExtra("callingpackage", activity.getPackageName());
            intentM79271I.putExtra("idTokenSignAlg", 1);
            activity.startActivityForResult(intentM79271I, i10);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HmsHwId", "checkHwIdPasswordV2 exception: " + e10.toString());
            if (interfaceC13451d != null) {
                interfaceC13451d.mo17021a(new ErrorStatus(3400, "checkHwIdPasswordV2, exception"));
            }
        }
    }

    /* renamed from: p0 */
    public final void m79327p0(boolean z10) {
        BaseLogger.m28729d("HmsHwId", "setIsAtValid: " + z10);
        this.f59742b.writeLock().lock();
        try {
            this.f59747g = z10;
        } finally {
            this.f59742b.writeLock().unlock();
        }
    }

    /* renamed from: q */
    public final void m79328q() throws C13194k {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f59750j;
        if (jCurrentTimeMillis <= 0 || jCurrentTimeMillis >= 60000) {
            return;
        }
        throw new C13194k(4001, " [AT OPERATION] getAt Failed. Last network error time: " + this.f59750j);
    }

    /* renamed from: q0 */
    public final void m79329q0(boolean z10, String str) {
        this.f59743c.writeLock().lock();
        if (!z10) {
            try {
                C5009e0.m30044e().m30047b(str);
            } catch (Throwable th2) {
                this.f59743c.writeLock().unlock();
                throw th2;
            }
        }
        this.f59748h = z10;
        this.f59743c.writeLock().unlock();
    }

    /* renamed from: r */
    public final void m79330r() throws C13194k {
        BaseLogger.m28729d("HmsHwId", "checkLoginStatusErr");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            BaseLogger.m28731e("HmsHwId", "checkLoginStatusErr, context is null");
            return;
        }
        if (C13452e.m80781L().m80846Q0()) {
            BaseLogger.m28733i("HmsHwId", "checkLoginStatusErr, login status error");
            long jM80822K = C13452e.m80781L().m80822K();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jM80822K < 1800000) {
                throw new C13194k(4003, "login status error");
            }
            int iM81841D = C13612b.m81829B().m81841D(contextM1377a);
            C13452e.m80781L().m80928i2(jCurrentTimeMillis);
            if (iM81841D != 1) {
                throw new C13194k(4003, "login status recheck error");
            }
            C13452e.m80781L().m80945m2(false);
        }
    }

    /* renamed from: r0 */
    public void m79331r0(boolean z10) {
        C13452e.m80781L().m80868V2(z10);
    }

    /* renamed from: s */
    public void m79332s() {
        BaseLogger.m28733i("HmsHwId", "clearAccessToken");
        m79327p0(false);
        this.f59744d = null;
        this.f59746f = null;
        this.f59745e = null;
        C5009e0.m30044e().m30047b("clearAccessToken");
        m79333s0();
    }

    /* renamed from: s0 */
    public final void m79333s0() {
        d dVar = new d();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C12515a.m75110o().m75172d(dVar);
        } else {
            dVar.run();
        }
    }

    /* renamed from: t */
    public void m79334t() {
        BaseLogger.m28733i("HmsHwId", "clearAuthCodeAndAT");
        m79327p0(false);
        this.f59744d = null;
        this.f59746f = null;
        this.f59745e = null;
        C5009e0.m30044e().m30047b("clearAuthCodeAndAT");
    }

    /* renamed from: t0 */
    public final boolean m79335t0(String str, String str2) throws C13199p, JSONException, C13194k, InterruptedException {
        BaseLogger.m28733i("HmsHwId", " [AT OPERATION] silentSignIn");
        try {
            CountDownLatch countDownLatch = this.f59751k;
            if (countDownLatch != null) {
                BaseLogger.m28729d("HmsHwId", " [AT OPERATION] signOutLatch.await: " + countDownLatch.await(3L, TimeUnit.SECONDS));
            }
        } catch (InterruptedException unused) {
            BaseLogger.m28735w("HmsHwId", " [AT OPERATION] signOutLatch InterruptedException");
        }
        this.f59751k = null;
        this.f59744d = null;
        this.f59745e = null;
        C5009e0.m30044e().m30047b("silentSignIn isUseSessionAT=" + m79308X() + ", id=" + str + ", from=" + str2);
        if (this.f59755o == null) {
            BaseLogger.m28731e("HmsHwId", " [AT OPERATION] silentSignIn failed, IdAuthService null, code = 4002");
            throw new C13194k(4002, "silentSignIn failed, IdAuthService null");
        }
        this.f59752l = new CountDownLatch(1);
        String strM79296L = m79296L(str);
        BaseLogger.m28733i("HmsHwId", "params=" + strM79296L);
        Task<AuthHuaweiId> taskAddOnFailureListener = this.f59755o.silentSignIn(strM79296L).addOnSuccessListener(this.f59756p, new c()).addOnFailureListener(this.f59756p, new b(strM79296L));
        try {
            BaseLogger.m28733i("HmsHwId", " [AT OPERATION] silentSignInLatch.await: " + this.f59752l.await(35L, TimeUnit.SECONDS));
        } catch (InterruptedException unused2) {
            BaseLogger.m28735w("HmsHwId", " [AT OPERATION] silentSignInLatch InterruptedException");
        }
        if (taskAddOnFailureListener.isComplete() && taskAddOnFailureListener.isSuccessful()) {
            m79293F(taskAddOnFailureListener.getResult());
            return true;
        }
        m79315g0(taskAddOnFailureListener.getException(), str);
        return false;
    }

    /* renamed from: u */
    public void m79336u() {
        BaseLogger.m28733i("HmsHwId", "clearLocalAccessToken");
        m79327p0(false);
        this.f59744d = null;
        this.f59746f = null;
        this.f59745e = null;
    }

    /* renamed from: u0 */
    public void m79337u0(InterfaceC13449b interfaceC13449b, boolean z10) {
        BaseLogger.m28733i("HmsHwId", "silentSignInForBackground start");
        HuaweiIdAuthService huaweiIdAuthService = this.f59755o;
        if (huaweiIdAuthService != null) {
            Task<AuthHuaweiId> taskSilentSignIn = huaweiIdAuthService.silentSignIn();
            taskSilentSignIn.addOnSuccessListener(new g(interfaceC13449b, z10));
            taskSilentSignIn.addOnFailureListener(new l(interfaceC13449b, "silentSignInForBackground"));
        } else {
            BaseLogger.m28731e("HmsHwId", "account sdk login background error, service is null");
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(new Exception("login background service is null"));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00a9 A[Catch: all -> 0x001b, Exception -> 0x001e, b -> 0x0021, TRY_LEAVE, TryCatch #3 {b -> 0x0021, Exception -> 0x001e, blocks: (B:47:0x0013, B:54:0x0024, B:57:0x0055, B:59:0x008c, B:63:0x009c, B:64:0x00a9), top: B:81:0x0013, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016f A[ORIG_RETURN, RETURN] */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m79338v(java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p681uj.C13195l.m79338v(java.lang.String, java.lang.String):void");
    }

    /* renamed from: v0 */
    public final void m79339v0(Activity activity, InterfaceC13449b interfaceC13449b, int i10) {
        Task<AuthHuaweiId> taskSilentSignIn = this.f59755o.silentSignIn();
        taskSilentSignIn.addOnSuccessListener(new e(interfaceC13449b, activity));
        taskSilentSignIn.addOnFailureListener(new f(activity, interfaceC13449b, i10));
    }

    /* renamed from: w */
    public void m79340w(String str, boolean z10) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07056"), AccountConstant.Cmd.SMS_REFRESH, C13452e.m80781L().m80971t0());
            String strM30053i = C5009e0.m30044e().m30053i();
            String strM30051g = C5009e0.m30044e().m30051g();
            if (TextUtils.isEmpty(strM30053i) || TextUtils.isEmpty(strM30051g)) {
                m79329q0(false, "executeSMSRefresh error signature is null or sessionId is nul");
                BaseLogger.m28735w("HmsHwId", "executeSMSRefresh signature is null or sessionId is null");
                return;
            }
            SMSRefreshResp sMSRefreshRespM30061f = C5026t.m30056d().m30061f(c11060cM66626a, strM30053i, strM30051g);
            long atExpireTime = sMSRefreshRespM30061f.getAtExpireTime();
            long jCurrentTimeMillis = atExpireTime - System.currentTimeMillis();
            BaseLogger.m28733i("HmsHwId", "executeSMSRefresh atExpireTime = " + atExpireTime + " , intervalTime = " + jCurrentTimeMillis);
            if (jCurrentTimeMillis < 300000) {
                BaseLogger.m28735w("HmsHwId", "executeSMSRefresh Invalid time");
                m79329q0(false, "executeSMSRefresh Invalid time");
            } else {
                BaseLogger.m28733i("HmsHwId", "executeSMSRefresh success, start to encrypt");
                C5009e0.m30044e().m30049d(sMSRefreshRespM30061f);
            }
        } catch (C9721b e10) {
            int iM60659c = e10.m60659c();
            BaseLogger.m28731e("HmsHwId", "executeSMSRefresh error: code = " + iM60659c + " message = " + e10.getMessage());
            if (iM60659c == 4016) {
                BaseLogger.m28729d("HmsHwId", "executeSMSRefresh error: SMS_SERVICE_FAILED_SESSION_TIME_OUT, executeSMSLogin.");
                m79338v(str, "SMS_SERVICE_FAILED_SESSION_TIME_OUT");
            } else {
                if (iM60659c == 4018) {
                    if (z10) {
                        m79329q0(false, "executeSMSRefresh SMS_SERVICE_SIGNATURE_EXPIRED repeat");
                        return;
                    } else {
                        m79340w(str, true);
                        return;
                    }
                }
                m79329q0(false, "executeSMSRefresh CException getMessage =" + e10.toString());
            }
        } catch (Exception e11) {
            BaseLogger.m28731e("HmsHwId", "executeSMSRefresh error: " + e11.getMessage());
            m79329q0(false, "executeSMSRefresh Exception" + e11.getMessage());
        }
    }

    /* renamed from: w0 */
    public final void m79341w0(Activity activity, InterfaceC13449b interfaceC13449b) {
        HuaweiIdAuthService huaweiIdAuthService = this.f59755o;
        if (huaweiIdAuthService != null) {
            Task<AuthHuaweiId> taskSilentSignIn = huaweiIdAuthService.silentSignIn();
            taskSilentSignIn.addOnSuccessListener(new a(interfaceC13449b, activity));
            taskSilentSignIn.addOnFailureListener(new k(interfaceC13449b));
        } else {
            BaseLogger.m28731e("HmsHwId", "account sdk reLogin error, service is null");
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(new Exception("reLogin service is null"));
            }
        }
    }

    /* renamed from: x */
    public void m79342x(Activity activity, int i10, boolean z10, int i11, String str, int i12) {
        try {
            Intent intentM79271I = m79271I(activity, "hwid://com.huawei.hwid/ForgotPassword");
            if (intentM79271I == null) {
                AbstractC10896a.m65886e("HmsHwId", "hmsPackage is invalid!");
                return;
            }
            intentM79271I.putExtra("loginChannel", i10);
            intentM79271I.putExtra("reqClientType", i11);
            intentM79271I.putExtra("hw_frp_token", str);
            intentM79271I.putExtra("isOOBE", z10);
            activity.startActivityForResult(intentM79271I, i12);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HmsHwId", "forgotPwd exception: " + e10.toString());
        }
    }

    /* renamed from: x0 */
    public void m79343x0(InterfaceC13449b interfaceC13449b) {
        HuaweiIdAuthService huaweiIdAuthService = this.f59755o;
        if (huaweiIdAuthService != null) {
            Task<AuthHuaweiId> taskSilentSignIn = huaweiIdAuthService.silentSignIn();
            taskSilentSignIn.addOnSuccessListener(new n(interfaceC13449b));
            taskSilentSignIn.addOnFailureListener(new m(interfaceC13449b));
        } else {
            BaseLogger.m28731e("HmsHwId", "account sdk get user info error, service is null");
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(new Exception("get user info service is null"));
            }
        }
    }

    /* renamed from: y */
    public String m79344y(String str, String str2) throws C13199p, C13194k {
        return m79346z("", str, str2);
    }

    /* renamed from: y0 */
    public void m79345y0(InterfaceC13449b interfaceC13449b) {
        BaseLogger.m28733i("HmsHwId", "silentSignInWithoutAdvance start");
        HuaweiIdAuthService huaweiIdAuthService = this.f59755o;
        if (huaweiIdAuthService != null) {
            Task<AuthHuaweiId> taskSilentSignIn = huaweiIdAuthService.silentSignIn();
            taskSilentSignIn.addOnSuccessListener(new h(interfaceC13449b));
            taskSilentSignIn.addOnFailureListener(new l(interfaceC13449b, "silentSignInWithoutAdvance"));
        } else {
            BaseLogger.m28731e("HmsHwId", "account sdk login WithoutAdvance error, service is null");
            if (interfaceC13449b != null) {
                interfaceC13449b.mo13808L(new Exception("login WithoutAdvance service is null"));
            }
        }
    }

    /* renamed from: z */
    public String m79346z(String str, String str2, String str3) throws C13199p, C13194k {
        boolean zM80826L0 = C13452e.m80781L().m80826L0();
        BaseLogger.m28733i("HmsHwId", "getAccessToken enableAuthCode = " + zM80826L0);
        return (zM80826L0 && m79307W()) ? m79289B(str, str2, str3) : m79316h0(str, str2, str3);
    }
}
