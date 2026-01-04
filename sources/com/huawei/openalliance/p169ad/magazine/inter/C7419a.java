package com.huawei.openalliance.p169ad.magazine.inter;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7568pb;
import com.huawei.openalliance.p169ad.AbstractC7573pg;
import com.huawei.openalliance.p169ad.AbstractC7603qe;
import com.huawei.openalliance.p169ad.C7103es;
import com.huawei.openalliance.p169ad.C7107ew;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7204hy;
import com.huawei.openalliance.p169ad.C7544ol;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7567pa;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.magazine.inter.listener.MagLockListener;
import com.huawei.openalliance.p169ad.opendeviceidentifier.OAIDServiceManager;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.DeletedContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.processor.eventbeans.MagLockEventInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.openalliance.ad.magazine.inter.a */
/* loaded from: classes2.dex */
public class C7419a implements HiAdMagLock {

    /* renamed from: a */
    private static int[] f34454a = {200, 206};

    /* renamed from: b */
    private static int[] f34455b = {204, ErrorCode.ERROR_CODE_WRONG_ADID, ErrorCode.ERROR_CODE_NO_MATCH, ErrorCode.ERROR_CODE_ONLY_TEST, ErrorCode.ERROR_CODE_NO_PACKAGE, ErrorCode.ERROR_CODE_NO_USERINFO};

    /* renamed from: c */
    private static int[] f34456c = {200, ErrorCode.ERROR_CODE_NO_ADID, ErrorCode.ERROR_CODE_WRONG_ADID};

    /* renamed from: d */
    private Context f34457d;

    /* renamed from: e */
    private C7103es f34458e;

    /* renamed from: f */
    private C7107ew f34459f;

    /* renamed from: com.huawei.openalliance.ad.magazine.inter.a$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a */
        static final /* synthetic */ int[] f34476a;

