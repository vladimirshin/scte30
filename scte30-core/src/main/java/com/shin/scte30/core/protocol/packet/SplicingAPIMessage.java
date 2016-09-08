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

package com.shin.scte30.core.protocol.packet;


import java.nio.ByteBuffer;


/**
 * Messages in this API all contain a general message structure that wraps the data for the
 * specific message being sent. This is done so that when the message is received a common
 * parsing routine can store the message, determine what the structure of the data is and
 * ensure that the message is received correctly.
 * @author Vladimir Shin [vladimir.shin@gmail.com]
 */
public class SplicingAPIMessage extends AbstractPacket {

    private final int BASE_SIZE = 8;

    private final short MESSAGE_ID;
    private final short MESSAGE_SIZE;

    private short result = (short) 0xFFFF;
    private short resultExtension = (short) 0xFFFF;

    private final Payload payload;

    public SplicingAPIMessage(final Payload payload) {
        this.payload = payload;

        this.MESSAGE_ID = (short) payload.id();
        this.MESSAGE_SIZE = (short) payload.size();

        allocate(this.BASE_SIZE + payload.size());
    }

    @Override public ByteBuffer build() {
        if (this.buffer == null || this.payload == null)
            return ByteBuffer.wrap(new byte[0]);

        this.buffer.putShort(this.MESSAGE_ID);
        this.buffer.putShort(this.MESSAGE_SIZE);
        this.buffer.putShort(this.result);
        this.buffer.putShort(this.resultExtension);
        this.buffer.put(this.payload.array());

        return this.buffer;
    }

    /**
     * @return MessageID – An integer value that indicates what message is being sent.
     */
    public short getMessageID() {
        return this.MESSAGE_ID;
    }

    /**
     * @return MessageSize – The size of the data( ) field being sent in bytes.
     */
    public short getMessageSize() {
        return this.MESSAGE_SIZE;
    }

    /**
     * @return Result – The results to the requested message. See Appendix A – Result Codes for
     * details on the result codes. On request messages, this is set to 0xFFFF.
     */
    public short getResult() {
        return this.result;
    }

    /**
     * @return Result_Extension – This shall be set to 0xFFFF unless used to send additional result
     * information in a response message.
     */
    public short getResultExtension() {
        return this.resultExtension;
    }

    /**
     * @return data() – Specific data structure for the message being sent. Details on each of the
     * messages containing data are described below. The size of this field is equal to the MessageSize
     * and is determined by the size of the data being added to the message. Not all messages utilize
     * the data( ) field.
     */
    public Payload getPayload() {
        return this.payload;
    }
}
