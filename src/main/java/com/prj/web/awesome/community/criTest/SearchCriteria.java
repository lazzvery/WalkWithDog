package com.prj.web.awesome.community.criTest;

import lombok.Data;

@Data
public class SearchCriteria extends Criteria{
    private String searchType;
    private String keyword;
    private String[] check;

    private String user_id;

}
