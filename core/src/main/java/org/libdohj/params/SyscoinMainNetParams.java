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
 * Parameters for the main Syscoin production network on which people trade
 * goods and services.
 */
public class SyscoinMainNetParams extends AbstractSyscoinParams {
    public static final int MAINNET_MAJORITY_WINDOW = 2000;
    public static final int MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED = 1900;
    public static final int MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE = 1500;

    public SyscoinMainNetParams() {
        super();
        maxTarget = Utils.decodeCompactBits(0x1e0fffffL);


        dumpedPrivateKeyHeader = 128; //This is always addressHeader + 128
        addressHeader = 63;
        p2shHeader = 5;

        port = 9900;
        packetMagic = 0x9a0b9c0d;


        segwitAddressHrp = "sys";
        bip32HeaderP2PKHpub = 0x0488b21e; // The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderP2PKHpriv = 0x0488ade4; // The 4 byte header that serializes in base58 to "xprv"
        bip32HeaderP2WPKHpub = 0x04b24746; // The 4 byte header that serializes in base58 to "zpub".
        bip32HeaderP2WPKHpriv = 0x04b2430c; // The 4 byte header that serializes in base58 to "zprv"

        genesisBlock.setDifficultyTarget(0x1e0fffffL);
        genesisBlock.setTime(1589846400L);
        genesisBlock.setNonce(2655493L);
        id = ID_SYSCOIN_MAINNET;
        subsidyDecreaseBlockCount = 100000;
        spendableCoinbaseDepth = 100;

        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("0000049286f4c4a14dea206d39f6ff3275824bed0b06c9c4dc7acdb7e4bbad05"),
                genesisHash);

        majorityEnforceBlockUpgrade = MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
        majorityRejectBlockOutdated = MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED;
        majorityWindow = MAINNET_MAJORITY_WINDOW;

        // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
        // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
        // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
        // Having these here simplifies block connection logic considerably.
        checkpoints.put(    0, Sha256Hash.wrap("0000049286f4c4a14dea206d39f6ff3275824bed0b06c9c4dc7acdb7e4bbad05"));
        checkpoints.put(    250, Sha256Hash.wrap("00000fb53813979ed8ddbc22bf6476021bb7213b471766f26f548c594b8cf83e"));
        checkpoints.put(    5000, Sha256Hash.wrap("0000000d936bd198f5bceb71136b230a823a4c4d18712eb81bd7c68aff64bd41"));
        checkpoints.put(    10000, Sha256Hash.wrap("0000000166523b6d6bb950e3b184746030f90c8b6bed718c9770ccc89fe3056b"));
        checkpoints.put(    20000, Sha256Hash.wrap("00000004c4abab46915efe25cdc704e5318cdeeffdfa2832b06d608cdf2f08b2"));

        dnsSeeds = new String[] {
                "52.83.40.78",
                "52.82.4.7",
                "52.83.45.206"
        };
    }

    private static SyscoinMainNetParams instance;
    public static synchronized SyscoinMainNetParams get() {
        if (instance == null) {
            instance = new SyscoinMainNetParams();
        }
        return instance;
    }


    @Override
    public String getPaymentProtocolId() {
        // TODO: CHANGE THIS
        return ID_SYSCOIN_MAINNET;
    }

    @Override
    public boolean isTestNet() {
        return false;
    }
}
