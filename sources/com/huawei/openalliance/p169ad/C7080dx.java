package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.StringVector;
import com.huawei.openalliance.p169ad.C8209wd;
import com.huawei.openalliance.p169ad.C8211wf;
import com.huawei.openalliance.p169ad.C8212wg;
import com.huawei.openalliance.p169ad.C8213wh;
import com.huawei.openalliance.p169ad.C8215wj;
import com.huawei.openalliance.p169ad.C8218wm;
import com.huawei.openalliance.p169ad.C8222wq;
import com.huawei.openalliance.p169ad.C8226wu;
import com.huawei.openalliance.p169ad.C8227wv;
import com.huawei.openalliance.p169ad.C8230wy;
import com.huawei.openalliance.p169ad.C8231wz;
import com.huawei.openalliance.p169ad.C8234xb;
import com.huawei.openalliance.p169ad.C8235xc;
import com.huawei.openalliance.p169ad.C8236xd;
import com.huawei.openalliance.p169ad.C8238xf;
import com.huawei.openalliance.p169ad.C8239xg;
import com.huawei.openalliance.p169ad.C8244xl;
import com.huawei.openalliance.p169ad.C8245xm;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.beans.metadata.AdTypeEvent;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.AudioInfo;
import com.huawei.openalliance.p169ad.beans.metadata.C6957Om;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.ContentExt;
import com.huawei.openalliance.p169ad.beans.metadata.DefaultTemplate;
import com.huawei.openalliance.p169ad.beans.metadata.FlowControl;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.metadata.InstallConfig;
import com.huawei.openalliance.p169ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.p169ad.beans.metadata.MediaFile;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.metadata.NegativeFb;
import com.huawei.openalliance.p169ad.beans.metadata.ParamFromServer;
import com.huawei.openalliance.p169ad.beans.metadata.Permission;
import com.huawei.openalliance.p169ad.beans.metadata.Precontent;
import com.huawei.openalliance.p169ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.p169ad.beans.metadata.ShareInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Skip;
import com.huawei.openalliance.p169ad.beans.metadata.TextState;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.MotionData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateV3;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Data;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Image;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.ImageExt;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Title;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Video;
import com.huawei.openalliance.p169ad.constant.LabelPosition;
import com.huawei.openalliance.p169ad.constant.MetaCreativeType;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.inter.data.DeviceAiParam;
import com.huawei.openalliance.p169ad.inter.data.RewardItem;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.C7766bm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.dx */
/* loaded from: classes8.dex */
public class C7080dx {
    /* renamed from: a */
    public static int m42739a(int i10, int i11) {
        return i10 == -1111 ? i11 : i10;
    }

    /* renamed from: b */
    public static float m42802b(float f10) {
        if (C7766bm.m47804a(f10, -1111.0f)) {
            return 0.0f;
        }
        return f10;
    }

    /* renamed from: a */
    private static long m42740a(long j10) {
        return m42741a(j10, 0L);
    }

    /* renamed from: b */
    public static int m42803b(int i10) {
        return m42739a(i10, 0);
    }

    /* renamed from: a */
    private static long m42741a(long j10, long j11) {
        return j10 == -1111 ? j11 : j10;
    }

    /* renamed from: b */
    public static ImpEX m42804b(C8227wv c8227wv) {
        if (c8227wv == null) {
            return null;
        }
        ImpEX impEX = new ImpEX();
        impEX.m40189a(c8227wv.m51286a());
        impEX.m40191b(c8227wv.m51289b());
        return impEX;
    }

    /* renamed from: a */
    public static Ad30 m42742a(C8209wd c8209wd) {
        if (c8209wd == null) {
            return null;
        }
        Ad30 ad30 = new Ad30();
        ad30.m39422a(c8209wd.m51002a());
        ad30.m39420a(m42739a(c8209wd.m51004b(), -1));
        ad30.m39423a(m42787a(c8209wd.m51007d()));
        ad30.m39425b(m42739a(c8209wd.m51009f(), -1));
        ad30.m39426b(c8209wd.m51006c());
        ad30.m39427b(m42805b(c8209wd.m51008e()));
        ad30.m39429c(AbstractC7758be.m47742b(m42800a(c8209wd.m51010g())));
        ad30.m39421a(m42750a(c8209wd.m51011h()));
        return ad30;
    }

