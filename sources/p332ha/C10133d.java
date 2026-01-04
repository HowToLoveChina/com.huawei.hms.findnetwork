package p332ha;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p031b7.C1120a;

/* renamed from: ha.d */
/* loaded from: classes3.dex */
public class C10133d {

    /* renamed from: a */
    public b f49397a;

    /* renamed from: ha.d$b */
    public static class b {

        /* renamed from: a */
        public String f49398a;

        /* renamed from: b */
        public String f49399b;

        /* renamed from: c */
        public String f49400c;

        /* renamed from: d */
        public int f49401d;

        /* renamed from: e */
        public long f49402e = -1;

        /* renamed from: f */
        public String f49403f;

        /* renamed from: g */
        public int f49404g;

        /* renamed from: h */
        public String f49405h;

        /* renamed from: i */
        public String f49406i;

        /* renamed from: j */
        public String f49407j;

        /* renamed from: k */
        public String f49408k;

        /* renamed from: l */
        public long f49409l;

        public b(String str) {
            this.f49399b = str;
        }

        /* renamed from: A */
        public int m63132A() {
            return this.f49404g;
        }

        /* renamed from: B */
        public long m63133B() {
            return this.f49402e;
        }

        /* renamed from: C */
        public String m63134C() {
            return this.f49405h;
        }

        /* renamed from: D */
        public void m63135D() {
            this.f49402e = -1L;
            this.f49404g = EnumC10135f.DEFAULT.m63179b();
        }

        /* renamed from: E */
        public b m63136E(int i10) {
            this.f49401d = i10;
            return this;
        }

        /* renamed from: F */
        public b m63137F(String str) {
            this.f49400c = str;
            return this;
        }

        /* renamed from: G */
        public b m63138G(long j10) {
            this.f49409l = j10;
            return this;
        }

        /* renamed from: H */
        public b m63139H(String str) {
            this.f49398a = str;
            return this;
        }

        /* renamed from: I */
        public b m63140I(int i10) {
            this.f49404g = i10;
            return this;
        }

        /* renamed from: J */
        public b m63141J(long j10) {
            this.f49402e = j10;
            return this;
        }

        /* renamed from: K */
        public b m63142K(String str) {
            this.f49405h = str;
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            boolean z10 = this.f49401d == bVar.f49401d && Objects.equals(this.f49399b, bVar.f49399b) && Objects.equals(this.f49398a, bVar.f49398a) && Objects.equals(this.f49400c, bVar.f49400c);
            if (z10) {
                m63140I(bVar.f49404g).m63141J(bVar.f49402e).m63142K(bVar.f49405h);
            }
            return z10;
        }

        public int hashCode() {
            return Objects.hash(this.f49399b, this.f49398a, Integer.valueOf(this.f49401d), this.f49400c);
        }

        /* renamed from: w */
        public C10133d m63143w() {
            return new C10133d(this);
        }

        /* renamed from: x */
        public String m63144x() {
            return this.f49400c;
        }

        /* renamed from: y */
        public long m63145y() {
            return this.f49409l;
        }

        /* renamed from: z */
        public String m63146z() {
            return this.f49398a;
        }
    }

    /* renamed from: a */
    public void m63107a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            sQLiteDatabase.execSQL("delete from t_slice_download_status where hmac = ? and path = ?", new Object[]{this.f49397a.f49399b, this.f49397a.f49398a});
        } catch (Exception e10) {
            C1120a.m6676e("SliceDownloadStatus", "delete download status error " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public List<b> m63108b(SQLiteDatabase sQLiteDatabase) throws C9721b {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select hmac, path, num, object, synckey, taskId, uuid, status, data1, data2, data3 from t_slice_download_status where hmac = ? and path = ? order by num asc ", new String[]{this.f49397a.f49399b, this.f49397a.f49398a});
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    do {
                        b bVar = new b(this.f49397a.f49399b);
                        bVar.f49399b = cursorRawQuery.getString(0);
                        bVar.f49398a = cursorRawQuery.getString(1);
                        bVar.f49401d = cursorRawQuery.getInt(2);
                        bVar.f49400c = cursorRawQuery.getString(3);
                        bVar.f49403f = cursorRawQuery.getString(4);
                        bVar.f49402e = cursorRawQuery.getLong(5);
                        bVar.f49405h = cursorRawQuery.getString(6);
                        bVar.f49404g = cursorRawQuery.getInt(7);
                        bVar.f49406i = cursorRawQuery.getString(8);
                        bVar.f49407j = cursorRawQuery.getString(9);
                        bVar.f49408k = cursorRawQuery.getString(10);
                        arrayList.add(bVar);
                    } while (cursorRawQuery.moveToNext());
                }
                return arrayList;
            } catch (Exception e10) {
                C1120a.m6676e("SliceDownloadStatus", "query download status error " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "query download status error " + e10.getMessage());
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: c */
    public void m63109c(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        try {
            sQLiteDatabase.execSQL("replace into t_slice_download_status(hmac, path, num, object, synckey, taskId, uuid, status, data1, data2, data3) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{this.f49397a.f49399b, this.f49397a.f49398a, Integer.valueOf(this.f49397a.f49401d), this.f49397a.f49400c, this.f49397a.f49403f, Long.valueOf(this.f49397a.f49402e), this.f49397a.f49405h, Integer.valueOf(this.f49397a.f49404g), this.f49397a.f49406i, this.f49397a.f49407j, this.f49397a.f49408k});
        } catch (Exception e10) {
            C1120a.m6676e("SliceDownloadStatus", "replace download status error " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "replace download slices error " + e10.getMessage());
        }
    }

    public C10133d(b bVar) {
        this.f49397a = bVar;
    }
}
