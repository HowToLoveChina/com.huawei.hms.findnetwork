package p006a5;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Xml;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import p699v4.C13342k;

/* renamed from: a5.f */
/* loaded from: classes.dex */
public class C0051f extends AbstractC0048c {

    /* renamed from: f */
    public ContentValues f125f = null;

    /* renamed from: g */
    public File f126g = null;

    /* renamed from: h */
    public FileOutputStream f127h = null;

    /* renamed from: i */
    public XmlSerializer f128i = null;

    /* renamed from: j */
    public String f129j = null;

    public C0051f() {
        this.f115a = ".xml";
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: B */
    public synchronized int mo186B(String str, ContentValues[] contentValuesArr, Handler.Callback callback, Object obj) {
        if (this.f127h != null && this.f128i != null) {
            int i10 = 0;
            while (i10 < contentValuesArr.length) {
                int i11 = mo187C(str, contentValuesArr[i10]) == 1 ? 0 : 2;
                i10++;
                m204w(i11, i10, contentValuesArr.length, callback, obj);
            }
            return 1;
        }
        C2111d.m12648d("StoreHandlerXml", "write is fail, outputStream or serializer is null");
        return 2;
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: C */
    public synchronized int mo187C(String str, ContentValues contentValues) {
        if (this.f127h != null && this.f128i != null) {
            if (contentValues == null) {
                C2111d.m12648d("StoreHandlerXml", "write is fail, values is null");
                return 2;
            }
            try {
                if (this.f125f.containsKey(str)) {
                    this.f125f.put(str, Integer.valueOf(this.f125f.getAsInteger(str).intValue() + 1));
                } else {
                    this.f125f.put(str, (Integer) 1);
                }
                this.f128i.startTag("", "row");
                this.f128i.attribute("", "table", str);
                for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    String key = entry.getKey();
                    String[] strArrM219J = m219J(entry);
                    this.f128i.startTag("", "column");
                    this.f128i.attribute("", "name", key);
                    this.f128i.startTag("", "value");
                    this.f128i.attribute("", strArrM219J[1], strArrM219J[0]);
                    this.f128i.endTag("", "value");
                    this.f128i.endTag("", "column");
                }
                this.f128i.endTag("", "row");
                return 1;
            } catch (IOException unused) {
                C2111d.m12648d("StoreHandlerXml", "writeXML Exception");
                return 2;
            }
        }
        C2111d.m12648d("StoreHandlerXml", "write is fail, outputStream or serializer is null");
        return 2;
    }

    /* renamed from: D */
    public final XmlSerializer m213D(FileOutputStream fileOutputStream, String str) throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        try {
            xmlSerializerNewSerializer.setOutput(fileOutputStream, Constants.UTF_8);
            xmlSerializerNewSerializer.startDocument(null, Boolean.TRUE);
            this.f129j = str;
            xmlSerializerNewSerializer.startTag("", str);
            return xmlSerializerNewSerializer;
        } catch (IOException unused) {
            C2111d.m12648d("StoreHandlerXml", "createXML fail");
            this.f129j = null;
            return null;
        }
    }

    /* renamed from: E */
    public final int m214E(XmlPullParser xmlPullParser, String str, int i10) {
        if (str == null) {
            return 0;
        }
        String name = xmlPullParser.getName();
        if ("row".equals(name)) {
            return ("table".equals(xmlPullParser.getAttributeName(0)) && str.equals(xmlPullParser.getAttributeValue(0))) ? 1 : 0;
        }
        if ("column".equals(name)) {
            return i10 != 0 ? 2 : 0;
        }
        if ("value".equals(name)) {
            return i10 != 0 ? 3 : 0;
        }
        C2111d.m12646b("StoreHandlerXml", "unknown tag");
        return 0;
    }

