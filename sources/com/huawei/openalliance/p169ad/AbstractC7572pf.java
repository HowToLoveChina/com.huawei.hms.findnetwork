package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.AdEvent;
import com.huawei.openalliance.p169ad.beans.metadata.AppCollectInfo;
import com.huawei.openalliance.p169ad.beans.metadata.AppCollection;
import com.huawei.openalliance.p169ad.beans.metadata.BluetoothInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.NegativeFb;
import com.huawei.openalliance.p169ad.beans.metadata.ParamFromServer;
import com.huawei.openalliance.p169ad.beans.metadata.Precontent;
import com.huawei.openalliance.p169ad.beans.metadata.Skip;
import com.huawei.openalliance.p169ad.beans.metadata.Template;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.beans.metadata.WifiInfo;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.p171db.bean.AppDataCollectionRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EncryptionField;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.PlacementRecord;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* renamed from: com.huawei.openalliance.ad.pf */
/* loaded from: classes8.dex */
public abstract class AbstractC7572pf {
    /* renamed from: a */
    private static AdEvent m46742a(EventRecord eventRecord, Context context) {
        if (eventRecord == null) {
            return null;
        }
        AdEvent adEvent = new AdEvent();
        adEvent.m39454c(eventRecord.m41752j());
        adEvent.m39439a(eventRecord.m41755k());
        adEvent.m39438a(eventRecord.m41767o());
        adEvent.m39445b(eventRecord.m41769p());
        adEvent.m39451c(eventRecord.m41771q());
        adEvent.m39458d(eventRecord.m41748i());
        adEvent.m39449b(eventRecord.m41758l());
        adEvent.m39444a(eventRecord.m41775s());
        adEvent.m39450b(eventRecord.m41777t());
        adEvent.m39446b(eventRecord.m41783w());
        adEvent.m39464f(eventRecord.m41779u());
        adEvent.m39467g(eventRecord.m41781v());
        adEvent.m39456d(AbstractC7806cz.m48178h(eventRecord.m41785x()));
        adEvent.m39455c(eventRecord.m41787y());
        adEvent.m39459e(AbstractC7806cz.m48178h(eventRecord.m41789z()));
        adEvent.m39462f(AbstractC7806cz.m48178h(eventRecord.m41664A()));
        adEvent.m39465g(AbstractC7806cz.m48178h(eventRecord.m41666B()));
        adEvent.m39468h(AbstractC7806cz.m48178h(eventRecord.m41668C()));
        adEvent.m39477l(eventRecord.m41689T());
        adEvent.m39479m(eventRecord.m41690U());
        adEvent.m39470i(AbstractC7806cz.m48178h(eventRecord.m41670D()));
        adEvent.m39472j(AbstractC7806cz.m48178h(eventRecord.m41672E()));
        adEvent.m39469h(eventRecord.m41675G());
        adEvent.m39474k(AbstractC7806cz.m48178h(eventRecord.m41679J()));
        adEvent.m39457d(AbstractC7806cz.m48180i(eventRecord.m41678I()));
        adEvent.m39476l(AbstractC7806cz.m48178h(eventRecord.m41681L()));
        adEvent.m39478m(AbstractC7806cz.m48178h(eventRecord.m41677H()));
        adEvent.m39471i(eventRecord.m41696a());
        adEvent.m39480n(AbstractC7806cz.m48178h(eventRecord.m41680K()));
        adEvent.m39482o(Integer.valueOf(eventRecord.m41682M()));
        adEvent.m39473j(eventRecord.m41683N());
        adEvent.m39475k(eventRecord.m41684O());
        adEvent.m39484p(Integer.valueOf(eventRecord.m41686Q()));
        adEvent.m39486q(eventRecord.m41685P());
        adEvent.m39481n(eventRecord.m41693X());
        adEvent.m39483o(eventRecord.m41694Y());
        adEvent.m39487q(eventRecord.m41711ah());
        if (-111111 != eventRecord.m41712ai()) {
            adEvent.m39495x(Integer.valueOf(eventRecord.m41712ai()));
        }
        if (-111111 != eventRecord.m41691V()) {
            adEvent.m39488r(Integer.valueOf(eventRecord.m41691V()));
        }
        if (-111111 != eventRecord.m41692W()) {
            adEvent.m39490s(Integer.valueOf(eventRecord.m41692W()));
        }
        if (-111111 != eventRecord.m41744h()) {
            adEvent.m39441a(Integer.valueOf(eventRecord.m41744h()));
        }
        if (-111111 != eventRecord.m41718b()) {
            adEvent.m39442a(Long.valueOf(eventRecord.m41718b()));
        }
        adEvent.m39443a(eventRecord.m41724c());
        if (-111111 != eventRecord.m41728d()) {
            adEvent.m39448b(Long.valueOf(eventRecord.m41728d()));
        }
        if (-111111 != eventRecord.m41732e()) {
            adEvent.m39453c(Long.valueOf(eventRecord.m41732e()));
        }
        if (-111111 != eventRecord.m41736f()) {
            adEvent.m39447b(Integer.valueOf(eventRecord.m41736f()));
        }
        if (-111111 != eventRecord.m41740g()) {
            adEvent.m39452c(Integer.valueOf(eventRecord.m41740g()));
        }
        if (-111111 != eventRecord.m41695Z() && eventRecord.m41695Z() > 0) {
            adEvent.m39460e(Long.valueOf(eventRecord.m41695Z()));
        }
        if (-111111 != eventRecord.m41704aa()) {
            adEvent.m39492u(Integer.valueOf(eventRecord.m41704aa()));
            adEvent.m39493v(Integer.valueOf(eventRecord.m41704aa()));
        }
        adEvent.m39485p(eventRecord.m41705ab());
        if (-111111 != eventRecord.m41706ac()) {
            adEvent.m39494w(Integer.valueOf(eventRecord.m41706ac()));
        }
        if (-111111 != eventRecord.m41707ad()) {
            adEvent.m39491t(Integer.valueOf(eventRecord.m41707ad()));
        }
        if (-111111 != eventRecord.m41715al()) {
            adEvent.m39463f(Long.valueOf(eventRecord.m41715al()));
        }
        if (-111111 != eventRecord.m41716am()) {
            adEvent.m39466g(Long.valueOf(eventRecord.m41716am()));
        }
        if (-111111 != eventRecord.m41709af()) {
            adEvent.m39496y(Integer.valueOf(eventRecord.m41709af()));
        }
        if (-111111 != eventRecord.m41710ag()) {
            adEvent.m39497z(Integer.valueOf(eventRecord.m41710ag()));
        }
        if (!AbstractC7806cz.m48165b(eventRecord.m41717an())) {
            adEvent.m39489r(eventRecord.m41717an());
        }
        m46752a(eventRecord, context, adEvent);
        return adEvent;
    }

