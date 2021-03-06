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


/**
 * The data() field for the Splice_Response message contains the Splice_Response_Data structure outlined below.
 * The Splice_Response_Message may contain an error code if appropriate. The Splice_Offset is used by the
 * Splicer to inform the Server of a time offset for the delivery of the content for this message. This
 * does not affect the point in the primary channel where the splice will occur.
 * @author Vladimir Shin [vladimir.shin@gmail.com]
 */
public class SpliceResponseMessage {
}
