package p256ef;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadBabyHeadPicCallable;
import com.huawei.android.remotecontrol.facard.model.ShareLocationCardInfo;
import com.huawei.android.remotecontrol.http.BaseResponse;
import com.huawei.android.remotecontrol.http.PhoneFinderServer;
import com.huawei.android.remotecontrol.sharing.bean.LocateInfo;
import com.huawei.android.remotecontrol.sharing.bean.QueryLocateResponse;
import com.huawei.android.remotecontrol.sharing.bean.ShareGrantGetResponse;
import com.huawei.android.remotecontrol.sharing.bean.ShareGrantInfo;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.p129ai.C5807k0;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import mp.C11503a;
import no.C11739b;
import okhttp3.HttpRequestBuilder;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0241z;
import p020ap.C1010e;
import p256ef.C9465f;
import p292fn.C9733f;
import p366if.C10487l;
import p514o9.C11829c;
import p514o9.C11835i;
import p514o9.C11838l;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p581qk.AbstractC12369f;
import p616rk.C12515a;
import p681uj.C13195l;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import p809yg.C13981a;
import tm.C13040c;

/* renamed from: ef.f */
/* loaded from: classes4.dex */
public class C9465f {

    /* renamed from: a */
    public final Map<String, List<ShareGrantInfo>> f47212a;

    /* renamed from: b */
    public final Map<String, List<ShareGrantInfo>> f47213b;

    /* renamed from: c */
    public final C11503a<String, String, Set<Long>> f47214c;

    /* renamed from: d */
    public final C11503a<String, String, Set<Long>> f47215d;

    /* renamed from: e */
    public final PhoneFinderServer f47216e;

    /* renamed from: f */
    public final Context f47217f;

    /* renamed from: g */
    public int f47218g;

    /* renamed from: h */
    public final ReentrantLock f47219h;

    /* renamed from: ef.f$b */
    public class b extends C11739b {

        /* renamed from: d */
        public String f47220d;

        public b(String str, long j10) {
            super(str, j10);
            this.f47220d = str;
        }

        @Override // no.C11739b, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
        public void prepare(HttpRequestBuilder.a aVar) throws UnsupportedEncodingException {
            String strEncode;
            try {
                strEncode = URLEncoder.encode(C13195l.m79272J().m79344y("PhoneFinder", ""), Constants.UTF_8);
            } catch (Exception unused) {
                C11839m.m70687e("ShareReceivingManage", "MapSnapshotCallback Exception");
                strEncode = null;
            }
            aVar.addHeader("authType", "0").addHeader("authValue", strEncode).addHeader(HwPayConstant.KEY_SITE_ID, String.valueOf(C13452e.m80781L().m80947n0()));
            super.prepare(aVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00d2  */
        @Override // no.C11739b, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void onResponse(okhttp3.HttpResponseBuilder r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.String r0 = "ShareReceivingManage"
                okhttp3.h0 r1 = r10.m71595s()
                java.lang.String r1 = r1.m71637z()
                r2 = 0
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r3.<init>(r1)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r1 = "resultCode"
                java.lang.String r1 = r3.optString(r1)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r4 = "result"
                java.lang.String r3 = r3.optString(r4)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r4 = 0
                byte[] r3 = com.huawei.secure.android.common.util.SafeBase64.decode(r3, r4)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r5.<init>()     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r6 = "onResponse buff size: "
                r5.append(r6)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                int r6 = r3.length     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r5.append(r6)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                p514o9.C11839m.m70688i(r0, r5)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                android.os.Bundle r5 = new android.os.Bundle     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r5.<init>()     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r6 = "operationType"
                java.lang.String r7 = "mapCardShow"
                r5.putString(r6, r7)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r6 = "businessId"
                java.lang.String r7 = "petalMapCard"
                r5.putString(r6, r7)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r6 = "errorReason"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r7.<init>()     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r8 = "FA card map download response. resultCode: "
                r7.append(r8)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r7.append(r1)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r8 = ", buff size: "
                r7.append(r8)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                int r8 = r3.length     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r7.append(r8)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r5.putString(r6, r7)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                ap.e r6 = p020ap.C1010e.m6125b()     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r6.m6129D(r5)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r5.<init>()     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r6 = "onResponse. resultCode: "
                r5.append(r6)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                r5.append(r1)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                p809yg.C13981a.m83989i(r0, r5)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String r5 = "0"
                boolean r1 = com.huawei.hidisk.common.util.javautil.StringUtil.equals(r1, r5)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                if (r1 != 0) goto L8f
                r10.close()
                return r2
            L8f:
                java.lang.String r9 = r9.f47220d     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.lang.String[] r1 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.nio.file.Path r9 = java.nio.file.Paths.get(r9, r1)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r4]     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                java.io.OutputStream r9 = java.nio.file.Files.newOutputStream(r9, r1)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb2
                int r1 = r3.length     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
                r9.write(r3, r4, r1)     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
                r9.flush()     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            La4:
                r9.close()
            La7:
                r10.close()
                goto Lcf
            Lab:
                r0 = move-exception
                r2 = r9
                goto Ld0
            Lae:
                r1 = move-exception
                goto Lb4
            Lb0:
                r0 = move-exception
                goto Ld0
            Lb2:
                r1 = move-exception
                r9 = r2
            Lb4:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lab
                r3.<init>()     // Catch: java.lang.Throwable -> Lab
                java.lang.String r4 = "onResponse error e:"
                r3.append(r4)     // Catch: java.lang.Throwable -> Lab
                java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> Lab
                r3.append(r1)     // Catch: java.lang.Throwable -> Lab
                java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Lab
                p514o9.C11839m.m70687e(r0, r1)     // Catch: java.lang.Throwable -> Lab
                if (r9 == 0) goto La7
                goto La4
            Lcf:
                return r2
            Ld0:
                if (r2 == 0) goto Ld5
                r2.close()
            Ld5:
                r10.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p256ef.C9465f.b.onResponse(okhttp3.g0):java.lang.Void");
        }
    }

