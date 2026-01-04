package p758x0;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArraySet;
import android.util.Pair;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import p005a4.C0026f;
import p631s3.C12684g;
import p631s3.C12686i;
import p631s3.InterfaceC12678a;
import p631s3.InterfaceC12681d;
import p646t3.C12923a;
import p646t3.C12928f;
import p698v3.C13329a;
import p698v3.C13330b;
import p727w3.C13522a;

/* renamed from: x0.a */
/* loaded from: classes.dex */
public final class SharedPreferencesC13674a implements SharedPreferences {

    /* renamed from: a */
    public final SharedPreferences f61569a;

    /* renamed from: b */
    public final List<SharedPreferences.OnSharedPreferenceChangeListener> f61570b = new ArrayList();

    /* renamed from: c */
    public final String f61571c;

    /* renamed from: d */
    public final String f61572d;

    /* renamed from: e */
    public final InterfaceC12678a f61573e;

    /* renamed from: f */
    public final InterfaceC12681d f61574f;

    /* renamed from: x0.a$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f61575a;

        static {
            int[] iArr = new int[c.values().length];
            f61575a = iArr;
            try {
                iArr[c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61575a[c.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f61575a[c.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f61575a[c.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f61575a[c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f61575a[c.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: x0.a$b */
    public static final class b implements SharedPreferences.Editor {

        /* renamed from: a */
        public final SharedPreferencesC13674a f61576a;

        /* renamed from: b */
        public final SharedPreferences.Editor f61577b;

        /* renamed from: d */
        public AtomicBoolean f61579d = new AtomicBoolean(false);

        /* renamed from: c */
        public final List<String> f61578c = new CopyOnWriteArrayList();

        public b(SharedPreferencesC13674a sharedPreferencesC13674a, SharedPreferences.Editor editor) {
            this.f61576a = sharedPreferencesC13674a;
            this.f61577b = editor;
        }

        /* renamed from: a */
        public final void m82264a() {
            if (this.f61579d.getAndSet(false)) {
                for (String str : this.f61576a.getAll().keySet()) {
                    if (!this.f61578c.contains(str) && !this.f61576a.m82263f(str)) {
                        this.f61577b.remove(this.f61576a.m82260c(str));
                    }
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            m82264a();
            this.f61577b.apply();
            m82265b();
            this.f61578c.clear();
        }

        /* renamed from: b */
        public final void m82265b() {
            for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.f61576a.f61570b) {
                Iterator<String> it = this.f61578c.iterator();
                while (it.hasNext()) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.f61576a, it.next());
                }
            }
        }

