package controller;




import Exception.ClienteExistenteException;
import javax.ejb.Stateless;
import javax.persistence.*;
import loja.model.Cliente;

@Stateless
public class ClienteServices {
  @PersistenceContext
  private EntityManager em;

  public Cliente findByEmailAndSenha(String email, String senha) {
    Query query = em
        .createQuery("SELECT c FROM Cliente c WHERE c.email = :email AND c.senha = :senha");
    query.setParameter("email", email);
    query.setParameter("senha", senha);
    try {
      return (Cliente) query.getSingleResult();
    }
    catch (NoResultException e) {
      return null;
    }
  }

  public Cliente adicionar(Cliente cliente) throws ClienteExistenteException {
    try {
      em.persist(cliente);
      return cliente;
    }
    catch (PersistenceException e) {
      throw new ClienteExistenteException();
    }
  }
}