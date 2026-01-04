package pl;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.TarRefRatioDBScript;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotBackupMetaScript;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.messagecenter.richmessage.TextItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.network.embedded.C5846a3;
import fk.C9721b;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import ml.AbstractC11478a;
import p015ak.C0209d;
import p514o9.C11839m;
import p682ul.C13216j;
import p744wl.C13617a;
import p815ym.AbstractC14026a;
import p851zp.InterfaceC14354a;
import p851zp.InterfaceC14355b;

/* renamed from: pl.f */
/* loaded from: classes6.dex */
public class C12164f extends AbstractC11478a<C12161c> {

    /* renamed from: a */
    public String f56436a;

    /* renamed from: b */
    public String f56437b;

    /* renamed from: c */
    public int f56438c;

    public C12164f(String str, String str2, int i10, int i11) {
        super(C13216j.m79427l(C13216j.c.SNAPSHOT, C13617a.m81942x(str, str2, i10, i11)));
        this.f56436a = str;
        this.f56437b = str2;
        this.f56438c = i11;
    }

    /* renamed from: t */
    public static /* synthetic */ void m73023t(long j10, List list, String str) {
        list.add(new String[]{String.valueOf(j10), String.valueOf(str)});
    }

    /* renamed from: A */
    public long m73024A(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("SELECT count(DISTINCT file_id)  FROM snapshot_data  WHERE app_id = ?  AND flag = ?  AND file_id IS NOT NULL  AND file_id != '' AND status in (5,-5,6,-6) ;", new String[]{String.valueOf(str), String.valueOf(1)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: A0 */
    public void m73025A0(boolean z10) throws C9721b, SQLException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C13617a.m81941w());
        String str = File.separator;
        sb2.append(str);
        sb2.append("cloudbackup_status.db");
        attach(sb2.toString());
        try {
            try {
                if (z10) {
                    execSQL("UPDATE snapshot_data SET status = ?, cloud_path = '', file_id = '', assert_id = '', version_id = '', flag = ?, type = ?, hash1 = '', hash2 = '', cloud_hash = '', extend = '' WHERE type IN (0, 1, 2, 3, 6, 7, 8, 9)   AND status IN (?, ?)   AND app_id = ?   AND root != ?   AND ((file_id != ''       AND file_id IS NOT NULL       AND file_id = (         SELECT last.t_backup_lost_file_meta.file_id         FROM last.t_backup_lost_file_meta         WHERE snapshot_data.file_id = last.t_backup_lost_file_meta.file_id       ))     OR (cloud_path != ''       AND cloud_path IS NOT NULL       AND cloud_path = (         SELECT last.t_backup_lost_file_meta.cloud_path         FROM last.t_backup_lost_file_meta         WHERE snapshot_data.cloud_path = last.t_backup_lost_file_meta.cloud_path       )));", new String[]{String.valueOf(0), String.valueOf(0), String.valueOf(6), String.valueOf(5), String.valueOf(6), this.f56437b, ICBUtil.RELATIVE_SDATA_PATH + str});
                } else {
                    execSQL("UPDATE snapshot_data SET status = ?, cloud_path = '', file_id = '', assert_id = '', version_id = '', flag = ?, type = ?, hash1 = '', hash2 = '', cloud_hash = '', extend = '' WHERE type IN (0, 1, 2, 3, 6, 7, 8, 9)   AND status IN (?, ?)   AND app_id = ?   AND ((file_id != ''       AND file_id IS NOT NULL       AND file_id = (         SELECT last.t_backup_lost_file_meta.file_id         FROM last.t_backup_lost_file_meta         WHERE snapshot_data.file_id = last.t_backup_lost_file_meta.file_id       ))     OR (cloud_path != ''       AND cloud_path IS NOT NULL       AND cloud_path = (         SELECT last.t_backup_lost_file_meta.cloud_path         FROM last.t_backup_lost_file_meta         WHERE snapshot_data.cloud_path = last.t_backup_lost_file_meta.cloud_path       )));", new String[]{String.valueOf(0), String.valueOf(0), String.valueOf(6), String.valueOf(5), String.valueOf(6), this.f56437b});
                }
                detach();
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupMetaOperator", "updateFileInfoBySnapshot error." + e10.getMessage());
                throw e10;
            }
        } catch (Throwable th2) {
            detach();
            throw th2;
        }
    }

    /* renamed from: B */
    public int m73026B() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9)", new String[]{String.valueOf(this.f56437b)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: B0 */
    public void m73027B0(String str) {
        try {
            execSQL("update snapshot_data set flag = ? where file_id = ? and app_id = ?;", new String[]{String.valueOf(0), String.valueOf(str), String.valueOf(this.f56437b)});
        } catch (C9721b unused) {
            C11839m.m70687e("CloudBackupMetaOperator", "");
        }
    }

