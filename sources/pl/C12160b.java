package pl;

import android.database.Cursor;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;
import p744wl.C13617a;

/* renamed from: pl.b */
/* loaded from: classes6.dex */
public class C12160b extends AbstractC11478a<C12159a> {

    /* renamed from: a */
    public final String f56398a;

    /* renamed from: b */
    public final String f56399b;

    public C12160b(String str, String str2, int i10, int i11) {
        this(str, str2, i10, i11, false);
    }

    /* renamed from: a */
    private void m72930a() {
        try {
            m72931b();
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupDiffPacketMetaOperator", "create table error: " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public void m72931b() throws C9721b {
        execSQL("CREATE TABLE IF NOT EXISTS t_difference_packet (id INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT NOT NULL,root TEXT,name TEXT,type TEXT,app_id TEXT,hash1 TEXT,hash2 TEXT,status INTEGER NOT NULL DEFAULT 0,size INTEGER,file_id TEXT,assert_id TEXT,version_id TEXT,flag INTEGER,idex INTEGER,source_file TEXT,source_hash TEXT,backupid TEXT,isvalid INTEGER NOT NULL DEFAULT 0,cloud_size INTEGER,cloud_hash TEXT,cloud_encoded INTEGER,date_create INTEGER,date_modify INTEGER,date_invalid INTEGER,date_taken INTEGER,extend TEXT,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT,UNIQUE(data, root, app_id));");
        execSQL("CREATE INDEX IF NOT EXISTS idx_data ON t_difference_packet(data);");
    }

    public void batchReplace(List<C12159a> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        batch("replace into t_difference_packet(data,root,name,type,app_id,hash1,hash2,status,size,file_id,assert_id,version_id,flag,idex,source_file,source_hash,backupid,isvalid,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", list);
    }

    /* renamed from: c */
    public void m72932c(int i10) {
        try {
            delete("t_difference_packet", "isvalid = ?", new String[]{String.valueOf(i10)});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupDiffPacketMetaOperator", "queryByType error: " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public void m72933d(String str, String str2, String str3) throws C9721b {
        delete("t_difference_packet", "source_file = ? and app_id = ? and isvalid = ?", new String[]{str, str2, str3});
    }

    /* renamed from: e */
    public void m72934e(String str) throws C9721b {
        delete("t_difference_packet", "data = ? and app_id = ?", new String[]{str, this.f56399b});
    }

    @Override // ml.AbstractC11478a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C12159a c12159a) {
        return new String[]{c12159a.m72907j(), c12159a.m72867C(), c12159a.m72866B(), String.valueOf(c12159a.m72872H()), c12159a.m72894c(), c12159a.m72927x(), c12159a.m72928y(), String.valueOf(c12159a.m72871G()), String.valueOf(c12159a.m72868D()), c12159a.m72925v(), c12159a.m72896d(), c12159a.m72873I(), String.valueOf(c12159a.m72926w()), String.valueOf(c12159a.m72929z()), c12159a.m72869E(), c12159a.m72870F(), c12159a.m72898e(), String.valueOf(c12159a.m72865A()), String.valueOf(c12159a.m72904h()), c12159a.m72902g(), String.valueOf(c12159a.m72900f()), String.valueOf(c12159a.m72920q()), String.valueOf(c12159a.m72922s()), String.valueOf(c12159a.m72921r()), String.valueOf(c12159a.m72923t()), c12159a.m72924u(), c12159a.m72909k(), c12159a.m72911l(), c12159a.m72913m(), c12159a.m72915n(), c12159a.m72917o(), c12159a.m72919p()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C12159a getObject(Cursor cursor) {
        C12159a c12159a = new C12159a();
        c12159a.m72880P(cursor.getString(cursor.getColumnIndex("data")));
        c12159a.m72906i0(cursor.getString(cursor.getColumnIndex(SnapshotBackupMeta.DB_ROOT_NODE_APPID)));
        c12159a.m72905h0(cursor.getString(cursor.getColumnIndex("name")));
        c12159a.m72916n0(cursor.getLong(cursor.getColumnIndex("type")));
        c12159a.m72874J(cursor.getString(cursor.getColumnIndex("app_id")));
        c12159a.m72897d0(cursor.getString(cursor.getColumnIndex("hash1")));
        c12159a.m72899e0(cursor.getString(cursor.getColumnIndex("hash2")));
        c12159a.m72914m0(cursor.getInt(cursor.getColumnIndex("status")));
        c12159a.m72908j0(cursor.getLong(cursor.getColumnIndex("size")));
        c12159a.m72893b0(cursor.getString(cursor.getColumnIndex("file_id")));
        c12159a.m72875K(cursor.getString(cursor.getColumnIndex("assert_id")));
        c12159a.m72918o0(cursor.getString(cursor.getColumnIndex("version_id")));
        c12159a.m72895c0(cursor.getInt(cursor.getColumnIndex("flag")));
        c12159a.m72901f0(cursor.getInt(cursor.getColumnIndex("idex")));
        c12159a.m72910k0(cursor.getString(cursor.getColumnIndex("source_file")));
        c12159a.m72912l0(cursor.getString(cursor.getColumnIndex("source_hash")));
        c12159a.m72876L(cursor.getString(cursor.getColumnIndex("backupid")));
        c12159a.m72903g0(cursor.getInt(cursor.getColumnIndex("isvalid")));
        c12159a.m72879O(cursor.getLong(cursor.getColumnIndex("cloud_size")));
        c12159a.m72878N(cursor.getString(cursor.getColumnIndex("cloud_hash")));
        c12159a.m72877M(cursor.getLong(cursor.getColumnIndex("cloud_encoded")));
        c12159a.m72887W(cursor.getLong(cursor.getColumnIndex("date_create")));
        c12159a.m72889Y(cursor.getLong(cursor.getColumnIndex("date_modify")));
        c12159a.m72888X(cursor.getLong(cursor.getColumnIndex("date_invalid")));
        c12159a.m72890Z(cursor.getLong(cursor.getColumnIndex("date_taken")));
        c12159a.m72891a0(cursor.getString(cursor.getColumnIndex("extend")));
        c12159a.m72881Q(cursor.getString(cursor.getColumnIndex("data1")));
        c12159a.m72882R(cursor.getString(cursor.getColumnIndex("data2")));
        c12159a.m72883S(cursor.getString(cursor.getColumnIndex("data3")));
        c12159a.m72884T(cursor.getString(cursor.getColumnIndex("data4")));
        c12159a.m72885U(cursor.getString(cursor.getColumnIndex("data5")));
        c12159a.m72886V(cursor.getString(cursor.getColumnIndex("data6")));
        return c12159a;
    }

    /* renamed from: h */
    public boolean m72937h() {
        return isTableExist("t_difference_packet");
    }

    /* renamed from: i */
    public List<C12159a> m72938i() {
        ArrayList arrayList = new ArrayList();
        try {
            return query("select t_difference_packet.data,root,name,type,app_id,hash1,t_difference_packet.hash2,status,size,file_id,assert_id,version_id,flag,idex,source_file,source_hash,backupid,isvalid,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from t_difference_packet, (select data, hash2 from snapshot_data where type = 8) t where source_hash = t.hash2 and source_file = t.data and isvalid = 0", null);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupDiffPacketMetaOperator", "queryAll error: " + e10.getMessage());
            return arrayList;
        }
    }

    /* renamed from: j */
    public List<C12159a> m72939j(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            return query("select data,root,name,type,app_id,hash1,hash2,status,size,file_id,assert_id,version_id,flag,idex,source_file,source_hash,backupid,isvalid,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from t_difference_packet where source_file = ? and app_id = ? and isvalid = ?", new String[]{String.valueOf(str), String.valueOf(this.f56399b), String.valueOf(str2)});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupDiffPacketMetaOperator", "queryBySourceFile error: " + e10.getMessage());
            return arrayList;
        }
    }

    /* renamed from: k */
    public List<C12159a> m72940k(String str, String str2) {
        String[] strArr = {String.valueOf(str), String.valueOf(str2), String.valueOf(this.f56399b)};
        ArrayList arrayList = new ArrayList();
        try {
            return query("select data,root,name,type,app_id,hash1,hash2,status,size,file_id,assert_id,version_id,flag,idex,source_file,source_hash,backupid,isvalid,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from t_difference_packet where source_file = ? and source_hash = ? and app_id = ?", strArr);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupDiffPacketMetaOperator", "queryBySourceFileAndHash error: " + e10.getMessage());
            return arrayList;
        }
    }

    /* renamed from: l */
    public List<C12159a> m72941l(int i10) {
        String[] strArr = {String.valueOf(this.f56399b), String.valueOf(i10)};
        ArrayList arrayList = new ArrayList();
        try {
            return query("select data,root,name,type,app_id,hash1,hash2,status,size,file_id,assert_id,version_id,flag,idex,source_file,source_hash,backupid,isvalid,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from t_difference_packet where app_id = ? and type = ?", strArr);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupDiffPacketMetaOperator", "queryByType error: " + e10.getMessage());
            return arrayList;
        }
    }

    /* renamed from: m */
    public List<C12159a> m72942m(String str) throws C9721b {
        return query("select data,root,name,type,app_id,hash1,hash2,status,size,file_id,assert_id,version_id,flag,idex,source_file,source_hash,backupid,isvalid,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from t_difference_packet where app_id = ? and file_id = ?", new String[]{this.f56399b, str});
    }

    /* renamed from: n */
    public void m72943n(C12159a c12159a) throws C9721b {
        batchReplace(Collections.singletonList(c12159a));
    }

    /* renamed from: o */
    public void m72944o(String str) {
        try {
            execSQL("update t_difference_packet set isvalid = 1 where file_id = ?", new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupDiffPacketMetaOperator", "setInvalidByFileId error fileId = " + str + "error = " + e10.getMessage());
        }
    }

    public C12160b(String str, String str2, int i10, int i11, boolean z10) {
        super(C13216j.m79427l(C13216j.c.SNAPSHOT, C13617a.m81942x(str, str2, i10, i11)));
        this.f56398a = str;
        this.f56399b = str2;
        if (z10) {
            m72930a();
        }
    }
}
