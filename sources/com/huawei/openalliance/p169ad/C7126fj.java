package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.MotionData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentTemplateRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7801cu;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.File;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.fj */
/* loaded from: classes8.dex */
public class C7126fj {

    /* renamed from: a */
    private InterfaceC7135fs f32906a;

    /* renamed from: b */
    private InterfaceC7137fu f32907b;

    /* renamed from: c */
    private InterfaceC7148ge f32908c;

    /* renamed from: d */
    private InterfaceC7136ft f32909d;

    /* renamed from: e */
    private Context f32910e;

    public C7126fj(Context context) {
        this.f32910e = context.getApplicationContext();
        this.f32906a = C7104et.m43127b(context);
        this.f32907b = C7106ev.m43144a(context);
        this.f32908c = C7128fl.m43510a(context);
        this.f32909d = C7105eu.m43130a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Boolean m43495b(java.lang.String r1) {
        /*
            r0 = this;
            com.huawei.openalliance.ad.ft r0 = r0.f32909d
            java.util.List r0 = r0.mo43133a(r1)
            boolean r1 = com.huawei.openalliance.p169ad.utils.AbstractC7760bg.m47767a(r0)
            if (r1 != 0) goto L14
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7126fj.m43495b(java.lang.String):java.lang.Boolean");
    }

    /* renamed from: c */
    private String m43496c(String str) {
        Context context = this.f32910e;
        String str2 = Constants.TPLATE_CACHE;
        String strM41968c = C7019dh.m41937a(context, Constants.TPLATE_CACHE).m41968c(str);
        if (!AbstractC7806cz.m48165b(strM41968c) && !AbstractC7731ae.m47464d(new File(strM41968c))) {
            String strM41968c2 = C7019dh.m41937a(this.f32910e, Constants.NORMAL_CACHE).m41968c(str);
            if (!AbstractC7806cz.m48165b(strM41968c2) && AbstractC7731ae.m47464d(new File(strM41968c2))) {
                str2 = Constants.NORMAL_CACHE;
            }
        }
        AbstractC7185ho.m43821b("TContentRecordManager", "realCacheType is %s", str2);
        return str2;
    }

    /* renamed from: a */
    public ContentRecord m43497a(ContentRecord contentRecord, int i10, long j10) {
        String str;
        if (contentRecord == null) {
            return null;
        }
        ContentRecord contentRecordMo43103a = this.f32906a.mo43103a(contentRecord.m41588n(), contentRecord.m41463aO(), contentRecord.m41585m(), i10, j10);
        if (contentRecordMo43103a == null) {
            str = "showContent is null";
        } else {
            ContentTemplateRecord contentTemplateRecordMo43146a = this.f32907b.mo43146a(contentRecord.m41588n(), contentRecord.m41463aO());
            if (contentTemplateRecordMo43146a != null && !AbstractC7760bg.m47767a(contentTemplateRecordMo43146a.m41646c())) {
                contentRecordMo43103a.m41584l(contentTemplateRecordMo43146a.m41646c());
                contentRecordMo43103a.m41477aa(contentTemplateRecordMo43146a.m41650g());
                TemplateData templateData = new TemplateData(contentTemplateRecordMo43146a.m41647d(), contentTemplateRecordMo43146a.m41648e(), contentTemplateRecordMo43146a.m41649f());
                if (contentRecord.m41469aU() != null) {
                    templateData.m40555c(contentRecord.m41469aU().m40556d());
                }
                contentRecordMo43103a.m41440a(templateData);
                contentRecordMo43103a.m41408M(m43498a(contentRecord.m41585m(), contentRecord.m41463aO()));
                return contentRecordMo43103a;
            }
            str = "template is null";
        }
        AbstractC7185ho.m43820b("TContentRecordManager", str);
        return null;
    }

    /* renamed from: a */
    public String m43498a(String str, String str2) {
        return this.f32908c.mo43522a(str, str2);
    }

    /* renamed from: b */
    public List<ContentRecord> m43504b() {
        return this.f32906a.mo43105a(1);
    }

    /* renamed from: a */
    public List<ContentRecord> m43499a() {
        return this.f32906a.mo43120c();
    }

    /* renamed from: a */
    public List<ContentRecord> m43500a(String str) {
        return this.f32906a.mo43113b(str);
    }

    /* renamed from: a */
    public void m43501a(ContentRecord contentRecord) {
        if (contentRecord == null) {
            AbstractC7185ho.m43823c("TContentRecordManager", "deleteContent, record is null");
            return;
        }
        AbstractC7185ho.m43821b("TContentRecordManager", "deleteContent: %s %s", contentRecord.m41588n(), contentRecord.m41463aO());
        m43494a(contentRecord.m41588n(), contentRecord.m41463aO(), "delete invalids");
        this.f32906a.mo43119b(contentRecord.m41588n(), contentRecord.m41585m());
    }

    /* renamed from: a */
    public void m43502a(ContentRecord contentRecord, String str) {
        if (contentRecord == null) {
            AbstractC7185ho.m43823c("TContentRecordManager", "deleteContentByIds, record is null");
            return;
        }
        AbstractC7185ho.m43821b("TContentRecordManager", "deleteContentByIds %s %s because %s", contentRecord.m41588n(), contentRecord.m41463aO(), str);
        m43494a(contentRecord.m41588n(), contentRecord.m41463aO(), str);
        this.f32906a.mo43111a(contentRecord.m41588n(), contentRecord.m41463aO(), contentRecord.m41585m(), str);
    }

    /* renamed from: a */
    public void m43503a(ContentRecord contentRecord, List<Asset> list, TemplateData templateData) {
        if (contentRecord == null) {
            return;
        }
        this.f32906a.mo43121c(contentRecord);
        if (TextUtils.isEmpty(contentRecord.m41463aO()) || AbstractC7760bg.m47767a(list)) {
            return;
        }
        ContentTemplateRecord contentTemplateRecord = new ContentTemplateRecord(contentRecord.m41588n(), contentRecord.m41463aO(), list, templateData, contentRecord.m41528bo());
        if (!TextUtils.isEmpty(contentRecord.m41473aY())) {
            contentTemplateRecord.m41644a(contentRecord.m41473aY());
        }
        this.f32907b.mo43147a(contentTemplateRecord);
    }

    /* renamed from: a */
    private void m43494a(String str, String str2, String str3) {
        ContentTemplateRecord contentTemplateRecordMo43146a = this.f32907b.mo43146a(str, str2);
        if (contentTemplateRecordMo43146a == null) {
            AbstractC7185ho.m43820b("TContentRecordManager", "templateRecord is null");
            return;
        }
        List<Asset> listM41646c = contentTemplateRecordMo43146a.m41646c();
        if (!AbstractC7760bg.m47767a(listM41646c)) {
            for (Asset asset : listM41646c) {
                if (asset != null) {
                    String strM40519g = asset.m40519g();
                    if (!AbstractC7806cz.m48165b(strM40519g)) {
                        String strSubstring = strM40519g.substring(strM40519g.lastIndexOf("/") + 1);
                        if (m43495b(strSubstring).booleanValue()) {
                            String strM41956l = C7022dk.m41956l(strM40519g);
                            AbstractC7731ae.m47441a(this.f32910e, strM41956l, m43496c(strM41956l));
                        } else {
                            this.f32909d.mo43140b(str, strSubstring);
                        }
                    }
                }
            }
        }
        List<MotionData> listM41649f = contentTemplateRecordMo43146a.m41649f();
        if (!AbstractC7760bg.m47767a(listM41649f)) {
            for (MotionData motionData : listM41649f) {
                if (motionData != null && !AbstractC7806cz.m48165b(motionData.m40539g())) {
                    String strM48126a = AbstractC7801cu.m48126a(motionData.m40539g());
                    String str4 = Scheme.DISKCACHE + strM48126a;
                    if (m43495b(strM48126a).booleanValue()) {
                        AbstractC7731ae.m47441a(this.f32910e, str4, m43496c(str4));
                    } else {
                        this.f32909d.mo43140b(str, strM48126a);
                    }
                }
            }
        }
        this.f32907b.mo43148a(str, str2, str3);
    }
}
