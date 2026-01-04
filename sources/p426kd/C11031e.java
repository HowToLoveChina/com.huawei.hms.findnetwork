package p426kd;

import android.content.SharedPreferences;
import com.huawei.android.hicloud.clouddisk.logic.sms.BackupSmsImp;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import p514o9.C11829c;

@CBServiceTask(request = 55000014, response = 66000014)
/* renamed from: kd.e */
/* loaded from: classes3.dex */
public class C11031e extends AbstractC11027a {
    @Override // p426kd.AbstractC11027a
    /* renamed from: C */
    public CloudDiskModuleRst mo66478C() {
        CloudDiskModuleRst cloudDiskModuleRstOnBackup = new BackupSmsImp(this.f53282a).onBackup(this.f53297m, this.f52115y);
        cloudDiskModuleRstOnBackup.setModuleName(NavigationUtils.SMS_SCHEMA_PREF);
        return cloudDiskModuleRstOnBackup;
    }

    @Override // p426kd.AbstractC11027a
    /* renamed from: D */
    public void mo66479D(int i10, int i11, boolean z10) {
        SharedPreferences.Editor editorEdit = this.f53286e.edit();
        if (this.f53286e.getBoolean("autosmslistkeynotAllSucess", false)) {
            editorEdit.remove("autosmslistkeynotAllSucess");
            editorEdit.commit();
        }
        if (i10 == 1 || i11 > 0) {
            editorEdit.putString("autosmslistkey_time", String.valueOf(System.currentTimeMillis()));
            editorEdit.putInt("autosmslistkey_retcode", i10);
            editorEdit.commit();
        } else {
            editorEdit.putInt("autosmslistkey_retcode", i10);
            editorEdit.commit();
        }
        if (z10) {
            editorEdit.putBoolean("autosmslistkeynotAllSucess", true);
            editorEdit.commit();
        }
    }

    @Override // p426kd.AbstractC11027a
    /* renamed from: E */
    public void mo66480E() {
        SharedPreferences.Editor editorEdit = this.f53286e.edit();
        editorEdit.putInt("autosmslistkey_retcode", 4);
        editorEdit.commit();
        this.f52116z = "102";
        if (C11829c.m70611r0()) {
            return;
        }
        editorEdit.putBoolean("autosmslistkeynotAllSucess", true);
        editorEdit.commit();
    }
}
