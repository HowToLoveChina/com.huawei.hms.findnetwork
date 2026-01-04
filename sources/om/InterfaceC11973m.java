package om;

import android.os.Handler;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import java.util.function.Supplier;
import tl.C13029h;

/* renamed from: om.m */
/* loaded from: classes6.dex */
public interface InterfaceC11973m {
    /* renamed from: a */
    void mo72044a(int i10, boolean z10);

    /* renamed from: b */
    CloudBackupState mo72075b();

    /* renamed from: c */
    boolean mo72076c();

    /* renamed from: d */
    void mo72048d(Handler handler);

    /* renamed from: e */
    long mo72050e();

    /* renamed from: f */
    void mo72052f();

    /* renamed from: g */
    void mo72054g(Handler handler);

    /* renamed from: h */
    void mo72056h(C13029h c13029h, Integer num, boolean z10);

    /* renamed from: i */
    void mo72058i(int i10);

    void init();

    /* renamed from: j */
    void mo72060j(int i10, String str);

    /* renamed from: k */
    void mo72077k(boolean z10);

    /* renamed from: l */
    void mo72061l(int i10, String str, boolean z10);

    /* renamed from: m */
    void mo72079m();

    /* renamed from: n */
    void mo72062n(int i10);

    /* renamed from: o */
    void mo72063o(BackupItem backupItem, BackupItem backupItem2, int i10, Supplier<Float> supplier);

    /* renamed from: p */
    void mo72064p(boolean z10, int i10);

    /* renamed from: q */
    void mo72065q(float f10);

    /* renamed from: r */
    void mo72066r(long j10);
}
