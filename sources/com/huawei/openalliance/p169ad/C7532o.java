package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.activity.AdComplainActivity;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.views.feedback.C8091a;
import com.huawei.openalliance.p169ad.views.feedback.InterfaceC8098h;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.o */
/* loaded from: classes8.dex */
public class C7532o extends AbstractC7326j {

    /* renamed from: d */
    private InterfaceC8098h f34992d;

    /* renamed from: com.huawei.openalliance.ad.o$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f34993a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(context, C6849R.string.hiad_feedback_had_feedback, 0).show();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.o$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f34994a;

        public AnonymousClass2(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(context, C6849R.string.hiad_feedback_reduce_such_content, 0).show();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.o$a */
    public static class a implements InterfaceC8098h {

        /* renamed from: a */
        private Context f34995a;

        /* renamed from: b */
        private ContentRecord f34996b;

        /* renamed from: c */
        private FeedbackInfo f34997c;

        /* renamed from: d */
        private String f34998d;

        /* renamed from: e */
        private RemoteCallResultCallback<String> f34999e;

        public a(Context context, ContentRecord contentRecord, FeedbackInfo feedbackInfo, RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.f34995a = context.getApplicationContext();
            this.f34996b = contentRecord;
            this.f34997c = feedbackInfo;
            this.f34999e = remoteCallResultCallback;
            this.f34998d = str;
        }

        /* renamed from: c */
        private void m46264c() {
            this.f34995a = null;
            this.f34996b = null;
            this.f34997c = null;
            this.f34999e = null;
            this.f34998d = null;
        }

        @Override // com.huawei.openalliance.p169ad.views.feedback.InterfaceC8098h
        /* renamed from: a */
        public void mo46265a() {
            Context context = this.f34995a;
            if (context == null) {
                return;
            }
            C7532o.m46263b(context, this.f34996b, 3, this.f34997c);
            AbstractC7326j.m45216a(this.f34999e, this.f34998d, 1000, 0, true);
            m46264c();
        }

        @Override // com.huawei.openalliance.p169ad.views.feedback.InterfaceC8098h
        /* renamed from: b */
        public void mo46266b() {
            if (this.f34995a == null) {
                return;
            }
            AbstractC7326j.m45216a(this.f34999e, this.f34998d, 1000, 1, true);
            m46264c();
        }
    }

