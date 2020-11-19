package projetomicroservicosspringboot.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetomicroservicosspringboot.user.model.UserModel;
import projetomicroservicosspringboot.user.service.UserService;

@RestController
@RequestMapping("v1/admin/user")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<UserModel>> list(Pageable pageable){
        return new ResponseEntity<>(userService.list(pageable), HttpStatus.OK);
    }
}
