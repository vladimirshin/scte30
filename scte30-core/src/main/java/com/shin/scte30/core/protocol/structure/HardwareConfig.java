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
 * Hardware_Config
 * This structure describes the hardware interface between the Server and the Splicer.
 * It is important for the Splicer to know exactly where the Server is connected so that
 * the Splicer knows what Multiplex is being referenced. An example of this link would be
 * a DVB-ASI connection from the Server to the Splicer.
 *
 * Basic structure looks like:
 * Hardware_Config{
 *     Length
 *     Chassis
 *     Card
 *     Port
 *     Logical_Multiplex_Type
 *     Logical_Multiplex()
 * }
 * @author Vladimir Shin [vladimir.shin@gmail.com]
 */
public class HardwareConfig {

    private final short LENGTH;
    private final short CHASSIS;
    private final short CARD;
    private final short PORT;
    private final MultiplexType LOGICAL_MULTIPLEX_TYPE;

    public HardwareConfig(short length, short chassis, short card, short port, MultiplexType multiplexType) {
        this.LENGTH = length;
        this.CHASSIS = chassis;
        this.CARD = card;
        this.PORT = port;
        this.LOGICAL_MULTIPLEX_TYPE = multiplexType;
    }

}
