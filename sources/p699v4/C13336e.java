package p699v4;

import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: v4.e */
/* loaded from: classes.dex */
public final class C13336e {

    /* renamed from: a */
    public static HashMap<String, Integer> f60154a = new HashMap<>(200);

    static {
        m79996a("3GPP2", 504);
        m79996a("IMY", 504);
        m79996a("AAC", 504);
        m79996a("AMR", 504);
        m79996a("MID", 504);
        m79996a("MPGA", 504);
        m79996a("MXMF", 504);
        m79996a("RMVB", BasicBaseResp.TERM_NO_SIGN);
        m79996a("RTTTL", 504);
        m79996a("RTX", 504);
        m79996a("SMF", 504);
        m79996a("WAV", 504);
        m79996a("WMA", 504);
        m79996a("OTA", 504);
        m79996a("XMF", 504);
        m79996a("OGG", 504);
        m79996a("PLS", 504);
        m79996a("QCP", 504);
        m79996a("MMF", 504);
        m79996a("RA", 504);
        m79996a("RAM", 504);
        m79996a("MIDI", 504);
        m79996a("M3U", 504);
        m79996a("M4A", 504);
        m79996a("M4B", 504);
        m79996a("M4P", 504);
        m79996a("AWB", 504);
        m79996a("MP2", 504);
        m79996a("MP3", 504);
        m79996a("AU", 504);
        m79996a("DOCX", 5062);
        m79996a("DOC", 5062);
        m79996a("XLS", 5061);
        m79996a("XLSX", 5061);
        m79996a(HiCloudNativeAd.CHANNEL_PPS, 5063);
        m79996a("PPT", 5063);
        m79996a("PPTX", 5063);
        m79996a("MSG", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("GTAR", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("OGA", 504);
        m79996a("PDF", 5064);
        m79996a("RAR", 5065);
        m79996a("RTF", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("TAR", 5065);
        m79996a("TGZ", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("WPL", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("WPS", 5062);
        m79996a("XHTML", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("Z", 5065);
        m79996a("ZIP", 5065);
        m79996a("MPC", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("JS", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("JAR", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("GZ", 5065);
        m79996a("PNG", 503);
        m79996a("RAW", 503);
        m79996a("WBMP", 503);
        m79996a("BMP", 503);
        m79996a("GIF", 503);
        m79996a("JPEG", 503);
        m79996a("MPO", 503);
        m79996a("JPG", 503);
        m79996a("DNG", 503);
        m79996a("CR2", 503);
        m79996a("NEF", 503);
        m79996a("NRW", 503);
        m79996a("ARW", 503);
        m79996a("RW2", 503);
        m79996a("ORF", 503);
        m79996a("RAF", 503);
        m79996a("PEF", 503);
        m79996a("SRW", 503);
        m79996a("HEIC", 503);
        m79996a("C", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("CONF", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("CPP", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("H", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("HTM", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("HTML", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("JAVA", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("LOG", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("PROP", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("RC", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("SH", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("TXT", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("XML", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("EPUB", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("M4U", BasicBaseResp.TERM_NO_SIGN);
        m79996a("M4V", BasicBaseResp.TERM_NO_SIGN);
        m79996a("MOV", BasicBaseResp.TERM_NO_SIGN);
        m79996a("MP4", BasicBaseResp.TERM_NO_SIGN);
        m79996a("MPE", BasicBaseResp.TERM_NO_SIGN);
        m79996a("MPEG", BasicBaseResp.TERM_NO_SIGN);
        m79996a("MPG", BasicBaseResp.TERM_NO_SIGN);
        m79996a("MPG4", BasicBaseResp.TERM_NO_SIGN);
        m79996a("MKV", BasicBaseResp.TERM_NO_SIGN);
        m79996a("WEBM", BasicBaseResp.TERM_NO_SIGN);
        m79996a("3GP", BasicBaseResp.TERM_NO_SIGN);
        m79996a("3GPP", BasicBaseResp.TERM_NO_SIGN);
        m79996a("ASF", BasicBaseResp.TERM_NO_SIGN);
        m79996a("ASX", BasicBaseResp.TERM_NO_SIGN);
        m79996a("AVI", BasicBaseResp.TERM_NO_SIGN);
        m79996a("FLV", BasicBaseResp.TERM_NO_SIGN);
        m79996a("M2TS", BasicBaseResp.TERM_NO_SIGN);
        m79996a("SUB", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("ASS", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("SSA", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("JAD", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("DHTML", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("SHTML", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("AC3", 504);
        m79996a("MKA", 504);
        m79996a("FLAC", 504);
        m79996a("AIF", 504);
        m79996a("AIFF", 504);
        m79996a("AIFC", 504);
        m79996a("APE", 504);
        m79996a("3G2", BasicBaseResp.TERM_NO_SIGN);
        m79996a("WMV", BasicBaseResp.TERM_NO_SIGN);
        m79996a("RM", BasicBaseResp.TERM_NO_SIGN);
        m79996a("RV", BasicBaseResp.TERM_NO_SIGN);
        m79996a("TS", BasicBaseResp.TERM_NO_SIGN);
        m79996a("DIVX", BasicBaseResp.TERM_NO_SIGN);
        m79996a("F4V", BasicBaseResp.TERM_NO_SIGN);
        m79996a("WEBP", 503);
        m79996a("TIF", 503);
        m79996a("ICO", 503);
        m79996a("TEXT", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("INI", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("VCS", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("JSP", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("ASP", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("PHP", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("DOTX", 5062);
        m79996a("DOT", 5062);
        m79996a("XLT", 5061);
        m79996a("XLTX", 5061);
        m79996a("CSV", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("POT", 5063);
        m79996a("POTX", 5063);
        m79996a("PPSX", 5063);
        m79996a("BZ", 5065);
        m79996a("BZ2", 5065);
        m79996a("7Z", 5065);
        m79996a("VCF", CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a(FaqConstants.OPEN_TYPE_APK, CBSbkFlowHead.FLOW_CONTROL_ERR_CODE);
        m79996a("MTS", BasicBaseResp.TERM_NO_SIGN);
        m79996a("ISMV", BasicBaseResp.TERM_NO_SIGN);
        m79996a("RMHD", BasicBaseResp.TERM_NO_SIGN);
        m79996a("BCI", 503);
        m79996a("SVG", 503);
        m79996a("WPNG", 503);
    }

    /* renamed from: a */
    public static void m79996a(String str, int i10) {
        f60154a.put(str, Integer.valueOf(i10));
    }

    /* renamed from: b */
    public static int m79997b(File file) {
        return m79998c(file);
    }

    /* renamed from: c */
    public static int m79998c(File file) throws IOException {
        String canonicalPath;
        int iLastIndexOf;
        if (m79999d(file)) {
            return -1;
        }
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (IOException unused) {
            C2111d.m12648d("FileMimeTypeUtil", "getMimeTypeObject IOException");
            canonicalPath = null;
        }
        if (canonicalPath == null || (iLastIndexOf = canonicalPath.lastIndexOf(".")) < 0) {
            return -1;
        }
        String upperCase = canonicalPath.substring(iLastIndexOf + 1).toUpperCase(Locale.ENGLISH);
        if (f60154a.containsKey(upperCase)) {
            return f60154a.get(upperCase).intValue();
        }
        return -1;
    }

    /* renamed from: d */
    public static boolean m79999d(File file) {
        return file == null || !file.exists() || file.isDirectory() || TextUtils.isEmpty(C13334c.m79991x(file));
    }
}
