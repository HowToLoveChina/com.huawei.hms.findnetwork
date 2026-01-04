package p031b7;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import bb.C1160a;
import ck.C1443a;
import com.google.gson.Gson;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadBabyHeadPicCallable;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.model.PictureMetaData;
import com.huawei.android.hicloud.drive.cloudphoto.model.VideoMetaData;
import com.huawei.android.hicloud.security.bean.DataDecryptReq;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.android.text.format.DateUtilsEx;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.FilterDataForRecommend;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.notify.NotifyService;
import com.huawei.hidisk.common.kvdb.KvDatabaseWrapper;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.network.embedded.C6110u3;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import com.huawei.secure.android.common.util.SafeString;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p009a8.C0069g;
import p009a8.C0070h;
import p009a8.C0077o;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0229n;
import p015ak.C0234s;
import p015ak.C0237v;
import p015ak.C0241z;
import p031b7.C1136q;
import p054cj.C1442a;
import p260ek.C9499a;
import p281f8.C9673j;
import p292fn.C9733f;
import p341hj.C10220d0;
import p365ic.C10466a;
import p429kk.C11058a;
import p429kk.C11060c;
import p511o6.C11820b;
import p514o9.C11829c;
import p514o9.C11835i;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p649t6.C12947g;
import p664u0.C13108a;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p783xp.C13843a;
import tm.C13040c;

/* renamed from: b7.c */
/* loaded from: classes2.dex */
public class C1122c {

    /* renamed from: A */
    public static Map<String, List<MediaFileBean>> f5342A;

    /* renamed from: B */
    public static final ReadWriteLock f5343B;

    /* renamed from: C */
    public static final Lock f5344C;

    /* renamed from: D */
    public static final Lock f5345D;

    /* renamed from: E */
    public static final Object f5346E;

    /* renamed from: a */
    public static final Uri f5347a = Uri.withAppendedPath(C13843a.m83053E(), "is_support_cloudphoto");

    /* renamed from: b */
    public static final Uri f5348b;

    /* renamed from: c */
    public static final Uri f5349c;

    /* renamed from: d */
    public static final Uri f5350d;

    /* renamed from: e */
    public static final Uri f5351e;

    /* renamed from: f */
    public static final Uri f5352f;

    /* renamed from: g */
    public static final Uri f5353g;

    /* renamed from: h */
    public static final Uri f5354h;

    /* renamed from: i */
    public static final Uri f5355i;

    /* renamed from: j */
    public static final Uri f5356j;

    /* renamed from: k */
    public static final Pattern f5357k;

    /* renamed from: l */
    public static String f5358l;

    /* renamed from: m */
    public static HiCloudSysParamMap f5359m;

    /* renamed from: n */
    public static C12947g f5360n;

    /* renamed from: o */
    public static final int[] f5361o;

    /* renamed from: p */
    public static final int f5362p;

    /* renamed from: q */
    public static final int f5363q;

    /* renamed from: r */
    public static final String[] f5364r;

    /* renamed from: s */
    public static final String[] f5365s;

    /* renamed from: t */
    public static final String[] f5366t;

    /* renamed from: u */
    public static final String[] f5367u;

    /* renamed from: v */
    public static final long f5368v;

    /* renamed from: w */
    public static long f5369w;

    /* renamed from: x */
    public static final Object f5370x;

    /* renamed from: y */
    public static final Object f5371y;

    /* renamed from: z */
    public static final Map<String, String> f5372z;

    /* renamed from: b7.c$a */
    public class a implements Callable<Boolean> {

        /* renamed from: a */
        public final /* synthetic */ Context f5373a;

        public a(Context context) {
            this.f5373a = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(C1122c.m6714L1(this.f5373a, C1122c.f5351e, new String[]{"is_mobile_switch_on"}));
        }
    }

    /* renamed from: b7.c$b */
    public class b implements Callable {

        /* renamed from: a */
        public final /* synthetic */ Context f5374a;

        public b(Context context) {
            this.f5374a = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            if (CloudAlbumSettings.m14363h().m14386v()) {
                CloudAlbumSettings.m14363h().m14365B(C1122c.m6714L1(this.f5374a, C1122c.f5352f, new String[]{"is_gallery_network_on"}));
            }
            return Boolean.valueOf(C1122c.m6714L1(this.f5374a, C1122c.f5351e, new String[]{"is_mobile_switch_on"}));
        }
    }

    /* renamed from: b7.c$c */
    public class c extends Handler {

        /* renamed from: a */
        public final /* synthetic */ String[] f5375a;

        /* renamed from: b */
        public final /* synthetic */ int[] f5376b;

