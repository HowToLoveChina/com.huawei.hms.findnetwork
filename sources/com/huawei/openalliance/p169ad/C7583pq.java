package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.analysis.C6923d;
import com.huawei.openalliance.p169ad.beans.metadata.CheckResult;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.MotionData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.CreativeType;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7801cu;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.pq */
/* loaded from: classes8.dex */
public class C7583pq extends C7557or {

    /* renamed from: e */
    private Context f35361e;

    /* renamed from: f */
    private C7126fj f35362f;

    /* renamed from: g */
    private InterfaceC7140fx f35363g;

    /* renamed from: h */
    private boolean f35364h;

    /* renamed from: i */
    private String f35365i;

    public C7583pq(Context context, boolean z10) {
        super(context, z10, -1);
        this.f35365i = "3";
        this.f35361e = context;
        this.f35363g = C7118fb.m43196a(context);
        this.f35362f = new C7126fj(context);
        this.f35364h = z10;
    }

    /* renamed from: c */
    private int m46840c(ContentRecord contentRecord) {
        if (contentRecord.m41469aU() != null && contentRecord.m41469aU().m40549a() != null) {
            try {
                JSONArray jSONArray = new JSONArray(contentRecord.m41469aU().m40549a());
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    if (!jSONObject.isNull("videoDwnNetwork")) {
                        return jSONObject.optInt("videoDwnNetwork");
                    }
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43821b("TemplateContentProcessor", "getDownNetwork err: %s", th2.getClass().getSimpleName());
            }
        }
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.C7557or, com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: b */
    public CheckResult mo46447b(ContentRecord contentRecord) {
        if (contentRecord == null || AbstractC7806cz.m48165b(contentRecord.m41463aO()) || AbstractC7760bg.m47767a(contentRecord.m41471aW())) {
            return new CheckResult(false, "spareRecord is null", "");
        }
        ArrayList arrayList = new ArrayList();
        for (Asset asset : contentRecord.m41471aW()) {
            if (asset != null) {
                String strM41585m = contentRecord.m41585m();
                if (asset.m40516d() != null) {
                    if (!m46836a(strM41585m, contentRecord, asset, C7752az.m47696b(this.f35361e, asset.m40516d().m40573a()), (C7653sb) null)) {
                        return new CheckResult(false, "asset img not exist", "");
                    }
                } else if (asset.m40517e() != null && !m46836a(strM41585m, contentRecord, asset, asset.m40517e().m40595a(), (C7653sb) null)) {
                    return new CheckResult(false, "asset video not exist", "");
                }
                arrayList.add(asset);
            }
        }
        contentRecord.m41584l(arrayList);
        this.f35362f.m43503a(contentRecord, arrayList, contentRecord.m41469aU());
        AbstractC7185ho.m43820b("TemplateContentProcessor", "spare exists");
        return new CheckResult(true, "assets exists", "null", contentRecord.m41423U());
    }

    /* renamed from: b */
    private String m46837b(String str) {
        String str2 = this.f35365i;
        List<ContentResource> listMo43142c = C7105eu.m43130a(this.f35361e).mo43142c(AbstractC7801cu.m48126a(str), Constants.TPLATE_CACHE);
        return (AbstractC7760bg.m47767a(listMo43142c) || listMo43142c.get(0) == null) ? str2 : String.valueOf(listMo43142c.get(0).m41639g());
    }

    /* renamed from: c */
    private boolean m46841c(String str) {
        try {
            return new JSONObject(str).optInt("optional", 0) == 1;
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("TemplateContentProcessor", "isOptional err: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7557or, com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: a */
    public ContentRecord mo46437a(ContentRecord contentRecord, int i10, long j10) {
        return this.f35362f.m43497a(contentRecord, i10, j10);
    }

    @Override // com.huawei.openalliance.p169ad.C7557or, com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: a */
    public ContentRecord mo46438a(ContentRecord contentRecord, int i10, long j10, byte[] bArr, int i11) {
        Asset asset;
        C7653sb c7653sb;
        AbstractC7185ho.m43820b("TemplateContentProcessor", "downloadElements start");
        ContentRecord contentRecord2 = null;
        if (contentRecord == null || AbstractC7806cz.m48165b(contentRecord.m41463aO()) || AbstractC7760bg.m47767a(contentRecord.m41471aW())) {
            return null;
        }
        String strM41588n = contentRecord.m41588n();
        int iM46840c = m46840c(contentRecord);
        String strM48205a = AbstractC7807d.m48205a(i11);
        this.f35365i = strM48205a;
        contentRecord.m41599q(strM48205a);
        ArrayList arrayList = new ArrayList();
        String strM46830a = strM41588n;
        for (Asset asset2 : contentRecord.m41471aW()) {
            if (asset2 != null) {
                if (asset2.m40516d() != null) {
                    C7653sb c7653sbM46826a = m46826a(asset2, j10, contentRecord.m41427W());
                    if (c7653sbM46826a == null) {
                        return contentRecord2;
                    }
                    String strM47696b = C7752az.m47696b(this.f35361e, asset2.m40516d().m40573a());
                    c7653sbM46826a.m47187d(strM47696b);
                    asset = asset2;
                    if (m46836a(contentRecord.m41585m(), contentRecord, asset2, strM47696b, c7653sbM46826a)) {
                        arrayList.add(asset);
                        if (AbstractC7185ho.m43819a()) {
                            AbstractC7185ho.m43818a("TemplateContentProcessor", "asset img path: %s", asset.m40519g());
                        }
                    } else {
                        c7653sb = c7653sbM46826a;
                        c7653sb.m47188d(true);
                        c7653sb.m47178b(Integer.valueOf(this.f35365i));
                        strM46830a = m46830a(contentRecord, strM46830a, arrayList, asset, c7653sb);
                    }
                } else {
                    asset = asset2;
                    if (asset.m40517e() != null) {
                        C7653sb c7653sbM46825a = m46825a(asset, j10);
                        if (m46836a(contentRecord.m41585m(), contentRecord, asset, asset.m40517e().m40595a(), c7653sbM46825a)) {
                            arrayList.add(asset);
                            if (AbstractC7185ho.m43819a()) {
                                AbstractC7185ho.m43818a("TemplateContentProcessor", "asset video path: %s", asset.m40519g());
                            }
                        } else {
                            c7653sb = c7653sbM46825a;
                            c7653sb.m47188d(true);
                            c7653sb.m47178b(Integer.valueOf(this.f35365i));
                            if (!m46446a(iM46840c)) {
                                C6923d.m39131a(this.f35361e, contentRecord);
                                AbstractC7185ho.m43820b("TemplateContentProcessor", "video content can only download in wifi");
                                return null;
                            }
                            strM46830a = m46830a(contentRecord, strM46830a, arrayList, asset, c7653sb);
                        }
                    } else {
                        arrayList.add(asset);
                    }
                }
            }
            contentRecord2 = null;
        }
        contentRecord.m41584l(arrayList);
        TemplateData templateDataM41469aU = contentRecord.m41469aU();
        ContentRecord contentRecordM46824a = m46824a(contentRecord, i10, bArr, strM46830a, arrayList, templateDataM41469aU, m46832a(contentRecord, j10, i11, iM46840c, templateDataM41469aU));
        AbstractC7185ho.m43821b("TemplateContentProcessor", "downloadElements end, showContentId = %s", strM46830a);
        return contentRecordM46824a;
    }

    @Override // com.huawei.openalliance.p169ad.C7557or, com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: b */
    public void mo46448b() {
        List<ContentRecord> listM43504b = this.f35362f.m43504b();
        if (AbstractC7760bg.m47767a(listM43504b)) {
            AbstractC7185ho.m43820b("TemplateContentProcessor", "trimAllContents, cacheContents is empty.");
            return;
        }
        for (ContentRecord contentRecord : listM43504b) {
            if (contentRecord != null && !AbstractC7760bg.m47767a(contentRecord.m41471aW())) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("TemplateContentProcessor", "begin check %s, %s", contentRecord.m41588n(), contentRecord.m41463aO());
                }
                for (Asset asset : contentRecord.m41471aW()) {
                    if (asset != null && (asset.m40516d() != null || asset.m40517e() != null)) {
                        if (AbstractC7185ho.m43819a()) {
                            AbstractC7185ho.m43818a("TemplateContentProcessor", "check asset, %s %s", asset.m40512b(), asset.m40520h());
                        }
                        if (m46841c(asset.m40520h())) {
                            AbstractC7185ho.m43820b("TemplateContentProcessor", "is optional");
                        } else if (asset.m40516d() != null) {
                            if (!m46836a(contentRecord.m41585m(), contentRecord, asset, C7752az.m47696b(this.f35361e, asset.m40516d().m40573a()), (C7653sb) null)) {
                                this.f35362f.m43502a(contentRecord, "media not valid");
                                if (AbstractC7185ho.m43819a()) {
                                    AbstractC7185ho.m43818a("TemplateContentProcessor", "img is valid: %s", asset.m40516d().m40573a());
                                }
                            }
                        } else if (asset.m40517e() != null && !m46836a(contentRecord.m41585m(), contentRecord, asset, asset.m40517e().m40595a(), (C7653sb) null)) {
                            this.f35362f.m43502a(contentRecord, "media not valid");
                            if (AbstractC7185ho.m43819a()) {
                                AbstractC7185ho.m43818a("TemplateContentProcessor", "video is valid: %s", asset.m40517e().m40595a());
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private ContentRecord m46824a(ContentRecord contentRecord, int i10, byte[] bArr, String str, List<Asset> list, TemplateData templateData, boolean z10) {
        if (str == null || !z10) {
            return null;
        }
        contentRecord.m41857a(bArr);
        contentRecord.m41612v(UUID.randomUUID().toString());
        contentRecord.m41408M(this.f35362f.m43498a(contentRecord.m41585m(), contentRecord.m41463aO()));
        if (1 == i10) {
            contentRecord.m41553f(720);
            contentRecord.m41559g(1080);
        } else {
            contentRecord.m41553f(1080);
            contentRecord.m41559g(720);
        }
        contentRecord.m41578k(CreativeType.SPLASH_TEMPLATE_AD);
        this.f35362f.m43503a(contentRecord, list, templateData);
        return contentRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m46838b(ContentRecord contentRecord, Asset asset, String str, C7653sb c7653sb) {
        String strM46828a = m46828a(this.f35361e, contentRecord, str, Constants.TPLATE_CACHE, c7653sb);
        if (!TextUtils.isEmpty(strM46828a)) {
            if (asset != null) {
                asset.m40513b(strM46828a);
            }
            AbstractC7185ho.m43821b("TemplateContentProcessor", "tplate isExistLocal: %s", AbstractC7819dl.m48375a(strM46828a));
            return true;
        }
        String strM46828a2 = m46828a(this.f35361e, contentRecord, str, Constants.NORMAL_CACHE, c7653sb);
        if (TextUtils.isEmpty(strM46828a2)) {
            return false;
        }
        if (asset != null) {
            asset.m40513b(strM46828a2);
        }
        AbstractC7185ho.m43821b("TemplateContentProcessor", "normal isExistLocal: %s", AbstractC7819dl.m48375a(strM46828a2));
        return true;
    }

    /* renamed from: a */
    private C7653sb m46825a(Asset asset, long j10) {
        if (asset == null || asset.m40517e() == null) {
            return null;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47187d(asset.m40517e().m40595a());
        c7653sb.m47184c(asset.m40517e().m40610f());
        c7653sb.m47181b(asset.m40517e().m40612h() == 0);
        c7653sb.m47185c(true);
        c7653sb.m47171a(Long.valueOf(j10));
        return c7653sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m46839b(ContentRecord contentRecord, TemplateData templateData, long j10, int i10, int i11) {
        if (templateData == null || AbstractC7760bg.m47767a(templateData.m40554c())) {
            return true;
        }
        boolean z10 = true;
        for (MotionData motionData : templateData.m40554c()) {
            C7653sb c7653sbM46827a = m46827a(motionData, j10);
            c7653sbM46827a.m47169a(contentRecord);
            if (motionData == null || !m46836a(contentRecord.m41585m(), (ContentRecord) null, (Asset) null, motionData.m40539g(), c7653sbM46827a)) {
                if (m46446a(i10)) {
                    c7653sbM46827a.m47188d(true);
                    c7653sbM46827a.m47178b(Integer.valueOf(AbstractC7807d.m48205a(i11)));
                    if (AbstractC7806cz.m48165b(m46829a(contentRecord, c7653sbM46827a, false))) {
                        AbstractC7185ho.m43821b("TemplateContentProcessor", "motionDataId %s is Download failed, Because filePath is blank!", Long.valueOf(motionData.m40524a()));
                    }
                } else {
                    AbstractC7185ho.m43821b("TemplateContentProcessor", "motionDataId %s is Download failed, Because network can not download!", Long.valueOf(motionData.m40524a()));
                }
                z10 = false;
            }
        }
        AbstractC7185ho.m43821b("TemplateContentProcessor", "downMotionSuccessFlag is %s", Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: a */
    private C7653sb m46826a(Asset asset, long j10, String str) {
        if (asset == null || asset.m40516d() == null) {
            return null;
        }
        if (this.f35364h && AbstractC7558os.m46462a(str) && !C7775bv.m47829c(this.f35361e)) {
            AbstractC7185ho.m43820b("TemplateContentProcessor", "pre content only download in wifi");
            return null;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47187d(asset.m40516d().m40573a());
        c7653sb.m47184c(asset.m40516d().m40581d() != null ? asset.m40516d().m40581d().m40587b() : null);
        c7653sb.m47181b(asset.m40516d().m40581d() == null || asset.m40516d().m40581d().m40590d() == 0);
        c7653sb.m47185c(true);
        c7653sb.m47171a(Long.valueOf(j10));
        return c7653sb;
    }

    /* renamed from: a */
    private C7653sb m46827a(MotionData motionData, long j10) {
        if (motionData == null) {
            return null;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47187d(motionData.m40539g());
        c7653sb.m47184c(motionData.m40540h());
        c7653sb.m47181b(true);
        c7653sb.m47185c(true);
        c7653sb.m47190e(Constants.TPLATE_CACHE);
        c7653sb.m47171a(Long.valueOf(j10));
        return c7653sb;
    }

    /* renamed from: a */
    private String m46828a(Context context, ContentRecord contentRecord, String str, String str2, C7653sb c7653sb) {
        C7022dk c7022dkM41937a = C7019dh.m41937a(context, str2);
        String strM41970e = c7022dkM41937a.m41970e(C7752az.m47696b(context, str));
        String strM41968c = c7022dkM41937a.m41968c(strM41970e);
        if (!AbstractC7731ae.m47458b(strM41968c)) {
            return null;
        }
        if (contentRecord != null) {
            contentRecord.m41599q(m46837b(str));
            if (c7653sb != null) {
                c7653sb.m47169a(contentRecord);
            }
        }
        C7652sa.m47165a(context, strM41970e, c7022dkM41937a, c7653sb, str2);
        return strM41968c;
    }

    /* renamed from: a */
    private String m46829a(ContentRecord contentRecord, C7653sb c7653sb, boolean z10) {
        if (c7653sb != null) {
            c7653sb.m47169a(contentRecord);
            c7653sb.m47185c(true);
            c7653sb.m47190e(Constants.TPLATE_CACHE);
            C7654sc c7654scMo43274a = this.f35363g.mo43274a(c7653sb);
            if (c7654scMo43274a != null) {
                return c7654scMo43274a.m47207a();
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m46830a(ContentRecord contentRecord, String str, List<Asset> list, Asset asset, C7653sb c7653sb) {
        String strM41968c = C7019dh.m41937a(this.f35361e, Constants.TPLATE_CACHE).m41968c(m46829a(contentRecord, c7653sb, true));
        if (!AbstractC7806cz.m48165b(strM41968c)) {
            asset.m40513b(strM41968c);
        } else if (!m46841c(asset.m40520h())) {
            str = null;
        }
        list.add(asset);
        return str;
    }

    @Override // com.huawei.openalliance.p169ad.C7557or, com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: a */
    public void mo46439a() {
        List<ContentRecord> listM43499a = this.f35362f.m43499a();
        if (AbstractC7760bg.m47767a(listM43499a)) {
            return;
        }
        Iterator<ContentRecord> it = listM43499a.iterator();
        while (it.hasNext()) {
            mo46441a(it.next());
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7557or
    /* renamed from: a */
    public void mo46441a(ContentRecord contentRecord) {
        if (contentRecord == null) {
            AbstractC7185ho.m43826d("TemplateContentProcessor", "fail to delete content, content is null");
        } else {
            this.f35362f.m43501a(contentRecord);
        }
    }

    /* renamed from: a */
    private void m46831a(final ContentRecord contentRecord, final TemplateData templateData, final long j10, final int i10, final int i11) {
        AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.pq.4
            @Override // java.lang.Runnable
            public void run() {
                C7583pq.this.m46839b(contentRecord, templateData, j10, i10, i11);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.C7557or, com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: a */
    public void mo46444a(String str) {
        List<ContentRecord> listM43500a = this.f35362f.m43500a(str);
        if (AbstractC7760bg.m47767a(listM43500a)) {
            return;
        }
        Iterator<ContentRecord> it = listM43500a.iterator();
        while (it.hasNext()) {
            mo46441a(it.next());
        }
    }

    /* renamed from: a */
    private boolean m46832a(ContentRecord contentRecord, long j10, int i10, int i11, TemplateData templateData) {
        boolean zM46839b;
        boolean z10 = !this.f35364h && AbstractC7558os.m46461I(contentRecord.m41427W());
        AbstractC7185ho.m43821b("TemplateContentProcessor", "isPreContent is  %s, isNeedAsyncDownMotion is %s", Boolean.valueOf(this.f35364h), Boolean.valueOf(z10));
        if (z10) {
            m46831a(contentRecord, templateData, j10, i11, i10);
            zM46839b = false;
        } else {
            zM46839b = m46839b(contentRecord, templateData, j10, i11, i10);
        }
        return z10 || zM46839b;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m46833a(final com.huawei.openalliance.p169ad.p171db.bean.ContentRecord r9, final com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset r10, final java.lang.String r11, final com.huawei.openalliance.p169ad.C7653sb r12) {
        /*
            r8 = this;
            java.lang.String r0 = "TemplateContentProcessor"
            com.huawei.openalliance.ad.pq$1 r7 = new com.huawei.openalliance.ad.pq$1
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r1.<init>()
            java.util.concurrent.Future r12 = com.huawei.openalliance.p169ad.utils.AbstractC7810dc.m48271a(r7)
            com.huawei.openalliance.ad.pq$2 r1 = new com.huawei.openalliance.ad.pq$2
            r1.<init>()
            java.util.concurrent.Future r10 = com.huawei.openalliance.p169ad.utils.AbstractC7810dc.m48271a(r1)
            r11 = 0
            java.lang.Object r12 = r12.get()     // Catch: java.lang.Throwable -> L31
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> L31
            boolean r1 = r12.booleanValue()     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = "sdk res: %s"
            java.lang.Object[] r12 = new java.lang.Object[]{r12}     // Catch: java.lang.Throwable -> L2f
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r0, r2, r12)     // Catch: java.lang.Throwable -> L2f
            goto L44
        L2f:
            r12 = move-exception
            goto L33
        L31:
            r12 = move-exception
            r1 = r11
        L33:
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getSimpleName()
            java.lang.Object[] r12 = new java.lang.Object[]{r12}
            java.lang.String r2 = "sdk res err: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r0, r2, r12)
        L44:
            if (r1 != 0) goto L78
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L57
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L57
            boolean r1 = r10.booleanValue()     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L59
            r11 = 2
            r8.m46442a(r9, r11)     // Catch: java.lang.Throwable -> L57
            goto L5c
        L57:
            r8 = move-exception
            goto L66
        L59:
            r8.m46442a(r9, r11)     // Catch: java.lang.Throwable -> L57
        L5c:
            java.lang.String r8 = "kit res: %s"
            java.lang.Object[] r9 = new java.lang.Object[]{r10}     // Catch: java.lang.Throwable -> L57
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r0, r8, r9)     // Catch: java.lang.Throwable -> L57
            goto L80
        L66:
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getSimpleName()
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            java.lang.String r9 = "kit res err: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r0, r9, r8)
            goto L80
        L78:
            com.huawei.openalliance.ad.pq$3 r11 = new com.huawei.openalliance.ad.pq$3
            r11.<init>()
            com.huawei.openalliance.p169ad.utils.AbstractC7834m.m48486f(r11)
        L80:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r1)
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            java.lang.String r9 = "isExistBoth: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r0, r9, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7583pq.m46833a(com.huawei.openalliance.ad.db.bean.ContentRecord, com.huawei.openalliance.ad.beans.metadata.v3.Asset, java.lang.String, com.huawei.openalliance.ad.sb):boolean");
    }

    /* renamed from: a */
    private boolean m46836a(String str, ContentRecord contentRecord, Asset asset, String str2, C7653sb c7653sb) {
        return AbstractC7807d.m48228c(this.f35361e, str) ? m46838b(contentRecord, asset, str2, c7653sb) : m46833a(contentRecord, asset, str2, c7653sb);
    }
}