    /* renamed from: b */
    public static List<ImpEX> m42805b(C8227wv.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42804b(aVar.m51291a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static AdSource m42743a(C8211wf c8211wf) {
        if (c8211wf == null) {
            return null;
        }
        AdSource adSource = new AdSource();
        adSource.m39553a(c8211wf.m51039a());
        adSource.m39555b(c8211wf.m51042b());
        adSource.m39552a(m42803b(c8211wf.m51043c()));
        return adSource;
    }

    /* renamed from: a */
    public static AdTypeEvent m42744a(C8213wh c8213wh) {
        if (c8213wh == null) {
            return null;
        }
        AdTypeEvent adTypeEvent = new AdTypeEvent();
        adTypeEvent.m39578a(m42803b(c8213wh.m51059b()));
        adTypeEvent.m39579a(m42782a(c8213wh.m51056a()));
        return adTypeEvent;
    }

    /* renamed from: a */
    private static ApkInfo m42745a(C8214wi c8214wi) {
        if (c8214wi == null) {
            return null;
        }
        ApkInfo apkInfo = new ApkInfo();
        apkInfo.m39661i(c8214wi.m51098g());
        apkInfo.m39679r(c8214wi.m51111t());
        apkInfo.m39646d(c8214wi.m51090a());
        apkInfo.m39652f(c8214wi.m51097f());
        apkInfo.m39655g(c8214wi.m51080Q());
        apkInfo.m39658h(c8214wi.m51081R());
        apkInfo.m39640b(c8214wi.m51093b());
        apkInfo.m39643c(c8214wi.m51106o());
        apkInfo.m39628a(m42740a(c8214wi.m51094c()));
        apkInfo.m39649e(c8214wi.m51095d());
        apkInfo.m39632a(c8214wi.m51096e());
        apkInfo.m39633a(m42796a(c8214wi.m51099h()));
        apkInfo.m39663j(c8214wi.m51101j());
        apkInfo.m39669m(c8214wi.m51079P());
        apkInfo.m39629a(m42753a(c8214wi.m51102k()));
        apkInfo.m39671n(c8214wi.m51104m() == null ? "1" : c8214wi.m51104m());
        apkInfo.m39673o(c8214wi.m51105n() == null ? "0" : c8214wi.m51105n());
        apkInfo.m39627a(m42803b(c8214wi.m51113v()));
        apkInfo.m39677q(c8214wi.m51108q());
        apkInfo.m39637b(m42803b(c8214wi.m51109r()));
        apkInfo.m39681s(c8214wi.m51110s());
        apkInfo.m39642c(m42803b(c8214wi.m51112u()));
        apkInfo.m39675p(c8214wi.m51117z());
        apkInfo.m39683t(c8214wi.m51115x());
        apkInfo.m39685u(c8214wi.m51116y());
        apkInfo.m39645d(m42739a(c8214wi.m51114w(), 1));
        apkInfo.m39648e(m42803b(c8214wi.m51068E()));
        apkInfo.m39687v(c8214wi.m51069F());
        apkInfo.m39689w(c8214wi.m51072I());
        apkInfo.m39651f(m42739a(c8214wi.m51073J(), 1));
        apkInfo.m39691x(c8214wi.m51064A());
        apkInfo.m39693y(c8214wi.m51065B());
        apkInfo.m39695z(c8214wi.m51107p());
        apkInfo.m39630a(m42780a(c8214wi.m51100i()));
        apkInfo.m39592A(c8214wi.m51067D());
        apkInfo.m39594B(c8214wi.m51103l());
        apkInfo.m39596C(c8214wi.m51066C());
        apkInfo.m39654g(m42739a(c8214wi.m51070G(), 1));
        apkInfo.m39657h(m42803b(c8214wi.m51074K()));
        apkInfo.m39638b(m42740a(c8214wi.m51071H()));
        apkInfo.m39598D(c8214wi.m51076M());
        apkInfo.m39600E(c8214wi.m51077N());
        apkInfo.m39602F(c8214wi.m51077N());
        apkInfo.m39604G(c8214wi.m51078O());
        apkInfo.m39606H(c8214wi.m51075L());
        apkInfo.m39660i(m42803b(c8214wi.m51082S()));
        apkInfo.m39608I(c8214wi.m51083T());
        apkInfo.m39665k(c8214wi.m51084U());
        apkInfo.m39631a(Long.valueOf(c8214wi.m51085V()));
        apkInfo.m39639b(Long.valueOf(c8214wi.m51086W()));
        apkInfo.m39667l(c8214wi.m51087X());
        return apkInfo;
    }

    /* renamed from: a */
    private static AudioInfo m42746a(C8216wk c8216wk) {
        if (c8216wk == null) {
            return null;
        }
        AudioInfo audioInfo = new AudioInfo();
        audioInfo.m39863a(c8216wk.m51138b());
        audioInfo.m39862a(m42803b((int) c8216wk.m51139c()));
        audioInfo.m39865b(m42803b((int) c8216wk.m51135a()));
        audioInfo.m39866b(c8216wk.m51140d());
        audioInfo.m39868c(c8216wk.m51141e());
        return audioInfo;
    }

    /* renamed from: a */
    public static Content m42747a(C8218wm c8218wm) {
        if (c8218wm == null) {
            return null;
        }
        Content content = new Content();
        content.m39947c(c8218wm.m51191a());
        content.m39952d(c8218wm.m51209i());
        content.m39939b(m42739a(c8218wm.m51208h(), 1));
        content.m39914a(m42740a(c8218wm.m51199b()));
        content.m39940b(m42741a(c8218wm.m51210j(), -1L));
        content.m39945c(m42739a(c8218wm.m51203c(), 0));
        content.m39913a(m42739a(c8218wm.m51204d(), 1));
        content.m39956e(AbstractC7758be.m47742b(m42760a(c8218wm.m51205e())));
        content.m39923a(c8218wm.m51207g());
        content.m39964g(c8218wm.m51215o() == null ? "tr" : c8218wm.m51215o());
        content.m39917a(m42765a(c8218wm.m51216p()));
        content.m39971i(0);
        content.m39963g(m42803b(c8218wm.m51155H()));
        content.m39942b(AbstractC7758be.m47742b(m42756a(c8218wm.m51206f())));
        content.m39998u(AbstractC7758be.m47742b(m42800a(c8218wm.m51172Y())));
        content.m39943b(m42782a(c8218wm.m51211k()));
        content.m39948c(m42782a(c8218wm.m51212l()));
        content.m39953d(m42793a(c8218wm.m51213m()));
        content.m39960f(c8218wm.m51217q() == null ? "" : c8218wm.m51217q());
        content.m39968h(c8218wm.m51218r() == null ? LabelPosition.LOWER_LEFT : c8218wm.m51218r());
        content.m39950d(m42803b(c8218wm.m51219s()));
        content.m39957e(m42781a(c8218wm.m51220t()));
        content.m39972i(c8218wm.m51221u());
        content.m39975j(c8218wm.m51222v());
        content.m39955e(m42803b(c8218wm.m51224x()));
        content.m39961f(m42781a(c8218wm.m51223w()));
        content.m39978k(c8218wm.m51225y());
        content.m39980l(c8218wm.m51226z());
        content.m39920a(m42778a(c8218wm.m51150C()));
        content.m39982m(c8218wm.m51149B());
        content.m39984n(c8218wm.m51151D());
        content.m39941b(m42780a(c8218wm.m51157J()));
        content.m39946c(m42780a(c8218wm.m51158K()));
        content.m39986o(c8218wm.m51160M());
        content.m39967h(m42803b(c8218wm.m51152E()));
        content.m39988p(c8218wm.m51148A());
        content.m39965g(m42788a(c8218wm.m51161N()));
        content.m39969h(m42790a(c8218wm.m51156I()));
        content.m39924a(m42791a(c8218wm.m51214n()));
        content.m39990q(c8218wm.m51159L());
        content.m39916a(m42754a(c8218wm.m51162O()));
        content.m39973i(m42795a(c8218wm.m51163P()));
        content.m39951d(m42780a(c8218wm.m51166S()));
        content.m39976j(m42786a(c8218wm.m51165R()));
        content.m39918a(m42771a(c8218wm.m51164Q()));
        content.m39992r(c8218wm.m51167T());
        content.m39994s(c8218wm.m51168U());
        content.m39996t(c8218wm.m51170W());
        content.m39915a(m42749a(c8218wm.m51169V()));
        content.m39919a(m42777a(c8218wm.m51171X()));
        content.m40000v(c8218wm.m51173Z());
        content.m40002w(c8218wm.m51193aa());
        content.m40004x(c8218wm.m51194ab());
        content.m40006y(c8218wm.m51154G());
        content.m39921a(m42779a(c8218wm.m51153F()));
        content.m40008z(c8218wm.m51195ac());
        content.m39885A(c8218wm.m51196ad());
        content.m39922a(Integer.valueOf(c8218wm.m51197ae()));
        content.m39887B(c8218wm.m51198af());
        return content;
    }

    /* renamed from: a */
    public static ContentExt m42748a(C8227wv c8227wv) {
        if (c8227wv == null) {
            return null;
        }
        ContentExt contentExt = new ContentExt();
        contentExt.m40010a(c8227wv.m51286a());
        contentExt.m40012b(c8227wv.m51289b());
        return contentExt;
    }

    /* renamed from: a */
    public static DefaultTemplate m42749a(C8220wo c8220wo) {
        if (c8220wo == null) {
            return null;
        }
        DefaultTemplate defaultTemplate = new DefaultTemplate();
        defaultTemplate.m40016a(c8220wo.m51235a());
        defaultTemplate.m40015a(m42780a(c8220wo.m51237b()));
        return defaultTemplate;
    }

    /* renamed from: a */
    public static FlowControl m42750a(C8223wr c8223wr) {
        if (c8223wr == null) {
            return null;
        }
        FlowControl flowControl = new FlowControl();
        flowControl.m40166a(m42803b(c8223wr.m51255a()));
        flowControl.m40167a(m42740a(c8223wr.m51257b()));
        return flowControl;
    }

    /* renamed from: a */
    public static ImageInfo m42751a(C8226wu c8226wu) {
        if (c8226wu == null) {
            return null;
        }
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.m40182c(c8226wu.m51273a());
        imageInfo.m40175a(m42803b(c8226wu.m51275b()));
        imageInfo.m40178b(m42803b(c8226wu.m51277c()));
        imageInfo.m40176a(c8226wu.m51278d());
        imageInfo.m40179b(c8226wu.m51280f() == null ? MetaCreativeType.IMG : c8226wu.m51280f());
        imageInfo.m40181c(m42803b((int) c8226wu.m51279e()));
        imageInfo.m40184d(m42803b(c8226wu.m51281g()));
        return imageInfo;
    }

    /* renamed from: a */
    public static ImpEX m42752a(C8222wq c8222wq) {
        if (c8222wq == null) {
            return null;
        }
        ImpEX impEX = new ImpEX();
        impEX.m40189a(c8222wq.m51248a());
        impEX.m40191b(c8222wq.m51251b());
        return impEX;
    }

    /* renamed from: a */
    private static InstallConfig m42753a(C8228ww c8228ww) {
        if (c8228ww == null) {
            return null;
        }
        InstallConfig installConfig = new InstallConfig();
        installConfig.m40195b(c8228ww.m51293a());
        installConfig.m40193a(c8228ww.m51296b());
        installConfig.m40197c(c8228ww.m51297c());
        return installConfig;
    }

    /* renamed from: a */
    public static InteractCfg m42754a(C8229wx c8229wx) {
        if (c8229wx == null) {
            return null;
        }
        InteractCfg interactCfg = new InteractCfg();
        interactCfg.m40199a(m42780a(c8229wx.m51298a()));
        interactCfg.m40202b(m42780a(c8229wx.m51311l()));
        interactCfg.m40208d(m42780a(c8229wx.m51300b()));
        interactCfg.m40211e(m42780a(c8229wx.m51302c()));
        interactCfg.m40214f(m42780a(c8229wx.m51303d()));
        interactCfg.m40205c(m42780a(c8229wx.m51304e()));
        interactCfg.m40216g(m42780a(c8229wx.m51305f()));
        interactCfg.m40200a(c8229wx.m51306g());
        interactCfg.m40203b(c8229wx.m51307h());
        interactCfg.m40206c(c8229wx.m51308i());
        interactCfg.m40209d(c8229wx.m51309j());
        interactCfg.m40212e(c8229wx.m51310k());
        return interactCfg;
    }

    /* renamed from: a */
    public static MediaFile m42755a(C8231wz c8231wz) {
        if (c8231wz == null) {
            return null;
        }
        MediaFile mediaFile = new MediaFile();
        mediaFile.m40246a(c8231wz.m51322a() == null ? MimeType.MP4 : c8231wz.m51322a());
        mediaFile.m40244a(m42803b(c8231wz.m51324b()));
        mediaFile.m40248b(m42803b(c8231wz.m51326c()));
        mediaFile.m40245a(m42740a(c8231wz.m51327d()));
        mediaFile.m40249b(c8231wz.m51328e());
        mediaFile.m40252c(c8231wz.m51329f());
        mediaFile.m40251c(m42739a(c8231wz.m51330g(), 0));
        mediaFile.m40254d(m42739a(c8231wz.m51331h(), 0));
        mediaFile.m40256e(m42739a(c8231wz.m51332i(), 1));
        return mediaFile;
    }

    /* renamed from: a */
    private static MetaData m42756a(C8233xa c8233xa) {
        if (c8233xa == null) {
            return null;
        }
        MetaData metaData = new MetaData();
        metaData.m40297b(c8233xa.m51370c());
        metaData.m40294b(c8233xa.m51371d());
        metaData.m40303c(c8233xa.m51372e());
        metaData.m40317g(m42782a(c8233xa.m51373f()));
        metaData.m40292a(m42789a(c8233xa.m51374g()));
        metaData.m40298b(m42789a(c8233xa.m51375h()));
        metaData.m40291a(c8233xa.m51376i());
        metaData.m40307d(c8233xa.m51377j());
        metaData.m40282a(m42741a(c8233xa.m51378k(), 500L));
        metaData.m40295b(m42741a(c8233xa.m51352M(), 0L));
        metaData.m40281a(c8233xa.m51379l());
        metaData.m40290a(m42780a(c8233xa.m51345F()));
        metaData.m40296b(m42780a(c8233xa.m51346G()));
        metaData.m40285a(m42751a(c8233xa.m51380m()));
        metaData.m40310e(c8233xa.m51381n());
        metaData.m40313f(c8233xa.m51382o());
        metaData.m40316g(c8233xa.m51383p());
        metaData.m40319h(c8233xa.m51384q());
        metaData.m40289a(m42767a(c8233xa.m51385r()));
        metaData.m40284a(m42746a(c8233xa.m51386s()));
        metaData.m40288a(m42764a(c8233xa.m51387t()));
        metaData.m40283a(m42745a(c8233xa.m51388u()));
        metaData.m40287a(m42763a(c8233xa.m51351L()));
        metaData.m40321i(c8233xa.m51389v());
        metaData.m40301c(m42740a(c8233xa.m51390w()));
        metaData.m40286a(m42755a(c8233xa.m51391x()));
        metaData.m40300c(m42803b(c8233xa.m51344E()));
        metaData.m40333o(c8233xa.m51348I());
        metaData.m40335p(c8233xa.m51347H());
        metaData.m40337q(c8233xa.m51364a());
        metaData.m40314f(m42784a(c8233xa.m51349J()));
        metaData.m40304c(m42799a(c8233xa.m51369b()));
        metaData.m40323j(c8233xa.m51392y());
        metaData.m40325k(c8233xa.m51393z());
        metaData.m40327l(c8233xa.m51340A());
        metaData.m40329m(c8233xa.m51341B());
        metaData.m40311e(m42782a(c8233xa.m51342C()));
        metaData.m40302c(m42780a(c8233xa.m51343D()));
        metaData.m40306d(m42780a(c8233xa.m51350K()));
        return metaData;
    }

    /* renamed from: a */
    public static Monitor m42757a(C8234xb c8234xb) {
        if (c8234xb == null) {
            return null;
        }
        Monitor monitor = new Monitor();
        monitor.m40349a(c8234xb.m51396a());
        monitor.m40350a(m42782a(c8234xb.m51398b()));
        monitor.m40348a(m42739a(c8234xb.m51400c(), 1));
        return monitor;
    }

    /* renamed from: a */
    public static NegativeFb m42758a(C8236xd c8236xd) {
        if (c8236xd == null) {
            return null;
        }
        NegativeFb negativeFb = new NegativeFb();
        negativeFb.m40355a(m42740a(c8236xd.m51419a()));
        negativeFb.m40356a(c8236xd.m51422b());
        negativeFb.m40354a(m42803b(c8236xd.m51423c()));
        return negativeFb;
    }

    /* renamed from: a */
    public static C6957Om m42759a(C8230wy c8230wy) {
        if (c8230wy == null) {
            return null;
        }
        C6957Om c6957Om = new C6957Om();
        c6957Om.m40367a(c8230wy.m51313a());
        c6957Om.m40369b(c8230wy.m51316b());
        c6957Om.m40371c(c8230wy.m51317c());
        return c6957Om;
    }

    /* renamed from: a */
    private static ParamFromServer m42760a(C8237xe c8237xe) {
        if (c8237xe == null) {
            return null;
        }
        ParamFromServer paramFromServer = new ParamFromServer();
        paramFromServer.m40382b(c8237xe.m51427a());
        paramFromServer.m40380a(c8237xe.m51431c());
        paramFromServer.m40383c(c8237xe.m51430b());
        return paramFromServer;
    }

    /* renamed from: a */
    private static Permission m42761a(C8238xf c8238xf) {
        if (c8238xf == null) {
            return null;
        }
        Permission permission = new Permission();
        permission.m40385a(c8238xf.m51433a());
        permission.m40387b(c8238xf.m51436b());
        return permission;
    }

    /* renamed from: a */
    public static Precontent m42762a(C8239xg c8239xg) {
        if (c8239xg == null) {
            return null;
        }
        Precontent precontent = new Precontent();
        precontent.m40412a(c8239xg.m51447a());
        precontent.m40417b(c8239xg.m51450b());
        precontent.m40408a(m42803b(c8239xg.m51451c()));
        precontent.m40413a(m42789a(c8239xg.m51452d()));
        precontent.m40409a(m42767a(c8239xg.m51455g()));
        precontent.m40421c(c8239xg.m51453e());
        precontent.m40418b(m42792a(c8239xg.m51454f()));
        precontent.m40411a(m42780a(c8239xg.m51456h()));
        precontent.m40416b(m42780a(c8239xg.m51461m()));
        precontent.m40422c(m42786a(c8239xg.m51458j()));
        precontent.m40410a(m42771a(c8239xg.m51457i()));
        precontent.m40424d(m42798a(c8239xg.m51460l()));
        precontent.m40420c(m42780a(c8239xg.m51459k()));
        return precontent;
    }

    /* renamed from: a */
    private static PromoteInfo m42763a(C8240xh c8240xh) {
        if (c8240xh == null) {
            return null;
        }
        PromoteInfo promoteInfo = new PromoteInfo();
        promoteInfo.m40435a(m42803b(c8240xh.m51465a()));
        promoteInfo.m40436a(c8240xh.m51468b());
        return promoteInfo;
    }

    /* renamed from: a */
    private static ShareInfo m42764a(C8242xj c8242xj) {
        if (c8242xj == null) {
            return null;
        }
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.m40443a(c8242xj.m51473a());
        shareInfo.m40445b(c8242xj.m51476b());
        shareInfo.m40447c(c8242xj.m51477c());
        shareInfo.m40449d(c8242xj.m51478d());
        return shareInfo;
    }

    /* renamed from: a */
    public static Skip m42765a(C8217wl c8217wl) {
        if (c8217wl == null) {
            return null;
        }
        Skip skip = new Skip();
        skip.m40452a(c8217wl.m51142a());
        skip.m40451a(m42803b(c8217wl.m51144b()));
        skip.m40454b(m42803b(c8217wl.m51146c()));
        return skip;
    }

    /* renamed from: a */
    public static TextState m42766a(C8245xm c8245xm) {
        if (c8245xm == null) {
            return null;
        }
        TextState textState = new TextState();
        textState.m40461a(m42803b(c8245xm.m51499a()));
        textState.m40464b(m42803b(c8245xm.m51501b()));
        textState.m40462a(c8245xm.m51503c());
        textState.m40465b(c8245xm.m51504d());
        textState.m40467c(m42803b(c8245xm.m51505e()));
        return textState;
    }

    /* renamed from: a */
    public static VideoInfo m42767a(C8248xp c8248xp) {
        if (c8248xp == null) {
            return null;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.m40476a(c8248xp.m51523a());
        videoInfo.m40473a(m42803b((int) c8248xp.m51525b()));
        videoInfo.m40478b(m42803b((int) c8248xp.m51527c()));
        videoInfo.m40480b(c8248xp.m51528d() == null ? "y" : c8248xp.m51528d());
        videoInfo.m40483c(c8248xp.m51529e() == null ? "n" : c8248xp.m51529e());
        videoInfo.m40482c(m42739a(c8248xp.m51530f(), 200));
        videoInfo.m40486d(c8248xp.m51531g());
        videoInfo.m40488e(m42803b(c8248xp.m51533i()));
        videoInfo.m40485d(m42739a(c8248xp.m51532h(), 1));
        videoInfo.m40475a(m42780a(c8248xp.m51534j()));
        videoInfo.m40479b(m42780a(c8248xp.m51535k()));
        videoInfo.m40491f(m42739a(c8248xp.m51536l(), 0));
        videoInfo.m40474a(m42779a(c8248xp.m51537m()));
        videoInfo.m40489e(c8248xp.m51538n() != null ? c8248xp.m51538n() : "y");
        videoInfo.m40472a(m42802b(c8248xp.m51539o()));
        videoInfo.m40494g(m42803b(c8248xp.m51540p()));
        videoInfo.m40492f(c8248xp.m51541q());
        return videoInfo;
    }

    /* renamed from: a */
    public static Asset m42768a(C8215wj c8215wj) {
        if (c8215wj == null) {
            return null;
        }
        Asset asset = new Asset();
        asset.m40506a(m42803b((int) c8215wj.m51119a()));
        asset.m40511a(c8215wj.m51126b());
        asset.m40515c(c8215wj.m51131g());
        asset.m40507a(m42772a(c8215wj.m51130f()));
        asset.m40508a(m42773a(c8215wj.m51128d()));
        asset.m40510a(m42776a(c8215wj.m51129e()));
        asset.m40509a(m42775a(c8215wj.m51127c()));
        return asset;
    }

    /* renamed from: a */
    public static MotionData m42769a(C8235xc c8235xc) {
        if (c8235xc == null) {
            return null;
        }
        MotionData motionData = new MotionData();
        motionData.m40526a(m42740a(c8235xc.m51405a()));
        motionData.m40530b(c8235xc.m51408b());
        motionData.m40525a(m42803b(c8235xc.m51409c()));
        motionData.m40529b(m42803b(c8235xc.m51410d()));
        motionData.m40527a(c8235xc.m51411e());
        motionData.m40532c(m42803b(c8235xc.m51412f()));
        motionData.m40533c(c8235xc.m51413g());
        motionData.m40535d(m42803b(c8235xc.m51414h()));
        return motionData;
    }

    /* renamed from: a */
    public static TemplateData m42770a(C8243xk c8243xk) {
        if (c8243xk == null) {
            return null;
        }
        TemplateData templateData = new TemplateData();
        templateData.m40550a(c8243xk.m51480a());
        templateData.m40553b(c8243xk.m51483b());
        templateData.m40551a(m42794a(c8243xk.m51484c()));
        templateData.m40555c(c8243xk.m51485d());
        return templateData;
    }

    /* renamed from: a */
    public static TemplateV3 m42771a(C8244xl c8244xl) {
        if (c8244xl == null) {
            return null;
        }
        TemplateV3 templateV3 = new TemplateV3();
        templateV3.m40559a(c8244xl.m51488a());
        templateV3.m40558a(m42770a(c8244xl.m51492c()));
        templateV3.m40561b(c8244xl.m51491b());
        templateV3.m40563c(c8244xl.m51493d());
        templateV3.m40565d(c8244xl.m51494e());
        return templateV3;
    }

    /* renamed from: a */
    public static Data m42772a(C8219wn c8219wn) {
        if (c8219wn == null) {
            return null;
        }
        Data data = new Data();
        data.m40568a(m42803b(c8219wn.m51230a()));
        data.m40569a(c8219wn.m51234c());
        data.m40571b(m42803b(c8219wn.m51232b()));
        return data;
    }

    /* renamed from: a */
    private static Image m42773a(C8225wt c8225wt) {
        if (c8225wt == null) {
            return null;
        }
        Image image = new Image();
        image.m40576a(c8225wt.m51266a());
        image.m40574a(m42803b(c8225wt.m51268b()));
        image.m40578b(m42803b(c8225wt.m51270c()));
        image.m40575a(m42774a(c8225wt.m51271d()));
        return image;
    }

    /* renamed from: a */
    public static ImageExt m42774a(C8224ws c8224ws) {
        if (c8224ws == null) {
            return null;
        }
        ImageExt imageExt = new ImageExt();
        imageExt.m40585a(m42740a(c8224ws.m51261b()));
        imageExt.m40586a(c8224ws.m51259a());
        imageExt.m40588b(c8224ws.m51263c());
        imageExt.m40584a(m42803b(c8224ws.m51264d()));
        return imageExt;
    }

    /* renamed from: a */
    public static Title m42775a(C8246xn c8246xn) {
        if (c8246xn == null) {
            return null;
        }
        Title title = new Title();
        title.m40593a(c8246xn.m51509a());
        title.m40592a(m42803b(c8246xn.m51511b()));
        return title;
    }

    /* renamed from: a */
    public static Video m42776a(C8247xo c8247xo) {
        if (c8247xo == null) {
            return null;
        }
        Video video = new Video();
        video.m40598a(c8247xo.m51513a());
        video.m40596a(m42803b(c8247xo.m51518d()));
        video.m40600b(m42803b(c8247xo.m51519e()));
        video.m40597a(m42740a(c8247xo.m51521g()));
        video.m40601b(m42803b(c8247xo.m51517c()));
        video.m40602b(c8247xo.m51516b());
        video.m40605c(c8247xo.m51520f());
        video.m40607d(c8247xo.m51522h());
        return video;
    }

    /* renamed from: a */
    public static DeviceAiParam m42777a(C8221wp c8221wp) {
        if (c8221wp == null) {
            return null;
        }
        DeviceAiParam deviceAiParam = new DeviceAiParam();
        deviceAiParam.m44458a(c8221wp.m51242b());
        deviceAiParam.m44459b(c8221wp.m51243c());
        deviceAiParam.m44460c(c8221wp.m51244d());
        deviceAiParam.m44461d(c8221wp.m51239a());
        deviceAiParam.m44462e(c8221wp.m51245e());
        deviceAiParam.m44463f(c8221wp.m51246f());
        return deviceAiParam;
    }

    /* renamed from: a */
    public static RewardItem m42778a(C8241xi c8241xi) {
        if (c8241xi == null) {
            return null;
        }
        RewardItem rewardItem = new RewardItem();
        rewardItem.m44555a(c8241xi.m51469a());
        rewardItem.m44554a(m42803b(c8241xi.m51471b()));
        return rewardItem;
    }

    /* renamed from: a */
    public static Float m42779a(float f10) {
        if (C7766bm.m47804a(f10, -1111.0f)) {
            return null;
        }
        return Float.valueOf(f10);
    }

    /* renamed from: a */
    public static Integer m42780a(int i10) {
        if (i10 == -1111) {
            return null;
        }
        return Integer.valueOf(i10);
    }

    /* renamed from: a */
    public static List<Integer> m42781a(IntVector intVector) {
        if (m42801a((BaseVector) intVector)) {
            return null;
        }
        int length = intVector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(Integer.valueOf(m42803b(intVector.get(i10))));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<String> m42782a(StringVector stringVector) {
        if (m42801a((BaseVector) stringVector)) {
            return null;
        }
        int length = stringVector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(stringVector.get(i10));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Ad30> m42783a(C8209wd.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42742a(aVar.m51013a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<AdSource> m42784a(C8211wf.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42743a(aVar.m51045a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<AdTypeEvent> m42785a(C8213wh.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42744a(aVar.m51062a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Asset> m42786a(C8215wj.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42768a(aVar.m51133a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Content> m42787a(C8218wm.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42747a(aVar.m51228a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<ImpEX> m42788a(C8222wq.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42752a(aVar.m51253a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<ImageInfo> m42789a(C8226wu.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42751a(aVar.m51283a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<ContentExt> m42790a(C8227wv.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42748a(aVar.m51291a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<C6957Om> m42791a(C8230wy.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42759a(aVar.m51319a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<MediaFile> m42792a(C8231wz.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42755a(aVar.m51334a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Monitor> m42793a(C8234xb.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42757a(aVar.m51402a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<MotionData> m42794a(C8235xc.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42769a(aVar.m51416a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<NegativeFb> m42795a(C8236xd.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42758a(aVar.m51425a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<Permission> m42796a(C8238xf.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = aVar.length();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42761a(aVar.m51438a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Precontent> m42797a(C8239xg.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42762a(aVar.m51463a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<TemplateV3> m42798a(C8244xl.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42771a(aVar.m51496a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<TextState> m42799a(C8245xm.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42766a(aVar.m51507a(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map<String, String> m42800a(C8212wg.a aVar) {
        if (m42801a((BaseVector) aVar)) {
            return null;
        }
        int length = aVar.length();
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < length; i10++) {
            C8212wg c8212wgM51053a = aVar.m51053a(i10);
            map.put(c8212wgM51053a.m51048a(), c8212wgM51053a.m51051b());
        }
        return map;
    }

    /* renamed from: a */
    private static boolean m42801a(BaseVector baseVector) {
        return baseVector == null || baseVector.length() == 0;
    }
}
