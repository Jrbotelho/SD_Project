package sd_project.score_dei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/login/create")
    public String created_acc(Model model, Client clientParams, String is_admin){
        if (clientParams.getUsername() == null ||
            clientParams.getPassword() == null ||
            clientParams.getContact() == null ||
            clientParams.getEmail() == null
        ) {
            model.addAttribute("error", "One or more blanks given");
            return "login_create";
        }

        clientParams.setAdmin(Objects.equals(is_admin, "true"));
        clientRepository.save(clientParams);
        return "redirect:/";
    }

    @GetMapping("/login/create")
    public String create_acc(){
        return "login_create";
    }

    @GetMapping("/login/remove")
    public String remove_acc(){ return "login_remove";}

    @PostMapping("/login/remove")
    public String removed_acc(Model model, Client clientParam){
        Client client = this.clientRepository.find_by_username(clientParam.getUsername());
        if (client != null)
        {
            System.out.println("Client deleted");
            clientRepository.delete(client);
            return "login_remove";
        }
        model.addAttribute("error", "couldnt find user");
        return "login_remove";
    }

    @GetMapping("/login")
    public String login(){
        return "login_menu";
    }

    @PostMapping("/login")
    public String logger(Model model, Client clientParam, HttpServletResponse response){
        Client client = this.clientRepository.login(clientParam.getUsername(), clientParam.getPassword());
        if (client != null)
        {
            CookieService.setCookie(response, "userId", String.valueOf(client.getId()), 600);
            System.out.println(client);
            return "redirect:/";
        }
        model.addAttribute("error", "Wrong user or password");
        return "login_menu";
    }
}
