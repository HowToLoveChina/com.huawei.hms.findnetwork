package tl;

import android.database.Cursor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.cloudbackup.store.manager.CloudBackupTagsDBHelper;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: tl.e */
/* loaded from: classes6.dex */
public class C13026e extends AbstractC11478a<BackupOptionItem> {

    /* renamed from: a */
    public String f59287a;

    public C13026e() {
        this(false, true);
    }

    /* renamed from: q */
    public static /* synthetic */ boolean m78363q(BackupOptionItem backupOptionItem) {
        return backupOptionItem.getUid() != 0;
    }

    /* renamed from: r */
    public static /* synthetic */ boolean m78364r(BackupOptionItem backupOptionItem) {
        return backupOptionItem.getOperateType() == 1;
    }

    /* renamed from: s */
    public static /* synthetic */ String m78365s(BackupOptionItem backupOptionItem) {
        return backupOptionItem.getAppId() + backupOptionItem.getUid();
    }

    /* renamed from: A */
    public List<BackupOptionItem> m78366A(String str) {
        try {
            return query(m78389j("select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, operateType, operateTime, parent, increase1, increase2, isDisable, isDataEnable, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5, data6 from %s where appId = ?;", this.f59287a), new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "query queryItems by appId error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: B */
    public final boolean m78367B(String str, String[] strArr) {
        try {
            Cursor cursorRawQuery = rawQuery(m78389j(str, this.f59287a), strArr);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst() && cursorRawQuery.getInt(0) > 0) {
                        C11839m.m70688i("BackupOptionItemOperator", "queryResultNotEmpty,count > 0");
                        cursorRawQuery.close();
                        return true;
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "query app switch state error: " + e10.getMessage());
        }
        C11839m.m70688i("BackupOptionItemOperator", "query result is empty");
        return false;
    }

    /* renamed from: C */
    public List<BackupOptionItem> m78368C(String str) {
        try {
            return query(m78389j(" select * from %s where oriBackupAppName = ? and splitApkType != ? and splitApkType != ?;", this.f59287a), new String[]{str, "0", ""});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "querySplitItems by appId error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: D */
    public void m78369D(String str, String str2, int i10, String str3, String str4, String str5, boolean z10) throws C9721b {
        BackupOptionItem backupOptionItemOrElse;
        List<BackupOptionItem> listM78366A = m78366A(str2);
        if (listM78366A != null && listM78366A.size() > 1) {
            backupOptionItemOrElse = listM78366A.stream().filter(new Predicate() { // from class: tl.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C13026e.m78363q((BackupOptionItem) obj);
                }
            }).filter(new Predicate() { // from class: tl.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C13026e.m78364r((BackupOptionItem) obj);
                }
            }).max(Comparator.comparingLong(new ToLongFunction() { // from class: tl.c
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return ((BackupOptionItem) obj).getOperateTime();
                }
            })).orElse(null);
            if (backupOptionItemOrElse == null) {
                backupOptionItemOrElse = listM78366A.get(0);
            }
            listM78366A.remove(backupOptionItemOrElse);
            m78388i(listM78366A);
            C11839m.m70688i("BackupOptionItemOperator", "delete more backupOptionItems: " + listM78366A.stream().map(new Function() { // from class: tl.d
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C13026e.m78365s((BackupOptionItem) obj);
                }
            }).collect(Collectors.toList()));
        } else if (listM78366A == null || listM78366A.size() != 1) {
            BackupOptionItem backupOptionItem = new BackupOptionItem(str2, "thirdAppData");
            backupOptionItem.setUid(i10);
            backupOptionItem.setSplitApkType(str3);
            backupOptionItem.setOriBackupAppName(str4);
            backupOptionItem.setBackupSwitch(z10);
            C11839m.m70688i("BackupOptionItemOperator", "refresh3rdTwinAppData new backupOptionItems");
            m78370E(backupOptionItem);
            backupOptionItemOrElse = backupOptionItem;
        } else {
            backupOptionItemOrElse = listM78366A.get(0);
        }
        backupOptionItemOrElse.setUid(i10);
        backupOptionItemOrElse.setSplitApkType(str3);
        backupOptionItemOrElse.setOriBackupAppName(str4);
        backupOptionItemOrElse.setParent(str);
        backupOptionItemOrElse.setBackupData(true);
        if (!TextUtils.isEmpty(str5)) {
            str2 = str5;
        }
        backupOptionItemOrElse.setAppName(str2);
        m78381P(backupOptionItemOrElse);
        C11839m.m70688i("BackupOptionItemOperator", "getThirdTwinAppOptionsInfo" + new Gson().toJson(backupOptionItemOrElse));
    }

