package p762x4;

import android.content.ContentValues;
import android.content.Context;
import android.content.p017pm.IPackageDataObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2110c;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.riemann.location.common.utils.Constant;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import p006a5.AbstractC0048c;

/* renamed from: x4.c */
/* loaded from: classes.dex */
public abstract class AbstractC13696c {

    /* renamed from: m */
    public static volatile boolean f61632m = false;

    /* renamed from: a */
    public String f61633a;

    /* renamed from: b */
    public String f61634b;

    /* renamed from: c */
    public String f61635c;

    /* renamed from: d */
    public C2110c f61636d;

    /* renamed from: e */
    public Context f61637e;

    /* renamed from: f */
    public Handler.Callback f61638f;

    /* renamed from: g */
    public String f61639g;

    /* renamed from: h */
    public Object f61640h;

    /* renamed from: i */
    public AbstractC0048c f61641i;

    /* renamed from: j */
    public int f61642j = 0;

    /* renamed from: k */
    public boolean f61643k = false;

    /* renamed from: l */
    public boolean f61644l = false;

    /* renamed from: x4.c$a */
    public static class a {

        /* renamed from: a */
        public final int f61645a;

        /* renamed from: b */
        public final int f61646b;

        /* renamed from: c */
        public final int f61647c;

        public a(int i10, int i11, int i12) {
            this.f61645a = i10;
            this.f61646b = i11;
            this.f61647c = i12;
        }

        /* renamed from: a */
        public int m82366a() {
            return this.f61645a;
        }

        /* renamed from: b */
        public int m82367b() {
            return this.f61646b;
        }

        /* renamed from: c */
        public int m82368c() {
            return this.f61647c;
        }
    }

    /* renamed from: x4.c$b */
    public class b extends IPackageDataObserver.Stub {
        public b() {
        }

        @Override // android.content.p017pm.IPackageDataObserver
        public void onRemoveCompleted(String str, boolean z10) throws RemoteException {
            AbstractC13696c.this.f61643k = true;
            AbstractC13696c.this.f61644l = z10;
        }
    }

    public AbstractC13696c(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, String str, Object obj) {
        this.f61637e = context;
        this.f61641i = abstractC0048c;
        this.f61638f = callback;
        this.f61639g = str;
        this.f61640h = obj;
    }

    /* renamed from: j */
    public static void m82341j() {
        f61632m = false;
    }

    /* renamed from: r */
    public static boolean m82342r() {
        return f61632m;
    }

    /* renamed from: s */
    public static /* synthetic */ Object m82343s(Method method) throws SecurityException {
        method.setAccessible(true);
        return null;
    }

    /* renamed from: x */
    public static void m82344x() {
        f61632m = true;
    }

