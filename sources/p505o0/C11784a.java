package p505o0;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.OsConstants;
import android.util.Log;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import p505o0.C11785b;

/* renamed from: o0.a */
/* loaded from: classes.dex */
public class C11784a {

    /* renamed from: T */
    public static SimpleDateFormat f54519T;

    /* renamed from: U */
    public static SimpleDateFormat f54520U;

    /* renamed from: Y */
    public static final d[] f54524Y;

    /* renamed from: Z */
    public static final d[] f54525Z;

    /* renamed from: a0 */
    public static final d[] f54526a0;

    /* renamed from: b0 */
    public static final d[] f54527b0;

    /* renamed from: c0 */
    public static final d[] f54528c0;

    /* renamed from: d0 */
    public static final d f54529d0;

    /* renamed from: e0 */
    public static final d[] f54530e0;

    /* renamed from: f0 */
    public static final d[] f54531f0;

    /* renamed from: g0 */
    public static final d[] f54532g0;

    /* renamed from: h0 */
    public static final d[] f54533h0;

    /* renamed from: i0 */
    public static final d[][] f54534i0;

    /* renamed from: j0 */
    public static final d[] f54535j0;

    /* renamed from: k0 */
    public static final HashMap<Integer, d>[] f54536k0;

    /* renamed from: l0 */
    public static final HashMap<String, d>[] f54537l0;

    /* renamed from: m0 */
    public static final HashSet<String> f54538m0;

    /* renamed from: n0 */
    public static final HashMap<Integer, Integer> f54539n0;

    /* renamed from: o0 */
    public static final Charset f54540o0;

    /* renamed from: p0 */
    public static final byte[] f54541p0;

    /* renamed from: q0 */
    public static final byte[] f54542q0;

    /* renamed from: r0 */
    public static final Pattern f54543r0;

    /* renamed from: s0 */
    public static final Pattern f54544s0;

    /* renamed from: t0 */
    public static final Pattern f54545t0;

    /* renamed from: u0 */
    public static final Pattern f54547u0;

    /* renamed from: a */
    public String f54553a;

    /* renamed from: b */
    public FileDescriptor f54554b;

    /* renamed from: c */
    public AssetManager.AssetInputStream f54555c;

    /* renamed from: d */
    public int f54556d;

    /* renamed from: e */
    public boolean f54557e;

    /* renamed from: f */
    public final HashMap<String, c>[] f54558f;

    /* renamed from: g */
    public Set<Integer> f54559g;

    /* renamed from: h */
    public ByteOrder f54560h;

    /* renamed from: i */
    public boolean f54561i;

    /* renamed from: j */
    public boolean f54562j;

    /* renamed from: k */
    public boolean f54563k;

    /* renamed from: l */
    public int f54564l;

    /* renamed from: m */
    public int f54565m;

    /* renamed from: n */
    public byte[] f54566n;

    /* renamed from: o */
    public int f54567o;

    /* renamed from: p */
    public int f54568p;

    /* renamed from: q */
    public int f54569q;

    /* renamed from: r */
    public int f54570r;

    /* renamed from: s */
    public int f54571s;

    /* renamed from: t */
    public boolean f54572t;

    /* renamed from: u */
    public static final boolean f54546u = Log.isLoggable("ExifInterface", 3);

    /* renamed from: v */
    public static final List<Integer> f54548v = Arrays.asList(1, 6, 3, 8);

    /* renamed from: w */
    public static final List<Integer> f54549w = Arrays.asList(2, 7, 4, 5);

    /* renamed from: x */
    public static final int[] f54550x = {8, 8, 8};

    /* renamed from: y */
    public static final int[] f54551y = {4};

    /* renamed from: z */
    public static final int[] f54552z = {8};

    /* renamed from: A */
    public static final byte[] f54500A = {-1, -40, -1};

    /* renamed from: B */
    public static final byte[] f54501B = {102, 116, 121, 112};

    /* renamed from: C */
    public static final byte[] f54502C = {109, 105, 102, 49};

    /* renamed from: D */
    public static final byte[] f54503D = {104, 101, 105, 99};

    /* renamed from: E */
    public static final byte[] f54504E = {79, 76, 89, 77, 80, 0};

    /* renamed from: F */
    public static final byte[] f54505F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: G */
    public static final byte[] f54506G = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: H */
    public static final byte[] f54507H = {101, 88, 73, 102};

    /* renamed from: I */
    public static final byte[] f54508I = {73, 72, 68, 82};

    /* renamed from: J */
    public static final byte[] f54509J = {73, 69, 78, 68};

    /* renamed from: K */
    public static final byte[] f54510K = {82, 73, 70, 70};

    /* renamed from: L */
    public static final byte[] f54511L = {87, 69, 66, 80};

    /* renamed from: M */
    public static final byte[] f54512M = {69, 88, 73, 70};

    /* renamed from: N */
    public static final byte[] f54513N = {-99, 1, 42};

    /* renamed from: O */
    public static final byte[] f54514O = "VP8X".getBytes(Charset.defaultCharset());

    /* renamed from: P */
    public static final byte[] f54515P = "VP8L".getBytes(Charset.defaultCharset());

    /* renamed from: Q */
    public static final byte[] f54516Q = "VP8 ".getBytes(Charset.defaultCharset());

    /* renamed from: R */
    public static final byte[] f54517R = "ANIM".getBytes(Charset.defaultCharset());

    /* renamed from: S */
    public static final byte[] f54518S = "ANMF".getBytes(Charset.defaultCharset());

    /* renamed from: V */
    public static final String[] f54521V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: W */
    public static final int[] f54522W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: X */
    public static final byte[] f54523X = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: o0.a$a */
    public class a extends MediaDataSource {

        /* renamed from: a */
        public long f54573a;

        /* renamed from: b */
        public final /* synthetic */ f f54574b;

        public a(f fVar) {
            this.f54574b = fVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j10, byte[] bArr, int i10, int i11) throws IOException {
            if (i11 == 0) {
                return 0;
            }
            if (j10 < 0) {
                return -1;
            }
            try {
                long j11 = this.f54573a;
                if (j11 != j10) {
                    if (j11 >= 0 && j10 >= j11 + this.f54574b.available()) {
                        return -1;
                    }
                    this.f54574b.seek(j10);
                    this.f54573a = j10;
                }
                if (i11 > this.f54574b.available()) {
                    i11 = this.f54574b.available();
                }
                int i12 = this.f54574b.read(bArr, i10, i11);
                if (i12 >= 0) {
                    this.f54573a += i12;
                    return i12;
                }
            } catch (IOException unused) {
            }
            this.f54573a = -1L;
            return -1;
        }
    }

