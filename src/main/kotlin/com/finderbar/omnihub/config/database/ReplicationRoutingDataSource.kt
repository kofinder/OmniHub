package com.finderbar.omnihub.config.database

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager

class ReplicationRoutingDataSource : AbstractRoutingDataSource() {

    override fun determineCurrentLookupKey(): Any {

        return if (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) {
            DataSourceType.SLAVE
        } else {
            DataSourceType.MASTER
        }
    }
}