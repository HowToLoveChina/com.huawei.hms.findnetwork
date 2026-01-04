package p546p6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import bb.C1160a;
import com.huawei.android.hicloud.album.service.p075vo.DayModeGroup;
import com.huawei.android.hicloud.album.service.p075vo.GalleryAlbum;
import com.huawei.android.hicloud.commonlib.p079db.bean.JoinShareAlbumRequestInfo;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Applicant;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionUpdateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.PictureMetaData;
import com.huawei.android.hicloud.drive.cloudphoto.model.VideoMetaData;
import com.huawei.android.hicloud.drive.cloudphoto.request.Permissions;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.PhotoPickerActivity;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.router.data.ShareAlbumInfo;
import com.huawei.hicloud.router.data.SmallPictureInfo;
import com.huawei.hidisk.common.kvdb.KvDatabaseWrapper;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p009a8.C0069g;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1131l;
import p031b7.C1132m;
import p031b7.C1140u;
import p283fa.C9678a;
import p336he.C10159j;
import p471m6.C11415a;
import p471m6.C11416b;
import p471m6.C11417c;
import p471m6.C11422h;
import p471m6.C11423i;
import p471m6.C11424j;
import p471m6.C11425k;
import p486n6.ViewOnClickListenerC11636a;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p604r7.C12474g;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p649t6.C12941a;
import p649t6.C12944d;
import p649t6.C12947g;
import p649t6.C12948h;
import p664u0.C13108a;
import p684un.C13223b;
import p684un.C13224c;
import p709vj.C13452e;
import p783xp.C13843a;
import p804ya.C13924a;

/* renamed from: p6.d */
/* loaded from: classes2.dex */
public class C12091d {

    /* renamed from: h */
    public static final Object f55933h = new Object();

    /* renamed from: i */
    public static final Object f55934i = new Object();

    /* renamed from: j */
    public static final Object f55935j = new Object();

    /* renamed from: k */
    public static final Object f55936k = new Object();

    /* renamed from: l */
    public static final Object f55937l = new Object();

    /* renamed from: m */
    public static final Object f55938m = new Object();

    /* renamed from: n */
    public static final Object f55939n = new Object();

    /* renamed from: o */
    public static final Object f55940o = new Object();

    /* renamed from: p */
    public static final Object f55941p = new Object();

    /* renamed from: q */
    public static List<MediaFileBean> f55942q = new ArrayList();

    /* renamed from: r */
    public static final Object f55943r = new Object();

    /* renamed from: s */
    public static List<MediaFileBean> f55944s = new ArrayList();

    /* renamed from: t */
    public static List<C11415a> f55945t = new ArrayList();

    /* renamed from: u */
    public static List<C11422h> f55946u = new ArrayList();

    /* renamed from: v */
    public static C11415a f55947v;

    /* renamed from: a */
    public List<C11424j> f55948a;

    /* renamed from: b */
    public List<C11425k> f55949b;

    /* renamed from: c */
    public List<C11425k> f55950c;

    /* renamed from: d */
    public Map<String, List<DayModeGroup>> f55951d;

    /* renamed from: e */
    public Map<String, C11415a> f55952e;

    /* renamed from: f */
    public int f55953f;

    /* renamed from: g */
    public KvDatabaseWrapper f55954g;

    /* renamed from: p6.d$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f55955a;

        /* renamed from: b */
        public final /* synthetic */ Handler f55956b;

