package p604r7;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import p015ak.C0213f;
import p031b7.C1120a;

/* renamed from: r7.c */
/* loaded from: classes2.dex */
public class C12470c {

    /* renamed from: a */
    public final SharedPreferences f57402a;

    /* renamed from: r7.c$b */
    public static class b {

        /* renamed from: a */
        public static C12470c f57403a = new C12470c();
    }

    /* renamed from: d */
    public static C12470c m74770d() {
        return b.f57403a;
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: a */
    public void m74771a() {
        SharedPreferences.Editor editorEdit = this.f57402a.edit();
        editorEdit.remove("changes_startCursor");
        editorEdit.remove("changes_startCursor_forMedia");
        editorEdit.remove("temp_startCursor");
        editorEdit.remove("temp_nextCursor");
        editorEdit.remove("temp_share_nextCursor");
        editorEdit.remove("sync_end_time");
        editorEdit.remove("sync_simplify_time");
        editorEdit.remove("sync_simplify_cursor");
        editorEdit.remove("album_sync_all_complete");
        editorEdit.remove("share_sync_all_complete");
        editorEdit.remove("album_sync_suspend_cursor");
        editorEdit.remove("album_sync_last_auto_time");
        editorEdit.remove("preload_complete");
        editorEdit.commit();
        C1120a.m6677i("AlbumClientSyncConfig", "clearConfig");
    }

    /* renamed from: b */
    public String m74772b() {
        return this.f57402a.getString("changes_startCursor", null);
    }

    /* renamed from: c */
    public String m74773c() {
        return this.f57402a.getString("changes_startCursor_forMedia", null);
    }

    /* renamed from: e */
    public long m74774e() {
        return this.f57402a.getLong("album_sync_last_auto_time", 0L);
    }

    /* renamed from: f */
    public String m74775f() {
        return this.f57402a.getString("album_sync_suspend_cursor", "");
    }

    /* renamed from: g */
    public String m74776g() {
        return this.f57402a.getString("temp_nextCursor", null);
    }

    /* renamed from: h */
    public String m74777h() {
        return this.f57402a.getString("temp_share_nextCursor", null);
    }

    /* renamed from: i */
    public String m74778i() {
        return this.f57402a.getString("temp_startCursor", null);
    }

    /* renamed from: j */
    public boolean m74779j() {
        return this.f57402a.getBoolean("album_sync_all_complete", false);
    }

    /* renamed from: k */
    public boolean m74780k() {
        return this.f57402a.getBoolean("preload_complete", false);
    }

    /* renamed from: l */
    public boolean m74781l() {
        return this.f57402a.getBoolean("share_sync_all_complete", false);
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: m */
    public void m74782m(boolean z10) {
        this.f57402a.edit().putBoolean("album_sync_all_complete", z10).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: n */
    public void m74783n(String str) {
        this.f57402a.edit().putString("changes_startCursor", str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: o */
    public void m74784o(String str) {
        this.f57402a.edit().putString("changes_startCursor_forMedia", str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: p */
    public void m74785p(long j10) {
        this.f57402a.edit().putLong("sync_end_time", j10).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: q */
    public void m74786q(long j10) {
        this.f57402a.edit().putLong("album_sync_last_auto_time", j10).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: r */
    public void m74787r(boolean z10) {
        this.f57402a.edit().putBoolean("preload_complete", z10).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: s */
    public void m74788s(boolean z10) {
        this.f57402a.edit().putBoolean("share_sync_all_complete", z10).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: t */
    public void m74789t(String str) {
        this.f57402a.edit().putString("album_sync_suspend_cursor", str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: u */
    public void m74790u(String str) {
        this.f57402a.edit().putString("temp_nextCursor", str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: v */
    public void m74791v(String str) {
        this.f57402a.edit().putString("temp_share_nextCursor", str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: w */
    public void m74792w(String str) {
        this.f57402a.edit().putString("temp_startCursor", str).commit();
    }

    public C12470c() {
        this.f57402a = C0213f.m1378b().getSharedPreferences("album_client_sync_config", 0);
    }
}