    /* renamed from: b */
    public static PlacementRecord m46753b(String str, Precontent precontent, int i10) {
        PlacementRecord placementRecordM46747a = m46747a(str, new Content(precontent), i10);
        if (placementRecordM46747a != null) {
            placementRecordM46747a.m41807e(0);
        }
        return placementRecordM46747a;
    }

    /* renamed from: c */
    private static void m46756c(Content content, ContentRecord contentRecord) {
        int iM40185e;
        contentRecord.m41511b(content.m39949d());
        MetaData metaDataM39944c = content.m39944c();
        if (metaDataM39944c == null) {
            return;
        }
        contentRecord.m41540d(metaDataM39944c.m40299c() == null ? 0 : metaDataM39944c.m40299c().intValue());
        contentRecord.m41436a(metaDataM39944c.m40324k());
        contentRecord.m41437a(metaDataM39944c.m40320i());
        contentRecord.m41508b(metaDataM39944c.m40322j());
        contentRecord.m41510b(metaDataM39944c.m40293b());
        contentRecord.m41587m(metaDataM39944c.m40332o());
        contentRecord.m41579k(metaDataM39944c.m40318h());
        contentRecord.m41556f(metaDataM39944c.m40343w());
        VideoInfo videoInfoM40305d = metaDataM39944c.m40305d();
        if (videoInfoM40305d != null) {
            Float fM40500m = videoInfoM40305d.m40500m();
            if (fM40500m != null) {
                iM40185e = (int) ((720 * 1.0f) / fM40500m.floatValue());
                contentRecord.m41553f(720);
                contentRecord.m41559g(iM40185e);
            }
        } else {
            List<ImageInfo> listM40334p = metaDataM39944c.m40334p();
            if (listM40334p != null && listM40334p.size() > 0) {
                ImageInfo imageInfo = listM40334p.get(0);
                contentRecord.m41571i(imageInfo.m40180c());
                contentRecord.m41553f(imageInfo.m40183d());
                iM40185e = imageInfo.m40185e();
                contentRecord.m41559g(iM40185e);
            }
        }
        contentRecord.m41616x(metaDataM39944c.m40265B());
    }

