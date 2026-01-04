package p818yp;

import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.constant.TradeMode;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import hk.C10279b;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import p556pp.C12202a;

/* renamed from: yp.a */
/* loaded from: classes8.dex */
public class C14034a {

    /* renamed from: a */
    public static final Locale f62797a = new Locale(FaqConstants.DEFAULT_ISO_LANGUAGE);

    /* renamed from: b */
    public static final C12202a f62798b = new C12202a(9, -1, -1, null);

    /* renamed from: c */
    public static HashMap<String, C12202a> f62799c = new HashMap<>();

    /* renamed from: d */
    public static HashMap<String, C12202a> f62800d = new HashMap<>();

    static {
        m84164a("3GPP2", 5, 53, -1, "audio/3gpp2");
        m84164a("IMY", 5, 25, -1, "audio/imelody");
        m84164a("AAC", 5, 8, -1, "audio/aac");
        m84164a("AMR", 5, 4, -1, "audio/amr");
        m84164a("MID", 5, 23, -1, "audio/midi");
        m84164a("MPGA", 5, 13, -1, "audio/mpeg");
        m84164a("MXMF", 5, 11, -1, "audio/mobile-xmf");
        m84164a("RMVB", 4, 57, -1, "video/x-pn-realvideo");
        m84164a("RTTTL", 5, 23, -1, "audio/midi");
        m84164a("RTX", 5, 23, -1, "audio/midi");
        m84164a("SMF", 5, 24, -1, "audio/sp-midi");
        m84164a("WAV", 5, 3, -1, "audio/x-wav");
        m84164a("WMA", 5, 6, -1, "audio/x-ms-wma");
        m84164a("OTA", 5, 23, -1, "audio/midi");
        m84164a("XMF", 5, 23, -1, "audio/midi");
        m84164a("OGG", 5, 7, -1, "audio/ogg");
        m84164a("PLS", 5, 151, -1, "audio/x-scpls");
        m84164a("QCP", 5, 14, -1, "audio/qcp");
        m84164a("MMF", 5, 22, -1, "audio/mmf");
        m84164a("RA", 5, 9, -1, "audio/x-pn-realaudio");
        m84164a("RAM", 5, 15, -1, "audio/x-pn-realaudio");
        m84164a("MIDI", 5, 23, -1, "audio/midi");
        m84164a("M3U", 5, 150, -1, "audio/x-mpegurl");
        m84164a("M4A", 5, 2, -1, "audio/mp4a-latm");
        m84164a("M4B", 5, 16, -1, "audio/mp4a-latm");
        m84164a("M4P", 5, 16, -1, "audio/mp4a-latm");
        m84164a("AWB", 5, 5, -1, "audio/amr-wb");
        m84164a("MP2", 5, 17, -1, "audio/x-mpeg");
        m84164a("MP3", 5, 1, -1, "audio/x-mpeg");
        m84164a("AU", 5, 19, -1, "audio/basic");
        m84164a("DOCX", 2, 304, -1, "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        m84164a("DOC", 2, 304, -1, "application/msword");
        m84164a("DOCM", 2, 304, -1, "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        m84164a("DOTM", 2, 304, -1, "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        m84164a("XLS", 2, 305, -1, "application/vnd.ms-excel");
        m84164a("XLSX", 2, 305, -1, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        m84164a(HiCloudNativeAd.CHANNEL_PPS, 2, 306, -1, "application/vnd.ms-powerpoint");
        m84164a("PPT", 2, 306, -1, "application/vnd.ms-powerpoint");
        m84164a("PPTX", 2, 306, -1, "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        m84164a("MSG", 2, -1, -1, "application/vnd.ms-outlook");
        m84164a("GTAR", 8, 350, -1, "application/x-gtar");
        m84164a("OGA", 5, 7, -1, "application/ogg");
        m84164a("PDF", 2, 302, -1, "application/pdf");
        m84164a("RAR", 8, 357, -1, "application/x-rar-compressed");
        m84164a("RTF", 2, 304, -1, "application/rtf");
        m84164a("TAR", 8, 353, -1, "application/x-tar");
        m84164a("TGZ", 8, 358, -1, "application/x-compressed");
        m84164a("WPL", 5, 152, -1, "application/vnd.ms-wpl");
        m84164a("WPS", 2, 304, -1, "application/vnd.ms-works");
        m84164a("XHTML", 2, 299, -1, "application/xhtml+xml");
        m84164a("Z", 8, 359, -1, "application/x-compressed");
        m84164a("ZIP", 8, 350, -1, "application/zip");
        m84164a("MPC", 2, -1, -1, "application/vnd.mpohun.certificate");
        m84164a("JS", 2, 299, -1, "application/x-javascript");
        m84164a("JAR", 8, 356, -1, "text/vnd.sun.j2me.app-descriptor");
        m84164a("GZ", 8, 354, -1, "application/x-gzip");
        m84164a("EXE", 9, -1, -1, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        m84164a(FaqConstants.OPEN_TYPE_APK, 7, 450, -1, "application/vnd.android.package-archive");
        m84164a("BIN", 9, -1, -1, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        m84164a("CLASS", 9, -1, -1, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM);
        m84164a("PNG", 6, 102, -1, MimeType.PNG);
        m84164a("RAW", 6, 106, -1, "image/raw");
        m84164a("WBMP", 6, 104, -1, "image/vnd.wap.wbmp");
        m84164a("BMP", 6, 103, -1, "image/bmp");
        m84164a("GIF", 6, 101, -1, MimeType.GIF);
        m84164a("JPEG", 6, 100, -1, MimeType.JPEG);
        m84164a("MPO", 6, 109, -1, "image/mpo");
        m84164a("JPG", 6, 100, -1, MimeType.JPEG);
        m84164a("JPE", 6, 100, -1, MimeType.JPEG);
        m84164a("HEIC", 6, 110, -1, "image/heif");
        m84164a("HEIF", 6, 110, -1, "image/heif");
        m84164a("DNG", 6, 106, -1, "image/x-adobe-dng");
        m84164a("C", 2, 299, -1, InterfaceC5483d.f25083i);
        m84164a("CONF", 2, 299, -1, InterfaceC5483d.f25083i);
        m84164a("CPP", 2, 299, -1, InterfaceC5483d.f25083i);
        m84164a("H", 2, 299, -1, InterfaceC5483d.f25083i);
        m84164a("HTM", 2, LocationRequest.PRIORITY_MAG_POSITION, -1, "text/html");
        m84164a("HTML", 2, LocationRequest.PRIORITY_MAG_POSITION, -1, "text/html");
        m84164a("JAVA", 2, 299, -1, InterfaceC5483d.f25083i);
        m84164a("LOG", 2, 299, -1, InterfaceC5483d.f25083i);
        m84164a("PROP", 2, 299, -1, InterfaceC5483d.f25083i);
        m84164a("RC", 2, 299, -1, InterfaceC5483d.f25083i);
        m84164a("SH", 2, 299, -1, InterfaceC5483d.f25083i);
        m84164a("TXT", 2, 300, -1, InterfaceC5483d.f25083i);
        m84164a("XML", 2, 303, -1, InterfaceC5483d.f25083i);
        m84164a("M4U", 4, 63, -1, "video/vnd.mpegurl");
        m84164a("M4V", 4, 51, -1, "video/x-m4v");
        m84164a("MOV", 4, 64, -1, "video/quicktime");
        m84164a("MP4", 4, 50, -1, MimeType.MP4);
        m84164a("MPE", 4, 50, -1, "video/mpeg");
        m84164a("MPEG", 4, 400, -1, "video/mpeg");
        m84164a("MPG", 4, 50, -1, "video/video/mp2p");
        m84164a("MPG4", 4, 50, -1, "video/mpeg");
        m84164a("MKV", 4, 60, -1, "video/x-matroska");
        m84164a("WEBM", 4, 62, -1, "video/x-matroska");
        m84164a("3GP", 4, 52, -1, "video/3gpp");
        m84164a("3GPP", 4, 52, -1, "video/3gpp");
        m84164a("ASF", 4, 59, -1, "video/x-ms-asf");
        m84164a("ASX", 4, 59, -1, "video/x-ms-asf");
        m84164a("AVI", 4, 58, -1, "video/x-msvideo");
        m84164a("FLV", 4, 65, -1, "video/x-flv");
        m84164a("M2TS", 4, 400, -1, "video/mpeg");
        m84164a("EPUB", 9, -1, -1, "application/epub+zip");
        m84164a("EBK3", 9, -1, -1, "application/x-expandedbook");
        m84164a("SUB", 2, 299, -1, "text/x-subviewer");
        m84164a("ASS", 2, 299, -1, "text/x-ssa");
        m84164a("SSA", 2, 299, -1, "text/x-ssa");
        m84164a("SAMI", 9, -1, -1, "application/x-sami");
        m84164a("SMI", 9, -1, -1, "application/x-sami");
        m84164a("SRT", 9, -1, -1, "application/x-subrip");
        m84164a("SWF", 9, -1, -1, "application/x-shockwave-flash");
        m84164a("CAB", 9, -1, -1, "application/x-shockwave-flash");
        m84164a("CHM", 9, -1, -1, "application/x-chm");
        m84164a("UMD", 9, -1, -1, "application/umd");
        m84164a(TradeMode.PDB, 9, -1, -1, "application/ebook");
        m84164a("JAD", 2, 299, -1, "text/vnd.sun.j2me.app-descriptor");
        m84164a("DHTML", 2, LocationRequest.PRIORITY_MAG_POSITION, -1, "text/html");
        m84164a("SHTML", 2, LocationRequest.PRIORITY_MAG_POSITION, -1, "text/html");
        m84164a("AC3", 5, 21, -1, "audio/ac3");
        m84164a("MKA", 5, 10, -1, "audio/x-matroska");
        m84164a("FLAC", 5, 12, -1, "audio/flac");
        m84164a("AIF", 5, 18, -1, "audio/x-aiff");
        m84164a("AIFF", 5, 18, -1, "audio/x-aiff");
        m84164a("AIFC", 5, 18, -1, "audio/x-aiff");
        m84164a("APE", 5, 20, -1, "audio/x-ape");
        m84164a("3G2", 4, 53, -1, "video/3gpp2");
        m84164a("WMV", 4, 54, -1, "video/x-ms-wmv");
        m84164a("RM", 4, 55, -1, "video/x-pn-realvideo");
        m84164a("RV", 4, 56, -1, "video/x-pn-realvideo");
        m84164a("TS", 4, 61, -1, "video/mp2ts");
        m84164a("DIVX", 4, 66, -1, "video/divx");
        m84164a("F4V", 4, 67, -1, "video/x-f4v");
        m84164a("WEBP", 6, 105, -1, "image/webp");
        m84164a("TIF", 6, 107, -1, "image/tiff");
        m84164a("ICO", 6, 108, -1, "image/x-icon");
        m84164a("TEXT", 2, 300, -1, InterfaceC5483d.f25083i);
        m84164a("INI", 2, 299, -1, InterfaceC5483d.f25083i);
        m84164a("VCS", 2, 299, -1, "text/x-vcalendar");
        m84164a("ICS", 2, 299, -1, "text/calendar");
        m84164a("JSP", 2, 299, -1, "text/html");
        m84164a("ASP", 2, 299, -1, "text/html");
        m84164a("PHP", 2, 299, -1, "text/html");
        m84164a("DOTX", 2, 304, -1, "application/vnd.openxmlformats-officedocument.wordprocessingml.template");
        m84164a("DOT", 2, 304, -1, "application/x-dot");
        m84164a("XLT", 2, 305, -1, "application/vnd.ms-excel");
        m84164a("XLTX", 2, 305, -1, "application/vnd.openxmlformats-officedocument.spreadsheetml.template");
        m84164a("CSV", 2, 305, -1, "text/comma-separated-values");
        m84164a("POT", 2, 306, -1, "application/vnd.ms-powerpoint");
        m84164a("POTX", 2, 306, -1, "application/vnd.openxmlformats-officedocument.presentationml.template");
        m84164a("PPSX", 2, 306, -1, "application/vnd.openxmlformats-officedocument.presentationml.slideshow");
        m84164a("BZ", 8, 351, -1, "application/x-bzip");
        m84164a("BZ2", 8, 352, -1, "application/x-bzip2");
        m84164a("7Z", 8, 355, -1, "application/x-7z-compressed");
        m84164a("VCF", 2, 460, -1, "text/x-vcard");
        m84164a("DCF", 9, 99, -1, "application/vnd.oma.drm.content");
        m84164a("ARW", 6, 106, -1, "image/x-sony-arw");
    }

    /* renamed from: a */
    public static void m84164a(String str, int i10, int i11, int i12, String str2) {
        C12202a c12202a = new C12202a(i10, i11, i12, str2);
        f62799c.put(str, c12202a);
        f62800d.put(str2, c12202a);
    }

    /* renamed from: b */
    public static boolean m84165b(String str) {
        int iLastIndexOf;
        String strNormalizerString = StringUtil.normalizerString(str);
        if (strNormalizerString == null || strNormalizerString.trim().isEmpty() || (iLastIndexOf = strNormalizerString.lastIndexOf(".")) < 0) {
            return false;
        }
        return strNormalizerString.length() >= iLastIndexOf + 1;
    }

    /* renamed from: c */
    public static C12202a m84166c(String str, boolean z10) {
        return m84167d(str, z10, f62799c);
    }

    /* renamed from: d */
    public static C12202a m84167d(String str, boolean z10, HashMap<String, C12202a> map) {
        String strNormalizerString = StringUtil.normalizerString(str);
        if (!m84165b(strNormalizerString)) {
            return f62798b;
        }
        C12202a c12202a = map.get(strNormalizerString.substring(strNormalizerString.lastIndexOf(".") + 1).toUpperCase(f62797a));
        if (!z10) {
            return c12202a == null ? f62798b : c12202a;
        }
        if (c12202a == null) {
            return f62798b;
        }
        C12202a c12202aM84172i = m84172i(c12202a.m73356b());
        return c12202aM84172i != null ? c12202aM84172i : c12202a;
    }

    /* renamed from: e */
    public static HashMap<String, C12202a> m84168e() {
        return f62799c;
    }

    /* renamed from: f */
    public static String m84169f(File file) {
        return m84171h(file).m73356b();
    }

    /* renamed from: g */
    public static HashMap<String, C12202a> m84170g() {
        return f62800d;
    }

    /* renamed from: h */
    public static C12202a m84171h(File file) {
        return (file == null || !file.exists() || file.isDirectory()) ? f62798b : m84166c(C10279b.m63452a(file), false);
    }

    /* renamed from: i */
    public static C12202a m84172i(String str) {
        if (str == null) {
            return null;
        }
        C12202a c12202a = f62800d.get(str);
        if (c12202a == null && str.contains("mpeg3")) {
            c12202a = f62800d.get("MP3");
        }
        return c12202a == null ? f62798b : c12202a;
    }

    /* renamed from: j */
    public static boolean m84173j(int i10) {
        return i10 == 450;
    }

    /* renamed from: k */
    public static boolean m84174k(int i10) {
        return i10 >= 350 && i10 <= 359;
    }

    /* renamed from: l */
    public static boolean m84175l(int i10) {
        if (i10 < 1 || i10 > 22) {
            return i10 >= 23 && i10 <= 25;
        }
        return true;
    }

    /* renamed from: m */
    public static boolean m84176m(int i10) {
        return i10 == 0;
    }

    /* renamed from: n */
    public static boolean m84177n(int i10) {
        return i10 >= 299 && i10 <= 306;
    }

    /* renamed from: o */
    public static boolean m84178o(int i10) {
        return i10 >= 100 && i10 <= 110;
    }

    /* renamed from: p */
    public static boolean m84179p(int i10) {
        return i10 >= 50 && i10 <= 67;
    }

    /* renamed from: q */
    public static boolean m84180q(File file) {
        return m84171h(file).m73357c();
    }
}
