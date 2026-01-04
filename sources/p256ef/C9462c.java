package p256ef;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.remotecontrol.facard.model.ShareLocationCardInfo;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p015ak.C0212e0;
import p015ak.C0213f;
import p521og.C11869b;
import p809yg.C13981a;

/* renamed from: ef.c */
/* loaded from: classes4.dex */
public class C9462c {

    /* renamed from: a */
    public Context f47208a;

    /* renamed from: b */
    public ConcurrentHashMap<Long, ShareLocationCardInfo> f47209b;

    /* renamed from: ef.c$b */
    public static class b {

        /* renamed from: a */
        public static final C9462c f47210a = new C9462c();
    }

    /* renamed from: g */
    public static C9462c m59254g() {
        return b.f47210a;
    }

    /* renamed from: a */
    public void m59255a(long j10, ShareLocationCardInfo shareLocationCardInfo) {
        this.f47209b.put(Long.valueOf(j10), shareLocationCardInfo);
        m59256b(j10, shareLocationCardInfo);
    }

    /* renamed from: b */
    public final void m59256b(long j10, ShareLocationCardInfo shareLocationCardInfo) {
        ShareLocationCardInfo shareLocationCardInfo2 = new ShareLocationCardInfo();
        shareLocationCardInfo2.setUserName(C11869b.m71142i(this.f47208a, shareLocationCardInfo.getUserName()));
        shareLocationCardInfo2.setDeviceId(C11869b.m71142i(this.f47208a, shareLocationCardInfo.getDeviceId()));
        shareLocationCardInfo2.setSenderUserId(C11869b.m71142i(this.f47208a, shareLocationCardInfo.getSenderUserId()));
        shareLocationCardInfo2.setSenderDeviceType(C11869b.m71142i(this.f47208a, shareLocationCardInfo.getSenderDeviceType()));
        shareLocationCardInfo2.setRelationType(shareLocationCardInfo.getRelationType());
        C0212e0.m1372v(this.f47208a, "fa_card", String.valueOf(j10), new Gson().toJson(shareLocationCardInfo2));
    }

    /* renamed from: c */
    public void m59257c() {
        this.f47209b.clear();
        SharedPreferences sharedPreferencesM1362l = C0212e0.m1362l(this.f47208a, "fa_card");
        if (sharedPreferencesM1362l == null) {
            return;
        }
        if (sharedPreferencesM1362l.edit().clear().commit()) {
            C13981a.m83989i("FAController", "clearSP success");
        } else {
            C13981a.m83988e("FAController", "clearSP error");
        }
    }

    /* renamed from: d */
    public ShareLocationCardInfo m59258d(long j10) {
        ShareLocationCardInfo shareLocationCardInfo = this.f47209b.get(Long.valueOf(j10));
        if (shareLocationCardInfo != null) {
            return shareLocationCardInfo;
        }
        ShareLocationCardInfo shareLocationCardInfoM59259e = m59259e(j10);
        return shareLocationCardInfoM59259e != null ? this.f47209b.putIfAbsent(Long.valueOf(j10), shareLocationCardInfoM59259e) : shareLocationCardInfoM59259e;
    }

    /* renamed from: e */
    public final ShareLocationCardInfo m59259e(long j10) {
        String strM1363m = C0212e0.m1363m(this.f47208a, "fa_card", String.valueOf(j10), null);
        if (strM1363m == null) {
            return null;
        }
        ShareLocationCardInfo shareLocationCardInfo = new ShareLocationCardInfo();
        try {
            ShareLocationCardInfo shareLocationCardInfo2 = (ShareLocationCardInfo) new Gson().fromJson(strM1363m, ShareLocationCardInfo.class);
            shareLocationCardInfo.setUserName(C11869b.m71136c(this.f47208a, shareLocationCardInfo2.getUserName()));
            shareLocationCardInfo.setDeviceId(C11869b.m71136c(this.f47208a, shareLocationCardInfo2.getDeviceId()));
            shareLocationCardInfo.setSenderUserId(C11869b.m71136c(this.f47208a, shareLocationCardInfo2.getSenderUserId()));
            shareLocationCardInfo.setSenderDeviceType(C11869b.m71136c(this.f47208a, shareLocationCardInfo2.getSenderDeviceType()));
            shareLocationCardInfo.setRelationType(shareLocationCardInfo2.getRelationType());
        } catch (JsonSyntaxException unused) {
            C13981a.m83988e("FAController", "getCardInfoFromSP catch JsonSyntaxException");
        }
        return shareLocationCardInfo;
    }

