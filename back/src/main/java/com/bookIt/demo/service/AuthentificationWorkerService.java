package com.bookIt.demo.service;

import com.bookIt.demo.dto.AuthRequestDTO;
import com.bookIt.demo.dto.WorkerAuthResponseDTO;
import com.bookIt.demo.dto.WorkerDTO;
import com.bookIt.demo.mapper.WorkerMapper;
import com.bookIt.demo.model.Worker;
import com.bookIt.demo.model.security.Token;
import com.bookIt.demo.tool.jwtToken.JwtTokenTool;
import io.jsonwebtoken.Claims;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationWorkerService {

    @Autowired
    private WorkerService workerSvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenTool jwtTokenUtil;
    @Autowired
    private ModelMapper mapper;


    public WorkerAuthResponseDTO login(AuthRequestDTO authRequest) {

        final Worker worker;

        try {
            worker = workerSvc.findByEmail(authRequest.getEmail());
        } catch (UsernameNotFoundException e) {
            return null;
        }

        if (passwordEncoder.matches(authRequest.getPassword(), worker.getUser().getPassword())) {

            String token = this.jwtTokenUtil.generateToken(worker);
            WorkerDTO workerDTO = mapper.map(worker, WorkerDTO.class);

            return new WorkerAuthResponseDTO(
                    new Token(
                            token,
                            this.jwtTokenUtil.extractClaim(token, Claims::getExpiration)
                    ),
                    workerDTO
            );
        }
        return null;
    }
}
