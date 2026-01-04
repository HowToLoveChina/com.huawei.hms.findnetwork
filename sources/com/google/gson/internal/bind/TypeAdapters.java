package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes.dex */
public final class TypeAdapters {
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
    public static final TypeAdapter<BigInteger> BIG_INTEGER;
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter<Currency> CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<LazilyParsedNumber> LAZILY_PARSED_NUMBER;
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$1 */
    public class C20411 extends TypeAdapter<Class> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Class read2(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$10 */
    public class C204210 extends TypeAdapter<AtomicIntegerArray> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public AtomicIntegerArray read2(JsonReader jsonReader) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                jsonWriter.value(atomicIntegerArray.get(i10));
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$11 */
    public class C204311 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.longValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$12 */
    public class C204412 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$13 */
    public class C204513 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.doubleValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$14 */
    public class C204614 extends TypeAdapter<Character> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Character read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            if (strNextString.length() == 1) {
                return Character.valueOf(strNextString.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + strNextString + "; at " + jsonReader.getPreviousPath());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Character ch2) throws IOException {
            jsonWriter.value(ch2 == null ? null : String.valueOf(ch2));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$15 */
    public class C204715 extends TypeAdapter<String> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public String read2(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (jsonTokenPeek != JsonToken.NULL) {
                return jsonTokenPeek == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.nextBoolean()) : jsonReader.nextString();
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$16 */
    public class C204816 extends TypeAdapter<BigDecimal> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public BigDecimal read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            try {
                return new BigDecimal(strNextString);
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as BigDecimal; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
            jsonWriter.value(bigDecimal);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$17 */
    public class C204917 extends TypeAdapter<BigInteger> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public BigInteger read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            try {
                return new BigInteger(strNextString);
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as BigInteger; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
            jsonWriter.value(bigInteger);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$18 */
    public class C205018 extends TypeAdapter<LazilyParsedNumber> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public LazilyParsedNumber read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new LazilyParsedNumber(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, LazilyParsedNumber lazilyParsedNumber) throws IOException {
            jsonWriter.value(lazilyParsedNumber);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$19 */
    public class C205119 extends TypeAdapter<StringBuilder> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public StringBuilder read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuilder sb2) throws IOException {
            jsonWriter.value(sb2 == null ? null : sb2.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$2 */
    public class C20522 extends TypeAdapter<BitSet> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public BitSet read2(JsonReader jsonReader) throws IOException, NumberFormatException {
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            JsonToken jsonTokenPeek = jsonReader.peek();
            int i10 = 0;
            while (jsonTokenPeek != JsonToken.END_ARRAY) {
                int i11 = C206935.$SwitchMap$com$google$gson$stream$JsonToken[jsonTokenPeek.ordinal()];
                if (i11 == 1 || i11 == 2) {
                    int iNextInt = jsonReader.nextInt();
                    if (iNextInt != 0) {
                        if (iNextInt != 1) {
                            throw new JsonSyntaxException("Invalid bitset value " + iNextInt + ", expected 0 or 1; at path " + jsonReader.getPreviousPath());
                        }
                        bitSet.set(i10);
                    } else {
                        continue;
                    }
                } else {
                    if (i11 != 3) {
                        throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenPeek + "; at path " + jsonReader.getPath());
                    }
                    if (jsonReader.nextBoolean()) {
                        bitSet.set(i10);
                    }
                }
                i10++;
                jsonTokenPeek = jsonReader.peek();
            }
            jsonReader.endArray();
            return bitSet;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                jsonWriter.value(bitSet.get(i10) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$20 */
    public class C205320 extends TypeAdapter<StringBuffer> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public StringBuffer read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$21 */
    public class C205421 extends TypeAdapter<URL> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public URL read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            if ("null".equals(strNextString)) {
                return null;
            }
            return new URL(strNextString);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, URL url) throws IOException {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$22 */
    public class C205522 extends TypeAdapter<URI> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public URI read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String strNextString = jsonReader.nextString();
                if ("null".equals(strNextString)) {
                    return null;
                }
                return new URI(strNextString);
            } catch (URISyntaxException e10) {
                throw new JsonIOException(e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, URI uri) throws IOException {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$23 */
    public class C205623 extends TypeAdapter<InetAddress> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public InetAddress read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$24 */
    public class C205724 extends TypeAdapter<UUID> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public UUID read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            try {
                return UUID.fromString(strNextString);
            } catch (IllegalArgumentException e10) {
                throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as UUID; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$25 */
    public class C205825 extends TypeAdapter<Currency> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Currency read2(JsonReader jsonReader) throws IOException {
            String strNextString = jsonReader.nextString();
            try {
                return Currency.getInstance(strNextString);
            } catch (IllegalArgumentException e10) {
                throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as Currency; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$26 */
    public class C205926 extends TypeAdapter<Calendar> {
        private static final String DAY_OF_MONTH = "dayOfMonth";
        private static final String HOUR_OF_DAY = "hourOfDay";
        private static final String MINUTE = "minute";
        private static final String MONTH = "month";
        private static final String SECOND = "second";
        private static final String YEAR = "year";

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Calendar read2(JsonReader jsonReader) throws IOException, NumberFormatException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String strNextName = jsonReader.nextName();
                int iNextInt = jsonReader.nextInt();
                if (YEAR.equals(strNextName)) {
                    i10 = iNextInt;
                } else if (MONTH.equals(strNextName)) {
                    i11 = iNextInt;
                } else if (DAY_OF_MONTH.equals(strNextName)) {
                    i12 = iNextInt;
                } else if (HOUR_OF_DAY.equals(strNextName)) {
                    i13 = iNextInt;
                } else if (MINUTE.equals(strNextName)) {
                    i14 = iNextInt;
                } else if (SECOND.equals(strNextName)) {
                    i15 = iNextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(YEAR);
            jsonWriter.value(calendar.get(1));
            jsonWriter.name(MONTH);
            jsonWriter.value(calendar.get(2));
            jsonWriter.name(DAY_OF_MONTH);
            jsonWriter.value(calendar.get(5));
            jsonWriter.name(HOUR_OF_DAY);
            jsonWriter.value(calendar.get(11));
            jsonWriter.name(MINUTE);
            jsonWriter.value(calendar.get(12));
            jsonWriter.name(SECOND);
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$27 */
    public class C206027 extends TypeAdapter<Locale> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Locale read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$28 */
    public class C206128 extends TypeAdapter<JsonElement> {
        private JsonElement readTerminal(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
            int i10 = C206935.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
            if (i10 == 1) {
                return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
            }
            if (i10 == 2) {
                return new JsonPrimitive(jsonReader.nextString());
            }
            if (i10 == 3) {
                return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
            }
            if (i10 == 6) {
                jsonReader.nextNull();
                return JsonNull.INSTANCE;
            }
            throw new IllegalStateException("Unexpected token: " + jsonToken);
        }

        private JsonElement tryBeginNesting(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
            int i10 = C206935.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
            if (i10 == 4) {
                jsonReader.beginArray();
                return new JsonArray();
            }
            if (i10 != 5) {
                return null;
            }
            jsonReader.beginObject();
            return new JsonObject();
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public JsonElement read2(JsonReader jsonReader) throws IOException {
            if (jsonReader instanceof JsonTreeReader) {
                return ((JsonTreeReader) jsonReader).nextJsonElement();
            }
            JsonToken jsonTokenPeek = jsonReader.peek();
            JsonElement jsonElementTryBeginNesting = tryBeginNesting(jsonReader, jsonTokenPeek);
            if (jsonElementTryBeginNesting == null) {
                return readTerminal(jsonReader, jsonTokenPeek);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (jsonReader.hasNext()) {
                    String strNextName = jsonElementTryBeginNesting instanceof JsonObject ? jsonReader.nextName() : null;
                    JsonToken jsonTokenPeek2 = jsonReader.peek();
                    JsonElement jsonElementTryBeginNesting2 = tryBeginNesting(jsonReader, jsonTokenPeek2);
                    boolean z10 = jsonElementTryBeginNesting2 != null;
                    if (jsonElementTryBeginNesting2 == null) {
                        jsonElementTryBeginNesting2 = readTerminal(jsonReader, jsonTokenPeek2);
                    }
                    if (jsonElementTryBeginNesting instanceof JsonArray) {
                        ((JsonArray) jsonElementTryBeginNesting).add(jsonElementTryBeginNesting2);
                    } else {
                        ((JsonObject) jsonElementTryBeginNesting).add(strNextName, jsonElementTryBeginNesting2);
                    }
                    if (z10) {
                        arrayDeque.addLast(jsonElementTryBeginNesting);
                        jsonElementTryBeginNesting = jsonElementTryBeginNesting2;
                    }
                } else {
                    if (jsonElementTryBeginNesting instanceof JsonArray) {
                        jsonReader.endArray();
                    } else {
                        jsonReader.endObject();
                    }
                    if (arrayDeque.isEmpty()) {
                        return jsonElementTryBeginNesting;
                    }
                    jsonElementTryBeginNesting = (JsonElement) arrayDeque.removeLast();
                }
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                jsonWriter.nullValue();
                return;
            }
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    jsonWriter.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    jsonWriter.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    jsonWriter.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement.isJsonArray()) {
                jsonWriter.beginArray();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(jsonWriter, it.next());
                }
                jsonWriter.endArray();
                return;
            }
            if (!jsonElement.isJsonObject()) {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
            jsonWriter.beginObject();
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                jsonWriter.name(entry.getKey());
                write(jsonWriter, entry.getValue());
            }
            jsonWriter.endObject();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$29 */
    public class C206229 implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new EnumTypeAdapter(rawType);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$3 */
    public class C20633 extends TypeAdapter<Boolean> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Boolean read2(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (jsonTokenPeek != JsonToken.NULL) {
                return jsonTokenPeek == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString())) : Boolean.valueOf(jsonReader.nextBoolean());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$30 */
    public class C206430 implements TypeAdapterFactory {
        final /* synthetic */ TypeAdapter val$typeAdapter;

        public C206430(TypeAdapter typeAdapter) {
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.equals(typeToken)) {
                return typeAdapter;
            }
            return null;
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$31 */
    public class C206531 implements TypeAdapterFactory {
        final /* synthetic */ Class val$type;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        public C206531(Class cls, TypeAdapter typeAdapter) {
            cls = cls;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == cls) {
                return typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$32 */
    public class C206632 implements TypeAdapterFactory {
        final /* synthetic */ Class val$boxed;
        final /* synthetic */ TypeAdapter val$typeAdapter;
        final /* synthetic */ Class val$unboxed;

        public C206632(Class cls, Class cls2, TypeAdapter typeAdapter) {
            cls = cls;
            cls = cls2;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == cls || rawType == cls) {
                return typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + cls.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$33 */
    public class C206733 implements TypeAdapterFactory {
        final /* synthetic */ Class val$base;
        final /* synthetic */ Class val$sub;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        public C206733(Class cls, Class cls2, TypeAdapter typeAdapter) {
            cls = cls;
            cls = cls2;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == cls || rawType == cls) {
                return typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + cls.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$34 */
    public class C206834 implements TypeAdapterFactory {
        final /* synthetic */ Class val$clazz;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$34$1 */
        public class AnonymousClass1<T1> extends TypeAdapter<T1> {
            final /* synthetic */ Class val$requestedType;

            public AnonymousClass1(Class cls) {
                cls = cls;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public T1 read2(JsonReader jsonReader) throws IOException {
                T1 t12 = (T1) typeAdapter.read2(jsonReader);
                if (t12 == null || cls.isInstance(t12)) {
                    return t12;
                }
                throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + t12.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T1 t12) throws IOException {
                typeAdapter.write(jsonWriter, t12);
            }
        }

        public C206834(Class cls, TypeAdapter typeAdapter) {
            cls = cls;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
            Class<? super T2> rawType = typeToken.getRawType();
            if (cls.isAssignableFrom(rawType)) {
                return new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.34.1
                    final /* synthetic */ Class val$requestedType;

                    public AnonymousClass1(Class rawType2) {
                        cls = rawType2;
                    }

                    @Override // com.google.gson.TypeAdapter
                    /* renamed from: read */
                    public T1 read2(JsonReader jsonReader) throws IOException {
                        T1 t12 = (T1) typeAdapter.read2(jsonReader);
                        if (t12 == null || cls.isInstance(t12)) {
                            return t12;
                        }
                        throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + t12.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                    }

                    @Override // com.google.gson.TypeAdapter
                    public void write(JsonWriter jsonWriter, T1 t12) throws IOException {
                        typeAdapter.write(jsonWriter, t12);
                    }
                };
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$35 */
    public static /* synthetic */ class C206935 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$4 */
    public class C20704 extends TypeAdapter<Boolean> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Boolean read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool == null ? "null" : bool.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$5 */
    public class C20715 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int iNextInt = jsonReader.nextInt();
                if (iNextInt <= 255 && iNextInt >= -128) {
                    return Byte.valueOf((byte) iNextInt);
                }
                throw new JsonSyntaxException("Lossy conversion from " + iNextInt + " to byte; at path " + jsonReader.getPreviousPath());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.byteValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$6 */
    public class C20726 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int iNextInt = jsonReader.nextInt();
                if (iNextInt <= 65535 && iNextInt >= -32768) {
                    return Short.valueOf((short) iNextInt);
                }
                throw new JsonSyntaxException("Lossy conversion from " + iNextInt + " to short; at path " + jsonReader.getPreviousPath());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.shortValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$7 */
    public class C20737 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.intValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$8 */
    public class C20748 extends TypeAdapter<AtomicInteger> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public AtomicInteger read2(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
            jsonWriter.value(atomicInteger.get());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$9 */
    public class C20759 extends TypeAdapter<AtomicBoolean> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public AtomicBoolean read2(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
            jsonWriter.value(atomicBoolean.get());
        }
    }

    public static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> nameToConstant = new HashMap();
        private final Map<String, T> stringToConstant = new HashMap();
        private final Map<T, String> constantToName = new HashMap();

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$EnumTypeAdapter$1 */
        public class C20761 implements PrivilegedAction<Field[]> {
            final /* synthetic */ Class val$classOfT;

            public C20761(Class cls) {
                cls = cls;
            }

            @Override // java.security.PrivilegedAction
            public Field[] run() throws SecurityException {
                Field[] declaredFields = cls.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new PrivilegedAction<Field[]>() { // from class: com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter.1
                    final /* synthetic */ Class val$classOfT;

                    public C20761(Class cls2) {
                        cls = cls2;
                    }

                    @Override // java.security.PrivilegedAction
                    public Field[] run() throws SecurityException {
                        Field[] declaredFields = cls.getDeclaredFields();
                        ArrayList arrayList = new ArrayList(declaredFields.length);
                        for (Field field2 : declaredFields) {
                            if (field2.isEnumConstant()) {
                                arrayList.add(field2);
                            }
                        }
                        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                        AccessibleObject.setAccessible(fieldArr, true);
                        return fieldArr;
                    }
                })) {
                    Enum r42 = (Enum) field.get(null);
                    String strName = r42.name();
                    String string = r42.toString();
                    SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        strName = serializedName.value();
                        for (String str : serializedName.alternate()) {
                            this.nameToConstant.put(str, r42);
                        }
                    }
                    this.nameToConstant.put(strName, r42);
                    this.stringToConstant.put(string, r42);
                    this.constantToName.put(r42, strName);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            T t10 = this.nameToConstant.get(strNextString);
            return t10 == null ? this.stringToConstant.get(strNextString) : t10;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t10) throws IOException {
            jsonWriter.value(t10 == null ? null : this.constantToName.get(t10));
        }
    }

    static {
        TypeAdapter<Class> typeAdapterNullSafe = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Class read2(JsonReader jsonReader) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Class cls) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }
        }.nullSafe();
        CLASS = typeAdapterNullSafe;
        CLASS_FACTORY = newFactory(Class.class, typeAdapterNullSafe);
        TypeAdapter<BitSet> typeAdapterNullSafe2 = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public BitSet read2(JsonReader jsonReader) throws IOException, NumberFormatException {
                BitSet bitSet = new BitSet();
                jsonReader.beginArray();
                JsonToken jsonTokenPeek = jsonReader.peek();
                int i10 = 0;
                while (jsonTokenPeek != JsonToken.END_ARRAY) {
                    int i11 = C206935.$SwitchMap$com$google$gson$stream$JsonToken[jsonTokenPeek.ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        int iNextInt = jsonReader.nextInt();
                        if (iNextInt != 0) {
                            if (iNextInt != 1) {
                                throw new JsonSyntaxException("Invalid bitset value " + iNextInt + ", expected 0 or 1; at path " + jsonReader.getPreviousPath());
                            }
                            bitSet.set(i10);
                        } else {
                            continue;
                        }
                    } else {
                        if (i11 != 3) {
                            throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenPeek + "; at path " + jsonReader.getPath());
                        }
                        if (jsonReader.nextBoolean()) {
                            bitSet.set(i10);
                        }
                    }
                    i10++;
                    jsonTokenPeek = jsonReader.peek();
                }
                jsonReader.endArray();
                return bitSet;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
                jsonWriter.beginArray();
                int length = bitSet.length();
                for (int i10 = 0; i10 < length; i10++) {
                    jsonWriter.value(bitSet.get(i10) ? 1L : 0L);
                }
                jsonWriter.endArray();
            }
        }.nullSafe();
        BIT_SET = typeAdapterNullSafe2;
        BIT_SET_FACTORY = newFactory(BitSet.class, typeAdapterNullSafe2);
        C20633 c20633 = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Boolean read2(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenPeek = jsonReader.peek();
                if (jsonTokenPeek != JsonToken.NULL) {
                    return jsonTokenPeek == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString())) : Boolean.valueOf(jsonReader.nextBoolean());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                jsonWriter.value(bool);
            }
        };
        BOOLEAN = c20633;
        BOOLEAN_AS_STRING = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Boolean read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Boolean.valueOf(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                jsonWriter.value(bool == null ? "null" : bool.toString());
            }
        };
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, c20633);
        C20715 c20715 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    int iNextInt = jsonReader.nextInt();
                    if (iNextInt <= 255 && iNextInt >= -128) {
                        return Byte.valueOf((byte) iNextInt);
                    }
                    throw new JsonSyntaxException("Lossy conversion from " + iNextInt + " to byte; at path " + jsonReader.getPreviousPath());
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.byteValue());
                }
            }
        };
        BYTE = c20715;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, c20715);
        C20726 c20726 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    int iNextInt = jsonReader.nextInt();
                    if (iNextInt <= 65535 && iNextInt >= -32768) {
                        return Short.valueOf((short) iNextInt);
                    }
                    throw new JsonSyntaxException("Lossy conversion from " + iNextInt + " to short; at path " + jsonReader.getPreviousPath());
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.shortValue());
                }
            }
        };
        SHORT = c20726;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, c20726);
        C20737 c20737 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader.nextInt());
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.intValue());
                }
            }
        };
        INTEGER = c20737;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, c20737);
        TypeAdapter<AtomicInteger> typeAdapterNullSafe3 = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public AtomicInteger read2(JsonReader jsonReader) throws IOException {
                try {
                    return new AtomicInteger(jsonReader.nextInt());
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
                jsonWriter.value(atomicInteger.get());
            }
        }.nullSafe();
        ATOMIC_INTEGER = typeAdapterNullSafe3;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, typeAdapterNullSafe3);
        TypeAdapter<AtomicBoolean> typeAdapterNullSafe4 = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public AtomicBoolean read2(JsonReader jsonReader) throws IOException {
                return new AtomicBoolean(jsonReader.nextBoolean());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
                jsonWriter.value(atomicBoolean.get());
            }
        }.nullSafe();
        ATOMIC_BOOLEAN = typeAdapterNullSafe4;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, typeAdapterNullSafe4);
        TypeAdapter<AtomicIntegerArray> typeAdapterNullSafe5 = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public AtomicIntegerArray read2(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    try {
                        arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                    } catch (NumberFormatException e10) {
                        throw new JsonSyntaxException(e10);
                    }
                }
                jsonReader.endArray();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i10 = 0; i10 < size; i10++) {
                    atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
                jsonWriter.beginArray();
                int length = atomicIntegerArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    jsonWriter.value(atomicIntegerArray.get(i10));
                }
                jsonWriter.endArray();
            }
        }.nullSafe();
        ATOMIC_INTEGER_ARRAY = typeAdapterNullSafe5;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, typeAdapterNullSafe5);
        LONG = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Long.valueOf(jsonReader.nextLong());
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.longValue());
                }
            }
        };
        FLOAT = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                if (!(number instanceof Float)) {
                    number = Float.valueOf(number.floatValue());
                }
                jsonWriter.value(number);
            }
        };
        DOUBLE = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.doubleValue());
                }
            }
        };
        C204614 c204614 = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Character read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString = jsonReader.nextString();
                if (strNextString.length() == 1) {
                    return Character.valueOf(strNextString.charAt(0));
                }
                throw new JsonSyntaxException("Expecting character, got: " + strNextString + "; at " + jsonReader.getPreviousPath());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Character ch2) throws IOException {
                jsonWriter.value(ch2 == null ? null : String.valueOf(ch2));
            }
        };
        CHARACTER = c204614;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, c204614);
        C204715 c204715 = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public String read2(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenPeek = jsonReader.peek();
                if (jsonTokenPeek != JsonToken.NULL) {
                    return jsonTokenPeek == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.nextBoolean()) : jsonReader.nextString();
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, String str) throws IOException {
                jsonWriter.value(str);
            }
        };
        STRING = c204715;
        BIG_DECIMAL = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public BigDecimal read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString = jsonReader.nextString();
                try {
                    return new BigDecimal(strNextString);
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as BigDecimal; at path " + jsonReader.getPreviousPath(), e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
                jsonWriter.value(bigDecimal);
            }
        };
        BIG_INTEGER = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public BigInteger read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString = jsonReader.nextString();
                try {
                    return new BigInteger(strNextString);
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as BigInteger; at path " + jsonReader.getPreviousPath(), e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
                jsonWriter.value(bigInteger);
            }
        };
        LAZILY_PARSED_NUMBER = new TypeAdapter<LazilyParsedNumber>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public LazilyParsedNumber read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return new LazilyParsedNumber(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, LazilyParsedNumber lazilyParsedNumber) throws IOException {
                jsonWriter.value(lazilyParsedNumber);
            }
        };
        STRING_FACTORY = newFactory(String.class, c204715);
        C205119 c205119 = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public StringBuilder read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return new StringBuilder(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, StringBuilder sb2) throws IOException {
                jsonWriter.value(sb2 == null ? null : sb2.toString());
            }
        };
        STRING_BUILDER = c205119;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, c205119);
        C205320 c205320 = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public StringBuffer read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return new StringBuffer(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
                jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        STRING_BUFFER = c205320;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, c205320);
        C205421 c205421 = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public URL read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString = jsonReader.nextString();
                if ("null".equals(strNextString)) {
                    return null;
                }
                return new URL(strNextString);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, URL url) throws IOException {
                jsonWriter.value(url == null ? null : url.toExternalForm());
            }
        };
        URL = c205421;
        URL_FACTORY = newFactory(URL.class, c205421);
        C205522 c205522 = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public URI read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    String strNextString = jsonReader.nextString();
                    if ("null".equals(strNextString)) {
                        return null;
                    }
                    return new URI(strNextString);
                } catch (URISyntaxException e10) {
                    throw new JsonIOException(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, URI uri) throws IOException {
                jsonWriter.value(uri == null ? null : uri.toASCIIString());
            }
        };
        URI = c205522;
        URI_FACTORY = newFactory(URI.class, c205522);
        C205623 c205623 = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public InetAddress read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return InetAddress.getByName(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
                jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        INET_ADDRESS = c205623;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, c205623);
        C205724 c205724 = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public UUID read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString = jsonReader.nextString();
                try {
                    return UUID.fromString(strNextString);
                } catch (IllegalArgumentException e10) {
                    throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as UUID; at path " + jsonReader.getPreviousPath(), e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
                jsonWriter.value(uuid == null ? null : uuid.toString());
            }
        };
        UUID = c205724;
        UUID_FACTORY = newFactory(UUID.class, c205724);
        TypeAdapter<Currency> typeAdapterNullSafe6 = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Currency read2(JsonReader jsonReader) throws IOException {
                String strNextString = jsonReader.nextString();
                try {
                    return Currency.getInstance(strNextString);
                } catch (IllegalArgumentException e10) {
                    throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as Currency; at path " + jsonReader.getPreviousPath(), e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
                jsonWriter.value(currency.getCurrencyCode());
            }
        }.nullSafe();
        CURRENCY = typeAdapterNullSafe6;
        CURRENCY_FACTORY = newFactory(Currency.class, typeAdapterNullSafe6);
        C205926 c205926 = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            private static final String DAY_OF_MONTH = "dayOfMonth";
            private static final String HOUR_OF_DAY = "hourOfDay";
            private static final String MINUTE = "minute";
            private static final String MONTH = "month";
            private static final String SECOND = "second";
            private static final String YEAR = "year";

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Calendar read2(JsonReader jsonReader) throws IOException, NumberFormatException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                jsonReader.beginObject();
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String strNextName = jsonReader.nextName();
                    int iNextInt = jsonReader.nextInt();
                    if (YEAR.equals(strNextName)) {
                        i10 = iNextInt;
                    } else if (MONTH.equals(strNextName)) {
                        i11 = iNextInt;
                    } else if (DAY_OF_MONTH.equals(strNextName)) {
                        i12 = iNextInt;
                    } else if (HOUR_OF_DAY.equals(strNextName)) {
                        i13 = iNextInt;
                    } else if (MINUTE.equals(strNextName)) {
                        i14 = iNextInt;
                    } else if (SECOND.equals(strNextName)) {
                        i15 = iNextInt;
                    }
                }
                jsonReader.endObject();
                return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
                if (calendar == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                jsonWriter.name(YEAR);
                jsonWriter.value(calendar.get(1));
                jsonWriter.name(MONTH);
                jsonWriter.value(calendar.get(2));
                jsonWriter.name(DAY_OF_MONTH);
                jsonWriter.value(calendar.get(5));
                jsonWriter.name(HOUR_OF_DAY);
                jsonWriter.value(calendar.get(11));
                jsonWriter.name(MINUTE);
                jsonWriter.value(calendar.get(12));
                jsonWriter.name(SECOND);
                jsonWriter.value(calendar.get(13));
                jsonWriter.endObject();
            }
        };
        CALENDAR = c205926;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, c205926);
        C206027 c206027 = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Locale read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
                jsonWriter.value(locale == null ? null : locale.toString());
            }
        };
        LOCALE = c206027;
        LOCALE_FACTORY = newFactory(Locale.class, c206027);
        C206128 c206128 = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            private JsonElement readTerminal(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
                int i10 = C206935.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
                if (i10 == 1) {
                    return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
                }
                if (i10 == 2) {
                    return new JsonPrimitive(jsonReader.nextString());
                }
                if (i10 == 3) {
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
                }
                if (i10 == 6) {
                    jsonReader.nextNull();
                    return JsonNull.INSTANCE;
                }
                throw new IllegalStateException("Unexpected token: " + jsonToken);
            }

            private JsonElement tryBeginNesting(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
                int i10 = C206935.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
                if (i10 == 4) {
                    jsonReader.beginArray();
                    return new JsonArray();
                }
                if (i10 != 5) {
                    return null;
                }
                jsonReader.beginObject();
                return new JsonObject();
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public JsonElement read2(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    return ((JsonTreeReader) jsonReader).nextJsonElement();
                }
                JsonToken jsonTokenPeek = jsonReader.peek();
                JsonElement jsonElementTryBeginNesting = tryBeginNesting(jsonReader, jsonTokenPeek);
                if (jsonElementTryBeginNesting == null) {
                    return readTerminal(jsonReader, jsonTokenPeek);
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                while (true) {
                    if (jsonReader.hasNext()) {
                        String strNextName = jsonElementTryBeginNesting instanceof JsonObject ? jsonReader.nextName() : null;
                        JsonToken jsonTokenPeek2 = jsonReader.peek();
                        JsonElement jsonElementTryBeginNesting2 = tryBeginNesting(jsonReader, jsonTokenPeek2);
                        boolean z10 = jsonElementTryBeginNesting2 != null;
                        if (jsonElementTryBeginNesting2 == null) {
                            jsonElementTryBeginNesting2 = readTerminal(jsonReader, jsonTokenPeek2);
                        }
                        if (jsonElementTryBeginNesting instanceof JsonArray) {
                            ((JsonArray) jsonElementTryBeginNesting).add(jsonElementTryBeginNesting2);
                        } else {
                            ((JsonObject) jsonElementTryBeginNesting).add(strNextName, jsonElementTryBeginNesting2);
                        }
                        if (z10) {
                            arrayDeque.addLast(jsonElementTryBeginNesting);
                            jsonElementTryBeginNesting = jsonElementTryBeginNesting2;
                        }
                    } else {
                        if (jsonElementTryBeginNesting instanceof JsonArray) {
                            jsonReader.endArray();
                        } else {
                            jsonReader.endObject();
                        }
                        if (arrayDeque.isEmpty()) {
                            return jsonElementTryBeginNesting;
                        }
                        jsonElementTryBeginNesting = (JsonElement) arrayDeque.removeLast();
                    }
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    jsonWriter.nullValue();
                    return;
                }
                if (jsonElement.isJsonPrimitive()) {
                    JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                    if (asJsonPrimitive.isNumber()) {
                        jsonWriter.value(asJsonPrimitive.getAsNumber());
                        return;
                    } else if (asJsonPrimitive.isBoolean()) {
                        jsonWriter.value(asJsonPrimitive.getAsBoolean());
                        return;
                    } else {
                        jsonWriter.value(asJsonPrimitive.getAsString());
                        return;
                    }
                }
                if (jsonElement.isJsonArray()) {
                    jsonWriter.beginArray();
                    Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        write(jsonWriter, it.next());
                    }
                    jsonWriter.endArray();
                    return;
                }
                if (!jsonElement.isJsonObject()) {
                    throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
                }
                jsonWriter.beginObject();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
            }
        };
        JSON_ELEMENT = c206128;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, c206128);
        ENUM_FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new EnumTypeAdapter(rawType);
            }
        };
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            final /* synthetic */ TypeAdapter val$typeAdapter;

            public C206430(TypeAdapter typeAdapter2) {
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
                if (typeToken2.equals(typeToken)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> cls, Class<? extends TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            final /* synthetic */ Class val$base;
            final /* synthetic */ Class val$sub;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            public C206733(Class cls3, Class cls22, TypeAdapter typeAdapter2) {
                cls = cls3;
                cls = cls22;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(Class<T1> cls, TypeAdapter<T1> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            final /* synthetic */ Class val$clazz;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            /* renamed from: com.google.gson.internal.bind.TypeAdapters$34$1 */
            public class AnonymousClass1<T1> extends TypeAdapter<T1> {
                final /* synthetic */ Class val$requestedType;

                public AnonymousClass1(Class rawType2) {
                    cls = rawType2;
                }

                @Override // com.google.gson.TypeAdapter
                /* renamed from: read */
                public T1 read2(JsonReader jsonReader) throws IOException {
                    T1 t12 = (T1) typeAdapter.read2(jsonReader);
                    if (t12 == null || cls.isInstance(t12)) {
                        return t12;
                    }
                    throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + t12.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, T1 t12) throws IOException {
                    typeAdapter.write(jsonWriter, t12);
                }
            }

            public C206834(Class cls2, TypeAdapter typeAdapter2) {
                cls = cls2;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
                Class rawType2 = typeToken.getRawType();
                if (cls.isAssignableFrom(rawType2)) {
                    return new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.34.1
                        final /* synthetic */ Class val$requestedType;

                        public AnonymousClass1(Class rawType22) {
                            cls = rawType22;
                        }

                        @Override // com.google.gson.TypeAdapter
                        /* renamed from: read */
                        public T1 read2(JsonReader jsonReader) throws IOException {
                            T1 t12 = (T1) typeAdapter.read2(jsonReader);
                            if (t12 == null || cls.isInstance(t12)) {
                                return t12;
                            }
                            throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + t12.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void write(JsonWriter jsonWriter, T1 t12) throws IOException {
                            typeAdapter.write(jsonWriter, t12);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            final /* synthetic */ Class val$type;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            public C206531(Class cls2, TypeAdapter typeAdapter2) {
                cls = cls2;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, Class<TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            final /* synthetic */ Class val$boxed;
            final /* synthetic */ TypeAdapter val$typeAdapter;
            final /* synthetic */ Class val$unboxed;

            public C206632(Class cls3, Class cls22, TypeAdapter typeAdapter2) {
                cls = cls3;
                cls = cls22;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