    /* renamed from: F */
    public final String m215F(String str, String[] strArr) {
        if (strArr == null) {
            return str;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: G */
    public final String m216G(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        int iM214E = 1;
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    C2111d.m12648d("StoreHandlerXml", "XmlPullParser.END_DOCUMENT");
                    return null;
                }
                if (next == 2) {
                    iM214E = m214E(xmlPullParser, str, iM214E);
                    if (iM214E == 2) {
                        return m215F(xmlPullParser.getAttributeValue(0), null);
                    }
                } else if (next != 3) {
                    C2111d.m12647c("StoreHandlerXml", "getColumnName eventType: ", Integer.valueOf(next));
                } else if ("row".equals(xmlPullParser.getName()) && iM214E != 0) {
                    return null;
                }
            } catch (IOException unused) {
                C2111d.m12648d("StoreHandlerXml", "getValidRow fail");
                return null;
            } catch (XmlPullParserException unused2) {
                C2111d.m12648d("StoreHandlerXml", "getValidRow XmlPullParserException");
                return null;
            }
        }
    }

    /* renamed from: H */
    public final ContentValues m217H(ContentValues contentValues, String str, String str2, String str3) {
        if (contentValues != null && str != null) {
            if (str3 == null) {
                contentValues.putNull(str);
                return contentValues;
            }
            try {
                if ("String".equals(str3)) {
                    contentValues.put(str, str2);
                } else if ("Long".equals(str3)) {
                    contentValues.put(str, Long.valueOf(C13342k.m80057f(str2)));
                } else if ("Integer".equals(str3)) {
                    contentValues.put(str, Integer.valueOf(C13342k.m80055d(str2)));
                } else if ("Boolean".equals(str3)) {
                    contentValues.put(str, Boolean.valueOf(str2));
                } else if ("Short".equals(str3)) {
                    contentValues.put(str, Short.valueOf(C13342k.m80058g(str2)));
                } else if ("Byte".equals(str3)) {
                    contentValues.put(str, Byte.valueOf(C13342k.m80052a(str2)));
                } else if ("Float".equals(str3)) {
                    contentValues.put(str, Float.valueOf(C13342k.m80054c(str2)));
                } else if ("Double".equals(str3)) {
                    contentValues.put(str, Double.valueOf(C13342k.m80053b(str2)));
                } else if ("Blob".equals(str3)) {
                    try {
                        contentValues.put(str, str2.getBytes(Constants.UTF_8));
                    } catch (UnsupportedEncodingException unused) {
                        C2111d.m12648d("StoreHandlerXml", "getContentValues Exception");
                    }
                } else if ("Null".equals(str3)) {
                    contentValues.putNull(str);
                } else {
                    contentValues.put(str, str2);
                }
            } catch (NumberFormatException e10) {
                C2111d.m12649e("StoreHandlerXml", "getContentValues NumberFormatException:", e10.getMessage());
            }
        }
        return contentValues;
    }

    /* renamed from: I */
    public final ContentValues m218I(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        ContentValues contentValues = null;
        String strM215F = null;
        int iM214E = 0;
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return null;
                }
                if (next == 2) {
                    iM214E = m214E(xmlPullParser, str, iM214E);
                    if (iM214E == 1) {
                        contentValues = new ContentValues();
                    } else if (iM214E == 2) {
                        strM215F = m215F(xmlPullParser.getAttributeValue(0), strArr);
                    } else if (iM214E == 3) {
                        contentValues = m217H(contentValues, strM215F, xmlPullParser.getAttributeValue(0), xmlPullParser.getAttributeName(0));
                    } else {
                        C2111d.m12646b("StoreHandlerXml", "invalid tag");
                    }
                } else if (next == 3 && "row".equals(xmlPullParser.getName())) {
                    if (contentValues != null) {
                        return contentValues;
                    }
                    strM215F = null;
                }
            } catch (IOException unused) {
                C2111d.m12648d("StoreHandlerXml", "getValidRow fail");
                return null;
            } catch (XmlPullParserException unused2) {
                C2111d.m12648d("StoreHandlerXml", "getValidRow XmlPullParserException");
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /* renamed from: J */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String[] m219J(java.util.Map.Entry<java.lang.String, java.lang.Object> r2) {
        /*
            r1 = this;
            java.lang.Object r1 = r2.getValue()
            if (r1 != 0) goto L9
            java.lang.String r2 = "Null"
            goto L48
        L9:
            boolean r2 = r1 instanceof java.lang.String
            java.lang.String r0 = "String"
            if (r2 == 0) goto L11
        Lf:
            r2 = r0
            goto L48
        L11:
            boolean r2 = r1 instanceof java.lang.Long
            if (r2 == 0) goto L18
            java.lang.String r2 = "Long"
            goto L48
        L18:
            boolean r2 = r1 instanceof java.lang.Integer
            if (r2 == 0) goto L1f
            java.lang.String r2 = "Integer"
            goto L48
        L1f:
            boolean r2 = r1 instanceof java.lang.Boolean
            if (r2 == 0) goto L26
            java.lang.String r2 = "Boolean"
            goto L48
        L26:
            boolean r2 = r1 instanceof java.lang.Short
            if (r2 == 0) goto L2d
            java.lang.String r2 = "Short"
            goto L48
        L2d:
            boolean r2 = r1 instanceof java.lang.Byte
            if (r2 == 0) goto L34
            java.lang.String r2 = "Byte"
            goto L48
        L34:
            boolean r2 = r1 instanceof java.lang.Float
            if (r2 == 0) goto L3b
            java.lang.String r2 = "Float"
            goto L48
        L3b:
            boolean r2 = r1 instanceof java.lang.Double
            if (r2 == 0) goto L42
            java.lang.String r2 = "Double"
            goto L48
        L42:
            boolean r2 = r1 instanceof byte[]
            if (r2 == 0) goto Lf
            java.lang.String r2 = "Blob"
        L48:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p006a5.C0051f.m219J(java.util.Map$Entry):java.lang.String[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0071 A[Catch: all -> 0x0013, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0006, B:13:0x002d, B:14:0x002f, B:17:0x003a, B:28:0x005c, B:20:0x0044, B:34:0x006d, B:36:0x0071, B:37:0x0073, B:39:0x0077, B:30:0x005f, B:33:0x006c, B:32:0x0065, B:25:0x0051, B:10:0x0016, B:11:0x001e, B:12:0x0026, B:16:0x0033, B:24:0x004a), top: B:48:0x0001, inners: #4, #6, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0077 A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0006, B:13:0x002d, B:14:0x002f, B:17:0x003a, B:28:0x005c, B:20:0x0044, B:34:0x006d, B:36:0x0071, B:37:0x0073, B:39:0x0077, B:30:0x005f, B:33:0x006c, B:32:0x0065, B:25:0x0051, B:10:0x0016, B:11:0x001e, B:12:0x0026, B:16:0x0033, B:24:0x004a), top: B:48:0x0001, inners: #4, #6, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // p006a5.C0046a
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void mo170b() {
        /*
            r4 = this;
            monitor-enter(r4)
            org.xmlpull.v1.XmlSerializer r0 = r4.f128i     // Catch: java.lang.Throwable -> L13
            r1 = 0
            if (r0 == 0) goto L2f
            java.lang.String r2 = ""
            java.lang.String r3 = r4.f129j     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L16 java.lang.IllegalStateException -> L1e java.lang.IllegalArgumentException -> L26
            r0.endTag(r2, r3)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L16 java.lang.IllegalStateException -> L1e java.lang.IllegalArgumentException -> L26
            org.xmlpull.v1.XmlSerializer r0 = r4.f128i     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L16 java.lang.IllegalStateException -> L1e java.lang.IllegalArgumentException -> L26
            r0.endDocument()     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L16 java.lang.IllegalStateException -> L1e java.lang.IllegalArgumentException -> L26
            goto L2d
        L13:
            r0 = move-exception
            goto L7e
        L16:
            java.lang.String r0 = "StoreHandlerXml"
            java.lang.String r2 = "close serializer IOException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r2)     // Catch: java.lang.Throwable -> L13
            goto L2d
        L1e:
            java.lang.String r0 = "StoreHandlerXml"
            java.lang.String r2 = "close serializer IllegalStateException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r2)     // Catch: java.lang.Throwable -> L13
            goto L2d
        L26:
            java.lang.String r0 = "StoreHandlerXml"
            java.lang.String r2 = "close serializer IllegalArgumentException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r2)     // Catch: java.lang.Throwable -> L13
        L2d:
            r4.f128i = r1     // Catch: java.lang.Throwable -> L13
        L2f:
            java.io.FileOutputStream r0 = r4.f127h     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L6d
            java.io.FileDescriptor r0 = r0.getFD()     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4a
            r0.sync()     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4a
            java.io.FileOutputStream r0 = r4.f127h     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L40
            r0.close()     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L40
            goto L5c
        L40:
            java.lang.String r0 = "StoreHandlerXml"
            java.lang.String r2 = "close outputStream IOException"
        L44:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r2)     // Catch: java.lang.Throwable -> L13
            goto L5c
        L48:
            r0 = move-exception
            goto L5f
        L4a:
            java.lang.String r0 = "StoreHandlerXml"
            java.lang.String r2 = "close outputStream IOException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r2)     // Catch: java.lang.Throwable -> L48
            java.io.FileOutputStream r0 = r4.f127h     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L57
            r0.close()     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L57
            goto L5c
        L57:
            java.lang.String r0 = "StoreHandlerXml"
            java.lang.String r2 = "close outputStream IOException"
            goto L44
        L5c:
            r4.f127h = r1     // Catch: java.lang.Throwable -> L13
            goto L6d
        L5f:
            java.io.FileOutputStream r1 = r4.f127h     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L65
            r1.close()     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L65
            goto L6c
        L65:
            java.lang.String r1 = "StoreHandlerXml"
            java.lang.String r2 = "close outputStream IOException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r2)     // Catch: java.lang.Throwable -> L13
        L6c:
            throw r0     // Catch: java.lang.Throwable -> L13
        L6d:
            java.io.File r0 = r4.f126g     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L73
            r4.f126g = r1     // Catch: java.lang.Throwable -> L13
        L73:
            android.content.ContentValues r0 = r4.f125f     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L7c
            r0.clear()     // Catch: java.lang.Throwable -> L13
            r4.f125f = r1     // Catch: java.lang.Throwable -> L13
        L7c:
            monitor-exit(r4)
            return
        L7e:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p006a5.C0051f.mo170b():void");
    }

    @Override // p006a5.C0046a
    /* renamed from: d */
    public synchronized boolean mo172d(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !str.toLowerCase(this.f118d).endsWith(this.f115a)) {
                str = str + this.f115a;
            }
            File file = new File(str);
            try {
                if (file.exists()) {
                    this.f126g = file;
                } else {
                    if (!file.createNewFile()) {
                        return false;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    this.f127h = fileOutputStream;
                    this.f128i = m213D(fileOutputStream, file.getName());
                }
                this.f125f = new ContentValues();
                this.f116b = str;
                return true;
            } catch (IOException unused) {
                C2111d.m12648d("StoreHandlerXml", "exception in createNewFile()");
                return false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: l */
    public Cursor mo194l(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p006a5.AbstractC0048c
    /* renamed from: t */
    public synchronized ContentValues[] mo201t(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        String str4;
        String str5;
        FileInputStream fileInputStream;
        XmlPullParser xmlPullParserNewPullParser;
        HashSet hashSet;
        ContentValues[] contentValuesArr = new ContentValues[0];
        if (this.f126g == null) {
            C2111d.m12648d("StoreHandlerXml", "readArrayRaw is fail, inputXmlFile is null");
            return contentValuesArr;
        }
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        FileInputStream fileInputStream4 = null;
        try {
            try {
                fileInputStream = new FileInputStream(this.f126g);
                try {
                    xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStream, Constants.UTF_8);
                    hashSet = new HashSet();
                    while (true) {
                        ContentValues contentValuesM218I = m218I(xmlPullParserNewPullParser, str, strArr);
                        if (contentValuesM218I == null) {
                            break;
                        }
                        hashSet.add(contentValuesM218I);
                    }
                } catch (FileNotFoundException unused) {
                    fileInputStream3 = fileInputStream;
                    C2111d.m12648d("StoreHandlerXml", "inputStream :fail");
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                            fileInputStream2 = fileInputStream3;
                        } catch (IOException unused2) {
                            str4 = "StoreHandlerXml";
                            str5 = "inputStream.close error!";
                            C2111d.m12648d(str4, str5);
                            return contentValuesArr;
                        }
                    }
                    return contentValuesArr;
                } catch (XmlPullParserException unused3) {
                    fileInputStream4 = fileInputStream;
                    C2111d.m12648d("StoreHandlerXml", "readArrayRaw :XmlPullParserException");
                    fileInputStream2 = fileInputStream4;
                    if (fileInputStream4 != null) {
                        try {
                            fileInputStream4.close();
                            fileInputStream2 = fileInputStream4;
                        } catch (IOException unused4) {
                            str4 = "StoreHandlerXml";
                            str5 = "inputStream.close error!";
                            C2111d.m12648d(str4, str5);
                            return contentValuesArr;
                        }
                    }
                    return contentValuesArr;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused5) {
                            C2111d.m12648d("StoreHandlerXml", "inputStream.close error!");
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused6) {
            } catch (XmlPullParserException unused7) {
            }
            if (hashSet.size() > 0) {
                ContentValues[] contentValuesArr2 = (ContentValues[]) hashSet.toArray(contentValuesArr);
                try {
                    fileInputStream.close();
                } catch (IOException unused8) {
                    C2111d.m12648d("StoreHandlerXml", "inputStream.close error!");
                }
                return contentValuesArr2;
            }
            try {
                fileInputStream.close();
                fileInputStream2 = xmlPullParserNewPullParser;
            } catch (IOException unused9) {
                str4 = "StoreHandlerXml";
                str5 = "inputStream.close error!";
                C2111d.m12648d(str4, str5);
                return contentValuesArr;
            }
            return contentValuesArr;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: u */
    public synchronized Set<String> mo202u(String str) {
        String str2;
        String str3;
        Set<String> hashSet;
        FileInputStream fileInputStream;
        Set<String> setEmptySet = Collections.emptySet();
        if (this.f126g == null) {
            C2111d.m12648d("StoreHandlerXml", "readColumnNames is fail, inputXmlFile is null");
            return setEmptySet;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(this.f126g);
            } catch (FileNotFoundException unused) {
            } catch (XmlPullParserException unused2) {
            }
            try {
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStream, Constants.UTF_8);
                    hashSet = new HashSet<>();
                    while (true) {
                        try {
                            String strM216G = m216G(xmlPullParserNewPullParser, str);
                            if (strM216G == null) {
                                break;
                            }
                            hashSet.add(strM216G);
                        } catch (FileNotFoundException unused3) {
                            fileInputStream2 = fileInputStream;
                            setEmptySet = hashSet;
                            C2111d.m12648d("StoreHandlerXml", "readColumnNames :FileNotFoundException");
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused4) {
                                    str2 = "StoreHandlerXml";
                                    str3 = "readColumnNames :IOException";
                                    C2111d.m12648d(str2, str3);
                                    hashSet = setEmptySet;
                                    return hashSet;
                                }
                            }
                            hashSet = setEmptySet;
                            return hashSet;
                        } catch (XmlPullParserException unused5) {
                            fileInputStream2 = fileInputStream;
                            setEmptySet = hashSet;
                            C2111d.m12648d("StoreHandlerXml", "readColumnNames :XmlPullParserException");
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused6) {
                                    str2 = "StoreHandlerXml";
                                    str3 = "readColumnNames :IOException";
                                    C2111d.m12648d(str2, str3);
                                    hashSet = setEmptySet;
                                    return hashSet;
                                }
                            }
                            hashSet = setEmptySet;
                            return hashSet;
                        }
                    }
                } catch (FileNotFoundException unused7) {
                    fileInputStream2 = fileInputStream;
                } catch (XmlPullParserException unused8) {
                    fileInputStream2 = fileInputStream;
                }
                if (hashSet.size() > 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused9) {
                        C2111d.m12648d("StoreHandlerXml", "readColumnNames :IOException");
                    }
                    return hashSet;
                }
                C2111d.m12648d("StoreHandlerXml", "readColumnNames return null,set.size()=0");
                try {
                    fileInputStream.close();
                } catch (IOException unused10) {
                    C2111d.m12648d("StoreHandlerXml", "readColumnNames :IOException");
                }
                return hashSet;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused11) {
                        C2111d.m12648d("StoreHandlerXml", "readColumnNames :IOException");
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: v */
    public int mo203v(String str) {
        return 0;
    }
}
