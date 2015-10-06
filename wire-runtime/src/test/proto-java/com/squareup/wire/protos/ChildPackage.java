// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ../wire-runtime/src/test/proto/child_pkg.proto at 22:1
package com.squareup.wire.protos;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.protos.foreign.ForeignEnum;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class ChildPackage extends Message<ChildPackage, ChildPackage.Builder> {
  public static final ProtoAdapter<ChildPackage> ADAPTER = new ProtoAdapter<ChildPackage>(FieldEncoding.LENGTH_DELIMITED, ChildPackage.class) {
    @Override
    public int encodedSize(ChildPackage value) {
      return (value.inner_foreign_enum != null ? ForeignEnum.ADAPTER.encodedSize(1, value.inner_foreign_enum) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, ChildPackage value) throws IOException {
      if (value.inner_foreign_enum != null) ForeignEnum.ADAPTER.encodeTagged(writer, 1, value.inner_foreign_enum);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public ChildPackage decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: {
            try {
              builder.inner_foreign_enum(ForeignEnum.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public ChildPackage redact(ChildPackage value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  };

  private static final long serialVersionUID = 0L;

  public static final ForeignEnum DEFAULT_INNER_FOREIGN_ENUM = ForeignEnum.BAV;

  public final ForeignEnum inner_foreign_enum;

  public ChildPackage(ForeignEnum inner_foreign_enum) {
    this(inner_foreign_enum, ByteString.EMPTY);
  }

  public ChildPackage(ForeignEnum inner_foreign_enum, ByteString unknownFields) {
    super(unknownFields);
    this.inner_foreign_enum = inner_foreign_enum;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.inner_foreign_enum = inner_foreign_enum;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof ChildPackage)) return false;
    ChildPackage o = (ChildPackage) other;
    return equals(unknownFields(), o.unknownFields())
        && equals(inner_foreign_enum, o.inner_foreign_enum);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (inner_foreign_enum != null ? inner_foreign_enum.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (inner_foreign_enum != null) builder.append(", inner_foreign_enum=").append(inner_foreign_enum);
    return builder.replace(0, 2, "ChildPackage{").append('}').toString();
  }

  public static final class Builder extends com.squareup.wire.Message.Builder<ChildPackage, Builder> {
    public ForeignEnum inner_foreign_enum;

    public Builder() {
    }

    public Builder inner_foreign_enum(ForeignEnum inner_foreign_enum) {
      this.inner_foreign_enum = inner_foreign_enum;
      return this;
    }

    @Override
    public ChildPackage build() {
      return new ChildPackage(inner_foreign_enum, buildUnknownFields());
    }
  }
}