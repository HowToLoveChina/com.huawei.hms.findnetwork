package com.huawei.android.hicloud.sync.syncutil;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import je.C10812z;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.f */
/* loaded from: classes3.dex */
public class C2977f {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r1v81 */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v44 */
    /* JADX WARN: Type inference failed for: r8v45 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v37 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* renamed from: a */
    public static boolean m17858a(String str, File file, String str2, Context context) throws Throwable {
        Context context2;
        BufferedOutputStream bufferedOutputStream;
        Object obj;
        int i10;
        Object obj2;
        String str3;
        Object obj3;
        Context context3;
        FileInputStream fileInputStream;
        Object obj4;
        int i11;
        ?? r52;
        ?? r82;
        Context context4;
        ?? r62;
        Object obj5;
        Object obj6;
        String strValueOf;
        HashMap map;
        Context context5;
        int i12;
        ?? r92;
        ?? r83;
        Context context6;
        ?? r63;
        FileOutputStream fileOutputStream;
        Object obj7;
        String str4;
        Context context7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Context context8;
        Object obj12;
        Object obj13;
        Context context9;
        Object obj14;
        FileOutputStream fileOutputStream2;
        boolean z10;
        FileOutputStream fileOutputStream3;
        FileOutputStream fileOutputStream4;
        Object obj15;
        Context context10;
        Object obj16;
        Context context11;
        Object obj17;
        ZipOutputStream zipOutputStream;
        Context context12;
        FileOutputStream fileOutputStream5;
        Object obj18;
        FileOutputStream fileOutputStream6;
        Context context13;
        Object obj19;
        Object obj20;
        BufferedOutputStream bufferedOutputStream2;
        boolean z11;
        ZipOutputStream zipOutputStream2;
        Context context14;
        Object obj21;
        ZipOutputStream zipOutputStream3;
        ZipOutputStream zipOutputStream4;
        Object obj22;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream3;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        ?? r12 = file;
        ?? r22 = context;
        ?? r53 = "sourceFile size is 0 sourceFilePath:";
        ?? r64 = "target zip is null";
        ?? r72 = "sourceFile not exists sourceFilePath :";
        ?? r84 = "FileToZip";
        ?? r93 = "useTime";
        File file2 = new File(str);
        String strM66627b = (str2 == null || str2.isEmpty()) ? C11058a.m66627b("00000") : str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "fileToZip", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        FileInputStream fileInputStream2 = null;
        long length = 0;
        try {
            try {
            } catch (FileNotFoundException unused) {
                context3 = r22;
                fileInputStream = null;
                str3 = "FileToZip";
                obj4 = "useTime";
            } catch (IOException e10) {
                e = e10;
                obj2 = null;
                str3 = "FileToZip";
                obj3 = "useTime";
            } catch (Throwable th2) {
                th = th2;
                context2 = r22;
                bufferedOutputStream = null;
                obj = "useTime";
                i10 = 0;
            }
            if (!file2.exists()) {
                try {
                    C11839m.m70689w("FileToZip", "sourceFile not exists sourceFilePath :" + str);
                    c11060cM66626a.m66665u(String.valueOf(2228));
                    c11060cM66626a.m66635A("sourceFile not exists sourceFilePath :" + str);
                    m17862e(null, null, null, null, null);
                    HashMap map2 = new HashMap();
                    map2.put("zipFileSize", String.valueOf(0));
                    map2.put("zipFileLength", String.valueOf(0L));
                    map2.put("useTime", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    C13622a.m81969o(r22, c11060cM66626a, map2);
                    return false;
                } catch (FileNotFoundException unused2) {
                    context6 = r22;
                    fileInputStream = null;
                    fileOutputStream = null;
                    r63 = 0;
                    obj7 = "useTime";
                    str4 = "fileToZip FileNotFoundException";
                    i12 = 0;
                    r92 = null;
                    str3 = "FileToZip";
                    r83 = 0;
                    C11839m.m70688i(str3, str4);
                    c11060cM66626a.m66665u(String.valueOf(2228));
                    c11060cM66626a.m66635A(str4);
                    m17862e(fileInputStream, r83, fileOutputStream, r63, r92);
                    map = new HashMap();
                    map.put("zipFileSize", String.valueOf(i12));
                    map.put("zipFileLength", String.valueOf(length));
                    map.put(obj7, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    context5 = context6;
                    C13622a.m81969o(context5, c11060cM66626a, map);
                    return true;
                } catch (IOException e11) {
                    e = e11;
                    r12 = 0;
                    r53 = 0;
                    r64 = 0;
                    r22 = "useTime";
                    i11 = 0;
                    r93 = 0;
                    str3 = "FileToZip";
                    r84 = 0;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("fileToZip IOException, e ");
                    try {
                        sb2.append(e.toString());
                        C11839m.m70688i(str3, sb2.toString());
                        c11060cM66626a.m66665u(String.valueOf(2228));
                        c11060cM66626a.m66635A("fileToZip IOException, e " + e.toString());
                        m17862e(r12, r84, r53, r64, r93);
                        map = new HashMap();
                        map.put("zipFileSize", String.valueOf(i11));
                        map.put("zipFileLength", String.valueOf(length));
                        strValueOf = String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                        obj6 = r22;
                        map.put(obj6, strValueOf);
                        context5 = context;
                        C13622a.m81969o(context5, c11060cM66626a, map);
                        return true;
                    } catch (Throwable th3) {
                        th = th3;
                        r72 = context;
                        fileInputStream2 = r12;
                        bufferedOutputStream = r93;
                        obj5 = r22;
                        r52 = r53;
                        r62 = r64;
                        context4 = r72;
                        r82 = r84;
                        m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                        HashMap map3 = new HashMap();
                        map3.put("zipFileSize", String.valueOf(i11));
                        map3.put("zipFileLength", String.valueOf(length));
                        map3.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        C13622a.m81969o(context4, c11060cM66626a, map3);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    context7 = r22;
                    bufferedOutputStream = null;
                    obj8 = null;
                    obj9 = null;
                    obj10 = null;
                    obj11 = "useTime";
                    i11 = 0;
                    obj5 = obj11;
                    r52 = obj8;
                    r62 = obj9;
                    context4 = context7;
                    r82 = obj10;
                    m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                    HashMap map32 = new HashMap();
                    map32.put("zipFileSize", String.valueOf(i11));
                    map32.put("zipFileLength", String.valueOf(length));
                    map32.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    C13622a.m81969o(context4, c11060cM66626a, map32);
                    throw th;
                }
            }
            length = file2.length();
            File[] fileArrListFiles = file2.listFiles();
            if (fileArrListFiles != null) {
                try {
                } catch (FileNotFoundException unused3) {
                    context6 = r22;
                    obj7 = "useTime";
                    str3 = "FileToZip";
                    str4 = "fileToZip FileNotFoundException";
                    fileInputStream = null;
                    fileOutputStream = null;
                    r63 = 0;
                    r83 = 0;
                    r92 = null;
                    i12 = 0;
                } catch (IOException e12) {
                    e = e12;
                    r22 = "useTime";
                    str3 = "FileToZip";
                    r12 = 0;
                    r53 = 0;
                    r64 = 0;
                    r84 = 0;
                    r93 = 0;
                    i11 = 0;
                } catch (Throwable th5) {
                    th = th5;
                    context7 = r22;
                    obj11 = "useTime";
                    bufferedOutputStream = null;
                    fileInputStream2 = null;
                    obj8 = null;
                    obj9 = null;
                    obj10 = null;
                    i11 = 0;
                    obj5 = obj11;
                    r52 = obj8;
                    r62 = obj9;
                    context4 = context7;
                    r82 = obj10;
                    m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                    HashMap map322 = new HashMap();
                    map322.put("zipFileSize", String.valueOf(i11));
                    map322.put("zipFileLength", String.valueOf(length));
                    map322.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    C13622a.m81969o(context4, c11060cM66626a, map322);
                    throw th;
                }
                if (fileArrListFiles.length >= 1) {
                    int length2 = fileArrListFiles.length;
                    if (r12 == 0) {
                        try {
                            C11839m.m70689w("FileToZip", "target zip is null");
                            c11060cM66626a.m66665u(String.valueOf(2228));
                            c11060cM66626a.m66635A("target zip is null");
                            m17862e(null, null, null, null, null);
                            HashMap map4 = new HashMap();
                            map4.put("zipFileSize", String.valueOf(length2));
                            map4.put("zipFileLength", String.valueOf(length));
                            map4.put("useTime", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            C13622a.m81969o(r22, c11060cM66626a, map4);
                            return false;
                        } catch (FileNotFoundException unused4) {
                            context9 = r22;
                            i12 = length2;
                            str3 = "FileToZip";
                            obj14 = "useTime";
                            str4 = "fileToZip FileNotFoundException";
                            fileInputStream = null;
                            fileOutputStream4 = null;
                            obj16 = obj14;
                            context10 = context9;
                            r63 = 0;
                            r83 = 0;
                            r92 = null;
                            obj7 = obj16;
                            fileOutputStream = fileOutputStream4;
                            context6 = context10;
                            C11839m.m70688i(str3, str4);
                            c11060cM66626a.m66665u(String.valueOf(2228));
                            c11060cM66626a.m66635A(str4);
                            m17862e(fileInputStream, r83, fileOutputStream, r63, r92);
                            map = new HashMap();
                            map.put("zipFileSize", String.valueOf(i12));
                            map.put("zipFileLength", String.valueOf(length));
                            map.put(obj7, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            context5 = context6;
                            C13622a.m81969o(context5, c11060cM66626a, map);
                            return true;
                        } catch (IOException e13) {
                            e = e13;
                            i11 = length2;
                            str3 = "FileToZip";
                            obj13 = "useTime";
                            z10 = false;
                            fileOutputStream3 = null;
                            obj15 = obj13;
                            r64 = 0;
                            r84 = 0;
                            r93 = 0;
                            r12 = z10;
                            r22 = obj15;
                            r53 = fileOutputStream3;
                            StringBuilder sb22 = new StringBuilder();
                            sb22.append("fileToZip IOException, e ");
                            sb22.append(e.toString());
                            C11839m.m70688i(str3, sb22.toString());
                            c11060cM66626a.m66665u(String.valueOf(2228));
                            c11060cM66626a.m66635A("fileToZip IOException, e " + e.toString());
                            m17862e(r12, r84, r53, r64, r93);
                            map = new HashMap();
                            map.put("zipFileSize", String.valueOf(i11));
                            map.put("zipFileLength", String.valueOf(length));
                            strValueOf = String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                            obj6 = r22;
                            map.put(obj6, strValueOf);
                            context5 = context;
                            C13622a.m81969o(context5, c11060cM66626a, map);
                            return true;
                        } catch (Throwable th6) {
                            th = th6;
                            context8 = r22;
                            i11 = length2;
                            obj12 = "useTime";
                            bufferedOutputStream = null;
                            fileInputStream2 = null;
                            fileOutputStream2 = null;
                            obj17 = obj12;
                            context11 = context8;
                            zipOutputStream = null;
                            obj18 = obj17;
                            fileOutputStream5 = fileOutputStream2;
                            context12 = context11;
                            r82 = 0;
                            obj5 = obj18;
                            r52 = fileOutputStream5;
                            r62 = zipOutputStream;
                            context4 = context12;
                            m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                            HashMap map3222 = new HashMap();
                            map3222.put("zipFileSize", String.valueOf(i11));
                            map3222.put("zipFileLength", String.valueOf(length));
                            map3222.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            C13622a.m81969o(context4, c11060cM66626a, map3222);
                            throw th;
                        }
                    }
                    try {
                        C11839m.m70686d("FileToZip", "create new file  result = " + file.createNewFile());
                        fileOutputStream6 = new FileOutputStream((File) r12);
                    } catch (FileNotFoundException unused5) {
                        context9 = r22;
                        obj14 = "useTime";
                        i12 = length2;
                        str3 = "FileToZip";
                        str4 = "fileToZip FileNotFoundException";
                        fileInputStream = null;
                        fileOutputStream4 = null;
                        obj16 = obj14;
                        context10 = context9;
                        r63 = 0;
                        r83 = 0;
                        r92 = null;
                        obj7 = obj16;
                        fileOutputStream = fileOutputStream4;
                        context6 = context10;
                        C11839m.m70688i(str3, str4);
                        c11060cM66626a.m66665u(String.valueOf(2228));
                        c11060cM66626a.m66635A(str4);
                        m17862e(fileInputStream, r83, fileOutputStream, r63, r92);
                        map = new HashMap();
                        map.put("zipFileSize", String.valueOf(i12));
                        map.put("zipFileLength", String.valueOf(length));
                        map.put(obj7, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        context5 = context6;
                        C13622a.m81969o(context5, c11060cM66626a, map);
                        return true;
                    } catch (IOException e14) {
                        e = e14;
                        obj13 = "useTime";
                        i11 = length2;
                        str3 = "FileToZip";
                        z10 = false;
                        fileOutputStream3 = null;
                        obj15 = obj13;
                        r64 = 0;
                        r84 = 0;
                        r93 = 0;
                        r12 = z10;
                        r22 = obj15;
                        r53 = fileOutputStream3;
                        StringBuilder sb222 = new StringBuilder();
                        sb222.append("fileToZip IOException, e ");
                        sb222.append(e.toString());
                        C11839m.m70688i(str3, sb222.toString());
                        c11060cM66626a.m66665u(String.valueOf(2228));
                        c11060cM66626a.m66635A("fileToZip IOException, e " + e.toString());
                        m17862e(r12, r84, r53, r64, r93);
                        map = new HashMap();
                        map.put("zipFileSize", String.valueOf(i11));
                        map.put("zipFileLength", String.valueOf(length));
                        strValueOf = String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                        obj6 = r22;
                        map.put(obj6, strValueOf);
                        context5 = context;
                        C13622a.m81969o(context5, c11060cM66626a, map);
                        return true;
                    } catch (Throwable th7) {
                        th = th7;
                        context8 = r22;
                        obj12 = "useTime";
                        i11 = length2;
                        bufferedOutputStream = null;
                        fileInputStream2 = null;
                        fileOutputStream2 = null;
                        obj17 = obj12;
                        context11 = context8;
                        zipOutputStream = null;
                        obj18 = obj17;
                        fileOutputStream5 = fileOutputStream2;
                        context12 = context11;
                        r82 = 0;
                        obj5 = obj18;
                        r52 = fileOutputStream5;
                        r62 = zipOutputStream;
                        context4 = context12;
                        m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                        HashMap map32222 = new HashMap();
                        map32222.put("zipFileSize", String.valueOf(i11));
                        map32222.put("zipFileLength", String.valueOf(length));
                        map32222.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        C13622a.m81969o(context4, c11060cM66626a, map32222);
                        throw th;
                    }
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream6);
                        try {
                            zipOutputStream4 = new ZipOutputStream(bufferedOutputStream);
                        } catch (FileNotFoundException unused6) {
                            context14 = r22;
                            obj21 = "useTime";
                            r92 = bufferedOutputStream;
                            i12 = length2;
                            str3 = "FileToZip";
                            str4 = "fileToZip FileNotFoundException";
                            fileInputStream = null;
                            zipOutputStream3 = null;
                        } catch (IOException e15) {
                            e = e15;
                            obj20 = "useTime";
                            bufferedOutputStream2 = bufferedOutputStream;
                            i11 = length2;
                            str3 = "FileToZip";
                            z11 = false;
                            zipOutputStream2 = null;
                        } catch (Throwable th8) {
                            th = th8;
                            context13 = r22;
                            obj19 = "useTime";
                            i11 = length2;
                            fileInputStream2 = null;
                            obj17 = obj19;
                            fileOutputStream2 = fileOutputStream6;
                            context11 = context13;
                            zipOutputStream = null;
                            obj18 = obj17;
                            fileOutputStream5 = fileOutputStream2;
                            context12 = context11;
                            r82 = 0;
                            obj5 = obj18;
                            r52 = fileOutputStream5;
                            r62 = zipOutputStream;
                            context4 = context12;
                            m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                            HashMap map322222 = new HashMap();
                            map322222.put("zipFileSize", String.valueOf(i11));
                            map322222.put("zipFileLength", String.valueOf(length));
                            map322222.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            C13622a.m81969o(context4, c11060cM66626a, map322222);
                            throw th;
                        }
                        try {
                            byte[] bArr = new byte[10240];
                            int length3 = fileArrListFiles.length;
                            int i13 = 0;
                            BufferedInputStream bufferedInputStream4 = null;
                            FileInputStream fileInputStream3 = null;
                            Object obj23 = r93;
                            while (i13 < length3) {
                                int i14 = length3;
                                try {
                                    File file3 = fileArrListFiles[i13];
                                    File[] fileArr = fileArrListFiles;
                                    obj22 = obj23;
                                    try {
                                        zipOutputStream4.putNextEntry(new ZipEntry(file3.getName()));
                                        FileInputStream fileInputStream4 = new FileInputStream(file3);
                                        try {
                                            int i15 = 10240;
                                            bufferedInputStream = new BufferedInputStream(fileInputStream4, 10240);
                                            int i16 = 0;
                                            while (true) {
                                                try {
                                                    int i17 = bufferedInputStream.read(bArr, i16, i15);
                                                    if (i17 == -1) {
                                                        break;
                                                    }
                                                    zipOutputStream4.write(bArr, i16, i17);
                                                    i16 = 0;
                                                    i15 = 10240;
                                                } catch (FileNotFoundException unused7) {
                                                    r92 = bufferedOutputStream;
                                                    bufferedInputStream3 = bufferedInputStream;
                                                    i12 = length2;
                                                    fileInputStream = fileInputStream4;
                                                    str4 = "fileToZip FileNotFoundException";
                                                    str3 = "FileToZip";
                                                    obj7 = obj22;
                                                    context6 = context;
                                                    fileOutputStream = fileOutputStream6;
                                                    r63 = zipOutputStream4;
                                                    r83 = bufferedInputStream3;
                                                    C11839m.m70688i(str3, str4);
                                                    c11060cM66626a.m66665u(String.valueOf(2228));
                                                    c11060cM66626a.m66635A(str4);
                                                    m17862e(fileInputStream, r83, fileOutputStream, r63, r92);
                                                    map = new HashMap();
                                                    map.put("zipFileSize", String.valueOf(i12));
                                                    map.put("zipFileLength", String.valueOf(length));
                                                    map.put(obj7, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                                    context5 = context6;
                                                    C13622a.m81969o(context5, c11060cM66626a, map);
                                                    return true;
                                                } catch (IOException e16) {
                                                    e = e16;
                                                    bufferedOutputStream3 = bufferedOutputStream;
                                                    bufferedInputStream2 = bufferedInputStream;
                                                    i11 = length2;
                                                    r12 = fileInputStream4;
                                                    str3 = "FileToZip";
                                                    r22 = obj22;
                                                    r53 = fileOutputStream6;
                                                    r64 = zipOutputStream4;
                                                    r84 = bufferedInputStream2;
                                                    r93 = bufferedOutputStream3;
                                                    StringBuilder sb2222 = new StringBuilder();
                                                    sb2222.append("fileToZip IOException, e ");
                                                    sb2222.append(e.toString());
                                                    C11839m.m70688i(str3, sb2222.toString());
                                                    c11060cM66626a.m66665u(String.valueOf(2228));
                                                    c11060cM66626a.m66635A("fileToZip IOException, e " + e.toString());
                                                    m17862e(r12, r84, r53, r64, r93);
                                                    map = new HashMap();
                                                    map.put("zipFileSize", String.valueOf(i11));
                                                    map.put("zipFileLength", String.valueOf(length));
                                                    strValueOf = String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                                                    obj6 = r22;
                                                    map.put(obj6, strValueOf);
                                                    context5 = context;
                                                    C13622a.m81969o(context5, c11060cM66626a, map);
                                                    return true;
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    i11 = length2;
                                                    fileInputStream2 = fileInputStream4;
                                                    obj5 = obj22;
                                                    context4 = context;
                                                    r52 = fileOutputStream6;
                                                    r62 = zipOutputStream4;
                                                    r82 = bufferedInputStream;
                                                    m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                                                    HashMap map3222222 = new HashMap();
                                                    map3222222.put("zipFileSize", String.valueOf(i11));
                                                    map3222222.put("zipFileLength", String.valueOf(length));
                                                    map3222222.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                                    C13622a.m81969o(context4, c11060cM66626a, map3222222);
                                                    throw th;
                                                }
                                            }
                                            fileInputStream4.close();
                                            bufferedInputStream.close();
                                            i13++;
                                            length3 = i14;
                                            bufferedInputStream4 = bufferedInputStream;
                                            obj23 = obj22;
                                            fileInputStream3 = fileInputStream4;
                                            fileArrListFiles = fileArr;
                                        } catch (FileNotFoundException unused8) {
                                            r92 = bufferedOutputStream;
                                            bufferedInputStream3 = bufferedInputStream4;
                                        } catch (IOException e17) {
                                            e = e17;
                                            bufferedOutputStream3 = bufferedOutputStream;
                                            bufferedInputStream2 = bufferedInputStream4;
                                        } catch (Throwable th10) {
                                            th = th10;
                                            bufferedInputStream = bufferedInputStream4;
                                        }
                                    } catch (FileNotFoundException unused9) {
                                        context6 = context;
                                        r92 = bufferedOutputStream;
                                        i12 = length2;
                                        fileInputStream = fileInputStream3;
                                        str4 = "fileToZip FileNotFoundException";
                                        str3 = "FileToZip";
                                        r83 = bufferedInputStream4;
                                        obj7 = obj22;
                                        fileOutputStream = fileOutputStream6;
                                        r63 = zipOutputStream4;
                                    } catch (IOException e18) {
                                        e = e18;
                                        r93 = bufferedOutputStream;
                                        i11 = length2;
                                        r12 = fileInputStream3;
                                        str3 = "FileToZip";
                                        r84 = bufferedInputStream4;
                                        r22 = obj22;
                                        r53 = fileOutputStream6;
                                        r64 = zipOutputStream4;
                                        StringBuilder sb22222 = new StringBuilder();
                                        sb22222.append("fileToZip IOException, e ");
                                        sb22222.append(e.toString());
                                        C11839m.m70688i(str3, sb22222.toString());
                                        c11060cM66626a.m66665u(String.valueOf(2228));
                                        c11060cM66626a.m66635A("fileToZip IOException, e " + e.toString());
                                        m17862e(r12, r84, r53, r64, r93);
                                        map = new HashMap();
                                        map.put("zipFileSize", String.valueOf(i11));
                                        map.put("zipFileLength", String.valueOf(length));
                                        strValueOf = String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                                        obj6 = r22;
                                        map.put(obj6, strValueOf);
                                        context5 = context;
                                        C13622a.m81969o(context5, c11060cM66626a, map);
                                        return true;
                                    } catch (Throwable th11) {
                                        th = th11;
                                        context4 = context;
                                        i11 = length2;
                                        fileInputStream2 = fileInputStream3;
                                        r82 = bufferedInputStream4;
                                        obj5 = obj22;
                                        r52 = fileOutputStream6;
                                        r62 = zipOutputStream4;
                                        m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                                        HashMap map32222222 = new HashMap();
                                        map32222222.put("zipFileSize", String.valueOf(i11));
                                        map32222222.put("zipFileLength", String.valueOf(length));
                                        map32222222.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                        C13622a.m81969o(context4, c11060cM66626a, map32222222);
                                        throw th;
                                    }
                                } catch (FileNotFoundException unused10) {
                                    context6 = context;
                                    i12 = length2;
                                    str4 = "fileToZip FileNotFoundException";
                                    str3 = "FileToZip";
                                    Object obj24 = obj23;
                                    r92 = bufferedOutputStream;
                                    fileInputStream = fileInputStream3;
                                    r83 = bufferedInputStream4;
                                    obj7 = obj24;
                                    fileOutputStream = fileOutputStream6;
                                    r63 = zipOutputStream4;
                                } catch (IOException e19) {
                                    e = e19;
                                    obj22 = obj23;
                                } catch (Throwable th12) {
                                    th = th12;
                                    obj22 = obj23;
                                }
                            }
                            Object obj25 = obj23;
                            try {
                                c11060cM66626a.m66635A("fileToZip success ");
                                m17862e(fileInputStream3, bufferedInputStream4, fileOutputStream6, zipOutputStream4, bufferedOutputStream);
                                map = new HashMap();
                                map.put("zipFileSize", String.valueOf(length2));
                                map.put("zipFileLength", String.valueOf(length));
                                strValueOf = String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                                obj6 = obj25;
                            } catch (FileNotFoundException unused11) {
                                BufferedInputStream bufferedInputStream5 = bufferedInputStream4;
                                obj7 = obj25;
                                context6 = context;
                                r92 = bufferedOutputStream;
                                i12 = length2;
                                fileInputStream = fileInputStream3;
                                str4 = "fileToZip FileNotFoundException";
                                r83 = bufferedInputStream5;
                                str3 = "FileToZip";
                                fileOutputStream = fileOutputStream6;
                                r63 = zipOutputStream4;
                                C11839m.m70688i(str3, str4);
                                c11060cM66626a.m66665u(String.valueOf(2228));
                                c11060cM66626a.m66635A(str4);
                                m17862e(fileInputStream, r83, fileOutputStream, r63, r92);
                                map = new HashMap();
                                map.put("zipFileSize", String.valueOf(i12));
                                map.put("zipFileLength", String.valueOf(length));
                                map.put(obj7, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                context5 = context6;
                                C13622a.m81969o(context5, c11060cM66626a, map);
                                return true;
                            } catch (IOException e20) {
                                e = e20;
                                BufferedInputStream bufferedInputStream6 = bufferedInputStream4;
                                r22 = obj25;
                                r93 = bufferedOutputStream;
                                i11 = length2;
                                r12 = fileInputStream3;
                                r84 = bufferedInputStream6;
                                str3 = "FileToZip";
                                r53 = fileOutputStream6;
                                r64 = zipOutputStream4;
                                StringBuilder sb222222 = new StringBuilder();
                                sb222222.append("fileToZip IOException, e ");
                                sb222222.append(e.toString());
                                C11839m.m70688i(str3, sb222222.toString());
                                c11060cM66626a.m66665u(String.valueOf(2228));
                                c11060cM66626a.m66635A("fileToZip IOException, e " + e.toString());
                                m17862e(r12, r84, r53, r64, r93);
                                map = new HashMap();
                                map.put("zipFileSize", String.valueOf(i11));
                                map.put("zipFileLength", String.valueOf(length));
                                strValueOf = String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                                obj6 = r22;
                                map.put(obj6, strValueOf);
                                context5 = context;
                                C13622a.m81969o(context5, c11060cM66626a, map);
                                return true;
                            } catch (Throwable th13) {
                                th = th13;
                                context4 = context;
                                BufferedInputStream bufferedInputStream7 = bufferedInputStream4;
                                obj5 = obj25;
                                i11 = length2;
                                fileInputStream2 = fileInputStream3;
                                r82 = bufferedInputStream7;
                                r52 = fileOutputStream6;
                                r62 = zipOutputStream4;
                                m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                                HashMap map322222222 = new HashMap();
                                map322222222.put("zipFileSize", String.valueOf(i11));
                                map322222222.put("zipFileLength", String.valueOf(length));
                                map322222222.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                C13622a.m81969o(context4, c11060cM66626a, map322222222);
                                throw th;
                            }
                        } catch (FileNotFoundException unused12) {
                            context14 = r22;
                            obj21 = "useTime";
                            r92 = bufferedOutputStream;
                            i12 = length2;
                            str3 = "FileToZip";
                            str4 = "fileToZip FileNotFoundException";
                            fileInputStream = null;
                            zipOutputStream3 = zipOutputStream4;
                            r83 = 0;
                            obj7 = obj21;
                            fileOutputStream = fileOutputStream6;
                            r63 = zipOutputStream3;
                            context6 = context14;
                            C11839m.m70688i(str3, str4);
                            c11060cM66626a.m66665u(String.valueOf(2228));
                            c11060cM66626a.m66635A(str4);
                            m17862e(fileInputStream, r83, fileOutputStream, r63, r92);
                            map = new HashMap();
                            map.put("zipFileSize", String.valueOf(i12));
                            map.put("zipFileLength", String.valueOf(length));
                            map.put(obj7, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            context5 = context6;
                            C13622a.m81969o(context5, c11060cM66626a, map);
                            return true;
                        } catch (IOException e21) {
                            e = e21;
                            obj20 = "useTime";
                            bufferedOutputStream2 = bufferedOutputStream;
                            i11 = length2;
                            str3 = "FileToZip";
                            z11 = false;
                            zipOutputStream2 = zipOutputStream4;
                            r84 = 0;
                            r12 = z11;
                            r22 = obj20;
                            r53 = fileOutputStream6;
                            r64 = zipOutputStream2;
                            r93 = bufferedOutputStream2;
                            StringBuilder sb2222222 = new StringBuilder();
                            sb2222222.append("fileToZip IOException, e ");
                            sb2222222.append(e.toString());
                            C11839m.m70688i(str3, sb2222222.toString());
                            c11060cM66626a.m66665u(String.valueOf(2228));
                            c11060cM66626a.m66635A("fileToZip IOException, e " + e.toString());
                            m17862e(r12, r84, r53, r64, r93);
                            map = new HashMap();
                            map.put("zipFileSize", String.valueOf(i11));
                            map.put("zipFileLength", String.valueOf(length));
                            strValueOf = String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                            obj6 = r22;
                            map.put(obj6, strValueOf);
                            context5 = context;
                            C13622a.m81969o(context5, c11060cM66626a, map);
                            return true;
                        } catch (Throwable th14) {
                            th = th14;
                            context12 = r22;
                            obj18 = "useTime";
                            i11 = length2;
                            fileInputStream2 = null;
                            fileOutputStream5 = fileOutputStream6;
                            zipOutputStream = zipOutputStream4;
                            r82 = 0;
                            obj5 = obj18;
                            r52 = fileOutputStream5;
                            r62 = zipOutputStream;
                            context4 = context12;
                            m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                            HashMap map3222222222 = new HashMap();
                            map3222222222.put("zipFileSize", String.valueOf(i11));
                            map3222222222.put("zipFileLength", String.valueOf(length));
                            map3222222222.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            C13622a.m81969o(context4, c11060cM66626a, map3222222222);
                            throw th;
                        }
                    } catch (FileNotFoundException unused13) {
                        context10 = r22;
                        obj16 = "useTime";
                        i12 = length2;
                        str3 = "FileToZip";
                        str4 = "fileToZip FileNotFoundException";
                        fileInputStream = null;
                        fileOutputStream4 = fileOutputStream6;
                        r63 = 0;
                        r83 = 0;
                        r92 = null;
                        obj7 = obj16;
                        fileOutputStream = fileOutputStream4;
                        context6 = context10;
                        C11839m.m70688i(str3, str4);
                        c11060cM66626a.m66665u(String.valueOf(2228));
                        c11060cM66626a.m66635A(str4);
                        m17862e(fileInputStream, r83, fileOutputStream, r63, r92);
                        map = new HashMap();
                        map.put("zipFileSize", String.valueOf(i12));
                        map.put("zipFileLength", String.valueOf(length));
                        map.put(obj7, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        context5 = context6;
                        C13622a.m81969o(context5, c11060cM66626a, map);
                        return true;
                    } catch (IOException e22) {
                        e = e22;
                        obj15 = "useTime";
                        i11 = length2;
                        str3 = "FileToZip";
                        z10 = false;
                        fileOutputStream3 = fileOutputStream6;
                        r64 = 0;
                        r84 = 0;
                        r93 = 0;
                        r12 = z10;
                        r22 = obj15;
                        r53 = fileOutputStream3;
                        StringBuilder sb22222222 = new StringBuilder();
                        sb22222222.append("fileToZip IOException, e ");
                        sb22222222.append(e.toString());
                        C11839m.m70688i(str3, sb22222222.toString());
                        c11060cM66626a.m66665u(String.valueOf(2228));
                        c11060cM66626a.m66635A("fileToZip IOException, e " + e.toString());
                        m17862e(r12, r84, r53, r64, r93);
                        map = new HashMap();
                        map.put("zipFileSize", String.valueOf(i11));
                        map.put("zipFileLength", String.valueOf(length));
                        strValueOf = String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                        obj6 = r22;
                        map.put(obj6, strValueOf);
                        context5 = context;
                        C13622a.m81969o(context5, c11060cM66626a, map);
                        return true;
                    } catch (Throwable th15) {
                        th = th15;
                        context13 = r22;
                        obj19 = "useTime";
                        i11 = length2;
                        bufferedOutputStream = null;
                    }
                    map.put(obj6, strValueOf);
                    context5 = context;
                    C13622a.m81969o(context5, c11060cM66626a, map);
                    return true;
                }
            }
            Context context15 = r22;
            Object obj26 = "useTime";
            try {
                try {
                    str3 = "FileToZip";
                    try {
                        C11839m.m70689w(str3, "sourceFile size is 0 sourceFilePath:" + str);
                        c11060cM66626a.m66665u(String.valueOf(2228));
                        c11060cM66626a.m66635A("sourceFile size is 0 sourceFilePath:" + str);
                        m17862e(null, null, null, null, null);
                        HashMap map5 = new HashMap();
                        map5.put("zipFileSize", String.valueOf(0));
                        map5.put("zipFileLength", String.valueOf(length));
                        map5.put(obj26, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        C13622a.m81969o(context15, c11060cM66626a, map5);
                        return false;
                    } catch (FileNotFoundException unused14) {
                        fileInputStream = null;
                        obj4 = obj26;
                        context3 = context15;
                        FileInputStream fileInputStream5 = fileInputStream;
                        FileInputStream fileInputStream6 = fileInputStream5;
                        r92 = fileInputStream6;
                        i12 = 0;
                        str4 = "fileToZip FileNotFoundException";
                        fileOutputStream = r92;
                        obj7 = obj4;
                        r63 = fileInputStream5;
                        context6 = context3;
                        r83 = fileInputStream6;
                        C11839m.m70688i(str3, str4);
                        c11060cM66626a.m66665u(String.valueOf(2228));
                        c11060cM66626a.m66635A(str4);
                        m17862e(fileInputStream, r83, fileOutputStream, r63, r92);
                        map = new HashMap();
                        map.put("zipFileSize", String.valueOf(i12));
                        map.put("zipFileLength", String.valueOf(length));
                        map.put(obj7, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        context5 = context6;
                        C13622a.m81969o(context5, c11060cM66626a, map);
                        return true;
                    } catch (IOException e23) {
                        e = e23;
                        obj2 = null;
                        obj3 = obj26;
                        Object obj27 = obj2;
                        Object obj28 = obj27;
                        Object obj29 = obj28;
                        i11 = 0;
                        r53 = obj29;
                        r12 = obj2;
                        r22 = obj3;
                        r64 = obj27;
                        r84 = obj28;
                        r93 = obj29;
                        StringBuilder sb222222222 = new StringBuilder();
                        sb222222222.append("fileToZip IOException, e ");
                        sb222222222.append(e.toString());
                        C11839m.m70688i(str3, sb222222222.toString());
                        c11060cM66626a.m66665u(String.valueOf(2228));
                        c11060cM66626a.m66635A("fileToZip IOException, e " + e.toString());
                        m17862e(r12, r84, r53, r64, r93);
                        map = new HashMap();
                        map.put("zipFileSize", String.valueOf(i11));
                        map.put("zipFileLength", String.valueOf(length));
                        strValueOf = String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                        obj6 = r22;
                        map.put(obj6, strValueOf);
                        context5 = context;
                        C13622a.m81969o(context5, c11060cM66626a, map);
                        return true;
                    }
                } catch (FileNotFoundException unused15) {
                    str3 = "FileToZip";
                } catch (IOException e24) {
                    e = e24;
                    str3 = "FileToZip";
                }
            } catch (Throwable th16) {
                th = th16;
                bufferedOutputStream = null;
                i10 = 0;
                fileInputStream2 = null;
                obj = obj26;
                context2 = context15;
                FileInputStream fileInputStream7 = fileInputStream2;
                FileInputStream fileInputStream8 = fileInputStream7;
                i11 = i10;
                r52 = fileInputStream8;
                obj5 = obj;
                r62 = fileInputStream7;
                context4 = context2;
                r82 = fileInputStream8;
                m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
                HashMap map32222222222 = new HashMap();
                map32222222222.put("zipFileSize", String.valueOf(i11));
                map32222222222.put("zipFileLength", String.valueOf(length));
                map32222222222.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                C13622a.m81969o(context4, c11060cM66626a, map32222222222);
                throw th;
            }
        } catch (Throwable th17) {
            th = th17;
            fileInputStream2 = r12;
            bufferedOutputStream = r93;
            obj5 = r22;
            r52 = r53;
            r62 = r64;
            context4 = r72;
            r82 = r84;
            m17862e(fileInputStream2, r82, r52, r62, bufferedOutputStream);
            HashMap map322222222222 = new HashMap();
            map322222222222.put("zipFileSize", String.valueOf(i11));
            map322222222222.put("zipFileLength", String.valueOf(length));
            map322222222222.put(obj5, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            C13622a.m81969o(context4, c11060cM66626a, map322222222222);
            throw th;
        }
    }

    /* renamed from: b */
    public static boolean m17859b(File file, File file2, String str, String str2, ConcurrentHashMap<String, Integer> concurrentHashMap, LinkedHashMap<String, String> linkedHashMap) {
        if (TextUtils.isEmpty(str) || str.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
            C11839m.m70687e("FileToZip", "zip file is not valid");
            concurrentHashMap.put("zipNameInvalid, zipfile = " + str, 2250);
            linkedHashMap.put("returnCode", String.valueOf(2250));
            linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, "zipNameInvalid, zipfile = " + str);
            return false;
        }
        if (TextUtils.isEmpty(str2) || str2.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
            C11839m.m70687e("FileToZip", "target directory is not valid");
            concurrentHashMap.put("zipPathInvalid, zipPath = " + str2, 2251);
            linkedHashMap.put("returnCode", String.valueOf(2251));
            linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, "zipPathInvalid, zipPath = " + str2);
            return false;
        }
        if (!file2.exists() && !file2.mkdirs()) {
            C11839m.m70688i("FileToZip", "unzipFile , create unzip path fail");
            concurrentHashMap.put("zipDirectoryFileCreateFail, direcotry not exists", 2252);
            linkedHashMap.put("returnCode", String.valueOf(2252));
            linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, "zipDirectoryFileCreateFail, direcotry not exists");
            return false;
        }
        long length = file.length();
        if (length < 0) {
            C11839m.m70687e("FileToZip", "unzipFile fail, Zip file size invalid, totalSize = " + length);
            concurrentHashMap.put("zipSizeInvalid, size  = " + length, 2253);
            linkedHashMap.put("returnCode", String.valueOf(2253));
            linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, "zipSizeInvalid, size  = " + length);
            return false;
        }
        if (length <= 5368709120L) {
            return true;
        }
        C11839m.m70687e("FileToZip", "unzipFile fail, Zip file too big, totalSize = " + length);
        concurrentHashMap.put("zipSizeTooBig, size  = " + length, 2254);
        linkedHashMap.put("returnCode", String.valueOf(2254));
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, "zipSizeTooBig, size  = " + length);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ff, code lost:
    
        p514o9.C11839m.m70687e("FileToZip", "Zip item too many files, break unzip");
        r28.put("zipSizeTooMany", 2255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0111, code lost:
    
        r29.put("returnCode", java.lang.String.valueOf(2255));
        r29.put(com.huawei.android.backup.service.logic.C2126b.ERROR_MESSAGE_INFO, "zipSizeTooMany, size > 50000");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0123, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0126, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0127, code lost:
    
        r10 = r13;
        r1 = r17;
        r3 = r19;
        r2 = r20;
        r9 = r21;
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01dd, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01e1, code lost:
    
        p514o9.C11839m.m70687e("FileToZip", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01e6, code lost:
    
        p514o9.C11839m.m70688i("FileToZip", r2 + r10);
        r30.append(r3);
        r30.append(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01fe, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:?, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m17860c(java.lang.String r24, java.lang.String r25, java.lang.String r26, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r27, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r28, java.util.LinkedHashMap<java.lang.String, java.lang.String> r29, java.lang.StringBuffer r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 511
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.syncutil.C2977f.m17860c(java.lang.String, java.lang.String, java.lang.String, java.util.concurrent.ConcurrentHashMap, java.util.concurrent.ConcurrentHashMap, java.util.LinkedHashMap, java.lang.StringBuffer):boolean");
    }

    /* renamed from: d */
    public static boolean m17861d(String str, String str2, Context context) {
        C11839m.m70688i("FileToZip", "normalDownloadFileToZip");
        File file = new File(str + "/sync_download.zip");
        if (file.exists()) {
            C11839m.m70686d("FileToZip", "zip has exits");
            C11839m.m70686d("FileToZip", "deleteResult is = " + file.delete());
        }
        return m17858a(str, file, str2, context);
    }

    /* renamed from: e */
    public static void m17862e(FileInputStream fileInputStream, BufferedInputStream bufferedInputStream, FileOutputStream fileOutputStream, ZipOutputStream zipOutputStream, BufferedOutputStream bufferedOutputStream) throws IOException {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e10) {
                C11839m.m70687e("FileToZip", "IOException bis occur, " + e10.getMessage());
            }
        }
        if (zipOutputStream != null) {
            try {
                zipOutputStream.close();
            } catch (IOException e11) {
                C11839m.m70687e("FileToZip", "IOException zos occur, " + e11.getMessage());
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e12) {
                C11839m.m70687e("FileToZip", "IOException fos occur, " + e12.getMessage());
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e13) {
                C11839m.m70687e("FileToZip", "IOException fis occur, " + e13.getMessage());
            }
        }
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (IOException e14) {
                C11839m.m70687e("FileToZip", "IOException bos occur, " + e14.getMessage());
            }
        }
    }

    /* renamed from: f */
    public static void m17863f(String str, String str2, String str3, String str4, String str5) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("unzipUsageName", str2);
        linkedHashMap.put("unzipUsageSize", str3);
        linkedHashMap.put("syncType", str4);
        linkedHashMap.put("dataType", str5);
        C10812z.m65844m(str, linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x071b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x07a6  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0755 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x05ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x06cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m17864g(java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r41, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r42) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2043
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.syncutil.C2977f.m17864g(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.concurrent.ConcurrentHashMap, java.util.concurrent.ConcurrentHashMap):boolean");
    }

    /* renamed from: h */
    public static void m17865h(ZipEntry zipEntry, ZipInputStream zipInputStream, File file, ConcurrentHashMap<String, Integer> concurrentHashMap, StringBuffer stringBuffer) throws Throwable {
        StringBuilder sb2;
        String name = zipEntry.getName();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (name == null) {
                    throw new IOException("File path is null.");
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, new File(name).getCanonicalPath()));
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int i10 = zipInputStream.read(bArr);
                        if (i10 <= 0) {
                            fileOutputStream2.flush();
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (IOException e10) {
                                e = e10;
                                sb2 = new StringBuilder();
                                sb2.append("WriteBuffer finally IOException occur, ");
                                sb2.append(e.getMessage());
                                C11839m.m70687e("FileToZip", sb2.toString());
                            }
                        }
                        fileOutputStream2.write(bArr, 0, i10);
                    }
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    C11839m.m70687e("FileToZip", "Zip item IOException, name = " + name);
                    if (!TextUtils.isEmpty(name)) {
                        concurrentHashMap.put(name, 2259);
                        stringBuffer.append("name = ");
                        stringBuffer.append(name);
                        stringBuffer.append(" ioException,");
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e11) {
                            e = e11;
                            sb2 = new StringBuilder();
                            sb2.append("WriteBuffer finally IOException occur, ");
                            sb2.append(e.getMessage());
                            C11839m.m70687e("FileToZip", sb2.toString());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e12) {
                            C11839m.m70687e("FileToZip", "WriteBuffer finally IOException occur, " + e12.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
