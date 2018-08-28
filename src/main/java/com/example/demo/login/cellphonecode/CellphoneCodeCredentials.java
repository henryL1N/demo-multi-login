package com.example.demo.login.cellphonecode;

import lombok.Data;
import org.springframework.security.core.CredentialsContainer;

/**
 * @author Henry Lin badcop@163.com
 */
@Data
public class CellphoneCodeCredentials implements CredentialsContainer {

    private String cellphoneNumber;

    private String verificationCode;

    public CellphoneCodeCredentials(String cellphoneNumber, String verificationCode) {
        this.cellphoneNumber = cellphoneNumber;
        this.verificationCode = verificationCode;
    }

    @Override
    public void eraseCredentials() {
        verificationCode = null;
    }
}
