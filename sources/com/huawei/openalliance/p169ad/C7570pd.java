package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.AudioInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.metadata.NegativeFb;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateV3;
import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EncryptionField;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7827f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.pd */
/* loaded from: classes8.dex */
public class C7570pd {

    /* renamed from: a */
    private static final String f35287a = "pd";

    /* renamed from: a */
    public static ContentRecord m46698a(C7302e c7302e) {
        String strM44777S;
        String strM44811ag;
        String strM44812ah;
        if (c7302e == null) {
            return null;
        }
        ContentRecord contentRecord = new ContentRecord();
        contentRecord.m41444a(c7302e.m44601a());
        contentRecord.m41436a(c7302e.getMinEffectiveShowRatio());
        contentRecord.m41437a(c7302e.getMinEffectiveShowTime());
        contentRecord.m41508b(c7302e.getMaxEffectiveShowTime());
        contentRecord.m41540d(c7302e.m44659q() == null ? 0 : c7302e.m44659q().intValue());
        contentRecord.m41510b(Integer.valueOf(c7302e.m44661r() != null ? c7302e.m44661r().intValue() : 0));
        contentRecord.m41536c(c7302e.getShowId());
        contentRecord.m41543d(c7302e.getSlotId());
        contentRecord.m41549e(c7302e.getContentId());
        contentRecord.m41548e(c7302e.getStartTime());
        contentRecord.m41541d(c7302e.getEndTime());
        contentRecord.m41562g(c7302e.m44787X());
        contentRecord.m41555f(c7302e.getTaskId());
        contentRecord.m41608t(c7302e.m44810af());
        contentRecord.m41610u(c7302e.getWhyThisAd());
        contentRecord.m41620z(c7302e.getAdChoiceUrl());
        contentRecord.m41385A(c7302e.getAdChoiceIcon());
        contentRecord.m41578k(c7302e.getCreativeType());
        EncryptionField<String> encryptionField = new EncryptionField<>(String.class);
        if (c7302e.m44819ao()) {
            encryptionField.m41655a((EncryptionField<String>) c7302e.m44821aq());
        } else {
            encryptionField.m41656a(c7302e.m44765M());
        }
        contentRecord.m41441a(encryptionField);
        contentRecord.m41507b(c7302e.m44632e());
        contentRecord.m41579k(c7302e.getLandWebUrl());
        contentRecord.m41569i(c7302e.getInterActionType());
        contentRecord.m41587m(c7302e.getIntent());
        contentRecord.m41511b(c7302e.m44775R());
        if (c7302e.m44819ao()) {
            List<Monitor> listM44822ar = c7302e.m44822ar();
            EncryptionField encryptionField2 = new EncryptionField(List.class, Monitor.class);
            encryptionField2.m41655a((EncryptionField) listM44822ar);
            strM44777S = encryptionField2.m41657b(c7302e.m44820ap());
        } else {
            strM44777S = c7302e.m44777S();
        }
        if (!AbstractC7806cz.m48165b(strM44777S)) {
            EncryptionField<List<Monitor>> encryptionField3 = new EncryptionField<>(List.class, Monitor.class);
            encryptionField3.m41656a(strM44777S);
            contentRecord.m41509b(encryptionField3);
        }
        contentRecord.m41582l(c7302e.m44779T());
        contentRecord.m41550e(c7302e.m44781U());
        contentRecord.m41602r(c7302e.m44785W());
        contentRecord.m41605s(c7302e.getCtrlSwitchs());
        contentRecord.m41612v(c7302e.getUniqueId());
        if (c7302e.m44819ao()) {
            EncryptionField encryptionField4 = new EncryptionField(String.class);
            encryptionField4.m41655a((EncryptionField) c7302e.m44823as());
            strM44811ag = encryptionField4.m41657b(c7302e.m44820ap());
        } else {
            strM44811ag = c7302e.m44811ag();
        }
        if (!TextUtils.isEmpty(strM44811ag)) {
            EncryptionField<String> encryptionField5 = new EncryptionField<>(String.class);
            encryptionField5.m41656a(strM44811ag);
            contentRecord.m41535c(encryptionField5);
        }
        if (c7302e.m44819ao()) {
            EncryptionField encryptionField6 = new EncryptionField(String.class);
            encryptionField6.m41655a((EncryptionField) c7302e.m44824at());
            strM44812ah = encryptionField6.m41657b(c7302e.m44820ap());
        } else {
            strM44812ah = c7302e.m44812ah();
        }
        if (!TextUtils.isEmpty(strM44812ah)) {
            EncryptionField<String> encryptionField7 = new EncryptionField<>(String.class);
            encryptionField7.m41656a(strM44812ah);
            contentRecord.m41542d(encryptionField7);
        }
        contentRecord.m41447a(c7302e.isAutoDownloadApp());
        contentRecord.m41616x(c7302e.m44813ai());
        contentRecord.m41618y(c7302e.m44636f());
        contentRecord.m41479ab(c7302e.m44599B());
        contentRecord.m41446a(c7302e.getAdCloseKeyWords());
        contentRecord.m41512b(c7302e.m44773Q());
        contentRecord.m41592o(c7302e.m44639g());
        contentRecord.m41533c(1);
        contentRecord.m41387B(c7302e.m44641h() != null ? String.valueOf(c7302e.m44641h()) : null);
        contentRecord.m41391D(c7302e.m44643i());
        contentRecord.m41393E(c7302e.m44645j());
        contentRecord.m41396G(c7302e.m44647k());
        contentRecord.m41398H(c7302e.m44649l());
        contentRecord.m41567h(c7302e.m44817am());
        contentRecord.m41572i(c7302e.m44818an());
        contentRecord.m41544d(c7302e.m44651m());
        contentRecord.m41402J(c7302e.m44653n());
        contentRecord.m41560g(c7302e.m44657p());
        contentRecord.m41576j(c7302e.getFeedbackInfoList());
        contentRecord.m41545d(c7302e.m44664s());
        contentRecord.m41410N(c7302e.getAbilityDetailInfo());
        contentRecord.m41412O(c7302e.getHwChannelId());
        contentRecord.m41406L(c7302e.m44791Z());
        contentRecord.m41408M(c7302e.m44807ac());
        contentRecord.m41440a(c7302e.m44806ab());
        contentRecord.m41414P(c7302e.m44828ax());
        contentRecord.m41432Y(c7302e.m44830az());
        contentRecord.m41434Z(c7302e.m44802aA());
        contentRecord.m41584l(c7302e.m44804aa());
        contentRecord.m41604s(c7302e.m44808ad() != null ? c7302e.m44808ad().intValue() : -1);
        contentRecord.m41580k(c7302e.getCompliance());
        contentRecord.m41607t(c7302e.m44673x());
        contentRecord.m41416Q(c7302e.m44620c());
        contentRecord.m41551e(c7302e.isTransparencyOpen());
        contentRecord.m41420S(c7302e.getTransparencyTplUrl());
        contentRecord.m41422T(c7302e.m44598A());
        contentRecord.m41424U(c7302e.m44829ay());
        contentRecord.m41481ac(c7302e.m44600C());
        return contentRecord;
    }

