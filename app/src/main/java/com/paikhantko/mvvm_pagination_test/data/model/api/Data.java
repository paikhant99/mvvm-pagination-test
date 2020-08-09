
package com.paikhantko.mvvm_pagination_test.data.model.api;

import java.util.List;

@lombok.Data
@SuppressWarnings("unused")
public class Data {

    private String lastUpdate;
    private PaginationMeta paginationMeta;
    private List<Row> rows;

}
