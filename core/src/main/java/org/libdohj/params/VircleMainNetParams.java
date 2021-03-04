/*
 * Copyright 2013 Google Inc.
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

package org.libdohj.params;

import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Utils;

import static com.google.common.base.Preconditions.checkState;
import java.math.BigInteger;
/**
 * Parameters for the main Vircle production network on which people trade
 * goods and services.
 */
public class VircleMainNetParams extends AbstractVircleParams {
    public static final int MAINNET_MAJORITY_WINDOW = 2000;
    public static final int MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED = 1900;
    public static final int MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE = 1500;

    public VircleMainNetParams() {
        super();
        maxTarget = Utils.decodeCompactBits(0x1e0fffffL);


        dumpedPrivateKeyHeader = 128; //This is always addressHeader + 128
        addressHeader = 63;
        p2shHeader = 5;

        port = 9804;
        packetMagic = 0xaeafacad;


        segwitAddressHrp = "ail";
        bip32HeaderP2PKHpub = 0x0488b21e; // The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderP2PKHpriv = 0x0488ade4; // The 4 byte header that serializes in base58 to "xprv"
        bip32HeaderP2WPKHpub = 0x04b24746; // The 4 byte header that serializes in base58 to "zpub".
        bip32HeaderP2WPKHpriv = 0x04b2430c; // The 4 byte header that serializes in base58 to "zprv"

        genesisBlock.setDifficultyTarget(0x1e0fffffL);
        genesisBlock.setTime(1611028800L);
        genesisBlock.setNonce(4632189L);
        id = ID_VIRCLE_MAINNET;
        subsidyDecreaseBlockCount = 100000;
        spendableCoinbaseDepth = 100;

        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("000002b121d6248a8bb31e4e61530e60161992dc8f2547da9275debfe6752a6c"),
                genesisHash);

        majorityEnforceBlockUpgrade = MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
        majorityRejectBlockOutdated = MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED;
        majorityWindow = MAINNET_MAJORITY_WINDOW;

        // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
        // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
        // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
        // Having these here simplifies block connection logic considerably.
        checkpoints.put(    0, Sha256Hash.wrap("000002b121d6248a8bb31e4e61530e60161992dc8f2547da9275debfe6752a6c"));
        checkpoints.put(    250, Sha256Hash.wrap("00000338d572ca186190f57bd328d4a956def50bf78395b1402b6899854539df"));
        checkpoints.put(    5000, Sha256Hash.wrap("0000000001c8f47f5bb91b27637de6f94567d48ff31e2d17682ccb605d5eca78"));

        dnsSeeds = new String[] {
                "47.111.243.38",
                "68.79.34.218"
        };
    }

    private static VircleMainNetParams instance;
    public static synchronized VircleMainNetParams get() {
        if (instance == null) {
            instance = new VircleMainNetParams();
        }
        return instance;
    }


    @Override
    public String getPaymentProtocolId() {
        // TODO: CHANGE THIS
        return ID_VIRCLE_MAINNET;
    }

    @Override
    public boolean isTestNet() {
        return false;
    }
}
