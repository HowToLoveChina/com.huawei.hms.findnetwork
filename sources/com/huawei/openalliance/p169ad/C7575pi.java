package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MediaFile;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.PlacementMediaFile;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EncryptionField;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7827f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.huawei.openalliance.ad.pi */
/* loaded from: classes8.dex */
public class C7575pi {
    /* renamed from: a */
    public static ContentRecord m46766a(C7304g c7304g) {
        if (c7304g == null) {
            return null;
        }
        ContentRecord contentRecord = new ContentRecord();
        contentRecord.m41444a(c7304g.m44601a());
        contentRecord.m41437a(c7304g.getMinEffectiveShowTime());
        contentRecord.m41436a(c7304g.getMinEffectiveShowRatio());
        contentRecord.m41510b(c7304g.m44661r());
        contentRecord.m41540d(c7304g.m44659q() == null ? 0 : c7304g.m44659q().intValue());
        contentRecord.m41536c(c7304g.getShowId());
        contentRecord.m41543d(c7304g.m44879H());
        contentRecord.m41549e(c7304g.getContentId());
        contentRecord.m41555f(c7304g.getTaskId());
        contentRecord.m41608t(c7304g.m44884K());
        contentRecord.m41548e(c7304g.getStartTime());
        contentRecord.m41541d(c7304g.getEndTime());
        String encodedParamFromServer = c7304g.getEncodedParamFromServer();
        if (!AbstractC7806cz.m48165b(encodedParamFromServer)) {
            EncryptionField<String> encryptionField = new EncryptionField<>(String.class);
            encryptionField.m41656a(encodedParamFromServer);
            contentRecord.m41441a(encryptionField);
        }
        contentRecord.m41507b(60);
        contentRecord.m41579k(c7304g.getLandWebUrl());
        contentRecord.m41569i(c7304g.getInterActionType());
        contentRecord.m41587m(c7304g.getIntent());
        contentRecord.m41511b(c7304g.m44873E());
        String encodedeMonitors = c7304g.getEncodedeMonitors();
        if (!AbstractC7806cz.m48165b(encodedeMonitors)) {
            EncryptionField<List<Monitor>> encryptionField2 = new EncryptionField<>(List.class, Monitor.class);
            encryptionField2.m41656a(encodedeMonitors);
            contentRecord.m41509b(encryptionField2);
        }
        contentRecord.m41582l(c7304g.getShowLandingPageTitleFlag());
        contentRecord.m41550e(c7304g.getClickActionList());
        contentRecord.m41602r(c7304g.getWebConfig());
        contentRecord.m41605s(c7304g.getCtrlSwitchs());
        contentRecord.m41562g(c7304g.m44877G());
        contentRecord.m41616x(c7304g.m44883J());
        String strM44881I = c7304g.m44881I();
        if (!TextUtils.isEmpty(strM44881I)) {
            EncryptionField<String> encryptionField3 = new EncryptionField<>(String.class);
            encryptionField3.m41656a(strM44881I);
            contentRecord.m41535c(encryptionField3);
        }
        contentRecord.m41447a(c7304g.isAutoDownloadApp());
        contentRecord.m41618y(c7304g.m44636f());
        contentRecord.m41479ab(c7304g.m44599B());
        contentRecord.m41592o(c7304g.m44639g());
        contentRecord.m41387B(c7304g.m44641h() != null ? String.valueOf(c7304g.m44641h()) : null);
        contentRecord.m41612v(c7304g.getUniqueId());
        contentRecord.m41610u(c7304g.getWhyThisAd());
        contentRecord.m41391D(c7304g.m44643i());
        contentRecord.m41393E(c7304g.m44645j());
        contentRecord.m41396G(c7304g.m44647k());
        contentRecord.m41398H(c7304g.m44649l());
        contentRecord.m41544d(c7304g.m44651m());
        contentRecord.m41402J(c7304g.m44653n());
        contentRecord.m41560g(c7304g.m44657p());
        contentRecord.m41545d(c7304g.m44664s());
        contentRecord.m41412O(c7304g.getHwChannelId());
        contentRecord.m41410N(c7304g.getAbilityDetailInfo());
        contentRecord.m41580k(c7304g.getCompliance());
        contentRecord.m41416Q(c7304g.m44620c());
        contentRecord.m41551e(c7304g.isTransparencyOpen());
        contentRecord.m41420S(c7304g.getTransparencyTplUrl());
        contentRecord.m41422T(c7304g.m44598A());
        return contentRecord;
    }