        /* renamed from: c */
        public final /* synthetic */ CountDownLatch f5377c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, String[] strArr, int[] iArr, CountDownLatch countDownLatch) {
            super(looper);
            this.f5375a = strArr;
            this.f5376b = iArr;
            this.f5377c = countDownLatch;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 6009) {
                this.f5375a[0] = C1122c.m6679A(message.obj);
                this.f5376b[0] = 0;
                this.f5377c.countDown();
            } else {
                if (i10 != 6010) {
                    this.f5377c.countDown();
                    return;
                }
                this.f5376b[0] = 1;
                C11839m.m70688i("AlbumUtil", "getPackageId CHECK_FAIL msg.obj e.getMessage()：" + message.obj);
                this.f5377c.countDown();
            }
        }
    }

    /* renamed from: b7.c$d */
    public static class d extends AbstractC12367d {
        public d() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Context contextM1377a = C0213f.m1377a();
            boolean zM7166d = C1136q.e.m7166d(contextM1377a);
            C1120a.m6677i("AlbumUtil", "reportGalleryForeground switch AlbumOn: " + zM7166d);
            if (zM7166d) {
                try {
                    Uri uriM83100v = C13843a.m83100v();
                    if (C0209d.m1227Y1(contextM1377a, uriM83100v) && C1122c.m6789i(contextM1377a, uriM83100v, "request_sync", null, new Bundle()) == null) {
                        C1120a.m6675d("AlbumUtil", "reportGalleryForeground request_sync is null");
                    }
                } catch (Exception e10) {
                    C1120a.m6676e("AlbumUtil", "reportGalleryForeground Exception:" + e10);
                }
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    static {
        Uri uriM83100v = C13843a.m83100v();
        f5348b = uriM83100v;
        f5349c = Uri.withAppendedPath(uriM83100v, "is_support_disable");
        f5350d = Uri.withAppendedPath(uriM83100v, "clear_cloud_version");
        f5351e = Uri.withAppendedPath(uriM83100v, "is_mobile_switch_on");
        f5352f = Uri.withAppendedPath(uriM83100v, "is_gallery_network_on");
        f5353g = Uri.parse("content://com.huawei.cloudalbumsdk.SdkProvider/sync_state");
        f5354h = Uri.parse("content://com.huawei.cloudalbumsdk.SdkProvider/delete_sync_state");
        f5355i = Uri.parse("content://com.huawei.cloudalbumsdk.SdkProvider/delete_album_dot");
        f5356j = Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI);
        f5357k = Pattern.compile("[a-zA-Z0-9_\\-]{1,150}");
        f5360n = new C12947g();
        f5361o = new int[]{200, 400, 800, 1600, 3200, 6400, 12800, 30000, 50000, 100000, 100000, 100000};
        int i10 = C11842p.m70771U0() ? 150 : 90;
        f5362p = i10;
        f5363q = i10 / 3;
        f5364r = new String[]{"00:00:00", "06:00:00", "06:30:00", "07:00:00", "07:30:00"};
        f5365s = new String[]{"00:00:45", "06:00:20", "06:30:20", "07:00:20", "07:30:20"};
        f5366t = new String[]{"00:00:00"};
        f5367u = new String[]{"00:00:20"};
        f5368v = C11829c.f54756b ? 100000000L : Constants.WEB_VIEW_CACHE_TOTAL_MAX_SIZE;
        f5369w = 0L;
        f5370x = new Object();
        f5371y = new Object();
        f5372z = new HashMap();
        f5342A = new HashMap();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        f5343B = reentrantReadWriteLock;
        f5344C = reentrantReadWriteLock.readLock();
        f5345D = reentrantReadWriteLock.writeLock();
        f5346E = new Object();
    }

    /* renamed from: A */
    public static String m6679A(Object obj) {
        try {
            return ((FilterDataForRecommend) obj).getFilterAvailabalGradePackageList().get(0).getPackageIdList().get(0);
        } catch (Exception e10) {
            C11839m.m70688i("AlbumUtil", "dealGetPackagesBySpaceRuleSuccess object is invalid. e: " + e10.toString());
            return "";
        }
    }

    /* renamed from: A0 */
    public static int m6680A0(Context context) {
        return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("notUploadedCount", 0);
    }

    /* renamed from: A1 */
    public static boolean m6681A1(int i10, long j10, long j11) {
        if (i10 != 0 || j10 >= j11 + 52428800) {
            return i10 != 0 && j10 <= 102400;
        }
        return true;
    }

    /* renamed from: B */
    public static void m6682B(Exception exc, Handler handler, final Activity activity) {
        if (exc == null || handler == null || !(exc instanceof C4616s) || !"31004091".equals(C1160a.m7253d((C4616s) exc))) {
            return;
        }
        handler.post(new Runnable() { // from class: b7.b
            @Override // java.lang.Runnable
            public final void run() {
                C1122c.m6702H1(activity);
            }
        });
    }

    /* renamed from: B0 */
    public static int m6683B0(Context context) {
        long jM7025S = C1136q.b.m7025S(context);
        if (jM7025S == 0) {
            return C1136q.b.m7005I(context);
        }
        long jCurrentTimeMillis = jM7025S - System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            return C1136q.b.m7005I(context);
        }
        int i10 = (int) (jCurrentTimeMillis / 86400000);
        return (CloudAlbumSettings.m14363h().m14376l() || jCurrentTimeMillis % 86400000 <= 0) ? i10 : i10 + 1;
    }

    /* renamed from: B1 */
    public static boolean m6684B1(ErrorResp.Error error, String str) {
        List<ErrorResp.ErrorMsg> errorDetail;
        ErrorResp.ErrorMsg errorMsg;
        if (error == null || TextUtils.isEmpty(str) || (errorDetail = error.getErrorDetail()) == null || errorDetail.isEmpty() || (errorMsg = errorDetail.get(0)) == null || TextUtils.isEmpty(errorMsg.getErrorCode())) {
            return false;
        }
        return str.equals(errorMsg.getErrorCode());
    }

    /* renamed from: C */
    public static void m6685C(Context context) {
        if (context == null) {
            C1120a.m6676e("AlbumUtil", "DeleteAlbumDot context is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Uri uri = f5355i;
            if (C0209d.m1227Y1(context, uri)) {
                C1120a.m6677i("AlbumUtil", "deleteAlbumDot code: " + contentResolver.delete(uri, null, null));
            }
        } catch (Exception unused) {
            C1120a.m6676e("AlbumUtil", "DeleteAlbumDot Exception");
        }
    }

    /* renamed from: C0 */
    public static String[] m6686C0() {
        HiCloudSysParamMap hiCloudSysParamMapM6839v0 = m6839v0();
        if (hiCloudSysParamMapM6839v0 == null) {
            C1120a.m6676e("AlbumUtil", "getOMAssetRefundStatus configMap is null");
            return new String[]{String.valueOf(2)};
        }
        String assetRefundStatus = hiCloudSysParamMapM6839v0.getAssetRefundStatus();
        C1120a.m6675d("AlbumUtil", "getOMAssetRefundStatus: " + assetRefundStatus);
        return TextUtils.isEmpty(assetRefundStatus) ? new String[]{String.valueOf(2)} : assetRefundStatus.split(",");
    }

    /* renamed from: C1 */
    public static boolean m6687C1(Context context) {
        C1120a.m6677i("AlbumUtil", "begin isSupportCloudFreqAndNewBusiness");
        if (context == null) {
            C1120a.m6676e("AlbumUtil", "isSupportCloudFreqAndNewBusiness context null");
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                C1120a.m6676e("AlbumUtil", "isSupportCloudFreqAndNewBusiness manager null");
                return false;
            }
            Bundle bundle = packageManager.getApplicationInfo(C13843a.m83054F(context), 128).metaData;
            if (bundle == null) {
                C1120a.m6676e("AlbumUtil", "isSupportCloudFreqAndNewBusiness metaData null");
                return false;
            }
            Object obj = bundle.get("albumFeatureSwitch");
            C1120a.m6677i("AlbumUtil", "albumFeatureSwitch obj " + obj);
            return (obj instanceof Integer) && (((Integer) obj).intValue() & 2) == 2;
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "isSupportCloudFreqAndNewBusiness Exception " + e10.toString());
            return false;
        }
    }

    /* renamed from: D */
    public static void m6688D(ArrayList<Album> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        C12947g c12947g = new C12947g();
        KvDatabaseWrapper kvDatabaseWrapperM72352f0 = C12091d.m72280a0().m72352f0();
        Iterator<Album> it = arrayList.iterator();
        while (it.hasNext()) {
            Album next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getId())) {
                m6694F(C1124e.m6871o(C0213f.m1377a()) + "/.cloudShare/thumb/headPic/" + (next.getId() + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT));
                String strM6782g0 = m6782g0(1, next.getId());
                String strM6782g02 = m6782g0(2, next.getId());
                m6697G(strM6782g0);
                m6697G(strM6782g02);
                int i10 = 0;
                ArrayList<Media> arrayListM77798K = c12947g.m77798K(next.getId(), 0, RippleView.SINGLE_RIPPLE_TIME);
                while (kvDatabaseWrapperM72352f0 != null && !arrayListM77798K.isEmpty()) {
                    m6700H(kvDatabaseWrapperM72352f0, arrayListM77798K);
                    i10 += 2000;
                    arrayListM77798K = c12947g.m77798K(next.getId(), i10, RippleView.SINGLE_RIPPLE_TIME);
                }
            }
        }
        c12947g.m77821i(arrayList);
    }

    /* renamed from: D0 */
    public static int m6689D0() {
        HiCloudSysParamMap hiCloudSysParamMapM6839v0 = m6839v0();
        if (hiCloudSysParamMapM6839v0 != null) {
            return hiCloudSysParamMapM6839v0.getAlbumSmartChargeLevel();
        }
        C1120a.m6676e("AlbumUtil", "getOMBatteryCharge configMap is null");
        return -1;
    }

    /* renamed from: D1 */
    public static boolean m6690D1(Context context) throws PackageManager.NameNotFoundException {
        C1120a.m6677i("AlbumUtil", "begin isSupportDisableAndResume");
        String strM6833t0 = m6833t0(context);
        C1120a.m6677i("AlbumUtil", "currentGalleryVersion: " + strM6833t0);
        if ("1100".equals(strM6833t0)) {
            C1120a.m6677i("AlbumUtil", "currentGalleryVersion invalid");
            return false;
        }
        String strM7107w = C1136q.b.m7107w(context);
        C1120a.m6677i("AlbumUtil", "galleryDisableVersion: " + strM7107w);
        if (TextUtils.isEmpty(strM7107w) || !strM7107w.equals(strM6833t0)) {
            boolean zM6714L1 = m6714L1(context, f5349c, new String[]{"is_support_disable"});
            C1136q.b.m7002G0(context, strM6833t0);
            C1136q.b.m7000F0(context, zM6714L1);
            return zM6714L1;
        }
        boolean zM7069j0 = C1136q.b.m7069j0(context);
        C1120a.m6677i("AlbumUtil", "galleryDisableVersion not change, galleryDisableSupport: " + zM7069j0);
        return zM7069j0;
    }

    /* renamed from: E */
    public static boolean m6691E(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists() && fileM63442h.isDirectory()) {
            File[] fileArrListFiles = fileM63442h.listFiles();
            if (fileArrListFiles != null) {
                boolean zM6691E = true;
                for (int i10 = 0; i10 < fileArrListFiles.length; i10++) {
                    if (fileArrListFiles[i10].isDirectory()) {
                        zM6691E = m6691E(C10279b.m63452a(fileArrListFiles[i10]));
                        if (!zM6691E) {
                            break;
                        }
                    } else {
                        zM6691E = m6694F(C10279b.m63452a(fileArrListFiles[i10]));
                        if (!zM6691E) {
                            break;
                        }
                    }
                }
                if (!zM6691E) {
                    return false;
                }
            }
            if (fileM63442h.delete()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: E0 */
    public static String m6692E0() {
        long j10;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int[] iArr = {-1};
        String[] strArr = {""};
        C11060c c11060cM6737T0 = m6737T0();
        long jM6680A0 = m6680A0(C0213f.m1377a()) * 4096 * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        if (jM6680A0 < 5368709120L) {
            C11839m.m70689w("AlbumUtil", "totalNeedSpace = " + jM6680A0 + ". reset the value.");
            j10 = 5368709120L;
        } else {
            j10 = jM6680A0;
        }
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setSalChannel("500");
        channelInfo.setSrcChannel("512");
        new C10220d0(new c(Looper.getMainLooper(), strArr, iArr, countDownLatch), c11060cM6737T0, 0, j10, 3, channelInfo).m63381g();
        try {
            if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                C11839m.m70686d("AlbumUtil", "getPackageId wait not finish");
            }
        } catch (InterruptedException unused) {
            C11839m.m70689w("AlbumUtil", "getPackageId syncLock wait catch InterruptedException.");
        }
        C11839m.m70688i("AlbumUtil", "getPackageId end, result = " + iArr[0]);
        C11839m.m70688i("AlbumUtil", "getPackageId end, packageId = " + strArr[0]);
        return iArr[0] == 0 ? strArr[0] : "";
    }

    /* renamed from: E1 */
    public static boolean m6693E1(Context context) {
        C1120a.m6677i("AlbumUtil", "begin isSupportDisableAndResumeV2");
        if (context == null) {
            C1120a.m6676e("AlbumUtil", "isSupportDisableAndResumeV2 context null");
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                C1120a.m6676e("AlbumUtil", "isSupportDisableAndResumeV2 manager null");
                return m6690D1(context);
            }
            Bundle bundle = packageManager.getApplicationInfo(C13843a.m83054F(context), 128).metaData;
            if (bundle == null) {
                C1120a.m6676e("AlbumUtil", "isSupportDisableAndResumeV2 metaData null");
                return m6690D1(context);
            }
            Object obj = bundle.get("albumFeatureSwitch");
            C1120a.m6677i("AlbumUtil", "albumFeatureSwitch obj " + obj);
            return obj instanceof Integer ? (((Integer) obj).intValue() & 1) == 1 : m6690D1(context);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "isSupportDisableAndResumeV2 Exception " + e10.toString());
            return m6690D1(context);
        }
    }

    /* renamed from: F */
    public static boolean m6694F(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.isFile() && fileM63442h.exists()) {
            return fileM63442h.delete();
        }
        return false;
    }

    /* renamed from: F0 */
    public static int m6695F0(int i10) {
        int iM6739U = m6739U() / i10;
        if (iM6739U > 40) {
            return iM6739U;
        }
        return 40;
    }

    /* renamed from: F1 */
    public static boolean m6696F1() throws ParseException {
        C1120a.m6677i("AlbumUtil", "checkTransDelay");
        boolean zM1289o1 = C0209d.m1289o1(f5366t, f5367u);
        C1120a.m6677i("AlbumUtil", "isInDelayTime: " + zM1289o1);
        return zM1289o1;
    }

    /* renamed from: G */
    public static boolean m6697G(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists()) {
            return fileM63442h.isFile() ? m6694F(str) : m6691E(str);
        }
        return false;
    }

    /* renamed from: G0 */
    public static long m6698G0(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = statFs.getBlockSize();
        long blockCount = statFs.getBlockCount();
        long availableBlocks = statFs.getAvailableBlocks();
        StringBuilder sb2 = new StringBuilder("getPathAvailSize block size: ");
        sb2.append(blockSize);
        sb2.append(", block num: ");
        sb2.append(blockCount);
        sb2.append(", total size: ");
        sb2.append((blockCount * blockSize) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        sb2.append("KB");
        sb2.append(", available block num:");
        sb2.append(availableBlocks);
        sb2.append(", available size: ");
        long j10 = availableBlocks * blockSize;
        sb2.append(j10 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        sb2.append("KB");
        C1120a.m6675d("AlbumUtil", sb2.toString());
        return j10;
    }

    /* renamed from: G1 */
    public static boolean m6699G1(C4616s c4616s) {
        return m6802l0(c4616s) == 4946;
    }

    /* renamed from: H */
    public static void m6700H(KvDatabaseWrapper kvDatabaseWrapper, ArrayList<Media> arrayList) {
        Iterator<Media> it = arrayList.iterator();
        while (it.hasNext()) {
            Media next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getId())) {
                kvDatabaseWrapper.m30075f(next.getId());
            }
        }
    }

    /* renamed from: H0 */
    public static String m6701H0() {
        return Build.MODEL;
    }

    /* renamed from: H1 */
    public static /* synthetic */ void m6702H1(Activity activity) {
        C11841o.m70706b(activity, activity.getString(R$string.album_system_busy), 0);
    }

    /* renamed from: I */
    public static void m6703I(List<Media> list) {
        Media mediaM77802O;
        if (list == null || list.isEmpty()) {
            return;
        }
        C12947g c12947g = new C12947g();
        KvDatabaseWrapper kvDatabaseWrapperM72352f0 = C12091d.m72280a0().m72352f0();
        for (Media media : list) {
            if (media != null && !TextUtils.isEmpty(media.getId()) && (mediaM77802O = c12947g.m77802O(media.getId())) != null) {
                m6694F(mediaM77802O.getLocalThumbPath());
                m6694F(mediaM77802O.getLocalBigThumbPath());
                if (kvDatabaseWrapperM72352f0 != null) {
                    kvDatabaseWrapperM72352f0.m30075f(mediaM77802O.getId());
                }
            }
        }
    }

    /* renamed from: I0 */
    public static String m6704I0() {
        return Integer.toString(Process.myPid()) + "_" + CloudAlbumSettings.m14363h().m14370e();
    }

    /* renamed from: I1 */
    public static boolean m6705I1(Album album) {
        if (album == null) {
            return true;
        }
        return album.getShareType().intValue() == 1 && !CloudAlbumSettings.m14363h().m14373i();
    }

    /* renamed from: J */
    public static void m6706J(Context context) {
        if (context == null) {
            C1120a.m6676e("AlbumUtil", "deleteSyncState context is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Uri uri = f5354h;
            if (C0209d.m1227Y1(context, uri)) {
                C1120a.m6677i("AlbumUtil", "deleteSyncState code: " + contentResolver.delete(uri, null, null));
            }
        } catch (Exception unused) {
            C1120a.m6676e("AlbumUtil", "deleteSyncState Exception");
        }
    }

    /* renamed from: J0 */
    public static String m6707J0() {
        return String.valueOf(new Random().nextInt(90000000) + ExceptionCode.CRASH_EXCEPTION);
    }

    /* renamed from: J1 */
    public static boolean m6708J1() {
        return C13452e.m80781L().m80791C0() && C1136q.m6977r() == 0 && (C1136q.m6976q() == 1 || C1136q.m6976q() == 2);
    }

    /* renamed from: K */
    public static List<Permission> m6709K(List<Permission> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Permission permission : list) {
            if (permission != null && permission.getStatus() != null && permission.getStatus().intValue() == 1) {
                arrayList.add(permission);
            }
        }
        return arrayList;
    }

    /* renamed from: K0 */
    public static String m6710K0() {
        return C0213f.m1377a().getFilesDir() + "/album_refund/";
    }

    /* renamed from: K1 */
    public static void m6711K1(String str) {
        MsgUserData msgUserData = new MsgUserData();
        msgUserData.setNotifyType(str);
        try {
            C1120a.m6675d("AlbumUtil", "==================== notifyType : " + str);
            new NotifyService().queryEventV2(str, new Gson().toJson(msgUserData));
            m6744V1(str);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "invokeEvent exception, e: " + e10.toString());
        }
    }

    /* renamed from: L */
    public static void m6712L(Context context) {
        C1120a.m6677i("AlbumUtil", "forceStartSync");
        m6793j(context, f5356j, "notifyGalleryChange", null);
    }

    /* renamed from: L0 */
    public static String m6713L0(String str, boolean z10) {
        if (z10) {
            return "001_" + str + ":1";
        }
        return "101_" + str + ":1";
    }

    /* renamed from: L1 */
    public static boolean m6714L1(Context context, Uri uri, String[] strArr) {
        if (strArr == null || strArr.length != 1) {
            return false;
        }
        try {
            try {
                cursorQuery = C0209d.m1227Y1(context, uri) ? context.getContentResolver().query(uri, null, "featureName = ?", strArr, null) : null;
                if (cursorQuery == null) {
                    C1120a.m6678w("AlbumUtil", "queryGallery is null");
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                    C1120a.m6677i("AlbumUtil", strArr[0] + " = " + string);
                    if (string.contains(FaqConstants.DISABLE_HA_REPORT)) {
                        cursorQuery.close();
                        return true;
                    }
                }
                cursorQuery.close();
                return false;
            } catch (Exception e10) {
                C1120a.m6676e("AlbumUtil", "queryGallery Exception:" + e10.toString());
                if (0 != 0) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: M */
    public static String m6715M(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        int i11 = i10 / 1000;
        int i12 = i11 % 60;
        int i13 = i11 / 60;
        int i14 = i11 / AsCache.TIME_HOUR;
        return i14 > 0 ? String.format(Locale.ENGLISH, "%d:%02d:%02d", Integer.valueOf(i14), Integer.valueOf(i13 % 60), Integer.valueOf(i12)) : String.format(Locale.ENGLISH, "%02d:%02d", Integer.valueOf(i13), Integer.valueOf(i12));
    }

    /* renamed from: M0 */
    public static int m6716M0(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
            if (attributeInt == 1) {
                return 0;
            }
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return -1;
            }
            return Constants.INTERSTITIAL_WIDTH;
        } catch (IOException e10) {
            C1120a.m6676e("AlbumUtil", "rotateBitmapForJPG err: " + e10.toString());
            return -1;
        } catch (NumberFormatException e11) {
            C1120a.m6676e("AlbumUtil", "rotateBitmapForJPG NumberFormatException err: " + e11.toString());
            return -1;
        }
    }

    /* renamed from: M1 */
    public static boolean m6717M1(Context context) {
        C1120a.m6677i("AlbumUtil", "begin queryGallerySwitchStatus");
        Boolean bool = (Boolean) C0077o.m632b().m633a(new b(context), 5, TimeUnit.SECONDS);
        return bool != null && bool.booleanValue();
    }

    /* renamed from: N */
    public static String m6718N(Context context, long j10) {
        String string;
        if (context == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.applyPattern("0.##");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        float f10 = j10;
        int i10 = C11829c.f54756b ? 1000 : 1024;
        int i11 = R$string.main_space_display_B;
        if (f10 > 900.0f) {
            i11 = R$string.main_space_display_KB;
            f10 /= i10;
        }
        if (f10 > 900.0f) {
            f10 /= i10;
            i11 = R$string.main_space_display_MB;
        }
        if (f10 > 900.0f) {
            f10 /= i10;
            i11 = R$string.main_space_display_GB;
        }
        try {
            string = context.getString(i11, C13843a.m83104z(Double.valueOf(decimalFormat.format(f10))));
        } catch (Exception unused) {
            C11839m.m70687e("AlbumUtil", "formatSpace exception");
            string = context.getString(i11, decimalFormat.format(f10));
        }
        return C13843a.m83087i(string);
    }

    /* renamed from: N0 */
    public static Bitmap m6719N0(Bitmap bitmap, int i10) {
        if (bitmap == null) {
            C1120a.m6678w("AlbumUtil", "bitmap is null");
            return null;
        }
        try {
            C1120a.m6675d("AlbumUtil", "getRotationChangedBitmap rotationId = " + i10);
            Matrix matrix = new Matrix();
            if (i10 == 3) {
                matrix.postRotate(180.0f);
            } else if (i10 == 6) {
                matrix.postRotate(90.0f);
            } else {
                if (i10 != 8) {
                    return bitmap;
                }
                matrix.postRotate(270.0f);
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "getRotationChangedBitmap error: " + e10.toString());
            return bitmap;
        }
    }

    /* renamed from: N1 */
    public static void m6720N1(FileInfo fileInfo, JSONObject jSONObject) {
        if (CloudAlbumSettings.m14363h().m14378n()) {
            return;
        }
        if (jSONObject.has(SyncProtocol.Constant.DEK)) {
            jSONObject.remove(SyncProtocol.Constant.DEK);
        }
        if (jSONObject.has("positionDEK")) {
            jSONObject.remove("positionDEK");
        }
        if (jSONObject.has("createrAccountDEK")) {
            jSONObject.remove("createrAccountDEK");
        }
        fileInfo.setExpand(jSONObject.toString());
    }

    /* renamed from: O */
    public static String m6721O(long j10) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(j10));
    }

    /* renamed from: O0 */
    public static int m6722O0(int i10) {
        if (i10 == 90) {
            return 6;
        }
        if (i10 != 180) {
            return i10 != 270 ? 1 : 8;
        }
        return 3;
    }

    /* renamed from: O1 */
    public static void m6723O1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<MediaFileBean> list = f5342A.get(str);
        if (list != null) {
            list.clear();
        }
        f5342A.remove(str);
    }

    /* renamed from: P */
    public static String m6724P(long j10) {
        return DateUtilsEx.formatChinaDateTime(C0213f.m1377a(), j10, 65557);
    }

    /* renamed from: P0 */
    public static String m6725P0(Context context) {
        if (context == null) {
            C1120a.m6676e("AlbumUtil", "getScreenStatus context is null");
            return "context is null";
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return String.valueOf(powerManager.isInteractive());
        }
        C1120a.m6676e("AlbumUtil", "getScreenStatus pm is null");
        return "pm is null";
    }

    /* renamed from: P1 */
    public static String m6726P1(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (TextUtils.isEmpty(str) || str.equals(HNConstants.DataType.f22634NA) || str.equals(str2)) {
            return HNConstants.DataType.f22634NA;
        }
        if (!str.contains(str2)) {
            return str;
        }
        String[] strArrSplit = str.split("\\|");
        StringBuilder sb2 = new StringBuilder();
        for (String str3 : strArrSplit) {
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                sb2.append(str3);
                sb2.append("|");
            }
        }
        String string = sb2.toString();
        return TextUtils.isEmpty(string) ? HNConstants.DataType.f22634NA : string.substring(0, string.length() - 1);
    }

    /* renamed from: Q */
    public static String m6727Q(String str, JSONObject jSONObject, DataDecryptReq dataDecryptReq) throws JSONException {
        if (!jSONObject.has("createrAccount")) {
            return str;
        }
        String string = jSONObject.getString("createrAccount");
        if (!CloudAlbumSettings.m14363h().m14378n()) {
            return string;
        }
        dataDecryptReq.setSrcData(string);
        try {
            return C10466a.m64316g(dataDecryptReq);
        } catch (C9721b e10) {
            C1120a.m6676e("AlbumUtil", "createrAccount decrypt data error: " + e10.getMessage());
            return string;
        }
    }

    /* renamed from: Q0 */
    public static String m6728Q0(String str) throws UnknownHostException {
        String hostAddress = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Map<String, String> map = f5372z;
        if (map.containsKey(str)) {
            hostAddress = map.get(str);
            if (!TextUtils.isEmpty(hostAddress)) {
                return hostAddress;
            }
        }
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName.length > 0) {
                hostAddress = allByName[0].getHostAddress();
            }
            map.put(str, hostAddress);
            return hostAddress;
        } catch (UnknownHostException e10) {
            C1120a.m6676e("AlbumUtil", "getSserverIP " + e10.toString());
            return hostAddress;
        }
    }

    /* renamed from: Q1 */
    public static String m6729Q1(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("..\\")) {
            str = str.replace("..\\", "");
        }
        if (!TextUtils.isEmpty(str) && str.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
            str = str.replace(FeedbackWebConstants.INVALID_FILE_NAME_PRE, "");
        }
        return (TextUtils.isEmpty(str) || !str.contains("./")) ? str : str.replace("./", "");
    }

    /* renamed from: R */
    public static Activity m6730R(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* renamed from: R0 */
    public static int m6731R0(String str) {
        if (TextUtils.isEmpty(str)) {
            return 101;
        }
        if (str.length() >= 8) {
            str = str.substring(str.length() - 4);
        }
        return C0241z.m1686d(str, 101);
    }

    /* renamed from: R1 */
    public static String m6732R1(String str) {
        Map<String, String> mapM6766c0 = m6766c0();
        StringBuilder sb2 = new StringBuilder();
        String strM6729Q1 = m6729Q1(str);
        if (strM6729Q1 == null) {
            return null;
        }
        for (char c10 : strM6729Q1.toCharArray()) {
            if (mapM6766c0.get(c10 + "") == null) {
                sb2.append(c10);
            }
        }
        return sb2.toString();
    }

    /* renamed from: S */
    public static int m6733S() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            return 7;
        }
        int albumClientClearInterval = hiCloudSysParamMapM60757p.getAlbumClientClearInterval();
        C1120a.m6677i("AlbumUtil", "hiCloudSysParamMap clearInterval " + albumClientClearInterval);
        return albumClientClearInterval;
    }

    /* renamed from: S0 */
    public static Bitmap m6734S0(Bitmap bitmap, int i10, int i11) {
        try {
            C1120a.m6675d("AlbumUtil", "getSizedBitmap showWidth = " + i10 + " , showHeight = " + i11);
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f10 = ((float) i10) / ((float) width);
            float f11 = ((float) i11) / ((float) height);
            if (f10 >= 1.0f || f11 >= 1.0f) {
                return bitmap;
            }
            matrix.postScale(Math.max(f10, f11), Math.max(f10, f11));
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "getSizedBitmap error: " + e10.toString());
            return bitmap;
        }
    }

    /* renamed from: S1 */
    public static boolean m6735S1(String str, String str2) {
        if (str == null || str2 == null) {
            C1120a.m6676e("AlbumUtil", "renameFileName path is not available.");
            return false;
        }
        File fileM63442h = C10278a.m63442h(str2);
        File fileM63442h2 = C10278a.m63442h(str);
        if (!fileM63442h2.exists()) {
            C1120a.m6676e("AlbumUtil", "renameFileName oldFile is not exist.");
            return false;
        }
        boolean zM70654r = C11835i.m70654r(fileM63442h2, fileM63442h);
        if (!zM70654r) {
            C1120a.m6676e("AlbumUtil", "moveFile from " + fileM63442h2 + " to " + str2 + " fail.");
        }
        return zM70654r;
    }

    /* renamed from: T */
    public static List<MediaFileBean> m6736T(String str) {
        Lock lock = f5344C;
        lock.lock();
        try {
            List<MediaFileBean> list = f5342A.get(str);
            lock.unlock();
            return list;
        } catch (Throwable th2) {
            f5344C.unlock();
            throw th2;
        }
    }

    /* renamed from: T0 */
    public static C11060c m6737T0() {
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        return c11060c;
    }

    /* renamed from: T1 */
    public static void m6738T1(Context context, String str) {
        if (context == null) {
            return;
        }
        if (System.currentTimeMillis() - C1136q.b.m7059g(context) < 86400000) {
            C1120a.m6677i("AlbumUtil", "reportAuthFailed in interval, ignore");
            return;
        }
        C1136q.b.m7100t1(context, System.currentTimeMillis());
        String strSubstring = "04001";
        if (TextUtils.isEmpty(str)) {
            str = m6755Z0("04001");
        } else if (str.length() > 5) {
            strSubstring = str.substring(0, 5);
        }
        m6750X1(context, "001_3004:1", "cloud album st invalid", strSubstring, "reportAuthFailed", str, false);
    }

    /* renamed from: U */
    public static int m6739U() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            return 2000;
        }
        int albumClientPreloadCount = hiCloudSysParamMapM60757p.getAlbumClientPreloadCount();
        C1120a.m6677i("AlbumUtil", "hiCloudSysParamMap pre download number " + albumClientPreloadCount);
        return albumClientPreloadCount;
    }

    /* renamed from: U0 */
    public static String m6740U0(String str) {
        return TextUtils.isEmpty(str) ? "" : str.length() > 4 ? SafeString.substring(str, str.length() - 4) : str;
    }

    /* renamed from: U1 */
    public static void m6741U1() {
        C12515a.m75110o().m75175e(new d(null), false);
    }

    /* renamed from: V */
    public static PackageInfo m6742V(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo = null;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "getAppPkgInfo exception:" + e10.toString());
        }
        if (packageManager == null) {
            C1120a.m6676e("AlbumUtil", "getAppPkgInfo manager is null");
            return null;
        }
        packageInfo = packageManager.getPackageInfo(str, 0);
        if (packageInfo != null) {
            C1120a.m6675d("AlbumUtil", "getAppPkgInfo pkgName:" + packageInfo.packageName + ", applicationInfo name: " + packageInfo.applicationInfo.name + ", versionName: " + packageInfo.versionName + ", versionCode: " + packageInfo.versionCode);
        }
        return packageInfo;
    }

    /* renamed from: V0 */
    public static String m6743V0(String str, int i10) {
        return TextUtils.isEmpty(str) ? "" : str.length() > i10 ? SafeString.substring(str, str.length() - i10) : str;
    }

    /* renamed from: V1 */
    public static void m6744V1(String str) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_NOTICE_TYPE, str);
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07008"), "07008", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B(NotifyConstants.NotificationReport.OPERATION_NAME_INVOKE_NOTIFY_EVENT);
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "reportOMEvent exception:" + e10.toString());
        }
    }

    /* renamed from: W */
    public static String m6745W() {
        String strM78625Q;
        try {
            strM78625Q = C13040c.m78609F().m78625Q();
        } catch (C9721b e10) {
            C1442a.m8291w("AlbumUtil", "getAutoRenewal error= " + e10.toString());
            strM78625Q = null;
        }
        if (TextUtils.isEmpty(strM78625Q)) {
            strM78625Q = "";
        }
        return strM78625Q + "/payagreement?lang=" + C0234s.m1627e();
    }

    /* renamed from: W0 */
    public static Bundle m6746W0(Context context) {
        Bundle bundle = new Bundle();
        if (context == null) {
            C1120a.m6676e("AlbumUtil", "getSyncStateBundle context is null");
            return bundle;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            try {
                Uri uri = f5353g;
                cursorQuery = C0209d.m1227Y1(context, uri) ? contentResolver.query(uri, null, null, null, null) : null;
                if (cursorQuery == null) {
                    C1120a.m6678w("AlbumUtil", "getSyncStateBundle cursor is null");
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return bundle;
                }
                cursorQuery.moveToPosition(0);
                int i10 = cursorQuery.getInt(cursorQuery.getColumnIndex("sync_state"));
                cursorQuery.moveToPosition(1);
                int i11 = cursorQuery.getInt(cursorQuery.getColumnIndex("sync_state"));
                cursorQuery.moveToPosition(2);
                long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex("sync_state"));
                C1120a.m6677i("AlbumUtil", "getSyncStateBundle syncStateCode: " + i10 + ", syncStopCode: " + i11 + ", latestSyncTime: " + j10);
                Bundle bundleM60391c = C9673j.m60391c(context, i10, i11, j10);
                cursorQuery.close();
                return bundleM60391c;
            } catch (Exception e10) {
                C1120a.m6676e("AlbumUtil", "getSyncStateBundle Exception:" + e10.toString());
                if (0 != 0) {
                    cursorQuery.close();
                }
                return bundle;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: W1 */
    public static void m6747W1(Context context, String str, String str2, String str3, String str4, String str5) {
        m6750X1(context, str, str2, str3, str4, str5, false);
    }

    /* renamed from: X */
    public static String m6748X(Context context) {
        return (C1136q.b.m7023R(context).booleanValue() ? 1 : 0) + ":" + C1136q.b.m7077m(context) + "_" + C1136q.b.m7074l(context) + "_" + C1136q.b.m7080n(context);
    }

    /* renamed from: X0 */
    public static String m6749X0() {
        return C0209d.m1315v();
    }

    /* renamed from: X1 */
    public static void m6750X1(Context context, String str, String str2, String str3, String str4, String str5, boolean z10) {
        if (!m6843w1(context)) {
            C1120a.m6675d("AlbumUtil", "user experience involved");
        } else {
            if (TextUtils.isEmpty(str5) || context == null) {
                return;
            }
            m6772d2(context, str5, m6790i0(context, str, str2, str3, str4, str5, z10));
        }
    }

    /* renamed from: Y */
    public static String m6751Y(Bundle bundle) {
        StringBuilder sb2 = new StringBuilder(128);
        if (bundle == null) {
            C1120a.m6676e("AlbumUtil", "bundle is null");
            return "";
        }
        for (String str : bundle.keySet()) {
            sb2.append(str);
            sb2.append("=");
            sb2.append(bundle.get(str));
            sb2.append(";");
        }
        return sb2.toString();
    }

    /* renamed from: Y0 */
    public static int m6752Y0() {
        HiCloudSysParamMap hiCloudSysParamMapM6839v0 = m6839v0();
        if (hiCloudSysParamMapM6839v0 != null) {
            return hiCloudSysParamMapM6839v0.getCloudPhotoThumbFixMaxSize();
        }
        C1120a.m6676e("AlbumUtil", "getThumbFixMaxSize configMap is null");
        return 5000;
    }

    /* renamed from: Y1 */
    public static void m6753Y1(Context context, String str, String str2, String str3, String str4, String str5, boolean z10, LinkedHashMap<String, String> linkedHashMap) {
        if (!m6843w1(context)) {
            C1120a.m6675d("AlbumUtil", "user experience involved");
            return;
        }
        if (TextUtils.isEmpty(str5) || context == null) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM6790i0 = m6790i0(context, str, str2, str3, str4, str5, z10);
        if (linkedHashMapM6790i0 != null && linkedHashMap != null) {
            for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
                linkedHashMapM6790i0.put(entry.getKey(), entry.getValue());
            }
        }
        m6772d2(context, str5, linkedHashMapM6790i0);
    }

    /* renamed from: Z */
    public static String m6754Z(int i10) {
        try {
            C1120a.m6675d("AlbumUtil", "getCheckDirResult");
            String strM6866j = C1124e.m6866j();
            if (TextUtils.isEmpty(strM6866j)) {
                return "innerRootPath empty";
            }
            File fileM63442h = C10278a.m63442h(strM6866j + "/.photoShare/");
            if (fileM63442h.exists() && !fileM63442h.isFile()) {
                File fileM63442h2 = C10278a.m63442h(strM6866j + "/.photoShare/thumb/");
                if (fileM63442h2.exists() && !fileM63442h2.isFile()) {
                    if (i10 == 0) {
                        File fileM63442h3 = C10278a.m63442h(strM6866j + "/Pictures/hiddenAlbum/.tmp/");
                        return (!fileM63442h3.exists() || fileM63442h3.isFile()) ? "/Pictures/hiddenAlbum/.tmp/ not exist or is file" : "OK";
                    }
                    if (i10 == 1) {
                        File fileM63442h4 = C10278a.m63442h(strM6866j + "/.photoShare/thumb/lcd/");
                        return (!fileM63442h4.exists() || fileM63442h4.isFile()) ? "/.photoShare/thumb/lcd/ not exist or is file" : "OK";
                    }
                    if (i10 != 2) {
                        return "OK";
                    }
                    File fileM63442h5 = C10278a.m63442h(strM6866j + "/.photoShare/thumb/thumb/");
                    return (!fileM63442h5.exists() || fileM63442h5.isFile()) ? "/.photoShare/thumb/thumb/ not exist or is file" : "OK";
                }
                return "/.photoShare/thumb/ not exist or is file";
            }
            return "/.photoShare/ not exist or is file";
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "getCheckDirResult error " + e10);
            return "getCheckDirResult error";
        }
    }

    /* renamed from: Z0 */
    public static String m6755Z0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str + "_" + HiAnalyticsConstant.KeyAndValue.NUMBER_01 + "_" + (System.currentTimeMillis() / 1000) + "_" + m6707J0();
    }

    /* renamed from: Z1 */
    public static void m6756Z1() {
        C1120a.m6677i("AlbumUtil", "reportPowerUsage");
        Context contextM1377a = C0213f.m1377a();
        if (C0070h.m527v().m541N()) {
            C1120a.m6677i("AlbumUtil", "data is cleared not report");
            return;
        }
        try {
            Uri uriM83100v = C13843a.m83100v();
            if (C0209d.m1227Y1(contextM1377a, uriM83100v)) {
                if (m6789i(contextM1377a, uriM83100v, "report_power_usage", null, m6767c1()) == null) {
                    C1120a.m6675d("AlbumUtil", "reportPowerUsage report_power_usage is null");
                }
                C0070h.m527v().m569k(contextM1377a);
            }
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "reportPowerUsage Exception:" + e10.toString());
        }
    }

    /* renamed from: a0 */
    public static String m6758a0() {
        return "hasPermission = " + C0229n.m1608g("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
    }

    /* renamed from: a1 */
    public static String m6759a1(String str) {
        return C1124e.m6866j() + "/.photoShare/uploadCache/" + str;
    }

    /* renamed from: a2 */
    public static void m6760a2(Context context, boolean z10, int i10) {
        m6750X1(context, "0:1", z10 + "_" + i10, "04011", "album_switch_status", m6755Z0("04011"), false);
    }

    /* renamed from: b0 */
    public static int m6762b0(IOException iOException) {
        if (!(iOException instanceof C4616s)) {
            return 0;
        }
        C4616s c4616s = (C4616s) iOException;
        if (TextUtils.isEmpty(c4616s.m28319c())) {
            return 0;
        }
        String strM59436d = C9499a.m59436d(c4616s.m28319c(), VastAttribute.ERROR);
        if (TextUtils.isEmpty(strM59436d)) {
            return 0;
        }
        String strM59436d2 = C9499a.m59436d(strM59436d, "errorData");
        if (TextUtils.isEmpty(strM59436d2)) {
            return 0;
        }
        return C9499a.m59435c(strM59436d2, "clearDataScene", 0);
    }

    /* renamed from: b1 */
    public static String m6763b1(FileInfo fileInfo) {
        if (fileInfo == null) {
            C1120a.m6676e("AlbumUtil", "getUploadCompressPath fileInfo is null");
            return "";
        }
        return m6759a1(fileInfo.getAlbumId()) + File.separator + m6822q0(fileInfo.getLocalRealPath());
    }

    /* renamed from: b2 */
    public static void m6764b2(int i10, boolean z10) {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put(RemoteMessageConst.FROM, String.valueOf(i10));
        linkedHashMapM79499C.put("isOpenSwitch", String.valueOf(z10));
        C13224c.m79487f1().m79567R("album_openswitch_open_info", linkedHashMapM79499C);
        UBAAnalyze.m29947H("PVC", "album_openswitch_open_info", linkedHashMapM79499C);
    }

    /* renamed from: c */
    public static void m6765c(int i10, FileInfo fileInfo) {
        String strM70401f = C11820b.m70401f(fileInfo.getAlbumId(), fileInfo.getUniqueId(), i10);
        Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM70401f, 5);
        SyncSessionManager.m15153t().m15166M(strM70401f, Integer.valueOf(numM15193q != null ? 1 + numM15193q.intValue() : 1), 5);
    }

    /* renamed from: c0 */
    public static Map<String, String> m6766c0() {
        HashMap map = new HashMap();
        map.put("\"", "\"");
        map.put("\\", "\\");
        map.put(":", ":");
        map.put("*", "*");
        map.put(Constants.QUESTION_STR, Constants.QUESTION_STR);
        map.put("<", "<");
        map.put(">", ">");
        map.put("|", "|");
        return map;
    }

    /* renamed from: c1 */
    public static Bundle m6767c1() {
        Bundle bundle = new Bundle();
        bundle.putLong("startTime", C0070h.m527v().m532E());
        bundle.putLong("normalizedUsage", C0070h.m527v().m590w());
        bundle.putLong("realUsage", C0070h.m527v().m528A());
        bundle.putLong("lastUpdateTime", C0070h.m527v().m591x());
        bundle.putInt("netType", C0070h.m527v().m593z());
        bundle.putInt("usedUploadTime", C0070h.m527v().m533F());
        C1120a.m6677i("AlbumUtil", "getUsedPower: " + m6751Y(bundle));
        return bundle;
    }

    /* renamed from: c2 */
    public static void m6768c2() {
        C1120a.m6677i("AlbumUtil", "reportUserIdChanged");
        new CommonOpsReport(C0213f.m1377a()).m15209C(m6755Z0("04001"), "user_id_changed", 0, "success");
    }

    /* renamed from: d */
    public static String m6769d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (TextUtils.isEmpty(str) || str.equals(HNConstants.DataType.f22634NA)) {
            return str2;
        }
        if (str.contains(str2)) {
            return str;
        }
        return str + "|" + str2;
    }

    /* renamed from: d0 */
    public static int m6770d0() {
        HiCloudSysParamMap hiCloudSysParamMapM6839v0 = m6839v0();
        if (hiCloudSysParamMapM6839v0 != null) {
            return hiCloudSysParamMapM6839v0.getCloudPhotoAssetRefundPeriod();
        }
        C1120a.m6676e("AlbumUtil", "getCloudPhotoAssetRefundPeriod configMap is null");
        return 7;
    }

    /* renamed from: d1 */
    public static boolean m6771d1(int i10) {
        return i10 == 1 || i10 == 2 || i10 == 4;
    }

    /* renamed from: d2 */
    public static void m6772d2(Context context, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (context == null) {
            C1120a.m6676e("AlbumUtil", "safeReportEvent context is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("AlbumUtil", "safeReportEvent eventID is invalid");
            return;
        }
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            C1120a.m6676e("AlbumUtil", "safeReportEvent map is invalid");
            return;
        }
        try {
            C13224c.m79487f1().m79573U(str, linkedHashMap);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "safeReportEvent error is " + e10.toString());
        }
    }

    /* renamed from: e */
    public static String m6773e(String str) {
        try {
            return new String(Base64.encode(str.getBytes(Charset.forName(Constants.UTF_8)), 2), "ASCII");
        } catch (UnsupportedEncodingException e10) {
            C1120a.m6676e("AlbumUtil", "ASCII is not supported:" + e10.toString());
            return null;
        }
    }

    /* renamed from: e0 */
    public static String m6774e0() {
        if (!C10028c.m62182c0().m62221H1()) {
            C1120a.m6678w("AlbumUtil", "getCloudPhotoDriveDomain return empty as terms is not confirmed ");
            return "";
        }
        try {
            C1120a.m6675d("AlbumUtil", "start getCloudPhotoDriveDomain get cloud album url");
            return C13040c.m78609F().m78668u();
        } catch (C9721b e10) {
            C1120a.m6676e("AlbumUtil", "getCloudPhotoDriveDomain get cloud album url error ," + e10.toString());
            return "";
        }
    }

    /* renamed from: e1 */
    public static boolean m6775e1(Context context) {
        int iM7074l = C1136q.b.m7074l(context);
        if (iM7074l >= 10) {
            return false;
        }
        C1120a.m6678w("AlbumUtil", "low battery: " + iM7074l);
        return true;
    }

    /* renamed from: e2 */
    public static void m6776e2(String str, List<MediaFileBean> list) {
        Lock lock = f5345D;
        lock.lock();
        try {
            f5342A.put(str, list);
            lock.unlock();
        } catch (Throwable th2) {
            f5345D.unlock();
            throw th2;
        }
    }

    /* renamed from: f */
    public static void m6777f(Context context, long j10, boolean z10, boolean z11) {
        C1120a.m6677i("AlbumUtil", "broadcastNotify totalNeedSpace:" + j10 + " isSpaceNotEnough:" + z10);
        long jM7089q = C1136q.b.m7089q(context, "userCapacityTotal");
        long jM7089q2 = C1136q.b.m7089q(context, "userCapacityUsed");
        if (j10 <= jM7089q && z10) {
            j10 = (j10 > jM7089q2 ? j10 - jM7089q2 : 1L) + jM7089q;
        }
        if (z10) {
            C13224c.m79487f1().m79585f0("mecloud_cloudphotospace_not_enough_sync_fail", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29943D("CKC", "mecloud_cloudphotospace_not_enough_sync_fail");
            C0237v.m1661c();
        }
        Intent intent = new Intent("com.huawei.hicloud.intent.action.ALBUM_SYNC_NOTIFY");
        intent.putExtra("totalNeedSpace", j10);
        intent.putExtra("isSpaceNotEnough", z10);
        intent.putExtra("isAutoSync", z11);
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: f0 */
    public static String m6778f0() {
        return C1124e.m6871o(C0213f.m1377a()) + "/.cloudShare";
    }

    /* renamed from: f1 */
    public static Media m6779f1(Media media) {
        Media mediaM6924d;
        if (media == null) {
            return null;
        }
        return (m6819p1(media) && media.containsKey("id") && (mediaM6924d = C1132m.m6921c().m6924d(media.getId())) == null) ? mediaM6924d : media;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00e8 A[Catch: JSONException -> 0x011a, TryCatch #1 {JSONException -> 0x011a, blocks: (B:66:0x0016, B:68:0x0024, B:70:0x002f, B:72:0x003f, B:73:0x0043, B:75:0x004e, B:76:0x0055, B:78:0x005f, B:80:0x0065, B:82:0x006b, B:84:0x0072, B:86:0x007a, B:88:0x0088, B:108:0x00e2, B:110:0x00e8, B:112:0x00f2, B:114:0x00f8, B:116:0x00fe, B:106:0x00c6), top: B:122:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00f8 A[Catch: JSONException -> 0x011a, TryCatch #1 {JSONException -> 0x011a, blocks: (B:66:0x0016, B:68:0x0024, B:70:0x002f, B:72:0x003f, B:73:0x0043, B:75:0x004e, B:76:0x0055, B:78:0x005f, B:80:0x0065, B:82:0x006b, B:84:0x0072, B:86:0x007a, B:88:0x0088, B:108:0x00e2, B:110:0x00e8, B:112:0x00f2, B:114:0x00f8, B:116:0x00fe, B:106:0x00c6), top: B:122:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00fd  */
    /* renamed from: f2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m6780f2(com.huawei.android.p069cg.p072vo.FileInfo r18, java.lang.String r19) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p031b7.C1122c.m6780f2(com.huawei.android.cg.vo.FileInfo, java.lang.String):void");
    }

    /* renamed from: g */
    public static String m6781g(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    /* renamed from: g0 */
    public static String m6782g0(int i10, String str) {
        if (1 == i10) {
            return C1124e.m6871o(C0213f.m1377a()) + "/.cloudShare/thumb/lcd/" + str;
        }
        if (2 == i10) {
            return C1124e.m6871o(C0213f.m1377a()) + "/.cloudShare/thumb/thumb/" + str;
        }
        C1120a.m6676e("AlbumUtil", "getCloudThumbCacheFolder invalid: " + i10);
        return "";
    }

    /* renamed from: g1 */
    public static boolean m6783g1(int i10, int i11, int i12) {
        return i10 == 2 || i10 == 5 || m6846x1(i11, i12);
    }

    /* renamed from: g2 */
    public static void m6784g2(Media media, MediaFileBean mediaFileBean) {
        if (media.getFileType().intValue() != 4) {
            mediaFileBean.m14323a0(4);
            return;
        }
        mediaFileBean.m14323a0(5);
        if (media.getVideoMetaData() != null) {
            mediaFileBean.m14315R(r2.getDurationTime().intValue());
            mediaFileBean.m14343n().m68388B(true);
        }
    }

    /* renamed from: h */
    public static Bundle m6785h(Context context, Uri uri, String str, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Bundle bundleCall = null;
        try {
            if (C0209d.m1227Y1(context, uri)) {
                bundleCall = contentResolver.call(uri, str, (String) null, bundle);
            }
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "callGallery Exception:" + e10.toString());
        }
        if (bundleCall == null) {
            C1120a.m6678w("AlbumUtil", "callGallery is null");
        }
        return bundleCall;
    }

    /* renamed from: h0 */
    public static String m6786h0(int i10, String str, String str2) {
        if (1 == i10) {
            return C1124e.m6871o(C0213f.m1377a()) + "/.cloudShare/thumb/lcd/" + str + File.separator + str2;
        }
        if (2 == i10) {
            return C1124e.m6871o(C0213f.m1377a()) + "/.cloudShare/thumb/thumb/" + str + File.separator + str2;
        }
        if (i10 != 0) {
            C1120a.m6676e("AlbumUtil", "getCloudThumbRelativePath invalid: " + i10);
            return "";
        }
        return C1124e.m6871o(C0213f.m1377a()) + "/.cloudShare/thumb/cloudShareDownload/" + str + File.separator + str2;
    }

    /* renamed from: h1 */
    public static boolean m6787h1(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            C1120a.m6678w("AlbumUtil", "intent is null.");
            return false;
        }
        try {
            return m6783g1(intentRegisterReceiver.getIntExtra("status", 1), intentRegisterReceiver.getIntExtra(FaqConstants.FAQ_LEVEL, 100), intentRegisterReceiver.getIntExtra("plugged", -1));
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "isCharging exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: h2 */
    public static void m6788h2(String str) {
        f5358l = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0052  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle m6789i(android.content.Context r2, android.net.Uri r3, java.lang.String r4, java.lang.String r5, android.os.Bundle r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "AlbumUtil"
            r1 = 0
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27 android.os.RemoteException -> L2a
            android.content.ContentProviderClient r2 = r2.acquireUnstableContentProviderClient(r3)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27 android.os.RemoteException -> L2a
            if (r2 != 0) goto L1d
            java.lang.String r3 = "callUnstable is null"
            p031b7.C1120a.m6678w(r0, r3)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b android.os.RemoteException -> L47
            if (r2 == 0) goto L17
            r2.release()
        L17:
            return r1
        L18:
            r3 = move-exception
            r1 = r2
            goto L50
        L1b:
            r3 = move-exception
            goto L2c
        L1d:
            android.os.Bundle r1 = r2.call(r4, r5, r6)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b android.os.RemoteException -> L47
        L21:
            r2.release()
            goto L4f
        L25:
            r3 = move-exception
            goto L50
        L27:
            r3 = move-exception
            r2 = r1
            goto L2c
        L2a:
            r2 = r1
            goto L47
        L2c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r4.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r5 = "callUnstable exception="
            r4.append(r5)     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L18
            r4.append(r3)     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L18
            p031b7.C1120a.m6676e(r0, r3)     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L4f
            goto L21
        L47:
            java.lang.String r3 = "callUnstable RemoteException"
            p031b7.C1120a.m6676e(r0, r3)     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L4f
            goto L21
        L4f:
            return r1
        L50:
            if (r1 == 0) goto L55
            r1.release()
        L55:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p031b7.C1122c.m6789i(android.content.Context, android.net.Uri, java.lang.String, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    /* renamed from: i0 */
    public static LinkedHashMap<String, String> m6790i0(Context context, String str, String str2, String str3, String str4, String str5, boolean z10) {
        if (TextUtils.isEmpty(str5) || context == null) {
            C1120a.m6676e("AlbumUtil", "context or traceId is null ");
            return null;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("pn", "com.huawei.hidisk\u0001_cloudalbum");
        String strM83101w = C13843a.m83101w(m6774e0());
        linkedHashMap.put("domain", strM83101w);
        linkedHashMap.put("server_ip", m6728Q0(strM83101w));
        linkedHashMap.put("error_code", str);
        linkedHashMap.put("error_msg", str2);
        linkedHashMap.put("resource_path", "null");
        linkedHashMap.put("clientErrorCode", "null");
        linkedHashMap.put("operation_type", str3);
        linkedHashMap.put("business_id", str4);
        linkedHashMap.put("business_type", m6701H0());
        linkedHashMap.put("traceID", str5);
        linkedHashMap.put(HwPayConstant.KEY_USER_ID, C13452e.m80781L().m80971t0());
        linkedHashMap.put("logVersion", "4.0");
        linkedHashMap.put("galleryVersion", m6833t0(context));
        linkedHashMap.put(C6110u3.f28488m, m6704I0());
        linkedHashMap.put("mobile_network", m6851z0(context));
        linkedHashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, String.valueOf(C0209d.m1225Y(C0213f.m1377a())));
        if (z10) {
            linkedHashMap.put("endTrace", "1");
        } else {
            linkedHashMap.put("endTrace", "0");
        }
        return linkedHashMap;
    }

    /* renamed from: i1 */
    public static boolean m6791i1(int i10) {
        return i10 == 2 || i10 == 5 || m6849y1();
    }

    /* renamed from: i2 */
    public static void m6792i2(boolean z10, Context context) {
        C0209d.m1151A2(context, "hicloud_cloudPhoto", z10);
        C1136q.e.m7174l(Boolean.valueOf(z10), context);
    }

    /* renamed from: j */
    public static Bundle m6793j(Context context, Uri uri, String str, Bundle bundle) {
        Bundle bundleM6789i = C0209d.m1227Y1(context, uri) ? m6789i(context, uri, str, null, bundle) : null;
        if (bundleM6789i == null) {
            C1120a.m6678w("AlbumUtil", "callUnstableGallery is null");
        }
        return bundleM6789i;
    }

    /* renamed from: j0 */
    public static long m6794j0(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return jCurrentTimeMillis;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str).getTime();
        } catch (ParseException e10) {
            C1120a.m6676e("AlbumUtil", "getDateFromGMT ParseException:" + e10.toString());
            return jCurrentTimeMillis;
        }
    }

    /* renamed from: j1 */
    public static boolean m6795j1(Media media, ImageView imageView) {
        KvDatabaseWrapper kvDatabaseWrapperM72352f0;
        if (media.isEmpty()) {
            return false;
        }
        String strM480A = C0069g.m479y().m480A(media);
        Bitmap bitmapM30071b = (TextUtils.isEmpty(media.getId()) || (kvDatabaseWrapperM72352f0 = C12091d.m72280a0().m72352f0()) == null) ? null : kvDatabaseWrapperM72352f0.m30071b(media.getId());
        if (bitmapM30071b == null || imageView == null || !strM480A.equals(imageView.getTag())) {
            return false;
        }
        if (imageView.getLayoutParams().width > 0 && imageView.getLayoutParams().height > 0) {
            bitmapM30071b = m6734S0(bitmapM30071b, imageView.getLayoutParams().width, imageView.getLayoutParams().height);
        }
        C12091d.q0 q0Var = new C12091d.q0(bitmapM30071b, imageView);
        Context context = imageView.getContext();
        if (!(context instanceof Activity)) {
            return false;
        }
        ((Activity) context).runOnUiThread(q0Var);
        return true;
    }

    /* renamed from: j2 */
    public static void m6796j2(FileInfo fileInfo, JSONObject jSONObject) throws JSONException {
        String string = jSONObject.has(HicloudH5ConfigManager.KEY_HASH) ? jSONObject.getString(HicloudH5ConfigManager.KEY_HASH) : null;
        if (!CloudAlbumSettings.m14363h().m14378n() || string == null) {
            return;
        }
        fileInfo.setHash(string);
    }

    /* renamed from: k */
    public static boolean m6797k(String str, boolean z10) {
        boolean zMkdirs;
        C1120a.m6675d("AlbumUtil", "checkCustomCachePath: " + str);
        File fileM63437c = C10278a.m63437c(C10278a.m63442h(str));
        if (fileM63437c == null) {
            return false;
        }
        if (!fileM63437c.exists()) {
            C1120a.m6675d("AlbumUtil", "create directory: " + fileM63437c.getPath());
            synchronized (f5346E) {
                zMkdirs = fileM63437c.mkdirs();
            }
            if (!zMkdirs) {
                if (!fileM63437c.exists()) {
                    C1120a.m6676e("AlbumUtil", "mkdirs error need check system storage or permissions");
                    return false;
                }
                C1120a.m6677i("AlbumUtil", "directory already exist ");
            }
        }
        if (!z10) {
            return true;
        }
        File fileM63442h = C10278a.m63442h(fileM63437c.getPath() + "/.nomedia");
        if (fileM63442h.exists()) {
            return true;
        }
        try {
            synchronized (f5346E) {
                try {
                    if (fileM63442h.exists()) {
                        C1120a.m6676e("AlbumUtil", ".nomedia already exist");
                        return true;
                    }
                    return fileM63442h.createNewFile();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (IOException e10) {
            C1120a.m6676e("AlbumUtil", "checkCustomCachePath: create .nomedia file error! error message: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: k0 */
    public static int m6798k0() {
        return CloudAlbumSettings.m14363h().m14376l() ? 29 : 30;
    }

    /* renamed from: k1 */
    public static Media m6799k1(Media media) {
        if (media == null) {
            return null;
        }
        if (!m6819p1(media) || !media.containsKey("id")) {
            return media;
        }
        Media mediaM6924d = C1132m.m6921c().m6924d(media.getId());
        return mediaM6924d != null ? mediaM6924d : f5360n.m77802O(media.getId());
    }

    /* renamed from: k2 */
    public static void m6800k2(Context context, boolean z10) {
        C1120a.m6677i("AlbumUtil", "setMobileSwitch: " + z10);
        Bundle bundle = new Bundle();
        bundle.putBoolean("mobile_data_swich", z10);
        m6785h(context, f5356j, "setMobileData", bundle);
    }

    /* renamed from: l */
    public static void m6801l(String[] strArr, String[] strArr2) throws InterruptedException {
        if (C0209d.m1289o1(strArr, strArr2)) {
            int iNextInt = new Random().nextInt(120);
            C1120a.m6677i("AlbumUtil", "checkDelay delay: " + iNextInt);
            if (iNextInt > 0) {
                try {
                    Thread.sleep(iNextInt * 1000);
                } catch (InterruptedException unused) {
                    C1120a.m6676e("AlbumUtil", "checkDelay InterruptedException");
                }
            }
        }
    }

    /* renamed from: l0 */
    public static int m6802l0(C4616s c4616s) {
        return m6806m0(c4616s, true);
    }

    /* renamed from: l1 */
    public static boolean m6803l1() {
        Bundle bundleM6836u0 = m6836u0(C0213f.m1377a());
        if (bundleM6836u0 == null) {
            return false;
        }
        return (TextUtils.isEmpty(bundleM6836u0.getString("string_sync_album")) || TextUtils.isEmpty(bundleM6836u0.getString("string_mobile_data")) || TextUtils.isEmpty(bundleM6836u0.getString("string_clean_file_title"))) ? false : true;
    }

    /* renamed from: l2 */
    public static void m6804l2(int i10, Context context) {
        C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("notUploadedCount", i10).commit();
    }

    /* renamed from: m */
    public static boolean m6805m(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    /* renamed from: m0 */
    public static int m6806m0(C4616s c4616s, boolean z10) {
        JSONArray jSONArrayM59433a;
        if (TextUtils.isEmpty(c4616s.m28319c())) {
            return 101;
        }
        String strM59436d = C9499a.m59436d(c4616s.m28319c(), VastAttribute.ERROR);
        if (TextUtils.isEmpty(strM59436d) || (jSONArrayM59433a = C9499a.m59433a(strM59436d, "errorDetail")) == null || jSONArrayM59433a.optJSONObject(0) == null) {
            return 101;
        }
        String strM59436d2 = C9499a.m59436d(jSONArrayM59433a.optJSONObject(0).toString(), AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
        if (TextUtils.isEmpty(strM59436d2)) {
            return 101;
        }
        return (strM59436d2.length() < 8 || !z10) ? C0241z.m1686d(strM59436d2, 101) : C0241z.m1686d(strM59436d2.substring(strM59436d2.length() - 4), 101);
    }

    /* renamed from: m1 */
    public static boolean m6807m1(Context context) {
        return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilisCloudAlbumOn", false);
    }

    /* renamed from: m2 */
    public static void m6808m2(int i10, C4609l c4609l) {
        if (i10 == 0 && c4609l != null) {
            c4609l.set("x-hw-options", "privilege");
        }
    }

    /* renamed from: n */
    public static void m6809n() throws InterruptedException {
        C1120a.m6677i("AlbumUtil", "checkSyncDelay");
        m6801l(f5364r, f5365s);
    }

    /* renamed from: n0 */
    public static String m6810n0(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(".")) == -1 || iLastIndexOf >= str.length() + (-1)) ? "" : str.substring(iLastIndexOf + 1);
    }

    /* renamed from: n1 */
    public static boolean m6811n1(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[4];
                    C1120a.m6675d("AlbumUtil", "read: " + fileInputStream2.read(bArr, 0, 4));
                    String strM6781g = m6781g(bArr);
                    if (TextUtils.isEmpty(strM6781g)) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e10) {
                            C1120a.m6676e("AlbumUtil", "isJPEG close error: " + e10.toString());
                        }
                        return false;
                    }
                    String upperCase = strM6781g.toUpperCase(Locale.ENGLISH);
                    C1120a.m6677i("AlbumUtil", "isJPEG type: " + upperCase);
                    boolean zContains = upperCase.contains("FFD8");
                    try {
                        fileInputStream2.close();
                    } catch (IOException e11) {
                        C1120a.m6676e("AlbumUtil", "isJPEG close error: " + e11.toString());
                    }
                    return zContains;
                } catch (Exception e12) {
                    e = e12;
                    fileInputStream = fileInputStream2;
                    C1120a.m6676e("AlbumUtil", "isJPEG error: " + e.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e13) {
                            C1120a.m6676e("AlbumUtil", "isJPEG close error: " + e13.toString());
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e14) {
                            C1120a.m6676e("AlbumUtil", "isJPEG close error: " + e14.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e15) {
            e = e15;
        }
    }

    /* renamed from: n2 */
    public static void m6812n2(Context context, String str, int i10) {
        if (context == null || TextUtils.isEmpty(str)) {
            C1120a.m6676e("AlbumUtil", "setSettings invalidate params");
            return;
        }
        try {
            Settings.Secure.putInt(context.getContentResolver(), str, i10);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "setSettings error: " + e10.toString());
        }
    }

    /* renamed from: o */
    public static void m6813o() {
        synchronized (f5370x) {
            try {
                if (!C1136q.d.m7157u()) {
                    C1120a.m6678w("AlbumUtil", "migrate finish, clear cache");
                    CloudAlbumManager.m14456v().m14489h(C0213f.m1377a());
                    C1136q.d.m7136M(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: o0 */
    public static String m6814o0(FileInfo fileInfo) {
        if (fileInfo == null) {
            return "";
        }
        String uniqueId = fileInfo.getUniqueId();
        return m6831s1(fileInfo.getFileId()) ? TextUtils.isEmpty(uniqueId) ? "" : uniqueId : (!CloudAlbumSettings.m14363h().m14376l() || CloudAlbumSettings.m14363h().m14378n() || TextUtils.isEmpty(uniqueId)) ? !TextUtils.isEmpty(fileInfo.getFileId()) ? fileInfo.getFileId() : !TextUtils.isEmpty(uniqueId) ? uniqueId : "" : uniqueId;
    }

    /* renamed from: o1 */
    public static boolean m6815o1(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return !f5357k.matcher(str).matches();
    }

    /* renamed from: o2 */
    public static void m6816o2(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException e10) {
            C1120a.m6676e("AlbumUtil", "sleep：" + e10.getMessage());
        }
    }

    /* renamed from: p */
    public static void m6817p() {
        f5342A.clear();
    }

    /* renamed from: p0 */
    public static String m6818p0(String str) {
        if (C1443a.f6214b.booleanValue() || TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.length() > 8) {
            return "****" + str.substring(str.length() - 8, str.length());
        }
        return "*" + str.substring(1);
    }

    /* renamed from: p1 */
    public static boolean m6819p1(Media media) {
        return media == null || media.getLocalId() == -1;
    }

    /* renamed from: p2 */
    public static <E> List<List<E>> m6820p2(List<E> list, int i10) {
        int size = list.size();
        int i11 = ((size + i10) - 1) / i10;
        ArrayList arrayList = new ArrayList(i11);
        int i12 = 0;
        while (i12 < i11) {
            int i13 = i12 * i10;
            i12++;
            int i14 = i12 * i10;
            if (i14 >= size) {
                i14 = size;
            }
            arrayList.add(list.subList(i13, i14));
        }
        return arrayList;
    }

    /* renamed from: q */
    public static void m6821q() {
        synchronized (f5370x) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j10 = f5369w;
                if (j10 != 0 && jCurrentTimeMillis - j10 < 60000) {
                    C1120a.m6678w("AlbumUtil", "clearCloudCache too frequent");
                    return;
                }
                f5369w = jCurrentTimeMillis;
                if (C1136q.d.m7141e() < 5) {
                    C1120a.m6678w("AlbumUtil", "sync invalid, clear cache");
                    CloudAlbumManager.m14456v().m14489h(C0213f.m1377a());
                    C1136q.d.m7137a();
                } else {
                    C1120a.m6678w("AlbumUtil", "sync invalid, reopen switch");
                    CloudAlbumManager.m14456v().m14474T(C0213f.m1377a());
                    C1136q.d.m7158v();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: q0 */
    public static String m6822q0(String str) {
        return str.substring(str.lastIndexOf(File.separator) + 1);
    }

    /* renamed from: q1 */
    public static boolean m6823q1(Media media) {
        if (media == null) {
            return true;
        }
        if (m6819p1(media)) {
            return !media.containsKey("id") || C1132m.m6921c().m6924d(media.getId()) == null;
        }
        return false;
    }

    /* renamed from: q2 */
    public static int m6824q2(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            C1120a.m6676e("AlbumUtil", "String trans to Integer error");
            return Integer.MIN_VALUE;
        }
    }

    /* renamed from: r */
    public static boolean m6825r(Context context, String str) {
        C1120a.m6678w("AlbumUtil", "clearCloudVersion");
        ContentResolver contentResolver = context.getContentResolver();
        CommonOpsReport commonOpsReport = new CommonOpsReport(context);
        try {
            Uri uri = f5350d;
            if (C0209d.m1227Y1(context, uri)) {
                contentResolver.delete(uri.buildUpon().appendQueryParameter("clearShareData", FaqConstants.DISABLE_HA_REPORT).build(), null, null);
                commonOpsReport.m15209C(str, "cloud_clear_version", 0, "success");
                return true;
            }
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "clearCloudVersion Exception:" + e10.toString());
            commonOpsReport.m15209C(str, "cloud_clear_version", 101, e10.getMessage());
        }
        return false;
    }

    /* renamed from: r0 */
    public static String m6826r0(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(".")) == -1 || iLastIndexOf >= str.length()) ? "" : str.substring(0, iLastIndexOf);
    }

    /* renamed from: r1 */
    public static boolean m6827r1(Context context) {
        C1120a.m6677i("AlbumUtil", "begin isMobileSwitchOn");
        Boolean bool = (Boolean) C0077o.m632b().m633a(new a(context), 5, TimeUnit.SECONDS);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* renamed from: r2 */
    public static void m6828r2(FileInfo fileInfo) throws JSONException {
        JSONArray jSONArray;
        if (fileInfo == null) {
            return;
        }
        String fileName = fileInfo.getFileName();
        C1120a.m6677i("AlbumUtil", "updateFileExpand file local Expand");
        try {
            if (fileInfo.getExpand() == null || fileInfo.getExpand().isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(fileName);
                jSONObject.put("fileRepeatList", jSONArray2.toString());
                fileInfo.setExpand(jSONObject.toString());
                return;
            }
            JSONObject jSONObject2 = new JSONObject(fileInfo.getExpand());
            if (jSONObject2.has("fileRepeatList")) {
                jSONArray = new JSONArray(jSONObject2.getString("fileRepeatList"));
                if (jSONArray.length() > 0) {
                    jSONArray.put(fileName);
                } else {
                    jSONArray = new JSONArray();
                    jSONArray.put(fileName);
                }
            } else {
                jSONArray = new JSONArray();
                jSONArray.put(fileName);
            }
            jSONObject2.remove("fileRepeatList");
            jSONObject2.put("fileRepeatList", jSONArray.toString());
            fileInfo.setExpand(jSONObject2.toString());
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "updateFileExpand error:" + e10.toString());
        }
    }

    /* renamed from: s */
    public static void m6829s() {
        synchronized (f5371y) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jM7142f = C1136q.d.m7142f();
                if (jM7142f == 0 || jCurrentTimeMillis - jM7142f >= 86400000) {
                    C1120a.m6678w("AlbumUtil", "clearUserKey");
                    UserKeyUtils.getInstance().clearUserKeyByBusinessType(12);
                    C1136q.d.m7161y(jCurrentTimeMillis);
                } else {
                    C1120a.m6678w("AlbumUtil", "clearUserKey in interval, do nothing");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: s0 */
    public static long m6830s0(File file) {
        long jM6830s0 = 0;
        if (file == null || !file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                jM6830s0 += m6830s0(file2);
            }
        }
        return jM6830s0;
    }

    /* renamed from: s1 */
    public static boolean m6831s1(String str) {
        return CloudAlbumSettings.m14363h().m14378n() && CloudAlbumSettings.m14363h().m14376l() && "NMD".equals(str);
    }

    /* renamed from: t */
    public static void m6832t(Closeable closeable) throws IOException {
        if (closeable == null) {
            C1120a.m6675d("AlbumUtil", "cursor is already null");
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            C1120a.m6676e("AlbumUtil", "close fialed: " + e10.toString());
        }
    }

    /* renamed from: t0 */
    public static String m6833t0(Context context) throws PackageManager.NameNotFoundException {
        if (!TextUtils.isEmpty(f5358l)) {
            return f5358l;
        }
        if (!C13452e.m80781L().m80850R0() || !C10028c.m62183d0(context).m62221H1()) {
            return "1100";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                C1120a.m6676e("AlbumUtil", "getGalleryPackageVersionName pm is null");
                return "1100";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(C13843a.m83054F(context), 16384);
            if (packageInfo == null) {
                C1120a.m6676e("AlbumUtil", "getGalleryPackageVersionName pi is null");
                return "1100";
            }
            String strValueOf = String.valueOf(packageInfo.versionName);
            f5358l = strValueOf;
            return strValueOf;
        } catch (Exception e10) {
            C1120a.m6676e("AlbumUtil", "getVersionCode error: " + e10.toString());
            return "1100";
        }
    }

    /* renamed from: t1 */
    public static boolean m6834t1(Context context) {
        if (context == null) {
            context = C0213f.m1377a();
        }
        return Settings.Global.getInt(context.getContentResolver(), Constants.NAVIGATIONBAR_IS_MIN, 0) == 0;
    }

    /* renamed from: u */
    public static int m6835u(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        int iMin = Math.min(length, length2);
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int i10 = 0;
        while (true) {
            int i11 = iMin - 1;
            if (iMin == 0) {
                return length - length2;
            }
            char c10 = charArray[i10];
            char c11 = charArray2[i10];
            if (c10 != c11) {
                return c10 - c11;
            }
            i10++;
            iMin = i11;
        }
    }

    /* renamed from: u0 */
    public static Bundle m6836u0(Context context) {
        C1120a.m6677i("AlbumUtil", "getGalleryString");
        return m6793j(context, f5356j, "getGalleryData", null);
    }

    /* renamed from: u1 */
    public static boolean m6837u1(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File fileM63442h = C10278a.m63442h(str);
        return fileM63442h.exists() && fileM63442h.isFile();
    }

    /* renamed from: v */
    public static String m6838v(FileInfo fileInfo) {
        return fileInfo.getFileName() + "_" + fileInfo.getAlbumId() + "_" + fileInfo.getHash() + "_" + fileInfo.getUniqueId();
    }

    /* renamed from: v0 */
    public static HiCloudSysParamMap m6839v0() {
        HiCloudSysParamMap hiCloudSysParamMap = f5359m;
        if (hiCloudSysParamMap != null) {
            return hiCloudSysParamMap;
        }
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        f5359m = hiCloudSysParamMapM60757p;
        return hiCloudSysParamMapM60757p;
    }

    /* renamed from: v1 */
    public static boolean m6840v1(Context context) {
        return context != null && context.getResources().getConfiguration().orientation == 1;
    }

    /* renamed from: w */
    public static String m6841w(FileData fileData) {
        return fileData.getFileName() + "_" + fileData.getAlbumId() + "_" + fileData.getHash() + "_" + fileData.getUniqueId();
    }

    /* renamed from: w0 */
    public static String m6842w0(Exception exc) {
        return exc instanceof UnknownHostException ? "1003" : exc instanceof ProtocolException ? "1005" : exc instanceof SocketTimeoutException ? "1006" : exc instanceof TimeoutException ? "1010" : exc instanceof NoRouteToHostException ? FaqConstants.CHANNEL_HICARE : exc instanceof MalformedURLException ? "1002" : exc instanceof ConnectException ? "1001" : exc instanceof SocketException ? "1008" : exc instanceof SSLException ? "1009" : exc instanceof InterruptedIOException ? "1011" : "1000";
    }

    /* renamed from: w1 */
    public static boolean m6843w1(Context context) {
        if (context != null) {
            return C10028c.m62182c0().m62221H1();
        }
        C1120a.m6678w("AlbumUtil", "isReport context is null");
        return false;
    }

    /* renamed from: x */
    public static Media m6844x(Media media) {
        Media media2 = new Media();
        media2.setAlbumId(media.getAlbumId());
        media2.setCreatedTime(media.getCreatedTime());
        media2.setFavorite(media.getFavorite());
        media2.setId(media.getId());
        media2.setFileType(media.getFileType());
        media2.setFileName(media.getFileName());
        media2.setHashId(media.getHashId());
        media2.setSize(media.getSize());
        if (media.getFileType().intValue() == 4) {
            VideoMetaData videoMetaData = media.getVideoMetaData();
            if (videoMetaData != null && videoMetaData.getRotation() != null) {
                media2.setRotation(videoMetaData.getRotation().intValue());
            }
            if (videoMetaData != null && videoMetaData.getDurationTime() != null) {
                media2.setVideoTimeDuration(videoMetaData.getDurationTime().intValue());
            }
        } else {
            PictureMetaData pictureMetaData = media.getPictureMetaData();
            if (pictureMetaData != null && pictureMetaData.getRotation() != null) {
                media2.setRotation(pictureMetaData.getRotation().intValue());
            }
        }
        return media2;
    }

    /* renamed from: x0 */
    public static int m6845x0(Exception exc) {
        return C0241z.m1685c(m6842w0(exc));
    }

    /* renamed from: x1 */
    public static boolean m6846x1(int i10, int i11) {
        int iM6689D0 = m6689D0();
        C1120a.m6677i("AlbumUtil", "isSmartCharging batteryCurrentLevel: " + i10 + ", omBatteryCharge: " + iM6689D0 + ", chargePlugStatus: " + i11);
        return m6771d1(i11) && iM6689D0 >= 10 && i10 > iM6689D0;
    }

    /* renamed from: y */
    public static String m6847y(FileInfo fileInfo) {
        return fileInfo.getAlbumId() + "_" + fileInfo.getHash();
    }

    /* renamed from: y0 */
    public static int m6848y0(C4616s c4616s) {
        if (TextUtils.isEmpty(c4616s.m28319c())) {
            return -1;
        }
        String strM59436d = C9499a.m59436d(c4616s.m28319c(), VastAttribute.ERROR);
        if (TextUtils.isEmpty(strM59436d)) {
            return -1;
        }
        String strM59436d2 = C9499a.m59436d(strM59436d, "errorData");
        if (TextUtils.isEmpty(strM59436d2)) {
            return -1;
        }
        return C9499a.m59435c(strM59436d2, "invalidCipherType", -1);
    }

    /* renamed from: y1 */
    public static boolean m6849y1() {
        return m6846x1(C1136q.b.m7074l(C0213f.m1377a()), C1136q.b.m7080n(C0213f.m1377a()));
    }

    /* renamed from: z */
    public static String m6850z(FileData fileData) {
        return fileData.getAlbumId() + "_" + fileData.getHash();
    }

    /* renamed from: z0 */
    public static String m6851z0(Context context) {
        if (context != null) {
            return String.valueOf(CloudAlbumSettings.m14363h().m14380p());
        }
        C1120a.m6676e("AlbumUtil", "getMobileNetWortState is null");
        return "null";
    }

    /* renamed from: z1 */
    public static boolean m6852z1(int i10, long j10) {
        if (i10 != 0 || j10 >= 52428800) {
            return i10 != 0 && j10 <= 102400;
        }
        return true;
    }
}
