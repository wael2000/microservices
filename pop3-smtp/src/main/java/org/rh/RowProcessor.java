package org.rh;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RowProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        List<Map<String, Object>> rows = exchange.getIn().getBody(List.class);
        System.out.println("Processing " + exchange.getIn().getBody());
        List<Article> articles = new ArrayList<Article>();
        for (Map<String, Object> row : rows) {
            Article article = new Article();

            article.setAuthor((String) row.get("AUTHOR"));
            article.setCategory((String) row.get("CATEGORY"));
            article.setName((String) row.get("NAME"));
            article.setTags((String) row.get("TAGS"));
            article.setId((Integer) row.get("ID"));
            articles.add(article);
        }
        exchange.getOut().setBody(articles);
    }
}
