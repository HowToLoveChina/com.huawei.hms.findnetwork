package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.inner.C5077a;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7753b;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p208cq.InterfaceC8939g;

/* renamed from: com.huawei.openalliance.ad.ne */
/* loaded from: classes8.dex */
public class C7497ne extends C7336jj<IPPSNativeView> {

    /* renamed from: d */
    private static final String f34778d = "ne";

    /* renamed from: e */
    private Context f34779e;

    /* renamed from: f */
    private C7302e f34780f;

    /* renamed from: com.huawei.openalliance.ad.ne$a */
    public static class a implements InterfaceC8939g<Boolean> {

        /* renamed from: a */
        private final WeakReference<C7497ne> f34781a;

        /* renamed from: b */
        private final AbstractC7687ti f34782b;

        /* renamed from: c */
        private final MaterialClickInfo f34783c;

        /* renamed from: d */
        private final int f34784d;

        /* renamed from: e */
        private final String f34785e;

        public a(C7497ne c7497ne, AbstractC7687ti abstractC7687ti, MaterialClickInfo materialClickInfo, int i10, String str) {
            this.f34781a = new WeakReference<>(c7497ne);
            this.f34782b = abstractC7687ti;
            this.f34783c = materialClickInfo;
            this.f34784d = i10;
            this.f34785e = str;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(Boolean bool) {
            AbstractC7185ho.m43821b(C7497ne.f34778d, "onSuccess ret: %s.", bool);
            C7497ne c7497ne = this.f34781a.get();
            if (c7497ne == null) {
                AbstractC7185ho.m43823c(C7497ne.f34778d, "presenter is null");
            } else {
                AbstractC7185ho.m43820b(C7497ne.f34778d, "presenter doActionReport");
                c7497ne.m45945a(this.f34782b, this.f34783c, this.f34784d, this.f34785e);
            }
        }
    }

    public C7497ne(Context context, IPPSNativeView iPPSNativeView) {
        this.f34779e = context;
        mo45316a((C7497ne) iPPSNativeView);
        this.f34190b = new C7560ou(context, new C7665sn(context, 3));
    }

    /* renamed from: a */
    public void m45947a() {
        this.f34190b.mo46606b();
    }

    /* renamed from: b */
    public void m45954b() {
        this.f34190b.mo46633p();
    }

    /* renamed from: a */
    public void m45948a(long j10, int i10) {
        this.f34190b.mo46581a(j10, i10);
    }

    /* renamed from: b */
    public void m45955b(String str) {
        ContentRecord contentRecord = this.f34189a;
        if (contentRecord == null) {
            return;
        }
        contentRecord.m41389C(str);
        this.f34190b.mo46590a(this.f34189a);
    }

    /* renamed from: c */
    public void m45957c(String str) {
        ContentRecord contentRecord = this.f34189a;
        if (contentRecord == null) {
            return;
        }
        contentRecord.m41511b(str);
        this.f34190b.mo46590a(this.f34189a);
    }

    /* renamed from: a */
    public void m45949a(VideoInfo videoInfo) {
        C7302e c7302e = this.f34780f;
        if (c7302e == null) {
            return;
        }
        c7302e.m44799a(videoInfo);
    }

    /* renamed from: b */
    public void m45956b(List<FeedbackInfo> list) {
        this.f34190b.mo46614b(list);
    }

    /* renamed from: c */
    public void m45958c(List<FeedbackInfo> list) {
        this.f34190b.mo46604a(list);
    }

    /* renamed from: a */
    public void m45950a(C7302e c7302e) {
        this.f34780f = c7302e;
        this.f34189a = C7570pd.m46698a(c7302e);
        Context context = this.f34779e;
        this.f34190b = new C7560ou(context, new C7665sn(context, c7302e == null ? 3 : c7302e.m44632e()), this.f34189a);
        if (c7302e == null || c7302e.m44808ad() == null || c7302e.m44808ad().intValue() != 3) {
            return;
        }
        C7012db.m41242a().m41246a(c7302e.getUniqueId(), this.f34189a);
    }

