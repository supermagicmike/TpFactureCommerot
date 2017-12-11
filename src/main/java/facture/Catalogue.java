package facture;

import java.util.HashMap;
import java.util.Map;

public class Catalogue {
    
    private Map<String,Article> articles;

    public Catalogue(Map<String, Article> articles) {
        this.articles = articles;
    }
     public Catalogue() {
        this.articles = new HashMap<>();
    }
    
    public void addArticle(Article article) {
        this.articles.put(article.getCode(), article);
    }
    
    public Article findByCode(String code) {
        if(!articles.containsKey(code)){
            System.out.println("Pas darticles concernant ce code mleh");
        }
        return this.articles.get(code);
    }
    
}
