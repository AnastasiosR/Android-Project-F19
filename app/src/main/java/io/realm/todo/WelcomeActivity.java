/*
 * Copyright 2018 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.todo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import io.realm.ObjectServerError;
import io.realm.SyncCredentials;
import io.realm.SyncUser;
import io.realm.annotations.PrimaryKey;

import static io.realm.todo.Constants.AUTH_URL;

public class WelcomeActivity extends AppCompatActivity {

    private EditText usernameView;
    private EditText passwordView;
    private View progressView;
    private View loginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //If user has already logged in , skip the welcome page(sign in/sign up)
        //and go to item list
//        if (SyncUser.current() != null)
//        {
//            gotoListActivity();
//        }




        // Set up the login form.
        usernameView = findViewById(R.id.username);
        passwordView = findViewById(R.id.password);
        Button signInButton = findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(view -> attemptLogin(false));
        Button signUpButton = findViewById(R.id.sign_up_button);
        signUpButton.setOnClickListener(view -> attemptLogin(true));
        loginFormView = findViewById(R.id.login_form);
        progressView = findViewById(R.id.login_progress);
        setTitle("F19 Android Project(6208)");
    }


    private void attemptLogin(boolean createUser) {
        // Reset errors.
        usernameView.setError(null);
        // Store values at the time of the login attempt.
        String username = usernameView.getText().toString();
        String password = passwordView.getText().toString();
        showProgress(true);

        SyncCredentials credentials = SyncCredentials.usernamePassword(username, password, createUser);
        SyncUser.logInAsync(credentials, AUTH_URL, new SyncUser.Callback<SyncUser>() {
            @Override
            public void onSuccess(SyncUser user) {
                showProgress(false);
                gotoListActivity();
            }

            @Override
            public void onError(ObjectServerError error) {
                showProgress(false);
                usernameView.setError("Error->)"+ error);
                usernameView.requestFocus();
                Log.e("Login error", error.toString());
            }
        });
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        loginFormView.animate().setDuration(shortAnimTime).alpha(
                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });
        progressView.setVisibility(show ? View.VISIBLE : View.GONE);
        progressView.animate().setDuration(shortAnimTime).alpha(
                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }

    private void gotoListActivity() {
        Intent intent = new Intent(WelcomeActivity.this, ItemListActivity.class);
        intent.putExtra(ItemListActivity.INTENT_EXTRA_PROJECT_URL, Constants.REALM_URL + "/~/project");
        startActivity(intent);
    }
}

