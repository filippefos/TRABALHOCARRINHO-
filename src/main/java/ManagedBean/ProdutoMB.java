
import controller.ProdutoServices;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import loja.model.Produto;


@Named
@RequestScoped
public class ProdutoMB {
  @Inject
  private ProdutoServices produtoServices;
  private List<Produto> produtos;

  @PostConstruct
  public void init() {
    produtos = produtoServices.findAll();
  }

  public List<Produto> getProdutos() {
    return produtos;
  }
}