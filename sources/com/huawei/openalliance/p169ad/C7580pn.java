package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateV3;
import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.RewardItem;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EncryptionField;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7827f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.pn */
/* loaded from: classes8.dex */
public class C7580pn {
    /* renamed from: a */
    public static ContentRecord m46793a(C7305h c7305h) {
        if (c7305h == null) {
            return null;
        }
        ContentRecord contentRecord = new ContentRecord();
        contentRecord.m41444a(c7305h.m44601a());
        contentRecord.m41437a(c7305h.getMinEffectiveShowTime());
        contentRecord.m41436a(c7305h.getMinEffectiveShowRatio());
        contentRecord.m41510b(c7305h.m44661r());
        contentRecord.m41540d(c7305h.m44659q() == null ? 0 : c7305h.m44659q().intValue());
        contentRecord.m41536c(c7305h.getShowId());
        contentRecord.m41543d(c7305h.m44932R());
        contentRecord.m41549e(c7305h.getContentId());
        contentRecord.m41548e(c7305h.getStartTime());
        contentRecord.m41541d(c7305h.getEndTime());
        contentRecord.m41562g(c7305h.m44930Q());
        contentRecord.m41555f(c7305h.getTaskId());
        contentRecord.m41608t(c7305h.m44934T());
        contentRecord.m41610u(c7305h.getWhyThisAd());
        contentRecord.m41620z(c7305h.getAdChoiceUrl());
        contentRecord.m41385A(c7305h.getAdChoiceIcon());
        String strM44935U = c7305h.m44935U();
        if (!AbstractC7806cz.m48165b(strM44935U)) {
            EncryptionField<String> encryptionField = new EncryptionField<>(String.class);
            encryptionField.m41656a(strM44935U);
            contentRecord.m41441a(encryptionField);
        }
        RewardItem rewardItem = c7305h.getRewardItem();
        if (rewardItem != null) {
            contentRecord.m41442a(rewardItem);
        }
        contentRecord.m41507b(7);
        contentRecord.m41616x(c7305h.m44949ad());
        contentRecord.m41579k(c7305h.m44912H());
        contentRecord.m41569i(c7305h.m44904D());
        contentRecord.m41587m(c7305h.getIntent());
        contentRecord.m41511b(c7305h.m44920L());
        String strM44936V = c7305h.m44936V();
        if (!AbstractC7806cz.m48165b(strM44936V)) {
            EncryptionField<List<Monitor>> encryptionField2 = new EncryptionField<>(List.class, Monitor.class);
            encryptionField2.m41656a(strM44936V);
            contentRecord.m41509b(encryptionField2);
        }
        contentRecord.m41582l(c7305h.m44924N());
        contentRecord.m41550e(c7305h.m44922M());
        contentRecord.m41602r(c7305h.m44928P());
        contentRecord.m41605s(c7305h.getCtrlSwitchs());
        contentRecord.m41612v(c7305h.getUniqueId());
        String strM44937W = c7305h.m44937W();
        if (!TextUtils.isEmpty(strM44937W)) {
            EncryptionField<String> encryptionField3 = new EncryptionField<>(String.class);
            encryptionField3.m41656a(strM44937W);
            contentRecord.m41535c(encryptionField3);
        }
        contentRecord.m41447a(c7305h.isAutoDownloadApp());
        contentRecord.m41618y(c7305h.m44636f());
        contentRecord.m41479ab(c7305h.m44599B());
        contentRecord.m41592o(c7305h.m44639g());
        contentRecord.m41533c(1);
        contentRecord.m41387B(c7305h.m44641h() != null ? String.valueOf(c7305h.m44641h()) : null);
        contentRecord.m41391D(c7305h.m44643i());
        contentRecord.m41393E(c7305h.m44645j());
        contentRecord.m41396G(c7305h.m44647k());
        contentRecord.m41398H(c7305h.m44649l());
        contentRecord.m41544d(c7305h.m44651m());
        contentRecord.m41402J(c7305h.m44653n());
        contentRecord.m41404K(c7305h.m44953ah());
        contentRecord.m41560g(c7305h.m44657p());
        contentRecord.m41545d(c7305h.m44664s());
        contentRecord.m41593o(AbstractC7806cz.m48170d(c7305h.m44667u()));
        contentRecord.m41410N(c7305h.getAbilityDetailInfo());
        contentRecord.m41412O(c7305h.getHwChannelId());
        contentRecord.m41580k(c7305h.getCompliance());
        contentRecord.m41416Q(c7305h.m44620c());
        contentRecord.m41406L(c7305h.m44954ai());
        contentRecord.m41584l(c7305h.m44955aj());
        contentRecord.m41440a(c7305h.m44956ak());
        contentRecord.m41604s(c7305h.m44957al() == null ? -1 : c7305h.m44957al().intValue());
        contentRecord.m41551e(c7305h.isTransparencyOpen());
        contentRecord.m41420S(c7305h.getTransparencyTplUrl());
        contentRecord.m41422T(c7305h.m44598A());
        contentRecord.m41607t(c7305h.m44673x());
        return contentRecord;
    }

