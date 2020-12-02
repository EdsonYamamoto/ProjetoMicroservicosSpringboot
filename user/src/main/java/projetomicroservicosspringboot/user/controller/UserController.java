package projetomicroservicosspringboot.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetomicroservicosspringboot.user.model.UserModel;
import projetomicroservicosspringboot.user.repository.UserRepository;
import projetomicroservicosspringboot.user.service.UserService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Api(value = "User")
@RequestMapping("v1/admin/user")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @RequestMapping(value = "/teste", method = RequestMethod.GET)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "executeTestes")
    public ResponseEntity<UserModel> teste(){
        List<UserModel> usuarios = StreamSupport
                .stream(userRepository.list(0,100).spliterator(), false)
                .collect(Collectors.toList());

        return new ResponseEntity(userService.ListarUsuariosEspeciais(usuarios), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @GetMapping(value = "/{page}/{size}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "show user list")
    public ResponseEntity<Iterable<UserModel>> list(@RequestParam("page") int pageIndex,
                                                    @RequestParam("size") int pageSize){
        return new ResponseEntity<>(userRepository.list(pageIndex, pageSize), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "show user by ID")
    public ResponseEntity<UserModel> getUser(@RequestParam("id") long id){
        return new ResponseEntity(userRepository.getId(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "save one user")
    public ResponseEntity<UserModel> saveUser(UserModel user){
        return new ResponseEntity(userRepository.saveUser(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "delete one user")
    public ResponseEntity<?> deleteUser(UserModel user){
        userRepository.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update one user")
    public ResponseEntity<UserModel> updateUser(UserModel user){
        return new ResponseEntity(userRepository.saveUser(user), HttpStatus.NO_CONTENT);
    }
}
