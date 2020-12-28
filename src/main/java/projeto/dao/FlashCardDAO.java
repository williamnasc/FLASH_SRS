package projeto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto.model.FlashCard;
import projeto.model.JPAUtil;

public class FlashCardDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void salvar(FlashCard flashCard) {
		entity.getTransaction().begin();
		entity.persist(flashCard);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public void editar(FlashCard flashCard) {
		entity.getTransaction().begin();
		entity.merge(flashCard);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public FlashCard buscar(Long id) {
		FlashCard f = new FlashCard();
		f=entity.find(FlashCard.class, id);
		//JPAUtil.shutdown();
		return f;
	}
	
	public void excluir(Long id) {
		FlashCard f = new FlashCard();
		f=entity.find(FlashCard.class, id);
		entity.getTransaction().begin();
		entity.remove(f);
		entity.getTransaction().commit();
	}
	
	public List<FlashCard> obtenerFlashCards(){
		List<FlashCard> listaFlashCards = new ArrayList<>();
		Query q=entity.createQuery("SELECT c FROM FlashCard c");
		listaFlashCards=q.getResultList();
		return listaFlashCards;
	}
}
