package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.app.AbstractC0378c;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: androidx.appcompat.app.m */
/* loaded from: classes.dex */
public class C0388m {

    /* renamed from: androidx.appcompat.app.m$a */
    public static class a implements Executor {

        /* renamed from: a */
        public final Object f1385a = new Object();

        /* renamed from: b */
        public final Queue<Runnable> f1386b = new ArrayDeque();

        /* renamed from: c */
        public final Executor f1387c;

        /* renamed from: d */
        public Runnable f1388d;

        public a(Executor executor) {
            this.f1387c = executor;
        }

        /* renamed from: b */
        public final /* synthetic */ void m2244b(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                m2245c();
            }
        }

        /* renamed from: c */
        public void m2245c() {
            synchronized (this.f1385a) {
                try {
                    Runnable runnablePoll = this.f1386b.poll();
                    this.f1388d = runnablePoll;
                    if (runnablePoll != null) {
                        this.f1387c.execute(runnablePoll);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f1385a) {
                try {
                    this.f1386b.add(new Runnable() { // from class: androidx.appcompat.app.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1383a.m2244b(runnable);
                        }
                    });
                    if (this.f1388d == null) {
                        m2245c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.app.m$b */
    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    /* renamed from: a */
    public static void m2240a(Context context, String str) throws IOException {
        if (str.equals("")) {
            context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return;
        }
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            try {
                try {
                    xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                    xmlSerializerNewSerializer.startDocument(Constants.UTF_8, Boolean.TRUE);
                    xmlSerializerNewSerializer.startTag(null, "locales");
                    xmlSerializerNewSerializer.attribute(null, "application_locales", str);
                    xmlSerializerNewSerializer.endTag(null, "locales");
                    xmlSerializerNewSerializer.endDocument();
                    Log.d("AppLocalesStorageHelper", "Storing App Locales : app-locales: " + str + " persisted successfully.");
                } catch (Exception e10) {
                    Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: " + str, e10);
                    if (fileOutputStreamOpenFileOutput != null) {
                    }
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (Throwable th2) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th2;
            }
        } catch (FileNotFoundException unused3) {
            Log.w("AppLocalesStorageHelper", String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x003c, code lost:
    
        r2 = r4.getAttributeValue(null, "application_locales");
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m2241b(android.content.Context r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = ""
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch: java.io.FileNotFoundException -> L76
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            java.lang.String r5 = "UTF-8"
            r4.setInput(r3, r5)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            int r5 = r4.getDepth()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
        L17:
            int r6 = r4.next()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            r7 = 1
            if (r6 == r7) goto L43
            r7 = 3
            if (r6 != r7) goto L2a
            int r8 = r4.getDepth()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            if (r8 <= r5) goto L43
            goto L2a
        L28:
            r9 = move-exception
            goto L70
        L2a:
            if (r6 == r7) goto L17
            r7 = 4
            if (r6 != r7) goto L30
            goto L17
        L30:
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            java.lang.String r7 = "locales"
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            if (r6 == 0) goto L17
            java.lang.String r5 = "application_locales"
            r6 = 0
            java.lang.String r2 = r4.getAttributeValue(r6, r5)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
        L43:
            if (r3 == 0) goto L51
        L45:
            r3.close()     // Catch: java.io.IOException -> L51
            goto L51
        L49:
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r4)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L51
            goto L45
        L51:
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L6c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: "
            r9.append(r0)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r1, r9)
            goto L6f
        L6c:
            r9.deleteFile(r0)
        L6f:
            return r2
        L70:
            if (r3 == 0) goto L75
            r3.close()     // Catch: java.io.IOException -> L75
        L75:
            throw r9
        L76:
            java.lang.String r9 = "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0388m.m2241b(android.content.Context):java.lang.String");
    }

    /* renamed from: c */
    public static void m2242c(Context context) throws IOException {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (AbstractC0378c.m2201k().m6479e()) {
                    String strM2241b = m2241b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        AbstractC0378c.b.m2210b(systemService, AbstractC0378c.a.m2208a(strM2241b));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }
}
