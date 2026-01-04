package p640sq;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwidauth.datatype.ReadAllowListInfo;
import com.huawei.hwidauth.datatype.SiteDefaultInfo;
import com.huawei.hwidauth.datatype.SiteListInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p432kq.C11142n;
import p432kq.C11143o;

/* renamed from: sq.n */
/* loaded from: classes8.dex */
public class C12835n {

    /* renamed from: a */
    public static SiteListInfo f58581a;

    /* renamed from: a */
    public static int m77088a(Context context, String str) throws XmlPullParserException, IOException {
        if (context == null || TextUtils.isEmpty(str)) {
            C12836o.m77097b("IpCountryUtil", "getXmlVersionCode context is null or xmlStr is empty", true);
            return 0;
        }
        try {
            XmlPullParser xmlPullParserM67047a = C11143o.m67047a(str.getBytes(Constants.UTF_8));
            for (int eventType = xmlPullParserM67047a.getEventType(); 1 != eventType; eventType = xmlPullParserM67047a.next()) {
                String name = xmlPullParserM67047a.getName();
                if (2 == eventType && "Infos".equals(name)) {
                    for (int i10 = 0; i10 < xmlPullParserM67047a.getAttributeCount(); i10++) {
                        if ("version-code".equals(xmlPullParserM67047a.getAttributeName(i10))) {
                            try {
                                return C11142n.m67046a(xmlPullParserM67047a.getAttributeValue(i10));
                            } catch (Exception e10) {
                                C12836o.m77097b("IpCountryUtil", "e = " + e10.getClass().getSimpleName(), true);
                                return 0;
                            }
                        }
                    }
                }
            }
        } catch (UnsupportedEncodingException e11) {
            C12836o.m77098c("IpCountryUtil", "UnsupportedEncodingException " + e11.getClass().getSimpleName(), true);
        } catch (IOException e12) {
            C12836o.m77098c("IpCountryUtil", "IOException " + e12.getClass().getSimpleName(), true);
        } catch (XmlPullParserException e13) {
            C12836o.m77098c("IpCountryUtil", "XmlPullParserException " + e13.getClass().getSimpleName(), true);
        } catch (Exception e14) {
            C12836o.m77098c("IpCountryUtil", "Exception " + e14.getClass().getSimpleName(), true);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.BufferedReader] */
    /* renamed from: b */
    public static String m77089b(Context context) throws Throwable {
        ?? r72;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        try {
            try {
                inputStreamReader = new InputStreamReader(context.getResources().getAssets().open("global_cfg_for_android_mobile.xml"), Constants.UTF_8);
            } catch (UnsupportedEncodingException e10) {
                e = e10;
                bufferedReader = null;
                inputStreamReader = null;
            } catch (IOException e11) {
                e = e11;
                bufferedReader = null;
                inputStreamReader = null;
            } catch (Throwable th2) {
                th = th2;
                r72 = 0;
                inputStreamReader = null;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (UnsupportedEncodingException e12) {
                e = e12;
                bufferedReader = null;
            } catch (IOException e13) {
                e = e13;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                r72 = 0;
                m77093f(inputStreamReader, r72, null);
                throw th;
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        String string = sb2.toString();
                        m77093f(inputStreamReader, bufferedReader, null);
                        return string;
                    }
                    sb2.append(line);
                }
            } catch (UnsupportedEncodingException e14) {
                e = e14;
                C12836o.m77099d("IpCountryUtil", "UnsupportedEncodingException" + e.getClass().getSimpleName(), true);
                m77093f(inputStreamReader, bufferedReader, null);
                m77093f(inputStreamReader, bufferedReader, null);
                return "";
            } catch (IOException e15) {
                e = e15;
                C12836o.m77099d("IpCountryUtil", "IOException " + e.getClass().getSimpleName(), true);
                m77093f(inputStreamReader, bufferedReader, null);
                m77093f(inputStreamReader, bufferedReader, null);
                return "";
            }
        } catch (Throwable th4) {
            th = th4;
            r72 = context;
        }
    }

    /* renamed from: c */
    public static XmlPullParser m77090c(Context context, String str, String str2) throws XmlPullParserException, IOException {
        int iM77088a = m77088a(context, str);
        int iM77088a2 = m77088a(context, str2);
        C12836o.m77099d("IpCountryUtil", "parseSiteCountryXML xmlDataFileCode " + iM77088a, true);
        C12836o.m77099d("IpCountryUtil", "parseSiteCountryXML xmlAssetsFileCode " + iM77088a2, true);
        if (iM77088a < iM77088a2) {
            C12836o.m77099d("IpCountryUtil", "parseSiteCountryXML xmlDataFileCode < xmlAssetsFileCode", true);
            return C11143o.m67047a(str2.getBytes(Constants.UTF_8));
        }
        C12836o.m77099d("IpCountryUtil", "parseSiteCountryXML else ", true);
        return C11143o.m67047a(str.getBytes(Constants.UTF_8));
    }

    /* renamed from: d */
    public static void m77091d(Context context, SiteDefaultInfo siteDefaultInfo, ArrayList<String> arrayList, ArrayList<SiteListInfo> arrayList2) throws XmlPullParserException, IOException {
        if (context == null) {
            C12836o.m77098c("IpCountryUtil", "parseSiteCountryXML mContext == null", true);
            return;
        }
        C12836o.m77097b("IpCountryUtil", "getFromDataFile", true);
        XmlPullParser xmlPullParserM77090c = m77090c(context, m77094g(context), m77089b(context));
        for (int eventType = xmlPullParserM77090c.getEventType(); 1 != eventType; eventType = xmlPullParserM77090c.next()) {
            String name = xmlPullParserM77090c.getName();
            if (eventType == 2) {
                m77092e(context, xmlPullParserM77090c, siteDefaultInfo, arrayList, arrayList2, name);
            }
        }
    }