    /* renamed from: C */
    public long m73028C() {
        try {
            Cursor cursorRawQuery = rawQuery("select count(data4) from (select data4 from snapshot_data where type = ? and app_id = ? group by file_id||cloud_path);", new String[]{String.valueOf(7), this.f56437b});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupMetaOperator", "queryAllTarCount error: " + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: C0 */
    public void m73029C0(C12161c c12161c) throws C9721b {
        execSQL("update snapshot_data set status = ?, file_id = ?, assert_id = ?,version_id = ?, flag = ?, cloud_path = ?, data4 = ? where app_id = ? and cloud_path = ?;", new String[]{String.valueOf(c12161c.m72952H()), c12161c.m73009x(), c12161c.m72978e(), c12161c.m72954J(), String.valueOf(c12161c.m73010y()), "", c12161c.m72999p(), String.valueOf(this.f56437b), c12161c.m72984h()});
    }

    /* renamed from: D */
    public long m73030D() {
        Cursor cursorRawQuery;
        long j10 = 0;
        try {
            cursorRawQuery = rawQuery("select sum(data4) from (select data4 from snapshot_data where type = ? and app_id = ? and data4 is not null and data4 != '' group by file_id||cloud_path);", new String[]{String.valueOf(7), this.f56437b});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        j10 = cursorRawQuery.getLong(0);
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupMetaOperator", "query sum tar size has data4 error: " + e10.getMessage());
        }
        try {
            cursorRawQuery = rawQuery("select count(data4) from (select data4 from snapshot_data where type = ? and app_id = ? and (data4 is null or data4 = '') group by file_id||cloud_path);", new String[]{String.valueOf(7), this.f56437b});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j11 = cursorRawQuery.getLong(0);
                        C11839m.m70686d("CloudBackupMetaOperator", "query count tar count no data4 : " + j11);
                        j10 += j11 * RuleConfig.DEFAULT_TAR_SIZE;
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e11) {
            C11839m.m70689w("CloudBackupMetaOperator", "query count tar count no data4 error: " + e11.getMessage());
        }
        return j10;
    }

    /* renamed from: D0 */
    public void m73031D0(String str, long j10) throws C9721b {
        execSQL("update snapshot_data set status = ? where data = ?;", new String[]{String.valueOf(j10), String.valueOf(str)});
    }

    /* renamed from: E */
    public int m73032E() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(DISTINCT file_id||cloud_path) from snapshot_data where status = ? and type in (0,1,2,3,6,7,8,9) and app_id = ?;", new String[]{String.valueOf(4), String.valueOf(this.f56437b)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: E0 */
    public void m73033E0(String str, int i10) throws C9721b {
        execSQL("update snapshot_data set status = ? where app_id = ? and cloud_path = ?;", new String[]{String.valueOf(i10), String.valueOf(this.f56437b), str});
    }

    /* renamed from: F */
    public List<String> m73034F(String str) throws C9721b {
        String[] strArr = {String.valueOf(str), String.valueOf(0)};
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = rawQuery("SELECT DISTINCT (cloud_path)  FROM snapshot_data  WHERE app_id = ?  AND flag = ?  AND cloud_path IS NOT NULL  AND cloud_path != '';", strArr);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorRawQuery.getString(0));
                    } while (cursorRawQuery.moveToNext());
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return arrayList;
    }

    /* renamed from: F0 */
    public void m73035F0(String str, int i10) throws C9721b {
        execSQL("update snapshot_data set status = ? where app_id = ? and file_id = ?;", new String[]{String.valueOf(i10), String.valueOf(this.f56437b), String.valueOf(str)});
    }

    /* renamed from: G */
    public long m73036G() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and status not in (?,?,?) and type in (0,1,2,3,6,7,8,9);", new String[]{this.f56437b, String.valueOf(4), String.valueOf(5), String.valueOf(6)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: G0 */
    public void m73037G0(long j10) throws C9721b {
        execSQL("update snapshot_data set status = ?;", new String[]{String.valueOf(j10)});
    }

    /* renamed from: H */
    public int m73038H() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(DISTINCT file_id||cloud_path) from snapshot_data where status = ? and type in (0,1,2,3,6,7,8,9) and app_id = ?;", new String[]{String.valueOf(5), String.valueOf(this.f56437b)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: H0 */
    public void m73039H0(int i10, int i11) throws C9721b {
        execSQL("update snapshot_data set status = ?, data2 = '' where status = ?;", new String[]{String.valueOf(i11), String.valueOf(i10)});
    }

