package com.ready2die.javaBeans.io;

import com.ready2die.javaBeans.TemporaryDirectory;

import java.io.IOException;

public class TemporaryDirectorySerializer extends com.cedarsoft.serialization.jackson.AbstractJacksonSerializer<TemporaryDirectory> {
    public static final String PROPERTY_SERIAL_VERSION_UID = "serialVersionUID";

    @javax.inject.Inject
    public TemporaryDirectorySerializer(@org.jetbrains.annotations.NotNull LongSerializer longSerializer) {
        super("temporary-directory", com.cedarsoft.version.VersionRange.from(1, 0, 0).to());
        getDelegatesMappings().add(longSerializer).responsibleFor(Long.class).map(1, 0, 0).toDelegateVersion(1, 0, 0);
        assert getDelegatesMappings().verify();
    }

    @Override
    public void serialize(@org.jetbrains.annotations.NotNull com.fasterxml.jackson.core.JsonGenerator serializeTo, @org.jetbrains.annotations.NotNull TemporaryDirectory object, @org.jetbrains.annotations.NotNull com.cedarsoft.version.Version formatVersion) throws IOException, com.cedarsoft.version.VersionException, com.fasterxml.jackson.core.JsonProcessingException {
        verifyVersionWritable(formatVersion);
        serialize(object.getSerialVersionUID(), Long.class, PROPERTY_SERIAL_VERSION_UID, serializeTo, formatVersion);
    }

    @Override
    @org.jetbrains.annotations.NotNull
    public TemporaryDirectory deserialize(@org.jetbrains.annotations.NotNull com.fasterxml.jackson.core.JsonParser deserializeFrom, @org.jetbrains.annotations.NotNull com.cedarsoft.version.Version formatVersion) throws IOException, com.cedarsoft.version.VersionException, com.fasterxml.jackson.core.JsonProcessingException {
        verifyVersionReadable(formatVersion);

        long serialVersionUID = -1;

        com.cedarsoft.serialization.jackson.JacksonParserWrapper parser = new com.cedarsoft.serialization.jackson.JacksonParserWrapper(deserializeFrom);
        while (parser.nextToken() == com.fasterxml.jackson.core.JsonToken.FIELD_NAME) {
            String currentName = parser.getCurrentName();

            if (currentName.equals(PROPERTY_SERIAL_VERSION_UID)) {
                parser.nextToken();
                serialVersionUID = deserialize(Long.class, formatVersion, deserializeFrom);
                continue;
            }
            throw new IllegalStateException("Unexpected field reached <" + currentName + ">");
        }

        parser.verifyDeserialized(serialVersionUID, PROPERTY_SERIAL_VERSION_UID);

        parser.ensureObjectClosed();

        TemporaryDirectory object = new TemporaryDirectory();
        object.setSerialVersionUID(serialVersionUID);
        return object;
    }
}
