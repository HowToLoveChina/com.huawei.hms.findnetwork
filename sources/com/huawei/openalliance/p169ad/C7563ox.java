package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateV3;
import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
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

/* renamed from: com.huawei.openalliance.ad.ox */
/* loaded from: classes8.dex */
public class C7563ox {
    /* renamed from: a */
    public static ContentRecord m46653a(C7301d c7301d) {
        if (c7301d == null) {
            return null;
        }
        ContentRecord contentRecord = new ContentRecord();
        contentRecord.m41444a(c7301d.m44601a());
        contentRecord.m41436a(c7301d.getMinEffectiveShowRatio());
        contentRecord.m41437a(c7301d.getMinEffectiveShowRatio());
        contentRecord.m41510b(c7301d.m44661r());
        contentRecord.m41540d(c7301d.m44659q() == null ? 0 : c7301d.m44659q().intValue());
        contentRecord.m41440a(c7301d.m44719Z() == null ? new TemplateData() : c7301d.m44719Z());
        contentRecord.m41406L(c7301d.m44718Y() == null ? Constants.NULL_TEMPLATE_ID : c7301d.m44718Y());
        contentRecord.m41604s(c7301d.m44717X() == null ? -1 : c7301d.m44717X().intValue());
        contentRecord.m41584l(c7301d.m44725aa() == null ? new ArrayList<>() : c7301d.m44725aa());
        contentRecord.m41536c(c7301d.getShowId());
        contentRecord.m41543d(c7301d.m44710Q());
        contentRecord.m41549e(c7301d.getContentId());
        contentRecord.m41548e(c7301d.getStartTime());
        contentRecord.m41541d(c7301d.getEndTime());
        contentRecord.m41562g(c7301d.m44708P());
        contentRecord.m41555f(c7301d.getTaskId());
        contentRecord.m41608t(c7301d.m44712S());
        contentRecord.m41610u(c7301d.getWhyThisAd());
        contentRecord.m41620z(c7301d.getAdChoiceUrl());
        contentRecord.m41385A(c7301d.getAdChoiceIcon());
        contentRecord.m41396G(c7301d.m44647k());
        contentRecord.m41398H(c7301d.m44649l());
        contentRecord.m41593o(c7301d.m44667u());
        contentRecord.m41607t(c7301d.m44673x());
        String strM44688F = c7301d.m44688F();
        if (!AbstractC7806cz.m48165b(strM44688F)) {
            EncryptionField<String> encryptionField = new EncryptionField<>(String.class);
            encryptionField.m41656a(strM44688F);
            contentRecord.m41441a(encryptionField);
        }
        RewardItem rewardItemM44684D = c7301d.m44684D();
        if (rewardItemM44684D != null) {
            contentRecord.m41442a(rewardItemM44684D);
        }
        contentRecord.m41507b(12);
        contentRecord.m41616x(c7301d.m44715V());
        contentRecord.m41579k(c7301d.m44692H());
        contentRecord.m41569i(c7301d.m44686E());
        contentRecord.m41587m(c7301d.getIntent());
        contentRecord.m41511b(c7301d.m44700L());
        String strM44702M = c7301d.m44702M();
        if (!AbstractC7806cz.m48165b(strM44702M)) {
            EncryptionField<List<Monitor>> encryptionField2 = new EncryptionField<>(List.class, Monitor.class);
            encryptionField2.m41656a(strM44702M);
            contentRecord.m41509b(encryptionField2);
        }
        contentRecord.m41582l(c7301d.m44704N());
        contentRecord.m41550e(c7301d.m44726ab());
        contentRecord.m41602r(c7301d.m44706O());
        contentRecord.m41605s(c7301d.getCtrlSwitchs());
        contentRecord.m41612v(c7301d.getUniqueId());
        String strM44713T = c7301d.m44713T();
        if (!TextUtils.isEmpty(strM44713T)) {
            EncryptionField<String> encryptionField3 = new EncryptionField<>(String.class);
            encryptionField3.m41656a(strM44713T);
            contentRecord.m41535c(encryptionField3);
        }
        contentRecord.m41447a(c7301d.isAutoDownloadApp());
        contentRecord.m41618y(c7301d.m44636f());
        contentRecord.m41479ab(c7301d.m44599B());
        contentRecord.m41592o(c7301d.m44639g());
        contentRecord.m41387B(c7301d.m44641h() != null ? String.valueOf(c7301d.m44641h()) : null);
        contentRecord.m41391D(c7301d.m44643i());
        contentRecord.m41393E(c7301d.m44645j());
        contentRecord.m41571i(c7301d.m44727ac());
        contentRecord.m41578k(c7301d.getCreativeType());
        contentRecord.m41544d(c7301d.m44651m());
        contentRecord.m41402J(c7301d.m44653n());
        contentRecord.m41560g(c7301d.m44657p());
        contentRecord.m41545d(c7301d.m44664s());
        contentRecord.m41410N(c7301d.getAbilityDetailInfo());
        contentRecord.m41412O(c7301d.getHwChannelId());
        contentRecord.m41580k(c7301d.getCompliance());
        contentRecord.m41416Q(c7301d.m44620c());
        contentRecord.m41551e(c7301d.isTransparencyOpen());
        contentRecord.m41420S(c7301d.getTransparencyTplUrl());
        contentRecord.m41422T(c7301d.m44598A());
        return contentRecord;
    }

