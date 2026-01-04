package p768xa;

import hk.C10278a;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import p514o9.C11839m;

/* renamed from: xa.a */
/* loaded from: classes3.dex */
public class C13736a {

    /* renamed from: b */
    public static volatile C13736a f61744b;

    /* renamed from: c */
    public static final ReentrantLock f61745c = new ReentrantLock();

    /* renamed from: d */
    public static final ReentrantLock f61746d = new ReentrantLock();

    /* renamed from: e */
    public static MessageDigest f61747e = null;

    /* renamed from: f */
    public static MessageDigest f61748f = null;

    /* renamed from: a */
    public ExecutorService f61749a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public C13736a() {
        try {
            m82557e(MessageDigest.getInstance("MD5"));
        } catch (Exception e10) {
            C11839m.m70687e("DiskBitmapCache", "setCheckSum Message error " + e10.toString());
            m82557e(null);
        }
        try {
            m82558f(MessageDigest.getInstance("MD5"));
        } catch (Exception e11) {
            C11839m.m70687e("DiskBitmapCache", "setUiCheckSum Message error " + e11.toString());
            m82558f(null);
        }
    }

    /* renamed from: a */
    public static MessageDigest m82554a() {
        return f61747e;
    }

    /* renamed from: b */
    public static String m82555b(String str) {
        if (str == null) {
            return null;
        }
        long length = C10278a.m63442h(str).length();
        ReentrantLock reentrantLock = f61745c;
        reentrantLock.lock();
        try {
            MessageDigest messageDigestM82554a = m82554a();
            if (messageDigestM82554a == null) {
                reentrantLock.unlock();
                return null;
            }
            messageDigestM82554a.reset();
            messageDigestM82554a.update((str + "path").getBytes(Charset.defaultCharset()));
            messageDigestM82554a.update(String.valueOf(length).getBytes(Charset.defaultCharset()));
            String string = new BigInteger(1, messageDigestM82554a.digest()).toString(16);
            reentrantLock.unlock();
            return string;
        } catch (Throwable th2) {
            f61745c.unlock();
            throw th2;
        }
    }

    /* renamed from: c */
    public static C13736a m82556c() {
        if (f61744b == null) {
            ReentrantLock reentrantLock = f61745c;
            reentrantLock.lock();
            try {
                if (f61744b == null) {
                    f61744b = new C13736a();
                }
                reentrantLock.unlock();
            } catch (Throwable th2) {
                f61745c.unlock();
                throw th2;
            }
        }
        return f61744b;
    }

    /* renamed from: e */
    public static void m82557e(MessageDigest messageDigest) {
        f61747e = messageDigest;
    }

    /* renamed from: f */
    public static void m82558f(MessageDigest messageDigest) {
        f61748f = messageDigest;
    }

    /* renamed from: d */
    public void m82559d() {
    }
}