    /* renamed from: ef.f$c */
    public class c extends AbstractC12367d {
        public c() {
        }

        /* renamed from: j */
        public static /* synthetic */ boolean m59322j(Long l10) {
            return l10.longValue() > 0;
        }

        /* renamed from: m */
        public static /* synthetic */ boolean m59323m(Long l10) {
            return l10.longValue() > 0;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11503a c11503a;
            try {
                ShareGrantGetResponse shareGrantGetResponseM26199j = C9465f.this.f47216e.m26199j();
                if (shareGrantGetResponseM26199j.getResultCode() != 0) {
                    return;
                }
                List<ShareGrantInfo> shareGrantInfoList = shareGrantGetResponseM26199j.getShareGrantInfoList();
                C9465f.this.f47213b.clear();
                synchronized (C9465f.this.f47214c) {
                    c11503a = new C11503a(C9465f.this.f47214c);
                    C9465f.this.f47214c.m68668a();
                }
                for (final ShareGrantInfo shareGrantInfo : shareGrantInfoList) {
                    String senderUserId = shareGrantInfo.getSenderUserId();
                    c11503a.m68673f(shareGrantInfo.getSenderDeviceId(), senderUserId);
                    Optional.ofNullable((Set) C9465f.this.f47215d.m68673f(shareGrantInfo.getSenderDeviceId(), senderUserId)).ifPresent(new Consumer() { // from class: ef.g
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            this.f47238a.m59325l(shareGrantInfo, (Set) obj);
                        }
                    });
                    if (C9465f.this.f47213b.containsKey(senderUserId)) {
                        ((List) C9465f.this.f47213b.get(senderUserId)).add(shareGrantInfo);
                    } else {
                        C9465f.this.f47213b.put(senderUserId, new ArrayList(Collections.singletonList(shareGrantInfo)));
                    }
                }
                c11503a.m68670c().forEach(new Consumer() { // from class: ef.h
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f47240a.m59327o((Map.Entry) obj);
                    }
                });
                c11503a.m68668a();
                C9465f.this.f47215d.m68668a();
                C9465f.this.f47219h.lock();
                C9465f c9465f = C9465f.this;
                c9465f.m59297P(c9465f.f47217f, shareGrantInfoList.size() > 0);
            } catch (C9721b e10) {
                C13981a.m83988e("ShareReceivingManage", "GetReceivingInfoTask error:" + e10.getMessage());
            }
        }

        /* renamed from: k */
        public final /* synthetic */ void m59324k(ShareGrantInfo shareGrantInfo, Long l10) {
            C9465f.this.m59307r(shareGrantInfo.getSenderUserId(), shareGrantInfo.getSenderIconUrl(), true);
            C9465f.this.m59299R(l10.longValue(), shareGrantInfo.getSenderUserId(), shareGrantInfo.getSenderDeviceId(), shareGrantInfo.getSenderName(), C9465f.this.m59314y(shareGrantInfo.getSenderUserId()));
        }

        /* renamed from: l */
        public final /* synthetic */ void m59325l(final ShareGrantInfo shareGrantInfo, Set set) {
            set.stream().filter(new Predicate() { // from class: ef.i
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C9465f.c.m59322j((Long) obj);
                }
            }).forEach(new Consumer() { // from class: ef.j
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f47241a.m59324k(shareGrantInfo, (Long) obj);
                }
            });
        }

        /* renamed from: n */
        public final /* synthetic */ void m59326n(String str, String str2, Long l10) {
            C9465f.this.m59303V(l10.longValue(), str, str2);
        }

        /* renamed from: o */
        public final /* synthetic */ void m59327o(Map.Entry entry) {
            final String str = (String) ((C11503a.a) entry.getKey()).m68674a();
            final String str2 = (String) ((C11503a.a) entry.getKey()).m68675b();
            ((Set) entry.getValue()).stream().filter(new Predicate() { // from class: ef.k
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C9465f.c.m59323m((Long) obj);
                }
            }).forEach(new Consumer() { // from class: ef.l
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f47243a.m59326n(str2, str, (Long) obj);
                }
            });
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public void release() {
            super.release();
            C9465f.this.f47219h.unlock();
        }
    }

    /* renamed from: ef.f$d */
    public static class d {

        /* renamed from: a */
        public static final C9465f f47223a = new C9465f();
    }

    /* renamed from: ef.f$e */
    public class e extends AbstractC12369f {

        /* renamed from: a */
        public final ShareLocationCardInfo f47224a;

        /* renamed from: b */
        public final String f47225b;

        /* renamed from: c */
        public final String f47226c;

        /* renamed from: d */
        public final int f47227d;

        /* renamed from: e */
        public final long f47228e;

        /* renamed from: f */
        public boolean f47229f;

        /* renamed from: g */
        public int f47230g;

        public e(long j10, long j11, long j12, ShareLocationCardInfo shareLocationCardInfo) {
            super(j10, j11);
            this.f47229f = false;
            this.f47230g = 0;
            this.f47228e = j12;
            this.f47224a = shareLocationCardInfo;
            this.f47225b = shareLocationCardInfo.getDeviceId();
            this.f47227d = C0241z.m1685c(shareLocationCardInfo.getSenderDeviceType());
            this.f47226c = shareLocationCardInfo.getSenderUserId();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            if (this.f47229f) {
                cancel();
                return;
            }
            if (this.f47230g > 2) {
                C13981a.m83988e("ShareReceivingManage", "can't get sender locateInfo");
                this.f47229f = true;
                C9465f.this.m59300S(this.f47228e, this.f47226c, this.f47225b);
                cancel();
                return;
            }
            try {
                C13981a.m83989i("ShareReceivingManage", "start queryLocateTask");
                QueryLocateResponse queryLocateResponseM26206q = C9465f.this.f47216e.m26206q(this.f47225b, Integer.valueOf(this.f47227d), "1", null, this.f47224a.getRelationType(), this.f47226c);
                if (queryLocateResponseM26206q.getResultCode() != 3029 && queryLocateResponseM26206q.getResultCode() != 3030) {
                    LocateInfo info = queryLocateResponseM26206q.getInfo();
                    if (info != null) {
                        this.f47229f = true;
                        Location location = new Location("");
                        location.setLongitude(info.getLongitudeWGS());
                        location.setLatitude(info.getLatitudeWGS());
                        if (C10487l.m64539f(location)) {
                            C9465f.this.m59301T(this.f47228e, this.f47226c, this.f47225b);
                            cancel();
                            return;
                        }
                        Location locationM64545l = C10487l.m64545l(location);
                        if (locationM64545l != null) {
                            String strM59310u = C9465f.this.m59310u(this.f47225b);
                            C9465f.this.m59308s(locationM64545l, strM59310u);
                            C9465f.this.m59302U(this.f47228e, new File(strM59310u), this.f47226c, this.f47225b);
                        }
                        cancel();
                    }
                    return;
                }
                C13981a.m83989i("ShareReceivingManage", "queryLocate failed : " + queryLocateResponseM26206q.getResultCode());
                C9465f.this.m59305X(this.f47226c, this.f47225b);
                C9465f.this.m59303V(this.f47228e, this.f47226c, this.f47225b);
            } finally {
                this.f47230g++;
            }
        }
    }

    /* renamed from: ef.f$f */
    public class f extends AbstractC12367d {

        /* renamed from: a */
        public final ShareLocationCardInfo f47232a;

        /* renamed from: b */
        public final String f47233b;

        /* renamed from: c */
        public final String f47234c;

        /* renamed from: d */
        public final int f47235d;

        /* renamed from: e */
        public final long f47236e;

        public f(long j10, ShareLocationCardInfo shareLocationCardInfo) {
            this.f47232a = shareLocationCardInfo;
            this.f47236e = j10;
            this.f47233b = shareLocationCardInfo.getDeviceId();
            this.f47235d = C0241z.m1685c(shareLocationCardInfo.getSenderDeviceType());
            this.f47234c = shareLocationCardInfo.getSenderUserId();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException, C9721b {
            C13981a.m83989i("ShareReceivingManage", "start sendLocateTask");
            BaseResponse baseResponseM26208s = C9465f.this.f47216e.m26208s(this.f47233b, Integer.valueOf(this.f47235d), this.f47232a.getRelationType(), this.f47234c);
            if (baseResponseM26208s.getResultCode() != 3029 && baseResponseM26208s.getResultCode() != 3030) {
                C13981a.m83989i("ShareReceivingManage", "sendLocateTask result: " + baseResponseM26208s.getResultCode());
                C12515a.m75110o().m75172d(C9465f.this.new e(5L, 5L, this.f47236e, this.f47232a));
                return;
            }
            C13981a.m83989i("ShareReceivingManage", "queryLocate failed : " + baseResponseM26208s.getResultCode());
            C9465f.this.m59305X(this.f47234c, this.f47233b);
            C9465f.this.m59303V(this.f47236e, this.f47234c, this.f47233b);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    /* renamed from: A */
    public static C9465f m59265A() {
        return d.f47223a;
    }

    /* renamed from: N */
    public static /* synthetic */ boolean m59266N(List list, Long l10) {
        return !list.contains(l10);
    }

    /* renamed from: O */
    public static /* synthetic */ void m59267O(Long l10) {
        C9462c.m59254g().m59262i(l10.longValue());
    }

    /* renamed from: B */
    public long m59285B() {
        return this.f47218g;
    }

    /* renamed from: C */
    public final String m59286C(String str, Context context) {
        String strM78623O;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            strM78623O = (C13452e.m80781L().m80842P0() && C1010e.m6125b().m6138d(context)) ? C13040c.m78609F().m78623O() : C13040c.m78609F().m78622N();
        } catch (C9721b e10) {
            C11839m.m70687e("ShareReceivingManage", "cannot get phoneFinder address from grs: " + e10.getMessage());
            strM78623O = null;
        }
        C11839m.m70686d("ShareReceivingManage", "domain is " + strM78623O);
        if (TextUtils.isEmpty(strM78623O)) {
            C11839m.m70687e("ShareReceivingManage", "domain is empty");
            return null;
        }
        return strM78623O + str;
    }

    /* renamed from: D */
    public boolean m59287D(long j10) {
        ShareLocationCardInfo shareLocationCardInfoM59258d;
        try {
            if (j10 > 0) {
                shareLocationCardInfoM59258d = C9462c.m59254g().m59258d(j10);
                if (shareLocationCardInfoM59258d != null) {
                    String deviceId = shareLocationCardInfoM59258d.getDeviceId();
                    String senderUserId = shareLocationCardInfoM59258d.getSenderUserId();
                    C13981a.m83989i("ShareReceivingManage", "getReceivingInfo: " + j10);
                    synchronized (this.f47214c) {
                        try {
                            if (this.f47214c.m68669b(deviceId, senderUserId)) {
                                this.f47214c.m68671d(deviceId, senderUserId).add(Long.valueOf(j10));
                            } else {
                                this.f47214c.m68672e(deviceId, senderUserId, new HashSet(Collections.singletonList(Long.valueOf(j10))));
                            }
                        } finally {
                        }
                    }
                }
                this.f47219h.lock();
                C12515a.m75110o().m75172d(new c());
                return j10 > 0 || shareLocationCardInfoM59258d != null;
            }
            shareLocationCardInfoM59258d = null;
            C12515a.m75110o().m75172d(new c());
            if (j10 > 0) {
            }
        } finally {
            this.f47219h.unlock();
        }
        C13981a.m83989i("ShareReceivingManage", "getReceivingInfo all");
        this.f47219h.lock();
    }

    /* renamed from: E */
    public final String m59288E(Location location) throws UnsupportedEncodingException {
        if (location == null) {
            C11839m.m70687e("ShareReceivingManage", "getRequestUrl, location is null");
            return null;
        }
        try {
            String strEncode = URLEncoder.encode(URLEncoder.encode(location.getLatitude() + "," + location.getLongitude(), Constants.UTF_8), Constants.UTF_8);
            String strM59286C = m59286C("/FindCloud/FindService/Map/Image", C0213f.m1377a());
            if (TextUtils.isEmpty(strM59286C)) {
                C11839m.m70687e("ShareReceivingManage", "getRequestUrl, url is empty");
                return null;
            }
            String str = C13843a.m83067S() ? "&language=zh" : "&language=en";
            StringBuilder sb2 = new StringBuilder(strM59286C);
            sb2.append("?width=");
            sb2.append("400");
            sb2.append("&height=");
            sb2.append("240");
            sb2.append("&location=");
            sb2.append(strEncode);
            sb2.append("&scale=2");
            sb2.append("&zoom=");
            sb2.append(16);
            sb2.append("&fields=result");
            sb2.append(str);
            return String.valueOf(sb2);
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e("ShareReceivingManage", "getRequestUrl, URLEncoder error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: F */
    public List<String> m59289F() {
        return new ArrayList(this.f47212a.keySet());
    }

    /* renamed from: G */
    public String m59290G(String str) {
        List<ShareGrantInfo> list = this.f47212a.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0).getSenderName();
    }

    /* renamed from: H */
    public ShareGrantInfo m59291H(String str, int i10) {
        List<ShareGrantInfo> list = this.f47212a.get(str);
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return list.get(i10);
    }

    /* renamed from: I */
    public List<ShareGrantInfo> m59292I(String str) {
        return this.f47212a.get(str);
    }

    /* renamed from: J */
    public boolean m59293J() {
        return this.f47212a.size() > 0;
    }

    /* renamed from: K */
    public boolean m59294K() {
        try {
            ShareGrantGetResponse shareGrantGetResponseM26199j = this.f47216e.m26199j();
            if (shareGrantGetResponseM26199j.getResultCode() != 0) {
                return false;
            }
            List<ShareGrantInfo> shareGrantInfoList = shareGrantGetResponseM26199j.getShareGrantInfoList();
            this.f47212a.clear();
            for (ShareGrantInfo shareGrantInfo : shareGrantInfoList) {
                String senderUserId = shareGrantInfo.getSenderUserId();
                if (this.f47212a.containsKey(senderUserId)) {
                    this.f47212a.get(senderUserId).add(shareGrantInfo);
                } else {
                    m59307r(senderUserId, shareGrantInfo.getSenderIconUrl(), false);
                    this.f47212a.put(senderUserId, new ArrayList(Collections.singletonList(shareGrantInfo)));
                }
            }
            return true;
        } catch (C9721b e10) {
            C13981a.m83988e("ShareReceivingManage", "init error:" + e10.getMessage());
            m59295L();
            return false;
        }
    }

    /* renamed from: L */
    public void m59295L() {
        this.f47212a.clear();
        this.f47212a.putAll(this.f47213b);
    }

    /* renamed from: M */
    public final boolean m59296M(ShareLocationCardInfo shareLocationCardInfo, String str, String str2) {
        return shareLocationCardInfo == null || str == null || str2 == null || !str.equals(shareLocationCardInfo.getSenderUserId()) || !str2.equals(shareLocationCardInfo.getDeviceId());
    }

    /* renamed from: P */
    public void m59297P(Context context, boolean z10) {
        C13981a.m83989i("ShareReceivingManage", "notifyAllFAToInit: " + z10);
        Uri uri = Uri.parse("dataability://com.huawei.hicloud.HwCloudDriveFADataAbility");
        Bundle bundle = new Bundle();
        bundle.putBoolean("hasShare", z10);
        m59311v(context, uri, bundle, "reset_all_init");
    }

    /* renamed from: Q */
    public void m59298Q(Context context) {
        C13981a.m83989i("ShareReceivingManage", "notifyFAAccountLogout");
        C9462c.m59254g().m59257c();
        m59311v(context, Uri.parse("dataability://com.huawei.hicloud.HwCloudDriveFADataAbility"), null, "reset_all_init");
    }

    /* renamed from: R */
    public final void m59299R(long j10, String str, String str2, String str3, String str4) {
        C13981a.m83989i("ShareReceivingManage", "notifyFAInfo: " + j10);
        if (m59296M(C9462c.m59254g().m59258d(j10), str, str2)) {
            return;
        }
        C9462c.m59254g().m59263j(j10, str3, null, null);
        Uri uri = Uri.parse("dataability://com.huawei.hicloud.HwCloudDriveFADataAbility");
        Bundle bundle = new Bundle();
        bundle.putLong("formId", j10);
        bundle.putString(HwPayConstant.KEY_USER_NAME, str3);
        bundle.putString("avatarUri", str4);
        m59311v(this.f47217f, uri, bundle, "sender_change");
    }

    /* renamed from: S */
    public final void m59300S(long j10, String str, String str2) {
        C13981a.m83989i("ShareReceivingManage", "notifyFALocateFail: " + j10);
        if (m59296M(C9462c.m59254g().m59258d(j10), str, str2)) {
            return;
        }
        Uri uri = Uri.parse("dataability://com.huawei.hicloud.HwCloudDriveFADataAbility");
        Bundle bundle = new Bundle();
        bundle.putLong("formId", j10);
        bundle.putBoolean("locateResult", false);
        m59311v(this.f47217f, uri, bundle, "locate_sender");
    }

    /* renamed from: T */
    public final void m59301T(long j10, String str, String str2) {
        C13981a.m83989i("ShareReceivingManage", "notifyFALocateOutChina: " + j10);
        if (m59296M(C9462c.m59254g().m59258d(j10), str, str2)) {
            return;
        }
        Uri uri = Uri.parse("dataability://com.huawei.hicloud.HwCloudDriveFADataAbility");
        Bundle bundle = new Bundle();
        bundle.putLong("formId", j10);
        bundle.putBoolean("locateOutChina", true);
        m59311v(this.f47217f, uri, bundle, "locate_sender");
    }

    /* renamed from: U */
    public final void m59302U(long j10, File file, String str, String str2) {
        C13981a.m83989i("ShareReceivingManage", "notifyFARefreshMap: " + j10);
        if (m59296M(C9462c.m59254g().m59258d(j10), str, str2)) {
            return;
        }
        Uri uriForFile = FileProvider.getUriForFile(this.f47217f, FeedbackConst.Mail.HIDISK_FILE_PROVIDER, file);
        this.f47217f.grantUriPermission(NotifyConstants.InterfaceC4908FA.PACKAGE_NAME, uriForFile, 3);
        Uri uri = Uri.parse("dataability://com.huawei.hicloud.HwCloudDriveFADataAbility");
        Bundle bundle = new Bundle();
        bundle.putLong("formId", j10);
        bundle.putBoolean("locateResult", true);
        bundle.putString("mapUri", uriForFile.toString());
        m59311v(this.f47217f, uri, bundle, "locate_sender");
    }

    /* renamed from: V */
    public final void m59303V(long j10, String str, String str2) {
        C13981a.m83989i("ShareReceivingManage", "notifyFAToInit: " + j10);
        if (m59296M(C9462c.m59254g().m59258d(j10), str, str2)) {
            return;
        }
        C9462c.m59254g().m59262i(j10);
        Uri uri = Uri.parse("dataability://com.huawei.hicloud.HwCloudDriveFADataAbility");
        Bundle bundle = new Bundle();
        bundle.putLong("formId", j10);
        bundle.putBoolean("hasShare", this.f47213b.size() > 0);
        m59311v(this.f47217f, uri, bundle, "reset_init");
    }

    /* renamed from: W */
    public void m59304W(Context context, long j10, ShareGrantInfo shareGrantInfo) {
        C13981a.m83989i("ShareReceivingManage", "notifyFAToMap");
        Uri uri = Uri.parse("dataability://com.huawei.hicloud.HwCloudDriveFADataAbility");
        ShareLocationCardInfo shareLocationCardInfo = new ShareLocationCardInfo();
        shareLocationCardInfo.setDeviceId(shareGrantInfo.getSenderDeviceId());
        shareLocationCardInfo.setSenderUserId(shareGrantInfo.getSenderUserId());
        shareLocationCardInfo.setUserName(shareGrantInfo.getSenderName());
        shareLocationCardInfo.setSenderDeviceType(shareGrantInfo.getSenderDeviceType());
        shareLocationCardInfo.setRelationType(Integer.valueOf(shareGrantInfo.getRelationType()));
        C9462c.m59254g().m59255a(j10, shareLocationCardInfo);
        Bundle bundle = new Bundle();
        String strM59314y = m59265A().m59314y(shareGrantInfo.getSenderUserId());
        bundle.putLong("formId", j10);
        bundle.putString("avatarUri", strM59314y);
        m59311v(context, uri, bundle, "set_to_map");
    }

    /* renamed from: X */
    public final synchronized void m59305X(String str, String str2) {
        try {
            List<ShareGrantInfo> list = this.f47213b.get(str);
            Iterator<ShareGrantInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getSenderDeviceId().equals(str2)) {
                    it.remove();
                    break;
                }
            }
            if (list.size() == 0) {
                this.f47213b.remove(str);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: Y */
    public void m59306Y(long j10, boolean z10) {
        ShareLocationCardInfo shareLocationCardInfoM59258d;
        if (j10 <= 0 || (shareLocationCardInfoM59258d = C9462c.m59254g().m59258d(j10)) == null) {
            return;
        }
        String deviceId = shareLocationCardInfoM59258d.getDeviceId();
        String senderUserId = shareLocationCardInfoM59258d.getSenderUserId();
        if (z10) {
            C13981a.m83989i("ShareReceivingManage", "startLocateSender: " + j10);
            if (this.f47215d.m68669b(deviceId, senderUserId)) {
                this.f47215d.m68671d(deviceId, senderUserId).add(Long.valueOf(j10));
            } else {
                this.f47215d.m68672e(deviceId, senderUserId, new HashSet(Collections.singletonList(Long.valueOf(j10))));
            }
        }
        if (TextUtils.isEmpty(shareLocationCardInfoM59258d.getSenderDeviceType())) {
            shareLocationCardInfoM59258d.setRelationType(9);
        }
        C12515a.m75110o().m75172d(new f(j10, shareLocationCardInfoM59258d));
    }

    /* renamed from: r */
    public final void m59307r(String str, String str2, boolean z10) {
        String strM59309t = m59309t(str);
        File file = new File(strM59309t);
        if (file.exists()) {
            if (TextUtils.isEmpty(str2)) {
                if (file.delete()) {
                    return;
                }
                C13981a.m83988e("ShareReceivingManage", "delete avatar error");
                return;
            } else if (!z10) {
                return;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        C11829c.m70598n(strM59309t, str2, new C11739b(strM59309t, 0L));
    }

    /* renamed from: s */
    public final void m59308s(Location location, String str) throws UnsupportedEncodingException {
        C11839m.m70688i("ShareReceivingManage", "blockingDownloadMap");
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM59288E = m59288E(location);
        if (strM59288E == null) {
            C13981a.m83988e("ShareReceivingManage", "downloadPetalMapPic fail");
            m59313x(location, str);
            return;
        }
        C13981a.m83989i("ShareReceivingManage", "start to add loadImageTask.");
        String str2 = str + "_tmp";
        try {
            C11829c.m70598n(str2, strM59288E, new b(str2, 0L));
            File file = new File(str2);
            if (!file.exists()) {
                C13981a.m83988e("ShareReceivingManage", "tempFile is not exist");
                m59313x(location, str);
                return;
            }
            if (C0209d.m1311u(str2) == null) {
                C13981a.m83988e("ShareReceivingManage", "downloadPetalMapPic bitmap is null");
                m59313x(location, str);
                return;
            }
            if (!file.renameTo(new File(str))) {
                C13981a.m83988e("ShareReceivingManage", "downloadPetalMapPic fail");
                m59313x(location, str);
                return;
            }
            C13981a.m83989i("ShareReceivingManage", "downloadPetalMapPic success");
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("download_map_from", "from_fa_card");
            linkedHashMapM79497A.put("mapType", "petalMapCard");
            C13230i.m79504I().m79567R("mecloud_findmyphone_download_map", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "mecloud_findmyphone_download_map", linkedHashMapM79497A);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            Bundle bundle = new Bundle();
            bundle.putString("operationType", "mapCardLoad");
            bundle.putString(C5807k0.f25949l, "petalMapCard");
            bundle.putString("errorReason", "FA card downloadPetalMapPic success. times: " + jCurrentTimeMillis2);
            C1010e.m6125b().m6129D(bundle);
        } catch (Exception e10) {
            C13981a.m83988e("ShareReceivingManage", "blockingDownloadMap petal map error: " + e10.getMessage());
            m59313x(location, str);
        }
    }

    /* renamed from: t */
    public final String m59309t(String str) {
        return C11835i.m70649m(this.f47217f).getPath() + "/fa/avatar/" + C0227m.m1593f(str) + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT;
    }

    /* renamed from: u */
    public final String m59310u(String str) {
        return C11835i.m70649m(this.f47217f).getPath() + "/fa/mappic/" + C0227m.m1593f(str) + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT;
    }

    /* renamed from: v */
    public final Bundle m59311v(Context context, Uri uri, Bundle bundle, String str) {
        try {
            return context.getContentResolver().call(uri, str, (String) null, bundle);
        } catch (Exception e10) {
            C13981a.m83988e("ShareReceivingManage", "callContentResolver error: " + e10.getMessage());
            return new Bundle();
        }
    }

    /* renamed from: w */
    public void m59312w(final List<Long> list, Set<Long> set) {
        if (set == null || set.size() == 0) {
            return;
        }
        if (list.size() == 0) {
            C9462c.m59254g().m59257c();
        } else {
            set.stream().filter(new Predicate() { // from class: ef.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C9465f.m59266N(list, (Long) obj);
                }
            }).forEach(new Consumer() { // from class: ef.e
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C9465f.m59267O((Long) obj);
                }
            });
        }
    }

    /* renamed from: x */
    public final void m59313x(Location location, String str) {
        C13981a.m83989i("ShareReceivingManage", "downloadDefaultMap");
        String str2 = location.getLongitude() + "," + location.getLatitude();
        String str3 = C13843a.m83067S() ? "" : "&language=en";
        String strM70685c = C11838l.m70685c();
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C13981a.m83988e("ShareReceivingManage", "downloadDefaultMap hiCloudSysParamMap is null");
            return;
        }
        String mapPreUrl = hiCloudSysParamMapM60757p.getMapPreUrl();
        if (strM70685c == null || mapPreUrl == null) {
            return;
        }
        String str4 = mapPreUrl + "?zoom=15&size=400*240&key=" + strM70685c + "&scale=2&location=" + str2 + str3;
        C13981a.m83989i("ShareReceivingManage", "start to add loadImageTask.");
        String str5 = str + "_tmp";
        C11829c.m70598n(str5, str4, new C11739b(str5, 0L));
        File file = new File(str5);
        if (file.exists() && file.renameTo(new File(str))) {
            C13981a.m83989i("ShareReceivingManage", "downloadMapPic success");
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("download_map_from", "from_fa_card");
            linkedHashMapM79497A.put("mapType", "defaultMapCard");
            C13230i.m79504I().m79567R("mecloud_findmyphone_download_map", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "mecloud_findmyphone_download_map", linkedHashMapM79497A);
            Bundle bundle = new Bundle();
            bundle.putString("operationType", "mapCardLoad");
            bundle.putString(C5807k0.f25949l, "defaultMapCard");
            bundle.putString("errorReason", "FA card downloadDefaultMap success");
            C1010e.m6125b().m6129D(bundle);
        }
    }

    /* renamed from: y */
    public String m59314y(String str) {
        File file = new File(m59309t(str));
        if (!file.exists() || file.length() > 4194304) {
            return null;
        }
        Uri uriForFile = FileProvider.getUriForFile(this.f47217f, FeedbackConst.Mail.HIDISK_FILE_PROVIDER, file);
        this.f47217f.grantUriPermission(NotifyConstants.InterfaceC4908FA.PACKAGE_NAME, uriForFile, 3);
        return uriForFile.toString();
    }

    /* renamed from: z */
    public final List<Long> m59315z() {
        C13981a.m83989i("ShareReceivingManage", "getFormIdListFormFA");
        long[] longArray = m59311v(this.f47217f, Uri.parse("dataability://com.huawei.hicloud.HwCloudDriveFADataAbility"), null, "get_form_id").getLongArray("formIdList");
        return longArray == null ? new ArrayList() : (List) LongStream.of(longArray).boxed().collect(Collectors.toList());
    }

    public C9465f() {
        int locateInterval;
        this.f47212a = new HashMap();
        this.f47213b = new HashMap();
        this.f47214c = new C11503a<>();
        this.f47215d = new C11503a<>();
        this.f47218g = Constants.HALF_HOUR;
        this.f47219h = new ReentrantLock(true);
        Context contextM1377a = C0213f.m1377a();
        this.f47217f = contextM1377a;
        this.f47216e = new PhoneFinderServer(contextM1377a);
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null && (locateInterval = hiCloudSysParamMapM60757p.getLocateInterval()) > 0) {
            this.f47218g = locateInterval * 60000;
        }
        Set<Long> setM59260f = C9462c.m59254g().m59260f();
        if (C0209d.m1205R0(setM59260f)) {
            return;
        }
        m59312w(m59315z(), setM59260f);
    }
}
