package p483n3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: n3.t */
/* loaded from: classes.dex */
public final class C11629t {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <K, V> void m69489a(InterfaceC11624o<K, V> interfaceC11624o, ObjectInputStream objectInputStream, int i10) throws IOException, ClassNotFoundException {
        for (int i11 = 0; i11 < i10; i11++) {
            Collection collection = interfaceC11624o.get(objectInputStream.readObject());
            int i12 = objectInputStream.readInt();
            for (int i13 = 0; i13 < i12; i13++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    /* renamed from: b */
    public static int m69490b(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    /* renamed from: c */
    public static <K, V> void m69491c(InterfaceC11624o<K, V> interfaceC11624o, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(interfaceC11624o.mo69358b().size());
        for (Map.Entry<K, Collection<V>> entry : interfaceC11624o.mo69358b().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }
}
