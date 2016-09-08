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
public class Time extends Packet {

    private final int SIZE = 8; // 8 bytes

    private final int seconds;
    private final int microseconds;

    public Time(final int seconds, final int microseconds) {
        allocate(this.SIZE);
        this.seconds = seconds;
        this.microseconds = microseconds;
    }

    @Override
    public ByteBuffer build() {
//        if (seconds <= 0)
//            throw new IllegalArgumentException("Seconds field is invalid");
//
//        if (microseconds <= 0)
//            throw new IllegalArgumentException("Microseconds field is invalid");

        this.buffer.putInt(this.seconds);
        this.buffer.putInt(this.microseconds);

        return this.buffer;
    }

    /**
     * @return Seconds – Elapsed seconds since 12:00 AM January 1, 1970 UTC.
     */
    public int getSeconds() {
        return this.seconds;
    }

    /**
     * @return MicroSeconds – Offset in microseconds of the Seconds field.
     */
    public int getMicroseconds() {
        return this.microseconds;
    }
}
