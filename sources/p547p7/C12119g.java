package p547p7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.SQLException;
import android.text.TextUtils;
import bb.C1160a;
import com.huawei.android.hicloud.album.service.p075vo.FailRet;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.hicloud.drive.asset.AssetMetadataTransport;
import com.huawei.android.hicloud.drive.asset.C2797a;
import com.huawei.android.hicloud.drive.asset.C2798b;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Attachment;
import com.huawei.android.hicloud.drive.cloudphoto.model.Cipher;
import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaAssetAttribute;
import com.huawei.android.hicloud.drive.cloudphoto.model.Resource;
import com.huawei.android.hicloud.drive.cloudphoto.model.RevisionCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.request.Assets;
import com.huawei.android.hicloud.drive.cloudphoto.request.Medias;
import com.huawei.android.hicloud.p081cs.bean.Thumbnail;
import com.huawei.android.p069cg.manager.CloudAlbumReFoundManager;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.AbstractC1139t;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1128i;
import p031b7.C1136q;
import p031b7.C1141v;
import p031b7.InterfaceC1126g;
import p283fa.C9678a;
import p332ha.C10130a;
import p332ha.C10134e;
import p429kk.C11058a;
import p429kk.C11060c;
import p546p6.C12109v;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p649t6.C12952l;
import p709vj.C13452e;
import p804ya.C13924a;

/* renamed from: p7.g */
/* loaded from: classes2.dex */
public class C12119g extends AbstractC12367d implements AssetMetadataTransport {

    /* renamed from: b */
    public String f56217b;

    /* renamed from: c */
    public C13924a f56218c;

    /* renamed from: d */
    public String f56219d;

    /* renamed from: e */
    public CommonOpsReport f56220e;

    /* renamed from: f */
    public C12952l f56221f;

    /* renamed from: g */
    public C2797a f56222g;

    /* renamed from: h */
    public a f56223h;

    /* renamed from: a */
    public final AtomicBoolean f56216a = new AtomicBoolean(false);

    /* renamed from: i */
    public volatile boolean f56224i = false;

