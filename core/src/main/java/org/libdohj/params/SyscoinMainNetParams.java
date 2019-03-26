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
        maxTarget = Utils.decodeCompactBits(0x1e0ffff0L);


        dumpedPrivateKeyHeader = 128; //This is always addressHeader + 128
        addressHeader = 63;
        p2shHeader = 5;

        port = 8369;
        packetMagic = 0xcee2caff;


        segwitAddressHrp = "sys";
        bip32HeaderP2PKHpub = 0x0488b21e; // The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderP2PKHpriv = 0x0488ade4; // The 4 byte header that serializes in base58 to "xprv"
        bip32HeaderP2WPKHpub = 0x04b24746; // The 4 byte header that serializes in base58 to "zpub".
        bip32HeaderP2WPKHpriv = 0x04b2430c; // The 4 byte header that serializes in base58 to "zprv"

        genesisBlock.setDifficultyTarget(0x1e0ffff0L);
        genesisBlock.setTime(1552606660L);
        genesisBlock.setNonce(1104721L);
        id = ID_SYSCOIN_MAINNET;
        subsidyDecreaseBlockCount = 100000;
        spendableCoinbaseDepth = 100;

        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("000009e388d0cb406b36ed70bf89d21a4f7a3b1adea23a21e7948bac2dbb9fcc"),
                genesisHash);

        majorityEnforceBlockUpgrade = MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
        majorityRejectBlockOutdated = MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED;
        majorityWindow = MAINNET_MAJORITY_WINDOW;

        // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
        // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
        // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
        // Having these here simplifies block connection logic considerably.
        checkpoints.put(    0, Sha256Hash.wrap("000009e388d0cb406b36ed70bf89d21a4f7a3b1adea23a21e7948bac2dbb9fcc"));
        /*checkpoints.put( 42279, Sha256Hash.wrap("8444c3ef39a46222e87584ef956ad2c9ef401578bd8b51e8e4b9a86ec3134d3a"));
        checkpoints.put( 42400, Sha256Hash.wrap("557bb7c17ed9e6d4a6f9361cfddf7c1fc0bdc394af7019167442b41f507252b4"));
        checkpoints.put(104679, Sha256Hash.wrap("35eb87ae90d44b98898fec8c39577b76cb1eb08e1261cfc10706c8ce9a1d01cf"));
        checkpoints.put(128370, Sha256Hash.wrap("3f9265c94cab7dc3bd6a2ad2fb26c8845cb41cff437e0a75ae006997b4974be6"));
        checkpoints.put(145000, Sha256Hash.wrap("cc47cae70d7c5c92828d3214a266331dde59087d4a39071fa76ddfff9b7bde72"));
        checkpoints.put(165393, Sha256Hash.wrap("7154efb4009e18c1c6a6a79fc6015f48502bcd0a1edd9c20e44cd7cbbe2eeef1"));
        checkpoints.put(186774, Sha256Hash.wrap("3c712c49b34a5f34d4b963750d6ba02b73e8a938d2ee415dcda141d89f5cb23a"));
        checkpoints.put(199992, Sha256Hash.wrap("3408ff829b7104eebaf61fd2ba2203ef2a43af38b95b353e992ef48f00ebb190"));
        checkpoints.put(225000, Sha256Hash.wrap("be148d9c5eab4a33392a6367198796784479720d06bfdd07bd547fe934eea15a"));
        checkpoints.put(250000, Sha256Hash.wrap("0e4bcfe8d970979f7e30e2809ab51908d435677998cf759169407824d4f36460"));
        checkpoints.put(270639, Sha256Hash.wrap("c587a36dd4f60725b9dd01d99694799bef111fc584d659f6756ab06d2a90d911"));
        checkpoints.put(299742, Sha256Hash.wrap("1cc89c0c8a58046bf0222fe131c099852bd9af25a80e07922918ef5fb39d6742"));
        checkpoints.put(323141, Sha256Hash.wrap("60c9f919f9b271add6ef5671e9538bad296d79f7fdc6487ba702bf2ba131d31d"));
        checkpoints.put(339202, Sha256Hash.wrap("8c29048df5ae9df38a67ea9470fdd404d281a3a5c6f33080cd5bf14aa496ab03"));
        checkpoints.put(350000, Sha256Hash.wrap("2bdcba23a47049e69c4fec4c425462e30f3d21d25223bde0ed36be4ea59a7075"));
        checkpoints.put(370005, Sha256Hash.wrap("7be5af2c5bdcb79047dcd691ef613b82d4f1c20835677daed936de37a4782e15"));
        checkpoints.put(371337, Sha256Hash.wrap("60323982f9c5ff1b5a954eac9dc1269352835f47c2c5222691d80f0d50dcf053"));
        checkpoints.put(400002, Sha256Hash.wrap("a5021d69a83f39aef10f3f24f932068d6ff322c654d20562def3fac5703ce3aa"));*/

        /*dnsSeeds = new String[] {
                "seed.syscoin.com",
                "seed.multisyscoin.org",
                "seed2.multisyscoin.org",
                "seed.syscoinr.syscoin.com"
        };*/
    }

    private static SyscoinMainNetParams instance;
    public static synchronized SyscoinMainNetParams get() {
        if (instance == null) {
            instance = new SyscoinMainNetParams();
        }
        return instance;
    }

    @Override
    public boolean allowMinDifficultyBlocks() {
        return false;
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
