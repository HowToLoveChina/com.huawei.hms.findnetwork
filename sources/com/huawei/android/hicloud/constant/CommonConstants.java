package com.huawei.android.hicloud.constant;

import android.net.Uri;
import android.provider.MediaStore;
import ck.C1443a;
import java.util.Timer;
import p015ak.C0224k0;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class CommonConstants {

    /* renamed from: a */
    public static final boolean f12114a = C1443a.f6214b.booleanValue();

    /* renamed from: b */
    public static final Uri f12115b = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    /* renamed from: c */
    public static final Uri f12116c = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

    /* renamed from: d */
    public static final Timer f12117d = new Timer();

    /* renamed from: e */
    public static final String f12118e;

    /* renamed from: f */
    public static final String f12119f;

    /* renamed from: g */
    public static final Object f12120g;

    public interface BackupOptionsSource {
    }

    public interface CommonHandlerMsg {
    }

    public interface DeviceMode {
    }

    public interface DeviceSwitchQuery {
    }

    public interface GalleryInfo {

        /* renamed from: a */
        public static final Uri f12121a;

        /* renamed from: b */
        public static final Uri f12122b;

        /* renamed from: c */
        public static final Uri f12123c;

        /* renamed from: d */
        public static final Uri f12124d;

        /* renamed from: e */
        public static final Uri f12125e;

        /* renamed from: f */
        public static final Uri f12126f;

        /* renamed from: g */
        public static final Uri f12127g;

        /* renamed from: h */
        public static final Uri f12128h;

        /* renamed from: i */
        public static final Uri f12129i;

        /* renamed from: j */
        public static final Uri f12130j;

        /* renamed from: k */
        public static final Uri f12131k;

        /* renamed from: l */
        public static final Uri f12132l;

        /* renamed from: m */
        public static final Uri f12133m;

        /* renamed from: n */
        public static final Uri f12134n;

        /* renamed from: o */
        public static final Uri f12135o;

        /* renamed from: p */
        public static final Uri f12136p;

        /* renamed from: q */
        public static final Uri f12137q;

        static {
            Uri uriM83100v = C13843a.m83100v();
            f12121a = uriM83100v;
            f12122b = Uri.withAppendedPath(uriM83100v, "cloud_album");
            f12123c = Uri.withAppendedPath(uriM83100v, "cloud_file");
            f12124d = Uri.withAppendedPath(uriM83100v, "cloud_recycled_file");
            f12125e = Uri.withAppendedPath(uriM83100v, "merge/gallery_media");
            f12126f = Uri.withAppendedPath(uriM83100v, "local_album");
            f12127g = Uri.withAppendedPath(uriM83100v, "auto_upload_album");
            f12128h = Uri.withAppendedPath(uriM83100v, "merge/gallery_album");
            f12129i = Uri.withAppendedPath(uriM83100v, "query_wait_upload_count");
            f12130j = Uri.withAppendedPath(uriM83100v, "query_wait_upload_size");
            f12131k = Uri.withAppendedPath(uriM83100v, "clearData");
            f12132l = Uri.withAppendedPath(uriM83100v, "clear_data_keep_switch");
            f12133m = Uri.withAppendedPath(uriM83100v, "deletedAlbum");
            f12134n = Uri.withAppendedPath(uriM83100v, "query_empty");
            f12135o = Uri.withAppendedPath(uriM83100v, "general_cloud_file");
            f12136p = Uri.withAppendedPath(uriM83100v, "cloud_classify_file");
            f12137q = Uri.withAppendedPath(uriM83100v, "restore_file_not_exists");
        }
    }

    public interface NotchViewType {
    }

    public interface NotificationType {
    }

    public interface PhotoAlbumsType {
    }

    public interface ReportDeskShortCut {
    }

    public interface SyncPrompt {
    }

    public interface SyncType {
    }

    public interface SysRefreshRandom {
    }

    public interface TracdIdRange {
    }

    public interface UserSpace {
    }

    static {
        String strM1573b = C0224k0.a.m1573b("ro.hwcamera.directory", "/DCIM/Camera");
        f12118e = strM1573b;
        f12119f = strM1573b + "/";
        f12120g = "ccB";
    }
}
