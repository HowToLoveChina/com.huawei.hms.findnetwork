package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.ParamFromServer;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7826e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.oy */
/* loaded from: classes8.dex */
public class C7564oy {

    /* renamed from: a */
    private Context f35259a;

    /* renamed from: b */
    private a f35260b;

    /* renamed from: c */
    private AdContentRsp f35261c;

    /* renamed from: d */
    private C7076dt f35262d = C7076dt.m42678h();

    /* renamed from: e */
    private InterfaceC7140fx f35263e;

    /* renamed from: com.huawei.openalliance.ad.oy$a */
    public interface a {
        /* renamed from: a */
        void mo45001a(int i10);

        /* renamed from: a */
        void mo45013a(Map<String, List<InterfaceC7299b>> map);
    }

    public C7564oy(Context context, a aVar) {
        this.f35259a = context;
        this.f35260b = aVar;
        this.f35263e = C7118fb.m43196a(context);
    }

    /* renamed from: a */
    private List<InterfaceC7299b> m46659a(Ad30 ad30, byte[] bArr) {
        ImageInfo imageInfo;
        ArrayList arrayList = null;
        if (ad30 != null && !TextUtils.isEmpty(ad30.m39419a())) {
            String strM39419a = ad30.m39419a();
            String strM39434g = ad30.m39434g();
            List<Content> listM39428c = ad30.m39428c();
            if (AbstractC7760bg.m47767a(listM39428c)) {
                AbstractC7185ho.m43823c("InterstitialAdProcessor", "content is null" + strM39419a);
                return null;
            }
            arrayList = new ArrayList(4);
            for (Content content : listM39428c) {
                if (content != null) {
                    AdContentRsp adContentRsp = this.f35261c;
                    if (adContentRsp != null) {
                        content.m39925a(adContentRsp.m40847h(), 12);
                    }
                    MetaData metaDataM39944c = content.m39944c();
                    if (metaDataM39944c == null || !m46664a(content)) {
                        AbstractC7185ho.m43826d("InterstitialAdProcessor", "content is invalid:" + content.m39962g());
                    } else {
                        ContentRecord contentRecordM46744a = AbstractC7572pf.m46744a(strM39419a, content, 12, strM39434g);
                        contentRecordM46744a.m41857a(bArr);
                        contentRecordM46744a.m41618y(this.f35261c.m40851k());
                        contentRecordM46744a.m41479ab(this.f35261c.m40852l());
                        contentRecordM46744a.m41592o(this.f35261c.m40855o());
                        contentRecordM46744a.m41422T(this.f35261c.m40862v());
                        C7301d c7301dM46655a = C7563ox.m46655a(strM39419a, content, bArr);
                        c7301dM46655a.m44644i(this.f35261c.m40851k());
                        c7301dM46655a.m44670v(this.f35261c.m40852l());
                        c7301dM46655a.m44621c(this.f35261c.m40855o());
                        c7301dM46655a.m44654n(this.f35261c.m40857q());
                        c7301dM46655a.m44656o(this.f35261c.m40858r());
                        c7301dM46655a.m44668u(this.f35261c.m40862v());
                        BiddingInfo.C7295a lurl = new BiddingInfo.C7295a().m44455a(content.m39932ag()).m44454a(content.m39933ah()).m44457b(content.m39934ai()).setLurl(content.m39935aj());
                        if (!lurl.m44456a().m44449a()) {
                            c7301dM46655a.m44608a(lurl.m44456a());
                        }
                        if (metaDataM39944c.m40305d() != null) {
                            m46661a(metaDataM39944c.m40305d(), content.m39962g(), strM39419a, content.m39894I());
                        }
                        List<ImageInfo> listM40334p = metaDataM39944c.m40334p();
                        if (listM40334p != null && listM40334p.size() > 0 && (imageInfo = listM40334p.get(0)) != null) {
                            m46663a(contentRecordM46744a, imageInfo, c7301dM46655a);
                        }
                        m46662a(contentRecordM46744a);
                        arrayList.add(c7301dM46655a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m46660a(ImageInfo imageInfo, String str) {
        if (imageInfo.m40183d() <= 0 || imageInfo.m40185e() <= 0) {
            Rect rectM47685a = C7752az.m47685a(str);
            int iWidth = rectM47685a.width();
            int iHeight = rectM47685a.height();
            if (iWidth <= 0 || iHeight <= 0) {
                return;
            }
            imageInfo.m40175a(iWidth);
            imageInfo.m40178b(iHeight);
        }
    }

    /* renamed from: a */
    private void m46661a(final VideoInfo videoInfo, final String str, final String str2, final Integer num) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.oy.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43818a("InterstitialAdProcessor", "download interstitialad video:%s", AbstractC7819dl.m48375a(videoInfo.m40471a()));
                C7074dr c7074dr = new C7074dr(videoInfo.m40471a(), videoInfo.m40481c(), videoInfo.m40496i() == 0, videoInfo.m40493g(), null, videoInfo.m40499l() == 1, 1, str, str2, 12, false, C7564oy.this.f35261c.m40855o());
                c7074dr.m42638a(num);
                C7564oy.this.f35262d.m42680a(c7074dr);
            }
        });
    }

    /* renamed from: a */
    public void m46666a(AdContentRsp adContentRsp) {
        a aVar;
        AbstractC7185ho.m43820b("InterstitialAdProcessor", "parser");
        if (adContentRsp == null) {
            a aVar2 = this.f35260b;
            if (aVar2 != null) {
                aVar2.mo45001a(ErrorCode.ERROR_CODE_OTHER);
            }
            AbstractC7185ho.m43823c("InterstitialAdProcessor", "response is null");
            return;
        }
        this.f35261c = adContentRsp;
        List<Ad30> listM40830c = adContentRsp.m40830c();
        HashMap map = new HashMap(4);
        byte[] bArrM48089b = AbstractC7796cp.m48089b(this.f35259a);
        if (AbstractC7760bg.m47767a(listM40830c)) {
            AbstractC7185ho.m43820b("InterstitialAdProcessor", "response ads is isEmpty");
            aVar = this.f35260b;
            if (aVar == null) {
                return;
            }
        } else {
            for (Ad30 ad30 : listM40830c) {
                String strM39419a = ad30.m39419a();
                int iM39424b = ad30.m39424b();
                if (200 != iM39424b) {
                    AbstractC7185ho.m43821b("InterstitialAdProcessor", "ad failed, retcode30: %s, slotId: %s.", Integer.valueOf(iM39424b), strM39419a);
                }
                List<InterfaceC7299b> listM46659a = m46659a(ad30, bArrM48089b);
                if (!AbstractC7760bg.m47767a(listM46659a)) {
                    map.put(strM39419a, listM46659a);
                }
            }
            AbstractC7185ho.m43821b("InterstitialAdProcessor", "interstitialAdMap empty: %s", Boolean.valueOf(C7765bl.m47802a(map)));
            if (this.f35260b == null) {
                return;
            }
            boolean zM47802a = C7765bl.m47802a(map);
            aVar = this.f35260b;
            if (!zM47802a) {
                aVar.mo45013a(map);
                return;
            }
        }
        aVar.mo45001a(204);
    }

    /* renamed from: a */
    private void m46662a(ContentRecord contentRecord) {
        if (contentRecord == null || contentRecord.m41568i() == null || contentRecord.m41568i().m40275L() == null) {
            return;
        }
        C7826e.m48392a(this.f35259a, contentRecord.m41568i().m40275L());
    }

    /* renamed from: a */
    private void m46663a(ContentRecord contentRecord, ImageInfo imageInfo, C7301d c7301d) {
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47169a(contentRecord);
        c7653sb.m47187d(imageInfo.m40180c());
        c7653sb.m47167a(52428800L);
        c7653sb.m47184c(imageInfo.m40174a());
        c7653sb.m47181b(imageInfo.m40187g() == 0);
        c7653sb.m47180b(Constants.AD_MATERIAL_SUB_DIR);
        c7653sb.m47185c(true);
        c7653sb.m47171a(Long.valueOf(System.currentTimeMillis()));
        C7654sc c7654scMo43274a = this.f35263e.mo43274a(c7653sb);
        if (c7654scMo43274a == null || AbstractC7806cz.m48165b(c7654scMo43274a.m47207a())) {
            AbstractC7185ho.m43823c("InterstitialAdProcessor", "download image failed");
        } else {
            c7301d.m44707O(c7654scMo43274a.m47207a());
            m46660a(imageInfo, c7654scMo43274a.m47207a());
        }
    }

    /* renamed from: a */
    private boolean m46664a(Content content) {
        String strM39981m;
        ParamFromServer paramFromServer;
        if (content == null || TextUtils.isEmpty(content.m39962g()) || content.m39977k() <= 0 || content.m39944c() == null || (strM39981m = content.m39981m()) == null || (paramFromServer = (ParamFromServer) AbstractC7758be.m47739b(strM39981m, ParamFromServer.class, new Class[0])) == null) {
            return false;
        }
        return (TextUtils.isEmpty(paramFromServer.m40379a()) && TextUtils.isEmpty(paramFromServer.m40381b())) ? false : true;
    }
}
