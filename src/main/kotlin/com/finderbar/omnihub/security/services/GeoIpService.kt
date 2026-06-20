package com.finderbar.omnihub.security.services

import org.springframework.stereotype.Service


@Service
class GeoIpService {

    fun getCountry(ip: String): String {

        return when {
            ip.startsWith("127.") -> "LOCAL"
            ip.startsWith("192.168.") -> "LOCAL"
            ip.startsWith("10.") -> "LOCAL"

            // Myanmar test range (example placeholder logic)
            ip.startsWith("103.") -> "MM"
            ip.startsWith("182.") -> "MM"

            else -> "UNKNOWN"
        }
    }

    fun isForeign(ip: String): Boolean {
        return getCountry(ip) != "MM" && getCountry(ip) != "LOCAL"
    }
}