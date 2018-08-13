package pubmed.database.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "PubMedArticle")
public class PubMedArticle {
    private Long pmid;
    private reciter.model.pubmed.PubMedArticle pubMedArticle;

    public PubMedArticle() {
    }

    public PubMedArticle(Long pmid, reciter.model.pubmed.PubMedArticle pubMedArticle) {
        this.pmid = pmid;
        this.pubMedArticle = pubMedArticle;
    }

    @DynamoDBHashKey(attributeName = "pmid")
    public Long getPmid() {
        return pmid;
    }

    public void setPmid(Long pmid) {
        this.pmid = pmid;
    }

    @DynamoDBAttribute(attributeName = "pubmedarticle")
    public reciter.model.pubmed.PubMedArticle getPubmedArticle() {
        return pubMedArticle;
    }

    public void setPubmedArticle(reciter.model.pubmed.PubMedArticle pubMedArticle) {
        this.pubMedArticle = pubMedArticle;
    }
}