    /* renamed from: A */
    public final byte[] m82345A(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return str.getBytes(Constants.UTF_8);
            } catch (UnsupportedEncodingException unused) {
                C2111d.m12648d("BackupAppDataBase", "string2Byte error" + str);
            }
        }
        return null;
    }

    /* renamed from: B */
    public final void m82346B() throws InterruptedException {
        while (!this.f61643k && !m82342r()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
                C2111d.m12648d("BackupAppDataBase", "clear data Sleep Failed");
                return;
            }
        }
    }

    /* renamed from: d */
    public int m82347d(ArrayList<String> arrayList) throws IllegalAccessException, InterruptedException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iMo82355m = 2;
        if (this.f61637e == null || this.f61641i == null || TextUtils.isEmpty(this.f61639g)) {
            C2111d.m12648d("BackupAppDataBase", "backupApkData() input param error !");
            return 2;
        }
        C2110c c2110cM82357o = m82357o();
        this.f61636d = c2110cM82357o;
        if (c2110cM82357o != null) {
            mo82359q();
            if (mo82349f(this.f61634b)) {
                ArrayList<ContentValues> arrayList2 = new ArrayList<>();
                int iM82348e = m82348e(arrayList2, this.f61634b, arrayList);
                if (iM82348e > 0) {
                    iMo82355m = mo82355m(arrayList2);
                } else if (iM82348e == 0) {
                    m82362v(0, 0, 0, this.f61638f, this.f61640h);
                } else {
                    C2111d.m12648d("BackupAppDataBase", "totalCount is less than 0.");
                }
            }
        }
        mo82360t(iMo82355m);
        return iMo82355m;
    }

    /* renamed from: e */
    public final int m82348e(ArrayList<ContentValues> arrayList, String str, ArrayList<String> arrayList2) {
        String str2;
        String str3 = "BackupAppDataBase";
        C2111d.m12653i("BackupAppDataBase", "Backup apk data file info.");
        byte[] bArrM12636g = this.f61636d.m12636g();
        ArrayList arrayList3 = new ArrayList();
        int i10 = -100;
        long jM12635f = 0;
        try {
            try {
                Locale locale = Locale.ROOT;
                jM12635f = this.f61636d.m12635f(String.format(locale, "opendir %s", str).getBytes(Constants.UTF_8));
                if (jM12635f == -100) {
                    return -100;
                }
                byte[] bytes = String.format(locale, "readdir %s", String.valueOf(jM12635f)).getBytes(Constants.UTF_8);
                byte[] bArrM12634e = this.f61636d.m12634e();
                int i11 = 0;
                while (true) {
                    int iM12644s = this.f61636d.m12644s(bytes, bArrM12636g);
                    if (iM12644s < 264) {
                        C2111d.m12648d(str3, "backupApkDataFileInfo Exception socket len less" + str);
                        return i10;
                    }
                    byte[] bArr = bytes;
                    int iM12626a = C2110c.m12626a(bArrM12636g, 0, 4);
                    if (iM12626a == -1) {
                        break;
                    }
                    Arrays.fill(bArrM12634e, (byte) 0);
                    str2 = str3;
                    try {
                        System.arraycopy(bArrM12636g, 4, bArrM12634e, 0, 256);
                        String str4 = new String(bArrM12634e, 0, m82351h(bArrM12634e), Constants.UTF_8);
                        if (!TextUtils.isEmpty(str4)) {
                            int iM12626a2 = C2110c.m12626a(bArrM12636g, 260, Constant.ERROR_ROTATION_ANGLE_INVALID);
                            Arrays.fill(bArrM12636g, 0, iM12644s, (byte) 0);
                            if (C13694a.m82334l(str, str4, iM12626a2, this.f61634b) && C13694a.m82331i(str, str4, arrayList2, this.f61639g)) {
                                if (iM12626a2 == 4) {
                                    arrayList3.add(str4);
                                }
                                i11++;
                                arrayList.add(m82350g(str, str4, bArrM12636g, iM12626a2));
                            }
                        }
                        if (iM12626a != 0) {
                            break;
                        }
                        bytes = bArr;
                        str3 = str2;
                        i10 = -100;
                    } catch (IOException unused) {
                        C2111d.m12648d(str2, "backupApkDataFileInfo Exception");
                        m82353k(jM12635f, bArrM12636g, str);
                        return -100;
                    }
                }
                m82353k(jM12635f, bArrM12636g, str);
                if (arrayList3.size() == 0) {
                    return i11;
                }
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    int iM82348e = m82348e(arrayList, str + File.separator + ((String) it.next()), arrayList2);
                    if (iM82348e == -100) {
                        return -100;
                    }
                    i11 += iM82348e;
                }
                return i11;
            } finally {
                m82353k(jM12635f, bArrM12636g, str);
            }
        } catch (IOException unused2) {
            str2 = str3;
        }
    }

    /* renamed from: f */
    public abstract boolean mo82349f(String str);

    /* renamed from: g */
    public final ContentValues m82350g(String str, String str2, byte[] bArr, int i10) throws IOException {
        ContentValues contentValues = new ContentValues();
        String str3 = str + File.separator + str2;
        int iM82356n = m82356n(str3, bArr);
        int[] iArrM82358p = m82358p(str3, bArr);
        contentValues.put("uid", Integer.valueOf(iArrM82358p[0]));
        contentValues.put("gid", Integer.valueOf(iArrM82358p[1]));
        contentValues.put("file_path", str3);
        contentValues.put("permission", Integer.valueOf(iM82356n));
        if (i10 == 4) {
            contentValues.put("file_index", (Integer) (-1));
        } else {
            int i11 = this.f61642j;
            this.f61642j = i11 + 1;
            contentValues.put("file_index", Integer.valueOf(i11));
        }
        contentValues.putNull("file_link");
        return contentValues;
    }

    /* renamed from: h */
    public final int m82351h(byte[] bArr) {
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (bArr[i10] == 0) {
                return i10;
            }
        }
        return bArr.length;
    }

    /* renamed from: i */
    public boolean mo82352i(Context context) throws IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (context == null) {
            return false;
        }
        try {
            final Method method = Class.forName("android.content.pm.IPackageManager").getMethod("clearApplicationUserData", String.class, IPackageDataObserver.class);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: x4.b
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    return AbstractC13696c.m82343s(method);
                }
            });
            method.invoke(context.getPackageManager(), this.f61639g, new b());
            this.f61643k = false;
            m82346B();
            return this.f61644l;
        } catch (Exception e10) {
            C2111d.m12653i("BackupAppDataBase", "clearApplicationUserDataMethod.invoke error" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: k */
    public final void m82353k(long j10, byte[] bArr, String str) {
        if (j10 == -1 || j10 == -100) {
            return;
        }
        try {
            this.f61636d.m12644s(String.format(Locale.ROOT, "closedir %s", String.valueOf(j10)).getBytes(Constants.UTF_8), bArr);
            Arrays.fill(bArr, (byte) 0);
        } catch (IOException unused) {
            C2111d.m12648d("BackupAppDataBase", "backupApkDataFileInfo close handle socket write error Exception");
        }
    }

    /* renamed from: l */
    public void m82354l(String str, int i10, byte[] bArr) throws IOException {
        byte[] bArrM82345A = m82345A(String.format(Locale.ROOT, "mkdir %s %s", str, String.valueOf(i10)));
        if (bArrM82345A == null) {
            throw new IOException("string2Byte err!");
        }
        int iM12644s = this.f61636d.m12644s(bArrM82345A, bArr);
        if (C2110c.m12626a(bArr, 0, 4) != 0) {
            throw new IOException("createDir err!");
        }
        if (iM12644s > 0) {
            Arrays.fill(bArr, 0, iM12644s, (byte) 0);
        }
    }

    /* renamed from: m */
    public abstract int mo82355m(ArrayList<ContentValues> arrayList);

    /* renamed from: n */
    public int m82356n(String str, byte[] bArr) throws IOException {
        byte[] bArrM82345A = m82345A(String.format(Locale.ROOT, "getmod %s", str));
        int iM12626a = -100;
        if (bArrM82345A == null) {
            return -100;
        }
        int iM12644s = this.f61636d.m12644s(bArrM82345A, bArr);
        if (iM12644s >= 8 && C2110c.m12626a(bArr, 0, 4) == 0) {
            iM12626a = C2110c.m12626a(bArr, 4, 8);
        }
        if (iM12644s > 0) {
            Arrays.fill(bArr, 0, iM12644s, (byte) 0);
        }
        return iM12626a;
    }

    /* renamed from: o */
    public C2110c m82357o() {
        if (C2110c.m12628i()) {
            return null;
        }
        C2110c c2110c = new C2110c();
        if (c2110c.m12632c()) {
            return c2110c;
        }
        return null;
    }

    /* renamed from: p */
    public final int[] m82358p(String str, byte[] bArr) throws IOException {
        byte[] bArrM82345A = m82345A(String.format(Locale.ROOT, "getown %s", str));
        if (bArrM82345A == null) {
            throw new IOException("getUidAndGid err!");
        }
        int[] iArr = new int[2];
        int iM12644s = this.f61636d.m12644s(bArrM82345A, bArr);
        if (C2110c.m12626a(bArr, 0, 4) == 0) {
            iArr[0] = C2110c.m12626a(bArr, 4, 8);
            iArr[1] = C2110c.m12626a(bArr, 8, 12);
        }
        if (iM12644s > 0) {
            Arrays.fill(bArr, 0, iM12644s, (byte) 0);
        }
        return iArr;
    }

    /* renamed from: q */
    public void mo82359q() {
        File parentFile = this.f61637e.getCacheDir().getParentFile();
        if (parentFile != null) {
            this.f61635c = parentFile.getParent() + File.separator;
        }
        this.f61634b = this.f61635c + this.f61639g;
        StringBuilder sb2 = new StringBuilder(this.f61635c);
        sb2.append(this.f61639g);
        String str = File.separator;
        sb2.append(str);
        sb2.append("lib");
        sb2.append(str);
        this.f61633a = sb2.toString();
    }

    /* renamed from: t */
    public void mo82360t(int i10) throws IllegalAccessException, InterruptedException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C2110c c2110c = this.f61636d;
        if (c2110c != null) {
            c2110c.m12633d();
            try {
                Thread.sleep(1500L);
            } catch (InterruptedException unused) {
                C2111d.m12648d("BackupAppDataBase", "releaseResource sleep fail");
            }
        }
        if (i10 == 5) {
            mo82352i(this.f61637e);
        }
    }

    /* renamed from: u */
    public final void m82361u(Context context, String str) throws IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        byte[] bArrM82345A = m82345A(String.format(Locale.ROOT, "restoreconpkgdir %s", str));
        try {
            C2110c c2110c = this.f61636d;
            c2110c.m12644s(bArrM82345A, c2110c.m12636g());
        } catch (IOException unused) {
            C2111d.m12648d("BackupAppDataBase", "restoreSELinuxTag Exception");
            mo82352i(context);
        }
    }

    /* renamed from: v */
    public void m82362v(int i10, int i11, int i12, Handler.Callback callback, Object obj) {
        if (callback != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = i11;
            messageObtain.arg2 = i12;
            messageObtain.obj = obj;
            callback.handleMessage(messageObtain);
        }
    }

    /* renamed from: w */
    public void m82363w(a aVar, Handler.Callback callback, Object obj, Bundle bundle) {
        if (callback == null || aVar == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = aVar.m82366a();
        messageObtain.arg1 = aVar.m82367b();
        messageObtain.arg2 = aVar.m82368c();
        messageObtain.obj = obj;
        messageObtain.setData(bundle);
        callback.handleMessage(messageObtain);
    }

    /* renamed from: y */
    public final void m82364y(String str, int i10, byte[] bArr) throws IOException {
        byte[] bArrM82345A = m82345A(String.format(Locale.ROOT, "chmod %s %s", str, String.valueOf(i10)));
        if (bArrM82345A == null) {
            throw new IOException("string2Byte err!");
        }
        int iM12644s = this.f61636d.m12644s(bArrM82345A, bArr);
        int iM12626a = C2110c.m12626a(bArr, 0, 4);
        if (iM12644s > 0) {
            Arrays.fill(bArr, 0, iM12644s, (byte) 0);
        }
        if (iM12626a != 0) {
            throw new IOException("setPermission err!");
        }
    }

    /* renamed from: z */
    public final void m82365z(String str, int[] iArr, byte[] bArr) throws IOException {
        byte[] bArrM82345A = m82345A(String.format(Locale.ROOT, "chown %s %s %s", str, String.valueOf(iArr[0]), String.valueOf(iArr[1])));
        if (bArrM82345A == null) {
            throw new IOException("string2Byte err!");
        }
        int iM12644s = this.f61636d.m12644s(bArrM82345A, bArr);
        int iM12626a = C2110c.m12626a(bArr, 0, 4);
        if (iM12644s > 0) {
            Arrays.fill(bArr, 0, iM12644s, (byte) 0);
        }
        if (iM12626a != 0) {
            throw new IOException("setUidAndGid err!");
        }
    }
}
