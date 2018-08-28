package com.example.demo.login;

import java.io.Serializable;
import java.security.Principal;

/**
 * @author Henry Lin badcop@163.com
 */
public interface IdPrincipal<T extends Serializable> extends Principal {

    /**
     * Get any kink of id
     *
     * @return id
     */
    T getId();
}
