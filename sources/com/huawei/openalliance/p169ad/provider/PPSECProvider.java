package com.huawei.openalliance.p169ad.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.inter.C7286a;
import com.huawei.openalliance.p169ad.utils.C7782cb;
import com.huawei.openalliance.p169ad.utils.C7830i;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class PPSECProvider extends ContentProvider {

    /* renamed from: a */
    private final Map<String, InterfaceC7589a> f35440a = new HashMap();

    /* renamed from: b */
    private final InterfaceC7589a f35441b = new InterfaceC7589a() { // from class: com.huawei.openalliance.ad.provider.PPSECProvider.1
        @Override // com.huawei.openalliance.p169ad.provider.InterfaceC7589a
        /* renamed from: a */
        public Bundle mo46925a(String str, Bundle bundle) {
            String strM47876a;
            Bundle bundle2 = new Bundle();
            try {
                strM47876a = C7782cb.m47876a(PPSECProvider.this.getContext());
                AbstractC7185ho.m43820b("PPSATProvider", "callingPackage " + strM47876a);
            } catch (Throwable th2) {
                bundle2.putInt(InterfaceC5323b.f24681h, 5);
                AbstractC7185ho.m43823c("PPSATProvider", "getAccessToken exception: " + th2.getClass().getSimpleName());
            }
            if (TextUtils.isEmpty(strM47876a)) {
                bundle2.putInt(InterfaceC5323b.f24681h, 2);
                return bundle2;
            }
            if (!C7830i.m48437g(PPSECProvider.this.getContext(), strM47876a)) {
                bundle2.putInt(InterfaceC5323b.f24681h, 3);
                return bundle2;
            }
            String strM44217b = C7286a.m44210a().m44217b();
            if (TextUtils.isEmpty(strM44217b)) {
                AbstractC7185ho.m43823c("PPSATProvider", "at is null.");
                bundle2.putInt(InterfaceC5323b.f24681h, 4);
                return bundle2;
            }
            bundle2.putString("accessToken", strM44217b);
            bundle2.putInt(InterfaceC5323b.f24681h, 0);
            return bundle2;
        }
    };

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        AbstractC7185ho.m43820b("PPSATProvider", "call method: " + str);
        InterfaceC7589a interfaceC7589a = this.f35440a.get(str);
        if (interfaceC7589a != null) {
            return interfaceC7589a.mo46925a(str2, bundle);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(InterfaceC5323b.f24681h, 1);
        return bundle2;
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
        this.f35440a.put("getAccessToken", this.f35441b);
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
