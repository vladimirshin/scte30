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

package com.shin.scte30.core.protocol.message;


import java.util.List;
import java.util.LinkedList;

import com.shin.scte30.core.protocol.structure.Version;
import com.shin.scte30.core.protocol.structure.HardwareConfig;
import com.shin.scte30.core.protocol.structure.SpliceAPIDescriptor;


/**
 * The initial communication begins with the Splicer listening on the predefined port 5168 and a Server
 * opening an API Connection to the Splicer. The Server sends an Init_Request message to the Splicer.
 * The Server then listens for the response from the Splicer on the established API Connection. All further
 * communication is done on this API Connection. Either the Splicer or Server may terminate communications
 * by closing this API Connection. Each device is responsible for detecting and properly handling a closed
 * API Connection. When the Splicer initializes the TCP listener on port 5168, it should allow for at least
 * three times the number of Insertion Channels for API Connections to the splicer. For example, if the
 * Splicer controls 70 Channels of which 40 are spliceable, then it should allow 120, (40 * 3), simultaneous
 * API Connections.
 * @author Vladimir Shin [vladimir.shin@gmail.com]
 */
public class InitRequestMessage {

    private final Version VERSION;
    private final String CHANNEL_NAME;
    private final String SPLICER_NAME;
    private final HardwareConfig HARDWARE_CONFIG;

    private final List<SpliceAPIDescriptor> SPLICE_API_LIST = new LinkedList<>();

    public InitRequestMessage(final Version version,
                              final String channelName,
                              final String splicerName,
                              final HardwareConfig hardwareConfig) {
        this.VERSION = version;
        this.CHANNEL_NAME = channelName;
        this.SPLICER_NAME = splicerName;
        this.HARDWARE_CONFIG = hardwareConfig;
    }
}