    /* renamed from: b */
    private static void m46708b(ContentRecord contentRecord, boolean z10, C7302e c7302e, byte[] bArr) {
        EncryptionField<List<Monitor>> encryptionFieldM41405L = contentRecord.m41405L();
        if (encryptionFieldM41405L != null) {
            if (z10) {
                c7302e.m44857p(encryptionFieldM41405L.m41653a(bArr));
                return;
            }
            EncryptionField encryptionField = new EncryptionField(List.class, Monitor.class);
            encryptionField.m41655a((EncryptionField) encryptionFieldM41405L.m41653a(bArr));
            c7302e.m44761I(encryptionField.m41657b(bArr));
        }
    }

    /* renamed from: c */
    private static void m46709c(ContentRecord contentRecord, boolean z10, C7302e c7302e, byte[] bArr) {
        EncryptionField<String> encryptionFieldM41395G = contentRecord.m41395G();
        if (encryptionFieldM41395G != null) {
            if (z10) {
                c7302e.m44780T(encryptionFieldM41395G.m41653a(bArr));
            } else {
                c7302e.m44780T(encryptionFieldM41395G.m41653a(bArr));
                c7302e.m44754B(contentRecord.m41395G().m41657b(bArr));
            }
        }
    }

    /* renamed from: a */
    public static C7302e m46699a(Context context, ContentRecord contentRecord, boolean z10) {
        C7302e c7302e = new C7302e();
        AdContentData adContentData = new AdContentData();
        adContentData.m39277a(contentRecord.m41552f());
        c7302e.m44764L(contentRecord.m41585m());
        c7302e.m44624c(contentRecord.m41588n());
        c7302e.m44845j(contentRecord.m41388C());
        c7302e.m44603a(contentRecord.m41603s());
        c7302e.m44614b(contentRecord.m41600r());
        c7302e.m44602a(contentRecord.m41392E());
        c7302e.m44633e(contentRecord.m41392E());
        adContentData.m39288c(contentRecord.m41392E());
        adContentData.m39291d(contentRecord.m41392E());
        c7302e.m44843i(contentRecord.m41431Y());
        c7302e.m44635e(contentRecord.m41591o());
        c7302e.m44770O(contentRecord.m41433Z());
        c7302e.m44613b(contentRecord.m41552f());
        c7302e.m44850k(z10);
        c7302e.m44621c(contentRecord.m41492an());
        c7302e.m44644i(contentRecord.m41486ah());
        if (!TextUtils.isEmpty(contentRecord.m41577k())) {
            c7302e.m44642h(contentRecord.m41577k());
        }
        if (!TextUtils.isEmpty(contentRecord.m41529bp())) {
            c7302e.m44670v(contentRecord.m41529bp());
        }
        m46707a(contentRecord.m41401J(), c7302e, contentRecord.m41403K());
        byte[] bArrM48089b = AbstractC7796cp.m48089b(context);
        c7302e.m44800a(bArrM48089b);
        m46709c(contentRecord, z10, c7302e, bArrM48089b);
        MetaData metaDataM41568i = contentRecord.m41568i();
        m46708b(contentRecord, z10, c7302e, bArrM48089b);
        m46705a(contentRecord, z10, c7302e, bArrM48089b);
        EncryptionField<String> encryptionFieldM41453aE = contentRecord.m41453aE();
        if (encryptionFieldM41453aE != null) {
            c7302e.m44774Q(encryptionFieldM41453aE.m41657b(bArrM48089b));
        }
        c7302e.m44851l(contentRecord.m41413P());
        c7302e.m44841h(contentRecord.m41409N());
        c7302e.m44762J(contentRecord.m41425V());
        c7302e.m44763K(contentRecord.m41427W());
        c7302e.m44760H(contentRecord.m41563h());
        adContentData.m39280a(contentRecord.m41563h());
        if (metaDataM41568i == null) {
            return c7302e;
        }
        c7302e.m44755C(AbstractC7806cz.m48168c(metaDataM41568i.m40309e()));
        c7302e.m44756D(AbstractC7806cz.m48168c(metaDataM41568i.m40312f()));
        c7302e.m44832d(AbstractC7806cz.m48158a(metaDataM41568i.m40279P()));
        m46706a(c7302e, metaDataM41568i);
        c7302e.m44660q(AbstractC7806cz.m48168c(contentRecord.m41411O()));
        c7302e.m44646j(AbstractC7806cz.m48168c(contentRecord.m41476aa()));
        c7302e.m44648k(AbstractC7806cz.m48168c(contentRecord.m41490al()));
        c7302e.m44650l(AbstractC7806cz.m48168c(contentRecord.m41491am()));
        ApkInfo apkInfoM40339s = metaDataM41568i.m40339s();
        if (apkInfoM40339s != null) {
            AppInfo appInfo = new AppInfo(apkInfoM40339s);
            appInfo.m44415m(c7302e.getIntent());
            AppInfo appInfoM41484af = contentRecord.m41484af();
            if (appInfoM41484af == null || TextUtils.isEmpty(appInfoM41484af.getUniqueId())) {
                appInfo.m44433v(c7302e.getUniqueId());
                AbstractC7185ho.m43821b(f35287a, "myUniqueId2 is %s", appInfoM41484af.getUniqueId());
            } else {
                appInfo.m44433v(appInfoM41484af.getUniqueId());
                AbstractC7185ho.m43821b(f35287a, "myUniqueId is %s", appInfoM41484af.getUniqueId());
            }
            appInfo.m44402h(metaDataM41568i.m40266C());
            c7302e.m44796a(appInfo);
        }
        c7302e.m44607a(metaDataM41568i.m40340t());
        c7302e.m44630d(metaDataM41568i.m40341u());
        AudioInfo audioInfoM40269F = metaDataM41568i.m40269F();
        if (audioInfoM40269F != null) {
            c7302e.m44797a(new com.huawei.openalliance.p169ad.inter.data.AudioInfo(audioInfoM40269F));
        }
        c7302e.m44615b(Integer.valueOf(contentRecord.m41390D()));
        c7302e.m44853m(contentRecord.m41452aD());
        c7302e.m44855n(contentRecord.m41455aG());
        c7302e.m44854m(contentRecord.m41454aF());
        c7302e.m44611a(contentRecord.m41506b(context));
        c7302e.m44658p(contentRecord.m41456aH());
        c7302e.m44856o(contentRecord.m41461aM());
        c7302e.m44662r(contentRecord.m41466aR());
        c7302e.m44663s(contentRecord.m41467aS());
        c7302e.m44766M(contentRecord.m41463aO());
        c7302e.m44795a(contentRecord.m41469aU());
        c7302e.m44846j(contentRecord.m41471aW());
        adContentData.m39285b(contentRecord.m41463aO());
        adContentData.m39279a(contentRecord.m41469aU());
        adContentData.m39281a(contentRecord.m41471aW());
        c7302e.m44836f(Integer.valueOf(contentRecord.m41464aP()));
        c7302e.m44625c(contentRecord.m41468aT());
        c7302e.m44794a(contentRecord.m41470aV());
        adContentData.m39284b(contentRecord.m41464aP());
        adContentData.m39278a(contentRecord.m41470aV());
        c7302e.m44606a(adContentData);
        c7302e.m44637f(contentRecord.m41472aX());
        c7302e.m44610a(contentRecord.m41474aZ());
        return c7302e;
    }

