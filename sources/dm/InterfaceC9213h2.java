package dm;

import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import fk.C9721b;
import im.AbstractC10548b;
import im.InterfaceC10570t;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.function.Consumer;
import p455ll.C11308a;

/* renamed from: dm.h2 */
/* loaded from: classes6.dex */
public interface InterfaceC9213h2 extends Closeable {
    /* renamed from: Q */
    File mo57841Q();

    /* renamed from: U */
    String mo57842U();

    /* renamed from: d0 */
    boolean mo57843d0();

    /* renamed from: e0 */
    String mo57844e0();

    String getName();

    String getParent();

    /* renamed from: h0 */
    C11308a mo57845h0(InterfaceC10570t interfaceC10570t, String str, int i10, String str2, String str3, C4879a c4879a, Consumer<AbstractC10548b> consumer, String str4) throws C9721b;

    /* renamed from: k0 */
    String mo57846k0(long j10) throws C9721b;

    long length();

    /* renamed from: p0 */
    long mo57847p0();

    /* renamed from: v0 */
    FileInputStream mo57848v0() throws FileNotFoundException;
}
