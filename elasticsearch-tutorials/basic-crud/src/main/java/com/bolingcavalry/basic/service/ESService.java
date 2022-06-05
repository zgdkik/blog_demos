package com.bolingcavalry.basic.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class ESService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public void addIndex(String name) throws IOException {
        elasticsearchClient.indices().create(c -> c.index(name));
    }

    public boolean indexExists(String name) throws IOException {
        return elasticsearchClient.indices().exists(b -> b.index(name)).value();
    }

    public void delIndex(String name) throws IOException {
        elasticsearchClient.indices().delete(c -> c.index(name));
    }
}
