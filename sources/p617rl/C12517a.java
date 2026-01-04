package p617rl;

import android.database.Cursor;
import com.huawei.android.hicloud.cloudbackup.bean.HiCloudAppFilesBean;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: rl.a */
/* loaded from: classes6.dex */
public class C12517a extends AbstractC11478a<HiCloudAppFilesBean> {
    public C12517a() {
        super(C13216j.m79427l(C13216j.c.SETTING, null));
    }

    @Override // ml.AbstractC11478a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(HiCloudAppFilesBean hiCloudAppFilesBean) {
        return new String[]{hiCloudAppFilesBean.getId(), hiCloudAppFilesBean.getDate(), String.valueOf(hiCloudAppFilesBean.getVersion()), hiCloudAppFilesBean.getData()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public HiCloudAppFilesBean getObject(Cursor cursor) {
        HiCloudAppFilesBean hiCloudAppFilesBean = new HiCloudAppFilesBean();
        hiCloudAppFilesBean.setId(cursor.getString(0));
        hiCloudAppFilesBean.setDate(cursor.getString(1));
        hiCloudAppFilesBean.setVersion(cursor.getInt(2));
        hiCloudAppFilesBean.setData(cursor.getString(3));
        return hiCloudAppFilesBean;
    }

    /* renamed from: c */
    public void m75223c(HiCloudAppFilesBean hiCloudAppFilesBean) throws C9721b {
        if (hiCloudAppFilesBean != null) {
            try {
                execSQL("replace into app_config_version(id, date, version, data) VALUES(?,?,?,?);", new String[]{hiCloudAppFilesBean.getId(), hiCloudAppFilesBean.getDate(), String.valueOf(hiCloudAppFilesBean.getVersion()), hiCloudAppFilesBean.getData()});
            } catch (C9721b e10) {
                C11839m.m70687e("AppConfigVersionOperator", "execSQL updateAppConfigVersion error: " + e10.toString());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "exec update app config version error. " + e10.getMessage(), "execSQL");
            }
        }
    }

    public void clear() {
        try {
            execSQL("delete from app_config_version");
        } catch (C9721b e10) {
            C11839m.m70687e("AppConfigVersionOperator", "execSQL clear error: " + e10.toString());
        }
    }
}
