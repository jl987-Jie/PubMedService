package pubmed.service;

import reciter.model.pubmed.PubMedArticle;

import java.util.Collection;
import java.util.List;

public interface PubMedService {

    void save(PubMedArticle pubMedArticle);

    void save(Collection<PubMedArticle> pubMedArticles);

    List<PubMedArticle> findByPmids(List<Long> pmids);

    PubMedArticle findByPmid(Long pmid);
}
