package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Template;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.AdParseConfig;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.inter.listeners.ContentIdListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7803cw;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.utils.C7826e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.openalliance.ad.pe */
/* loaded from: classes8.dex */
public class C7571pe implements InterfaceC7617qs {

    /* renamed from: a */
    private static final String f35288a = "pe";

    /* renamed from: b */
    private AdContentRsp f35289b;

    /* renamed from: c */
    private a f35290c;

    /* renamed from: d */
    private InterfaceC7140fx f35291d;

    /* renamed from: e */
    private InterfaceC7146gc f35292e;

    /* renamed from: f */
    private String f35293f;

    /* renamed from: g */
    private Context f35294g;

    /* renamed from: h */
    private boolean f35295h;

    /* renamed from: i */
    private int f35296i;

    /* renamed from: j */
    private ContentIdListener f35297j;

    /* renamed from: k */
    private boolean f35298k;

    /* renamed from: l */
    private boolean f35299l;

    /* renamed from: m */
    private boolean f35300m;

    /* renamed from: com.huawei.openalliance.ad.pe$a */
    public interface a {
        /* renamed from: a */
        void mo44135a(int i10);

        /* renamed from: a */
        void mo44137a(Map<String, List<INativeAd>> map);
    }

    /* renamed from: com.huawei.openalliance.ad.pe$b */
    public class b implements Callable<Void> {

        /* renamed from: b */
        private long f35313b;

        /* renamed from: c */
        private boolean[] f35314c;

        /* renamed from: d */
        private byte[] f35315d;

        /* renamed from: e */
        private String f35316e;

        /* renamed from: f */
        private String f35317f;

        /* renamed from: g */
        private List<INativeAd> f35318g;

        /* renamed from: h */
        private Content f35319h;

        public b(long j10, boolean[] zArr, byte[] bArr, String str, String str2, List<INativeAd> list, Content content) {
            this.f35313b = j10;
            this.f35314c = zArr;
            this.f35315d = bArr;
            this.f35316e = str;
            this.f35317f = str2;
            this.f35318g = list;
            this.f35319h = content;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            return C7571pe.this.m46715a(this.f35313b, this.f35314c, this.f35315d, this.f35316e, this.f35317f, this.f35318g, this.f35319h);
        }
    }

