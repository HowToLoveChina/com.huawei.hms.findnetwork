package p332ha;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import p031b7.C1120a;

/* renamed from: ha.b */
/* loaded from: classes3.dex */
public class C10131b {

    /* renamed from: a */
    public b f49379a;

    /* renamed from: ha.b$b */
    public static class b {

        /* renamed from: a */
        public String f49380a;

        /* renamed from: b */
        public String f49381b;

        /* renamed from: c */
        public long f49382c;

        /* renamed from: d */
        public String f49383d;

        /* renamed from: e */
        public String f49384e;

        /* renamed from: f */
        public String f49385f;

        /* renamed from: g */
        public long f49386g;

        /* renamed from: h */
        public long f49387h;

        /* renamed from: i */
        public String f49388i;

        /* renamed from: j */
        public String f49389j = "";

        /* renamed from: k */
        public String f49390k = "";

        /* renamed from: l */
        public int f49391l = EnumC10135f.DEFAULT.m63179b();

        /* renamed from: m */
        public String f49392m;

        /* renamed from: n */
        public String f49393n;

        /* renamed from: o */
        public String f49394o;

        /* renamed from: p */
        public String f49395p;

        /* renamed from: G */
        public C10131b m63090G() {
            return new C10131b(this);
        }

        /* renamed from: H */
        public String m63091H() {
            return this.f49388i;
        }

        /* renamed from: I */
        public String m63092I() {
            return this.f49393n;
        }

        /* renamed from: J */
        public String m63093J() {
            return this.f49394o;
        }

        /* renamed from: K */
        public String m63094K() {
            return this.f49390k;
        }

        /* renamed from: L */
        public String m63095L() {
            return this.f49389j;
        }

        /* renamed from: M */
        public b m63096M(String str) {
            this.f49388i = str;
            return this;
        }

        /* renamed from: N */
        public b m63097N(String str) {
            this.f49393n = str;
            return this;
        }

        /* renamed from: O */
        public b m63098O(String str) {
            this.f49394o = str;
            return this;
        }

        /* renamed from: P */
        public b m63099P(String str) {
            this.f49380a = str;
            return this;
        }

        /* renamed from: Q */
        public b m63100Q(String str) {
            this.f49390k = str;
            return this;
        }

        /* renamed from: R */
        public b m63101R(String str) {
            this.f49381b = str;
            return this;
        }

        /* renamed from: S */
        public b m63102S(long j10) {
            this.f49382c = j10;
            return this;
        }

        /* renamed from: T */
        public b m63103T(long j10) {
            this.f49386g = j10;
            return this;
        }

        /* renamed from: U */
        public b m63104U(String str) {
            this.f49389j = str;
            return this;
        }
    }

    /* renamed from: a */
    public void m63055a(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        try {
            sQLiteDatabase.execSQL("delete from t_asset_status where localID = ?", new Object[]{this.f49379a.f49380a});
        } catch (Exception e10) {
            C1120a.m6676e("AssetStatus", "delete status error " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "delete status error " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public void m63056b(SQLiteDatabase sQLiteDatabase) throws C9721b {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select localID, sha256, size, hmac, efek, iv, sliceSize, version, status, bucket, data1, data2, data3, assetID, versionId, mediaId from t_asset_status where localID = ?", new String[]{this.f49379a.f49380a});
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    do {
                        this.f49379a.f49380a = cursorRawQuery.getString(0);
                        this.f49379a.f49381b = cursorRawQuery.getString(1);
                        this.f49379a.f49382c = cursorRawQuery.getLong(2);
                        this.f49379a.f49383d = cursorRawQuery.getString(3);
                        this.f49379a.f49384e = cursorRawQuery.getString(4);
                        this.f49379a.f49385f = cursorRawQuery.getString(5);
                        this.f49379a.f49386g = cursorRawQuery.getLong(6);
                        this.f49379a.f49387h = cursorRawQuery.getLong(7);
                        this.f49379a.f49391l = cursorRawQuery.getInt(8);
                        this.f49379a.f49392m = cursorRawQuery.getString(9);
                        this.f49379a.f49393n = cursorRawQuery.getString(10);
                        this.f49379a.f49394o = cursorRawQuery.getString(11);
                        this.f49379a.f49395p = cursorRawQuery.getString(12);
                        this.f49379a.f49388i = cursorRawQuery.getString(13);
                        this.f49379a.f49389j = cursorRawQuery.getString(14);
                        this.f49379a.f49390k = cursorRawQuery.getString(15);
                    } while (cursorRawQuery.moveToNext());
                }
            } catch (Exception e10) {
                C1120a.m6676e("AssetStatus", "query status error " + e10.getMessage());
                throw new C9721b(4007, "query status error " + e10.getMessage());
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: c */
    public void m63057c(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        try {
            sQLiteDatabase.execSQL("replace into t_asset_status(localID, sha256, size, hmac, efek, iv, sliceSize, version, status, bucket, data1, data2, data3, assetID, versionId, mediaId) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{this.f49379a.f49380a, this.f49379a.f49381b, Long.valueOf(this.f49379a.f49382c), this.f49379a.f49383d, this.f49379a.f49384e, this.f49379a.f49385f, Long.valueOf(this.f49379a.f49386g), Long.valueOf(this.f49379a.f49387h), Integer.valueOf(this.f49379a.f49391l), this.f49379a.f49392m, this.f49379a.f49393n, this.f49379a.f49394o, this.f49379a.f49395p, this.f49379a.f49388i, this.f49379a.f49389j, this.f49379a.f49390k});
        } catch (Exception e10) {
            C1120a.m6676e("AssetStatus", "replace status error " + e10.getMessage());
            throw new C9721b(4007, "replace status error " + e10.getMessage());
        }
    }

    public C10131b(b bVar) {
        this.f49379a = bVar;
    }
}
