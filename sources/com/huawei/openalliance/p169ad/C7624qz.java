package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7571pe;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.MotionData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7803cw;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7757bd;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7780c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.qz */
/* loaded from: classes8.dex */
public class C7624qz {

    /* renamed from: a */
    private Context f35491a;

    /* renamed from: b */
    private InterfaceC7146gc f35492b;

    /* renamed from: c */
    private InterfaceC7140fx f35493c;

    /* renamed from: d */
    private String f35494d;

    /* renamed from: e */
    private boolean f35495e;

    /* renamed from: f */
    private boolean f35496f;

    /* renamed from: g */
    private boolean f35497g;

    /* renamed from: h */
    private int f35498h = 1;

    /* renamed from: i */
    private int f35499i = 0;

    /* renamed from: com.huawei.openalliance.ad.qz$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C7302e f35500a;

        /* renamed from: b */
        final /* synthetic */ long f35501b;

        public AnonymousClass1(C7302e c7302e, long j10) {
            c7302e = c7302e;
            j = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7624qz.this.m47049a(c7302e);
            C7624qz.this.m47054a(c7302e, j);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.qz$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C7302e f35503a;

        /* renamed from: b */
        final /* synthetic */ long f35504b;

        /* renamed from: c */
        final /* synthetic */ String f35505c;

        /* renamed from: d */
        final /* synthetic */ C7571pe.a f35506d;

        public AnonymousClass2(C7302e c7302e, long j10, String str, C7571pe.a aVar) {
            c7302e = c7302e;
            j = j10;
            str = str;
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7624qz.this.m47049a(c7302e);
            if (C7624qz.this.m47054a(c7302e, j)) {
                c7302e.m44618b(true);
                HashMap map = new HashMap();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(c7302e);
                C7780c.m47860a(map, str, arrayList);
                aVar.mo44137a(map);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.qz$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35508a;

        public AnonymousClass3(ContentRecord contentRecord) {
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            new C6922c(C7624qz.this.f35491a).m39112b(contentRecord);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.qz$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35510a;

        /* renamed from: b */
        final /* synthetic */ long f35511b;

        public AnonymousClass4(ContentRecord contentRecord, long j10) {
            contentRecord = contentRecord;
            j = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentRecord contentRecord = contentRecord;
            if (contentRecord == null || contentRecord.m41469aU() == null || !C7624qz.this.m47053a(contentRecord)) {
                return;
            }
            if ((1 == C7624qz.this.f35498h || C7624qz.this.f35496f) && !AbstractC7760bg.m47767a(contentRecord.m41469aU().m40554c())) {
                Iterator<MotionData> it = contentRecord.m41469aU().m40554c().iterator();
                while (it.hasNext()) {
                    C7653sb c7653sbM47043a = C7624qz.this.m47043a(it.next(), j);
                    c7653sbM47043a.m47169a(contentRecord);
                    C7624qz.this.m47060b(contentRecord, c7653sbM47043a);
                }
            }
        }
    }

    public C7624qz(Context context, boolean z10, boolean z11, boolean z12) {
        this.f35491a = context;
        this.f35495e = z10;
        this.f35496f = z11;
        this.f35497g = z12;
        this.f35492b = C7124fh.m43316b(context);
        this.f35493c = C7118fb.m43196a(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AbstractC7803cw.m48133c(context));
        String str = File.separator;
        sb2.append(str);
        sb2.append(Constants.PPS_ROOT_PATH);
        sb2.append(str);
        sb2.append(Constants.TEMPLATE_VIDEO_SUB_DIR);
        sb2.append(str);
        this.f35494d = sb2.toString();
    }

    /* renamed from: a */
    private C7653sb m47042a(Asset asset, long j10) {
        if (asset == null || asset.m40516d() == null) {
            return null;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47187d(asset.m40516d().m40573a());
        c7653sb.m47184c(asset.m40516d().m40581d() != null ? asset.m40516d().m40581d().m40587b() : null);
        c7653sb.m47181b(asset.m40516d().m40581d() == null || asset.m40516d().m40581d().m40590d() == 0);
        c7653sb.m47185c(true);
        c7653sb.m47171a(Long.valueOf(j10));
        c7653sb.m47180b(Constants.TEMPLATE_VIDEO_SUB_DIR);
        return c7653sb;
    }

    /* renamed from: b */
    private C7653sb m47059b(Asset asset, long j10) {
        if (asset == null || asset.m40517e() == null) {
            return null;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47187d(asset.m40517e().m40595a());
        c7653sb.m47184c(asset.m40517e().m40610f());
        c7653sb.m47181b(asset.m40517e().m40612h() == 0);
        c7653sb.m47185c(true);
        c7653sb.m47171a(Long.valueOf(j10));
        c7653sb.m47180b(Constants.TEMPLATE_VIDEO_SUB_DIR);
        c7653sb.m47173a(true);
        return c7653sb;
    }

    /* renamed from: a */
    public C7653sb m47043a(MotionData motionData, long j10) {
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

    /* renamed from: b */
    public String m47060b(ContentRecord contentRecord, C7653sb c7653sb) {
        if (c7653sb != null) {
            c7653sb.m47169a(contentRecord);
            c7653sb.m47185c(true);
            c7653sb.m47190e(Constants.TPLATE_CACHE);
            C7654sc c7654scMo43274a = this.f35493c.mo43274a(c7653sb);
            if (c7654scMo43274a != null) {
                return c7654scMo43274a.m47207a();
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m47045a(ContentRecord contentRecord, C7653sb c7653sb) {
        String strM47060b = m47060b(contentRecord, c7653sb);
        C7022dk c7022dkM41937a = C7019dh.m41937a(this.f35491a, Constants.TPLATE_CACHE);
        String strM41968c = c7022dkM41937a.m41974g(strM47060b) ? c7022dkM41937a.m41968c(strM47060b) : C7019dh.m41937a(this.f35491a, Constants.NORMAL_CACHE).m41968c(strM47060b);
        if (AbstractC7806cz.m48165b(strM41968c)) {
            return null;
        }
        return strM41968c;
    }

    /* renamed from: a */
    private void m47047a(Asset asset, String str) {
        if (asset.m40516d().m40577b() <= 0 || asset.m40516d().m40580c() <= 0) {
            Rect rectM47685a = C7752az.m47685a(str);
            int iWidth = rectM47685a.width();
            int iHeight = rectM47685a.height();
            if (iWidth <= 0 || iHeight <= 0) {
                return;
            }
            asset.m40516d().m40574a(iWidth);
            asset.m40516d().m40578b(iHeight);
        }
    }

    /* renamed from: a */
    private void m47048a(ContentRecord contentRecord, long j10) {
        AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.qz.4

            /* renamed from: a */
            final /* synthetic */ ContentRecord f35510a;

            /* renamed from: b */
            final /* synthetic */ long f35511b;

            public AnonymousClass4(ContentRecord contentRecord2, long j102) {
                contentRecord = contentRecord2;
                j = j102;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentRecord contentRecord2 = contentRecord;
                if (contentRecord2 == null || contentRecord2.m41469aU() == null || !C7624qz.this.m47053a(contentRecord)) {
                    return;
                }
                if ((1 == C7624qz.this.f35498h || C7624qz.this.f35496f) && !AbstractC7760bg.m47767a(contentRecord.m41469aU().m40554c())) {
                    Iterator<MotionData> it = contentRecord.m41469aU().m40554c().iterator();
                    while (it.hasNext()) {
                        C7653sb c7653sbM47043a = C7624qz.this.m47043a(it.next(), j);
                        c7653sbM47043a.m47169a(contentRecord);
                        C7624qz.this.m47060b(contentRecord, c7653sbM47043a);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void m47049a(C7302e c7302e) {
        try {
            JSONArray jSONArray = new JSONArray(c7302e.m44806ab().m40549a());
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (!jSONObject.isNull("videoDwnNetwork")) {
                    this.f35499i = jSONObject.optInt("videoDwnNetwork");
                } else if (!jSONObject.isNull("videoPlayMode")) {
                    this.f35498h = jSONObject.optInt("videoPlayMode");
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("NativeAdParser3", "getTemplateContext err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m47051a(String str, C7302e c7302e, long j10, C7571pe.a aVar) {
        AbstractC7185ho.m43821b("NativeAdParser3", "dealVideo, adId: %s, directCacheVideo: %s.", str, Boolean.valueOf(this.f35496f));
        AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.qz.2

            /* renamed from: a */
            final /* synthetic */ C7302e f35503a;

            /* renamed from: b */
            final /* synthetic */ long f35504b;

            /* renamed from: c */
            final /* synthetic */ String f35505c;

            /* renamed from: d */
            final /* synthetic */ C7571pe.a f35506d;

            public AnonymousClass2(C7302e c7302e2, long j102, String str2, C7571pe.a aVar2) {
                c7302e = c7302e2;
                j = j102;
                str = str2;
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7624qz.this.m47049a(c7302e);
                if (C7624qz.this.m47054a(c7302e, j)) {
                    c7302e.m44618b(true);
                    HashMap map = new HashMap();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(c7302e);
                    C7780c.m47860a(map, str, arrayList);
                    aVar.mo44137a(map);
                }
            }
        });
    }

    /* renamed from: a */
    private boolean m47052a() {
        int i10;
        if (this.f35497g || this.f35496f || (i10 = this.f35499i) == 1) {
            return true;
        }
        return i10 == 0 && C7775bv.m47829c(this.f35491a);
    }

    /* renamed from: a */
    public boolean m47062a(long j10, String str, List<INativeAd> list, C7302e c7302e, C7571pe.a aVar) {
        String str2;
        c7302e.m44602a(99);
        boolean z10 = true;
        if (this.f35495e) {
            c7302e.m44844i(true);
        }
        if (this.f35495e) {
            AbstractC7185ho.m43820b("NativeAdParser3", "parser, add nativeAd");
            list.add(c7302e);
            z10 = false;
            if (C7757bd.m47714a(Integer.valueOf(c7302e.m44639g())) && !this.f35496f) {
                str2 = "no cache";
            } else if (C7780c.m47861a()) {
                str2 = "use engine down";
            } else {
                AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.qz.1

                    /* renamed from: a */
                    final /* synthetic */ C7302e f35500a;

                    /* renamed from: b */
                    final /* synthetic */ long f35501b;

                    public AnonymousClass1(C7302e c7302e2, long j102) {
                        c7302e = c7302e2;
                        j = j102;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7624qz.this.m47049a(c7302e);
                        C7624qz.this.m47054a(c7302e, j);
                    }
                });
            }
            AbstractC7185ho.m43820b("NativeAdParser3", str2);
            return false;
        }
        m47051a(str, c7302e2, j102, aVar);
        return z10;
    }

    /* renamed from: a */
    public boolean m47053a(ContentRecord contentRecord) {
        if (1 != this.f35498h || m47052a()) {
            return true;
        }
        AbstractC7185ho.m43824c("NativeAdParser3", "cache mode video is not allowed to download in network %d", Integer.valueOf(this.f35499i));
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.qz.3

            /* renamed from: a */
            final /* synthetic */ ContentRecord f35508a;

            public AnonymousClass3(ContentRecord contentRecord2) {
                contentRecord = contentRecord2;
            }

            @Override // java.lang.Runnable
            public void run() {
                new C6922c(C7624qz.this.f35491a).m39112b(contentRecord);
            }
        });
        return false;
    }

    /* renamed from: a */
    public boolean m47054a(C7302e c7302e, long j10) {
        if (this.f35492b.mo43334aA() + 86400000 < AbstractC7741ao.m47566c()) {
            this.f35492b.mo43370b(AbstractC7741ao.m47566c());
            AbstractC7731ae.m47445a(this.f35494d, 604800000L);
        }
        ContentRecord contentRecordM46698a = C7570pd.m46698a(c7302e);
        if (contentRecordM46698a == null || AbstractC7760bg.m47767a(contentRecordM46698a.m41471aW())) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        boolean z10 = true;
        for (Asset asset : contentRecordM46698a.m41471aW()) {
            if (asset != null) {
                if (asset.m40516d() != null) {
                    String strM47045a = m47045a(contentRecordM46698a, m47042a(asset, j10));
                    if (TextUtils.isEmpty(strM47045a)) {
                        AbstractC7185ho.m43824c("NativeAdParser3", "download img: %s failed", asset.m40512b());
                        if (!m47057a(asset.m40520h())) {
                            z10 = false;
                        }
                    } else {
                        asset.m40516d().m40579b(strM47045a);
                        m47047a(asset, strM47045a);
                    }
                }
                if (asset.m40517e() != null) {
                    if (!m47053a(contentRecordM46698a)) {
                        z10 = false;
                    } else if (1 == this.f35498h || this.f35496f) {
                        AbstractC7185ho.m43820b("NativeAdParser3", "cacheVideo");
                        String strM47045a2 = m47045a(contentRecordM46698a, m47059b(asset, j10));
                        if (TextUtils.isEmpty(strM47045a2)) {
                            AbstractC7185ho.m43823c("NativeAdParser3", "dealVideo, download video failed!");
                            if (!m47057a(asset.m40520h())) {
                                z10 = false;
                            }
                        } else {
                            asset.m40517e().m40608d(strM47045a2);
                        }
                    }
                }
                arrayList.add(asset);
            }
        }
        if (z10) {
            c7302e.m44846j(arrayList);
        }
        m47048a(contentRecordM46698a, j10);
        return z10;
    }

    /* renamed from: a */
    private boolean m47057a(String str) {
        try {
            return new JSONObject(str).optInt("optional", 0) == 1;
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("NativeAdParser3", "isOptional err: %s", th2.getClass().getSimpleName());
            return false;
        }
    }
}
