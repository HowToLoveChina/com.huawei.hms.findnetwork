package ohos.ohos.ohos.ohos.ohos;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.huawei.ohos.localability.base.AlertDialogActivity;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.Thread;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ohos.ohos.ohos.ohos.ohos.C11896l;
import ohos.ohos.ohos.ohos.ohos.InterfaceC11900x;
import org.json.JSONException;
import org.json.JSONObject;
import p625rx.C12646m;
import p625rx.RunnableC12637d;
import p625rx.RunnableC12638e;

/* renamed from: ohos.ohos.ohos.ohos.ohos.f */
/* loaded from: classes9.dex */
public class C11891f {

    /* renamed from: a */
    public static final C11891f f55039a = new C11891f();

    /* renamed from: ohos.ohos.ohos.ohos.ohos.f$a */
    public class a extends InterfaceC11900x.a {
        public a(C11891f c11891f) {
        }

        @Override // ohos.ohos.ohos.ohos.ohos.InterfaceC11900x
        /* renamed from: a */
        public void mo71403a(int i10, String str) {
            if (i10 != 0) {
                Log.e("AbilityProxy", "upgradeCheck onFinished  resultCode = " + i10 + ",resultMsg = " + str);
            }
        }
    }

    /* renamed from: ohos.ohos.ohos.ohos.ohos.f$b */
    public static class b implements Thread.UncaughtExceptionHandler {
        public /* synthetic */ b(RunnableC12637d runnableC12637d) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            Log.e("AbilityProxy", "Uncaught exception " + (thread != null ? thread.getName() : "<Unknown>") + " : " + (th2 != null ? th2.getMessage() : "<Unknown>"));
        }
    }

    /* renamed from: u */
    public static /* synthetic */ void m71407u(C11891f c11891f, Intent intent, Context context, int i10) {
        String str;
        List<C11896l> listM71424t = c11891f.m71424t(intent);
        if (listM71424t.size() == 1) {
            C11885a c11885aM71380a = C11886b.m71380a(listM71424t.get(0));
            if (c11885aM71380a != null) {
                c11891f.m71414h(context, c11885aM71380a, intent, false, i10);
                return;
            }
            str = "silentInstallPageAbility onFinished data is null";
        } else {
            str = "onFinished startLocalAbility fail, ability size: " + listM71424t.size();
        }
        Log.e("AbilityProxy", str);
    }

    /* renamed from: a */
    public final int m71408a(String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (str == null || str2 == null) {
            Log.e("AbilityProxy", "getModuleUpgradeFlag intent is null when first free install");
            return -1;
        }
        IBinder iBinderM76173a = C12646m.m76173a();
        if (iBinderM76173a == null) {
            Log.e("AbilityProxy", "getModuleUpgradeFlag getBmsProxy failed");
            return -1;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
        parcelObtain.writeString(str);
        parcelObtain.writeString(str2);
        try {
            iBinderM76173a.transact(72, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readInt();
        } catch (RemoteException e10) {
            Log.e("AbilityProxy", "getModuleUpgradeFlag transact accur exception:" + e10.getMessage());
            return -1;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: b */
    public final ArrayList<C11896l> m71409b(int i10, Parcel parcel, ArrayList<C11896l> arrayList, String str) {
        Parcelable.Creator creator;
        C11902z c11902zCreateFromParcel;
        for (int i11 = 0; i11 < i10; i11++) {
            if (parcel.readBoolean()) {
                if (str == null || "".equals(str)) {
                    creator = C11887c.CREATOR;
                } else if (str.equals("1.0")) {
                    creator = C11896l.CREATOR;
                } else {
                    c11902zCreateFromParcel = C11902z.CREATOR.createFromParcel(parcel);
                    Log.i("AbilityProxy", "item value is InterworkAbilityInfo");
                    arrayList.add(c11902zCreateFromParcel);
                }
                c11902zCreateFromParcel = (C11896l) creator.createFromParcel(parcel);
                arrayList.add(c11902zCreateFromParcel);
            } else {
                Log.e("AbilityProxy", "selectAbilityFromBms length error, length is " + i10);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public final ArrayList<C11896l> m71410c(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setAction("ability.intent.QUERY_ABILITY_NEED_UPDATE");
        return m71422q(intent2);
    }

    /* renamed from: e */
    public List<Intent> m71411e(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, ""));
        intent.addCategory("entity.system.home");
        intent.setAction("action.system.home");
        ArrayList<C11896l> arrayListM71422q = m71422q(intent);
        ArrayList arrayList = new ArrayList(0);
        if (arrayListM71422q.size() == 0) {
            Log.e("AbilityProxy", "getLaunchIntents: not found launch ability by bundle name: " + str);
            return arrayList;
        }
        for (C11896l c11896l : arrayListM71422q) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(str, c11896l.mo71384d()));
            Log.d("AbilityProxy", "found launch ability name: " + c11896l.mo71384d() + " by bundle name: " + str);
            arrayList.add(intent2);
        }
        return arrayList;
    }

    /* renamed from: f */
    public void m71412f(Context context, Intent intent) {
        if (intent.getExtras() == null || !intent.getExtras().getBoolean("ohos.extra.param.key.INSTALL_ON_DEMAND")) {
            m71413g(context, intent, false, -1, C11896l.b.UNKNOWN);
            return;
        }
        Intent intent2 = new Intent(intent);
        intent2.addFlags(2048);
        if (intent.getExtras().getBoolean("ohos.extra.param.key.INSTALL_WITH_BACKGROUND")) {
            intent2.addFlags(Integer.MIN_VALUE);
        }
        Thread thread = new Thread(new RunnableC12637d(this, intent2, context, -1));
        thread.setUncaughtExceptionHandler(new b(null));
        thread.start();
    }

    /* renamed from: g */
    public final void m71413g(Context context, Intent intent, boolean z10, int i10, C11896l.b bVar) {
        C11896l c11896l;
        Log.d("AbilityProxy", "AbilityProxy::startAbility");
        if (context == null || intent == null) {
            Log.d("AbilityProxy", "AbilityProxy::startAbility intent is null!");
            throw new IllegalArgumentException("context or intent is null, can't start ability");
        }
        C11885a c11885aM71380a = C11886b.m71380a(m71425v(intent));
        if (c11885aM71380a == null || (c11896l = c11885aM71380a.f54940a) == null) {
            Log.d("AbilityProxy", "AbilityProxy::startAbility selectAbility failed");
            throw new IllegalArgumentException("ability can not be found, can't start ability");
        }
        C11896l.b bVarMo71392n = c11896l.mo71392n();
        if (bVar != C11896l.b.UNKNOWN && bVar != bVarMo71392n) {
            throw new IllegalStateException("request ability type is wrong, start ability failed");
        }
        m71414h(context, c11885aM71380a, intent, z10, i10);
    }

    /* renamed from: h */
    public void m71414h(Context context, C11885a c11885a, Intent intent, boolean z10, int i10) {
        C11896l c11896l = c11885a.f54940a;
        Intent intent2 = new Intent(intent);
        intent2.setComponent(new ComponentName(c11885a.f54941b, c11885a.f54942c));
        if (c11896l.mo71392n() != C11896l.b.PAGE) {
            if (c11896l.mo71392n() != C11896l.b.SERVICE) {
                Log.d("AbilityProxy", "AbilityProxy::startLocalAbility not page an service ability");
                throw new SecurityException("caller is wrong state, can't start ability");
            }
            try {
                if (z10) {
                    Log.i("AbilityProxy", "startLocalAbility startForegroundService");
                    context.startForegroundService(intent2);
                } else {
                    Log.i("AbilityProxy", "startLocalAbility startService");
                    context.startService(intent2);
                }
                return;
            } catch (IllegalStateException unused) {
                throw new IllegalStateException("caller is wrong state, can't start ability");
            } catch (SecurityException unused2) {
                throw new SecurityException("ability can not be found, can't start ability");
            }
        }
        if (i10 < 0 || i10 > 65535) {
            try {
                Log.i("AbilityProxy", "startLocalAbility startActivity");
                context.startActivity(intent2);
            } catch (ActivityNotFoundException unused3) {
                throw new SecurityException("ability can not be found, can't start ability");
            }
        } else {
            if (!(context instanceof Activity)) {
                Log.d("AbilityProxy", "AbilityProxy::startLocalAbility only Activity support");
                throw new SecurityException("ability can not be found, can't start ability");
            }
            Activity activity = (Activity) context;
            try {
                Log.i("AbilityProxy", "startLocalAbility startActivityForResult");
                activity.startActivityForResult(intent2, i10);
            } catch (ActivityNotFoundException unused4) {
                throw new SecurityException("ability can not be found, can't start ability");
            }
        }
    }

    /* renamed from: i */
    public final void m71415i(Intent intent, Context context, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str;
        Log.d("AbilityProxy", "begin startFreeInstallAbility by fa dispatcher");
        List<C11896l> listM71424t = m71424t(intent);
        Log.d("AbilityProxy", "startFreeInstallAbility infos.size:" + listM71424t.size());
        if (listM71424t.size() <= 1) {
            if (listM71424t.size() == 1) {
                C11885a c11885aM71380a = C11886b.m71380a(listM71424t.get(0));
                if (c11885aM71380a == null) {
                    str = "freeInstallByFaDispatcher selectAbility failed";
                } else {
                    if (m71417l(intent, listM71424t.get(0))) {
                        ComponentName component = intent.getComponent();
                        if (component == null) {
                            Log.e("AbilityProxy", "upgradeCheckAndInstallStartAbility intent ComponentName is null");
                            return;
                        }
                        int iM71408a = m71408a(component.getPackageName(), component.getClassName());
                        Log.i("AbilityProxy", "getModuleUpgradeFlag upgradeFlag = " + iM71408a);
                        if (iM71408a != 1 && iM71408a != 2) {
                            m71414h(context, c11885aM71380a, intent, false, i10);
                            m71426w(intent);
                            return;
                        }
                        BinderC11892g binderC11892g = new BinderC11892g(this, intent, context, i10);
                        if (m71416k(intent, iM71408a, binderC11892g)) {
                            return;
                        }
                        Log.e("AbilityProxy", "upgradeCheckAndInstallPageAbility upgradeInstall fail");
                        binderC11892g.mo71403a(5, "");
                        return;
                    }
                    Log.i("AbilityProxy", "enter second install");
                    if (m71418m(intent, new BinderC11890e(this, intent, context, i10))) {
                        return;
                    }
                }
            } else if (m71418m(intent, new BinderC11890e(this, intent, context, i10))) {
                return;
            }
            Log.e("AbilityProxy", "silentInstallPageAbility silentInstall failed");
            return;
        }
        str = "startFreeInstallAbility selectAbility failed, more than one ability match";
        Log.e("AbilityProxy", str);
    }

    /* renamed from: k */
    public final boolean m71416k(Intent intent, int i10, InterfaceC11900x interfaceC11900x) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        IBinder iBinderM76173a = C12646m.m76173a();
        if (iBinderM76173a == null) {
            Log.e("AbilityProxy", "upgradeInstall getBmsProxy failed");
            return false;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
        C11897l0 c11897l0 = new C11897l0(intent);
        parcelObtain.writeInt(1);
        c11897l0.writeToParcel(parcelObtain, 0);
        parcelObtain.writeInt(i10);
        parcelObtain.writeStrongBinder(interfaceC11900x == null ? null : interfaceC11900x.asBinder());
        try {
            iBinderM76173a.transact(74, parcelObtain, parcelObtain2, 0);
            int i11 = parcelObtain2.readInt();
            if (i11 == 0) {
                return true;
            }
            Log.e("AbilityProxy", "upgradeInstall failed, result is" + i11);
            return false;
        } catch (RemoteException e10) {
            Log.e("AbilityProxy", "upgradeInstall transact accur exception:" + e10.getMessage());
            return false;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: l */
    public final boolean m71417l(Intent intent, C11896l c11896l) throws JSONException {
        String string;
        String stringExtra = intent.getStringExtra("ohos.extra.param.key.moduleName");
        try {
        } catch (JSONException e10) {
            Log.e("AbilityProxy", "parse modulename failed " + e10.getMessage());
        }
        if (c11896l instanceof C11902z) {
            C11902z c11902z = (C11902z) c11896l;
            Log.i("AbilityProxy", "extendparam is " + c11902z.f55124F);
            string = new JSONObject(c11902z.f55124F).getString("modulename");
        } else {
            string = "";
        }
        Log.i("AbilityProxy", "intent moduleName=" + stringExtra + " local query ability moduleName=" + string);
        if (stringExtra != null && !stringExtra.isEmpty()) {
            return stringExtra.equals(string);
        }
        Log.w("AbilityProxy", "moduleName is null");
        return true;
    }

    /* renamed from: m */
    public final boolean m71418m(Intent intent, InterfaceC11900x interfaceC11900x) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        IBinder iBinderM76173a = C12646m.m76173a();
        if (iBinderM76173a == null) {
            Log.e("AbilityProxy", "silentInstall getBmsProxy failed");
            return false;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
        C11888c0 c11888c0 = new C11888c0(intent);
        parcelObtain.writeInt(1);
        c11888c0.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(interfaceC11900x == null ? null : interfaceC11900x.asBinder());
        try {
            iBinderM76173a.transact(73, parcelObtain, parcelObtain2, 0);
            int i10 = parcelObtain2.readInt();
            if (i10 == 0) {
                return true;
            }
            Log.e("AbilityProxy", "silentInstall failed, result is" + i10);
            return false;
        } catch (RemoteException e10) {
            Log.e("AbilityProxy", "silentInstall transact accur exception:" + e10.getMessage());
            return false;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: n */
    public boolean m71419n(ArrayList<C11896l> arrayList, boolean z10, InterfaceC11900x interfaceC11900x) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (arrayList == null || arrayList.isEmpty()) {
            Log.e("AbilityProxy", "error infos size when download and install");
            return false;
        }
        IBinder iBinderM76173a = C12646m.m76173a();
        if (iBinderM76173a == null) {
            Log.e("AbilityProxy", "AbilityProxy::getBmsProxy getBundleManager failed");
            return false;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
        parcelObtain.writeInt(arrayList.size());
        Iterator<C11896l> it = arrayList.iterator();
        while (it.hasNext()) {
            C11896l next = it.next();
            if (next != null) {
                parcelObtain.writeInt(1);
                next.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
        }
        parcelObtain.writeBoolean(z10);
        parcelObtain.writeStrongBinder(interfaceC11900x == null ? null : interfaceC11900x.asBinder());
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            iBinderM76173a.transact(46, parcelObtain, parcelObtain2, 0);
            int i10 = parcelObtain2.readInt();
            if (i10 == 0) {
                return true;
            }
            Log.e("AbilityProxy", "AbilityProxy::downloadAndInstall failed, result is" + i10);
            return false;
        } catch (RemoteException e10) {
            Log.e("AbilityProxy", "downloadAndInstall transact accur exception:" + e10);
            return false;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: o */
    public boolean m71420o(C11896l c11896l) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        IBinder iBinderM76173a = C12646m.m76173a();
        if (iBinderM76173a == null) {
            Log.e("AbilityProxy", "AbilityProxy::getBmsProxy getBundleManager failed");
            return false;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
        if (c11896l != null) {
            parcelObtain.writeInt(1);
            c11896l.writeToParcel(parcelObtain, 0);
        } else {
            parcelObtain.writeInt(0);
        }
        try {
            try {
                if (C12646m.m76178f()) {
                    iBinderM76173a.transact(47, parcelObtain, parcelObtain2, 0);
                } else {
                    iBinderM76173a.transact(43, parcelObtain, parcelObtain2, 0);
                }
                int i10 = parcelObtain2.readInt();
                if (i10 == 0) {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    return true;
                }
                Log.e("AbilityProxy", "AbilityProxy::cancelConnect failed, result is" + i10);
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return false;
            } catch (RemoteException e10) {
                Log.e("AbilityProxy", "cancelConnect transact accur exception:" + e10);
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return false;
            }
        } catch (Throwable th2) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            throw th2;
        }
    }

    /* renamed from: p */
    public boolean m71421p(C11896l c11896l, boolean z10, InterfaceC11900x interfaceC11900x) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        IBinder iBinderM76173a = C12646m.m76173a();
        if (iBinderM76173a == null) {
            Log.e("AbilityProxy", "AbilityProxy::getBmsProxy getBundleManager failed");
            return false;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
        if (c11896l != null) {
            parcelObtain.writeInt(1);
            c11896l.writeToParcel(parcelObtain, 0);
        } else {
            parcelObtain.writeInt(0);
        }
        parcelObtain.writeBoolean(z10);
        parcelObtain.writeStrongBinder(interfaceC11900x == null ? null : interfaceC11900x.asBinder());
        try {
            iBinderM76173a.transact(41, parcelObtain, parcelObtain2, 0);
            int i10 = parcelObtain2.readInt();
            if (i10 == 0) {
                return true;
            }
            Log.e("AbilityProxy", "AbilityProxy::downloadAndInstall failed, result is" + i10);
            return false;
        } catch (RemoteException e10) {
            Log.e("AbilityProxy", "downloadAndInstall transact accur exception:" + e10);
            return false;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: q */
    public final ArrayList<C11896l> m71422q(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ArrayList<C11896l> arrayList = new ArrayList<>(0);
        IBinder iBinderM76173a = C12646m.m76173a();
        if (iBinderM76173a == null) {
            Log.e("AbilityProxy", "getBmsProxy return null");
            return arrayList;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        C11897l0 c11897l0 = new C11897l0(intent);
        parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
        parcelObtain.writeInt(1);
        c11897l0.writeToParcel(parcelObtain, 0);
        try {
            try {
                parcelObtain.writeInt(0);
                String strM76176d = C12646m.m76176d();
                if (strM76176d == null || "".equals(strM76176d)) {
                    parcelObtain.writeInt(0);
                    iBinderM76173a.transact(5, parcelObtain, parcelObtain2, 0);
                } else if (strM76176d.equals("1.0")) {
                    parcelObtain.writeInt(0);
                    if (intent.getExtras() == null || !intent.getExtras().getBoolean("ohos.extra.param.key.INSTALL_ON_DEMAND")) {
                        iBinderM76173a.transact(45, parcelObtain, parcelObtain2, 0);
                    } else {
                        iBinderM76173a.transact(48, parcelObtain, parcelObtain2, 0);
                    }
                } else {
                    iBinderM76173a.transact(77, parcelObtain, parcelObtain2, 0);
                }
                if (parcelObtain2.readInt() != 0) {
                    Log.e("AbilityProxy", "selectAbilityFromBms code error");
                }
                int i10 = parcelObtain2.readInt();
                if (i10 <= 20 && i10 >= 0) {
                    ArrayList<C11896l> arrayListM71409b = m71409b(i10, parcelObtain2, arrayList, strM76176d);
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    return arrayListM71409b;
                }
                Log.e("AbilityProxy", "selectAbilityFromBms length error, length is " + i10);
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return arrayList;
            } catch (RemoteException e10) {
                Log.e("AbilityProxy", "getBmsProxy transact accur exception:" + e10);
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return arrayList;
            }
        } catch (Throwable th2) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            throw th2;
        }
    }

    /* renamed from: r */
    public final void m71423r(Intent intent, Context context, int i10) {
        Log.d("AbilityProxy", "begin startFreeInstallAbility by hag");
        C11885a c11885aM71380a = C11886b.m71380a(m71425v(intent));
        if (c11885aM71380a == null) {
            Log.e("AbilityProxy", "startFreeInstallAbility selectAbility failed");
            return;
        }
        String strMo71385e = c11885aM71380a.f54940a.mo71385e();
        if (strMo71385e == null || strMo71385e.isEmpty()) {
            Log.d("AbilityProxy", "startFreeInstallAbility target ability has been installed");
            try {
                m71414h(context, c11885aM71380a, intent, false, i10);
                if ((intent.getFlags() & 2048) == 0) {
                    return;
                }
                Thread thread = new Thread(new RunnableC12638e(this, intent, i10, c11885aM71380a, context));
                thread.setUncaughtExceptionHandler(new b(null));
                thread.start();
                return;
            } catch (SecurityException unused) {
                Log.e("AbilityProxy", "startFreeInstallAbility startLocalAbility failed");
                return;
            }
        }
        Log.d("AbilityProxy", "startFreeInstallAbility begin AlertDialog");
        Intent intent2 = new Intent(context, (Class<?>) AlertDialogActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("dialogName", 1);
        bundle.putInt("requestCode", i10);
        bundle.putParcelable("abilityData", c11885aM71380a);
        bundle.putParcelable("abilityIntent", intent);
        intent2.putExtras(bundle);
        intent2.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        context.startActivity(intent2);
    }

    /* renamed from: t */
    public final List<C11896l> m71424t(Intent intent) {
        if (intent.getBooleanExtra("ohos.extra.param.key.INSTALL_ON_DEMAND", false)) {
            intent.putExtra("ohos.extra.param.key.INSTALL_ON_DEMAND", false);
        }
        intent.removeFlags(2048);
        return m71422q(intent);
    }

    /* renamed from: v */
    public final C11896l m71425v(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ArrayList<C11896l> arrayListM71422q = m71422q(intent);
        if (arrayListM71422q.size() == 1) {
            return arrayListM71422q.get(0);
        }
        Log.e("AbilityProxy", "selectAbilityFromBms infos size is not 1, cause error");
        return null;
    }

    /* renamed from: w */
    public final void m71426w(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i10;
        a aVar = new a(this);
        IBinder iBinderM76173a = C12646m.m76173a();
        if (iBinderM76173a == null) {
            Log.e("AbilityProxy", "upgradeCheck getBmsProxy failed");
        } else {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
            C11897l0 c11897l0 = new C11897l0(intent);
            parcelObtain.writeInt(1);
            c11897l0.writeToParcel(parcelObtain, 0);
            parcelObtain.writeStrongBinder(aVar.asBinder());
            try {
                try {
                    iBinderM76173a.transact(75, parcelObtain, parcelObtain2, 0);
                    i10 = parcelObtain2.readInt();
                } catch (RemoteException e10) {
                    Log.e("AbilityProxy", "upgradeCheck transact accur exception:" + e10.getMessage());
                }
                if (i10 == 0) {
                    return;
                }
                Log.e("AbilityProxy", "upgradeCheck failed, result is" + i10);
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        Log.e("AbilityProxy", "upgradeCheckAndInstallPageAbility upgradeCheck fail");
        aVar.mo71403a(5, "");
    }
}
