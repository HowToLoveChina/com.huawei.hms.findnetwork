package p711vl;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0214f0;
import p371ik.C10527a;
import p572qb.C12299b;
import p618rm.C12540b1;

/* renamed from: vl.f */
/* loaded from: classes6.dex */
public class C13466f {

    /* renamed from: b */
    public static final C13466f f60648b = new C13466f();

    /* renamed from: a */
    public SharedPreferences f60649a;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: vl.f$a */
    public class a<T> extends TypeToken<List<T>> {
        public a() {
        }
    }

    /* renamed from: d */
    public static C13466f m81073d() {
        return f60648b;
    }

    /* renamed from: a */
    public void m81074a() {
        SharedPreferences sharedPreferences = this.f60649a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
        }
    }

    /* renamed from: b */
    public boolean m81075b(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f60649a;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z10) : z10;
    }

    /* renamed from: c */
    public <T> List<T> m81076c(String str) {
        ArrayList arrayList = new ArrayList();
        String string = this.f60649a.getString(str, null);
        if (string == null) {
            return arrayList;
        }
        List<T> list = (List) C12540b1.m75484b(string, new a().getType());
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: e */
    public int m81077e(String str, int i10) {
        SharedPreferences sharedPreferences = this.f60649a;
        return sharedPreferences != null ? sharedPreferences.getInt(str, i10) : i10;
    }

    /* renamed from: f */
    public long m81078f(String str, long j10) {
        SharedPreferences sharedPreferences = this.f60649a;
        return sharedPreferences != null ? sharedPreferences.getLong(str, j10) : j10;
    }

    /* renamed from: g */
    public String m81079g(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60649a;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    /* renamed from: h */
    public void m81080h(Context context) {
        this.f60649a = C0214f0.m1382b(context, "cloudbackupsettings", 0);
    }

    /* renamed from: i */
    public void m81081i(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f60649a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z10).apply();
        }
    }

    /* renamed from: j */
    public void m81082j(String str, int i10) {
        SharedPreferences sharedPreferences = this.f60649a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str, i10).apply();
        }
    }

    /* renamed from: k */
    public void m81083k(String str, long j10) {
        SharedPreferences sharedPreferences = this.f60649a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str, j10).apply();
        }
    }

    /* renamed from: l */
    public void m81084l(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60649a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
            if ("gradeCode".equals(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(str, str2);
                C12299b.m73929k(contentValues, "backupUserFrequency");
            }
        }
    }

    /* renamed from: m */
    public <T> void m81085m(String str, List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m81084l(str, C10527a.m64633k(list));
    }
}