    public C7532o() {
        super("pps.feedback.click");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0045 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #0 {all -> 0x0037, blocks: (B:24:0x0002, B:30:0x0031, B:33:0x0039, B:34:0x0045), top: B:39:0x0002 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m46263b(android.content.Context r6, com.huawei.openalliance.p169ad.p171db.bean.ContentRecord r7, int r8, com.huawei.openalliance.p169ad.inter.data.FeedbackInfo r9) {
        /*
            java.lang.String r0 = "JsbFeedBackClick"
            com.huawei.openalliance.ad.ou r1 = new com.huawei.openalliance.ad.ou     // Catch: java.lang.Throwable -> L37
            int r2 = r7.m41552f()     // Catch: java.lang.Throwable -> L37
            com.huawei.openalliance.ad.st r2 = com.huawei.openalliance.p169ad.C7662sk.m47225a(r6, r2)     // Catch: java.lang.Throwable -> L37
            r1.<init>(r6, r2)     // Catch: java.lang.Throwable -> L37
            r1.mo46590a(r7)     // Catch: java.lang.Throwable -> L37
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L37
            r7.<init>()     // Catch: java.lang.Throwable -> L37
            r7.add(r9)     // Catch: java.lang.Throwable -> L37
            java.lang.String r9 = "itemType is %s."
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L37
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L37
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.Throwable -> L37
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r0, r9, r3)     // Catch: java.lang.Throwable -> L37
            if (r8 == r2) goto L45
            r9 = 2
            if (r8 == r9) goto L39
            r9 = 3
            if (r8 == r9) goto L45
            java.lang.String r6 = "invalid feedback type"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r0, r6)     // Catch: java.lang.Throwable -> L37
            goto L62
        L37:
            r6 = move-exception
            goto L51
        L39:
            com.huawei.openalliance.ad.o$1 r8 = new com.huawei.openalliance.ad.o$1     // Catch: java.lang.Throwable -> L37
            r8.<init>()     // Catch: java.lang.Throwable -> L37
            com.huawei.openalliance.p169ad.utils.AbstractC7817dj.m48363a(r8)     // Catch: java.lang.Throwable -> L37
            r1.mo46604a(r7)     // Catch: java.lang.Throwable -> L37
            goto L62
        L45:
            com.huawei.openalliance.ad.o$2 r8 = new com.huawei.openalliance.ad.o$2     // Catch: java.lang.Throwable -> L37
            r8.<init>()     // Catch: java.lang.Throwable -> L37
            com.huawei.openalliance.p169ad.utils.AbstractC7817dj.m48363a(r8)     // Catch: java.lang.Throwable -> L37
            r1.mo46614b(r7)     // Catch: java.lang.Throwable -> L37
            goto L62
        L51:
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getSimpleName()
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r7 = "itemClickAction error: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r0, r7, r6)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7532o.m46263b(android.content.Context, com.huawei.openalliance.ad.db.bean.ContentRecord, int, com.huawei.openalliance.ad.inter.data.FeedbackInfo):void");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        int i10;
        String str2;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("JsbFeedBackClick", "start");
        }
        JSONObject jSONObject = new JSONObject(str);
        ContentRecord contentRecordM45224b = m45224b(context, str);
        int iOptInt = jSONObject.optInt(JsbMapKeyNames.FEEDBACK_TYPE, -111111);
        if (contentRecordM45224b != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(JsbMapKeyNames.FEEDBACK_INFO);
            FeedbackInfo feedbackInfo = (FeedbackInfo) AbstractC7758be.m47739b(jSONObjectOptJSONObject.toString(), FeedbackInfo.class, new Class[0]);
            if (feedbackInfo == null) {
                return;
            }
            long jM48146a = AbstractC7806cz.m48146a(jSONObjectOptJSONObject.optString("id"), -111111L);
            if (jM48146a != -111111) {
                feedbackInfo.m44466a(jM48146a);
                if (iOptInt == 3) {
                    a aVar = new a(context, contentRecordM45224b, feedbackInfo, remoteCallResultCallback, this.f34112a);
                    this.f34992d = aVar;
                    m46262a(context, contentRecordM45224b, feedbackInfo, aVar);
                    return;
                } else {
                    m46263b(context, contentRecordM45224b, iOptInt, feedbackInfo);
                    str2 = this.f34112a;
                    i10 = 1000;
                    AbstractC7326j.m45216a(remoteCallResultCallback, str2, i10, null, true);
                }
            }
            AbstractC7185ho.m43820b("JsbFeedBackClick", "invalid id");
            i10 = 4001;
        } else {
            AbstractC7185ho.m43817a("JsbFeedBackClick", "ad not exist");
            i10 = SNSCode.Status.GET_FRIEND_LIST_FAIL;
        }
        str2 = this.f34112a;
        AbstractC7326j.m45216a(remoteCallResultCallback, str2, i10, null, true);
    }

    /* renamed from: a */
    private boolean m46262a(Context context, ContentRecord contentRecord, FeedbackInfo feedbackInfo, InterfaceC8098h interfaceC8098h) {
        AbstractC7185ho.m43820b("JsbFeedBackClick", "click complain");
        if (feedbackInfo == null) {
            return false;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) AdComplainActivity.class);
            intent.putExtra(MapKeyNames.COMPLAIN_H5_TITLE, feedbackInfo.getLabel());
            AdComplainActivity.m38585a(new C8091a(context, contentRecord, interfaceC8098h));
            if (!(context instanceof Activity)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            AbstractC7811dd.m48294a(context, intent);
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("JsbFeedBackClick", "start ac failed: %s", th2.getClass().getSimpleName());
            return true;
        }
    }
}
