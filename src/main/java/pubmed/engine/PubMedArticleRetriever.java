package pubmed.engine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pubmed.model.PubMedQuery;
import reciter.model.pubmed.PubMedArticle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class PubMedArticleRetriever {

    private static final String PUBMED_SERVICE = System.getenv("PUBMED_SERVICE");

    /**
     * Initializes and starts threads that handles the retrieval process. Partition the number of articles
     * into manageable pieces and ask each thread to handle one partition.
     */
    public List<PubMedArticle> retrievePubMed(PubMedQuery pubMedQuery, int numberOfPubmedArticles) {
        if (numberOfPubmedArticles == 0) {
            return Collections.emptyList();
        }
        String nodeUrl = PUBMED_SERVICE + "/pubmed/query-complex/";
        RestTemplate restTemplate = new RestTemplate();
        log.info("Sending web request: for query: " + pubMedQuery + ":" + nodeUrl);
        ResponseEntity<PubMedArticle[]> responseEntity = null;
        try {
            responseEntity = restTemplate.postForEntity(nodeUrl, pubMedQuery, PubMedArticle[].class);
        } catch (Exception e) {
            log.error("Unable to retrieve via external REST api=[" + nodeUrl + "]", e);
        }
        if (responseEntity == null) {
            return Collections.emptyList();
        }
        PubMedArticle[] pubMedArticles = responseEntity.getBody();
        return Arrays.asList(pubMedArticles);
    }
}