    public C7571pe(Context context, a aVar, int i10, boolean z10) {
        this(context, aVar, z10);
        this.f35296i = i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7617qs
    /* renamed from: c */
    public void mo46740c(boolean z10) {
        this.f35300m = z10;
    }

    public C7571pe(final Context context, a aVar, boolean z10) {
        this.f35295h = false;
        this.f35296i = 3;
        this.f35298k = false;
        this.f35299l = false;
        this.f35300m = false;
        this.f35294g = context.getApplicationContext();
        this.f35290c = aVar;
        this.f35291d = C7118fb.m43196a(context);
        this.f35292e = C7124fh.m43316b(context);
        if (z10) {
            AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.pe.1
                @Override // java.lang.Runnable
                public void run() {
                    C7571pe c7571pe = C7571pe.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(AbstractC7803cw.m48133c(context));
                    String str = File.separator;
                    sb2.append(str);
                    sb2.append(Constants.PPS_ROOT_PATH);
                    sb2.append(str);
                    sb2.append(Constants.VIDEO_SUB_DIR);
                    sb2.append(str);
                    c7571pe.f35293f = sb2.toString();
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AbstractC7803cw.m48133c(context));
        String str = File.separator;
        sb2.append(str);
        sb2.append(Constants.PPS_ROOT_PATH);
        sb2.append(str);
        sb2.append(Constants.VIDEO_SUB_DIR);
        sb2.append(str);
        this.f35293f = sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public ImageInfo m46711a(C7302e c7302e) {
        List<ImageInfo> imageInfos = c7302e.getImageInfos();
        if (AbstractC7760bg.m47767a(imageInfos)) {
            return null;
        }
        return imageInfos.get(0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7617qs
    /* renamed from: b */
    public void mo46738b(boolean z10) {
        this.f35295h = z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7617qs
    /* renamed from: b */
    public boolean mo46739b() {
        return this.f35300m;
    }

    /* renamed from: a */
    private C7302e m46713a(String str, Content content, byte[] bArr, MetaData metaData) {
        return C7570pd.m46700a(str, content, bArr, this.f35296i, this.f35298k, metaData);
    }

    /* renamed from: b */
    private boolean m46730b(int i10) {
        if (99 != i10) {
            return false;
        }
        String strM42836a = C7084e.m42836a();
        return !TextUtils.isEmpty(strM42836a) && 30461200 <= Integer.parseInt(strM42836a);
    }

    /* renamed from: b */
    private boolean m46731b(C7302e c7302e) {
        return c7302e.getVideoInfo() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Void m46715a(long j10, boolean[] zArr, byte[] bArr, String str, String str2, List<INativeAd> list, Content content) {
        String str3;
        String str4;
        if (content == null) {
            str3 = f35288a;
            str4 = "parser, content is null";
        } else {
            content.m39925a(this.f35289b.m40847h(), this.f35296i);
            MetaData metaDataM39944c = content.m39944c();
            if (metaDataM39944c != null) {
                C7302e c7302eM46713a = m46713a(str, content, bArr, metaDataM39944c);
                c7302eM46713a.m44644i(this.f35289b.m40851k());
                c7302eM46713a.m44670v(this.f35289b.m40852l());
                c7302eM46713a.m44621c(this.f35289b.m40855o());
                c7302eM46713a.m44849k(this.f35289b.m40834d());
                c7302eM46713a.m44654n(this.f35289b.m40857q());
                c7302eM46713a.m44656o(this.f35289b.m40858r());
                c7302eM46713a.m44778S(str2);
                c7302eM46713a.m44668u(this.f35289b.m40862v());
                if ((c7302eM46713a.m44808ad() == null || c7302eM46713a.m44808ad().intValue() != 3) ? m46723a(j10, str, list, c7302eM46713a) : new C7624qz(this.f35294g, this.f35299l, this.f35300m, this.f35295h).m47062a(j10, str, list, c7302eM46713a, this.f35290c)) {
                    zArr[0] = true;
                }
                m46718a(metaDataM39944c);
                return null;
            }
            str3 = f35288a;
            str4 = "parser, metaData is null";
        }
        AbstractC7185ho.m43820b(str3, str4);
        return null;
    }

    /* renamed from: b */
    private boolean m46732b(List<Ad30> list) {
        Iterator<Ad30> it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            List<Content> listM39428c = it.next().m39428c();
            if (!AbstractC7760bg.m47767a(listM39428c) && (size = size + listM39428c.size()) > 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7617qs
    /* renamed from: a */
    public void mo46733a(int i10) {
        this.f35296i = i10;
    }

    /* renamed from: a */
    private void m46717a(long j10, AdParseConfig adParseConfig) {
        String str;
        ArrayList arrayList;
        Vector vector;
        AbstractC7185ho.m43820b(f35288a, "parser");
        this.f35298k = adParseConfig.m44000c();
        AdContentRsp adContentRsp = this.f35289b;
        if (adContentRsp == null) {
            this.f35290c.mo44135a(ErrorCode.ERROR_CODE_OTHER);
            return;
        }
        ContentIdListener contentIdListener = this.f35297j;
        if (contentIdListener != null) {
            contentIdListener.mo45026a(adContentRsp.m40834d());
        }
        List<Ad30> listM40830c = this.f35289b.m40830c();
        if (AbstractC7760bg.m47767a(listM40830c)) {
            this.f35290c.mo44135a(ErrorCode.ERROR_NATIVE_AD_NO);
            return;
        }
        boolean zM43998a = adParseConfig.m43998a();
        if (zM43998a) {
            zM43998a = m46732b(listM40830c);
        }
        boolean z10 = zM43998a;
        m46721a(this.f35289b.m40849i());
        HashMap map = new HashMap(0);
        boolean[] zArr = {false};
        byte[] bArrM48089b = AbstractC7796cp.m48089b(this.f35294g);
        Vector vector2 = new Vector();
        ArrayList arrayList2 = new ArrayList();
        for (Ad30 ad30 : listM40830c) {
            String strM39419a = ad30.m39419a();
            int iM39424b = ad30.m39424b();
            if (200 != iM39424b) {
                AbstractC7185ho.m43821b(f35288a, "ad failed, retcode30: %s, slotId: %s.", Integer.valueOf(iM39424b), strM39419a);
            }
            List<Content> listM39428c = ad30.m39428c();
            String strM39432e = ad30.m39432e();
            if (AbstractC7760bg.m47767a(listM39428c)) {
                AbstractC7185ho.m43820b(f35288a, "parser, contents is empty");
            } else {
                for (Content content : listM39428c) {
                    if (z10) {
                        str = strM39419a;
                        arrayList = arrayList2;
                        vector = vector2;
                        arrayList.add(new b(j10, zArr, bArrM48089b, strM39419a, strM39432e, vector2, content));
                    } else {
                        str = strM39419a;
                        arrayList = arrayList2;
                        vector = vector2;
                        m46715a(j10, zArr, bArrM48089b, str, strM39432e, vector, content);
                    }
                    vector2 = vector;
                    arrayList2 = arrayList;
                    strM39419a = str;
                }
            }
        }
        ArrayList arrayList3 = arrayList2;
        Vector vector3 = vector2;
        if (z10 && !arrayList3.isEmpty()) {
            AbstractC7834m.m48476a(arrayList3, RippleView.SINGLE_RIPPLE_TIME);
        }
        if (!vector3.isEmpty()) {
            m46722a(map, vector3);
        }
        if (!map.isEmpty()) {
            this.f35290c.mo44137a(map);
            return;
        }
        AbstractC7185ho.m43820b(f35288a, "parser, nativeAdsMap is empty");
        if (zArr[0]) {
            return;
        }
        this.f35290c.mo44135a(ErrorCode.ERROR_NATIVE_AD_NO);
    }

    /* renamed from: a */
    private void m46718a(MetaData metaData) {
        if (metaData == null || metaData.m40275L() == null) {
            return;
        }
        C7826e.m48392a(this.f35294g, metaData.m40275L());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7617qs
    /* renamed from: a */
    public void mo46734a(AdContentRsp adContentRsp, long j10, AdParseConfig adParseConfig) {
        try {
            this.f35289b = adContentRsp;
            m46717a(j10, adParseConfig);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(f35288a, "parse ad err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m46719a(ImageInfo imageInfo, String str) {
        if (imageInfo.getWidth() <= 0 || imageInfo.getHeight() <= 0) {
            Rect rectM47685a = C7752az.m47685a(str);
            int iWidth = rectM47685a.width();
            int iHeight = rectM47685a.height();
            if (iWidth <= 0 || iHeight <= 0) {
                return;
            }
            imageInfo.m44475b(iWidth);
            imageInfo.m44471a(iHeight);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7617qs
    /* renamed from: a */
    public void mo46735a(ContentIdListener contentIdListener) {
        this.f35297j = contentIdListener;
    }

    /* renamed from: a */
    private void m46720a(final String str, final C7302e c7302e, final long j10) {
        AbstractC7185ho.m43821b(f35288a, "dealVideo, adId: %s, directCacheVideo: %s.", str, Boolean.valueOf(this.f35300m));
        AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.pe.3
            @Override // java.lang.Runnable
            public void run() {
                VideoInfo videoInfo = c7302e.getVideoInfo();
                ImageInfo imageInfoM46711a = C7571pe.this.m46711a(c7302e);
                if (C7571pe.this.m46726a(c7302e, videoInfo, imageInfoM46711a) && C7571pe.this.m46725a(c7302e, j10, videoInfo, imageInfoM46711a)) {
                    if (C7780c.m47863a(C7571pe.this.f35294g, c7302e.m44809ae(), c7302e.getSlotId(), c7302e.m44632e())) {
                        c7302e.m44602a(99);
                        c7302e.m44618b(true);
                    }
                    HashMap map = new HashMap();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(c7302e);
                    C7780c.m47860a(map, str, arrayList);
                    C7571pe.this.f35290c.mo44137a(map);
                }
            }
        });
    }

    /* renamed from: a */
    private void m46721a(List<Template> list) {
        new C7584pr(this.f35294g).mo46844a(list);
    }

    /* renamed from: a */
    private static void m46722a(Map<String, List<INativeAd>> map, List<INativeAd> list) {
        if (map == null || list == null || list.isEmpty()) {
            return;
        }
        for (INativeAd iNativeAd : list) {
            String slotId = ((C7302e) iNativeAd).getSlotId();
            List<INativeAd> arrayList = map.get(slotId);
            if (AbstractC7760bg.m47767a(arrayList)) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(iNativeAd);
            map.put(slotId, arrayList);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7617qs
    /* renamed from: a */
    public void mo46736a(boolean z10) {
        this.f35299l = z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7617qs
    /* renamed from: a */
    public boolean mo46737a() {
        return this.f35295h;
    }

    /* renamed from: a */
    private boolean m46723a(final long j10, String str, List<INativeAd> list, final C7302e c7302e) {
        boolean z10 = true;
        if (this.f35299l && m46731b(c7302e)) {
            c7302e.m44844i(true);
        }
        if (this.f35299l || !m46731b(c7302e)) {
            String str2 = f35288a;
            AbstractC7185ho.m43820b(str2, "parser, add nativeAd");
            if (C7780c.m47863a(this.f35294g, c7302e.m44809ae(), c7302e.getSlotId(), c7302e.m44632e())) {
                c7302e.m44602a(99);
            }
            list.add(c7302e);
            z10 = false;
            if (m46730b(c7302e.getCreativeType())) {
                AbstractC7185ho.m43820b(str2, "use engine down");
                return false;
            }
            if (this.f35300m && m46731b(c7302e)) {
                AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.pe.2
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoInfo videoInfo = c7302e.getVideoInfo();
                        ImageInfo imageInfoM46711a = C7571pe.this.m46711a(c7302e);
                        if (C7571pe.this.m46726a(c7302e, videoInfo, imageInfoM46711a)) {
                            C7571pe.this.m46725a(c7302e, j10, videoInfo, imageInfoM46711a);
                        }
                    }
                });
            }
        } else {
            m46720a(str, c7302e, j10);
        }
        return z10;
    }

    /* renamed from: a */
    private boolean m46724a(VideoInfo videoInfo) {
        if (this.f35295h || this.f35300m || videoInfo.getDownloadNetwork() == 1) {
            return true;
        }
        return videoInfo.getDownloadNetwork() == 0 && C7775bv.m47829c(this.f35294g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m46725a(C7302e c7302e, long j10, VideoInfo videoInfo, ImageInfo imageInfo) {
        if (this.f35292e.mo43334aA() + 86400000 < AbstractC7741ao.m47566c()) {
            this.f35292e.mo43370b(AbstractC7741ao.m47566c());
            AbstractC7731ae.m47445a(this.f35293f, 604800000L);
        }
        ContentRecord contentRecordM46698a = C7570pd.m46698a(c7302e);
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47169a(contentRecordM46698a);
        c7653sb.m47187d(imageInfo.getUrl());
        c7653sb.m47167a(imageInfo.m44470a());
        c7653sb.m47184c(imageInfo.getSha256());
        c7653sb.m47181b(imageInfo.isCheckSha256());
        c7653sb.m47180b(Constants.VIDEO_SUB_DIR);
        c7653sb.m47171a(Long.valueOf(j10));
        c7653sb.m47185c(true);
        C7654sc c7654scMo43274a = this.f35291d.mo43274a(c7653sb);
        if (c7654scMo43274a == null || AbstractC7806cz.m48165b(c7654scMo43274a.m47207a())) {
            AbstractC7185ho.m43823c(f35288a, "dealVideo, download cover failed!");
            return false;
        }
        imageInfo.m44479c(c7654scMo43274a.m47207a());
        m46719a(imageInfo, c7654scMo43274a.m47207a());
        if (1 == videoInfo.getVideoPlayMode() || this.f35300m) {
            String str = f35288a;
            AbstractC7185ho.m43820b(str, "cacheVideo");
            C7653sb c7653sb2 = new C7653sb();
            c7653sb2.m47169a(contentRecordM46698a);
            c7653sb2.m47187d(videoInfo.getVideoDownloadUrl());
            c7653sb2.m47167a(videoInfo.m44559a());
            c7653sb2.m47184c(videoInfo.getSha256());
            c7653sb2.m47181b(videoInfo.isCheckSha256());
            c7653sb2.m47180b(Constants.VIDEO_SUB_DIR);
            c7653sb2.m47173a(true);
            c7653sb2.m47171a(Long.valueOf(j10));
            c7653sb2.m47185c(true);
            C7654sc c7654scMo43274a2 = this.f35291d.mo43274a(c7653sb2);
            if (c7654scMo43274a2 == null || AbstractC7806cz.m48165b(c7654scMo43274a2.m47207a())) {
                AbstractC7185ho.m43823c(str, "dealVideo, download video failed!");
                return false;
            }
            String strM47207a = c7654scMo43274a2.m47207a();
            videoInfo.m44563a(strM47207a);
            contentRecordM46698a.m41571i(strM47207a);
            c7302e.mo44499y(strM47207a);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m46726a(final C7302e c7302e, VideoInfo videoInfo, ImageInfo imageInfo) {
        if (videoInfo == null || imageInfo == null || c7302e == null) {
            return false;
        }
        if (1 != videoInfo.getVideoPlayMode() || m46724a(videoInfo)) {
            return true;
        }
        AbstractC7185ho.m43824c(f35288a, "cache mode video is only allowed to download in network %d", Integer.valueOf(videoInfo.getDownloadNetwork()));
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.pe.4
            @Override // java.lang.Runnable
            public void run() {
                new C6922c(C7571pe.this.f35294g).m39112b(C7570pd.m46698a(c7302e));
            }
        });
        return false;
    }
}
