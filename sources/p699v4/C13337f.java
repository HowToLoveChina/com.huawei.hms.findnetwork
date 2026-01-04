package p699v4;

import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: v4.f */
/* loaded from: classes.dex */
public class C13337f {

    /* renamed from: a */
    public ArrayList<a> f60155a;

    /* renamed from: b */
    public final Object f60156b = new Object();

    /* renamed from: v4.f$a */
    public static final class a {

        /* renamed from: a */
        public String f60157a;

        /* renamed from: b */
        public String f60158b;

        /* renamed from: c */
        public String f60159c;

        /* renamed from: d */
        public String f60160d;

        /* renamed from: e */
        public String f60161e;

        /* renamed from: f */
        public String m80009f() {
            return this.f60157a;
        }

        public String toString() {
            return " packageName:" + this.f60157a + " diffName:" + this.f60158b + " oldApkVersion:" + this.f60159c + " newApkVersion:" + this.f60160d + " newApkName:" + this.f60161e;
        }
    }

    /* renamed from: a */
    public boolean m80000a() {
        try {
            return new File(m80002c()).exists();
        } catch (SecurityException unused) {
            C2111d.m12648d("HotPatchConfigParser", "check has patch failed");
            return false;
        }
    }

    /* renamed from: b */
    public List<a> m80001b() {
        ArrayList<a> arrayList;
        synchronized (this.f60156b) {
            arrayList = this.f60155a;
        }
        return arrayList;
    }

    /* renamed from: c */
    public final String m80002c() {
        return "/patch_hw/apk/apk_patch.xml";
    }

    /* renamed from: d */
    public boolean m80003d() {
        boolean z10;
        FileInputStream fileInputStream;
        File file = new File(m80002c());
        synchronized (this.f60156b) {
            this.f60155a = new ArrayList<>();
            FileInputStream fileInputStream2 = null;
            a aVar = null;
            FileInputStream fileInputStream3 = null;
            fileInputStream2 = null;
            fileInputStream2 = null;
            boolean z11 = false;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (FileNotFoundException unused) {
                } catch (IOException unused2) {
                } catch (XmlPullParserException unused3) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStream, null);
                    XmlUtils.beginDocument(xmlPullParserNewPullParser, "apkpatch");
                    z10 = false;
                    while (true) {
                        try {
                            XmlUtils.nextElement(xmlPullParserNewPullParser);
                            String name = xmlPullParserNewPullParser.getName();
                            if (name == null) {
                                break;
                            }
                            if (JsbMapKeyNames.H5_APP_PKGNAME.equals(name)) {
                                aVar = new a();
                                aVar.f60157a = XmlUtils.readStringAttribute(xmlPullParserNewPullParser, "value");
                                z10 = false;
                            } else if ("diffName".equals(name) && aVar != null) {
                                aVar.f60158b = XmlUtils.readStringAttribute(xmlPullParserNewPullParser, "value");
                            } else if ("oldapkversion".equals(name) && aVar != null) {
                                aVar.f60159c = XmlUtils.readStringAttribute(xmlPullParserNewPullParser, "value");
                            } else if ("newapkversion".equals(name) && aVar != null) {
                                aVar.f60160d = XmlUtils.readStringAttribute(xmlPullParserNewPullParser, "value");
                            } else if (!"newapkName".equals(name) || aVar == null) {
                                C2111d.m12646b("HotPatchConfigParser", "Unknown element");
                            } else {
                                aVar.f60161e = XmlUtils.readStringAttribute(xmlPullParserNewPullParser, "value");
                                z10 = true;
                            }
                            if (z10) {
                                this.f60155a.add(aVar);
                            }
                        } catch (FileNotFoundException unused4) {
                            fileInputStream2 = fileInputStream;
                            z11 = z10;
                            C2111d.m12648d("HotPatchConfigParser", "patch info parse fail");
                            C13339h.m80014a(fileInputStream2);
                            z10 = z11;
                            return z10;
                        } catch (IOException unused5) {
                            fileInputStream2 = fileInputStream;
                            z11 = z10;
                            C2111d.m12648d("HotPatchConfigParser", "getSystemHotPatch :IOException");
                            C13339h.m80014a(fileInputStream2);
                            z10 = z11;
                            return z10;
                        } catch (XmlPullParserException unused6) {
                            fileInputStream2 = fileInputStream;
                            z11 = z10;
                            C2111d.m12648d("HotPatchConfigParser", "getSystemHotPatch :XmlPullParserException");
                            C13339h.m80014a(fileInputStream2);
                            z10 = z11;
                            return z10;
                        }
                    }
                    C13339h.m80014a(fileInputStream);
                } catch (FileNotFoundException unused7) {
                    fileInputStream2 = fileInputStream;
                } catch (IOException unused8) {
                    fileInputStream2 = fileInputStream;
                } catch (XmlPullParserException unused9) {
                    fileInputStream2 = fileInputStream;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream3 = fileInputStream;
                C13339h.m80014a(fileInputStream3);
                throw th;
            }
        }
        return z10;
    }
}
