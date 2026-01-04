package p225dd;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p514o9.C11839m;

/* renamed from: dd.h */
/* loaded from: classes3.dex */
public class C9072h {

    /* renamed from: a */
    public b f45817a;

    /* renamed from: dd.h$b */
    public static class b {

        /* renamed from: a */
        public String f45818a;

        /* renamed from: b */
        public String f45819b;

        /* renamed from: c */
        public int f45820c;

        /* renamed from: d */
        public String f45821d;

        /* renamed from: e */
        public String f45822e;

        /* renamed from: f */
        public long f45823f = -1;

        /* renamed from: g */
        public String f45824g;

        /* renamed from: h */
        public int f45825h;

        /* renamed from: i */
        public String f45826i;

        /* renamed from: j */
        public String f45827j;

        /* renamed from: k */
        public String f45828k;

        /* renamed from: l */
        public long f45829l;

        public b(String str) {
            this.f45818a = str;
        }

        /* renamed from: A */
        public int m57270A() {
            return this.f45825h;
        }

        /* renamed from: B */
        public long m57271B() {
            return this.f45823f;
        }

        /* renamed from: C */
        public String m57272C() {
            return this.f45824g;
        }

        /* renamed from: D */
        public void m57273D() {
            this.f45823f = -1L;
            this.f45825h = EnumC9073i.DEFAULT.m57285b();
        }

        /* renamed from: E */
        public b m57274E(int i10) {
            this.f45820c = i10;
            return this;
        }

        /* renamed from: F */
        public b m57275F(long j10) {
            this.f45829l = j10;
            return this;
        }

        /* renamed from: G */
        public b m57276G(String str) {
            this.f45819b = str;
            return this;
        }

        /* renamed from: H */
        public b m57277H(String str) {
            this.f45821d = str;
            return this;
        }

        /* renamed from: I */
        public b m57278I(int i10) {
            this.f45825h = i10;
            return this;
        }

        /* renamed from: J */
        public b m57279J(long j10) {
            this.f45823f = j10;
            return this;
        }

        /* renamed from: K */
        public b m57280K(String str) {
            this.f45824g = str;
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
            boolean z10 = this.f45820c == bVar.f45820c && Objects.equals(this.f45818a, bVar.f45818a) && Objects.equals(this.f45819b, bVar.f45819b) && Objects.equals(this.f45821d, bVar.f45821d);
            if (z10) {
                m57278I(bVar.f45825h).m57279J(bVar.f45823f).m57280K(bVar.f45824g);
            }
            return z10;
        }

        public int hashCode() {
            return Objects.hash(this.f45818a, this.f45819b, Integer.valueOf(this.f45820c), this.f45821d);
        }

        /* renamed from: w */
        public C9072h m57281w() {
            return new C9072h(this);
        }

        /* renamed from: x */
        public long m57282x() {
            return this.f45829l;
        }

        /* renamed from: y */
        public String m57283y() {
            return this.f45819b;
        }

        /* renamed from: z */
        public String m57284z() {
            return this.f45821d;
        }
    }

    /* renamed from: a */
    public void m57245a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            sQLiteDatabase.execSQL("delete from t_sync_slices_download_status where assetId = ? and path = ?", new Object[]{this.f45817a.f45818a, this.f45817a.f45819b});
        } catch (Exception e10) {
            C11839m.m70687e("SliceDownloadStatus", "delete download status error " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public List<b> m57246b(SQLiteDatabase sQLiteDatabase) throws C9721b {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select assetId, path, num, sliceObjectId, synckey, taskId, uuid, status, data1, data2, data3 from t_sync_slices_download_status where assetId = ? and path = ? order by num asc ", new String[]{this.f45817a.f45818a, this.f45817a.f45819b});
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    do {
                        b bVar = new b(this.f45817a.f45818a);
                        bVar.f45818a = cursorRawQuery.getString(0);
                        bVar.f45819b = cursorRawQuery.getString(1);
                        bVar.f45820c = cursorRawQuery.getInt(2);
                        bVar.f45821d = cursorRawQuery.getString(3);
                        bVar.f45822e = cursorRawQuery.getString(4);
                        bVar.f45823f = cursorRawQuery.getLong(5);
                        bVar.f45824g = cursorRawQuery.getString(6);
                        bVar.f45825h = cursorRawQuery.getInt(7);
                        bVar.f45826i = cursorRawQuery.getString(8);
                        bVar.f45827j = cursorRawQuery.getString(9);
                        bVar.f45828k = cursorRawQuery.getString(10);
                        arrayList.add(bVar);
                    } while (cursorRawQuery.moveToNext());
                }
                return arrayList;
            } catch (Exception e10) {
                C11839m.m70687e("SliceDownloadStatus", "query download status error " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "query download status error " + e10.getMessage());
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: c */
    public void m57247c(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        try {
            sQLiteDatabase.execSQL("replace into t_sync_slices_download_status(assetId, path, num, sliceObjectId, synckey, taskId, uuid, status, data1, data2, data3) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{this.f45817a.f45818a, this.f45817a.f45819b, Integer.valueOf(this.f45817a.f45820c), this.f45817a.f45821d, this.f45817a.f45822e, Long.valueOf(this.f45817a.f45823f), this.f45817a.f45824g, Integer.valueOf(this.f45817a.f45825h), this.f45817a.f45826i, this.f45817a.f45827j, this.f45817a.f45828k});
        } catch (Exception e10) {
            C11839m.m70687e("SliceDownloadStatus", "replace download status error " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "replace download slices error " + e10.getMessage());
        }
    }

    public C9072h(b bVar) {
        this.f45817a = bVar;
    }
}
