package br.vianna.aula.jsf;

import br.vianna.aula.jsf.dao.AdotanteDao;
import br.vianna.aula.jsf.dao.GatoDao;
import br.vianna.aula.jsf.dao.UsuarioDao;
import br.vianna.aula.jsf.model.Adotante;
import br.vianna.aula.jsf.model.ENUM.EPelagem;
import br.vianna.aula.jsf.model.ENUM.EPorteCachorro;
import br.vianna.aula.jsf.model.ENUM.ERacaCachorro;
import br.vianna.aula.jsf.model.ENUM.ERacaGato;
import br.vianna.aula.jsf.model.ENUM.ESexo;
import br.vianna.aula.jsf.model.ENUM.ETipoUsuario;
import br.vianna.aula.jsf.model.Usuario;
import br.vianna.aula.jsf.model.pet.Cachorro;
import br.vianna.aula.jsf.model.pet.Gato;
import br.vianna.aula.jsf.model.pet.Pet;
import br.vianna.aula.jsf.util.Utils;
import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectJsfSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjectJsfSpringApplication.class, args);
    }

    @Autowired
    UsuarioDao userD;

//        
    @Autowired
    AdotanteDao adtDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Servidor On.");

        System.out.println("a :: " + Utils.md5("a"));
//        
        Usuario u1 = new Usuario(0, ETipoUsuario.NORMAL, "Cesar", "c@cesar.com", "Cesar", Utils.md5("Cesar"));
        Usuario u2 = new Usuario(0, ETipoUsuario.ADMIN, "Cesar", "c@cesar.com", "csaraugustol", Utils.md5("admin"));
        Usuario u3 = new Usuario(0, ETipoUsuario.NORMAL, "Cesar", "c@cesar.com", "csaraugustol", Utils.md5("normal"));

        userD.save(u1);
        userD.save(u2);
        userD.save(u3);

        Adotante a1 = new Adotante(0, "Cesar", new Date(), 2500);
        Adotante a2 = new Adotante(0, "Zezim", new Date(), 2500);

        Pet p1 = new Cachorro(EPorteCachorro.PEQUENO, ERacaCachorro.LABRADOR, 0, "Jack", new Date(), ESexo.MASCULINO, true, true, true, a1);
        a1.getPets().add(p1);
        adtDao.save(a1);

        Pet p2 = new Gato(EPelagem.SOLIDA, ERacaGato.RAGDOLL, 0, "Person", new Date(), ESexo.MASCULINO, true, true, true, a2);
        a2.getPets().add(p2);
        adtDao.save(a2);

    }

}
