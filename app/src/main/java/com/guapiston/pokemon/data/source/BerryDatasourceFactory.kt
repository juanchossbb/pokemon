package com.guapiston.pokemon.data.source

import androidx.paging.DataSource
import com.guapiston.pokemon.data.model.BerriesListResponse


class BerryDatasourceFactory : DataSource.Factory<Int,BerriesListResponse.Berry>(){

    override fun create(): DataSource<Int, BerriesListResponse.Berry> {
        return BerryDataSource()
    }
}
