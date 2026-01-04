package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.magazine.inter.listener.IAdInvalidHandler;
import com.huawei.openalliance.p169ad.magazine.inter.listener.IPPSDownloadService;
import com.huawei.openalliance.p169ad.magazine.inter.listener.PPSDownloadResult;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.pa */
/* loaded from: classes8.dex */
public class C7567pa implements InterfaceC7616qr {

    /* renamed from: a */
    private static final String f35269a = C7557or.class.getSimpleName();

    /* renamed from: j */
    private static int f35270j = 0;

    /* renamed from: b */
    private List<ContentRecord> f35271b;

    /* renamed from: c */
    private List<String> f35272c;

    /* renamed from: d */
    private int f35273d = 2;

    /* renamed from: e */
    private InterfaceC7135fs f35274e;

    /* renamed from: f */
    private Context f35275f;

    /* renamed from: g */
    private IAdInvalidHandler f35276g;

    /* renamed from: h */
    private IPPSDownloadService f35277h;

    /* renamed from: i */
    private C6922c f35278i;

    /* renamed from: com.huawei.openalliance.ad.pa$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f35279a;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43821b(C7567pa.f35269a, "onInvalid: %s", str);
            C7567pa.this.f35276g.onInvalid(str);
        }
    }

    public C7567pa(Context context, List<ContentRecord> list) {
        this.f35275f = context.getApplicationContext();
        this.f35271b = list;
        this.f35274e = C7103es.m43094a(context);
        this.f35276g = HiAd.getInstance(context).getAdInvalidHandler();
        this.f35277h = HiAd.getInstance(context).getPPSDownloadService();
        this.f35278i = new C6922c(context);
    }

    /* renamed from: c */
    private boolean m46674c() {
        return 2 == this.f35273d;
    }

    /* renamed from: a */
    private String m46670a(ContentRecord contentRecord, String str, boolean z10) {
        if (this.f35277h == null) {
            AbstractC7185ho.m43823c(f35269a, "there is no download service");
            return null;
        }
        ImageInfo imageInfoM41417R = contentRecord.m41417R();
        if (imageInfoM41417R == null) {
            AbstractC7185ho.m43823c(f35269a, "image info is null");
            return null;
        }
        PPSDownloadResult pPSDownloadResultDownload = this.f35277h.download(str, imageInfoM41417R.m40180c(), imageInfoM41417R.m40174a(), imageInfoM41417R.m40186f(), z10);
        if (pPSDownloadResultDownload == null || !pPSDownloadResultDownload.isResult() || AbstractC7806cz.m48165b(pPSDownloadResultDownload.getPath())) {
            AbstractC7185ho.m43823c(f35269a, "download fail");
            this.f35278i.m39108a(contentRecord.m41585m(), str, false);
            return null;
        }
        contentRecord.m41571i(pPSDownloadResultDownload.getPath());
        String str2 = f35269a;
        AbstractC7185ho.m43820b(str2, "insert to db start:" + contentRecord.m41588n());
        this.f35274e.mo43116b(contentRecord);
        AbstractC7185ho.m43820b(str2, "insert to db end:" + contentRecord.m41588n());
        this.f35278i.m39108a(contentRecord.m41585m(), str, true);
        return str;
    }

    /* renamed from: b */
    private boolean m46673b(String str) {
        ContentRecord contentRecordMo43098a = this.f35274e.mo43098a(str);
        return (contentRecordMo43098a == null || TextUtils.isEmpty(contentRecordMo43098a.m41619z()) || AbstractC7806cz.m48181j(contentRecordMo43098a.m41619z())) ? false : true;
    }

    /* renamed from: a */
    private String m46671a(ContentRecord contentRecord, boolean z10) {
        String strM41588n = contentRecord.m41588n();
        if (!m46673b(strM41588n)) {
            return m46670a(contentRecord, strM41588n, z10);
        }
        AbstractC7185ho.m43821b(f35269a, "contentId %s exist,no download.update DB!", contentRecord.m41588n());
        ArrayList arrayList = new ArrayList();
        arrayList.add("_id");
        arrayList.add(ContentRecord.DISPLAY_COUNT);
        arrayList.add(ContentRecord.DISPLAY_DATE);
        if (TextUtils.isEmpty(contentRecord.m41619z()) || AbstractC7806cz.m48181j(contentRecord.m41619z())) {
            arrayList.add(ContentRecord.SPLASH_MEDIA_PATH);
        }
        arrayList.add(ContentRecord.LAST_SHOW_TIME);
        arrayList.add(ContentRecord.FC_CTRL_DATE);
        this.f35274e.mo43118b(contentRecord, arrayList, strM41588n);
        return strM41588n;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7616qr
    /* renamed from: a */
    public String mo46675a(boolean z10) {
        AbstractC7185ho.m43820b(f35269a, "download contents start");
        String strM46671a = null;
        if (AbstractC7760bg.m47767a(this.f35271b)) {
            return null;
        }
        byte[] bArrM48089b = AbstractC7796cp.m48089b(this.f35275f);
        for (ContentRecord contentRecord : this.f35271b) {
            if (m46674c()) {
                contentRecord.m41857a(bArrM48089b);
                AbstractC7185ho.m43821b(f35269a, "start to downloadContent , contentId : %s", contentRecord.m41588n());
                strM46671a = m46671a(contentRecord, z10 || contentRecord.m41521bh());
            } else {
                AbstractC7185ho.m43821b(f35269a, "downloadContents - content creativeType %d not supported", Integer.valueOf(contentRecord.m41392E()));
            }
        }
        AbstractC7185ho.m43820b(f35269a, "download contents ends");
        return strM46671a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7616qr
    /* renamed from: a */
    public void mo46676a() {
        if (AbstractC7760bg.m47767a(this.f35272c)) {
            AbstractC7185ho.m43820b(f35269a, "invalidContentIds is empty");
            return;
        }
        Iterator<String> it = this.f35272c.iterator();
        while (it.hasNext()) {
            m46678a(it.next());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7616qr
    /* renamed from: a */
    public void mo46677a(int i10) {
        this.f35273d = i10;
    }

    /* renamed from: a */
    public void m46678a(String str) {
        this.f35274e.mo43122c(str);
        if (this.f35276g != null) {
            AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.pa.1

                /* renamed from: a */
                final /* synthetic */ String f35279a;

                public AnonymousClass1(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7185ho.m43821b(C7567pa.f35269a, "onInvalid: %s", str);
                    C7567pa.this.f35276g.onInvalid(str);
                }
            });
        } else {
            AbstractC7185ho.m43823c(f35269a, "invalid handler is null");
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7616qr
    /* renamed from: a */
    public void mo46679a(List<String> list) {
        this.f35272c = list;
    }
}
