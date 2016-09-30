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


/**
 * @author Vladimir Shin [vladimir.shin@gmail.com]
 */
public enum MultiplexType {

    // The Logical_Multiplex field is not needed to identify the multiplex.
    NOT_USED((short) 0x0000, (short) 0),

    // The usage of the Logical_Multiplex field is not defined by this specification
    // and must be agreed upon between the splicer and the server.
    USER_DEFINED((short) 0x0001, (short) 0), // BYTES parameter should be defined

    // The Logical_Multiplex field contains the IEEE Media Access Control address of
    // the multiplex as a 6 byte address.
    MAC_ADDRESS((short) 0x0002, (short) 6),

    // The most significant 4 bytes of the Logical_Multiplex field contain the Internet
    // Protocol (IP) address of the multiplex, and the remaining 2 bytes contain the IP
    // port number where the multiplex can be found.
    IPV4_ADDRESS((short) 0x0003, (short) 6),

    // The most significant 16 bytes of the Logical_Multiplex field contain the Internet
    // Protocol (IPv6) address of the multiplex, and the remaining 2 bytes contain the IP
    // port number where the multiplex can be found.
    IPV6_ADDRESS((short) 0x0004, (short) 18),

    // The Logical_Multiplex field contains the coordinates of the Asynchronous Transfer Mode (ATM)
    // circuit over which the multiplex is carried. The most significant 2 bytes of the logical
    // multiplex field contain the Virtual Path Identifier (VPI) and the next two bytes contain
    // the Virtual Channel Identifier (VCI) of the circuit. The least significant byte contains
    // the ATM Adaptation Layer (AAL) number.
    ATM_ADDRESS((short) 0x0005, (short) 5),

    //
    IPV4_ADDRESS_SPTS_SUPPORT ((short) 0x0006, (short) 0), // BYTES parameter should be defined

    //
    IPV6_ADDRESS_SPTS_SUPPORT ((short) 0x0006, (short) 0); // BYTES parameter should be defined

    // 0x0008 - 0xFFFF RESERVED

    private MultiplexType(short type, short bytes) {
        this.TYPE = type;
        this.BYTES = bytes;
    }

    private final short TYPE;
    private final short BYTES;

    /**
     *
     * @return specific two octets (short) value for the MULTIPLEX_TYPE.
     */
    public short type() { return this.TYPE; }

    /**
     *
     * @return specific two octets (short) value for the following MULTIPLEX_TYPE structure.
     */
    public short bytes() { return this.BYTES; }
}
