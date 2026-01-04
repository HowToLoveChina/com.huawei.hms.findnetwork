package p765x7;

import com.huawei.android.p069cg.configure.CloudAlbumSettings;

/* renamed from: x7.b */
/* loaded from: classes2.dex */
public class C13720b {
    /* renamed from: a */
    public static String m82480a() {
        return CloudAlbumSettings.m14363h().m14378n() ? "/JPJX/V2/BaseAPI" : "/JPJX/BaseAPI";
    }

    /* renamed from: b */
    public static String m82481b() {
        return CloudAlbumSettings.m14363h().m14378n() ? "/JPJX/V2/CloudPhoto4Manual" : "/JPJX/CloudPhoto4Manual";
    }

    /* renamed from: c */
    public static String m82482c(int i10) {
        return i10 == 0 ? CloudAlbumSettings.m14363h().m14378n() ? "/JPJX/V2/CloudPhoto/querymodifyinfos" : "/JPJX/CloudPhoto/querymodifyinfos" : CloudAlbumSettings.m14363h().m14378n() ? "/JPJX/V2/CloudPhoto/cycle/querymodifyinfos" : "/JPJX/CloudPhoto/cycle/querymodifyinfos";
    }

    /* renamed from: d */
    public static String m82483d() {
        return CloudAlbumSettings.m14363h().m14378n() ? "/JPJX/V2/CloudPhotoRecycle" : "/JPJX/CloudPhotoRecycle";
    }

    /* renamed from: e */
    public static String m82484e() {
        return CloudAlbumSettings.m14363h().m14378n() ? "/JPJX/V2/CloudPhoto" : "/JPJX/CloudPhoto";
    }
}