    /* renamed from: o0.a$b */
    public static class b extends InputStream implements DataInput {

        /* renamed from: e */
        public static final ByteOrder f54576e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f */
        public static final ByteOrder f54577f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a */
        public final DataInputStream f54578a;

        /* renamed from: b */
        public ByteOrder f54579b;

        /* renamed from: c */
        public int f54580c;

        /* renamed from: d */
        public byte[] f54581d;

        public b(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f54578a.available();
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.f54580c++;
            return this.f54578a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.f54580c++;
            return this.f54578a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f54580c++;
            int i10 = this.f54578a.read();
            if (i10 >= 0) {
                return (byte) i10;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.f54580c += 2;
            return this.f54578a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i10, int i11) throws IOException {
            this.f54580c += i11;
            this.f54578a.readFully(bArr, i10, i11);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f54580c += 4;
            int i10 = this.f54578a.read();
            int i11 = this.f54578a.read();
            int i12 = this.f54578a.read();
            int i13 = this.f54578a.read();
            if ((i10 | i11 | i12 | i13) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f54579b;
            if (byteOrder == f54576e) {
                return (i13 << 24) + (i12 << 16) + (i11 << 8) + i10;
            }
            if (byteOrder == f54577f) {
                return (i10 << 24) + (i11 << 16) + (i12 << 8) + i13;
            }
            throw new IOException("Invalid byte order: " + this.f54579b);
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f54580c += 8;
            int i10 = this.f54578a.read();
            int i11 = this.f54578a.read();
            int i12 = this.f54578a.read();
            int i13 = this.f54578a.read();
            int i14 = this.f54578a.read();
            int i15 = this.f54578a.read();
            int i16 = this.f54578a.read();
            int i17 = this.f54578a.read();
            if ((i10 | i11 | i12 | i13 | i14 | i15 | i16 | i17) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f54579b;
            if (byteOrder == f54576e) {
                return (i17 << 56) + (i16 << 48) + (i15 << 40) + (i14 << 32) + (i13 << 24) + (i12 << 16) + (i11 << 8) + i10;
            }
            if (byteOrder == f54577f) {
                return (i10 << 56) + (i11 << 48) + (i12 << 40) + (i13 << 32) + (i14 << 24) + (i15 << 16) + (i16 << 8) + i17;
            }
            throw new IOException("Invalid byte order: " + this.f54579b);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i10;
            this.f54580c += 2;
            int i11 = this.f54578a.read();
            int i12 = this.f54578a.read();
            if ((i11 | i12) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f54579b;
            if (byteOrder == f54576e) {
                i10 = (i12 << 8) + i11;
            } else {
                if (byteOrder != f54577f) {
                    throw new IOException("Invalid byte order: " + this.f54579b);
                }
                i10 = (i11 << 8) + i12;
            }
            return (short) i10;
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.f54580c += 2;
            return this.f54578a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.f54580c++;
            return this.f54578a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f54580c += 2;
            int i10 = this.f54578a.read();
            int i11 = this.f54578a.read();
            if ((i10 | i11) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f54579b;
            if (byteOrder == f54576e) {
                return (i11 << 8) + i10;
            }
            if (byteOrder == f54577f) {
                return (i10 << 8) + i11;
            }
            throw new IOException("Invalid byte order: " + this.f54579b);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        /* renamed from: s */
        public int m70222s() {
            return this.f54580c;
        }

        @Override // java.io.DataInput
        public int skipBytes(int i10) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        /* renamed from: t */
        public long m70223t() throws IOException {
            return readInt() & 4294967295L;
        }

        /* renamed from: u */
        public void m70224u(ByteOrder byteOrder) {
            this.f54579b = byteOrder;
        }

        /* renamed from: v */
        public void m70225v(int i10) throws IOException {
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i10 - i11;
                int iSkip = (int) this.f54578a.skip(i12);
                if (iSkip <= 0) {
                    if (this.f54581d == null) {
                        this.f54581d = new byte[8192];
                    }
                    iSkip = this.f54578a.read(this.f54581d, 0, Math.min(8192, i12));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i10 + " bytes.");
                    }
                }
                i11 += iSkip;
            }
            this.f54580c += i11;
        }

        public b(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f54579b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f54578a = dataInputStream;
            dataInputStream.mark(0);
            this.f54580c = 0;
            this.f54579b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = this.f54578a.read(bArr, i10, i11);
            this.f54580c += i12;
            return i12;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f54580c += bArr.length;
            this.f54578a.readFully(bArr);
        }
    }

    /* renamed from: o0.a$e */
    public static class e {

        /* renamed from: a */
        public final long f54590a;

        /* renamed from: b */
        public final long f54591b;

        public e(long j10, long j11) {
            if (j11 == 0) {
                this.f54590a = 0L;
                this.f54591b = 1L;
            } else {
                this.f54590a = j10;
                this.f54591b = j11;
            }
        }

        /* renamed from: a */
        public double m70238a() {
            return this.f54590a / this.f54591b;
        }

        public String toString() {
            return this.f54590a + "/" + this.f54591b;
        }
    }

    static {
        d[] dVarArr = {new d("NewSubfileType", Constant.ERROR_ROAD_AREA_INVALID, 4), new d("SubfileType", HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", Constants.INTERSTITIAL_WIDTH, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", LocationRequest.PRIORITY_MAG_POSITION, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", ErrorCode.ERROR_NATIVE_AD_NO, 1)};
        f54524Y = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f54525Z = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        f54526a0 = dVarArr3;
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        f54527b0 = dVarArr4;
        d[] dVarArr5 = {new d("NewSubfileType", Constant.ERROR_ROAD_AREA_INVALID, 4), new d("SubfileType", HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", Constants.INTERSTITIAL_WIDTH, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", LocationRequest.PRIORITY_MAG_POSITION, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Xmp", ErrorCode.ERROR_NATIVE_AD_NO, 1), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f54528c0 = dVarArr5;
        f54529d0 = new d("StripOffsets", 273, 3);
        d[] dVarArr6 = {new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        f54530e0 = dVarArr6;
        d[] dVarArr7 = {new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4)};
        f54531f0 = dVarArr7;
        d[] dVarArr8 = {new d("AspectFrame", 4371, 3)};
        f54532g0 = dVarArr8;
        d[] dVarArr9 = {new d("ColorSpace", 55, 3)};
        f54533h0 = dVarArr9;
        d[][] dVarArr10 = {dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, dVarArr6, dVarArr7, dVarArr8, dVarArr9};
        f54534i0 = dVarArr10;
        f54535j0 = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        f54536k0 = new HashMap[dVarArr10.length];
        f54537l0 = new HashMap[dVarArr10.length];
        f54538m0 = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f54539n0 = new HashMap<>();
        Charset charsetForName = Charset.forName("US-ASCII");
        f54540o0 = charsetForName;
        f54541p0 = "Exif\u0000\u0000".getBytes(charsetForName);
        f54542q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        f54519T = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        f54520U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i10 = 0;
        while (true) {
            d[][] dVarArr11 = f54534i0;
            if (i10 >= dVarArr11.length) {
                HashMap<Integer, Integer> map = f54539n0;
                d[] dVarArr12 = f54535j0;
                map.put(Integer.valueOf(dVarArr12[0].f54586a), 5);
                map.put(Integer.valueOf(dVarArr12[1].f54586a), 1);
                map.put(Integer.valueOf(dVarArr12[2].f54586a), 2);
                map.put(Integer.valueOf(dVarArr12[3].f54586a), 3);
                map.put(Integer.valueOf(dVarArr12[4].f54586a), 7);
                map.put(Integer.valueOf(dVarArr12[5].f54586a), 8);
                f54543r0 = Pattern.compile(".*[1-9].*");
                f54544s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f54545t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f54547u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f54536k0[i10] = new HashMap<>();
            f54537l0[i10] = new HashMap<>();
            for (d dVar : dVarArr11[i10]) {
                f54536k0[i10].put(Integer.valueOf(dVar.f54586a), dVar);
                f54537l0[i10].put(dVar.f54587b, dVar);
            }
            i10++;
        }
    }

    public C11784a(InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    /* renamed from: K */
    public static boolean m70182K(int i10) {
        return (i10 == 4 || i10 == 9 || i10 == 13 || i10 == 14) ? false : true;
    }

    /* renamed from: q */
    public static boolean m70183q(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f54541p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i10 = 0;
        while (true) {
            byte[] bArr3 = f54541p0;
            if (i10 >= bArr3.length) {
                return true;
            }
            if (bArr2[i10] != bArr3[i10]) {
                return false;
            }
            i10++;
        }
    }

    /* renamed from: s */
    public static boolean m70184s(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f54500A;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    /* renamed from: x */
    public static boolean m70185x(FileDescriptor fileDescriptor) {
        try {
            C11785b.a.m70244c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!f54546u) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    /* renamed from: A */
    public final boolean m70186A(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f54510K;
            if (i10 >= bArr2.length) {
                int i11 = 0;
                while (true) {
                    byte[] bArr3 = f54511L;
                    if (i11 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[f54510K.length + i11 + 4] != bArr3[i11]) {
                        return false;
                    }
                    i11++;
                }
            } else {
                if (bArr[i10] != bArr2[i10]) {
                    return false;
                }
                i10++;
            }
        }
    }

    /* renamed from: B */
    public final void m70187B(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("inputstream shouldn't be null");
        }
        for (int i10 = 0; i10 < f54534i0.length; i10++) {
            try {
                try {
                    this.f54558f[i10] = new HashMap<>();
                } catch (IOException | UnsupportedOperationException e10) {
                    boolean z10 = f54546u;
                    if (z10) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e10);
                    }
                    m70199a();
                    if (!z10) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                m70199a();
                if (f54546u) {
                    m70189D();
                }
                throw th2;
            }
        }
        if (!this.f54557e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.f54556d = m70205g(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (m70182K(this.f54556d)) {
            f fVar = new f(inputStream);
            if (this.f54557e) {
                m70211m(fVar);
            } else {
                int i11 = this.f54556d;
                if (i11 == 12) {
                    m70203e(fVar);
                } else if (i11 == 7) {
                    m70206h(fVar);
                } else if (i11 == 10) {
                    m70210l(fVar);
                } else {
                    m70209k(fVar);
                }
            }
            fVar.seek(this.f54568p);
            m70195J(fVar);
        } else {
            b bVar = new b(inputStream);
            int i12 = this.f54556d;
            if (i12 == 4) {
                m70204f(bVar, 0, 0);
            } else if (i12 == 13) {
                m70207i(bVar);
            } else if (i12 == 9) {
                m70208j(bVar);
            } else if (i12 == 14) {
                m70212n(bVar);
            }
        }
        m70199a();
        if (!f54546u) {
            return;
        }
        m70189D();
    }

    /* renamed from: C */
    public final void m70188C(b bVar) throws IOException {
        ByteOrder byteOrderM70190E = m70190E(bVar);
        this.f54560h = byteOrderM70190E;
        bVar.m70224u(byteOrderM70190E);
        int unsignedShort = bVar.readUnsignedShort();
        int i10 = this.f54556d;
        if (i10 != 7 && i10 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i11 = bVar.readInt();
        if (i11 < 8) {
            throw new IOException("Invalid first Ifd offset: " + i11);
        }
        int i12 = i11 - 8;
        if (i12 > 0) {
            bVar.m70225v(i12);
        }
    }

    /* renamed from: D */
    public final void m70189D() {
        for (int i10 = 0; i10 < this.f54558f.length; i10++) {
            Log.d("ExifInterface", "The size of tag group[" + i10 + "]: " + this.f54558f[i10].size());
            for (Map.Entry<String, c> entry : this.f54558f[i10].entrySet()) {
                c value = entry.getValue();
                Log.d("ExifInterface", "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.m70235j(this.f54560h) + "'");
            }
        }
    }

    /* renamed from: E */
    public final ByteOrder m70190E(b bVar) throws IOException {
        short s10 = bVar.readShort();
        if (s10 == 18761) {
            if (f54546u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s10 == 19789) {
            if (f54546u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s10));
    }

    /* renamed from: F */
    public final void m70191F(byte[] bArr, int i10) throws IOException {
        f fVar = new f(bArr);
        m70188C(fVar);
        m70192G(fVar, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0272  */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m70192G(p505o0.C11784a.f r28, int r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p505o0.C11784a.m70192G(o0.a$f, int):void");
    }

    /* renamed from: H */
    public final void m70193H(int i10, String str, String str2) {
        if (this.f54558f[i10].isEmpty() || this.f54558f[i10].get(str) == null) {
            return;
        }
        HashMap<String, c> map = this.f54558f[i10];
        map.put(str2, map.get(str));
        this.f54558f[i10].remove(str);
    }

    /* renamed from: I */
    public final void m70194I(f fVar, int i10) throws Throwable {
        c cVar = this.f54558f[i10].get("ImageLength");
        c cVar2 = this.f54558f[i10].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = this.f54558f[i10].get("JPEGInterchangeFormat");
            c cVar4 = this.f54558f[i10].get("JPEGInterchangeFormatLength");
            if (cVar3 == null || cVar4 == null) {
                return;
            }
            int iM70234i = cVar3.m70234i(this.f54560h);
            int iM70234i2 = cVar3.m70234i(this.f54560h);
            fVar.seek(iM70234i);
            byte[] bArr = new byte[iM70234i2];
            fVar.read(bArr);
            m70204f(new b(bArr), iM70234i, i10);
        }
    }

    /* renamed from: J */
    public final void m70195J(b bVar) throws Throwable {
        HashMap<String, c> map = this.f54558f[4];
        c cVar = map.get("Compression");
        if (cVar == null) {
            this.f54567o = 6;
            m70213o(bVar, map);
            return;
        }
        int iM70234i = cVar.m70234i(this.f54560h);
        this.f54567o = iM70234i;
        if (iM70234i != 1) {
            if (iM70234i == 6) {
                m70213o(bVar, map);
                return;
            } else if (iM70234i != 7) {
                return;
            }
        }
        if (m70220y(map)) {
            m70214p(bVar, map);
        }
    }

    /* renamed from: L */
    public final void m70196L(int i10, int i11) throws Throwable {
        if (this.f54558f[i10].isEmpty() || this.f54558f[i11].isEmpty()) {
            if (f54546u) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        c cVar = this.f54558f[i10].get("ImageLength");
        c cVar2 = this.f54558f[i10].get("ImageWidth");
        c cVar3 = this.f54558f[i11].get("ImageLength");
        c cVar4 = this.f54558f[i11].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            if (f54546u) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (cVar3 == null || cVar4 == null) {
            if (f54546u) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iM70234i = cVar.m70234i(this.f54560h);
        int iM70234i2 = cVar2.m70234i(this.f54560h);
        int iM70234i3 = cVar3.m70234i(this.f54560h);
        int iM70234i4 = cVar4.m70234i(this.f54560h);
        if (iM70234i >= iM70234i3 || iM70234i2 >= iM70234i4) {
            return;
        }
        HashMap<String, c>[] mapArr = this.f54558f;
        HashMap<String, c> map = mapArr[i10];
        mapArr[i10] = mapArr[i11];
        mapArr[i11] = map;
    }

    /* renamed from: M */
    public final void m70197M(f fVar, int i10) throws Throwable {
        c cVarM70231f;
        c cVarM70231f2;
        c cVar = this.f54558f[i10].get("DefaultCropSize");
        c cVar2 = this.f54558f[i10].get("SensorTopBorder");
        c cVar3 = this.f54558f[i10].get("SensorLeftBorder");
        c cVar4 = this.f54558f[i10].get("SensorBottomBorder");
        c cVar5 = this.f54558f[i10].get("SensorRightBorder");
        if (cVar == null) {
            if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
                m70194I(fVar, i10);
                return;
            }
            int iM70234i = cVar2.m70234i(this.f54560h);
            int iM70234i2 = cVar4.m70234i(this.f54560h);
            int iM70234i3 = cVar5.m70234i(this.f54560h);
            int iM70234i4 = cVar3.m70234i(this.f54560h);
            if (iM70234i2 <= iM70234i || iM70234i3 <= iM70234i4) {
                return;
            }
            c cVarM70231f3 = c.m70231f(iM70234i2 - iM70234i, this.f54560h);
            c cVarM70231f4 = c.m70231f(iM70234i3 - iM70234i4, this.f54560h);
            this.f54558f[i10].put("ImageLength", cVarM70231f3);
            this.f54558f[i10].put("ImageWidth", cVarM70231f4);
            return;
        }
        if (cVar.f54582a == 5) {
            e[] eVarArr = (e[]) cVar.m70236k(this.f54560h);
            if (eVarArr == null || eVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(eVarArr));
                return;
            }
            cVarM70231f = c.m70229d(eVarArr[0], this.f54560h);
            cVarM70231f2 = c.m70229d(eVarArr[1], this.f54560h);
        } else {
            int[] iArr = (int[]) cVar.m70236k(this.f54560h);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            cVarM70231f = c.m70231f(iArr[0], this.f54560h);
            cVarM70231f2 = c.m70231f(iArr[1], this.f54560h);
        }
        this.f54558f[i10].put("ImageWidth", cVarM70231f);
        this.f54558f[i10].put("ImageLength", cVarM70231f2);
    }

    /* renamed from: N */
    public final void m70198N() throws Throwable {
        m70196L(0, 5);
        m70196L(0, 4);
        m70196L(5, 4);
        c cVar = this.f54558f[1].get("PixelXDimension");
        c cVar2 = this.f54558f[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            this.f54558f[0].put("ImageWidth", cVar);
            this.f54558f[0].put("ImageLength", cVar2);
        }
        if (this.f54558f[4].isEmpty() && m70221z(this.f54558f[5])) {
            HashMap<String, c>[] mapArr = this.f54558f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        if (!m70221z(this.f54558f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        m70193H(0, "ThumbnailOrientation", "Orientation");
        m70193H(0, "ThumbnailImageLength", "ImageLength");
        m70193H(0, "ThumbnailImageWidth", "ImageWidth");
        m70193H(5, "ThumbnailOrientation", "Orientation");
        m70193H(5, "ThumbnailImageLength", "ImageLength");
        m70193H(5, "ThumbnailImageWidth", "ImageWidth");
        m70193H(4, "Orientation", "ThumbnailOrientation");
        m70193H(4, "ImageLength", "ThumbnailImageLength");
        m70193H(4, "ImageWidth", "ThumbnailImageWidth");
    }

    /* renamed from: a */
    public final void m70199a() {
        String strM70200b = m70200b("DateTimeOriginal");
        if (strM70200b != null && m70200b("DateTime") == null) {
            this.f54558f[0].put("DateTime", c.m70226a(strM70200b));
        }
        if (m70200b("ImageWidth") == null) {
            this.f54558f[0].put("ImageWidth", c.m70227b(0L, this.f54560h));
        }
        if (m70200b("ImageLength") == null) {
            this.f54558f[0].put("ImageLength", c.m70227b(0L, this.f54560h));
        }
        if (m70200b("Orientation") == null) {
            this.f54558f[0].put("Orientation", c.m70227b(0L, this.f54560h));
        }
        if (m70200b("LightSource") == null) {
            this.f54558f[1].put("LightSource", c.m70227b(0L, this.f54560h));
        }
    }

    /* renamed from: b */
    public String m70200b(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c cVarM70202d = m70202d(str);
        if (cVarM70202d != null) {
            if (!f54538m0.contains(str)) {
                return cVarM70202d.m70235j(this.f54560h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i10 = cVarM70202d.f54582a;
                if (i10 != 5 && i10 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + cVarM70202d.f54582a);
                    return null;
                }
                e[] eVarArr = (e[]) cVarM70202d.m70236k(this.f54560h);
                if (eVarArr == null || eVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr));
                    return null;
                }
                e eVar = eVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (eVar.f54590a / eVar.f54591b));
                e eVar2 = eVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (eVar2.f54590a / eVar2.f54591b));
                e eVar3 = eVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (eVar3.f54590a / eVar3.f54591b)));
            }
            try {
                return Double.toString(cVarM70202d.m70233h(this.f54560h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* renamed from: c */
    public int m70201c(String str, int i10) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c cVarM70202d = m70202d(str);
        if (cVarM70202d == null) {
            return i10;
        }
        try {
            return cVarM70202d.m70234i(this.f54560h);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    /* renamed from: d */
    public final c m70202d(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (f54546u) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i10 = 0; i10 < f54534i0.length; i10++) {
            c cVar = this.f54558f[i10].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    /* renamed from: e */
    public final void m70203e(f fVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                C11785b.b.m70245a(mediaMetadataRetriever, new a(fVar));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                if (strExtractMetadata != null) {
                    this.f54558f[0].put("ImageWidth", c.m70231f(Integer.parseInt(strExtractMetadata), this.f54560h));
                }
                if (strExtractMetadata2 != null) {
                    this.f54558f[0].put("ImageLength", c.m70231f(Integer.parseInt(strExtractMetadata2), this.f54560h));
                }
                if (strExtractMetadata3 != null) {
                    int i10 = Integer.parseInt(strExtractMetadata3);
                    this.f54558f[0].put("Orientation", c.m70231f(i10 != 90 ? i10 != 180 ? i10 != 270 ? 1 : 8 : 3 : 6, this.f54560h));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i11 = Integer.parseInt(strExtractMetadata4);
                    int i12 = Integer.parseInt(strExtractMetadata5);
                    if (i12 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.seek(i11);
                    byte[] bArr = new byte[6];
                    if (fVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i13 = i11 + 6;
                    int i14 = i12 - 6;
                    if (!Arrays.equals(bArr, f54541p0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i14];
                    if (fVar.read(bArr2) != i14) {
                        throw new IOException("Can't read exif");
                    }
                    this.f54568p = i13;
                    m70191F(bArr2, 0);
                }
                if (f54546u) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + Constants.MULTIPLE_SIGN + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th2) {
            mediaMetadataRetriever.release();
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0191, code lost:
    
        r22.m70224u(r21.f54560h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0196, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017b A[LOOP:0: B:10:0x0037->B:63:0x017b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0182 A[SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m70204f(p505o0.C11784a.b r22, int r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p505o0.C11784a.m70204f(o0.a$b, int, int):void");
    }

    /* renamed from: g */
    public final int m70205g(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (m70184s(bArr)) {
            return 4;
        }
        if (m70218v(bArr)) {
            return 9;
        }
        if (m70215r(bArr)) {
            return 12;
        }
        if (m70216t(bArr)) {
            return 7;
        }
        if (m70219w(bArr)) {
            return 10;
        }
        if (m70217u(bArr)) {
            return 13;
        }
        return m70186A(bArr) ? 14 : 0;
    }

    /* renamed from: h */
    public final void m70206h(f fVar) throws Throwable {
        int i10;
        int i11;
        m70209k(fVar);
        c cVar = this.f54558f[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.f54585d);
            fVar2.m70224u(this.f54560h);
            byte[] bArr = f54504E;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.seek(0L);
            byte[] bArr3 = f54505F;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.seek(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.seek(12L);
            }
            m70192G(fVar2, 6);
            c cVar2 = this.f54558f[7].get("PreviewImageStart");
            c cVar3 = this.f54558f[7].get("PreviewImageLength");
            if (cVar2 != null && cVar3 != null) {
                this.f54558f[5].put("JPEGInterchangeFormat", cVar2);
                this.f54558f[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = this.f54558f[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.m70236k(this.f54560h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i12 = iArr[2];
                int i13 = iArr[0];
                if (i12 <= i13 || (i10 = iArr[3]) <= (i11 = iArr[1])) {
                    return;
                }
                int i14 = (i12 - i13) + 1;
                int i15 = (i10 - i11) + 1;
                if (i14 < i15) {
                    int i16 = i14 + i15;
                    i15 = i16 - i15;
                    i14 = i16 - i15;
                }
                c cVarM70231f = c.m70231f(i14, this.f54560h);
                c cVarM70231f2 = c.m70231f(i15, this.f54560h);
                this.f54558f[0].put("ImageWidth", cVarM70231f);
                this.f54558f[0].put("ImageLength", cVarM70231f2);
            }
        }
    }

    /* renamed from: i */
    public final void m70207i(b bVar) throws Throwable {
        if (f54546u) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.m70224u(ByteOrder.BIG_ENDIAN);
        byte[] bArr = f54506G;
        bVar.m70225v(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i10 = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i11 = length + 8;
                if (i11 == 16 && !Arrays.equals(bArr2, f54508I)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f54509J)) {
                    return;
                }
                if (Arrays.equals(bArr2, f54507H)) {
                    byte[] bArr3 = new byte[i10];
                    if (bVar.read(bArr3) != i10) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + C11785b.m70239a(bArr2));
                    }
                    int i12 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i12) {
                        this.f54568p = i11;
                        m70191F(bArr3, 0);
                        m70198N();
                        m70195J(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i12 + ", calculated CRC value: " + crc32.getValue());
                }
                int i13 = i10 + 4;
                bVar.m70225v(i13);
                length = i11 + i13;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    /* renamed from: j */
    public final void m70208j(b bVar) throws Throwable {
        boolean z10 = f54546u;
        if (z10) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.m70225v(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        int i12 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i11];
        bVar.m70225v(i10 - bVar.m70222s());
        bVar.read(bArr4);
        m70204f(new b(bArr4), i10, 5);
        bVar.m70225v(i12 - bVar.m70222s());
        bVar.m70224u(ByteOrder.BIG_ENDIAN);
        int i13 = bVar.readInt();
        if (z10) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i13);
        }
        for (int i14 = 0; i14 < i13; i14++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == f54529d0.f54586a) {
                short s10 = bVar.readShort();
                short s11 = bVar.readShort();
                c cVarM70231f = c.m70231f(s10, this.f54560h);
                c cVarM70231f2 = c.m70231f(s11, this.f54560h);
                this.f54558f[0].put("ImageLength", cVarM70231f);
                this.f54558f[0].put("ImageWidth", cVarM70231f2);
                if (f54546u) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s10) + ", width: " + ((int) s11));
                    return;
                }
                return;
            }
            bVar.m70225v(unsignedShort2);
        }
    }

    /* renamed from: k */
    public final void m70209k(f fVar) throws Throwable {
        c cVar;
        m70188C(fVar);
        m70192G(fVar, 0);
        m70197M(fVar, 0);
        m70197M(fVar, 5);
        m70197M(fVar, 4);
        m70198N();
        if (this.f54556d != 8 || (cVar = this.f54558f[1].get("MakerNote")) == null) {
            return;
        }
        f fVar2 = new f(cVar.f54585d);
        fVar2.m70224u(this.f54560h);
        fVar2.m70225v(6);
        m70192G(fVar2, 9);
        c cVar2 = this.f54558f[9].get("ColorSpace");
        if (cVar2 != null) {
            this.f54558f[1].put("ColorSpace", cVar2);
        }
    }

    /* renamed from: l */
    public final void m70210l(f fVar) throws Throwable {
        if (f54546u) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + fVar);
        }
        m70209k(fVar);
        c cVar = this.f54558f[0].get("JpgFromRaw");
        if (cVar != null) {
            m70204f(new b(cVar.f54585d), (int) cVar.f54584c, 5);
        }
        c cVar2 = this.f54558f[0].get("ISO");
        c cVar3 = this.f54558f[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        this.f54558f[1].put("PhotographicSensitivity", cVar2);
    }

    /* renamed from: m */
    public final void m70211m(f fVar) throws IOException {
        byte[] bArr = f54541p0;
        fVar.m70225v(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.f54568p = bArr.length;
        m70191F(bArr2, 0);
    }

    /* renamed from: n */
    public final void m70212n(b bVar) throws Throwable {
        if (f54546u) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.m70224u(ByteOrder.LITTLE_ENDIAN);
        bVar.m70225v(f54510K.length);
        int i10 = bVar.readInt() + 8;
        byte[] bArr = f54511L;
        bVar.m70225v(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i11 = bVar.readInt();
                int i12 = length + 8;
                if (Arrays.equals(f54512M, bArr2)) {
                    byte[] bArr3 = new byte[i11];
                    if (bVar.read(bArr3) == i11) {
                        this.f54568p = i12;
                        m70191F(bArr3, 0);
                        m70195J(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + C11785b.m70239a(bArr2));
                    }
                }
                if (i11 % 2 == 1) {
                    i11++;
                }
                length = i12 + i11;
                if (length == i10) {
                    return;
                }
                if (length > i10) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.m70225v(i11);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* renamed from: o */
    public final void m70213o(b bVar, HashMap map) throws Throwable {
        c cVar = (c) map.get("JPEGInterchangeFormat");
        c cVar2 = (c) map.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int iM70234i = cVar.m70234i(this.f54560h);
        int iM70234i2 = cVar2.m70234i(this.f54560h);
        if (this.f54556d == 7) {
            iM70234i += this.f54569q;
        }
        if (iM70234i > 0 && iM70234i2 > 0) {
            this.f54561i = true;
            if (this.f54553a == null && this.f54555c == null && this.f54554b == null) {
                byte[] bArr = new byte[iM70234i2];
                bVar.skip(iM70234i);
                bVar.read(bArr);
                this.f54566n = bArr;
            }
            this.f54564l = iM70234i;
            this.f54565m = iM70234i2;
        }
        if (f54546u) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iM70234i + ", length: " + iM70234i2);
        }
    }

    /* renamed from: p */
    public final void m70214p(b bVar, HashMap map) throws IOException {
        c cVar = (c) map.get("StripOffsets");
        c cVar2 = (c) map.get("StripByteCounts");
        if (cVar == null || cVar2 == null) {
            return;
        }
        long[] jArrM70240b = C11785b.m70240b(cVar.m70236k(this.f54560h));
        long[] jArrM70240b2 = C11785b.m70240b(cVar2.m70236k(this.f54560h));
        if (jArrM70240b == null || jArrM70240b.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrM70240b2 == null || jArrM70240b2.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrM70240b.length != jArrM70240b2.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j10 = 0;
        for (long j11 : jArrM70240b2) {
            j10 += j11;
        }
        int i10 = (int) j10;
        byte[] bArr = new byte[i10];
        this.f54563k = true;
        this.f54562j = true;
        this.f54561i = true;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < jArrM70240b.length; i13++) {
            int i14 = (int) jArrM70240b[i13];
            int i15 = (int) jArrM70240b2[i13];
            if (i13 < jArrM70240b.length - 1 && i14 + i15 != jArrM70240b[i13 + 1]) {
                this.f54563k = false;
            }
            int i16 = i14 - i11;
            if (i16 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
                return;
            }
            long j12 = i16;
            if (bVar.skip(j12) != j12) {
                Log.d("ExifInterface", "Failed to skip " + i16 + " bytes.");
                return;
            }
            int i17 = i11 + i16;
            byte[] bArr2 = new byte[i15];
            if (bVar.read(bArr2) != i15) {
                Log.d("ExifInterface", "Failed to read " + i15 + " bytes.");
                return;
            }
            i11 = i17 + i15;
            System.arraycopy(bArr2, 0, bArr, i12, i15);
            i12 += i15;
        }
        this.f54566n = bArr;
        if (this.f54563k) {
            this.f54564l = (int) jArrM70240b[0];
            this.f54565m = i10;
        }
    }

    /* renamed from: r */
    public final boolean m70215r(byte[] bArr) throws Throwable {
        b bVar;
        long length;
        byte[] bArr2;
        long j10;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
                try {
                    length = bVar.readInt();
                    bArr2 = new byte[4];
                    bVar.read(bArr2);
                } catch (Exception e10) {
                    e = e10;
                    bVar2 = bVar;
                    if (f54546u) {
                        Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                    }
                    if (bVar2 != null) {
                        bVar2.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
        if (!Arrays.equals(bArr2, f54501B)) {
            bVar.close();
            return false;
        }
        if (length == 1) {
            length = bVar.readLong();
            j10 = 16;
            if (length < 16) {
                bVar.close();
                return false;
            }
        } else {
            j10 = 8;
        }
        if (length > bArr.length) {
            length = bArr.length;
        }
        long j11 = length - j10;
        if (j11 < 8) {
            bVar.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z10 = false;
        boolean z11 = false;
        for (long j12 = 0; j12 < j11 / 4; j12++) {
            if (bVar.read(bArr3) != 4) {
                bVar.close();
                return false;
            }
            if (j12 != 1) {
                if (Arrays.equals(bArr3, f54502C)) {
                    z10 = true;
                } else if (Arrays.equals(bArr3, f54503D)) {
                    z11 = true;
                }
                if (z10 && z11) {
                    bVar.close();
                    return true;
                }
            }
        }
        bVar.close();
        return false;
    }

    /* renamed from: t */
    public final boolean m70216t(byte[] bArr) throws Throwable {
        b bVar;
        b bVar2 = null;
        try {
            bVar = new b(bArr);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            ByteOrder byteOrderM70190E = m70190E(bVar);
            this.f54560h = byteOrderM70190E;
            bVar.m70224u(byteOrderM70190E);
            short s10 = bVar.readShort();
            boolean z10 = s10 == 20306 || s10 == 21330;
            bVar.close();
            return z10;
        } catch (Exception unused2) {
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
    }

    /* renamed from: u */
    public final boolean m70217u(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f54506G;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    /* renamed from: v */
    public final boolean m70218v(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (bArr[i10] != bytes[i10]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: w */
    public final boolean m70219w(byte[] bArr) throws Throwable {
        b bVar;
        b bVar2 = null;
        try {
            bVar = new b(bArr);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            ByteOrder byteOrderM70190E = m70190E(bVar);
            this.f54560h = byteOrderM70190E;
            bVar.m70224u(byteOrderM70190E);
            boolean z10 = bVar.readShort() == 85;
            bVar.close();
            return z10;
        } catch (Exception unused2) {
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
    }

    /* renamed from: y */
    public final boolean m70220y(HashMap map) throws IOException {
        c cVar;
        int iM70234i;
        c cVar2 = (c) map.get("BitsPerSample");
        if (cVar2 != null) {
            int[] iArr = (int[]) cVar2.m70236k(this.f54560h);
            int[] iArr2 = f54550x;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f54556d == 3 && (cVar = (c) map.get("PhotometricInterpretation")) != null && (((iM70234i = cVar.m70234i(this.f54560h)) == 1 && Arrays.equals(iArr, f54552z)) || (iM70234i == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f54546u) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    /* renamed from: z */
    public final boolean m70221z(HashMap map) throws IOException {
        c cVar = (c) map.get("ImageLength");
        c cVar2 = (c) map.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.m70234i(this.f54560h) <= 512 && cVar2.m70234i(this.f54560h) <= 512;
    }

    /* renamed from: o0.a$c */
    public static class c {

        /* renamed from: a */
        public final int f54582a;

        /* renamed from: b */
        public final int f54583b;

        /* renamed from: c */
        public final long f54584c;

        /* renamed from: d */
        public final byte[] f54585d;

        public c(int i10, int i11, byte[] bArr) {
            this(i10, i11, -1L, bArr);
        }

        /* renamed from: a */
        public static c m70226a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(C11784a.f54540o0);
            return new c(2, bytes.length, bytes);
        }

        /* renamed from: b */
        public static c m70227b(long j10, ByteOrder byteOrder) {
            return m70228c(new long[]{j10}, byteOrder);
        }

        /* renamed from: c */
        public static c m70228c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C11784a.f54522W[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j10 : jArr) {
                byteBufferWrap.putInt((int) j10);
            }
            return new c(4, jArr.length, byteBufferWrap.array());
        }

        /* renamed from: d */
        public static c m70229d(e eVar, ByteOrder byteOrder) {
            return m70230e(new e[]{eVar}, byteOrder);
        }

        /* renamed from: e */
        public static c m70230e(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C11784a.f54522W[5] * eVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (e eVar : eVarArr) {
                byteBufferWrap.putInt((int) eVar.f54590a);
                byteBufferWrap.putInt((int) eVar.f54591b);
            }
            return new c(5, eVarArr.length, byteBufferWrap.array());
        }

        /* renamed from: f */
        public static c m70231f(int i10, ByteOrder byteOrder) {
            return m70232g(new int[]{i10}, byteOrder);
        }

        /* renamed from: g */
        public static c m70232g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C11784a.f54522W[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i10 : iArr) {
                byteBufferWrap.putShort((short) i10);
            }
            return new c(3, iArr.length, byteBufferWrap.array());
        }

        /* renamed from: h */
        public double m70233h(ByteOrder byteOrder) throws Throwable {
            Object objM70236k = m70236k(byteOrder);
            if (objM70236k == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objM70236k instanceof String) {
                return Double.parseDouble((String) objM70236k);
            }
            if (objM70236k instanceof long[]) {
                if (((long[]) objM70236k).length == 1) {
                    return r3[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objM70236k instanceof int[]) {
                if (((int[]) objM70236k).length == 1) {
                    return r3[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objM70236k instanceof double[]) {
                double[] dArr = (double[]) objM70236k;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objM70236k instanceof e[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            e[] eVarArr = (e[]) objM70236k;
            if (eVarArr.length == 1) {
                return eVarArr[0].m70238a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        /* renamed from: i */
        public int m70234i(ByteOrder byteOrder) throws Throwable {
            Object objM70236k = m70236k(byteOrder);
            if (objM70236k == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objM70236k instanceof String) {
                return Integer.parseInt((String) objM70236k);
            }
            if (objM70236k instanceof long[]) {
                long[] jArr = (long[]) objM70236k;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objM70236k instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objM70236k;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        /* renamed from: j */
        public String m70235j(ByteOrder byteOrder) throws Throwable {
            Object objM70236k = m70236k(byteOrder);
            if (objM70236k == null) {
                return null;
            }
            if (objM70236k instanceof String) {
                return (String) objM70236k;
            }
            StringBuilder sb2 = new StringBuilder();
            int i10 = 0;
            if (objM70236k instanceof long[]) {
                long[] jArr = (long[]) objM70236k;
                while (i10 < jArr.length) {
                    sb2.append(jArr[i10]);
                    i10++;
                    if (i10 != jArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (objM70236k instanceof int[]) {
                int[] iArr = (int[]) objM70236k;
                while (i10 < iArr.length) {
                    sb2.append(iArr[i10]);
                    i10++;
                    if (i10 != iArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (objM70236k instanceof double[]) {
                double[] dArr = (double[]) objM70236k;
                while (i10 < dArr.length) {
                    sb2.append(dArr[i10]);
                    i10++;
                    if (i10 != dArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (!(objM70236k instanceof e[])) {
                return null;
            }
            e[] eVarArr = (e[]) objM70236k;
            while (i10 < eVarArr.length) {
                sb2.append(eVarArr[i10].f54590a);
                sb2.append(C5929g4.f26852n);
                sb2.append(eVarArr[i10].f54591b);
                i10++;
                if (i10 != eVarArr.length) {
                    sb2.append(",");
                }
            }
            return sb2.toString();
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0030: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:18:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:183:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* renamed from: k */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object m70236k(java.nio.ByteOrder r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 446
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p505o0.C11784a.c.m70236k(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + C11784a.f54521V[this.f54582a] + ", data length:" + this.f54585d.length + ")";
        }

        public c(int i10, int i11, long j10, byte[] bArr) {
            this.f54582a = i10;
            this.f54583b = i11;
            this.f54584c = j10;
            this.f54585d = bArr;
        }
    }

    /* renamed from: o0.a$f */
    public static class f extends b {
        public f(byte[] bArr) throws IOException {
            super(bArr);
            this.f54578a.mark(Integer.MAX_VALUE);
        }

        public void seek(long j10) throws IOException {
            int i10 = this.f54580c;
            if (i10 > j10) {
                this.f54580c = 0;
                this.f54578a.reset();
            } else {
                j10 -= i10;
            }
            m70225v((int) j10);
        }

        public f(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f54578a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C11784a(java.io.InputStream r4, int r5) throws java.io.IOException {
        /*
            r3 = this;
            r3.<init>()
            o0.a$d[][] r0 = p505o0.C11784a.f54534i0
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r3.f54558f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r3.f54559g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r3.f54560h = r0
            if (r4 == 0) goto L6a
            r0 = 0
            r3.f54553a = r0
            r1 = 1
            if (r5 != r1) goto L3c
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream
            byte[] r2 = p505o0.C11784a.f54541p0
            int r2 = r2.length
            r5.<init>(r4, r2)
            boolean r4 = m70183q(r5)
            if (r4 != 0) goto L34
            java.lang.String r3 = "ExifInterface"
            java.lang.String r4 = "Given data does not follow the structure of an Exif-only data."
            android.util.Log.w(r3, r4)
            return
        L34:
            r3.f54557e = r1
            r3.f54555c = r0
            r3.f54554b = r0
            r4 = r5
            goto L66
        L3c:
            boolean r5 = r4 instanceof android.content.res.AssetManager.AssetInputStream
            if (r5 == 0) goto L48
            r5 = r4
            android.content.res.AssetManager$AssetInputStream r5 = (android.content.res.AssetManager.AssetInputStream) r5
            r3.f54555c = r5
            r3.f54554b = r0
            goto L66
        L48:
            boolean r5 = r4 instanceof java.io.FileInputStream
            if (r5 == 0) goto L62
            r5 = r4
            java.io.FileInputStream r5 = (java.io.FileInputStream) r5
            java.io.FileDescriptor r1 = r5.getFD()
            boolean r1 = m70185x(r1)
            if (r1 == 0) goto L62
            r3.f54555c = r0
            java.io.FileDescriptor r5 = r5.getFD()
            r3.f54554b = r5
            goto L66
        L62:
            r3.f54555c = r0
            r3.f54554b = r0
        L66:
            r3.m70187B(r4)
            return
        L6a:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "inputStream cannot be null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p505o0.C11784a.<init>(java.io.InputStream, int):void");
    }

    /* renamed from: o0.a$d */
    public static class d {

        /* renamed from: a */
        public final int f54586a;

        /* renamed from: b */
        public final String f54587b;

        /* renamed from: c */
        public final int f54588c;

        /* renamed from: d */
        public final int f54589d;

        public d(String str, int i10, int i11) {
            this.f54587b = str;
            this.f54586a = i10;
            this.f54588c = i11;
            this.f54589d = -1;
        }

        /* renamed from: a */
        public boolean m70237a(int i10) {
            int i11;
            int i12 = this.f54588c;
            if (i12 == 7 || i10 == 7 || i12 == i10 || (i11 = this.f54589d) == i10) {
                return true;
            }
            if ((i12 == 4 || i11 == 4) && i10 == 3) {
                return true;
            }
            if ((i12 == 9 || i11 == 9) && i10 == 8) {
                return true;
            }
            return (i12 == 12 || i11 == 12) && i10 == 11;
        }

        public d(String str, int i10, int i11, int i12) {
            this.f54587b = str;
            this.f54586a = i10;
            this.f54588c = i11;
            this.f54589d = i12;
        }
    }
}
