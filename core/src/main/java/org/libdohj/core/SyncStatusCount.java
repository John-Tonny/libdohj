/*
 * Copyright 2017 Anton Kumaigorodski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitcoinj.core;

/**
 * <p>
 * A new message, "ssc", which indicates a sync status count
 * </p>
 *
 */
public class SyncStatusCount extends EmptyMessage {
    public SyncStatusCount() {
    }

    // this is needed by the BitcoinSerializer
    public SyncStatusCount(NetworkParameters params, byte[] payload) {
    }
}