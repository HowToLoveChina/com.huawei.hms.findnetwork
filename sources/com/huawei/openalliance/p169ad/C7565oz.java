package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.LinkedSplashAd;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EncryptionField;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.oz */
/* loaded from: classes8.dex */
public class C7565oz {
    /* renamed from: a */
    public static ContentRecord m46667a(LinkedSplashAd linkedSplashAd) {
        if (linkedSplashAd == null) {
            return null;
        }
        ContentRecord contentRecord = new ContentRecord();
        contentRecord.m41536c(linkedSplashAd.getShowId());
        contentRecord.m41444a(linkedSplashAd.m44601a());
        contentRecord.m41543d(linkedSplashAd.getSlotId());
        contentRecord.m41549e(linkedSplashAd.getContentId());
        contentRecord.m41548e(linkedSplashAd.getStartTime());
        contentRecord.m41541d(linkedSplashAd.getEndTime());
        contentRecord.m41562g(linkedSplashAd.m44787X());
        contentRecord.m41555f(linkedSplashAd.getTaskId());
        contentRecord.m41608t(linkedSplashAd.m44810af());
        contentRecord.m41610u(linkedSplashAd.getWhyThisAd());
        contentRecord.m41578k(linkedSplashAd.getCreativeType());
        String strM44765M = linkedSplashAd.m44765M();
        if (!AbstractC7806cz.m48165b(strM44765M)) {
            EncryptionField<String> encryptionField = new EncryptionField<>(String.class);
            encryptionField.m41656a(strM44765M);
            contentRecord.m41441a(encryptionField);
        }
        contentRecord.m41507b(1);
        contentRecord.m41579k(linkedSplashAd.getLandWebUrl());
        contentRecord.m41569i(linkedSplashAd.getInterActionType());
        contentRecord.m41587m(linkedSplashAd.getIntent());
        contentRecord.m41511b(linkedSplashAd.m44775R());
        String strM44777S = linkedSplashAd.m44777S();
        if (!AbstractC7806cz.m48165b(strM44777S)) {
            EncryptionField<List<Monitor>> encryptionField2 = new EncryptionField<>(List.class, Monitor.class);
            encryptionField2.m41656a(strM44777S);
            contentRecord.m41509b(encryptionField2);
        }
        contentRecord.m41582l(linkedSplashAd.m44779T());
        contentRecord.m41550e(linkedSplashAd.m44781U());
        contentRecord.m41602r(linkedSplashAd.m44785W());
        contentRecord.m41605s(linkedSplashAd.getCtrlSwitchs());
        contentRecord.m41612v(linkedSplashAd.getUniqueId());
        String strM44811ag = linkedSplashAd.m44811ag();
        if (!TextUtils.isEmpty(strM44811ag)) {
            EncryptionField<String> encryptionField3 = new EncryptionField<>(String.class);
            encryptionField3.m41656a(strM44811ag);
            contentRecord.m41535c(encryptionField3);
        }
        contentRecord.m41447a(linkedSplashAd.isAutoDownloadApp());
        contentRecord.m41616x(linkedSplashAd.m44813ai());
        contentRecord.m41618y(linkedSplashAd.m44636f());
        contentRecord.m41446a(linkedSplashAd.getAdCloseKeyWords());
        contentRecord.m41512b(linkedSplashAd.m44773Q());
        contentRecord.m41596p(linkedSplashAd.m44484E());
        contentRecord.m41593o(linkedSplashAd.m44667u());
        contentRecord.m41547e(linkedSplashAd.m44483D());
        contentRecord.m41445a(linkedSplashAd.m44486G());
        contentRecord.m41590n(linkedSplashAd.m44487H());
        contentRecord.m41586m(linkedSplashAd.m44488I());
        contentRecord.m41589n(linkedSplashAd.m44489J());
        contentRecord.m41571i(linkedSplashAd.mo44485F());
        contentRecord.m41544d(linkedSplashAd.m44651m());
        contentRecord.m41402J(linkedSplashAd.m44653n());
        contentRecord.m41545d(linkedSplashAd.m44664s());
        contentRecord.m41416Q(linkedSplashAd.m44620c());
        contentRecord.m41422T(linkedSplashAd.m44598A());
        contentRecord.m41607t(linkedSplashAd.m44673x());
        return contentRecord;
    }

