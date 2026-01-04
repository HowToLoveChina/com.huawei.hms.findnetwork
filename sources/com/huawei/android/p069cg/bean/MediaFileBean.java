package com.huawei.android.p069cg.bean;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.VideoMetaData;
import com.huawei.android.p069cg.p072vo.FileInfo;
import java.util.Objects;
import p031b7.C1122c;
import p471m6.C11417c;

/* loaded from: classes2.dex */
public class MediaFileBean implements Parcelable {
    public static final Parcelable.Creator<MediaFileBean> CREATOR = new C2269a();

    /* renamed from: A */
    public boolean f10902A;

    /* renamed from: B */
    public String f10903B;

    /* renamed from: C */
    public int f10904C;

    /* renamed from: D */
    public int f10905D;

    /* renamed from: E */
    public String f10906E;

    /* renamed from: F */
    public String f10907F;

    /* renamed from: G */
    public int f10908G;

    /* renamed from: H */
    public int f10909H;

    /* renamed from: a */
    public long f10910a;

    /* renamed from: b */
    public long f10911b;

    /* renamed from: c */
    public int f10912c;

    /* renamed from: d */
    public FileInfo f10913d;

    /* renamed from: e */
    public Album f10914e;

    /* renamed from: f */
    public Media f10915f;

    /* renamed from: g */
    public String f10916g;

    /* renamed from: h */
    public int f10917h;

    /* renamed from: i */
    public Uri f10918i;

    /* renamed from: j */
    public Uri f10919j;

    /* renamed from: k */
    public long f10920k;

    /* renamed from: l */
    public long f10921l;

    /* renamed from: m */
    public long f10922m;

    /* renamed from: n */
    public int f10923n;

    /* renamed from: o */
    public int f10924o;

    /* renamed from: p */
    public int f10925p;

    /* renamed from: q */
    public String f10926q;

    /* renamed from: r */
    public String f10927r;

    /* renamed from: s */
    public String f10928s;

    /* renamed from: t */
    public String f10929t;

    /* renamed from: u */
    public long f10930u;

    /* renamed from: v */
    public String f10931v;

    /* renamed from: w */
    public C11417c f10932w;

    /* renamed from: x */
    public boolean f10933x;

    /* renamed from: y */
    public String f10934y;

    /* renamed from: z */
    public boolean f10935z;

    /* renamed from: com.huawei.android.cg.bean.MediaFileBean$a */
    public class C2269a implements Parcelable.Creator<MediaFileBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaFileBean createFromParcel(Parcel parcel) {
            return new MediaFileBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaFileBean[] newArray(int i10) {
            return new MediaFileBean[i10];
        }
    }

    public MediaFileBean() {
        this.f10915f = null;
        this.f10932w = new C11417c();
        this.f10908G = 1;
        this.f10909H = 3;
    }

    /* renamed from: A */
    public String m14306A() {
        return this.f10907F;
    }

    /* renamed from: I */
    public long m14307I() {
        return this.f10911b;
    }

    /* renamed from: K */
    public int m14308K() {
        return this.f10923n;
    }

    /* renamed from: L */
    public boolean m14309L() {
        int scaState;
        Media media = this.f10915f;
        return (media == null || (scaState = media.getScaState()) == 2 || scaState == 1) ? false : true;
    }

    /* renamed from: M */
    public boolean m14310M() {
        Media media = this.f10915f;
        if (media == null) {
            return false;
        }
        int scaRank = media.getScaRank();
        return scaRank == 1 || scaRank == 0;
    }

    /* renamed from: N */
    public boolean m14311N() {
        return this.f10909H == 1;
    }

    /* renamed from: O */
    public void m14312O(Album album) {
        this.f10914e = album;
    }

    /* renamed from: P */
    public void m14313P(boolean z10) {
        this.f10909H = z10 ? 1 : 3;
    }

    /* renamed from: Q */
    public void m14314Q(boolean z10) {
        this.f10933x = z10;
    }