    /* renamed from: a */
    public static C7301d m46654a(Context context, ContentRecord contentRecord) {
        if (contentRecord == null || context == null) {
            return null;
        }
        C7301d c7301d = new C7301d();
        c7301d.m44735f(Integer.valueOf(contentRecord.m41464aP()));
        c7301d.m44739g(contentRecord.m41471aW());
        c7301d.m44705N(contentRecord.m41463aO());
        c7301d.m44720a(contentRecord.m41469aU());
        c7301d.m44693H(contentRecord.m41585m());
        c7301d.m44624c(contentRecord.m41588n());
        c7301d.m44738g(contentRecord.m41388C());
        c7301d.m44603a(contentRecord.m41603s());
        c7301d.m44614b(contentRecord.m41600r());
        c7301d.m44602a(contentRecord.m41392E());
        c7301d.m44621c(contentRecord.m41492an());
        c7301d.m44736f(contentRecord.m41431Y());
        c7301d.m44635e(contentRecord.m41591o());
        c7301d.m44695I(contentRecord.m41433Z());
        c7301d.m44613b(12);
        c7301d.m44646j(AbstractC7806cz.m48168c(contentRecord.m41476aa()));
        c7301d.m44648k(AbstractC7806cz.m48168c(contentRecord.m41490al()));
        c7301d.m44650l(AbstractC7806cz.m48168c(contentRecord.m41491am()));
        c7301d.m44644i(contentRecord.m41486ah());
        c7301d.m44660q(AbstractC7806cz.m48168c(contentRecord.m41411O()));
        c7301d.m44631d(contentRecord.m41517bd());
        c7301d.m44666t(contentRecord.m41516bc());
        c7301d.m44637f(contentRecord.m41472aX());
        c7301d.m44668u(contentRecord.m41520bg());
        List<String> listM41401J = contentRecord.m41401J();
        if (listM41401J != null && listM41401J.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = listM41401J.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC7806cz.m48168c(it.next()));
            }
            c7301d.m44733e(arrayList);
        }
        byte[] bArrM48089b = AbstractC7796cp.m48089b(context);
        if (contentRecord.m41395G() != null) {
            c7301d.m44745x(contentRecord.m41395G().m41657b(bArrM48089b));
        }
        EncryptionField<List<Monitor>> encryptionFieldM41405L = contentRecord.m41405L();
        if (encryptionFieldM41405L != null) {
            c7301d.m44687E(encryptionFieldM41405L.m41657b(bArrM48089b));
        }
        RewardItem rewardItemM41487ai = contentRecord.m41487ai();
        if (rewardItemM41487ai != null) {
            c7301d.m44722a(rewardItemM41487ai);
        }
        c7301d.m44744i(contentRecord.m41413P());
        c7301d.m44742h(contentRecord.m41409N());
        c7301d.m44689F(contentRecord.m41425V());
        c7301d.m44691G(contentRecord.m41427W());
        c7301d.m44685D(contentRecord.m41563h());
        MetaData metaDataM41568i = contentRecord.m41568i();
        if (metaDataM41568i == null) {
            return c7301d;
        }
        m46657a(c7301d, metaDataM41568i);
        EncryptionField<String> encryptionFieldM41480ac = contentRecord.m41480ac();
        if (encryptionFieldM41480ac != null) {
            c7301d.m44697J(encryptionFieldM41480ac.m41657b(bArrM48089b));
        }
        c7301d.m44615b(AbstractC7806cz.m48178h(contentRecord.m41493ao()));
        c7301d.m44707O(contentRecord.m41619z());
        c7301d.m44611a(contentRecord.m41506b(context));
        c7301d.m44658p(contentRecord.m41456aH());
        c7301d.m44625c(contentRecord.m41468aT());
        c7301d.m44610a(contentRecord.m41474aZ());
        return c7301d;
    }

    /* renamed from: a */
    public static C7301d m46655a(String str, Content content, byte[] bArr) {
        C7301d c7301d = new C7301d();
        c7301d.m44693H(str);
        c7301d.m44735f(content.m39906U());
        c7301d.m44609a(content.m39912a());
        c7301d.m44624c(content.m39962g());
        c7301d.m44738g(content.m39979l());
        c7301d.m44603a(content.m39977k());
        c7301d.m44614b(content.m39974j());
        c7301d.m44602a(content.m39958f());
        c7301d.m44736f(content.m40007z());
        c7301d.m44635e(content.m39966h());
        c7301d.m44695I(content.m39884A());
        c7301d.m44613b(12);
        c7301d.m44646j(AbstractC7806cz.m48168c(content.m39889D()));
        c7301d.m44648k(AbstractC7806cz.m48168c(content.m39890E()));
        c7301d.m44650l(AbstractC7806cz.m48168c(content.m39891F()));
        c7301d.m44660q(AbstractC7806cz.m48168c(content.m39989q()));
        c7301d.m44631d(content.m39930ae().booleanValue());
        c7301d.m44666t(content.m39929ad());
        c7301d.m44637f(content.m39927ab());
        List<String> listM39983n = content.m39983n();
        if (listM39983n != null && listM39983n.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = listM39983n.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC7806cz.m48168c(it.next()));
            }
            c7301d.m44733e(arrayList);
        }
        String strM39981m = content.m39981m();
        if (strM39981m != null) {
            c7301d.m44745x(AbstractC7827f.m48394a(strM39981m, bArr));
        }
        List<Monitor> listM39987p = content.m39987p();
        if (listM39987p == null) {
            listM39987p = new ArrayList<>();
        }
        MetaData metaDataM39944c = content.m39944c();
        VastContent vastContentM46929a = C7590ps.m46929a(metaDataM39944c, 12, content.m39958f());
        if (vastContentM46929a != null) {
            AbstractC7185ho.m43821b("InterstitialAdConverter", "content:%s is vast ad, merge monitors", content.m39962g());
            listM39987p = C7590ps.m46933a(listM39987p, C7590ps.m46932a(vastContentM46929a));
        }
        if (listM39987p.size() > 0) {
            EncryptionField encryptionField = new EncryptionField(List.class, Monitor.class);
            encryptionField.m41655a((EncryptionField) listM39987p);
            c7301d.m44687E(encryptionField.m41657b(bArr));
        }
        RewardItem rewardItemM39888C = content.m39888C();
        if (rewardItemM39888C != null) {
            c7301d.m44722a(rewardItemM39888C);
        }
        c7301d.m44744i(content.m39991r());
        c7301d.m44742h(content.m39997u());
        c7301d.m44689F(content.m39999v());
        c7301d.m44691G(content.m40001w());
        c7301d.m44685D(content.m39949d());
        if (metaDataM39944c == null) {
            return c7301d;
        }
        if (vastContentM46929a != null) {
            AbstractC7185ho.m43821b("InterstitialAdConverter", "content:%s is vast ad, merge meta data", content.m39962g());
            C7590ps.m46937a(metaDataM39944c, vastContentM46929a, 12);
            c7301d.m44685D(AbstractC7758be.m47742b(metaDataM39944c));
            c7301d.m44626c(true);
        }
        m46657a(c7301d, metaDataM39944c);
        String strM39886B = content.m39886B();
        if (!TextUtils.isEmpty(strM39886B)) {
            EncryptionField encryptionField2 = new EncryptionField(String.class);
            encryptionField2.m41655a((EncryptionField) strM39886B);
            c7301d.m44697J(encryptionField2.m41657b(bArr));
        }
        TemplateV3 templateV3M39908W = content.m39908W();
        if (templateV3M39908W != null) {
            c7301d.m44705N(templateV3M39908W.m40557a());
            c7301d.m44720a(templateV3M39908W.m40560b());
            c7301d.m44739g(content.m39907V());
            c7301d.m44709P(content.m39936ak());
        }
        c7301d.m44735f(content.m39906U());
        c7301d.m44615b(content.m39894I());
        c7301d.m44611a(content.m39954e());
        c7301d.m44658p(content.m39903R());
        c7301d.m44662r(content.m39909X());
        c7301d.m44663s(AbstractC7806cz.m48168c(content.m39910Y()));
        c7301d.m44625c(content.m39911Z());
        c7301d.m44610a(content.m39928ac());
        return c7301d;
    }

    /* renamed from: a */
    private static List<ImageInfo> m46656a(List<com.huawei.openalliance.p169ad.beans.metadata.ImageInfo> list) {
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
    private static void m46657a(C7301d c7301d, MetaData metaData) {
        c7301d.m44746y(AbstractC7806cz.m48168c(metaData.m40309e()));
        c7301d.m44747z(AbstractC7806cz.m48168c(metaData.m40312f()));
        c7301d.m44699K(metaData.m40346z());
        c7301d.m44701L(metaData.m40264A());
        c7301d.m44703M(metaData.m40265B());
        c7301d.m44732e(metaData.m40345y());
        c7301d.m44731d(m46656a(metaData.m40334p()));
        VideoInfo videoInfoM40305d = metaData.m40305d();
        if (videoInfoM40305d != null) {
            c7301d.m44723a(new com.huawei.openalliance.p169ad.inter.data.VideoInfo(videoInfoM40305d));
        }
        c7301d.m44681A(metaData.m40318h());
        c7301d.m44628d(metaData.m40271H());
        c7301d.m44730d(metaData.m40320i());
        c7301d.m44741h(metaData.m40324k());
        c7301d.m44638f(AbstractC7806cz.m48168c(metaData.m40326l()));
        c7301d.m44682B(metaData.m40328m());
        c7301d.m44683C(metaData.m40330n());
        c7301d.m44640g(metaData.m40332o());
        c7301d.m44616b(AbstractC7806cz.m48168c(metaData.m40280a()));
        c7301d.m44617b(metaData.m40275L());
        c7301d.m44634e(metaData.m40278O());
        ApkInfo apkInfoM40339s = metaData.m40339s();
        if (apkInfoM40339s != null) {
            AppInfo appInfo = new AppInfo(apkInfoM40339s);
            appInfo.m44415m(c7301d.getIntent());
            appInfo.m44433v(c7301d.getUniqueId());
            appInfo.m44402h(metaData.m40266C());
            c7301d.m44721a(appInfo);
        }
        c7301d.m44630d(metaData.m40341u());
    }
}
