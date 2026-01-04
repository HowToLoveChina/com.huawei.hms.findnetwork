package p680ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/* renamed from: ui.d */
/* loaded from: classes.dex */
public interface InterfaceC13180d<V extends Serializable> {
    /* renamed from: a */
    InterfaceC13180d<V> mo79227a(String str) throws IOException;

    /* renamed from: b */
    InterfaceC13180d<V> mo79228b(String str, V v10) throws IOException;

    /* renamed from: c */
    V mo79229c(String str) throws IOException;

    InterfaceC13180d<V> clear() throws IOException;

    boolean isEmpty() throws IOException;

    Set<String> keySet() throws IOException;

    Collection<V> values() throws IOException;
}
