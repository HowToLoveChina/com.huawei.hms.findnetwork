package p397ji;

import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.json.JsonError;
import com.huawei.cloud.base.json.JsonErrorContainer;
import java.io.IOException;
import p369ii.InterfaceC10510a;

/* renamed from: ji.a */
/* loaded from: classes.dex */
public abstract class AbstractC10891a<T> implements InterfaceC10510a<T, JsonErrorContainer> {
    public abstract void onFailure(JsonError jsonError, C4609l c4609l) throws IOException;

    @Override // p369ii.InterfaceC10510a
    public final void onFailure(JsonErrorContainer jsonErrorContainer, C4609l c4609l) throws IOException {
        onFailure(jsonErrorContainer.getError(), c4609l);
    }
}
