package dw.study.wtw.demo.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.*;
import org.springframework.stereotype.Service;

@Service
public class FirebaseAuthServiceImpl implements FirebaseAuthService{
    @Override
    public boolean create() throws FirebaseAuthException {
//        boolean result = false;
        CreateRequest req = new CreateRequest()
                .setEmail("dwtest0928@naver.com")
                .setEmailVerified(false)
                .setPassword("secretPassword")
                .setPhoneNumber("+12034567890")
                .setDisplayName("John Doe")
                .setPhotoUrl("http://www.example.com/12345678/photo.png")
                .setDisabled(false);
        UserRecord userRecord = FirebaseAuth.getInstance().createUser(req);
        if(userRecord.getUid().isEmpty())
            return false;
        else return true;
    }

    @Override
    public boolean delete() throws FirebaseAuthException {
//        boolean result = false;
        CreateRequest request = new CreateRequest()
                .setUid("dw-uid")
                .setEmail("user1@example.com")
                .setPhoneNumber("+11234567892");
        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
        if(!userRecord.getUid().isEmpty()){
            FirebaseAuth.getInstance().deleteUser(userRecord.getUid());
            System.out.println("Successfully deleted user.");
            return true;
        }else{
            return false;
        }

//        return result;
    }

    @Override
    public boolean getToken(String idToken) throws FirebaseAuthException {
        boolean result = false;
        FirebaseToken decodeToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        return result;
    }

    @Override
    public boolean update() {
        boolean result = false;

        return result;
    }
}
