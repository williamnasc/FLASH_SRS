package projeto.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import projeto.dao.FlashCardDAO;
import projeto.model.FlashCard;

@ManagedBean(name = "flashCardBean")
@RequestScoped
public class FlashCardBean {

	public String novo() {
		FlashCard f = new FlashCard();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("flashCard", f);
		return "novo.xhtml";
	}

	public String salvar(FlashCard flashCard) {
		Date hoje = new Date();
		/*
		 * Calendar data = Calendar.getInstance(); data.setTime(new Date());
		 * data.add(Calendar.DAY_OF_MONTH, -1); flashCard.setDataRepet(data.getTime());
		 */
		flashCard.setDataRepet(hoje);
		FlashCardDAO flashCardDAO = new FlashCardDAO();
		flashCardDAO.salvar(flashCard);
		

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Flashcard cadastrado com sucesso!", ""));
		
		return "index.xhtml";
	}

	public List<FlashCard> obterFlashCards() {
		FlashCardDAO flashCardDAO = new FlashCardDAO();

		return flashCardDAO.obtenerFlashCards();
	}

	public String editar(Long id) {
		FlashCardDAO flashCardDAO = new FlashCardDAO();
		FlashCard f = new FlashCard();
		f = flashCardDAO.buscar(id);
		System.out.println(f);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("flashCard", f);
		
		return "editar.xhtml";
	}

	public String atualizar(FlashCard flashCard) {
		FlashCardDAO flashCardDAO = new FlashCardDAO();
		flashCardDAO.editar(flashCard);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Flashcard atualizado com sucesso!", ""));
		
		return "index.xhtml";
	}

	// excluir um FlashCard
	public String excluir(Long id) {
		FlashCardDAO flashCardDAO = new FlashCardDAO();
		flashCardDAO.excluir(id);
		System.out.println("Flash Card Excluido");
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Flashcard excluído com sucesso!", ""));
		
		return "index.xhtml";
	}

	public String revisar() {
		FlashCardDAO flashCardDAO = new FlashCardDAO();
		List<FlashCard> flashCards = flashCardDAO.obtenerFlashCards();
		List<FlashCard> cardsRevisao = new ArrayList<>();
		FlashCard f = new FlashCard();
		Date hoje = new Date();
		Random random = new Random();
		// percorrer a list e inserir a revisão as que tem hj como data de revisão
		for (int i = 0; i < flashCards.size(); i++) {
			if (hoje.compareTo(flashCards.get(i).getDataRepet()) > 0) {
				cardsRevisao.add(flashCards.get(i));
			}
		}
		
		if (cardsRevisao.size() == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Sem cards para revisar."));
			
			return "index.xhtml";
		}
			
		else 
			f = cardsRevisao.get(random.nextInt((cardsRevisao.size())));
			

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("flashCard", f);
		return "revisao.xhtml";
	}

	public FlashCard addDataRev(FlashCard flashCard) {
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());

		switch (flashCard.getNivelAprend()) {
		case 0:
			break;

		case 1:
			data.add(Calendar.DAY_OF_MONTH, 1);
			break;
		case 2:
			data.add(Calendar.DAY_OF_MONTH, 4);
			break;
		case 3:
			data.add(Calendar.DAY_OF_MONTH, 8);
			break;
		case 4:
			data.add(Calendar.DAY_OF_MONTH, 15);
			break;
		default:
			data.add(Calendar.DAY_OF_MONTH, 30);
			break;
		}

		flashCard.setDataRepet(data.getTime());
		return flashCard;
	}

	public String revisado(FlashCard flashCard, boolean acertou) {
		FlashCardDAO flashCardDAO = new FlashCardDAO();
		
		if (acertou) {
			System.out.println("ACERTOU");
			flashCard.setNivelAprend((flashCard.getNivelAprend() + 1));
			flashCard = addDataRev(flashCard);
		} else {
			System.out.println("ERROU");
			flashCard.setNivelAprend(0);
		}

		flashCardDAO.editar(flashCard);

		return revisar();

	}

}
