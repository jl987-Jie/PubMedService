package pubmed.database.dynamodb.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import pubmed.database.dynamodb.model.PubMedArticle;

@EnableScan
public interface PubMedArticleRepository extends CrudRepository<PubMedArticle, Long> {

}
