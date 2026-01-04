package p723w;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* renamed from: w.i */
/* loaded from: classes.dex */
public class C13510i {

    /* renamed from: w.i$a */
    public static class a {
        /* renamed from: a */
        public static ParcelFileDescriptor m81259a(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
            return contentResolver.openFileDescriptor(uri, str, cancellationSignal);
        }
    }

    /* renamed from: a */
    public static ByteBuffer m81258a(Context context, CancellationSignal cancellationSignal, Uri uri) throws IOException {
        try {
            ParcelFileDescriptor parcelFileDescriptorM81259a = a.m81259a(context.getContentResolver(), uri, "r", cancellationSignal);
            if (parcelFileDescriptorM81259a == null) {
                if (parcelFileDescriptorM81259a != null) {
                    parcelFileDescriptorM81259a.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorM81259a.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorM81259a.close();
                    return map;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
