package com.bookIt.demo.service;

import com.bookIt.demo.dto.WorkerCompanyAuthResponseDTO;
import com.bookIt.demo.model.WorkerCompany;
import com.bookIt.demo.model.security.Token;
import com.bookIt.demo.tool.JwtToken.JwtTokenTool;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationWorkerService {

    @Autowired
    private WorkerCompanyService workerCompanySvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenTool jwtTokenUtil;


    public WorkerCompanyAuthResponseDTO login(String username, String password, Integer idCompany) {

        final WorkerCompany workerCompany;

        try {
            workerCompany = workerCompanySvc.findByEmailAndIdCompany(username, idCompany);
        } catch (UsernameNotFoundException e) {
            return null;
        }

        if (passwordEncoder.matches(password, workerCompany.getWorker().getUser().getPassword())) {

            String token = this.jwtTokenUtil.generateToken(workerCompany.getWorker().getUser());

            return new WorkerCompanyAuthResponseDTO(
                    new Token(
                            token,
                            this.jwtTokenUtil.extractClaim(token, Claims::getExpiration)
                    ),
                    workerCompany
            );
        }
        return null;
    }
}
