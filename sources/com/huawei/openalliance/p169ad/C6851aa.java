package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.activity.ComplianceActivity;
import com.huawei.openalliance.p169ad.activity.InterfaceC6904d;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.aa */
/* loaded from: classes8.dex */
public class C6851aa extends C8251z {

    /* renamed from: d */
    private ContentRecord f31614d;

    /* renamed from: e */
    private int[] f31615e;

    /* renamed from: f */
    private int[] f31616f;

    /* renamed from: com.huawei.openalliance.ad.aa$a */
    public static class a implements InterfaceC6904d {

        /* renamed from: a */
        private String f31617a;

        /* renamed from: b */
        private RemoteCallResultCallback<String> f31618b;

        public a(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.f31618b = remoteCallResultCallback;
            this.f31617a = str;
        }

        @Override // com.huawei.openalliance.p169ad.activity.InterfaceC6904d
        /* renamed from: a */
        public void mo38575a() {
            AbstractC7185ho.m43820b("JsbStartComplianceActivity", "onActivityShow");
            AbstractC7326j.m45216a(this.f31618b, this.f31617a, 1000, 5001, false);
        }

        @Override // com.huawei.openalliance.p169ad.activity.InterfaceC6904d
        /* renamed from: b */
        public void mo38576b() {
            AbstractC7185ho.m43820b("JsbStartComplianceActivity", "onActivityFinish");
            AbstractC7326j.m45216a(this.f31618b, this.f31617a, 1000, 5002, false);
            ComplianceActivity.m38599l();
        }
    }

    public C6851aa() {
        super("pps.advertiserinfo.show");
        this.f31615e = new int[2];
        this.f31616f = new int[2];
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        try {
            if (m38574d(context, str)) {
                ComplianceActivity.m38597a(new a(remoteCallResultCallback, this.f34112a));
                ComplianceActivity.m38596a(context, this.f31615e, this.f31616f, this.f31614d, true);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("JsbStartComplianceActivity", "execute ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: d */
    public boolean m38574d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("JsbStartComplianceActivity", "parseParam: %s", str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                ContentRecord contentRecordM45224b = m45224b(context, str);
                this.f31614d = contentRecordM45224b;
                if (contentRecordM45224b != null && !AbstractC7760bg.m47767a(contentRecordM45224b.m41468aT())) {
                    int iOptInt = jSONObject.optInt("anchorViewX", -1);
                    int iOptInt2 = jSONObject.optInt("anchorViewY", -1);
                    if (-1 != iOptInt && -1 != iOptInt2) {
                        int iOptInt3 = jSONObject.optInt("anchorWidth", -1);
                        int iOptInt4 = jSONObject.optInt("anchorHeight", -1);
                        if (-1 != iOptInt3 && -1 != iOptInt4) {
                            int[] iArr = this.f31615e;
                            iArr[0] = iOptInt;
                            iArr[1] = iOptInt2;
                            int[] iArr2 = this.f31616f;
                            iArr2[0] = iOptInt3;
                            iArr2[1] = iOptInt4;
                            if (AbstractC7185ho.m43819a()) {
                                AbstractC7185ho.m43818a("JsbStartComplianceActivity", "parse param complete, anchor loc (%s, %s), anchor size (%s, %s)", Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2), Integer.valueOf(iOptInt3), Integer.valueOf(iOptInt4));
                            }
                            return true;
                        }
                        AbstractC7185ho.m43823c("JsbStartComplianceActivity", "invalid anchor size");
                        return false;
                    }
                    AbstractC7185ho.m43823c("JsbStartComplianceActivity", "invalid anchor loc");
                    return false;
                }
                AbstractC7185ho.m43823c("JsbStartComplianceActivity", "content is null or compliance is null.");
                return false;
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("JsbStartComplianceActivity", "parse param ex: %s", th2.getClass().getSimpleName());
            }
        }
        return false;
    }
}
