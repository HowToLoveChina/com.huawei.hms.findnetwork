package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.openalliance.p169ad.constant.ConfigMapKeys;
import com.huawei.openalliance.p169ad.utils.C7845x;

/* renamed from: com.huawei.openalliance.ad.fg */
/* loaded from: classes8.dex */
public class C7123fg implements InterfaceC7145gb {

    /* renamed from: a */
    private static final byte[] f32841a = new byte[0];

    /* renamed from: c */
    private static InterfaceC7145gb f32842c;

    /* renamed from: b */
    private final Context f32843b;

    private C7123fg(Context context) {
        this.f32843b = C7845x.m48571i(context.getApplicationContext());
    }

    /* renamed from: a */
    public static InterfaceC7145gb m43308a(Context context) {
        return m43309b(context);
    }

    /* renamed from: e */
    private SharedPreferences m43310e(String str) {
        return this.f32843b.getSharedPreferences("hiad_slot_cfg_" + str, 0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7145gb
    /* renamed from: b */
    public int mo43313b(String str) {
        return m43310e(str).getInt("recommendPath", 0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7145gb
    /* renamed from: c */
    public boolean mo43314c(String str) {
        return m43310e(str).getBoolean(ConfigMapKeys.CLICK_VALID_CTRL, false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7145gb
    /* renamed from: d */
    public int mo43315d(String str) {
        return m43310e(str).getInt("resultAdReqType", 0);
    }

    /* renamed from: b */
    private static InterfaceC7145gb m43309b(Context context) {
        InterfaceC7145gb interfaceC7145gb;
        synchronized (f32841a) {
            try {
                if (f32842c == null) {
                    f32842c = new C7123fg(context);
                }
                interfaceC7145gb = f32842c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7145gb;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003a  */
    @Override // com.huawei.openalliance.p169ad.InterfaceC7145gb
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo43311a(java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r4 = this;
            android.content.SharedPreferences r4 = r4.m43310e(r5)
            android.content.SharedPreferences$Editor r4 = r4.edit()
            java.lang.String r5 = "deAdRecmdEbl"
            java.lang.Object r5 = r6.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Integer r5 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48178h(r5)
            java.lang.String r0 = "fsdkDeRcmdWay"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Integer r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48178h(r0)
            java.lang.String r1 = "1"
            java.lang.String r2 = "clickValidCtrl"
            java.lang.Object r3 = r6.get(r2)
            boolean r1 = r1.equals(r3)
            r4.putBoolean(r2, r1)
            r1 = 0
            if (r5 == 0) goto L3a
            int r5 = r5.intValue()
            r2 = 1
            if (r5 != r2) goto L3a
            goto L3b
        L3a:
            r2 = r1
        L3b:
            java.lang.String r5 = "recommendEnabled"
            r4.putBoolean(r5, r2)
            if (r0 == 0) goto L47
            int r5 = r0.intValue()
            goto L48
        L47:
            r5 = r1
        L48:
            java.lang.String r0 = "recommendPath"
            r4.putInt(r0, r5)
            java.lang.String r5 = "resultAdReqType"
            java.lang.Object r6 = r6.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48145a(r6, r1)
            r4.putInt(r5, r6)
            r4.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7123fg.mo43311a(java.lang.String, java.util.Map):void");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7145gb
    /* renamed from: a */
    public boolean mo43312a(String str) {
        return m43310e(str).getBoolean("recommendEnabled", false);
    }
}