        public a(String str, Handler handler) {
            this.f55955a = str;
            this.f55956b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Message messageObtain = Message.obtain();
            Album albumM77726A = new C12941a().m77726A(this.f55955a, true);
            C11415a c11415a = new C11415a();
            c11415a.m68368g(albumM77726A);
            c11415a.m68369h(albumM77726A.getAlbumName());
            if (albumM77726A.getShareType().intValue() == 1) {
                c11415a.m68376o(C0213f.m1377a().getString(R$string.album_baby));
            }
            c11415a.m68370i(albumM77726A.getAlbumOwnerName());
            c11415a.m68374m(albumM77726A.getPicCount());
            c11415a.m68377p(albumM77726A.getVideoCount());
            c11415a.m68372k(albumM77726A.getPermissions().size());
            messageObtain.what = 1009;
            messageObtain.obj = c11415a;
            this.f55956b.sendMessage(messageObtain);
        }
    }

    /* renamed from: p6.d$a0 */
    public class a0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f55958a;

        /* renamed from: b */
        public final /* synthetic */ Handler f55959b;

        /* renamed from: c */
        public final /* synthetic */ int f55960c;

        /* renamed from: d */
        public final /* synthetic */ String f55961d;

        public a0(Context context, Handler handler, int i10, String str) {
            this.f55958a = context;
            this.f55959b = handler;
            this.f55960c = i10;
            this.f55961d = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12091d.this.m72335V0(this.f55958a, this.f55959b, this.f55960c, this.f55961d, "album_id_picture");
        }
    }

    /* renamed from: p6.d$b */
    public class b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f55963a;

        /* renamed from: b */
        public final /* synthetic */ Handler f55964b;

        /* renamed from: c */
        public final /* synthetic */ Activity f55965c;

        public b(String str, Handler handler, Activity activity) {
            this.f55963a = str;
            this.f55964b = handler;
            this.f55965c = activity;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Album albumM77726A = new C12941a().m77726A(this.f55963a, false);
            if (albumM77726A == null) {
                C1120a.m6676e("AlbumShareManager", "album no exist");
                return;
            }
            C1120a.m6677i("AlbumShareManager", "shareAlbumId:" + this.f55963a);
            try {
                C12469b.m74746l().m74752f(albumM77726A);
                C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.refresh.share.album"));
                Message messageObtain = Message.obtain();
                messageObtain.what = 1041;
                this.f55964b.sendMessageDelayed(messageObtain, 500L);
            } catch (C4616s e10) {
                C1120a.m6676e("AlbumShareManager", "deleteShareAlbum HttpResponseException " + e10.toString());
                if (!C1122c.m6699G1(e10)) {
                    C1122c.m6682B(e10, this.f55964b, this.f55965c);
                    return;
                }
                C1120a.m6676e("AlbumShareManager", "user suspended");
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 2000;
                this.f55964b.sendMessage(messageObtain2);
            } catch (Exception e11) {
                C1120a.m6676e("AlbumShareManager", "deleteAlbum Exception " + e11.getMessage());
            }
        }
    }

    /* renamed from: p6.d$b0 */
    public class b0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f55967a;

        /* renamed from: b */
        public final /* synthetic */ Handler f55968b;

        /* renamed from: c */
        public final /* synthetic */ int f55969c;

        /* renamed from: d */
        public final /* synthetic */ String f55970d;

        public b0(Context context, Handler handler, int i10, String str) {
            this.f55967a = context;
            this.f55968b = handler;
            this.f55969c = i10;
            this.f55970d = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12091d.this.m72335V0(this.f55967a, this.f55968b, this.f55969c, this.f55970d, "album_id_video");
        }
    }

    /* renamed from: p6.d$c */
    public class c extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f55972a;

        /* renamed from: b */
        public final /* synthetic */ String f55973b;

        /* renamed from: c */
        public final /* synthetic */ Handler f55974c;

        public c(String str, String str2, Handler handler) {
            this.f55972a = str;
            this.f55973b = str2;
            this.f55974c = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C13924a c13924aM60445d;
            Album albumM77726A = new C12941a().m77726A(this.f55972a, false);
            C1120a.m6677i("AlbumShareManager", "shareAlbumId:" + this.f55972a);
            try {
                c13924aM60445d = C9678a.m60442e().m60445d();
            } catch (Exception e10) {
                C1120a.m6676e("AlbumShareManager", "quitAlbum:" + e10.getMessage());
            }
            if (c13924aM60445d == null) {
                C1120a.m6677i("AlbumShareManager", "cloudPhoto null");
                return;
            }
            Permissions.Delete deleteAddHeader = c13924aM60445d.m83550g().delete(albumM77726A.getId(), this.f55973b).addHeader("x-hw-album-owner-Id", (Object) albumM77726A.getAlbumOwnerId());
            deleteAddHeader.setAlbumClientHeader(C1122c.m6755Z0("04019"));
            deleteAddHeader.execute();
            Album album = new Album();
            album.setId(this.f55972a);
            ArrayList<Album> arrayList = new ArrayList<>();
            arrayList.add(album);
            new C12941a().m77734i(arrayList);
            C12515a.m75110o().m75175e(new C12095h(arrayList), false);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1041;
            this.f55974c.sendMessageDelayed(messageObtain, 500L);
        }
    }

    /* renamed from: p6.d$c0 */
    public class c0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f55976a;

        /* renamed from: b */
        public final /* synthetic */ Handler f55977b;

        public c0(String str, Handler handler) {
            this.f55976a = str;
            this.f55977b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Message messageObtain = Message.obtain();
            List<MediaFileBean> listM483D = C0069g.m479y().m483D(this.f55976a);
            messageObtain.what = 1024;
            messageObtain.obj = listM483D;
            this.f55977b.sendMessage(messageObtain);
        }
    }

    /* renamed from: p6.d$d */
    public class d extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f55979a;

        /* renamed from: b */
        public final /* synthetic */ String f55980b;

        /* renamed from: c */
        public final /* synthetic */ String f55981c;

        /* renamed from: d */
        public final /* synthetic */ Handler f55982d;

        public d(String str, String str2, String str3, Handler handler) {
            this.f55979a = str;
            this.f55980b = str2;
            this.f55981c = str3;
            this.f55982d = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Message messageObtain = Message.obtain();
            try {
                Permission permissionM74759n = C12469b.m74746l().m74759n(this.f55979a, this.f55980b, this.f55981c);
                C11422h c11422h = new C11422h();
                if (permissionM74759n != null) {
                    c11422h.m68443i(permissionM74759n);
                    c11422h.m68442h(permissionM74759n.getDisplayName());
                }
                messageObtain.obj = c11422h;
                messageObtain.what = FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST;
                this.f55982d.sendMessage(messageObtain);
            } catch (IOException e10) {
                C1120a.m6677i("AlbumShareManager", "getMemberInfo error:" + e10.toString());
            }
        }
    }

    /* renamed from: p6.d$d0 */
    public class d0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Handler f55984a;

        public d0(Handler handler) {
            this.f55984a = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Message messageObtain = Message.obtain();
            ArrayList<Album> arrayListM77727B = new C12941a().m77727B(1, false);
            ArrayList arrayList = new ArrayList();
            if (!arrayListM77727B.isEmpty()) {
                Iterator<Album> it = arrayListM77727B.iterator();
                while (it.hasNext()) {
                    Album next = it.next();
                    if (!C1122c.m6705I1(next)) {
                        ShareAlbumInfo shareAlbumInfo = new ShareAlbumInfo();
                        shareAlbumInfo.setAlbumId(next.getId());
                        shareAlbumInfo.setAlbumName(next.getAlbumName());
                        shareAlbumInfo.setEndEditorTime(next.getFileUpdateTime());
                        arrayList.add(shareAlbumInfo);
                    }
                }
            }
            messageObtain.what = FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH;
            messageObtain.obj = arrayList;
            C1120a.m6677i("AlbumShareManager", "getShareAlubumInfo sendMessage");
            this.f55984a.sendMessage(messageObtain);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: p6.d$e */
    public class e extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Album f55986a;

        /* renamed from: b */
        public final /* synthetic */ Handler f55987b;

        /* renamed from: c */
        public final /* synthetic */ Activity f55988c;

        public e(Album album, Handler handler, Activity activity) {
            this.f55986a = album;
            this.f55987b = handler;
            this.f55988c = activity;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Album albumM74765u;
            Message messageObtain = Message.obtain();
            try {
                albumM74765u = C12469b.m74746l().m74765u(this.f55986a);
            } catch (Exception e10) {
                C1120a.m6676e("AlbumShareManager", "modifyAlbum:" + e10.getMessage());
                C1122c.m6682B(e10, this.f55987b, this.f55988c);
                albumM74765u = null;
            }
            messageObtain.obj = Boolean.valueOf(albumM74765u != null);
            messageObtain.what = PlayerConstants.ErrorCode.SWITCH_SUBTITLE_FAILED;
            this.f55987b.sendMessage(messageObtain);
        }
    }

    /* renamed from: p6.d$e0 */
    public class e0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ ShareAlbumInfo f55990a;

        /* renamed from: b */
        public final /* synthetic */ Handler f55991b;

        public e0(ShareAlbumInfo shareAlbumInfo, Handler handler) {
            this.f55990a = shareAlbumInfo;
            this.f55991b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Message messageObtain = Message.obtain();
            ArrayList<Media> arrayListM77801N = new C12947g().m77801N(this.f55990a.getAlbumId(), 0L, 7L);
            if (!arrayListM77801N.isEmpty()) {
                Collections.sort(arrayListM77801N, new l0());
                ArrayList<Media> arrayList = new ArrayList();
                int i10 = 0;
                for (Media media : arrayListM77801N) {
                    if (i10 < 7) {
                        arrayList.add(media);
                        i10++;
                    }
                }
                ArrayList<Media> arrayListM72476z = C12096i.m72418I().m72476z(arrayList);
                ArrayList arrayList2 = new ArrayList();
                if (arrayListM72476z != null && !arrayListM72476z.isEmpty()) {
                    for (Media media2 : arrayList) {
                        for (Media media3 : arrayListM72476z) {
                            if (media2.getId().equals(media3.getId())) {
                                SmallPictureInfo smallPictureInfo = new SmallPictureInfo();
                                smallPictureInfo.setSmallPicPath(media3.getLocalBigThumbPath());
                                smallPictureInfo.setRotationId(media3.getRotation());
                                arrayList2.add(smallPictureInfo);
                            }
                        }
                    }
                }
                this.f55990a.setSmallPicInfos(arrayList2);
            }
            messageObtain.what = FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED;
            messageObtain.obj = this.f55990a;
            this.f55991b.sendMessage(messageObtain);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: p6.d$f */
    public class f extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f55993a;

        /* renamed from: b */
        public final /* synthetic */ Handler f55994b;

        public f(String str, Handler handler) {
            this.f55993a = str;
            this.f55994b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM7196h;
            HashMap<String, Integer> map = new HashMap<>();
            List<Applicant> listM74760p = C12469b.m74746l().m74760p(this.f55993a, map);
            ArrayList arrayList = new ArrayList();
            if (listM74760p == null || listM74760p.size() == 0) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = arrayList;
                messageObtain.what = 1005;
                Integer num = map.get("code");
                messageObtain.arg1 = num == null ? 0 : num.intValue();
                this.f55994b.sendMessage(messageObtain);
                return;
            }
            C1120a.m6677i("AlbumShareManager", "Applicants size:" + listM74760p.size());
            for (Applicant applicant : listM74760p) {
                if (applicant.getStatus().equals("await")) {
                    if (applicant.getExpirationTime().m28458c() > System.currentTimeMillis()) {
                        C11416b c11416b = new C11416b();
                        try {
                            strM7196h = C12469b.m74746l().m74757k(applicant.getUserId());
                        } catch (IOException e10) {
                            C1120a.m6677i("AlbumShareManager", "getDisplayName:" + e10.getMessage());
                            strM7196h = "";
                        }
                        String userAccount = applicant.getUserAccount();
                        if (TextUtils.equals(strM7196h, userAccount)) {
                            strM7196h = C1140u.m7196h(strM7196h);
                        }
                        if (!TextUtils.isEmpty(strM7196h)) {
                            c11416b.m68381d(strM7196h);
                        }
                        c11416b.m68386i(C1140u.m7196h(userAccount));
                        c11416b.m68382e(applicant);
                        c11416b.m68384g(applicant.getApplicantId());
                        c11416b.m68383f(applicant.getSource());
                        c11416b.m68385h(applicant.getRemark());
                        arrayList.add(c11416b);
                    }
                }
            }
            Collections.sort(arrayList, new k0(null));
            Message messageObtain2 = Message.obtain();
            messageObtain2.obj = arrayList;
            messageObtain2.what = 1005;
            this.f55994b.sendMessage(messageObtain2);
        }
    }

    /* renamed from: p6.d$f0 */
    public class f0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ List f55996a;

        /* renamed from: b */
        public final /* synthetic */ Handler f55997b;

        public f0(List list, Handler handler) {
            this.f55996a = list;
            this.f55997b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Message messageObtain = Message.obtain();
            C12947g c12947g = new C12947g();
            ArrayList arrayList = new ArrayList();
            List list = this.f55996a;
            if (list != null && !list.isEmpty()) {
                for (ShareAlbumInfo shareAlbumInfo : this.f55996a) {
                    ArrayList<Media> arrayListM77801N = c12947g.m77801N(shareAlbumInfo.getAlbumId(), 0L, 1L);
                    if (!arrayListM77801N.isEmpty()) {
                        Media media = arrayListM77801N.get(0);
                        shareAlbumInfo.setMediaId(media.getId());
                        shareAlbumInfo.setCoverRotationId(media.getRotation());
                    }
                }
                C1120a.m6677i("AlbumShareManager", "getSomeShareAlbumFirstPic getMedia finish().");
                Collections.sort(this.f55996a, new p0());
                arrayList.addAll(this.f55996a);
            }
            C1120a.m6677i("AlbumShareManager", "getSomeShareAlbumFirstPic finalShareAlbumInfoList.size() = " + arrayList.size());
            messageObtain.what = 1017;
            messageObtain.obj = arrayList;
            this.f55997b.sendMessage(messageObtain);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: p6.d$g */
    public class g extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f55999a;

        /* renamed from: b */
        public final /* synthetic */ String f56000b;

        /* renamed from: c */
        public final /* synthetic */ Handler f56001c;

        public g(String str, String str2, Handler handler) {
            this.f55999a = str;
            this.f56000b = str2;
            this.f56001c = handler;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // p616rk.AbstractRunnableC12516b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() throws fk.C9721b {
            /*
                r4 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "albumId:"
                r0.append(r1)
                java.lang.String r1 = r4.f55999a
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "AlbumShareManager"
                p031b7.C1120a.m6677i(r1, r0)
                r7.b r0 = p604r7.C12469b.m74746l()     // Catch: java.lang.Exception -> L25 com.huawei.cloud.base.http.C4616s -> L27
                java.lang.String r2 = r4.f55999a     // Catch: java.lang.Exception -> L25 com.huawei.cloud.base.http.C4616s -> L27
                java.lang.String r3 = r4.f56000b     // Catch: java.lang.Exception -> L25 com.huawei.cloud.base.http.C4616s -> L27
                com.huawei.android.hicloud.drive.cloudphoto.model.Album r0 = r0.m74754h(r2, r3)     // Catch: java.lang.Exception -> L25 com.huawei.cloud.base.http.C4616s -> L27
                goto L6e
            L25:
                r0 = move-exception
                goto L29
            L27:
                r0 = move-exception
                goto L42
            L29:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "getAlbum Exception "
                r2.append(r3)
                java.lang.String r0 = r0.getMessage()
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                p031b7.C1120a.m6676e(r1, r0)
                goto L6d
            L42:
                int r0 = p031b7.C1122c.m6802l0(r0)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "getAlbum HttpResponseException: "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                p031b7.C1120a.m6676e(r1, r2)
                android.os.Message r1 = android.os.Message.obtain()
                java.lang.String r0 = java.lang.String.valueOf(r0)
                r1.obj = r0
                r0 = 1047(0x417, float:1.467E-42)
                r1.what = r0
                android.os.Handler r0 = r4.f56001c
                r0.sendMessage(r1)
            L6d:
                r0 = 0
            L6e:
                if (r0 == 0) goto L7b
                android.os.Handler r4 = r4.f56001c
                r1 = 1046(0x416, float:1.466E-42)
                android.os.Message r4 = r4.obtainMessage(r1, r0)
                r4.sendToTarget()
            L7b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p546p6.C12091d.g.call():void");
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: p6.d$g0 */
    public class g0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Handler f56003a;

        public g0(Handler handler) {
            this.f56003a = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Album albumM77726A;
            Message messageObtain = Message.obtain();
            JoinShareAlbumRequestInfo joinShareAlbumRequestInfo = new JoinShareAlbumRequestInfo();
            ArrayList<com.huawei.android.hicloud.drive.cloudphoto.model.Message> arrayListM77844o = new C12948h().m77844o();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String strM80971t0 = C13452e.m80781L().m80971t0();
            C12941a c12941a = new C12941a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator<com.huawei.android.hicloud.drive.cloudphoto.model.Message> it = arrayListM77844o.iterator();
            while (it.hasNext()) {
                com.huawei.android.hicloud.drive.cloudphoto.model.Message next = it.next();
                if (!next.isRead()) {
                    if (next.getMessageType().intValue() == 1) {
                        if (next.getExpirationTime().m28458c() >= jCurrentTimeMillis) {
                            C12091d.this.m72371o(next, linkedHashMap);
                        }
                    } else if (next.getMessageType().intValue() == 2) {
                        if (!TextUtils.isEmpty(strM80971t0) && strM80971t0.equals(next.getSenderId()) && (albumM77726A = c12941a.m77726A(next.getAlbumId(), false)) != null) {
                            ArrayList arrayList4 = new ArrayList();
                            Iterator<Permission> it2 = albumM77726A.getPermissions().iterator();
                            while (it2.hasNext()) {
                                arrayList4.add(it2.next().getUserId());
                            }
                            if (arrayList4.contains(next.getSenderId())) {
                                arrayList2.add(next);
                            }
                        }
                    } else if (next.getMessageType().intValue() == 7 && TextUtils.equals(strM80971t0, next.getReceiverId()) && next.getAuditStatus() == 2) {
                        arrayList3.add(next);
                    }
                }
            }
            HashMap<String, Integer> map = new HashMap<>();
            if (linkedHashMap.size() > 0) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    LinkedHashMap linkedHashMap2 = (LinkedHashMap) entry.getValue();
                    List<Applicant> listM74760p = C12469b.m74746l().m74760p((String) entry.getKey(), map);
                    for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                        if (listM74760p != null && !listM74760p.isEmpty()) {
                            for (com.huawei.android.hicloud.drive.cloudphoto.model.Message message : (List) entry2.getValue()) {
                                for (Applicant applicant : listM74760p) {
                                    if (message.getApplicantId().equals(applicant.getApplicantId()) && applicant.getStatus().equals("await")) {
                                        arrayList.add(message);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                Collections.sort(arrayList, new m0());
                joinShareAlbumRequestInfo.setJoinRequestNum(arrayList.size());
                joinShareAlbumRequestInfo.setMessageType(1);
                joinShareAlbumRequestInfo.setJoinRequestTime(((com.huawei.android.hicloud.drive.cloudphoto.model.Message) arrayList.get(0)).getCreatedTime().m28458c());
                joinShareAlbumRequestInfo.setJoinRequesetUserIdList(C12091d.this.m72348d0(arrayList));
            } else if (!arrayList2.isEmpty()) {
                Collections.sort(arrayList2, new m0());
                joinShareAlbumRequestInfo.setJoinRequestNum(arrayList2.size());
                joinShareAlbumRequestInfo.setMessageType(2);
                joinShareAlbumRequestInfo.setJoinRequestTime(((com.huawei.android.hicloud.drive.cloudphoto.model.Message) arrayList2.get(0)).getCreatedTime().m28458c());
                joinShareAlbumRequestInfo.setLatestJoinAlbumName(new C12941a().m77726A(((com.huawei.android.hicloud.drive.cloudphoto.model.Message) arrayList2.get(0)).getAlbumId(), false).getAlbumName());
                joinShareAlbumRequestInfo.setJoinRequesetUserIdList(C12091d.this.m72399y0());
            } else if (!arrayList3.isEmpty()) {
                joinShareAlbumRequestInfo.setJoinRequestNum(arrayList3.size());
                joinShareAlbumRequestInfo.setMessageType(7);
                joinShareAlbumRequestInfo.setJoinRequestTime(((com.huawei.android.hicloud.drive.cloudphoto.model.Message) arrayList3.get(0)).getCreatedTime().m28458c());
                joinShareAlbumRequestInfo.setLatestJoinAlbumName(((com.huawei.android.hicloud.drive.cloudphoto.model.Message) arrayList3.get(0)).getAlbumName());
                joinShareAlbumRequestInfo.setJoinRequesetUserIdList(C12091d.this.m72399y0());
            }
            C1120a.m6677i("AlbumShareManager", "getJoinRequestInfo sendMessage" + arrayList3.size());
            messageObtain.what = FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN;
            messageObtain.obj = joinShareAlbumRequestInfo;
            this.f56003a.sendMessage(messageObtain);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: p6.d$h */
    public class h extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f56005a;

        /* renamed from: b */
        public final /* synthetic */ Handler f56006b;

        public h(String str, Handler handler) {
            this.f56005a = str;
            this.f56006b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Applicant applicantM74756j;
            String strM7196h;
            Message messageObtain = Message.obtain();
            try {
                applicantM74756j = C12469b.m74746l().m74756j(this.f56005a);
            } catch (Exception e10) {
                C1120a.m6677i("AlbumShareManager", "getApplicant Exception:" + e10.getMessage());
                applicantM74756j = null;
            }
            C11416b c11416b = new C11416b();
            if (applicantM74756j == null) {
                C1120a.m6677i("AlbumShareManager", "result null");
                messageObtain.obj = c11416b;
                messageObtain.what = FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH;
                this.f56006b.sendMessage(messageObtain);
                return;
            }
            C1120a.m6675d("AlbumShareManager", "Applicant:" + applicantM74756j.toString());
            try {
                strM7196h = C12469b.m74746l().m74757k(applicantM74756j.getUserId());
            } catch (IOException e11) {
                C1120a.m6677i("AlbumShareManager", "getDisplayName:" + e11.getMessage());
                strM7196h = "";
            }
            String userAccount = applicantM74756j.getUserAccount();
            if (TextUtils.equals(strM7196h, userAccount)) {
                strM7196h = C1140u.m7196h(strM7196h);
            }
            if (!TextUtils.isEmpty(strM7196h)) {
                c11416b.m68381d(strM7196h);
            }
            c11416b.m68386i(C1140u.m7196h(userAccount));
            c11416b.m68382e(applicantM74756j);
            c11416b.m68384g(applicantM74756j.getApplicantId());
            c11416b.m68383f(applicantM74756j.getSource());
            c11416b.m68385h(applicantM74756j.getRemark());
            messageObtain.obj = c11416b;
            messageObtain.what = FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH;
            this.f56006b.sendMessage(messageObtain);
        }
    }

    /* renamed from: p6.d$h0 */
    public class h0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f56008a;

        /* renamed from: b */
        public final /* synthetic */ Handler f56009b;

        public h0(String str, Handler handler) {
            this.f56008a = str;
            this.f56009b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12947g c12947g = new C12947g();
            ArrayList<DayModeGroup> arrayListM77812Y = c12947g.m77812Y(this.f56008a);
            C12091d.m72280a0().m72357h1(this.f56008a, arrayListM77812Y);
            ArrayList<DayModeGroup> arrayListM77813Z = c12947g.m77813Z(this.f56008a);
            C12091d.m72280a0().m72357h1(this.f56008a + "share_home_picture", arrayListM77813Z);
            ArrayList<DayModeGroup> arrayListM77815b0 = c12947g.m77815b0(this.f56008a);
            C12091d.m72280a0().m72357h1(this.f56008a + "share_home_vedio", arrayListM77815b0);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1004;
            messageObtain.obj = this.f56008a;
            if (arrayListM77812Y.size() == 0) {
                messageObtain.arg1 = 0;
            } else {
                messageObtain.arg1 = 1;
            }
            this.f56009b.sendMessage(messageObtain);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: p6.d$i */
    public class i extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f56011a;

        /* renamed from: b */
        public final /* synthetic */ Handler f56012b;

        public i(String str, Handler handler) {
            this.f56011a = str;
            this.f56012b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                C12469b.m74746l().m74766v(null, null, "reject", this.f56011a, null, null, null);
            } catch (C4616s e10) {
                C1120a.m6676e("AlbumShareManager", "disagreeJionAlbum HttpResponseException " + e10.getMessage());
                C12091d.m72280a0().m72309H0(this.f56012b, e10);
                C12091d.m72280a0().m72307G0(e10, this.f56012b);
            } catch (Exception e11) {
                C1120a.m6676e("AlbumShareManager", "disagreeJionAlbum exception:" + e11.getMessage());
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1040;
            this.f56012b.sendMessage(messageObtain);
        }
    }

    /* renamed from: p6.d$i0 */
    public static class i0 extends AbstractC12367d {

        /* renamed from: a */
        public String f56014a;

        /* renamed from: b */
        public Handler f56015b;

        public i0(String str, Handler handler) {
            this.f56014a = str;
            this.f56015b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12947g c12947g = new C12947g();
            C1120a.m6675d("AlbumShareManager", "getAlbumShareBackGroundList start query");
            ArrayList<DayModeGroup> arrayListM77814a0 = c12947g.m77814a0(this.f56014a);
            C1120a.m6675d("AlbumShareManager", "getAlbumShareBackGroundList end query");
            C12091d.m72280a0().m72357h1(this.f56014a + "select_cover_bg", arrayListM77814a0);
            this.f56015b.obtainMessage(1004).sendToTarget();
        }
    }

    /* renamed from: p6.d$j */
    public class j extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f56016a;

        /* renamed from: b */
        public final /* synthetic */ String f56017b;

        /* renamed from: c */
        public final /* synthetic */ Handler f56018c;

        public j(String str, String str2, Handler handler) {
            this.f56016a = str;
            this.f56017b = str2;
            this.f56018c = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Message messageObtain = Message.obtain();
            HashMap<String, Integer> map = new HashMap<>();
            try {
                List<Permission> listM74762r = C12469b.m74746l().m74762r(this.f56016a, this.f56017b, map);
                C1120a.m6675d("AlbumShareManager", "permissions:" + listM74762r.toString());
                ArrayList arrayList = new ArrayList();
                for (Permission permission : listM74762r) {
                    C11422h c11422h = new C11422h();
                    c11422h.m68443i(permission);
                    c11422h.m68442h(permission.getDisplayName());
                    arrayList.add(c11422h);
                }
                Collections.sort(arrayList, new o0(null));
                messageObtain.obj = arrayList;
                messageObtain.what = 1007;
                Integer num = map.get("code");
                messageObtain.arg1 = num == null ? 0 : num.intValue();
                this.f56018c.sendMessage(messageObtain);
            } catch (IOException e10) {
                C1120a.m6677i("AlbumShareManager", "listPermission error:" + e10.getMessage());
            }
        }
    }

    /* renamed from: p6.d$j0 */
    public static class j0 {

        /* renamed from: a */
        public static final C12091d f56020a = new C12091d(null);
    }

    /* renamed from: p6.d$k */
    public class k extends AbstractC12367d {
        public k() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            synchronized (C12091d.f55941p) {
                try {
                    if (C12091d.this.f55954g != null) {
                        C12091d.this.f55954g.m30070a();
                        C12091d.this.f55954g = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: p6.d$k0 */
    public static class k0 implements Comparator<C11416b>, Serializable {
        private static final long serialVersionUID = -1000;

        public k0() {
        }

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(C11416b c11416b, C11416b c11416b2) {
            if (c11416b.m68379b() != null && c11416b2.m68379b() != null) {
                C4644l createdTime = c11416b.m68379b().getCreatedTime();
                C4644l createdTime2 = c11416b2.m68379b().getCreatedTime();
                if (createdTime != null && createdTime2 != null) {
                    long jM28458c = createdTime.m28458c();
                    long jM28458c2 = createdTime2.m28458c();
                    if (jM28458c > jM28458c2) {
                        return -1;
                    }
                    if (jM28458c < jM28458c2) {
                        return 1;
                    }
                }
            }
            return 0;
        }

        public /* synthetic */ k0(k kVar) {
            this();
        }
    }

    /* renamed from: p6.d$l */
    public class l extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f56022a;

        /* renamed from: b */
        public final /* synthetic */ String f56023b;

        /* renamed from: c */
        public final /* synthetic */ String f56024c;

        /* renamed from: d */
        public final /* synthetic */ Handler f56025d;

        public l(String str, String str2, String str3, Handler handler) {
            this.f56022a = str;
            this.f56023b = str2;
            this.f56024c = str3;
            this.f56025d = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                C12469b.m74746l().m74751e(this.f56022a, this.f56023b, this.f56024c);
            } catch (Exception e10) {
                C1120a.m6676e("AlbumShareManager", "deleteMember exception:" + e10.getMessage());
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1036;
            this.f56025d.sendMessageDelayed(messageObtain, 500L);
        }
    }

    /* renamed from: p6.d$l0 */
    public static class l0 implements Comparator<Media>, Serializable {
        private static final long serialVersionUID = 753232693119674635L;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Media media, Media media2) {
            C4644l editedTime = media.getEditedTime();
            C4644l editedTime2 = media2.getEditedTime();
            if (editedTime.m28458c() > editedTime2.m28458c()) {
                return -1;
            }
            return editedTime.m28458c() == editedTime2.m28458c() ? 0 : 1;
        }
    }

    /* renamed from: p6.d$m */
    public class m extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f56027a;

        /* renamed from: b */
        public final /* synthetic */ String f56028b;

        /* renamed from: c */
        public final /* synthetic */ String f56029c;

        /* renamed from: d */
        public final /* synthetic */ PermissionUpdateRequest f56030d;

        /* renamed from: e */
        public final /* synthetic */ Handler f56031e;

        public m(String str, String str2, String str3, PermissionUpdateRequest permissionUpdateRequest, Handler handler) {
            this.f56027a = str;
            this.f56028b = str2;
            this.f56029c = str3;
            this.f56030d = permissionUpdateRequest;
            this.f56031e = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                Permission permissionM74767w = C12469b.m74746l().m74767w(this.f56027a, this.f56028b, this.f56029c, this.f56030d);
                Message messageObtain = Message.obtain();
                messageObtain.obj = permissionM74767w;
                messageObtain.what = 1018;
                this.f56031e.sendMessage(messageObtain);
            } catch (C4616s e10) {
                C1120a.m6676e("AlbumShareManager", "doSaveOperation HttpResponseException " + e10.getMessage());
                C12091d.m72280a0().m72309H0(this.f56031e, e10);
                C12091d.m72280a0().m72307G0(e10, this.f56031e);
            } catch (Exception e11) {
                C1120a.m6676e("AlbumShareManager", "updateMember exception:" + e11.getMessage());
            }
        }
    }

    /* renamed from: p6.d$m0 */
    public static class m0 implements Comparator<com.huawei.android.hicloud.drive.cloudphoto.model.Message>, Serializable {
        private static final long serialVersionUID = -7038437957372029963L;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(com.huawei.android.hicloud.drive.cloudphoto.model.Message message, com.huawei.android.hicloud.drive.cloudphoto.model.Message message2) {
            long jM28458c = message.getCreatedTime().m28458c();
            long jM28458c2 = message2.getCreatedTime().m28458c();
            if (jM28458c > jM28458c2) {
                return -1;
            }
            return jM28458c == jM28458c2 ? 0 : 1;
        }
    }

    /* renamed from: p6.d$n */
    public class n extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Album f56033a;

        /* renamed from: b */
        public final /* synthetic */ List f56034b;

        /* renamed from: c */
        public final /* synthetic */ Handler f56035c;

        /* renamed from: d */
        public final /* synthetic */ Activity f56036d;

        public n(Album album, List list, Handler handler, Activity activity) {
            this.f56033a = album;
            this.f56034b = list;
            this.f56035c = handler;
            this.f56036d = activity;
        }

        /* renamed from: e */
        public static /* synthetic */ void m72408e(Activity activity) {
            C11841o.m70706b(activity, activity.getString(R$string.album_no_upload_permission), 0);
        }

        /* renamed from: f */
        public static /* synthetic */ void m72409f(Activity activity) {
            C11841o.m70706b(activity, activity.getString(R$string.album_have_deleted), 0);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                try {
                    int iM501h = C0069g.m479y().m501h(C12091d.m72280a0().m72369n0(this.f56033a, this.f56034b));
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 1035;
                    messageObtain.obj = this.f56033a;
                    messageObtain.arg1 = iM501h;
                    this.f56035c.sendMessage(messageObtain);
                } catch (C4616s e10) {
                    C1120a.m6676e("AlbumShareManager", "add upload task:HttpResponseException=" + e10.toString());
                    if (C1122c.m6699G1(e10)) {
                        C1120a.m6676e("AlbumShareManager", "user suspended");
                        Message messageObtain2 = Message.obtain();
                        messageObtain2.what = 2000;
                        this.f56035c.sendMessage(messageObtain2);
                    }
                    String strM7253d = C1160a.m7253d(e10);
                    if (strM7253d.endsWith("4036")) {
                        Handler handler = this.f56035c;
                        final Activity activity = this.f56036d;
                        handler.post(new Runnable() { // from class: p6.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                C12091d.n.m72408e(activity);
                            }
                        });
                    } else if ("31084041".equals(strM7253d)) {
                        Handler handler2 = this.f56035c;
                        final Activity activity2 = this.f56036d;
                        handler2.post(new Runnable() { // from class: p6.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                C12091d.n.m72409f(activity2);
                            }
                        });
                    } else {
                        C1122c.m6682B(e10, this.f56035c, this.f56036d);
                    }
                } catch (Exception e11) {
                    C1120a.m6676e("AlbumShareManager", "add upload task:Exception=" + e11.toString());
                }
            } finally {
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 1035;
                messageObtain3.obj = this.f56033a;
                messageObtain3.arg1 = 1;
                this.f56035c.sendMessage(messageObtain3);
            }
        }
    }

    /* renamed from: p6.d$n0 */
    public static class n0 extends AbstractC12367d {

        /* renamed from: a */
        public String f56038a;

        /* renamed from: b */
        public String f56039b;

        /* renamed from: c */
        public String f56040c;

        /* renamed from: d */
        public String f56041d;

        /* renamed from: e */
        public String f56042e;

        /* renamed from: f */
        public String f56043f;

        /* renamed from: g */
        public String f56044g;

        /* renamed from: h */
        public Handler f56045h;

        public n0(String str, String str2, String str3, String str4, String str5, String str6, String str7, Handler handler) {
            this.f56038a = str;
            this.f56039b = str2;
            this.f56040c = str3;
            this.f56041d = str4;
            this.f56042e = str5;
            this.f56043f = str6;
            this.f56044g = str7;
            this.f56045h = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                C12469b.m74746l().m74766v(this.f56038a, this.f56039b, this.f56041d, this.f56040c, this.f56043f, this.f56042e, this.f56044g);
                C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.approveApplicant"));
                Message messageObtain = Message.obtain();
                messageObtain.what = 1040;
                this.f56045h.sendMessage(messageObtain);
            } catch (C4616s e10) {
                C1120a.m6676e("AlbumShareManager", "approveApplicant HttpResponseException " + e10.getMessage());
                C12091d.m72280a0().m72309H0(this.f56045h, e10);
                C12091d.m72280a0().m72307G0(e10, this.f56045h);
            } catch (Exception e11) {
                C1120a.m6676e("AlbumShareManager", "approveApplicant exception:" + e11.getMessage());
            }
        }
    }

    /* renamed from: p6.d$o */
    public class o extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Handler f56046a;

        public o(Handler handler) {
            this.f56046a = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Applicant applicantM74756j;
            ArrayList<com.huawei.android.hicloud.drive.cloudphoto.model.Message> arrayListM77844o = new C12948h().m77844o();
            HashSet hashSet = new HashSet();
            Iterator<com.huawei.android.hicloud.drive.cloudphoto.model.Message> it = arrayListM77844o.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getAlbumId());
            }
            C12941a c12941a = new C12941a();
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                Album albumM77726A = c12941a.m77726A((String) it2.next(), false);
                if (albumM77726A != null) {
                    arrayList.add(albumM77726A);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            String strM80971t0 = C13452e.m80781L().m80971t0();
            Iterator<com.huawei.android.hicloud.drive.cloudphoto.model.Message> it3 = arrayListM77844o.iterator();
            while (it3.hasNext()) {
                com.huawei.android.hicloud.drive.cloudphoto.model.Message next = it3.next();
                C11423i c11423i = new C11423i();
                c11423i.m68452i(next.getMessageId());
                c11423i.m68451h(next);
                String strM72315L = C12091d.this.m72315L(next.getAlbumId(), arrayList);
                if (!TextUtils.isEmpty(strM72315L)) {
                    c11423i.m68448e(strM72315L);
                }
                c11423i.m68448e(strM72315L);
                if (next.getMessageType().intValue() == 1) {
                    try {
                        applicantM74756j = C12469b.m74746l().m74756j(next.getApplicantId());
                    } catch (Exception e10) {
                        C1120a.m6677i("AlbumShareManager", "getApplicant Exception:" + e10.getMessage());
                        applicantM74756j = null;
                    }
                    if (applicantM74756j != null) {
                        c11423i.m68449f(applicantM74756j);
                    }
                }
                if (next.getMessageType().intValue() != 2 || TextUtils.equals(strM80971t0, next.getSenderId())) {
                    if (next.getMessageType().intValue() != 7 || (TextUtils.equals(strM80971t0, next.getReceiverId()) && 1 != next.getAuditStatus())) {
                        c11423i.m68450g(false);
                        arrayList2.add(c11423i);
                    }
                }
            }
            C11423i c11423i2 = new C11423i();
            c11423i2.m68450g(true);
            arrayList2.add(c11423i2);
            Message messageObtain = Message.obtain();
            messageObtain.what = PlayerConstants.ErrorCode.UNSUPPORTED_BANDWIDTH;
            messageObtain.obj = arrayList2;
            this.f56046a.sendMessage(messageObtain);
            C12515a.m75110o().m75175e(new C12474g(), true);
        }
    }

    /* renamed from: p6.d$o0 */
    public static class o0 implements Comparator<C11422h>, Serializable {
        private static final long serialVersionUID = 1;

        public o0() {
        }

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(C11422h c11422h, C11422h c11422h2) {
            C4644l createdTime = c11422h.m68436b().getCreatedTime();
            C4644l createdTime2 = c11422h2.m68436b().getCreatedTime();
            if (createdTime == null && createdTime2 != null) {
                return -1;
            }
            if (createdTime != null && createdTime2 == null) {
                return 1;
            }
            if ((createdTime == null && createdTime2 == null) || createdTime == null || createdTime2 == null) {
                return 0;
            }
            return Long.valueOf(createdTime2.m28458c()).compareTo(Long.valueOf(createdTime.m28458c()));
        }

        public /* synthetic */ o0(k kVar) {
            this();
        }
    }

    /* renamed from: p6.d$p */
    public class p extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Handler f56048a;

        public p(Handler handler) {
            this.f56048a = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Album albumM77726A;
            ArrayList<com.huawei.android.hicloud.drive.cloudphoto.model.Message> arrayListM77844o = new C12948h().m77844o();
            if (arrayListM77844o.isEmpty()) {
                C1120a.m6677i("AlbumShareManager", "getNewMsg messages null");
            }
            C1120a.m6675d("AlbumShareManager", "getNewMsg messages count:" + arrayListM77844o.toString());
            HashMap map = new HashMap();
            C12941a c12941a = new C12941a();
            Iterator<com.huawei.android.hicloud.drive.cloudphoto.model.Message> it = arrayListM77844o.iterator();
            while (it.hasNext()) {
                com.huawei.android.hicloud.drive.cloudphoto.model.Message next = it.next();
                if (!next.isRead() && next.getMessageType().intValue() == 2 && (albumM77726A = c12941a.m77726A(next.getAlbumId(), false)) != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Permission> it2 = albumM77726A.getPermissions().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next().getUserId());
                    }
                    if (arrayList.contains(next.getSenderId())) {
                        C12091d.this.m72368n(next, map);
                    }
                }
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1030;
            messageObtain.obj = map;
            this.f56048a.sendMessage(messageObtain);
        }
    }

    /* renamed from: p6.d$p0 */
    public static class p0 implements Comparator<ShareAlbumInfo>, Serializable {
        private static final long serialVersionUID = -7620083979113175048L;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(ShareAlbumInfo shareAlbumInfo, ShareAlbumInfo shareAlbumInfo2) {
            long endEditorTime = shareAlbumInfo.getEndEditorTime();
            long endEditorTime2 = shareAlbumInfo2.getEndEditorTime();
            if (endEditorTime > endEditorTime2) {
                return -1;
            }
            return endEditorTime == endEditorTime2 ? 0 : 1;
        }
    }

    /* renamed from: p6.d$q */
    public class q extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f56050a;

        public q(String str) {
            this.f56050a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            new C12948h().m77846q(true, this.f56050a);
        }
    }

    /* renamed from: p6.d$q0 */
    public static class q0 implements Runnable {

        /* renamed from: a */
        public Bitmap f56052a;

        /* renamed from: b */
        public ImageView f56053b;

        public q0(Bitmap bitmap, ImageView imageView) {
            this.f56052a = bitmap;
            this.f56053b = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView;
            Bitmap bitmap = this.f56052a;
            if (bitmap == null || (imageView = this.f56053b) == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    /* renamed from: p6.d$r */
    public class r extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Handler f56054a;

        public r(Handler handler) {
            this.f56054a = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Applicant applicantM74756j;
            ArrayList<com.huawei.android.hicloud.drive.cloudphoto.model.Message> arrayListM77844o = new C12948h().m77844o();
            String strM80971t0 = C13452e.m80781L().m80971t0();
            Iterator<com.huawei.android.hicloud.drive.cloudphoto.model.Message> it = arrayListM77844o.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                com.huawei.android.hicloud.drive.cloudphoto.model.Message next = it.next();
                if (next.getMessageType().intValue() == 1) {
                    try {
                        applicantM74756j = C12469b.m74746l().m74756j(next.getApplicantId());
                    } catch (Exception e10) {
                        C1120a.m6677i("AlbumShareManager", "getApplicant Exception:" + e10.getMessage());
                        applicantM74756j = null;
                    }
                    if (applicantM74756j == null) {
                    }
                }
                if (next.getMessageType().intValue() != 2 || TextUtils.equals(strM80971t0, next.getSenderId())) {
                    if (next.getMessageType().intValue() != 7 || (TextUtils.equals(strM80971t0, next.getReceiverId()) && 1 != next.getAuditStatus())) {
                        if (!next.isRead()) {
                            i10++;
                        }
                    }
                }
            }
            C1120a.m6677i("AlbumShareManager", "unreadMsg count:" + i10);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1027;
            messageObtain.obj = Integer.valueOf(i10);
            this.f56054a.sendMessage(messageObtain);
        }
    }

    /* renamed from: p6.d$s */
    public class s extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ List f56056a;

        public s(List list) {
            this.f56056a = list;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12948h c12948h = new C12948h();
            Iterator it = this.f56056a.iterator();
            while (it.hasNext()) {
                c12948h.m77846q(true, ((C11423i) it.next()).m68447d());
            }
        }
    }

    /* renamed from: p6.d$t */
    public class t extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Handler f56058a;

        public t(Handler handler) {
            this.f56058a = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            ArrayList<GalleryAlbum> arrayListM77766c = C12944d.m77766c();
            Message messageObtain = Message.obtain();
            messageObtain.what = 1034;
            messageObtain.obj = arrayListM77766c;
            this.f56058a.sendMessage(messageObtain);
        }
    }

    /* renamed from: p6.d$u */
    public class u extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f56060a;

        public u(Context context) {
            this.f56060a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C1122c.m6685C(this.f56060a);
        }
    }

    /* renamed from: p6.d$v */
    public class v extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f56062a;

        /* renamed from: b */
        public final /* synthetic */ List f56063b;

        /* renamed from: c */
        public final /* synthetic */ C11417c f56064c;

        /* renamed from: d */
        public final /* synthetic */ String f56065d;

        /* renamed from: e */
        public final /* synthetic */ Handler f56066e;

        public v(Context context, List list, C11417c c11417c, String str, Handler handler) {
            this.f56062a = context;
            this.f56063b = list;
            this.f56064c = c11417c;
            this.f56065d = str;
            this.f56066e = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            List list;
            if (this.f56062a == null || (list = this.f56063b) == null || list.size() == 0) {
                C1120a.m6676e("AlbumShareManager", "transMediaFileData data is null");
                return;
            }
            List listM72365l1 = C12091d.this.m72365l1(this.f56062a, this.f56063b, this.f56064c, this.f56065d, true);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1037;
            messageObtain.obj = listM72365l1;
            this.f56066e.sendMessage(messageObtain);
        }
    }

    /* renamed from: p6.d$w */
    public class w extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f56068a;

        /* renamed from: b */
        public final /* synthetic */ Handler f56069b;

        /* renamed from: c */
        public final /* synthetic */ int f56070c;

        /* renamed from: d */
        public final /* synthetic */ String f56071d;

        public w(Context context, Handler handler, int i10, String str) {
            this.f56068a = context;
            this.f56069b = handler;
            this.f56070c = i10;
            this.f56071d = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12091d.this.m72331T0(this.f56068a, this.f56069b, this.f56070c, this.f56071d, false);
        }
    }

    /* renamed from: p6.d$x */
    public class x extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f56073a;

        /* renamed from: b */
        public final /* synthetic */ Handler f56074b;

        /* renamed from: c */
        public final /* synthetic */ int f56075c;

        /* renamed from: d */
        public final /* synthetic */ String f56076d;

        public x(Context context, Handler handler, int i10, String str) {
            this.f56073a = context;
            this.f56074b = handler;
            this.f56075c = i10;
            this.f56076d = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12091d.this.m72331T0(this.f56073a, this.f56074b, this.f56075c, this.f56076d, true);
        }
    }

    /* renamed from: p6.d$y */
    public class y extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f56078a;

        /* renamed from: b */
        public final /* synthetic */ Handler f56079b;

        /* renamed from: c */
        public final /* synthetic */ int f56080c;

        /* renamed from: d */
        public final /* synthetic */ String f56081d;

        public y(Context context, Handler handler, int i10, String str) {
            this.f56078a = context;
            this.f56079b = handler;
            this.f56080c = i10;
            this.f56081d = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12091d.this.m72331T0(this.f56078a, this.f56079b, this.f56080c, this.f56081d, false);
        }
    }

    /* renamed from: p6.d$z */
    public class z extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f56083a;

        /* renamed from: b */
        public final /* synthetic */ Handler f56084b;

        /* renamed from: c */
        public final /* synthetic */ int f56085c;

        /* renamed from: d */
        public final /* synthetic */ String f56086d;

        public z(Context context, Handler handler, int i10, String str) {
            this.f56083a = context;
            this.f56084b = handler;
            this.f56085c = i10;
            this.f56086d = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12091d.this.m72335V0(this.f56083a, this.f56084b, this.f56085c, this.f56086d, "album_id_normal_full");
        }
    }

    public /* synthetic */ C12091d(k kVar) {
        this();
    }

    /* renamed from: K0 */
    public static /* synthetic */ int m72277K0(C11425k c11425k, C11425k c11425k2) {
        return Long.valueOf(c11425k2.m68466b()).compareTo(Long.valueOf(c11425k.m68466b()));
    }

    /* renamed from: L0 */
    public static /* synthetic */ int m72278L0(MediaFileBean mediaFileBean, MediaFileBean mediaFileBean2) {
        return Long.valueOf(mediaFileBean2.m14348q()).compareTo(Long.valueOf(mediaFileBean.m14348q()));
    }

    /* renamed from: a0 */
    public static C12091d m72280a0() {
        return j0.f56020a;
    }

    /* renamed from: a1 */
    public static void m72281a1(C11415a c11415a) {
        f55947v = c11415a;
    }

    /* renamed from: A */
    public void m72294A(Album album, ImageView imageView, boolean z10) {
        String coverImage = album.getCoverImage();
        Media mediaM72334V = !TextUtils.isEmpty(coverImage) ? m72334V(coverImage) : z10 ? m72314K(album.getId()) : null;
        String localBigThumbPath = mediaM72334V == null ? "" : mediaM72334V.getLocalBigThumbPath();
        if (TextUtils.isEmpty(localBigThumbPath)) {
            C12096i.m72418I().m72472v(album.getId(), imageView, mediaM72334V, album.getAlbumOwnerId());
            return;
        }
        Bitmap bitmapM6719N0 = C1122c.m6719N0(C0209d.m1311u(localBigThumbPath), m72364l0(mediaM72334V));
        imageView.setTag(C0069g.m479y().m480A(mediaM72334V));
        imageView.setImageBitmap(bitmapM6719N0);
    }

    /* renamed from: A0 */
    public void m72295A0(Handler handler) {
        C12515a.m75110o().m75175e(new r(handler), false);
    }

    /* renamed from: B */
    public void m72296B(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        C12096i.m72418I().m72473w(str, imageView);
    }

    /* renamed from: B0 */
    public void m72297B0(String str, Handler handler) {
        if (handler != null) {
            C12515a.m75110o().m75175e(new c0(str, handler), false);
        }
    }

    /* renamed from: C */
    public void m72298C(Media media, ImageView imageView) {
        String strM480A = C0069g.m479y().m480A(media);
        if (imageView != null) {
            imageView.setTag(strM480A);
        }
        C12096i.m72418I().m72474x(media, imageView);
    }

    /* renamed from: C0 */
    public String m72299C0() {
        return "";
    }

    /* renamed from: D */
    public void m72300D(Media media, ImageView imageView, int i10) {
        String strM480A = C0069g.m479y().m480A(media);
        if (imageView != null) {
            imageView.setTag(strM480A);
        }
        C12096i.m72418I().m72475y(media, imageView, i10);
    }

    /* renamed from: D0 */
    public final String m72301D0(Context context, int i10, int i11) throws Resources.NotFoundException {
        if (i11 > 0) {
            if (i10 == 0) {
                return context.getResources().getQuantityString(R$plurals.baby_album_title_month, i11, Integer.valueOf(i11));
            }
            return context.getResources().getString(R$string.baby_album_title_partly_age, context.getResources().getQuantityString(R$plurals.baby_album_title_month, i11, Integer.valueOf(i11)), context.getResources().getQuantityString(R$plurals.baby_album_title_day, i10, Integer.valueOf(i10)));
        }
        if (i11 != 0) {
            return "";
        }
        if (i10 == 0) {
            return context.getString(R$string.baby_album_title_born);
        }
        if (i10 <= 0) {
            return "";
        }
        int i12 = i10 + 1;
        return context.getString(R$string.baby_album_title_month_or_day_only, context.getResources().getQuantityString(R$plurals.baby_album_title_day, i12, Integer.valueOf(i12)));
    }

    /* renamed from: E */
    public boolean m72302E(Album album, ImageView imageView) {
        Media mediaM72314K = m72314K(album.getId());
        String localBigThumbPath = mediaM72314K == null ? "" : mediaM72314K.getLocalBigThumbPath();
        if (!TextUtils.isEmpty(localBigThumbPath)) {
            Bitmap bitmapM6719N0 = C1122c.m6719N0(C0209d.m1311u(localBigThumbPath), m72364l0(mediaM72314K));
            imageView.setTag(C0069g.m479y().m480A(mediaM72314K));
            imageView.setImageBitmap(bitmapM6719N0);
            return true;
        }
        if (mediaM72314K == null) {
            return false;
        }
        imageView.setTag(C0069g.m479y().m480A(mediaM72314K));
        C12096i.m72418I().m72474x(mediaM72314K, imageView);
        return true;
    }

    /* renamed from: E0 */
    public void m72303E0(Activity activity, int i10) {
        m72305F0(activity, i10, null, null);
    }

    /* renamed from: F */
    public void m72304F(Media media, ImageView imageView) {
        String strM480A = C0069g.m479y().m480A(media);
        if (imageView != null) {
            imageView.setTag(strM480A);
        }
        C12096i.m72418I().m72436E(media, imageView);
    }

    /* renamed from: F0 */
    public void m72305F0(Activity activity, int i10, String str, List<MediaFileBean> list) {
        if (CloudAlbumSettings.m14363h().m14388x()) {
            Intent intent = new Intent(activity, (Class<?>) PhotoPickerActivity.class);
            intent.putExtra("extra_max_selected_count", 100);
            if (list != null) {
                intent.putExtra("select-item-list-key", str);
                intent.putParcelableArrayListExtra("select-item-list", new ArrayList<>(list));
            }
            C0224k0.m1544N(activity, intent, i10);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
        C0209d.m1302r2(intent2, C13843a.m83054F(activity));
        intent2.setType("video/*;image/*");
        intent2.putExtra("support-multipick-items", true);
        intent2.putExtra("max-select-count", 100);
        intent2.putExtra("return-uris-for-multipick", true);
        intent2.putExtra("android.intent.extra.LOCAL_ONLY", true);
        C0224k0.m1544N(activity, intent2, i10);
    }

    /* renamed from: G */
    public boolean m72306G(Album album, ImageView imageView) {
        String coverImage = album.getCoverImage();
        C1120a.m6675d("AlbumShareManager", "displayShareHeadPic coverImage: " + coverImage);
        Media mediaM72334V = m72313J0(album) ? m72334V(coverImage) : m72314K(album.getId());
        String localBigThumbPath = mediaM72334V == null ? "" : mediaM72334V.getLocalBigThumbPath();
        if (!TextUtils.isEmpty(localBigThumbPath)) {
            Bitmap bitmapM6719N0 = C1122c.m6719N0(C0209d.m1311u(localBigThumbPath), m72364l0(mediaM72334V));
            imageView.setTag(C0069g.m479y().m480A(mediaM72334V));
            imageView.setImageBitmap(bitmapM6719N0);
            return true;
        }
        if (mediaM72334V == null) {
            return false;
        }
        imageView.setTag(C0069g.m479y().m480A(mediaM72334V));
        C12096i.m72418I().m72474x(mediaM72334V, imageView);
        return true;
    }

    /* renamed from: G0 */
    public void m72307G0(C4616s c4616s, Handler handler) {
        int iM6802l0 = C1122c.m6802l0(c4616s);
        C1120a.m6676e("AlbumShareManager", "handleErrorStatus errorCode " + iM6802l0);
        Message messageObtain = Message.obtain();
        messageObtain.what = iM6802l0;
        handler.sendMessage(messageObtain);
    }

    /* renamed from: H */
    public void m72308H(String str, String str2, Handler handler) {
        C12515a.m75110o().m75175e(new g(str, str2, handler), false);
    }

    /* renamed from: H0 */
    public void m72309H0(Handler handler, C4616s c4616s) {
        int iM6802l0 = C1122c.m6802l0(c4616s);
        C1120a.m6676e("AlbumShareManager", "handleErrorStatus errorCode " + iM6802l0);
        if (4956 == iM6802l0) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 4956;
            handler.sendMessage(messageObtain);
        }
    }

    /* renamed from: I */
    public Album m72310I(String str) {
        return new C12941a().m77726A(str, false);
    }

    /* renamed from: I0 */
    public boolean m72311I0(Album album) {
        return new C12947g().m77807T(album.getBackgroundImage()) != null;
    }

    /* renamed from: J */
    public void m72312J(String str) {
        C12515a.m75110o().m75175e(new C12100m(str), true);
    }

    /* renamed from: J0 */
    public boolean m72313J0(Album album) {
        return new C12947g().m77807T(album.getCoverImage()) != null;
    }

    /* renamed from: K */
    public Media m72314K(String str) {
        ArrayList<Media> arrayListM77801N = new C12947g().m77801N(str, 0L, 1L);
        if (arrayListM77801N.isEmpty()) {
            return null;
        }
        return arrayListM77801N.get(0);
    }

    /* renamed from: L */
    public final String m72315L(String str, ArrayList<Album> arrayList) {
        Iterator<Album> it = arrayList.iterator();
        while (it.hasNext()) {
            Album next = it.next();
            if (TextUtils.equals(str, next.getId())) {
                return next.getAlbumName();
            }
        }
        return "";
    }

    /* renamed from: M */
    public List<C11422h> m72316M() {
        List<C11422h> list;
        synchronized (f55938m) {
            list = f55946u;
        }
        return list;
    }

    /* renamed from: M0 */
    public void m72317M0(Album album, Handler handler, Activity activity) {
        C12515a.m75110o().m75175e(new e(album, handler, activity), false);
    }

    /* renamed from: N */
    public void m72318N(String str, Handler handler) {
        if (handler != null) {
            C12515a.m75110o().m75175e(new i0(str, handler), true);
        }
    }

    /* renamed from: N0 */
    public void m72319N0(String str, String str2, String str3, String str4, String str5, String str6, String str7, Handler handler) {
        C12515a.m75110o().m75175e(new n0(str, str2, str3, str4, str5, str6, str7, handler), false);
    }

    /* renamed from: O */
    public void m72320O(String str, Handler handler) {
        C12515a.m75110o().m75175e(new a(str, handler), false);
    }

    /* renamed from: O0 */
    public void m72321O0(Context context) {
        if (context == null) {
            C1120a.m6676e("AlbumShareManager", "notifyCreatAlbumSuccess context is null");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.intent.action.create.album.success");
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: P */
    public void m72322P(Context context, String str, int i10, Handler handler) {
        if (handler != null) {
            C12515a.m75110o().m75175e(new h0(str, handler), true);
        }
    }

    /* renamed from: P0 */
    public void m72323P0(Context context, Handler handler, int i10, String str) {
        C12515a.m75110o().m75175e(new z(context, handler, i10, str), true);
    }

    /* renamed from: Q */
    public void m72324Q(String str, String str2, Handler handler) {
        C12515a.m75110o().m75175e(new j(str, str2, handler), false);
    }

    /* renamed from: Q0 */
    public void m72325Q0(Context context, Handler handler, int i10, String str) {
        C12515a.m75110o().m75175e(new x(context, handler, i10, str), true);
    }

    /* renamed from: R */
    public void m72326R(Handler handler) {
        C12515a.m75110o().m75175e(new o(handler), false);
    }

    /* renamed from: R0 */
    public void m72327R0(Context context, Handler handler, int i10, String str) {
        C12515a.m75110o().m75175e(new w(context, handler, i10, str), true);
    }

    /* renamed from: S */
    public void m72328S() {
        C12515a.m75110o().m75175e(new C12098k(), true);
    }

    /* renamed from: S0 */
    public void m72329S0(Context context, Handler handler, int i10, String str) {
        C12515a.m75110o().m75175e(new y(context, handler, i10, str), false);
    }

    /* renamed from: T */
    public void m72330T(String str, Handler handler) {
        C12515a.m75110o().m75175e(new h(str, handler), false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0049  */
    /* renamed from: T0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m72331T0(android.content.Context r9, android.os.Handler r10, int r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p546p6.C12091d.m72331T0(android.content.Context, android.os.Handler, int, java.lang.String, boolean):void");
    }

    /* renamed from: U */
    public String m72332U(Context context, long j10, long j11) throws Resources.NotFoundException {
        if (j11 == 0) {
            C1120a.m6676e("AlbumShareManager", "getBabyAlbumAge babyBirthdayMills is 0");
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String str = simpleDateFormat.format(new Date(j11));
        String str2 = simpleDateFormat.format(Long.valueOf(j10));
        C1120a.m6675d("AlbumShareManager", "birthDate:" + str + " nowDate:" + str2);
        try {
            long time = simpleDateFormat.parse(str).getTime();
            long time2 = simpleDateFormat.parse(str2).getTime();
            long j12 = time2 - time;
            if (j12 <= 0) {
                int i10 = (int) ((time / 86400000) - (time2 / 86400000));
                if (i10 == 0) {
                    return context.getString(R$string.baby_album_title_born);
                }
                if (i10 > 0) {
                    return context.getResources().getQuantityString(R$plurals.baby_album_title_before_born, i10, Integer.valueOf(i10));
                }
            }
            long j13 = j12 / 86400000;
            if (j13 == 29) {
                return context.getString(R$string.baby_album_title_full_month);
            }
            if (j13 == 99) {
                return context.getString(R$string.baby_album_title_hundred_day);
            }
            if (j13 < 99) {
                int i11 = ((int) j13) + 1;
                return context.getString(R$string.baby_album_title_month_or_day_only, context.getResources().getQuantityString(R$plurals.baby_album_title_day, i11, Integer.valueOf(i11)));
            }
            Date date = new Date(j11);
            Date date2 = new Date(j10);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date2);
            int i12 = gregorianCalendar.get(1);
            int i13 = gregorianCalendar.get(2);
            int i14 = i13 + 1;
            int iM72356h0 = gregorianCalendar.get(5);
            gregorianCalendar.setTime(date);
            int i15 = gregorianCalendar.get(1);
            int i16 = gregorianCalendar.get(2) + 1;
            int i17 = gregorianCalendar.get(5);
            C1120a.m6675d("AlbumShareManager", "yearBirth: " + i15 + " monthBirth: " + i16 + "dayBirth: " + i17);
            C1120a.m6675d("AlbumShareManager", "yearNow: " + i12 + " monthNow: " + i14 + "dayNow: " + iM72356h0);
            if (i17 > iM72356h0) {
                iM72356h0 += m72356h0(i12, i13);
            } else {
                i13 = i14;
            }
            int i18 = iM72356h0 - i17;
            if (i16 > i13) {
                i13 += 12;
                i12--;
            }
            int i19 = i13 - i16;
            int i20 = i12 - i15;
            if (i20 == 0) {
                String strM72301D0 = m72301D0(context, i18, i19);
                if (strM72301D0 != null) {
                    return strM72301D0;
                }
            } else {
                String strM72360j0 = m72360j0(context, i18, i19, i20);
                if (strM72360j0 != null) {
                    return strM72360j0;
                }
            }
            return "";
        } catch (ParseException e10) {
            C1120a.m6676e("AlbumShareManager", "dateFormat parse:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: U0 */
    public void m72333U0(Context context, Handler handler, int i10, String str) {
        C12515a.m75110o().m75175e(new a0(context, handler, i10, str), true);
    }

    /* renamed from: V */
    public Media m72334V(String str) {
        return new C12947g().m77807T(str);
    }

    /* renamed from: V0 */
    public final void m72335V0(Context context, Handler handler, int i10, String str, String str2) {
        Integer num;
        if (context == null) {
            C1120a.m6676e("AlbumShareManager", "queryMediaDataFromPicTab context is null");
            return;
        }
        boolean zEquals = str2.equals("album_id_picture");
        boolean zEquals2 = str2.equals("album_id_video");
        int i11 = i10 - C1122c.f5363q;
        int i12 = C1122c.f5362p;
        if (i11 < 0) {
            i11 = 0;
        }
        int i13 = i11;
        C12947g c12947g = new C12947g();
        C1120a.m6675d("AlbumShareManager", "queryMediaDataFromPicTab startPosition = " + i13 + " startTime = " + System.currentTimeMillis());
        if (str == null || str.isEmpty()) {
            C1120a.m6675d("AlbumShareManager", "queryMediaDataFromPicTab startPosition = " + i13 + " startTime = " + System.currentTimeMillis());
            return;
        }
        ArrayList<Media> arrayListM77798K = !str2.equals("album_id_picture") ? !str2.equals("album_id_video") ? c12947g.m77798K(str, i13, i12) : c12947g.m77816c0(str, i13, i12) : c12947g.m77811X(str, i13, i12);
        C1120a.m6675d("AlbumShareManager", "queryMediaDataFromPicTab  startPosition = " + i13 + " endTime = " + System.currentTimeMillis());
        Map<String, Integer> mapM481B = C0069g.m479y().m481B(str);
        Iterator<Media> it = arrayListM77798K.iterator();
        while (it.hasNext()) {
            Media next = it.next();
            MediaFileBean mediaFileBean = new MediaFileBean();
            mediaFileBean.m14332f0(C1122c.m6844x(next));
            mediaFileBean.m14354u0(C0069g.m479y().m480A(next));
            mediaFileBean.m14336h0(next.getCreatedTime().m28458c());
            mediaFileBean.m14319V(Uri.parse(next.getLocalRealPath()));
            mediaFileBean.m14318U(next.getFileName());
            mediaFileBean.m14357w0(6);
            if (mapM481B != null && !mapM481B.isEmpty() && (num = mapM481B.get(mediaFileBean.m14306A())) != null) {
                mediaFileBean.m14357w0(num.intValue());
                if (mediaFileBean.m14308K() != 6) {
                    mediaFileBean.m14344o().setOpType(1);
                }
                mapM481B.remove(mediaFileBean.m14306A());
            }
            m72376p1(mediaFileBean, mediaFileBean);
            mediaFileBean.m14314Q(true);
            C1122c.m6784g2(next, mediaFileBean);
            mediaFileBean.m14326c0(i13);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(zEquals ? "share_home_picture" : zEquals2 ? "share_home_vedio" : "");
            sb2.append(i13);
            String string = sb2.toString();
            C1120a.m6677i("AlbumShareManager", "bindPictureViewHolder, addMedia positionUniqueId= " + string);
            C1132m.m6921c().m6922a(string, next);
            C1132m.m6921c().m6923b(string, mediaFileBean);
            i13++;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1042;
        handler.sendMessage(messageObtain);
    }

    /* renamed from: W */
    public JSONObject m72336W(String str, String str2, String str3) {
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), str, "1", C13452e.m80781L().m80971t0(), "2");
        try {
            jSONObjectM79482j.put("album_type", str2);
            jSONObjectM79482j.put("content_type", str3);
        } catch (JSONException e10) {
            C11839m.m70687e("AlbumShareManager", "ERROR OCCUR:" + e10.getMessage());
        }
        return jSONObjectM79482j;
    }

    /* renamed from: W0 */
    public void m72337W0(Context context, Handler handler, int i10, String str) {
        C12515a.m75110o().m75175e(new b0(context, handler, i10, str), true);
    }

    /* renamed from: X */
    public C11415a m72338X() {
        return f55947v;
    }

    /* renamed from: X0 */
    public void m72339X0(String str, String str2, Handler handler) {
        C12515a.m75110o().m75175e(new c(str, str2, handler), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x01b5 A[SYNTHETIC] */
    /* renamed from: Y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.android.p069cg.bean.MediaFileBean> m72340Y(android.content.Context r27, java.util.List<android.net.Uri> r28) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p546p6.C12091d.m72340Y(android.content.Context, java.util.List):java.util.List");
    }

    /* renamed from: Y0 */
    public void m72341Y0(String str, String str2) {
        C1120a.m6675d("AlbumShareManager", "reportClickJoinShareAlbum eventCode " + str + " eventFrom " + str2);
        C13224c.m79487f1().m79585f0(str, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", str, "1", str2);
    }

    /* renamed from: Z */
    public void m72342Z(Handler handler) {
        if (handler != null) {
            C12515a.m75110o().m75175e(new t(handler), false);
        }
    }

    /* renamed from: Z0 */
    public void m72343Z0(List<Permission> list) {
        synchronized (f55938m) {
            try {
                f55946u.clear();
                for (Permission permission : list) {
                    C11422h c11422h = new C11422h();
                    c11422h.m68443i(permission);
                    c11422h.m68442h(permission.getDisplayName());
                    f55946u.add(c11422h);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b0 */
    public void m72344b0(String str, Handler handler) {
        if (handler != null) {
            C12515a.m75110o().m75175e(new f(str, handler), false);
        }
    }

    /* renamed from: b1 */
    public void m72345b1(List<C11423i> list) {
        C12515a.m75110o().m75175e(new s(list), false);
    }

    /* renamed from: c0 */
    public void m72346c0(Handler handler) {
        C1120a.m6677i("AlbumShareManager", "getJoinRequestInfo");
        if (handler != null) {
            C12515a.m75110o().m75175e(new g0(handler), false);
        }
    }

    /* renamed from: c1 */
    public void m72347c1(String str) {
        C12515a.m75110o().m75175e(new q(str), false);
    }

    /* renamed from: d0 */
    public final List<String> m72348d0(List<com.huawei.android.hicloud.drive.cloudphoto.model.Message> list) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (com.huawei.android.hicloud.drive.cloudphoto.model.Message message : list) {
            if (i10 >= 3) {
                break;
            }
            arrayList.add(message.getSenderId());
            i10++;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        if (size == 0) {
            return arrayList2;
        }
        while (size > 0) {
            arrayList2.add((String) arrayList.get(size - 1));
            size--;
        }
        return arrayList2;
    }

    /* renamed from: d1 */
    public void m72349d1(List<C11424j> list) {
        synchronized (f55937l) {
            this.f55948a.clear();
            this.f55948a.addAll(list);
        }
    }

    /* renamed from: e0 */
    public String m72350e0(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "father":
                return context.getString(R$string.relation_father);
            case "mother":
                return context.getString(R$string.relation_mother);
            case "grandfather":
                return context.getString(R$string.relation_grandpaa);
            case "grandmother":
                return context.getString(R$string.relation_grandmaa);
            case "other":
                return context.getString(R$string.relation_other);
            case "grandma":
                return context.getString(R$string.relation_grandma);
            case "grandpa":
                return context.getString(R$string.relation_grandpa);
            default:
                return "";
        }
    }

    /* renamed from: e1 */
    public void m72351e1(int i10) {
        this.f55953f = i10;
    }

    /* renamed from: f0 */
    public KvDatabaseWrapper m72352f0() {
        KvDatabaseWrapper kvDatabaseWrapper;
        synchronized (f55941p) {
            if (this.f55954g == null) {
                try {
                    this.f55954g = new KvDatabaseWrapper(C0213f.m1377a());
                } catch (IOException e10) {
                    C1120a.m6676e("AlbumShareManager", "initKvdb exception:" + e10.toString());
                }
                kvDatabaseWrapper = this.f55954g;
            } else {
                kvDatabaseWrapper = this.f55954g;
            }
        }
        return kvDatabaseWrapper;
    }

    /* renamed from: f1 */
    public void m72353f1(String str, C11415a c11415a) {
        synchronized (f55936k) {
            if (str == null) {
                str = "";
            }
            try {
                this.f55952e.put(str, c11415a);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g0 */
    public void m72354g0(String str, String str2, String str3, Handler handler) {
        C12515a.m75110o().m75175e(new d(str, str2, str3, handler), false);
    }

    /* renamed from: g1 */
    public void m72355g1(List<C11415a> list) {
        synchronized (f55939n) {
            f55945t.clear();
            f55945t.addAll(list);
        }
    }

    /* renamed from: h0 */
    public final int m72356h0(int i10, int i11) {
        if (i11 == 1 || i11 == 3 || i11 == 5 || i11 == 7 || i11 == 8 || i11 == 10 || i11 == 12) {
            return 31;
        }
        if (i11 == 4 || i11 == 6 || i11 == 9 || i11 == 11) {
            return 30;
        }
        if (i11 == 2) {
            return new GregorianCalendar().isLeapYear(i10) ? 29 : 28;
        }
        return 0;
    }

    /* renamed from: h1 */
    public void m72357h1(String str, List<DayModeGroup> list) {
        synchronized (f55935j) {
            if (str == null) {
                str = "";
            }
            try {
                this.f55951d.put(str, list);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: i0 */
    public void m72358i0(Handler handler) {
        C12515a.m75110o().m75175e(new p(handler), false);
    }

    /* renamed from: i1 */
    public void m72359i1(Activity activity) {
        if (activity == null) {
            C1120a.m6676e("AlbumShareManager", "showAccountRiskManageDialog ");
        } else {
            new ViewOnClickListenerC11636a(activity).show();
        }
    }

    /* renamed from: j0 */
    public final String m72360j0(Context context, int i10, int i11, int i12) throws Resources.NotFoundException {
        if (i11 == 0) {
            if (i10 == 0) {
                return context.getString(R$string.baby_album_title_year_only, context.getResources().getQuantityString(R$plurals.baby_album_title_year, i12, Integer.valueOf(i12)));
            }
            return context.getString(R$string.baby_album_title_partly_age, context.getResources().getQuantityString(R$plurals.baby_album_title_year, i12, Integer.valueOf(i12)), context.getResources().getQuantityString(R$plurals.baby_album_title_day, i10, Integer.valueOf(i10)));
        }
        if (i11 <= 0) {
            return "";
        }
        if (i10 == 0) {
            return context.getString(R$string.baby_album_title_partly_age, context.getResources().getQuantityString(R$plurals.baby_album_title_year, i12, Integer.valueOf(i12)), context.getResources().getQuantityString(R$plurals.baby_album_title_month, i11, Integer.valueOf(i11)));
        }
        if (i10 <= 0) {
            return "";
        }
        return context.getString(R$string.baby_album_title_full_age, context.getResources().getQuantityString(R$plurals.baby_album_title_year, i12, Integer.valueOf(i12)), context.getResources().getQuantityString(R$plurals.baby_album_title_month, i11, Integer.valueOf(i11)), context.getResources().getQuantityString(R$plurals.baby_album_title_day, i10, Integer.valueOf(i10)));
    }

    @SuppressLint({"StringFormatInvalid"})
    /* renamed from: j1 */
    public void m72361j1(Activity activity, int i10, String str) {
        if (activity == null) {
            C1120a.m6676e("AlbumShareManager", "context is null");
            return;
        }
        if (4956 == i10) {
            C11841o.m70706b(activity, activity.getString(R$string.sensitive_word), 0);
            return;
        }
        if (4038 == i10) {
            C11841o.m70706b(activity, activity.getString(R$string.server_error), 0);
            return;
        }
        if (4971 == i10) {
            C11841o.m70706b(activity, activity.getString(R$string.reach_max_times), 0);
            return;
        }
        if (4966 == i10) {
            C11841o.m70706b(activity, activity.getString(R$string.member_full), 0);
            return;
        }
        if (4965 == i10) {
            if (TextUtils.isEmpty(str)) {
                C1120a.m6676e("AlbumShareManager", "remark is null");
                return;
            } else {
                C11841o.m70706b(activity, activity.getString(R$string.other_account_applied, str), 0);
                return;
            }
        }
        if (4004 == i10) {
            C11841o.m70706b(activity, activity.getString(R$string.invitation_code_dialog_error_tips), 0);
            return;
        }
        if (4946 == i10) {
            C11841o.m70706b(activity, activity.getString(R$string.error_account_forbid), 0);
            return;
        }
        if (4050 == i10) {
            C11841o.m70706b(activity, activity.getString(R$string.album_have_deleted), 0);
            return;
        }
        if (4974 == i10) {
            C11841o.m70706b(activity, activity.getString(R$string.apply_have_send), 0);
        } else if (4969 == i10) {
            C11841o.m70706b(activity, activity.getString(R$string.inviter_link_used_toast), 0);
        } else if (4031 == i10) {
            C11841o.m70706b(activity, activity.getString(R$string.data_migrating_toast), 0);
        }
    }

    /* renamed from: k0 */
    public void m72362k0(Handler handler, ShareAlbumInfo shareAlbumInfo) {
        C1120a.m6677i("AlbumShareManager", "getOneShareAlbumPartOfPics");
        if (handler != null) {
            C12515a.m75110o().m75175e(new e0(shareAlbumInfo, handler), false);
        }
    }

    /* renamed from: k1 */
    public void m72363k1(Context context, Handler handler, List<MediaFileBean> list, C11417c c11417c, String str) {
        C12515a.m75110o().m75175e(new v(context, list, c11417c, str, handler), false);
    }

    /* renamed from: l0 */
    public final int m72364l0(Media media) {
        if (media == null) {
            C1120a.m6678w("AlbumShareManager", "getOriention media is null");
            return -1;
        }
        int iIntValue = media.getFileType().intValue();
        if (media.getRotation() != 1) {
            return media.getRotation();
        }
        if (iIntValue == 4) {
            VideoMetaData videoMetaData = media.getVideoMetaData();
            if (videoMetaData != null && videoMetaData.containsKey("rotation")) {
                return videoMetaData.getRotation().intValue();
            }
        } else {
            PictureMetaData pictureMetaData = media.getPictureMetaData();
            if (pictureMetaData != null && pictureMetaData.containsKey("rotation")) {
                return pictureMetaData.getRotation().intValue();
            }
        }
        return 1;
    }

    /* renamed from: l1 */
    public final List<C11425k> m72365l1(Context context, List<MediaFileBean> list, C11417c c11417c, String str, boolean z10) {
        int i10;
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        String strM63325a = C10159j.m63325a(C0213f.m1377a(), System.currentTimeMillis(), C11842p.m70828k());
        C1120a.m6675d("AlbumShareManager", "transDateTypeList toadyStr " + strM63325a);
        Calendar calendar = Calendar.getInstance();
        calendar.set(6, calendar.get(6) - 1);
        String strM63325a2 = C10159j.m63325a(C0213f.m1377a(), calendar.getTimeInMillis(), C11842p.m70828k());
        C1120a.m6675d("AlbumShareManager", "transDateTypeList yesterDayStr " + strM63325a2);
        Iterator<MediaFileBean> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MediaFileBean next = it.next();
            if (c11417c != null) {
                next.m14328d0(c11417c.clone());
            }
            if (next.m14338j() == 3 || next.m14338j() == 5) {
                next.m14343n().m68388B(true);
            } else {
                next.m14343n().m68388B(false);
            }
            String strM63325a3 = C10159j.m63325a(C0213f.m1377a(), next.m14348q(), C11842p.m70828k());
            next.m14353t0(strM63325a3);
            if (strM63325a3.equals(strM63325a)) {
                strM63325a3 = context.getString(R$string.main_today);
            }
            if (strM63325a2.equals(strM63325a3)) {
                strM63325a3 = context.getString(R$string.main_yesterday);
            }
            if (map.get(strM63325a3) == null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(next);
                map.put(strM63325a3, arrayList2);
            } else {
                ((List) map.get(strM63325a3)).add(next);
            }
        }
        C1120a.m6675d("AlbumShareManager", "transMediaFileList data trans end");
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new C11425k((List) entry.getValue(), (String) entry.getKey(), ((MediaFileBean) ((List) entry.getValue()).get(0)).m14348q()));
        }
        Collections.sort(arrayList, new Comparator() { // from class: p6.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12091d.m72277K0((C11425k) obj, (C11425k) obj2);
            }
        });
        int i11 = 0;
        for (i10 = 0; i10 < arrayList.size(); i10++) {
            C11425k c11425k = (C11425k) arrayList.get(i10);
            c11425k.m68465a().sort(new Comparator() { // from class: p6.c
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C12091d.m72278L0((MediaFileBean) obj, (MediaFileBean) obj2);
                }
            });
            for (MediaFileBean mediaFileBean : c11425k.m68465a()) {
                mediaFileBean.m14326c0(i11);
                arrayList3.add(mediaFileBean);
                i11++;
            }
        }
        if (z10) {
            C1122c.m6776e2(str, arrayList3);
        }
        return arrayList;
    }

    /* renamed from: m0 */
    public List<C11424j> m72366m0() {
        List<C11424j> list;
        synchronized (f55937l) {
            list = this.f55948a;
        }
        return list;
    }

    /* renamed from: m1 */
    public void m72367m1(MediaFileBean mediaFileBean, MediaFileBean mediaFileBean2) {
        if (mediaFileBean == null || mediaFileBean2 == null) {
            return;
        }
        if (mediaFileBean2.m14308K() == 3) {
            mediaFileBean.m14343n().m68402s(true);
        } else {
            mediaFileBean.m14343n().m68402s(false);
        }
    }

    /* renamed from: n */
    public final void m72368n(com.huawei.android.hicloud.drive.cloudphoto.model.Message message, HashMap<String, com.huawei.android.hicloud.drive.cloudphoto.model.Message> map) {
        if (!map.containsKey(message.getAlbumId())) {
            map.put(message.getAlbumId(), message);
        } else if (map.get(message.getAlbumId()).getCreatedTime().m28458c() < message.getCreatedTime().m28458c()) {
            map.put(message.getAlbumId(), message);
        }
    }

    /* renamed from: n0 */
    public List<MediaFileBean> m72369n0(Album album, List<MediaFileBean> list) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (MediaFileBean mediaFileBean : list) {
                MediaFileBean mediaFileBean2 = new MediaFileBean();
                mediaFileBean2.m14339k0(mediaFileBean.m14349r());
                mediaFileBean2.m14312O(album);
                FileInfo fileInfo = new FileInfo();
                fileInfo.setAlbumId(album.getId());
                fileInfo.setShareId(album.getId());
                if (mediaFileBean.m14338j() == 2) {
                    mediaFileBean2.m14323a0(4);
                    fileInfo.setFileType(1);
                } else if (mediaFileBean.m14338j() == 3) {
                    mediaFileBean2.m14323a0(5);
                    fileInfo.setFileType(4);
                }
                mediaFileBean.m14314Q(true);
                fileInfo.setFileName(mediaFileBean.m14331f());
                fileInfo.setCreateTime(mediaFileBean.m14348q());
                fileInfo.setLocalRealPath(mediaFileBean.m14350s());
                fileInfo.setLocalBigThumbPath(mediaFileBean.m14350s());
                fileInfo.setLocalThumbPath(mediaFileBean.m14350s());
                fileInfo.setUserID(album.getAlbumOwnerId());
                File fileM63442h = C10278a.m63442h(mediaFileBean.m14350s());
                fileInfo.setHash(C1131l.m6920b(fileM63442h));
                fileInfo.setDataVersion("2.0");
                fileInfo.setSize(fileM63442h.length());
                fileInfo.setCreaterId(C13452e.m80781L().m80971t0());
                fileInfo.setOrientation(mediaFileBean.m14349r());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", String.valueOf(mediaFileBean.m14325c()));
                    jSONObject.put("rotate", String.valueOf(mediaFileBean.m14349r()));
                } catch (JSONException unused) {
                    C1120a.m6676e("getPhotoUploadItems", "JSONObject.put error");
                }
                fileInfo.setExpand(jSONObject.toString());
                mediaFileBean2.m14317T(fileInfo);
                arrayList.add(mediaFileBean2);
            }
        }
        return arrayList;
    }

    /* renamed from: n1 */
    public void m72370n1(String str, String str2, String str3, PermissionUpdateRequest permissionUpdateRequest, Handler handler) {
        C12515a.m75110o().m75175e(new m(str, str2, str3, permissionUpdateRequest, handler), false);
    }

    /* renamed from: o */
    public final void m72371o(com.huawei.android.hicloud.drive.cloudphoto.model.Message message, LinkedHashMap<String, LinkedHashMap<String, List<com.huawei.android.hicloud.drive.cloudphoto.model.Message>>> linkedHashMap) {
        String albumId = message.getAlbumId();
        if (!linkedHashMap.containsKey(albumId)) {
            LinkedHashMap<String, List<com.huawei.android.hicloud.drive.cloudphoto.model.Message>> linkedHashMap2 = new LinkedHashMap<>();
            ArrayList arrayList = new ArrayList();
            arrayList.add(message);
            linkedHashMap2.put(message.getSenderId(), arrayList);
            linkedHashMap.put(albumId, linkedHashMap2);
            return;
        }
        LinkedHashMap<String, List<com.huawei.android.hicloud.drive.cloudphoto.model.Message>> linkedHashMap3 = linkedHashMap.get(albumId);
        if (linkedHashMap3.containsKey(message.getSenderId())) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(message);
        linkedHashMap3.put(message.getSenderId(), arrayList2);
        linkedHashMap.put(albumId, linkedHashMap3);
    }

    /* renamed from: o0 */
    public List<C11425k> m72372o0() {
        ArrayList arrayList;
        synchronized (f55933h) {
            arrayList = new ArrayList();
            arrayList.addAll(this.f55949b);
        }
        return arrayList;
    }

    /* renamed from: o1 */
    public final void m72373o1(MediaFileBean mediaFileBean) {
        if (mediaFileBean == null) {
            return;
        }
        try {
            if (mediaFileBean.m14309L()) {
                if (mediaFileBean.m14344o().getMediaOwnerId().equals(C13452e.m80781L().m80971t0())) {
                    mediaFileBean.m14343n().m68406w(false);
                    mediaFileBean.m14343n().m68403t(false);
                } else {
                    mediaFileBean.m14343n().m68406w(true);
                    mediaFileBean.m14343n().m68403t(true);
                }
            } else if (mediaFileBean.m14310M()) {
                mediaFileBean.m14343n().m68406w(false);
                mediaFileBean.m14343n().m68403t(false);
            } else {
                mediaFileBean.m14343n().m68404u(true);
                mediaFileBean.m14343n().m68403t(true);
            }
        } catch (Exception e10) {
            C1120a.m6676e("AlbumShareManager", "updateRiskStatus exception:" + e10.toString());
        }
    }

    /* renamed from: p */
    public void m72374p(Album album, List<MediaFileBean> list, Handler handler, Activity activity) {
        if (handler == null) {
            return;
        }
        C12515a.m75110o().m75175e(new n(album, list, handler, activity), false);
    }

    /* renamed from: p0 */
    public void m72375p0() {
        C12515a.m75110o().m75175e(new C12101n(), true);
    }

    /* renamed from: p1 */
    public void m72376p1(MediaFileBean mediaFileBean, MediaFileBean mediaFileBean2) {
        m72388t1(mediaFileBean, mediaFileBean2);
        m72385s1(mediaFileBean, mediaFileBean2);
        m72379q1(mediaFileBean, mediaFileBean2);
        m72382r1(mediaFileBean, mediaFileBean2);
        m72391u1(mediaFileBean, mediaFileBean2);
        m72367m1(mediaFileBean, mediaFileBean2);
        m72373o1(mediaFileBean);
    }

    /* renamed from: q */
    public boolean m72377q(String str, ArrayList<DayModeGroup> arrayList) {
        int i10;
        synchronized (f55935j) {
            try {
                List<DayModeGroup> orDefault = this.f55951d.getOrDefault(str, null);
                if (orDefault != null && arrayList.size() == orDefault.size()) {
                    for (0; i10 < arrayList.size(); i10 + 1) {
                        DayModeGroup dayModeGroup = arrayList.get(i10);
                        DayModeGroup dayModeGroup2 = orDefault.get(i10);
                        i10 = (dayModeGroup.getCount() == dayModeGroup2.getCount() && dayModeGroup.getDayMode().equals(dayModeGroup2.getDayMode())) ? i10 + 1 : 0;
                        return false;
                    }
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    /* renamed from: q0 */
    public int m72378q0() {
        return this.f55953f;
    }

    /* renamed from: q1 */
    public final void m72379q1(MediaFileBean mediaFileBean, MediaFileBean mediaFileBean2) {
        if (mediaFileBean == null || mediaFileBean2 == null) {
            return;
        }
        if (mediaFileBean2.m14308K() == 6) {
            mediaFileBean.m14343n().m68408y(true);
        } else {
            mediaFileBean.m14343n().m68408y(false);
        }
    }

    /* renamed from: r */
    public void m72380r() {
        synchronized (f55933h) {
            this.f55949b.clear();
        }
    }

    /* renamed from: r0 */
    public C11415a m72381r0(String str) {
        C11415a orDefault;
        synchronized (f55936k) {
            if (str == null) {
                str = "";
            }
            try {
                orDefault = this.f55952e.getOrDefault(str, null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return orDefault;
    }

    /* renamed from: r1 */
    public final void m72382r1(MediaFileBean mediaFileBean, MediaFileBean mediaFileBean2) {
        if (mediaFileBean == null || mediaFileBean2 == null) {
            return;
        }
        if (mediaFileBean2.m14308K() == 4) {
            mediaFileBean.m14343n().m68407x(true);
        } else {
            mediaFileBean.m14343n().m68407x(false);
        }
    }

    /* renamed from: s */
    public void m72383s(Context context) {
        C12515a.m75110o().m75175e(new u(context), false);
    }

    /* renamed from: s0 */
    public void m72384s0() {
        C12515a.m75110o().m75175e(new C12103p(), true);
    }

    /* renamed from: s1 */
    public void m72385s1(MediaFileBean mediaFileBean, MediaFileBean mediaFileBean2) {
        if (mediaFileBean == null || mediaFileBean2 == null) {
            return;
        }
        if (mediaFileBean2.m14308K() == 3) {
            mediaFileBean.m14343n().m68405v(true);
        } else {
            mediaFileBean.m14343n().m68405v(false);
        }
    }

    /* renamed from: t */
    public void m72386t() {
        C12515a.m75110o().m75175e(new k(), false);
    }

    /* renamed from: t0 */
    public List<C11415a> m72387t0() {
        List<C11415a> list;
        synchronized (f55939n) {
            list = f55945t;
        }
        return list;
    }

    /* renamed from: t1 */
    public final void m72388t1(MediaFileBean mediaFileBean, MediaFileBean mediaFileBean2) {
        if (mediaFileBean == null || mediaFileBean2 == null) {
            return;
        }
        if (mediaFileBean2.m14308K() == 1) {
            mediaFileBean.m14343n().m68409z(true);
        } else {
            mediaFileBean.m14343n().m68409z(false);
        }
    }

    /* renamed from: u */
    public void m72389u(String str, Handler handler, Activity activity) {
        C12515a.m75110o().m75175e(new b(str, handler, activity), false);
    }

    /* renamed from: u0 */
    public void m72390u0(Handler handler) {
        C1120a.m6677i("AlbumShareManager", "getShareAlubumInfo");
        if (handler != null) {
            C12515a.m75110o().m75175e(new d0(handler), false);
        }
    }

    /* renamed from: u1 */
    public final void m72391u1(MediaFileBean mediaFileBean, MediaFileBean mediaFileBean2) {
        if (mediaFileBean == null || mediaFileBean2 == null) {
            return;
        }
        if (mediaFileBean2.m14308K() != 2) {
            mediaFileBean.m14343n().m68387A(false);
            mediaFileBean.m14356v0(0L);
            return;
        }
        mediaFileBean.m14343n().m68387A(true);
        C1120a.m6675d("AlbumShareManager", "upload progress:" + mediaFileBean2.m14307I());
        mediaFileBean.m14356v0(mediaFileBean2.m14307I());
    }

    /* renamed from: v */
    public void m72392v(String str, String str2, String str3, Handler handler) {
        C12515a.m75110o().m75175e(new l(str, str2, str3, handler), false);
    }

    /* renamed from: v0 */
    public void m72393v0(Context context, String str, boolean z10, boolean z11) {
        C12515a.m75110o().m75175e(new C12099l(context, str, z10, z11), true);
    }

    /* renamed from: w */
    public void m72394w(String str, Handler handler) {
        C12515a.m75110o().m75175e(new i(str, handler), false);
    }

    /* renamed from: w0 */
    public void m72395w0(Handler handler, List<ShareAlbumInfo> list) {
        C1120a.m6677i("AlbumShareManager", "getSomeShareAlbumFirstPic");
        if (handler != null) {
            C12515a.m75110o().m75175e(new f0(list, handler), false);
        }
    }

    /* renamed from: x */
    public void m72396x(Album album, String str, ImageView imageView) {
        C12947g c12947g = new C12947g();
        Media mediaM77802O = c12947g.m77802O(str);
        if (mediaM77802O == null || mediaM77802O.getOpType() == 4) {
            ArrayList<Media> arrayListM77801N = c12947g.m77801N(album.getId(), 0L, 1L);
            mediaM77802O = !arrayListM77801N.isEmpty() ? arrayListM77801N.get(0) : null;
        }
        String localBigThumbPath = mediaM77802O == null ? "" : mediaM77802O.getLocalBigThumbPath();
        if (!TextUtils.isEmpty(localBigThumbPath)) {
            Bitmap bitmapM6719N0 = C1122c.m6719N0(C0209d.m1311u(localBigThumbPath), m72364l0(mediaM77802O));
            imageView.setTag(C0069g.m479y().m480A(mediaM77802O));
            imageView.setImageBitmap(bitmapM6719N0);
        } else if (mediaM77802O != null) {
            String strM480A = C0069g.m479y().m480A(mediaM77802O);
            if (imageView != null) {
                imageView.setTag(strM480A);
            }
            C12096i.m72418I().m72474x(mediaM77802O, imageView);
        }
    }

    /* renamed from: x0 */
    public int m72397x0(Context context) {
        return C11842p.m70753O0(context) ? C11842p.m70771U0() ? 10 : 7 : C11842p.m70771U0() ? 6 : 4;
    }

    /* renamed from: y */
    public void m72398y(String str, ImageView imageView) {
        Media mediaM77807T = new C12947g().m77807T(str);
        if (mediaM77807T != null) {
            String localBigThumbPath = mediaM77807T.getLocalBigThumbPath();
            if (TextUtils.isEmpty(localBigThumbPath)) {
                imageView.setTag(C0069g.m479y().m480A(mediaM77807T));
                C12096i.m72418I().m72474x(mediaM77807T, imageView);
            } else {
                Bitmap bitmapM6719N0 = C1122c.m6719N0(C0209d.m1311u(localBigThumbPath), m72364l0(mediaM77807T));
                imageView.setTag(C0069g.m479y().m480A(mediaM77807T));
                imageView.setImageBitmap(bitmapM6719N0);
            }
        }
    }

    /* renamed from: y0 */
    public final List<String> m72399y0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("share_system");
        return arrayList;
    }

    /* renamed from: z */
    public boolean m72400z(Album album, ImageView imageView) {
        Media mediaM72314K = m72314K(album.getId());
        String localBigThumbPath = mediaM72314K == null ? "" : mediaM72314K.getLocalBigThumbPath();
        if (!TextUtils.isEmpty(localBigThumbPath)) {
            imageView.setImageBitmap(C0209d.m1311u(localBigThumbPath));
            return true;
        }
        if (mediaM72314K == null) {
            return false;
        }
        imageView.setTag(C0069g.m479y().m480A(mediaM72314K));
        C12096i.m72418I().m72474x(mediaM72314K, imageView);
        return true;
    }

    /* renamed from: z0 */
    public List<DayModeGroup> m72401z0(String str) {
        List<DayModeGroup> orDefault;
        synchronized (f55935j) {
            if (str == null) {
                str = "";
            }
            try {
                orDefault = this.f55951d.getOrDefault(str, null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return orDefault;
    }

    public C12091d() {
        this.f55948a = new ArrayList();
        this.f55949b = new ArrayList();
        this.f55950c = new ArrayList();
        this.f55951d = new HashMap();
        this.f55952e = new HashMap();
        this.f55953f = 0;
    }
}
