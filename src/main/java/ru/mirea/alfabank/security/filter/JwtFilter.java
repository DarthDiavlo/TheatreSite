package ru.mirea.alfabank.security.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.mirea.alfabank.modeldata.ClientModel;
import ru.mirea.alfabank.repositories.ClientRepository;
import ru.mirea.alfabank.security.jwt.JWTService;

import java.io.IOException;
import java.util.Objects;

import static org.apache.logging.log4j.util.Strings.isEmpty;


@Slf4j
@RequiredArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final ClientRepository clientRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String jwt=getToken(request);
        if(Objects.isNull(jwt)){
            filterChain.doFilter(request,response);
            log.info("no jwt in header");
            return;
        }
        ClientModel clientModel=jwtService.parseToke(jwt);
        if(Objects.isNull(clientModel)){
            filterChain.doFilter(request,response);
            log.info("no user in jwt");
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(
                clientModel.getEmail(),
                clientModel.getPassword(),
                clientModel.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        log.info("Succes");
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            return null;
        }

        final String[] strs = header.split(" ");
        if (strs.length != 2) {
            return null;
        }

        return strs[1].trim();
    }
}
