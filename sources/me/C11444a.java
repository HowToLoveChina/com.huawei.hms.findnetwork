package me;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.constant.TradeMode;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import hk.C10278a;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import p015ak.C0219i;
import p015ak.C0224k0;
import p818yp.C14034a;

/* renamed from: me.a */
/* loaded from: classes3.dex */
public class C11444a {

    /* renamed from: a */
    public static final Locale f53313a = new Locale(FaqConstants.DEFAULT_ISO_LANGUAGE);

    /* renamed from: b */
    public static final C11446c f53314b;

    /* renamed from: c */
    public static HashMap<String, C11446c> f53315c;

    /* renamed from: d */
    public static HashMap<String, C11446c> f53316d;

    static {
        int i10;
        int i11;
        int i12 = R$drawable.hidisk_icon_unknown;
        f53314b = new C11446c(9, 200, i12, null);
        f53315c = new HashMap<>();
        f53316d = new HashMap<>();
        int i13 = R$drawable.hidisk_icon_video;
        m68557a("3GPP2", 5, 38, i13, "audio/3gpp2");
        int i14 = R$drawable.hidisk_icon_music;
        m68557a("IMY", 5, 94, i14, "audio/imelody");
        m68557a("AAC", 5, 72, i14, "audio/aac");
        m68557a("AMR", 5, 82, R$drawable.hidisk_icon_music_amr, "audio/amr");
        m68557a("MID", 5, 92, i14, "audio/midi");
        m68557a("MPGA", 5, 90, i14, "audio/mpeg");
        m68557a("MXMF", 5, 91, i14, "audio/mobile-xmf");
        m68557a("RMVB", 4, 26, i13, "video/x-pn-realvideo");
        m68557a("RTTTL", 5, 92, i14, "audio/midi");
        m68557a("RTX", 5, 92, i14, "audio/midi");
        m68557a("SMF", 5, 93, i14, "audio/sp-midi");
        m68557a("WAV", 5, 71, R$drawable.hidisk_icon_music_wav, "audio/x-wav");
        m68557a("WMA", 5, 75, R$drawable.hidisk_icon_music_wma, "audio/x-ms-wma");
        m68557a("OTA", 5, 92, i14, "audio/midi");
        m68557a("XMF", 5, 92, i14, "audio/midi");
        m68557a("OGG", 5, 81, i14, "audio/ogg");
        m68557a("PLS", 5, 96, i14, "audio/x-scpls");
        m68557a("RA", 5, 79, i14, "audio/x-pn-realaudio");
        m68557a("RAM", 5, 73, i14, "audio/x-pn-realaudio");
        m68557a("MIDI", 5, 92, i14, "audio/midi");
        m68557a("M3U", 5, 95, i14, "audio/x-mpegurl");
        m68557a("M4A", 5, 83, R$drawable.hidisk_icon_music_m4a, "audio/mp4a-latm");
        m68557a("M4B", 5, 84, i14, "audio/mp4a-latm");
        m68557a("M4P", 5, 84, i14, "audio/mp4a-latm");
        m68557a("AWB", 5, 87, i14, "audio/amr-wb");
        m68557a("MP2", 5, 78, i14, "audio/x-mpeg");
        m68557a("MP3", 5, 70, R$drawable.hidisk_icon_music_mp3, "audio/x-mpeg");
        m68557a("AU", 5, 76, i14, "audio/basic");
        int i15 = R$drawable.hidisk_icon_doc;
        m68557a("DOCX", 2, 50, i15, "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        m68557a("DOC", 2, 50, i15, "application/msword");
        m68557a("DOCM", 2, 50, i15, "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        m68557a("DOTM", 2, 50, i15, "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        m68557a("WPT", 2, 50, i15, "application/wpt");
        int i16 = R$drawable.hidisk_icon_xls;
        m68557a("XLS", 2, 53, i16, "application/vnd.ms-excel");
        m68557a("XLSX", 2, 53, i16, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        m68557a("XLSM", 2, 53, i16, "application/vnd.ms-excel.sheet.macroEnabled.12");
        m68557a("XLTM", 2, 53, i16, "application/vnd.ms-excel.template.macroEnabled.12");
        m68557a("ET", 2, 53, i16, "application/et");
        int i17 = R$drawable.hidisk_icon_ppt;
        m68557a(HiCloudNativeAd.CHANNEL_PPS, 2, 52, i17, "application/vnd.ms-powerpoint");
        m68557a("PPT", 2, 52, i17, "application/vnd.ms-powerpoint");
        m68557a("PPTX", 2, 52, i17, "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        m68557a("PPTM", 2, 52, i17, "application/vnd.ms-powerpoint.presentation.macroEnabled.12");
        m68557a("PPSM", 2, 52, i17, "application/vnd.ms-powerpoint.slideshow.macroEnabled.12");
        m68557a("POTM", 2, 52, i17, "application/vnd.ms-powerpoint.presentation.macroEnabled.12");
        m68557a("DPS", 2, 52, i17, "application/dps");
        m68557a("DPT", 2, 52, i17, "application/dpt");
        int i18 = R$drawable.hidisk_icon_unknown1;
        m68557a("MSG", 2, 200, i18, "application/vnd.ms-outlook");
        int i19 = R$drawable.hidisk_icon_compressed_files;
        m68557a("GTAR", 8, 110, i19, "application/x-gtar");
        m68557a("OGA", 5, 81, i14, "application/ogg");
        m68557a("PDF", 2, 54, R$drawable.hidisk_icon_pdf, "application/pdf");
        m68557a("RAR", 8, 111, R$drawable.hidisk_icon_rar, "application/x-rar-compressed");
        m68557a("RTF", 2, 50, i15, "application/rtf");
        m68557a("TAR", 8, 114, i19, "application/x-tar");
        m68557a("TGZ", 8, 119, i19, "application/x-compressed");
        m68557a("WPL", 5, 97, i14, "application/vnd.ms-wpl");
        m68557a("WPS", 2, 50, i15, "application/vnd.ms-works");
        int i20 = R$drawable.hidisk_icon_xml;
        m68557a("XHTML", 2, 58, i20, "application/xhtml+xml");
        m68557a("Z", 8, 115, i19, "application/x-compressed");
        m68557a("ZIP", 8, 110, R$drawable.hidisk_icon_zip, "application/zip");
        m68557a("MPC", 2, 200, i12, "application/vnd.mpohun.certificate");
        m68557a("JS", 2, 58, i18, "application/x-javascript");
        m68557a("JAR", 8, 112, i19, "text/vnd.sun.j2me.app-descriptor");
        m68557a("GZ", 8, 113, i19, "application/x-gzip");
        m68557a("EXE", 9, 200, i12, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        m68557a(FaqConstants.OPEN_TYPE_APK, 7, 130, R$drawable.hidisk_icon_exe, "application/vnd.android.package-archive");
        m68557a("BIN", 9, 200, i12, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        m68557a("CLASS", 9, 200, i12, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        int i21 = R$drawable.ic_picture;
        m68557a("PNG", 6, 1, i21, MimeType.PNG);
        m68557a("RAW", 9, 200, i12, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        m68557a("WBMP", 6, 12, i21, "image/vnd.wap.wbmp");
        m68557a("BMP", 6, 5, i21, "image/bmp");
        m68557a("GIF", 6, 4, i21, MimeType.GIF);
        m68557a("JPEG", 6, 3, i21, MimeType.JPEG);
        m68557a("JPG", 6, 2, i21, MimeType.JPEG);
        m68557a("JPE", 6, 3, i21, MimeType.JPEG);
        m68557a("CR2", 6, 13, i21, "image/cr2");
        m68557a("PSD", 6, 14, i21, "image/psd");
        if (m68563g()) {
            m68557a("HEIC", 6, 10, i21, "image/heif");
            m68557a("HEIF", 6, 10, i21, "image/heif");
        }
        m68557a("DNG", 6, 7, i21, "image/x-adobe-dng");
        m68557a("C", 2, 58, i18, InterfaceC5483d.f25083i);
        m68557a("CONF", 2, 58, i18, InterfaceC5483d.f25083i);
        m68557a("CPP", 2, 58, i18, InterfaceC5483d.f25083i);
        m68557a("H", 2, 58, i18, InterfaceC5483d.f25083i);
        int i22 = R$drawable.hidisk_icon_html;
        m68557a("HTM", 2, 55, i22, "text/html");
        m68557a("HTML", 2, 55, i22, "text/html");
        m68557a("JAVA", 2, 58, i18, InterfaceC5483d.f25083i);
        m68557a("LOG", 2, 58, R$drawable.hidisk_icon_log, InterfaceC5483d.f25083i);
        m68557a("PROP", 2, 58, i18, InterfaceC5483d.f25083i);
        m68557a("RC", 2, 58, i18, InterfaceC5483d.f25083i);
        m68557a("SH", 2, 58, i18, InterfaceC5483d.f25083i);
        int i23 = R$drawable.hidisk_icon_text;
        m68557a("TXT", 2, 57, i23, InterfaceC5483d.f25083i);
        m68557a("XML", 2, 56, i20, InterfaceC5483d.f25083i);
        m68557a("M4U", 4, 29, i13, "video/vnd.mpegurl");
        m68557a("M4V", 4, 35, i13, "video/x-m4v");
        m68557a("MOV", 4, 24, i13, "video/quicktime");
        m68557a("MP4", 4, 21, i13, MimeType.MP4);
        m68557a("MPE", 4, 21, i13, "video/mpeg");
        m68557a("MPEG", 4, 39, i13, "video/mpeg");
        m68557a("MPG4", 4, 21, i13, "video/mpeg");
        m68557a("MKV", 4, 28, i13, "video/x-matroska");
        m68557a("WEBM", 4, 37, i13, "video/x-matroska");
        m68557a("3GPP", 4, 34, i13, "video/3gpp");
        m68557a("ASF", 4, 31, i13, "video/x-ms-asf");
        m68557a("ASX", 4, 31, i13, "video/x-ms-asf");
        m68557a("AVI", 4, 22, i13, "video/x-msvideo");
        m68557a("FLV", 4, 27, i13, "video/x-flv");
        m68557a("M2TS", 4, 39, i13, "video/mpeg");
        m68557a("EPUB", 9, 200, i12, "application/epub+zip");
        m68557a("EBK3", 9, 200, i12, "application/x-expandedbook");
        m68557a("SUB", 2, 58, i18, "text/x-subviewer");
        m68557a("ASS", 2, 58, i18, "text/x-ssa");
        m68557a("SSA", 2, 58, i18, "text/x-ssa");
        m68557a("SAMI", 9, 200, i12, "application/x-sami");
        m68557a("SMI", 9, 200, i12, "application/x-sami");
        m68557a("SRT", 9, 200, i12, "application/x-subrip");
        m68557a("SWF", 9, 200, i12, "application/x-shockwave-flash");
        m68557a("CAB", 9, 200, i12, "application/x-shockwave-flash");
        m68557a("CHM", 9, 200, R$drawable.hidisk_icon_chm, "application/x-chm");
        m68557a("UMD", 9, 200, i12, "application/umd");
        m68557a(TradeMode.PDB, 9, 200, i12, "application/ebook");
        m68557a("JAD", 2, 58, i18, "text/vnd.sun.j2me.app-descriptor");
        m68557a("DHTML", 2, 55, i22, "text/html");
        m68557a("SHTML", 2, 55, i22, "text/html");
        m68557a("AC3", 5, 80, i14, "audio/ac3");
        m68557a("MKA", 5, 88, i14, "audio/x-matroska");
        m68557a("FLAC", 5, 77, R$drawable.hidisk_icon_music_flac, "audio/flac");
        m68557a("AIF", 5, 85, i14, "audio/x-aiff");
        m68557a("AIFF", 5, 85, i14, "audio/x-aiff");
        m68557a("AIFC", 5, 85, i14, "audio/x-aiff");
        m68557a("APE", 5, 74, R$drawable.hidisk_icon_music_ape, "audio/x-ape");
        m68557a("3G2", 4, 38, i13, "video/3gpp2");
        m68557a("WMV", 4, 30, i13, "video/x-ms-wmv");
        if (C0219i.m1463a() < 21) {
            m68557a("RM", 4, 25, i13, "video/x-pn-realvideo");
            m68557a("3GP", 5, 100, i14, "audio/mpeg");
            m68557a("MPG", 5, 99, i14, "audio/quicktime");
            i10 = 4;
        } else {
            i10 = 4;
            m68557a("MPG", 4, 21, i13, "video/video/mp2p");
            m68557a("RM", 5, 98, i14, "audio/x-pn-realaudio");
            m68557a("3GP", 4, 34, i13, "video/3gpp");
        }
        m68557a("RV", i10, 32, i13, "video/x-pn-realvideo");
        m68557a("TS", i10, 23, i13, "video/mp2ts");
        m68557a("DIVX", i10, 33, i13, "video/divx");
        m68557a("F4V", i10, 36, i13, "video/x-f4v");
        m68557a("WEBP", 6, 9, i21, "image/webp");
        m68557a("TIF", 6, 8, i21, "image/tiff");
        m68557a("ICO", 6, 6, i21, "image/x-icon");
        m68557a("TEXT", 2, 57, i23, InterfaceC5483d.f25083i);
        m68557a("INI", 2, 58, i18, InterfaceC5483d.f25083i);
        m68557a("VCS", 2, 58, i18, "text/x-vcalendar");
        m68557a("ICS", 2, 58, i18, "text/calendar");
        m68557a("JSP", 2, 58, i18, "text/html");
        m68557a("ASP", 2, 58, i18, "text/html");
        m68557a("PHP", 2, 58, i18, "text/html");
        m68557a("DOTX", 2, 50, i15, "application/vnd.openxmlformats-officedocument.wordprocessingml.template");
        m68557a("DOT", 2, 50, i15, "application/msword");
        m68557a("XLT", 2, 53, i16, "application/vnd.ms-excel");
        m68557a("XLTX", 2, 53, i16, "application/vnd.openxmlformats-officedocument.spreadsheetml.template");
        m68557a("CSV", 2, 53, i16, "text/comma-separated-values");
        m68557a("POT", 2, 52, i17, "application/vnd.ms-powerpoint");
        m68557a("POTX", 2, 52, i17, "application/vnd.openxmlformats-officedocument.presentationml.template");
        m68557a("PPSX", 2, 52, i17, "application/vnd.openxmlformats-officedocument.presentationml.slideshow");
        if (MimeTypeMap.getSingleton().hasMimeType("application/caj")) {
            i11 = 50;
            m68557a("CAJ", 2, 50, R$drawable.hidisk_icon_caj, "application/caj");
        } else {
            i11 = 50;
        }
        if (MimeTypeMap.getSingleton().hasMimeType("application/kdh")) {
            m68557a("KDH", 2, i11, R$drawable.hidisk_icon_kdh, "application/kdh");
        }
        if (MimeTypeMap.getSingleton().hasMimeType("application/nh")) {
            m68557a("NH", 2, i11, R$drawable.hidisk_icon_nh, "application/nh");
        }
        if (MimeTypeMap.getSingleton().hasMimeType("application/teb")) {
            m68557a("TEB", 2, i11, R$drawable.hidisk_icon_teb, "application/teb");
        }
        if (MimeTypeMap.getSingleton().hasMimeType("application/x-eddx")) {
            m68557a("EDDX", 2, i11, R$drawable.hidisk_icon_eddx, "application/x-eddx");
        }
        m68557a("BZ", 8, 117, i19, "application/x-bzip");
        m68557a("BZ2", 8, 118, i19, "application/x-bzip2");
        m68557a("7Z", 8, 116, R$drawable.hidisk_icon_7z, "application/x-7z-compressed");
        m68557a("VCF", 2, SyncType.RISK_MANAGEMENT_MANUALLY, R$drawable.hidisk_icon_vcard, "text/x-vcard");
        m68557a("DCF", 9, 200, i12, "application/vnd.oma.drm.content");
        m68557a("ARW", 6, 7, i21, "image/x-sony-arw");
        m68557a("K3G", 9, 40, i12, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        m68557a("MPO", 9, 11, i12, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        m68557a("MMF", 9, 86, i12, "application/vnd.smaf");
        m68557a("QCP", 9, 89, i12, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
    }

    /* renamed from: a */
    public static void m68557a(String str, int i10, int i11, int i12, String str2) {
        C11446c c11446c = new C11446c(str, i10, i11, i12, str2);
        f53315c.put(str, c11446c);
        f53316d.put(str2, c11446c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.FileInputStream] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m68558b(java.io.File r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "IOException"
            java.lang.String r1 = "FileMimeTypeUtil"
            r2 = 0
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3e java.lang.OutOfMemoryError -> L41 java.io.FileNotFoundException -> L43
            r3.<init>()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3e java.lang.OutOfMemoryError -> L41 java.io.FileNotFoundException -> L43
            r4 = 1
            r3.inSampleSize = r4     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3e java.lang.OutOfMemoryError -> L41 java.io.FileNotFoundException -> L43
            java.io.FileInputStream r7 = hk.C10278a.m63444j(r7)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3e java.lang.OutOfMemoryError -> L41 java.io.FileNotFoundException -> L43
            android.graphics.Bitmap r2 = p035bk.C1248a.m7476g(r7, r2, r3)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L36 java.lang.OutOfMemoryError -> L7b java.io.FileNotFoundException -> L8d
            if (r7 == 0) goto L32
            r7.close()     // Catch: java.io.IOException -> L1b
            goto L32
        L1b:
            r7 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r7 = r7.toString()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            p514o9.C11839m.m70687e(r1, r7)
        L32:
            return r2
        L33:
            r2 = move-exception
            goto La0
        L36:
            r3 = move-exception
            goto L45
        L38:
            r7 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
            goto La0
        L3e:
            r3 = move-exception
            r7 = r2
            goto L45
        L41:
            r7 = r2
            goto L7b
        L43:
            r7 = r2
            goto L8d
        L45:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
            r4.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.String r5 = "exception = "
            r4.append(r5)     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L33
            r4.append(r3)     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L33
            p514o9.C11839m.m70687e(r1, r3)     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L9f
            r7.close()     // Catch: java.io.IOException -> L63
            goto L9f
        L63:
            r7 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L69:
            r3.append(r0)
            java.lang.String r7 = r7.toString()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            p514o9.C11839m.m70687e(r1, r7)
            goto L9f
        L7b:
            java.lang.String r3 = "OutOfMemoryError"
            p514o9.C11839m.m70687e(r1, r3)     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L9f
            r7.close()     // Catch: java.io.IOException -> L86
            goto L9f
        L86:
            r7 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L69
        L8d:
            java.lang.String r3 = "FileNotFoundException"
            p514o9.C11839m.m70687e(r1, r3)     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L9f
            r7.close()     // Catch: java.io.IOException -> L98
            goto L9f
        L98:
            r7 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L69
        L9f:
            return r2
        La0:
            if (r7 == 0) goto Lbd
            r7.close()     // Catch: java.io.IOException -> La6
            goto Lbd
        La6:
            r7 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r7 = r7.toString()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            p514o9.C11839m.m70687e(r1, r7)
        Lbd:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: me.C11444a.m68558b(java.io.File):android.graphics.Bitmap");
    }

    /* renamed from: c */
    public static Bitmap m68559c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File fileM63442h = C10278a.m63442h(str);
        return (!fileM63442h.exists() || (fileM63442h.length() <= 1048576 && fileM63442h.length() != 0)) ? m68558b(fileM63442h) : C0224k0.m1548c(str, 3);
    }

    /* renamed from: d */
    public static C11446c m68560d(String str, boolean z10) {
        String strNormalizerString = StringUtil.normalizerString(str);
        if (!C14034a.m84165b(strNormalizerString)) {
            return f53314b;
        }
        C11446c c11446c = f53315c.get(strNormalizerString.substring(strNormalizerString.lastIndexOf(".") + 1).toUpperCase(f53313a));
        if (!z10) {
            return c11446c == null ? f53314b : c11446c;
        }
        if (c11446c == null) {
            return f53314b;
        }
        C11446c c11446cM68562f = m68562f(c11446c.m68566b(), f53316d);
        return c11446cM68562f != null ? c11446cM68562f : c11446c;
    }

    /* renamed from: e */
    public static int m68561e(String str, int i10, int i11) {
        return (i10 == 0 && i11 == 0) ? R$drawable.hidisk_icon_folder : i10 == 0 ? R$drawable.hidisk_icon_folder_has_file : m68560d(str, false).m68567c();
    }

    /* renamed from: f */
    public static C11446c m68562f(String str, HashMap<String, C11446c> map) {
        if (str == null) {
            return null;
        }
        C11446c c11446c = map.get(str);
        if (c11446c == null && str.contains("mpeg3")) {
            c11446c = map.get("MP3");
        }
        return c11446c == null ? f53314b : c11446c;
    }

    /* renamed from: g */
    public static boolean m68563g() throws NoSuchMethodException, SecurityException {
        try {
            Class.forName("com.huawei.android.app.ActionBarEx").getDeclaredMethod("setDynamicSplitToolbar", ActionBar.class, Boolean.TYPE);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
