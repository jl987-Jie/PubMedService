package pubmed.engine;

public interface PubMedEngine {

    void retrieveArticlesByUid(String uid, boolean refreshFlag);
}
