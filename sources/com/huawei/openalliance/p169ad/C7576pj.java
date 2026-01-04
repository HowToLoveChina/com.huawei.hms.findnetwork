package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MediaFile;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.ParamFromServer;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.data.PlacementMediaFile;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.pj */
/* loaded from: classes8.dex */
public class C7576pj extends AbstractC7548op {

    /* renamed from: d */
    private AdContentRsp f35328d;

    /* renamed from: e */
    private C7022dk f35329e;

    /* renamed from: com.huawei.openalliance.ad.pj$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35330a;

        public AnonymousClass1(ContentRecord contentRecord) {
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            new C6922c(C7576pj.this.f35106b).mo39077a(contentRecord, "media's play mode is offline but was not cached before");
        }
    }

    public C7576pj(Context context, InterfaceC7622qx interfaceC7622qx) {
        super(context, interfaceC7622qx);
        this.f35329e = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
    }

    /* renamed from: a */
    private List<IPlacementAd> m46768a(Ad30 ad30, byte[] bArr, Map<String, List<IPlacementAd>> map) {
        if (ad30 == null || TextUtils.isEmpty(ad30.m39419a())) {
            return null;
        }
        List<Content> listM39428c = ad30.m39428c();
        if (AbstractC7760bg.m47767a(listM39428c)) {
            AbstractC7185ho.m43823c("PlacementAdProcessor", "content is null" + ad30.m39419a());
            return null;
        }
        ArrayList<Content> arrayList = new ArrayList(listM39428c);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList(4);
        String strM39419a = ad30.m39419a();
        for (Content content : arrayList) {
            if (content != null) {
                AdContentRsp adContentRsp = this.f35328d;
                if (adContentRsp != null) {
                    content.m39925a(adContentRsp.m40847h(), 60);
                }
                MetaData metaDataM39944c = content.m39944c();
                if (metaDataM39944c == null || metaDataM39944c.m40345y() <= 0 || !m46771a(content)) {
                    AbstractC7185ho.m43826d("PlacementAdProcessor", "content is invalid:" + content.m39962g());
                } else {
                    C7304g c7304gM46369a = m46369a(strM39419a, content, bArr);
                    c7304gM46369a.m44644i(this.f35328d.m40851k());
                    c7304gM46369a.m44621c(this.f35328d.m40855o());
                    c7304gM46369a.m44654n(this.f35328d.m40857q());
                    c7304gM46369a.m44656o(this.f35328d.m40858r());
                    c7304gM46369a.m44668u(this.f35328d.m40862v());
                    if (m46773c(c7304gM46369a)) {
                        arrayList2.add(c7304gM46369a);
                    } else {
                        m46770a(c7304gM46369a);
                    }
                    if (!m46772b(c7304gM46369a) && map != null) {
                        List<IPlacementAd> arrayList3 = map.get(strM39419a);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList<>();
                            map.put(strM39419a, arrayList3);
                        }
                        PlacementMediaFile mediaFile = c7304gM46369a.getMediaFile();
                        if (mediaFile != null) {
                            mediaFile.m44546a(1);
                            c7304gM46369a.m44871D().add(mediaFile);
                        }
                        arrayList3.add(c7304gM46369a);
                    }
                }
            }
        }
        return arrayList2;
    }

    /* renamed from: c */
    private boolean m46773c(C7304g c7304g) {
        PlacementMediaFile mediaFile = c7304g.getMediaFile();
        if (mediaFile == null) {
            return false;
        }
        if (2 == mediaFile.getPlayMode()) {
            return true;
        }
        return !TextUtils.isEmpty(this.f35329e.m41970e(mediaFile.getUrl()));
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7548op
    /* renamed from: b */
    public void mo46373b(AdContentRsp adContentRsp) {
        this.f35328d = adContentRsp;
        m46769a();
    }

    /* renamed from: a */
    private void m46769a() {
        String str;
        AbstractC7185ho.m43820b("PlacementAdProcessor", "parser");
        AdContentRsp adContentRsp = this.f35328d;
        if (adContentRsp == null) {
            this.f35107c.mo44171a(ErrorCode.ERROR_CODE_OTHER);
            str = "response is null";
        } else {
            Map<String, List<IPlacementAd>> mapM46372b = m46372b(adContentRsp.m40842f());
            List<Ad30> listM40830c = this.f35328d.m40830c();
            if (!AbstractC7760bg.m47767a(listM40830c)) {
                HashMap map = new HashMap(4);
                byte[] bArrM48089b = AbstractC7796cp.m48089b(this.f35106b);
                for (Ad30 ad30 : listM40830c) {
                    String strM39419a = ad30.m39419a();
                    int iM39424b = ad30.m39424b();
                    if (200 != iM39424b) {
                        AbstractC7185ho.m43821b("PlacementAdProcessor", "ad failed, retcode30: %s, slotId: %s.", Integer.valueOf(iM39424b), strM39419a);
                    }
                    List<IPlacementAd> listM46768a = m46768a(ad30, bArrM48089b, mapM46372b);
                    if (!AbstractC7760bg.m47767a(listM46768a)) {
                        List list = (List) map.get(strM39419a);
                        if (AbstractC7760bg.m47767a(list)) {
                            map.put(strM39419a, listM46768a);
                        } else {
                            list.addAll(listM46768a);
                        }
                    }
                }
                InterfaceC7622qx interfaceC7622qx = this.f35107c;
                if (interfaceC7622qx != null) {
                    interfaceC7622qx.mo44172a(map, mapM46372b);
                    return;
                }
                return;
            }
            this.f35107c.mo44172a(null, mapM46372b);
            str = "multi ad is null";
        }
        AbstractC7185ho.m43823c("PlacementAdProcessor", str);
    }

    /* renamed from: b */
    private boolean m46772b(C7304g c7304g) {
        if (c7304g.getMediaFile() != null) {
            return !TextUtils.isEmpty(this.f35329e.m41970e(r1.getUrl()));
        }
        return false;
    }

    /* renamed from: a */
    private void m46770a(C7304g c7304g) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.pj.1

            /* renamed from: a */
            final /* synthetic */ ContentRecord f35330a;

            public AnonymousClass1(ContentRecord contentRecord) {
                contentRecord = contentRecord;
            }

            @Override // java.lang.Runnable
            public void run() {
                new C6922c(C7576pj.this.f35106b).mo39077a(contentRecord, "media's play mode is offline but was not cached before");
            }
        });
    }

    /* renamed from: a */
    private boolean m46771a(Content content) {
        MetaData metaDataM39944c;
        String strM39981m;
        ParamFromServer paramFromServer;
        if (content == null || TextUtils.isEmpty(content.m39962g()) || content.m39977k() <= 0 || (metaDataM39944c = content.m39944c()) == null || (strM39981m = content.m39981m()) == null || (paramFromServer = (ParamFromServer) AbstractC7758be.m47739b(strM39981m, ParamFromServer.class, new Class[0])) == null) {
            return false;
        }
        if (TextUtils.isEmpty(paramFromServer.m40379a()) && TextUtils.isEmpty(paramFromServer.m40381b())) {
            return false;
        }
        MediaFile mediaFileM40342v = metaDataM39944c.m40342v();
        String strM40274K = metaDataM39944c.m40274K();
        if (mediaFileM40342v == null && !TextUtils.isEmpty(strM40274K)) {
            AbstractC7185ho.m43820b("PlacementAdProcessor", "use vastInfo");
            return true;
        }
        if (mediaFileM40342v == null) {
            return false;
        }
        if (mediaFileM40342v.m40262k() || mediaFileM40342v.m40261j()) {
            return mediaFileM40342v.m40253d() < (mediaFileM40342v.m40262k() ? 209715200L : C7124fh.m43316b(this.f35106b).mo43452f(mediaFileM40342v.m40263l()) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        }
        return false;
    }
}
