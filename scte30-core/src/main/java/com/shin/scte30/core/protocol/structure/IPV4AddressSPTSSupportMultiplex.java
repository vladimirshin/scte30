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

import com.shin.scte30.core.protocol.LogicalMultiplex;


/**
 * Type 0x0006 – IPv4 Address with Single Program Transport Stream (SPTS) support
 * Type 0x0006 is utilized by VOD and Ad Servers where remapping of PIDs is
 * impractical or undesirable.
 * In these cases it is desirable to use a SPTS per UDP Port.
 * @author Vladimir Shin [vladimir.shin@gmail.com]
 */
public class IPV4AddressSPTSSupportMultiplex extends LogicalMultiplex {

    @Override public ByteBuffer build() {
        return this.buffer;
    }
}
