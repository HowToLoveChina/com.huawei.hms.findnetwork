package p544p4;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.UserManager;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p229di.C9136a;
import p229di.C9141f;
import p229di.C9150o;
import p229di.C9154s;
import p229di.C9155t;
import p229di.C9156u;
import p699v4.C13334c;
import p699v4.C13339h;
import p699v4.C13349r;

/* renamed from: p4.a */
/* loaded from: classes.dex */
public final class C12086a {
    /* renamed from: a */
    public static void m72254a(FileInputStream fileInputStream, InputStreamReader inputStreamReader, BufferedReader bufferedReader) throws IOException {
        C13339h.m80014a(bufferedReader);
        C13339h.m80014a(inputStreamReader);
        C13339h.m80014a(fileInputStream);
    }

    /* renamed from: b */
    public static void m72255b(FileOutputStream fileOutputStream, OutputStreamWriter outputStreamWriter, BufferedWriter bufferedWriter) throws IOException {
        C13339h.m80014a(bufferedWriter);
        C13339h.m80014a(outputStreamWriter);
        C13339h.m80014a(fileOutputStream);
    }

    @TargetApi(17)
    /* renamed from: c */
    public static int m72256c(Context context) {
        UserManager userManager;
        List<Object> listM57499d;
        int i10 = -1;
        if (context == null || !m72262i(context) || (listM57499d = C9155t.m57499d((userManager = (UserManager) context.getSystemService("user")))) == null) {
            return -1;
        }
        Iterator<Object> it = listM57499d.iterator();
        while (it.hasNext()) {
            int iM57495a = C9154s.m57495a(it.next());
            if (C9141f.m57460a(C9156u.m57500a(userManager, iM57495a))) {
                i10 = iM57495a;
            }
        }
        C2111d.m12653i("AppTwinUtil", "clone user id : " + i10);
        return i10;
    }

    /* renamed from: d */
    public static String m72257d(Context context) {
        return SplitAppUtil.STORAGE_EMULATED + m72256c(context);
    }

    /* renamed from: e */
    public static int[] m72258e(Context context) {
        return new int[]{0, m72256c(context)};
    }

    /* renamed from: f */
    public static String m72259f(Context context) {
        int iM72256c = m72256c(context);
        if (iM72256c == -1) {
            C2111d.m12657m("AppTwinUtil", "getTwinWechatRecordPath, clone user is not exist");
            return "";
        }
        return SplitAppUtil.STORAGE_EMULATED + iM72256c;
    }