        static {
            int[] iArr = new int[EventType.values().length];
            f34476a = iArr;
            try {
                iArr[EventType.SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34476a[EventType.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34476a[EventType.SWIPEUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34476a[EventType.REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34476a[EventType.SHARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34476a[EventType.FAVORITE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34476a[EventType.SHOWEND.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f34476a[EventType.INTENTSUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f34476a[EventType.INTENTFAIL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.magazine.inter.a$a */
    public static class a extends OAIDServiceManager.OaidResultCallback {

        /* renamed from: a */
        private Context f34477a;

        /* renamed from: b */
        private AdSlotParam f34478b;

        /* renamed from: c */
        private List<String> f34479c;

        /* renamed from: d */
        private List<String> f34480d;

        /* renamed from: e */
        private MagLockListener f34481e;

        public a(Context context, AdSlotParam adSlotParam, List<String> list, List<String> list2, MagLockListener magLockListener) {
            this.f34477a = context.getApplicationContext();
            this.f34478b = adSlotParam;
            this.f34479c = list;
            this.f34480d = list2;
            this.f34481e = magLockListener;
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44091a() {
            AbstractC7185ho.m43820b("HiAdMagLockImpl", "onOaidAcquireFailed");
            C7419a.m45671c(this.f34477a, this.f34478b, this.f34479c, this.f34480d, this.f34481e);
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44092a(String str, boolean z10) {
            AbstractC7185ho.m43820b("HiAdMagLockImpl", "onOaidAcquired");
            this.f34478b.m40635a(str);
            this.f34478b.m40633a(Boolean.valueOf(z10));
            C7419a.m45671c(this.f34477a, this.f34478b, this.f34479c, this.f34480d, this.f34481e);
        }
    }

    public C7419a() {
        Arrays.sort(f34454a);
        Arrays.sort(f34455b);
        Arrays.sort(f34456c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m45671c(final Context context, final AdSlotParam adSlotParam, final List<String> list, final List<String> list2, final MagLockListener magLockListener) {
        AbstractC7185ho.m43818a("HiAdMagLockImpl", "oaid has been done: %s", Long.valueOf(System.currentTimeMillis()));
        AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.magazine.inter.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("HiAdMagLockImpl", "thread switch: %s", Long.valueOf(System.currentTimeMillis()));
                }
                C7419a.m45669b(context, new C7544ol(context).mo46333a(adSlotParam, list, list2), magLockListener, adSlotParam.m40657j());
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.HiAdMagLock
    public void loadAds(String[] strArr, Set<String> set, boolean z10, MagLockListener magLockListener) {
        AbstractC7185ho.m43817a("HiAdMagLockImpl", "loadAds!");
        m45665a(strArr, m45657a(set), z10, magLockListener, 1);
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.HiAdMagLock
    public void onNetworkConnected(Context context) {
        m45658a(context);
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.HiAdMagLock
    public void preloadAds(String[] strArr, Set<String> set, boolean z10, MagLockListener magLockListener) {
        AbstractC7185ho.m43817a("HiAdMagLockImpl", "preloadAds!");
        m45665a(strArr, m45657a(set), z10, magLockListener, 2);
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.HiAdMagLock
    public void reportEvent(final Context context, final String str, final EventType eventType, final MagLockEventInfo magLockEventInfo) {
        if (AbstractC7806cz.m48165b(str) || eventType == null) {
            AbstractC7185ho.m43826d("HiAdMagLockImpl", "params is null");
        } else {
            AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.magazine.inter.a.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    EventType eventTypeValueOf = EventType.valueOf(eventType.name());
                    ContentRecord contentRecordMo43098a = C7103es.m43094a(context).mo43098a(str);
                    if (contentRecordMo43098a == null) {
                        str2 = "reportEvent,content is null";
                    } else {
                        if (2 == contentRecordMo43098a.m41552f()) {
                            if (EventType.SHOW == eventTypeValueOf) {
                                C7124fh.m43316b(context).mo43454f("" + AbstractC7741ao.m47566c());
                            }
                            if (EventType.REMOVE == eventTypeValueOf) {
                                C7107ew.m43149a(context).m43155b(new DeletedContentRecord(str, AbstractC7741ao.m47566c()));
                                C7107ew.m43149a(context).m43154b();
                                C7103es.m43094a(context).mo43122c(str);
                            }
                            contentRecordMo43098a.m41536c(C7124fh.m43316b(context).mo43347aN());
                            Context context2 = context;
                            C7560ou c7560ou = new C7560ou(context2, C7662sk.m47225a(context2, contentRecordMo43098a.m41552f()));
                            c7560ou.mo46590a(contentRecordMo43098a);
                            C7419a.this.m45664a(c7560ou, eventTypeValueOf, magLockEventInfo);
                            MagLockEventInfo magLockEventInfo2 = magLockEventInfo;
                            if (magLockEventInfo2 == null || magLockEventInfo2.m46846b() == null) {
                                return;
                            }
                            new C6922c(context).mo39115b(contentRecordMo43098a, eventType.value(), magLockEventInfo.m46846b());
                            return;
                        }
                        str2 = "invalid ad type";
                    }
                    AbstractC7185ho.m43826d("HiAdMagLockImpl", str2);
                }
            });
        }
    }

    public C7419a(Context context) {
        Arrays.sort(f34454a);
        Arrays.sort(f34455b);
        Arrays.sort(f34456c);
        Context applicationContext = context.getApplicationContext();
        this.f34457d = applicationContext;
        this.f34458e = C7103es.m43094a(applicationContext);
        this.f34459f = C7107ew.m43149a(this.f34457d);
    }

    /* renamed from: a */
    private List<String> m45657a(Set<String> set) {
        if (set == null) {
            AbstractC7185ho.m43817a("HiAdMagLockImpl", "contentIds is null");
            return new ArrayList();
        }
        AbstractC7185ho.m43818a("HiAdMagLockImpl", "contentIds is %s", set.toString());
        return new ArrayList(set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m45668b(Context context, AdSlotParam adSlotParam, List<String> list, List<String> list2, MagLockListener magLockListener) {
        OAIDServiceManager.getInstance(context).requireOaid(new a(context, adSlotParam, list, list2, magLockListener));
    }

    /* renamed from: a */
    private static void m45658a(Context context) {
        m45659a(context, 1);
        m45659a(context, 2);
        m45659a(context, 4);
        m45659a(context, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m45669b(Context context, AdContentRsp adContentRsp, MagLockListener magLockListener, boolean z10) {
        if (adContentRsp == null) {
            AbstractC7185ho.m43820b("HiAdMagLockImpl", "onAdFailed response is null!");
            magLockListener.onAdFailed(ErrorCode.ERROR_CODE_OTHER);
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<ContentRecord> listM46757a = AbstractC7573pg.m46757a(adContentRsp, 2);
        if (!AbstractC7760bg.m47767a(listM46757a)) {
            arrayList.addAll(listM46757a);
        }
        List<ContentRecord> listM46759b = AbstractC7573pg.m46759b(adContentRsp, 2);
        if (!AbstractC7760bg.m47767a(listM46759b)) {
            arrayList.addAll(listM46759b);
        }
        if (AbstractC7185ho.m43819a() && AbstractC7185ho.m43819a()) {
            Iterator it = arrayList.iterator();
            String str = "[";
            while (it.hasNext()) {
                str = str + ((ContentRecord) it.next()).m41588n() + " ";
            }
            AbstractC7185ho.m43818a("HiAdMagLockImpl", "received contentIds: %s", str + "]");
        }
        C7567pa c7567pa = new C7567pa(context, arrayList);
        c7567pa.mo46677a(2);
        c7567pa.mo46679a(adContentRsp.m40834d());
        c7567pa.mo46676a();
        if (z10) {
            c7567pa.mo46675a(true);
        }
        int iM40819a = adContentRsp.m40819a();
        if (Arrays.binarySearch(f34454a, iM40819a) >= 0) {
            C7204hy c7204hyM46681a = AbstractC7568pb.m46681a(adContentRsp, context, z10);
            if (c7204hyM46681a == null) {
                AbstractC7185ho.m43823c("HiAdMagLockImpl", "onAdSuccess but MagLockAdInfo is null");
            } else {
                AbstractC7185ho.m43821b("HiAdMagLockImpl", "onAdSuccess MagLockAdInfo: %s", c7204hyM46681a.toString());
            }
            magLockListener.onAdSuccess(c7204hyM46681a);
        } else if (Arrays.binarySearch(f34455b, iM40819a) >= 0) {
            AbstractC7185ho.m43824c("HiAdMagLockImpl", "onAdFailed errorCode: %s", Integer.valueOf(iM40819a));
            magLockListener.onAdFailed(iM40819a);
        } else {
            AbstractC7185ho.m43824c("HiAdMagLockImpl", "onAdFailed errorCode: %s", Integer.valueOf(ErrorCode.ERROR_CODE_OTHER));
            magLockListener.onAdFailed(ErrorCode.ERROR_CODE_OTHER);
        }
        AbstractC7185ho.m43818a("HiAdMagLockImpl", "load ads finish: %s", Long.valueOf(System.currentTimeMillis()));
        if (z10) {
            return;
        }
        c7567pa.mo46675a(z10);
    }

    /* renamed from: a */
    private static void m45659a(Context context, int i10) {
        AbstractC7603qe.m47018a(context, C7662sk.m47225a(context, 2), i10).mo47016f();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m45670b(com.huawei.openalliance.p169ad.magazine.inter.listener.MagLockListener r5, java.lang.String[] r6) {
        /*
            r4 = this;
            java.lang.String r4 = "HiAdMagLockImpl"
            r0 = 0
            if (r6 == 0) goto L21
            int r1 = r6.length
            if (r1 != 0) goto L9
            goto L21
        L9:
            int r1 = r6.length
            r2 = r0
        Lb:
            if (r2 >= r1) goto L1f
            r3 = r6[r2]
            boolean r3 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48165b(r3)
            if (r3 == 0) goto L1c
            java.lang.String r6 = "some adId is empty"
        L17:
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r4, r6)
            r6 = r0
            goto L24
        L1c:
            int r2 = r2 + 1
            goto Lb
        L1f:
            r6 = 1
            goto L24
        L21:
            java.lang.String r6 = "adIds is empty"
            goto L17
        L24:
            if (r5 != 0) goto L2c
            java.lang.String r5 = "listener is null"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r4, r5)
            goto L2d
        L2c:
            r0 = r6
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.magazine.inter.C7419a.m45670b(com.huawei.openalliance.ad.magazine.inter.listener.MagLockListener, java.lang.String[]):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45664a(InterfaceC7615qq interfaceC7615qq, EventType eventType, MagLockEventInfo magLockEventInfo) {
        switch (AnonymousClass4.f34476a[eventType.ordinal()]) {
            case 1:
                C7586a.a aVar = new C7586a.a();
                aVar.m46876a(false).m46881c((Integer) 0).m46880b(true);
                interfaceC7615qq.mo46593a(aVar.m46877a());
                break;
            case 2:
                MaterialClickInfo materialClickInfo = new MaterialClickInfo();
                materialClickInfo.m44515f(1);
                C7587b.a aVar2 = new C7587b.a();
                aVar2.m46912a(0).m46919b(0).m46920b((String) null).m46921b(true).m46914a(materialClickInfo);
                interfaceC7615qq.mo46594a(aVar2.m46918a());
                break;
            case 3:
                interfaceC7615qq.mo46626i();
                break;
            case 4:
                interfaceC7615qq.mo46627j();
                break;
            case 5:
                interfaceC7615qq.mo46628k();
                break;
            case 6:
                interfaceC7615qq.mo46629l();
                break;
            case 7:
                interfaceC7615qq.mo46630m();
                break;
            case 8:
                interfaceC7615qq.mo46589a(EventType.INTENTSUCCESS, (Integer) 1, (Integer) null, false);
                break;
            case 9:
                interfaceC7615qq.mo46589a(EventType.INTENTFAIL, (Integer) 1, magLockEventInfo.m46845a(), false);
                break;
        }
    }

    /* renamed from: a */
    private void m45665a(final String[] strArr, final List<String> list, final boolean z10, final MagLockListener magLockListener, final int i10) {
        if (m45666a(magLockListener, strArr)) {
            if (C7775bv.m47831e(this.f34457d)) {
                AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.magazine.inter.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdSlotParam.Builder builder = new AdSlotParam.Builder();
                        builder.setAdIds(Arrays.asList(strArr)).setDeviceType(4).setOrientation(1).setWidth(AbstractC7807d.m48229d(C7419a.this.f34457d)).setHeight(AbstractC7807d.m48233e(C7419a.this.f34457d)).setTest(z10).setIsPreload(Boolean.valueOf(i10 == 2)).setRequestOptions(HiAd.getInstance(C7419a.this.f34457d).getRequestConfiguration());
                        List<String> listM43152a = C7419a.this.f34459f.m43152a();
                        AbstractC7185ho.m43818a("HiAdMagLockImpl", "ready to loadAds , removedIds: %s,cachedContentIds: %s", listM43152a, list);
                        C7419a c7419a = C7419a.this;
                        c7419a.m45668b(c7419a.f34457d, builder.build(), list, listM43152a, magLockListener);
                        C7419a.this.f34459f.m43154b();
                    }
                });
            } else {
                AbstractC7185ho.m43823c("HiAdMagLockImpl", "onAdFailed netWork not Connected!");
                magLockListener.onAdFailed(ErrorCode.ERROR_CODE_OTHER);
            }
        }
    }

    /* renamed from: a */
    private boolean m45666a(MagLockListener magLockListener, String[] strArr) {
        if (AbstractC7741ao.m47587j()) {
            return m45670b(magLockListener, strArr);
        }
        if (magLockListener == null) {
            return false;
        }
        AbstractC7185ho.m43823c("HiAdMagLockImpl", "api too low! onNoSupport");
        magLockListener.onNoSupport();
        return false;
    }
}
