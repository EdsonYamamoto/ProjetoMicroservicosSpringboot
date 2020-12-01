package projetomicroservicosspringboot.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projetomicroservicosspringboot.user.model.UserModel;
import projetomicroservicosspringboot.user.repository.UserRepository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    public List<UserModel> ListarUsuariosEspeciais(List<UserModel> usuarios){
        log.info("executando servico listar usuario especiais");

        List<UserModel> result;

        result = usuarios
                .stream()
                .filter(a->a.isActive() == true)
                .collect(Collectors.toList());

        return result;
    }
}
