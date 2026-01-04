package com.huawei.android.remotecontrol.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import bf.C1175a;
import eg.AbstractC9478g;
import fk.C9721b;
import gp.C10028c;
import ng.C11697d;
import p015ak.C0209d;
import p520of.C11860j;
import p616rk.C12515a;
import p677ue.C13168a;
import p709vj.C13452e;
import p739wg.C13605a;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* loaded from: classes4.dex */
public class PhoneFinderProvider extends ContentProvider {

    /* renamed from: a */
    public Context f20030a;

    /* renamed from: com.huawei.android.remotecontrol.provider.PhoneFinderProvider$a */
    public class C4384a extends AbstractC9478g {
        public C4384a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11697d.m69760e().m69761d();
        }
    }

    /* renamed from: a */
    public static void m26457a(Context context, String str, Bundle bundle) {
        if (context == null) {
            C13981a.m83988e("PhoneFinderProvider", "context is null");
            return;
        }
        if (bundle == null) {
            C13981a.m83988e("PhoneFinderProvider", "bundle is null");
            return;
        }
        boolean zM79182k = C13168a.m79182k();
        C13981a.m83989i("PhoneFinderProvider", "isNeedOpenBluetooth,isBluetoothOpen:" + zM79182k);
        bundle.putBoolean("isNeedOpenBluetooth", zM79182k ^ true);
    }

    /* renamed from: b */
    public static void m26458b(Context context, String str, Bundle bundle) {
        C13981a.m83989i("PhoneFinderProvider", "queryPhoneFinderStatus");
        if (context == null) {
            C13981a.m83988e("PhoneFinderProvider", "context null");
            return;
        }
        if (!C13452e.m80781L().m80842P0() || !C13452e.m80781L().m80971t0().equals(str)) {
            bundle.putBoolean("isPhoneFinderOpen", false);
            bundle.putBoolean("isPhoneFinderCanOpen", false);
            return;
        }
        if (C1175a.m7389k(context)) {
            if (TextUtils.equals(str, AbstractC12139d.m72766e(context).getUserID())) {
                bundle.putBoolean("isPhoneFinderOpen", true);
                return;
            }
            C13981a.m83990w("PhoneFinderProvider", "queryPhoneFinderStatus uid not same");
        }
        bundle.putBoolean("isPhoneFinderOpen", false);
        bundle.putBoolean("isPhoneFinderCanOpen", C10028c.m62182c0().m62395t1("funcfg_find_my_phone_globe"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        boolean z10;
        C0209d.m1247e(getContext());
        Bundle bundle2 = new Bundle();
        String callingPackage = getCallingPackage();
        if (!"com.huawei.android.findmyphone".equalsIgnoreCase(callingPackage) || !C13605a.m81797e(getContext(), callingPackage)) {
            C13981a.m83988e("PhoneFinderProvider", "Calling app is not from SLAVE;");
            return bundle2;
        }
        C13981a.m83989i("PhoneFinderProvider", "PhoneFinderProvider, method: " + str);
        str.hashCode();
        z10 = false;
        switch (str) {
            case "isNeedOpenBluetooth":
                m26457a(this.f20030a, str2, bundle2);
                return bundle2;
            case "updatePublicKey":
                C13981a.m83989i("PhoneFinderProvider", "updatePublicKey");
                C11860j.m71058h1(1, null);
                return bundle2;
            case "queryStatus":
                m26458b(this.f20030a, str2, bundle2);
                return bundle2;
            case "getUserGradeCode":
                C13981a.m83989i("PhoneFinderProvider", "getUserGradeCode");
                bundle2.putString("gradeCode", C13452e.m80781L().m80790C());
                return bundle2;
            case "isLocked":
                C13981a.m83989i("PhoneFinderProvider", "isLocked");
                bundle2.putInt("isLocked", C0209d.m1301r1(this.f20030a) ? 1 : 0);
                return bundle2;
            case "isCloudOpen":
                C13981a.m83989i("PhoneFinderProvider", "isCloudOpen");
                boolean zM62355l1 = C10028c.m62182c0().m62355l1();
                C13981a.m83989i("PhoneFinderProvider", "isCloudOpen isFindPhoneEnable:" + zM62355l1);
                if (zM62355l1) {
                    boolean zM80842P0 = C13452e.m80781L().m80842P0();
                    boolean zM62221H1 = C10028c.m62182c0().m62221H1();
                    if (zM80842P0 && zM62221H1) {
                        z10 = true;
                    }
                    C13981a.m83989i("PhoneFinderProvider", "isCloudOpen isLogin:" + zM80842P0 + ", isTermAgreed:" + zM62221H1);
                    bundle2.putInt("isCloudOpen", z10 ? 2 : 1);
                } else {
                    bundle2.putInt("isCloudOpen", 0);
                }
                return bundle2;
            case "openPhoneFinder":
                if (C13452e.m80781L().m80842P0() && C13452e.m80781L().m80971t0().equals(str2)) {
                    C13981a.m83989i("PhoneFinderProvider", "openPhoneFinderInBack");
                    C11860j.m71037a1(1);
                    C11860j.m71030X0(501);
                    C11860j.m71051f0(this.f20030a, 8, true);
                }
                return bundle2;
            case "isSupportAntiTheftV3":
                boolean zM71031Y = C11860j.m71031Y();
                C13981a.m83989i("PhoneFinderProvider", "isSupportAntiTheftV3: " + zM71031Y);
                bundle2.putBoolean("isSupportAntiTheftV3", zM71031Y);
                return bundle2;
            case "openBluetooth":
                C13981a.m83989i("PhoneFinderProvider", "open bluetooth");
                C13168a.m79187p();
                return bundle2;
            case "isCloudLogin":
                C13981a.m83989i("PhoneFinderProvider", "isCloudLogin");
                boolean zM62355l12 = C10028c.m62182c0().m62355l1();
                boolean zM80842P02 = C13452e.m80781L().m80842P0();
                boolean zM62221H12 = C10028c.m62182c0().m62221H1();
                C13981a.m83989i("PhoneFinderProvider", "isCloudLogin isFinderEnable:" + zM62355l12 + ", isLogin:" + zM80842P02 + ", isTermAgreed:" + zM62221H12);
                if (zM80842P02 && zM62221H12 && zM62355l12) {
                    z10 = true;
                }
                bundle2.putBoolean("isCloudLogin", z10);
                if (z10) {
                    C12515a.m75110o().m75172d(new C4384a());
                }
                return bundle2;
            default:
                return bundle2;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f20030a = getContext();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