    /* renamed from: p7.g$a */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1120a.m6676e("ScreenReceiver", "Intent is null!");
                return;
            }
            String action = new SafeIntent(intent).getAction();
            C1120a.m6675d("ScreenReceiver", "onReceive: " + action);
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                C1120a.m6677i("ScreenReceiver", "action screen off");
                C12119g.this.f56224i = false;
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                C1120a.m6677i("ScreenReceiver", "action user present");
                C12119g.this.f56224i = true;
            }
        }
    }

    /* renamed from: l */
    private String m72648l(Attachment attachment) {
        if (attachment == null) {
            C1120a.m6678w("ThumbFixTask", "getAssetId thumbnail is null");
            return "";
        }
        Asset asset = attachment.getAsset();
        return asset != null ? asset.getId() : "";
    }

    /* renamed from: A */
    public final void m72649A() {
        try {
            if (this.f56223h != null) {
                C0213f.m1377a().unregisterReceiver(this.f56223h);
            }
            C1120a.m6677i("ThumbFixTask", "unregisterReceiver");
        } catch (Exception e10) {
            C1120a.m6678w("ThumbFixTask", "unregisterReceiver error: " + e10);
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C13924a c13924aM60445d;
        String str = "";
        try {
            try {
                try {
                    C1120a.m6677i("ThumbFixTask", "start ThumbFixTask");
                    this.f56219d = C1122c.m6755Z0("04021");
                    this.f56220e = new CommonOpsReport(C0213f.m1377a());
                    c13924aM60445d = C9678a.m60442e().m60445d();
                    this.f56218c = c13924aM60445d;
                } catch (C9721b e10) {
                    this.f56220e.m15213G(this.f56219d, e10.m60658b(), "101_" + e10.m60662f() + ":1", e10.toString());
                    str = "ThumbFixTask CException: " + e10.m60658b() + ", " + e10;
                    C1120a.m6676e("ThumbFixTask", str);
                }
            } catch (Exception e11) {
                this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 2, e11.toString());
                str = "ThumbFixTask Exception: " + e11;
                C1120a.m6676e("ThumbFixTask", str);
            }
            if (c13924aM60445d == null) {
                C1120a.m6676e("ThumbFixTask", "cloudPhoto is null");
                C1120a.m6677i("ThumbFixTask", "ThumbFixTask finish");
                m72649A();
                C12109v.m72524c().m72531h();
                CloudAlbumReFoundManager.m14515b().m14524j("cloudPhoto is null");
                return;
            }
            this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_add", 0, "success");
            C12952l c12952l = new C12952l();
            this.f56221f = c12952l;
            ArrayList<C12118f> arrayListM77874m = c12952l.m77874m();
            this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 0, "thumbFixBeans size = " + arrayListM77874m.size());
            if (arrayListM77874m.isEmpty()) {
                C1120a.m6677i("ThumbFixTask", "thumbFixBeans is empty");
            } else {
                C1120a.m6677i("ThumbFixTask", "thumbFixBeans size: " + arrayListM77874m.size());
                m72666v();
                m72656k(arrayListM77874m);
            }
            C1136q.m6957O(System.currentTimeMillis());
        } finally {
            C1120a.m6677i("ThumbFixTask", "ThumbFixTask finish");
            m72649A();
            C12109v.m72524c().m72531h();
            CloudAlbumReFoundManager.m14515b().m14524j("");
        }
    }

    /* renamed from: d */
    public final void m72650d(String str) throws C9721b {
        if (this.f56216a.get()) {
            C1120a.m6676e("ThumbFixTask", "cancel task cmd: " + str);
            String str2 = this.f56217b;
            if (str2 == null) {
                str2 = "Canceled";
            }
            throw new C9721b(1001, str2, str);
        }
    }

    /* renamed from: e */
    public final void m72651e(String str) throws C9721b, SQLException {
        new C10134e.b(str).m63171s().m63147a(C10130a.m63054c());
    }

    /* renamed from: f */
    public final Asset m72652f(File file, File file2, String str, String str2, String str3, String str4, C12118f c12118f) throws Throwable {
        try {
            RevisionCreateRequest revisionCreateRequest = new RevisionCreateRequest();
            Resource resource = new Resource();
            resource.setLength(Long.valueOf(file.length() + file2.length()));
            MediaAssetAttribute mediaAssetAttribute = new MediaAssetAttribute();
            MediaAssetAttribute.SmallLargePair smallLargePair = new MediaAssetAttribute.SmallLargePair();
            smallLargePair.setSmall(Long.valueOf(file.length()));
            smallLargePair.setLarge(Long.valueOf(file2.length()));
            mediaAssetAttribute.set("length", (Object) smallLargePair);
            MediaAssetAttribute.SmallLargeStrPair smallLargeStrPair = new MediaAssetAttribute.SmallLargeStrPair();
            C2798b.a aVarM16331l = C2798b.m16331l(file);
            C2798b.a aVarM16331l2 = C2798b.m16331l(file2);
            smallLargeStrPair.setSmall(aVarM16331l.m16340a());
            smallLargeStrPair.setLarge(aVarM16331l2.m16340a());
            mediaAssetAttribute.set("sha256", (Object) smallLargeStrPair);
            resource.setHash(str);
            resource.setSha256(str2);
            resource.setAttributes(mediaAssetAttribute);
            C2797a c2797a = new C2797a(this);
            this.f56222g = c2797a;
            c2797a.m16304a0(str3);
            Cipher cipherM16299U = this.f56222g.m16299U(str4, true);
            revisionCreateRequest.setResource(resource);
            revisionCreateRequest.setCipher(cipherM16299U);
            if (TextUtils.isEmpty(c12118f.m72630a())) {
                Assets.Create createAddHeader = this.f56218c.m83549f().create(c12118f.m72634e(), "cipher,id,versionId,resource,state", revisionCreateRequest).setUsage("thumbnail").addHeader("x-hw-lock", (Object) m72659o());
                createAddHeader.setAlbumClientHeader(this.f56219d);
                return createAddHeader.execute();
            }
            Assets.Revisions.Create createAddHeader2 = this.f56218c.m83549f().revisions().create(c12118f.m72634e(), c12118f.m72630a(), "cipher,id,versionId,resource,state", revisionCreateRequest).setUsage("thumbnail").addHeader("x-hw-lock", (Object) m72659o());
            createAddHeader2.setAlbumClientHeader(this.f56219d);
            return createAddHeader2.execute();
        } catch (C4616s e10) {
            C1120a.m6676e("ThumbFixTask", "createThumbnailFromCloud HttpResponseException." + e10);
            throw new C9721b(e10.m28322f(), e10.m28322f(), e10.toString(), "createThumbnailFromCloud", C1160a.m7253d(e10));
        } catch (IOException e11) {
            C1120a.m6676e("ThumbFixTask", "createThumbnailFromCloud IOException." + e11);
            throw new C9721b(12, "createThumbnailFromCloud IOException." + e11, "createThumbnailFromCloud");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:171|6|(4:(11:(21:8|(1:10)|19|20|177|21|179|22|175|23|24|155|25|(3:26|27|(5:29|174|30|(1:183)(2:34|184)|41)(1:181))|42|43|(2:151|45)|153|49|53|54)(1:18)|155|25|(4:26|27|(0)(0)|41)|42|43|(0)|153|49|53|54)|175|23|24)|11|19|20|177|21|179|22) */
    /* JADX WARN: Can't wrap try/catch for region: R(23:171|6|(21:8|(1:10)|19|20|177|21|179|22|175|23|24|155|25|(3:26|27|(5:29|174|30|(1:183)(2:34|184)|41)(1:181))|42|43|(2:151|45)|153|49|53|54)(1:18)|11|19|20|177|21|179|22|175|23|24|155|25|(4:26|27|(0)(0)|41)|42|43|(0)|153|49|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0149, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014a, code lost:
    
        p031b7.C1120a.m6676e("ThumbFixTask", "download inputStream close error, message:" + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0184, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0185, code lost:
    
        r1 = r0;
        r8 = r13;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0189, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018a, code lost:
    
        r7 = ", exception: ";
        r8 = r13;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018f, code lost:
    
        r7 = ", exception: ";
        r9 = r22;
        r8 = r13;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0195, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0196, code lost:
    
        r1 = r0;
        r8 = r13;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0199, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x019b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x019c, code lost:
    
        r7 = ", exception: ";
        r8 = r13;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x019f, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a2, code lost:
    
        r7 = ", exception: ";
        r9 = r22;
        r8 = r13;
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0274 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0254 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0112 A[EDGE_INSN: B:181:0x0112->B:42:0x0112 BREAK  A[LOOP:0: B:26:0x00cf->B:41:0x0109], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079 A[Catch: all -> 0x01a9, Exception -> 0x01ae, b -> 0x01b3, TRY_ENTER, TryCatch #12 {b -> 0x01b3, blocks: (B:4:0x0027, B:19:0x007d, B:18:0x0079), top: B:157:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e3  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m72653g(p547p7.C12118f r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p547p7.C12119g.m72653g(p7.f):boolean");
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.ALBUM_FIX;
    }

    /* renamed from: h */
    public final boolean m72654h(C12118f c12118f) throws C9721b {
        m72650d("downloadByUrl");
        File fileM63442h = C10278a.m63442h(c12118f.m72635f());
        if (fileM63442h.exists() && fileM63442h.isFile()) {
            C1120a.m6677i("ThumbFixTask", "downloadByUrl exist");
            return true;
        }
        if (!TextUtils.isEmpty(m72658n(c12118f))) {
            return m72653g(c12118f);
        }
        C1120a.m6677i("ThumbFixTask", "downloadByUrl empty url");
        return false;
    }

    /* renamed from: j */
    public void m72655j(String str) {
        C1120a.m6676e("ThumbFixTask", "endThumbFix");
        this.f56216a.set(true);
        this.f56217b = str;
        cancel();
    }

    /* renamed from: k */
    public final void m72656k(ArrayList<C12118f> arrayList) throws Throwable {
        Iterator<C12118f> it = arrayList.iterator();
        while (it.hasNext()) {
            C12118f next = it.next();
            m72650d("filterThumbFix");
            C1120a.m6677i("ThumbFixTask", "filterThumbFix " + next.toString());
            if (!m72663s(next) && !m72664t(next)) {
                m72657m(next);
                if (!m72665u(next) && m72654h(next)) {
                    m72667y(next);
                    C12109v.m72524c().m72531h();
                    C1122c.m6694F(next.m72635f() + "_largeThumbnail");
                    C1122c.m6694F(next.m72635f() + "_smallThumbnail");
                    C1122c.m6694F(next.m72635f());
                }
            }
        }
    }

    /* renamed from: m */
    public final void m72657m(C12118f c12118f) throws C9721b {
        String strM6868l = C1124e.m6868l();
        if (TextUtils.isEmpty(strM6868l)) {
            C1120a.m6678w("ThumbFixTask", "getDownloadCachePath invalid parentPath");
            throw new C9721b(3, "invalid parentPath", "getDownloadCachePath");
        }
        String str = strM6868l + c12118f.m72634e();
        if (C1122c.m6797k(str, true)) {
            c12118f.m72645p(strM6868l).m72644o(str);
        } else {
            C1120a.m6678w("ThumbFixTask", "getDownloadCachePath mkdir error");
            throw new C9721b(3, "mkdir error", "getDownloadCachePath");
        }
    }

    /* renamed from: n */
    public final String m72658n(C12118f c12118f) throws SQLException {
        try {
            Medias.Get fields2 = this.f56218c.m83556m().get(c12118f.m72634e()).setFields2("contentDownloadLink,attachments");
            fields2.getHeaders().set("x-hw-trace-id", this.f56219d);
            fields2.setThumbnailInfo(true);
            Media mediaExecute = fields2.execute();
            String contentDownloadLink = mediaExecute.getContentDownloadLink();
            c12118f.m72639j(contentDownloadLink);
            Attachment attachmentM72660p = m72660p(mediaExecute.getAttachments());
            if (!m72662r(attachmentM72660p)) {
                c12118f.m72638i(m72648l(attachmentM72660p));
                return contentDownloadLink;
            }
            this.f56221f.m77870i(c12118f.m72634e());
            C1120a.m6677i("ThumbFixTask", "has been fixed " + c12118f);
            return "";
        } catch (C4616s e10) {
            this.f56221f.m77870i(c12118f.m72634e());
            String str = "getDownloadUrl error " + c12118f + ", ignore: " + e10;
            C1120a.m6676e("ThumbFixTask", str);
            this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 7, str);
            return null;
        } catch (Exception e11) {
            String str2 = "getDownloadUrl error " + c12118f + ", exception: " + e11;
            C1120a.m6676e("ThumbFixTask", str2);
            this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 7, str2);
            return null;
        }
    }

    /* renamed from: o */
    public final String m72659o() throws C9721b {
        Lock lockM72527d = C12109v.m72524c().m72527d();
        if (lockM72527d != null) {
            return lockM72527d.getSessionId();
        }
        throw new C9721b(1001, "lock is null", "getLockToken");
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Asset onCreateUploadUrl(String str, String str2, String str3, Asset asset, AssetMetadataTransport.C2796a c2796a) throws C9721b, IOException {
        Assets.Revisions.Update updateAddHeader = this.f56218c.m83549f().revisions().update(str, str2, str3, "resource(objects(id,uploadUrl,accelerateUploadUrl))", asset).addHeader("x-hw-lock", (Object) m72659o());
        updateAddHeader.setAlbumClientHeader(this.f56219d);
        return updateAddHeader.execute();
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Resource onRefreshDownloadUrl(String str, String str2, String str3, Asset asset) throws IOException {
        return null;
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public void onUploadCompleted(String str, String str2, String str3, Asset asset, boolean z10) throws C9721b, IOException {
        Assets.Revisions.Update updateAddHeader = this.f56218c.m83549f().revisions().update(str, str2, str3, "id", asset).addHeader("x-hw-lock", (Object) m72659o());
        updateAddHeader.setAlbumClientHeader(this.f56219d);
        updateAddHeader.execute();
    }

    /* renamed from: p */
    public final Attachment m72660p(List<Attachment> list) {
        if (list == null) {
            return null;
        }
        for (Attachment attachment : list) {
            if (attachment.getUsage().equalsIgnoreCase("thumbnail")) {
                return attachment;
            }
        }
        return null;
    }

    /* renamed from: q */
    public final InterfaceC1126g m72661q(int i10) {
        return i10 == 4 ? new C1141v() : new C1128i();
    }

    /* renamed from: r */
    public final boolean m72662r(Attachment attachment) {
        if (attachment == null) {
            C1120a.m6678w("ThumbFixTask", "hasBeenFixed thumbnail is null");
            return false;
        }
        Asset asset = attachment.getAsset();
        return (asset == null || asset.getState() == null || asset.getState().intValue() != 0) ? false : true;
    }

    /* renamed from: s */
    public final boolean m72663s(C12118f c12118f) {
        String strM72633d = c12118f.m72633d();
        if (TextUtils.isEmpty(strM72633d)) {
            return false;
        }
        try {
            if (System.currentTimeMillis() - new C4644l(strM72633d).m28458c() < 864000000) {
                String str = "isInFailInterval error " + c12118f;
                C1120a.m6678w("ThumbFixTask", str);
                this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 4, str);
                return true;
            }
        } catch (Exception unused) {
            C1120a.m6678w("ThumbFixTask", "lastFailTime invalid");
        }
        c12118f.m72642m("").m72641l("");
        return false;
    }

    /* renamed from: t */
    public final boolean m72664t(C12118f c12118f) {
        long jM6752Y0 = C1122c.m6752Y0() * 1024 * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        if (c12118f.m72637h().longValue() > 0 && c12118f.m72637h().longValue() <= jM6752Y0) {
            return false;
        }
        String str = "isInvalidSize error " + c12118f + ", thumbFixMaxSize: " + jM6752Y0;
        C1120a.m6678w("ThumbFixTask", str);
        this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 5, str);
        return true;
    }

    /* renamed from: u */
    public final boolean m72665u(C12118f c12118f) {
        long jM6698G0 = C1122c.m6698G0(c12118f.m72636g());
        if (jM6698G0 >= c12118f.m72637h().longValue() + Constants.ONE_GB_SIZE) {
            return false;
        }
        String str = "isLocalSpaceLow error " + c12118f + ", localSpace:" + jM6698G0;
        C1120a.m6678w("ThumbFixTask", str);
        this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 6, str);
        return true;
    }

    /* renamed from: v */
    public final void m72666v() {
        try {
            if (this.f56223h == null) {
                this.f56223h = new a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                C0213f.m1377a().registerReceiver(this.f56223h, intentFilter);
            }
            this.f56224i = C0209d.m1194N1(C0213f.m1377a());
            C1120a.m6677i("ThumbFixTask", "registerReceiver isScreenOn: " + this.f56224i);
        } catch (Exception e10) {
            C1120a.m6678w("ThumbFixTask", "registerReceiver error: " + e10);
        }
    }

    /* renamed from: y */
    public final void m72667y(C12118f c12118f) throws Throwable {
        C12118f c12118f2;
        m72650d("thumbFix");
        try {
            try {
            } catch (C9721b e10) {
                e = e10;
                c12118f2 = c12118f;
            }
            try {
                C1120a.m6677i("ThumbFixTask", "thumbFix upload: " + c12118f.m72634e() + ", " + c12118f.m72630a() + ", " + c12118f.m72632c());
                InterfaceC1126g interfaceC1126gM72661q = m72661q(c12118f.m72632c().intValue());
                String strM72635f = c12118f.m72635f();
                File fileM63442h = C10278a.m63442h(strM72635f);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(strM72635f);
                sb2.append("_largeThumbnail");
                File fileM63442h2 = C10278a.m63442h(sb2.toString());
                if (fileM63442h2.isFile() && fileM63442h2.exists()) {
                    fileM63442h2.delete();
                }
                fileM63442h2.createNewFile();
                AbstractC1139t abstractC1139tMo6901a = interfaceC1126gM72661q.mo6901a();
                FailRet failRet = new FailRet();
                abstractC1139tMo6901a.mo6907b(fileM63442h2, fileM63442h, 100, failRet);
                File fileM63442h3 = C10278a.m63442h(strM72635f + "_smallThumbnail");
                if (fileM63442h3.isFile() && fileM63442h3.exists()) {
                    fileM63442h3.delete();
                }
                fileM63442h3.createNewFile();
                AbstractC1139t abstractC1139tMo6901a2 = interfaceC1126gM72661q.mo6901a();
                FailRet failRet2 = new FailRet();
                abstractC1139tMo6901a2.mo6909e(fileM63442h3, fileM63442h, 100, failRet2);
                C1120a.m6677i("ThumbFixTask", "generateThumbnail end");
                if (fileM63442h2.exists() && fileM63442h3.exists()) {
                    if (fileM63442h2.length() > 2097152 || fileM63442h3.length() > 2097152) {
                        String str = "huge thumb error:" + c12118f.m72634e() + ", large:" + fileM63442h2.length() + ", small:" + fileM63442h3.length();
                        this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 11, str);
                        this.f56221f.m77875n(c12118f.m72634e(), str);
                        C1120a.m6678w("ThumbFixTask", str);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(fileM63442h3);
                    arrayList.add(fileM63442h2);
                    String strM16330k = C2798b.m16330k(arrayList);
                    String strM16336q = C2798b.m16336q(arrayList);
                    String strM16337r = C2798b.m16337r(strM16330k);
                    String str2 = c12118f.m72634e() + "_" + strM16336q + "_thumb_fix";
                    m72651e(str2);
                    C11060c c11060cM66626a = C11058a.m66626a(this.f56219d, "thumbFix", C13452e.m80781L().m80971t0());
                    Asset assetM72652f = m72652f(fileM63442h3, fileM63442h2, strM16337r, strM16336q, str2, strM16330k, c12118f);
                    Thumbnail[] thumbnailArr = {new Thumbnail("small", fileM63442h3), new Thumbnail("large", fileM63442h2)};
                    this.f56222g.m16305b0(c12118f.m72634e());
                    this.f56222g.m16303Z(assetM72652f);
                    this.f56222g.m16310g0(thumbnailArr);
                    this.f56222g.m16309f0(c11060cM66626a);
                    this.f56222g.m16314l0(false);
                    m72651e(str2);
                    String str3 = "thumbFix success " + c12118f.m72634e();
                    C1120a.m6677i("ThumbFixTask", str3);
                    this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 0, str3);
                    this.f56221f.m77870i(c12118f.m72634e());
                    return;
                }
                String str4 = "generate thumb error:" + c12118f.m72634e() + ", lcdRet:" + failRet.getErrMsg() + ", thumbRet:" + failRet2.getErrMsg();
                this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 10, str4);
                this.f56221f.m77875n(c12118f.m72634e(), str4);
                C1120a.m6678w("ThumbFixTask", str4);
            } catch (C9721b e11) {
                e = e11;
                c12118f2 = c12118f;
                C1120a.m6676e("ThumbFixTask", "thumbFix CException: " + e);
                if ((e.m60663g() == 403 && "31084037".equals(e.m60660d())) || ((e.m60663g() == 409 && "31004091".equals(e.m60660d())) || ((e.m60663g() == 409 && "31094091".equals(e.m60660d())) || 1001 == e.m60659c()))) {
                    C1120a.m6676e("ThumbFixTask", "lock expire or cancel");
                    throw e;
                }
                String str5 = "thumbFix error " + c12118f2 + ", cexception: " + e;
                this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 12, str5);
                this.f56221f.m77870i(c12118f.m72634e());
                C1120a.m6678w("ThumbFixTask", str5);
            }
        } catch (Exception e12) {
            C1120a.m6676e("ThumbFixTask", "thumbFix Exception: " + e12);
            String str6 = "thumbFix error " + c12118f + ", exception: " + e12;
            this.f56220e.m15209C(this.f56219d, "album_thumb_fix_task_info", 12, str6);
            this.f56221f.m77875n(c12118f.m72634e(), e12.toString());
            C1120a.m6678w("ThumbFixTask", str6);
        }
    }

    /* renamed from: z */
    public final void m72668z() throws InterruptedException {
        C1120a.m6677i("ThumbFixTask", "tryToSleep");
        for (int i10 = 0; i10 < 10; i10++) {
            try {
                if (!this.f56224i || this.f56216a.get()) {
                    C1120a.m6677i("ThumbFixTask", "cancel sleep");
                    return;
                }
                Thread.sleep(1000L);
            } catch (Exception e10) {
                C1120a.m6676e("ThumbFixTask", "tryToSleep exception: " + e10);
                return;
            }
        }
    }
}
