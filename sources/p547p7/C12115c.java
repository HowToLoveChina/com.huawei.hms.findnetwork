package p547p7;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Change;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import p015ak.C0213f;
import p031b7.C1120a;
import p292fn.C9733f;
import p649t6.C12945e;
import p649t6.C12946f;

/* renamed from: p7.c */
/* loaded from: classes2.dex */
public class C12115c {

    /* renamed from: a */
    public SharedPreferences f56181a;

    /* renamed from: b */
    public SharedPreferences.Editor f56182b;

    /* renamed from: c */
    public final C12946f f56183c;

    /* renamed from: d */
    public final C12945e f56184d;

    /* renamed from: p7.c$b */
    public static class b {

        /* renamed from: a */
        public static final C12115c f56185a = new C12115c();
    }

    public /* synthetic */ C12115c(a aVar) {
        this();
    }

    /* renamed from: h */
    public static C12115c m72560h() {
        if (b.f56185a.f56181a == null || b.f56185a.f56182b == null) {
            b.f56185a.m72571l();
        }
        return b.f56185a;
    }

    /* renamed from: a */
    public void m72561a() {
        C1120a.m6675d("AlbumHideLostManager", CloudBackupConstant.REPORT_TYPE_BASE_CLEAR_CACHE);
        m72562b();
        m72563c();
    }

    /* renamed from: b */
    public void m72562b() throws SQLException {
        C12946f c12946f = this.f56183c;
        if (c12946f != null) {
            c12946f.m77778k();
        } else {
            C1120a.m6678w("AlbumHideLostManager", "clearDb hideOperator is null");
        }
        C12945e c12945e = this.f56184d;
        if (c12945e != null) {
            c12945e.m77771j();
        } else {
            C1120a.m6678w("AlbumHideLostManager", "clearDb hideChangeOperator is null");
        }
    }

    /* renamed from: c */
    public void m72563c() {
        SharedPreferences.Editor editor = this.f56182b;
        if (editor == null) {
            C1120a.m6678w("AlbumHideLostManager", "clearSp shareEditor is null");
        } else {
            editor.clear().commit();
        }
    }

    /* renamed from: d */
    public String m72564d() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C1120a.m6676e("AlbumHideLostManager", "getOMAssetRefundStatus configMap is null");
            return String.valueOf(2);
        }
        String assetRefundStatus = hiCloudSysParamMapM60757p.getAssetRefundStatus();
        C1120a.m6675d("AlbumHideLostManager", "getOMAssetRefundStatus: " + assetRefundStatus);
        return TextUtils.isEmpty(assetRefundStatus) ? String.valueOf(2) : assetRefundStatus;
    }

    /* renamed from: e */
    public boolean m72565e(String str) {
        return m72566f(str, false);
    }

    /* renamed from: f */
    public boolean m72566f(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f56181a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, z10);
        }
        C1120a.m6678w("AlbumHideLostManager", "getBooleanValue sharedPreferences is null, key=" + str);
        return z10;
    }

    /* renamed from: g */
    public boolean m72567g() {
        return m72565e("hideUploadCompleteFlag");
    }

    /* renamed from: i */
    public String m72568i() {
        return m72570k("localAssetRefundStatus", String.valueOf(2));
    }

    /* renamed from: j */
    public boolean m72569j() {
        return m72566f("localEnableShowLostCloudPhoto", true);
    }

    /* renamed from: k */
    public String m72570k(String str, String str2) {
        SharedPreferences sharedPreferences = this.f56181a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, str2);
        }
        C1120a.m6678w("AlbumHideLostManager", "getStringValue sharedPreferences is null, key=" + str);
        return str2;
    }

    /* renamed from: l */
    public final void m72571l() {
        Context contextM1378b = C0213f.m1378b();
        if (contextM1378b == null) {
            C1120a.m6676e("AlbumHideLostManager", "initSp context is null");
            return;
        }
        SharedPreferences sharedPreferences = contextM1378b.getSharedPreferences("album_hide_lost", 0);
        this.f56181a = sharedPreferences;
        this.f56182b = sharedPreferences.edit();
    }

    /* renamed from: m */
    public boolean m72572m() {
        return C9733f.m60705z().m60763v("enableHiDiskHideLostCloudPhoto") == 0;
    }

    /* renamed from: n */
    public boolean m72573n(int i10, boolean z10) {
        if (z10) {
            return false;
        }
        return m72577r(i10);
    }

    /* renamed from: o */
    public boolean m72574o(Change change, boolean z10) {
        if (z10) {
            return false;
        }
        if (change.getDeleted().booleanValue()) {
            C1120a.m6675d("AlbumHideLostManager", "isHideMediaAtIncrementalSync, change.getDeleted=true");
            return false;
        }
        Media media = change.getMedia();
        if (media == null) {
            C1120a.m6678w("AlbumHideLostManager", "isHideMediaAtIncrementalSync, change.getMedia is null");
            return false;
        }
        if (m72577r(media.getStatus().intValue())) {
            return !this.f56183c.m77786s(media.getId()).isEmpty();
        }
        return false;
    }

    /* renamed from: p */
    public boolean m72575p(Media media, boolean z10) {
        if (!z10 && m72577r(media.getStatus().intValue())) {
            return !this.f56183c.m77786s(media.getId()).isEmpty();
        }
        return false;
    }

    /* renamed from: q */
    public boolean m72576q(Media media, boolean z10, int i10) {
        if (i10 == 0 && !z10) {
            return m72577r(media.getStatus().intValue());
        }
        return false;
    }

    /* renamed from: r */
    public boolean m72577r(int i10) {
        if (i10 != Asset.NORMAL.intValue() && i10 != Asset.FIX.intValue()) {
            for (String str : m72568i().split(",")) {
                if (str.equals(String.valueOf(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: s */
    public boolean m72578s() {
        boolean zM72572m = m72572m();
        C1120a.m6677i("AlbumHideLostManager", "isShowLostCloudPhoto, enableShowLostCloudPhoto=" + zM72572m);
        return zM72572m;
    }

    /* renamed from: t */
    public void m72579t() {
        m72583x(m72564d());
    }

    /* renamed from: u */
    public void m72580u() {
        m72581v("hideUploadCompleteFlag", false);
    }

    /* renamed from: v */
    public void m72581v(String str, boolean z10) {
        SharedPreferences.Editor editor = this.f56182b;
        if (editor != null) {
            editor.putBoolean(str, z10).commit();
            return;
        }
        C1120a.m6678w("AlbumHideLostManager", "setBooleanValue shareEditor is null, key=" + str);
    }

    /* renamed from: w */
    public void m72582w(boolean z10) {
        m72581v("hideUploadCompleteFlag", z10);
    }

    /* renamed from: x */
    public void m72583x(String str) {
        m72585z("localAssetRefundStatus", str);
    }

    /* renamed from: y */
    public void m72584y(boolean z10) {
        m72581v("localEnableShowLostCloudPhoto", z10);
    }

    /* renamed from: z */
    public void m72585z(String str, String str2) {
        SharedPreferences.Editor editor = this.f56182b;
        if (editor != null) {
            editor.putString(str, str2).commit();
            return;
        }
        C1120a.m6678w("AlbumHideLostManager", "setStringValue shareEditor is null, key=" + str);
    }

    public C12115c() {
        this.f56183c = new C12946f();
        this.f56184d = new C12945e();
        m72571l();
    }
}
