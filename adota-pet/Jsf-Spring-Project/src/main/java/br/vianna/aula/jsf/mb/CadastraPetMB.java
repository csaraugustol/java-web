/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.dao.CachorroDao;
import br.vianna.aula.jsf.dao.GatoDao;
import br.vianna.aula.jsf.dao.PetDao;
import br.vianna.aula.jsf.model.DTO.ListaPetDTO;
import br.vianna.aula.jsf.model.ENUM.EPelagem;
import br.vianna.aula.jsf.model.ENUM.EPorteCachorro;
import br.vianna.aula.jsf.model.ENUM.ERacaCachorro;
import br.vianna.aula.jsf.model.ENUM.ERacaGato;
import br.vianna.aula.jsf.model.ENUM.ESexo;
import br.vianna.aula.jsf.model.ENUM.EStatusCrud;
import br.vianna.aula.jsf.model.pet.Cachorro;
import br.vianna.aula.jsf.model.pet.Gato;
import br.vianna.aula.jsf.model.pet.Pet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author cesar
 */
@Component
@ViewScoped
public class CadastraPetMB implements Serializable {

    private EStatusCrud status;
    private ArrayList<ListaPetDTO> listaPet;

    private Pet animal;
    private String tipoEscolhido;

    private EPorteCachorro[] porteCachorro;
    private ERacaCachorro[] racaCachorro;
    private EPelagem[] pelagem;
    private ERacaGato[] racaGato;
    private ESexo[] sexo;

//    @Autowired
//    private PetDao petDao;
    @Autowired
    private CachorroDao cacDao;
    @Autowired
    private GatoDao gatoDao;

    public CadastraPetMB() {

        porteCachorro = EPorteCachorro.values();
        racaCachorro = ERacaCachorro.values();
        pelagem = EPelagem.values();
        racaGato = ERacaGato.values();
        sexo = ESexo.values();

        status = EStatusCrud.VIEW;

        listaPet = new ArrayList<>();
//        listaPet.add(new ListaPetDTO("Fofinho", "M", "Cachorro", "Cesar", true));
//        listaPet.add(new ListaPetDTO("Fofinho", "M", "Cachorro", "Cesar", true));
//        listaPet.add(new ListaPetDTO("Fofinho", "M", "Cachorro", "Cesar", true));
//        listaPet.add(new ListaPetDTO("Fofinho", "M", "Cachorro", "Cesar", true));
//        listaPet.add(new ListaPetDTO("Fofinho", "M", "Cachorro", "Cesar", true));
//        listaPet.add(new ListaPetDTO("Fofinho", "M", "Cachorro", "Cesar", true));
//        listaPet.add(new ListaPetDTO("Fofinho", "M", "Cachorro", "Cesar", true));
//        listaPet.add(new ListaPetDTO("Fofinho", "M", "Cachorro", "Cesar", true));
//        listaPet.add(new ListaPetDTO("Fofinho", "M", "Cachorro", "Cesar", true));

    }

    public void mudancaTipoAnimal() {

        System.out.println("Chamou: " + tipoEscolhido);

        if (tipoEscolhido.equalsIgnoreCase("Cachorro")) {
            animal = new Cachorro();
        } else {
            animal = new Gato();
        }
    }

    public void iniciaAnimal() {

        animal = new Cachorro();
//        animal.setNome("Azulão");
//        animal.setSexo(ESexo.MASCULINO);
        animal.setDataNascimento(new Date());
        tipoEscolhido = "Cachorro";
    }

    public String preparaEdicao(int id, String tipo) {
        status = EStatusCrud.EDIT;

        if (tipo.equalsIgnoreCase("Cachorro")) {
            animal = cacDao.getAnimal(id);
            tipoEscolhido = "Cachorro";
        } else {
            animal = gatoDao.getAnimal(id);
            tipoEscolhido = "Gato";
        }

        return "";
    }

    public String excluir(int id, String tipo) {

        FacesContext fc = FacesContext.getCurrentInstance();

        Pet aux = null;

        if (tipo.equalsIgnoreCase("Cachorro")) {
            aux = cacDao.excluir(id);
        } else {
            aux = gatoDao.excluir(id);
        }

        fc.addMessage("", new FacesMessage(aux.getNome() + " foi exluído."));
        
        listaPet = getAllPets();

        return "";
    }

