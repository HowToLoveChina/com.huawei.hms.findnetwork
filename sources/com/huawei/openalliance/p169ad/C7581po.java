package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.ParamFromServer;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7826e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.po */
/* loaded from: classes8.dex */
public class C7581po implements InterfaceC7619qu {

    /* renamed from: a */
    private Context f35345a;

    /* renamed from: b */
    private a f35346b;

    /* renamed from: c */
    private AdContentRsp f35347c;

    /* renamed from: d */
    private C7076dt f35348d = C7076dt.m42678h();

    /* renamed from: com.huawei.openalliance.ad.po$a */
    public interface a {
        /* renamed from: a */
        void mo44207a(int i10);

        /* renamed from: a */
        void mo44209a(Map<String, List<IRewardAd>> map);
    }

    public C7581po(Context context, a aVar) {
        this.f35345a = context.getApplicationContext();
        this.f35346b = aVar;
    }

    /* renamed from: a */
    private List<IRewardAd> m46801a(Ad30 ad30, byte[] bArr) {
        ArrayList arrayList = null;
        if (ad30 != null && !TextUtils.isEmpty(ad30.m39419a())) {
            String strM39419a = ad30.m39419a();
            List<Content> listM39428c = ad30.m39428c();
            String strM39434g = ad30.m39434g();
            if (AbstractC7760bg.m47767a(listM39428c)) {
                AbstractC7185ho.m43823c("RewardAdProcessor", "content is null" + strM39419a);
                return null;
            }
            arrayList = new ArrayList(4);
            for (Content content : listM39428c) {
                if (content != null) {
                    AdContentRsp adContentRsp = this.f35347c;
                    if (adContentRsp != null) {
                        content.m39925a(adContentRsp.m40847h(), 7);
                    }
                    MetaData metaDataM39944c = content.m39944c();
                    if (metaDataM39944c == null || !m46804a(content)) {
                        AbstractC7185ho.m43827d("RewardAdProcessor", "content is invalid:%s", content.m39962g());
                    } else {
                        C7305h c7305hM46795a = C7580pn.m46795a(strM39419a, content, bArr, strM39434g);
                        c7305hM46795a.m44644i(this.f35347c.m40851k());
                        c7305hM46795a.m44670v(this.f35347c.m40852l());
                        c7305hM46795a.m44621c(this.f35347c.m40855o());
                        c7305hM46795a.m44654n(this.f35347c.m40857q());
                        c7305hM46795a.m44656o(this.f35347c.m40858r());
                        c7305hM46795a.m44668u(this.f35347c.m40862v());
                        arrayList.add(c7305hM46795a);
                        if (!m46805a(content.m39906U())) {
                            m46803a(metaDataM39944c.m40305d(), content.m39962g(), strM39419a, content.m39894I());
                        }
                        m46802a(metaDataM39944c);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m46802a(MetaData metaData) {
        if (metaData == null || metaData.m40275L() == null) {
            return;
        }
        C7826e.m48392a(this.f35345a, metaData.m40275L());
    }

    /* renamed from: a */
    private void m46803a(final VideoInfo videoInfo, final String str, final String str2, final Integer num) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.po.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43818a("RewardAdProcessor", "download reward video:%s", AbstractC7819dl.m48375a(videoInfo.m40471a()));
                C7074dr c7074dr = new C7074dr(videoInfo.m40471a(), videoInfo.m40481c(), videoInfo.m40496i() == 0, videoInfo.m40493g(), null, 1 == videoInfo.m40499l(), 1, str, str2, 7, false, C7581po.this.f35347c.m40855o());
                c7074dr.m42638a(num);
                C7581po.this.f35348d.m42680a(c7074dr);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7619qu
    /* renamed from: a */
    public void mo46807a(AdContentRsp adContentRsp) {
        AbstractC7185ho.m43820b("RewardAdProcessor", "parser");
        if (adContentRsp == null) {
            this.f35346b.mo44207a(ErrorCode.ERROR_CODE_OTHER);
            AbstractC7185ho.m43823c("RewardAdProcessor", "response is null");
            return;
        }
        this.f35347c = adContentRsp;
        List<Ad30> listM40830c = adContentRsp.m40830c();
        HashMap map = new HashMap(4);
        byte[] bArrM48089b = AbstractC7796cp.m48089b(this.f35345a);
        if (!AbstractC7760bg.m47767a(listM40830c)) {
            for (Ad30 ad30 : listM40830c) {
                String strM39419a = ad30.m39419a();
                int iM39424b = ad30.m39424b();
                if (200 != iM39424b) {
                    AbstractC7185ho.m43821b("RewardAdProcessor", "ad failed, retcode30: %s, slotId: %s.", Integer.valueOf(iM39424b), strM39419a);
                }
                List<IRewardAd> listM46801a = m46801a(ad30, bArrM48089b);
                if (!AbstractC7760bg.m47767a(listM46801a)) {
                    map.put(strM39419a, listM46801a);
                }
            }
        }
        AbstractC7185ho.m43821b("RewardAdProcessor", "rewardAdMap empty: %s", Boolean.valueOf(map.isEmpty()));
        if (this.f35346b != null) {
            if (map.isEmpty()) {
                AbstractC7185ho.m43821b("RewardAdProcessor", "onAdFailed: %s", 204);
                this.f35346b.mo44207a(ErrorCode.ERROR_REWARD_AD_NO);
            } else {
                AbstractC7185ho.m43820b("RewardAdProcessor", "onAdsLoaded");
                this.f35346b.mo44209a(map);
            }
        }
    }

    /* renamed from: a */
    private boolean m46804a(Content content) {
        MetaData metaDataM39944c;
        String strM39981m;
        ParamFromServer paramFromServer;
        if (content == null || TextUtils.isEmpty(content.m39962g()) || content.m39977k() <= 0 || (metaDataM39944c = content.m39944c()) == null || (strM39981m = content.m39981m()) == null || (paramFromServer = (ParamFromServer) AbstractC7758be.m47739b(strM39981m, ParamFromServer.class, new Class[0])) == null) {
            return false;
        }
        if (TextUtils.isEmpty(paramFromServer.m40379a()) && TextUtils.isEmpty(paramFromServer.m40381b())) {
            return false;
        }
        if (m46805a(content.m39906U())) {
            AbstractC7185ho.m43820b("RewardAdProcessor", "v3 data");
            return true;
        }
        VideoInfo videoInfoM40305d = metaDataM39944c.m40305d();
        String strM40274K = metaDataM39944c.m40274K();
        if (videoInfoM40305d == null && !TextUtils.isEmpty(strM40274K)) {
            AbstractC7185ho.m43820b("RewardAdProcessor", "use vastInfo");
            C7590ps.m46938a(metaDataM39944c, C7590ps.m46929a(metaDataM39944c, 7, content.m39958f()), 7, false);
            content.m39942b(AbstractC7758be.m47742b(metaDataM39944c));
            videoInfoM40305d = metaDataM39944c.m40305d();
        }
        return videoInfoM40305d != null && videoInfoM40305d.m40477b() > 0 && ((long) videoInfoM40305d.m40481c()) < 209715200;
    }

    /* renamed from: a */
    private boolean m46805a(Integer num) {
        return num != null && 3 == num.intValue();
    }
}
