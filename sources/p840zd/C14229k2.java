package p840zd;

import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.cloudbackup.store.manager.CloudBackupTagsDBHelper;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;
import p682ul.C13216j;
import p711vl.C13465e;
import p848zl.C14333b;
import tl.C13026e;

/* renamed from: zd.k2 */
/* loaded from: classes3.dex */
public class C14229k2 extends C13026e {
    public C14229k2() {
        setDatabase(C13216j.m79427l(C13216j.c.TAG, null));
        this.f59287a = "t_backup_options_temporary";
        if (isTableExist("t_backup_options_temporary")) {
            return;
        }
        try {
            C11839m.m70688i("TempBackupOptionItemOperator", "table not exist, create table");
            execSQL(CloudBackupTagsDBHelper.f22420e);
        } catch (C9721b e10) {
            C11839m.m70687e("TempBackupOptionItemOperator", "create table error: " + e10.getMessage());
        }
    }

    /* renamed from: R */
    public final String m85085R(String str) {
        return new ArrayList(C14333b.m85482q()).contains(str) ? "baseData" : (NavigationUtils.SMS_SCHEMA_PREF.equals(str) || "chatSms".equals(str)) ? NavigationUtils.SMS_SCHEMA_PREF : ("callRecorder".equals(str) || "soundrecorder".equals(str)) ? "soundrecorder" : !new ArrayList(C14333b.m85476k()).contains(str) ? "thirdAppData" : str;
    }

    /* renamed from: S */
    public final BackupOptionItem m85086S(String str) {
        BackupOptionItem backupOptionItem;
        if ("baseData".equals(str) || "thirdAppData".equals(str)) {
            return null;
        }
        BackupOptionItem backupOptionItemM78401y = m78401y(str);
        if (backupOptionItemM78401y != null || (backupOptionItem = (BackupOptionItem) C13465e.m81052f().m81059h(str, BackupOptionItem.class)) == null) {
            return backupOptionItemM78401y;
        }
        backupOptionItem.setParent(m85085R(str));
        try {
            m78370E(backupOptionItem);
            C13465e.m81052f().m81068q(backupOptionItem.getAppId());
        } catch (C9721b e10) {
            C11839m.m70687e("TempBackupOptionItemOperator", "queryItem" + e10.getMessage());
        }
        return backupOptionItem;
    }

    /* renamed from: T */
    public BackupOptionItem m85087T(String str) {
        long totalIncrease;
        int isDataEnable;
        int i10;
        C11839m.m70688i("TempBackupOptionItemOperator", "query parent item appId: " + str);
        List<BackupOptionItem> listM78399w = m78399w(str);
        long j10 = 0;
        int itemTotal = 0;
        if (listM78399w == null || listM78399w.isEmpty()) {
            totalIncrease = 0;
            isDataEnable = 0;
            i10 = 0;
        } else {
            Iterator<BackupOptionItem> it = listM78399w.iterator();
            long dataBytes = 0;
            totalIncrease = 0;
            isDataEnable = 0;
            i10 = 0;
            while (it.hasNext()) {
                BackupOptionItem next = it.next();
                dataBytes += next.getDataBytes();
                itemTotal += next.getItemTotal();
                if (next.getBackupSwitch()) {
                    i10++;
                }
                if (next.getIsDataEnable() != -1 || isDataEnable == 0) {
                    isDataEnable = next.getIsDataEnable();
                }
                if (next.getTotalIncrease() > 0) {
                    totalIncrease += next.getTotalIncrease();
                }
            }
            j10 = dataBytes;
        }
        BackupOptionItem backupOptionItemM85086S = m85086S(str);
        boolean backupSwitch = backupOptionItemM85086S != null ? backupOptionItemM85086S.getBackupSwitch() : true;
        BackupOptionItem backupOptionItem = new BackupOptionItem();
        backupOptionItem.setAppId(str);
        backupOptionItem.setDataBytes(j10);
        backupOptionItem.setTotalIncrease(totalIncrease);
        backupOptionItem.setItemTotal(itemTotal);
        backupOptionItem.setBackupSwitch(backupSwitch);
        backupOptionItem.setIsDataEnable(isDataEnable);
        backupOptionItem.setSwitchCount(i10);
        backupOptionItem.setAppName("");
        return backupOptionItem;
    }

    @Override // tl.C13026e
    /* renamed from: m */
    public long mo78392m(BackupOptionItem backupOptionItem) {
        return backupOptionItem.getDataBytes();
    }
}
