package dao;
import bean.Product;

import java.util.List;


public interface ProductsDao{
    public void addProduct(Product p);
    public Product getProduct(String pid);
    public List getAllProducts();
}