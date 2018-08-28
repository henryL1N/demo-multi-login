package com.example.demo.login;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Henry Lin badcop@163.com
 */
@Entity
public class DefaultIdPrincipal implements IdPrincipal<String> {

    @Id
    private String id;

    private String name;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