    /* renamed from: E */
    public void m78370E(BackupOptionItem backupOptionItem) throws C9721b {
        ArrayList arrayList = new ArrayList();
        arrayList.add(backupOptionItem);
        try {
            batch(m78389j("replace into %s(appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data,operateType, operateTime, parent, increase1, increase2, isDisable, isDataEnable, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5, data6) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", this.f59287a), arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "replace item error: " + e10.getMessage());
            throw e10;
        }
    }

    /* renamed from: F */
    public void m78371F(long j10, String str, int i10) throws C9721b {
        execSQL(m78389j("update %s set data4 = ? where appId = ? and uid = ?", this.f59287a), new String[]{String.valueOf(j10), str, String.valueOf(i10)});
    }

    /* renamed from: G */
    public void m78372G(long j10, String str) throws C9721b {
        execSQL(m78389j("update %s set increase1 = ? where appId = ?", this.f59287a), new String[]{String.valueOf(j10), str});
    }

    /* renamed from: H */
    public void m78373H(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new String[]{it.next()});
            }
            execute(m78389j("update %s set increase1 = dataBytes where appId = ?", this.f59287a), arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "updateItemIncrease1ToDataByteByAppid error: " + e10.getMessage());
        }
    }

    /* renamed from: I */
    public void m78374I(String str, String str2) {
        try {
            execSQL(m78389j("update %s set appName = ? where appId = ?", this.f59287a), new String[]{String.valueOf(str), str2});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "update item name error: " + e10.getMessage());
        }
    }

    /* renamed from: J */
    public void m78375J() {
        try {
            execSQL(m78389j("update %s set operateType = ? where operateType = '';", this.f59287a), new String[]{String.valueOf(1)});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "update item operateType error: " + e10.getMessage());
        }
    }

    /* renamed from: K */
    public void m78376K(boolean z10, String str) {
        m78378M(z10, str, Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: L */
    public void m78377L(boolean z10, String str, int i10, Long l10) {
        if (l10 == null) {
            m78380O(z10, str, i10);
        } else {
            m78379N(z10, str, i10, l10.longValue());
        }
    }

    /* renamed from: M */
    public void m78378M(boolean z10, String str, Long l10) {
        m78377L(z10, str, 1, l10);
    }

    /* renamed from: N */
    public final void m78379N(boolean z10, String str, int i10, long j10) {
        try {
            execSQL(m78389j("update %s set backup_switch = ?, operateType = ?, operateTime = ? where appId = ?", this.f59287a), new String[]{String.valueOf(z10 ? 1 : 0), String.valueOf(i10), String.valueOf(j10), str});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "update item switchStatus error: " + e10.getMessage());
        }
    }

    /* renamed from: O */
    public final void m78380O(boolean z10, String str, int i10) {
        try {
            execSQL(m78389j("update %s set backup_switch = ?, operateType = ? where appId = ?", this.f59287a), new String[]{String.valueOf(z10 ? 1 : 0), String.valueOf(i10), str});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "update item switchStatus error: " + e10.getMessage());
        }
    }

    /* renamed from: P */
    public void m78381P(BackupOptionItem backupOptionItem) {
        try {
            execSQL(m78389j("update %s set (appName, parent, splitApkType, oriBackupAppName, uid, isDisable, backup_data, isDataEnable, codeBytes, dataBytes, itemTotal, operateTime, increase1, increase2, data2, data3) = (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) where appId = ?", this.f59287a), new String[]{backupOptionItem.getAppName(), backupOptionItem.getParent(), backupOptionItem.getSplitApkType(), backupOptionItem.getOriBackupAppName(), String.valueOf(backupOptionItem.getUid()), String.valueOf(backupOptionItem.getIsDisable() ? 1 : 0), String.valueOf(backupOptionItem.isBackupData() ? 1 : 0), String.valueOf(backupOptionItem.isDataEnable()), String.valueOf(backupOptionItem.getCodeBytes()), String.valueOf(backupOptionItem.getDataBytes()), String.valueOf(backupOptionItem.getItemTotal()), String.valueOf(backupOptionItem.getOperateTime()), String.valueOf(backupOptionItem.getTotalIncrease()), String.valueOf(backupOptionItem.getCurrentIncrease()), backupOptionItem.getData2(), backupOptionItem.getData3(), backupOptionItem.getAppId()});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "updateItemUidWithoutSwitch error: " + e10.getMessage());
        }
    }

    /* renamed from: Q */
    public void m78382Q(BackupOptionItem backupOptionItem) {
        try {
            execSQL(m78389j("update %s set (appName, parent, isDisable, backup_data, isDataEnable, codeBytes, dataBytes, itemTotal, operateTime, increase1, increase2, data2, data3) = (?,?,?,?,?,?,?,?,?,?,?,?,?) where appId = ? and uid = ?", this.f59287a), new String[]{backupOptionItem.getAppName(), backupOptionItem.getParent(), String.valueOf(backupOptionItem.getIsDisable() ? 1 : 0), String.valueOf(backupOptionItem.isBackupData() ? 1 : 0), String.valueOf(backupOptionItem.isDataEnable()), String.valueOf(backupOptionItem.getCodeBytes()), String.valueOf(backupOptionItem.getDataBytes()), String.valueOf(backupOptionItem.getItemTotal()), String.valueOf(backupOptionItem.getOperateTime()), String.valueOf(backupOptionItem.getTotalIncrease()), String.valueOf(backupOptionItem.getCurrentIncrease()), backupOptionItem.getData2(), backupOptionItem.getData3(), backupOptionItem.getAppId(), String.valueOf(backupOptionItem.getUid())});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "update item without switch error: " + e10.getMessage());
        }
    }

    public void clear() {
        try {
            execSQL(m78389j("delete from %s;", this.f59287a));
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "clear item error: " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public void m78383d(List<BackupOptionItem> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            batch(m78389j("replace into %s(appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data,operateType, operateTime, parent, increase1, increase2, isDisable, isDataEnable, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5, data6) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", this.f59287a), list);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "batch replace item error: " + e10.getMessage());
            throw e10;
        }
    }

    /* renamed from: e */
    public void m78384e(List<String> list) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new String[]{String.valueOf(0), String.valueOf(1), strValueOf, it.next()});
        }
        try {
            execute(m78389j("update %s set backup_switch = ?, operateType = ?, operateTime = ? where appId = ?", this.f59287a), arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "closeItemsSwitch error: " + e10.getMessage());
        }
    }

    /* renamed from: f */
    public void m78385f() {
        try {
            execSQL(m78389j("update %s set backup_switch = ? where parent = ?", this.f59287a), new String[]{String.valueOf(0), "thirdAppData"});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "close third app switchStatus error: " + e10.getMessage());
        }
    }

    /* renamed from: g */
    public void m78386g(String str) {
        try {
            execSQL(m78389j("delete from %s where appId = ?;", this.f59287a), new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "delete item error: " + e10.getMessage());
        }
    }

    /* renamed from: h */
    public void m78387h(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new String[]{it.next()});
            }
            execute(m78389j("delete from %s where appId = ?;", this.f59287a), arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "delete item error: " + e10.getMessage());
        }
    }

    /* renamed from: i */
    public void m78388i(List<BackupOptionItem> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (BackupOptionItem backupOptionItem : list) {
                arrayList.add(new String[]{backupOptionItem.getAppId(), String.valueOf(backupOptionItem.getUid())});
            }
            execute(m78389j("delete from %s where appId = ? and uid = ?;", this.f59287a), arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "delete item error: " + e10.getMessage());
        }
    }

    /* renamed from: j */
    public final String m78389j(String str, String str2) {
        return String.format(Locale.ENGLISH, str, str2);
    }

    @Override // ml.AbstractC11478a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(BackupOptionItem backupOptionItem) {
        String[] strArr = new String[24];
        strArr[0] = backupOptionItem.getAppId();
        if (TextUtils.equals(backupOptionItem.getParent(), "thirdAppData")) {
            C11839m.m70688i("BackupOptionItemOperator", "isBackupData = " + backupOptionItem.isBackupData() + "; appId = " + backupOptionItem.getAppId());
        }
        strArr[1] = String.valueOf(backupOptionItem.getUid());
        strArr[2] = backupOptionItem.getAppName();
        strArr[3] = String.valueOf(backupOptionItem.getAppType());
        strArr[4] = String.valueOf(backupOptionItem.getItemTotal());
        strArr[5] = String.valueOf(backupOptionItem.getDataBytes());
        strArr[6] = String.valueOf(backupOptionItem.getCodeBytes());
        strArr[7] = String.valueOf(backupOptionItem.getBackupSwitch() ? 1 : 0);
        strArr[8] = String.valueOf(backupOptionItem.isBackupData() ? 1 : 0);
        strArr[9] = String.valueOf(backupOptionItem.getOperateType());
        strArr[10] = String.valueOf(backupOptionItem.getOperateTime());
        strArr[11] = backupOptionItem.getParent();
        strArr[12] = String.valueOf(backupOptionItem.getTotalIncrease());
        strArr[13] = String.valueOf(backupOptionItem.getCurrentIncrease());
        strArr[14] = String.valueOf(backupOptionItem.getIsDisable() ? 1 : 0);
        strArr[15] = String.valueOf(backupOptionItem.isDataEnable());
        strArr[16] = String.valueOf(backupOptionItem.getOriBackupAppName());
        strArr[17] = String.valueOf(backupOptionItem.getSplitApkType());
        strArr[18] = backupOptionItem.getData1();
        strArr[19] = backupOptionItem.getData2();
        strArr[20] = backupOptionItem.getData3();
        strArr[21] = backupOptionItem.getData4();
        strArr[22] = backupOptionItem.getData5();
        strArr[23] = backupOptionItem.getData6();
        return strArr;
    }

    @Override // ml.AbstractC11478a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public BackupOptionItem getObject(Cursor cursor) {
        BackupOptionItem backupOptionItem = new BackupOptionItem();
        backupOptionItem.setAppId(cursor.getString(0));
        backupOptionItem.setUid(cursor.getInt(1));
        backupOptionItem.setAppName(cursor.getString(2));
        backupOptionItem.setAppType(cursor.getInt(3));
        backupOptionItem.setItemTotal(cursor.getInt(4));
        backupOptionItem.setDataBytes(cursor.getLong(5));
        backupOptionItem.setCodeBytes(cursor.getLong(6));
        backupOptionItem.setBackupSwitch(cursor.getInt(7) == 1);
        backupOptionItem.setBackupData(cursor.getInt(8) == 1);
        backupOptionItem.setOperateType(cursor.getInt(9));
        backupOptionItem.setOperateTime(cursor.getLong(10));
        backupOptionItem.setParent(cursor.getString(11));
        backupOptionItem.setTotalIncrease(cursor.getLong(12));
        backupOptionItem.setCurrentIncrease(cursor.getLong(13));
        backupOptionItem.setDisable(cursor.getInt(14) == 1);
        backupOptionItem.setDataEnable(cursor.getInt(15));
        backupOptionItem.setOriBackupAppName(cursor.getString(16));
        backupOptionItem.setSplitApkType(cursor.getString(17));
        backupOptionItem.setData1(cursor.getString(18));
        backupOptionItem.setData2(cursor.getString(19));
        backupOptionItem.setData3(cursor.getString(20));
        backupOptionItem.setData4(cursor.getString(21));
        backupOptionItem.setData5(cursor.getString(22));
        backupOptionItem.setData6(cursor.getString(23));
        return backupOptionItem;
    }

    /* renamed from: m */
    public long mo78392m(BackupOptionItem backupOptionItem) {
        return backupOptionItem.getTotalIncrease();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m78393n() {
        /*
            r4 = this;
            java.lang.String r0 = ""
            java.lang.String[] r0 = new java.lang.String[]{r0}
            r1 = 0
            java.lang.String r2 = "select count(*) from %s where operateType != ?;"
            java.lang.String r3 = r4.f59287a     // Catch: fk.C9721b -> L2a
            java.lang.String r2 = r4.m78389j(r2, r3)     // Catch: fk.C9721b -> L2a
            android.database.Cursor r4 = r4.rawQuery(r2, r0)     // Catch: fk.C9721b -> L2a
            if (r4 == 0) goto L2d
            boolean r0 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L2d
            int r0 = r4.getInt(r1)     // Catch: java.lang.Throwable -> L20
            goto L2e
        L20:
            r0 = move-exception
            r4.close()     // Catch: java.lang.Throwable -> L25
            goto L29
        L25:
            r4 = move-exception
            r0.addSuppressed(r4)     // Catch: fk.C9721b -> L2a
        L29:
            throw r0     // Catch: fk.C9721b -> L2a
        L2a:
            r4 = move-exception
            r0 = r1
            goto L35
        L2d:
            r0 = r1
        L2e:
            if (r4 == 0) goto L4f
            r4.close()     // Catch: fk.C9721b -> L34
            goto L4f
        L34:
            r4 = move-exception
        L35:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "query items error: "
            r2.append(r3)
            java.lang.String r4 = r4.getMessage()
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            java.lang.String r2 = "BackupOptionItemOperator"
            p514o9.C11839m.m70687e(r2, r4)
        L4f:
            if (r0 != 0) goto L52
            r1 = 1
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tl.C13026e.m78393n():boolean");
    }

    /* renamed from: o */
    public boolean m78394o() {
        return m78367B("select count(*) from %s where parent != ? and backup_switch = ?;", new String[]{"baseData", String.valueOf(1)});
    }

    /* renamed from: p */
    public boolean m78395p() {
        boolean zM78367B = m78367B("select count(*) from %s where parent = ? and backup_switch = ?;", new String[]{"thirdAppData", String.valueOf(1)});
        C11839m.m70688i("BackupOptionItemOperator", "third app switch state is:" + zM78367B);
        return zM78367B;
    }

    /* renamed from: t */
    public void m78396t() {
        try {
            execSQL(CloudBackupTagsDBHelper.f22418c);
            if (!isTableExist("backup_options_status")) {
                C11839m.m70688i("BackupOptionItemOperator", "onUpgradeAppTwin old table not exist");
            } else {
                execSQL("replace into t_cloudbackup_options select appId, 0 as uid, name as appName, 0 as appType, count as itemTotal, dataSize as dataBytes, apkSize as codeBytes, switchStatus as backup_switch, isBackupData as backup_data, data3 as operateType, operateTime, parent, data1 as increase1, data2 as increase2, isDisable, isDataEnable, '' as data1, '' as data2, '' as data3, '' as data4, '' as data5, '' as data6 from backup_options_status");
                drop("backup_options_status");
            }
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "onUpgradeAppTwin error: " + e10.getMessage());
        }
    }

    /* renamed from: u */
    public List<BackupOptionItem> m78397u() {
        try {
            return query(m78389j("select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, operateType, operateTime, parent, increase1, increase2, isDisable, isDataEnable, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5, data6 from %s;", this.f59287a), null);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "query items error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: v */
    public List<String> m78398v(String str) {
        String[] strArr = {str};
        try {
            ArrayList arrayList = new ArrayList();
            Cursor cursorRawQuery = rawQuery(m78389j("select appId, uid from %s where parent = ?;", this.f59287a), strArr);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            arrayList.add(cursorRawQuery.getString(0));
                        } while (cursorRawQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return arrayList;
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "query items error: " + e10.getMessage());
            return new ArrayList();
        }
    }

    /* renamed from: w */
    public List<BackupOptionItem> m78399w(String str) {
        try {
            return query(m78389j("select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, operateType, operateTime, parent, increase1, increase2, isDisable, isDataEnable, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5, data6 from %s where parent = ?;", this.f59287a), new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "query items error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: x */
    public List<BackupOptionItem> m78400x(String str) {
        try {
            return query(m78389j("select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, operateType, operateTime, parent, increase1, increase2, isDisable, isDataEnable, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5, data6 from %s where parent = ?;", this.f59287a), new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "query items error: " + e10.getMessage());
            return new ArrayList();
        }
    }

    /* renamed from: y */
    public BackupOptionItem m78401y(String str) {
        try {
            List<BackupOptionItem> listQuery = query(m78389j("select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, operateType, operateTime, parent, increase1, increase2, isDisable, isDataEnable, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5, data6 from %s where appId = ?;", this.f59287a), new String[]{str});
            if (listQuery.isEmpty()) {
                return null;
            }
            return listQuery.get(0);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "query item by appId error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: z */
    public BackupOptionItem m78402z(String str, int i10) {
        try {
            List<BackupOptionItem> listQuery = query(m78389j("select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, operateType, operateTime, parent, increase1, increase2, isDisable, isDataEnable, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5, data6 from %s where appId = ? and uid = ?;", this.f59287a), new String[]{str, String.valueOf(i10)});
            if (listQuery.isEmpty()) {
                return null;
            }
            return listQuery.get(0);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "query item by appId error: " + e10.getMessage());
            return null;
        }
    }

    public C13026e(boolean z10) {
        this(z10, true);
    }

    public C13026e(boolean z10, boolean z11) {
        String str;
        super(C13216j.m79427l(C13216j.c.TAG, null));
        this.f59287a = "t_cloudbackup_options";
        if (z10) {
            this.f59287a = "t_backup_options_refurbish";
        }
        if (!z11 || isTableExist(this.f59287a)) {
            return;
        }
        try {
            C11839m.m70688i("BackupOptionItemOperator", "table not exist, create table");
            if (z10) {
                str = CloudBackupTagsDBHelper.f22419d;
            } else {
                str = CloudBackupTagsDBHelper.f22418c;
            }
            execSQL(str);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionItemOperator", "create table error: " + e10.getMessage());
        }
    }
}