    @PostConstruct
    public void init() {

        listaPet = getAllPets();
    }

    public String trocar() {

        status = EStatusCrud.INSERT;

        iniciaAnimal();

        return "";

    }

    public void validaDataNasc(FacesContext fc, UIComponent uic, Object Value) {

        Date d = (Date) Value;

        if (d.after(new Date())) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Incorreta.", "Data não pode ser futura."));
        }

    }

    public String salvar() {

        String tp = "";
        FacesContext fc = FacesContext.getCurrentInstance();

//        if (animal instanceof Cachorro && {{Cachorro}animal}.getPorteCachorro() == EPorteCachorro.GRANDE){
//        fc.addMessage("", new FacesMessage("Não aceitamos cachorro grande"));
//        return "";
//    }
        if (animal instanceof Cachorro) {

            cacDao.save((Cachorro) animal);
            tp = "Cachorro";
        } else {
            gatoDao.save((Gato) animal);
            tp = "Gato";
        }

        iniciaAnimal();

        listaPet = getAllPets();
        fc.addMessage("", new FacesMessage(tp + " salvo com sucesso."));

        status = EStatusCrud.VIEW;
        return "";

    }

    public String voltar() {

        status = EStatusCrud.VIEW;
        return "";

    }

    private ArrayList<ListaPetDTO> getAllPets() {
        ArrayList<ListaPetDTO> lista = new ArrayList<>();

        lista.addAll(cacDao.getAllPets());
        lista.addAll(gatoDao.getAllPets());

        return lista;
    }

//    public void porte()
//    {
//        Pet p = new Cachorro();
//        {{Cachorro}.p}.setPorteCachorro(porteCachorro[] porteCachorro);
//    }
    public boolean isView() {
        return status == EStatusCrud.VIEW;
    }

    public EStatusCrud getStatus() {
        return status;
    }

    public void setStatus(EStatusCrud status) {
        this.status = status;
    }

    public ArrayList<ListaPetDTO> getListaPet() {
        return listaPet;
    }

    public void setListaPet(ArrayList<ListaPetDTO> listaPet) {
        this.listaPet = listaPet;
    }

//    public PetDao getPetDao() {
//        return petDao;
//    }
//
//    public void setPetDao(PetDao petDao) {
//        this.petDao = petDao;
//    }
    public Pet getAnimal() {
        return animal;
    }

    public void setAnimal(Pet animal) {
        this.animal = animal;
    }

    public String getTipoEscolhido() {
        return tipoEscolhido;
    }

    public void setTipoEscolhido(String tipoEscolhido) {
        this.tipoEscolhido = tipoEscolhido;
    }

    public CachorroDao getCacDao() {
        return cacDao;
    }

    public void setCacDao(CachorroDao cacDao) {
        this.cacDao = cacDao;
    }

    public EPorteCachorro[] getPorteCachorro() {
        return porteCachorro;
    }

    public void setPorteCachorro(EPorteCachorro[] porteCachorro) {
        this.porteCachorro = porteCachorro;
    }

    public ERacaCachorro[] getRacaCachorro() {
        return racaCachorro;
    }

    public void setRacaCachorro(ERacaCachorro[] racaCachorro) {
        this.racaCachorro = racaCachorro;
    }

    public EPelagem[] getPelagem() {
        return pelagem;
    }

    public void setPelagem(EPelagem[] pelagem) {
        this.pelagem = pelagem;
    }

    public ERacaGato[] getRacaGato() {
        return racaGato;
    }

    public void setRacaGato(ERacaGato[] racaGato) {
        this.racaGato = racaGato;
    }

    public GatoDao getGatoDao() {
        return gatoDao;
    }

    public void setGatoDao(GatoDao gatoDao) {
        this.gatoDao = gatoDao;
    }

    public ESexo[] getSexo() {
        return sexo;
    }

    public void setSexo(ESexo[] sexo) {
        this.sexo = sexo;
    }

}
