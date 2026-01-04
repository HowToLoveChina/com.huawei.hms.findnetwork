package p292fn;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import cn.C1461a;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.PushPublicKey;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import p015ak.C0213f;
import p015ak.C0214f0;
import p371ik.C10527a;
import p372ip.C10586d;
import p616rk.C12515a;

/* renamed from: fn.i */
/* loaded from: classes6.dex */
public class C9736i {

    /* renamed from: a */
    public String f47987a;

    /* renamed from: b */
    public String f47988b;

    /* renamed from: c */
    public String f47989c;

    /* renamed from: d */
    public SharedPreferences f47990d;

    /* renamed from: fn.i$b */
    public static class b {

        /* renamed from: a */
        public static C9736i f47991a = new C9736i();
    }

    public /* synthetic */ C9736i(a aVar) {
        this();
    }

    /* renamed from: c */
    public static C9736i m60781c() {
        return b.f47991a;
    }

    /* renamed from: a */
    public void m60782a() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C1461a.m8358e("PushPublicKeyManager", "context is null");
            return;
        }
        C1461a.m8359i("PushPublicKeyManager", "clearPublicKeySPData");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(contextM1377a, "pushPublicKeyFile", 0);
        if (sharedPreferencesM1382b == null) {
            C1461a.m8358e("PushPublicKeyManager", "sp is null");
        } else {
            sharedPreferencesM1382b.edit().clear().apply();
        }
    }

    /* renamed from: b */
    public final String m60783b(String str) {
        str.hashCode();
        switch (str) {
            case "syncV2":
                return this.f47988b;
            case "sync":
                return this.f47987a;
            case "album":
                return this.f47989c;
            default:
                C1461a.m8360w("PushPublicKeyManager", "invalid key.");
                return "";
        }
    }

    /* renamed from: d */
    public String m60784d(Context context, String str) {
        String strM60783b = "";
        if (context == null || TextUtils.isEmpty(str)) {
            C1461a.m8360w("PushPublicKeyManager", "invalid params.");
            return "";
        }
        try {
            m60786f(context);
            strM60783b = m60783b(str);
            if (TextUtils.isEmpty(strM60783b)) {
                m60785e(context);
                strM60783b = m60783b(str);
            }
            if (TextUtils.isEmpty(strM60783b)) {
                C1461a.m8359i("PushPublicKeyManager", str + " is empty");
            }
        } catch (Exception e10) {
            C1461a.m8358e("PushPublicKeyManager", "getPublicKey error:" + e10);
        }
        return strM60783b;
    }

    /* renamed from: e */
    public final void m60785e(Context context) {
        C1461a.m8359i("PushPublicKeyManager", "getPublicKeyFromOM start");
        C9733f c9733fM60705z = C9733f.m60705z();
        HiCloudSysParamMap hiCloudSysParamMapM60757p = c9733fM60705z.m60757p();
        PushPublicKey pushPublicKey = hiCloudSysParamMapM60757p != null ? (PushPublicKey) C10527a.m64629g(hiCloudSysParamMapM60757p.getPushPublicKeys(), PushPublicKey.class) : null;
        if (pushPublicKey == null || TextUtils.isEmpty(pushPublicKey.getSync()) || TextUtils.isEmpty(pushPublicKey.getSyncV2()) || TextUtils.isEmpty(pushPublicKey.getAlbum())) {
            C1461a.m8360w("PushPublicKeyManager", "getPublicKeyFromOM ： localData is empty");
            C10586d c10586d = new C10586d();
            if (Looper.myLooper() == Looper.getMainLooper()) {
                C12515a.m75110o().m75172d(c10586d);
            } else {
                C1461a.m8360w("PushPublicKeyManager", "getPublicKeyFromOM ： sync query");
                c10586d.call();
                HiCloudSysParamMap hiCloudSysParamMapM60757p2 = c9733fM60705z.m60757p();
                if (hiCloudSysParamMapM60757p2 != null) {
                    pushPublicKey = (PushPublicKey) C10527a.m64629g(hiCloudSysParamMapM60757p2.getPushPublicKeys(), PushPublicKey.class);
                }
            }
        }
        if (pushPublicKey != null) {
            C1461a.m8357d("PushPublicKeyManager", "putPublicKeyOM:" + pushPublicKey);
            String sync = pushPublicKey.getSync();
            this.f47987a = sync;
            m60787g(context, "sync", sync);
            String syncV2 = pushPublicKey.getSyncV2();
            this.f47988b = syncV2;
            m60787g(context, "syncV2", syncV2);
            String album = pushPublicKey.getAlbum();
            this.f47989c = album;
            m60787g(context, PowerKitApplyUtil.GROUP_ALBUM, album);
        }
        C1461a.m8359i("PushPublicKeyManager", "getPublicKeyFromOM end");
    }

    /* renamed from: f */
    public final void m60786f(Context context) {
        if (TextUtils.isEmpty(this.f47987a) || TextUtils.isEmpty(this.f47988b) || TextUtils.isEmpty(this.f47989c)) {
            if (this.f47990d == null) {
                this.f47990d = C0214f0.m1382b(context, "pushPublicKeyFile", 0);
            }
            SharedPreferences sharedPreferences = this.f47990d;
            if (sharedPreferences == null) {
                return;
            }
            this.f47987a = sharedPreferences.getString("sync", "");
            this.f47988b = this.f47990d.getString("syncV2", "");
            this.f47989c = this.f47990d.getString(PowerKitApplyUtil.GROUP_ALBUM, "");
        }
    }

    /* renamed from: g */
    public void m60787g(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            C1461a.m8360w("PushPublicKeyManager", "invalid params.");
            return;
        }
        try {
            if (this.f47990d == null) {
                this.f47990d = C0214f0.m1382b(context, "pushPublicKeyFile", 0);
            }
            SharedPreferences sharedPreferences = this.f47990d;
            if (sharedPreferences == null) {
                return;
            }
            sharedPreferences.edit().putString(str, str2).apply();
        } catch (Exception e10) {
            C1461a.m8358e("PushPublicKeyManager", "putPublicKey error:" + e10);
        }
    }

    public C9736i() {
        this.f47987a = "";
        this.f47988b = "";
        this.f47989c = "";
        this.f47990d = null;
    }
}
