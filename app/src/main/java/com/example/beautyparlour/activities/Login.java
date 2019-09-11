package com.example.beautyparlour.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.beautyparlour.R;
import com.example.beautyparlour.models.User;
import com.example.beautyparlour.utils.Utils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    private final int GOOGLE_REQ_CODE = 787;
    private View glogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        glogin = findViewById(R.id.glogin);
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestId()
                .requestProfile()
                .requestIdToken("1013393434218-ba6oh9huibc77pup1918lou5c8av4e72.apps.googleusercontent.com")
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions)
//                .addApi(Auth.CREDENTIALS_API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(@Nullable Bundle bundle) {
                        if (!Utils.getInstance().isLoggedIn()) {
                            logOutGoogle(Login.this, googleApiClient);
                        }
                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                })
                .build();
        glogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignIn();
            }
        });
    }

    private void googleSignIn() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, GOOGLE_REQ_CODE);
    }

    private void handleGoogleResult(GoogleSignInResult signInResult) {
        if (signInResult.isSuccess()) {
            GoogleSignInAccount signInAccount = signInResult.getSignInAccount();
            String email = signInAccount.getEmail();
            String name = signInAccount.getDisplayName();
            String phone = "";
//            AuthCredential credential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
//            FirebaseAuth.getInstance().signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                @Override
//                public void onSuccess(AuthResult authResult) {
//                    String phone = authResult.getUser().getEmail();
//                    Toast.makeText(Login.this, phone, Toast.LENGTH_SHORT).show();
//                }
//            })
//            .addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            });

        } else {

            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case GOOGLE_REQ_CODE: {
                GoogleSignInResult signInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                handleGoogleResult(signInResult);
            }
        }
    }

    public void logOutGoogle(final Activity activity, GoogleApiClient mGoogleApiClient) {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // ...
                        if (status.isSuccess()) {
                            //Log.d(Constants.TAG, "Logged Out Google");
                            //Toast.makeText(activity, "Logged Out", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void registerUser(final String name, final String email, final String phone) {
        Utils.getInstance().setLoggedIn(true);
        Utils.getInstance().setEmail(email);
        Utils.getInstance().setName(name);
//        Utils.getInstance().setPhoto(signInAccount.getPhotoUrl().toString());
        String url = "https://httpsgauravhuria08wixsitecomvaigau1208.000webhostapp.com/register.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("RESPONSE", response);
//                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                        try {
                            User user = Utils.getInstance().getGson().fromJson(response, User.class);
                            if(!user.exists()&&user.isRegistered()){
                                Toast.makeText(Login.this, "Thank you for joining us!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (RuntimeException e) {
                            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(Login.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("phone", phone);
                return params;
            }
        };
        stringRequest.setShouldCache(false);
        Utils.getInstance().addRequest(stringRequest);
    }
}
