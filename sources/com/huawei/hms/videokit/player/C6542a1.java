package com.huawei.hms.videokit.player;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* renamed from: com.huawei.hms.videokit.player.a1 */
/* loaded from: classes8.dex */
class C6542a1 implements InterfaceC6612z0 {

    /* renamed from: a */
    public static boolean f30302a = false;

    /* renamed from: b */
    private static final Logger f30303b = Logger.getLogger("JDKVideoLog");

    /* renamed from: c */
    private static FileHandler f30304c;

    /* renamed from: com.huawei.hms.videokit.player.a1$b */
    public static final class b extends Formatter {

        /* renamed from: a */
        private static final String f30305a = System.getProperty("line.separator");

        /* renamed from: b */
        private static final Map<Level, String> f30306b;

        static {
            HashMap map = new HashMap();
            f30306b = map;
            map.put(Level.FINE, "DEBUG");
            map.put(Level.INFO, "INFO");
            map.put(Level.WARNING, "WARN");
            map.put(Level.SEVERE, "ERROR");
        }

        private b() {
        }

        /* renamed from: a */
        public static String m37206a(long j10, String str) {
            if (str == null) {
                return null;
            }
            return new SimpleDateFormat(str, Locale.US).format(Long.valueOf(j10));
        }

        @Override // java.util.logging.Formatter
        public String format(LogRecord logRecord) {
            return m37206a(logRecord.getMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + ' ' + f30306b.get(logRecord.getLevel()) + ": " + formatMessage(logRecord) + f30305a;
        }
    }

    public C6542a1(String str, int i10, int i11) throws SecurityException, IllegalArgumentException {
        Logger logger = f30303b;
        if (logger == null) {
            throw new IllegalArgumentException();
        }
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        m37196a(str, i10, i11);
    }

    /* renamed from: b */
    private static FileHandler m37198b(String str, int i10, int i11) throws SecurityException {
        try {
            m37199b(str);
            FileHandler fileHandler = new FileHandler(str, i11, i10, true);
            fileHandler.setFormatter(new b());
            return fileHandler;
        } catch (IOException unused) {
            Log.println(6, "JDKVideoLog", "Error in initializing jdk logger and disabled logger.");
            f30302a = false;
            return null;
        }
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: a */
    public void mo37200a() {
        synchronized (C6542a1.class) {
            try {
                FileHandler fileHandler = f30304c;
                if (fileHandler != null) {
                    fileHandler.flush();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: c */
    public void mo37204c(String str, Object obj) {
        f30303b.log(Level.FINE, '[' + str + "] " + obj);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: d */
    public void mo37205d(String str, Object obj) {
        f30303b.log(Level.WARNING, '[' + str + "] " + obj);
    }

    /* renamed from: a */
    private static void m37196a(String str, int i10, int i11) throws IllegalArgumentException {
        synchronized (C6542a1.class) {
            try {
                FileHandler fileHandler = f30304c;
                if (fileHandler != null) {
                    fileHandler.flush();
                    f30304c.close();
                    f30303b.removeHandler(f30304c);
                    f30304c = null;
                }
                FileHandler fileHandlerM37198b = m37198b(str, i10, i11);
                if (fileHandlerM37198b == null) {
                    f30302a = false;
                    throw new IllegalArgumentException();
                }
                f30303b.addHandler(fileHandlerM37198b);
                f30304c = fileHandlerM37198b;
                f30302a = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: b */
    public void mo37203b(String str, Object obj) {
        f30303b.log(Level.INFO, '[' + str + "] " + obj);
    }

    /* renamed from: b */
    private static boolean m37199b(String str) {
        int iLastIndexOf;
        int iLastIndexOf2;
        if (!C6600t0.m37683c(str) && (iLastIndexOf = str.lastIndexOf("/")) > 0 && (iLastIndexOf2 = str.lastIndexOf("/", iLastIndexOf - 1)) > 0 && m37197a(C6600t0.m37673a(str, 0, iLastIndexOf2))) {
            return m37197a(C6600t0.m37673a(str, 0, iLastIndexOf));
        }
        return false;
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: a */
    public void mo37201a(String str, Object obj) {
        f30303b.log(Level.SEVERE, '[' + str + "] " + obj);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: a */
    public void mo37202a(String str, Object obj, Throwable th2) {
        f30303b.log(Level.SEVERE, '[' + str + "] " + C6606w0.m37720a(obj, th2));
    }

    /* renamed from: a */
    private static boolean m37197a(String str) {
        if (C6600t0.m37683c(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.exists() && !file.delete()) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }
}