    /* renamed from: I */
    public List<String> m73040I(int i10) throws C9721b {
        String[] strArr = {String.valueOf(0), String.valueOf(i10)};
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = rawQuery("select distinct cloud_path from snapshot_data where type in (0,1,2,3,6,7,8,9) and flag = ? limit ?;", strArr);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorRawQuery.getString(0));
                    } while (cursorRawQuery.moveToNext());
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return arrayList;
    }

    /* renamed from: I0 */
    public void m73041I0() throws C9721b {
        execSQL("update snapshot_data set file_id = '' where file_id is null;");
        execSQL("update snapshot_data set cloud_path = '' where cloud_path is null;");
    }

    /* renamed from: J */
    public int m73042J(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("SELECT count(*) from snapshot_data INNER JOIN t_asset_status ON snapshot_data.hash2=t_asset_status.hash2 and snapshot_data.assert_id=t_asset_status.assetId where t_asset_status.data3 !='' and t_asset_status.data3 like ?", new String[]{"%" + str + "%"});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = (int) cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: J0 */
    public void m73043J0(int i10, int i11) throws C9721b {
        execSQL("update snapshot_data set status = ? where status = ?;", new String[]{String.valueOf(i11), String.valueOf(i10)});
    }

    /* renamed from: K */
    public long m73044K() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where type in (0,1,2,3,6,7,8,9) and app_id = ? and root = ?;", new String[]{this.f56437b, ICBUtil.RELATIVE_SDATA_PATH + File.separator});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: K0 */
    public void m73045K0(C12161c c12161c, String str) throws C9721b {
        execSQL("update snapshot_data set status = ?, type = ?, hash1 = ? , hash2 = ? , cloud_hash = ? , cloud_path = ? where data = ? and root = ? and app_id = ?;", new String[]{String.valueOf(c12161c.m72952H()), String.valueOf(c12161c.m72953I()), c12161c.m72945A(), c12161c.m72946B(), c12161c.m72982g(), str, c12161c.m72991l(), c12161c.m72950F(), this.f56437b});
    }

    /* renamed from: L */
    public long[] m73046L(int i10) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*), sum(size) from snapshot_data where app_id = ? and type = ? and status = 2;", new String[]{this.f56437b, String.valueOf(i10)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long[] jArr = {cursorRawQuery.getLong(0), cursorRawQuery.getLong(1)};
                    cursorRawQuery.close();
                    return jArr;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "restore metadata count error.", "queryDone");
    }

    /* renamed from: L0 */
    public final void m73047L0(boolean z10, double d10, double d11) throws C9721b {
        C11839m.m70688i("CloudBackupMetaOperator", "resetMetaBackupStatus start pmsCopyUploadDone: " + z10);
        String[] strArr = new String[11];
        strArr[0] = String.valueOf(0);
        strArr[1] = String.valueOf(0);
        strArr[2] = String.valueOf(7);
        strArr[3] = "";
        if (z10) {
            strArr[3] = ICBUtil.RELATIVE_SDATA_PATH + File.separator;
        }
        strArr[4] = String.valueOf(5);
        strArr[5] = String.valueOf(6);
        strArr[6] = String.valueOf(7);
        strArr[7] = String.valueOf(d10);
        strArr[8] = String.valueOf(0);
        strArr[9] = String.valueOf(d11);
        strArr[10] = String.valueOf(1);
        execSQL(String.format(Locale.ENGLISH, "UPDATE %1$s SET status = ?,          cloud_path = '',file_id = '', assert_id = '', version_id = '', flag = ?, type = ?, hash1 = '', hash2 = '', cloud_hash = '', extend = '', data4 = '' WHERE root != ?         AND status in(?,?)         AND type = ?         AND EXISTS      (SELECT tar_ref_ratio     FROM %2$s     WHERE ((%2$s.tar_ref_ratio < ?             AND %2$s.is_new_tar = ?)             OR (%2$s.tar_ref_ratio < ?             AND %2$s.is_new_tar = ?))             AND %1$s.file_id||cloud_path = %2$s.file_id);", SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), strArr);
    }

    /* renamed from: M */
    public int m73048M(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("SELECT count(DISTINCT file_id)  FROM snapshot_data  WHERE app_id = ?  AND flag = ?  AND file_id IS NOT NULL  AND file_id != '';", new String[]{str, String.valueOf(1)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: M0 */
    public void m73049M0(String str) throws C9721b {
        if (TextUtils.isEmpty(this.f56436a) || TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudBackupMetaOperator", "updateV2SameMetasByV3 error, recordId or appId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV2SameMetasByV3 error, recordId or appId is null.");
        }
        execSQL("update snapshot_data set data3 = 1 where type in (0,1,2,3,6,7,8,9) and app_id = ?;", new String[]{str});
    }

    /* renamed from: N */
    public long m73050N() {
        try {
            Cursor cursorRawQuery = rawQuery("select count(file_id) from snapshot_data where type in (6,7,8,9) and app_id = ? and status < 5;", new String[]{this.f56437b});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupMetaOperator", "fileStatusAbnormalNum error: " + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: N0 */
    public void m73051N0() throws C9721b {
        if (TextUtils.isEmpty(this.f56436a) || TextUtils.isEmpty(this.f56437b)) {
            C11839m.m70687e("CloudBackupMetaOperator", "updateV3SnapshotMetaCache error, recordId or appId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV3SnapshotMetaCache error, recordId or appId is null.");
        }
        String[] strArr = {this.f56437b};
        execSQL("update snapshot_data set (status,cloud_path,type) = (select 6, lb.cloud_path, lb.type from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.hash1 = lb.hash1) and (snapshot_data.app_id = lb.app_id))where exists (select * from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.hash1 = lb.hash1) and (snapshot_data.app_id = ?) and (snapshot_data.hash2 != '') and (snapshot_data.hash2 is not null) and (snapshot_data.app_id = lb.app_id) and (snapshot_data.status in (0,1,2,3)) and (snapshot_data.flag not in (1)) and (snapshot_data.type in (0,1,2,3,6,7,8,9)))", strArr);
        execSQL("update snapshot_data set (status,cloud_path,type,hash1,hash2,cloud_hash,extend) = (select 6, lb.cloud_path,lb.type, lb.hash1, lb.hash2, lb.cloud_hash, lb.extend from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.date_modify = lb.date_invalid) and (snapshot_data.size = lb.size) and (snapshot_data.app_id = lb.app_id))where exists (select * from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.date_modify = lb.date_invalid) and (snapshot_data.size = lb.size) and (snapshot_data.app_id = ?) and (snapshot_data.app_id = lb.app_id) and (snapshot_data.flag not in (1)) and (snapshot_data.status in (0,1,2,3)) and (snapshot_data.type in (0,1,2,3,6,7,8,9)))", strArr);
        execSQL("update snapshot_data set (status,cloud_path,type,hash1,hash2,cloud_hash,extend) = (select 6, lb.cloud_path, lb.type, lb.hash1, lb.hash2, lb.cloud_hash, lb.extend from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.date_modify = lb.date_modify) and (snapshot_data.size = lb.size) and (snapshot_data.app_id = lb.app_id))where exists (select * from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.date_modify = lb.date_modify) and (snapshot_data.size = lb.size) and (snapshot_data.app_id = ?) and (snapshot_data.app_id = lb.app_id) and (snapshot_data.flag not in (1)) and (snapshot_data.status in (0,1,2,3)) and (snapshot_data.type in (0,1,2,3,6,7,8,9)))", strArr);
    }

    /* renamed from: O */
    public C12161c m73052O() throws C9721b {
        List<C12161c> listQuery = query("select id,data,root,name,type,left,right,app_id,app_name,hash1,hash2,status,size,count,cloud_path,file_id,assert_id,version_id,flag,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from snapshot_data where app_id = ? and name = 'gallery.db';", new String[]{this.f56437b});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    /* renamed from: O0 */
    public void m73053O0() throws C9721b {
        if (isTableExist("t_recovery_meta_info")) {
            try {
                execSQL("REPLACE INTO t_recovery_meta_info (file_id, app_id, cipher, fek_mac, hash1, hash2, assert_id, version_id, data1, data2, data3, data4, data5, data6) SELECT last_t.file_id, last_t.app_id, last_t.cipher, last_t.fek_mac, last_t.hash1  , last_t.hash2, last_t.assert_id, last_t.version_id, last_t.data1, last_t.data2  , last_t.data3, last_t.data4, last_t.data5, last_t.data6  FROM last.t_recovery_meta_info as last_t ");
            } catch (C9721b e10) {
                C11839m.m70689w("CloudBackupMetaOperator", "updateV3RecoveryMetaCache error: " + e10.getMessage());
            }
        }
    }

    /* renamed from: P */
    public int m73054P() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and root = ? and type in (0,1,2,3,6,7,8,9);", new String[]{this.f56437b, "/sdata/"});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = (int) cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: P0 */
    public void m73055P0(String str) throws C9721b {
        if (TextUtils.isEmpty(this.f56436a) || TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudBackupMetaOperator", "updateV3SameMetasByV3 error, recordId or appId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV3SameMetasByOldRecord error, recordId or appId is null.");
        }
        try {
            execSQL("update snapshot_data set data3 = 1 where type in (6,7,8,9) and cloud_path is not null and cloud_path != '' and cloud_path in (select cloud_path from last.snapshot_data where last.snapshot_data.cloud_path = snapshot_data.cloud_path and last.snapshot_data.app_id = snapshot_data.app_id and snapshot_data.app_id = ?);", new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupMetaOperator", "updateV3SameMetasByOldRecord snaptshot meta error." + e10.getMessage());
            throw e10;
        }
    }

    /* renamed from: Q */
    public int m73056Q() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9) and status not in (?,?,?) and root = ?", new String[]{this.f56437b, String.valueOf(4), String.valueOf(5), String.valueOf(6), "/sdata/"});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = (int) cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: Q0 */
    public void m73057Q0(String str) throws C9721b {
        if (TextUtils.isEmpty(this.f56436a) || TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudBackupMetaOperator", "updateV3SameMetasByV3 error, recordId or appId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV3SameMetasByV3 error, recordId or appId is null.");
        }
        try {
            String[] strArr = {str};
            execSQL("update snapshot_data set data3 = 1 where type in (6,7,8,9) and cloud_path is not null and cloud_path != '' and cloud_path in (select cloud_path from last.snapshot_data where last.snapshot_data.cloud_path = snapshot_data.cloud_path and last.snapshot_data.app_id = snapshot_data.app_id and snapshot_data.app_id = ?);", strArr);
            execSQL("update snapshot_data set data3 = 1 where type in (6,7,8,9) and file_id is not null and file_id != '' and file_id in (select DISTINCT file_id from last.snapshot_data where last.snapshot_data.app_id = ?);", strArr);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupMetaOperator", "updateV3SameMetasByV3 snaptshot meta error." + e10.getMessage());
            throw e10;
        }
    }

    /* renamed from: R */
    public long m73058R() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and status not in (?,?,?) and root = ? and type in (0,1,2,3,6,7,8,9);", new String[]{this.f56437b, String.valueOf(4), String.valueOf(5), String.valueOf(6), "/sdata/"});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: R0 */
    public void m73059R0(boolean z10) throws C9721b {
        if (TextUtils.isEmpty(this.f56436a) || TextUtils.isEmpty(this.f56437b)) {
            C11839m.m70687e("CloudBackupMetaOperator", "updateV3SnapshotMetaCache error, recordId or appId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV3SnapshotMetaCache error, recordId or appId is null.");
        }
        String[] strArr = {this.f56437b};
        if (!z10) {
            execSQL("update snapshot_data set (status,cloud_path,file_id,assert_id,version_id,flag,type,data4) = (select lb.status, lb.cloud_path,lb.file_id,lb.assert_id,lb.version_id,lb.flag,lb.type,lb.data4 from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.hash2 = lb.hash2) and (snapshot_data.app_id = lb.app_id))where exists (select * from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.hash2 = lb.hash2) and (snapshot_data.app_id = ?) and (snapshot_data.app_id = lb.app_id) and (snapshot_data.status in (0,1,2,3)) and (lb.cloud_path != '') and (lb.cloud_path is not null) and (lb.hash2 != '') and (lb.hash2 is not null) and (lb.file_id = '' or lb.file_id is null) and (lb.flag = 0) and (snapshot_data.type in (0,1,2,3,6,7,8,9)))", strArr);
        }
        execSQL("update snapshot_data set (status,cloud_path,file_id,assert_id,version_id,flag,type,data4) = (select lb.status, lb.cloud_path,lb.file_id,lb.assert_id,lb.version_id,lb.flag,lb.type,lb.data4 from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.hash2 = lb.hash2) and (snapshot_data.app_id = lb.app_id))where exists (select * from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.hash2 = lb.hash2) and (snapshot_data.app_id = ?) and (snapshot_data.app_id = lb.app_id) and (snapshot_data.status in (0,1,2,3)) and (lb.file_id != '') and (lb.file_id is not null) and (lb.assert_id != '') and (lb.assert_id is not null) and (lb.version_id != '') and (lb.version_id is not null) and (lb.hash2 != '') and (lb.hash2 is not null) and (lb.cloud_path = '' or lb.cloud_path is null) and (lb.flag = 1) and (snapshot_data.type in (0,1,2,3,6,7,8,9)))", strArr);
        if (!z10) {
            execSQL("update snapshot_data set (status,cloud_path,file_id,assert_id,version_id,flag,type,hash1,hash2,cloud_hash,extend,data4) = (select lb.status, lb.cloud_path,lb.file_id,lb.assert_id,lb.version_id,lb.flag, lb.type, lb.hash1, lb.hash2, lb.cloud_hash, lb.extend, lb.data4 from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.date_modify = lb.date_modify) and (snapshot_data.size = lb.size) and (snapshot_data.app_id = lb.app_id))where exists (select * from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.date_modify = lb.date_modify) and (snapshot_data.size = lb.size) and (snapshot_data.app_id = ?) and (snapshot_data.app_id = lb.app_id) and (lb.cloud_path != '') and (lb.cloud_path is not null) and (lb.file_id = '' or lb.file_id is null) and (lb.flag = 0) and (snapshot_data.status in (0,1,2,3)) and (snapshot_data.type in (0,1,2,3,6,7,8,9)))", strArr);
        }
        execSQL("update snapshot_data set (status,cloud_path,file_id,assert_id,version_id,flag,type,hash1,hash2,cloud_hash,extend,data4) = (select lb.status, lb.cloud_path,lb.file_id,lb.assert_id,lb.version_id,lb.flag, lb.type, lb.hash1, lb.hash2, lb.cloud_hash, lb.extend, lb.data4 from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.date_modify = lb.date_modify) and (snapshot_data.size = lb.size) and (snapshot_data.app_id = lb.app_id))where exists (select * from last.snapshot_data lb where (snapshot_data.data = lb.data) and (snapshot_data.date_modify = lb.date_modify) and (snapshot_data.size = lb.size) and (snapshot_data.app_id = ?) and (snapshot_data.app_id = lb.app_id) and (snapshot_data.cloud_path = '' or snapshot_data.cloud_path is null) and (lb.file_id != '') and (lb.file_id is not null) and (lb.assert_id != '') and (lb.assert_id is not null) and (lb.version_id != '') and (lb.version_id is not null) and (lb.cloud_path = '' or lb.cloud_path is null) and (lb.flag = 1) and (snapshot_data.status in (0,1,2,3)) and (snapshot_data.type in (0,1,2,3,6,7,8,9)))", strArr);
    }

    /* renamed from: S */
    public long m73060S() {
        try {
            Cursor cursorRawQuery = rawQuery("SELECT count(id) AS result  FROM snapshot_data  WHERE cloud_path IS NOT NULL  AND cloud_path != ''  AND type = ?  AND flag = ?  GROUP BY cloud_path  ORDER BY result desc", new String[]{String.valueOf(7), String.valueOf(0)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return 0L;
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupMetaOperator", "queryMaxCloudpathTarFileCount" + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: T */
    public long m73061T() {
        try {
            Cursor cursorRawQuery = rawQuery("select MAX(size) from snapshot_data where app_id = ? and root = ? and type in (0,1,2,3,6,7,8,9);", new String[]{this.f56437b, ICBUtil.RELATIVE_SDATA_PATH + File.separator});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupMetaOperator", "queryMaxDataFileSize error: " + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: U */
    public long m73062U() {
        try {
            Cursor cursorRawQuery = rawQuery("SELECT count(id) AS result  FROM snapshot_data  WHERE file_id IS NOT NULL  AND file_id != ''  AND type = ?  AND flag = ?  GROUP BY file_id  ORDER BY result desc", new String[]{String.valueOf(7), String.valueOf(1)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return 0L;
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupMetaOperator", "queryMaxDmTarFileCount" + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: V */
    public C12161c m73063V(String str, String str2) throws C9721b {
        List<C12161c> listQuery = query("select id,data,root,name,type,left,right,app_id,app_name,hash1,hash2,status,size,count,cloud_path,file_id,assert_id,version_id,flag,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from snapshot_data where type in (0,1,2,3,6,7,8,9) and app_id = ? and data = ? and root = ?;", new String[]{this.f56437b, str, str2});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    /* renamed from: W */
    public C12161c m73064W(String str, String str2) throws C9721b {
        List<C12161c> listQuery;
        try {
            listQuery = query("select id,data,root,name,type,left,right,app_id,app_name,hash1,hash2,status,size,count,cloud_path,file_id,assert_id,version_id,flag,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from snapshot_data where type in (0,1,2,3,6,7,8,9) and app_id = ? and data = ? and cloud_hash = ?;", new String[]{this.f56437b, str2, str});
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupMetaOperator", "queryMetaByHashAndData" + e10.getMessage());
            listQuery = null;
        }
        if (AbstractC14026a.m84159a(listQuery)) {
            return null;
        }
        return listQuery.get(0);
    }

    /* renamed from: X */
    public long m73065X(int i10) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9) and flag = ?", new String[]{String.valueOf(this.f56437b), String.valueOf(i10)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: Y */
    public List<C12161c> m73066Y(long j10, long j11) throws C9721b {
        return query("select id,data,root,name,type,left,right,app_id,app_name,hash1,hash2,status,size,count,cloud_path,file_id,assert_id,version_id,flag,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from snapshot_data where type in (0,1,2,3,6,7,8,9) and app_id = ? order by id limit ? offset ?;", new String[]{this.f56437b, String.valueOf(j10), String.valueOf(j11)});
    }

    /* renamed from: Z */
    public List<C12161c> m73067Z(String str, String str2) {
        try {
            return query("select id,data,root,name,type,left,right,app_id,app_name,hash1,hash2,status,size,count,cloud_path,file_id,assert_id,version_id,flag,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from snapshot_data where app_id = ? and name = ? and data = ?;", new String[]{this.f56437b, str, str2});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupMetaOperator", "queryMetasByName Exception " + e10.getMessage());
            return Collections.emptyList();
        }
    }

    /* renamed from: a0 */
    public List<C12161c> m73068a0(int i10) throws C9721b {
        return query("select id,data,root,name,type,left,right,app_id,app_name,hash1,hash2,status,size,count,cloud_path,file_id,assert_id,version_id,flag,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from snapshot_data where app_id = ? and type = ?;", new String[]{this.f56437b, String.valueOf(i10)});
    }

    /* renamed from: b */
    public void m73069b(String str) throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.f56436a) || TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudBackupMetaOperator", "attachHistorySnapshotDB error, recordId or backupId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "attachHistorySnapshotDB error, recordId is null.");
        }
        attach(str);
    }

    /* renamed from: b0 */
    public long m73070b0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9)", new String[]{String.valueOf(this.f56437b)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    public void batchReplace(List<C12161c> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        batch("replace into snapshot_data(data,root,name,type,left,right,app_id,app_name,hash1,hash2,status,size,count,cloud_path,file_id,assert_id,version_id,flag,cloud_size,cloud_hash,cloud_encoded,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", list);
    }

    /* renamed from: c */
    public final void m73071c(String str) throws C9721b {
        try {
            execSQL("attach database ? as userdata", new String[]{str});
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupMetaOperator", "attachV4Db error." + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "attachV4Db error. " + e10.getMessage());
        }
    }

    /* renamed from: c0 */
    public long m73072c0() throws C9721b {
        try {
            Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9) and status in (?,?,?)", new String[]{this.f56437b, String.valueOf(5), String.valueOf(6), String.valueOf(-5)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
        } catch (Exception e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryMkfileFileSize error." + e10.getMessage());
        }
    }

    public void clear() {
        try {
            delete(SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, null, null);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupMetaOperator", "clear restore status error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public long m73073d(String str, long j10, InterfaceC14355b interfaceC14355b, InterfaceC14354a<String> interfaceC14354a) throws C9721b {
        String[] strArr = {String.valueOf(str), String.valueOf(1)};
        StringBuilder sb2 = new StringBuilder();
        Cursor cursorRawQuery = rawQuery("SELECT DISTINCT (file_id)  FROM snapshot_data  WHERE app_id = ?  AND flag = ?  AND file_id IS NOT NULL  AND file_id != '' AND status in (5,-5,6,-6);", strArr);
        long j11 = 0;
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = 0;
                    do {
                        j11++;
                        String string = cursorRawQuery.getString(0);
                        interfaceC14355b.execute();
                        long jM1239c = C0209d.m1239c(string);
                        long j12 = 1 + jM1239c;
                        if (i10 + j12 > j10 && sb2.length() > 0) {
                            interfaceC14354a.apply(sb2.toString());
                            sb2.setLength(0);
                            i10 = 0;
                        }
                        if (sb2.length() == 0) {
                            sb2.append(string);
                            i10 = (int) (i10 + jM1239c);
                        } else {
                            sb2.append(',');
                            sb2.append(string);
                            i10 = (int) (i10 + j12);
                        }
                    } while (cursorRawQuery.moveToNext());
                    if (sb2.length() > 0) {
                        interfaceC14354a.apply(sb2.toString());
                    }
                    cursorRawQuery.close();
                    return j11;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery == null) {
                    throw th2;
                }
                try {
                    cursorRawQuery.close();
                    throw th2;
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                    throw th2;
                }
            }
        }
        C11839m.m70689w("CloudBackupMetaOperator", "batchQueryAllIncreasesFileIds cursor == null || !cursor.moveToFirst()");
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0L;
    }

    /* renamed from: d0 */
    public long m73074d0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9) and status not in (?,?)", new String[]{this.f56437b, String.valueOf(5), String.valueOf(6)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: e */
    public void m73075e(List<String[]> list) throws C9721b {
        if (list.size() <= 0) {
            C11839m.m70688i("CloudBackupMetaOperator", "batchUpdateMetaStatus bindArgsList is empty");
        } else {
            execute("update snapshot_data set status = ? where data = ? and root = ?;", list);
        }
    }

    /* renamed from: e0 */
    public long m73076e0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and data like ? and type in (0,1,2,3,6,7,8,9);", new String[]{this.f56437b, "data/storage%"});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: f */
    public void m73077f(List<String> list, final long j10) throws C9721b {
        final ArrayList arrayList = new ArrayList();
        list.forEach(new Consumer() { // from class: pl.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C12164f.m73023t(j10, arrayList, (String) obj);
            }
        });
        execute("update snapshot_data set status = ? where data = ?;", arrayList);
    }

    /* renamed from: f0 */
    public long m73078f0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(id) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9) and status != ?;", new String[]{this.f56437b, String.valueOf(0)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: g */
    public void m73079g(List<String[]> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        execute("update snapshot_data set cloud_path = '', file_id = ?, assert_id = ?, version_id = ?, flag = ? where cloud_path = ?;", list);
    }

    /* renamed from: g0 */
    public int m73080g0(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where type in (6,7,8,9) and app_id = ? and data != ?;", new String[]{this.f56437b, str});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: h */
    public void m73081h(boolean z10, double d10, double d11) throws C9721b {
        drop(AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE);
        createCaclTarRefRatioTable();
        m73113x0(z10);
        tarRateCaclExecute();
        m73047L0(z10, d10, d11);
    }

    /* renamed from: h0 */
    public int m73082h0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and root = ? and type in (0,1,2,3,6,7,8,9);", new String[]{this.f56437b, "/sdata/"});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = (int) cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: i */
    public void m73083i() throws C9721b {
        execSQL("update snapshot_data set data2 = ? where data2 = 'delete';", new String[]{""});
    }

    /* renamed from: i0 */
    public long m73084i0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and root = ? and type in (0,1,2,3,6,7,8,9);", new String[]{this.f56437b, "/sdata/"});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: j */
    public void m73085j(String str) throws C9721b {
        execSQL("delete from snapshot_data where app_id = ? and data = ?;", new String[]{this.f56437b, str});
    }

    /* renamed from: j0 */
    public long m73086j0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where type in (0,1,2,3,6,7,8,9) and app_id = ? and root != ?;", new String[]{this.f56437b, ICBUtil.RELATIVE_SDATA_PATH + File.separator});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: k */
    public void m73087k(String str, String str2, String str3) throws C9721b {
        execSQL("delete from snapshot_data where app_id = ? and data = ? and hash1 = ? and hash2 = ?;", new String[]{this.f56437b, str, str2, str3});
    }

    /* renamed from: k0 */
    public long m73088k0(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and status = ? and type in (0,1,2,3,6,7,8,9);", new String[]{this.f56437b, str});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: l */
    public void m73089l(String str) throws C9721b {
        execSQL("delete from snapshot_data where app_id = ? and root = ?;", new String[]{this.f56437b, str});
    }

    /* renamed from: l0 */
    public long m73090l0(int i10, String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and type = ? and cloud_path = ?;", new String[]{this.f56437b, String.valueOf(i10), str});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: m */
    public void m73091m(String str) throws C9721b {
        execSQL("delete from snapshot_data where app_id = ? and data2 = 'delete';", new String[]{str});
    }

    /* renamed from: m0 */
    public long m73092m0(int i10, String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and type = ? and file_id = ?;", new String[]{this.f56437b, String.valueOf(i10), str});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: n */
    public void m73093n() throws C9721b {
        execSQL("delete from snapshot_data where app_id = ? and root != ? and type != 4;", new String[]{this.f56437b, ICBUtil.RELATIVE_SDATA_PATH + File.separator});
    }

    /* renamed from: n0 */
    public long m73094n0() {
        try {
            Cursor cursorRawQuery = rawQuery("SELECT   SUM( asset.length )  FROM   ( SELECT DISTINCT file_id FROM snapshot_data WHERE type IN ( 0, 1, 2, 3, 6, 7, 8, 9 ) ) AS snapshot   INNER JOIN ( SELECT recordId, length FROM t_asset_status GROUP BY recordId ) AS asset ON snapshot.file_id = asset.recordId", null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return 0L;
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupMetaOperator", "querySnapshotJoinAssetMetaSumSize error: " + e10);
            return 0L;
        }
    }

    /* renamed from: o */
    public final void m73095o() throws C9721b {
        try {
            execSQL("detach database userdata");
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupMetaOperator", "detachV4Db error." + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "detachV4Db error. " + e10.getMessage());
        }
    }

    /* renamed from: o0 */
    public long m73096o0(String str, String str2) throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and cloud_path = ?;", new String[]{this.f56437b, str2});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: p */
    public boolean m73097p() {
        return isTableExist("t_recovery_meta_info");
    }

    /* renamed from: p0 */
    public long m73098p0() {
        try {
            Cursor cursorRawQuery = rawQuery("select count(*) from t_del where app_id = ?", new String[]{String.valueOf(this.f56437b)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
        } catch (Exception e10) {
            C11839m.m70688i("CloudBackupMetaOperator", "queryTempDelCount Exception " + e10.getMessage());
            return 0L;
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C12161c c12161c) {
        return new String[]{c12161c.m72991l(), c12161c.m72950F(), c12161c.m72948D(), String.valueOf(c12161c.m72953I()), String.valueOf(c12161c.m72947C()), String.valueOf(c12161c.m72949E()), c12161c.m72974c(), c12161c.m72976d(), c12161c.m72945A(), c12161c.m72946B(), String.valueOf(c12161c.m72952H()), String.valueOf(c12161c.m72951G()), String.valueOf(c12161c.m72989k()), c12161c.m72984h(), c12161c.m73009x(), c12161c.m72978e(), c12161c.m72954J(), String.valueOf(c12161c.m73010y()), String.valueOf(c12161c.m72987j()), c12161c.m72982g(), String.valueOf(c12161c.m72980f()), String.valueOf(c12161c.m73004s()), String.valueOf(c12161c.m73006u()), String.valueOf(c12161c.m73005t()), String.valueOf(c12161c.m73007v()), c12161c.m73008w(), c12161c.m72993m(), c12161c.m72995n(), c12161c.m72997o(), c12161c.m72999p(), c12161c.m73001q(), c12161c.m73003r()};
    }

    /* renamed from: q0 */
    public long m73100q0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9) and status not in (?,?,?)", new String[]{this.f56437b, String.valueOf(4), String.valueOf(5), String.valueOf(6)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    public int queryCount() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ?;", new String[]{this.f56437b});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    public long querySumFreeSizeByRatio(double d10, double d11) {
        long j10 = 0;
        if (!isTableExist(AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE)) {
            return 0L;
        }
        try {
            Cursor cursorRawQuery = rawQuery(String.format(Locale.ENGLISH, TarRefRatioDBScript.SUM_FREE_SIZE_BY_RATIO, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(0), String.valueOf(d10), String.valueOf(1), String.valueOf(d11)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        j10 = cursorRawQuery.getLong(0);
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupMetaOperator", "queryTarRefRatioByFileId error: " + e10);
        }
        return j10;
    }

    public List<Double> queryTarRefRatioByLimit(int i10) {
        ArrayList arrayList = new ArrayList();
        if (isTableExist(AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE)) {
            try {
                Cursor cursorRawQuery = rawQuery(String.format(Locale.ENGLISH, "select tar_ref_ratio from %1$s limit ?;", AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(i10)});
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.moveToFirst()) {
                            do {
                                arrayList.add(Double.valueOf(new BigDecimal(cursorRawQuery.getDouble(0)).setScale(4, 4).doubleValue()));
                            } while (cursorRawQuery.moveToNext());
                        }
                    } finally {
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupMetaOperator", "queryInvalidUploadMeta error: " + e10.toString());
            }
        }
        return arrayList;
    }

    @Override // ml.AbstractC11478a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C12161c getObject(Cursor cursor) {
        C12161c c12161c = new C12161c();
        c12161c.m72964T(cursor.getString(cursor.getColumnIndex("data")));
        c12161c.m72994m0(cursor.getString(cursor.getColumnIndex(SnapshotBackupMeta.DB_ROOT_NODE_APPID)));
        c12161c.m72990k0(cursor.getString(cursor.getColumnIndex("name")));
        c12161c.m73000p0(cursor.getLong(cursor.getColumnIndex("type")));
        c12161c.m72988j0(cursor.getLong(cursor.getColumnIndex("left")));
        c12161c.m72992l0(cursor.getLong(cursor.getColumnIndex(TextItem.RIGHT)));
        c12161c.m72956L(cursor.getString(cursor.getColumnIndex("app_id")));
        c12161c.m72957M(cursor.getString(cursor.getColumnIndex(C5846a3.APP_NAME)));
        c12161c.m72985h0(cursor.getString(cursor.getColumnIndex("hash1")));
        c12161c.m72986i0(cursor.getString(cursor.getColumnIndex("hash2")));
        c12161c.m72998o0(cursor.getInt(cursor.getColumnIndex("status")));
        c12161c.m72996n0(cursor.getLong(cursor.getColumnIndex("size")));
        c12161c.m72963S(cursor.getLong(cursor.getColumnIndex("count")));
        c12161c.m72961Q(cursor.getString(cursor.getColumnIndex("cloud_path")));
        c12161c.m72981f0(cursor.getString(cursor.getColumnIndex("file_id")));
        c12161c.m72958N(cursor.getString(cursor.getColumnIndex("assert_id")));
        c12161c.m73002q0(cursor.getString(cursor.getColumnIndex("version_id")));
        c12161c.m72983g0(cursor.getInt(cursor.getColumnIndex("flag")));
        c12161c.m72962R(cursor.getLong(cursor.getColumnIndex("cloud_size")));
        c12161c.m72960P(cursor.getString(cursor.getColumnIndex("cloud_hash")));
        c12161c.m72959O(cursor.getLong(cursor.getColumnIndex("cloud_encoded")));
        c12161c.m72971a0(cursor.getLong(cursor.getColumnIndex("date_create")));
        c12161c.m72975c0(cursor.getLong(cursor.getColumnIndex("date_modify")));
        c12161c.m72973b0(cursor.getLong(cursor.getColumnIndex("date_invalid")));
        c12161c.m72977d0(cursor.getLong(cursor.getColumnIndex("date_taken")));
        c12161c.m72979e0(cursor.getString(cursor.getColumnIndex("extend")));
        c12161c.m72965U(cursor.getString(cursor.getColumnIndex("data1")));
        c12161c.m72966V(cursor.getString(cursor.getColumnIndex("data2")));
        c12161c.m72967W(cursor.getString(cursor.getColumnIndex("data3")));
        c12161c.m72968X(cursor.getString(cursor.getColumnIndex("data4")));
        c12161c.m72969Y(cursor.getString(cursor.getColumnIndex("data5")));
        c12161c.m72970Z(cursor.getString(cursor.getColumnIndex("data6")));
        return c12161c;
    }

    /* renamed from: r0 */
    public long m73102r0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9) and status in (?,?,?)", new String[]{this.f56437b, String.valueOf(4), String.valueOf(5), String.valueOf(6)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: s */
    public boolean m73103s() {
        try {
            Cursor cursorRawQuery = rawQuery(PmsMetaDBScript.CHECK_TEMP_TABLE_EXIST, new String[]{SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        if (cursorRawQuery.getInt(0) > 0) {
                            cursorRawQuery.close();
                            return true;
                        }
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupMetaOperator", "check old db tag exists error." + e10.toString());
        }
        return false;
    }

    /* renamed from: s0 */
    public long m73104s0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9) and status in (?,?,?)", new String[]{this.f56437b, String.valueOf(4), String.valueOf(5), String.valueOf(6)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: t0 */
    public long m73105t0(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery("SELECT count(DISTINCT cloud_path)  FROM snapshot_data  WHERE app_id = ?  AND flag = ?  AND cloud_path IS NOT NULL  AND cloud_path != '';", new String[]{str, String.valueOf(0)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    public final void tarRateCaclExecute() throws C9721b {
        Locale locale = Locale.ENGLISH;
        execSQL(String.format(locale, TarRefRatioDBScript.CACL_TAR_RATIO_AND_MARK, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(1)});
        execSQL(String.format(locale, TarRefRatioDBScript.DELETE_NOT_CACL_END_ROW, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(0)});
    }

    /* renamed from: u */
    public final void m73106u() throws C9721b {
        m73071c(C13617a.m81942x(this.f56436a, "snapshot_" + this.f56437b, 1, this.f56438c));
        try {
            try {
                execSQL("replace into snapshot_data(id, data, root, name, type, left, right, app_id, app_name, hash1, hash2, status, size, count, cloud_path, file_id, assert_id, version_id, flag, cloud_size, cloud_hash, cloud_encoded, date_create, date_modify, date_invalid, date_taken, extend, data1, data2, data3, data4, data5, data6) select id, data, root, name, type, left, right, app_id, app_name, hash1, hash2, status, size, count, cloud_path, file_id, assert_id, version_id, flag, cloud_size, cloud_hash, cloud_encoded, date_create, date_modify, date_invalid, date_taken, extend, data1, data2, data3, data4, data5, data6 from userdata.snapshot_data");
            } catch (C9721b e10) {
                C11839m.m70689w("CloudBackupMetaOperator", "updateV3RecoveryMetaCache error: " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "exec sql error. " + e10.getMessage());
            }
        } finally {
            m73095o();
        }
    }

    /* renamed from: u0 */
    public long m73107u0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select sum(size) from snapshot_data where app_id = ? and status not in (?,?) and type in (0,1,2,3,6,7,8,9);", new String[]{this.f56437b, String.valueOf(5), String.valueOf(6)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* renamed from: v */
    public void m73108v(String str) throws C9721b {
        if ("V4".equals(str)) {
            m73106u();
        }
    }

    /* renamed from: v0 */
    public int m73109v0() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9) and data2 = 'delete';", new String[]{this.f56437b});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = (int) cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: w */
    public long m73110w(String str) {
        try {
            Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and root = ? and type in (0,1,2,3,5,6,7,8,9)", new String[]{String.valueOf(str), ICBUtil.RELATIVE_SDATA_PATH + File.separator});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getInt(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupMetaOperator", "queryAllCountWithDir error: " + e10.getMessage());
            return -1L;
        }
    }

    /* renamed from: w0 */
    public void m73111w0(C12161c c12161c) throws C9721b {
        batchReplace(Collections.singletonList(c12161c));
    }

    /* renamed from: x */
    public int m73112x() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and type in (5)", new String[]{String.valueOf(this.f56437b)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: x0 */
    public final void m73113x0(boolean z10) throws C9721b {
        String[] strArr = {String.valueOf(1), String.valueOf(0), String.valueOf(7), String.valueOf(5), String.valueOf(6), ""};
        if (z10) {
            strArr[5] = ICBUtil.RELATIVE_SDATA_PATH + File.separator;
        }
        Locale locale = Locale.ENGLISH;
        execSQL(String.format(locale, TarRefRatioDBScript.REPLACE_INTO_TAR_REF_SUM_SIZE_FROM_SNAPSHOT, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE, SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META), strArr);
        execSQL(String.format(locale, TarRefRatioDBScript.REPLACE_INTO_TAR_REF_ZERO_FILE_COUNT_FROM_SNAPSHOT, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE, SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META), strArr);
        execSQL(String.format(locale, TarRefRatioDBScript.UPDATA_ORIGIN_SIZE_FLAG_BY_ORIGIN_SIZE, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(RuleConfig.DEFAULT_TAR_SIZE), String.valueOf(0)});
    }

    /* renamed from: y */
    public int m73114y() throws C9721b {
        Cursor cursorRawQuery = rawQuery("select count(*) from snapshot_data where app_id = ? and type in (5) and (file_id != '' or cloud_path != '')", new String[]{String.valueOf(this.f56437b)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0;
    }

    /* renamed from: y0 */
    public void m73115y0(String str, String str2, String str3) throws C9721b {
        execSQL("update snapshot_data set cloud_path = ? where root = ? and data = ? and app_id = ?;", new String[]{String.valueOf(str), String.valueOf(str2), String.valueOf(str3), String.valueOf(this.f56437b)});
    }

    /* renamed from: z */
    public List<String> m73116z(String str) throws C9721b {
        String[] strArr = {String.valueOf(str), String.valueOf(1)};
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = rawQuery("SELECT DISTINCT (file_id)  FROM snapshot_data  WHERE app_id = ?  AND flag = ?  AND file_id IS NOT NULL  AND file_id != '';", strArr);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorRawQuery.getString(0));
                    } while (cursorRawQuery.moveToNext());
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return arrayList;
    }

    /* renamed from: z0 */
    public void m73117z0(C12161c c12161c) throws C9721b {
        execSQL("update snapshot_data set data2 = 'delete', cloud_path = '' where app_id = ? and data = ? and root = ?;", new String[]{c12161c.m72974c(), c12161c.m72991l(), c12161c.m72950F()});
    }
}