    /* renamed from: f */
    public Set<Long> m59260f() {
        return this.f47209b.keySet();
    }

    /* renamed from: h */
    public final void m59261h() {
        this.f47209b.clear();
        SharedPreferences sharedPreferencesM1362l = C0212e0.m1362l(this.f47208a, "fa_card");
        if (sharedPreferencesM1362l == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : sharedPreferencesM1362l.getAll().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        ShareLocationCardInfo shareLocationCardInfo = (ShareLocationCardInfo) new Gson().fromJson(str, ShareLocationCardInfo.class);
                        ShareLocationCardInfo shareLocationCardInfo2 = new ShareLocationCardInfo();
                        shareLocationCardInfo2.setUserName(C11869b.m71136c(this.f47208a, shareLocationCardInfo.getUserName()));
                        shareLocationCardInfo2.setDeviceId(C11869b.m71136c(this.f47208a, shareLocationCardInfo.getDeviceId()));
                        shareLocationCardInfo2.setSenderUserId(C11869b.m71136c(this.f47208a, shareLocationCardInfo.getSenderUserId()));
                        shareLocationCardInfo2.setSenderDeviceType(C11869b.m71136c(this.f47208a, shareLocationCardInfo.getSenderDeviceType()));
                        shareLocationCardInfo2.setRelationType(shareLocationCardInfo.getRelationType());
                        this.f47209b.put(Long.valueOf(Long.parseLong(entry.getKey())), shareLocationCardInfo2);
                    } catch (JsonSyntaxException e10) {
                        C13981a.m83988e("FAController", "init exception:" + e10.getMessage());
                    }
                }
            }
        }
    }

    /* renamed from: i */
    public void m59262i(long j10) {
        this.f47209b.remove(Long.valueOf(j10));
        C0212e0.m1374x(this.f47208a, "fa_card", String.valueOf(j10));
    }

    /* renamed from: j */
    public void m59263j(long j10, String str, String str2, String str3) {
        ShareLocationCardInfo shareLocationCardInfo = this.f47209b.get(Long.valueOf(j10));
        if (shareLocationCardInfo == null) {
            shareLocationCardInfo = new ShareLocationCardInfo();
        }
        String strM1363m = C0212e0.m1363m(this.f47208a, "fa_card", String.valueOf(j10), null);
        if (strM1363m == null) {
            return;
        }
        try {
            Gson gson = new Gson();
            ShareLocationCardInfo shareLocationCardInfo2 = (ShareLocationCardInfo) gson.fromJson(strM1363m, ShareLocationCardInfo.class);
            if (str != null) {
                shareLocationCardInfo.setUserName(str);
                shareLocationCardInfo2.setUserName(C11869b.m71142i(this.f47208a, str));
            }
            if (str2 != null) {
                shareLocationCardInfo.setDeviceId(str2);
                shareLocationCardInfo2.setDeviceId(C11869b.m71142i(this.f47208a, str2));
            }
            if (str3 != null) {
                shareLocationCardInfo.setSenderUserId(str3);
                shareLocationCardInfo2.setSenderUserId(C11869b.m71142i(this.f47208a, str3));
            }
            this.f47209b.put(Long.valueOf(j10), shareLocationCardInfo);
            C0212e0.m1372v(this.f47208a, "fa_card", String.valueOf(j10), gson.toJson(shareLocationCardInfo2));
        } catch (JsonSyntaxException e10) {
            C13981a.m83989i("FAController", "updateCardInfo e:" + e10.getMessage());
        }
    }

    public C9462c() {
        this.f47209b = new ConcurrentHashMap<>();
        this.f47208a = C0213f.m1377a();
        m59261h();
    }
}