    /* renamed from: R */
    public void m14315R(long j10) {
        this.f10920k = j10;
    }

    /* renamed from: S */
    public void m14316S(long j10) {
        this.f10921l = j10;
    }

    /* renamed from: T */
    public void m14317T(FileInfo fileInfo) {
        this.f10913d = fileInfo;
    }

    /* renamed from: U */
    public void m14318U(String str) {
        this.f10916g = str;
    }

    /* renamed from: V */
    public void m14319V(Uri uri) {
        this.f10918i = uri;
    }

    /* renamed from: W */
    public void m14320W(String str) {
        this.f10929t = str;
    }

    /* renamed from: Y */
    public void m14321Y(long j10) {
        this.f10930u = j10;
    }

    /* renamed from: a */
    public Album m14322a() {
        return this.f10914e;
    }

    /* renamed from: a0 */
    public void m14323a0(int i10) {
        this.f10917h = i10;
    }

    /* renamed from: b0 */
    public void m14324b0(Uri uri) {
        this.f10919j = uri;
    }

    /* renamed from: c */
    public long m14325c() {
        return this.f10920k;
    }

    /* renamed from: c0 */
    public void m14326c0(int i10) {
        this.f10904C = i10;
    }

    /* renamed from: d */
    public long m14327d() {
        return this.f10921l;
    }

    /* renamed from: d0 */
    public void m14328d0(C11417c c11417c) {
        this.f10932w = c11417c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public FileInfo m14329e() {
        return this.f10913d;
    }

    /* renamed from: e0 */
    public void m14330e0(long j10) {
        this.f10910a = j10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaFileBean mediaFileBean = (MediaFileBean) obj;
        if (TextUtils.isEmpty(this.f10907F)) {
            return false;
        }
        return this.f10907F.equals(mediaFileBean.f10907F);
    }

    /* renamed from: f */
    public String m14331f() {
        return this.f10916g;
    }

    /* renamed from: f0 */
    public void m14332f0(Media media) {
        if (media == null) {
            return;
        }
        this.f10915f = media;
        this.f10921l = media.getLocalId();
        this.f10922m = media.getCreatedTime().m28458c();
        this.f10918i = Uri.parse(media.getLocalRealPath());
        this.f10916g = media.getFileName();
        if (this.f10932w == null) {
            this.f10932w = new C11417c();
        }
        if (media.getFileType().intValue() != 4) {
            this.f10917h = 4;
            this.f10932w.m68388B(false);
            return;
        }
        this.f10917h = 5;
        this.f10932w.m68388B(true);
        VideoMetaData videoMetaData = media.getVideoMetaData();
        if (videoMetaData != null) {
            this.f10920k = videoMetaData.getDurationTime() == null ? 0L : videoMetaData.getDurationTime().intValue();
        }
    }

    /* renamed from: g */
    public Uri m14333g() {
        return this.f10918i;
    }

    /* renamed from: g0 */
    public void m14334g0(int i10) {
        this.f10912c = i10;
    }

    /* renamed from: h */
    public String m14335h() {
        return this.f10929t;
    }

    /* renamed from: h0 */
    public void m14336h0(long j10) {
        this.f10922m = j10;
    }

    public int hashCode() {
        return Objects.hash(this.f10907F);
    }

    /* renamed from: i */
    public long m14337i() {
        return this.f10930u;
    }

    /* renamed from: j */
    public int m14338j() {
        return this.f10917h;
    }

    /* renamed from: k0 */
    public void m14339k0(int i10) {
        this.f10908G = i10;
    }

    /* renamed from: l */
    public Uri m14340l() {
        return this.f10919j;
    }

    /* renamed from: l0 */
    public void m14341l0(int i10) {
        this.f10924o = i10;
    }

    /* renamed from: m */
    public int m14342m() {
        return this.f10904C;
    }

    /* renamed from: n */
    public C11417c m14343n() {
        return this.f10932w;
    }

    /* renamed from: o */
    public Media m14344o() {
        return C1122c.m6799k1(this.f10915f);
    }

    /* renamed from: o0 */
    public void m14345o0(int i10) {
        this.f10925p = i10;
    }

    /* renamed from: p */
    public int m14346p() {
        return this.f10912c;
    }

    /* renamed from: p0 */
    public void m14347p0(int i10) {
        this.f10905D = i10;
    }

    /* renamed from: q */
    public long m14348q() {
        return this.f10922m;
    }

    /* renamed from: r */
    public int m14349r() {
        return this.f10908G;
    }

    /* renamed from: s */
    public String m14350s() {
        return this.f10906E;
    }

    /* renamed from: s0 */
    public void m14351s0(String str) {
        this.f10906E = str;
    }

    /* renamed from: t */
    public Media m14352t() {
        return this.f10915f;
    }

    /* renamed from: t0 */
    public void m14353t0(String str) {
        this.f10926q = str;
    }

    /* renamed from: u0 */
    public void m14354u0(String str) {
        this.f10907F = str;
    }

    /* renamed from: v */
    public String m14355v() {
        return this.f10926q;
    }

    /* renamed from: v0 */
    public void m14356v0(long j10) {
        this.f10911b = j10;
    }

    /* renamed from: w0 */
    public void m14357w0(int i10) {
        this.f10923n = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f10910a);
        parcel.writeLong(this.f10911b);
        parcel.writeInt(this.f10912c);
        parcel.writeParcelable(this.f10913d, i10);
        parcel.writeString(this.f10916g);
        parcel.writeInt(this.f10917h);
        parcel.writeParcelable(this.f10918i, i10);
        parcel.writeParcelable(this.f10919j, i10);
        parcel.writeLong(this.f10920k);
        parcel.writeLong(this.f10921l);
        parcel.writeLong(this.f10922m);
        parcel.writeInt(this.f10923n);
        parcel.writeInt(this.f10924o);
        parcel.writeInt(this.f10925p);
        parcel.writeString(this.f10926q);
        parcel.writeString(this.f10927r);
        parcel.writeString(this.f10928s);
        parcel.writeString(this.f10929t);
        parcel.writeString(this.f10931v);
        parcel.writeByte(this.f10933x ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f10934y);
        parcel.writeByte(this.f10935z ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10902A ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f10903B);
        parcel.writeInt(this.f10904C);
        parcel.writeInt(this.f10905D);
        parcel.writeString(this.f10906E);
        parcel.writeString(this.f10907F);
        parcel.writeInt(this.f10908G);
        parcel.writeInt(this.f10909H);
    }

