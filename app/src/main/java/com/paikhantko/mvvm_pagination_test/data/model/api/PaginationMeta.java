
package com.paikhantko.mvvm_pagination_test.data.model.api;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class PaginationMeta {

    private long currentPage;
    private long currentPageSize;
    private long totalPages;
    private long totalRecords;

}
