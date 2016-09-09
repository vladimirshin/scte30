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

package com.shin.scte30.core.protocol.structure;


import java.nio.ByteBuffer;


/**
 * The Version structure is used to maintain the proper versioning within the API. It is expected that
 * this API will evolve over time and, to allow for this expansion, the version is specified in the
 * Init_Request and Init_Response messages to ensure that the Splicer supports the same version as
 * the Server.
 * The Server and Splicer should set and check this field to insure that both components are
 * capable of operating at the appropriate revision.
 * @author Vladimir Shin [vladimir.shin@gmail.com]
 */
public class Version extends AbstractStructure {

    private final int BASE_SIZE = 2; // 2 bytes

    private final short REVISION_NUM;

    public Version(final int version) {
        this.REVISION_NUM = (short) version;

        allocate(this.BASE_SIZE);
    }

    @Override public ByteBuffer build() {
        if (this.buffer == null) return ByteBuffer.wrap(new byte[0]);

        this.buffer.putShort(this.REVISION_NUM);

        return this.buffer;
    }

    /**
     * @return Revision_Num – This field is two (2) in this version.
     */
    public short version() {
        return this.REVISION_NUM;
    }
}
