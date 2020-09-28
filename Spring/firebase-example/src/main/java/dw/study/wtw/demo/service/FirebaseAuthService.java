package dw.study.wtw.demo.service;

import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

public interface FirebaseAuthService {
    public boolean create() throws FirebaseAuthException;
    public boolean delete() throws FirebaseAuthException;
    public boolean getToken(String idToken) throws FirebaseAuthException;
    public boolean update();
}