    /* renamed from: a */
    public static C7302e m46700a(String str, Content content, byte[] bArr, int i10, boolean z10, MetaData metaData) {
        C7302e c7302e = new C7302e();
        AdContentData adContentData = new AdContentData();
        adContentData.m39277a(i10);
        c7302e.m44764L(str);
        c7302e.m44609a(content.m39912a());
        c7302e.m44624c(content.m39962g());
        c7302e.m44845j(content.m39979l());
        c7302e.m44603a(content.m39977k());
        c7302e.m44614b(content.m39974j());
        c7302e.m44602a(content.m39958f());
        c7302e.m44633e(content.m39958f());
        adContentData.m39288c(content.m39958f());
        adContentData.m39291d(content.m39958f());
        c7302e.m44843i(content.m40007z());
        c7302e.m44635e(content.m39966h());
        c7302e.m44770O(content.m39884A());
        c7302e.m44613b(i10);
        c7302e.m44850k(z10);
        c7302e.m44800a(bArr);
        c7302e.m44610a(content.m39928ac());
        BiddingInfo.C7295a lurl = new BiddingInfo.C7295a().m44455a(content.m39932ag()).m44454a(content.m39933ah()).m44457b(content.m39934ai()).setLurl(content.m39935aj());
        if (!lurl.m44456a().m44449a()) {
            c7302e.m44608a(lurl.m44456a());
        }
        List<String> listM39983n = content.m39983n();
        if (listM39983n != null && listM39983n.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = listM39983n.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC7806cz.m48168c(it.next()));
            }
            c7302e.m44837f(arrayList);
        }
        List<String> listM39985o = content.m39985o();
        if (listM39985o != null && listM39985o.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it2 = listM39985o.iterator();
            while (it2.hasNext()) {
                arrayList2.add(AbstractC7806cz.m48168c(it2.next()));
            }
            c7302e.m44839g(arrayList2);
        }
        String strM39981m = content.m39981m();
        if (strM39981m != null) {
            if (z10) {
                c7302e.m44780T(strM39981m);
            } else {
                c7302e.m44754B(AbstractC7827f.m48394a(strM39981m, bArr));
            }
        }
        List<Monitor> listM39987p = content.m39987p();
        if (listM39987p == null) {
            listM39987p = new ArrayList<>();
        }
        VastContent vastContentM46929a = C7590ps.m46929a(metaData, 3, content.m39958f());
        if (vastContentM46929a != null) {
            AbstractC7185ho.m43821b(f35287a, "content:%s is vast ad, merge monitors", content.m39962g());
            listM39987p = C7590ps.m46933a(listM39987p, C7590ps.m46932a(vastContentM46929a));
        }
        if (listM39987p.size() > 0) {
            if (z10) {
                c7302e.m44857p(listM39987p);
            } else {
                EncryptionField encryptionField = new EncryptionField(List.class, Monitor.class);
                encryptionField.m41655a((EncryptionField) listM39987p);
                c7302e.m44761I(encryptionField.m41657b(bArr));
            }
        }
        c7302e.m44851l(content.m39991r());
        c7302e.m44841h(content.m39997u());
        c7302e.m44762J(content.m39999v());
        c7302e.m44763K(content.m40001w());
        c7302e.m44760H(content.m39949d());
        adContentData.m39280a(content.m39949d());
        c7302e.m44637f(content.m39927ab());
        if (metaData == null) {
            return c7302e;
        }
        m46703a(content, c7302e, metaData, vastContentM46929a);
        c7302e.m44660q(AbstractC7806cz.m48168c(content.m39989q()));
        c7302e.m44646j(AbstractC7806cz.m48168c(content.m39889D()));
        c7302e.m44648k(AbstractC7806cz.m48168c(content.m39890E()));
        c7302e.m44650l(AbstractC7806cz.m48168c(content.m39891F()));
        c7302e.m44631d(content.m39930ae().booleanValue());
        c7302e.m44666t(content.m39929ad());
        c7302e.m44630d(metaData.m40341u());
        AudioInfo audioInfoM40269F = metaData.m40269F();
        if (audioInfoM40269F != null) {
            c7302e.m44797a(new com.huawei.openalliance.p169ad.inter.data.AudioInfo(audioInfoM40269F));
        }
        m46704a(content, bArr, z10, c7302e);
        c7302e.m44615b(content.m39894I());
        c7302e.m44853m(content.m39899N());
        c7302e.m44855n(content.m39902Q());
        c7302e.m44854m(content.m39901P());
        c7302e.m44611a(content.m39954e());
        c7302e.m44658p(content.m39903R());
        m46702a(content, c7302e);
        c7302e.m44662r(content.m39909X());
        c7302e.m44663s(AbstractC7806cz.m48168c(content.m39910Y()));
        TemplateV3 templateV3M39908W = content.m39908W();
        if (templateV3M39908W != null) {
            c7302e.m44766M(templateV3M39908W.m40557a());
            c7302e.m44795a(templateV3M39908W.m40560b());
            c7302e.m44846j(content.m39907V());
            c7302e.m44805aa(content.m39936ak());
            c7302e.m44786W(templateV3M39908W.m40562c());
            c7302e.m44789Y(templateV3M39908W.m40564d());
            c7302e.m44792Z(templateV3M39908W.m40566e());
            adContentData.m39285b(templateV3M39908W.m40557a());
            adContentData.m39279a(templateV3M39908W.m40560b());
            adContentData.m39281a(content.m39907V());
            adContentData.m39292d(content.m39936ak());
            adContentData.m39289c(templateV3M39908W.m40562c());
            adContentData.m39296f(templateV3M39908W.m40564d());
            adContentData.m39298g(templateV3M39908W.m40566e());
        }
        c7302e.m44836f(content.m39906U());
        c7302e.m44672w(content.m39937al());
        c7302e.m44625c(content.m39911Z());
        c7302e.m44794a(content.m39926aa());
        c7302e.m44788X(content.m39931af());
        adContentData.m39284b(content.m39906U() == null ? -1 : content.m39906U().intValue());
        adContentData.m39278a(content.m39926aa());
        adContentData.m39294e(content.m39937al());
        c7302e.m44606a(adContentData);
        return c7302e;
    }

    /* renamed from: a */
    private static List<ImageInfo> m46701a(List<com.huawei.openalliance.p169ad.beans.metadata.ImageInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<com.huawei.openalliance.p169ad.beans.metadata.ImageInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new ImageInfo(it.next()));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m46702a(Content content, C7302e c7302e) {
        List<NegativeFb> listM39905T = content.m39905T();
        if (AbstractC7760bg.m47767a(listM39905T)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (NegativeFb negativeFb : listM39905T) {
            if (negativeFb != null) {
                FeedbackInfo feedbackInfo = new FeedbackInfo();
                feedbackInfo.m44466a(negativeFb.m40353a());
                feedbackInfo.m44467a(AbstractC7806cz.m48168c(negativeFb.m40357b()));
                feedbackInfo.m44465a(negativeFb.m40358c());
                arrayList.add(feedbackInfo);
            }
        }
        c7302e.m44856o(arrayList);
    }

    /* renamed from: a */
    private static void m46703a(Content content, C7302e c7302e, MetaData metaData, VastContent vastContent) {
        if (vastContent != null) {
            AbstractC7185ho.m43821b(f35287a, "content:%s is vast ad, merge meta data", content.m39962g());
            C7590ps.m46937a(metaData, vastContent, 3);
            c7302e.m44760H(AbstractC7758be.m47742b(metaData));
            c7302e.m44626c(true);
        }
        c7302e.m44755C(AbstractC7806cz.m48168c(metaData.m40309e()));
        c7302e.m44756D(AbstractC7806cz.m48168c(metaData.m40312f()));
        c7302e.m44832d(AbstractC7806cz.m48158a(metaData.m40279P()));
        m46706a(c7302e, metaData);
        c7302e.m44634e(metaData.m40278O());
        c7302e.m44607a(metaData.m40340t());
        ApkInfo apkInfoM40339s = metaData.m40339s();
        if (apkInfoM40339s != null) {
            AppInfo appInfo = new AppInfo(apkInfoM40339s);
            appInfo.m44415m(c7302e.getIntent());
            appInfo.m44433v(c7302e.getUniqueId());
            appInfo.m44402h(metaData.m40266C());
            c7302e.m44796a(appInfo);
        }
    }

    /* renamed from: a */
    private static void m46704a(Content content, byte[] bArr, boolean z10, C7302e c7302e) {
        String strM39886B = content.m39886B();
        if (!TextUtils.isEmpty(strM39886B)) {
            if (z10) {
                c7302e.m44782U(strM39886B);
            } else {
                EncryptionField encryptionField = new EncryptionField(String.class);
                encryptionField.m41655a((EncryptionField) strM39886B);
                c7302e.m44771P(encryptionField.m41657b(bArr));
            }
        }
        String strM39900O = content.m39900O();
        if (TextUtils.isEmpty(strM39900O)) {
            return;
        }
        if (z10) {
            c7302e.m44783V(strM39900O);
            return;
        }
        EncryptionField encryptionField2 = new EncryptionField(String.class);
        encryptionField2.m41655a((EncryptionField) strM39900O);
        c7302e.m44774Q(encryptionField2.m41657b(bArr));
    }

    /* renamed from: a */
    private static void m46705a(ContentRecord contentRecord, boolean z10, C7302e c7302e, byte[] bArr) {
        EncryptionField<String> encryptionFieldM41480ac = contentRecord.m41480ac();
        if (encryptionFieldM41480ac != null) {
            if (z10) {
                c7302e.m44782U(encryptionFieldM41480ac.m41653a(bArr));
            } else {
                encryptionFieldM41480ac.m41655a((EncryptionField<String>) encryptionFieldM41480ac.m41653a(bArr));
                c7302e.m44771P(encryptionFieldM41480ac.m41657b(bArr));
            }
        }
    }

    /* renamed from: a */
    private static void m46706a(C7302e c7302e, MetaData metaData) {
        List<com.huawei.openalliance.p169ad.beans.metadata.ImageInfo> listM40315g = metaData.m40315g();
        if (listM40315g != null && !listM40315g.isEmpty()) {
            c7302e.m44798a(new ImageInfo(listM40315g.get(0)));
        }
        List<ImageInfo> listM46701a = m46701a(metaData.m40334p());
        c7302e.m44834e(listM46701a);
        c7302e.m44852l(listM46701a);
        VideoInfo videoInfoM40305d = metaData.m40305d();
        if (videoInfoM40305d != null) {
            com.huawei.openalliance.p169ad.inter.data.VideoInfo videoInfo = new com.huawei.openalliance.p169ad.inter.data.VideoInfo(videoInfoM40305d);
            if (metaData.m40299c() != null) {
                videoInfo.m44595j(metaData.m40299c().intValue());
            }
            c7302e.m44799a(videoInfo);
        }
        c7302e.m44757E(metaData.m40318h());
        c7302e.m44628d(metaData.m40271H());
        c7302e.m44831d(metaData.m40320i());
        c7302e.m44835f(metaData.m40322j());
        c7302e.m44629d(metaData.m40293b());
        c7302e.m44623c(metaData.m40299c());
        c7302e.m44848k(metaData.m40324k());
        c7302e.m44638f(AbstractC7806cz.m48168c(metaData.m40326l()));
        c7302e.m44758F(metaData.m40328m());
        c7302e.m44759G(metaData.m40330n());
        c7302e.m44640g(metaData.m40332o());
        c7302e.m44616b(AbstractC7806cz.m48168c(metaData.m40280a()));
        c7302e.m44776R(metaData.m40265B());
        c7302e.m44617b(metaData.m40275L());
    }

    /* renamed from: a */
    private static void m46707a(List<String> list, C7302e c7302e, List<String> list2) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC7806cz.m48168c(it.next()));
            }
            c7302e.m44837f(arrayList);
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(AbstractC7806cz.m48168c(it2.next()));
        }
        c7302e.m44839g(arrayList2);
    }
}