    /* renamed from: e */
    public static void m77092e(Context context, XmlPullParser xmlPullParser, SiteDefaultInfo siteDefaultInfo, ArrayList<String> arrayList, ArrayList<SiteListInfo> arrayList2, String str) {
        if ("site-list".equals(str)) {
            SiteDefaultInfo.m38024f(xmlPullParser, siteDefaultInfo);
            return;
        }
        if ("domain".equals(str)) {
            ReadAllowListInfo.m38019a(xmlPullParser, arrayList, str);
        } else if ("site".equals(str)) {
            SiteListInfo siteListInfo = new SiteListInfo();
            f58581a = siteListInfo;
            SiteListInfo.m38042i(xmlPullParser, siteListInfo, str);
            arrayList2.add(f58581a);
        }
    }

    /* renamed from: f */
    public static void m77093f(InputStreamReader inputStreamReader, BufferedReader bufferedReader, InputStream inputStream) throws IOException {
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e10) {
                C12836o.m77099d("IpCountryUtil", "IOException" + e10.getClass().getSimpleName(), true);
            }
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e11) {
                C12836o.m77099d("IpCountryUtil", "IOException" + e11.getClass().getSimpleName(), true);
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e12) {
                C12836o.m77099d("IpCountryUtil", "IOException" + e12.getClass().getSimpleName(), true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.InputStreamReader] */
    /* renamed from: g */
    public static String m77094g(Context context) throws Throwable {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        IOException e10;
        ?? r82;
        UnsupportedEncodingException e11;
        ?? r83;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        try {
            try {
                fileInputStream = new FileInputStream((context.getFilesDir().getCanonicalPath() + "/") + "global_cfg_for_android_mobile.xml");
            } catch (UnsupportedEncodingException e12) {
                e = e12;
                fileInputStream = null;
                bufferedReader2 = null;
            } catch (IOException e13) {
                e = e13;
                fileInputStream = null;
                bufferedReader2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                bufferedReader = null;
            }
            try {
                context = new InputStreamReader(fileInputStream, Constants.UTF_8);
                try {
                    bufferedReader2 = new BufferedReader(context);
                } catch (UnsupportedEncodingException e14) {
                    bufferedReader2 = null;
                    e11 = e14;
                    r83 = context;
                } catch (IOException e15) {
                    bufferedReader2 = null;
                    e10 = e15;
                    r82 = context;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    inputStreamReader2 = context;
                    m77093f(inputStreamReader2, bufferedReader, fileInputStream);
                    throw th;
                }
            } catch (UnsupportedEncodingException e16) {
                e = e16;
                bufferedReader2 = null;
                e11 = e;
                r83 = bufferedReader2;
                C12836o.m77099d("IpCountryUtil", "getFromDataFile UnsupportedEncodingException " + e11.getClass().getSimpleName(), true);
                m77093f(r83, bufferedReader2, fileInputStream);
                inputStreamReader = r83;
                m77093f(inputStreamReader, bufferedReader2, fileInputStream);
                return "";
            } catch (IOException e17) {
                e = e17;
                bufferedReader2 = null;
                e10 = e;
                r82 = bufferedReader2;
                C12836o.m77099d("IpCountryUtil", "getFromDataFile IOException " + e10.getClass().getSimpleName(), true);
                m77093f(r82, bufferedReader2, fileInputStream);
                inputStreamReader = r82;
                m77093f(inputStreamReader, bufferedReader2, fileInputStream);
                return "";
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                m77093f(inputStreamReader2, bufferedReader, fileInputStream);
                throw th;
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        String string = sb2.toString();
                        m77093f(context, bufferedReader2, fileInputStream);
                        return string;
                    }
                    sb2.append(line);
                }
            } catch (UnsupportedEncodingException e18) {
                e11 = e18;
                r83 = context;
                C12836o.m77099d("IpCountryUtil", "getFromDataFile UnsupportedEncodingException " + e11.getClass().getSimpleName(), true);
                m77093f(r83, bufferedReader2, fileInputStream);
                inputStreamReader = r83;
                m77093f(inputStreamReader, bufferedReader2, fileInputStream);
                return "";
            } catch (IOException e19) {
                e10 = e19;
                r82 = context;
                C12836o.m77099d("IpCountryUtil", "getFromDataFile IOException " + e10.getClass().getSimpleName(), true);
                m77093f(r82, bufferedReader2, fileInputStream);
                inputStreamReader = r82;
                m77093f(inputStreamReader, bufferedReader2, fileInputStream);
                return "";
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* renamed from: h */
    public static boolean m77095h(Context context, String str, String str2) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                try {
                    context.deleteFile(str);
                    fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
                    fileOutputStreamOpenFileOutput.write(str2.getBytes(Constants.UTF_8));
                    fileOutputStreamOpenFileOutput.close();
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused) {
                        C12836o.m77099d("IpCountryUtil", "IOException", true);
                    }
                    return true;
                } catch (IOException unused2) {
                    C12836o.m77099d("IpCountryUtil", "writeSMSAvailableCountryXML IOException", true);
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused3) {
                            C12836o.m77099d("IpCountryUtil", "IOException", true);
                        }
                    }
                    return false;
                }
            } catch (FileNotFoundException unused4) {
                C12836o.m77099d("IpCountryUtil", "writeSMSAvailableCountryXML FileNotFoundException", true);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused5) {
                        C12836o.m77099d("IpCountryUtil", "IOException", true);
                    }
                }
                return false;
            }
        } catch (Throwable th2) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException unused6) {
                    C12836o.m77099d("IpCountryUtil", "IOException", true);
                }
            }
            throw th2;
        }
    }
}
