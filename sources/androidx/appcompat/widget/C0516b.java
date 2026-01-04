package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: androidx.appcompat.widget.b */
/* loaded from: classes.dex */
public class C0516b extends DataSetObservable {

    /* renamed from: m */
    public static final String f2269m = "b";

    /* renamed from: n */
    public static final Object f2270n = new Object();

    /* renamed from: o */
    public static final Map<String, C0516b> f2271o = new HashMap();

    /* renamed from: d */
    public final Context f2275d;

    /* renamed from: e */
    public final String f2276e;

    /* renamed from: f */
    public Intent f2277f;

    /* renamed from: a */
    public final Object f2272a = new Object();

    /* renamed from: b */
    public final List<a> f2273b = new ArrayList();

    /* renamed from: c */
    public final List<d> f2274c = new ArrayList();

    /* renamed from: g */
    public b f2278g = new c();

    /* renamed from: h */
    public int f2279h = 50;

    /* renamed from: i */
    public boolean f2280i = true;

    /* renamed from: j */
    public boolean f2281j = false;

    /* renamed from: k */
    public boolean f2282k = true;

    /* renamed from: l */
    public boolean f2283l = false;

    /* renamed from: androidx.appcompat.widget.b$a */
    public static final class a implements Comparable<a> {

        /* renamed from: a */
        public final ResolveInfo f2284a;

        /* renamed from: b */
        public float f2285b;

        public a(ResolveInfo resolveInfo) {
            this.f2284a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.f2285b) - Float.floatToIntBits(this.f2285b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && Float.floatToIntBits(this.f2285b) == Float.floatToIntBits(((a) obj).f2285b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f2285b) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.f2284a.toString() + "; weight:" + new BigDecimal(this.f2285b) + "]";
        }
    }

    /* renamed from: androidx.appcompat.widget.b$b */
    public interface b {
        /* renamed from: a */
        void mo2913a(Intent intent, List<a> list, List<d> list2);
    }

    /* renamed from: androidx.appcompat.widget.b$c */
    public static final class c implements b {

        /* renamed from: a */
        public final Map<ComponentName, a> f2286a = new HashMap();

