package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.C7306i;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.az */
/* loaded from: classes8.dex */
public class C6948az extends AbstractC6912ag {

    /* renamed from: com.huawei.openalliance.ad.az$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int[] f31992a;

        /* renamed from: b */
        final /* synthetic */ Context f31993b;

        /* renamed from: c */
        final /* synthetic */ String f31994c;

        /* renamed from: d */
        final /* synthetic */ C7306i f31995d;

        /* renamed from: e */
        final /* synthetic */ RemoteCallResultCallback f31996e;

        public AnonymousClass1(int[] iArr, Context context, String str, C7306i c7306i, RemoteCallResultCallback remoteCallResultCallback) {
            iArr = iArr;
            context = context;
            str = str;
            c7306i = c7306i;
            remoteCallResultCallback = remoteCallResultCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                iArr[0] = C6948az.this.m38796e(context, str).mo42478a(context, c7306i);
            } catch (Throwable unused) {
            }
            AbstractC7326j.m45216a(remoteCallResultCallback, C6948az.this.f34112a, 1000, Integer.valueOf(iArr[0]), true);
        }
    }

    public C6948az() {
        super("pps.download.start");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b != null) {
            boolean zOptBoolean = new JSONObject(str).optBoolean(JsbMapKeyNames.ALLOWED_NON_WIFI_NETWORK, false);
            if (!m45223a(context, contentRecordM45224b)) {
                AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, SNSCode.Status.GET_GROUP_MEM_LIST_FAIL, null, true);
                return;
            }
            int[] iArr = {-1};
            C7306i c7306iM38794a = m38794a(contentRecordM45224b);
            if (c7306iM38794a != null) {
                if (c7306iM38794a.getAppInfo() != null) {
                    c7306iM38794a.getAppInfo().setAllowedNonWifiNetwork(zOptBoolean);
                }
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.az.1

                    /* renamed from: a */
                    final /* synthetic */ int[] f31992a;

                    /* renamed from: b */
                    final /* synthetic */ Context f31993b;

                    /* renamed from: c */
                    final /* synthetic */ String f31994c;

                    /* renamed from: d */
                    final /* synthetic */ C7306i f31995d;

                    /* renamed from: e */
                    final /* synthetic */ RemoteCallResultCallback f31996e;

                    public AnonymousClass1(int[] iArr2, Context context2, String str2, C7306i c7306iM38794a2, RemoteCallResultCallback remoteCallResultCallback2) {
                        iArr = iArr2;
                        context = context2;
                        str = str2;
                        c7306i = c7306iM38794a2;
                        remoteCallResultCallback = remoteCallResultCallback2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            iArr[0] = C6948az.this.m38796e(context, str).mo42478a(context, c7306i);
                        } catch (Throwable unused) {
                        }
                        AbstractC7326j.m45216a(remoteCallResultCallback, C6948az.this.f34112a, 1000, Integer.valueOf(iArr[0]), true);
                    }
                });
                return;
            }
        }
        AbstractC7326j.m45216a(remoteCallResultCallback2, this.f34112a, SNSCode.Status.GET_FRIEND_LIST_FAIL, null, true);
    }
}
