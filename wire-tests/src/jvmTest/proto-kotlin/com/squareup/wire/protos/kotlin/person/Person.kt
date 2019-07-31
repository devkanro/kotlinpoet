// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: person.proto
package com.squareup.wire.protos.kotlin.person

import com.squareup.wire.EnumAdapter
import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.WireEnum
import com.squareup.wire.WireField
import com.squareup.wire.internal.missingRequiredFields
import com.squareup.wire.internal.redactElements
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import okio.ByteString

/**
 * Message representing a person, includes their name, unique ID number, email and phone number.
 */
data class Person(
  /**
   * The customer's full name.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.REQUIRED
  )
  val name: String,
  /**
   * The customer's ID number.
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#INT32",
    label = WireField.Label.REQUIRED
  )
  val id: Int,
  /**
   * Email address for the customer.
   */
  @field:WireField(
    tag = 3,
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  val email: String? = null,
  /**
   * A list of the customer's phone numbers.
   */
  @field:WireField(
    tag = 4,
    adapter = "com.squareup.wire.protos.kotlin.person.Person${'$'}PhoneNumber#ADAPTER",
    label = WireField.Label.REPEATED
  )
  val phone: List<PhoneNumber> = emptyList(),
  val unknownFields: ByteString = ByteString.EMPTY
) : Message<Person, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing {
    throw AssertionError()
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Person) return false
    return unknownFields == other.unknownFields
        && name == other.name
        && id == other.id
        && email == other.email
        && phone == other.phone
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<Person> = object : ProtoAdapter<Person>(
      FieldEncoding.LENGTH_DELIMITED, 
      Person::class
    ) {
      override fun encodedSize(value: Person): Int = 
        ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) +
        ProtoAdapter.INT32.encodedSizeWithTag(2, value.id) +
        ProtoAdapter.STRING.encodedSizeWithTag(3, value.email) +
        PhoneNumber.ADAPTER.asRepeated().encodedSizeWithTag(4, value.phone) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: Person) {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name)
        ProtoAdapter.INT32.encodeWithTag(writer, 2, value.id)
        ProtoAdapter.STRING.encodeWithTag(writer, 3, value.email)
        PhoneNumber.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.phone)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): Person {
        var name: String? = null
        var id: Int? = null
        var email: String? = null
        val phone = mutableListOf<PhoneNumber>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> name = ProtoAdapter.STRING.decode(reader)
            2 -> id = ProtoAdapter.INT32.decode(reader)
            3 -> email = ProtoAdapter.STRING.decode(reader)
            4 -> phone.add(PhoneNumber.ADAPTER.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return Person(
          name = name ?: throw missingRequiredFields(name, "name"),
          id = id ?: throw missingRequiredFields(id, "id"),
          email = email,
          phone = phone,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: Person): Person = value.copy(
        phone = value.phone.redactElements(PhoneNumber.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }
  }

  /**
   * Represents the type of the phone number: mobile, home or work.
   */
  enum class PhoneType(
    override val value: Int
  ) : WireEnum {
    MOBILE(0),

    HOME(1),

    /**
     * Could be phone or fax.
     */
    WORK(2);

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<PhoneType> = object : EnumAdapter<PhoneType>(
        PhoneType::class
      ) {
        override fun fromValue(value: Int): PhoneType = PhoneType.fromValue(value)
      }

      @JvmStatic
      fun fromValue(value: Int): PhoneType = when (value) {
        0 -> MOBILE
        1 -> HOME
        2 -> WORK
        else -> throw IllegalArgumentException("""Unexpected value: $value""")
      }
    }
  }

  data class PhoneNumber(
    /**
     * The customer's phone number.
     */
    @field:WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
    )
    val number: String,
    /**
     * The type of phone stored here.
     */
    @field:WireField(
      tag = 2,
      adapter = "com.squareup.wire.protos.kotlin.person.Person${'$'}PhoneType#ADAPTER"
    )
    val type: PhoneType? = null,
    val unknownFields: ByteString = ByteString.EMPTY
  ) : Message<PhoneNumber, Nothing>(ADAPTER, unknownFields) {
    @Deprecated(
      message = "Shouldn't be used in Kotlin",
      level = DeprecationLevel.HIDDEN
    )
    override fun newBuilder(): Nothing {
      throw AssertionError()
    }

    override fun equals(other: Any?): Boolean {
      if (other === this) return true
      if (other !is PhoneNumber) return false
      return unknownFields == other.unknownFields
          && number == other.number
          && type == other.type
    }

    companion object {
      @JvmField
      val DEFAULT_TYPE: PhoneType = PhoneType.HOME

      @JvmField
      val ADAPTER: ProtoAdapter<PhoneNumber> = object : ProtoAdapter<PhoneNumber>(
        FieldEncoding.LENGTH_DELIMITED, 
        PhoneNumber::class
      ) {
        override fun encodedSize(value: PhoneNumber): Int = 
          ProtoAdapter.STRING.encodedSizeWithTag(1, value.number) +
          PhoneType.ADAPTER.encodedSizeWithTag(2, value.type) +
          value.unknownFields.size

        override fun encode(writer: ProtoWriter, value: PhoneNumber) {
          ProtoAdapter.STRING.encodeWithTag(writer, 1, value.number)
          PhoneType.ADAPTER.encodeWithTag(writer, 2, value.type)
          writer.writeBytes(value.unknownFields)
        }

        override fun decode(reader: ProtoReader): PhoneNumber {
          var number: String? = null
          var type: PhoneType? = null
          val unknownFields = reader.forEachTag { tag ->
            when (tag) {
              1 -> number = ProtoAdapter.STRING.decode(reader)
              2 -> type = PhoneType.ADAPTER.decode(reader)
              else -> reader.readUnknownField(tag)
            }
          }
          return PhoneNumber(
            number = number ?: throw missingRequiredFields(number, "number"),
            type = type,
            unknownFields = unknownFields
          )
        }

        override fun redact(value: PhoneNumber): PhoneNumber = value.copy(
          unknownFields = ByteString.EMPTY
        )
      }
    }
  }
}