        /* renamed from: c */
        public final void m82266c(String str, byte[] bArr) {
            if (this.f61576a.m82263f(str)) {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
            this.f61578c.add(str);
            if (str == null) {
                str = "__NULL__";
            }
            try {
                Pair<String, String> pairM82261d = this.f61576a.m82261d(str, bArr);
                this.f61577b.putString((String) pairM82261d.first, (String) pairM82261d.second);
            } catch (GeneralSecurityException e10) {
                throw new SecurityException("Could not encrypt data: " + e10.getMessage(), e10);
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f61579d.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            m82264a();
            try {
                return this.f61577b.commit();
            } finally {
                m82265b();
                this.f61578c.clear();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z10) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
            byteBufferAllocate.putInt(c.BOOLEAN.m82268e());
            byteBufferAllocate.put(z10 ? (byte) 1 : (byte) 0);
            m82266c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f10) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(c.FLOAT.m82268e());
            byteBufferAllocate.putFloat(f10);
            m82266c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i10) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(c.INT.m82268e());
            byteBufferAllocate.putInt(i10);
            m82266c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j10) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
            byteBufferAllocate.putInt(c.LONG.m82268e());
            byteBufferAllocate.putLong(j10);
            m82266c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 8);
            byteBufferAllocate.putInt(c.STRING.m82268e());
            byteBufferAllocate.putInt(length);
            byteBufferAllocate.put(bytes);
            m82266c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new ArraySet<>();
                set.add("__NULL__");
            }
            ArrayList<byte[]> arrayList = new ArrayList(set.size());
            int size = set.size() * 4;
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                byte[] bytes = it.next().getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes);
                size += bytes.length;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(size + 4);
            byteBufferAllocate.putInt(c.STRING_SET.m82268e());
            for (byte[] bArr : arrayList) {
                byteBufferAllocate.putInt(bArr.length);
                byteBufferAllocate.put(bArr);
            }
            m82266c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            if (!this.f61576a.m82263f(str)) {
                this.f61577b.remove(this.f61576a.m82260c(str));
                this.f61578c.remove(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    /* renamed from: x0.a$c */
    public enum c {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);


        /* renamed from: a */
        public final int f61587a;

        c(int i10) {
            this.f61587a = i10;
        }

        /* renamed from: b */
        public static c m82267b(int i10) {
            if (i10 == 0) {
                return STRING;
            }
            if (i10 == 1) {
                return STRING_SET;
            }
            if (i10 == 2) {
                return INT;
            }
            if (i10 == 3) {
                return LONG;
            }
            if (i10 == 4) {
                return FLOAT;
            }
            if (i10 != 5) {
                return null;
            }
            return BOOLEAN;
        }

        /* renamed from: e */
        public int m82268e() {
            return this.f61587a;
        }
    }

    /* renamed from: x0.a$d */
    public enum d {
        AES256_SIV(C13329a.m79932j());


        /* renamed from: a */
        public final C12684g f61590a;

        d(C12684g c12684g) {
            this.f61590a = c12684g;
        }

        /* renamed from: b */
        public C12684g m82269b() {
            return this.f61590a;
        }
    }

    /* renamed from: x0.a$e */
    public enum e {
        AES256_GCM(C12928f.m77614j());


        /* renamed from: a */
        public final C12684g f61593a;

        e(C12684g c12684g) {
            this.f61593a = c12684g;
        }

        /* renamed from: b */
        public C12684g m82270b() {
            return this.f61593a;
        }
    }

    public SharedPreferencesC13674a(String str, String str2, SharedPreferences sharedPreferences, InterfaceC12678a interfaceC12678a, InterfaceC12681d interfaceC12681d) {
        this.f61571c = str;
        this.f61569a = sharedPreferences;
        this.f61572d = str2;
        this.f61573e = interfaceC12678a;
        this.f61574f = interfaceC12681d;
    }

    /* renamed from: a */
    public static SharedPreferences m82258a(String str, String str2, Context context, d dVar, e eVar) throws GeneralSecurityException, IOException {
        C13330b.m79943b();
        C12923a.m77585b();
        C12686i c12686iM81379c = new C13522a.b().m81387h(dVar.m82269b()).m81389j(context, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str).m81388i("android-keystore://" + str2).m81383d().m81379c();
        C12686i c12686iM81379c2 = new C13522a.b().m81387h(eVar.m82270b()).m81389j(context, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str).m81388i("android-keystore://" + str2).m81383d().m81379c();
        return new SharedPreferencesC13674a(str, str2, context.getSharedPreferences(str, 0), (InterfaceC12678a) c12686iM81379c2.m76338h(InterfaceC12678a.class), (InterfaceC12681d) c12686iM81379c.m76338h(InterfaceC12681d.class));
    }

    /* renamed from: b */
    public String m82259b(String str) {
        try {
            String str2 = new String(this.f61574f.mo98b(C0026f.m102a(str, 0), this.f61571c.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals("__NULL__")) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e10) {
            throw new SecurityException("Could not decrypt key. " + e10.getMessage(), e10);
        }
    }

    /* renamed from: c */
    public String m82260c(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return C0026f.m105d(this.f61574f.mo97a(str.getBytes(StandardCharsets.UTF_8), this.f61571c.getBytes()));
        } catch (GeneralSecurityException e10) {
            throw new SecurityException("Could not encrypt key. " + e10.getMessage(), e10);
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (!m82263f(str)) {
            return this.f61569a.contains(m82260c(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    /* renamed from: d */
    public Pair<String, String> m82261d(String str, byte[] bArr) throws GeneralSecurityException {
        String strM82260c = m82260c(str);
        return new Pair<>(strM82260c, C0026f.m105d(this.f61573e.mo88a(bArr, strM82260c.getBytes(StandardCharsets.UTF_8))));
    }

    /* renamed from: e */
    public final Object m82262e(String str) {
        if (m82263f(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strM82260c = m82260c(str);
            String string = this.f61569a.getString(strM82260c, null);
            if (string == null) {
                return null;
            }
            byte[] bArrM102a = C0026f.m102a(string, 0);
            InterfaceC12678a interfaceC12678a = this.f61573e;
            Charset charset = StandardCharsets.UTF_8;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(interfaceC12678a.mo89b(bArrM102a, strM82260c.getBytes(charset)));
            byteBufferWrap.position(0);
            switch (a.f61575a[c.m82267b(byteBufferWrap.getInt()).ordinal()]) {
                case 1:
                    int i10 = byteBufferWrap.getInt();
                    ByteBuffer byteBufferSlice = byteBufferWrap.slice();
                    byteBufferWrap.limit(i10);
                    String string2 = charset.decode(byteBufferSlice).toString();
                    if (string2.equals("__NULL__")) {
                        return null;
                    }
                    return string2;
                case 2:
                    return Integer.valueOf(byteBufferWrap.getInt());
                case 3:
                    return Long.valueOf(byteBufferWrap.getLong());
                case 4:
                    return Float.valueOf(byteBufferWrap.getFloat());
                case 5:
                    return Boolean.valueOf(byteBufferWrap.get() != 0);
                case 6:
                    ArraySet arraySet = new ArraySet();
                    while (byteBufferWrap.hasRemaining()) {
                        int i11 = byteBufferWrap.getInt();
                        ByteBuffer byteBufferSlice2 = byteBufferWrap.slice();
                        byteBufferSlice2.limit(i11);
                        byteBufferWrap.position(byteBufferWrap.position() + i11);
                        arraySet.add(StandardCharsets.UTF_8.decode(byteBufferSlice2).toString());
                    }
                    if (arraySet.size() == 1 && "__NULL__".equals(arraySet.valueAt(0))) {
                        return null;
                    }
                    return arraySet;
                default:
                    return null;
            }
        } catch (GeneralSecurityException e10) {
            throw new SecurityException("Could not decrypt value. " + e10.getMessage(), e10);
        }
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new b(this, this.f61569a.edit());
    }

    /* renamed from: f */
    public boolean m82263f(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : this.f61569a.getAll().entrySet()) {
            if (!m82263f(entry.getKey())) {
                String strM82259b = m82259b(entry.getKey());
                map.put(strM82259b, m82262e(strM82259b));
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z10) {
        Object objM82262e = m82262e(str);
        return (objM82262e == null || !(objM82262e instanceof Boolean)) ? z10 : ((Boolean) objM82262e).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f10) {
        Object objM82262e = m82262e(str);
        return (objM82262e == null || !(objM82262e instanceof Float)) ? f10 : ((Float) objM82262e).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i10) {
        Object objM82262e = m82262e(str);
        return (objM82262e == null || !(objM82262e instanceof Integer)) ? i10 : ((Integer) objM82262e).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j10) {
        Object objM82262e = m82262e(str);
        return (objM82262e == null || !(objM82262e instanceof Long)) ? j10 : ((Long) objM82262e).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object objM82262e = m82262e(str);
        return (objM82262e == null || !(objM82262e instanceof String)) ? str2 : (String) objM82262e;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Object objM82262e = m82262e(str);
        Set<String> arraySet = objM82262e instanceof Set ? (Set) objM82262e : new ArraySet<>();
        return arraySet.size() > 0 ? arraySet : set;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f61570b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f61570b.remove(onSharedPreferenceChangeListener);
    }
}
