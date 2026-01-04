package p426kd;

import android.content.SharedPreferences;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.BackupCallLogsImp;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import p514o9.C11829c;

@CBServiceTask(request = 55000015, response = 66000015)
/* renamed from: kd.b */
/* loaded from: classes3.dex */
public class C11028b extends AbstractC11027a {
    @Override // p426kd.AbstractC11027a
    /* renamed from: C */
    public CloudDiskModuleRst mo66478C() throws Throwable {
        CloudDiskModuleRst cloudDiskModuleRstDoBackup = new BackupCallLogsImp(this.f53282a).doBackup(this.f53297m, this.f52115y);
        cloudDiskModuleRstDoBackup.setModuleName("callLog");
        return cloudDiskModuleRstDoBackup;
    }

    @Override // p426kd.AbstractC11027a
    /* renamed from: D */
    public void mo66479D(int i10, int i11, boolean z10) {
        SharedPreferences.Editor editorEdit = this.f53286e.edit();
        if (this.f53286e.getBoolean("autocallloglistkeynotAllSucess", false)) {
            editorEdit.remove("autocallloglistkeynotAllSucess");
            editorEdit.commit();
        }
        if (i10 == 1 || i11 > 0) {
            editorEdit.putString("autocallloglistkey_time", String.valueOf(System.currentTimeMillis()));
            editorEdit.putInt("autocallloglistkey_retcode", i10);
            editorEdit.commit();
        } else {
            editorEdit.putInt("autocallloglistkey_retcode", i10);
            editorEdit.commit();
        }
        if (z10) {
            editorEdit.putBoolean("autocallloglistkeynotAllSucess", true);
            editorEdit.commit();
        }
    }

    @Override // p426kd.AbstractC11027a
    /* renamed from: E */
    public void mo66480E() {
        SharedPreferences.Editor editorEdit = this.f53286e.edit();
        editorEdit.putInt("autocallloglistkey_retcode", 4);
        editorEdit.commit();
        this.f52116z = "102";
        if (C11829c.m70611r0()) {
            return;
        }
        editorEdit.putBoolean("autocallloglistkeynotAllSucess", true);
        editorEdit.commit();
    }
}
