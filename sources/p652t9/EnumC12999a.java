package p652t9;

import ck.C1444b;
import java.util.HashSet;

/* renamed from: t9.a */
/* loaded from: classes3.dex */
public enum EnumC12999a {
    CLOUD_BACKUP(1, C1444b.m8313s(), "com.huawei.hidisk.backup"),
    CLOUD_ALBUM(2, C1444b.m8311q(), "com.huawei.hidisk.cloudAlbum"),
    CLOUD_SYNC(3, C1444b.m8316v(), "com.huawei.hidisk.syncmodule"),
    CLOUD_MORE(4, C1444b.m8315u(), ""),
    CLOUD_DRIVE(5, C1444b.m8314t(), "com.huawei.hidisk.foldersync"),
    CLOUD_PAY(6, ""),
    CLOUD_OOBE(7, 1, ""),
    CLOUD_THUMNAIL(8, C1444b.m8317w(), "com.huawei.hidisk.cloudAlbum"),
    CLOUDSYNC_UNSTRUCT_CONTACT(9, C1444b.m8316v(), "com.huawei.hidisk.contact"),
    CLOUDSYNC_UNSTRUCT_NOTEPAD(10, C1444b.m8316v(), "com.huawei.hidisk.notepad"),
    CLOUD_ALBUM_DRIVE(11, C1444b.m8312r(), "com.huawei.hidisk.cloudAlbum"),
    CLOUD_ALBUM_DRIVE_QUIC(12, C1444b.m8312r(), "com.huawei.hidisk.cloudAlbum"),
    CLOUD_THUMNAIL_QUIC(13, C1444b.m8317w(), "com.huawei.hidisk.cloudAlbum"),
    CLOUD_DISK_BITMAP(14, C1444b.m8314t(), "com.huawei.hidisk.foldersync"),
    CLOUD_SYNC_QUIC(15, C1444b.m8316v(), "com.huawei.hidisk.syncmodule"),
    CLOUDSYNC_UNSTRUCT_CONTACT_QUIC(16, C1444b.m8316v(), "com.huawei.hidisk.contact"),
    CLOUDSYNC_UNSTRUCT_NOTEPAD_QUIC(17, C1444b.m8316v(), "com.huawei.hidisk.notepad"),
    CLOUD_BACKUP_QUIC(18, C1444b.m8313s(), "com.huawei.hidisk.backup"),
    CLOUD_ALBUM_QUIC(19, C1444b.m8314t(), "com.huawei.hidisk.cloudAlbum");


    /* renamed from: w */
    public static final HashSet<EnumC12999a> f59222w = new HashSet<EnumC12999a>() { // from class: t9.a.a
        {
            add(EnumC12999a.CLOUD_ALBUM_DRIVE_QUIC);
            add(EnumC12999a.CLOUD_THUMNAIL_QUIC);
            add(EnumC12999a.CLOUD_BACKUP_QUIC);
            add(EnumC12999a.CLOUD_SYNC_QUIC);
            add(EnumC12999a.CLOUDSYNC_UNSTRUCT_CONTACT_QUIC);
            add(EnumC12999a.CLOUDSYNC_UNSTRUCT_NOTEPAD_QUIC);
        }
    };

    /* renamed from: x */
    public static final HashSet<EnumC12999a> f59223x = new HashSet<EnumC12999a>() { // from class: t9.a.b
        {
            add(EnumC12999a.CLOUD_ALBUM_QUIC);
            add(EnumC12999a.CLOUD_BACKUP_QUIC);
            add(EnumC12999a.CLOUD_SYNC_QUIC);
            add(EnumC12999a.CLOUDSYNC_UNSTRUCT_CONTACT_QUIC);
            add(EnumC12999a.CLOUDSYNC_UNSTRUCT_NOTEPAD_QUIC);
        }
    };

    /* renamed from: a */
    public int f59225a;

    /* renamed from: b */
    public int f59226b;

    /* renamed from: c */
    public String f59227c;

    EnumC12999a(int i10, String str) {
        this.f59225a = i10;
        this.f59227c = str;
    }

    /* renamed from: h */
    public static HashSet<EnumC12999a> m78141h() {
        return f59222w;
    }

    /* renamed from: k */
    public static HashSet<EnumC12999a> m78142k() {
        return f59223x;
    }

    /* renamed from: b */
    public int m78143b() {
        return this.f59225a;
    }

    /* renamed from: e */
    public String m78144e() {
        return this.f59227c;
    }

    /* renamed from: f */
    public int m78145f() {
        return this.f59226b;
    }

    EnumC12999a(int i10, int i11, String str) {
        this.f59225a = i10;
        this.f59226b = i11;
        this.f59227c = str;
    }
}
