package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import android.util.Xml;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MediaFile;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.beans.vast.ClickThrough;
import com.huawei.openalliance.p169ad.beans.vast.Creative;
import com.huawei.openalliance.p169ad.beans.vast.Impression;
import com.huawei.openalliance.p169ad.beans.vast.LinearCreative;
import com.huawei.openalliance.p169ad.beans.vast.NonLinear;
import com.huawei.openalliance.p169ad.beans.vast.NonLinearAds;
import com.huawei.openalliance.p169ad.beans.vast.StaticResource;
import com.huawei.openalliance.p169ad.beans.vast.Tracking;
import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import com.huawei.openalliance.p169ad.beans.vast.VastIcon;
import com.huawei.openalliance.p169ad.beans.vast.VastMediaFile;
import com.huawei.openalliance.p169ad.beans.vast.VideoClicks;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.constant.MetaCreativeType;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.constant.VastTag;
import com.huawei.openalliance.p169ad.constant.VastVersion;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EncryptionField;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.C7756bc;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.huawei.openalliance.ad.ps */
/* loaded from: classes8.dex */
public class C7590ps {

    /* renamed from: a */
    private static Map<String, EventType> f35443a;

    static {
        HashMap map = new HashMap();
        f35443a = map;
        map.put("mute", EventType.SOUNDCLICKOFF);
        f35443a.put("complete", EventType.VASTPLAYCOMPLETE);
        f35443a.put("start", EventType.VASTPLAYSTART);
        f35443a.put("unmute", EventType.SOUNDCLICKON);
        f35443a.put("skip", EventType.CLOSE);
        f35443a.put("firstQuartile", EventType.VASTFIRSTQURAT);
        f35443a.put("midpoint", EventType.VASTMIDPOINT);
        f35443a.put("thirdQuartile", EventType.VASTTHIRDQUART);
    }

    /* renamed from: a */
    private static ImageInfo m46926a(StaticResource staticResource) {
        if (staticResource == null || TextUtils.isEmpty(staticResource.m41004b())) {
            return null;
        }
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.m40182c(staticResource.m41004b());
        imageInfo.m40179b(MimeType.GIF.equalsIgnoreCase(staticResource.m41002a()) ? MetaCreativeType.GIF : MetaCreativeType.IMG);
        imageInfo.m40184d(1);
        return imageInfo;
    }

    /* renamed from: b */
    private static MediaFile m46947b(VastMediaFile vastMediaFile, MetaData metaData) {
        if (vastMediaFile == null) {
            return null;
        }
        MediaFile mediaFile = metaData.m40342v() == null ? new MediaFile() : metaData.m40342v();
        mediaFile.m40249b(vastMediaFile.m41042d());
        mediaFile.m40248b(vastMediaFile.m41040c());
        mediaFile.m40244a(vastMediaFile.m41037b());
        mediaFile.m40256e(2);
        return mediaFile;
    }

    /* renamed from: c */
    private static String m46951c(LinearCreative linearCreative) {
        VideoClicks videoClicksM40987e;
        ClickThrough clickThroughM41044a;
        if (linearCreative == null || (videoClicksM40987e = linearCreative.m40987e()) == null || (clickThroughM41044a = videoClicksM40987e.m41044a()) == null) {
            return null;
        }
        return clickThroughM41044a.m40970a();
    }

