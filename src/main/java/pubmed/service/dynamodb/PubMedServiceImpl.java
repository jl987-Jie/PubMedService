package pubmed.service.dynamodb;

import org.springframework.beans.factory.annotation.Autowired;
import pubmed.database.dynamodb.repository.PubMedArticleRepository;
import pubmed.service.PubMedService;
import reciter.model.pubmed.PubMedArticle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PubMedServiceImpl implements PubMedService {

    @Autowired
    private PubMedArticleRepository pubMedRepository;

    @Override
    public void save(PubMedArticle pubMedArticle) {
        pubmed.database.dynamodb.model.PubMedArticle pubMedArticleDb = new pubmed.database.dynamodb.model.PubMedArticle(
                pubMedArticle.getMedlinecitation().getMedlinecitationpmid().getPmid(),
                pubMedArticle);
        pubMedRepository.save(pubMedArticleDb);
    }

    @Override
    public void save(Collection<PubMedArticle> pubMedArticles) {
        List<pubmed.database.dynamodb.model.PubMedArticle> pubmedArticlesDb = new ArrayList<>();
        pubMedArticles.stream().forEach(
                pubMedArticle -> {
                    pubmed.database.dynamodb.model.PubMedArticle pubMedArticleDb = new pubmed.database.dynamodb.model.PubMedArticle(
                            pubMedArticle.getMedlinecitation().getMedlinecitationpmid().getPmid(),
                            pubMedArticle
                    );
                    pubmedArticlesDb.add(pubMedArticleDb);
                }
        );
        pubMedRepository.save(pubmedArticlesDb);
    }

    @Override
    public List<PubMedArticle> findByPmids(List<Long> pmids) {
        List<PubMedArticle> pubMedArticles = Collections.EMPTY_LIST;
        Iterator<pubmed.database.dynamodb.model.PubMedArticle> iterator = pubMedRepository.findAll(pmids).iterator();
        pubMedArticles = new ArrayList<>(pmids.size());
        while (iterator.hasNext()) {
            pubMedArticles.add(iterator.next().getPubmedArticle());
        }
        return pubMedArticles;
    }

    @Override
    public PubMedArticle findByPmid(Long pmid) {
        return pubMedRepository.findOne(pmid).getPubmedArticle();
    }
}