    /* renamed from: a */
    public static C7305h m46794a(Context context, ContentRecord contentRecord) {
        if (contentRecord == null || context == null) {
            return null;
        }
        C7305h c7305h = new C7305h();
        c7305h.m44909F(contentRecord.m41585m());
        c7305h.m44624c(contentRecord.m41588n());
        c7305h.m44966g(contentRecord.m41388C());
        c7305h.m44603a(contentRecord.m41603s());
        c7305h.m44614b(contentRecord.m41600r());
        c7305h.m44602a(contentRecord.m41392E());
        c7305h.m44621c(contentRecord.m41492an());
        c7305h.m44970h(contentRecord.m41431Y());
        c7305h.m44635e(contentRecord.m41591o());
        c7305h.m44911G(contentRecord.m41433Z());
        c7305h.m44921L(AbstractC7806cz.m48168c(contentRecord.m41558g()));
        c7305h.m44613b(7);
        c7305h.m44646j(AbstractC7806cz.m48168c(contentRecord.m41476aa()));
        c7305h.m44648k(AbstractC7806cz.m48168c(contentRecord.m41490al()));
        c7305h.m44650l(AbstractC7806cz.m48168c(contentRecord.m41491am()));
        c7305h.m44644i(contentRecord.m41486ah());
        c7305h.m44926O(contentRecord.m41457aI());
        List<String> listM41401J = contentRecord.m41401J();
        if (listM41401J != null && listM41401J.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = listM41401J.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC7806cz.m48168c(it.next()));
            }
            c7305h.m44964f(arrayList);
        }
        byte[] bArrM48089b = AbstractC7796cp.m48089b(context);
        if (contentRecord.m41395G() != null) {
            c7305h.m44913H(contentRecord.m41395G().m41657b(bArrM48089b));
        }
        EncryptionField<List<Monitor>> encryptionFieldM41405L = contentRecord.m41405L();
        if (encryptionFieldM41405L != null) {
            c7305h.m44915I(encryptionFieldM41405L.m41657b(bArrM48089b));
        }
        RewardItem rewardItemM41487ai = contentRecord.m41487ai();
        if (rewardItemM41487ai != null) {
            c7305h.m44943a(rewardItemM41487ai);
        }
        c7305h.m44972i(contentRecord.m41413P());
        c7305h.m44967g(contentRecord.m41409N());
        c7305h.m44905D(contentRecord.m41425V());
        c7305h.m44907E(contentRecord.m41427W());
        c7305h.m44903C(contentRecord.m41563h());
        MetaData metaDataM41568i = contentRecord.m41568i();
        if (metaDataM41568i == null) {
            return c7305h;
        }
        m46799a(c7305h, metaDataM41568i);
        EncryptionField<String> encryptionFieldM41480ac = contentRecord.m41480ac();
        if (encryptionFieldM41480ac != null) {
            c7305h.m44917J(encryptionFieldM41480ac.m41657b(bArrM48089b));
        }
        c7305h.m44615b(AbstractC7806cz.m48178h(contentRecord.m41493ao()));
        c7305h.m44611a(contentRecord.m41506b(context));
        c7305h.m44658p(contentRecord.m41456aH());
        c7305h.m44660q(AbstractC7806cz.m48168c(contentRecord.m41411O()));
        c7305h.m44617b(metaDataM41568i.m40275L());
        c7305h.m44625c(contentRecord.m41468aT());
        c7305h.m44610a(contentRecord.m41474aZ());
        c7305h.m44631d(contentRecord.m41517bd());
        c7305h.m44666t(contentRecord.m41516bc());
        m46798a(contentRecord, c7305h);
        c7305h.m44637f(contentRecord.m41472aX());
        c7305h.m44668u(contentRecord.m41520bg());
        return c7305h;
    }

    /* renamed from: a */
    public static C7305h m46795a(String str, Content content, byte[] bArr, String str2) {
        C7305h c7305h = new C7305h();
        c7305h.m44609a(content.m39912a());
        c7305h.m44909F(str);
        c7305h.m44624c(content.m39962g());
        c7305h.m44966g(content.m39979l());
        c7305h.m44603a(content.m39977k());
        c7305h.m44614b(content.m39974j());
        c7305h.m44602a(content.m39958f());
        c7305h.m44621c(content.m39893H());
        c7305h.m44970h(content.m40007z());
        c7305h.m44635e(content.m39966h());
        c7305h.m44911G(content.m39884A());
        c7305h.m44921L(AbstractC7806cz.m48168c(content.m39938b()));
        c7305h.m44613b(7);
        c7305h.m44646j(AbstractC7806cz.m48168c(content.m39889D()));
        c7305h.m44648k(AbstractC7806cz.m48168c(content.m39890E()));
        c7305h.m44650l(AbstractC7806cz.m48168c(content.m39891F()));
        c7305h.m44631d(content.m39930ae().booleanValue());
        c7305h.m44666t(content.m39929ad());
        BiddingInfo.C7295a c7295aM44457b = new BiddingInfo.C7295a().m44455a(content.m39932ag()).m44454a(content.m39933ah()).setLurl(content.m39935aj()).m44457b(content.m39934ai());
        if (!c7295aM44457b.m44456a().m44449a()) {
            c7305h.m44608a(c7295aM44457b.m44456a());
        }
        m46797a(content, c7305h);
        List<String> listM39983n = content.m39983n();
        if (listM39983n != null && listM39983n.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = listM39983n.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC7806cz.m48168c(it.next()));
            }
            c7305h.m44964f(arrayList);
        }
        String strM39981m = content.m39981m();
        if (strM39981m != null) {
            c7305h.m44913H(AbstractC7827f.m48394a(strM39981m, bArr));
        }
        List<Monitor> listM39987p = content.m39987p();
        if (listM39987p == null) {
            listM39987p = new ArrayList<>();
        }
        MetaData metaDataM39944c = content.m39944c();
        VastContent vastContentM46929a = C7590ps.m46929a(metaDataM39944c, 7, content.m39958f());
        if (vastContentM46929a != null) {
            AbstractC7185ho.m43821b("RewardAdConverter", "content:%s is vast ad, merge monitors", content.m39962g());
            listM39987p = C7590ps.m46933a(listM39987p, C7590ps.m46932a(vastContentM46929a));
        }
        if (listM39987p.size() > 0) {
            EncryptionField encryptionField = new EncryptionField(List.class, Monitor.class);
            encryptionField.m41655a((EncryptionField) listM39987p);
            c7305h.m44915I(encryptionField.m41657b(bArr));
        }
        RewardItem rewardItemM39888C = content.m39888C();
        if (rewardItemM39888C != null) {
            c7305h.m44943a(rewardItemM39888C);
        }
        c7305h.m44972i(content.m39991r());
        c7305h.m44967g(content.m39997u());
        c7305h.m44905D(content.m39999v());
        c7305h.m44907E(content.m40001w());
        c7305h.m44903C(content.m39949d());
        if (metaDataM39944c == null) {
            return c7305h;
        }
        if (vastContentM46929a != null) {
            AbstractC7185ho.m43821b("RewardAdConverter", "content:%s is vast ad, merge meta data", content.m39962g());
            C7590ps.m46937a(metaDataM39944c, vastContentM46929a, 7);
            c7305h.m44903C(AbstractC7758be.m47742b(metaDataM39944c));
            c7305h.m44626c(true);
        }
        m46799a(c7305h, metaDataM39944c);
        String strM39886B = content.m39886B();
        if (!TextUtils.isEmpty(strM39886B)) {
            EncryptionField encryptionField2 = new EncryptionField(String.class);
            encryptionField2.m41655a((EncryptionField) strM39886B);
            c7305h.m44917J(encryptionField2.m41657b(bArr));
        }
        c7305h.m44615b(content.m39894I());
        c7305h.m44611a(content.m39954e());
        c7305h.m44658p(content.m39903R());
        c7305h.m44926O(str2);
        c7305h.m44660q(AbstractC7806cz.m48168c(content.m39989q()));
        c7305h.m44617b(metaDataM39944c.m40275L());
        c7305h.m44662r(content.m39909X());
        c7305h.m44663s(AbstractC7806cz.m48168c(content.m39910Y()));
        c7305h.m44625c(content.m39911Z());
        c7305h.m44610a(content.m39928ac());
        c7305h.m44637f(content.m39927ab());
        return c7305h;
    }

    /* renamed from: a */
    private static List<ImageInfo> m46796a(List<com.huawei.openalliance.p169ad.beans.metadata.ImageInfo> list) {
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
    private static void m46797a(Content content, C7305h c7305h) {
        if (content == null || c7305h == null) {
            return;
        }
        TemplateV3 templateV3M39908W = content.m39908W();
        if (templateV3M39908W != null) {
            c7305h.m44929P(templateV3M39908W.m40557a());
            c7305h.m44941a(templateV3M39908W.m40560b());
            c7305h.m44973i(content.m39907V());
            c7305h.m44931Q(content.m39936ak());
        }
        c7305h.m44963f(content.m39906U());
    }

    /* renamed from: a */
    private static void m46798a(ContentRecord contentRecord, C7305h c7305h) {
        if (contentRecord == null || c7305h == null) {
            return;
        }
        c7305h.m44941a(contentRecord.m41469aU());
        c7305h.m44973i(contentRecord.m41471aW());
        c7305h.m44963f(Integer.valueOf(contentRecord.m41464aP()));
        c7305h.m44929P(contentRecord.m41463aO());
    }

    /* renamed from: a */
    private static void m46799a(C7305h c7305h, MetaData metaData) {
        c7305h.m44974x(AbstractC7806cz.m48168c(metaData.m40309e()));
        c7305h.m44975y(AbstractC7806cz.m48168c(metaData.m40312f()));
        c7305h.m44919K(metaData.m40346z());
        c7305h.m44923M(metaData.m40264A());
        c7305h.m44925N(metaData.m40265B());
        c7305h.m44960e(metaData.m40345y());
        c7305h.m44959d(m46796a(metaData.m40334p()));
        c7305h.m44961e(m46796a(metaData.m40315g()));
        VideoInfo videoInfoM40305d = metaData.m40305d();
        if (videoInfoM40305d != null) {
            c7305h.m44944a(new com.huawei.openalliance.p169ad.inter.data.VideoInfo(videoInfoM40305d));
        }
        c7305h.m44976z(metaData.m40318h());
        c7305h.m44628d(metaData.m40271H());
        c7305h.m44958d(metaData.m40320i());
        c7305h.m44969h(metaData.m40324k());
        c7305h.m44638f(AbstractC7806cz.m48168c(metaData.m40326l()));
        c7305h.m44901A(metaData.m40328m());
        c7305h.m44902B(metaData.m40330n());
        c7305h.m44640g(metaData.m40332o());
        c7305h.m44616b(AbstractC7806cz.m48168c(metaData.m40280a()));
        c7305h.m44634e(metaData.m40278O());
        ApkInfo apkInfoM40339s = metaData.m40339s();
        if (apkInfoM40339s != null) {
            AppInfo appInfo = new AppInfo(apkInfoM40339s);
            appInfo.m44415m(c7305h.getIntent());
            appInfo.m44433v(c7305h.getUniqueId());
            appInfo.m44402h(metaData.m40266C());
            c7305h.m44942a(appInfo);
        }
        c7305h.m44630d(metaData.m40341u());
    }
}