    public MediaFileBean(Parcel parcel) {
        this.f10915f = null;
        this.f10932w = new C11417c();
        this.f10908G = 1;
        this.f10909H = 3;
        this.f10910a = parcel.readLong();
        this.f10911b = parcel.readLong();
        this.f10912c = parcel.readInt();
        this.f10913d = (FileInfo) parcel.readParcelable(FileInfo.class.getClassLoader());
        this.f10916g = parcel.readString();
        this.f10917h = parcel.readInt();
        this.f10918i = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f10919j = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f10920k = parcel.readLong();
        this.f10921l = parcel.readLong();
        this.f10922m = parcel.readLong();
        this.f10923n = parcel.readInt();
        this.f10924o = parcel.readInt();
        this.f10925p = parcel.readInt();
        this.f10926q = parcel.readString();
        this.f10927r = parcel.readString();
        this.f10928s = parcel.readString();
        this.f10929t = parcel.readString();
        this.f10931v = parcel.readString();
        this.f10933x = parcel.readByte() != 0;
        this.f10934y = parcel.readString();
        this.f10935z = parcel.readByte() != 0;
        this.f10902A = parcel.readByte() != 0;
        this.f10903B = parcel.readString();
        this.f10904C = parcel.readInt();
        this.f10905D = parcel.readInt();
        this.f10906E = parcel.readString();
        this.f10907F = parcel.readString();
        this.f10908G = parcel.readInt();
        this.f10909H = parcel.readInt();
    }
}
