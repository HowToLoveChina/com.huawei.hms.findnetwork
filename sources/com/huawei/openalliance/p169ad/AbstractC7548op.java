package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MediaFile;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Precontent;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.p171db.bean.PlacementRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.op */
/* loaded from: classes8.dex */
public abstract class AbstractC7548op {

    /* renamed from: a */
    InterfaceC7141fy f35105a;

    /* renamed from: b */
    Context f35106b;

    /* renamed from: c */
    InterfaceC7622qx f35107c;

    /* renamed from: d */
    private AdContentRsp f35108d;

    public AbstractC7548op(Context context, InterfaceC7622qx interfaceC7622qx) {
        this.f35106b = context;
        this.f35105a = C7119fc.m43281a(context);
        this.f35107c = interfaceC7622qx;
    }

    /* renamed from: a */
    public C7304g m46369a(String str, Content content, byte[] bArr) {
        return C7575pi.m46767a(str, content, bArr);
    }

    /* renamed from: b */
    public Map<String, List<IPlacementAd>> m46372b(List<Precontent> list) {
        HashMap map = new HashMap(4);
        if (list == null) {
            return map;
        }
        byte[] bArrM48089b = AbstractC7796cp.m48089b(this.f35106b);
        for (final Precontent precontent : list) {
            if (precontent != null) {
                AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.op.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC7548op.this.f35105a.mo43286b(AbstractC7572pf.m46753b(precontent.m40407a(), precontent, 60));
                    }
                });
                String strM40407a = precontent.m40407a();
                if (!map.containsKey(strM40407a)) {
                    map.put(strM40407a, new ArrayList(4));
                }
                List list2 = (List) map.get(strM40407a);
                Content content = new Content(precontent);
                if (content.m39944c() != null) {
                    C7304g c7304gM46369a = m46369a(strM40407a, content, bArrM48089b);
                    c7304gM46369a.m44644i(this.f35108d.m40851k());
                    c7304gM46369a.m44670v(this.f35108d.m40852l());
                    c7304gM46369a.m44621c(this.f35108d.m40855o());
                    c7304gM46369a.m44654n(this.f35108d.m40857q());
                    c7304gM46369a.m44656o(this.f35108d.m40858r());
                    list2.add(c7304gM46369a);
                }
            }
        }
        return map;
    }

    /* renamed from: b */
    public abstract void mo46373b(AdContentRsp adContentRsp);

    /* renamed from: a */
    public static AbstractC7548op m46366a(Context context, InterfaceC7622qx interfaceC7622qx, boolean z10) {
        return z10 ? new C7577pk(context, interfaceC7622qx) : new C7576pj(context, interfaceC7622qx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46367a(MediaFile mediaFile) {
        if (mediaFile == null) {
            return;
        }
        C7019dh.m41937a(this.f35106b, Constants.NORMAL_CACHE).m41976j(C7022dk.m41953d(mediaFile.m40255e()));
    }

    /* renamed from: a */
    public void m46370a(AdContentRsp adContentRsp) {
        if (adContentRsp == null) {
            this.f35107c.mo44171a(800);
            return;
        }
        this.f35108d = adContentRsp;
        m46371a(adContentRsp.m40834d());
        mo46373b(adContentRsp);
    }

    /* renamed from: a */
    public void m46371a(final List<String> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.op.1
            @Override // java.lang.Runnable
            public void run() {
                MetaData metaData;
                for (String str : list) {
                    PlacementRecord placementRecordMo43283a = AbstractC7548op.this.f35105a.mo43283a(str);
                    if (placementRecordMo43283a != null && (metaData = (MetaData) AbstractC7758be.m47739b(placementRecordMo43283a.m41797b(), MetaData.class, new Class[0])) != null) {
                        AbstractC7548op.this.m46367a(metaData.m40342v());
                        List<MediaFile> listM40344x = metaData.m40344x();
                        if (!AbstractC7760bg.m47767a(listM40344x)) {
                            Iterator<MediaFile> it = listM40344x.iterator();
                            while (it.hasNext()) {
                                AbstractC7548op.this.m46367a(it.next());
                            }
                        }
                    }
                    AbstractC7548op.this.f35105a.mo43287b(str);
                }
            }
        }, AbstractC7834m.a.IO, false);
    }
}
