package p332ha;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.android.hicloud.drive.cloudphoto.model.SliceObject;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p031b7.C1120a;

/* renamed from: ha.e */
/* loaded from: classes3.dex */
public class C10134e {

    /* renamed from: a */
    public b f49410a;

    /* renamed from: ha.e$b */
    public static class b {

        /* renamed from: a */
        public String f49411a;

        /* renamed from: b */
        public int f49412b;

        /* renamed from: c */
        public String f49413c;

        /* renamed from: d */
        public String f49414d;

        /* renamed from: e */
        public String f49415e;

        /* renamed from: f */
        public int f49416f = 0;

        /* renamed from: g */
        public String f49417g;

        /* renamed from: h */
        public String f49418h;

        /* renamed from: i */
        public String f49419i;

        public b(String str) {
            this.f49411a = str;
        }

        /* renamed from: A */
        public b m63169A(int i10) {
            this.f49416f = i10;
            return this;
        }

        /* renamed from: B */
        public b m63170B(String str) {
            this.f49415e = str;
            return this;
        }

        /* renamed from: s */
        public C10134e m63171s() {
            return new C10134e(this);
        }

        /* renamed from: t */
        public String m63172t() {
            return this.f49417g;
        }

        /* renamed from: u */
        public String m63173u() {
            return this.f49413c;
        }

        /* renamed from: v */
        public int m63174v() {
            return this.f49416f;
        }

        /* renamed from: w */
        public boolean m63175w() {
            int i10 = this.f49416f;
            return i10 >= 200 && i10 < 300;
        }

        /* renamed from: x */
        public b m63176x(String str) {
            this.f49417g = str;
            return this;
        }

        /* renamed from: y */
        public b m63177y(String str) {
            this.f49413c = str;
            return this;
        }

        /* renamed from: z */
        public b m63178z(int i10) {
            this.f49412b = i10;
            return this;
        }
    }

    /* renamed from: a */
    public void m63147a(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        try {
            sQLiteDatabase.execSQL("delete from t_slices_upload_status where id = ?", new Object[]{this.f49410a.f49411a});
        } catch (Exception e10) {
            C1120a.m6676e("SliceUploadStatus", "delete status error " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "delete status error " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public List<b> m63148b(SQLiteDatabase sQLiteDatabase) throws C9721b {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select id, num, object, synckey, time, status, data1, data2, data3 from t_slices_upload_status where id = ? order by num asc ", new String[]{this.f49410a.f49411a});
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    do {
                        b bVar = new b(this.f49410a.f49411a);
                        bVar.f49411a = cursorRawQuery.getString(0);
                        bVar.f49412b = cursorRawQuery.getInt(1);
                        bVar.f49413c = cursorRawQuery.getString(2);
                        bVar.f49414d = cursorRawQuery.getString(3);
                        bVar.f49415e = cursorRawQuery.getString(4);
                        bVar.f49416f = cursorRawQuery.getInt(5);
                        bVar.f49417g = cursorRawQuery.getString(6);
                        bVar.f49418h = cursorRawQuery.getString(7);
                        bVar.f49419i = cursorRawQuery.getString(8);
                        arrayList.add(bVar);
                    } while (cursorRawQuery.moveToNext());
                }
                return arrayList;
            } catch (Exception e10) {
                C1120a.m6676e("SliceUploadStatus", "query status error " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "query status error " + e10.getMessage());
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: c */
    public void m63149c(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        try {
            sQLiteDatabase.execSQL("replace into t_slices_upload_status(id, num, object, synckey, time, status, data1, data2, data3) values(?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{this.f49410a.f49411a, Integer.valueOf(this.f49410a.f49412b), this.f49410a.f49413c, this.f49410a.f49414d, this.f49410a.f49415e, Integer.valueOf(this.f49410a.f49416f), this.f49410a.f49417g, this.f49410a.f49418h, this.f49410a.f49419i});
        } catch (Exception e10) {
            C1120a.m6676e("SliceUploadStatus", "replace status error " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "replace status error " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public void m63150d(List<SliceObject> list, boolean z10, SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        if (z10) {
            m63147a(sQLiteDatabase);
        }
        List<b> listM63148b = m63148b(sQLiteDatabase);
        int i10 = 0;
        for (SliceObject sliceObject : list) {
            b bVar = new b(this.f49410a.f49411a);
            bVar.m63178z(i10).m63177y(sliceObject.getId()).m63170B(sliceObject.getModifiedTime().toString());
            if (!listM63148b.isEmpty() && i10 < listM63148b.size()) {
                b bVar2 = listM63148b.get(i10);
                if (bVar2.f49413c.equals(sliceObject.getId())) {
                    bVar.f49416f = bVar2.f49416f;
                    bVar.f49417g = bVar2.f49417g;
                }
            }
            i10++;
            bVar.m63171s().m63149c(sQLiteDatabase);
        }
    }

    public C10134e(b bVar) {
        this.f49410a = bVar;
    }
}