    /* renamed from: a */
    private static Monitor m46927a(List<Tracking> list, EventType eventType) {
        if (AbstractC7760bg.m47767a(list) || eventType == null) {
            return null;
        }
        Monitor monitor = new Monitor();
        monitor.m40349a(eventType.value());
        ArrayList arrayList = new ArrayList();
        Iterator<Tracking> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m41006a());
        }
        monitor.m40350a(arrayList);
        return monitor;
    }

    /* renamed from: b */
    private static String m46948b(NonLinearAds nonLinearAds) {
        NonLinear nonLinear;
        if (nonLinearAds == null) {
            return null;
        }
        List<NonLinear> listM41001b = nonLinearAds.m41001b();
        if (AbstractC7760bg.m47767a(listM41001b) || (nonLinear = listM41001b.get(0)) == null) {
            return null;
        }
        return nonLinear.m40993b();
    }

    /* renamed from: c */
    private static List<ImageInfo> m46952c(NonLinearAds nonLinearAds) {
        List<NonLinear> listM41001b;
        ImageInfo imageInfoM46926a;
        if (nonLinearAds == null || (listM41001b = nonLinearAds.m41001b()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NonLinear nonLinear : listM41001b) {
            if (nonLinear != null && (imageInfoM46926a = m46926a(nonLinear.m40988a())) != null) {
                arrayList.add(imageInfoM46926a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static VideoInfo m46928a(VastMediaFile vastMediaFile, MetaData metaData) {
        if (vastMediaFile == null) {
            return null;
        }
        VideoInfo videoInfo = metaData.m40305d() == null ? new VideoInfo() : metaData.m40305d();
        videoInfo.m40476a(vastMediaFile.m41042d());
        if (vastMediaFile.m41040c() != 0) {
            videoInfo.m40474a(Float.valueOf(vastMediaFile.m41037b() / vastMediaFile.m41040c()));
        }
        videoInfo.m40488e(1);
        videoInfo.m40478b(0);
        return videoInfo;
    }

    /* renamed from: b */
    private static List<ImageInfo> m46949b(LinearCreative linearCreative) {
        if (linearCreative == null) {
            return null;
        }
        List<VastIcon> listM40986d = linearCreative.m40986d();
        if (AbstractC7760bg.m47767a(listM40986d)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (VastIcon vastIcon : listM40986d) {
            ImageInfo imageInfoM46926a = m46926a(vastIcon.m41030c());
            if (imageInfoM46926a != null) {
                imageInfoM46926a.m40178b(vastIcon.m41023a());
                imageInfoM46926a.m40175a(vastIcon.m41027b());
                arrayList.add(imageInfoM46926a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static VastContent m46929a(MetaData metaData, int i10, int i11) {
        ByteArrayInputStream byteArrayInputStream;
        if (metaData == null) {
            return null;
        }
        String strM40274K = metaData.m40274K();
        if (TextUtils.isEmpty(strM40274K)) {
            return null;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("VastAdapter", "parse vastInfo.");
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(strM40274K.getBytes(Constants.UTF_8));
            try {
                XmlPullParser xmlPullParserM46934a = m46934a(byteArrayInputStream);
                C7633ri.m47099a(m46931a(xmlPullParserM46934a));
                List<VastContent> listMo47082a = C7633ri.m47098a().mo47082a(xmlPullParserM46934a);
                if (AbstractC7760bg.m47767a(listMo47082a)) {
                    AbstractC7185ho.m43820b("VastAdapter", "parse vast info but vast content is empty");
                    return null;
                }
                if (listMo47082a.size() > 1) {
                    AbstractC7185ho.m43820b("VastAdapter", "multi vast content, skip parse vastInfo.");
                    return null;
                }
                VastContent vastContent = listMo47082a.get(0);
                List<Creative> listM41018e = vastContent.m41018e();
                if (AbstractC7760bg.m47767a(listM41018e)) {
                    AbstractC7185ho.m43820b("VastAdapter", "vast creatives empty, skip parse vastInfo.");
                    return null;
                }
                if (listM41018e.size() > 1) {
                    AbstractC7185ho.m43820b("VastAdapter", "multi vast creative, skip parse vastInfo.");
                    return null;
                }
                Creative creative = listM41018e.get(0);
                if (creative == null) {
                    AbstractC7185ho.m43820b("VastAdapter", "creative null, skip parse vastInfo.");
                    return null;
                }
                LinearCreative linearCreativeM40973a = creative.m40973a();
                NonLinearAds nonLinearAdsM40976b = creative.m40976b();
                if (m46943a(i10, i11, linearCreativeM40973a)) {
                    if (linearCreativeM40973a != null && nonLinearAdsM40976b != null) {
                        if (!m46945a(linearCreativeM40973a, nonLinearAdsM40976b)) {
                            AbstractC7185ho.m43820b("VastAdapter", "check ads with linear and nonlinear failed, skip parse vastInfo.");
                            return null;
                        }
                    }
                    AbstractC7185ho.m43820b("VastAdapter", "need both linear and nonlinear ad, skip parse vastInfo.");
                    return null;
                }
                if (!m46944a(linearCreativeM40973a)) {
                    AbstractC7185ho.m43820b("VastAdapter", "not valid linear creative, skip parse vastInfo.");
                    return null;
                }
                return vastContent;
            } catch (Throwable th2) {
                th = th2;
                try {
                    AbstractC7185ho.m43824c("VastAdapter", "parseVastInfo error: %s", th.getClass().getSimpleName());
                    return null;
                } finally {
                    AbstractC7805cy.m48142a((Closeable) byteArrayInputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
        }
    }

    /* renamed from: b */
    private static List<Monitor> m46950b(ContentRecord contentRecord) {
        EncryptionField<List<Monitor>> encryptionFieldM41405L;
        if (contentRecord == null || (encryptionFieldM41405L = contentRecord.m41405L()) == null) {
            return null;
        }
        return encryptionFieldM41405L.m41652a(HiAd.m44013a().mo44051d());
    }

    /* renamed from: a */
    private static VastMediaFile m46930a(List<VastMediaFile> list) {
        VastMediaFile next;
        if (AbstractC7760bg.m47767a(list)) {
            return null;
        }
        Iterator<VastMediaFile> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && MimeType.MP4.equalsIgnoreCase(next.m41034a())) {
                break;
            }
        }
        if (next != null && !TextUtils.isEmpty(next.m41042d()) && next.m41040c() != 0 && next.m41037b() != 0) {
            return next;
        }
        AbstractC7185ho.m43820b("VastAdapter", "vast mediaFile missing required attribute.");
        return null;
    }

    /* renamed from: a */
    private static VastVersion m46931a(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(VastTag.NAMESPACE, "version");
        if (AbstractC7806cz.m48165b(attributeValue)) {
            AbstractC7185ho.m43826d("VastAdapter", "Required version attribute in VAST tag");
        }
        return VastVersion.getVerFromStr(attributeValue);
    }

    /* renamed from: a */
    public static List<Monitor> m46932a(VastContent vastContent) {
        ArrayList arrayList = null;
        if (vastContent == null) {
            return null;
        }
        List<Creative> listM41018e = vastContent.m41018e();
        if (!AbstractC7760bg.m47767a(listM41018e) && listM41018e.size() <= 1) {
            Creative creative = listM41018e.get(0);
            if (creative == null) {
                return null;
            }
            arrayList = new ArrayList();
            List<Impression> listM41016d = vastContent.m41016d();
            if (!AbstractC7760bg.m47767a(listM41016d)) {
                Monitor monitor = new Monitor();
                monitor.m40349a(EventType.SHOW.value());
                ArrayList arrayList2 = new ArrayList();
                Iterator<Impression> it = listM41016d.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().m40977a());
                }
                monitor.m40350a(arrayList2);
                arrayList.add(monitor);
            }
            if (creative.m40973a() != null && creative.m40973a().m40987e() != null) {
                List<Tracking> listM41047b = creative.m40973a().m40987e().m41047b();
                if (!AbstractC7760bg.m47767a(listM41047b)) {
                    arrayList.add(m46927a(listM41047b, EventType.CLICK));
                }
            }
            HashMap map = new HashMap();
            if (creative.m40973a() != null && !C7765bl.m47802a(creative.m40973a().m40985c())) {
                map.putAll(creative.m40973a().m40985c());
            }
            if (creative.m40976b() != null && !C7765bl.m47802a(creative.m40976b().m40998a())) {
                map.putAll(creative.m40976b().m40998a());
            }
            if (C7765bl.m47802a(map)) {
                return arrayList;
            }
            for (Map.Entry<String, EventType> entry : f35443a.entrySet()) {
                m46941a(arrayList, map, entry.getKey(), entry.getValue());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Monitor> m46933a(List<Monitor> list, List<Monitor> list2) {
        HashMap map = new HashMap();
        m46942a(map, list);
        m46942a(map, list2);
        return C7765bl.m47802a(map) ? Collections.EMPTY_LIST : new ArrayList(map.values());
    }

    /* renamed from: a */
    private static XmlPullParser m46934a(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        xmlPullParserNewPullParser.setInput(inputStream, "utf-8");
        xmlPullParserNewPullParser.nextTag();
        xmlPullParserNewPullParser.require(2, VastTag.NAMESPACE, VastTag.VAST);
        return xmlPullParserNewPullParser;
    }

    /* renamed from: a */
    private static void m46935a(MetaData metaData, int i10, LinearCreative linearCreative) {
        VideoInfo videoInfoM46928a;
        MediaFile mediaFileM46947b;
        VastMediaFile vastMediaFileM46930a = m46930a(linearCreative.m40983b());
        if (vastMediaFileM46930a != null && 60 == i10 && (mediaFileM46947b = m46947b(vastMediaFileM46930a, metaData)) != null) {
            metaData.m40286a(mediaFileM46947b);
            if (linearCreative.m40978a() > 0) {
                metaData.m40301c(linearCreative.m40978a());
            }
        }
        if (vastMediaFileM46930a != null && 60 != i10 && (videoInfoM46928a = m46928a(vastMediaFileM46930a, metaData)) != null) {
            metaData.m40289a(videoInfoM46928a);
            if (linearCreative.m40978a() > 0) {
                videoInfoM46928a.m40473a(linearCreative.m40978a());
                metaData.m40301c(linearCreative.m40978a());
            }
        }
        String strM46951c = m46951c(linearCreative);
        if (!TextUtils.isEmpty(strM46951c)) {
            metaData.m40307d(strM46951c);
        }
        List<ImageInfo> listM46949b = m46949b(linearCreative);
        if (AbstractC7760bg.m47767a(listM46949b)) {
            return;
        }
        metaData.m40292a(listM46949b);
    }

    /* renamed from: a */
    private static void m46936a(MetaData metaData, NonLinearAds nonLinearAds) {
        List<ImageInfo> listM46952c = m46952c(nonLinearAds);
        if (!AbstractC7760bg.m47767a(listM46952c)) {
            Iterator<ImageInfo> it = listM46952c.iterator();
            while (it.hasNext()) {
                it.next().m40184d(1);
            }
            metaData.m40298b(listM46952c);
        }
        String strM46948b = m46948b(nonLinearAds);
        if (TextUtils.isEmpty(strM46948b)) {
            return;
        }
        metaData.m40307d(strM46948b);
    }

    /* renamed from: a */
    public static void m46937a(MetaData metaData, VastContent vastContent, int i10) {
        m46938a(metaData, vastContent, i10, true);
    }

    /* renamed from: a */
    public static void m46938a(MetaData metaData, VastContent vastContent, int i10, boolean z10) {
        if (metaData == null || vastContent == null) {
            return;
        }
        List<Creative> listM41018e = vastContent.m41018e();
        if (AbstractC7760bg.m47767a(listM41018e)) {
            return;
        }
        Creative creative = listM41018e.get(0);
        if (creative == null) {
            AbstractC7185ho.m43820b("VastAdapter", "vast creative empty, skip merge.");
            return;
        }
        AbstractC7185ho.m43817a("VastAdapter", "merge metadata.");
        m46936a(metaData, creative.m40976b());
        m46935a(metaData, i10, creative.m40973a());
        if (!TextUtils.isEmpty(vastContent.m41014c())) {
            metaData.m40303c(vastContent.m41014c());
        }
        if (!TextUtils.isEmpty(vastContent.m41020f())) {
            metaData.m40310e(vastContent.m41020f());
        }
        if (!TextUtils.isEmpty(vastContent.m41012b())) {
            metaData.m40297b(vastContent.m41012b());
        }
        if (z10) {
            metaData.m40337q(null);
        }
    }

    /* renamed from: a */
    private static void m46939a(VastContent vastContent, ContentRecord contentRecord) {
        List<ImageInfo> listM40334p;
        int iM40185e;
        if (vastContent == null || contentRecord == null) {
            return;
        }
        contentRecord.m41545d(true);
        MetaData metaDataM41568i = contentRecord.m41568i();
        if (metaDataM41568i != null) {
            contentRecord.m41579k(metaDataM41568i.m40318h());
        }
        List<Monitor> listM46932a = m46932a(vastContent);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("VastAdapter", "monitors from vast: %s", AbstractC7819dl.m48375a(AbstractC7758be.m47742b(listM46932a)));
        }
        if (!AbstractC7760bg.m47767a(listM46932a)) {
            List<Monitor> listM46950b = m46950b(contentRecord);
            if (!AbstractC7760bg.m47767a(listM46950b)) {
                listM46932a = m46933a(listM46950b, listM46932a);
            }
            contentRecord.m41537c(listM46932a);
        }
        VideoInfo videoInfoM41419S = contentRecord.m41419S();
        if (videoInfoM41419S != null) {
            Float fM40500m = videoInfoM41419S.m40500m();
            if (fM40500m == null) {
                return;
            }
            iM40185e = (int) ((720 * 1.0f) / fM40500m.floatValue());
            contentRecord.m41553f(720);
        } else {
            if (metaDataM41568i == null || (listM40334p = metaDataM41568i.m40334p()) == null || listM40334p.size() <= 0) {
                return;
            }
            ImageInfo imageInfo = listM40334p.get(0);
            contentRecord.m41571i(imageInfo.m40180c());
            contentRecord.m41553f(imageInfo.m40183d());
            iM40185e = imageInfo.m40185e();
        }
        contentRecord.m41559g(iM40185e);
    }

    /* renamed from: a */
    public static void m46940a(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        MetaData metaDataM41568i = contentRecord.m41568i();
        int iM41552f = contentRecord.m41552f();
        VastContent vastContentM46929a = m46929a(metaDataM41568i, iM41552f, contentRecord.m41392E());
        m46937a(metaDataM41568i, vastContentM46929a, iM41552f);
        contentRecord.m41511b(AbstractC7758be.m47742b(metaDataM41568i));
        m46939a(vastContentM46929a, contentRecord);
    }

    /* renamed from: a */
    private static void m46941a(List<Monitor> list, Map<String, List<Tracking>> map, String str, EventType eventType) {
        if (list == null || C7765bl.m47802a(map) || TextUtils.isEmpty(str) || eventType == null || !map.containsKey(str)) {
            return;
        }
        List<Tracking> list2 = map.get(str);
        if (AbstractC7760bg.m47767a(list2)) {
            return;
        }
        list.add(m46927a(list2, eventType));
    }

    /* renamed from: a */
    private static void m46942a(Map<String, Monitor> map, List<Monitor> list) {
        if (AbstractC7760bg.m47767a(list) || map == null) {
            return;
        }
        for (Monitor monitor : list) {
            if (monitor != null) {
                String strM40347a = monitor.m40347a();
                Monitor monitor2 = map.get(strM40347a);
                if (monitor2 != null) {
                    HashSet hashSet = new HashSet(monitor2.m40351b());
                    hashSet.addAll(monitor.m40351b());
                    monitor2.m40350a(new ArrayList(hashSet));
                    map.put(strM40347a, monitor2);
                } else {
                    map.put(monitor.m40347a(), monitor);
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m46943a(int i10, int i11, LinearCreative linearCreative) {
        if (i10 != 3) {
            return i10 == 7 && C7756bc.m47711f(i11);
        }
        if (9 == i11 || 12 == i11 || 106 == i11 || 6 == i11) {
            return true;
        }
        return linearCreative != null && m46944a(linearCreative);
    }

    /* renamed from: a */
    private static boolean m46944a(LinearCreative linearCreative) {
        if (!AbstractC7760bg.m47767a(linearCreative.m40983b())) {
            return true;
        }
        AbstractC7185ho.m43820b("VastAdapter", "no media file in linear creative, skip parse vastInfo.");
        return false;
    }

    /* renamed from: a */
    private static boolean m46945a(LinearCreative linearCreative, NonLinearAds nonLinearAds) {
        return m46944a(linearCreative) && m46946a(nonLinearAds);
    }

    /* renamed from: a */
    private static boolean m46946a(NonLinearAds nonLinearAds) {
        if (!AbstractC7760bg.m47767a(nonLinearAds.m41001b())) {
            return true;
        }
        AbstractC7185ho.m43820b("VastAdapter", "no nonlinear ads in nonlinear creative, skip parse vastInfo.");
        return false;
    }
}