    /* renamed from: a */
    public static C7304g m46767a(String str, Content content, byte[] bArr) {
        C7304g c7304g = new C7304g();
        c7304g.m44609a(content.m39912a());
        c7304g.m44888d(content.m39997u());
        c7304g.m44875F(str);
        c7304g.m44624c(content.m39962g());
        c7304g.m44890e(false);
        c7304g.m44602a(content.m39958f());
        c7304g.m44872D(content.m40001w());
        c7304g.m44614b(content.m39974j());
        c7304g.m44893g(content.m39979l());
        c7304g.m44897j(content.m40003x());
        c7304g.m44896i(content.m39991r());
        c7304g.m44892f(false);
        c7304g.m44603a(content.m39977k());
        c7304g.m44870C(content.m39999v());
        c7304g.m44635e(content.m39966h());
        c7304g.m44882I(content.m39884A());
        c7304g.m44891f(content.m40007z());
        c7304g.m44613b(60);
        c7304g.m44646j(AbstractC7806cz.m48168c(content.m39889D()));
        String strM39886B = content.m39886B();
        if (!TextUtils.isEmpty(strM39886B)) {
            EncryptionField encryptionField = new EncryptionField(String.class);
            encryptionField.m41655a((EncryptionField) strM39886B);
            c7304g.m44878G(encryptionField.m41657b(bArr));
        }
        BiddingInfo.C7295a c7295aM44457b = new BiddingInfo.C7295a().m44455a(content.m39932ag()).m44454a(content.m39933ah()).setLurl(content.m39935aj()).m44457b(content.m39934ai());
        if (!c7295aM44457b.m44456a().m44449a()) {
            c7304g.m44608a(c7295aM44457b.m44456a());
        }
        String strM39981m = content.m39981m();
        if (strM39981m != null) {
            c7304g.m44898x(AbstractC7827f.m48394a(strM39981m, bArr));
        }
        List<Monitor> listM39987p = content.m39987p();
        if (listM39987p == null) {
            listM39987p = new ArrayList<>();
        }
        MetaData metaDataM39944c = content.m39944c();
        VastContent vastContentM46929a = C7590ps.m46929a(metaDataM39944c, 60, content.m39958f());
        if (vastContentM46929a != null) {
            AbstractC7185ho.m43821b("PlacementAdConverter", "content:%s is vast ad, merge monitors", content.m39962g());
            listM39987p = C7590ps.m46933a(listM39987p, C7590ps.m46932a(vastContentM46929a));
        }
        if (listM39987p.size() > 0) {
            EncryptionField encryptionField2 = new EncryptionField(List.class, Monitor.class);
            encryptionField2.m41655a((EncryptionField) listM39987p);
            c7304g.m44869B(encryptionField2.m41657b(bArr));
        }
        if (metaDataM39944c == null) {
            return c7304g;
        }
        if (vastContentM46929a != null) {
            AbstractC7185ho.m43821b("PlacementAdConverter", "content:%s is vast ad, merge meta data", content.m39962g());
            C7590ps.m46937a(metaDataM39944c, vastContentM46929a, 60);
            c7304g.m44626c(true);
        }
        c7304g.m44887d(metaDataM39944c.m40320i());
        c7304g.m44629d(metaDataM39944c.m40293b());
        c7304g.m44623c(metaDataM39944c.m40299c());
        c7304g.m44895h(metaDataM39944c.m40324k());
        c7304g.m44868A(metaDataM39944c.m40330n());
        c7304g.m44899y(metaDataM39944c.m40318h());
        c7304g.m44628d(metaDataM39944c.m40271H());
        c7304g.m44638f(AbstractC7806cz.m48168c(metaDataM39944c.m40326l()));
        c7304g.m44640g(metaDataM39944c.m40332o());
        c7304g.m44616b(AbstractC7806cz.m48168c(metaDataM39944c.m40280a()));
        c7304g.m44900z(metaDataM39944c.m40328m());
        c7304g.m44630d(metaDataM39944c.m40341u());
        c7304g.m44880H(metaDataM39944c.m40265B());
        c7304g.m44660q(AbstractC7806cz.m48168c(content.m39989q()));
        c7304g.m44617b(metaDataM39944c.m40275L());
        c7304g.m44634e(metaDataM39944c.m40278O());
        c7304g.m44607a(metaDataM39944c.m40340t());
        ApkInfo apkInfoM40339s = metaDataM39944c.m40339s();
        if (apkInfoM40339s != null) {
            AppInfo appInfo = new AppInfo(apkInfoM40339s);
            appInfo.m44415m(c7304g.getIntent());
            appInfo.m44433v(c7304g.getUniqueId());
            appInfo.m44402h(metaDataM39944c.m40266C());
            c7304g.m44885a(appInfo);
        }
        MediaFile mediaFileM40342v = metaDataM39944c.m40342v();
        if (mediaFileM40342v != null) {
            c7304g.m44886a(new PlacementMediaFile(mediaFileM40342v, metaDataM39944c.m40345y()));
        }
        List<MediaFile> listM40344x = metaDataM39944c.m40344x();
        if (!AbstractC7760bg.m47767a(listM40344x)) {
            int size = listM40344x.size();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(new PlacementMediaFile(listM40344x.get(i10), 0L));
            }
            c7304g.m44889e(arrayList);
        }
        try {
            c7304g.m44874E(AbstractC7758be.m47727a(metaDataM39944c));
        } catch (JSONException unused) {
            AbstractC7185ho.m43826d("PlacementAdConverter", "MetaData.toJson error");
        }
        c7304g.m44615b(content.m39894I());
        c7304g.m44611a(content.m39954e());
        c7304g.m44658p(content.m39903R());
        c7304g.m44663s(AbstractC7806cz.m48168c(content.m39910Y()));
        c7304g.m44662r(content.m39909X());
        c7304g.m44625c(content.m39911Z());
        c7304g.m44610a(content.m39928ac());
        c7304g.m44631d(content.m39930ae().booleanValue());
        c7304g.m44666t(content.m39929ad());
        return c7304g;
    }
}