    /* renamed from: a */
    public static ContentRecord m46743a(AdLandingPageData adLandingPageData) {
        return adLandingPageData == null ? new ContentRecord() : adLandingPageData.m44329y();
    }

    /* renamed from: b */
    public static List<AppCollection> m46754b(Collection<AppDataCollectionRecord> collection, Context context) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        byte[] bArrM48089b = AbstractC7796cp.m48089b(context);
        ArrayList arrayList = new ArrayList();
        for (AppDataCollectionRecord appDataCollectionRecord : collection) {
            AppCollection appCollection = new AppCollection();
            appCollection.m39775a(Long.valueOf(appDataCollectionRecord.m41360o()));
            appCollection.m39776a(appDataCollectionRecord.m41331b());
            appCollection.m39802b(appDataCollectionRecord.m41362p());
            appCollection.m39807c(appDataCollectionRecord.m41364q());
            appCollection.m39811d(appDataCollectionRecord.m41366r());
            appCollection.m39813e(appDataCollectionRecord.m41368s());
            appCollection.m39801b(AbstractC7806cz.m48180i(appDataCollectionRecord.m41335c()));
            appCollection.m39774a(AbstractC7806cz.m48178h(appDataCollectionRecord.m41338d()));
            appCollection.m39815f(appDataCollectionRecord.m41340e());
            appCollection.m39817g(appDataCollectionRecord.m41342f());
            appCollection.m39800b(Integer.valueOf(appDataCollectionRecord.m41344g()));
            appCollection.m39819h(appDataCollectionRecord.m41346h());
            appCollection.m39833o(appDataCollectionRecord.m41370t());
            appCollection.m39831n(appDataCollectionRecord.m41348i());
            EncryptionField<List<AppCollectInfo>> encryptionFieldM41294X = appDataCollectionRecord.m41294X();
            if (encryptionFieldM41294X != null) {
                List<AppCollectInfo> listM41653a = encryptionFieldM41294X.m41653a(bArrM48089b);
                if (!AbstractC7760bg.m47767a(listM41653a)) {
                    appCollection.m39777a(listM41653a);
                }
            }
            appCollection.m39835p(appDataCollectionRecord.m41372u());
            appCollection.m39837q(appDataCollectionRecord.m41374v());
            appCollection.m39839r(appDataCollectionRecord.m41376w());
            appCollection.m39841s(appDataCollectionRecord.m41378x());
            appCollection.m39843t(appDataCollectionRecord.m41380y());
            appCollection.m39821i(appDataCollectionRecord.m41350j());
            appCollection.m39823j(appDataCollectionRecord.m41352k());
            appCollection.m39825k(appDataCollectionRecord.m41354l());
            appCollection.m39827l(appDataCollectionRecord.m41356m());
            appCollection.m39829m(appDataCollectionRecord.m41358n());
            appCollection.m39845u(appDataCollectionRecord.m41382z());
            appCollection.m39847v(appDataCollectionRecord.m41248A());
            appCollection.m39849w(appDataCollectionRecord.m41250B());
            appCollection.m39851x(appDataCollectionRecord.m41252C());
            appCollection.m39853y(appDataCollectionRecord.m41254D());
            appCollection.m39855z(appDataCollectionRecord.m41256E());
            appCollection.m39721A(appDataCollectionRecord.m41258F());
            appCollection.m39723B(appDataCollectionRecord.m41260G());
            appCollection.m39725C(appDataCollectionRecord.m41262H());
            appCollection.m39727D(appDataCollectionRecord.m41264I());
            appCollection.m39729E(appDataCollectionRecord.m41266J());
            appCollection.m39731F(appDataCollectionRecord.m41268K());
            appCollection.m39733G(appDataCollectionRecord.m41270L());
            appCollection.m39735H(appDataCollectionRecord.m41272M());
            appCollection.m39737I(appDataCollectionRecord.m41274N());
            appCollection.m39739J(appDataCollectionRecord.m41276O());
            appCollection.m39741K(appDataCollectionRecord.m41278P());
            appCollection.m39743L(appDataCollectionRecord.m41280Q());
            appCollection.m39745M(appDataCollectionRecord.m41282R());
            appCollection.m39747N(appDataCollectionRecord.m41284S());
            appCollection.m39791ag(appDataCollectionRecord.m41330aq());
            appCollection.m39773a(appDataCollectionRecord.m41300a());
            appCollection.m39810d(AbstractC7806cz.m48178h(appDataCollectionRecord.m41288U()));
            appCollection.m39805c(AbstractC7806cz.m48178h(appDataCollectionRecord.m41286T()));
            EncryptionField<List<BluetoothInfo>> encryptionFieldM41290V = appDataCollectionRecord.m41290V();
            if (encryptionFieldM41290V != null) {
                List<BluetoothInfo> listM41653a2 = encryptionFieldM41290V.m41653a(bArrM48089b);
                if (!AbstractC7760bg.m47767a(listM41653a2)) {
                    appCollection.m39803b(listM41653a2);
                }
            }
            EncryptionField<List<WifiInfo>> encryptionFieldM41292W = appDataCollectionRecord.m41292W();
            if (encryptionFieldM41292W != null) {
                List<WifiInfo> listM41653a3 = encryptionFieldM41292W.m41653a(bArrM48089b);
                if (!AbstractC7760bg.m47767a(listM41653a3)) {
                    appCollection.m39808c(listM41653a3);
                }
            }
            appCollection.m39806c(Long.valueOf(AbstractC7811dd.m48327f()));
            appCollection.m39749O(appDataCollectionRecord.m41296Y());
            appCollection.m39751P(appDataCollectionRecord.m41298Z());
            EncryptionField<String> encryptionFieldM41305aa = appDataCollectionRecord.m41305aa();
            if (encryptionFieldM41305aa != null) {
                String strM41653a = encryptionFieldM41305aa.m41653a(bArrM48089b);
                if (!AbstractC7806cz.m48165b(strM41653a)) {
                    appCollection.m39753Q(strM41653a);
                }
            }
            appCollection.m39755R(appDataCollectionRecord.m41307ab());
            appCollection.m39757S(appDataCollectionRecord.m41309ac());
            appCollection.m39759T(appDataCollectionRecord.m41311ad());
            appCollection.m39761U(appDataCollectionRecord.m41313ae());
            appCollection.m39763V(appDataCollectionRecord.m41315af());
            appCollection.m39765W(appDataCollectionRecord.m41317ag());
            appCollection.m39767X(appDataCollectionRecord.m41319ah());
            appCollection.m39769Y(appDataCollectionRecord.m41321ai());
            appCollection.m39771Z(appDataCollectionRecord.m41323aj());
            appCollection.m39779aa(appDataCollectionRecord.m41324ak());
            appCollection.m39785ad(appDataCollectionRecord.m41327an());
            appCollection.m39787ae(appDataCollectionRecord.m41328ao());
            appCollection.m39781ab(appDataCollectionRecord.m41325al());
            appCollection.m39783ac(appDataCollectionRecord.m41326am());
            appCollection.m39789af(appDataCollectionRecord.m41329ap());
            arrayList.add(appCollection);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static ContentRecord m46744a(String str, Content content, int i10, String str2) {
        ContentRecord contentRecordM46745a = m46745a(str, content, i10, str2, false);
        if (contentRecordM46745a != null) {
            contentRecordM46745a.m41533c(1);
        }
        return contentRecordM46745a;
    }

    /* renamed from: b */
    private static void m46755b(Content content, ContentRecord contentRecord) {
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
        contentRecord.m41576j(arrayList);
    }

    /* renamed from: a */
    private static ContentRecord m46745a(String str, Content content, int i10, String str2, boolean z10) {
        if (content == null || (!z10 && AbstractC7806cz.m48165b(str))) {
            return null;
        }
        ContentRecord contentRecord = new ContentRecord();
        contentRecord.m41444a(content.m39912a());
        contentRecord.m41564h(0);
        contentRecord.m41566h(AbstractC7741ao.m47561b("yyyy-MM-dd"));
        contentRecord.m41569i(content.m39979l());
        contentRecord.m41578k(content.m39958f());
        contentRecord.m41549e(content.m39962g());
        contentRecord.m41555f(content.m39966h());
        contentRecord.m41543d(str);
        contentRecord.m41541d(content.m39974j());
        contentRecord.m41548e(content.m39977k());
        contentRecord.m41547e(content.m39970i());
        contentRecord.m41574j(0);
        contentRecord.m41554f(AbstractC7741ao.m47566c());
        contentRecord.m41446a(content.m39983n());
        contentRecord.m41512b(content.m39985o());
        contentRecord.m41562g(content.m40007z());
        contentRecord.m41608t(content.m39884A());
        contentRecord.m41538c(content.m39895J() != 0);
        contentRecord.m41394F(content.m39898M());
        String strM39981m = content.m39981m();
        if (strM39981m != null) {
            contentRecord.m41583l(strM39981m);
        }
        contentRecord.m41507b(i10);
        m46751a(content, contentRecord);
        m46756c(content, contentRecord);
        contentRecord.m41537c(content.m39987p());
        contentRecord.m41593o(AbstractC7806cz.m48168c(content.m39989q()));
        contentRecord.m41596p(content.m39995t());
        contentRecord.m41582l(content.m39991r());
        contentRecord.m41550e(content.m39997u());
        contentRecord.m41602r(content.m39999v());
        contentRecord.m41605s(content.m40001w());
        contentRecord.m41614w(content.m39886B());
        contentRecord.m41400I(content.m39900O());
        contentRecord.m41610u(content.m39889D());
        contentRecord.m41620z(content.m39890E());
        contentRecord.m41385A(content.m39891F());
        contentRecord.m41551e(content.m39930ae().booleanValue());
        contentRecord.m41420S(content.m39929ad());
        contentRecord.m41592o(content.m39893H());
        contentRecord.m41387B(content.m39894I() != null ? String.valueOf(content.m39894I()) : null);
        if (content.m39897L() != null) {
            contentRecord.m41598q(content.m39897L().intValue());
        }
        if (content.m39896K() != null) {
            contentRecord.m41595p(content.m39896K().intValue());
        }
        contentRecord.m41601r(content.m39899N());
        contentRecord.m41567h(content.m39901P());
        contentRecord.m41572i(content.m39902Q());
        contentRecord.m41544d(content.m39954e());
        contentRecord.m41402J(content.m39903R());
        contentRecord.m41404K(str2);
        contentRecord.m41439a(content.m39904S());
        m46755b(content, contentRecord);
        if (content.m39908W() != null) {
            contentRecord.m41406L(content.m39908W().m40557a());
            contentRecord.m41440a(content.m39908W().m40560b());
            contentRecord.m41414P(content.m39908W().m40562c());
            contentRecord.m41432Y(content.m39908W().m40564d());
            contentRecord.m41434Z(content.m39908W().m40566e());
        }
        contentRecord.m41584l(content.m39907V());
        contentRecord.m41477aa(content.m39936ak());
        contentRecord.m41604s(content.m39906U() == null ? -1 : content.m39906U().intValue());
        contentRecord.m41410N(content.m39909X());
        contentRecord.m41412O(AbstractC7806cz.m48168c(content.m39910Y()));
        contentRecord.m41580k(content.m39911Z());
        contentRecord.m41438a(content.m39926aa());
        if (1 == i10) {
            contentRecord.m41612v(UUID.randomUUID().toString());
        }
        contentRecord.m41607t(content.m39927ab());
        contentRecord.m41416Q(content.m39928ac());
        contentRecord.m41426V(content.m39932ag());
        contentRecord.m41443a(content.m39933ah());
        contentRecord.m41428W(content.m39934ai());
        contentRecord.m41430X(content.m39935aj());
        contentRecord.m41481ac(content.m39937al());
        C7590ps.m46940a(contentRecord);
        return contentRecord;
    }

    /* renamed from: a */
    public static ContentRecord m46746a(String str, Precontent precontent, int i10) {
        ContentRecord contentRecordM46745a = m46745a(str, new Content(precontent), i10, null, true);
        if (contentRecordM46745a != null) {
            contentRecordM46745a.m41533c(0);
            contentRecordM46745a.m41557f(true);
        }
        return contentRecordM46745a;
    }

    /* renamed from: a */
    public static PlacementRecord m46747a(String str, Content content, int i10) {
        if (AbstractC7806cz.m48165b(str) || content == null) {
            return null;
        }
        PlacementRecord placementRecord = new PlacementRecord();
        placementRecord.m41795a(str);
        placementRecord.m41809f(i10);
        String strM39981m = content.m39981m();
        if (strM39981m != null) {
            placementRecord.m41803c(strM39981m);
        }
        placementRecord.m41801b(content.m39997u());
        placementRecord.m41800b(content.m39962g());
        placementRecord.m41798b(content.m39958f());
        placementRecord.m41812h(content.m40001w());
        placementRecord.m41799b(content.m39974j());
        placementRecord.m41792a(content.m39979l());
        placementRecord.m41802c(content.m39991r());
        placementRecord.m41796a(content.m39987p());
        placementRecord.m41807e(1);
        placementRecord.m41805d(content.m40003x());
        placementRecord.m41793a(content.m39977k());
        placementRecord.m41810f(content.m39966h());
        placementRecord.m41811g(content.m39999v());
        MetaData metaDataM39944c = content.m39944c();
        if (metaDataM39944c != null) {
            placementRecord.m41808e(AbstractC7758be.m47742b(metaDataM39944c));
            placementRecord.m41806d(metaDataM39944c.m40332o());
            placementRecord.m41813i(metaDataM39944c.m40318h());
            placementRecord.m41794a(metaDataM39944c.m40342v());
            if (metaDataM39944c.m40344x() != null) {
                placementRecord.m41804c(metaDataM39944c.m40344x());
            }
            placementRecord.m41814j(metaDataM39944c.m40265B());
        }
        placementRecord.m41815k(content.m39894I() != null ? String.valueOf(content.m39894I()) : null);
        return placementRecord;
    }

    /* renamed from: a */
    public static TemplateRecord m46748a(Template template) {
        if (!template.m40456a()) {
            return null;
        }
        TemplateRecord templateRecord = new TemplateRecord();
        templateRecord.m41821a(template.m40457b());
        templateRecord.m41822b(template.m40458c());
        return templateRecord;
    }

    /* renamed from: a */
    public static Collection<AppDataCollectionRecord> m46749a(List<AppCollection> list, String str) {
        if (AbstractC7760bg.m47767a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AppCollection appCollection : list) {
            AppDataCollectionRecord appDataCollectionRecord = new AppDataCollectionRecord();
            appDataCollectionRecord.m41303a(appCollection.m39804c());
            appDataCollectionRecord.m41332b(appCollection.m39799b().longValue());
            appDataCollectionRecord.m41357m(appCollection.m39809d());
            appDataCollectionRecord.m41359n(appCollection.m39812e());
            appDataCollectionRecord.m41361o(appCollection.m39814f());
            appDataCollectionRecord.m41363p(appCollection.m39816g());
            if (appCollection.m39818h() != null) {
                appDataCollectionRecord.m41333b(String.valueOf(appCollection.m39818h()));
            }
            if (appCollection.m39820i() != null) {
                appDataCollectionRecord.m41336c(String.valueOf(appCollection.m39820i()));
            }
            appDataCollectionRecord.m41339d(appCollection.m39822j());
            appDataCollectionRecord.m41341e(appCollection.m39824k());
            appDataCollectionRecord.m41301a(appCollection.m39826l().intValue());
            appDataCollectionRecord.m41343f(appCollection.m39828m());
            appDataCollectionRecord.m41345g(appCollection.m39830n());
            appDataCollectionRecord.m41347h(appCollection.m39832o());
            appDataCollectionRecord.m41349i(appCollection.m39834p());
            appDataCollectionRecord.m41351j(appCollection.m39836q());
            appDataCollectionRecord.m41353k(appCollection.m39838r());
            appDataCollectionRecord.m41355l(str);
            appDataCollectionRecord.m41365q(appCollection.m39842t());
            appDataCollectionRecord.m41367r(appCollection.m39844u());
            appDataCollectionRecord.m41369s(appCollection.m39846v());
            appDataCollectionRecord.m41371t(appCollection.m39848w());
            appDataCollectionRecord.m41373u(appCollection.m39850x());
            appDataCollectionRecord.m41375v(appCollection.m39852y());
            appDataCollectionRecord.m41377w(appCollection.m39854z());
            appDataCollectionRecord.m41379x(appCollection.m39720A());
            appDataCollectionRecord.m41381y(appCollection.m39722B());
            appDataCollectionRecord.m41383z(appCollection.m39724C());
            appDataCollectionRecord.m41249A(appCollection.m39726D());
            appDataCollectionRecord.m41251B(appCollection.m39728E());
            appDataCollectionRecord.m41253C(appCollection.m39730F());
            appDataCollectionRecord.m41255D(appCollection.m39732G());
            appDataCollectionRecord.m41257E(appCollection.m39734H());
            appDataCollectionRecord.m41259F(appCollection.m39736I());
            appDataCollectionRecord.m41261G(appCollection.m39738J());
            appDataCollectionRecord.m41263H(appCollection.m39740K());
            appDataCollectionRecord.m41265I(appCollection.m39742L());
            appDataCollectionRecord.m41267J(appCollection.m39744M());
            appDataCollectionRecord.m41269K(appCollection.m39746N());
            appDataCollectionRecord.m41271L(appCollection.m39748O());
            appDataCollectionRecord.m41273M(appCollection.m39750P());
            appDataCollectionRecord.m41275N(appCollection.m39752Q());
            if (appCollection.m39754R() != null) {
                appDataCollectionRecord.m41277O(String.valueOf(appCollection.m39754R()));
            }
            if (appCollection.m39756S() != null) {
                appDataCollectionRecord.m41279P(String.valueOf(appCollection.m39756S()));
            }
            appDataCollectionRecord.m41281Q(appCollection.m39760U());
            appDataCollectionRecord.m41283R(appCollection.m39762V());
            appDataCollectionRecord.m41302a(appCollection.m39772a());
            appDataCollectionRecord.m41337c(appCollection.m39840s());
            appDataCollectionRecord.m41304a(appCollection.m39758T());
            appDataCollectionRecord.m41334b(appCollection.m39764W());
            appDataCollectionRecord.m41285S(appCollection.m39766X());
            appDataCollectionRecord.m41287T(appCollection.m39768Y());
            appDataCollectionRecord.m41291V(appCollection.m39778aa());
            appDataCollectionRecord.m41289U(appCollection.m39770Z());
            appDataCollectionRecord.m41293W(appCollection.m39780ab());
            appDataCollectionRecord.m41295X(appCollection.m39782ac());
            appDataCollectionRecord.m41297Y(appCollection.m39784ad());
            appDataCollectionRecord.m41299Z(appCollection.m39786ae());
            appDataCollectionRecord.m41306aa(appCollection.m39788af());
            appDataCollectionRecord.m41308ab(appCollection.m39790ag());
            appDataCollectionRecord.m41310ac(appCollection.m39792ah());
            appDataCollectionRecord.m41312ad(appCollection.m39793ai());
            appDataCollectionRecord.m41314ae(appCollection.m39794aj());
            appDataCollectionRecord.m41316af(appCollection.m39795ak());
            appDataCollectionRecord.m41318ag(appCollection.m39796al());
            appDataCollectionRecord.m41320ah(appCollection.m39797am());
            appDataCollectionRecord.m41322ai(appCollection.m39798an());
            arrayList.add(appDataCollectionRecord);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<AdEvent> m46750a(Collection<EventRecord> collection, Context context) {
        ArrayList arrayList = new ArrayList();
        if (AbstractC7760bg.m47767a(collection)) {
            return arrayList;
        }
        byte[] bArrM48089b = AbstractC7796cp.m48089b(context);
        for (EventRecord eventRecord : collection) {
            eventRecord.m41857a(bArrM48089b);
            AdEvent adEventM46742a = m46742a(eventRecord, context);
            if (adEventM46742a != null) {
                arrayList.add(adEventM46742a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m46751a(Content content, ContentRecord contentRecord) {
        contentRecord.m41445a(content.m39938b());
        contentRecord.m41590n(content.m39993s());
        Skip skipM39892G = content.m39892G();
        if (skipM39892G != null) {
            if (!TextUtils.isEmpty(skipM39892G.m40450a())) {
                contentRecord.m41590n(skipM39892G.m40450a());
            }
            if (skipM39892G.m40453b() > 0) {
                contentRecord.m41589n(skipM39892G.m40453b());
            }
            if (skipM39892G.m40455c() > 0) {
                contentRecord.m41586m(skipM39892G.m40455c());
            }
        }
    }

    /* renamed from: a */
    private static void m46752a(EventRecord eventRecord, Context context, AdEvent adEvent) {
        EncryptionField<String> encryptionFieldM41764n = eventRecord.m41764n();
        if (encryptionFieldM41764n != null) {
            byte[] bArrM41859br = eventRecord.m41859br();
            String strM41653a = bArrM41859br != null ? encryptionFieldM41764n.m41653a(bArrM41859br) : encryptionFieldM41764n.m41652a(context);
            if (!AbstractC7806cz.m48165b(strM41653a)) {
                adEvent.m39440a((ParamFromServer) AbstractC7758be.m47739b(strM41653a, ParamFromServer.class, new Class[0]));
            }
        }
        EncryptionField<String> encryptionFieldM41773r = eventRecord.m41773r();
        if (encryptionFieldM41773r != null) {
            byte[] bArrM41859br2 = eventRecord.m41859br();
            String strM41653a2 = bArrM41859br2 != null ? encryptionFieldM41773r.m41653a(bArrM41859br2) : encryptionFieldM41773r.m41652a(context);
            if (AbstractC7806cz.m48165b(strM41653a2)) {
                return;
            }
            adEvent.m39461e(strM41653a2);
        }
    }
}
