package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.magazine.inter.MagLockAd;
import com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.pb */
/* loaded from: classes8.dex */
public abstract class AbstractC7568pb {
    /* renamed from: a */
    private static C7202hw m46680a(Context context, ContentRecord contentRecord) {
        C7202hw c7202hw = new C7202hw();
        c7202hw.setContentId(contentRecord.m41588n());
        c7202hw.m43885b(contentRecord.m41388C());
        String strM41563h = contentRecord.m41563h();
        MetaData metaData = (MetaData) AbstractC7758be.m47739b(strM41563h, MetaData.class, new Class[0]);
        if (metaData != null) {
            List<ImageInfo> listM40334p = metaData.m40334p();
            if (listM40334p != null && !listM40334p.isEmpty()) {
                ImageInfo imageInfo = listM40334p.get(0);
                c7202hw.setUrl(imageInfo.m40180c());
                c7202hw.setSha256(imageInfo.m40174a());
                c7202hw.setFileSize(imageInfo.m40186f());
                c7202hw.m43884a(contentRecord.m41619z());
                c7202hw.setTitle(metaData.m40309e());
                c7202hw.setDescription(metaData.m40312f());
            }
            ImageInfo imageInfoM40336q = metaData.m40336q();
            if (imageInfoM40336q != null) {
                c7202hw.setPreviewUrl(imageInfoM40336q.m40180c());
                c7202hw.setPreviewSha256(imageInfoM40336q.m40174a());
            }
            c7202hw.m43888d(metaData.m40332o());
            c7202hw.m43887c(metaData.m40318h());
            c7202hw.m43886b(metaData.m40326l());
            c7202hw.m43891g(metaData.m40341u());
            if ("2".equals(metaData.m40341u())) {
                c7202hw.m43892h(context.getResources().getString(C6849R.string.hiad_ad_label_new));
            }
            if (metaData.m40339s() != null) {
                c7202hw.m43890f(metaData.m40339s().m39662j());
                c7202hw.m43889e(metaData.m40339s().m39626a());
            }
            if (metaData.m40340t() != null && metaData.m40340t().getName() != null) {
                c7202hw.m43890f(metaData.m40340t().getName());
                c7202hw.m43883a(metaData.m40340t().getType());
            }
            c7202hw.setMetaData(strM41563h);
        }
        c7202hw.setEndTime(contentRecord.m41600r());
        return c7202hw;
    }

    /* renamed from: a */
    public static C7204hy m46681a(AdContentRsp adContentRsp, Context context, boolean z10) {
        if (adContentRsp == null || AbstractC7760bg.m47767a(adContentRsp.m40830c())) {
            return null;
        }
        C7204hy c7204hy = new C7204hy();
        c7204hy.setRetCode(adContentRsp.m40819a());
        ArrayList arrayList = new ArrayList();
        Iterator<Ad30> it = adContentRsp.m40830c().iterator();
        while (it.hasNext()) {
            MagLockAd magLockAdM46682a = m46682a(it.next(), z10, context);
            if (magLockAdM46682a != null) {
                arrayList.add(magLockAdM46682a);
            }
        }
        c7204hy.setMultiAds(arrayList);
        return c7204hy;
    }

    /* renamed from: a */
    private static MagLockAd m46682a(Ad30 ad30, boolean z10, Context context) {
        if (ad30 == null) {
            return null;
        }
        C7203hx c7203hx = new C7203hx();
        c7203hx.setRetCode(ad30.m39424b());
        c7203hx.setSlotId(ad30.m39419a());
        List<Content> listM39428c = ad30.m39428c();
        if (200 == ad30.m39424b() && !AbstractC7760bg.m47767a(listM39428c)) {
            c7203hx.setAdList(m46684a(listM39428c, z10, context));
        }
        return c7203hx;
    }

    /* renamed from: a */
    private static MagLockAdContent m46683a(Content content, boolean z10, Context context) {
        if (content == null) {
            return null;
        }
        AbstractC7185ho.m43823c("MagLockConverter", "content in response :" + content.m39962g());
        ContentRecord contentRecordMo43098a = C7103es.m43094a(context).mo43098a(content.m39962g());
        if (contentRecordMo43098a != null && !TextUtils.isEmpty(contentRecordMo43098a.m41619z())) {
            AbstractC7185ho.m43818a("MagLockConverter", "content is in db: %s,and path: %s.", content.m39962g(), contentRecordMo43098a.m41619z());
            if (!z10) {
                m46685a(contentRecordMo43098a, content);
            }
            return m46680a(context, contentRecordMo43098a);
        }
        if (contentRecordMo43098a == null) {
            AbstractC7185ho.m43823c("MagLockConverter", "content is null!" + content.m39962g());
        }
        return null;
    }

    /* renamed from: a */
    private static List<MagLockAdContent> m46684a(List<Content> list, boolean z10, Context context) {
        ArrayList arrayList = new ArrayList();
        Iterator<Content> it = list.iterator();
        while (it.hasNext()) {
            MagLockAdContent magLockAdContentM46683a = m46683a(it.next(), z10, context);
            if (magLockAdContentM46683a != null) {
                arrayList.add(magLockAdContentM46683a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m46685a(ContentRecord contentRecord, Content content) {
        contentRecord.m41541d(content.m39974j());
        contentRecord.m41511b(content.m39949d());
        contentRecord.m41583l(content.m39981m());
        contentRecord.m41569i(content.m39979l());
    }
}
