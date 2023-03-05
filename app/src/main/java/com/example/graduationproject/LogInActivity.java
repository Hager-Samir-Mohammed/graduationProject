package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LogInActivity extends AppCompatActivity {
    private EditText email_et, password_et;
    private Button login_btn;
    private TextView register_tv, forget;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    SignInButton signInWithGoogle;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        email_et = findViewById(R.id.login_et_email);
        password_et = findViewById(R.id.login_et_password);
        login_btn = findViewById(R.id.login_btn_login);
        register_tv = findViewById(R.id.login_tv_register);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.login_bp);
        signInWithGoogle = findViewById(R.id.login_login_with_google);
        forget = findViewById(R.id.login_tv_forget);


        register_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginWithEmail(email_et.getText().toString(), password_et.getText().toString());
            }
        });
        signInWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginGoogle();
            }
        });

        forgetPassword();

    }
     private void forgetPassword(){
         forget.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(email_et.getText().toString().length()>6){
                     progressBar.setVisibility(View.VISIBLE);
                     FirebaseAuth auth = FirebaseAuth.getInstance();
                     String emailAddress = email_et.getText().toString();

                     auth.sendPasswordResetEmail(emailAddress)
                             .addOnCompleteListener(new OnCompleteListener() {
                                 @Override
                                 public void onComplete(@NonNull Task task) {
                                     if (task.isSuccessful()) {
                                         Toast.makeText(LogInActivity.this, "We have sent an email", Toast.LENGTH_SHORT).show();
                                     }
                                     else {
                                         Toast.makeText(LogInActivity.this, "There is an error", Toast.LENGTH_SHORT).show();

                                     }
                                 }
                             });
                 } else{
                     email_et.setError("Entar valid email");
                 }


             }
         });
     }



    private void loginWithEmail(String email, String password) {
        if (email.length() > 5 && password.length() > 6) {
            progressBar.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(LogInActivity.this, "Welcome back :)",
                                        Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(LogInActivity.this, "Wrong email or password",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        } else {
            if (email.length() < 5) {
                email_et.setError("Email not valid");
            }
            if (password.length() <= 6) {
                password_et.setError("Password should be more 6 chars");
            }
        }
    }

    private void loginGoogle(){
        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken("521969625817-67lqdntbhicjdr35gsnf26okjnksgm0c.apps.googleusercontent.com")
                .requestEmail()
                .build();
        googleSignInClient= GoogleSignIn.getClient(LogInActivity.this
                ,googleSignInOptions);
        firebaseAuth = FirebaseAuth.getInstance();
        signInWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize sign in intent
                Intent intent=googleSignInClient.getSignInIntent();
                // Start activity for result
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check condition
        if(requestCode==100) {
            Task<GoogleSignInAccount> signInAccountTask=GoogleSignIn
                    .getSignedInAccountFromIntent(data);

            if(signInAccountTask.isSuccessful()) {
                String s="Google sign in successful";
                displayToast(s);
                // Initialize sign in account
                try {
                    // Initialize sign in account
                    GoogleSignInAccount googleSignInAccount=signInAccountTask
                            .getResult(ApiException.class);
                    // Check condition
                    if(googleSignInAccount!=null) {

                        AuthCredential authCredential= GoogleAuthProvider
                                .getCredential(googleSignInAccount.getIdToken()
                                        ,null);

                        firebaseAuth.signInWithCredential(authCredential)
                                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()) {
                                            startActivity(new Intent(LogInActivity.this ,HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                            displayToast("Firebase authentication successful");
                                        } else {
                                            displayToast("Authentication Failed :" +task.getException().getMessage());
                                            System.out.println(task.getException().getMessage());
                                        }
                                    }
                                });

                    }
                }
                catch (ApiException e)
                {
                    e.printStackTrace();
                }
            }else{
                displayToast(signInAccountTask.getException().getMessage());
            }

        }
    }
    private void displayToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}