package com.contestgo.contestgobackend.utils;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-11-13 00:26
 **/
public class ElasticSearchUtil {

    public static final Logger logger = LoggerFactory.getLogger(ElasticSearchUtil.class);

    public static final String CONTEST_INDEX = "team";
    public static final String CONTEST_TYPE = "sport";

    @Autowired
    private TransportClient client;

    @GetMapping("/get/contest/key")
    public ResponseEntity get(@RequestParam(name = "key") String key) {
        GetResponse result = client.prepareGet(CONTEST_INDEX, CONTEST_TYPE, key).get();

        if (result == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/get/contest/key")
    public ResponseEntity getByScore(@RequestParam(name = "key") String key) {
        GetResponse result = client.prepareGet(CONTEST_INDEX, CONTEST_TYPE, key).get();

        FunctionScoreQueryBuilder scoreQueryBuilder = QueryBuilders.functionScoreQuery(
                QueryBuilders.boolQuery().should(
                        (QueryBuilders.matchQuery("team_name", key))
                )
        );

        // SearchQuery searchQuery = new NativeSearchQueryBuilder()

        if (result == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