    /* renamed from: a */
    private void m45942a(AbstractC7687ti abstractC7687ti, MaterialClickInfo materialClickInfo, Integer num, String str) {
        C7587b.a aVar = new C7587b.a();
        aVar.m46920b(abstractC7687ti.m47250c()).m46915a(Integer.valueOf(num != null ? num.intValue() : 7)).m46914a(materialClickInfo).m46923d(C7753b.m47700a(mo45320d())).m46924e(str);
        this.f34190b.mo46594a(aVar.m46918a());
        InterfaceC7615qq interfaceC7615qq = this.f34191c;
        if (interfaceC7615qq != null) {
            interfaceC7615qq.mo46594a(aVar.m46918a());
        }
    }

    /* renamed from: a */
    public void m45951a(Long l10, Integer num, Integer num2, String str) {
        String strM45322f = m45322f();
        C7302e c7302e = this.f34780f;
        if (c7302e != null) {
            AbstractC7185ho.m43818a(f34778d, "slotId: %s, contentId: %s, slot pos: %s", c7302e.getSlotId(), this.f34780f.getContentId(), strM45322f);
        }
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(l10).m46873a(num).m46878b(num2).m46875a(C7753b.m47700a(mo45320d())).m46884d(strM45322f).m46882c(str).m46885e(m45323g());
        this.f34190b.mo46593a(aVar.m46877a());
    }

    /* renamed from: a */
    private void m45943a(HashMap<String, String> map) {
        MetaData metaDataM41568i;
        if (map == null || (metaDataM41568i = this.f34189a.m41568i()) == null) {
            return;
        }
        ApkInfo apkInfoM40339s = metaDataM41568i.m40339s();
        if (apkInfoM40339s != null) {
            String strM48170d = AbstractC7806cz.m48170d(map.get(Constants.BF_DOWNLOAD_TXT));
            if (!TextUtils.isEmpty(strM48170d)) {
                apkInfoM40339s.m39683t(strM48170d);
            }
            String strM48170d2 = AbstractC7806cz.m48170d(map.get(Constants.AF_DOWNLOAD_TXT));
            if (!TextUtils.isEmpty(strM48170d2)) {
                apkInfoM40339s.m39685u(strM48170d2);
            }
        }
        this.f34189a.m41511b(AbstractC7758be.m47742b(metaDataM41568i));
    }

    /* renamed from: a */
    public void m45952a(List<String> list) {
        this.f34190b.mo46577a(0, 0, list);
    }

    /* renamed from: a */
    public boolean m45953a(MaterialClickInfo materialClickInfo, Integer num, String str, boolean z10, HashMap<String, String> map) {
        C7302e c7302e = this.f34780f;
        if (c7302e == null) {
            return false;
        }
        c7302e.m44838f(true);
        String str2 = f34778d;
        AbstractC7185ho.m43817a(str2, "begin to deal click");
        Map<String, String> mapM44815ak = this.f34780f.m44815ak();
        m45943a(map);
        AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(this.f34779e, this.f34189a, mapM44815ak);
        if (!z10) {
            m45942a(abstractC7687tiM47245a, materialClickInfo, num, str);
            return true;
        }
        if (!AbstractC7811dd.m48310b(this.f34779e)) {
            return m45945a(abstractC7687tiM47245a, materialClickInfo, num.intValue(), str);
        }
        AbstractC7185ho.m43820b(str2, "screenLocked onAdClick");
        C5077a.m30321a(this.f34779e, new a(this, abstractC7687tiM47245a, materialClickInfo, num.intValue(), str));
        return true;
    }

    /* renamed from: a */
    public boolean m45945a(AbstractC7687ti abstractC7687ti, MaterialClickInfo materialClickInfo, int i10, String str) {
        boolean zMo47233a = abstractC7687ti.mo47233a();
        if (zMo47233a) {
            m45942a(abstractC7687ti, materialClickInfo, Integer.valueOf(i10), str);
        }
        return zMo47233a;
    }
}