    /* renamed from: g */
    public static boolean m72260g(Context context, String str, int i10) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            if (!C9136a.m57448a(i10)) {
                return false;
            }
            C9150o.m57489c(packageManager, str, i10);
            return true;
        } catch (Exception e10) {
            C2111d.m12648d("AppTwinUtil", "installExistingPackageAsUser failed, error: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: h */
    public static boolean m72261h(Context context) {
        return m72256c(context) != -1;
    }

    /* renamed from: i */
    public static boolean m72262i(Context context) {
        return C2157a.m13177L(context) && C13349r.m80087c();
    }

    /* renamed from: j */
    public static boolean m72263j(String str, String str2, int i10) {
        C2111d.m12653i("AppTwinUtil", "modifyTwinAppAttrFile");
        if (i10 == 0) {
            return true;
        }
        String str3 = BackupRestoreConstans.DATA_USER_PATH + i10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append(str2 + ".txt");
        String string = sb2.toString();
        File file = new File(string);
        if (!file.exists()) {
            C2111d.m12653i("AppTwinUtil", "file not found");
            return false;
        }
        File file2 = new File(str + str4 + (str2 + "_new.txt"));
        if (!C13334c.m79978k(file2)) {
            C2111d.m12653i("AppTwinUtil", "create new file error");
            return false;
        }
        if (!m72265l(str3, file, file2)) {
            C2111d.m12653i("AppTwinUtil", "read file is error");
            return false;
        }
        if (!file.delete()) {
            C2111d.m12653i("AppTwinUtil", "delete old file error");
            return false;
        }
        if (file2.renameTo(new File(string))) {
            return true;
        }
        C2111d.m12653i("AppTwinUtil", "rename new file error");
        return false;
    }

    /* renamed from: k */
    public static ArrayList<String> m72264k(Context context) {
        if (context != null && m72262i(context)) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> listM57490d = C9150o.m57490d(context.getPackageManager(), intent, 0, m72256c(context));
            ArrayList<String> arrayList = new ArrayList<>(listM57490d.size());
            for (ResolveInfo resolveInfo : listM57490d) {
                arrayList.add(resolveInfo.activityInfo.packageName);
                C2111d.m12653i("AppTwinUtil", "twin app is " + resolveInfo.activityInfo.packageName);
            }
            return arrayList;
        }
        return new ArrayList<>(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.BufferedWriter, java.io.Writer] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* renamed from: l */
    public static boolean m72265l(String str, File file, File file2) throws Throwable {
        InputStreamReader inputStreamReader;
        OutputStreamWriter outputStreamWriter;
        ?? bufferedWriter;
        BufferedReader bufferedReader;
        ?? fileOutputStream;
        FileInputStream fileInputStream = null;
        String strSubstring = null;
        fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2, Constants.UTF_8);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        fileOutputStream = new FileOutputStream(file2, true);
                        try {
                            outputStreamWriter = new OutputStreamWriter((OutputStream) fileOutputStream, Constants.UTF_8);
                            try {
                                bufferedWriter = new BufferedWriter(outputStreamWriter);
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            m72254a(fileInputStream2, inputStreamReader, bufferedReader);
                                            m72255b(fileOutputStream, outputStreamWriter, bufferedWriter);
                                            return true;
                                        }
                                        if (strSubstring == null) {
                                            int iIndexOf = line.indexOf(File.separator, 11);
                                            strSubstring = iIndexOf == -1 ? line : line.substring(0, iIndexOf);
                                        }
                                        bufferedWriter.write(line.replaceAll(strSubstring, str));
                                        bufferedWriter.newLine();
                                    } catch (IOException unused) {
                                        fileInputStream = fileInputStream2;
                                        bufferedWriter = bufferedWriter;
                                        fileOutputStream = fileOutputStream;
                                        try {
                                            C2111d.m12653i("AppTwinUtil", "modifyTwinAppAttrFile exception happen");
                                            m72254a(fileInputStream, inputStreamReader, bufferedReader);
                                            m72255b(fileOutputStream, outputStreamWriter, bufferedWriter);
                                            return false;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            m72254a(fileInputStream, inputStreamReader, bufferedReader);
                                            m72255b(fileOutputStream, outputStreamWriter, bufferedWriter);
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileInputStream = fileInputStream2;
                                        m72254a(fileInputStream, inputStreamReader, bufferedReader);
                                        m72255b(fileOutputStream, outputStreamWriter, bufferedWriter);
                                        throw th;
                                    }
                                }
                            } catch (IOException unused2) {
                                bufferedWriter = 0;
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedWriter = 0;
                            }
                        } catch (IOException unused3) {
                            outputStreamWriter = null;
                            bufferedWriter = 0;
                        } catch (Throwable th5) {
                            th = th5;
                            outputStreamWriter = null;
                            bufferedWriter = 0;
                        }
                    } catch (IOException unused4) {
                        outputStreamWriter = null;
                        bufferedWriter = 0;
                        fileOutputStream = 0;
                    } catch (Throwable th6) {
                        th = th6;
                        outputStreamWriter = null;
                        bufferedWriter = 0;
                        fileOutputStream = 0;
                    }
                } catch (IOException unused5) {
                    outputStreamWriter = null;
                    bufferedWriter = outputStreamWriter;
                    bufferedReader = bufferedWriter;
                    fileOutputStream = bufferedReader;
                    fileInputStream = fileInputStream2;
                    bufferedWriter = bufferedWriter;
                    fileOutputStream = fileOutputStream;
                    C2111d.m12653i("AppTwinUtil", "modifyTwinAppAttrFile exception happen");
                    m72254a(fileInputStream, inputStreamReader, bufferedReader);
                    m72255b(fileOutputStream, outputStreamWriter, bufferedWriter);
                    return false;
                } catch (Throwable th7) {
                    th = th7;
                    outputStreamWriter = null;
                    bufferedWriter = outputStreamWriter;
                    bufferedReader = bufferedWriter;
                    fileOutputStream = bufferedReader;
                    fileInputStream = fileInputStream2;
                    m72254a(fileInputStream, inputStreamReader, bufferedReader);
                    m72255b(fileOutputStream, outputStreamWriter, bufferedWriter);
                    throw th;
                }
            } catch (IOException unused6) {
                inputStreamReader = null;
                outputStreamWriter = null;
            } catch (Throwable th8) {
                th = th8;
                inputStreamReader = null;
                outputStreamWriter = null;
            }
        } catch (IOException unused7) {
            inputStreamReader = null;
            outputStreamWriter = null;
            bufferedWriter = 0;
            bufferedReader = null;
            fileOutputStream = 0;
        } catch (Throwable th9) {
            th = th9;
            inputStreamReader = null;
            outputStreamWriter = null;
            bufferedWriter = 0;
            bufferedReader = null;
            fileOutputStream = 0;
        }
    }
}
