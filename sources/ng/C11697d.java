package ng;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.account.AccountAuthManager;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.picker.AccountPickerManager;
import com.huawei.hms.support.picker.request.AccountPickerParams;
import com.huawei.hms.support.picker.request.AccountPickerParamsHelper;
import iq.C10589c;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0226l0;
import p015ak.C0228m0;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p575qe.C12347f;
import p611rf.C12498f;
import p683um.C13221b;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: ng.d */
/* loaded from: classes4.dex */
public class C11697d {

    /* renamed from: a */
    public String f54176a;

    /* renamed from: b */
    public Consumer<String> f54177b;

    /* renamed from: c */
    public volatile boolean f54178c;

    /* renamed from: d */
    public volatile long f54179d;

    /* renamed from: e */
    public boolean f54180e;

    /* renamed from: ng.d$b */
    public static class b {

        /* renamed from: a */
        public static final C11697d f54181a = new C11697d();
    }

    /* renamed from: e */
    public static C11697d m69760e() {
        return b.f54181a;
    }

    /* renamed from: d */
    public void m69761d() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f54179d;
        C13981a.m83989i("PickerLoginManager", "registerLoginCallback timeOffset:" + jCurrentTimeMillis);
        boolean z10 = 240000 > jCurrentTimeMillis;
        if (this.f54178c && !TextUtils.isEmpty(this.f54176a) && z10) {
            C13981a.m83988e("PickerLoginManager", "has login");
            return;
        }
        this.f54178c = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Scope(C13221b.m79456c("LOGIN_ID_SCOPE")));
        arrayList.add(new Scope(C13221b.m79456c("ACCOUNT_SCOPE")));
        arrayList.add(new Scope(C13221b.m79456c("DEVICE_LIST_SCOPE")));
        AccountAuthService service = AccountAuthManager.getService(C0213f.m1377a(), new AccountAuthParamsHelper(AccountAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setEmail().setAuthorizationCode().setEmail().setMobileNumber().setId().setProfile().setAuthorizationCode().setScopeList(arrayList).createParams());
        C13981a.m83989i("PickerLoginManager", "Auth silentSignIn");
        Task<AuthAccount> taskSilentSignIn = service.silentSignIn();
        taskSilentSignIn.addOnSuccessListener(new InterfaceC8939g() { // from class: ng.a
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                this.f54173a.m69763g((AuthAccount) obj);
            }
        });
        taskSilentSignIn.addOnFailureListener(new InterfaceC8938f() { // from class: ng.b
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f54174a.m69764h(exc);
            }
        });
    }

    /* renamed from: f */
    public boolean m69762f() {
        return this.f54180e;
    }

    /* renamed from: g */
    public final /* synthetic */ void m69763g(AuthAccount authAccount) {
        C13981a.m83989i("PickerLoginManager", "Auth silentSignIn success");
        this.f54178c = true;
        this.f54176a = authAccount.getAuthorizationCode();
        this.f54179d = System.currentTimeMillis();
        Consumer<String> consumer = this.f54177b;
        if (consumer != null) {
            consumer.accept(this.f54176a);
            this.f54176a = "";
            this.f54179d = 0L;
            this.f54177b = null;
        }
        new C12797b().m76782h(C12347f.m74285n().m74301m(), "PickerLoginManager", "0", 0, "master portal silentSignIn login result", "001_3017", null, null, "picker login", true);
    }

    /* renamed from: h */
    public final /* synthetic */ void m69764h(Exception exc) {
        C13981a.m83989i("PickerLoginManager", "Auth silentSignIn fail:" + exc.getMessage());
        this.f54178c = true;
        Consumer<String> consumer = this.f54177b;
        if (consumer != null) {
            consumer.accept("");
            this.f54177b = null;
        }
        new C12797b().m76782h(C12347f.m74285n().m74301m(), "PickerLoginManager", "-1", -1, "master portal silentSignIn login fail" + exc.toString(), "001_3017", null, null, "picker login", true);
    }

    /* renamed from: i */
    public final /* synthetic */ void m69765i() {
        Consumer<String> consumer = this.f54177b;
        if (consumer != null) {
            consumer.accept("");
            this.f54177b = null;
            C13981a.m83990w("PickerLoginManager", "registerLoginCallback timeout");
        }
    }

    /* renamed from: j */
    public boolean m69766j(Activity activity, boolean z10) throws JSONException {
        C13981a.m83989i("PickerLoginManager", "picker Sdk isSysTemAcc:" + z10);
        AccountPickerParams accountPickerParamsCreateParams = new AccountPickerParamsHelper(AccountPickerParams.DEFAULT_AUTH_REQUEST_PARAM).setRedirecturl("hms://redirect_uri").setDeviceInfo(C10589c.m64966a(C12498f.m75014a(C0213f.m1377a()), C0228m0.m1597b().m1599c(), C12498f.m75015b(C0213f.m1377a()), C0209d.m1324x0())).setGrsAppName("hicloud").setEmail().setMobileNumber().setId().setProfile().setAuthorizationCode().setScope(new Scope(C13221b.m79456c("LOGIN_ID_SCOPE"))).setScope(new Scope(C13221b.m79456c("ACCOUNT_SCOPE"))).setScope(new Scope(C13221b.m79456c("DEVICE_LIST_SCOPE"))).createParams();
        if (activity == null) {
            C13981a.m83988e("PickerLoginManager", "activity null");
            return false;
        }
        Intent intentSignIn = AccountPickerManager.getService(activity, accountPickerParamsCreateParams, z10 ? 1 : 0).signIn();
        if (intentSignIn == null) {
            C13981a.m83988e("PickerLoginManager", "pickerIntent null");
            return false;
        }
        try {
            activity.startActivityForResult(intentSignIn, 8911);
            return true;
        } catch (Exception unused) {
            C13981a.m83988e("PickerLoginManager", "startActivityForResult exception");
            return false;
        }
    }

    /* renamed from: k */
    public void m69767k(Consumer<String> consumer) {
        if (!this.f54178c) {
            this.f54177b = consumer;
            C0226l0.m1585e(new Runnable() { // from class: ng.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f54175a.m69765i();
                }
            }, 1000L);
        } else if (consumer != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f54179d;
            C13981a.m83989i("PickerLoginManager", "registerLoginCallback timeOffset:" + jCurrentTimeMillis);
            consumer.accept(240000 > jCurrentTimeMillis ? this.f54176a : "");
            this.f54176a = null;
            this.f54179d = 0L;
        }
    }

    /* renamed from: l */
    public void m69768l(boolean z10) {
        this.f54180e = z10;
    }

    public C11697d() {
        this.f54176a = "";
        this.f54178c = false;
        this.f54179d = 0L;
    }
}
