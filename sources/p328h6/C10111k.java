package p328h6;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.huawei.android.backup.filelogic.utils.C2111d;
import gy.C10065d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import p699v4.C13339h;

/* renamed from: h6.k */
/* loaded from: classes.dex */
public class C10111k extends Thread {

    /* renamed from: a */
    public int f49331a;

    /* renamed from: b */
    public volatile int f49332b = -1;

    /* renamed from: c */
    public volatile boolean f49333c = true;

    /* renamed from: d */
    public boolean f49334d = true;

    public C10111k(int i10) {
        this.f49331a = i10;
    }

    /* renamed from: g */
    public static void m62985g(int i10, int i11, int i12, Bundle bundle, String str) {
        Handler.Callback callbackM62929d = C10104d.m62929d(str);
        if (callbackM62929d != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = i11;
            messageObtain.arg2 = i12;
            messageObtain.setData(bundle);
            callbackM62929d.handleMessage(messageObtain);
        }
    }

    /* renamed from: a */
    public final void m62986a(C10112l c10112l) throws Throwable {
        C10065d c10065d;
        C10065d c10065d2;
        Bundle bundle;
        String strM62996f = c10112l.m62996f();
        if (strM62996f == null) {
            C2111d.m12648d("UnTarFilesThread", "deArchiveFiles srcPath is null");
            return;
        }
        C2111d.m12653i("deArchiveFiles begin, path ", strM62996f);
        String strM62991a = c10112l.m62991a();
        File file = new File(strM62996f);
        String strM62993c = "";
        int iM62983y = c10112l.m62998h() ? AbstractC10110j.m62983y(strM62996f) : AbstractC10110j.m62952B(strM62996f);
        try {
            try {
                bundle = new Bundle();
                c10065d2 = new C10065d(new FileInputStream(file));
            } catch (FileNotFoundException unused) {
                c10065d2 = null;
            } catch (IOException unused2) {
                c10065d2 = null;
            } catch (Exception unused3) {
                c10065d2 = null;
            } catch (Throwable th2) {
                th = th2;
                c10065d = null;
                C13339h.m80014a(c10065d);
                m62987c(file);
                throw th;
            }
            try {
                int iM62971m = AbstractC10110j.m62971m(strM62991a, c10065d2, c10112l, bundle);
                C2111d.m12654j("deArchiveFiles end, path ", strM62996f, ", successCount ", Integer.valueOf(iM62971m), ", type ", Integer.valueOf(this.f49331a));
                bundle.putBoolean("isTarMsg", true);
                strM62993c = c10112l.m62993c();
                if (iM62983y == iM62971m) {
                    m62985g(3, iM62983y, c10112l.m62994d(), bundle, strM62993c);
                } else {
                    m62985g(3, iM62971m, c10112l.m62994d(), bundle, strM62993c);
                    int i10 = iM62983y - iM62971m;
                    m62985g(5, i10, c10112l.m62994d(), null, c10112l.m62993c());
                    C2111d.m12649e("UnTarFilesThread", "deArchiveFiles srcFile untar path is ", strM62996f, " success num: ", Integer.valueOf(iM62971m), " fail num: ", Integer.valueOf(i10));
                }
            } catch (FileNotFoundException unused4) {
                m62985g(5, iM62983y, c10112l.m62994d(), null, strM62993c);
                C2111d.m12648d("UnTarFilesThread", "dearchive srcFile File not existed");
                C13339h.m80014a(c10065d2);
                m62987c(file);
            } catch (IOException unused5) {
                m62985g(5, iM62983y, c10112l.m62994d(), null, strM62993c);
                C2111d.m12648d("UnTarFilesThread", "dearchive srcFile IOException");
                C13339h.m80014a(c10065d2);
                m62987c(file);
            } catch (Exception unused6) {
                m62985g(5, iM62983y, c10112l.m62994d(), null, strM62993c);
                C2111d.m12648d("UnTarFilesThread", "dearchive srcFile Exception");
                C13339h.m80014a(c10065d2);
                m62987c(file);
            }
            C13339h.m80014a(c10065d2);
            m62987c(file);
        } catch (Throwable th3) {
            th = th3;
            c10065d = c10065d2;
            C13339h.m80014a(c10065d);
            m62987c(file);
            throw th;
        }
    }

    /* renamed from: c */
    public final void m62987c(File file) {
        if (!file.exists() || file.delete()) {
            return;
        }
        C2111d.m12649e("UnTarFilesThread", "delete fail: ", file.getPath());
    }

    /* renamed from: d */
    public int m62988d() {
        return this.f49332b;
    }

    /* renamed from: e */
    public boolean m62989e() {
        C2111d.m12646b("UnTarFilesThread", "isCurrentTaskFinish currentTaskFinish = " + this.f49334d);
        return this.f49334d;
    }

    /* renamed from: f */
    public boolean m62990f() {
        return this.f49333c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        this.f49332b = Process.myTid();
        while (this.f49333c) {
            C10112l c10112lM62933e = C10104d.m62930i().m62933e(this.f49331a);
            if (c10112lM62933e != null && c10112lM62933e.m62996f().endsWith(".tar")) {
                C2111d.m12646b("UnTarFilesThread", "UnTarFilesThread UnTarTask start");
                this.f49334d = false;
                long jCurrentTimeMillis = System.currentTimeMillis();
                m62986a(c10112lM62933e);
                this.f49334d = true;
                C2111d.m12646b("UnTarFilesThread", "untar path " + c10112lM62933e.m62996f() + " finish ,time is " + (System.currentTimeMillis() - jCurrentTimeMillis));
            }
        }
    }
}
