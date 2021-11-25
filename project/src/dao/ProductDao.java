package dao;
import java.util.List;

import bean.Product;
public interface ProductDao {
	public void addProduct(Product u);
    public Product getProduct(int productnum);
    public List getAllProducts();

}

