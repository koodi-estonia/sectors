package ee.koodi.helmes.user.api;


import ee.koodi.helmes.sector.SectorService;
import ee.koodi.helmes.user.UserService;
import ee.koodi.helmes.user_sector.UserSectorService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.ArrayList;

@Controller
public class UserController {

    private static final String INDEX_PAGE = "index";
    private final UserService userService;
    private final SectorService sectorService;
    private final UserSectorService userSectorService;

    public UserController(UserService userService, SectorService sectorService, UserSectorService userSectorService) {
        this.userService = userService;
        this.sectorService = sectorService;
        this.userSectorService = userSectorService;
    }

    @GetMapping("/")
    @Transactional
    public String index(Model model) {
        model.addAttribute("user", getUserData());
        model.addAttribute("sectors", sectorService.getSectorsList());

        return INDEX_PAGE;
    }


    @PostMapping("/save")
    @Transactional
    public String save(@ModelAttribute("user") UserDto user) {
        var sessionId = getSessionId();
        var userId = userService.updateUserAndReturnId(sessionId, user);
        userSectorService.updateUserSelectedSectors(userId, user.getSelectedSectorsIds());

        return "redirect:/";
    }


    private String getSessionId() {
        return RequestContextHolder.currentRequestAttributes().getSessionId();
    }

    private UserDto getUserData() {
        var sessionId = getSessionId();
        var user = userService.findUserBySessionIdOrCreateNew(sessionId);
        var userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setConsent(user.isConsent());
        userDto.setSelectedSectorsIds(user.getId() == null ? new ArrayList<>() : userSectorService.getUsersSelectedSectors(user.getId()));
        return userDto;
    }

}