        @Override // androidx.appcompat.widget.C0516b.b
        /* renamed from: a */
        public void mo2913a(Intent intent, List<a> list, List<d> list2) {
            Map<ComponentName, a> map = this.f2286a;
            map.clear();
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                a aVar = list.get(i10);
                aVar.f2285b = 0.0f;
                ActivityInfo activityInfo = aVar.f2284a.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), aVar);
            }
            float f10 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                d dVar = list2.get(size2);
                a aVar2 = map.get(dVar.f2287a);
                if (aVar2 != null) {
                    aVar2.f2285b += dVar.f2289c * f10;
                    f10 *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    /* renamed from: androidx.appcompat.widget.b$d */
    public static final class d {

        /* renamed from: a */
        public final ComponentName f2287a;

        /* renamed from: b */
        public final long f2288b;

        /* renamed from: c */
        public final float f2289c;

        public d(String str, long j10, float f10) {
            this(ComponentName.unflattenFromString(str), j10, f10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            ComponentName componentName = this.f2287a;
            if (componentName == null) {
                if (dVar.f2287a != null) {
                    return false;
                }
            } else if (!componentName.equals(dVar.f2287a)) {
                return false;
            }
            return this.f2288b == dVar.f2288b && Float.floatToIntBits(this.f2289c) == Float.floatToIntBits(dVar.f2289c);
        }

        public int hashCode() {
            ComponentName componentName = this.f2287a;
            int iHashCode = componentName == null ? 0 : componentName.hashCode();
            long j10 = this.f2288b;
            return ((((iHashCode + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + Float.floatToIntBits(this.f2289c);
        }

        public String toString() {
            return "[; activity:" + this.f2287a + "; time:" + this.f2288b + "; weight:" + new BigDecimal(this.f2289c) + "]";
        }

        public d(ComponentName componentName, long j10, float f10) {
            this.f2287a = componentName;
            this.f2288b = j10;
            this.f2289c = f10;
        }
    }

    /* renamed from: androidx.appcompat.widget.b$e */
    public final class e extends AsyncTask<Object, Void, Void> {
        public e() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) throws IOException {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = C0516b.this.f2275d.openFileOutput(str, 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            try {
                                xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                                xmlSerializerNewSerializer.startDocument(Constants.UTF_8, Boolean.TRUE);
                                xmlSerializerNewSerializer.startTag(null, "historical-records");
                                int size = list.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    d dVar = (d) list.remove(0);
                                    xmlSerializerNewSerializer.startTag(null, "historical-record");
                                    xmlSerializerNewSerializer.attribute(null, "activity", dVar.f2287a.flattenToString());
                                    xmlSerializerNewSerializer.attribute(null, "time", String.valueOf(dVar.f2288b));
                                    xmlSerializerNewSerializer.attribute(null, "weight", String.valueOf(dVar.f2289c));
                                    xmlSerializerNewSerializer.endTag(null, "historical-record");
                                }
                                xmlSerializerNewSerializer.endTag(null, "historical-records");
                                xmlSerializerNewSerializer.endDocument();
                                C0516b.this.f2280i = true;
                            } catch (IllegalArgumentException e10) {
                                Log.e(C0516b.f2269m, "Error writing historical record file: " + C0516b.this.f2276e, e10);
                                C0516b.this.f2280i = true;
                                if (fileOutputStreamOpenFileOutput != null) {
                                }
                            }
                        } catch (IllegalStateException e11) {
                            Log.e(C0516b.f2269m, "Error writing historical record file: " + C0516b.this.f2276e, e11);
                            C0516b.this.f2280i = true;
                            if (fileOutputStreamOpenFileOutput != null) {
                            }
                        }
                    } catch (IOException e12) {
                        Log.e(C0516b.f2269m, "Error writing historical record file: " + C0516b.this.f2276e, e12);
                        C0516b.this.f2280i = true;
                        if (fileOutputStreamOpenFileOutput != null) {
                        }
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    C0516b.this.f2280i = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th2;
                }
            } catch (FileNotFoundException e13) {
                Log.e(C0516b.f2269m, "Error writing historical record file: " + str, e13);
                return null;
            }
        }
    }

    public C0516b(Context context, String str) {
        this.f2275d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.f2276e = str;
            return;
        }
        this.f2276e = str + ".xml";
    }

    /* renamed from: d */
    public static C0516b m2896d(Context context, String str) {
        C0516b c0516b;
        synchronized (f2270n) {
            try {
                Map<String, C0516b> map = f2271o;
                c0516b = map.get(str);
                if (c0516b == null) {
                    c0516b = new C0516b(context, str);
                    map.put(str, c0516b);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c0516b;
    }

    /* renamed from: a */
    public final boolean m2897a(d dVar) {
        boolean zAdd = this.f2274c.add(dVar);
        if (zAdd) {
            this.f2282k = true;
            m2907l();
            m2906k();
            m2911p();
            notifyChanged();
        }
        return zAdd;
    }

    /* renamed from: b */
    public Intent m2898b(int i10) {
        synchronized (this.f2272a) {
            try {
                if (this.f2277f == null) {
                    return null;
                }
                m2899c();
                ActivityInfo activityInfo = this.f2273b.get(i10).f2284a.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                Intent intent = new Intent(this.f2277f);
                intent.setComponent(componentName);
                m2897a(new d(componentName, System.currentTimeMillis(), 1.0f));
                return intent;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public final void m2899c() {
        boolean zM2905j = m2905j() | m2908m();
        m2907l();
        if (zM2905j) {
            m2911p();
            notifyChanged();
        }
    }

    /* renamed from: e */
    public ResolveInfo m2900e(int i10) {
        ResolveInfo resolveInfo;
        synchronized (this.f2272a) {
            m2899c();
            resolveInfo = this.f2273b.get(i10).f2284a;
        }
        return resolveInfo;
    }

    /* renamed from: f */
    public int m2901f() {
        int size;
        synchronized (this.f2272a) {
            m2899c();
            size = this.f2273b.size();
        }
        return size;
    }

    /* renamed from: g */
    public int m2902g(ResolveInfo resolveInfo) {
        synchronized (this.f2272a) {
            try {
                m2899c();
                List<a> list = this.f2273b;
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (list.get(i10).f2284a == resolveInfo) {
                        return i10;
                    }
                }
                return -1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: h */
    public ResolveInfo m2903h() {
        synchronized (this.f2272a) {
            try {
                m2899c();
                if (this.f2273b.isEmpty()) {
                    return null;
                }
                return this.f2273b.get(0).f2284a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: i */
    public int m2904i() {
        int size;
        synchronized (this.f2272a) {
            m2899c();
            size = this.f2274c.size();
        }
        return size;
    }

    /* renamed from: j */
    public final boolean m2905j() {
        if (!this.f2283l || this.f2277f == null) {
            return false;
        }
        this.f2283l = false;
        this.f2273b.clear();
        List<ResolveInfo> listQueryIntentActivities = this.f2275d.getPackageManager().queryIntentActivities(this.f2277f, 0);
        int size = listQueryIntentActivities.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f2273b.add(new a(listQueryIntentActivities.get(i10)));
        }
        return true;
    }

    /* renamed from: k */
    public final void m2906k() {
        if (!this.f2281j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.f2282k) {
            this.f2282k = false;
            if (TextUtils.isEmpty(this.f2276e)) {
                return;
            }
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f2274c), this.f2276e);
        }
    }

    /* renamed from: l */
    public final void m2907l() {
        int size = this.f2274c.size() - this.f2279h;
        if (size <= 0) {
            return;
        }
        this.f2282k = true;
        for (int i10 = 0; i10 < size; i10++) {
            this.f2274c.remove(0);
        }
    }

    /* renamed from: m */
    public final boolean m2908m() throws IOException {
        if (!this.f2280i || !this.f2282k || TextUtils.isEmpty(this.f2276e)) {
            return false;
        }
        this.f2280i = false;
        this.f2281j = true;
        m2909n();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
    
        return;
     */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2909n() throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "Error reading historical recrod file: "
            android.content.Context r1 = r10.f2275d     // Catch: java.io.FileNotFoundException -> Lc5
            java.lang.String r2 = r10.f2276e     // Catch: java.io.FileNotFoundException -> Lc5
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.io.FileNotFoundException -> Lc5
            org.xmlpull.v1.XmlPullParser r2 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            java.lang.String r3 = "UTF-8"
            r2.setInput(r1, r3)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            r3 = 0
        L14:
            r4 = 1
            if (r3 == r4) goto L27
            r5 = 2
            if (r3 == r5) goto L27
            int r3 = r2.next()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            goto L14
        L1f:
            r10 = move-exception
            goto Lbf
        L22:
            r2 = move-exception
            goto L8c
        L24:
            r2 = move-exception
            goto La5
        L27:
            java.lang.String r3 = "historical-records"
            java.lang.String r5 = r2.getName()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            boolean r3 = r3.equals(r5)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            if (r3 == 0) goto L84
            java.util.List<androidx.appcompat.widget.b$d> r3 = r10.f2274c     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            r3.clear()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
        L38:
            int r5 = r2.next()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            if (r5 != r4) goto L45
            if (r1 == 0) goto Lbe
        L40:
            r1.close()     // Catch: java.io.IOException -> Lbe
            goto Lbe
        L45:
            r6 = 3
            if (r5 == r6) goto L38
            r6 = 4
            if (r5 != r6) goto L4c
            goto L38
        L4c:
            java.lang.String r5 = r2.getName()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            java.lang.String r6 = "historical-record"
            boolean r5 = r6.equals(r5)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            if (r5 == 0) goto L7c
            java.lang.String r5 = "activity"
            r6 = 0
            java.lang.String r5 = r2.getAttributeValue(r6, r5)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            java.lang.String r7 = "time"
            java.lang.String r7 = r2.getAttributeValue(r6, r7)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            long r7 = java.lang.Long.parseLong(r7)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            java.lang.String r9 = "weight"
            java.lang.String r6 = r2.getAttributeValue(r6, r9)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            float r6 = java.lang.Float.parseFloat(r6)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            androidx.appcompat.widget.b$d r9 = new androidx.appcompat.widget.b$d     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            r9.<init>(r5, r7, r6)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            r3.add(r9)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            goto L38
        L7c:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            java.lang.String r3 = "Share records file not well-formed."
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            throw r2     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
        L84:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            java.lang.String r3 = "Share records file does not start with historical-records tag."
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
            throw r2     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22 org.xmlpull.v1.XmlPullParserException -> L24
        L8c:
            java.lang.String r3 = androidx.appcompat.widget.C0516b.f2269m     // Catch: java.lang.Throwable -> L1f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r4.<init>()     // Catch: java.lang.Throwable -> L1f
            r4.append(r0)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r10 = r10.f2276e     // Catch: java.lang.Throwable -> L1f
            r4.append(r10)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> L1f
            android.util.Log.e(r3, r10, r2)     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto Lbe
            goto L40
        La5:
            java.lang.String r3 = androidx.appcompat.widget.C0516b.f2269m     // Catch: java.lang.Throwable -> L1f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r4.<init>()     // Catch: java.lang.Throwable -> L1f
            r4.append(r0)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r10 = r10.f2276e     // Catch: java.lang.Throwable -> L1f
            r4.append(r10)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> L1f
            android.util.Log.e(r3, r10, r2)     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto Lbe
            goto L40
        Lbe:
            return
        Lbf:
            if (r1 == 0) goto Lc4
            r1.close()     // Catch: java.io.IOException -> Lc4
        Lc4:
            throw r10
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0516b.m2909n():void");
    }

    /* renamed from: o */
    public void m2910o(int i10) {
        synchronized (this.f2272a) {
            try {
                m2899c();
                a aVar = this.f2273b.get(i10);
                a aVar2 = this.f2273b.get(0);
                float f10 = aVar2 != null ? (aVar2.f2285b - aVar.f2285b) + 5.0f : 1.0f;
                ActivityInfo activityInfo = aVar.f2284a.activityInfo;
                m2897a(new d(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f10));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: p */
    public final boolean m2911p() {
        if (this.f2278g == null || this.f2277f == null || this.f2273b.isEmpty() || this.f2274c.isEmpty()) {
            return false;
        }
        this.f2278g.mo2913a(this.f2277f, this.f2273b, Collections.unmodifiableList(this.f2274c));
        return true;
    }
}
