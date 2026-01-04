package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.CheckResult;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.C7841t;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.pm */
/* loaded from: classes8.dex */
public class C7579pm implements InterfaceC7618qt {

    /* renamed from: a */
    protected List<ContentRecord> f35336a;

    /* renamed from: b */
    protected int f35337b;

    /* renamed from: c */
    protected InterfaceC7135fs f35338c;

    /* renamed from: d */
    protected InterfaceC7135fs f35339d;

    /* renamed from: e */
    protected Context f35340e;

    /* renamed from: f */
    private List<String> f35341f;

    /* renamed from: g */
    private List<String> f35342g;

    /* renamed from: h */
    private InterfaceC7614qp f35343h;

    /* renamed from: i */
    private InterfaceC7614qp f35344i;

    public C7579pm() {
    }

    public C7579pm(Context context, List<ContentRecord> list, boolean z10, int i10) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(list != null ? list.size() : 0);
        objArr[1] = Boolean.valueOf(z10);
        AbstractC7185ho.m43821b("ResponseProcessor", "ResponseProcessor - content records size: %d isPreContent: %s", objArr);
        this.f35340e = context.getApplicationContext();
        this.f35336a = list;
        this.f35338c = C7103es.m43094a(context);
        this.f35339d = C7104et.m43127b(context);
        this.f35337b = i10;
        this.f35343h = new C7557or(context, z10, i10);
        this.f35344i = new C7583pq(context, z10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: a */
    public CheckResult mo46779a(ContentRecord contentRecord) {
        return ((contentRecord.m41464aP() == -1 || contentRecord.m41464aP() != 3) ? this.f35343h : this.f35344i).mo46447b(contentRecord);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: b */
    public void mo46789b() {
        this.f35343h.mo46439a();
        this.f35344i.mo46439a();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: c */
    public void mo46791c() {
        if (AbstractC7760bg.m47767a(this.f35342g)) {
            AbstractC7185ho.m43820b("ResponseProcessor", "todayNoShowContentIds is empty");
            return;
        }
        ContentRecord contentRecord = new ContentRecord();
        contentRecord.m41561g(AbstractC7741ao.m47561b("yyyy-MM-dd"));
        ArrayList arrayList = new ArrayList();
        arrayList.add(ContentRecord.FC_CTRL_DATE);
        for (String str : this.f35342g) {
            this.f35338c.mo43109a(contentRecord, arrayList, str);
            this.f35339d.mo43109a(contentRecord, arrayList, str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: d */
    public void mo46792d() {
        AbstractC7185ho.m43820b("ResponseProcessor", "trimAllContents");
        this.f35343h.mo46448b();
        this.f35344i.mo46448b();
    }

    public C7579pm(Context context, boolean z10, int i10) {
        Context applicationContext = context.getApplicationContext();
        this.f35340e = applicationContext;
        this.f35343h = new C7557or(applicationContext, z10, i10);
        this.f35344i = new C7583pq(this.f35340e, z10);
    }

    /* renamed from: b */
    private void m46778b(ContentRecord contentRecord, String str) {
        String strM41493ao;
        String str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add("_id");
        arrayList.add(ContentRecord.DISPLAY_COUNT);
        arrayList.add(ContentRecord.DISPLAY_DATE);
        arrayList.add(ContentRecord.SPLASH_MEDIA_PATH);
        arrayList.add(ContentRecord.LAST_SHOW_TIME);
        arrayList.add(ContentRecord.FC_CTRL_DATE);
        if (contentRecord.m41464aP() != -1 && 2 != contentRecord.m41464aP()) {
            if (3 == contentRecord.m41464aP()) {
                this.f35339d.mo43117b(contentRecord, arrayList);
                strM41493ao = contentRecord.m41493ao();
                str2 = Constants.TPLATE_CACHE;
            }
            m46787a(str, contentRecord.m41493ao(), Constants.AR_CACHE);
        }
        this.f35338c.mo43117b(contentRecord, arrayList);
        strM41493ao = contentRecord.m41493ao();
        str2 = Constants.NORMAL_CACHE;
        m46787a(str, strM41493ao, str2);
        m46787a(str, contentRecord.m41493ao(), Constants.AR_CACHE);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: a */
    public ContentRecord mo46780a(long j10, int i10, int i11) {
        AbstractC7185ho.m43820b("ResponseProcessor", "download contents start");
        if (AbstractC7760bg.m47767a(this.f35336a)) {
            AbstractC7185ho.m43823c("ResponseProcessor", "download contents, content records is empty");
            return null;
        }
        byte[] bArrM48089b = AbstractC7796cp.m48089b(this.f35340e);
        ContentRecord contentRecordMo46438a = null;
        for (ContentRecord contentRecord : this.f35336a) {
            if (contentRecord != null) {
                InterfaceC7614qp interfaceC7614qp = (contentRecord.m41464aP() == -1 || 2 == contentRecord.m41464aP()) ? this.f35343h : 3 == contentRecord.m41464aP() ? this.f35344i : null;
                if (interfaceC7614qp != null) {
                    contentRecordMo46438a = interfaceC7614qp.mo46438a(contentRecord, i10, j10, bArrM48089b, i11);
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("download contents end, showContentId:");
        sb2.append(contentRecordMo46438a != null ? contentRecordMo46438a.m41588n() : null);
        AbstractC7185ho.m43820b("ResponseProcessor", sb2.toString());
        return contentRecordMo46438a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: a */
    public ContentRecord mo46781a(ContentRecord contentRecord, int i10, long j10) {
        return (contentRecord.m41464aP() == -1 || 2 == contentRecord.m41464aP()) ? C7103es.m43094a(this.f35340e).m43101a(contentRecord.m41588n(), contentRecord.m41585m(), i10, j10) : this.f35344i.mo46437a(contentRecord, i10, j10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: b */
    public void mo46790b(List<String> list) {
        this.f35342g = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0026  */
    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.openalliance.p169ad.p171db.bean.ContentRecord mo46782a(com.huawei.openalliance.p169ad.p171db.bean.ContentRecord r9, int r10, long r11, byte[] r13, int r14) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L4
            return r0
        L4:
            int r1 = r9.m41464aP()
            r2 = -1
            if (r1 == r2) goto L20
            r1 = 2
            int r2 = r9.m41464aP()
            if (r1 != r2) goto L13
            goto L20
        L13:
            r1 = 3
            int r2 = r9.m41464aP()
            if (r1 != r2) goto L1e
            com.huawei.openalliance.ad.qp r8 = r8.f35344i
        L1c:
            r1 = r8
            goto L23
        L1e:
            r1 = r0
            goto L23
        L20:
            com.huawei.openalliance.ad.qp r8 = r8.f35343h
            goto L1c
        L23:
            if (r1 != 0) goto L26
            return r0
        L26:
            r2 = r9
            r3 = r10
            r4 = r11
            r6 = r13
            r7 = r14
            com.huawei.openalliance.ad.db.bean.ContentRecord r8 = r1.mo46438a(r2, r3, r4, r6, r7)
            if (r8 != 0) goto L32
            goto L36
        L32:
            java.lang.String r0 = r8.m41588n()
        L36:
            java.lang.String r9 = "downloadOneContent, showContentId:%s"
            java.lang.Object[] r10 = new java.lang.Object[]{r0}
            java.lang.String r11 = "ResponseProcessor"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r11, r9, r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7579pm.mo46782a(com.huawei.openalliance.ad.db.bean.ContentRecord, int, long, byte[], int):com.huawei.openalliance.ad.db.bean.ContentRecord");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: a */
    public void mo46783a() {
        if (AbstractC7760bg.m47767a(this.f35341f)) {
            AbstractC7185ho.m43820b("ResponseProcessor", "invalidContentIds is empty");
            return;
        }
        for (String str : this.f35341f) {
            this.f35343h.mo46444a(str);
            this.f35344i.mo46444a(str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: a */
    public void mo46784a(ImageInfo imageInfo, ContentRecord contentRecord, long j10) {
        this.f35343h.mo46440a(imageInfo, contentRecord, j10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: a */
    public void mo46785a(ContentRecord contentRecord, String str) {
        m46778b(contentRecord, str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: a */
    public void mo46786a(Integer num) {
        this.f35343h.mo46443a(num);
    }

    /* renamed from: a */
    public void m46787a(String str, String str2, String str3) {
        C7841t.m48503a(this.f35340e, str, str2, str3);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7618qt
    /* renamed from: a */
    public void mo46788a(List<String> list) {
        this.f35341f = list;
    }
}
