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


/**
 * @author Vladimir Shin [vladimir.shin@gmail.com]
 */
public interface MessageID {

    public final static short GENERAL_RES         = 0x0000;
    public final static short INIT_REQ            = 0x0001;
    public final static short INIT_RES            = 0x0002;
    public final static short EXTENDED_DATA_REQ   = 0x0003;
    public final static short EXTENDED_DATA_RES   = 0x0004;
    public final static short ALIVE_REQ           = 0x0005;
    public final static short ALIVE_RES           = 0x0006;
    public final static short SPLICE_REQ          = 0x0007;
    public final static short SPLICE_RES          = 0x0008;
    public final static short SPLICE_COMPLETE_RES = 0x0009;
    public final static short GET_CONFIG_REQ      = 0x000A;
    public final static short GET_CONFIG_RES      = 0x000B;
    public final static short CUE_REQ             = 0x000C;
    public final static short CUE_RES             = 0x000D;
    public final static short ABORT_REQ           = 0x000E;
    public final static short ABORT_RES           = 0x000F;
    public final static short TEARDOWN_FEED_REQ   = 0x0010;
    public final static short TEARDOWN_FEED_RES   = 0x0011;

    public final static int[] RESERVED     = { 0x0012, 0x7FFF, 0xFFFF }; // where 0x0012 - 0x7FFF is a range
    public final static int[] USER_DEFINED = { 0x8000, 0xFFFE };         // where 0x8000 - 0xFFFE is a range

}