    /* renamed from: a */
    public static LinkedSplashAd m46668a(Context context, ContentRecord contentRecord) {
        LinkedSplashAd linkedSplashAd = new LinkedSplashAd();
        linkedSplashAd.m44492a(contentRecord);
        linkedSplashAd.m44644i(contentRecord.m41486ah());
        linkedSplashAd.m44609a(Integer.valueOf(contentRecord.m41505b()));
        linkedSplashAd.m44613b(1);
        linkedSplashAd.m44796a(contentRecord.m41484af());
        linkedSplashAd.m44841h(contentRecord.m41409N());
        linkedSplashAd.m44837f(contentRecord.m41401J());
        linkedSplashAd.m44602a(contentRecord.m41392E());
        linkedSplashAd.m44624c(contentRecord.m41588n());
        linkedSplashAd.m44839g(contentRecord.m41403K());
        linkedSplashAd.m44757E(contentRecord.m41386B());
        linkedSplashAd.m44776R(contentRecord.m41483ae());
        linkedSplashAd.m44764L(contentRecord.m41585m());
        linkedSplashAd.m44642h(contentRecord.m41577k());
        linkedSplashAd.m44614b(contentRecord.m41600r());
        linkedSplashAd.m44603a(contentRecord.m41603s());
        linkedSplashAd.m44843i(contentRecord.m41431Y());
        linkedSplashAd.m44635e(contentRecord.m41591o());
        linkedSplashAd.m44770O(contentRecord.m41433Z());
        linkedSplashAd.m44646j(contentRecord.m41476aa());
        if (contentRecord.m41395G() != null) {
            linkedSplashAd.m44754B(contentRecord.m41395G().m41654a());
        }
        linkedSplashAd.m44845j(contentRecord.m41388C());
        linkedSplashAd.m44640g(contentRecord.m41397H());
        linkedSplashAd.m44760H(contentRecord.m41563h());
        if (contentRecord.m41405L() != null) {
            linkedSplashAd.m44761I(contentRecord.m41405L().m41654a());
        }
        linkedSplashAd.m44851l(contentRecord.m41413P());
        linkedSplashAd.m44762J(contentRecord.m41425V());
        linkedSplashAd.m44763K(contentRecord.m41427W());
        if (contentRecord.m41480ac() != null) {
            linkedSplashAd.m44771P(contentRecord.m41480ac().m41654a());
        }
        linkedSplashAd.m44799a(new VideoInfo(contentRecord.m41419S()));
        MetaData metaDataM41568i = contentRecord.m41568i();
        if (metaDataM41568i != null) {
            linkedSplashAd.m44755C(AbstractC7806cz.m48168c(metaDataM41568i.m40309e()));
            linkedSplashAd.m44756D(AbstractC7806cz.m48168c(metaDataM41568i.m40312f()));
            linkedSplashAd.m44757E(metaDataM41568i.m40318h());
            linkedSplashAd.m44628d(metaDataM41568i.m40271H());
            linkedSplashAd.m44831d(metaDataM41568i.m40320i());
            linkedSplashAd.m44848k(metaDataM41568i.m40324k());
            linkedSplashAd.m44638f(AbstractC7806cz.m48168c(contentRecord.m41568i().m40326l()));
            linkedSplashAd.m44758F(metaDataM41568i.m40328m());
            linkedSplashAd.m44759G(metaDataM41568i.m40330n());
            linkedSplashAd.m44640g(metaDataM41568i.m40332o());
            linkedSplashAd.m44616b(AbstractC7806cz.m48168c(metaDataM41568i.m40280a()));
            linkedSplashAd.m44776R(metaDataM41568i.m40265B());
            ApkInfo apkInfoM40339s = metaDataM41568i.m40339s();
            if (apkInfoM40339s != null) {
                AppInfo appInfo = new AppInfo(apkInfoM40339s);
                appInfo.m44415m(linkedSplashAd.getIntent());
                appInfo.m44433v(linkedSplashAd.getUniqueId());
                appInfo.m44402h(metaDataM41568i.m40266C());
                linkedSplashAd.m44796a(appInfo);
            }
            linkedSplashAd.m44630d(metaDataM41568i.m40341u());
        }
        linkedSplashAd.m44495g(contentRecord.m41594p());
        linkedSplashAd.m44498x(contentRecord.m41415Q());
        linkedSplashAd.m44660q(contentRecord.m41411O());
        linkedSplashAd.m44500z(contentRecord.m41558g());
        linkedSplashAd.m44482A(contentRecord.m41407M());
        linkedSplashAd.m44496h(contentRecord.m41488aj());
        linkedSplashAd.m44497i(contentRecord.m41489ak());
        linkedSplashAd.mo44499y(contentRecord.m41619z());
        linkedSplashAd.m44611a(contentRecord.m41506b(context));
        linkedSplashAd.m44658p(contentRecord.m41456aH());
        linkedSplashAd.m44626c(contentRecord.m41462aN());
        linkedSplashAd.m44610a(contentRecord.m41474aZ());
        linkedSplashAd.m44631d(contentRecord.m41517bd());
        linkedSplashAd.m44666t(contentRecord.m41516bc());
        linkedSplashAd.m44668u(contentRecord.m41520bg());
        linkedSplashAd.m44637f(contentRecord.m41472aX());
        return linkedSplashAd;
    }
}
