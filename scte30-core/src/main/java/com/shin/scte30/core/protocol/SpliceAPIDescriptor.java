/*
 *  Copyright 2015 Vladimir Shin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package com.shin.scte30.core.protocol;


import java.nio.ByteBuffer;


/**
 * This is a template for adding descriptors in any message defined within this document.
 * The Splice_Request, ExtendedData_Response and Init_Request messages may use descriptors. The use
 * of descriptors in messages defined by this standard is optional. The following table is the general
 * format for descriptors used in this standard.
 * @author Vladimir Shin [vladimir.shin@gmail.com]
 */
public class SpliceAPIDescriptor extends Packet {

    private final int BASE_SIZE = 6*8;

    private final byte SPLICE_DESCRIPTOR_TAG;
    private final byte DESCRIPTOR_LENGTH;
    private final int SPLICE_API_IDENTIFIER;

    public SpliceAPIDescriptor(final byte tag, final byte length, final int identifier) {
        this.SPLICE_DESCRIPTOR_TAG = tag;
        this.DESCRIPTOR_LENGTH = length;
        this.SPLICE_API_IDENTIFIER = identifier;

        allocate(this.BASE_SIZE + length);
    }

    @Override
    public ByteBuffer build() {
        return this.buffer;
    }

    /**
     * Splice_Descriptor_Tag – A value from 0x00 to 0xFF to denote the specific descriptor being used. Tag
     * values 0x00 to 0xFF are reserved for use by this standard. The vendor may use a vendor unique
     * Splice_API_Identifier to allow for a larger tag range and a more robust method of adding vendor unique
     * descriptors.
     * @return Splice_Descriptor_Tag as byte value
     */
    public byte getSpliceDescriptorTag() {
        return this.SPLICE_DESCRIPTOR_TAG;
    }

    /**
     * Descriptor_Length – This gives the length, in bytes, of the descriptor following this field. Descriptors
     * are limited to 256 bytes, so this value is limited to 254.
     * @return Descriptor_Length as byte value
     */
    public byte getDescriptorLength() {
        return this.DESCRIPTOR_LENGTH;
    }

    /**
     * Splice_API_Identifier – An identifier of the organization that has defined this descriptor. For all
     * descriptors within this document, the identifier is 0x53415049 (ASCII “SAPI”). This has been chosen
     * to not conflict with descriptors of any other known identifier.
     * @return Splice_API_Identifier as int value
     */
    public int getSpliceApiIdentifier() {
        return this.SPLICE_API_IDENTIFIER;
    }
}
