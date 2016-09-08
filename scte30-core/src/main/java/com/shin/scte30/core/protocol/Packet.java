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
 * The time structure is used to define various times in this specification.
 * @author Vladimir Shin [vladimir.shin@gmail.com]
 */
public abstract class Packet implements MessageID {

    protected ByteBuffer buffer;

    protected void allocate(final int size) {
        this.buffer = ByteBuffer.allocate(size);
    }

    public abstract ByteBuffer build();
}
